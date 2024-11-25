package AbsoluteCinema;

import AbsoluteCinema.Cinemas.CineArt;
import AbsoluteCinema.Cinemas.Cinema;
import AbsoluteCinema.SSF.Filme;
import AbsoluteCinema.SSF.Salas;

public class Main {

    public static Cinema cinema;
        public static void main(String[] args) {
    
            
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
    }
}

/*
Polimorfismo: cinema1 e cinema2 respondem o mostrar de forma diferente 
Herança: cinema1 e cinema2 tem metodos herdados de cinema abstrato
Sobrecarga: cinema1 tem 2 tipos de mostrar
Interface: mostrar
Modificadores de acesso: variaveis public private etc
Excessoes: try catch
Colections: Armazenar varios objetos estrutura de dados
Armazenamento secundario: o banco de dados
*/