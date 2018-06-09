import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class FormTest {

    @Test
    public void openBDH2() throws SQLException {


        Form F = new Form ("Test");


        int TestP1 = 0102;      //Значение, для тестового запроса
        int TestP2 = 0102;      //Значение, передаваемое в метод

        // тестовый запрос для сравнения результатов
        Connection conn = DriverManager.getConnection("jdbc:h2:file:C:\\Users\\111\\IdeaProjects\\Pracktika_TPK\\src\\test\\resources\\test","sa", "");
        Statement st = null;
        st = conn.createStatement();
        ResultSet expected;
        expected = st.executeQuery("select * from ERM_SOUN where CODE = '"+ TestP1 +"'");

        String[][] arr1 = new String[15][3];


        int Index1 = 0;
        while(expected.next()){
            for (int i = 0;i  <= 2; i++){
                arr1[Index1][i] = expected.getString(i+1);
            }
            Index1++;
        }
        ////////////////////////////////////////////
        // Использование тестируемого метода
        ResultSet result = F.OpenBDH2(TestP2);

        String[][] arr2 = new String[15][3];
        Index1 = 0;
        while(result.next()){
            for (int i = 0;i  <= 2; i++){
                arr2[Index1][i] = result.getString(i+1);
            }
            Index1++;
        }
        ////////////////////////////////////////////
        // Сравнение результатов
        int Flag = 1;
        for (int i = 0;i  <= 14; i++){
            for (int j = 0;j  <= 2; j++){
                if (arr1[i][j] != arr2[i][j]){Flag = 0;}
            }
        }
        ////////////////////////////////////////////
        // Вывод сообщения об ошибе
        assertEquals(Flag,1);
    }
}