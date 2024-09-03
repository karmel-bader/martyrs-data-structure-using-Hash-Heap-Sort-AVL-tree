package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VBoxButtonsDate {

	private VBox vButtons = new VBox(10);
	private static Button next;
	private static Button prev;
	int i = 0;

	

	public VBoxButtonsDate() {
		Label lbl = new Label();
		lbl.setStyle(
				"-fx-font-style: italic; -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;");
		vButtons.setAlignment(Pos.CENTER);
		HBox hButtons = new HBox(10);
		hButtons.setAlignment(Pos.CENTER);
		next = new Button("Next");
		next.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color:#990000; -fx-text-fill:white;");
		prev = new Button("Previous");
		prev.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color:#990000; -fx-text-fill:white;");
		Button load = new Button("Load");
		load.setStyle(
				" -fx-font-weight: bold;-fx-font-family: 'Times New Roman'; -fx-font-size: 12px;-fx-background-color:#990000; -fx-text-fill:white;");
		hButtons.getChildren().addAll(prev, next, load);
		vButtons.getChildren().addAll(hButtons, lbl);
		
		
		next.setOnAction(e ->{
			VBoxDate.clear();
			lbl.setText("");
			 while(i<Main.hash.getSize()-1){
				 i++;
		            if(Main.hash.getHash()[i].getFlag()=='F') {
		            	BorderPaneDate.getLblDate().setText(Main.hash.getHash()[i].getValue() + "");
		            	BorderPaneDate.setCurrDate(Main.hash.getHash()[i]);
						BorderPaneDate.getTotal().setText("The Total Martyrs is " + BorderPaneDate.getCurrDate().getValue().totalMartyrs());
						BorderPaneDate.getMales().setText("The Total Number of Males is " + BorderPaneDate.getCurrDate().getValue().totalMales());
						BorderPaneDate.getAvgAge().setText("The Average Age is " + BorderPaneDate.getCurrDate().getValue().avgAge());
						BorderPaneDate.getFemales().setText("The Total Number Of Females is " + BorderPaneDate.getCurrDate().getValue().totalFemales());
						BorderPaneDate.getMaxDistrict().setText("The Max District is " + Main.maxDistrict(BorderPaneDate.getCurrDate().getValue()));
						BorderPaneDate.getMaxLocation()
						.setText("The Max Location is " + Main.maxLocation(BorderPaneDate.getCurrDate().getValue()));
		            	break;
		            }
		        }
		});
		
		prev.setOnAction(e ->{
			VBoxDate.clear();
			lbl.setText("");
			 while(i>0){
				 i--;
		            if(Main.hash.getHash()[i].getFlag()=='F') {
		            	BorderPaneDate.getLblDate().setText(Main.hash.getHash()[i].getValue() + "");
		            	BorderPaneDate.setCurrDate(Main.hash.getHash()[i]);
						BorderPaneDate.getTotal().setText("The Total Martyrs is " + BorderPaneDate.getCurrDate().getValue().totalMartyrs());
						BorderPaneDate.getMales().setText("The Total Number of Males is " + BorderPaneDate.getCurrDate().getValue().totalMales());
						BorderPaneDate.getAvgAge().setText("The Average Age is " + BorderPaneDate.getCurrDate().getValue().avgAge());
						BorderPaneDate.getFemales().setText("The Total Number Of Females is " + BorderPaneDate.getCurrDate().getValue().totalFemales());
						BorderPaneDate.getMaxDistrict().setText("The Max District is " + Main.maxDistrict(BorderPaneDate.getCurrDate().getValue()));
						BorderPaneDate.getMaxLocation()
						.setText("The Max Location is " + Main.maxLocation(BorderPaneDate.getCurrDate().getValue()));
		            	break;
		            }
		        }
		});

		load.setOnAction(e ->{
			    BorderPaneMartyr.setDate(Main.hash.search(new Date(BorderPaneDate.getLblDate().getText())));
			    System.out.println(Main.hash.search(new Date(BorderPaneDate.getLblDate().getText())));
			    BorderPaneMartyr.getLblHeight().setText("The Tree Height is " + BorderPaneMartyr.getDate().getValue().getAvlTree().height(BorderPaneMartyr.getDate().getValue().getAvlTree().getRoot()));
				BorderPaneMartyr.getLblSize().setText("The Tree Size is "+ BorderPaneMartyr.getDate().getValue().totalMartyrs());
				lbl.setText("Loaded Successfully");
		});
	}	

	public VBox getvButtons() {
		return vButtons;
	}

	public void setvButtons(VBox vButtons) {
		this.vButtons = vButtons;
	}

	public static Button getNext() {
		return next;
	}

	public static void setNext(Button next) {
		VBoxButtonsDate.next = next;
	}

	public static Button getPrev() {
		return prev;
	}

	public static void setPrev(Button prev) {
		VBoxButtonsDate.prev = prev;
	}	
}

