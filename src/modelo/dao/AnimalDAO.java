package modelo.dao;

import modelo.getset.Animal;
import util.ConexaoBD;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public void inserir(Animal animal) {
        String sql = "INSERT INTO animais (dataNascimento, idMatriz, raça, sexo, id_animal) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            LocalDate data = animal.getDataNasc();
            if (data!= null){
                stmt.setDate(1, java.sql.Date.valueOf(data));
            } else {
                stmt.setNull(1, Types.DATE);
            }

            stmt.setString(2, animal.getNome());
            stmt.setString(3, animal.getRaca());
            stmt.setString(4, animal.getSexo());
            stmt.setInt(5, animal.getIdAnimal());
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
                a.setIdAnimal(rs.getInt("id_Animal"));
                a.setRaca(rs.getString("raça"));
                a.setSexo(rs.getString("sexo"));
                a.setDataNasc(rs.getDate("dataNascimento") != null ? rs.getDate("dataNascimento").toLocalDate() : null);

                animais.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animais;
    }
    public static List<Animal> buscar(String termo){
        List<Animal> busca = new ArrayList<>();
        String sql = "SELECT * FROM animais WHERE id_Animal LIKE ? OR raça LIKE ? OR sexo LIKE ? OR idMatriz LIKE ?";
        try (Connection conn = Conexao.getConexao();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            String termoLike = "%" + termo + "%";
            stmt.setString(1, termoLike);
            stmt.setString(2, termoLike);
            stmt.setString(3, termoLike);
            stmt.setString(4, termoLike);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Animal a = new Animal();
                a.setIdAnimal(rs.getInt("id_animal"));
                a.setDataNasc(rs.getDate("dataNascimento") != null ?
                        rs.getDate("dataNascimento").toLocalDate() : null);
                a.setRaca(rs.getString("raça"));
                a.setSexo(rs.getString("sexo"));
                a.setIdMatriz(rs.getInt("idMatriz"));
                a.setPesoAtual(rs.getDouble("peso"));
                busca.add(a);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return busca;
    }

    public void excluir(int id) throws SQLException{
        String sql = "DELETE FROM animais WHERE id_Animal = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            //stmt.close();
        }

    }

}

