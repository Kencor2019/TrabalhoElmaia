
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static Cinema cinema;
        public static void main(String[] args) throws SQLException {
    
            
            cinema = new CineArt(0, "a", "a");
            cinema.criarSalas(100, "Sala1", 0);
            cinema.criarSalas(300, "Sala2", 1);
            cinema.listarSalas();

            Filme filme1 = new Filme(1, "O Grande Filme", 7200); 
            Filme filme2 = new Filme(2, "Aventura no Espaço", 5400); 

            for(Salas sal : cinema.salas) {
                sal.CriarSessao(0, filme1, 0);
                sal.CriarSessao(0, filme1, 121);
                sal.CriarSessao(1, filme2);
                sal.CriarSessao(1, filme2);
                sal.CriarSessao(2, filme2, 540);
                sal.ListarSessao();
            }

            String dbHost = "localhost";  
            String dbPort = "3306";      
            String dbName = "CinemaDB";    
            String dbUser = "root";   
            String dbPassword = "1234";  

            String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

            try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword)) {
                System.out.println("Conexão estabelecida com sucesso!");
                FilmeDAO filmin = new FilmeDAO(conn);
                filmin.listarTodos();
            } catch (SQLException e) {
                System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            }

    }
}