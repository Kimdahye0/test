import java.util.Random;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[주민등록번호 계산]");

        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        int 출생년도 = sc.nextInt();
        String 년도 = Integer.toString(출생년도).substring(2);
        System.out.print("출생월을 입력해 주세요.(mm):");
        String 출생월 = sc.next();
        System.out.print("출생일을 입력해 주세요.(dd):");
        String 출생일 = sc.next();
        System.out.print("성별을 입력해 주세요(m/f):");
        String 성별 = sc.next();
        if (출생년도 < 2000) {
            if (성별.equals("m")) {
                성별 = "1";
            } else {
                성별 = "2";
            }
        } else {
            if (성별.equals("m")) {
                성별 = "3";
            } else {
                성별 = "4";
            }
        }

        Random rd = new Random();
        int random = rd.nextInt(999999);
        String 임의번호 = String.valueOf(random);

        System.out.println(년도+출생월 +출생일+"-"+성별+임의번호);



    }
}
