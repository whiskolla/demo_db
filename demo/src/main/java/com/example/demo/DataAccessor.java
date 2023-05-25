package com.example.demo;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessor {

    private static DataAccessor da = new DataAccessor("jdbc:postgresql://localhost:5432/library", "postgres", "Zaq!23");
    private Connection connection;
    public static DataAccessor getDataAccessor(){
        return da;
    }
    private DataAccessor(String dbUrl, String user, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {}
    }

    //метод, возвращающий данные
    public List<Books> getBooks() throws SQLException {
        Statement st = connection.createStatement(); //
        ResultSet rs = st.executeQuery("SELECT * FROM books"); //запрос executeQuery - если селект, executeUpdate - если все остальное

        List<Books> bl = new ArrayList<>();
        while(rs.next()){
            String bn = rs.getString("book_name");
            String atr = rs.getString("author");
            Books b = new Books(bn, atr);
            bl.add(b);
        }
        return bl;
    }

}
