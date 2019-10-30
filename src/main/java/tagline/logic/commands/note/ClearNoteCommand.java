// @@author shiweing
package tagline.logic.commands.note;

import tagline.logic.commands.CommandResult;
import tagline.model.Model;
import tagline.model.note.NoteBook;

import static java.util.Objects.requireNonNull;

/**
 * Clears the note book.
 */
public class ClearNoteCommand extends  NoteCommand {
    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Notes have been cleared!";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setNoteBook(new NoteBook());
        return new CommandResult(MESSAGE_SUCCESS, CommandResult.ViewType.NOTE);
    }
}
