package gui;

import creatures.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

public class DndGUI extends Application{
	protected int[] stats;
	protected PC player;
	protected TextArea playerPrint;
	protected TextField txtStr;
	protected TextField txtDex;
	protected TextField txtCon;
	protected TextField txtInt;
	protected TextField txtWis;
	protected TextField txtCha;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			player = new PC("Bob");
			root.setLeft(statsBuilder());
			playerPrint = new TextArea(player.toString());
			root.setCenter(playerPrint);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public GridPane statsBuilder() {
		stats = player.getStats();
		GridPane gp = new GridPane();
		Label lbStr = new Label("Str");
		txtStr = new TextField(String.valueOf(stats[0]));
		Label lbDex = new Label("Dex");
		txtDex = new TextField(String.valueOf(stats[1]));
		Label lbCon = new Label("Con");
		txtCon = new TextField(String.valueOf(stats[2]));
		Label lbInt = new Label("Int");
		txtInt = new TextField(String.valueOf(stats[3]));
		Label lbWis = new Label("Wis");
		txtWis = new TextField(String.valueOf(stats[4]));
		Label lbCha = new Label("Cha");
		txtCha = new TextField(String.valueOf(stats[5]));
		
		Button setStats = new Button("Set");
		setStats.setOnAction(new SetStatsButtonHandler());
		
		Button resetStats = new Button("Reset");
		resetStats.setOnAction(new ResetStatsButtonHandler());
		
		gp.addRow(0, lbStr, txtStr);
		gp.addRow(1, lbDex, txtDex);
		gp.addRow(2, lbCon, txtCon);
		gp.addRow(3, lbInt, txtInt);
		gp.addRow(4, lbWis, txtWis);
		gp.addRow(5, lbCha, txtCha);
		gp.add(new HBox(setStats, resetStats), 1, 6);
		gp.setPrefWidth(150);;
		
		
		return gp;
	}
	
	private class SetStatsButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			stats[0] = Integer.parseInt(txtStr.getText());
			stats[1] = Integer.parseInt(txtDex.getText());
			stats[2] = Integer.parseInt(txtCon.getText());
			stats[3] = Integer.parseInt(txtInt.getText());
			stats[4] = Integer.parseInt(txtWis.getText());
			stats[5] = Integer.parseInt(txtCha.getText());
			player.setStats(stats);
			playerPrint.setText(player.toString());
		}
	}
	
	private class ResetStatsButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			txtStr.setText(String.valueOf(stats[0]));
			txtDex.setText(String.valueOf(stats[1]));
			txtCon.setText(String.valueOf(stats[2]));
			txtInt.setText(String.valueOf(stats[3]));
			txtWis.setText(String.valueOf(stats[4]));
			txtCha.setText(String.valueOf(stats[5]));
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}