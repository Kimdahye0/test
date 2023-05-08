import java.util.Scanner;

/*
김다혜
미니과제 2번
*/
public class Test2{
    public static void main(String[] args) {
        System.out.println("[캐시백 계산]");
        Scanner sc= new Scanner(System.in);
        System.out.print("결제 금액을 입력해 주세요.(금액): ");
        int money = sc.nextInt();
        int cash = (int)((money * 0.1 / 100)) * 100;
        if (cash > 300) {
            cash = 300;
        }
        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원입니다.\n", money, cash);

    }
}
