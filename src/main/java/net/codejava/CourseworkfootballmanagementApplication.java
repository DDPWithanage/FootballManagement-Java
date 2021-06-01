package net.codejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
@RestController
public class CourseworkfootballmanagementApplication {
    private final static PremierLeagueManager leagueManager = new PremierLeagueManager();
    private static int count = 0;

    //Create mapping for display premier league table
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/FootballSystem")
    public List<FootballClub> getList(){
        return leagueManager.footballList;
    }

    //Create mapping for display points
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/Points")
    public List<FootballClub> getSort(){
        Collections.sort(leagueManager.footballList, new FootballPointsComparator());
        return leagueManager.footballList;
    }

    //Create mapping for display goal score
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/GoalsScore")
    public List<FootballClub> getGoalsScore(){
        Collections.sort(leagueManager.footballList, new FootballGoalsScoredComparator());
        return leagueManager.footballList;
    }

    //Create mapping for display wins
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/Win")
    public List<FootballClub> getWin(){
        Collections.sort(leagueManager.footballList, new FootballWinsComparator());
        return leagueManager.footballList;
    }

    //Create mapping for generate random matches from randomMatch method
    @CrossOrigin("http://localhost:4200")
    @GetMapping("RandomMatch")
    public List<FootballClub> match()  {
        return leagueManager.randomMatch();
    }


    //Start
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CourseworkfootballmanagementApplication.class, args);

        //Retrieve data from the file
        leagueManager.getData("Football.txt");
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                //Main menu
                System.out.println("~~~~~~~~~~~~~Welcome to Football Club~~~~~~~~~~~~~");
                System.out.println("Enter \"A\" or \"a\" for ADD a new football club");
                System.out.println("Enter \"D\" or \"d\" for DELETE a football club");
                System.out.println("Enter \"I\" or \"i\" for DISPLAY STATISTICS of football club");
                System.out.println("Enter \"P\" or \"p\" for DISPLAY PREMIER LEAGUE TABLE");
                System.out.println("Enter \"M\" or \"m\" for ADD PLAYED MATCHES");
                System.out.println("Enter \"S\" or \"s\" for SAVED INFORMATION in premier league");
                System.out.println("Enter \"E\" or \"e\" for EXIT from the system");
                System.out.print("Enter your choice : ");
                String choice = scanner.next();

                //Add switch cases for menu console for get user input
                switch (choice) {
                    case "A":
                    case "a":
                        addFootballClub();
                        break;

                    case "D":
                    case "d":
                        deleteFootballClub();
                        break;

                    case "I":
                    case "i":
                        leagueManager.displayStatistics();
                        break;

                    case "P":
                    case "p":
                        leagueManager.premierLeagueTable();
                        break;

                    case "M":
                    case "m":
                        leagueManager.addPlayedMatch();
                        break;

                    case "S":
                    case "s":
                        leagueManager.saveFile("Football.txt");
                        break;

                    case "E":
                    case "e":
                        exit();
                        break;

                    default:
                        System.out.println("Invalid input");
                        break;

                }
            }
        } catch (InputMismatchException in) {
            System.out.println("Invalid Input! Please reenter a valid number");
        }
    }

    //Add method
    private static void addFootballClub() {
        Scanner scanner = new Scanner(System.in);
        if (count < 20) {
            System.out.print("Enter name of the new football club : ");
            String clubName = scanner.next();
            System.out.print("Enter location : ");
            String location = scanner.next();

            System.out.print("Enter football club type - 'D' for Default football club , 'U' for university football club & 's' for school football club : ");
            String type = scanner.next();
            FootballClub sports;

            //Assign values for Football club constructor
            sports = new FootballClub(clubName, location, null, null, 0, 0, 0, 0, 0, 0, 0, null);

            //Add switch cases for define the team is default club, university club or school club
            switch (type) {
                case "D":
                case "d":
                    System.out.println("Successfully added a default team");
                    break;

                case "U":
                case "u":
                    System.out.print("Enter your university name : ");
                    String uniName = scanner.next();
                    System.out.print("Enter your university address : ");
                    String uniAddress = scanner.next();
                    System.out.print("Enter your university email : ");
                    String uniEmail = scanner.next();
                    sports = new UniversityFootballClub(clubName, location, sports.getHomeTeamName(), sports.getGuestTeamName(), 0, 0, 0, 0, 0, 0, 0, null, uniName, uniAddress, uniEmail);
                    break;

                case "S":
                case "s":
                    System.out.print("Enter your school name : ");
                    String schoolName = scanner.next();
                    System.out.print("Enter your school email : ");
                    String schoolEmail = scanner.next();
                    sports = new SchoolFootballClub(clubName, location, null, null, 0, 0, 0, 0, 0, 0, 0, null, schoolName, schoolEmail);
                    break;
                default:
                    System.out.println("Invalid input");

                    return;

            }
            leagueManager.addFootballClub(sports);
            count++;

        } else {
            System.out.println("No free spaces available. Unable to add more clubs");
        }
    }

    //Delete Method
    private static void deleteFootballClub() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter club name : ");
        String clubName = scanner.next();
        leagueManager.deleteFootballClub(clubName);

        count--;
    }

    //Exit Method - exit from the system
    private static void exit() {
        System.out.println("Thank you for visiting our football club!!!!! ");
        System.exit(0);
    }

}


