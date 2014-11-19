/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadrovskaslike;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author LozanciZ
 */
public class RadniciController implements Initializable, ControlledScreen  {
    ScreensController myController;
    
    @FXML private TextField matBrTxt;
    @FXML private TextField prezimeImeTxt;
    @FXML private Button runBtn;
//    @FXML private Button btnTest;
    @FXML private TableView<Djelatnik> radnici;
    @FXML private CheckBox sviAktivni;
    @FXML private CheckBox imaSliku;
    @FXML private Label noDjelatnik;
    
     private TableColumn<Djelatnik,Blob> slikaCol = new TableColumn<Djelatnik,Blob>("fotografija");
     private TableColumn<Djelatnik,String> prezimeImeCol = new TableColumn<Djelatnik,String>("Prezime ime");
     private TableColumn<Djelatnik,String> matBrCol = new TableColumn<Djelatnik,String>("Matični broj");
     private TableColumn<Djelatnik,String> datumOdlaska = new TableColumn<Djelatnik,String>("Datum odlaska");
    
    //private static String QUERY_BASED_ON_NAZIV="from Djelatnik a where a.prezimeIme like '%";
    //private static String QUERY_BASED_ON_MATBR="from Djelatnik a where a.brojIskaznice like '";         
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //prezimeImeTxt.setText("LOZ%");        
        //final Stage stageTheLabelBelongs = (Stage) prezimeImeTxt.getScene().getWindow();
        
        runBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {  
                System.out.println("Jesam"+prezimeImeTxt.getText());
                
                runQueryBasedOnColumns();
                String[] args = {};
                TestReportCall.main(args);
                
//                InputStream stream = this.getClass().getResourceAsStream("/rpt/Pregled_korisnika.jasper");
//                
//                JRDataSource yourDataSource = null;
//                ReportUtil.showReport(stream, null, yourDataSource);                  
            }
        });
        
//        btnTest.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {  
//                
//                Raw.updateRaw(1);
//            }
//        });
        
        radnici.autosize();
        radnici.getColumns().removeAll();        
        radnici.setTableMenuButtonVisible(true);
        
        slikaCol = new TableColumn<Djelatnik,Blob>("fotografija");       
        slikaCol.setCellValueFactory(new PropertyValueFactory("fotografija"));
        slikaCol.setPrefWidth(250); 
        
        prezimeImeCol = new TableColumn<Djelatnik,String>("Prezime ime");
        prezimeImeCol.setCellValueFactory(new PropertyValueFactory("prezimeIme"));
        prezimeImeCol.setPrefWidth(150); 
         
        matBrCol = new TableColumn<Djelatnik,String>("Matični broj");
        matBrCol.setCellValueFactory(new PropertyValueFactory("brojIskaznice"));
        matBrCol.setPrefWidth(120);          
        
        slikaCol.setSortable(false);
        
        datumOdlaska = new TableColumn<Djelatnik,String>("Datum odlaska");
        datumOdlaska.setCellValueFactory(new PropertyValueFactory("datumOdlaska"));
        datumOdlaska.setPrefWidth(120);
        radnici.getColumns().addAll(slikaCol,prezimeImeCol,matBrCol,datumOdlaska);
        
    }    

    @Override
    public void setScreenParent(ScreensController screenParent) {        
        myController = screenParent;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @FXML 
    private void goToMain(ActionEvent event){ 
       myController.setScreen(KadrovskaSlike.MAIN_SCREEN); 
    }
    
    private void runQueryBasedOnColumns() {
        String sqlStr = "";
        if (sviAktivni.isSelected()){
            sqlStr = "from Djelatnik a where a.datumOdlaska is null ";
        }
        
        if (imaSliku.isSelected()){
            if (sqlStr.equals("")){
                sqlStr ="from Djelatnik a where a.fotografija is null "; 
            } else {
                sqlStr =sqlStr+" and a.fotografija is null "; 
            }      
        }
        
        if (prezimeImeTxt.getText() != null && prezimeImeTxt.getText().trim().length()>0){
            if (sqlStr.equals("")){
                sqlStr ="from Djelatnik a where a.prezimeIme like '%"+ prezimeImeTxt.getText() + "%'"; 
            } else {
                sqlStr =sqlStr+" and a.prezimeIme like '%"+ prezimeImeTxt.getText() + "%'"; 
            }           
        }
        
        if (matBrTxt.getText() != null && matBrTxt.getText().trim().length()>0){
            if (sqlStr.equals("")){
                sqlStr ="from Djelatnik a where a.brojIskaznice like '%"+ matBrTxt.getText() + "%'"; 
            } else {
                sqlStr =sqlStr+" and a.brojIskaznice like '%"+ matBrTxt.getText() + "%'"; 
            }           
        }
        
        executeHQLQuery(sqlStr);
    }
    
//        Task task = new Task<Void>() {
//            @Override public Void call() {
//                static final int max = 1000000;
//                for (int i=1; i<=max; i++) {
//                    if (isCancelled()) {
//                       break;
//                    }
//                    updateProgress(i, max);
//                }
//                return null;
//            }
//        };     
        
    private void executeHQLQuery(String hql) {
        
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            Integer no = resultList.size();
            noDjelatnik.setText(no.toString());
            displayResult(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        runQueryBasedOnColumns();
    } 
    
    private void clickShow(ActionEvent event,Djelatnik djel) throws IOException {
        StatDjel stat = new StatDjel();
        stat.setStatdjel(djel);
        Stage stage = new Stage();
        stat.setStage(stage);
        Parent root = FXMLLoader.load(ScreensController.class.getResource("JedanRadnik.fxml"));
        stage.setScene(new Scene(root));       
        stage.setTitle("My modal window");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow() );        
        stage.show();
    }    
    
    private void displayResult(List resultList) {
        
        if (radnici.getItems() != null) {
            radnici.getItems().clear();
            radnici.getItems().removeAll(resultList);
        }        
        List<Djelatnik> list = new ArrayList<Djelatnik>();
        for(Object o : resultList) {
            Djelatnik radn = (Djelatnik)o;
            list.add(radn);
            //Vector<Object> oneRow = new Vector<Object>();
            //oneRow.add(radnik.getFotografija());
            //oneRow.add(radnik.getPrezimeIme());
            //oneRow.add(radnik.getBrojIskaznice());
            //tableData.add(oneRow);
        }        
        ObservableList<Djelatnik> djel = FXCollections.observableList(list);
        //ObservableList<Djelatnik> radnik = FXCollections.observableArrayList();
        
        //Vector<String> tableHeaders = new Vector<String>();
        //Vector tableData = new Vector();
        //tableHeaders.add("Username"); 
        //tableHeaders.add("Naziv");
        //tableHeaders.add("Email");
        //tableHeaders.add("Broj kratki");
        //List<Djelatnik> list = new ArrayList<Djelatnik>();
        //ObservableList<Djelatnik> djel = FXCollections.observableList(list);
        
        radnici.setItems(djel);//   setModel(new DefaultTableModel(tableData, tableHeaders));        
        
        slikaCol.setCellFactory(new Callback<TableColumn<Djelatnik,Blob>,TableCell<Djelatnik,Blob>>(){        
            
            @Override
            public TableCell<Djelatnik,Blob> call(TableColumn<Djelatnik,Blob> param) {                
                TableCell<Djelatnik,Blob> cell = new TableCell<Djelatnik,Blob>(){
                    @Override
                    public void updateItem(Blob item, boolean empty) {                                               
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                            setGraphic(null);
                        } else {                           
                            try {
                                HBox box= new HBox();
                                box.setSpacing(10) ;
                                //VBox vbox = new VBox();
                                //vbox.getChildren().add(new Label("Slika"));
                                Image image2 = null;
                                
                                try {
                                    byte[] data = item.getBytes(1, (int) item.length());                               
                                    BufferedImage bufferedImg = ImageIO.read(new ByteArrayInputStream(data));
                                    image2 = new javafx.scene.image.Image(new ByteArrayInputStream(data)) {};
                                } catch(IOException e) {
                                    Logger.getLogger(RadniciController.class.getName()).log(Level.SEVERE, null, e);   
                                }
                                ImageView imageview = new ImageView();
                                //imageview.setFitHeight(70);
                                //imageview.setFitWidth(50);
                                if (image2 != null){
                                    imageview.setImage(image2);
                                //imageview.setImage(new javafx.scene.image.Image(KadrovskaSlike.class.getResource("img").toString()+"/1.jpg"));
                                }
                                final Image imag2 = image2;
                                final ContextMenu cm = new ContextMenu();
                                MenuItem cmItem1 = new MenuItem("Copy Image");
                                cmItem1.setOnAction(new EventHandler<ActionEvent>() {                                    
                                    Image imag = imag2;
                                    public void handle(ActionEvent e) {
                                        Clipboard clipboard = Clipboard.getSystemClipboard();
                                        ClipboardContent content = new ClipboardContent();
                                        content.putImage(imag);
                                        clipboard.setContent(content);
                                    }
                                });
                                
                                MenuItem cmItem2 = new MenuItem("Save Image");
                                    cmItem2.setOnAction(new EventHandler<ActionEvent>() {
                                        public void handle(ActionEvent e) {
                                            FileChooser fileChooser = new FileChooser();
                                            fileChooser.setTitle("Save Image");
                                            Stage stage = myController.stage;
                                            File file = fileChooser.showSaveDialog(stage);
                                            if (file != null) {
                                                try {
                                                    ImageIO.write(SwingFXUtils.fromFXImage(imageview.getImage(),
                                                        null), "jpg", file);
                                                } catch (IOException ex) {
                                                    System.out.println(ex.getMessage());
                                                }
                                            }
                                        }
                                    }
                                );                                

                                cm.getItems().add(cmItem1);
                                cm.getItems().add(cmItem2);
                                if (imageview != null){
                                    imageview.addEventHandler(MouseEvent.MOUSE_CLICKED,
                                        new EventHandler<MouseEvent>() {
                                            @Override public void handle(MouseEvent e) {
                                                if (e.getButton() == MouseButton.SECONDARY){  
                                                    cm.show(imageview, e.getScreenX(), e.getScreenY());
                                                }                                                
                                            }
                                    });
                                    box.getChildren().addAll(imageview);//,vbox);
                                    //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
                                    setGraphic(box);
                                } else {
                                    box.getChildren().clear();
                                    setGraphic(box);
                                }
                                

                            } catch (SQLException ex) {
                                Logger.getLogger(RadniciController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                };
                System.out.println(cell.getIndex());
                cell.addEventHandler(MouseEvent.MOUSE_CLICKED,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
                            if (e.getClickCount() == 2) {
                            Djelatnik djel = (Djelatnik) radnici.getItems().get(((TableCell)e.getSource()).getIndex());
                            System.out.println("person" + djel.getDjePid());                                
                            ActionEvent ae = new ActionEvent(e.getSource(), null);                            
                                try {    
                                    clickShow(ae,djel);
                                } catch (IOException ex) {
                                    Logger.getLogger(RadniciController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }                                                
                        }
                });                               
                return cell;
            }
            
        });        
        
    }
    
  static class TestTask extends Task<Void> {
    private final int waitTime; // milliseconds
    private final int pauseTime; // milliseconds
    public static final int NUM_ITERATIONS = 100;

    TestTask(int waitTime, int pauseTime) {
      this.waitTime = waitTime;
      this.pauseTime = pauseTime;
    }

    @Override
    protected Void call() throws Exception {
      this.updateProgress(ProgressIndicator.INDETERMINATE_PROGRESS, 1);
      this.updateMessage("Waiting...");
      Thread.sleep(waitTime);
      this.updateMessage("Running...");
      for (int i = 0; i < NUM_ITERATIONS; i++) {
        updateProgress((1.0 * i) / NUM_ITERATIONS, 1);
        Thread.sleep(pauseTime);
      }
      this.updateMessage("Done");
      this.updateProgress(1, 1);
      return null;
    }
  }
}
