package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Main extends Application {
	static File file = new File("");
	static File newFile = new File("");
	static Hash<Date> hash = new Hash<>();
	static Hash<District> districtHash = new Hash<>();
	static ArrayList<Martyr> martyrArray = new ArrayList<Martyr>();

	@Override
	public void start(Stage stage) {
		TabPane tabpane = new TabPane();
		FileChooser fileChooser = new FileChooser();
		Locale.setDefault(Locale.ENGLISH);
		Tab date = new Tab();
		Tab martyr = new Tab();
		StackPane pane = new StackPane();
		VBox vMain = new VBox(10);
		vMain.setAlignment(Pos.CENTER);
		Label lbl = new Label();
		lbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-font-family: 'Times New Roman';");
		Label lblSave = new Label();
		lbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-font-family: 'Times New Roman';");
		Button choose = new Button("Choose A File To Start");
		Button save = new Button("Save To File");
		save.setStyle(
				"-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px; -fx-font-weight: bold;-fx-font-family: 'Times New Roman';");
		choose.setStyle(
				"-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px; -fx-font-weight: bold;-fx-font-family: 'Times New Roman';");
		vMain.getChildren().addAll(choose, lbl, save, lblSave);
		choose.setOnAction(e -> {
			try {
				File selectedFile = fileChooser.showOpenDialog(stage);
				file = selectedFile;
				this.readFromFile();
				date.setDisable(false);
				martyr.setDisable(false);
				BorderPaneDate BPDate = new BorderPaneDate();
				date.setContent(BPDate.getMainPane());
				BorderPaneMartyr BPMartyr = new BorderPaneMartyr();
				martyr.setContent(BPMartyr.getMainMartyr());
				BorderPaneDate.setCurrDate(hash.search(new Date(BorderPaneDate.getLblDate().getText())));
				BorderPaneDate.getTotal()
						.setText("The Total Martyrs is " + BorderPaneDate.getCurrDate().getValue().totalMartyrs());
				BorderPaneDate.getMales().setText(
						"The Total Number of Males is " + BorderPaneDate.getCurrDate().getValue().totalMales());
				BorderPaneDate.getAvgAge()
						.setText("The Average Age is " + BorderPaneDate.getCurrDate().getValue().avgAge());
				BorderPaneDate.getFemales().setText(
						"The Total Number Of Females is " + BorderPaneDate.getCurrDate().getValue().totalFemales());
				BorderPaneDate.getMaxDistrict()
						.setText("The Max District is " + Main.maxDistrict(BorderPaneDate.getCurrDate().getValue()));
				BorderPaneDate.getMaxLocation()
				.setText("The Max Location is " + Main.maxLocation(BorderPaneDate.getCurrDate().getValue()));
				lbl.setText("File selected Successfully");
				lbl.setTextFill(Color.GREEN);
			} catch (Exception ex) {
				lbl.setText("Choose File Please");
				lbl.setTextFill(Color.RED);
				ex.printStackTrace();
			}

		});

		save.setOnAction(e -> {
			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv"));
			Stage stageSave = new Stage();
			File fileSave = fileChooser.showSaveDialog(stageSave);
			if (fileSave != null) {
				try {
					boolean created = fileSave.createNewFile();
					if (created) {
						newFile = fileSave;
						writeToFile();
						lblSave.setText("Saved Successfully");
						lblSave.setTextFill(Color.GREEN);
					}
				} catch (IOException ex) {

				}
			}
		});
		Image image = new Image(
				"https://scontent.fjrs29-1.fna.fbcdn.net/v/t1.15752-9/447741018_888974726329047_5047014922814378984_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=5f2048&_nc_ohc=LQsDr-4MiBsQ7kNvgGOtPix&_nc_ht=scontent.fjrs29-1.fna&oh=03_Q7cD1QFslTOT6Gp__mrRDekU9ebtYj3kJymqt35s1RTipUDAWQ&oe=668BC8FC");
		ImageView imageView = new ImageView(image);
		imageView.fitWidthProperty().bind(stage.widthProperty());
		imageView.fitHeightProperty().bind(stage.heightProperty());
		imageView.setOpacity(0.5);
		pane.getChildren().addAll(vMain);
		Tab main = new Tab();
		main.setText("Choose File");
		main.setContent(pane);

		date.setText("Date");
		date.setDisable(true);

		martyr.setText("Martyr");
		martyr.setDisable(true);

		tabpane.getTabs().addAll(main, date, martyr);
		Scene scene = new Scene(tabpane, 400, 400);
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void readFromFile() {
		try {
			Scanner scan = new Scanner(file);
			scan.nextLine();
			while (scan.hasNext()) {
				String Line = scan.nextLine();
				String[] data = Line.split(",");
				if (data.length == 6 && !data[2].equals("")) {
					String name = data[0];
					String date = data[1];
					int age = Integer.parseInt(data[2]);
					String location = data[3];
					String district = data[4];
					String gender = data[5];
					Martyr martyr = new Martyr(name, date, age, location, district, gender);
					Date dateObj = new Date(date);
					District districtObj = new District(district);
					hash.insert(dateObj);
					hash.search(dateObj).getValue().getAvlTree().insert(martyr);
					districtHash.insert(districtObj);
					districtHash.search(districtObj).getValue().getMartyrList().add(location);
					if (VBoxMartyr.observableList.contains(district) == false) {
						VBoxMartyr.observableList.add(district);
					}

					districtHash.insert(districtObj);
					districtHash.search(districtObj).getValue().getMartyrList().add(location);
					if (VBoxMartyr.observableListUpdate.contains(district) == false) {
						VBoxMartyr.observableListUpdate.add(district);
					}
				}
			}
		

		} catch (IOException ex) {

		}
	}

	public static void printMartyrs(AVL<Martyr> avlTree) {
		if (avlTree.getRoot() == null)
			return;
		Queue<Martyr> q = new Queue<Martyr>();
		q.enQueue(avlTree.getRoot().getData());
		while (!q.isEmpty()) {
			Martyr mar = q.deQueue();
			TNode<Martyr> MartyrNode = avlTree.find(mar);
			if (MartyrNode.getRight() != null)
				q.enQueue(MartyrNode.getRight().getData());
			if (MartyrNode.getLeft() != null)
				q.enQueue(MartyrNode.getLeft().getData());
			BorderPaneMartyr.items.add(mar);
		}
	}

	public static void martyrArray(TNode<Martyr> node) {
		if (node != null) {
			if (node.getLeft() != null)
				martyrArray(node.getLeft());
			martyrArray.add(node.getData());
			if (node.getRight() != null) {
				martyrArray(node.getRight());
			}
		}
	}

	public static void maxHeapify(Martyr[] martyr) {
		int N = martyr.length - 1, i = (int) Math.ceil(N / 2.0) - 1;
		Martyr temp;
		while (i-- >= 0) {
			int k = i + 1;
			while (2 * k + 1 <= N) {
				int j = 2 * k + 1;
				if (j < N && martyr[j].getAge() < martyr[j + 1].getAge())
					j++;
				if (martyr[k].getAge() >= martyr[j].getAge())
					break;
				temp = martyr[k];
				martyr[k] = martyr[j];
				martyr[j] = temp;
				k = j;
			}
		}
	}

	public static void heapSortAsc(Martyr[] martyr) {
		int N = martyr.length - 1;
		Martyr temp;

		maxHeapify(martyr);

		while (N > 0) {
			temp = martyr[0];
			martyr[0] = martyr[N];
			martyr[N] = temp;
			N--;

			int k = 0;
			while (2 * k + 1 <= N) {
				int j = 2 * k + 1;
				if (j < N && martyr[j].getAge() < martyr[j + 1].getAge())
					j++;
				if (martyr[k].getAge() >= martyr[j].getAge())
					break;
				temp = martyr[k];
				martyr[k] = martyr[j];
				martyr[j] = temp;
				k = j;
			}
		}
	}

	public static void writeToFile() {
		try {
			PrintWriter pw = new PrintWriter(newFile);
			pw.write("Name,Date,Age,Location,District,Gender");
			for (int i = 0; i < hash.getSize(); i++) {
				if (hash.getHash()[i].getFlag() == 'F') {
					Queue<Martyr> q = new Queue<Martyr>();
					q.enQueue(hash.search((Date) hash.getHash()[i].getValue()).getValue().getAvlTree().getRoot()
							.getData());
					while (!q.isEmpty()) {
						Martyr mar = q.deQueue();
						TNode<Martyr> MartyrNode = hash.search((Date) hash.getHash()[i].getValue()).getValue()
								.getAvlTree().find(mar);
						if (MartyrNode.getRight() != null)
							q.enQueue(MartyrNode.getRight().getData());
						if (MartyrNode.getLeft() != null)
							q.enQueue(MartyrNode.getLeft().getData());
						pw.println(MartyrNode.getData().getName() + "," + MartyrNode.getData().getAge() + ","
								+ MartyrNode.getData().getEvent() + "," + MartyrNode.getData().getLocation() + ","
								+ MartyrNode.getData().getDistrict() + "," + MartyrNode.getData().getGender());

					}
				}
			}
			pw.close();
		} catch (IOException ex) {

		}
	}

	private static int martyrsForEachDistrict(TNode<Martyr> node, String district) {
		if (node == null)
			return 0;
		if (node.getData().getDistrict().equals(district)) {
			return 1 + martyrsForEachDistrict(node.getLeft(), district)
					+ martyrsForEachDistrict(node.getRight(), district);
		}
		return martyrsForEachDistrict(node.getLeft(), district) + martyrsForEachDistrict(node.getRight(), district);

	}

	public static String maxDistrict(Date date) {
		String district = "";
		int max = 0;
		for (int i = 0; i < VBoxMartyr.observableList.size(); i++) {
			if (max < martyrsForEachDistrict(hash.search(date).getValue().getAvlTree().getRoot(),
					VBoxMartyr.observableList.get(i))) {
				max = martyrsForEachDistrict(hash.search(date).getValue().getAvlTree().getRoot(),
						VBoxMartyr.observableList.get(i));
				district = VBoxMartyr.observableList.get(i);
			}
		}

		return district;
	}

	private static int martyrsForEachLocation(TNode<Martyr> node, String location) {
		if (node == null)
			return 0;
		if (node.getData().getLocation().equals(location)) {
			return 1 + martyrsForEachLocation(node.getLeft(), location)
					+ martyrsForEachLocation(node.getRight(), location);
		}
		return martyrsForEachLocation(node.getLeft(), location) + martyrsForEachLocation(node.getRight(), location);

	}

	public static String maxLocation(Date date) {
		String location = "";
		int max = 0;

		for (int i = 0; i < districtHash.getSize(); i++) {
			if (districtHash.getHash()[i].getFlag() == 'F') {
				for (int j = 0; j < ((District) districtHash.getHash()[i].getValue()).getMartyrList().size(); j++) {
					if (max < martyrsForEachLocation(hash.search(date).getValue().getAvlTree().getRoot(),
							((District) districtHash.getHash()[i].getValue()).getMartyrList().get(j))) {
						max = martyrsForEachLocation(hash.search(date).getValue().getAvlTree().getRoot(),
								((District) districtHash.getHash()[i].getValue()).getMartyrList().get(j));
						location = ((District) districtHash.getHash()[i].getValue()).getMartyrList().get(j);
					}
				}
			}

		}

		return location;
	}

}
