import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Scanner;

/*
김다혜
미니과제 5번
*/

public class Test5 {
    public static void main(String[] args) {
        System.out.println("[달력 출력 프로그램]");
        Scanner sc = new Scanner(System.in);
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = sc.nextInt();

        LocalDate monthstart = LocalDate.of(year, month, 1);
        int monthday = monthstart.get(ChronoField.DAY_OF_WEEK);
        int monthend = monthstart.lengthOfMonth();

        System.out.println();

        System.out.println("[" + year + "년" + month + "월]");
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        int total = 0;

        for (int i = 0; i < monthday; i++) {
            System.out.print("\t");
            total++;
        }
        for (int j = 1; j <= monthend; j++) {
            System.out.printf(String.format("%02d\t", j));
            total++;
            if (total % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
