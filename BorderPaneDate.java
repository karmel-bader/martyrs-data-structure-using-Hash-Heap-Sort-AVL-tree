package application;


import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BorderPaneDate {
	private static BorderPane mainDate = new BorderPane();
	private static Label lblDate = new Label("");
	private static Label total = new Label("");
	private static Label males = new Label("");
	private static Label AvgAge = new Label("");
	private static Label females = new Label("");
	private static Label maxDistrict = new Label("");
	private static Label maxLocation = new Label("");
	private static HNode<Date> currDate ;

	public BorderPaneDate() {
		mainDate.setStyle("-fx-background-color: white;");
		total.setStyle(
				"-fx-font-family: 'Times New Roman'; -fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 20;");
		males.setStyle(
				"-fx-font-family: 'Times New Roman';-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 20;");
		AvgAge.setStyle(
				"-fx-font-style: italic;-fx-font-family: 'Times New Roman'; -fx-font-weight: bold; -fx-font-size: 20;");
		females.setStyle(
				"-fx-font-style: italic;-fx-font-family: 'Times New Roman'; -fx-font-weight: bold; -fx-font-size: 20;");
		
		maxDistrict.setStyle(
				"-fx-font-style: italic;-fx-font-family: 'Times New Roman'; -fx-font-weight: bold; -fx-font-size: 20;");
		
		maxLocation.setStyle(
				"-fx-font-style: italic;-fx-font-family: 'Times New Roman'; -fx-font-weight: bold; -fx-font-size: 20;");

		lblDate.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-font-family: 'Times New Roman';");
		 for(int i=0; i<Main.hash.getSize(); i++){
	            if(Main.hash.getHash()[i].getFlag()=='F') {
	            	lblDate.setText(Main.hash.getHash()[i].getValue() + "");
	            	break;
	            }
	        }
		
		VBoxDate vDate = new VBoxDate();
		VBoxButtonsDate vButtons = new VBoxButtonsDate();
		mainDate.setLeft(vDate.getvDate());
		mainDate.setBottom(vButtons.getvButtons());
		mainDate.setMargin(vDate.getvDate(), new javafx.geometry.Insets(0, 0, 0, 80));
		mainDate.setMargin(vButtons.getvButtons(), new javafx.geometry.Insets(0, 0, 40, 0));
		mainDate.setTop(lblDate);
		mainDate.setAlignment(lblDate, Pos.CENTER);
		mainDate.setMargin(lblDate, new javafx.geometry.Insets(20, 0, 0, 0));

		StackPane sPane = new StackPane();
		Image imageData = new Image(
				"https://scontent.fjrs4-1.fna.fbcdn.net/v/t1.15752-9/370099455_931682898520873_1480713249280401791_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_ohc=FWg_CU3ZOZoQ7kNvgGEi7Re&_nc_ht=scontent.fjrs4-1.fna&oh=03_Q7cD1QF7R0lIgIDavLex_AdHAL-BUndYWQkVSjYz_xjpo13xMg&oe=666EFA3E");
		ImageView imageViewData = new ImageView(imageData);
		imageViewData.setOpacity(0.2);
		imageViewData.setFitHeight(500);
		imageViewData.setFitWidth(600);
		Rectangle recData = new Rectangle(600, 500);
		recData.setStyle("-fx-fill: white; -fx-stroke:black; -fx-stroke-width: 3;");
		
		
		
		VBox vData = new VBox(30);
		vData.setAlignment(Pos.CENTER);
		vData.getChildren().addAll(total,males,females, AvgAge,maxDistrict,maxLocation);
		mainDate.setRight(sPane);
		sPane.getChildren().addAll(recData, imageViewData, vData);
		mainDate.setMargin(sPane, new javafx.geometry.Insets(0, 100, 0, 0));
		
		
		
		
	}

	public static BorderPane getMainPane() {
		return mainDate;
	}

	public static void setMainPane(BorderPane mainDate) {
		BorderPaneDate.mainDate = mainDate;
	}

	public static Label getLblDate() {
		return lblDate;
	}

	public static void setLblDate(Label lblDate) {
		BorderPaneDate.lblDate = lblDate;
	}



	public static Label getAvgAge() {
		return AvgAge;
	}

	public static void setAvgAge(Label avgAge) {
		AvgAge = avgAge;
	}

	public static Label getTotal() {
		return total;
	}

	public static void setTotal(Label total) {
		BorderPaneDate.total = total;
	}

	public static Label getMales() {
		return males;
	}

	public static void setMales(Label males) {
		BorderPaneDate.males = males;
	}

	public static Label getFemales() {
		return females;
	}

	public static void setFemales(Label females) {
		BorderPaneDate.females = females;
	}

	public static HNode<Date> getCurrDate() {
		return currDate;
	}

	public static void setCurrDate(HNode<Date> currDate) {
		BorderPaneDate.currDate = currDate;
	}

	public static Label getMaxDistrict() {
		return maxDistrict;
	}

	public static void setMaxDistrict(Label maxDistrict) {
		BorderPaneDate.maxDistrict = maxDistrict;
	}

	public static Label getMaxLocation() {
		return maxLocation;
	}

	public static void setMaxLocation(Label maxLocation) {
		BorderPaneDate.maxLocation = maxLocation;
	}

	

	

	
}

