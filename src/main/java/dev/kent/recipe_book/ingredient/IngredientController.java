package dev.kent.recipe_book.ingredient;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return new ResponseEntity<>(ingredientService.getAllIngredients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getSingleIngredient(@PathVariable ObjectId id) {
        Optional<Ingredient> ingredient = ingredientService.getIngredientById(id);
        return ingredient.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                         .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        return new ResponseEntity<>(ingredientService.saveIngredient(ingredient), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable ObjectId id, @RequestBody Ingredient ingredient) {
        Optional<Ingredient> existingIngredientOpt = ingredientService.getIngredientById(id);
        if (existingIngredientOpt.isPresent()) {
            Ingredient existingIngredient = existingIngredientOpt.get();
            if (ingredient.getName() != null) {
                existingIngredient.setName(ingredient.getName());
            }
            if (ingredient.getDescription() != null) {
                existingIngredient.setDescription(ingredient.getDescription());
            }
            return new ResponseEntity<>(ingredientService.saveIngredient(existingIngredient), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable ObjectId id) {
        ingredientService.deleteIngredient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
