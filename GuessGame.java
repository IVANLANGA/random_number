import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.*;
import java.util.*;

public class GuessGame extends Application 
{
    //to generate random number
    Random random = new Random();
    public int randomNumber;
    int count =1;
    //launch args
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) 
    {
        //set objects I will use
        Button randomButton = new Button("Random Number");
        randomButton.setPrefSize(140, 35);
        randomButton.setLayoutX(80); 
        randomButton.setLayoutY(50);
        
        Button checkMatch = new Button("Check match");
        checkMatch.setPrefSize(150, 30);
        checkMatch.setLayoutX(80); 
        checkMatch.setLayoutY(140);
        
        Button clearAll = new Button("Clear all components");
        clearAll.setPrefSize(180, 30);
        clearAll.setLayoutX(80); 
        clearAll.setLayoutY(560);
           
        Button quitGame = new Button("Quit Game");
        quitGame.setPrefSize(150, 30);
        quitGame.setLayoutX(300); 
        quitGame.setLayoutY(560);
        
        Label enter = new Label("Enter a number:");
        enter.setLayoutX(80); 
        enter.setLayoutY(100);
        
        TextField enterNumber = new TextField();
        enterNumber.setLayoutX(200); 
        enterNumber.setLayoutY(100);
        
        TextArea outputData = new TextArea();
        outputData.setLayoutX(80); 
        outputData.setLayoutY(230); 
        outputData.setPrefSize(600, 300);
       
        
       Pane root = new Pane(randomButton,enter,enterNumber,checkMatch,outputData,clearAll,quitGame);
       Scene scene = new Scene(root, 1000, 600);
       primaryStage.setScene(scene);
       primaryStage.setTitle("Guess game");
       primaryStage.show();

        randomButton.setOnAction(e ->
        {
            //random number generated upon button click
            randomNumber = random.nextInt(10)+1;
            outputData.clear();
            enterNumber.clear();
            outputData.appendText("The random number is generated,now guess the number\n");
        });
        
        checkMatch.setOnAction(e ->
        {
            String input = enterNumber.getText();
            int guessNumber = Integer.parseInt(input);
            if (guessNumber == randomNumber)
            {
                outputData.appendText("Your guess is correct. !Congradulations, you win\n");
                outputData.appendText("Number of guesses: " + count);
            } else
            
            {
                if (guessNumber < randomNumber)
                {
                    outputData.appendText("Your guess is " + guessNumber + " - guess is too low\n");
                } else
                {
                    outputData.appendText("Your guess is " + guessNumber + " - gies is too high\n");
                }
                count++;
            }
            enterNumber.clear();
        });
        
        quitGame.setOnAction(e -> 
        {
            //quite game
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("Good bye");
        alert.showAndWait();

        Platform.exit(); 
        
        });
        
        clearAll.setOnAction( e->
        {
            outputData.clear();
            enterNumber.clear();
        });
        
        
    }
}
