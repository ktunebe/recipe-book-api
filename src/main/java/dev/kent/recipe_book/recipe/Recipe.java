package dev.kent.recipe_book.recipe;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.kent.recipe_book.IngredientInstance;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "recipes")
public class Recipe {
    @Id
    private ObjectId id;

    private String title;
    private String category;
    private List<IngredientInstance> ingredientList;
    private List<String> instructions;
    private List<String> tags = new ArrayList<>();
    private String imagePath;

    public Recipe(ObjectId id, String title, String category, List<IngredientInstance> ingredientList, List<String> instructions, List<String> tags, String imagePath) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.ingredientList = ingredientList;
        this.instructions = instructions;
        this.tags = tags;
        this.imagePath = imagePath;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<IngredientInstance> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<IngredientInstance> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getImagePath() { return imagePath; }

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}
