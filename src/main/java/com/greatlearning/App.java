package com.greatlearning;

import com.greatlearning.helpers.FileWriterHelper;

import java.util.Scanner;

/**
 * Class reader app
 */
public class App {
    public static void main(String[] args) {
        int selectedOption;
        String className;
        Class<?> c;

        do {
            Scanner scan = new Scanner(System.in);

            System.out.println("------------------------------------------");
            System.out.println("Please enter the class name");
            className = scan.next();
            c = validateClass(className);

            selectedOption = getSelectedOption(c);

        } while (selectedOption > 0);

    }


    /**
     * display menu for reading class information
     * @param c
     * @return
     */
    private static int getSelectedOption(Class<?> c) {
        Scanner scan = new Scanner(System.in);
        ClassReader classReader = new ClassReader();
        int selectedOption;
        String result;
        System.out.println("Select the menu option");
        System.out.println("1. Methods");
        System.out.println("2. Class");
        System.out.println("3. Subclasses");
        System.out.println("4. Parent classes");
        System.out.println("5. Constructors");
        System.out.println("6. Data Members");
        System.out.println("------------------------------------------");

        selectedOption = scan.nextInt();

        switch (selectedOption) {
            case 1:
                result = classReader.getMethods(c);
                if (getConfirmation()) {
                    getSelectedOption(c);
                } else {
                    getFileMenu(result);
                }
                break;
            case 2:
                result = classReader.getClassName(c);
                if (getConfirmation()) {
                    getSelectedOption(c);
                } else {
                    getFileMenu(result);
                }
                break;
            case 3:
                result = classReader.getSubClass(c);
                if (getConfirmation()) {
                    getSelectedOption(c);
                } else {
                    getFileMenu(result);
                }

                break;
            case 4:
                result = classReader.getParentClass(c);
                if (getConfirmation()) {
                    getSelectedOption(c);
                } else {
                    getFileMenu(result);
                }
                break;

            case 5:
                result = classReader.getConstructors(c);
                if (getConfirmation()) {
                    getSelectedOption(c);
                } else {
                    getFileMenu(result);
                }
                break;

            case 6:
                result = classReader.getDataMembers(c);
                if (getConfirmation()) {
                    getSelectedOption(c);
                } else {
                    getFileMenu(result);
                }
                break;


            default:
                System.out.println("Please select the correct option");
                break;
        }
        return selectedOption;
    }

    /**
     * validates if package exists
     * @param className
     * @return
     */
    private static Class<?> validateClass(String className) {
        try {
            Class c = Class.forName(className);
            System.out.println("Provided class found." + "Package Name : " + c.getPackage().getName());
            return c;
        } catch (ClassNotFoundException e) {
            System.out.println("Provided class doesn't exists.");
            System.out.println("Exited successfully");
            System.exit(0);
        }
		return null;
    }

    /**
     * get confirmation from user
     * @return
     */
    private static boolean getConfirmation() {
        System.out.println("Do you want to see any other information?");
        System.out.println("press yes to recheck the menu and no if you want to continue");
        Scanner scan = new Scanner(System.in);
        String confirmation = scan.next();
        return confirmation.equalsIgnoreCase("yes");
    }

    /**
     * display menu for file operations
     * @param input
     */
    private static void getFileMenu(String input) {
        FileWriterHelper writerHelper = new FileWriterHelper();
        Scanner scan = new Scanner(System.in);
        System.out.println("Select the option");
        System.out.println("1. Store information into file");
        System.out.println("2. To see all previous file created");
        System.out.println("3. Exit without storing");
        int option;
        option = scan.nextInt();
        switch (option) {
            case 1:
                //writing info to file
                writerHelper.writeToFile(input);
                break;
            case 2:
                //reading file content
                writerHelper.readFileContent();
                break;
            case 3:
                System.out.println("Exited successfully");
                System.exit(0);
                break;
            default:
                System.out.println("Please select the correct option");

        }
    }
}
