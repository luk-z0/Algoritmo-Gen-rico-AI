import java.util.ArrayList;
import java.util.Random;

public class AlgoritmoGenerico {

    public double random() {

        double MIN = -100000;
        double MAX = 100000;
        return (MAX - MIN) + MIN;
    }

    public double funcao(double x1, double x2) {
        return (x1 - Math.log(x2)) / (Math.pow(x1, 2) - 3 * x2);
    }

    public ArrayList<Individuo> populacao(int n) {
        ArrayList<Individuo> popupalcao = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            double x1 = r.nextDouble(this.random());
            double x2 = r.nextDouble(this.random());
            double fitness = this.funcao(x1, x2);
            popupalcao.add(new Individuo(x1, x2, fitness));
        }
        return popupalcao;
    }

    public Individuo selecao(ArrayList<Individuo> populacao) {
        Random r = new Random();
        int index1 = r.nextInt(populacao.size() - 1);
        int index2 = r.nextInt(populacao.size() - 1);
        int index3 = r.nextInt(populacao.size() - 1);
        Individuo individuo1 = populacao.get(index1);
        Individuo individuo2 = populacao.get(index2);
        Individuo individuo3 = populacao.get(index3);

        if (individuo1.getFit() > individuo2.getFit()
                && individuo1.getFit() > individuo3.getFit()) {
            return individuo1;

        } else if (individuo2.getFit() > individuo1.getFit()
                && individuo2.getFit() > individuo3.getFit()) {
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

        filhos.set(0,
                new Individuo(x1Pai1, x2Pai2,
                        this.funcao(x1Pai1, x2Pai2)));

        filhos.set(1, new Individuo(x1Pai2, x2Pai1,
                this.funcao(x1Pai2, x2Pai1)));

        return filhos;
    }

    public Individuo mutacao(Individuo filho) {

        Random r = new Random();
        filho = new Individuo(filho.getX1(), r.nextDouble(this.random()), filho.getFit());

        return filho;
    }

}
