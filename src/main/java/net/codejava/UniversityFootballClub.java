package net.codejava;

import java.util.Objects;

public class UniversityFootballClub extends  FootballClub{
    //Identify the attributes
    String uniName;
    String uniAddress;
    String uniEmail;


    //Parameterized Constructor
    public UniversityFootballClub(String clubName, String clubLocation, String homeTeamName, String guestTeamName, int wins, int draws, int defeats, int goalsReceived, int goalsScored, int currentPoints, int playedMatches, Date date, String uniName, String uniAddress, String uniEmail) {
        super(clubName,clubLocation,homeTeamName,guestTeamName,wins,draws,defeats,goalsReceived,goalsScored,currentPoints,playedMatches,date);
        this.uniName = uniName;
        this.uniAddress = uniAddress;
        this.uniEmail = uniEmail;
    }

    //Adding getters and setters
    public String getUniName() {
        return uniName;
    }

    public String getUniAddress() {
        return uniAddress;
    }

    public String getUniEmail() {
        return uniEmail;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public void setUniAddress(String uniAddress) {
        this.uniAddress = uniAddress;
    }

    public void setUniEmail(String uniEmail) {
        this.uniEmail = uniEmail;
    }

    //Equal method to equal attributes with new objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        UniversityFootballClub uni = (UniversityFootballClub) obj;
        return Objects.equals(uniName, uni.uniName) &&
                Objects.equals(uniAddress, uni.uniAddress) &&
                Objects.equals(uniEmail, uni.uniEmail);
    }

    //Hashcode method
    @Override
    public int hashCode() {
        return Objects.hash(uniName, uniAddress, uniEmail);
    }

    //toString method
    @Override
    public String toString() {
        return "University Football Club{" +
                "Uni Name='" + uniName + '\'' +
                ", Uni Email='" + uniEmail + '\'' +
                ", Uni Address='" + uniAddress + '\'' +
                '}';
    }

}
