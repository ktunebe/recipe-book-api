package dev.kent.recipe_book.recipe;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getSingleRecipe(@PathVariable ObjectId id) {
        Optional<Recipe> recipe = recipeService.getRecipeById(id);
        return recipe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        return new ResponseEntity<>(recipeService.saveRecipe(recipe), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable ObjectId id, @RequestBody Recipe recipe) {
        recipe.setId(id);
        return new ResponseEntity<>(recipeService.saveRecipe(recipe), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable ObjectId id) {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
