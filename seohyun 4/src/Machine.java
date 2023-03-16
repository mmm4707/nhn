
class Machine {
    private BeverageFactory hotBeverageFactory;
    private BeverageFactory coldBeverageFactory;

    public Machine() {
        hotBeverageFactory = new HotBeverageFactory();
        coldBeverageFactory = new ColdBeverageFactory();
    }

    public void sellHotBeverage(String type, String paymentMethod, int money) {
        Beverage beverage = hotBeverageFactory.createBeverage(type);

        if (beverage != null) {
            beverage.sell(paymentMethod, money);
        }
    }

    public void sellColdBeverage(String type, String paymentMethod, int money) {
        Beverage beverage = coldBeverageFactory.createBeverage(type);

        if (beverage != null) {
            beverage.sell(paymentMethod, money);
        }
    }
}