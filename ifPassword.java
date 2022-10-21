package application;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class ifPassword extends Application{
	String userId="sharan";
	String passwd="123456";
	TextField name,password;
	Button validate,goback;
	Label response1,response2;
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage myStage)throws MyException{
		myStage.setTitle("validating UserId and Password");
		FlowPane rootNode1=new FlowPane(Orientation.VERTICAL,10,20);
		FlowPane rootNode2=new FlowPane(Orientation.VERTICAL,10,20);
		rootNode1.setAlignment(Pos.CENTER);
		rootNode2.setAlignment(Pos.CENTER);
		Scene myScene=new Scene(rootNode1,450,200);
		myStage.setScene(myScene);
		Scene myScene2=new Scene(rootNode2,450,200);
		
		name=new TextField();
		name.setPromptText("enter your name");
		
		password=new TextField();
		password.setPromptText("enter your password");
		
		validate=new Button("Validate");
		goback=new Button("Go back");
		
		response1=new Label();
		response2=new Label();
		
		Separator separator=new Separator();
		separator.setPrefWidth(100);
		
		validate.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				try {
					if(name.getText().equals(userId)&&password.getText().equals(passwd)) {
						myStage.setScene(myScene2);
						response2.setText("WELCOME HERE");
				   }
					else
						throw new MyException();
			       }
				catch(MyException e) {
				response1.setText(e.toString());
				}
		}
		});
		
		goback.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myStage.setScene(myScene);
				
			}
		});
		
		rootNode1.getChildren().addAll(name,password,separator,validate,response1);
		rootNode2.getChildren().addAll(goback,response2);
		
		myStage.show();
		
			}

}

class MyException extends Exception{
	public String toString() {
		return "invalid UserId or Password Please try again..!";
	}
}