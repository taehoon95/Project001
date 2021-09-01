package Pack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavafxStudy extends Application{
	
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox(); //VBox ���η� ����
		root.setPrefSize(400, 300);
		//-------------------------------------------- �ڵ� ����

		Button btn1 = new Button("�׽�Ʈ"); 
		root.getChildren().add(btn1); //root �ؿ� �ڽ����� btn1�߰�
		Button btn2 = new Button("�׽�Ʈ"); 
		root.getChildren().add(btn2); 

		//--------------------------------------------
		Scene scene = new Scene(root);
		arg0.setTitle("�ѱ�");
		arg0.setScene(scene);
		arg0.show();
	}

	public static void main(String[] args) {
		
		launch(); //blocking
		System.out.println("Exit");
	}

}
