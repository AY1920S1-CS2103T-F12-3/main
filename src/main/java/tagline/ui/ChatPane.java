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

    public ChatPane(CommandExecutor commandExecutor) {
        super(FXML);

        commandBox = new CommandBox(commandExecutor);
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());

        //setting vvalue to 1.0 doesn't work
        dialogScrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setCommandFromUser(String commandFromUser) {
        requireNonNull(commandFromUser);
        dialogContainer.getChildren().add(DialogBox.getCommandDialog(commandFromUser).getRoot());
    }

    public void setFeedbackToUser(String feedbackToUser) {
        requireNonNull(feedbackToUser);
        dialogContainer.getChildren().add(DialogBox.getResponseDialog(feedbackToUser).getRoot());
    }
}
