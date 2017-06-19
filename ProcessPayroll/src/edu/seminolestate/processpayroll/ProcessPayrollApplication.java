// Written by Toni Huffman
// 4-19-2017

package edu.seminolestate.processpayroll;

import java.text.NumberFormat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProcessPayrollApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create Controls
		TextField txtEmployeeName = new TextField();
		TextField txtHoursWorked = new TextField();
		TextField txtHourlyPay = new TextField();
		Label lblGrossPay = new Label();
		Label lblTaxes = new Label();
		Label lblNetPay = new Label();
		Button btnCalculate = new Button("Calculate");
		Button btnClear = new Button("Clear");
		Button btnExit = new Button("Exit");

		// Create Panes

		// BorderPane for Container
		BorderPane borderPane = new BorderPane();
		// GridPane for Center
		GridPane gridPane = new GridPane();
		// FlowPane for Bottom
		FlowPane flowPane = new FlowPane();

		// Add Controls to Panes

		// Set up BorderPane Container
		borderPane.setCenter(gridPane);
		borderPane.setBottom(flowPane);
		borderPane.setPadding(new Insets(10));

		// Set up GridPane for Form
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.add(new Label("Employee name: "), 0, 0);
		gridPane.add(txtEmployeeName, 1, 0);
		gridPane.add(new Label("Hours worked: "), 0, 1);
		gridPane.add(txtHoursWorked, 1, 1);
		gridPane.add(new Label("Hourly pay rate: "), 0, 2);
		gridPane.add(txtHourlyPay, 1, 2);
		gridPane.add(new Label("Gross pay: "), 0, 3);
		gridPane.add(lblGrossPay, 1, 3);
		gridPane.add(new Label("Taxes: "), 0, 4);
		gridPane.add(lblTaxes, 1, 4);
		gridPane.add(new Label("Net pay: "), 0, 5);
		gridPane.add(lblNetPay, 1, 5);

		// Set up FlowPane for Buttons
		flowPane.getChildren().addAll(btnCalculate,btnClear,btnExit);
		flowPane.setHgap(10);
		flowPane.setVgap(10);
		flowPane.setAlignment(Pos.CENTER);

		// Process Events

		// Calculate Button
		btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Set up variables
				String strEmpName = "";
				double dblHoursWorked = 0;
				double dblPayRate = 0;

				// Clear Existing Output
				lblGrossPay.setText("");
				lblNetPay.setText("");
				lblTaxes.setText("");

				// Check User Input
				boolean isValid = true;

				// Process Employee Name
				if (txtEmployeeName.getText().isEmpty()) {
					// Set default if box is empty
					strEmpName = "No name entered";
					txtEmployeeName.setText(strEmpName);
				} else {
					strEmpName = txtEmployeeName.getText();
				}

				// Process Hours Worked
				try {
					dblHoursWorked = Double.parseDouble(txtHoursWorked.getText());
					if (dblHoursWorked <= 0) {
						// Make sure it's greater than 0
						isValid = false;
						txtHoursWorked.setText("Hours must be > 0");
					}
				} catch (Exception e) {
					// Catch exception if user types non-numeric characters
					isValid = false;
					txtHoursWorked.setText("Hours must be numeric");
				}

				// Process Hourly Rate
				try {
					dblPayRate = Double.parseDouble(txtHourlyPay.getText());
					if (dblPayRate <= 0) {
						// Make sure it's greater than 0
						isValid = false;
						txtHourlyPay.setText("Rate must be > 0");
					}

				} catch (NumberFormatException e) {
					// Catch exception if user types non-numeric characters
					isValid = false;
					txtHourlyPay.setText("Rate must be numeric");
				}



				// If input is valid, try to create Object
				if (isValid) {
					try {
						HourlyEmployee employee = new HourlyEmployee(strEmpName, dblHoursWorked, dblPayRate);
						NumberFormat currFormatter = NumberFormat.getCurrencyInstance();

						// Calculate Amounts and Update Labels, format as currency
						lblGrossPay.setText(currFormatter.format(employee.computeGrossPay()));
						lblTaxes.setText(currFormatter.format(employee.computeTaxAmount()));
						lblNetPay.setText(currFormatter.format(employee.computeNetPay()));

					} catch (IllegalArgumentException e) {
						// Shouldn't happen, but catch error if object cannot be created
						lblGrossPay.setText("Error: Could not calculate.");
					}
				}
			}
		});

		// Clear Button
		btnClear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Clear text and label fields
				txtEmployeeName.setText("");
				txtHoursWorked.setText("");
				txtHourlyPay.setText("");
				lblGrossPay.setText("");
				lblTaxes.setText("");
				lblNetPay.setText("");
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
		Scene scene = new Scene(borderPane, 350, 250);

		// Add the Scene to the Stage
		primaryStage.setScene(scene);

		// Showtime!
		primaryStage.show();
		primaryStage.setTitle("Payroll");


	}
	public static void main(String[] args) {
		launch(args);

	}
}
