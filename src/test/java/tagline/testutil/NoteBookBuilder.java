package tagline.testutil;

import tagline.model.note.NoteBook;
import tagline.model.note.Note;

/**
 * A utility class to help with building Notebook objects.
 * Example usage: <br>
 *     {@code NoteBook ab = new NoteBookBuilder().withNote(ULTRON).build();}
 */
public class NoteBookBuilder {

    private NoteBook noteBook;

    public NoteBookBuilder() {
        noteBook = new NoteBook();
    }

    public NoteBookBuilder(NoteBook noteBook) {
        this.noteBook = noteBook;
    }

    /**
     * Adds a new {@code Note} to the {@code NoteBook} that we are building.
     */
    public NoteBookBuilder withNote(Note note) {
        noteBook.addNote(note);
        return this;
    }

    public NoteBook build() {
        return noteBook;
    }
}
