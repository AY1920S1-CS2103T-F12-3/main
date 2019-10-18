package tagline.model.tag;

import java.util.List;

/**
 * The API of the TagModel component.
 */
public interface TagModel {
    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setTagList(ReadOnlyTagList tagList);

    /**
     * Returns a read-only view of the tag list.
     */
    ReadOnlyTagList getTagList();

    /**
     * Returns true if {@code tag} exists in the tag list.
     */
    boolean containsTag(Tag tag);

    /**
     * Adds the given tag.
     * {@code tag} must not already exist in the tag list.
     */
    void addTag(Tag tag);

    /**
     * Returns a list containing the tag matching {@code id}, or an empty list if none were found.
     */
    List<Tag> findTag(TagId id);
}
