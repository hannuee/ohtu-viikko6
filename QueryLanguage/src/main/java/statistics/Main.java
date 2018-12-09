package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Querybuilder query = new Querybuilder();
        Matcher m = query.playsIn("NYR").not().build();

        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
