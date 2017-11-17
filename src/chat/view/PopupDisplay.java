package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PopupDisplay 
{
	private ImageIcon icon;
	private String windowTitle;
	
	/**
	 * Creates a Image when the app popups.
	 */
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/chatbot.png"));
		windowTitle = "Chatot says";
	}
	
	/**
	 * 
	 * @param message 
	 */
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	/**
	 * This creates an answer when the user creates input.
	 * @param question Is the question asked by the chatbot
	 * @return Returns the answer created from the line of code.
	 */
	public String collectResponse(String question)
	{
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		
		return answer;
	}
}
