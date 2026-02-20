import java.util.Arrays;

public class Statistics {

    public static void main(String[] args) {
        Statistics statistics = new Statistics();
        statistics.addValues(2, 105, -366, 44, 11);
        System.out.println("Durchschnitt: " + statistics.getAverage());
    }

    private int[] values;
    private int count = 0;

    public Statistics() {
        this.values = new int[100];
    }

    public void addValues(int... values) {
        for (int v : values) {
            if (count < this.values.length) {
                this.values[count++] = v;
            } else {
                System.out.println("Das Feld ist voll!");
                break;
            }
        }
    }

    public double getAverage() {
        if (count == 0) return 0;
        return Arrays.stream(this.values, 0, count)
                     .average()
                     .orElse(0);
    }

    public Statistics generate(int min, int max, int size) {
        Statistics statistics = new Statistics();

        if (size < 0 || size > 100 || max < min) {
            return statistics;
        }

        for (int i = 0; i < size; i++) {
            statistics.values[i] = (int)(Math.random() * (max - min + 1)) + min;
            statistics.count++;
        }

        return statistics;
    }

    private enum OurColor {
        GRUEN,
        ROT,
        GELB
    }

    public OurColor interpret(double ratio, int value) {

        double avg = this.getAverage();
        double up = avg + (ratio * Math.abs(avg));
        double down = avg - (ratio * Math.abs(avg));

        if (value <= up && value >= down) return OurColor.GELB;
        if (value < down) return OurColor.ROT;
        return OurColor.GRUEN;
    }
}
