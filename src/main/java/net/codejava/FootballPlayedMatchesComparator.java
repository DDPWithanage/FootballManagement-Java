package net.codejava;

import java.util.Comparator;

public class FootballPlayedMatchesComparator implements Comparator<Date> {

    //Comparator for sorting played match Date according to the ascending order
    /*Display teams according to the date they have. The club has highest date will
        displayed first. */

    @Override
    public int compare(Date date1, Date date2) {
        if (date1.getDay() < date2.getDay() || date1.getMonth() < date2.getMonth() || date1.getYear() < date2.getYear())
            return -1;

        else if (date1.getDay() > date2.getDay() || date1.getMonth() > date2.getMonth() || date1.getYear() > date2.getYear())
            return 1;

        return 0;

        //Finally sort wins according to the -1, 0, 1  ascending order
    }
}
