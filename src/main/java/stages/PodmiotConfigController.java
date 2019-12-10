package stages;

import config.Config;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PodmiotConfigController {
    @FXML
    private Button okButton;
    @FXML
    private TextField nazwaTextFieldPodmiotConfig;

    @FXML
    private TextField ulicaTextFieldPodmiotConfig;

    @FXML
    private TextField kodPocztowyTextFieldPodmiotConfig;

    @FXML
    private TextField miastoTextFieldPodmiotConfig;

    @FXML
    private TextField nipTextFieldPodmiotConfig;

    @FXML
    private TextField regonTextFieldPodmiotConfig;

    @FXML
    private Button anulujButton;

    public String getNazwaTextFieldPodmiotConfig() {
        return nazwaTextFieldPodmiotConfig.getText();
    }

    public void setNazwaTextFieldPodmiotConfig(String nazwaTextFieldPodmiotConfig) {
        this.nazwaTextFieldPodmiotConfig .setText(nazwaTextFieldPodmiotConfig);
    }

    public String getUlicaTextFieldPodmiotConfig() {
        return ulicaTextFieldPodmiotConfig.getText();
    }

    public void setUlicaTextFieldPodmiotConfig(String ulicaTextFieldPodmiotConfig) {
        this.ulicaTextFieldPodmiotConfig .setText( ulicaTextFieldPodmiotConfig);
    }

    public String getKodPocztowyTextFieldPodmiotConfig() {
        return kodPocztowyTextFieldPodmiotConfig.getText();
    }

    public void setKodPocztowyTextFieldPodmiotConfig(String kodPocztowyTextFieldPodmiotConfig) {
        this.kodPocztowyTextFieldPodmiotConfig .setText( kodPocztowyTextFieldPodmiotConfig);
    }

    public String getMiastoTextFieldPodmiotConfig() {
        return miastoTextFieldPodmiotConfig.getText();
    }

    public void setMiastoTextFieldPodmiotConfig(String miastoTextFieldPodmiotConfig) {
        this.miastoTextFieldPodmiotConfig .setText( miastoTextFieldPodmiotConfig);
    }

    public String getNipTextFieldPodmiotConfig() {
        return nipTextFieldPodmiotConfig.getText();
    }

    public void setNipTextFieldPodmiotConfig(String nipTextFieldPodmiotConfig) {
        this.nipTextFieldPodmiotConfig .setText( nipTextFieldPodmiotConfig);
    }

    public String getRegonTextFieldPodmiotConfig() {
        return regonTextFieldPodmiotConfig.getText();
    }

    public void setRegonTextFieldPodmiotConfig(String regonTextFieldPodmiotConfig) {
        this.regonTextFieldPodmiotConfig .setText( regonTextFieldPodmiotConfig);
    }
    @FXML
    void anulujButtonClick(ActionEvent event) {
        Stage stage = (Stage) anulujButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void okClick1(ActionEvent event) throws IOException {
        Config config = new Config();
        config.setDanePodmiotu(nazwaTextFieldPodmiotConfig.getText(), ulicaTextFieldPodmiotConfig.getText(), kodPocztowyTextFieldPodmiotConfig.getText(),
                miastoTextFieldPodmiotConfig.getText(), nipTextFieldPodmiotConfig.getText(), regonTextFieldPodmiotConfig.getText());

        config.getConfigFromFile();
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();

    }


}
