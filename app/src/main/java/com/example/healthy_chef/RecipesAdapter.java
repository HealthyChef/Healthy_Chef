package com.example.healthy_chef;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import org.parceler.Parcels;

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

        RelativeLayout container;
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
            tvRecipeName.setText(recipe.getTitle());
            tvServing.setText(recipe.getServings());
            tvSummary.setText(recipe.getSummary());
            String imageUrl;
            Glide.with(context).load(recipe.getImage()).into(ivRecipeImage);

            //1. Register click listener on the whole row
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //2. Navigate to a new activity on tap
                    Intent i = new Intent(context, DetailActivity.class);
                    i.putExtra("recipe", Parcels.wrap(recipe));
                    context.startActivity(i);
                }
            });
        }
    }
}
