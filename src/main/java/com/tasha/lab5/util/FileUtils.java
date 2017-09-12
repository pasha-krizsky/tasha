package com.tasha.lab5.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class FileUtils {

    public static String readLineFromFile(String path) {

        try (InputStream fis = new FileInputStream(path)) {

            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            return br.readLine();

        } catch (Exception e) {
            System.out.println("Cannot read line from file");
            e.printStackTrace();
        }

        return null;
    }

    public static String readAllLines(String path) {

        try (InputStream fis = new FileInputStream(path)) {

            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();

        } catch (Exception e) {
            System.out.println("Cannot read line from file");
            e.printStackTrace();
        }

        return null;
    }
}
