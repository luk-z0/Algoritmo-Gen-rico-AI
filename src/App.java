import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        AlgoritmoGenerico aGenerico = new AlgoritmoGenerico();
        ArrayList<Individuo> populacaoInicial = aGenerico.populacao(10);
        ArrayList<Individuo> populacaoNova = new ArrayList<>();

        System.out.println("\nPopulação Inicial");

        for (int i = 0; i < populacaoInicial.size(); i++) {
            System.out.println("Individuo " + i + " " + populacaoInicial.get(i));
        }

        System.out.println("\nNova população");

        populacaoNova = aGenerico.populacaoNova(populacaoInicial);

        int i = 0;
        for (Individuo individuo : populacaoNova) {
            System.out.println("Individuo " + i + " " + individuo);
            i++;
        }

        System.out.println("");

        System.out.println("Multiplas gerações");

        aGenerico.selecaoNatural(populacaoNova, 100);
    }

}
