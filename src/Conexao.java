/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvar_000
 * /* implementação Singletom para a conexao da base de dados
 */
public class Conexao implements Serializable  {
    
    /* implementação Singletom para a conexao da base de dados
    */
    private static Conexao conexao;
    
    private Conexao(){
    }
    public static Conexao getInstance(){
        if(conexao == null){
            conexao = new Conexao();
        }
        return conexao;
    }
    public Connection getConnection(){
        Connection connection = null;
        
    
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:aoliveira", "system", "357159Aa"); 
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
            
        }

}



