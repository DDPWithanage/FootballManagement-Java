package net.codejava;

import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {
    //Identify the attributes
    private String clubName;
    private String clubLocation;

    //Parameterized Constructor
    public SportsClub(String clubName, String clubLocation) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
    }

    //Default Constructor
    public SportsClub() {

    }

    public SportsClub(String clubName) {
        this.clubName = clubName;
    }

    //Adding getters and setters
    public String getClubName() {
        return clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }


    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    //Equal method to equal attributes with new objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        SportsClub uni = (SportsClub) obj;
        return Objects.equals(clubName, uni.clubName) &&
                Objects.equals(clubLocation, uni.clubLocation);

    }

    //Hashcode method
    @Override
    public int hashCode() {
        return Objects.hash(clubName, clubLocation);
    }

    //Compareto method for sorting points


    //toString method
    @Override
    public String toString() {
        return "Sports Club{" +
                "Club Name='" + clubName + '\'' +
                ", Club Location='" + clubLocation + '\'' +
                '}';
    }

}
