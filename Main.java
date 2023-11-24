import java.util.*;

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        int k = 2;

        var res = getRollingAverage(arr, k);
        System.out.println(res);
    }

    public static List<Double> getRollingAverage(ArrayList<Integer> arr, int k) {
        LinkedList<Double> temp = new LinkedList<>();
        LinkedList<Double> res = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            temp.add(Double.valueOf(arr.get(i)));
        }
        res.add(arithmeticMeanInEntireCollection(temp));
        for (int i = k; i < arr.size(); i++) {
            temp.add(Double.valueOf(arr.get(i)));
            temp.remove();
            res.add(arithmeticMeanInEntireCollection(temp));
        }
        return res;


    }

    private static double arithmeticMeanInEntireCollection(Collection<Double> col) {
        double res = 0;
        for (double item : col) {
            res += item;
        }
        return (res / (col.size()));
    }

}

