package livraria.controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import livraria.model.Cliente_model;
import livraria.model.Emprestimo_model;

public class Emprestimo_CRUD {
    
    Conexao co = new Conexao();
    
     public void salvar(Emprestimo_model cli) {

    try{
      co.conectar();
      PreparedStatement stmt = co.con.prepareStatement(
     "INSERT INTO emprestimo(cpf, nomeLivro, idItemEmprestimo,idLivro,dataEmprestimo,QtdDias) " +
     "VALUES( ?, ?, ?, ?, ?, ? )");

       stmt.setString(1, cli.getCpf());
       stmt.setString(2, cli.getNomeLivro());
       stmt.setInt(3, cli.getIdItemEmprestimo());
       stmt.setInt(4, cli.getIdLivro());
       stmt.setDate(5, (Date) cli.getDataEmprestimo());
       stmt.setInt(6, cli.getQtdDias());

       stmt.execute();
       stmt.close();

      } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Emprestimo de Livros",0);
      }
   }

    public int listar() {
         int lista=0;

      try{
          co.conectar();
          PreparedStatement stmt = co.con.prepareStatement(
                "SELECT MAX(idItemEmprestimo) FROM emprestimo");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            lista = rs.getInt(1);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Consulta de Empréstimo", 0);
      }
      return lista;
    }

    public void alterar(Emprestimo_model v, Cliente_model v1) {
        try{
         co.conectar();
         PreparedStatement stmt = co.con.prepareStatement(
                    "UPDATE emprestimo " +
                    "SET " +
                       "    QtdDias = ? " +
                    "WHERE " +
                    "    cpf = ?");

            stmt.setInt(1,v.getQtdDias());
            stmt.setString(2, v1.getCpf());
            
            stmt.execute();
            stmt.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Alteração do Empréstimo", 0);
        }
    }
}



