package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

import javax.xml.soap.Text;

public class Main extends Application {

    float nb1 , nb2 , res;
    TextField firstNumber , secondNumber , result;

    public void getNumbers(){
        nb1 = Float.parseFloat(firstNumber.getText());
        nb2  =Float.parseFloat(secondNumber.getText());
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Label firstNumberLabel = new Label("First Number:");
        Label secondNumberLabel = new Label("Second Number:");
        Label resultLabel = new Label("Result:");

        firstNumber = new TextField("Type here");
        secondNumber = new TextField("Type here");
        result = new TextField();

        Button add = new Button("Add");
        Button subtract = new Button("Subtract");
        Button multiply = new Button("Multiply");
        Button divide = new Button("Divide");

        GridPane gridLayout = new GridPane();
        HBox hboxLayout = new HBox();
        VBox vboxLayout= new VBox();

        gridLayout.add(firstNumberLabel ,0 , 0);
        gridLayout.add(firstNumber ,1 , 0);
        gridLayout.add(secondNumberLabel ,0 , 1);
        gridLayout.add(secondNumber,1 , 1);
        gridLayout.add(resultLabel ,0 , 2);
        gridLayout.add(result ,1 , 2);

        hboxLayout.getChildren().addAll(add,subtract,multiply,divide);
        vboxLayout.getChildren().addAll(gridLayout , hboxLayout);

        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        hboxLayout.setSpacing(10);
        vboxLayout.setSpacing(10);
        vboxLayout.setPadding(new Insets(10,10,10,10));

        add.setOnAction(e->{
            getNumbers();
            res = nb1 + nb2;
            result.setText("" + res);
        });
        subtract.setOnAction(e->{
            getNumbers();
            res = nb1 - nb2;
            result.setText("" + res);
        });
        multiply.setOnAction(e->{
            getNumbers();
            res = nb1*nb2;
            result.setText("" + res);
        });
        divide.setOnAction(e->{
            getNumbers();
            res = nb1/nb2;
            result.setText("" + res);
        });

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(vboxLayout, 265, 160));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
