package tagline.logic.commands.note;

import tagline.model.tag.Tag;

import java.util.Collections;
import java.util.List;

public class TagFilter implements NoteFilter<Tag> {
    List<Tag> filterValues;

    public TagFilter(List<Tag> tagDescriptors) {
        filterValues = tagDescriptors;
    }

    public List<Tag> getFilterValues() {
        return Collections.unmodifiableList(filterValues);
    }

    public FilterType getFilterType() {
        return FilterType.TAG;
    }
}
