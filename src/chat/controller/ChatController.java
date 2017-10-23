package chat.controller;

import chat.view.PopupDisplay;

public class ChatController 
{

	PopupDisplay display;
	
	public void start()
	{
		display = new PopupDisplay();
		display.displayText("I'm Invisible!");
	}
}
