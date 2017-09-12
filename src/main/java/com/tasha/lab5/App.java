package com.tasha.lab5;

import com.google.gson.JsonObject;
import com.tasha.lab5.container.ContainerImpl;
import com.tasha.lab5.data.Element;
import com.tasha.lab5.container.IContainer;
import com.tasha.lab5.util.JSONUtils;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        IContainer container = new ContainerImpl();

//        String javaHome = System.getenv("FILE");
//        container.importData(javaHome);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            public void run() {
                container.saveData("/home/pasha/IdeaProjects/tasha/lab4/src/main/resources/output1.json");
            }
        }));

        while (true) {
            String line = in.nextLine();
            String command = line.split(" ")[0];
            String path;

            switch (command) {
                case "import":
                    path = line.split(" ")[1];
                    container.importData(path);
                    break;
                case "save":
                    path = line.split(" ")[1];
                    container.saveData(path);
                    break;
                case "remove_first":
                    container.removeFirst();
                    break;
                case "remove_greater":
                    String elementString = line.split(" ")[1];
                    JsonObject elementJSON = JSONUtils.createJSONFromString(elementString);
                    Element element = new Element(elementJSON);
                    container.removeGreater(element);
                    break;
            }
        }
    }
}
