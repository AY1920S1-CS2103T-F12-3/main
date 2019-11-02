// @@author shiweing
package tagline.logic.parser.note;

import static java.util.Objects.requireNonNull;
import static tagline.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static tagline.logic.parser.note.NoteCliSyntax.PREFIX_CONTENT;
import static tagline.logic.parser.note.NoteCliSyntax.PREFIX_TAG;
import static tagline.logic.parser.note.NoteCliSyntax.PREFIX_TITLE;

import tagline.logic.commands.note.EditNoteCommand;
import tagline.logic.commands.note.EditNoteCommand.EditNoteDescriptor;
import tagline.logic.parser.ArgumentMultimap;
import tagline.logic.parser.ArgumentTokenizer;
import tagline.logic.parser.Parser;
import tagline.logic.parser.exceptions.ParseException;
import tagline.model.note.Content;
import tagline.model.note.NoteId;
import tagline.model.note.Title;

/**
 * Parses input arguments and creates a new EditNoteCommand object
 */
public class EditNoteParser implements Parser<EditNoteCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the EditNoteCommand
     * and returns an EditNoteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditNoteCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_TITLE, PREFIX_CONTENT, PREFIX_TAG);

        checkArguments(argMultimap);

        NoteId noteId = NoteParserUtil.parseIndex(argMultimap.getPreamble());

        EditNoteDescriptor editNoteDescriptor = new EditNoteDescriptor();
        if (argMultimap.getValue(PREFIX_TITLE).isPresent()) {
            editNoteDescriptor.setTitle(new Title(argMultimap.getValue(PREFIX_TITLE).get()));
        }
        if (argMultimap.getValue(PREFIX_CONTENT).isPresent()) {
            editNoteDescriptor.setContent(new Content(argMultimap.getValue(PREFIX_CONTENT).get()));
        }
        /* TO ADD TAGS WHEN TAG IMPLEMENTED */

        if (!editNoteDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditNoteCommand.MESSAGE_NOT_EDITED);
        }

        return new EditNoteCommand(noteId, editNoteDescriptor);
    }

    /**
     * Check for the validity of arguments in {@code argMultimap}
     * E.g. There should be at most one usage of title and content.
     */
    private void checkArguments(ArgumentMultimap argMultimap) throws ParseException {
        // missing index
        if (argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditNoteCommand.MESSAGE_USAGE));
        }

        // check at most only one usage of provided prefixes
        NoteParserUtil.checkSinglePrefixUsage(argMultimap, PREFIX_TITLE, PREFIX_CONTENT);
    }
}
