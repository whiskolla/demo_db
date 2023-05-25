package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;

public class HelloController {
    @FXML
    private Button btnOpen;
    @FXML
    private Button btnClose;
    @FXML
    private TableView<Books> tvMain;
    @FXML
    protected void handleBtnCloseAction() {
        Stage s = (Stage) btnClose.getScene().getWindow();
        s.close();
    }
    @FXML
    protected void handleBtnOpenAction() {
        try {
            DataAccessor da = DataAccessor.getDataAccessor();
            tvMain.getColumns().clear(); //удалим, что было (если было)

            TableColumn<Books, String> bookNameCol = new TableColumn<>("book name");
            TableColumn<Books, String> bookAuthorCol = new TableColumn<>("author");

            bookNameCol.setCellValueFactory(new PropertyValueFactory<>("book_name"));
            bookAuthorCol.setCellValueFactory(new PropertyValueFactory<>("author"));

            tvMain.getColumns().addAll(bookNameCol, bookAuthorCol);
            tvMain.getItems().addAll(da.getBooks());
        } catch (SQLException e) {};

    }


}