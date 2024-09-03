package application;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BorderPaneMartyr {
	private static BorderPane mainMartyr = new BorderPane();
	private static HNode<Date> date;
	private static Label lblSize = new Label();;
	private static Label lblHeight = new Label();
	static ObservableList<Martyr> items;
	static ObservableList<Martyr> itemsAge;
	static ListView<Martyr> listView;

	public BorderPaneMartyr() {
		Label lblMain = new Label(" Martyr Screen ");
		lblMain.setStyle(
				"-fx-font-family: 'Times New Roman';-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 35;-fx-background-color:#990000;-fx-text-fill:white");
		mainMartyr.setTop(lblMain);
		mainMartyr.setMargin(lblMain, new Insets(40,0,0,0));
		mainMartyr.setAlignment(lblMain, Pos.CENTER);
		mainMartyr.setStyle("-fx-background-color: white;");

		lblSize.setStyle(
				"-fx-font-family: 'Times New Roman'; -fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 20;");
		lblHeight.setStyle(
				"-fx-font-family: 'Times New Roman';-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 20;");

		VBoxMartyr vMartyr = new VBoxMartyr();
		mainMartyr.setLeft(vMartyr.gethDate());
		mainMartyr.setMargin(vMartyr.gethDate(), new javafx.geometry.Insets(0, 0, 0, 200));

		StackPane sPane = new StackPane();
		Image imageData = new Image(
				"https://scontent.fjrs4-1.fna.fbcdn.net/v/t1.15752-9/370099455_931682898520873_1480713249280401791_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_ohc=FWg_CU3ZOZoQ7kNvgGEi7Re&_nc_ht=scontent.fjrs4-1.fna&oh=03_Q7cD1QF7R0lIgIDavLex_AdHAL-BUndYWQkVSjYz_xjpo13xMg&oe=666EFA3E");
		ImageView imageViewData = new ImageView(imageData);
		imageViewData.setOpacity(0.2);
		imageViewData.setFitHeight(500);
		imageViewData.setFitWidth(600);
		Rectangle recData = new Rectangle(600, 500);
		recData.setStyle("-fx-fill: white; -fx-stroke:black; -fx-stroke-width: 3;");
		Button bData = new Button("Print Martyrs Level By Level");
		bData.setStyle(
				"-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px; -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-border-color: black;");

		Button bSortByAge = new Button("Print Martyrs Sort By Age");
		bSortByAge.setStyle(
				"-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px; -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-border-color: black;");

		VBox vData = new VBox(30);
		vData.setAlignment(Pos.CENTER);
		vData.getChildren().addAll(lblSize, lblHeight, bData, bSortByAge);
		mainMartyr.setRight(sPane);
		sPane.getChildren().addAll(recData, imageViewData, vData);
		mainMartyr.setMargin(sPane, new javafx.geometry.Insets(0, 200, 0, 0));

		items = FXCollections.observableArrayList();
		listView = new ListView<>(items);
		listView.setPrefSize(600, 400);
		listView.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-family:'Times New Roman';");

		bData.setOnAction(e -> {
			items.clear();
			Main.printMartyrs(date.getValue().getAvlTree());
			VBox vbox = new VBox(5);
			HBox hbox = new HBox(5);
			hbox.setAlignment(Pos.CENTER);
			hbox.getChildren().addAll(VBoxMartyr.bDelete,VBoxMartyr.load);
			vbox.getChildren().addAll(listView,hbox,VBoxMartyr.lblResD);
			vbox.setAlignment(Pos.CENTER);
			Stage stage = new Stage();
			Scene scene = new Scene(vbox, 900, 500);
			stage.setScene(scene);
			stage.show();
		});

		itemsAge = FXCollections.observableArrayList();
		ListView<Martyr> listViewAge = new ListView<>(itemsAge);
		listViewAge.setPrefSize(600, 400);
		listViewAge.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-family:'Times New Roman';");

		bSortByAge.setOnAction(e -> {
			itemsAge.clear();
			Main.martyrArray.clear();
			Main.martyrArray(date.getValue().getAvlTree().getRoot());
			Martyr[] array = new Martyr[Main.martyrArray.size()];
			array = Main.martyrArray.toArray(array);
			Main.heapSortAsc(array);
			for (int i = 0; i < array.length; i++) {
				itemsAge.add(array[i]);
			}
			VBox vbox = new VBox(5);
			vbox.getChildren().addAll(listViewAge);
			vbox.setAlignment(Pos.CENTER);
			Stage stage = new Stage();
			Scene scene = new Scene(vbox, 900, 400);
			stage.setScene(scene);
			stage.show();
		});

	}

	public static BorderPane getMainMartyr() {
		return mainMartyr;
	}

	public static void setMainMartyr(BorderPane mainMartyr) {
		BorderPaneMartyr.mainMartyr = mainMartyr;
	}

	public static Label getLblSize() {
		return lblSize;
	}

	public static void setLblSize(Label lblSize) {
		BorderPaneMartyr.lblSize = lblSize;
	}

	public static Label getLblHeight() {
		return lblHeight;
	}

	public static void setLblHeight(Label lblHeight) {
		BorderPaneMartyr.lblHeight = lblHeight;
	}

	public static HNode<Date> getDate() {
		return date;
	}

	public static void setDate(HNode<Date> date) {
		BorderPaneMartyr.date = date;
	}

}
