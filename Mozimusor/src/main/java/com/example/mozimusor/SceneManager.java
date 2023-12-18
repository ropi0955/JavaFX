package com.example.mozimusor;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;


public class SceneManager {
    private final String SUCCESS = "sikeres mentes";
    private final String FAILED = "hiba tortent";
    private final String SAVE = "mentes";
    private final String DELETE = "torles";

    private final VBox root;

    public SceneManager(VBox root) {
        this.root = root;
    }

    private void removePane() {
        root.getChildren().remove(1,2);
    }
    private GridPane generateBaseForm() {
        GridPane form = new GridPane();
        form.setPadding(new Insets(25,25,25,25));
        form.setVgap(10);
        form.setHgap(10);
        form.setAlignment(Pos.CENTER);

        return form;
    }

    public MenuBar generateMenu() {
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Adatbazis");
        Menu rest = new Menu("Rest1");
        Menu parallel = new Menu("Párhuzamos");

        MenuItem restCreate = new MenuItem("Create");
        restCreate.setOnAction(actionEvent -> {
            removePane();
            root.getChildren().add(generateRestCreate());
        });
        MenuItem restRead = new MenuItem("Read");
        restRead.setOnAction(actionEvent -> {
            removePane();
            root.getChildren().add(generateRestRead());
        });
        MenuItem restUpdate = new MenuItem("Update");
        restUpdate.setOnAction(actionEvent -> {
            removePane();
            root.getChildren().add(generateRestUpdate());
        });
        MenuItem restDelete = new MenuItem("Delete");
        restDelete.setOnAction(actionEvent -> {
            removePane();
            root.getChildren().add(generateRestDelete());
        });


        MenuItem parallelAlt = new MenuItem("Parhuzamos");
        parallelAlt.setOnAction(actionEvent -> {
            removePane();
            root.getChildren().add(generateParallel());
        });

        MenuItem read = new MenuItem("Olvas");
        read.setOnAction(actionEvent -> {
            removePane();
            root.getChildren().add(generateRead());
        });
        MenuItem read1 = new MenuItem("Olvas1");
        read1.setOnAction(actionEvent -> {
            removePane();
            root.getChildren().add(generateRead2Form());
        });
        MenuItem write = new MenuItem("Ir");
        write.setOnAction(actionEvent -> {
            removePane();
            root.getChildren().add(generateInsertForm());
        });
        MenuItem edit = new MenuItem("Modosit");
        edit.setOnAction(actionEvent -> {
            removePane();
            root.getChildren().add(generateEditForm());
        });
        MenuItem delete = new MenuItem("Torol");
        delete.setOnAction(actionEvent -> {
            removePane();
            root.getChildren().add(generateDelete());
        });


        menu.getItems().add(read);
        menu.getItems().add(read1);
        menu.getItems().add(write);
        menu.getItems().add(edit);
        menu.getItems().add(delete);

        parallel.getItems().add(parallelAlt);

        rest.getItems().add(restRead);
        rest.getItems().add(restCreate);
        rest.getItems().add(restUpdate);
        rest.getItems().add(restDelete);

        menuBar.getMenus().add(menu);
        menuBar.getMenus().add(parallel);
        menuBar.getMenus().add(rest);

        Menu menuRest = new Menu("RestApi");
        menuRest.getItems().add(new MenuItem("Rest1"));

        return menuBar;
    }

    private GridPane generateRestDelete() {
        GridPane form = generateBaseForm();
        Label msg = new Label();
        msg.setWrapText(true);

        Label idLabel = new Label("id: ");
        TextField id = new TextField();
        id.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                id.setText(newValue.replaceAll("\\D", ""));
            }
        });

        Button sendButton = new Button("felhasznalo torlese");
        sendButton.setOnAction(actionEvent -> {
            try {
                String response = RestAPI.delete("https://gorest.co.in/public/v2/users/" + id.getText());
                System.out.println(response);
                msg.setText("Sikeres torles");
            } catch (IOException ex) {
                ex.printStackTrace();
                msg.setText("Hiba a rest hivas kozben!");
            }
        });

        form.add(idLabel, 0,0);
        form.add(id, 0,1);
        form.add(sendButton, 0, 2);
        form.add(msg, 0,3);

        return form;
    }

    private GridPane generateRestUpdate() {
        GridPane form = generateBaseForm();
        Label msg = new Label();
        msg.setWrapText(true);

        Label idLabel = new Label("id: ");
        Label nameLabel = new Label("name: ");
        Label genderLabel = new Label("gender: ");
        Label emailLabel = new Label("email: ");
        Label activeLabel = new Label("active: ");

        TextField id = new TextField();
        id.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                id.setText(newValue.replaceAll("\\D", ""));
            }
        });
        TextField name = new TextField();
        ComboBox<String> gender = new ComboBox<>(FXCollections.observableArrayList("", "male", "female"));
        TextField email = new TextField();
        CheckBox active = new CheckBox();

        Button sendButton = new Button("felhasznalo frissitese");
        sendButton.setOnAction(actionEvent -> {
            try {
                String response = RestAPI.put("https://gorest.co.in/public/v2/users/" + id.getText(), generateUpdateJson(name, gender, email, active));
                System.out.println(response);
                msg.setText("Sikeres frissites");
            } catch (IOException ex) {
                ex.printStackTrace();
                msg.setText("Hiba a rest hivas kozben!");
            }
        });

        form.add(idLabel, 0,0);
        form.add(id, 0,1);
        form.add(nameLabel, 0,2);
        form.add(name, 0,3);
        form.add(genderLabel, 0,4);
        form.add(gender, 0,5);
        form.add(emailLabel, 0,6);
        form.add(email, 0,7);
        form.add(activeLabel, 0,8);
        form.add(active, 1,8);
        form.add(sendButton, 0, 9);
        form.add(msg, 0,10);

        return form;
    }

    private String generateUpdateJson(TextField name, ComboBox<String> gender, TextField email, CheckBox active) {
        StringBuilder sb = new StringBuilder("{");
        if(name.getText() != null && !name.getText().isBlank()) {
            sb.append("\"name\":\"").append(name.getText()).append("\",");
        }
        if (gender.getValue() != null && !gender.getValue().isBlank()) {
            sb.append("\"gender\":\"").append(gender.getValue()).append("\",");
        }
        if (email.getText() != null && !email.getText().isBlank()) {
            sb.append("\"email\":\"").append(email.getText()).append("\",");
        }
        sb.append("\"status\":\"").append(active.isSelected()? "active":"inactive" ).append("\",");

        sb.append("}");

        System.out.println("generated json string in generateUpdateJson: ");
        System.out.println(sb.toString().replace(",}", "}"));

        return sb.toString().replace(",}", "}");
    }

    private GridPane generateRestRead() {
        GridPane form = generateBaseForm();

        Label msg = new Label();
        msg.setWrapText(true);

        try {
            String response = RestAPI.get("https://gorest.co.in/public/v2/users");
            System.out.println(response);
            msg.setText(response.replace("},{", "},\n{" ));
        } catch (IOException ex) {
            msg.setText("Hiba a rest hiv's kozben!");
        }

        form.add(msg, 0,1);

        return form;
    }

    private GridPane generateRestCreate() {
        GridPane form = generateBaseForm();

        Label msg = new Label();
        msg.setWrapText(true);

        Label nameLabel = new Label("name: ");
        Label genderLabel = new Label("gender: ");
        Label emailLabel = new Label("email: ");
        Label activeLabel = new Label("active: ");

        TextField name = new TextField();
        ComboBox<String> gender = new ComboBox<>(FXCollections.observableArrayList("male", "female"));
        TextField email = new TextField();
        CheckBox active = new CheckBox();

        Button sendButton = new Button("felhasznalo letrehozasa");
        sendButton.setOnAction(actionEvent -> {
            try {
                String response = RestAPI.post("https://gorest.co.in/public/v2/users",
                        String.format("{\"name\":\"%s\", " +
                                "\"gender\":\"%s\", " +
                                "\"email\":\"%s\", " +
                                "\"status\":\"%s\"}", name.getText(), gender.getValue(), email.getText(), active.isSelected() ? "active" : "inactive"));
                System.out.println("sikeres letrehozas");
                msg.setText(response);
            } catch (IOException ex) {
                msg.setText("Hiba a rest hivas kozben!");
            }
        });

        form.add(nameLabel, 0,0);
        form.add(name, 0,1);
        form.add(genderLabel, 0,2);
        form.add(gender, 0,2);
        form.add(emailLabel, 0,3);
        form.add(email, 0,4);
        form.add(activeLabel, 0,5);
        form.add(active, 1,5);
        form.add(sendButton, 0, 6);
        form.add(msg, 0,7);

        return form;
    }

    class Timer1 extends Thread {
        private int val;
        private Label label;
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                Platform.runLater(() -> label.setText("1 masodpercenkent: "+val++));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
        public void setLabel(Label label) {
            this.label = label;
        }
    }
    class Timer2 extends Thread {
        private int val;
        private Label label;
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                Platform.runLater(() -> label.setText("2 masodpercenkent: "+val++));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
        public void setLabel(Label label) {
            this.label = label;
        }
    }

    private GridPane generateParallel() {
        GridPane form = generateBaseForm();

        Label label1 = new Label("1 masodpercenkent: ");
        Label label2 = new Label("2 masodpercenkent: ");

        Timer1 t1 = new Timer1();
        t1.setLabel(label1);
        t1.start();
        Timer2 t2 = new Timer2();
        t2.setLabel(label2);
        t2.start();
        form.add(label1, 0,0);
        form.add(label2, 0,1);

        return form;
    }

    public TableView<ReadData> generateRead() {
        return generateRead(null, null, null, null);
    }

    private TableView<ReadData> generateRead(String title, String cinema, Boolean colored, String genre) {
        TableView<ReadData> table = new TableView<>();
        TableColumn<ReadData, String> col1 = new TableColumn<>("mozinev");
        TableColumn<ReadData, String> col2 = new TableColumn<>("filmcim");

        col1.setCellValueFactory(new PropertyValueFactory<>("mozinev"));
        col2.setCellValueFactory(new PropertyValueFactory<>("filmcim"));

        table.getColumns().add(col1);
        table.getColumns().add(col2);

        ArrayList<ReadData> res = HelloApplication.connector.getReadDataFromDb(title, cinema, colored, genre);

        if (res != null) {
            for (ReadData data : res) {
                table.getItems().add(data);
            }
        }

        return table;
    }

    private GridPane generateRead2Form() {
        GridPane form = generateBaseForm();

        Label titleLabel = new Label("filmcim: ");
        Label cinemaLabel = new Label("mozinev: ");
        Label coloredLabel = new Label("szines: ");
        TextField title = new TextField();
        ObservableList<String> options = FXCollections.observableArrayList("Hunnia", "Kultiplex", "Jailhouse Club");
        ComboBox<String> cinemas = new ComboBox<>(options);
        CheckBox colored = new CheckBox();
        ToggleGroup group = new ToggleGroup();
        RadioButton horror = new RadioButton("horror");
        RadioButton doc = new RadioButton("dokumentum");
        RadioButton adventure = new RadioButton("kalandfilm");
        horror.setUserData("horror");
        doc.setUserData("dokumentum");
        adventure.setUserData("kalandfilm");

        Button searchButton = new Button("Kereses");
        searchButton.setOnAction(actionEvent -> {
            System.out.println("search button pressed");
            removePane();
            if (group.getSelectedToggle() != null) {
                root.getChildren().add(generateRead(title.getText(), cinemas.getValue(), colored.isSelected(), group.getSelectedToggle().getUserData().toString()));
            } else {
                root.getChildren().add(generateRead(title.getText(), cinemas.getValue(), colored.isSelected(), null));
            }
        });
        horror.setToggleGroup(group);
        doc.setToggleGroup(group);
        adventure.setToggleGroup(group);


        form.add(titleLabel, 0,0);
        form.add(title, 0,1);
        form.add(cinemaLabel, 0,2);
        form.add(cinemas, 0,3);
        form.add(coloredLabel, 0,4);
        form.add(colored, 1,4);
        form.add(horror, 0,5);
        form.add(doc, 0,6);
        form.add(adventure, 0,7);
        form.add(searchButton, 1,8);


        return form;
    }

    private GridPane generateInsertForm() {
        GridPane form = generateBaseForm();

        Label cinemasLabel = new Label("mozi: ");
        ObservableList<CinemaData> cinemaOptions = FXCollections.observableArrayList(HelloApplication.connector.getAllUniqueCinema());
        ComboBox<CinemaData> cinemas = new ComboBox<>(cinemaOptions);

        Label moviesLabel = new Label("film: ");
        ObservableList<MovieData> movieOptions = FXCollections.observableArrayList(HelloApplication.connector.getAllUniqueMovie());
        ComboBox<MovieData> movies = new ComboBox<>(movieOptions);

        Label msg = new Label();

        Button insertButton = new Button(SAVE);
        insertButton.setOnAction(actionEvent -> {
            if (HelloApplication.connector.insertLocation(cinemas.getValue(), movies.getValue())) {
                msg.setText(SUCCESS);
            } else {
                msg.setText(FAILED);
            }
        });

        form.add(cinemasLabel, 0, 0);
        form.add(cinemas, 0, 1);
        form.add(moviesLabel, 0, 2);
        form.add(movies, 0, 3);
        form.add(insertButton,0,4);
        form.add(msg, 0,5);


        return form;
    }

    private GridPane generateEditForm() {
        GridPane form = generateBaseForm();


        Label moziazonLabel = new Label("moziazon:");
        Label mozinevLabel = new Label("mozinev:");
        Label irszamLabel = new Label("irszam:");
        Label cimLabel = new Label("cim:");
        Label telefonLabel = new Label("telefon:");
        TextField moziazon = new TextField();
        moziazon.setEditable(false);
        TextField mozinev = new TextField();
        TextField irszam = new TextField();
        TextField cim = new TextField();
        TextField telefon = new TextField();
        moziazon.setUserData("moziazon");
        mozinev.setUserData("mozinev");
        irszam.setUserData("urszam");
        cim.setUserData("cim");
        telefon.setUserData("telefon");
        Label cinemaLabel = new Label("Valassz egy mozit: ");
        ObservableList<CinemaData> cinemaOptions = FXCollections.observableArrayList(HelloApplication.connector.getAllUniqueCinema());
        ComboBox<CinemaData> selectedCinema = new ComboBox<>(cinemaOptions);
        selectedCinema.valueProperty().addListener((observableValue, oldCinemaData, newCinemaData) -> {
            moziazon.setText(newCinemaData.getMoziazon().toString());
            mozinev.setText(newCinemaData.getMozinev());
            irszam.setText(newCinemaData.getIrszam().toString());
            cim.setText(newCinemaData.getCim());
            telefon.setText(newCinemaData.getTelefon().toString());
        });

        // force the field to be numeric only
        moziazon.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                moziazon.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        irszam.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                irszam.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        telefon.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                telefon.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        Button edit = new Button(SAVE);
        Label msg = new Label();
        edit.setOnAction(actionEvent -> {
            CinemaData selected = convertFormToCinemaData(form);
            if (HelloApplication.connector.updateCinema(selected)) {
                msg.setText(SUCCESS);
            } else {
                msg.setText(FAILED);
            }
        });

        form.add(cinemaLabel, 0, 0);
        form.add(selectedCinema, 0, 1);
        form.add(moziazonLabel, 0, 2);
        form.add(moziazon, 0, 3);
        form.add(mozinevLabel, 0, 4);
        form.add(mozinev, 0, 5);
        form.add(irszamLabel, 0, 6);
        form.add(irszam, 0, 7);
        form.add(cimLabel, 0, 8);
        form.add(cim, 0, 9);
        form.add(telefonLabel, 0, 10);
        form.add(telefon, 0, 11);

        form.add(edit,0,12);
        form.add(msg, 0,13);

        return form;
    }

    private CinemaData convertFormToCinemaData(GridPane form) {
        CinemaData res = new CinemaData();

        for (Node act : form.getChildren()) {
            if (act instanceof TextField) {
                TextField casted = (TextField) act;
                if (casted.getUserData().equals("moziazon") && !casted.getText().isBlank()) {
                    res.setMoziazon(Integer.valueOf(casted.getText()));
                } else if (casted.getUserData().equals("mozinev") && !casted.getText().isBlank()) {
                    res.setMozinev(casted.getText());
                } else if (casted.getUserData().equals("irszam") && !casted.getText().isBlank()) {
                    res.setIrszam(Integer.valueOf(casted.getText()));
                } else if (casted.getUserData().equals("cim") && !casted.getText().isBlank()) {
                    res.setCim(casted.getText());
                } else if (casted.getUserData().equals("telefon") && !casted.getText().isBlank()) {
                    res.setTelefon(Integer.valueOf(casted.getText()));
                }
            }
        }

        System.out.println("converted Cinema class:");
        System.out.println(res);
        return res;
    }

    private GridPane generateDelete() {
        GridPane form = generateBaseForm();

        Label movieLabel = new Label("filmcim: ");
        ObservableList<MovieData> movieOptions = FXCollections.observableArrayList(HelloApplication.connector.getAllUniqueMovie());
        ComboBox<MovieData> movies = new ComboBox<>(movieOptions);
        Button deleteButton = new Button(DELETE);
        deleteButton.setOnAction(actionEvent -> {
            if (movies.getValue() != null && movies.getValue().getFkod() != null) {
               HelloApplication.connector.deleteMovieById(movies.getValue().getFkod());
            }
        });

        form.add(movieLabel, 0, 0);
        form.add(movies, 0, 1);
        form.add(deleteButton, 0, 2);

        return form;
    }
}
