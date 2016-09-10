import java.util.HashMap;

/**
 * Class used to determine if strings are anagrams of each other. Performance is
 * O(n) since each letter in the word is assigned a prime number and then
 * multiplied together to assign a word a unique hashed value.
 *
 * @author Shyam Thiagarajan
 *
 * @credit to Alex Chan for Idea
 *
 */
public class AnagramHash {
    /**
     * instance variables
     */
    private String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
    private String word;
    public int value;
    private HashMap<Character, Integer> lettersToPrime = new HashMap<>();

    /**
     * Public constructor that takes {@code scrambledWord} and initializes
     * {@code word}.
     *
     * @param scrambledWord
     *            String of scrambled word
     * @replaces this.word
     */
    public AnagramHash(String scrambledWord) {
        this.word = scrambledWord.toLowerCase();
        this.hashAnagram();
    }

    /**
     * Checks if {@code num) is a prime number.
     *
     * @param num
     *            Number to check if isPrime
     * @return isPrime boolean of whether {@code num} is prime.
     */
    private boolean isPrime(int num) {
        boolean isPrime = true;
        int testNum = 2;
        while (testNum <= num / 2) {
            if (num % testNum == 0) {
                isPrime = false;
            }
            testNum += 1;
        }
        return isPrime;
    }

    /**
     * Finds a prime number greater in value than {@code nextPrime}.
     *
     * @param lowerLimit
     *            number to find next greater prime.
     * @return nextPrime prime number that is greater than {@code lowerLimit}
     * @ensures nextPrime is a prime number and nextPrime > lowerLimit
     */
    private int getNextPrime(int lowerLimit) {
        int nextPrime = lowerLimit;
        boolean primeFound = false;
        while (!primeFound) {
            if (this.isPrime(nextPrime)) {
                primeFound = true;
            } else {
                nextPrime += 1;
            }
        }
        return nextPrime;
    }

    /**
     * Prints the HashMap key (letter) and value (prime integer).
     *
     * @param map
     *            HashMap of Integer to Character
     */
    public void print(HashMap<Integer, Character> map) {
        for (Character letter : this.lettersToPrime.keySet()) {
            System.out.println("KEY " + letter + ", Value: " + map.get(letter));
        }
    }

    /**
     * Generates a HashMap{@code this.lettersToPrime} of prime integers: letters
     * in {@code this.lowercaseLetters}
     *
     * @replaces this.lettersToPrime HashMap of prime integers: char letters
     */
    private void generateLetterHash() {
        int nextPrime = 2;
        for (int index = 0; index < this.lowercaseLetters.length(); index++) {
            char letter = this.lowercaseLetters.charAt(index);
            nextPrime = this.getNextPrime(nextPrime);
            this.lettersToPrime.put(letter, nextPrime);
            nextPrime++;
        }
        // this.print(this.lettersToPrime);
    }

    /**
     * Determines value of {@code this.word} by multiplying all prime keys in
     * {@code this.lettersToPrime}.
     *
     * @updates this.value
     */
    private void determineValue() {
        int value = 1;
        for (int index = 0; index < this.word.length(); index++) {
            char letter = this.word.charAt(index);
            value *= this.lettersToPrime.get(letter);
        }
        this.value = value;
    }

    /**
     * Public method to get the value (the prime number) of {@code word}
     *
     * @return this.value unique value calculated by letters in
     *         {@code this.word}
     */
    public void hashAnagram() {
        this.generateLetterHash();
        this.determineValue();
    }

}
