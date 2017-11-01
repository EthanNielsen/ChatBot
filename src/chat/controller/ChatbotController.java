package chat.controller;

import chat.view.PopupDisplay;

public class ChatbotController 
{

	PopupDisplay display;
	
	public void start()
	{
		display = new PopupDisplay();
		display.displayText("I'm Invisible!");
	}
}
