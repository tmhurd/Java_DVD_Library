/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DvdLibraryView;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

/**
 *
 * @author Terri
 */
public class DvdLibraryController {

    DvdLibraryDao dao;
    DvdLibraryView view;

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        
        
        try {
            
        listDVDsPrivate();
        
        while (keepGoing) {
            menuSelection = getMenuSelection();
            

            switch (menuSelection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    listDVDs();
                    break;
                case 5:
                    displayDVD();
                    break;
                case 6:
                    listDVDsWithRating();
                    break;
                case 7:
                    listDVDsWithinRange();
                    break;
                case 8:
                    listNewest();
                    break;
                case 9:
                    listAverageDvdAge();
                    break;
                case 10:
                    listOldest();
                    break;
                case 11:
                    listDVDsByDirectorRating();
                    break;
                case 12:
                    listDVDsByStudio();
                    break;
                case 13:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
        }catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void listAverageDvdAge() throws DvdLibraryDaoException {
        double age = dao.getAverageDvdAge();
        view.printMessage("The average age of the DVDs in your collection is: " + age + " years.");
    }
    
    private void listNewest() throws DvdLibraryDaoException{
        DVD dvd = dao.getNewestMovies();
        view.displayOneDVD(dvd);
    }
    
    private void listOldest() throws DvdLibraryDaoException {
        DVD dvd = dao.getOldestMovies();
        view.displayOneDVD(dvd); 
    }
    
    private void listDVDsWithinRange() throws DvdLibraryDaoException {
        List<DVD> dvdList = dao.getDVDSWithinRange(view.getNumberOfYears());
        view.displayDVDList(dvdList);
    }
    
   private void listDVDsWithRating() throws DvdLibraryDaoException {
        List<DVD> dvdList = dao.getRating(view.getRating());
        view.displayDVDList(dvdList);
    } 
   
   private void listDVDsByStudio() throws DvdLibraryDaoException {
        List<DVD> dvdList = dao.getStudio(view.getStudio());
        view.displayDVDList(dvdList);
    } 
   
   private void listDVDsByDirectorRating() throws DvdLibraryDaoException {
       Map<String, List<DVD>> map = dao.getDVDbyDirectorGroupByRating(view.getDirector());
       view.printMap(map); 
   }

    private void createDVD() throws DvdLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void removeDVD() throws DvdLibraryDaoException {
        view.displayRemoveDVDBanner();
        String DVDTitle = view.getDVDTitle();
        dao.removeDVD(DVDTitle);
        view.displayRemoveSuccessBanner();
    }

    private void editDVD() throws DvdLibraryDaoException {
        view.displayEditBanner();
        DVD editDVD = view.getNewDVDInfo();
        dao.addDVD(editDVD.getTitle(), editDVD);
        view.displayEditSuccessBanner();
    }

    private void listDVDs() throws DvdLibraryDaoException {
        view.displayListBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }
    
    private void listDVDsPrivate() throws DvdLibraryDaoException {
        List<DVD> dvdList = dao.getAllDVDs();
    }

    private void displayDVD() throws DvdLibraryDaoException {
        view.displayDVDBanner();
        String title = view.getDVDTitle();
        DVD dvd = dao.getDVD(title);
        view.displayDvdInfo(dvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
}
