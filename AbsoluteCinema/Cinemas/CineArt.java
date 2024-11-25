package AbsoluteCinema.Cinemas;

public class CineArt extends Cinema {

    private int pontos;

    public CineArt(int id, String nome, String local) {
        super(id, nome, local);
    }

    public void genero(String genero) {
        System.out.println("Programação do CineArt para o genero: " + genero);
    }

    public void genero(String genero, String data) {
        System.out.println("Programação do CineArt para o genero: " + genero + " na data: " + data);
    }

    public void gastarPontos() {
        System.out.println("Gaste pontos para conseguir incriveis promoções\nGanhe pontos asssintindo filmes ;)");
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @Override
    public void listarCinemas() {
        System.out.println("CineArt - Cinema em " + getLocal());
    }
}
