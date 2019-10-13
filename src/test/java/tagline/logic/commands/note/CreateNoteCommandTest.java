package tagline.logic.commands.note;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tagline.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import tagline.model.note.Note;
import tagline.testutil.NoteBuilder;

class CreateNoteCommandTest {

    @Test
    public void constructor_nullNote_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CreateNoteCommand(null));
    }

    @Test
    public void equals() {
        Note note41 = new NoteBuilder().withNoteId(41).build();
        Note note42 = new NoteBuilder().withNoteId(42).build();
        CreateNoteCommand createNote41Command = new CreateNoteCommand(note41);
        CreateNoteCommand createNote42Command = new CreateNoteCommand(note42);

        // same object -> returns true
        assertTrue(createNote41Command.equals(createNote41Command));

        // same values -> returns true
        CreateNoteCommand createNote41CommandCopy = new CreateNoteCommand(note41);
        assertTrue(createNote41Command.equals(createNote41CommandCopy));

        // different types -> returns false
        assertFalse(createNote41Command.equals(1));

        // null -> returns false
        assertFalse(createNote41Command.equals(null));

        // different note -> returns false
        assertFalse(createNote41Command.equals(createNote42Command));
    }
}
