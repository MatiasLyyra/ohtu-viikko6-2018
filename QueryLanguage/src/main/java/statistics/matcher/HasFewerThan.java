package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher{
    private HasAtLeast matcher;

    public HasFewerThan(int value, String category) {
        matcher = new HasAtLeast(value, category);
    }

    @Override
    public boolean matches(Player p) {
        return !matcher.matches(p);
    }
}
