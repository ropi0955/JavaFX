package com.example.javafx_beadando;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Boolean.parseBoolean;

public class HelloController {


    @FXML public VBox OlvasasMenu;
    @FXML public TableView<Database> tOlvas;

    //Lapok:
    public VBox vbOlvas;
    public VBox vbInsert;
    public VBox vbUpdate;
    public VBox vbShowUpdate;
    public VBox vbDelete;
    public VBox vbRest1Get;
    public VBox vbRest1;
    public HBox mainPage;
    public VBox vbEgyeb;
    public VBox vbParhuzamos;
    public VBox vbRest1Post;

    public TableView tRest1Get;
    //Gombok mütyürkék:
    public ComboBox cbOlvasas;
    public TextField tfOlvas;
    public CheckBox cbSzines;
    public ToggleGroup group;
    public ComboBox cbInsertMufaj;

    //POST
    public TextField tfRest1PostId;
    public ComboBox tfRest1PostStatus;
    public ComboBox tfRest1PostGender;
    public TextField tfRest1PostEmail;
    public TextField tfRest1PostName;
    public Label lResponseRest1Post;
    public TextField tfRest1Delete;
    public VBox vbRest1Delete;
    public Label lDeleted;
    public VBox vbRest1Update;
    public Label lUpdated;
    public TextField tfRest1UpdateId;
    public TextField tfRest1UpdateName;
    public TextField tfRest1UpdateEmail;
    public ComboBox cbRest1UpdateGender;
    public ComboBox cbRest1UpdateStatus;
    public TextField tfRest2PostId;
    public TextField tfRest2PostEmail;
    public TextField tfRest2PostName;
    public Label lResponseRest2Post;
    public TextField tfRest2Delete;
    public VBox vbRest2Delete;
    public Label lDeleted2;
    public VBox vbRest2Update;
    public Label lUpdated2;
    public TextField tfRest2UpdateId;
    public TextField tfRest2UpdateName;
    public TextField tfRest2UpdateEmail;
    public Button bParhuzamos;
    public Label lParhuzamos1;
    public Label lParhuzamos2;
    //public TextField tfStreamId;
    //public ComboBox cbStreamkateg;
    public VBox vbStream;
    public CheckBox cbStreamVega;
    public TableView tStream;
    public ToggleGroup group1;
    public VBox vbRest2Post;
    public TableView tRest2Get;
    public VBox vbRest2Get;
    public VBox vbRest2;
    public ComboBox cbInsertSzines;
    public ComboBox cbInsertSzinkron;
    public TextField tfInsertSzarmazas;
    public TextField tfInsertHossz;
    public TextField tfInsertFilmcim;
    public ComboBox cbShowMozi;
    public TextField tfUpdateMoziNev;
    public TextField tfupdateIrszam;
    public TextField tfupdateCim;
    public TextField tfupdateTelefon;
    public ComboBox cbShowDeleteMozi;
    public ComboBox cbStreamMufaj;
    public CheckBox cbStreamSzines;
    public TextField tfStreamCim;

    @FXML private TableColumn<RestUser, String> RestUserid;
    @FXML private TableColumn<RestUser, String> RestUserName;
    @FXML private TableColumn<RestUser, String> RestUserEmail;
    @FXML private TableColumn<RestUser, String> RestUserGender;
    @FXML private TableColumn<RestUser, String> RestStatus;

    String url="jdbc:mysql://localhost/mozimusor?user=root";
    DatabaseDAO database=new DatabaseDAO(url);
    MoziDAO mozibase=new MoziDAO(url);


    public void Clear()
    {
        mainPage.getChildren().removeAll(mainPage.getChildren());
        cbShowMozi.setDisable(false);
    }

    public void Mutat(String a){
    Clear();

    switch(a){

        case "OlvasMenu":
            mainPage.getChildren().add(OlvasasMenu);
            OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());
            OlvasasMenu.getChildren().add(tOlvas);
            break;
        case "Olvas2Menu":
            mainPage.getChildren().add(OlvasasMenu);
            OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());
            OlvasasMenu.getChildren().addAll(vbOlvas,tOlvas);
            break;
        case "Insert":
            mainPage.getChildren().add(OlvasasMenu);
            OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());

            cbInsertMufaj.getItems().removeAll(cbInsertMufaj.getItems());
            cbInsertMufaj.getItems().addAll(database.Mufajok());

            cbInsertSzinkron.getItems().removeAll(cbInsertSzinkron.getItems());
            cbInsertSzinkron.getItems().addAll("fel","mb");

            cbInsertSzines.getItems().removeAll(cbInsertSzines.getItems());
            cbInsertSzines.getItems().addAll("true","false");

            OlvasasMenu.getChildren().addAll(vbInsert);
            break;
        case "Update":
            mainPage.getChildren().add(OlvasasMenu);
            OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());
            cbShowMozi.getItems().removeAll(cbShowMozi.getItems());
            cbShowMozi.getItems().addAll(mozibase.getMoziNev());
            OlvasasMenu.getChildren().addAll(vbUpdate);
            break;
        case "ShowUpdate":
            mainPage.getChildren().add(OlvasasMenu);
            OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());
            OlvasasMenu.getChildren().addAll(vbUpdate,vbShowUpdate);
            break;
        case "Delete":
            mainPage.getChildren().add(OlvasasMenu);
            OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());
            cbShowDeleteMozi.getItems().removeAll(cbShowDeleteMozi.getItems());
            cbShowDeleteMozi.getItems().addAll(mozibase.getMoziNev());
            OlvasasMenu.getChildren().addAll(vbDelete);
            break;
        case "Rest1Get":
            mainPage.getChildren().add(vbRest1);
            vbRest1.getChildren().removeAll(vbRest1.getChildren());
            vbRest1.getChildren().addAll(vbRest1Get);
            break;
        case "Rest1Post":
            mainPage.getChildren().add(vbRest1);
            vbRest1.getChildren().removeAll(vbRest1.getChildren());
            tfRest1PostStatus.getItems().removeAll(tfRest1PostStatus.getItems());
            tfRest1PostGender.getItems().removeAll(tfRest1PostGender.getItems());
            tfRest1PostGender.getItems().addAll("male","female");
            tfRest1PostStatus.getItems().addAll("active","inactive");
            vbRest1.getChildren().addAll(vbRest1Post);
            break;
        case "Rest1Delete":
            mainPage.getChildren().add(vbRest1);
            vbRest1.getChildren().removeAll(vbRest1.getChildren());
            vbRest1.getChildren().addAll(vbRest1Delete);
            break;
        case "Rest1Update":
            mainPage.getChildren().add(vbRest1);
            vbRest1.getChildren().removeAll(vbRest1.getChildren());
            cbRest1UpdateGender.getItems().removeAll(cbRest1UpdateGender.getItems());
            cbRest1UpdateStatus.getItems().removeAll(cbRest1UpdateStatus.getItems());
            cbRest1UpdateGender.getItems().addAll("male","female");
            cbRest1UpdateStatus.getItems().addAll("active","inactive");
            vbRest1.getChildren().addAll(vbRest1Update);
            break;
        case "Parhuzamos":
            mainPage.getChildren().add(vbEgyeb);
            vbEgyeb.getChildren().removeAll(vbEgyeb.getChildren());
            vbEgyeb.getChildren().addAll(vbParhuzamos);
            break;
        case "Stream":
            mainPage.getChildren().add(vbEgyeb);
            vbEgyeb.getChildren().removeAll(vbEgyeb.getChildren());
            vbEgyeb.getChildren().addAll(vbStream);
            break;
    }


    }

    public  void Tabla(String a)
    {
        ArrayList<Database> filmek = database.getAll(a);

        if(filmek == null || filmek.isEmpty())
        {
            tOlvas.getItems().removeAll(tOlvas.getItems());
            tOlvas.getColumns().removeAll(tOlvas.getColumns());
            TableColumn filmnev = new TableColumn("Nincs adat");
            tOlvas.getColumns().addAll(filmnev);
            filmnev.setCellValueFactory(new PropertyValueFactory<>("filmcim"));

            tOlvas.getItems().add(new Database("Nincs ilyen adat!","Nincs","Nincs","Nincs","Nincs","nincs",false));
        }
        else
        {
            tOlvas.getItems().removeAll(tOlvas.getItems());
            tOlvas.getColumns().removeAll(tOlvas.getColumns());

            TableColumn filmcim = new TableColumn("Film");
            TableColumn szarmazas = new TableColumn("Származási hely");
            TableColumn mufaj = new TableColumn("Műfaj");
            TableColumn mozinev = new TableColumn("Mozi");
            TableColumn cim = new TableColumn("Mozi címe");
            TableColumn szinkron = new TableColumn("Nyelv");
            TableColumn szines = new TableColumn("Színes");

            tOlvas.getColumns().addAll(filmcim,szarmazas,mufaj,mozinev,cim,szinkron,szines);

            filmcim.setCellValueFactory(new PropertyValueFactory<>("filmcim"));
            szarmazas.setCellValueFactory(new PropertyValueFactory<>("szarmazas"));
            mufaj.setCellValueFactory(new PropertyValueFactory<>("mufaj"));
            mozinev.setCellValueFactory(new PropertyValueFactory<>("mozinev"));
            cim.setCellValueFactory(new PropertyValueFactory<>("cim"));
            szinkron.setCellValueFactory(new PropertyValueFactory<>("szinkron"));
            szines.setCellValueFactory(new PropertyValueFactory<>("szines"));

            for(int i = 0; i < filmek.size(); i++ )
            {
                tOlvas.getItems().add(filmek.get(i));
            }
        }
    }

    @FXML
    private void initialize()
    {
        Clear();
    }

    public void Olvasas(ActionEvent actionEvent) {

        Mutat("OlvasMenu");
        Tabla("");
    }

    public void Olvasas2(ActionEvent actionEvent) {
        Mutat("Olvas2Menu");
        Tabla("");
        cbOlvasas.getItems().add(null);
        cbOlvasas.getItems().addAll(database.Mufajok());
    }

    @FXML
    protected void Insert(ActionEvent actionEvent){
        Mutat("Insert");
    }

    public void Rest1Get(ActionEvent actionEvent) throws IOException {
        Mutat("Rest1Get");
        Rest1Tabla();

    }

    public void Rest1Tabla() throws IOException {
        tRest1Get.getItems().removeAll(tRest1Get.getItems());
        tRest1Get.getColumns().removeAll(tRest1Get.getColumns());
        RestUser[] user = RestKliens.GET("https://gorest.co.in/public/v2/users");

        RestUserid = new TableColumn("ID");
        RestUserName = new TableColumn("Felhasználónév");
        RestUserEmail = new TableColumn("Email");
        RestUserGender = new TableColumn("Gender");
        RestStatus = new TableColumn("Státusz");

        tRest1Get.getColumns().addAll(RestUserid, RestUserName,RestUserEmail,RestUserGender,RestStatus);

        RestUserid.setCellValueFactory(new PropertyValueFactory<>("id"));
        RestUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        RestUserEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        RestUserGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        RestStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tRest1Get.getItems().addAll(user);
    }

    public void Rest1Post(ActionEvent actionEvent) {
        Mutat("Rest1Post");
    }

    public void Rest1PostDo(ActionEvent actionEvent) throws IOException {
        RestUser user = new RestUser(Integer.parseInt(tfRest1PostId.getText()),tfRest1PostName.getText(),tfRest1PostEmail.getText(),tfRest1PostGender.getSelectionModel().getSelectedItem().toString(),tfRest1PostStatus.getSelectionModel().getSelectedItem().toString());
        lResponseRest1Post.setText("Válasz:" + RestKliens.POST(user,"https://gorest.co.in/public/v2/users?access-token=ac3cfbe3aff6093675c6c8df54b71a5ad482fcf498d66692ab21c7e54af62e12"));
    }

    public void Rest1Delete(ActionEvent actionEvent) { Mutat("Rest1Delete"); }

    public void DoRest1Delete(ActionEvent actionEvent) throws IOException {
        String id = tfRest1Delete.getText();
        String re = RestKliens.DELETE("https://gorest.co.in/public/v2/users/"+id+"?access-token=ac3cfbe3aff6093675c6c8df54b71a5ad482fcf498d66692ab21c7e54af62e12");
        if(re == "Hiba!") lDeleted.setText("Hiba, nincs ilyen id!");
        else  lDeleted.setText("Sikeres törlés!");
    }

    public void Rest1Update(ActionEvent actionEvent) { Mutat("Rest1Update"); }

    public void DoRest1Update(ActionEvent actionEvent) throws IOException {
        RestUser user = new RestUser(Integer.parseInt(tfRest1UpdateId.getText()),tfRest1UpdateName.getText(),tfRest1UpdateEmail.getText(),cbRest1UpdateGender.getSelectionModel().getSelectedItem().toString(),cbRest1UpdateStatus.getSelectionModel().getSelectedItem().toString());
        if(RestKliens.PUT(user,"https://gorest.co.in/public/v2/users/"+user.getId()+"?access-token=ac3cfbe3aff6093675c6c8df54b71a5ad482fcf498d66692ab21c7e54af62e12") == "Hiba!") lUpdated.setText("Az id nem megfelelő vagy az email foglalt.");
        else lUpdated.setText("Sikeres");
    }

    public void Rest2Get(ActionEvent actionEvent) {
    }

    public void Rest2Post(ActionEvent actionEvent) {
    }

    public void Rest2Delete(ActionEvent actionEvent) {
    }

    public void Rest2Update(ActionEvent actionEvent) {
    }

    public void Parhuzamos(ActionEvent actionEvent) {
        Mutat("Parhuzamos");
    }

    public void DoAThing(ActionEvent actionEvent)
    {
        Thread thread1 = new Thread(() -> {
            try {
                while(true)
                {
                    Platform.runLater(() -> lParhuzamos1.setText("Párhuzamos"));
                    Thread.sleep(2000);
                    Platform.runLater(() -> lParhuzamos1.setText(""));
                    Thread.sleep(2000);
                }
            }
            catch (Exception exc) {
                // should not be able to get here...
                throw new Error("Unexpected interruption");
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            try {
                while (true)
                {
                    Platform.runLater(() -> lParhuzamos2.setText("Párhuzamos2"));
                    Thread.sleep(3000);
                    Platform.runLater(() -> lParhuzamos2.setText(""));
                    Thread.sleep(3000);
                }
            }
            catch (Exception exc) {
                // should not be able to get here...
                throw new Error("Unexpected interruption");
            }
        });
        thread2.start();
    }

    public void Stream(ActionEvent actionEvent) {
        Mutat("Stream");
        cbStreamMufaj.getItems().removeAll(cbStreamMufaj.getItems());
        cbStreamMufaj.getItems().add(null);
        cbStreamMufaj.getItems().addAll(database.Mufajok());
    }


    public void Filter(ActionEvent actionEvent) {
        //boolean helper = false;
        String le ="";
        if(!tfOlvas.getText().isEmpty())
        {

            le +=" and filmcim = '" + tfOlvas.getText()+"'";
            //helper = true;
        }
        if(cbOlvasas.getSelectionModel().getSelectedItem() != null)
        {
            le += " and film.mufaj = '" + cbOlvasas.getSelectionModel().getSelectedItem()+"'";
            }
        if(group.getSelectedToggle() != null)
        {
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String toogleGroupValue = selectedRadioButton.getText();
            le += " and film.szinkron = '" + toogleGroupValue + "'";
        }
        if(cbSzines.isSelected())
        {

            le+= " and film.szines = 0" ;

        }

        Tabla(le);
        Mutat("Olvas2Menu");
    }

    public void InsertToTable(ActionEvent actionEvent) {

        String filmcim = tfInsertFilmcim.getText();
        String mufaj = cbInsertMufaj.getSelectionModel().getSelectedItem().toString();
        String szinkron=cbInsertSzinkron.getSelectionModel().getSelectedItem().toString();
        String szines=cbInsertSzines.getSelectionModel().getSelectedItem().toString();
        String szarmazas=tfInsertSzarmazas.getText();
        int hossz=0;
        try {
           hossz= Integer.parseInt(tfInsertHossz.getText());
        }catch (NumberFormatException e) {
            hossz=0;
        }
        database.InsertFilm(filmcim,mufaj,szinkron,szines,szarmazas,hossz);
        Mutat("");
    }

    public void Update(ActionEvent actionEvent) {
        Mutat("Update");
    }

    public void ShowUpdate(ActionEvent actionEvent) {
        Mutat("ShowUpdate");
        if(cbShowMozi.getSelectionModel().getSelectedItem() == null) Mutat("");
        else
        {
           Mozi kiir = mozibase.getMozi(cbShowMozi.getSelectionModel().getSelectedItem().toString());
            tfUpdateMoziNev.setText(kiir.getMozinev());
            tfupdateIrszam.setText(String.valueOf(kiir.getIrszam()));
            tfupdateCim.setText(String.valueOf(kiir.getCim()));
            tfupdateTelefon.setText(String.valueOf(kiir.getTelefon()));
            cbShowMozi.setDisable(true);
        }

    }

    public void UpdateMozi(ActionEvent actionEvent) {

        Mozi a= mozibase.getMozi(tfUpdateMoziNev.getText());

        Mozi update = new Mozi(a.getMoziazon(),tfUpdateMoziNev.getText(),Integer.parseInt(tfupdateIrszam.getText()),tfupdateCim.getText(),tfupdateTelefon.getText());
        mozibase.UpdateMozi(update);
        cbShowMozi.setDisable(false);
        cbShowMozi.getItems().removeAll(cbShowMozi.getItems());
        Mutat("Update");


    }

    public void Delete(ActionEvent actionEvent) {
        Mutat("Delete");
    }

    public void DeleteMozi(ActionEvent actionEvent) {

        String dMozi = cbShowDeleteMozi.getSelectionModel().getSelectedItem().toString();
        mozibase.deleteMozi(dMozi);
        cbShowDeleteMozi.getItems().removeAll(cbShowDeleteMozi.getItems());
        Mutat("Delete");

    }


    public void FilterStream(ActionEvent actionEvent) {
        ArrayList<Database> adat = database.getAll("");
        ArrayList<String> DataB = new ArrayList<>();
        System.out.println( adat.get(0).toString());
        for(int i =0; i < adat.size(); i++)
        {
            DataB.add(adat.get(i).toString());
        }
        String le ="";
        if(!tfStreamCim.getText().isEmpty())
        {
            le +="^"+tfStreamCim.getText()+",.*";
        }

        System.out.println(le);

                if(cbStreamMufaj.getSelectionModel().getSelectedItem() != null) {
            le += ".*" + cbStreamMufaj.getSelectionModel().getSelectedItem() + ",.*";
        }
        System.out.println(le);

        if(group1.getSelectedToggle() != null )
        {
            RadioButton selectedRadioButton = (RadioButton) group1.getSelectedToggle();
            String toogleGroupValue = selectedRadioButton.getText();
            le += ".*," + toogleGroupValue + ",.*";
        }
        System.out.println(le);

        if(cbStreamSzines.isSelected())
        {
            le+= "false$" ;

        }else{ le+= "true$" ;}

        System.out.println(le);
        Pattern pattern = Pattern.compile(le);

        List<String> matching = DataB.stream()
                .filter(pattern.asPredicate())
                .collect(Collectors.toList());

        System.out.println(matching);

        ArrayList<Database> StreamRned = new ArrayList<>();
        for(int i = 0 ; i < matching.size(); i++)
        {
            String a[] = matching.get(i).split(",");



            //Database b = new Database(Integer.parseInt(a[0]),Integer.parseInt(a[1]),Integer.parseInt(a[2]),a[3],a[4],a[5],a[6],parseBoolean(a[7]));
            Database b = new Database(a[0],a[1],a[2],a[3],a[4],a[5],parseBoolean(a[6]));
            StreamRned.add(b);
        }
        tStream.getItems().removeAll(tStream.getItems());
        tStream.getColumns().removeAll(tStream.getColumns());

        TableColumn filmcim = new TableColumn("Filmcim");
        TableColumn szarmazas = new TableColumn("Származás");
        TableColumn mufaj = new TableColumn("Műfaj");
        TableColumn mozinev = new TableColumn("Mozinév");
        TableColumn cim = new TableColumn("Cim");
        TableColumn szinkron = new TableColumn("Szinkron");
        TableColumn szines = new TableColumn("Szines");


        tStream.getColumns().addAll(filmcim,szarmazas,mufaj,mozinev,cim,szinkron,szines);

        filmcim.setCellValueFactory(new PropertyValueFactory<>("Filmcim"));
        szarmazas.setCellValueFactory(new PropertyValueFactory<>("Szarmazas"));
        mufaj.setCellValueFactory(new PropertyValueFactory<>("Mufaj"));
        mozinev.setCellValueFactory(new PropertyValueFactory<>("Mozinev"));
        cim.setCellValueFactory(new PropertyValueFactory<>("Cim"));
        szinkron.setCellValueFactory(new PropertyValueFactory<>("Szinkron"));
        szines.setCellValueFactory(new PropertyValueFactory<>("Szines"));

        tStream.getItems().addAll(StreamRned);

    }


    public void Szamlainformáciok(ActionEvent actionEvent) {
    }

    public void AktualAr(ActionEvent actionEvent) {
    }

    public void HistorikuAar(ActionEvent actionEvent) {
    }

    public void PoziciNnyit(ActionEvent actionEvent) {
    }

    public void PozícioZar(ActionEvent actionEvent) {
    }

    public void NyitottPoz(ActionEvent actionEvent) {
    }
}