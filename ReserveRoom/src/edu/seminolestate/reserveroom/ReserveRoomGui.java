// Written by Toni Huffman
// 4/26/2017

package edu.seminolestate.reserveroom;

import java.text.NumberFormat;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ReserveRoomGui extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		NumberFormat currFormatter = NumberFormat.getCurrencyInstance();

		// Create Controls
		TextField txtName = new TextField();
		TextField txtNights = new TextField();
		ComboBox<String> cboRoomType = new ComboBox<>();
		CheckBox chkBreakfast = new CheckBox();
		CheckBox chkSmoking = new CheckBox();
		Label lblTotalLabel = new Label("Total amount owed: $0.00");
		Button btnReserve = new Button("Reserve");
		Button btnExit = new Button("Exit");

		// Add room types to a ComboBox
		String[] roomTypes = Reservation.getAllRoomTypes();
		ObservableList<String> roomTypeList = FXCollections.observableArrayList(roomTypes);
		cboRoomType.getItems().addAll(roomTypeList);
		cboRoomType.setValue(roomTypes[0]);


		// Create Container Pane
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10));
		flowPane.setHgap(5);
		flowPane.setVgap(10);

		// Add Controls to Container Pane
		flowPane.getChildren().addAll(new Label("Name"),txtName);
		flowPane.getChildren().addAll(new Label("Number of Nights"),txtNights);
		txtNights.setMaxWidth(50);
		flowPane.getChildren().addAll(new Label("Room Type"),cboRoomType);


		// Lay out Checkboxes
		GridPane gridPane = new GridPane();
		gridPane.add(chkBreakfast, 0, 0);
		gridPane.add(new Label("Breakfast Pkg? (" + currFormatter.format(Reservation.BREAKFAST_PKG_RATE) + " per day)"), 1, 0);
		gridPane.add(chkSmoking, 0, 1);
		gridPane.add(new Label("Smoking Room? (" + currFormatter.format(Reservation.SMOKING_RATE) + " per day)"), 1, 1);
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		// Add checkboxes to container pane
		flowPane.getChildren().add(gridPane);

		flowPane.getChildren().add(lblTotalLabel);

		// Lay out Buttons
		FlowPane buttonPane = new FlowPane(10,10);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setMaxWidth(200);
		buttonPane.getChildren().addAll(btnReserve,btnExit);
		// Add buttons to container pane
		flowPane.getChildren().add(buttonPane);


		// Process Events
		btnReserve.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String guestName;
				int intRoomType = 0;
				int numNights = 0;
				boolean isBreakfast = false;
				boolean isSmoking = false;

				// Get and edit Name
				guestName = txtName.getText();

				if (guestName.isEmpty()) {
					guestName = "No name supplied";
					txtName.setText(guestName);
				}

				// Get and edit number of nights
				try {
					numNights = Integer.parseInt(txtNights.getText());
					if (numNights <= 0) {
						numNights = 1;
						txtNights.setText(String.valueOf(numNights));
					}
				} catch (NumberFormatException e) {
					numNights = 1;
					txtNights.setText(String.valueOf(numNights));
				}


				// Get Room Type
				intRoomType = roomTypeList.indexOf(cboRoomType.getValue());

				// Get Breakfast Option
				if (chkBreakfast.isSelected()) {
					isBreakfast = true;
				}

				// Get Smoking Option
				if (chkSmoking.isSelected()) {
					isSmoking = true;
				}

				// Try to Create Reservation
				try {
					Reservation res1 = new Reservation(intRoomType, guestName, numNights, isSmoking, isBreakfast);
					lblTotalLabel.setText("Total amount owed: " + currFormatter.format(res1.getAmountDue()));
				} catch (Exception e) {
					lblTotalLabel.setText("ERROR: " + e.getMessage());
				}
			}
		});


		// Exit Button
		btnExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Exit the application
				System.exit(-1);

			}
		});


		// Create the Scene object. Add the Pane to the Scene
		Scene scene = new Scene(flowPane, 250, 270);

		// Add the Scene to the Stage
		primaryStage.setScene(scene);

		// Showtime!
		primaryStage.show();
		primaryStage.setTitle("Reserve Room");


	}

	public static void main(String[] args) {
		launch(args);

	}

}
