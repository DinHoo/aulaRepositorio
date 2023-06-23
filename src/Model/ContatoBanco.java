
package Model;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ContatoBanco {
    //inserir
    public static void cadastrarContato(DadosContato contato) throws SQLException
    {
        try 
        {
            //passar os dados para do BD
            Connection conexao = Conexao.conecta();
            //criar uma condição do Java interagir com o SQL
            /////////Statement query = conexao.createStatement();
            //criar a query de SQL(insert)
            String sql = "insert into contato values(null,'"+contato.getNome()+"','"+contato.getTelefone()+"','"+contato.getEmail()+"');";
            /////////query.execute(sql);
            //////////query.close();
            conexao.close();
            
        } 
        catch (SQLException erro) 
        {
            throw new SQLException("Erro ao inserir os dados no BD.\nCausa: "+erro.getMessage());
        }
    }        
    
    //listar
    public static ArrayList<DadosContato> listarContato() throws SQLException
    {
        try 
        {
            //passar os dados para do BD
            Connection conexao = Conexao.conecta();
            //criar uma condição do Java interagir com o SQL
            Statement query = conexao.createStatement();
            //criar a query de SQL(select *)
            String sql = "Select * from contato;";
            
            //pegar os dados da tabela
            ResultSet rs = query.executeQuery(sql);
            //criar um vetor dinamico para colocar o resultado
            ArrayList<DadosContato> listaAux = new ArrayList<>();
            //percorrer os registros (linhas da tabela)
            while (rs.next()) {                
                DadosContato dc = new DadosContato();
                dc.setIdContato(rs.getInt("id_contato"));
                dc.setNome(rs.getString("nome"));
                dc.setTelefone(rs.getString("telefone"));
                dc.setEmail(rs.getString("email"));
                listaAux.add(dc);
            }
            return listaAux;
            //vai ser fechado na interface???????????
            //query.close();
            //conexao.close();
        } 
        catch (SQLException e) 
        {
            throw new SQLException("Erro ao lista os dados no BD.\nCausa: "+e.getMessage());
        }
    }
    //apagar
    public static void apagarContato(DadosContato contato) throws SQLException {

        try {
            Connection conexao = Conexao.conecta();
            Statement query = conexao.createStatement();
            String sql = "delete from contato where id_contato = " + contato.getIdContato();
            query.execute(sql);
            query.close();
            conexao.close();

        } catch (SQLException erro) {
            throw new SQLException("Erro ao apagar contato no banco de dados.\nCausa: " + erro.getMessage());
        }

    }
    
    //atualizar
    public static void atualizarContato(DadosContato contato) throws SQLException
    {
        try 
        {
            Connection conexao = Conexao.conecta();
            Statement query = conexao.createStatement();
            String sql ="update contato set nome='"+contato.getNome()+
                    "',telefone='"+contato.getTelefone()+"',email='"+contato.getEmail()+
                    "' where id_contato = "+contato.getIdContato()+";";
            query.executeUpdate(sql);
            query.close();
            conexao.close();
        } 
        catch (Exception e) 
        {
            throw new SQLException("Erro ao atualizar contato no banco de dados.\nCausa: " + e.getMessage());
        }
    
    }
}
