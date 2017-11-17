package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPanel;
	
	/**
	 * This is the constructor, it holds all my defined variables. The controller has defined the appController and appPanel.
	 * @param appController Links the Panel, Frame, and Controller.
	 */
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		
		setupFrame();
	}
	
	/**
	 * This method calls the getBaseController.
	 * @return when "getBaseController" return the "appController".
	 */
	public ChatbotController getBaseController()
	{
		return appController;
	}
	
	/**
	 * The setupFrame creates the frame needed to put GUI code into.
	 */
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("After nine years in development hopefully Chatbot will be worth the wait.");
		this.setResizable(false);
		this.setSize(600, 600);
		this.setVisible(true);
	}
}
