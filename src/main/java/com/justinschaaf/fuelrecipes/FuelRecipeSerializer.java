package com.justinschaaf.fuelrecipes;

import com.google.gson.JsonObject;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.PacketByteBuf;

public class FuelRecipeSerializer implements RecipeSerializer<FuelRecipe> {

    @Override
    public FuelRecipe read(Identifier id, JsonObject json) {

        Ingredient input = Ingredient.fromJson(json.get("input"));
        int burnTime = JsonHelper.getInt(json, "burnTime", 1600);

        return new FuelRecipe(input, burnTime);

    }

    @Override
    public FuelRecipe read(Identifier id, PacketByteBuf buf) {
        return new FuelRecipe(Ingredient.fromPacket(buf), buf.readInt());
    }

    @Override
    public void write(PacketByteBuf buf, FuelRecipe recipe) {
        recipe.getInput().write(buf);       // Write the input
        buf.writeInt(recipe.getBurnTime()); // Write the burnTime
    }

}
