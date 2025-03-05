package br.com.senac.integrativeproject;

import br.com.senac.integrativeproject.SQL.CarroDAO;
import br.com.senac.integrativeproject.SQL.FuncionarioDAO;
import br.com.senac.integrativeproject.SQL.GestorDeVendasDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProjectController {

    //////////
    //Global//
    //////////

    // Uma caixa de texto editável e sem revelar os caracteres
    // para guardar o texto digitado pelo usuário.
    @FXML
    private PasswordField passwordFieldUser;

    // Uma caixa de texto editável e não editável com os caracteres
    // revelados para guarda o texto digitado pelo usuário ou
    // mostrar os dados para o usuário.
    @FXML
    private TextField textFieldUserName;

    //////////////
    //User-Board//
    //////////////

    //Botão que realizar a ação de verificação das informações
    //digitado pelo o usuário.
    @FXML
    private Button btnLogin;

    // Um pequeno texto selecionavel para realizar uma ação para
    // abrir uma janela de verificação de senha do gestor para
    // cadastrar um novo usuário(funcionário).
    @FXML
    private Label labelRegister;

    /////////////////
    //Register-User//
    /////////////////

    // Uma caixa de texto editável revelando os caracteres
    // para guardar o texto digitado pelo usuário.
    @FXML
    private TextField textFieldCPF;

    // Uma caixa de texto editável revelando os caracteres
    // para guardar o texto digitado pelo usuário.
    @FXML
    private TextField textFieldEmail;

    // Uma caixa de texto editável revelando os caracteres
    // para guardar o texto digitado pelo usuário.
    @FXML
    private TextField textFieldEndereço;

    // Uma caixa de texto editável revelando os caracteres
    // para guardar o texto digitado pelo usuário.
    @FXML
    private TextField textFieldTelephone;

    // Botão para realizar ação do cadastro de um novo usuário
    // usando as informações digitado pelo próprio usuário
    // na janela de cadastro.
    @FXML
    private Button btnRegister;

    //////////////////
    //Password-board//
    //////////////////

    // Um texto seletivo que realiza uma ação de verificação
    // de senha do gestor.
    @FXML
    private Label labelConfirmPassword;

    //////////////////
    //Main-Interface//

    // Janela interna inicial.
    @FXML
    private Pane paneInicio;

    // Janela interna de lista de carros cadastrados.
    @FXML
    private Pane paneListCar;//{

    // Uma lista vísivel de carro.
    @FXML
    private ListView<Carro> listViewCar;

    // Uma lista de carro.
    private ArrayList<Carro> carroList;

    // Uma lista observavel criado para atualizar as informações
    // do atributo "listViewCar".
    private ObservableList<Carro> obsCarroList;

    //}

    // Janela interna de lista de usuários(funcionário)
    // cadastrados.
    @FXML
    private Pane paneListUser;

    // Uma lista vísivel de funcionário.
    @FXML
    private ListView<Funcionario> listViewUser;//{

    // Uma lista de funcionário.
    private ArrayList<Funcionario> userList;

    // Uma lista observavel criado para atualizar as informações
    // do atributo "listViewUser".
    private ObservableList<Funcionario> obsUserList;
    //}

    // Janela interna para cadastro de novos carros.
    @FXML
    private Pane paneCarRegister;//{

    // Botão que realiza a ação de registro de um novo carro
    // usando as informações digitados pelo usuário.
    @FXML
    private Button btnRegisterNewCar;

    // Uma caixa de texto editável revelando os caracteres
    // para guardar o texto digitado pelo usuário.
    @FXML
    private TextField textFieldCarName;

    // Uma caixa de números seletivo numéricos de 1885 até
    // o ano atual do sistema operacional que executa o
    // programa
    @FXML
    private Spinner<Integer> spinnerCarAge;

    // Atributo para definir o ano minímo e o maxímo de um carro
    SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.
            IntegerSpinnerValueFactory(1885, LocalDate.now().getYear());

    // Uma caixa de texto editável revelando os caracteres
    // para guardar o texto digitado pelo usuário.
    @FXML
    private TextField textFieldCarModel;

    // Uma caixa de texto editável revelando os caracteres
    // para guardar o texto digitado pelo usuário.
    @FXML
    private TextField textFieldCarSerial;
    //}

    // Janela interna contendo as informações do programador
    // e a sua equipe do projeto.
    @FXML
    private Pane paneAbout;

    // Botão que realiza a ação de troca de janela interna
    // para janela Inicial("paneInicio")
    @FXML
    private Button btnInicio;

    // Botão que realiza a ação de troca de janela interna
    // para janela de lista de usuário("paneListUser").
    @FXML
    private Button btnListUser;

    // Botão que realiza a ação de troca de janela interna
    // para janela de lista de carros("paneListCar").
    @FXML
    private Button btnListCar;

    // Botão que realiza a ação de troca de janela interna
    // para janela de registro de carro("paneRegisterCar").
    @FXML
    private Button btnRegisterCar;

    // Botão que realiza a ação de troca de janela interna
    // para janela de informações("aneAbout")
    @FXML
    private Button btnAbout;

    // Uma caixa de texto não editável cotendo a informação
    // de quantidade de carros registrados.
    @FXML
    private TextField textFieldCarRegister;

    // Uma caixa de texto não editável cotendo a informação
    // de quantidade de usuários registrados.
    @FXML
    private TextField textFieldUserRegister;

    ////////////////////
    //dialog-interface//

    // Botão com ação de realizar a confirmação do aviso e fechar a
    // janela de dialogo.
    @FXML
    private Button btnDialogConfirm;


    /////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////ACTIONS////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////

    //////////////
    //User-board//
    //////////////

    /**
     * Chama o método para verificar o login do usuário quando clicar no
     * botão login.
     *
     * @param event (Quando o usuário clicar no botão login)
     * @throws IOException
     */
    @FXML
    void handleBTNLogin(ActionEvent event) throws IOException {
        loginVerification();
    }

    /**
     * Abre uma nova janela pedindo a senha do gestor para iniciar o processo
     * de cadastro de um novo usuario(funcionario).
     *
     * @param event (Quando o usuário clicar na palavra "Cadastrar")
     * @throws IOException
     */
    @FXML
    void handleLabelRegister(MouseEvent event) throws IOException {
        textFieldUserName.clear();
        passwordFieldUser.clear();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("password-board.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("User Board");
        stage.setScene(new Scene(root, 256, 122));
        stage.showAndWait();
    }

    /**
     * Chama o método de verificação de login do usuário quando
     * pressionar o "Enter" do teclado nas caixa de texto de nome de
     * usuário ou senha.
     *
     * @param event (Quando o usuário pressionar o botão "Enter" nas caixa
     *              de texto)
     * @throws IOException
     */
    @FXML
    void handleKeyLogin(KeyEvent event) throws IOException {
        if (event.getCode().toString().equals("ENTER")) {
            loginVerification();
        }
    }

    /*
     * Verificar as informações de nome de usuário e senha digitado pelo
     * usuário para realização de login.
     */
    public void loginVerification() throws IOException {
        GestorDeVendasDAO gestorDeVendasDAO = new GestorDeVendasDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if ((gestorDeVendasDAO.listar(textFieldUserName.getText(), passwordFieldUser.getText()))
                || funcionarioDAO.listar(textFieldUserName.getText(), passwordFieldUser.getText())) {
            passwordFieldUser.clear();
            textFieldUserName.clear();
            Stage stage = (Stage) textFieldUserName.getScene().getWindow();
            stage.setOpacity(1);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-interface.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage2 = new Stage();
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setOpacity(1);
            stage2.setTitle("User Board");
            stage2.setScene(new Scene(root, 1000, 650));

            FXMLLoader fxmlLoaderDialog = new FXMLLoader(getClass().getResource("dialog-interface-welcome.fxml"));
            Parent rootDialog = fxmlLoaderDialog.load();
            Stage stageDialog = new Stage();
            stageDialog.initModality(Modality.APPLICATION_MODAL);
            stageDialog.setOpacity(1);
            stageDialog.setScene(new Scene(rootDialog, 350, 150));
            stageDialog.initStyle(StageStyle.UNDECORATED);
            stageDialog.showAndWait();

            stage.close();
            stage2.showAndWait();

        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dialog-interface-warning.fxml"));
            Parent root = fxmlLoader.load();
            Stage stageDialog = new Stage();
            stageDialog.initModality(Modality.APPLICATION_MODAL);
            stageDialog.setOpacity(1);
            stageDialog.setScene(new Scene(root, 350, 150));
            stageDialog.initStyle(StageStyle.UNDECORATED);
            stageDialog.showAndWait();
        }
    }

    //////////////////
    //Password-board//
    //////////////////

    /**
     * Chama o método de verificação de senha do gestor ao clicar em
     * um texto.
     *
     * @param event (Quando o usuário clicar na palavra "Confirmar")
     * @throws IOException
     */
    @FXML
    void handleLabelConfirmPassword(MouseEvent event) throws IOException {
        passwordVerification();
    }

    /**
     * Chama o método de verificação de senha do gestor ao pressionar
     * o "Enter" do teclado.
     *
     * @param event (Quando o usuário pressionar o "Enter" do
     *              teclado)
     * @throws IOException
     */
    @FXML
    void handleKeyRegister(KeyEvent event) throws IOException {
        if (event.getCode().toString().equals("ENTER")) {
            passwordVerification();
        }
    }

    /*
     * Método de verificação de senha do gestor digitado pelo
     * usuário.
     */
    public void passwordVerification() throws IOException {
        GestorDeVendasDAO gestorDeVendasDAO = new GestorDeVendasDAO();
        if (gestorDeVendasDAO.listar(passwordFieldUser.getText())) {
            passwordFieldUser.clear();
            Stage stage = (Stage) labelConfirmPassword.getScene().getWindow();
            stage.setOpacity(0);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register-user.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage2 = new Stage();
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setOpacity(1);
            stage2.setTitle("User Board");
            stage2.setScene(new Scene(root, 450, 486));
            stage2.showAndWait();
            stage.close();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dialog-interface-warning.fxml"));
            Parent root = fxmlLoader.load();
            Stage stageDialog = new Stage();
            stageDialog.initModality(Modality.APPLICATION_MODAL);
            stageDialog.setOpacity(1);
            stageDialog.setScene(new Scene(root, 350, 150));
            stageDialog.initStyle(StageStyle.UNDECORATED);
            stageDialog.showAndWait();
        }
    }

    /////////////////
    //Register-user//
    /////////////////

    /**
     * Método com ação de realizar o cadastro do usuário(funcionário)
     * usando as informações digitadas pelo usuário.
     *
     * @param event (Quando o usuário clicar no botão "Cadastrar)
     * @throws IOException
     */
    @FXML
    void handleBTNRegister(ActionEvent event) throws IOException {
        Funcionario funcionários = new Funcionario(textFieldUserName.getText(), textFieldEmail.getText(),
                textFieldTelephone.getText(), textFieldCPF.getText(), passwordFieldUser.getText(),
                textFieldEndereço.getText());
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        Stage stage = (Stage) btnRegister.getScene().getWindow();

        funcionarioDao.inserir(funcionários);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dialog-interface-success.fxml"));
        Parent root = fxmlLoader.load();
        Stage stageDialog = new Stage();
        stageDialog.initModality(Modality.APPLICATION_MODAL);
        stageDialog.setOpacity(1);
        stageDialog.setScene(new Scene(root, 350, 150));
        stageDialog.initStyle(StageStyle.UNDECORATED);
        stageDialog.showAndWait();

        stage.close();
    }

    //////////////////
    //Main-Interface//
    //////////////////

    /**
     * Trocar de janela interna para inicio.
     * 
     * @param event (Quando o usuário clicar no botão "Inicio")
     */
    @FXML
    void handleBTNInicio(ActionEvent event) {
        paneInicio.setVisible(true);
        paneListCar.setVisible(false);
        paneListUser.setVisible(false);
        paneCarRegister.setVisible(false);
        paneAbout.setVisible(false);
    }

    /**
     * Trocar de janela interna para lista de carro e
     * listar os carros cadastrados.
     * 
     * @param event (Quando o usuário clicar no botão "Lista de Carro")
     */
    @FXML
    void handleBTNListCar(ActionEvent event) {
        paneInicio.setVisible(false);
        paneListCar.setVisible(true);
        paneListUser.setVisible(false);
        paneCarRegister.setVisible(false);
        paneAbout.setVisible(false);
        CarroDAO carroDAO = new CarroDAO();

        carroList = carroDAO.listar();
        obsCarroList = FXCollections.observableArrayList(carroList);
        listViewCar.setItems(obsCarroList);


    }

    /**
     * Troca de janela interna para lista de usuário e
     * listar os usuários cadastrados.
     *
     * @param event (Quando o usuário clicar no botão "Lista de Usuário")
     */
    @FXML
    void handleBTNListUser(ActionEvent event) {
        paneInicio.setVisible(false);
        paneListCar.setVisible(false);
        paneListUser.setVisible(true);
        paneCarRegister.setVisible(false);
        paneAbout.setVisible(false);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        userList = funcionarioDAO.listar();
        obsUserList = FXCollections.observableArrayList(userList);
        listViewUser.setItems(obsUserList);
    }

    /**
     * Troca de janela interna para resgistro de carro.
     *
     * @param event (Quando o usuário clicar no botão "Registrar carro")
     */
    @FXML
    void handleBTNRegisterCar(ActionEvent event) {
        paneInicio.setVisible(false);
        paneListCar.setVisible(false);
        paneListUser.setVisible(false);
        paneCarRegister.setVisible(true);
        paneAbout.setVisible(false);
        valueFactory.setValue(LocalDate.now().getYear());
        spinnerCarAge.setValueFactory(valueFactory);
    }

    /**
     * Troca de janela interna para mostra as informações do
     * programador e a equipe do projeto.
     *
     * @param event (Quando o usuário clicar no botão "Sobre")
     */
    @FXML
    void handleBTNAbout(ActionEvent event) {
        paneInicio.setVisible(false);
        paneListCar.setVisible(false);
        paneListUser.setVisible(false);
        paneCarRegister.setVisible(false);
        paneAbout.setVisible(true);
    }

    /**
     *  Método para cadastrar um novo carro usando as informações digitadas
     *  pelo usuário.
     *
     * @param event (Quando o usuário clicar no botão "Cadastrar")
     * @throws IOException
     */
    @FXML
    void handleBTNRegisterNewCar(ActionEvent event) throws IOException {
        Carro carros = new Carro(textFieldCarName.getText(), textFieldCarModel.getText(), String.valueOf(spinnerCarAge.getValue()),
                textFieldCarSerial.getText());
        CarroDAO carroDAO = new CarroDAO();
        carroDAO.inserir(carros);
        textFieldCarName.clear();
        textFieldCarModel.clear();
        valueFactory.setValue(LocalDate.now().getYear());
        spinnerCarAge.setValueFactory(valueFactory);
        textFieldCarSerial.clear();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dialog-interface-success.fxml"));
        Parent root = fxmlLoader.load();
        Stage stageDialog = new Stage();
        stageDialog.initModality(Modality.APPLICATION_MODAL);
        stageDialog.setOpacity(1);
        stageDialog.setScene(new Scene(root, 350, 150));
        stageDialog.initStyle(StageStyle.UNDECORATED);
        stageDialog.showAndWait();

    }
    ////////////////////
    //Dialog-interface//
    ////////////////////

    /**
     * Confirmar o aviso recebido e fechar a janela.
     * @param event (Quando o usuário clicar no botão "Ok")
     */
    @FXML
    void handleBTNDialogConfirm(ActionEvent event) {
        Stage stage = (Stage) btnDialogConfirm.getScene().getWindow();
        stage.close();
    }

}
