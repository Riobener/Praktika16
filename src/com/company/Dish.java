package com.company;

public final class Dish implements Item {
    private final double cost;

    private final String name;

    private final String description;

    public Dish(String name, String description) throws IllegalTableNumber {
        this(0, name, description);
    }

    public Dish(double cost, String name, String description) throws IllegalArgumentException{
        this.cost = cost;
        this.name = name;
        this.description = description;
        if (cost < 0 || name == null || name.isBlank() || description == null || description.isBlank())
            throw new IllegalArgumentException("Ошибка в аргументе!");
    }

    public double getCost() {
        return cost;
    }

    public Dish setCost(double cost) throws IllegalTableNumber {
        return new Dish(cost, this.name, this.description);
    }

    public String getName() {
        return name;
    }

    public Dish setName(String name) throws IllegalTableNumber {
        return new Dish(this.cost, name, description);
    }

    public String getDescription() {
        return description;
    }

    public Dish setDescription(String description) throws IllegalTableNumber {
        return new Dish(this.cost, this.name, description);
    }

    public String toString() {
        return "Блюдо " + name + ", " +
                "цена: " + cost + "₽, " +
                (description != "" ? "описание: " + description : "");
    }
}
