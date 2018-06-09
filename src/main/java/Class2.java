import javax.swing.*;
import javax.swing.JFrame;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Class2 {
    public static void main(String[] args) {
        //Создание и запуст кормы
        Form F = new Form ("Валидация КПП");
        F.setVisible(true);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        F.setSize(700,500);
        F.setResizable(false);
        F.setLocationRelativeTo(null);
    }
}
