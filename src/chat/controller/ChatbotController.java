package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;
import chat.view.ChatFrame;


/**
 * Manages the chatbot application including the model and frame of the View package.
 * @author Ethan Nielsen
 * @version 17.11.17 Added Frame and Panel
 */
public class ChatbotController 
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	/**
	 * Here is the constructor for ChatbotController
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Ethan Nielsen");
		//View initialized after Model
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	
	/**
	 * This asks the user what it wants to talk about and checks the answer if it was valid input.
	 */
	public void start()
	{
		display.displayText("Speak...");
		
//		while (chatbot.lengthChecker(response) & !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
	}
	
	
	/**
	 * Calls interactWithChatbot
	 * @param input grabs the users input.
	 * @return Returns the message they wrote in input.
	 */
	public String interactWithChatbot(String input)
	{
		String chatbotSays = ("Hello ");
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	
	private void close()
	{
		display.displayText("Cya");
		System.exit(0);
	}
	
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	
	/**
	 * Calls the getChatbot method and returns "chatbot".
	 */
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
	
	/**
	 * Calls the getDisplay method
	 * @return I returns the "display"
	 */
	public PopupDisplay getDisplay()
	{
		return display;
	}
	
	
	/**
	 * This method calls getChatFrame
	 * @return It returns the "appFrame".
	 */
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
	
//	public String prossesCheckers()
//	{
//		
//	}
//	
}


