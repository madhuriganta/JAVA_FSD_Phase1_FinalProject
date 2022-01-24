package com.locked_me;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
    static final String projectFilesPath="C:\\Source\\javaFS\\LockedMeFiles";
    static  String errorMessage="Some problem occurred, please contact: admin@LockedMe.com";

    public static void main(String[] args) {

      searchFile ();
    }
    public  static void displayMenu()
    {
        int choice=5;
        System.out.println ("====================================================================================================================");
        System.out.println ("\t\t\t\t\t\t\t\t\tWelcome to LockedMe.com ");
        System.out.println ("\t\t\t\t\t\t\t\tApplication Name: LockedMe.com");
        System.out.println ("\t\t\t\t\t\t\t\t\tDeveloped by: Madhuri Ganta");
        System.out.println ("====================================================================================================================");
        System.out.println ("\t\t\t1. Display All the Files");
        System.out.println ("\t\t\t2. Add a new  File");
        System.out.println ("\t\t\t3. Delete a File");
        System.out.println ("\t\t\t4. Search a File");
        System.out.println ("\t\t\t5. Exit");

        switch(choice)
        {
            case 1: getAllFiles();
            break;
            case 2: addAFile();
            break;
            case 3: deleteFile();
            break;
            case 4: searchFile();
            break;
            case 5: exit();
            break;
            default:
                System.out.println ("default message");
        }
    }
    /**
     * This function is for to get all files in directory
     */
    public static void getAllFiles()
    {
        try
        {
            File folder = new File(projectFilesPath);
            File[] listOfFiles = folder.listFiles();
            if(listOfFiles.length==0)
            {
                System.out.println ("No Files exist in the directory");
            }
            else
            {
                for (var file : listOfFiles)
                {
                    System.out.println(file.getName());
                }

            }
        }
        catch(Exception ex)
        {
            System.out.println (errorMessage);
        }

    }
    public static void addAFile()
    {

    }

    /**
     * This method will delete based on provided file name
     */
    public static void deleteFile()
    {
        String fileName;
        Scanner obj=new Scanner (System.in);
        System.out.println ("Enter File name to be delete: ");
        fileName = obj.nextLine ();
        File file = new File(projectFilesPath+"\\"+fileName);
        try {

            if (file.exists ()) {
                file.delete ();
                System.out.println (fileName+" is deleted successfully!");
            }
            else
                System.out.println ("File do not exist");

        }
        catch (Exception ex)
        {
            System.out.println (errorMessage);
        }
        finally
        {
            obj.close ();
        }


    }

    /**
     *
     */
    public static void searchFile()
    {
        Scanner obj=new Scanner (System.in);
        try {
            String fileName;
            File folder = new File (projectFilesPath);
            File[] listOfFiles = folder.listFiles ();
            LinkedList<String> fileNames= new LinkedList<String> ();

            for(var file: listOfFiles)
                fileNames.add(file.getName ());
            System.out.println ("List of files in the folder: "+ fileNames);
            System.out.println ("Enter the File name to be search: ");
            fileName = obj.nextLine ();
            if(fileNames.contains (fileName))
            {
                System.out.println ("File is available: "+ fileName);
            }
            else
                System.out.println ("File is not available");


//            if(Arrays.stream(listOfFiles).anyMatch (f -> f.getName ().equals (fileName)))
//                System.out.println ("File is available: "+ fileName);
//            else
//                System.out.println ("File is not available");


        }
        catch(Exception ex)
        {
            System.out.println (errorMessage);
        }
        finally {
            obj.close();
        }

    }
    private static void exit() {
    }
}
