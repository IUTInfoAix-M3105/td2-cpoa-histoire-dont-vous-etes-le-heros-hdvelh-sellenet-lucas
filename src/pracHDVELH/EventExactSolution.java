package pracHDVELH;

public class EventExactSolution extends Event {
    private String AnwserExpected;

    public String getAnwserExpected() {
        return AnwserExpected;
    }
    public void setAnwserExpected(String anwserExpected) {
        AnwserExpected = anwserExpected;
    }

    EventExactSolution(GUIManager gui, String data, String anwser) {
        super(gui, data);
        setAnwserExpected(anwser);
    }
}
