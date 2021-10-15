package livraria.controller;

import java.sql.*; 

public class Conexao {

  public Connection con;

  static String host="localhost"; 
  static String database="livraria"; 
  static String usuario="root";
  static String senha="";
  static String url="jdbc:mysql://"+host+"/"+database;
  
  public Conexao(){ }

  public void conectar()
  {
    try {
       Class.forName("com.mysql.jdbc.Driver");
       System.out.println("Driver OK!!!");
           
       con = DriverManager.getConnection(url,usuario,senha);
       System.out.println("Conexão OK!!!");

    } catch ( ClassNotFoundException exc ) {
       System.out.println("Erro no driver "+exc.getMessage());
    } catch(SQLException exc){
       System.out.println("Erro de conexao ="+exc.getMessage());
    }
  }

  public void Fechar_Conexao()
   {
       try{
           con.close(); 
          
       } catch(SQLException exc) {
           System.out.println(exc.getMessage());
       }
   }
}  