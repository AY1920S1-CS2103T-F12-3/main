package tagline.ui;

import static org.testfx.util.NodeQueryUtils.hasText;

import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.framework.junit5.Stop;

import javafx.scene.Node;
import javafx.stage.Stage;
import tagline.testutil.TypicalNotes;

@ExtendWith(ApplicationExtension.class)
public class NoteListCardTest {

    @Start
    void setUp(Stage stage) throws TimeoutException {
        stage.setWidth(500); //for human-viewable results
        FxToolkit.setupSceneRoot(() -> new NoteListCard(TypicalNotes.EARTH).getRoot());
        FxToolkit.showStage();
    }

    @Stop
    void tearDown() throws TimeoutException {
        FxToolkit.cleanupStages();
    }

    @AfterEach
    void pause(FxRobot robot) {
        String headlessPropertyValue = System.getProperty("testfx.headless");
        if (headlessPropertyValue != null && headlessPropertyValue.equals("true")) {
            return;
        }

        robot.sleep(500);
    }

    private Node getChildNode(FxRobot robot, String id) {
        return robot.lookup(id).query();
    }

    @Test
    void checkFieldsDisplayedCorrectly(FxRobot robot) {
        FxAssert.verifyThat(getChildNode(robot, "#title"), hasText(TypicalNotes.EARTH.getTitle().titleDescription));
        FxAssert.verifyThat(getChildNode(robot, "#time"), hasText(TypicalNotes.EARTH.getTimeCreated().toString()));
        FxAssert.verifyThat(getChildNode(robot, "#content"), hasText(TypicalNotes.EARTH.getContent().value));
        FxAssert.verifyThat(getChildNode(robot, "#id"), hasText("#" + TypicalNotes.EARTH.getNoteId().value));
    }
}
