package aplicacao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
   public void start(Stage primaryStage) throws Exception {
        // Carrega o FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));

        // Cria a cena com base no layout
        Scene scene = new Scene(loader.load());

        // Configura e mostra a janela
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Gestão de Gado Leiteiro");
        primaryStage.setScene(scene);
        primaryStage.show();
       }

    public static void main(String[] args) {
        launch(args); // inicia a aplicação JavaFX
    }
}
