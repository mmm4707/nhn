import java.util.ArrayList;
import java.util.List;
//커피음료 추상클래스
abstract class Beverage {
    protected String name;
    protected int price;
    protected boolean isHot;
    protected List<Component> components;

    public Beverage() {
        components = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void displayComponents() {
        System.out.println(name + "의 구성 요소:");
        for (Component component : components) {
            System.out.println(" - " + component.getName() + ": " + component.getQuantity() + "ml");
        }
    }

    public void getCup(boolean isHot) {
        if (isHot) {
            System.out.println("컵 나오는 곳에서 종이컵을 받습니다.");
        } else {
            System.out.println("컵 나오는 곳에서 플라스틱컵을 받습니다.");
        }
    }

    public void getBeverage() {
        if (isHot) {
            System.out.println("음료 추출대에서 " + name + "를 받습니다.");
        } else {
            addComponent(new Component("얼음", 80));
            System.out.println("얼음 추출대에서 얼음을 받습니다.");
            System.out.println("음료 추출대에서 " + name + "를 받습니다.");
        }
    }

    public void sell(String paymentMethod, int money) {
        boolean paymentValid = false;

        if (paymentMethod.equals("cash")) {
            //거스름돈 계산
            if (money >= price) {
                int change = money - price;
                int coin500 = change / 500;
                change %= 500;
    
                int coin100 = change / 100;
                change %= 100;
    
                int coin50 = change / 50;
                change %= 50;
    
                int coin10 = change / 10;
    
                System.out.println(name + " 구매 완료, 거스름돈은 " + (money - price) + "원 입니다.");
                System.out.println("500원: " + coin500 + "개, 100원: " + coin100 + "개, 50원: " + coin50 + "개, 10원: " + coin10 + "개");
                paymentValid = true;
            } else {
                System.out.println(name + "========== 결제를 실패했습니다. (금액이 부족합니다.)==========");
            }
        } else if (paymentMethod.equals("credit")) {
            paymentValid = true;
        } else if (paymentMethod.equals("online")) {
            paymentValid = true;
        } else {
            System.out.println("========== 잘못된 결제 방식입니다. ========== ");
        }

        if (paymentValid) {
            getCup(isHot);
            getBeverage();
        }
    }
}

//뜨거운 음료 추상클래스
abstract class HotBeverage extends Beverage {
}

class Americano extends HotBeverage {
    public Americano() {
        name = "아메리카노";
        price = 1500;
        isHot = true;

        addComponent(new Component("에스프레소", 30));
        addComponent(new Component("물", 120));
        displayComponents();
    }
}

class CafeLatte extends HotBeverage {
    public CafeLatte() {
        name = "카페라떼";
        price = 1700;
        isHot = true;

        addComponent(new Component("에스프레소", 30));
        addComponent(new Component("우유", 100));
        displayComponents();
    }
}

class Mocha extends HotBeverage {
    public Mocha() {
        name = "모카치노";
        price = 1700;
        isHot = true;

        addComponent(new Component("에스프레소", 30));
        addComponent(new Component("우유", 100));
        addComponent(new Component("초코 시럽", 15));
        displayComponents();
    }
}

class HotChocolate extends HotBeverage {
    public HotChocolate() {
        name = "핫 초코";
        price = 1300;
        isHot = true;

        addComponent(new Component("우유", 100));
        addComponent(new Component("초코 시럽", 45));
        displayComponents();
    }
}

//차가운 음료 추상클래스
abstract class ColdBeverage extends Beverage {
}

class IcedAmericano extends ColdBeverage {
    public IcedAmericano() {
        name = "아이스 아메리카노";
        price = 1700;
        isHot = false;

        addComponent(new Component("에스프레소", 30));
        addComponent(new Component("물", 120));
        displayComponents();
    }
}

class IcedChocolate extends ColdBeverage {
    public IcedChocolate() {
        name = "아이스 초코";
        price = 1200;
        isHot = false;
        
        addComponent(new Component("우유", 100));
        addComponent(new Component("초코 시럽", 45));
        displayComponents();
    }
}

class IcedCafeLatte extends ColdBeverage {
    public IcedCafeLatte() {
        name = "아이스 카페라떼";
        price = 1700;
        isHot = false;

        addComponent(new Component("에스프레소", 30));
        addComponent(new Component("우유", 100));
        displayComponents();
    }
}

class PeachIcedTea extends ColdBeverage {
    public PeachIcedTea() {
        name = "복숭아 아이스티";
        price = 1700;
        isHot = false;

        addComponent(new Component("아이스티분말", 30));
        addComponent(new Component("물", 120));
        displayComponents();
    }
}

abstract class BeverageFactory {
    public abstract Beverage createBeverage(String type);
}
