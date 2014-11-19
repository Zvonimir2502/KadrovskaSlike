/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadrovskaslike;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import oracle.sql.BLOB;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.LobCreator;

/**
 * FXML Controller class
 *
 * @author LozanciZ
 */
public class JedanRadnikController implements Initializable, ControlledScreen   {
    
    ScreensController myController;
    Djelatnik djelatnik;
    BufferedImage bufferedImage;
    File imgFile;
    Stage stage2;    
    
    @FXML private ImageView slikaView;
    @FXML private Label prezimeImeLbl;
    @FXML private Label matBrLbl; 
    @FXML private Button ucitajSliku;
    @FXML private Button saveDb;
    @FXML Parent root;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        djelatnik = StatDjel.getStatdjel();
        stage2 = StatDjel.getStage();  
        
        if (djelatnik != null){
            Image image2 = null;
            
            ucitajSliku.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {                         
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Odaberite sliku");

                    fileChooser.getExtensionFilters().addAll(
                                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                                    new FileChooser.ExtensionFilter("PNG", "*.png")
                    );                        

                    File file = fileChooser.showOpenDialog(stage2);
                    if (file != null) {
                        imgFile = file;
                        try {
                            bufferedImage = ImageIO.read(file);
                            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                            slikaView.setImage(image);

                            saveDb.setVisible(true);                                
                        } catch (IOException ex) {
                            Logger.getLogger(JedanRadnikController.class.getName()).log(Level.SEVERE, null, ex);
                        }                      
                    }                        
                }
            });                        
            
            if (djelatnik.getFotografija() != null){
            	BufferedImage bufferedImg = null;
            	try {
                    Blob item =djelatnik.getFotografija();
                    byte[] data = item.getBytes(1, (int) item.length());
                    bufferedImg = ImageIO.read(new ByteArrayInputStream(data));
                    image2 = new javafx.scene.image.Image(new ByteArrayInputStream(data)) {};                   
                } catch (IOException e) {
                    Logger.getLogger(RadniciController.class.getName()).log(Level.SEVERE, null, e);
                } catch (SQLException ex) {
                    Logger.getLogger(JedanRadnikController.class.getName()).log(Level.SEVERE, null, ex);
                }
                //imageview.setFitHeight(70);
                //imageview.setFitWidth(50);
                slikaView.setImage(image2);
                final Image inmage3 = image2;
                
                final ContextMenu cm = new ContextMenu();
                MenuItem cmItem1 = new MenuItem("Kopiraj sliku");
                cmItem1.setOnAction(new EventHandler<ActionEvent>() {                                    
                    public void handle(ActionEvent e) {
                        Clipboard clipboard = Clipboard.getSystemClipboard();
                        ClipboardContent content = new ClipboardContent();
                        content.putImage(inmage3);
                        clipboard.setContent(content);
                    }
                });
                MenuItem cmItem2 = new MenuItem("Sačuvaj sliku");
                cmItem2.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("Sačuvaj sliku");
                        fileChooser.setInitialFileName(djelatnik.getPrezimeIme());
                        fileChooser.getExtensionFilters().addAll(
                                new FileChooser.ExtensionFilter("All Images", "*.*"),
                                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                                new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
                                new FileChooser.ExtensionFilter("PNG", "*.png"),
                                new FileChooser.ExtensionFilter("BMP", "*.bmp")
                        ); 

                        File file = fileChooser.showSaveDialog(stage2);
                        if (file != null) {
                            try {   
                            	if (slikaView.isFocused()){
                            		slikaView.setFocusTraversable(false);
                            	}
                            	
                                ImageIO.write(SwingFXUtils.fromFXImage(slikaView.getImage(),null), "jpg", file);
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }
                });
                cm.getItems().add(cmItem1);
                cm.getItems().add(cmItem2);
                if (slikaView != null){
                	slikaView.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        new EventHandler<MouseEvent>() {
                            @Override public void handle(MouseEvent e) {
                                if (e.getButton() == MouseButton.SECONDARY){  
                                    cm.show(slikaView, e.getScreenX(), e.getScreenY());
                                }                                                
                            }
                    });                                                                                         
                }                                
                
            } else {
                ucitajSliku.setVisible(true);                
                
            }
            
            saveDb.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {                                                
                   executeHQLQuery();
                   stage2.close();                     
                }
            });            
            
            prezimeImeLbl.setText(djelatnik.getPrezimeIme());
            matBrLbl.setText(Integer.toString(djelatnik.getBrojIskaznice()));
            
        }
        
    }

    @FXML 
    private void goToMain(ActionEvent event){ 
       myController.setScreen(KadrovskaSlike.MAIN_SCREEN); 
    }    
    
    
    
    
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void executeHQLQuery() {
        
        try {
            
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Blob blob = null;
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] imageInByte = new byte[(int) imgFile.length()];
            
//            try {
//                InputStream bodyIn = new FileInputStream(imgFile);
//                ps.setBinaryStream(2, bodyIn, (int) imgFile.length());
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(JedanRadnikController.class.getName()).log(Level.SEVERE, null, ex);
//            }
            
            try {
                FileInputStream fileInputStream = new FileInputStream(imgFile);
                 //convert file into array of bytes
                fileInputStream.read(imageInByte);
                fileInputStream.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
            
            LobCreator lobc = Hibernate.getLobCreator(session);
            blob = lobc.createBlob(imageInByte);             

            if (blob != null){
                Djelatnik djel = (Djelatnik) session.get(Djelatnik.class, djelatnik.getDjePid());  
                djel.setFotografija(blob);              
                session.update("fotografija",djel); 
                session.getTransaction().commit();
            }
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    
//    /**
//     * Converts a given Image into a BufferedImage
//     *
//     * @param img The Image to be converted
//     * @return The converted BufferedImage
//     */
//    public static BufferedImage toBufferedImage(Image img)
//    {
//        if (img instanceof BufferedImage)
//        {
//            return (BufferedImage) img;
//        }
//
//        // Create a buffered image with transparency
//        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//
//        // Draw the image on to the buffered image
//        Graphics2D bGr = bimage.createGraphics();
//        bGr.drawImage(img, 0, 0, null);
//        bGr.dispose();
//
//        // Return the buffered image
//        return bimage;
//    }    

    
    
    
}
