package tagline.ui;

import java.util.ArrayList;
import java.util.List;

import tagline.logic.parser.Prompt;

/**
 * Handles the UI side of user prompts.
 */
public class PromptHandler {
    private boolean aborted = false;

    private String pendingCommand;
    private int nextIndex = 0;
    private List<Prompt> promptList = new ArrayList<>();
    private List<Prompt> filledPromptList = new ArrayList<>();

    public PromptHandler(String pendingCommand, List<Prompt> promptList) {
        this.pendingCommand = pendingCommand;
        this.promptList.addAll(promptList);
    }

    public String getPendingCommand() {
        return pendingCommand;
    }

    /**
     * Gets the filled prompt list.
     * Can only be called if all prompts have been filled.
     */
    public List<Prompt> getFilledPromptList() {
        assert isComplete();
        return filledPromptList;
    }

    /**
     * Fills the next unfilled prompt in the list with the user response.
     */
    public void fillNextPrompt(String userResponse) {
        assert nextIndex >= 0 && nextIndex < promptList.size();
        Prompt currentPrompt = promptList.get(nextIndex);
        currentPrompt.setPromptResponse(userResponse);

        nextIndex++;
        filledPromptList.add(currentPrompt);
    }

    /**
     * Returns the question for the next prompt in the list.
     */
    public String getNextPrompt() {
        assert nextIndex >= 0 && nextIndex < promptList.size();
        return promptList.get(nextIndex).getPromptQuestion();
    }

    /**
     * Returns true if all prompts are filled.
     */
    public boolean isComplete() {
        return nextIndex == promptList.size();
    }

    /**
     * Aborts the command.
     */
    public void setAborted() {
        aborted = true;
    }

    /**
     * Returns true if the command has been aborted.
     */
    public boolean isAborted() {
        return aborted;
    }
}
