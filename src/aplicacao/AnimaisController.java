package aplicacao;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modelo.dao.AnimalDAO;
import modelo.getset.Animal;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.time.LocalDate.parse;

public class AnimaisController {
    @FXML private TextField txtSexo;
    @FXML private TextField txtBrinco;
    @FXML private TextField txtNome;
    @FXML private TextField txtRaca;
    @FXML private DatePicker dataNasc;
    @FXML private TextField txtPeso;
    @FXML private TextField txtPesquisar;
    @FXML private TableView<Animal> tblAnimais;
    @FXML private TableColumn<Animal, Integer> colBrinco;
    @FXML private TableColumn<Animal, String> colRaca;
    @FXML private TableColumn<Animal, String> colSexo;
    @FXML private TableColumn<Animal, LocalDate> colDataNasc;

    @FXML public void initialize() {
        colBrinco.setCellValueFactory(new PropertyValueFactory<>("idAnimal"));
        colRaca.setCellValueFactory(new PropertyValueFactory<>("raca"));
        colSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        colDataNasc.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
        carregarAnimais();
        txtPesquisar.textProperty().addListener((observableValue, s, t1)
                -> buscarAnimal());


    }


    @FXML
    private void cadastrarAnimal() {
        txtBrinco.getText();
        txtNome.getText();
        txtRaca.getText();
        dataNasc.getValue();
        txtPeso.getText();
        txtSexo.getText();

        if (validarFormulario()) {
            LocalDate nasc = validarNascimento();
           Animal animal = new Animal();
           animal.setIdAnimal(Integer.parseInt(txtBrinco.getText()));
           if (nasc ==null && dataNasc.getValue() != null){
               return;
           }
           animal.setDataNasc(dataNasc.getValue());
           animal.setRaca(txtRaca.getText());
           animal.setPesoAtual(validarPeso());
           animal.setSexo(txtSexo.getText());
            AnimalDAO dao = new AnimalDAO();
            dao.inserir(animal);
            carregarAnimais();

        }

    }
    @FXML
    public void buscarAnimal(){
   String termo = txtPesquisar.getText();
    List<Animal> busca = AnimalDAO.buscar(termo);
        ObservableList<Animal> observableList = FXCollections.observableArrayList(busca);
        tblAnimais.setItems(observableList);
    }

    private boolean validarFormulario() {
        return validarBrinco() && validarRaca();
    }

    private LocalDate validarNascimento() {
        LocalDate nascimento = dataNasc.getValue();
        if (nascimento == null) {
            return null;
        }
        if (nascimento.isAfter(LocalDate.now())) {
            exibirAlerta("Erro:", " A data não pode ser no futuro!");
            return null;
        }
        return nascimento;
    }

    private boolean validarRaca() {
    return true;
    }

    private Double validarPeso() {
        String pesoTexto = txtPeso.getText();
        if (pesoTexto==null || pesoTexto.trim().isEmpty()){
            return null;
        }
        try {
            return Double.parseDouble(pesoTexto);
            }
        catch (NumberFormatException e) {
            exibirAlerta("Erro", "Peso deve conter apenas numeros!");
            return null;
        }
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

    @FXML
    public void carregarAnimais() {
        AnimalDAO dao = new AnimalDAO();
        List<Animal> lista = dao.listar();

            ObservableList<Animal> observableList = FXCollections.observableArrayList(lista);
            tblAnimais.setItems(observableList);
    }

    public void excluirAnimal() throws SQLException {
        Animal selecao = tblAnimais.getSelectionModel().getSelectedItem();

            if (selecao == null){
                exibirAlerta("Erro"," Não há nada para excluir");
                return;
            }
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmação");
        alerta.setHeaderText("Excluir Animal");
        alerta.setContentText("Tem certeza que deseja excluir este animal?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent()&& resultado.get() == ButtonType.OK){
            AnimalDAO dao = new AnimalDAO();
            dao.excluir(selecao.getIdAnimal());

        };
        carregarAnimais();
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





