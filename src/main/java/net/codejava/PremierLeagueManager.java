package net.codejava;

import java.io.*;
import java.util.*;

public class PremierLeagueManager implements LeagueManager{
    //Create a array list for store all the data of football club
    public List<FootballClub> footballList = new ArrayList<>();

    //Create a array list for store all the data of football club while creating random matches
    public List<FootballClub> match = new ArrayList<>();

    //Add football club
    @Override
    public void addFootballClub(FootballClub sports) {
        //Maximum size is 20 clubs
        if (footballList.size() < 20) {
            footballList.add(sports);
            System.out.println("This club is successfully added to the premier league");

        } else {
            System.out.println("No free spaces available. Unable to add more clubs");
        }

        System.out.println("Number of football clubs that still be registered : " + footballList.size());
        System.out.println("Number of Free spaces available : " + (20 - footballList.size()));
    }

    //Delete a football club
    @Override
    public void deleteFootballClub(String clubName) {
        for (FootballClub sports : footballList) {
            //Declare whether user input club is equal to the club in array list
            if (sports.getClubName().equals(clubName)) {
                //remove the club from array list
                footballList.remove(sports);
                System.out.println(clubName + " is successfully deleted");

                System.out.println("Number of football clubs that still be registered : " + footballList.size());
                System.out.println("Number of Free spaces available : " + (20 - footballList.size()));
                return;
            }
        }
        System.out.println(clubName + " is Invalid club");
    }

    //Display the statistics of each club
    @Override
    public void displayStatistics() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your club name : ");
        String clubName = scanner.next();

        for (FootballClub sports : footballList) {
            //Assign values for below variables from array list
            if (sports.getClubName().equals(clubName)) {
                System.out.println(sports.getClubName() + " win matches : " + sports.getWins());
                System.out.println(sports.getClubName() + " defeat matches : " + sports.getDefeats());
                System.out.println(sports.getClubName() + " draw matches : " + sports.getDraws());
                System.out.println(sports.getClubName() + " scored goals : " + sports.getGoalsScored());
                System.out.println(sports.getClubName() + " received goals : " + sports.getGoalsReceived());
                System.out.println(sports.getClubName() + " current points : " + sports.getCurrentPoints());
                System.out.println(sports.getClubName() + " matches played : " + sports.getPlayedMatches());
                System.out.println(sports.getClubName() + " Date : " + sports.getDate());
                return;

            }
            if (footballList.size() == 0) {
                System.out.println("Empty List");
            }
        }
        System.out.println(clubName + " is Invalid club");
    }

    //Display Premier league table
    @Override
    public void premierLeagueTable() {
        //Sort the table according to the current points
        Collections.sort(footballList, new FootballPointsComparator());

        //Sort clubs in premier league according to the points and goal difference
        for (FootballClub sports : footballList) {
            int goalDiff = (sports.getGoalsScored() - sports.getGoalsReceived());
            System.out.println("Club name : " + sports.getClubName() + " => " + " Points : " + sports.getCurrentPoints() + " => " + " goal difference : " + goalDiff);
        }
    }

    //Add a played match with its score and date
    @Override
    public void addPlayedMatch() {
        Scanner scanner = new Scanner(System.in);

        //Date
        //Get date from the user
        FootballClub newDate = new FootballClub();
        System.out.println("Enter your Date.....");

        //Get day
        System.out.print("Enter your entry day : ");
        int day = scanner.nextInt();

        //Get month
        System.out.print("Enter your entry month : ");
        int month = scanner.nextInt();

        //Get year
        System.out.print("Enter your entry year : ");
        int year = scanner.nextInt();

        //Set above user inputs to the variables in Date class
        Date date = new Date(day, month, year);
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);

        newDate.setDate(date);
        System.out.println(date);

        //Home team - Get home team from the user
        System.out.print("Enter home team name : ");
        String homeName = scanner.next();
        FootballClub home = null;

        for (FootballClub sports : footballList) {
            if (sports.getClubName().equals(homeName)) {
                home = sports;
            }
        }

        //Guest team - Get guest team from the user
        System.out.print("Enter guest team name : ");
        String guestName = scanner.next();
        FootballClub guest = null;

        for (FootballClub sports : footballList) {
            if (sports.getClubName().equals(guestName)) {
                guest = sports;
            }
        }

        //Get home team goals - get home team goals from the user
        System.out.print("Enter home team goals : ");
        int homeGoals = scanner.nextInt();

        //Get guest team goals - get guest team goals from the user
        System.out.print("Enter guest team goals : ");
        int guestGoals = scanner.nextInt();

        //Set above information to the relevant variables in Football club class
        FootballClub club = new FootballClub();
        club.setGuestTeamName(guestName);
        club.setHomeTeamName(homeName);
        club.setGoalsScored(homeGoals);
        club.setGoalsScored(guestGoals);
        club.setGoalsReceived(homeGoals);
        club.setGoalsReceived(guestGoals);
        club.setPlayedMatches(homeGoals);
        club.setPlayedMatches(guestGoals);

        //Set other variables
        //Set teams
        assert home != null;
        home.setHomeTeamName(home.getHomeTeamName());
        assert guest != null;
        guest.setGuestTeamName(guest.getGuestTeamName());

        //Set scored Goals
        home.setGoalsScored(home.getGoalsScored() + homeGoals);
        guest.setGoalsScored(guest.getGoalsScored() + guestGoals);

        //Set received goals
        home.setGoalsReceived(home.getGoalsReceived() + guestGoals);
        guest.setGoalsReceived(guest.getGoalsReceived() + homeGoals);

        //Set played matches
        home.setPlayedMatches(home.getPlayedMatches() + 1);
        guest.setPlayedMatches(guest.getPlayedMatches() + 1);

        //Set draw count
        home.setDraws(home.getDraws());
        guest.setDraws(guest.getDraws());

        //Set Date to the clubs
        home.setDate(date);
        guest.setDate(date);

        //Set points, wins & defeats
        //Define whether home team goals are greater than guest goals and set appropriate values
        if (homeGoals > guestGoals) {
            home.setCurrentPoints(home.getCurrentPoints() + 3);
            home.setWins(home.getWins() + 1);
            guest.setDefeats(guest.getDefeats() + 1);

            //Define whether home team goals are less than guest goals and set appropriate values
        } else {
            guest.setCurrentPoints(guest.getCurrentPoints() + 3);
            guest.setWins(guest.getWins() + 1);
            home.setDefeats(home.getDefeats() + 1);
        }
        //Add above details to the match array
        match.add(club);
    }

    //Save a file
    @Override
    public void saveFile(String file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (FootballClub sports : footballList) {
            objectOutputStream.writeObject(sports);

        }

        System.out.println("Successfully saved");

        }


    //Retrieve data from the file
    @Override
    public void getData(String file) throws IOException, ClassNotFoundException{
         FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            //Infinite for loop
            for (; ; ) {
                try {
                    footballList.add((FootballClub) objectInputStream.readObject());

                } catch (EOFException exception) {
                    break;
                }
            }
            System.out.println("Successfully Add data");
    }

    @Override
    public List<FootballClub> randomMatch() {
        Random random = new Random();

        if (footballList.size() > 1) {
            //random home goals and guest goals
            //Get a index from football list array and assign it into the football size and then  generate random size of the football clubs
            int homeGoals = random.nextInt(30);
            int guestGoals = random.nextInt(30);
            int homeIndex = random.nextInt(footballList.size());
            int guestIndex = random.nextInt(footballList.size());

            //random clubs from above index
            FootballClub homeClub = footballList.get(homeIndex);
            FootballClub guestClub = footballList.get(guestIndex);

            //print above variables
            System.out.println(homeClub);
            System.out.println(guestClub);
            System.out.println(homeGoals);
            System.out.println(guestGoals);


            //Define club name is not null
                if (homeClub.getClubName() != null && guestClub.getClubName() != null) {
                    FootballClub team = new FootballClub();
                    team.setGoalsScored(homeGoals);
                    team.setGoalsScored(guestGoals);

                    //Set other variables
                    //Set teams
                    homeClub.setHomeTeamName(homeClub.getHomeTeamName());

                    homeClub.setGuestTeamName(guestClub.getGuestTeamName());

                    //Set scored Goals
                    homeClub.setGoalsScored(homeClub.getGoalsScored() + homeGoals);
                    guestClub.setGoalsScored(guestClub.getGoalsScored() + guestGoals);

                    //Set received goals
                    homeClub.setGoalsReceived(homeClub.getGoalsReceived() + guestGoals);
                    guestClub.setGoalsReceived(guestClub.getGoalsReceived() + homeGoals);

                    //Set played matches
                    homeClub.setPlayedMatches(homeClub.getPlayedMatches() + 1);
                    guestClub.setPlayedMatches(guestClub.getPlayedMatches() + 1);

                    //Set draw count
                    homeClub.setDraws(homeClub.getDraws());
                    guestClub.setDraws(guestClub.getDraws());

                    //Set points, wins & defeats
                    if (homeGoals > guestGoals) {
                        homeClub.setCurrentPoints(homeClub.getCurrentPoints() + 3);
                        homeClub.setWins(homeClub.getWins() + 1);
                        guestClub.setDefeats(guestClub.getDefeats() + 1);

                    } else {
                        guestClub.setCurrentPoints(guestClub.getCurrentPoints() + 3);
                        guestClub.setWins(guestClub.getWins() + 1);
                        homeClub.setDefeats(homeClub.getDefeats() + 1);
                    }

                } else {
                    System.out.println("There is no clubs registered yet");
                }
            }
            return (List<FootballClub>) footballList;
        }

}
