package com.springapp.services;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCreator {

    public void zip(File file, ZipOutputStream zos) {
        try {
            byte[] readBuffer = new byte[1024];
            int bytesIn = 0;
            FileInputStream fis = new FileInputStream(file);
            ZipEntry anEntry = new ZipEntry(file.getPath());
            zos.putNextEntry(anEntry);
            while((bytesIn = fis.read(readBuffer)) != -1) {
                zos.write(readBuffer, 0, bytesIn);
            }
            fis.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
