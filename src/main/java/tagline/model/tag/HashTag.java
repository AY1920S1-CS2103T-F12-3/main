package tagline.model.tag;

/**
 * Tag a contact.
 */
public class HashTag extends Tag {
    public static final String TAG_PREFIX = "#";

    private String value;

    /**
     * Constructs a HashTag.
     */
    public HashTag(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || ((other instanceof HashTag) // instanceof handles nulls
                && value.equals(((HashTag) other).value));
    }

    @Override
    public String toString() {
        return TAG_PREFIX + value;
    }
}
