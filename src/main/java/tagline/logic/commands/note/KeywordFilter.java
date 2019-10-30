package tagline.logic.commands.note;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KeywordFilter implements NoteFilter<String> {

    private final String keyword;
    private final List<String> filterValues;

    public KeywordFilter(String keyword) {
        this.keyword = keyword;
        filterValues = Arrays.asList(keyword.split(" "));
    }

    public List<String> getFilterValues() {
        return Collections.unmodifiableList(filterValues);
    }

    public FilterType getFilterType() {
        return FilterType.KEYWORD;
    }

    @Override
    public String toString() {
        return keyword;
    }
}
