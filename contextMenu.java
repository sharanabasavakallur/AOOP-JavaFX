package application;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;

public class contextMenu extends Application {
	TextField tf;
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage myStage) {
		myStage.setTitle("Context Menu Demo");
		FlowPane rootNode = new FlowPane();
		Scene myScene = new Scene(rootNode,300,300);
		myStage.setScene(myScene);
		tf = new TextField();
		
		rootNode.setAlignment(Pos.CENTER);
		rootNode.getChildren().addAll(tf);
		
		Menu new1 = new Menu("New");
		
		MenuItem file = new MenuItem("File");
		MenuItem folder = new MenuItem("Folder");
		MenuItem image = new MenuItem("Image");
		
		new1.getItems().addAll(file,folder,image);
		
		Menu view = new Menu("View");
		
		MenuItem large = new MenuItem("Large");
		MenuItem medium = new MenuItem("Medium");
		MenuItem small = new MenuItem("Small");
		view.getItems().addAll(large,medium,small);
		
		final ContextMenu editMenu = new ContextMenu(new1,view);
		tf.setContextMenu(editMenu);
		myStage.show();
	}
}