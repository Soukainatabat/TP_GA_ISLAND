package ma.enset.bddc;
import java.util.Random;

public class Individual implements Comparable {
    private int [] chromosome = new int[GAUtils.CHROMOSOME_SIZE];
    private double fitness ;

    public Individual() {
        Random random=new Random();
        for (int i = 0; i < GAUtils.CHROMOSOME_SIZE; i++) {
            chromosome[i]= random.nextInt(2);

        }
    }

    public Individual(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public void calculateFitness() {
//        for (int i:chromosome) {
//            fitness+=i;
//        }
//        System.out.println(chromosome.length);
//        System.out.println(GAUtils.TARGET_PHRASE.length());



        int count = 0;

        for (int i = 0; i < GAUtils.TARGET_PHRASE.length(); i++) {
            if (chromosome[i] == 1) {
                fitness++;
            }
        }



    }

    public double getFitness() {
        return fitness;
    }

    public int[] getChromosome() {
        return chromosome;
    }

    @Override
    public int compareTo(Object o) {
        Individual individual=(Individual) o ;
        return Double.compare(this.fitness, individual.fitness);
    }

    public void setChromosome(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public void setFitness(char fitness) {
        this.fitness = fitness;
    }
}