package com.justinschaaf.fuelrecipes;

import net.fabricmc.api.ModInitializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;

public class FuelRecipes implements ModInitializer {

	public static final String MODID = "fuel_recipes";

	public static final RecipeType<FuelRecipe> FUEL_RECIPE = RecipeType.register(new Identifier(MODID, "fuel").toString());
	public static final FuelRecipeSerializer FUEL_RECIPE_SERIALIZER = RecipeSerializer.register(new Identifier(MODID, "fuel").toString(), new FuelRecipeSerializer());

	@Override
	public void onInitialize() {

		// We don't need to do anything here, just say that we're present and move on with our lives
		System.out.println("Furnace Fuels Kindling An Open Fire");

	}

}
