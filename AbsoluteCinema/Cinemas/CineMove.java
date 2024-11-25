package AbsoluteCinema.Cinemas;

public class CineMove extends Cinema {

    private int convidados;

    public CineMove(int id, String nome, String local) {
        super(id, nome, local);
    }

    public void promocao() {
        System.out.println("Promoções especiais do CineMove:");
        System.out.println("Desconto de 50% para estudantes!");
    }

    public void promocao(String tipoIngresso) {
        System.out.println("Promoções especiais do CineMove para " + tipoIngresso + ":");
        if (tipoIngresso.equalsIgnoreCase("meia-entrada")) {
            System.out.println("Desconto de 30% para meia-entrada!");
        } else {
            System.out.println("Desconto de 10% para ingressos normais!");
        }
    }

    public void promocao(int idade, String cpf) {
        if(idade > 18) {
            System.out.println("Nos de seu cpf e ganhe mais descontos, alem da meia-entrada voce ganha o mega desconto");
        }
        System.out.println("Ganhe um mega desconto se nos der suas informações ai podemos saber muito sobre voce\nEm troca voce ganha 50% de desconto num filminho de cria");
        System.out.println("Vale muito a pena vender suas informações por 50% de desconto ;))))))");
        System.out.println("E nos faremos bom uso >:3");
    }

    public void convidar() {
        System.out.println("convide pessoas para ganhar beneficios extras tambem");
    }

    
    public int getConvidados() {
        return convidados;
    }

    public void setConvidados(int convidados) {
        this.convidados = convidados;
    }

    

    @Override
    public void listarCinemas() {
        System.out.println("CineMove - Cinema em " + getLocal());
    }
}
