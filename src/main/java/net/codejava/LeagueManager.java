package net.codejava;

import java.io.IOException;
import java.util.List;

public interface LeagueManager {
    //Methods for implement premier league manager class
    void addFootballClub(FootballClub sports);//Adding method

    void deleteFootballClub(String clubName);//Delete method

    void displayStatistics();//Display statistics

    void premierLeagueTable();//Display premier league

    void addPlayedMatch();//Add played match

    void saveFile(String file) throws IOException;//Save to the file

    void getData(String file) throws IOException, ClassNotFoundException;//Retrieve data from the text file

    List<FootballClub> randomMatch();//Create a random Match method for random classes with clubs and goal score


}
