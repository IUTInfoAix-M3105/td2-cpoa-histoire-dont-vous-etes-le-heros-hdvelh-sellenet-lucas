package pracHDVELH;

public class EventRandomSolution extends Event {
    private int[] mask;
    private String[] result;

    EventRandomSolution(GUIManager gui, String data, int[] mask, String... args) {
        super(gui, data);
        this.mask = mask;
        this.result = args;
    }
}
