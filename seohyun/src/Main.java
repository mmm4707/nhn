import java.util.Scanner;

/**
 * 
 * @author 김서현
 */
public class Main {
    public static void main(String[] args) {
        Machine machine1 = new Machine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("음료주문 : 1, 종료 : 0");
            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 0) {
                System.out.println("주문을 종료합니다.");
                break;
            } else if (input == 1) {
                System.out.println(
                        "음료 종류를 입력하세요. "
                                + "(americano, cafelatte, mocha, hotchocolate, icedamericano, icedchocolate, icedcafelatte, peachicedtea)");
                String type = scanner.nextLine();

                Beverage tempBeverage;
                if (type.equalsIgnoreCase("americano")
                        || type.equalsIgnoreCase("cafelatte")
                        || type.equalsIgnoreCase("mocha")
                        || type.equalsIgnoreCase("hotchocolate")) {
                    tempBeverage = new HotBeverageFactory().createBeverage(type.toLowerCase());
                } else if (type.equalsIgnoreCase("icedamericano")
                        || type.equalsIgnoreCase("icedchocolate")
                        || type.equalsIgnoreCase("icedcafelatte")
                        || type.equalsIgnoreCase("peachicedtea")) {
                    tempBeverage = new ColdBeverageFactory().createBeverage(type.toLowerCase());
                } else {
                    System.out.println("ERROR : 잘못된 음료 종류입니다.");
                    continue;
                }

                System.out.println("선택하신 음료의 가격은 " + tempBeverage.getPrice() + "원 입니다.");
                System.out.println("결제 방식을 입력하세요. (cash, credit, online)");
                String paymentMethod = scanner.nextLine();

                if (paymentMethod.equals("cash")) {
                    System.out.println("지불할 금액을 입력하세요.");
                    int money = scanner.nextInt();
                    scanner.nextLine();

                    if (type.equalsIgnoreCase("americano")
                            || type.equalsIgnoreCase("cafelatte")
                            || type.equalsIgnoreCase("mocha")
                            || type.equalsIgnoreCase("hotchocolate")) {
                        machine1.sellHotBeverage(type.toLowerCase(), paymentMethod, money);
                    } else if (type.equalsIgnoreCase("icedamericano")
                            || type.equalsIgnoreCase("icedchocolate")
                            || type.equalsIgnoreCase("icedcafelatte")
                            || type.equalsIgnoreCase("peachicedtea")) {
                        machine1.sellColdBeverage(type.toLowerCase(), paymentMethod, money);
                    }
                } else if (paymentMethod.equals("credit") || paymentMethod.equals("online")) {
                    if (type.equalsIgnoreCase("americano")
                            || type.equalsIgnoreCase("cafelatte")
                            || type.equalsIgnoreCase("mocha")
                            || type.equalsIgnoreCase("hotchocolate")) {
                        machine1.sellHotBeverage(type.toLowerCase(), paymentMethod, 0);
                    } else if (type.equalsIgnoreCase("icedamericano")
                            || type.equalsIgnoreCase("icedchocolate")
                            || type.equalsIgnoreCase("icedcafelatte")
                            || type.equalsIgnoreCase("peachicedtea")) {
                        machine1.sellColdBeverage(type.toLowerCase(), paymentMethod, 0);
                    }
                } else {
                    System.out.println("ERROR : 잘못된 결제 방식입니다.");
                }
            } else {
                System.out.println("ERROR : 잘못된 입력입니다.");
            }
        }

        scanner.close();
    }
}