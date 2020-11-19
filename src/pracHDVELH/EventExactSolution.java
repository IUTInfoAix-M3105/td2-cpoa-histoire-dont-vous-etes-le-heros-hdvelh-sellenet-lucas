package pracHDVELH;

public class EventExactSolution extends Event {
    private String AnswerExpected;

    public String getAnwserExpected() {
        return AnswerExpected;
    }
    public void setAnwserExpected(String anwserExpected) {
        AnswerExpected = anwserExpected;
    }

    private int interpretAnswer() {
        if (getAnwserExpected().equals(getPlayerAnswer().toString())) {
            return 0;
        }
        return -1;
    }

    @Override
    public Event run() {
        getGui().outputln(this.toString());
        getGui().output(PROMPT_ANSWER);
        setPlayerAnswer(getReader().next());
        int path = interpretAnswer();
        while (path == -1) {
            return run();
        }
        setChosenPath(path);
        return getDaughter(getChosenPath());
    }

    EventExactSolution(GUIManager gui, String data, String answer) {
        super(gui, data);
        setAnwserExpected(answer);
    }
}
