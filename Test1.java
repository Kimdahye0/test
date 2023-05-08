/*
김다혜
미니과제 1번
*/
public class Test1 {
    public static void main(String[] args) {
        System.out.println("[구구단 출력]");
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.print(j + " * " + i + " = " + String.format("%2d", i * j));
                System.out.print("     ");

            }
            System.out.println();

        }
    }
}
