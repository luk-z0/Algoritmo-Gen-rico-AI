public class Individuo {

    private double x1;
    private double x2;
    private double fitness;

    public Individuo(double x1, double x2, double fit) {
        this.x1 = x1;
        this.x2 = x2;
        this.fitness = fit;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getFit() {
        return fitness;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setFit(double fit) {
        this.fitness = fit;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "X1 : " + this.x1 + ", " + "X2: " + this.x2 + ", " + "Fitness: " + this.fitness;
    }

}
