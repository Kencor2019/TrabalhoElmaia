package AbsoluteCinema.Cinemas;

import java.util.ArrayList;

import AbsoluteCinema.SSF.Salas;

public abstract class Cinema {
    private int id;
    private String nome;
    private String local;

    public ArrayList<Salas> salas;

    public Cinema(int id, String nome, String local) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.salas = new ArrayList<>();
    }

    public abstract void listarCinemas();

    public void criarSalas(int capacidade, String nome, int id) {
        salas.add(new Salas(capacidade, nome, id, this.id));
    }

    public void listarSalas() {
        String lista = "Lista de Salas\n";
        for(Salas sal : salas) {
            lista += sal.Mostrar() + "\n";
        }
        lista += "-------------------------";
        System.out.println(lista);
    }

    //falta listar cinemas()

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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
