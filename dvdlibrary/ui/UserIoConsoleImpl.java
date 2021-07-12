/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Terri
 */
public class UserIoConsoleImpl implements UserIO {

    Scanner userInput = new Scanner(System.in);

    private double yourDouble;
    private float yourFloat;
    private int yourInt;
    private long yourLong;
    private String yourString;
    private String yourDate;

    public String getYourDate() {
        return yourDate;
    }

    public void setYourDate(String yourDate) {
        this.yourDate = yourDate;
    }

    public String getYourString() {
        return yourString;
    }

    public void setYourString(String yourString) {
        this.yourString = yourString;
    }

    public int getYourInt() {
        return yourInt;
    }

    public void setYourInt(int yourInt) {
        this.yourInt = yourInt;
    }

    public long getYourLong() {
        return yourLong;
    }

    public void setYourLong(long yourLong) {
        this.yourLong = yourLong;
    }

    public double getYourDouble() {
        return yourDouble;
    }

    public void setYourDouble(double yourDouble) {
        this.yourDouble = yourDouble;
    }

    public Scanner getUserInput() {
        return userInput;
    }

    public void setUserInput(Scanner userInput) {
        this.userInput = userInput;
    }

    public float getYourFloat() {
        return yourFloat;
    }

    public void setYourFloat(float yourFloat) {
        this.yourFloat = yourFloat;
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        yourDouble = userInput.nextDouble();
        return (yourDouble);
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);

        yourDouble = userInput.nextDouble();

        while (yourDouble < min || yourDouble > max) {
            System.out.println(prompt);
            yourDouble = userInput.nextDouble();
        }

        if (yourDouble >= min || yourDouble <= max) {

        }
        return yourDouble;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        yourFloat = userInput.nextFloat();
        return (yourFloat);
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);

        yourFloat = userInput.nextFloat();

        while (yourFloat < min || yourFloat > max) {
            System.out.println(prompt);
            yourFloat = userInput.nextFloat();
        }

        if (yourFloat >= min || yourFloat <= max) {

        }
        return yourFloat;
    }

    @Override
    public int readInt(String prompt) {
        int yourInt = 0;
        System.out.println(prompt);
        String yourString = userInput.nextLine();
        yourInt = Integer.valueOf(yourString);
        return yourInt;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        
        int yourInt = 0;
        
        String yourString = userInput.nextLine();
        
        yourInt = Integer.valueOf(yourString);
                
               

        while (yourInt < min || yourInt > max) {
            System.out.println(prompt);
            yourString = userInput.nextLine();
            yourInt = Integer.valueOf(yourString);
        }

        if (yourInt >= min || yourInt <= max) {

        }
        return (yourInt);
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        yourLong = userInput.nextLong();
        return (yourLong);
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);

        yourLong = userInput.nextLong();

        while (yourLong < min || yourLong > max) {
            System.out.println(prompt);
            yourLong = userInput.nextLong();
        }

        if (yourLong >= min || yourLong <= max) {

        }
        return yourLong;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        yourString = userInput.nextLine();
        return (yourString);
    }
    
    @Override
    public String readString2(String prompt) {
        System.out.println(prompt);
        yourString = userInput.nextLine();
        return (yourString);
    }

    @Override
    public LocalDate readDate(String prompt) {
       LocalDate ld = null;
        
       System.out.println(prompt);
       yourDate=userInput.nextLine();
       
       return ld.parse(yourDate);
    }
    
    
    
}
