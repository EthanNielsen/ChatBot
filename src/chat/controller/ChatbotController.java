package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;


public class ChatbotController 
{
	private Chatbot chatbot;
	private PopupDisplay display;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Ethan Nielsen");
		display = new PopupDisplay();
	}
	
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
		while (chatbot.lengthChecker(response) & !chatbot.quitChecker(response))
		{
			response = popupChat(response);
			response = display.collectResponse(response);
		}
	}
	
	public String interactWithChatot(String input)
	{
		String message = ("Hello");
		
		return message;
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	
	
	
}


