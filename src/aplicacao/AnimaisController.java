package aplicacao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.Node;
import modelo.getset.Animal;

import java.io.IOException;

public class AnimaisController {
    @FXML private TextField txtBrinco;
    @FXML private TextField txtNome;
    @FXML private TextField txtRaca;
    @FXML private DatePicker dpNascimento;
    @FXML private TextField txtPeso;
    @FXML private Button btnSalvar, btnEditar, btnCancelar;
    @FXML private GridPane tabela;

    @FXML
    private void initialize(){


    }

    @FXML
    private void cadastrarAnimal(){
        Integer.parseInt(txtBrinco.getText());
        txtNome.getText();
        txtRaca.getText();
        dpNascimento.getValue();

        String brinco = txtBrinco.getText();
        System.out.println(brinco);


    }
   @FXML
   private void limparFormulario(){

   }
   private void exibir(){


   }




}
