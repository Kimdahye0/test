import java.util.Random;

import static java.lang.String.*;

public class Test6 {
    public static void main(String[] args) {
        String[] 후보들 = {"이재명", "윤석열", "심상정", "안철수"};
        Integer[] 투표들 = {0, 0, 0, 0};

        Random rd = new Random();

        for (int i = 1; i <= 10000; i++) {
            int number = rd.nextInt(4);
            int 투표 = 투표들[number];
            투표들[number] = 투표 + 1;
            String 후보 = 후보들[number];

            System.out.println("[투표진행율]: " + String.format("%.2f", ((double) i / 10000) * 100) + "%, " + i + "명 투표 => " + 후보);
            for (int j = 0; j < 후보들.length; j++) {
                String n = 후보들[j];
                Integer v = 투표들[j];
                System.out.println("[기호:" + (j + 1) + "] " + n + ": " + String.format("%.2f", ((double) v / 10000) * 100) + "%, (투표수: " + v + ")");

            }
        }
        int max = 0;
        int 당선인 = 0;

        for (int i = 0; i < 투표들.length; i++) {
            if (투표들[i] > max) {
                max = 투표들[i];
                당선인 = i;
            }
        }
        System.out.println("[투표결과] 당선인: " + 후보들[당선인]);

    }
}
