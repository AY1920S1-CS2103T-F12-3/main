package tagline.logic.parser;

import static tagline.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents a prompt requested by the parser for the user.
 */
public class Prompt {
    private final String argumentPrefix;
    private final String promptQuestion;
    private String promptResponse;

    public Prompt(String argumentPrefix, String promptQuestion) {
        requireAllNonNull(argumentPrefix, promptQuestion);
        this.argumentPrefix = argumentPrefix;
        this.promptQuestion = promptQuestion;
    }

    public String getPromptQuestion() {
        return promptQuestion;
    }

    public String getPromptResponse() {
        return promptResponse;
    }

    public String getArgumentPrefix() {
        return argumentPrefix;
    }

    public void setPromptResponse(String promptResponse) {
        this.promptResponse = promptResponse;
    }
}
