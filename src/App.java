import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        AlgoritmoGenerico aGenerico = new AlgoritmoGenerico();

        System.out.println("\nPopulação Inicial");

        ArrayList<Individuo> populacao = aGenerico.populacao(10);

        for (int i = 0; i < populacao.size(); i++) {
            System.out.println("Individuo " + i + " " + populacao.get(i));
        }

        System.out.println("\nNova população");    
        
        ArrayList<Individuo> populacaoNova = new ArrayList<>();
        populacaoNova = aGenerico.populacaoNova(populacao);
        
        int i = 0;
        for (Individuo individuo : populacaoNova) {
            System.out.println("Individuo " + i + " " + individuo);
            i++;
        }
    }

}
