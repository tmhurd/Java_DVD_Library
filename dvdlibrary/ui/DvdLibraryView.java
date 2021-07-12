/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Terri
 */
public class DvdLibraryView {

    private UserIO io;

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD to Collection");
        io.print("2. Remove DVD from Collection");
        io.print("3. Edit existing DVD");
        io.print("4. List all DVDs in Collection");
        io.print("5. Search for a DVD by Title");
        io.print("6. Find DVDs with specific ratings");
        io.print("7. Find DVDs released within a certain number of years");
        io.print("8. Find newest movie");
        io.print("9. Find average DVD age");
        io.print("10. Find oldest movie");
        io.print("11. Find DVDs by director");
        io.print("12. Find DVDs by studio");
        io.print("13. Exit");

        return io.readInt("Please select from the above choices.", 1, 13);
    }
    
    public int getNumberOfYears() {
        int yourYear = io.readInt("How far back do you want to go?  Enter the number of years.");
        return yourYear;
    }
    
    public void printMap(Map<String, List<DVD>> map) {
       Set<String> rating = map.keySet();
       rating.stream()
               .forEach(letter -> {  io.print("***************************");
                                     io.print("*RATING: " + letter + "*");
                                     map.get(letter).stream().forEach(d -> io.print(d.getTitle()));
                                     
                                  });
    }
    
    public void printMessage(String message) {
        io.print(message);
        io.print(" ");
    }

   
    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter the DVD title."); 
        String releaseDate = io.readString("Please enter the DVD release date in the following format:  MM/DD/YYYY");
        String rating = io.readString("Please enter the DVD rating");
        String director = io.readString("Please enter the director");
        String studio = io.readString("Please enter the production studio");       
        String userNotes = io.readString("Please enter any additional notes about the DVD");
        
               
        DVD currentDVD = new DVD();
        currentDVD.setTitle(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setRating(rating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserNotes(userNotes);
        
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.print("");
        io.readString2("DVD successfully created.");
        io.print("");
        io.readString2("What would you like to do next? Press enter.");
        
    }

    public String getDVDTitle() {
        return io.readString("Please enter the DVD title without any spaces.  Hyphens can be used between words.");
    }

    public String getDVDReleaseDate() {
        return io.readString("Please enter the release date");
    }

    public String getRating() {
        return io.readString("Please enter the rating");
    }

    public String getDirector() {
        return io.readString("Please enter the director's name");
    }

    public String getStudio() {
        return io.readString("Please enter the production studio");
    }

    public String getUserNotes() {
        return io.readString("Please enter any additional notes");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString2("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayEditBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditSuccessBanner() {
        io.readString2("DVD successfully edited. Please hit enter to continue.");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.print(currentDVD.getTitle());
        }
        io.readString2("Please hit enter to continue.");
        io.readString2("");
    }

    public void displayListBanner() {
        io.print("=== List of DVDs ===");
    }

    public void displayDVDBanner() {
        io.print("=== DVD Info ===");
    }

    public void displayDvdInfo(DVD dvd) {
      
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(LocalDate.parse(dvd.getReleaseDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy")) + ", " + dvd.getRating() + ", " 
                    + dvd.getDirector() + ", " + dvd.getStudio() + ", " 
                    + dvd.getUserNotes());           
            io.print("");
        } else {
            io.print("No such dvd.");
        }
        io.readString2("Please hit enter to continue.");
        io.readString2("");
    }
    
    public void displayOneDVD(DVD dvd) {                       //NEW
        io.print(dvd.getTitle() + ", " + dvd.getReleaseDate());
        io.readString2("Please hit enter to continue.");
        io.readString2("");
    }
    
     public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public DvdLibraryView(UserIO io) {
    this.io = io;
}
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);
    }

}
