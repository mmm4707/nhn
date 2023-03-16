
class HotBeverageFactory extends BeverageFactory {

    public Beverage createBeverage(String type) {
        if (type.equals("americano")) {
            return new Americano();
        } else if (type.equals("cafelatte")) {
            return new CafeLatte();
        } else if (type.equals("mocha")) {
            return new Mocha();
        } else if (type.equals("hotchocolate")) {
            return new HotChocolate();
        } else {
            System.out.println("잘못된 음료 종류입니다.");
            return null;
        }
    }
}