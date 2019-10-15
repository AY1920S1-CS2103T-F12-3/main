package tagline.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tagline.logic.parser.note.NoteCliSyntax.PREFIX_CONTENT;
import static tagline.logic.parser.note.NoteCliSyntax.PREFIX_TITLE;
import static tagline.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tagline.commons.core.index.Index;
import tagline.logic.commands.exceptions.CommandException;
import tagline.model.AddressBook;
import tagline.model.Model;
import tagline.model.contact.Contact;
import tagline.model.contact.NameContainsKeywordsPredicate;

/**
 * Contains helper methods for testing commands.
 */
public class NoteCommandTestUtil {

    public static final long VALID_NOTEID_PROTECTOR = 11;
    public static final String VALID_TITLE_PROTECTOR = "The Protector Initiative";
    public static final String VALID_CONTENT_PROTECTOR = "Phase 1:\n A response team comprised "
            + "of the most able individuals humankind has to offer. The Initiative will "
            + "defend Earth from imminent global threats that are beyond the warfighting "
            + "capability of conventional military forces.";
    public static final String VALID_TIMECREATED_PROTECTOR = "13-May-1995 15:35:08";
    public static final String VALID_TIMELASTUPDATED_PROTECTOR = "14-May-1995 09:26:11";

    public static final long VALID_NOTEID_INCIDENT = 12;
    public static final String VALID_TITLE_INCIDENT = "Battle of New York";
    public static final String VALID_CONTENT_INCIDENT = "The Battle of New York, also known as "
        + "the Attack on New York, the Attack on Midtown Manhattan, the Manhattan Crisis and "
        + "the Incident, was a major battle between the Avengers and Loki with his borrowed "
        + "Chitauri army in Manhattan, New York City. According to Loki's plan, it was his "
        + "first battle to subjugate Earth, but the actions of the Avengers neutralized the "
        + "threat of the Chitauri before they could continue the invasion.";
    public static final String VALID_TIMECREATED_INCIDENT = "04-May-2012 13:12:34";
    public static final String VALID_TIMELASTUPDATED_INCIDENT = "16-Oct-2023 08:38:09";

    public static final String TITLE_DESC_PROTECTOR = " " + PREFIX_TITLE + VALID_TITLE_PROTECTOR;
    public static final String TITLE_DESC_INCIDENT = " " + PREFIX_TITLE + VALID_TITLE_INCIDENT;
    public static final String CONTENT_DESC_PROTECTOR = " " + PREFIX_CONTENT + VALID_CONTENT_PROTECTOR;
    public static final String CONTENT_DESC_INCIDENT = " " + PREFIX_CONTENT + VALID_CONTENT_INCIDENT;
    /* TO ADD FOR TAG WHEN TAG IMPLEMENTED */

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered contact list and selected contact in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Contact> expectedFilteredList = new ArrayList<>(actualModel.getFilteredContactList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredContactList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the contact at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showContactAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredContactList().size());

        Contact contact = model.getFilteredContactList().get(targetIndex.getZeroBased());
        final String[] splitName = contact.getName().fullName.split("\\s+");
        model.updateFilteredContactList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredContactList().size());
    }

}
