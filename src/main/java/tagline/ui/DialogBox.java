package tagline.ui;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * A dialog box to display chat messages.
 */
class DialogBox extends UiPart<HBox> {

    private static final String FXML = "DialogBox.fxml";

    private static final String COMMAND_DIALOG = "command-dialog";
    private static final String RESPONSE_DIALOG = "response-dialog";

    private static final double TRANSITION_DURATION = 0.5;
    private static final double TRANSITION_OPACITY_FROM = 0.5;
    private static final double TRANSITION_OPACITY_TO = 1.0;

    @FXML
    private Label dialog;

    private FadeTransition fadeTransition;

    /**
     * Creates a new DialogBox.
     *
     * @param text  Text to place in the dialog box
     */
    private DialogBox(String text) {
        super(FXML);

        dialog.setText(text);
        prepareAnimation();
    }

    /**
     * Prepares the fade-in transition of the dialog box.
     */
    private void prepareAnimation() {
        fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(TRANSITION_DURATION));
        fadeTransition.setFromValue(TRANSITION_OPACITY_FROM);
        fadeTransition.setToValue(TRANSITION_OPACITY_TO);

        fadeTransition.setNode(dialog);
    }

    /**
     * Flips the dialog box so that the text is aligned on the left.
     */
    private void flip() {
        getRoot().setAlignment(Pos.TOP_LEFT);
    }

    /**
     * Creates a dialog box for commands from the user.
     * The text box is aligned to the right.
     *
     * @param text  Text to place in the dialog box
     * @return      A DialogBox object for the message
     */
    public static DialogBox getCommandDialog(String text) {
        DialogBox db = new DialogBox(text);

        db.dialog.getStyleClass().add(COMMAND_DIALOG);
        db.fadeTransition.play();
        return db;
    }

    /**
     * Creates a dialog box for response messages.
     * The text box is aligned to the left.
     *
     * @param text  Text to place in the dialog box
     * @return      A DialogBox object for the message
     */
    public static DialogBox getResponseDialog(String text) {
        DialogBox db = new DialogBox(text);
        db.flip();

        db.dialog.getStyleClass().add(RESPONSE_DIALOG);
        db.fadeTransition.play();
        return db;
    }
}
