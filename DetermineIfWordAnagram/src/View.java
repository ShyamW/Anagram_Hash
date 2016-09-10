import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public final class View extends JFrame implements ActionListener {

    // Controller Object
    private Controller controller;

    // GUI Widgets
    private static final int LINES_IN_TEXT_AREAS = 5,
            LINE_LENGTHS_IN_TEXT_AREAS = 20, ROWS_IN_BUTTON_PANEL_GRID = 1,
            COLUMNS_IN_BUTTON_PANEL_GRID = 2, ROWS_IN_THIS_GRID = 3,
            COLUMNS_IN_THIS_GRID = 1;

    // Text boxes
    private final JTextArea inputText, outputHash;

    // Buttons
    private final JButton resetButton, hashButton;

    /**
     * constructor.
     */
    public View() {
        // Title
        super("String Hashing Checker");

        // Create Widgets
        this.inputText = new JTextArea("", LINES_IN_TEXT_AREAS,
                LINE_LENGTHS_IN_TEXT_AREAS);
        this.outputHash = new JTextArea("", LINES_IN_TEXT_AREAS,
                LINE_LENGTHS_IN_TEXT_AREAS);
        this.resetButton = new JButton("Reset");
        this.hashButton = new JButton("Hash");

        // set editable and line wrapping
        this.inputText.setEditable(true);
        this.inputText.setLineWrap(true);
        this.inputText.setWrapStyleWord(true);
        this.outputHash.setEditable(false);
        this.outputHash.setLineWrap(true);
        this.outputHash.setWrapStyleWord(true);

        // Create Scroll Panes
        JScrollPane inputTextScrollPane = new JScrollPane(this.inputText);
        JScrollPane outputTextScrollPane = new JScrollPane(this.outputHash);

        // Create Button Panel with Grid Layout
        JPanel buttonPanel = new JPanel(new GridLayout(
                ROWS_IN_BUTTON_PANEL_GRID, COLUMNS_IN_BUTTON_PANEL_GRID));

        // Add Buttons
        buttonPanel.add(this.hashButton);
        buttonPanel.add(this.resetButton);

        // Set Grid Layout
        this.setLayout(new GridLayout(ROWS_IN_THIS_GRID, COLUMNS_IN_THIS_GRID));

        //Add Scroll Panes
        this.add(inputTextScrollPane);
        this.add(buttonPanel);
        this.add(outputTextScrollPane);

        // Listen to buttons
        this.resetButton.addActionListener(this);
        this.hashButton.addActionListener(this);

        // Condense Window
        this.pack();
        // Exit on Close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Open GUI
        this.setVisible(true);
    }

    /**
     * Register argument as observer/listener of this; this must be done first,
     * before any other methods of this class are called.
     *
     * @param controller
     *            controller to observe
     */
    public void registerObserver(Controller controller) {
        this.controller = controller;
    }

    /**
     * Updates input display based on String provided as argument.
     *
     * @param word
     *            new value of input display
     */
    public void updateInputDisplay(StringBuilder word) {
        this.inputText.setText(word.toString());
    }

    /**
     * Updates output to display hash.
     *
     * @param hash
     *            new value of output display
     */

    public void updateHashDisplay(Integer hash) {
        this.outputHash.setText(hash.toString());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // Stop Listening to Events
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        // Get the occuredEvent
        Object occuredEvent = event.getSource();
        if (occuredEvent == this.resetButton) {
            this.controller.processResetEvent();
        } else if (occuredEvent == this.hashButton) {
            String typedText = this.inputText.getText();
            System.out.println(typedText + "!");
            this.controller.processHashEvent(typedText);
        }

        // Resume Listening to Events
        this.setCursor(Cursor.getDefaultCursor());
    }

    /**
     * Enables the reset button on the JPanel.
     *
     * @param canEnable
     *            boolean (whether the update button can be enabled)
     */
    public void updateResetAllowed(boolean canEnable) {
        this.resetButton.setEnabled(canEnable);
    }

}
