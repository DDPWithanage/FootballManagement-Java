package net.codejava;

import java.util.Comparator;

public class FootballPointsComparator implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub club1, FootballClub club2) {

        /*Display teams according to the points they have. The club has maximum points will
        displayed first and if two teams have same number of points the club with maximum
        goal difference should appear first */
        if (club1.getCurrentPoints() > club2.getCurrentPoints())
            return -1;

        else if (club1.getCurrentPoints() < club2.getCurrentPoints())
            return 1;

        else if (club1.getCurrentPoints() == club2.getCurrentPoints()) {
            int goalDiff1 = club1.getGoalsScored() - club1.getGoalsReceived();
            int goalDiff2 = club2.getGoalsScored() - club2.getGoalsReceived();

            /*(goalDiff1 > goalDiff2 -> return -1) elseif (goalDiff1 < goalDiff2 -> return 1)
            or else return Zero*/
            return Integer.compare(goalDiff2, goalDiff1);

        }
        return 0;

        //Finally sort wins according to the 1, 0, -1  descending order
    }
}
