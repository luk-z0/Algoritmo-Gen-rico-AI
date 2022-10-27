import java.util.ArrayList;
import java.util.Random;

public class AlgoritmoGenerico {

    private double random() {
        double MIN = -100000.0f;
        double MAX = 100000.0f;
        return (MAX - MIN) + MIN;
    }

    private double funcao(double x1, double x2) {
        return (x1 - Math.log(x2)) / ((Math.pow(x1, 2)) - (3 * x2));
    }

    public ArrayList<Individuo> populacao(int n) {
        ArrayList<Individuo> populacao = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            double x1 = r.nextDouble(this.random());
            double x2 = r.nextDouble(this.random());
            double fitness = this.funcao(x1, x2);
            populacao.add(new Individuo(x1, x2, fitness));
        }
        return populacao;
    }

    public Individuo selecao(ArrayList<Individuo> populacao) {
        Random r = new Random();

        Individuo individuo1 = populacao.get(r.nextInt(populacao.size()));
        Individuo individuo2 = populacao.get(r.nextInt(populacao.size()));
        Individuo individuo3 = populacao.get(r.nextInt(populacao.size()));

        if (individuo1.getFit() >= individuo2.getFit()
                && individuo1.getFit() >= individuo3.getFit()) {
            return individuo1;

        } else if (individuo2.getFit() >= individuo1.getFit()
                && individuo2.getFit() >= individuo3.getFit()) {
            return individuo2;
        } else {
            return individuo3;
        }

    }

    public ArrayList<Individuo> cruzamento(Individuo pai1, Individuo pai2) {
        ArrayList<Individuo> filhos = new ArrayList<>();

        double x1Pai1 = pai1.getX1();
        double x2Pai1 = pai1.getX2();

        double x1Pai2 = pai2.getX1();
        double x2Pai2 = pai2.getX2();

        filhos.add(0,
                new Individuo(x1Pai1, x2Pai2,
                        this.funcao(x1Pai1, x2Pai2)));

        filhos.add(1, new Individuo(x1Pai2, x2Pai1,
                this.funcao(x1Pai2, x2Pai1)));

        return filhos;
    }

    public Individuo mutacao(Individuo filho) {

        Random randomX = new Random();
        Random randomValueX = new Random();

        int aux = randomX.nextInt(2);
        double valueX = randomValueX.nextDouble(this.random());

        if (aux == 0) {
            filho = new Individuo(filho.getX1(), valueX, this.funcao(filho.getX1(), valueX));
        }
        if (aux == 1) {
            filho = new Individuo(valueX, filho.getX2(), this.funcao(filho.getX2(), valueX));

        }

        return filho;
    }

    public Individuo elitismo(ArrayList<Individuo> populacao) {
        Individuo individuoSelecionado = new Individuo(0, 0, 0);
        for (int i = 0; i < populacao.size(); i++) {
            individuoSelecionado = this.selecao(populacao);
            if (populacao.get(i).getFit() >= individuoSelecionado.getFit()) {
                individuoSelecionado = populacao.get(i);
            }
        }

        return individuoSelecionado;
    }

    public ArrayList<Individuo> populacaoNova(ArrayList<Individuo> populacaoInicial) {
        Random r = new Random();
        ArrayList<Individuo> populacaoNova = new ArrayList<>();
        Individuo individuoSelecionado = this.elitismo(populacaoInicial);
        int chanceMutacao;
        int indexMutante;

        populacaoNova.add(0, individuoSelecionado);

        for (int i = 1; i < populacaoInicial.size(); i++) {

            ArrayList<Individuo> filhos = this.cruzamento(populacaoInicial.get(r.nextInt(populacaoInicial.size())),
                    populacaoInicial.get(r.nextInt(populacaoInicial.size())));

            chanceMutacao = r.nextInt(101);
            indexMutante = r.nextInt(2);

            if (chanceMutacao <= 5) {
                Individuo mutante = this.mutacao(filhos.get(indexMutante));
                filhos.set(indexMutante, mutante);

            }

            populacaoNova.addAll(i, filhos);

        }
        populacaoNova.subList(populacaoInicial.size(),
                populacaoNova.size()).clear();

        return populacaoNova;

    }

    public void selecaoNatural(ArrayList<Individuo> populacaoInicial, int qtdGeracao) {
        int count = 0;
        ArrayList<Individuo> populacaoNova = new ArrayList<>();

        for (Individuo individuo : populacaoInicial) {
            System.out.println("Gerações Inicial" + " - Individuo " + count + " - " + individuo);
            count++;
        }

        count = 0;
        System.out.println("\n");

        for (int i = 0; i < qtdGeracao; i++) {
            populacaoNova = this.populacaoNova(populacaoInicial);
            for (Individuo individuo : populacaoNova) {
                System.out.println("Gerações " + i + " - Individuo " + count + " - " + individuo);
                count++;
            }
            System.out
                    .println("\nIndividuo mais apto da geração : " + (count - 1) + " " + this.elitismo(populacaoNova));
            count = 0;
            populacaoInicial.clear();
            populacaoInicial.addAll(populacaoNova);
            populacaoNova.clear();

            System.out.println("\n");
        }

    }
}
