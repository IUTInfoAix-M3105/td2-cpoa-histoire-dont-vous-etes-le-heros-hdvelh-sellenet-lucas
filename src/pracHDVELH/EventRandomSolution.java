package pracHDVELH;

public class EventRandomSolution extends Event {
    private int[] mask;
    private String[] result;

    private int interpretAnswer() {
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

    EventRandomSolution(GUIManager gui, String data, int[] mask, String... args) {
        super(gui, data);
        this.mask = mask;
        this.result = args;
    }
}
