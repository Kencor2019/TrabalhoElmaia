
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO implements DAO<Salas> {
    private final Connection conn;

    public SalaDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Salas sala) {
        String sql = "INSERT INTO salas (nome, capacidade, cinema_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sala.getNome());
            stmt.setInt(2, sala.getCapacidade());
            stmt.setInt(3, sala.getCinemaId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Salas sala) {
        String sql = "UPDATE salas SET nome = ?, capacidade = ?, cinema_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sala.getNome());
            stmt.setInt(2, sala.getCapacidade());
            stmt.setInt(3, sala.getCinemaId());
            stmt.setInt(4, sala.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM salas WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public Salas buscarPorId(int id) {
        String sql = "SELECT * FROM salas WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Salas(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("capacidade"),
                    rs.getInt("cinema_id")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Salas> listarTodos() {
        List<Salas> salas = new ArrayList<>();
        String sql = "SELECT * FROM salas";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                salas.add(new Salas(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("capacidade"),
                    rs.getInt("cinema_id")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return salas;
    }
}
