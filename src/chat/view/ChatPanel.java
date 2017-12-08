package chat.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 * 
 * @author enie1762
 *
 */
public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	//Need a data member for the scrollpane
	private JScrollPane chatScrollPane;
	
	/**
	 * Here is the constructor for ChatPanel, I have defined GUI data members in here.
	 * @param appController Links the appController into the Panel
	 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		//Initialize GUI data members
		chatButton = new JButton("speak");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		infoLabel = new JLabel("Speak Here...");
		chatScrollPane = new JScrollPane();
		checkerButton = new JButton("check");
		
		//call new helper method
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * This sets up the Panel into the number of components I want. I also changed the color.
	 */
	
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	/**
	 * The startup for my buttons, Layouts, backgrounds, etc... are created here.
	 */
	private void setupPanel()
	{
		this.setBackground(Color.ORANGE);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatScrollPane);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		this.add(checkerButton);
	}
	
	/**
	 * This is a dumping ground for GUI, "appLayout.putConstraint(....);"
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -41, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 0, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -6, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 25, SpringLayout.WEST, this);
	}

	/**
	 * When you click the "speak" button it returns the input and calls the methods to create an answer.
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
					String userText = inputField.getText();
					String displayText = appController.interactWithChatbot(userText);
					chatArea.append(displayText);
					inputField.setText("");
			}
		});
		
		checkerButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
				
			}
		});
	}
}
