import java.util.Scanner;

/*
김다혜
미니과제 8번 (미완성)
주말 내내 붙잡고 있었지만 완성하지 못했습니다... ㅠㅠ...
아직 부족한 점이 많아서 더 공부하고 분발하겠습니다 ! ! !
*/

public class Test8 {
    static long[] taxBases = {12_000_000, 46_000_000, 88_000_000, 150_000_000, 300_000_000, 500_000_000, 1_000_000_000};
    static int[] taxRates = {6, 15, 24, 35, 38, 40, 42, 45};
    static long[] progressiveDeductions = {0, 1_080_000, 5_220_000, 14_900_000, 19_400_000, 25_400_000, 35_400_000, 65_400_000};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.: ");
        long income = sc.nextLong();
        if (income <= taxBases[0]) {
            System.out.println(income + " * " + taxRates[0] + "% = " + (int) (income * taxRates[0] / 100));
        } else {
            long tax = calculateTaxes(income);
            System.out.println();
            System.out.println("[세율에 의한 세금]:     " + String.format("%12d", tax));
            long deduction = progressive(income);
            System.out.println("[누진공제 계산에 의한 세금]:" + String.format("%12d", deduction));

        }
    }

    private static long calculateTaxes(long income) {
        long remain = income;
        int i = 0;
        long taxesByTaxRate = 0;
        while (i < taxBases.length) {
            long gap = 12_000_000;
            if (i > 0) {
                gap = taxBases[i] - taxBases[i - 1];
            }
            remain = income - taxBases[i];
            int tax = (int) (gap * taxBases[i] / 100);
            taxesByTaxRate = taxesByTaxRate + tax;
            System.out.println(String.format("%12d", gap) + " * " + String.format("%2d", taxRates[i]) + "% = " + String.format("%12d", tax));
            if (income - taxBases[i] < 0) {
                break;
            }
            i++;
        }
        int tax = (int) (remain * taxRates[i] / 100);
        taxesByTaxRate = taxesByTaxRate + tax;
        System.out.println(String.format("%12d", remain) + " * " + String.format("%2d", taxRates[i]) + "% = " + String.format("%12d", tax));

        return taxesByTaxRate;
    }

    private static long progressive(long income) {
        int i = 0;
        while (i < taxBases.length) {
            if (income - taxBases[i] < 0) {
                break;
            }
            i++;
        }
        long deduction = (int) (income * taxRates[i] / 100) - progressiveDeductions[i];
        return deduction;
    }
}
