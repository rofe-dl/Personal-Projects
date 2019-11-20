package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import mainapp.Handler;
import mainapp.Passtore;

public class WelcomeController {

    private Passtore passtoreInstance;
    public void setPasstoreInstance(Passtore passtoreInstance){
        this.passtoreInstance = passtoreInstance;
    }

    /** Items annotated @FXML means the the fxml file can access them**/
    @FXML
    private TextField masterUsernameField;

    @FXML
    private PasswordField masterPasswordField;

    @FXML
    private Button listMasterAccountsButton,  signUpButton;

    @FXML
    private Button signInButton;

    /** First method that gets called when a controller file's respective fxml is loaded **/
    @FXML
    private void initialize(){
        signUpButton.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)){
                signUpButton.fire();
            }
        });
        signInButton.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)){
                signInButton.fire();
            }
        });
        listMasterAccountsButton.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)){
                listMasterAccountsButton.fire();
            }
        });
    }

    /** methods starting with handle in these controllers shows the function that gets called when the button is pressed **/
    @FXML
    private void handleSignInButton(){
        if(!Handler.checkIfAccountExists( masterUsernameField.getText().trim() )){

            DialogBox.showError("No such username exists, please sign up","Username Not Found");
            return;

        }else if(!Handler.checkIfPasswordMatches(masterUsernameField.getText().trim(), masterPasswordField.getText())){

            DialogBox.showError("Your password is incorrect","Wrong Password");
            return;
        }

        this.passtoreInstance.showAccountUI(masterUsernameField.getText().trim());
    }

    @FXML
    private void handleSignUpButton(){
        this.passtoreInstance.showMasterAccountCreationUI();
    }

    @FXML
    private void handleListOfMasterAccountsButton(){
        this.passtoreInstance.showAccountListUI();
    }

}
