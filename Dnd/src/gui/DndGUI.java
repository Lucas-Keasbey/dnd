package gui;

import creatures.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class DndGUI extends Application{
	protected int[] stats;
	protected PC player;
	protected TextArea playerPrint;
	protected TextField txtStr, txtDex, txtCon, txtInt, txtWis, txtCha;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			player = new PC("Bob", new Fighter());
			stats = player.getStats();
			root.setLeft(statsBuilder());
			playerPrint = new TextArea(player.toString());
			playerPrint.setEditable(false);
			root.setCenter(playerPrint);
			Button btnRollStats = new Button("Roll Stats");
			btnRollStats.setOnAction(new RollStatsHandler());
			root.setTop(btnRollStats);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Dnd Player Character");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public GridPane statsBuilder() {
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
	
	private void resetFields() {
		txtStr.setText(String.valueOf(stats[0]));
		txtDex.setText(String.valueOf(stats[1]));
		txtCon.setText(String.valueOf(stats[2]));
		txtInt.setText(String.valueOf(stats[3]));
		txtWis.setText(String.valueOf(stats[4]));
		txtCha.setText(String.valueOf(stats[5]));
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
			resetFields();
		}
	}
	
	private class RollStatsHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			player.rollStats();
			stats = player.getStats();
			resetFields();
			playerPrint.setText(player.toString());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
