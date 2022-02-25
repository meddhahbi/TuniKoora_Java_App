/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.EquipeController;
import Models.Equipe;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author mdhah
 */
public class AddEquipeController implements Initializable {

    @FXML
    private TextField nomEq;
    @FXML
    private TextField classementEq;
    @FXML
    private TextField pathImg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(MouseEvent event) {
        
        String nom = nomEq.getText();
        int classement = Integer.parseInt(classementEq.getText());
        String logo = pathImg.getText();
        
        
        
         if (logo.isEmpty() || nom.isEmpty()){
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
             alert.setContentText("Insérer toutes les informations avant de valider l'insertion");
             alert.showAndWait();
               
             
         }else{
             
             Equipe e=new Equipe(1,nom,classement, logo);
             EquipeController ec = new EquipeController();
             ec.ajouterEquipe(e);
            Alert alert = new Alert(AlertType.INFORMATION);
             alert.setHeaderText("Succes");
             alert.setContentText("Equipe Ajoutée!");
                alert.showAndWait();             
         }
        
        
        
    }

    @FXML
    private void clean(MouseEvent event) {
        
         nomEq.setText(null);
        classementEq.setText(null);
      //  logoEq.setText(null);
        pathImg.setText(null);
        
        
    }

    @FXML
    private void saveImg(MouseEvent event) throws FileNotFoundException {
        
        String filename;
        
        
       JFileChooser chooser = new JFileChooser();
       chooser.showOpenDialog(null);
       File f = chooser.getSelectedFile();
       filename = f.getAbsolutePath();
       pathImg.setText(filename);
//       try{
//           File image = new  File(filename);
//           FileInputStream fis = new FileInputStream(image);
//           byte[] buf = new byte[1024];
//          
//           }
//       }catch(Exception e){
//           
       }

        
        
        
    
    
}