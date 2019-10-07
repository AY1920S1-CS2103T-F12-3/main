package tagline.ui;

import static java.util.Objects.requireNonNull;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import tagline.ui.CommandBox.CommandExecutor;

/**
 * The UI component that stores the chat window.
 */
public class ChatPane extends UiPart<VBox> {

    private static final String FXML = "ChatPane.fxml";

    private CommandBox commandBox;

    @FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private ScrollPane dialogScrollPane;

    @FXML
    private VBox dialogContainer;

    public ChatPane() {
        super(FXML);

        //setting vvalue to 1.0 doesn't work
        dialogScrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts(CommandExecutor commandExecutor) {
        commandBox = new CommandBox(commandExecutor);
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());
    }

    /**
     * Displays a new command from the user in the chat window.
     * @param commandFromUser Command entered by user
     */
    public void setCommandFromUser(String commandFromUser) {
        requireNonNull(commandFromUser);
        dialogContainer.getChildren().add(DialogBox.getCommandDialog(commandFromUser).getRoot());
    }

    /**
     * Displays the feedback returned by TagLine in the chat window.
     * @param feedbackToUser Feedback to user
     */
    public void setFeedbackToUser(String feedbackToUser) {
        requireNonNull(feedbackToUser);
        dialogContainer.getChildren().add(DialogBox.getResponseDialog(feedbackToUser).getRoot());
    }
}
