package tagline.model.note;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.requireNonNull;
import static tagline.commons.util.AppUtil.checkArgument;

/**
 * Represents a Note's content in the note book.
 * Guarantees: immutable; is valid as declared in {@link #(String)}
 */
public class Date {

    public static final String MESSAGE_CONSTRAINTS = "TimeCreated can take any values, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */


    public final Instant date;
    public static ZoneId timezone = ZoneId.systemDefault();
    public static final DateTimeFormatter INPUT_TEST_FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
    public static final DateTimeFormatter HUMAN_READABLE_FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMM-yyyy, hh:mma");
            //DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mma");

    /**
     * Constructs an {@code TimeCreated}.
     *
     * @param date A valid content.
     */
    public Date(Instant date) {
        //use of Date an dinstant is inspired by Woemucat
        requireNonNull(date);
        this.date = date;
    }

    public Date(String dateString) {
        requireNonNull(dateString);
        this.date = (LocalDateTime.parse(dateString, INPUT_TEST_FORMATTER).atZone(timezone).toInstant());
        //this.date = Instant.now();
        //did not use this(LocalDateTime...toInstant()) since then i cannot use requireNonNull
    }

    @Override
    public String toString() {
        return date.atZone(timezone).format(HUMAN_READABLE_FORMATTER);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Date // instanceof handles nulls
                && date.equals(((Date) other).date)); // state check
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

}
