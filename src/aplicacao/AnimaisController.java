package aplicacao;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Node;
import modelo.dao.AnimalDAO;
import modelo.getset.Animal;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javafx.scene.*;
import static java.time.LocalDate.parse;

public class AnimaisController {
    @FXML private TextField txtSexo;
    @FXML private TextField txtBrinco;
    @FXML private TextField txtNome;
    @FXML private TextField txtRaca;
    @FXML private DatePicker dpNascimento;
    @FXML private TextField txtPeso;
    @FXML private TableView<Animal> tblAnimais;
    @FXML private TableColumn<Animal, Integer> colBrinco;
    @FXML private TableColumn<Animal, String> colRaca;
    @FXML private TableColumn<Animal, String> colSexo;
    @FXML private TableColumn<Animal, LocalDate> colNascimento;


    @FXML
    private void cadastrarAnimal() {
        txtBrinco.getText();
        txtNome.getText();
        txtRaca.getText();
        dpNascimento.getValue();
        txtPeso.getText();
        txtSexo.getText();


        if (validarFormulario()) {
           Animal animal = new Animal();
           animal.setBrinco(Integer.parseInt(txtBrinco.getText()));
           animal.setDataNascimento(dpNascimento.getValue());
           animal.setRaca(txtRaca.getText());
           animal.setPesoAtual(Double.parseDouble(txtPeso.getText()));
           animal.setSexo(txtSexo.getText());

            AnimalDAO dao = new AnimalDAO();
            dao.inserir(animal);

            exibirAlerta("Ok "," feito");

        }

    }


    @FXML
    private void limparFormulario() {

    }


    private boolean validarFormulario() {
        return validarBrinco() && validarPeso() && validarRaca() &&validarNascimento();
    }

    private boolean validarNascimento() {
        LocalDate nascimento = dpNascimento.getValue();
        if (nascimento.isAfter(LocalDate.now())){
            exibirAlerta("Erro:", " A data não pode ser no futuro!");
            return false;
        }
        return true;
    }

    private boolean validarRaca() {
    return true;
    }

    private boolean validarPeso() {
        String pesoTexto = txtPeso.getText();
        try {
            double peso = Double.parseDouble(pesoTexto);

            if (peso <= 0) {
                exibirAlerta("Erro", "Pseo deve ser maior que 0");
                return false;
            }
        } catch (NumberFormatException e) {
            exibirAlerta("Erro", "Peso deve conter apenas numeros!");
            return false;
        }
    return true;
}

    private boolean validarBrinco() {
        String brincoTexto = txtBrinco.getText();
        if (brincoTexto.isEmpty()) {
            exibirAlerta("Erro", "O brinco não pode ser vazio!");
            return false;
        }
        try {
            int brinco = Integer.parseInt(brincoTexto);
            if (brinco <= 0) {
                exibirAlerta("Erro de validação", "O brinco deve ser maior que zero");
                return false;
            }
        } catch (NumberFormatException e) {
            exibirAlerta("Erro de validação", "O valor deve ser um numero inteiro");
            return false;
        }

        return true;

    }
    public void carregarAnimais() {
        AnimalDAO dao = new AnimalDAO();
        List<Animal> lista = dao.listar();

        ObservableList<Animal> observableList = FXCollections.observableArrayList(lista);
        tblAnimais.setItems(observableList);
    }



    private void exibirAlerta(String titulo, String mensagem) {
        System.out.println("exibir alerta"+mensagem);
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(titulo);
            alert.setHeaderText(null);
            alert.setContentText(mensagem);
            alert.showAndWait();
        });

    }



}





