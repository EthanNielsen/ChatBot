package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username) // This is the constructor I defined my data values in here
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String[4];
		this.username = username;
		this.content = "";
		this.intro = "";
		this.currentTime = LocalTime.now();
		this.topics = new String[4];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildTopics();
		buildFollowups();
		buildQuestions();
		buildShoppingList();
		buildMovieList();
		buildCuteAnimals();
	} // This is the end of the constructor. 
	
	/**
	 * Builds verbs that chatbot could say.
	 */
	private void buildVerbs() // used by "new String[4];"
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	/**
	 * Builds topics that chatbot could say.
	 */
	private void buildTopics() // used by "new String[4];"
	{
		topics[0] = "Race Cars";
		topics[1] = "Space Bars";
		topics[2] = "Politics";
		topics[3] = "Music";		
	}
	
	/**
	 * Builds the followup questions that could be asked by chatbot.
	 */
	private void buildFollowups() // used by "new String[5];"
	{
		followUps[0] = "What are you like?";
		followUps[1] = "Whats your favorite color?";
		followUps[2] = "How was your day?";
		followUps[3] = "Whats your social security number?";
		followUps[4] = "Is this the real world?";
	}
	
	/**
	 * Builds Movies that chatbot could say.
	 */
	private void buildMovieList() // used by "new ArrayList<Movie>();"
	{
		movieList.add(new Movie("Spiderman"));
		movieList.add(new Movie("Lord Of The Rings"));
		movieList.add(new Movie("Pluto Nash in 3D"));
		movieList.add(new Movie("The Emoji Movie"));
	}
	
	/**
	 * Builds the shopping list.
	 */
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("eggs");
		shoppingList.add("hot peppers");
		shoppingList.add("onions");
		shoppingList.add("snacks");
		shoppingList.add("bagel");
		shoppingList.add("crunchy peanut butter");
		shoppingList.add("hot sauce");
		shoppingList.add("juice");
	}
	
	/**
	 * Builds the Cute Animals. 
	 */
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pepe");
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("floofer");
	}
	
	/**
	 * Builds questions that can also be asked by chatbot.
	 */
	private void buildQuestions()
	{
		questions[0] = "What are your thoughts on presipitation?";
		questions[1] = "Do u Like my car?";
		questions[2] = "What is the meaning of life?";
		questions[3] = "What is your real name?";
 	}
	
//	/**
//	 * At least a full sentence about what and how a method operates.
//	 * @param input Explanation of the parameter
//	 * @return  full sentence that details what is returned.
//	 */

	/**
	 * The processConversation processes the response and returns it in a response.
	 * @param input Collects data in a String type.
	 * @return The chatbotResponse is what is returned (Basically what was typed is returned with a "You Said..")
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		currentTime = LocalTime.now();
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " ";
		chatbotResponse += "You said;" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 * This method chooses what response is going to be given.
	 * Uses integers to choose certain topics. (random numbers and arrays).
	 * @return It builds a response with the random number generators and returns a random question.
	 */ 
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "/n" + movieList.get(random).getTitle() + " is a great movie!";
		}
		
		int followup = (int) (Math.random() * 5);
		
		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		return response;
	}
	
	/**
	 * Makes sure that the input isn't null and that it is greater than 2 values.
	 * @param input This input is checked to see if it matches the requirements.
	 * @return If the input passes the test than return their response.
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2)
		{
				validLength = true;
		}
		
		return validLength;
	}
	
	/**
	 * Checks to see if the HTML format is correct.
	 * @param input Is the users response
	 * @return returns "containsHTML" meaning that the HTML was correct.
	 */
	public boolean htmlTagChecker(String input)
	{
		boolean containsHTML = false;
		if(input == null && !input.contains("<"))
		{
			return containsHTML;
		}
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf(">", firstOpen);
		int secondOpen = -9;
		int secondClose = -9;
		String tagText = "";
		
		//Check bad tags
		if(input.contains("<>") && input.indexOf("< >") > -1)
		{
			containsHTML = false;
		}
		//Check singleton
		if(input.toUpperCase().contains("<P>") && input.toLowerCase().contains("<br>"))
		{
			containsHTML = true;
		}
		//Check others
		else if(firstClose > firstOpen)
		{
			//Others
			tagText = input.substring(firstOpen +1, firstClose).toLowerCase();
			secondOpen = input.toLowerCase().indexOf("</" + tagText, firstClose);
		}
		return containsHTML;
	}
		
		
		
	// This is code I tried to make to solve HTMLTagChecker.
//		if(!input.contains("<") && !input.contains(">") && !input.contains("</"))
//		{
//			return false;
//		}
//		
//		else if(input.contains("<>"))
//		{
//			return false;
//		}
//		
//		return input;
//		
//		int firstBracketPosition = input.indexOf("<");
//		int secondBracketPosition = input.indexOf(">");
//		
//		if(firstBracketPosition != -1 && secondBracketPosition != -1)
//		{
//			tagText = input.substring(0, secondBracketPosition +1);
//			return false;
//		}	
//	}
	
	/**
	 * Checks to see if the user name has correct parameters.
	 * @param input User input
	 * @return return nameCheck if it passes the tests. 
	 */
	// WORK ON THIS.....
	public boolean userNameChecker(String input)
	{
		boolean nameCheck = false;
		
		if (username.contains("@"))
		{
			return true;
		}
//		else if (username.indexOf(0) == "@")
//		{
//			return true;
//		}
		
		return nameCheck;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
	
		
		return true;
	}
	/**
	 * This checks the shopping List and sees if it has all the specific items.
	 * @param shoppingItem Links to the Shopping List items.
	 * @return Returns true if if shopping list items are there but if not then return false.
	 */
	public boolean shoppingListChecker(String shoppingItem)
	{
		for (int index = 0; index < shoppingList.size(); index++)
		{			
			if(shoppingItem.contains(shoppingList.get(index)))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	/**
	 * Allows you to exit the app
	 * @param exitString 
	 * @return
	 */
	public boolean quitChecker(String exitString)
	{
		boolean quit = false;
		
		if (exitString != (null) && exitString.equalsIgnoreCase("quit"))
		{
			quit = true;
		}
		return quit;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return null;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
