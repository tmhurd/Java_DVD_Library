/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 *
 * @author Terri
 */
public class DVD {
    private String title;
    private String releaseDate;
    private String rating;
    private String director;
    private String studio;
    private String userNotes;

    public int getDvdAge() {
      String releaseDate = getReleaseDate();
       int dateDVD = Integer.parseInt(releaseDate);
        int now = LocalDate.now().getYear();
        
        int age = now - dateDVD;
        return age;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
    
    public int getReleaseDateInt() {
        String releaseDate = getReleaseDate();
        int releaseDateInt = Integer.parseInt(releaseDate);
        return releaseDateInt;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.title);
        hash = 83 * hash + Objects.hashCode(this.releaseDate);
        hash = 83 * hash + Objects.hashCode(this.rating);
        hash = 83 * hash + Objects.hashCode(this.director);
        hash = 83 * hash + Objects.hashCode(this.studio);
        hash = 83 * hash + Objects.hashCode(this.userNotes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.userNotes, other.userNotes)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Title: " + title + " |Release Date: " + releaseDate + "|Director: " + director;
    }
    
   
}
