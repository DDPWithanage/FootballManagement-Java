package net.codejava;

import java.util.Comparator;
import java.util.Objects;

public class FootballClub extends SportsClub implements Comparator<FootballClub> {
    //Identify the attributes
    private String homeTeamName;
    private String guestTeamName;
    private int wins;
    private int draws;
    private int defeats;
    private int goalsReceived;
    private int goalsScored;
    private int currentPoints;
    private int playedMatches;
    private Date date;

    //Parameterized Constructor
    public FootballClub(String clubName, String clubLocation, String homeTeamName, String guestTeamName, int wins, int draws, int defeats, int goalsReceived, int goalsScored, int currentPoints, int playedMatches, Date date) {
        super(clubName, clubLocation);
        this.homeTeamName = homeTeamName;
        this.guestTeamName = guestTeamName;
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.goalsReceived = goalsReceived;
        this.goalsScored = goalsScored;
        this.currentPoints = currentPoints;
        this.playedMatches = playedMatches;
        this.date = date;
    }

    public FootballClub(String clubName, String clubLocation, String homeTeamName, String guestTeamName, int wins, int draws, int defeats, int goalsReceived, int goalsScored, int currentPoints, int playedMatches) {
    }


    //Adding getters
    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getGuestTeamName() {
        return guestTeamName;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public int getPlayedMatches() {
        return playedMatches;
    }

    public Date getDate() {
        return date;
    }

    //Adding setters
    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public void setGuestTeamName(String guestTeamName) {
        this.guestTeamName = guestTeamName;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public void setPlayedMatches(int playedMatches) {
        this.playedMatches = playedMatches;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //Equal method to equal attributes with new objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return wins == that.wins &&
                draws == that.draws &&
                defeats == that.defeats &&
                goalsReceived == that.goalsReceived &&
                goalsScored == that.goalsScored &&
                currentPoints == that.currentPoints &&
                playedMatches == that.playedMatches &&
                Objects.equals(homeTeamName, that.homeTeamName) &&
                Objects.equals(guestTeamName, that.guestTeamName) &&
                Objects.equals(date, that.date);
    }

    //Hashcode Method
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), homeTeamName, guestTeamName, wins, draws, defeats, goalsReceived, goalsScored, currentPoints, playedMatches, date);
    }

    //Default Constructor
    public FootballClub() {
    }

    //Compare method used for sorting
    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        return 0;
    }

    //toString method
    @Override
    public String toString() {
        return "FootballClub{" +
                super.toString() +
                "homeTeamName='" + homeTeamName + '\'' +
                ", guestTeamName='" + guestTeamName + '\'' +
                ", wins=" + wins +
                ", draws=" + draws +
                ", defeats=" + defeats +
                ", goalsReceived=" + goalsReceived +
                ", goalsScored=" + goalsScored +
                ", currentPoints=" + currentPoints +
                ", playedMatches=" + playedMatches +
                ", date=" + date +
                '}';
    }
}

