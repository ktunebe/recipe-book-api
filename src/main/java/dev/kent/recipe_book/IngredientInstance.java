package dev.kent.recipe_book;

import java.util.Optional;

public class IngredientInstance {
    private Optional<Double> quantity;
    private Optional<String> measurement;
    private Ingredient ingredient;
    private Optional<String> prepMethod; // New field for prepMethod method

    public IngredientInstance(Optional<Double> quantity, Optional<String> measurement, Ingredient ingredient, Optional<String> prepMethod) {
        this.quantity = quantity;
        this.measurement = measurement;
        this.ingredient = ingredient;
        this.prepMethod = prepMethod;
    }

    public IngredientInstance(Ingredient ingredient) {
        this.quantity = Optional.empty();
        this.measurement = Optional.empty();
        this.prepMethod = Optional.empty();
        this.ingredient = ingredient;
    }

    public Optional<Double> getQuantity() {
        return quantity;
    }

    public void setQuantity(Optional<Double> quantity) {
        this.quantity = quantity;
    }

    public Optional<String> getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Optional<String> measurement) {
        this.measurement = measurement;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Optional<String> getPrepMethod() {
        return prepMethod;
    }

    public void setPrepMethod(Optional<String> prepMethod) {
        this.prepMethod = prepMethod;
    }

    @Override
    public String toString() {
        return quantity + " " + measurement + " " + ingredient.getName() + " " + prepMethod;
    }
}
