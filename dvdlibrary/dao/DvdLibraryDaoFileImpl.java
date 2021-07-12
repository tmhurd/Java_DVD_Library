/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Terri
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    
    private DvdLibraryAuditDao auditDao;

    public DvdLibraryDaoFileImpl(DvdLibraryAuditDao auditDao) {
        this.auditDao = auditDao;
    }
    

    private Map<String, DVD> allDVDs = new HashMap<>();

    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVD addDVD(String title, DVD dvd) throws DvdLibraryDaoException {
        DVD newDVD = allDVDs.put(title, dvd);
        writeDVDFile();
        DVD addedDVD = newDVD;
       // auditDao.writeAuditEntry("Dvd " + dvd.getTitle() + " CREATED");
        return addedDVD;
    }

    @Override
    public DVD removeDVD(String title) throws DvdLibraryDaoException {
        DVD removedDVD = allDVDs.remove(title);
        writeDVDFile();
        DVD deletedDVD = removedDVD;
       // auditDao.writeAuditEntry("Dvd " + title + " REMOVED");
        return deletedDVD;
    }

    @Override
    public DVD editDVD(String title, DVD dvd) throws DvdLibraryDaoException {
        DVD editDVD = allDVDs.put(title, dvd);
        writeDVDFile();
        DVD editedDVD = editDVD;
       // auditDao.writeAuditEntry("Dvd " + dvd.getTitle() + " EDITED");
        return editedDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DvdLibraryDaoException {
        loadDVDFile();
        return new ArrayList<DVD>(allDVDs.values());
    }

    @Override
    public DVD getDVD(String title) throws DvdLibraryDaoException {
        loadDVDFile();
        return allDVDs.get(title);
    }
    
   @Override
    public List<DVD> getRating(String rating) throws DvdLibraryDaoException {
      
    return allDVDs.values()
                .stream()
                .filter(d -> d.getRating().equalsIgnoreCase(rating))
                .collect(Collectors.toList()); 
    } 
    
    @Override
    public List<DVD> getDVDSWithinRange(int numberYears) throws DvdLibraryDaoException {
       return allDVDs.values()
               .stream()
               .filter(d -> Integer.parseInt(d.getReleaseDate()) >= (2019 - numberYears))
               .collect(Collectors.toList());          
                
    }
    
    @Override
    public DVD getNewestMovies() throws DvdLibraryDaoException {
        Comparator<DVD> comparator = Comparator.comparing(DVD::getReleaseDateInt);
        
        return allDVDs.values()
               .stream()
               .max(comparator)
               .get();
                     
    }
    
    @Override
    public DVD getOldestMovies() throws DvdLibraryDaoException {
        Comparator<DVD> comparator = Comparator.comparing(DVD::getReleaseDateInt);
        
        return allDVDs.values()
                .stream()
                .min(comparator)
                .get();
    }
    
    @Override
    public double getAverageDvdAge() {
        return allDVDs.values()
                .stream()
                .mapToLong(d -> d.getDvdAge())
                .average()
                .getAsDouble();
                
                
    }
    
    @Override
    public Map<String, List<DVD>> getDVDbyDirectorGroupByRating(String director) throws DvdLibraryDaoException {
        return allDVDs.values()
                .stream()
                .filter(d -> d.getDirector().equals(director))
                .collect(Collectors.groupingBy(DVD::getRating));
                
    }
    
    @Override
     public List<DVD> getStudio(String studio) throws DvdLibraryDaoException {
      
     return allDVDs.values()
                .stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList()); 
    } 
    
   /* 
  public void getNewestMovies() throws DvdLibraryDaoException {
      
        List<DVD> allDVDs2 = getAllDVDs();
        Comparator<DVD> comp = (d1, d2) -> Integer.compare(Integer.parseInt(d1.getReleaseDate()), Integer.parseInt(d2.getReleaseDate()));
        
               allDVDs.values()
               .stream()
               .max(comp)
               .get();  
*/
    private void loadDVDFile() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException("-_- Could not load dvd data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            DVD currentDVD = new DVD();
            currentDVD.setTitle(currentTokens[0]);
            currentDVD.setReleaseDate(currentTokens[1]);
            currentDVD.setRating(currentTokens[2]);
            currentDVD.setDirector(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            currentDVD.setUserNotes(currentTokens[5]);

            allDVDs.put(currentDVD.getTitle(), currentDVD);

        }

        scanner.close();
    }

    private void writeDVDFile() throws DvdLibraryDaoException {
       
        
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException("Could not save DVD data.", e);
        }

        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
           
            out.println(currentDVD.getTitle() + DELIMITER + currentDVD.getReleaseDate()
                    + DELIMITER + currentDVD.getRating() + DELIMITER + currentDVD.getDirector()
                    + DELIMITER + currentDVD.getStudio() + DELIMITER + currentDVD.getUserNotes());

            out.flush();
        }
        out.close();

    }
    
    
}
