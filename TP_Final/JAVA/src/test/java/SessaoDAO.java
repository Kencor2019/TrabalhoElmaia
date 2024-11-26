import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessaoDAO implements DAO<Sessao> {
    private final Connection conn;

    public SessaoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Sessao sessao) {
        String sql = "INSERT INTO Sessao (sala_id, filme_id, data_hora) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, sessao.getSala().getId());
            stmt.setInt(2, sessao.getFilme().getId());
            stmt.setTimestamp(3, Timestamp.valueOf(sessao.getDataHora(1)));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Sessao sessao) {
        String sql = "UPDATE Sessao SET sala_id = ?, filme_id = ?, data_hora = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, sessao.getSala().getId());
            stmt.setInt(2, sessao.getFilme().getId());
            stmt.setTimestamp(3, Timestamp.valueOf(sessao.getDataHora(1)));
            stmt.setInt(4, sessao.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM Sessao WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public Sessao buscarPorId(int id) {
        String sql = "SELECT * FROM Sessao WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Salas sala = new SalaDAO(conn).buscarPorId(rs.getInt("sala_id"));
                Filme filme = new FilmeDAO(conn).buscarPorId(rs.getInt("filme_id"));
                return new Sessao(
                    rs.getInt("id"),
                    filme,
                    rs.getTimestamp("data_hora").toLocalDateTime(),
                    sala
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Sessao> listarTodos() {
        List<Sessao> sessoes = new ArrayList<>();
        String sql = "SELECT * FROM Sessao";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Salas sala = new SalaDAO(conn).buscarPorId(rs.getInt("sala_id"));
                Filme filme = new FilmeDAO(conn).buscarPorId(rs.getInt("filme_id"));
                sessoes.add(new Sessao(
                    rs.getInt("id"),
                    filme,
                    rs.getTimestamp("data_hora").toLocalDateTime(),
                    sala
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return sessoes;
    }
}