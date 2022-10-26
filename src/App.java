import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        AlgoritmoGenerico aGenerico = new AlgoritmoGenerico();

        ArrayList<Individuo> populacao = aGenerico.populacao(10);

        for (int i = 0; i < populacao.size(); i++) {
            System.out.println("Individuo " + i + " " + populacao.get(i));
        }

        // Individuo individuoSelecionado = aGenerico.selecao(populacao);
        // System.out.println("Individuo Selecionado: " +
        // individuoSelecionado.toString());

        // //Cruzamento
        // System.out.println("Resultado do Cruzamento : " +
        // aGenerico.cruzamento(aGenerico.selecao(populacao),aGenerico.selecao(populacao)));

        ArrayList<Individuo> populacaoNova = new ArrayList<>();
        populacaoNova = aGenerico.populacaoNova(populacao);
        int i = 0;
        for (Individuo individuo : populacaoNova) {
            System.out.println(i + " : " + individuo);
            i++;
        }
    }

}
