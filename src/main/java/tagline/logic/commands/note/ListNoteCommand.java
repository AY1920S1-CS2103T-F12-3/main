package tagline.logic.commands.note;

import static java.util.Objects.requireNonNull;

import tagline.logic.commands.CommandResult;
import tagline.model.Model;

/**
 * Lists all contacts in the address book to the user.
 */
public class ListNoteCommand extends NoteCommand {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all notes";

    private final Filter filter;

    /**
     * @param filter to list notes by
     */
    public ListNoteCommand(Filter filter) {
        this.filter = filter;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        if (filter == null) {
            /* TO ADD LOGIC WHEN MODEL MANAGER DONE */
            return new CommandResult(MESSAGE_SUCCESS);
        } else {
            return new CommandResult("Listed notes for keyword: " + filter.getFilterValue());
        }
    }

    /**
     * Stores filter for note listing.
     */
    public static class Filter {
        /**
         * Represents the type of filter to list notes by.
         */
        public enum FilterType {
            KEYWORD
        }

        private final String filterValue;
        private final FilterType filterType;

        public Filter(String filterValue, FilterType filterType) {
            this.filterValue = filterValue;
            this.filterType = filterType;
        }

        public String getFilterValue() {
            return filterValue;
        }

        public FilterType getFilterType() {
            return filterType;
        }
    }
}
