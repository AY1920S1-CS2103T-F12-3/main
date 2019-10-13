package tagline.testutil;

import static tagline.logic.commands.NoteCommandTestUtil.VALID_CONTENT_INCIDENT;
import static tagline.logic.commands.NoteCommandTestUtil.VALID_CONTENT_PROTECTOR;
import static tagline.logic.commands.NoteCommandTestUtil.VALID_NOTEID_INCIDENT;
import static tagline.logic.commands.NoteCommandTestUtil.VALID_NOTEID_PROTECTOR;
import static tagline.logic.commands.NoteCommandTestUtil.VALID_TIMECREATED_INCIDENT;
import static tagline.logic.commands.NoteCommandTestUtil.VALID_TIMECREATED_PROTECTOR;
import static tagline.logic.commands.NoteCommandTestUtil.VALID_TIMELASTUPDATED_INCIDENT;
import static tagline.logic.commands.NoteCommandTestUtil.VALID_TIMELASTUPDATED_PROTECTOR;
import static tagline.logic.commands.NoteCommandTestUtil.VALID_TITLE_INCIDENT;
import static tagline.logic.commands.NoteCommandTestUtil.VALID_TITLE_PROTECTOR;

//import static tagline.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
//import static tagline.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
//import static tagline.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
//import static tagline.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
//import static tagline.logic.commands.CommandTestUtil.VALID_NAME_AMY;
//import static tagline.logic.commands.CommandTestUtil.VALID_NAME_BOB;
//import static tagline.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
//import static tagline.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
//import static tagline.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
//import static tagline.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tagline.model.NoteBook;
import tagline.model.note.Note;

/**
 * A utility class containing a list of {@code Note} objects to be used in tests.
 */
public class TypicalNotes {

    public static final long NOTEID_TIMEHEIST = 31;
    public static final String TITLE_TIMEHEIST = "Time Heist";
    public static final String CONTENT_TIMEHEIST = "\"Six stones, three teams, one shot. "
        + "Five years ago, we lost. All of us. We lost friends. We lost family. We lost "
        + "a part of ourselves. Today, we have a chance to take it all back. You know "
        + "your teams. You know your missions. Get the stones. Get them back.\""
        + "-- Steve Rogers";
    public static final String TIMECREATED_TIMEHEIST = "16-Oct-2023 08:38:09";
    public static final String TIMELASTUPDATED_TIMEHEIST = "17-Oct-2023 17:19:18";

    public static final long NOTEID_ULTRON = 21;
    public static final String TITLE_ULTRON = "Ultron Offensive";
    public static final String CONTENT_ULTRON = "The Ultron Offensive[1] was a series "
        + "of attacks executed by the rogue artificial intelligence, Ultron, in a quest "
        + "to bring about the extinction of humanity. His greatest opposition was by the "
        + "Avengers, and the repetitive confrontations between the two led to various "
        + "negative repercussions against the team. The conflict culminated in a wide-"
        + "scale destructive battle in the Eastern European country of Sokovia, where "
        + "the Avengers, aided by new members and allied forces from the former "
        + "S.H.I.E.L.D. agency, defeated Ultron. ";
    public static final String TIMECREATED_ULTRON = "29-Apr-2015 07:19:05";
    public static final String TIMELASTUPDATED_ULTRON = "06-May-2015 22:18:11";

    // Manually added
    public static final Note TIMEHEIST = new NoteBuilder().withNoteId(NOTEID_TIMEHEIST)
            .withTitle(TITLE_TIMEHEIST)
            .withContent(CONTENT_TIMEHEIST).withTimeCreated(TIMECREATED_TIMEHEIST)
            .withTimeLastUpdated(TIMELASTUPDATED_TIMEHEIST).build();

    public static final Note ULTRON = new NoteBuilder().withNoteId(NOTEID_ULTRON)
            .withTitle(TITLE_ULTRON)
            .withContent(CONTENT_ULTRON).withTimeCreated(TIMECREATED_ULTRON)
            .withTimeLastUpdated(TIMELASTUPDATED_ULTRON).build();

    ////public static final Note ALICE = new NoteBuilder().withName("Alice Pauline")
    ////        .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
    ////        .withPhone("94351253")
    ////        .withTags("friends").build();
    ////public static final Note BENSON = new NoteBuilder().withName("Benson Meier")
    ////        .withAddress("311, Clementi Ave 2, #02-25")
    ////        .withEmail("johnd@example.com").withPhone("98765432")
    ////        .withTags("owesMoney", "friends").build();

    // Manually added
    //public static final Note HOON = new NoteBuilder().withName("Hoon Meier").withPhone("8482424")
    //        .withEmail("stefan@example.com").withAddress("little india").build();
    //public static final Note IDA = new NoteBuilder().withName("Ida Mueller").withPhone("8482131")
    //        .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Note's details found in {@code NoteCommandTestUtil}
    public static final Note PROTECTOR = new NoteBuilder().withNoteId(VALID_NOTEID_PROTECTOR)
            .withTitle(VALID_TITLE_PROTECTOR)
            .withContent(VALID_CONTENT_PROTECTOR).withTimeCreated(VALID_TIMECREATED_PROTECTOR)
            .withTimeLastUpdated(VALID_TIMELASTUPDATED_PROTECTOR).build();

    public static final Note INCIDENT = new NoteBuilder().withNoteId(VALID_NOTEID_INCIDENT)
            .withTitle(VALID_TITLE_INCIDENT)
            .withContent(VALID_CONTENT_INCIDENT).withTimeCreated(VALID_TIMECREATED_INCIDENT)
            .withTimeLastUpdated(VALID_TIMELASTUPDATED_INCIDENT).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalNotes() {} // prevents instantiation

    /**
     * Returns an {@code NoteBook} with all the typical notes.
     */
    public static NoteBook getTypicalNoteBook() {
        NoteBook nb = new NoteBook();
        for (Note note : getTypicalNotes()) {
            nb.addNote(note);
        }
        return nb;
    }

    public static List<Note> getTypicalNotes() {
        return new ArrayList<>(Arrays.asList(PROTECTOR, INCIDENT, TIMEHEIST, ULTRON));
        //return new ArrayList<>(Arrays.asList(PROTECTOR, INCIDENT ));
    }
}
