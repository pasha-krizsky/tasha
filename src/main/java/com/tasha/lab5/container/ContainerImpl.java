package com.tasha.lab5.container;

import com.google.gson.JsonObject;
import com.tasha.lab5.data.Element;
import com.tasha.lab5.util.JSONUtils;
import lombok.Getter;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/** Concrete implementation of Container */
public class ContainerImpl implements IContainer {

    /** Deque to store Elements */
    @Getter
    private Deque<Element> deque = new ArrayDeque<>();

    @Override
    public void importData(String path) {

        try {

            InputStream is = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;

            while ((line = br.readLine()) != null) {
                JsonObject lineJSON = JSONUtils.createJSONFromString(line);
                Element element = new Element(lineJSON);
                deque.add(element);
            }

            br.close();
            isr.close();
            is.close();

        } catch (IOException e) {

            System.out.println("Cannot import data from file");
            e.printStackTrace();
        }

    }

    @Override
    public void saveData(String path) {

        try(PrintWriter pw = new PrintWriter(new File(path))) {

            for (Element element: deque) {
                pw.println(element.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot write to file");
            e.printStackTrace();
        }
    }

    @Override
    public void removeFirst() {
        if (deque.size() > 0) {
            deque.removeFirst();
        } else {
            throw new RuntimeException("The container is empty");
        }
    }

    @Override
    public void removeGreater(Element element) {
        if (deque.size() > 0) {
            deque.removeIf((Element e) ->  element.compareTo(e) < 0);
        } else {
            throw new RuntimeException("The container is empty");
        }
    }
}
