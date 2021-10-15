package livraria.controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import livraria.model.Cliente_model;

public class Cliente_CRUD {

    Conexao co = new Conexao();
    
    public void salvar(Cliente_model cli) {
    try{
      co.conectar();
      PreparedStatement stmt = co.con.prepareStatement(
     "INSERT INTO cliente(cpf,nomeCliente,sexo,dataNasc,numeroCasa,cidade,estado,telefone) " +
     "VALUES( ?, ?, ?, ?, ?, ?, ?, ?)");

       stmt.setString(1, cli.getCpf());
       stmt.setString(2, cli.getNomeCli());
       stmt.setString(3, cli.getSexo());
       stmt.setDate(4, (Date) cli.getDataNasc());
       stmt.setInt(5, cli.getNumeroCasa());       
       stmt.setString(6, cli.getCidade());
       stmt.setString(7, cli.getEstado());
       stmt.setString(8, cli.getFone());
       
       stmt.execute();
       stmt.close();

      } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Cadastro de Clientes",0);
      }
   }
}
