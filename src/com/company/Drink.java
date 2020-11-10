package com.company;

public final class Drink implements Item {

    private final double cost;

    private String name;

    private String description;

    public Drink(String name, String description) throws IllegalTableNumber {
        this(0, name, description);
    }

    public Drink(double cost, String name, String description) throws IllegalArgumentException {
        this.cost = cost;
        this.name = name;
        this.description = description;
        if (cost < 0 || name == null || name.isBlank() || description == null || description.isBlank())
            throw new IllegalArgumentException("Ошибка в аргументе!");
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Drink setName(String name) throws IllegalTableNumber {
        return new Drink(this.cost, name, description);
    }

    public Drink setCost(double cost) throws IllegalTableNumber {
        return new Drink(cost, this.name, this.description);
    }

    public Drink setDescription(String description) throws IllegalTableNumber {
        return new Drink(this.cost, this.name, description);
    }

    public String toString() {
        return "Напиток " + name + ", " +
                "цена: " + cost + "₽, " +
                (description != "" ? "описание: " + description : "");
    }
}
