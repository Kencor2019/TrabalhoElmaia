package AbsoluteCinema.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import AbsoluteCinema.SSF.Salas;

public class SalaDAO {

    public void salvarSala(Salas sala) {
        String sql = "INSERT INTO salas (nome, capacidade, cinema_id) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sala.getNome());
            stmt.setInt(2, sala.getCapacidade());
            stmt.setInt(3, sala.getCinemaId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Salas> carregarSalas(int cinemaId) {
        List<Salas> salas = new ArrayList<>();
        String sql = "SELECT * FROM salas WHERE cinema_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cinemaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int capacidade = rs.getInt("capacidade");

                Salas sala = new Salas(id, nome, capacidade, cinemaId);
                salas.add(sala);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salas;
    }

        // Método para buscar uma sala pelo ID
    public Salas buscarPorId(int id) {
        String sql = "SELECT * FROM salas WHERE id = ?";
        Salas sala = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                int capacidade = rs.getInt("capacidade");
                int cinemaId = rs.getInt("cinema_id");

                //Cinema cinema = new Cinema(cinemaId);  // Criando instância de cinema (precisa de um constructor apropriado)
                sala = new Salas(id, nome, capacidade, cinemaId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sala;
    }
}