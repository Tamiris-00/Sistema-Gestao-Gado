package modelo.dao;

import modelo.dao.Conexao;
import modelo.getset.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public void inserir(Animal animal) {
        String sql = "INSERT INTO animais (dataNascimento, idMatriz, raça, sexo, id_animal) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, java.sql.Date.valueOf(animal.getDataNascimento()));
            stmt.setString(2, animal.getNome());
            stmt.setString(3, animal.getRaca());
            stmt.setString(4, animal.getSexo());
            stmt.setInt(5, animal.getBrinco());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Animal> listar(){
        List<Animal> animais = new ArrayList<>();
        String sql= "SELECT * FROM animais";

        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);){

            while (rs.next()){
                Animal a = new Animal();
                a.setBrinco(rs.getInt("id_animal"));
                a.setRaca(rs.getString("raça"));
                a.setSexo(rs.getString("sexo"));
                a.setDataNascimento(rs.getDate("dataNascimento") != null ? rs.getDate("dataNascimento").toLocalDate() : null);

                animais.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animais;
    }

}

