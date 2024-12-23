package dev.kent.recipe_book;

import java.util.List;
import java.util.Optional;

public class Ingredient {
    private String name; // Required field
    private Optional<List<String>> tags; // Optional tags
    private Optional<String> description; // Optional description

    // Constructor with all fields
    public Ingredient(String name, Optional<List<String>> tags, Optional<String> description) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
        this.tags = tags != null ? tags : Optional.empty();
        this.description = description != null ? description : Optional.empty();
    }

    // Overloaded constructor for name only
    public Ingredient(String name) {
        this(name, Optional.empty(), Optional.empty());
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public Optional<List<String>> getTags() {
        return tags;
    }

    public void setTags(Optional<List<String>> tags) {
        this.tags = tags != null ? tags : Optional.empty();
    }

    public Optional<String> getDescription() {
        return description;
    }

    public void setDescription(Optional<String> description) {
        this.description = description != null ? description : Optional.empty();
    }
}
