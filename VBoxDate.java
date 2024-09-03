package application;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.*;

public class VBoxDate {
	private VBox vDate = new VBox(10);
	private static Label insertRes = new Label();
	private static Label lblResD = new Label();
	private static Label lblResU = new Label();
	private static Label lblRes = new Label();
	ObservableList<Date> items;

	public VBox getvDate() {
		return vDate;
	}

	public void setvDate(VBox vDate) {
		this.vDate = vDate;
	}

	public VBoxDate() {
		StackPane insert = new StackPane();
		insert.setAlignment(Pos.CENTER);
		Rectangle recInsert = new Rectangle(300, 150);
		recInsert.setArcWidth(50);
		recInsert.setArcHeight(50);
		recInsert.setStyle("-fx-stroke-width: 3px;-fx-fill:#990000;");
		HBox hInsert = new HBox(5);
		hInsert.setAlignment(Pos.CENTER);
		DatePicker dateInsert = new DatePicker();
		dateInsert.setDayCellFactory(picker -> new DateCell() {
			@Override
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				if (date.isAfter(LocalDate.now())) {
					setDisable(true); // Disable future dates
					setStyle("-fx-background-color: #c3c2c1;"); // Change color for disabled dates (optional)
				}
			}
		});
		dateInsert.getEditor().setDisable(true);
		Button bInsert = new Button("Insert");
		bInsert.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color:white;");
		hInsert.getChildren().addAll(dateInsert, bInsert);
		VBox vInsert = new VBox(10);
		vInsert.setAlignment(Pos.CENTER);
		lblRes = new Label("");
		lblRes.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
		Label lbl = new Label("Choose Date To Insert");
		lbl.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15;-fx-font-family: 'Times New Roman';-fx-text-fill: white;");
		vInsert.getChildren().addAll(lbl, hInsert, lblRes);
		insert.getChildren().addAll(recInsert, vInsert);

		StackPane delete = new StackPane();
		delete.setAlignment(Pos.CENTER);
		Rectangle recDelete = new Rectangle(300, 150);
		recDelete.setArcWidth(50);
		recDelete.setArcHeight(50);
		recDelete.setStyle("-fx-stroke-width: 3px;-fx-fill:#990000;");
		HBox hDelete = new HBox(5);
		hDelete.setAlignment(Pos.CENTER);
		DatePicker dateDelete = new DatePicker();
		dateDelete.setDayCellFactory(picker -> new DateCell() {
			@Override
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				if (date.isAfter(LocalDate.now())) {
					setDisable(true); // Disable future dates
					setStyle("-fx-background-color: #c3c2c1;"); // Change color for disabled dates (optional)
				}
			}
		});
		dateDelete.getEditor().setDisable(true);
		Button bDelete = new Button("Delete");
		bDelete.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px; -fx-background-color:white;");
		hDelete.getChildren().addAll(dateDelete, bDelete);
		VBox vDelete = new VBox(8);
		vDelete.setAlignment(Pos.CENTER);
		lblResD = new Label("");
		lblResD.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15; -fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
		Label lblD = new Label("Choose Date to Delete");
		lblD.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15; -fx-font-family: 'Times New Roman';-fx-text-fill: white;");
		vDelete.getChildren().addAll(lblD, hDelete, lblResD);
		delete.getChildren().addAll(recDelete, vDelete);

		StackPane update = new StackPane();
		update.setAlignment(Pos.CENTER);
		Rectangle recUpdate = new Rectangle(450, 150);
		recUpdate.setArcWidth(50);
		recUpdate.setArcHeight(50);
		recUpdate.setStyle("-fx-stroke-width: 3px;-fx-fill:#990000;");
		HBox hUpdate = new HBox(8);
		hUpdate.setAlignment(Pos.CENTER);
		VBox vTf = new VBox(5);
		vTf.setAlignment(Pos.CENTER);
		DatePicker dateUpdate = new DatePicker();
		dateUpdate.setDayCellFactory(picker -> new DateCell() {
			@Override
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				if (date.isAfter(LocalDate.now())) {
					setDisable(true); // Disable future dates
					setStyle("-fx-background-color: #c3c2c1;"); // Change color for disabled dates (optional)
				}
			}
		});
		dateUpdate.getEditor().setDisable(true);
		DatePicker dateNew = new DatePicker();
		dateNew.setDayCellFactory(picker -> new DateCell() {
			@Override
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				if (date.isAfter(LocalDate.now())) {
					setDisable(true); // Disable future dates
					setStyle("-fx-background-color: #c3c2c1;"); // Change color for disabled dates (optional)
				}
			}
		});
		dateNew.getEditor().setDisable(true);
		vTf.getChildren().addAll(dateUpdate, dateNew);
		Button bUpdate = new Button("Update");
		bUpdate.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color:white;");
		hUpdate.getChildren().addAll(vTf, bUpdate);
		VBox vUpdate = new VBox(8);
		vUpdate.setAlignment(Pos.CENTER);
		lblResU = new Label("");
		lblResU.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15; -fx-font-family: 'Times New Roman';-fx-text-fill:#FFEECC;");
		Label lblU = new Label("To Update a Date First Enter the old Date,\n              Then enter the new Date");
		lblU.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold; -fx-font-size: 15; -fx-font-family: 'Times New Roman'; -fx-text-fill: white;");
		vUpdate.getChildren().addAll(lblU, hUpdate, lblResU);
		update.getChildren().addAll(recUpdate, vUpdate);

		Button bPrint = new Button("Print Hash Table");
		bPrint.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-background-color:#990000; -fx-text-fill:white;");

		items = FXCollections.observableArrayList();
		ListView<Date> listView = new ListView<>(items);
		listView.setPrefSize(400, 400);
		listView.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family:'Times New Roman';");

		HBox hDate = new HBox(5);
		hDate.setAlignment(Pos.CENTER);
		hDate.getChildren().addAll(insert, delete);

		vDate.getChildren().addAll(hDate, update, bPrint);
		vDate.setAlignment(Pos.CENTER);

		bInsert.setOnAction(e -> {
			if (dateInsert.getValue() == null) {
				lblRes.setText("Choose Date please!");
				return;
			} else {
				Date dateObj = new Date(formatDate(dateInsert.getValue().toString()));
				if (Main.hash.insert(dateObj) == true) {
					lblRes.setText("Added Successfully");
				} else {
					lblRes.setText("The Date Exist Before");
				}
			}

		});

		bDelete.setOnAction(e -> {
			Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
			confirmation.setTitle("Confirmation");
			confirmation.setHeaderText("Are you sure you want to delete the Martyr?");
			confirmation.setContentText("Any unsaved changes will be lost.");
			confirmation.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					if (dateDelete.getValue() == null) {
						lblResD.setText("Choose Date Please");
						return;
					} else {
						Date dateObj = new Date(formatDate(dateDelete.getValue().toString()));
						System.out.println(dateDelete.getValue().toString());
						if (Main.hash.delete(dateObj) != null) {
							lblResD.setText("Deleted Successfully");
						} else {
							lblResD.setText("The Date Dose Not Exist");
						}
					}
				}

			});

		});

		bUpdate.setOnAction(e -> {
			Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
			confirmation.setTitle("Confirmation");
			confirmation.setHeaderText("Are you sure you want to update the Martyr?");
			confirmation.setContentText("Any unsaved changes will be lost.");
			confirmation.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					if (dateUpdate.getValue() == null || dateNew.getValue() == null) {
						lblResU.setText("Choose Date please");
						return;
					} else {
						Date dateOld = new Date(formatDate(dateUpdate.getValue().toString()));
						Date newDate = new Date(formatDate(dateNew.getValue().toString()));
						if (Main.hash.update(dateOld, newDate) == true) {
							lblResU.setText("Updated Successfully");
						} else {
							lblResU.setText("There is Something wrong, try again");
						}
					}
				}

			});

		});

		bPrint.setOnAction(e -> {
			this.PrintHashTabel();
			VBox vbox = new VBox(5);
			vbox.getChildren().addAll(listView);
			vbox.setAlignment(Pos.CENTER);
			Stage stage = new Stage();
			Scene scene = new Scene(vbox, 400, 400);
			stage.setScene(scene);
			stage.show();
		});

	}

	public static void clear() {
		insertRes.setText("");
		lblResD.setText("");
		lblResU.setText("");
		lblRes.setText("");
	}

	private String formatDate(String date) {
		String dataSplit[] = date.split("-");
		String dateFormat = dataSplit[1] + "/" + dataSplit[2] + "/" + dataSplit[0];
		if (dateFormat.charAt(0) == '0')
			dateFormat = dateFormat.substring(1);
		for (int i = 1; i < dateFormat.length(); i++) {
			if (dateFormat.charAt(i) == '0' && dateFormat.charAt(i - 1) == '/') {
				dateFormat = dateFormat.replaceFirst("0", "");
				break;
			}
		}
		return dateFormat;
	}

	public void PrintHashTabel() {
		for (int i = 0; i < Main.hash.getSize(); i++) {
			if (Main.hash.getHash()[i].getFlag() == 'F') {
				items.add(((Date) Main.hash.getHash()[i].getValue()));
			}
		}
	}

}
