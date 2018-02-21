package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.model.CTECTwitter;


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
	private CTECTwitter myTwitter;
	
	/**
	 * Here is the constructor for ChatbotController
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Ethan Nielsen");
		myTwitter = new CTECTwitter(this);
		//View initialized after Model
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
		
//		display = new Array<String>();
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
	
	/**
	 * This is the closeing statement when you exit out.
	 */
	private void close()
	{
		display.displayText("Cya");
		System.exit(0);
	}
	
	/**
	 * Returns the input of the user.
	 * @param chat 
	 * @return Returns the string from chatbotSays.
	 */
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	/**
	 * Checks to see if a special word "text" was imputed.
	 * @param text Defines what is inside the lists / arrays.
	 * @return Returns the special response.
	 */
	public String useCheckers(String text)
	{
		String response = "";
		
		if (chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "";
		}
		//continue will all checkers except length and quit checker.
		
		return response;
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
	
	public void  handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
}


