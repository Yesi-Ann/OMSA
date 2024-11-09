package com.coffee;

public class CoffeeMachine {
    private int smallCupsAvailable;
    private int mediumCupsAvailable;
    private int largeCupsAvailable;
    private int sugarAvailable;
    private int coffeeAvailable;

    public CoffeeMachine() {
        this.smallCupsAvailable = 10;
        this.mediumCupsAvailable = 10;
        this.largeCupsAvailable = 10;
        this.sugarAvailable = 100;
        this.coffeeAvailable = 100;
    }

    public String serveCoffee(String size, int sugarSpoons) {
        if (!checkResources(size, sugarSpoons)) {
            return "No hay recursos suficientes";
        }

        updateResources(size, sugarSpoons);
        return "Café " + size + " servido con " + sugarSpoons + " cucharadas de azúcar";
    }

    private boolean checkResources(String size, int sugarSpoons) {
        if (sugarSpoons > sugarAvailable) {
            return false;
        }

        int requiredCoffee = switch (size.toLowerCase()) {
            case "pequeño" -> 3;
            case "mediano" -> 5;
            case "grande" -> 7;
            default -> 0;
        };

        if (requiredCoffee > coffeeAvailable) {
            return false;
        }

        return switch (size.toLowerCase()) {
            case "pequeño" -> smallCupsAvailable > 0;
            case "mediano" -> mediumCupsAvailable > 0;
            case "grande" -> largeCupsAvailable > 0;
            default -> false;
        };
    }

    private void updateResources(String size, int sugarSpoons) {
        sugarAvailable -= sugarSpoons;
        
        switch (size.toLowerCase()) {
            case "pequeño" -> {
                smallCupsAvailable--;
                coffeeAvailable -= 3;
            }
            case "mediano" -> {
                mediumCupsAvailable--;
                coffeeAvailable -= 5;
            }
            case "grande" -> {
                largeCupsAvailable--;
                coffeeAvailable -= 7;
            }
        }
    }
}
