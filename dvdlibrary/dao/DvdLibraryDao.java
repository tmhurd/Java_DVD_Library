/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

/**
 *
 * @author Terri
 */
public interface DvdLibraryDao {
    
    DVD addDVD(String title, DVD dvd) throws DvdLibraryDaoException;
    
    DVD removeDVD(String title) throws DvdLibraryDaoException;
    
    DVD editDVD(String title, DVD dvd) throws DvdLibraryDaoException;
    
    List<DVD> getAllDVDs() throws DvdLibraryDaoException;
    
    DVD getDVD(String title) throws DvdLibraryDaoException;
    
    List<DVD> getRating(String rating) throws DvdLibraryDaoException; 
    
    List<DVD> getDVDSWithinRange(int numberYears) throws DvdLibraryDaoException;
    
    DVD getNewestMovies() throws DvdLibraryDaoException;
    
    DVD getOldestMovies() throws DvdLibraryDaoException;
    
    double getAverageDvdAge() throws DvdLibraryDaoException;
    
    Map<String, List<DVD>> getDVDbyDirectorGroupByRating(String director) throws DvdLibraryDaoException;
    
    List<DVD> getStudio(String studio) throws DvdLibraryDaoException;
}
