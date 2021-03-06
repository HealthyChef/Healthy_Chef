package com.example.healthy_chef;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Recipe {
    String id;
    String title;
    String summary;
    String servings;
    String image;

    // empty constructor needed by the Parceler library
    public Recipe() { }

    public Recipe(JSONObject jsonObject) throws JSONException {

        id = jsonObject.getString("id");
        title = jsonObject.getString("title");
        summary = jsonObject.getString("summary");
        servings = jsonObject.getString("servings");
        image = jsonObject.getString("image");
    }

    public static List<Recipe> fromJsonArray(JSONArray recipeJsonArray) throws JSONException {
        List<Recipe> recipes = new ArrayList<>();
        for (int i = 0; i < recipeJsonArray.length(); i++){
            recipes.add(new Recipe(recipeJsonArray.getJSONObject(i)));
        }
        return recipes;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        summary = summary.replace("<b>", "");
        summary = summary.replace("</b>", "");
        return summary;
    }

    public String getServings() {
        return "Number of servings: " + servings;
    }

    public String getImage() {
        return image;
    }
}
