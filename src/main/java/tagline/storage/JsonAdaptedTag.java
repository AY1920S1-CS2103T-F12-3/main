package tagline.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import tagline.commons.exceptions.IllegalValueException;
import tagline.model.contact.ContactId;
import tagline.model.tag.ContactTag;
import tagline.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Tag}.
 */
class JsonAdaptedTag {

    private final String tagName;
    private final int tagId;

    /**
     * Constructs a {@code JsonAdaptedTag} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedTag(String tagName, int tagId) {
        this.tagName = tagName;
        this.tagId = tagId;
    }

    /**
     * Converts a given {@code Tag} into this class for Jackson use.
     */
    public JsonAdaptedTag(Tag source) {
        tagName = source.toString();
        tagId = source.tagId;
    }

    @JsonValue
    public String getTagName() {
        return tagName;
    }

    @JsonValue
    public int getTagId() {
        return tagId;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public Tag toModelType() throws IllegalValueException {
        return new ContactTag(new ContactId("123"));
    }
}
