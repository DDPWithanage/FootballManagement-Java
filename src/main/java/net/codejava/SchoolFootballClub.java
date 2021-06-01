package net.codejava;

import java.util.Objects;

public class SchoolFootballClub extends  FootballClub{
    //Identify the attributes
    String schoolName;
    String schoolEmail;

    //Parameterized Constructor
    public SchoolFootballClub(String clubName, String clubLocation, String homeTeamName, String guestTeamName, int wins, int draws, int defeats, int goalsReceived, int goalsScored, int currentPoints, int playedMatches, Date date, String schoolName, String schoolEmail) {
        super(clubName,clubLocation,homeTeamName,guestTeamName,wins,draws,defeats,goalsReceived,goalsScored,currentPoints,playedMatches,date);
        this.schoolName = schoolName;
        this.schoolEmail = schoolEmail;
    }

    //Adding getters and setters
    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolName() {
        this.schoolName = schoolName;
    }

    public void setSchoolEmail() {
        this.schoolEmail = schoolEmail;
    }

    //Equal method to equal attributes with new objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        SchoolFootballClub uni = (SchoolFootballClub) obj;
        return Objects.equals(schoolName, uni.schoolName) &&
                Objects.equals(schoolEmail, uni.schoolEmail);
    }

    //Hashcode method
    @Override
    public int hashCode() {
        return Objects.hash(schoolName, schoolEmail);
    }

    //toString method
    @Override
    public String toString() {
        return "School Football Club{" +
                "School Name='" + schoolName + '\'' +
                "School Email='" + schoolEmail + '\'' +
                '}';
    }
}
