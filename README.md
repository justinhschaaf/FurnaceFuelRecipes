# Furnace Fuel Recipes

Defines furnace fuels through recipes.

## Usage

Under `data/{namespace}*/recipes`, create a JSON file with the following options:

| Key        | Value                 | Description |
|------------|-----------------------|-------------|
| `type`     | `"fuel_recipes:fuel"` | Defines that this recipe declares a fuel item.
| `input`    | Ingredient            | An item or tag which this recipe applies to.
| `burnTime` | int                   | The number of ticks this fuel should burn for.

*\* Note that {namespace} should either be your mod id or `fuel_recipes`, not `minecraft`!*

### Example

```json
{
	"type": "fuel_recipes:fuel",
	"input": {
		"item": "minecraft:coal"
	},
	"burnTime": 1600
}
```

## [License](https://github.com/justinhschaaf/FurnaceFuelRecipes/blob/master/LICENSE)

MIT License
