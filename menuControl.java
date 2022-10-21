package application;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.event.*;

public class menuControl extends Application {
Label response;

	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage myStage) {
		myStage.setTitle("Menu Demo");
		BorderPane rootNode = new BorderPane();
		Scene myScene = new Scene(rootNode,300,300);
		myStage.setScene(myScene);
		
		response = new Label("");
		MenuBar mb = new MenuBar();
		
		Menu fileMenu = new Menu("_File");
		
		MenuItem new1 = new MenuItem("New");
		MenuItem open = new MenuItem("Open");
		MenuItem save = new MenuItem("Save");
		new1.setAccelerator(KeyCombination.keyCombination("shortcut+N"));
		open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
		save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
		fileMenu.setMnemonicParsing(true);
		
		fileMenu.getItems().addAll(new1,open,save);
		
		Menu edit = new Menu("_Edit");
		
		MenuItem cut = new MenuItem("Cut");
		MenuItem copy = new MenuItem("Copy");
		MenuItem paste = new MenuItem("Paste");
		cut.setAccelerator(KeyCombination.keyCombination("shortcut+X"));
		copy.setAccelerator(KeyCombination.keyCombination("shortcut+C"));
		paste.setAccelerator(KeyCombination.keyCombination("shortcut+V"));
		edit.setMnemonicParsing(true);
		
		edit.getItems().addAll(cut,copy,paste);
		
		Menu help = new Menu("_About");
		
		MenuItem helpCenter = new MenuItem("Help Center");
		MenuItem about = new MenuItem("About Us");
		helpCenter.setAccelerator(KeyCombination.keyCombination("shortcut+H"));
		about.setAccelerator(KeyCombination.keyCombination("shortcut+B"));
		help.setMnemonicParsing(true);
		
		help.getItems().addAll(helpCenter,about);
		
		mb.getMenus().addAll(fileMenu,edit,help);
		
		EventHandler<ActionEvent> MEHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String name = ((MenuItem) ae.getTarget()).getText();
				response.setText(name + " selected");
			}
		};
		new1.setOnAction(MEHandler);
		open.setOnAction(MEHandler);
		save.setOnAction(MEHandler);
		cut.setOnAction(MEHandler);
		copy.setOnAction(MEHandler);
		paste.setOnAction(MEHandler);
		helpCenter.setOnAction(MEHandler);
		about.setOnAction(MEHandler);
		rootNode.setTop(mb);
		rootNode.setCenter(response);
		myStage.show();
	}
}