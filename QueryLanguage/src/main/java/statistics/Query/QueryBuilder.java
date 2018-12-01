package statistics.Query;

import statistics.matcher.*;

public class QueryBuilder {
    private Matcher matcher;

    public QueryBuilder() {
        matcher = new All();
    }

    private QueryBuilder(Matcher matcher) {
        this.matcher = matcher;
    }

    public QueryBuilder playsIn(String team) {
        return new QueryBuilder(new And(this.matcher, new PlaysIn(team)));
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        return new QueryBuilder(new And(this.matcher, new HasAtLeast(value, category)));
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        return new QueryBuilder(new And(this.matcher, new HasFewerThan(value, category)));
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        return new QueryBuilder(new Or(matchers));
    }

    public Matcher build() {
        return matcher;
    }
}
