package tagline.logic.commands.note;

import static java.util.Objects.requireNonNull;

import tagline.logic.commands.CommandResult;
import tagline.logic.commands.exceptions.CommandException;
import tagline.model.Model;
import tagline.model.note.NoteId;

/**
 * Deletes a note identified using it's index.
 */
public class DeleteNoteCommand extends NoteCommand {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the note identified by the note index number.\n"
            + "Parameters: NOTE_ID (must be a positive integer)\n"
            + "Example: " + COMMAND_KEY + " "  + COMMAND_WORD + " 1";

    public static final String MESSAGE_SUCCESS = "Delete note: %1$s";

    private final NoteId targetId;

    public DeleteNoteCommand(NoteId noteId) {
        requireNonNull(noteId);
        targetId = noteId;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        /* TO ADD EXECUTE LOGIC */

        return new CommandResult(String.format(MESSAGE_SUCCESS, "noteToDelete"));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteNoteCommand // instanceof handles nulls
                && targetId.equals(((DeleteNoteCommand) other).targetId)); // state check
    }
}
