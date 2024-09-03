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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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

public class VBoxMartyr {
	private HBox hDate = new HBox(5);
	private static Label insertRes;
	static Label lblResD;
	private TextField tfInsert;
	static Button bDelete;
	static Button bUpdate;
	static Button load;
	static ComboBox<String> comboDistrict = new ComboBox<String>();
	static ObservableList<String> observableList = FXCollections.observableArrayList();
	static ComboBox<String> comboLocation = new ComboBox<String>();
	static ObservableList<String> observableListLocation = FXCollections.observableArrayList();
	static ComboBox<String> comboDistrictUpdate = new ComboBox<String>();
	static ObservableList<String> observableListUpdate = FXCollections.observableArrayList();
	static ComboBox<String> comboLocationUpdate = new ComboBox<String>();
	static ObservableList<String> observableListLocationUpdate = FXCollections.observableArrayList();
	Martyr selectedItem;

	public HBox gethDate() {
		return hDate;
	}

	public void sethDate(HBox vDate) {
		this.hDate = vDate;
	}

	public Label getLblResD() {
		return lblResD;
	}

	public void setLblResD(Label lblResD) {
		this.lblResD = lblResD;
	}

	public TextField getTfInsert() {
		return tfInsert;
	}

	public void setTfInsert(TextField tfInsert) {
		this.tfInsert = tfInsert;
	}

	public VBoxMartyr() {
		StackPane insert = new StackPane();
		Rectangle recInsert = new Rectangle(400, 450);
		recInsert.setStyle("-fx-stroke-width: 3px;-fx-fill:#990000;");
		recInsert.setArcWidth(50);
		recInsert.setArcHeight(50);
		insert.setAlignment(Pos.CENTER);
		VBox vInsert = new VBox(10);
		vInsert.setAlignment(Pos.CENTER);
		Label lblInsert = new Label("Enter The Required Data To Insert New Martyr");
		lblInsert.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		lblInsert.setAlignment(Pos.CENTER);
		GridPane gpInsert = new GridPane();
		gpInsert.setAlignment(Pos.CENTER);
		gpInsert.setHgap(8);
		gpInsert.setVgap(8);
		Label name = new Label("Enter The Name");
		name.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		gpInsert.add(name, 0, 0);
		TextField tfName = new TextField();
		tfName.setPrefColumnCount(10);
		gpInsert.add(tfName, 1, 0);

		Label age = new Label("Enter The Age");
		age.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		gpInsert.add(age, 0, 1);
		TextField tfAge = new TextField();
		tfAge.setPrefColumnCount(10);
		gpInsert.add(tfAge, 1, 1);

		Label lblLocation = new Label("Choose Location");
		lblLocation.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		gpInsert.add(lblLocation, 0, 3);
		comboLocation = new ComboBox<String>(observableListLocation);
		comboLocation.setPrefWidth(220);
		comboLocation.setStyle("-fx-text-fill: white; -fx-background-color: white;");
		comboLocation.setPromptText("Choose Location");
		gpInsert.add(comboLocation, 1, 3);

		Label lblDistrict = new Label("Choose District");
		lblDistrict.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		gpInsert.add(lblDistrict, 0, 2);
		comboDistrict = new ComboBox<String>(observableList);
		comboDistrict.setPrefWidth(220);
		comboDistrict.setStyle("-fx-text-fill: white; -fx-background-color: white;");
		comboDistrict.setPromptText("Choose District");
		comboDistrict.setOnAction(e -> {
			this.fillComboBoxLocation();
		});
		gpInsert.add(comboDistrict, 1, 2);

		HBox hbox = new HBox(40);
		hbox.setAlignment(Pos.CENTER);
		Label gender = new Label("Choose Gender");
		gender.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:white;");
		gpInsert.add(gender, 0, 4);
		VBox vRadio = new VBox(5);
		vRadio.setAlignment(Pos.CENTER);
		ToggleGroup group = new ToggleGroup();
		RadioButton male = new RadioButton("M");
		male.setStyle("-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;");
		male.setToggleGroup(group);
		RadioButton female = new RadioButton("F ");
		female.setStyle("-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;");
		female.setToggleGroup(group);
		vRadio.getChildren().addAll(male, female);
		Button bInsert = new Button("Insert");
		bInsert.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-background-color:white;");
		insertRes = new Label();
		insertRes.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#FFEECC;");
		hbox.getChildren().addAll(vRadio, bInsert);
		gpInsert.add(hbox, 1, 4);

		vInsert.getChildren().addAll(lblInsert, gpInsert, insertRes);
		insert.getChildren().addAll(recInsert, vInsert);

		bDelete = new Button("Delete");
		bDelete.setStyle(
				"-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-background-color:#990000;-fx-text-fill:white;");
		lblResD = new Label("");
		lblResD.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#990000;");

		load = new Button("Load");
		load.setStyle(
				"-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-background-color:#990000;-fx-text-fill:white;");
		VBox vUpdate = new VBox(30);
		vUpdate.setStyle("-fx-background-color:white;");
		vUpdate.setAlignment(Pos.CENTER);
		Label lbl = new Label("Update Martyr Information");
		lbl.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 25px;-fx-text-fill:#990000;");
		vUpdate.getChildren().add(lbl);
		GridPane gpUpdate = new GridPane();
		gpUpdate.setStyle("-fx-background-color:white;");
		gpUpdate.setAlignment(Pos.CENTER);
		gpUpdate.setHgap(10);
		gpUpdate.setVgap(20);

		Label nameU = new Label("Enter The Name");
		nameU.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;");
		gpUpdate.add(nameU, 0, 0);
		TextField tfNameU = new TextField();
		tfNameU.setPrefColumnCount(10);
		gpUpdate.add(tfNameU, 1, 0);

		Label ageU = new Label("Enter The Age");
		ageU.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;");
		gpUpdate.add(ageU, 0, 1);
		TextField tfAgeU = new TextField();
		tfAgeU.setPrefColumnCount(10);
		gpUpdate.add(tfAgeU, 1, 1);

		Label lblLocationUpdate = new Label("Choose Location");
		lblLocationUpdate.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:black;");
		gpUpdate.add(lblLocationUpdate, 0, 3);
		comboLocationUpdate = new ComboBox<String>(observableListLocationUpdate);
		comboLocationUpdate.setPrefWidth(220);
		comboLocationUpdate.setStyle("-fx-text-fill: white;-fx-background-color: lightblue; ");
		comboLocationUpdate.setPromptText("Choose Location");
		gpUpdate.add(comboLocationUpdate, 1, 3);

		Label lblDistrictUpdate = new Label("Choose District");
		lblDistrictUpdate.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:black;");
		gpUpdate.add(lblDistrictUpdate, 0, 2);
		comboDistrictUpdate = new ComboBox<String>(observableListUpdate);
		comboDistrictUpdate.setPrefWidth(220);
		comboDistrictUpdate.setStyle("-fx-text-fill: white; -fx-background-color: lightblue;");
		comboDistrictUpdate.setPromptText("Choose District");
		comboDistrictUpdate.setOnAction(e -> {
			this.fillComboBoxLocationUpdate();
		});
		gpUpdate.add(comboDistrictUpdate, 1, 2);

		HBox hboxU = new HBox(10);
		hboxU.setAlignment(Pos.CENTER);
		Label genderU = new Label("Choose The Gender");
		genderU.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;");
		gpUpdate.add(genderU, 0, 4);
		VBox vRadioUpdate = new VBox(5);
		vRadioUpdate.setAlignment(Pos.CENTER);
		ToggleGroup groupUpdate = new ToggleGroup();
		RadioButton maleUpdate = new RadioButton("M");
		maleUpdate.setStyle("-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;");
		maleUpdate.setToggleGroup(groupUpdate);
		RadioButton femaleUpdate = new RadioButton("F ");
		femaleUpdate.setStyle("-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;");
		femaleUpdate.setToggleGroup(groupUpdate);
		vRadioUpdate.getChildren().addAll(maleUpdate, femaleUpdate);
		bUpdate = new Button("Update");
		bUpdate.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-background-color:#990000;-fx-text-fill:white;");
		Label updateRes = new Label();
		updateRes.setStyle(
				"-fx-font-style: italic;-fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 15px;-fx-text-fill:#990000;");
		hboxU.getChildren().addAll(vRadioUpdate, bUpdate);
		gpUpdate.add(hboxU, 1, 4);

		vUpdate.getChildren().addAll(gpUpdate, updateRes);

		Stage stage = new Stage();
		stage.setTitle("Update Martyr Information");
		Scene scene = new Scene(vUpdate, 400, 400);
		stage.setScene(scene);

		hDate.getChildren().addAll(insert);
		hDate.setAlignment(Pos.CENTER);

		bInsert.setOnAction(e -> {

			if (tfName.getText().isBlank() || tfAge.getText().isBlank() || comboLocation.getValue() == null
					|| comboDistrict.getValue() == null || group.getSelectedToggle() == null) {
				insertRes.setText("Fill All Required Data Fields");
				return;

			} else {
				try {
					if (Integer.parseInt(tfAge.getText()) > 120 || Integer.parseInt(tfAge.getText()) < 0) {
						insertRes.setText("Sorry, The Age must be between 1 and 120");
						insertRes.setTextFill(Color.BLACK);
						return;
					}
					Martyr martyr = new Martyr(tfName.getText(), BorderPaneMartyr.getDate().getValue().toString(),
							Integer.parseInt(tfAge.getText()), comboLocation.getValue().toString(),
							comboDistrict.getValue().toString(), ((RadioButton) group.getSelectedToggle()).getText());
					BorderPaneMartyr.getDate().getValue().getAvlTree().insert(martyr);
					insertRes.setText("Added Successfully");
				} catch (NumberFormatException ex) {
					insertRes.setText("Sorry, The Age must be a number between 1 and 120");
					insertRes.setTextFill(Color.BLACK);
					return;
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
					lblResD.setText("");
					Martyr selectedItem = BorderPaneMartyr.listView.getSelectionModel().getSelectedItem();
					if (selectedItem != null) {
						BorderPaneMartyr.items.remove(selectedItem);
						BorderPaneMartyr.getDate().getValue().getAvlTree().delete(selectedItem);
						lblResD.setText("Deleted Successfully");
					} else {
						lblResD.setText("Choose Martyr please!");
					}
				}

			});

		});

		load.setOnAction(e -> {
			lblResD.setText("");
			selectedItem = BorderPaneMartyr.listView.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				stage.show();
			} else {
				lblResD.setText("Choose Martyr please!");
			}
		});

		bUpdate.setOnAction(e -> {
			Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
			confirmation.setTitle("Confirmation");
			confirmation.setHeaderText("Are you sure you want to update the Martyr?");
			confirmation.setContentText("Any unsaved changes will be lost.");
			confirmation.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					if (tfNameU.getText().isBlank() || tfAgeU.getText().isBlank()
							|| comboLocationUpdate.getValue() == null || comboDistrictUpdate.getValue() == null
							|| groupUpdate.getSelectedToggle() == null) {
						updateRes.setText("Fill All required Data Feilds!");
						return;
					} else {
						try {
							if (Integer.parseInt(tfAgeU.getText()) > 120 || Integer.parseInt(tfAgeU.getText()) < 0) {
								updateRes.setText("Sorry, The Age must be between 1 and 120");
								return;
							}
							Martyr martyr = new Martyr(tfNameU.getText(),
									BorderPaneMartyr.getDate().getValue().toString(),
									Integer.parseInt(tfAgeU.getText()), comboLocationUpdate.getValue().toString(),
									comboDistrictUpdate.getValue().toString(),
									((RadioButton) groupUpdate.getSelectedToggle()).getText());
							BorderPaneMartyr.getDate().getValue().getAvlTree().update(selectedItem, martyr);
							BorderPaneMartyr.items.clear();
							Main.printMartyrs(BorderPaneMartyr.getDate().getValue().getAvlTree());
							updateRes.setText("Updated Successfully");
						} catch (NumberFormatException ex) {
							updateRes.setText("Sorry, The Age must be a number between 1 and 120");
							return;
						}
					}
				}

			});

		});

	}

	public static void clear() {
		insertRes.setText("");
		lblResD.setText("");
	}

	public void fillComboBoxLocation() {
		District district = new District(comboDistrict.getValue().toString());
		district = Main.districtHash.search(district).getValue();
		observableListLocation.clear();
		for (int i = 0; i < district.getMartyrList().size(); i++) {
			if (observableListLocation.contains(district.getMartyrList().get(i)) == false) {
				observableListLocation.add(district.getMartyrList().get(i));
			}
		}
	}

	public void fillComboBoxLocationUpdate() {
		District district = new District(comboDistrictUpdate.getValue().toString());
		district = Main.districtHash.search(district).getValue();
		observableListLocationUpdate.clear();
		for (int i = 0; i < district.getMartyrList().size(); i++) {
			if (observableListLocationUpdate.contains(district.getMartyrList().get(i)) == false) {
				observableListLocationUpdate.add(district.getMartyrList().get(i));
			}
		}
	}

}
