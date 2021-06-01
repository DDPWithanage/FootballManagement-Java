package net.codejava;

import java.util.Comparator;

public class FootballWinsComparator implements Comparator<FootballClub> {

    //Comparator for sorting win count in descending order
    /*Display teams according to the wins they have. The club has maximum wins will
        displayed first. */
    @Override
    public int compare(FootballClub club1, FootballClub club2) {

        if (club1.getWins() > club2.getWins())
            return -1;


        else if (club1.getWins() < club2.getWins())
            return 1;

        //equal
        return 0;
        //Finally sort wins according to the 1, 0, -1  descending order
    }


}
