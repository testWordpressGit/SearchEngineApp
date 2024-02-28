package org.example;

import org.jsoup.nodes.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Indexer {
    static Connection connection = null;

    Indexer(Document document, String url) {
        String title = document.title();
        String Link = url;
        String text = document.text();
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into pages value(?, ?, ?);");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, Link);
            preparedStatement.setString(3, text);
            preparedStatement.executeUpdate();
        }
    catch (SQLException sqlException){
        sqlException.printStackTrace();
    }
    }
}