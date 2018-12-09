package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Querybuilder query1 = new Querybuilder();
        Querybuilder query2 = new Querybuilder();
        Querybuilder query3 = new Querybuilder();
        
        Matcher m1 = query1.playsIn("PHI")
                  .hasAtLeast(10, "goals")
                  .hasFewerThan(20, "assists").build();
 
        Matcher m2 = query2.playsIn("EDM")
                          .hasAtLeast(60, "points").build();

        Matcher m = query3.oneOf(m1, m2).build();

        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
