package dev.kent.recipe_book;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
public class IngredientInstance {
    private Optional<Double> quantity;
    private Optional<String> measurement;
    private String ingredientId; // Use ingredient ID instead of Ingredient object
    private Optional<String> prepMethod; // New field for prepMethod method

    public IngredientInstance(String ingredientId) {
        this.quantity = Optional.empty();
        this.measurement = Optional.empty();
        this.prepMethod = Optional.empty();
        this.ingredientId = ingredientId;
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

    public String getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Optional<String> getPrepMethod() {
        return prepMethod;
    }

    public void setPrepMethod(Optional<String> prepMethod) {
        this.prepMethod = prepMethod;
    }

    @Override
    public String toString() {
        return quantity + " " + measurement + " " + ingredientId + " " + prepMethod;
    }
}
