// Written by Toni Huffman
// 4/11/2017

package edu.seminolestate.studentanalysis;

import java.text.NumberFormat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;


public class StudentAnalysis extends Application {

	// Constants for class sizes
	public static final int FRESHMEN = 170;
	public static final int SOPHOMORE = 105;
	public static final int JUNIOR = 90;
	public static final int SENIOR = 85;
	public static final int GRADUATE = 85;
	public static final int TOTAL_STUDENTS = FRESHMEN + SOPHOMORE + JUNIOR + SENIOR + GRADUATE;

	// Calculate Percentages
	double percentFresh = (double) FRESHMEN/TOTAL_STUDENTS;
	double percentSopho = (double) SOPHOMORE/TOTAL_STUDENTS;
	double percentJunior = (double) JUNIOR/TOTAL_STUDENTS;
	double percentSenior = (double) SENIOR/TOTAL_STUDENTS;
	double percentGrad = (double) GRADUATE/TOTAL_STUDENTS;

	// Set Colors
	Color titleColor = Color.BLACK;

	Color freshColor = Color.CRIMSON;
	Color sophColor = Color.CORAL;
	Color junColor = Color.GOLDENROD;
	Color senColor = Color.YELLOWGREEN;
	Color gradColor = Color.TEAL;

	Color strokeColor = Color.BLACK;

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Format Title
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		Label lblTitle = new Label("Percent of Students by Class");
		Font headingFont = Font.font("Times New Roman", FontWeight.BOLD, 18);
		lblTitle.setFont(headingFont);
		lblTitle.setTextFill(titleColor);

		// Create Pie Chart

		int chartRadius = 125;
		int chartX = 250;
		int chartY = 150;
		Pane chartPane = new Pane();

		// Create Arc for each class

		Arc freshArc = new Arc(chartX, chartY, chartRadius, chartRadius, 0, percentFresh*360);
		freshArc.setType(ArcType.ROUND);
		freshArc.setFill(freshColor);
		freshArc.setStroke(strokeColor);

		// Increment starting position for sophomores
		double start = percentFresh*360;

		Arc sophArc = new Arc(chartX, chartY, chartRadius, chartRadius, start, percentSopho*360);
		sophArc.setType(ArcType.ROUND);
		sophArc.setFill(sophColor);
		sophArc.setStroke(strokeColor);

		// Increment starting position
		start = start + percentSopho*360;

		Arc junArc = new Arc(chartX, chartY, chartRadius, chartRadius, start, percentJunior*360);
		junArc.setType(ArcType.ROUND);
		junArc.setFill(junColor);
		junArc.setStroke(strokeColor);

		// Increment starting position
		start = start + percentJunior*360;

		Arc senArc = new Arc(chartX, chartY, chartRadius, chartRadius, start, percentSenior*360);
		senArc.setType(ArcType.ROUND);
		senArc.setFill(senColor);
		senArc.setStroke(strokeColor);

		// Increment starting position
		start = start + percentSenior*360;

		Arc gradArc = new Arc(chartX, chartY, chartRadius, chartRadius, start, percentGrad*360);
		gradArc.setType(ArcType.ROUND);
		gradArc.setFill(gradColor);
		gradArc.setStroke(strokeColor);

		// Add all arcs to pane
		chartPane.getChildren().addAll(freshArc,sophArc,junArc,senArc,gradArc);


		// Format Legend Labels
		Label lblFreshmen = new Label(percentFormat.format(percentFresh) + ": Freshmen");
		lblFreshmen.setTextFill(freshColor);
		Font legendFont = Font.font("Times New Roman", FontWeight.BOLD, 12);
		lblFreshmen.setFont(legendFont);

		Label lblSophomores = new Label(percentFormat.format(percentSopho) + ": Sophomores");
		lblSophomores.setTextFill(sophColor);
		lblSophomores.setFont(legendFont);

		Label lblJuniors = new Label(percentFormat.format(percentJunior) + ": Juniors");
		lblJuniors.setTextFill(junColor);
		lblJuniors.setFont(legendFont);

		Label lblSeniors = new Label(percentFormat.format(percentSenior) + ": Seniors");
		lblSeniors.setTextFill(senColor);
		lblSeniors.setFont(legendFont);

		Label lblGraduate = new Label(percentFormat.format(percentGrad) + ": Graduate");
		lblGraduate.setTextFill(gradColor);
		lblGraduate.setFont(legendFont);

		// Create Legend Flowpane
		FlowPane flowPane = new FlowPane();
		flowPane.getChildren().addAll(lblFreshmen,lblSophomores,lblJuniors,lblSeniors,lblGraduate);
		flowPane.setHgap(15);
		flowPane.setAlignment(Pos.CENTER);
		flowPane.setPadding(new Insets(10));


		// Create Container BorderPane
		BorderPane thePane = new BorderPane();
		BorderPane.setAlignment(lblTitle, Pos.CENTER);

		// Add Top
		lblTitle.setPadding(new Insets(15));
		thePane.setTop(lblTitle);

		// Add Bottom
		thePane.setBottom(flowPane);

		// Add Middle
		thePane.setCenter(chartPane);


		// Create the Scene object. Add the Pane to the Scene
		Scene scene = new Scene(thePane, 500, 400);

		// Add the Scene to the Stage
		primaryStage.setScene(scene);

		// Showtime!
		primaryStage.show();
		primaryStage.setTitle("Student Class Analysis");

	}

	public static void main(String[] args) {
		launch(args);
	}

}
