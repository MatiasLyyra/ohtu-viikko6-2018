package statistics;

import statistics.Query.QueryBuilder;
import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        QueryBuilder builder = new QueryBuilder();
        Matcher m1 = builder
                .playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();
        Matcher m2 = builder
                .playsIn("EDM")
                .hasAtLeast(60, "points").build();
        Matcher m = builder.oneOf(m1, m2).build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
