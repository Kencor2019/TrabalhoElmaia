package AbsoluteCinema.SSF;
public class Filme {

    private int id;
    private String nome;
    private long duracao_s;

    public Filme(int id, String nome, long duracao_s) {
        this.id = id;
        this.nome = nome;
        this.duracao_s = duracao_s;
    }

    public String Mostrar() {
        String info = "";
        info += nome + " dura " + duracao_s + "s";
        return info;
    }

    //falta surprender

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getDuracao() {
        return duracao_s;
    }

    public void setDuracao(long duracao_s) {
        this.duracao_s = duracao_s;
    }
}
