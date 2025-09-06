package modelo.dao;

import modelo.dao.Conexao;
import modelo.getset.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalDAO {

    public void inserir(Animal animal) {
        String sql = "INSERT INTO animais (dataNascimento, idMatriz, raca, sexo) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, java.sql.Date.valueOf(animal.getDataNascimento()));
            stmt.setString(3, animal.getRaca());
            stmt.setString(4, animal.getSexo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
