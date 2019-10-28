package tagline.ui;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import tagline.model.contact.Contact;
import tagline.model.group.Group;

public class GroupSingleResultView extends ResultView {

    private static final String FXML = "GroupSingleResultView.fxml";

    private ContactListPanel contactListPanel;

    @FXML
    private Label name;

    @FXML
    private Label description;

    @FXML
    private StackPane contactListPanelPlaceholder;

    public GroupSingleResultView() {
        super(FXML);

        description.managedProperty().bind(description.visibleProperty());
    }

    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts(ObservableList<Group> groupList, ObservableList<Contact> contactList) {
        contactListPanel = new ContactListPanel(contactList);
        contactListPanelPlaceholder.getChildren().add(contactListPanel.getRoot());

        groupList.addListener(new ListChangeListener<Group>() {
            @Override
            public void onChanged(Change<? extends Group> change) {
                if (groupList.size() == 1) {
                    updateLabels(groupList.get(0));
                }
            }
        });
    }

    void updateLabels(Group group) {
        name.setText(group.getGroupName().value);

        if (group.getGroupDescription().value.isBlank()) {
            description.setVisible(false); //hide field
        } else {
            description.setVisible(true);
            description.setText(group.getGroupDescription().value);
        }
    }
}
