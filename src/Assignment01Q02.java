public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;


        int n = Integer.parseInt(args[0]);

        for (int i = 0; i < n; i++) {
            double term = 1.0 / (2 * i + 1);

            if (i % 2 == 0) {
                approxPi += term;
            } else {
                approxPi -= term;
            }
        }

        approxPi *= 4;

        System.out.println(approxPi + " " + actualPi);
    }
}