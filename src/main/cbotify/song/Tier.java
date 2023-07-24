package cbotify.song;

enum Tier {
    BLANK("-", 0),
    C("C", 4),
    B("B", 5),
    A("A", 6),
    S("S", 7);
    
    private final String str;
    private final int val;
    
    Tier(String str, int val) {
        this.str = str;
        this.val = val;
    }
    
    public boolean matches(String input) {
        String trimmed = input.trim();
        String upCased = trimmed.toUpperCase();
        return this.str.equals(upCased);
    }
}
