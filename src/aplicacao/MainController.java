package aplicacao;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.Node;

import java.io.IOException;

public class MainController {

    @FXML private StackPane mainContent;
    @FXML private Button btnAnimais, btnVacinas, btnProducao, btnPesagem, btnReproducao;

    @FXML
    private void initialize() {
        // adiciona ações nos botões
        btnAnimais.setOnAction(e -> carregarTela("Animais.fxml"));
        btnVacinas.setOnAction(e -> carregarTela("Vacina.fxml"));
        btnProducao.setOnAction(e -> carregarTela("Producao.fxml"));
        btnPesagem.setOnAction(e -> carregarTela("Pesagem.fxml"));
        btnReproducao.setOnAction(e -> carregarTela("Reproducao.fxml"));
    }

    private void carregarTela(String fxml) {
        try {
            Node tela = FXMLLoader.load(getClass().getResource(fxml));
            mainContent.getChildren().setAll(tela); // troca o conteúdo do centro
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
