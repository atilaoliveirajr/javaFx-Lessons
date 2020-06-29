package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable{
	
	@FXML
	private TextField txtNumber1;
	
	@FXML
	private TextField txtNumber2;
	
	@FXML
	private Label lbResult;
	
	@FXML
	private Button brSum;
	
	@FXML
	public void onBtSumAction () {
//		NumberFormatException
		try {
			Locale.setDefault(Locale.US);
			double number1 = Double.parseDouble(txtNumber1.getText());
			double number2 = Double.parseDouble(txtNumber2.getText());

			double sum = number1 + number2;
			
			lbResult.setText(String.format("%.2f", sum));
		}
		
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Please, insert a valid number", e.getMessage(), AlertType.ERROR);
		}
			
		

		
//		Alerts.showAlert("Title", null, "Content", AlertType.INFORMATION);
//		Alerts.showAlert("Title", "Header", "Content", AlertType.INFORMATION);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
//		Constraints.setTextFieldInteger(txtNumber1);
//		Constraints.setTextFieldInteger(txtNumber2);
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);
		Constraints.setTextFieldMaxLength(txtNumber1, 12);
		Constraints.setTextFieldMaxLength(txtNumber2, 12);

	}

}
