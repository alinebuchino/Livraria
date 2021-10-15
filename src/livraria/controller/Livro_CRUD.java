package livraria.controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import livraria.model.Livro_model;

public class Livro_CRUD {
    
    Conexao co = new Conexao();
    
    public void salvar(Livro_model l) {
         
     try{
      co.conectar();
      PreparedStatement stmt = co.con.prepareStatement(
     "INSERT INTO livro(idLivro, nomeLivro, autor, genero, ano) " +
     "VALUES( ?, ?, ?, ?, ? )");

       stmt.setInt(1, l.getIdLivro());
       stmt.setString(2, l.getNomeLivro());
       stmt.setString(3, l.getNomeAutor());
       stmt.setString(4, l.getGenero());
       stmt.setInt(5,l.getAno());
 
       stmt.execute();
       stmt.close();

      } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Cadastro de Livros",0);
      }
   }

    public int listar() {
         int lista=0;

      try{
          co.conectar();
          PreparedStatement stmt = co.con.prepareStatement(
                "SELECT MAX(idLivro) FROM livro");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            lista = rs.getInt(1);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Consulta de Livros", 0);
      }
      return lista;
    }

  public List listar_dados() {

     List<Livro_model> lista = new ArrayList<Livro_model>();

      try{
          co.conectar();
          PreparedStatement stmt = co.con.prepareStatement(
                "SELECT * FROM livro");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

          Livro_model t = new Livro_model();
          t.setIdLivro(rs.getInt("idLivro"));
          t.setNomeLivro(rs.getString("NomeLivro"));
          t.setNomeAutor(rs.getString("NomeAutor"));
          t.setGenero(rs.getString("Genero"));
          t.setAno(rs.getInt("Ano"));
          lista.add(t);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Alteração de Livros", 0);
      }
      return lista;
    }
}
