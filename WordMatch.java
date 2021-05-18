public class WordMatch
{

    /** The secret string. */
    private String secret;

    /** Constructs a WordMatch object with the given 
        secret string of lowercase letters. */
    public WordMatch(String word)
    {
        secret = word;
    }

    // read 3 minutes
    
    /** Returns a score for guess, as described in part (a).
     *  Precondition: 0 < guess.length() <= secret.length()
     */
    public int scoreGuess(String guess) {
        // 12 minutes for initial version,
        // which I still wasn't convinced was right (though it was)
        // 5ish minutes to convert+check do-while->while and restyle.
        /*
        int count = 0;
        int index = 0;
        int next = 0;
        while(next != -1) {
            next = secret.substring(index).indexOf(guess);
            if(next != -1) {
                index += next + 1;
                count++;
            }
        }

        return count * guess.length() * guess.length();
        */
        
        // 2 more minutes to streamline above version to below,
        // which I think is far superior to what ended up as the
        // probable canonical that loops through every index
        // checking .equals on a guess-length substring.
        String str = secret;
        int count = 0;
        int next;
        while ( (next = str.indexOf(guess)) != -1) {
            str = str.substring(next+1);
            count++;
        }
        
        return count*guess.length()*guess.length();
    }


    /** Returns the better of two guesses, as determined by scoreGuess 
     *  and the rules for a tie-breaker that are described in part (b).
     *  Precondition: guess1 and guess2 contain all lowercase letters.
     *                guess1 is not the same as guess2.
     */
    public String findBetterGuess(String guess1, String guess2)
    {
        // 2 minutes
        int s1 = scoreGuess(guess1);
        int s2 = scoreGuess(guess2);
        if(s1 > s2) return guess1;
        if(s2 > s1) return guess2;
        if(guess1.compareTo(guess2) < 0)
            return guess2;
        return guess1;
    }

    public static void main(String[] args) {
        WordMatch game = new WordMatch("mississippi");
        System.out.println("i should be 4: " +
                           game.scoreGuess("i"));
        System.out.println("iss should be 18: " +
                           game.scoreGuess("iss"));
        System.out.println("issipp should be 36: " +
                           game.scoreGuess("issipp"));
        System.out.println("mississippi should be 121: " +
                           game.scoreGuess("mississippi"));

        game = new WordMatch("aaaabb");
        System.out.println("a should be 4: " +
                           game.scoreGuess("a"));
        System.out.println("aa should be 12: " +
                           game.scoreGuess("aa"));
        System.out.println("aaa should be 18: " +
                           game.scoreGuess("aaa"));
        System.out.println("aabb should be 16: " +
                           game.scoreGuess("aabb"));
        System.out.println("b should be 2: " +
                           game.scoreGuess("b"));
        System.out.println("bb should be 4: " +
                           game.scoreGuess("bb"));
        System.out.println("c should be 0: " +
                           game.scoreGuess("c"));

        game = new WordMatch("concatenation");
        System.out.println("ten should be 9: " +
                           game.scoreGuess("ten"));
        System.out.println("nation should be 36: " +
                           game.scoreGuess("nation"));
        System.out.println("So better guess should be nation: " +
                           game.findBetterGuess("ten", "nation"));
        System.out.println("con should be 9: " +
                           game.scoreGuess("con"));
        System.out.println("cat should be 9: " +
                           game.scoreGuess("cat"));
        System.out.println("con > cat so better guess should be con: " +
                           game.findBetterGuess("con", "cat"));
    }
}
