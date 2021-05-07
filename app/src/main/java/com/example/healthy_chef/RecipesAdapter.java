package com.example.healthy_chef;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder>{

    private Context context;
    private List<Recipe> recipes;

    public RecipesAdapter(Context context, List<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("RecipeAdapter", "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.item_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("RecipeAdapter", "onCreateViewHolder" + position);
        Recipe recipe = recipes.get(position);
        holder.bind(recipe);
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivRecipeImage;
        TextView tvRecipeName;
        TextView tvServing;
        TextView tvSummary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivRecipeImage = itemView.findViewById(R.id.ivRecipeImage);
            tvRecipeName = itemView.findViewById(R.id.tvRecipeName);
            tvServing = itemView.findViewById(R.id.tvServing);
            tvSummary = itemView.findViewById(R.id.tvSummary);
        }

        public void bind(Recipe recipe) {
            Glide.with(context).load(recipe.getImage()).into(ivRecipeImage);
            tvRecipeName.setText(recipe.getTitle());
            tvServing.setText(recipe.getServings());
            tvSummary.setText(recipe.getSummary());
        }
    }
}
