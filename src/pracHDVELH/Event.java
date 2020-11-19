/**
 * File: NodeMultipleEvents.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

import java.util.Scanner;

import myUtils.ErrorNaiveHandler;

/**
 * @author prost
 *
 */
public class Event extends NodeMultiple {
	public static final String ERROR_MSG_UNEXPECTED_END = "Sorry, for some unexpected reason the story ends here...";
	public static final String PROMPT_ANSWER = "Answer: ";
	public static final String WARNING_MSG_INTEGER_EXPECTED = "Please input a integer within range!";

	private String playerAnwser;
	private Scanner reader;
	private int ChosenPath;
	private GUIManager gui;
	private int id;

	private static int nodeIdIncr = -1;
	/**
	 * @return the playerAnswer
	 */
	public String getPlayerAnswer() {
		return playerAnwser;
	}

	/**
	 * @param playerAnswer the playerAnswer to set
	 */
	public void setPlayerAnswer(String playerAnswer) {
		this.playerAnwser = playerAnswer;
	}

	/**
	 * @return the reader
	 */
	public Scanner getReader() {
		return this.reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Scanner reader) {
		this.reader = reader;
	}

	/**
	 * @return the chosenPath
	 */
	public int getChosenPath() {
		return ChosenPath;
	}

	/**
	 * @param chosenPath the chosenPath to set
	 */
	public void setChosenPath(int chosenPath) {
		ChosenPath = chosenPath;
	}

	/* Methods */
	/**
	 * @see pracHDVELH.NodeMultiple#getData()
	 */
	public String getData() {
		return super.getData().toString();
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setData(Object)
	 * @param data
	 */
	public void setData(String data) {
		super.setData(data);
	}

	/**
	 * @see pracHDVELH.NodeMultiple#getDaughter(int)
	 */
	@Override
	public Event getDaughter(int i) {
		return (Event)super.getDaughter(i);
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setDaughter(NodeMultiple, int)
	 * @param daughter
	 * @param i
	 */
	public void setDaughter(Event daughter, int i) {
		super.setDaughter(daughter, i);
	}

	/**
	 * @return the gui
	 */
	public GUIManager getGui() {
		return gui;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(GUIManager gui) {
		this.gui = gui;
		setReader(gui.getInputReader());
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/* Methods */
	/* TO BE COMPLETED */
	public Event(GUIManager gui, String text) {
		setGui(gui);
		setData(text);
		this.id = ++nodeIdIncr;
	}

	private int interpretAnswer() {
		String playerAnwser = getPlayerAnswer();
		int path = Integer.parseInt(playerAnwser)-1;
		if (getDaughters().size()-1 > path) {
			getGui().outputln(WARNING_MSG_INTEGER_EXPECTED);
			run();
		}
		return path;
	}

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
}

// eof