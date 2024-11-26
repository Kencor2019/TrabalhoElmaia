
import java.util.ArrayList;

public class Salas {

  private int id;
  private int cinemaId;
  private int capacidade;
  private String nome;
  private final ArrayList<Sessao> sessoes;

  public Salas(int capacidade, String nome, int id, int cinemaId) {
    this.capacidade = capacidade;
    this.nome = nome;
    this.id = id;
    this.cinemaId = cinemaId;

    this.sessoes = new ArrayList<>();
  }

  public String Mostrar() {
    String info;
    info = "Sala "+ id + ": " + nome + " Suporta " + capacidade + " pessoas";
    return info;
  }

  public void CriarSessao(int id, Filme filme, int data) {

    for(Sessao sessao : sessoes) {

      int finale = (int) (data + filme.getDuracao()/60);
      int finale2 = (int) (sessao.getFilme().getDuracao()/60 + sessao.getDataHora());
      int cmc = data;
      int cmc2 = sessao.getDataHora();

      //verifica se o filme começa no meio de um ou termina no meio de um
      if(cmc <= finale2 && cmc >= cmc2 || finale >= cmc2 && finale <= finale2 ) {
        System.out.println("Horario impossivel");
        return;
      }
    }

    sessoes.add(new Sessao(id, filme, data, this));
  }

  public void CriarSessao(int id, Filme filme) {
    int data = 0;
    boolean verificador = false;

    while (!verificador) {
        verificador = true;

        for (Sessao sessao : sessoes) {
            int finale = (int) (data + filme.getDuracao() / 60);
            int finale2 = (int) (sessao.getFilme().getDuracao() / 60 + sessao.getDataHora());
            int cmc = data;
            int cmc2 = sessao.getDataHora();

            if (cmc <= finale2 && cmc >= cmc2 || finale >= cmc2 && finale <= finale2) {
                verificador = false; 
                break;
            }
        }

        if (verificador) {
            sessoes.add(new Sessao(id, filme, data, this));
        } else {
            data += 1; 
        }
    }
}


  public void ListarSessao() {
    String lista = "Lista de Sessoes da sala " + id + "\n";
    for(Sessao sac : sessoes) {
      lista += sac.Mostrar() + "\n";
    }
    lista += "-------------------------";
    System.out.println(lista);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
      this.id = id;
  }

  public int getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(int capacidade) {
    this.capacidade = capacidade;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getCinemaId() {
    return cinemaId;
  }

  public void setCinemaId(int cinemaId) {
    this.cinemaId = cinemaId;
  }
}
