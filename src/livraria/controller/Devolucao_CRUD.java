package livraria.controller;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import livraria.model.Devolucao_model;

public class Devolucao_CRUD {
    
     Conexao co = new Conexao();
    
     public void salvar(Devolucao_model cli) {

    try{
      co.conectar();
      PreparedStatement stmt = co.con.prepareStatement(
     "INSERT INTO devolucao(cpf,idItemEmprestimo,idLivro,dataEmprestimo,QtdDias) " +
     "VALUES( ?, ?, ?, ? )");

       stmt.setString(1, (String.valueOf(cli.getCpf())));
       stmt.setInt(2, cli.getIdItemEmprestimo());
       stmt.setInt(3, cli.getIdItemDevolutivo());
       stmt.setDate(4, (Date) cli.getDataDevolucao());

       stmt.execute();
       stmt.close();

      } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Devolução de Livros",0);
      }
    }
      public int listar() {
         int lista=0;

      try{
          co.conectar();
          PreparedStatement stmt = co.con.prepareStatement(
                "SELECT MAX(idItemDevolutivo) FROM devolucao");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            lista = rs.getInt(1);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Consulta de Devolução", 0);
      }
      return lista;
    }
}
