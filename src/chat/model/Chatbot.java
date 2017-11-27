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
		this.followUps = new String [3];
		
		buildVerbs();
		buildTopics();
		buildFollowups();
		buildQuestions();
		buildShoppingList();
		buildMovieList();
		buildCuteAnimals();
	} // This is the end of the constructor. 
	
	private void buildVerbs() // used by "new String[4];"
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	private void buildTopics() // used by "new String[4];"
	{
		topics[0] = "Race Cars";
		topics[1] = "Space Bars";
		topics[2] = "Politics";
		topics[3] = "Music";
				
	}
	
	private void buildFollowups() // used by "new String[3];"
	{
		followUps[0] = "What are you like?";
		followUps[1] = "Whats your favorite color?";
		followUps[2] = "How was your day?";
		
	}
	
	
	private void buildMovieList() // used by "new ArrayList<Movie>();"
	{
		movieList.add(new Movie("Spiderman"));
		movieList.add(new Movie("Lord Of The Rings"));
		movieList.add(new Movie("Pluto Nash in 3D"));
		movieList.add(new Movie("The Emoji Movie"));
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("gross things");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pepe");
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("floofer");
	}
	
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
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		boolean nameCheck = false;
		
		for(input)
		
		
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
			if(shoppingList.contains(shoppingItem))
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
