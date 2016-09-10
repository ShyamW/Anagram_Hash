public final class Model {

    // Model class's word
    public StringBuilder word;

    // Model class's wordHash Representation of {@code word}.
    public Integer wordHash;

    /**
     * Default constructor. Initializes model input.
     */
    public Model() {
        this.word = new StringBuilder();
        this.wordHash = 1;
    }

    /**
     * Sets {@code this.word} to the value of {@code word}.
     *
     * @param word
     *            String representation of word to be hashed
     * @replaces this.word with the value of {@code word}
     */
    public void setWord(StringBuilder word) {
        this.word = word;
    }

    /**
     * Calculates the Hash representation of {@code word}.
     *
     * @replaces this.wordHash
     */
    private void calculateHash() {
        String word = this.word.toString();
        AnagramHash hash = new AnagramHash(word);
        this.wordHash = hash.value;
        System.out.println(this.wordHash + " FOR: " + this.word);
    }

    /**
     * Resets the has value of {@code this.wordHash}.
     *
     * @resets this.wordHash
     */
    public void resetHash() {
        this.wordHash = 0;
    }

    /**
     * Returns the word the user has typed into the inputPanel{@code this.word}
     *
     * @return this.word
     */
    public StringBuilder getWord() {
        return this.word;
    }

    /**
     * Returns the hashed value of {@code this.word}.
     * 
     * @return this.wordHash
     */
    public Integer getHash() {
        this.calculateHash();
        return this.wordHash;
    }

}
