package chat.model;

import java.io.File;
import java.util.List;

import chat.controller.ChatbotController;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.GeoLocation;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;

import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class CTECTwitter 
{
	private ChatbotController appController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTweets;
	private List<String> tweetedWords;
	private long totalWordCount;
	
	public CTECTwitter(ChatbotController appController)
	{
		this.appController = appController;
		this.chatbotTwitter = TwitterFactory.getSingleton();
	}
	

	public void sendTweet(String textToTweet)
	{
		try
		{
			chatbotTwitter.updateStatus(textToTweet + " @ChatbotCTEC");
		}
		catch(TwitterException tweetError)
		{
			appController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			appController.handleErrors(otherError);
		}
	}
	
	public String getMostCommonWord(String username)
	{
		String mostCommon = "";
		
		collectTweets(username);
		turnStatusesToWords();
		totalWordCount = tweetedWords.size();
		String [] boring = createIgnoredWordArray();
		trimTheBoringWords(boring);
		
		return mostCommon;
	}

	private void collectTweets(String username)
	{
		searchedTweets.clear();
		tweetedWords.clear();
		
		Paging statusPage = new Paging(1,100);
		int page = 1;
		long lastID = Long.MAX_VALUE;
		
		while(page <= 10)
		{
			statusPage.setPage(page);
			try
			{
				ResponseList<Status> listedTweets = chatbotTwitter.getUserTimeline(username, statusPage);
				for(Status current : listedTweets)
				{
					if(current.getId() < lastID)
					{
						searchedTweets.add(current);
						lastID = current.getId();
					}
				}
			}
			catch(TwitterException searchTweetError)
			{
				appController.handleErrors(searchTweetError);
			}
			page++;
		}
	}
	
	private void turnStatusesToWords()
	{
		for(Status currentStatus : searchedTweets)
		{
			String tweetText = currentStatus.getText();
			String [] tweetWords = tweetText.split(" ");
			for(int index = 0; index < tweetWords.length; index++)
			{
				tweetedWords.add(removePunctuation(tweetWords[index]).trim());
			}
		}
	}
	
	private String removePunctuation(String currentString)
	{
		
	}

	private String [] createIgnoredWordArray()
	{
		
	}
	
	private void trimTheBoringWords(String [] boringWords)
	{
		for (int index = tweetedWords.size() - 1; index >= 0; index--)
		{
			for (int removeIndex = 0; removeIndex < boringWords.length; removeIndex++)
			{
				if (tweetedWords.get(index).equals(boringWords[removeIndex]))
				{
					tweetedWords.remove(index);
					removeIndex = boringWords.length;
				}
			}
		}
	}
}
