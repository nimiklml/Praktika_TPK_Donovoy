import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Form extends JFrame{
    JButton b1;
    JLabel l1, l2;
    JTextField t1;
    int i, k;
    String a, b;
    eHandler handler = new eHandler();

    public Form(String s){
        ////////////////////////////////////////////
        // Создание формы
        super(s);
        setLayout(new FlowLayout());
        b1 = new JButton("Найти");
        l1 = new JLabel("Введите код КПП");
        l2 = new JLabel("");
        t1 = new JTextField(10);
        add(l1);
        add(t1);
        add(b1);
        add(l2);
        b1.addActionListener(handler);
    }

    public ResultSet OpenBDH2 (int Kpp) throws SQLException {
        ////////////////////////////////////////////
        // Метод, отправляющий запрос в БД, для поиска записей с введенным кодом
        Connection conn = DriverManager.getConnection("jdbc:h2:file:C:\\Users\\111\\IdeaProjects\\Pracktika_TPK\\src\\test\\resources\\test","sa", "");
        Statement st = null;
        st = conn.createStatement();
        ResultSet result;
        result = st.executeQuery("select * from ERM_SOUN where CODE = '"+ Kpp +"'");
        return result;
    };

    public class  eHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            ////////////////////////////////////////////
            // Метод, отвечающий за обработку действий пользователя с формой
            try{
            if (e.getSource() == b1){  // Обработка действий при нажатии кнопки Ввод
                String kpp = t1.getText();
                if (kpp.length() == 9){  //Проверка длины введеного кода
                    String s = "<html>";
                    String kppX = kpp.substring(0, kpp.length()-5);  // Отделение первых 4х цыфр
                    int kppXX = Integer.parseInt(kppX);


                    ResultSet result = OpenBDH2(kppXX);     // Отправка запроса


                    if (!result.isBeforeFirst() ) {// Проверка количесва найденых записей
                        l2.setText("<html><div style = 'width:500px; Color:red;'>Свопадения не найдены</div></html>");
                    }else{// Вывод найденых совпадений
                            int columns = result.getMetaData().getColumnCount();
                            s = s + "<html><div style = 'width:500px;'>";
                            while(result.next()){
                                for (int i = 1; i < columns; i++){
                                    s = s + result.getString(i) + "\t";
                                }
                                s = s + "<br>";
                            }
                            s = s + "</div></html>";

                            l2.setText(s);
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Введите 9-ти значный код КПП");
                }
            }
            }// В случае сбоя программы из за неправильного ввода кода КПП, выводится сообщение об ошибке
            catch (Exception ex){JOptionPane.showMessageDialog(null,"Введите в поле число");}

        }
    }
}
