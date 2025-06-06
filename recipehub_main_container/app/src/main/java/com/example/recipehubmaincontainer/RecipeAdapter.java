package com.example.recipehubmaincontainer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// PUBLIC_INTERFACE
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<Recipe> recipeList;
    private Context context;

    // PUBLIC_INTERFACE
    public RecipeAdapter(Context context, List<Recipe> recipeList) {
        this.context = context;
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recipe_card, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.nameTextView.setText(recipe.getName());
        holder.descTextView.setText(recipe.getShortDescription());
        holder.categoryTextView.setText(recipe.getCategory());

        // Placeholder: show static image from drawable; image loading library recommended for URLs
        // Here, if the URL starts with "http", you should ideally use Glide/Picasso, but for placeholder use fallback.
        holder.imageView.setImageResource(R.drawable.ic_recipe_placeholder);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    // PUBLIC_INTERFACE
    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView descTextView;
        TextView categoryTextView;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recipeImage);
            nameTextView = itemView.findViewById(R.id.recipeName);
            descTextView = itemView.findViewById(R.id.recipeDesc);
            categoryTextView = itemView.findViewById(R.id.recipeCategory);
        }
    }
}
