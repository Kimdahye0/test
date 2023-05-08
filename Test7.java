import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test7{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("[로또 당첨 프로그램]");
        System.out.println();
        System.out.print("로또 개수를 입력해주세요.(숫자 1~10): ");

        char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        int quantity = scanner.nextInt();
        int[][] numbersArray = new int[quantity][6];

        int[] balls = new int[46];
        for (int i = 0; i < numbersArray.length; i++) {
            for (int j = 0; j < balls.length; j++) {
                balls[j] = j + 1;
            }
            int[] numbers = numbersArray[i];
            int tmp = 0;
            int k = 0;
            for (int j = 0; j < numbers.length; j++) {
                k = random.nextInt(46);
                tmp = balls[j];
                balls[j] = balls[k];
                balls[k] = tmp;
            }

            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = balls[j];
            }

            // 정렬
            Arrays.sort(numbers);
        }

        for (int i = 0; i < numbersArray.length; i++) {
            int[] numbers = numbersArray[i];
            System.out.print(alphabets[i] + "    ");
            for (int j = 0; j < numbers.length; j++) {
                if (j < numbers.length - 1) {
                    System.out.print(String.format("%02d,", numbers[j]));
                } else {
                    System.out.println(String.format("%02d", numbers[j]));
                }
            }
        }

        int[] winningNumbers = new int[6];
        for (int i = 0; i < balls.length; i++) {
            balls[i] = i + 1;
        }
        int tmp = 0;
        int j = 0;
        for (int i = 0; i < winningNumbers.length; i++) {
            j = random.nextInt(46);
            tmp = balls[i];
            balls[i] = balls[j];
            balls[j] = tmp;
        }

        for (int i = 0; i < winningNumbers.length; i++) {
            winningNumbers[i] = balls[i];
        }
        Arrays.sort(winningNumbers);

        System.out.println();
        System.out.println("[로또 발표]");
        System.out.print("     ");
        for (int i = 0; i < winningNumbers.length; i++) {
            if (i < winningNumbers.length - 1) {
                System.out.print(String.format("%02d,", winningNumbers[i]));
            } else {
                System.out.println(String.format("%02d", winningNumbers[i]));
            }
        }

        int[] matchingNumbers = new int[quantity];
        for (int i = 0; i < numbersArray.length; i++) {
            int[] numbers = numbersArray[i];
            for (int k = 0; k < numbers.length; k++) {
                for (int l = 0; l < winningNumbers.length; l++) {
                    if (numbers[k] == winningNumbers[l]) {
                        matchingNumbers[i] += 1;
                    }
                }
            }
        }

        System.out.println();
        System.out.println("[내 로또 결과]");

        for (int i = 0; i < numbersArray.length; i++) {
            int[] numbers = numbersArray[i];
            System.out.print(alphabets[i] + "    ");
            for (int k = 0; k < numbers.length; k++) {
                if (k < numbers.length - 1) {
                    System.out.print(String.format("%02d,", numbers[k]));
                } else {
                    System.out.print(String.format("%02d", numbers[k]));
                    System.out.println(" => " + matchingNumbers[i] + "개 일치");
                }
            }
        }
    }
}
