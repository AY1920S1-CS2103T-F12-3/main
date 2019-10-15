package tagline.testutil;

import java.util.HashSet;
import java.util.Set;

import tagline.model.contact.Address;
import tagline.model.contact.Email;
import tagline.model.contact.Name;
import tagline.model.contact.Phone;
import tagline.model.note.Content;
import tagline.model.note.Date;
import tagline.model.note.Note;
import tagline.model.note.NoteId;
import tagline.model.note.TimeCreated;
import tagline.model.note.TimeLastEdited;
import tagline.model.note.Title;
import tagline.model.tag.Tag;
import tagline.model.util.SampleDataUtil;

/**
 * A utility class to help with building Note objects.
 */
public class NoteBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";



    public static final long DEFAULT_NOTEID = 99999;
    public static final String DEFAULT_TITLE = "The Protector Initiative";
    public static final String DEFAULT_CONTENT = "Phase 1:\n A response team comprised "
        + "of the most able individuals humankind has to offer. The Initiative will "
        + "defend Earth from imminent global threats that are beyond the warfighting "
        + "capability of conventional military forces.";
    public static final String DEFAULT_TIMECREATED = "13-May-1995 15:35:08";
    public static final String DEFAULT_TIMELASTUPDATED = "13-May-1995 15:35:08";
    //public static final String DEFAULT_EMAIL = "alice@gmail.com";
    //public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";


    private Name name;
    private Phone phone;
    private Email email;
    private Address address;

    private NoteId noteId;
    private Title title;
    private Content content;
    private TimeCreated timeCreated;
    private TimeLastEdited timeLastEdited;
    private Set<Tag> tags;

    public NoteBuilder() {
        noteId = new NoteId(DEFAULT_NOTEID);
        title = new Title(DEFAULT_TITLE);
        content = new Content(DEFAULT_CONTENT);
        //refactor These two classes to return with the same Instant instance
        //timeCreated = new TimeCreated();
        //timeLastEdited = new TimeLastEdited();
        timeCreated = new TimeCreated(new Date(DEFAULT_TIMECREATED));
        timeLastEdited = new TimeLastEdited(new Date(DEFAULT_TIMELASTUPDATED));

        tags = new HashSet<>();
    }

    /**
     * Initializes the NoteBuilder with the data of {@code contactToCopy}.
     */
    public NoteBuilder(Note noteToCopy) {
        noteId = noteToCopy.getNoteId();
        title = noteToCopy.getTitle();
        content = noteToCopy.getContent();
        timeCreated = noteToCopy.getTimeCreated();
        timeLastEdited = noteToCopy.getTimeLastEdited();
        title = noteToCopy.getTitle();

        tags = new HashSet<>(noteToCopy.getTags());
    }

    /**
     * Sets the {@code Title} of the {@code Note} that we are building.
     */
    public NoteBuilder withNoteId(long noteId) {
        this.noteId = new NoteId(noteId);
        return this;
    }

    /**
     * Sets the {@code Title} of the {@code Note} that we are building.
     */
    public NoteBuilder withTitle(String title) {
        this.title = new Title(title);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Note} that we are building.
     */
    public NoteBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Content} of the {@code Note} that we are building.
     */
    public NoteBuilder withContent(String content) {
        this.content = new Content(content);
        return this;
    }

    /**
     * Sets the {@code TimeCreated} of the {@code Note} that we are building.
     */
    public NoteBuilder withTimeCreated(String timestamp) {
        // need to add new feature into Date thingy
        this.timeCreated = new TimeCreated(new Date(timestamp));
        return this;
    }

    /**
     * Sets the {@code TimeLastEdited} of the {@code Note} that we are building.
     */
    public NoteBuilder withTimeLastUpdated(String timestamp) {
        this.timeLastEdited = new TimeLastEdited(new Date(timestamp));
        return this;
    }

    public Note build() {
        return new Note(noteId, title, content, timeCreated, timeLastEdited, tags);
    }

}
