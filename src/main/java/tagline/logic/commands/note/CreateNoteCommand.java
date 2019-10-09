package tagline.logic.commands.note;

import static java.util.Objects.requireNonNull;
import static tagline.logic.parser.note.NoteCliSyntax.PREFIX_CONTENT;

import tagline.logic.commands.Command;
import tagline.logic.commands.CommandResult;
import tagline.logic.commands.exceptions.CommandException;
import tagline.model.Model;

/**
 * Creates a new note.
 */
public class CreateNoteCommand extends Command {

    public static final String COMMAND_WORD = "create";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Creates a new note. "
            + "Parameters: "
            + PREFIX_CONTENT + "CONTENT\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_CONTENT + "CS2103T meeting on Wednesday";

    public static  final String MESSAGE_SUCCESS = "New note added: %1$s";

//    private final Note toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Note}
     */
    public CreateNoteCommand() {
        /* TO ADD CONSTRUCTOR LOGIC WHEN MERGE WITH NOTE CLASS */
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        /* TO ADD EXECUTE LOGIC */

        return new CommandResult(String.format(MESSAGE_SUCCESS, "toAdd"));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CreateNoteCommand // instanceof handles nulls
                && true); /* TO ADD ATTRIBUTE EQUALITY CHECK */
    }
}
