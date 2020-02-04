package com.justinschaaf.fuelrecipes;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class FuelRecipe implements Recipe<Inventory> {

    private Ingredient input;
    private int burnTime;

    public FuelRecipe(Ingredient input, int burnTime) {

        this.input = input;
        this.burnTime = burnTime;

        for (ItemStack inputItem : input.getMatchingStacksClient()) FuelRegistry.INSTANCE.add(inputItem.getItem(), burnTime);

    }

    @Override
    public boolean matches(Inventory inv, World world) {
        if (input.test(inv.getInvStack(1))) return true;
        return false;
    }

    @Override
    public ItemStack craft(Inventory inv) {
        return null;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return null;
    }

    @Override
    public DefaultedList<ItemStack> getRemainingStacks(Inventory inventory) {
        return null;
    }

    @Override
    public DefaultedList<Ingredient> getPreviewInputs() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(getInput());
        return list;
    }

    @Override
    public boolean isIgnoredInRecipeBook() {
        return true;
    }

    @Override
    public String getGroup() {
        return null;
    }

    @Override
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(Blocks.FURNACE);
    }

    @Override
    public Identifier getId() {
        return new Identifier(FuelRecipes.MODID, "fuel");
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return FuelRecipes.FUEL_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return FuelRecipes.FUEL_RECIPE;
    }

    public Ingredient getInput() {
        return input;
    }

    public int getBurnTime() {
        return burnTime;
    }

}
