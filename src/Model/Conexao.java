package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    //atributos
    private static final String URL="jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC";
    private static final String USUARIO="root";
    private static final String SENHA="Tecdev@2022";
    
    //metodos
    public static Connection conecta()throws SQLException
    {
        try 
        {
            return DriverManager.getConnection(URL,USUARIO,SENHA);
        } 
        catch (SQLException e) 
        {
            throw new SQLException("Erro na conexão.\nCausa: "+e.getMessage());
        }
    }
}
