package tagline.model.note;

import tagline.commons.util.StringUtil;
import tagline.model.tag.Tag;

import java.util.List;
import java.util.function.Predicate;

/**
 * Tests that a {@code Note}'s {@code Tag} matches any of the tags given.
 */
public class NoteContainsTagsPredicate implements Predicate<Note> {
    private final List<Tag> tags;

    public NoteContainsTagsPredicate(List<Tag> tags) {
        this.tags = tags;
    }

    // for testing only, remove after test case works as expected
    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public boolean test(Note note) {
        return tags.stream()
                .anyMatch(tag -> note.getTags().contains(tag));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NoteContainsTagsPredicate // instanceof handles nulls
                && tags.equals(((NoteContainsTagsPredicate) other).tags)); // state check
    }

}
