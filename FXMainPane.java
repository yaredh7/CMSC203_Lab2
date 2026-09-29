import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 * This panel is the basic panel, inside which other panels are placed.
 * Before beginning to implement, design the structure of your GUI in order to
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	
	Button helloButton;
	Button howdyButton;
	Button chineseButton;
	Button clearButton;
	Button exitButton;

	Label feedbackLabel;
	TextField feedbackField;

	HBox buttonBox;
	HBox feedbackBox;

	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		helloButton = new Button("Hello");
		howdyButton = new Button("Howdy");
		chineseButton = new Button("Chinese");
		clearButton = new Button("Clear");
		exitButton = new Button("Exit");

		feedbackLabel = new Label("Feedback:");
		feedbackField = new TextField();

		buttonBox = new HBox();
		feedbackBox = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		Insets inset = new Insets(10);

		HBox.setMargin(helloButton, inset);
		HBox.setMargin(howdyButton, inset);
		HBox.setMargin(chineseButton, inset);
		HBox.setMargin(clearButton, inset);
		HBox.setMargin(exitButton, inset);

		HBox.setMargin(feedbackLabel, inset);
		HBox.setMargin(feedbackField, inset);

		buttonBox.setAlignment(Pos.CENTER);
		feedbackBox.setAlignment(Pos.CENTER);
		
		helloButton.setOnAction(new ButtonHandler());
		howdyButton.setOnAction(new ButtonHandler());
		chineseButton.setOnAction(new ButtonHandler());
		clearButton.setOnAction(new ButtonHandler());
		exitButton.setOnAction(new ButtonHandler());

		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		feedbackBox.getChildren().addAll(feedbackLabel, feedbackField);
		
		//  add the buttons to the other HBox
		buttonBox.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);

		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(feedbackBox, buttonBox);

	}

	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

	    @Override
	    public void handle(ActionEvent event) {

	        if (event.getTarget() == helloButton) {
	            feedbackField.setText(dataManager.getHello());

	        } else if (event.getTarget() == howdyButton) {
	            feedbackField.setText(dataManager.getHowdy());

	        } else if (event.getTarget() == chineseButton) {
	            feedbackField.setText(dataManager.getChinese());

	        } else if (event.getTarget() == clearButton) {
	            feedbackField.setText("");

	        } else if (event.getTarget() == exitButton) {
	            Platform.exit();
	            System.exit(0);
	        }
	    }
	}
}

