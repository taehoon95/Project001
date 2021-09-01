package Pack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavafxStudy extends Application{
	
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox(); //VBox 세로로 생김
		root.setPrefSize(400, 300);
		//-------------------------------------------- 코드 시작

		Button btn1 = new Button("테스트"); 
		root.getChildren().add(btn1); //root 밑에 자식으로 btn1추가
		Button btn2 = new Button("테스트"); 
		root.getChildren().add(btn2); 

		//--------------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("한글");
		arg0.setScene(scene);
		arg0.show();
	}

	public static void main(String[] args) {
		
		launch(); //blocking
		System.out.println("Exit");
	}

}
