

import java.time.LocalDateTime;

public class Sessao {

    private int id;
    private Salas sala;
    private Filme filme;
    private int dataHora;

    public Sessao(int id, Filme filme, int dataHora2, Salas sala) {
        this.id = id;
        this.filme = filme;
        this.dataHora = dataHora2;
        this.sala = sala;
    }

    public Sessao(int int1, Filme filme2, LocalDateTime localDateTime, Salas sala2) {
        //TODO Auto-generated constructor stub
    }

    public String Mostrar() {
        String info;
        info = id + ": " + filme.Mostrar() + " sala " + sala.getId() + " as " + dater(dataHora) + " e termina as " + dater(dataHora + (int)(filme.getDuracao()/60));
        return info;
    }

    public String dater(int data) {
        int horas = data / 60;
        int minutos = data % 60;
        return String.format("%d:%02d", horas, minutos);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Salas getSala() {
        return sala;
    }

    public void setSala(Salas sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getDataHora() {
        return dataHora;
    }

    public void setDataHora(int dataHora) {
        this.dataHora = dataHora;
    }

    public LocalDateTime getDataHora(int a) {
            // Vamos assumir que a data base é meia-noite de hoje
            LocalDateTime hojeMeiaNoite = LocalDateTime.now().toLocalDate().atStartOfDay();
    
            // Adiciona os minutos ao LocalDateTime base
            return hojeMeiaNoite.plusMinutes(this.getDataHora());
    }
}
