package com.crawler;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Andy on 06/01/2017.
 */
public class SitemapOutput {

    public static void outputToFile(String fileName, List<String> sitemap) {

        try(FileOutputStream fos = new FileOutputStream(fileName, false);
            DataOutputStream dos = new DataOutputStream(fos)) {
                dos.writeBytes("");
        } catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try(FileOutputStream fos = new FileOutputStream(fileName, true);
            DataOutputStream dos = new DataOutputStream(fos)) {

            for(String page : sitemap) {
                dos.writeBytes(page);
            }
        } catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
