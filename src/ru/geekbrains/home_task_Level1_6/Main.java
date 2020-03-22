package ru.geekbrains.home_task_Level1_6;

import java.io.*;


public class Main {

    private static void readAndWriteFile (String path, String fileInputName, String fileOutName, int flag) {
        try {
            FileInputStream fis = new FileInputStream(path + fileInputName);
            byte[] fileDataByte = fis.readAllBytes();
            fis.close();
            FileOutputStream fos;
            if (flag == 0) {
                fos = new FileOutputStream(path + fileOutName);
            }
               else {
                 fos = new FileOutputStream(path + fileOutName, true);
               }

               for (byte b : fileDataByte) {
                     fos.write(b);
               }
             fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int serchWordInFile (String path, String fileName, String serchWord) {
        int i, countSerch;
        countSerch = 0;
        char [] serchChars =  serchWord.toCharArray();

        try {
            FileInputStream fis = new FileInputStream(path + fileName);
            BufferedInputStream buffInputStream = new BufferedInputStream(fis);
            while ((i = buffInputStream.read()) != -1) {
                if (i == serchChars[0]) {
                    for (int x = 1; x < serchChars.length; x++) {
                        i = buffInputStream.read();
                        if (i != serchChars[x]) {x=serchChars.length;}
                        else {
                            if (x == serchChars.length-1) {countSerch ++;}
                        }
                    }
                }
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countSerch;
    }

    public static void main(String[] args) {
        String pathToFile = "//Users/pilot/Desktop/JAVA/lesson6/src/ru/geekbrains/home_task_level1_6/";
        String fileName1 = "Controller.txt";
        String fileName2 = "Controller2.txt";
        String fileNameResalt = "Resalt.txt";
        String serchinWord = "aircraft";

        readAndWriteFile(pathToFile, fileName1, fileNameResalt,0);
        readAndWriteFile(pathToFile, fileName2, fileNameResalt,1);
        System.out.println("В файле: " + fileName1 + " найдено " + serchWordInFile(pathToFile, fileName1, serchinWord) + " совпадений c словом " + serchinWord);



        File folder = new File(pathToFile);
        String [] b  = folder.list();
        assert b != null;    // ? Разобраться подробнее чем отличается от Exeption

        for (String s : b) {
            System.out.println(s);
        }





    }
}
