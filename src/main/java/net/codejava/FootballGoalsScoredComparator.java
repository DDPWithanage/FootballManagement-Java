package net.codejava;

import java.util.Comparator;

public class FootballGoalsScoredComparator implements Comparator<FootballClub> {

    //Comparator for sorting goal scored in descending order
    /*Display teams according to the goal score they have. The club has maximum goal score will
        displayed first. */
    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        if (club1.getGoalsScored() > club2.getGoalsScored())
            return -1;

        else if (club1.getGoalsScored() < club2.getGoalsScored())
            return 1;

        return 0;
        //Finally sort wins according to the 1, 0, -1  descending order
    }
}
