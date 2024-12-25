package dev.kent.recipe_book.recipe;

import dev.kent.recipe_book.ingredient.Ingredient;
import dev.kent.recipe_book.ingredient.IngredientRepository;
import dev.kent.recipe_book.IngredientInstance;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        for (Recipe recipe : recipes) {
            populateIngredientNames(recipe);
        }
        return recipes;
    }

    public Optional<Recipe> getRecipeById(ObjectId id) {
        Optional<Recipe> recipeOpt = recipeRepository.findById(id);
        recipeOpt.ifPresent(this::populateIngredientNames);
        return recipeOpt;
    }

    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(ObjectId id) {
        recipeRepository.deleteById(id);
    }

    private void populateIngredientNames(Recipe recipe) {
        for (IngredientInstance ingredientInstance : recipe.getIngredientList()) {
            Optional<Ingredient> ingredientOpt = ingredientRepository.findById(new ObjectId(ingredientInstance.getIngredientId()));
            ingredientOpt.ifPresent(ingredient -> ingredientInstance.setIngredientName(ingredient.getName()));
        }
    }
}
