
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO implements DAO<Filme> {
    private final Connection conn;

    public FilmeDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Filme filme) {
        String sql = "INSERT INTO Filme (nome, duracao_s) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filme.getNome());
            stmt.setLong(2, filme.getDuracao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Filme filme) {
        String sql = "UPDATE Filme SET nome = ?, duracao_s = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filme.getNome());
            stmt.setLong(2, filme.getDuracao());
            stmt.setInt(3, filme.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM Filme WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public Filme buscarPorId(int id) {
        String sql = "SELECT * FROM Filme WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Filme(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getLong("duracao_s")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Filme> listarTodos() {
        List<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * FROM Filme";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                filmes.add(new Filme(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getLong("duracao_s")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return filmes;
    }
}