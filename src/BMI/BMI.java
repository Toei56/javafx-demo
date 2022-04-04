package BMI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.text.DecimalFormat;

public class BMI extends Application {
    private Label mBMI = new Label("ดัชนีมวชกาย (BMI)");
    private TextField mWeight = new TextField();
    private TextField mHeight = new TextField();
    private Button mOK = new Button("OK");

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("BMI Demo");
        stage.setWidth(250);
        stage.setHeight(180);
        stage.setResizable(false);

        mWeight.setPromptText("น้ำหนัก (กิโลกรัม)");
        mHeight.setPromptText("ส่วนสูง (เซนติเมตร)");
        mOK.setPrefWidth(50);
        mOK.setOnAction(event -> calculateBMI());

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(mBMI, mWeight, mHeight, mOK);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();

    }

    private void calculateBMI() {
        String message1 = "";
        String message2 = "";
        String msg = "";
        double weight = Double.parseDouble(mWeight.getText());
        double height = Double.parseDouble(mHeight.getText());
        double heightC = height / 100;
        double heightPow = Math.pow(heightC, 2);
        double bmi = weight / heightPow;

        if (bmi < 18.5) {
            message2 = "น้ำหนักน้อย / ผอม";
        } else if ((bmi >= 18.05) && (bmi <= 22.9)) {
            message2 = "น้ำหนักปกติ";
        } else if ((bmi >= 23) && (bmi <=24.9)) {
            message2 = "น้ำหนักมาก / ท้วม / โรคอ้วนระดับ 1";
        } else if ((bmi >= 25) && (bmi <= 29.9)) {
            message2 = "น้ำหนักเกิน / อ้วน / โรคอ้วนระดับ 2";
        } else {
            message2 = "น้ำหนักเกินพิกัด / อ้วนมาก / โรคอ้วนระดับ 3";
        }

        String pattren = "##.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattren);
        String sbmi = decimalFormat.format(bmi);
        message1 = "ค่า BMI ของคุณ คือ : " + sbmi;
        msg = message1 + "\n" + message2;

        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg,ButtonType.OK);
        alert.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
