package tagline.model.tag;

import static java.util.Objects.requireNonNull;


/**
 * Represents a tag in tagline.
 */
public abstract class Tag {
    /**
     * Specifies {@code TagType} for each tag.
     */
    public enum TagType {
        HASH_TAG,
        CONTACT_TAG,
        GROUP_TAG,
    }

    private static int nextId = 1; //temporary implementation of an incrementing tag ID

    public final TagType tagType;
    public final int tagId;

    /**
     * Constructs a {@code Tag}.
     *
     * @param tagType A valid tag name.
     */
    public Tag(TagType tagType) {
        requireNonNull(tagType);
        this.tagType = tagType;
        this.tagId = nextId;
        nextId++;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof Tag // instanceof handles nulls
            && tagType.equals(((Tag) other).tagType)); // state check
    }

    @Override
    public abstract String toString();
}
