
class ColdBeverageFactory extends BeverageFactory {
    
    public Beverage createBeverage(String type) {
        if (type.equals("icedamericano")) {
            return new IcedAmericano();
        } else if (type.equals("icedchocolate")) {
            return new IcedChocolate();
        } else if (type.equals("icedcafelatte")) {
            return new IcedCafeLatte();
        } else if (type.equals("peachicedtea")) {
            return new PeachIcedTea();
        } else {
            System.out.println("잘못된 음료 종류입니다.");
            return null;
        }
    }
}