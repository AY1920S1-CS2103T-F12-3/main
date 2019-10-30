package tagline.logic.parser.exceptions;

import static java.util.Objects.requireNonNull;

import java.util.List;

import tagline.logic.parser.Prompt;

/**
 * Represents a request for missing information from the user.
 */
public class PromptRequestException extends ParseException {
    private List<Prompt> requests;

    public PromptRequestException(List<Prompt> requests) {
        super("");
        requireNonNull(requests);
        this.requests = requests;
    }

    public List<Prompt> getPrompts() {
        return requests;
    }
}
