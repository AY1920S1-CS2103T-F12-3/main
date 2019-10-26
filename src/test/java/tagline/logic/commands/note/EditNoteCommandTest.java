package tagline.logic.commands.note;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tagline.logic.commands.note.EditNoteCommand.EditNoteDescriptor;
import static tagline.testutil.TypicalIndexes.INDEX_FIRST;
import static tagline.testutil.TypicalNotes.getTypicalNoteBook;

import org.junit.jupiter.api.Test;

import tagline.logic.commands.CommandResult;
import tagline.logic.commands.exceptions.CommandException;
import tagline.model.Model;
import tagline.model.ModelManager;
import tagline.model.UserPrefs;
import tagline.model.note.Note;
import tagline.testutil.EditNoteDescriptorBuilder;
import tagline.testutil.NoteBuilder;

/**
 * Contains integration tests (interaction with the Model) and
 * unit tests for EditNoteCommand.
 */
class EditNoteCommandTest {

    private static final CommandResult.ViewType EDIT_NOTE_COMMAND_VIEW_TYPE = CommandResult.ViewType.NOTE;
    private Model model = new ModelManager(getTypicalNoteBook(), new UserPrefs());

    @Test
    public void execute_allFieldsSpecified_success() {
        Note originalNote = model.getNoteBook().getNoteList().get(INDEX_FIRST.getZeroBased());
        Note editedNote = new NoteBuilder().withNoteId(originalNote.getNoteId().toLong())
                .withTimeLastEdited(originalNote.getTimeLastEdited()).build();

        EditNoteDescriptor descriptor = new EditNoteDescriptorBuilder(editedNote).build();
        EditNoteCommand editNoteCommand = new EditNoteCommand(originalNote.getNoteId(), descriptor);

        // check result manually as TimeLastEdited is dynamically obtained,
        // resulting in failure for assertEquals
        try {
            CommandResult result = editNoteCommand.execute(model);
            Note actualEditedNote = model.getNoteBook().getNoteList().get(INDEX_FIRST.getZeroBased());

            assertEquals(result.getViewType(), EDIT_NOTE_COMMAND_VIEW_TYPE);
            assertTrue(actualEditedNote.isUniqueNote(editedNote));
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }

    }
}
