public final class Controller {

    // Model object.
    private Model model;

    // View object.
    private View view;

    /**
     * Updates the content in the JWindow.
     *
     * @param model
     *            the model object
     * @param view
     *            the view object
     */
    private static void updateView(Model model, View view) {
        //Get model info
        StringBuilder word = model.getWord();
        Integer hash = model.getHash();
        // Update word in view
        view.updateInputDisplay(word);
        // Update hash in view
        view.updateHashDisplay(hash);
        boolean shouldButtonBeDisabled = hash > 0;
        view.updateResetAllowed(shouldButtonBeDisabled);
    }

    /**
     * Constructor that Aliases the model and view.
     *
     * @param model
     *            the model object
     * @param view
     *            the view object
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // Update view to show default model data
        updateView(this.model, this.view);
    }

    /**
     * Hashes {@code text} and updates word and hash code in model and view.
     *
     * @param typedWord
     *            String typed by the user to be hashed.
     * @updates model
     * @updates view
     */
    public void processHashEvent(String typedWord) {
        StringBuilder word = new StringBuilder(typedWord);
        this.model.setWord(word);
        this.model.getHash();
        updateView(this.model, this.view);
    }

    /**
     * Resets {@c0de this.model.word} and {@code this.model.wordHash}.
     */
    public void processResetEvent() {
        // Set word to empty String
        this.model.setWord(new StringBuilder());
        this.model.resetHash();
        updateView(this.model, this.view);
    }

}
