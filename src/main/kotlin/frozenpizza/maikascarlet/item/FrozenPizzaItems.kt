package frozenpizza.maikascarlet.item

import frozenpizza.maikascarlet.FrozenPizza
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.Item

object FrozenPizzaItems {
    private val FROZEN_PIZZA_KEY: ResourceKey<Item> =
        ResourceKey.create(Registries.ITEM, FrozenPizza.id("frozen_pizza"))
    private val TOMATO_SAUCE_KEY: ResourceKey<Item> =
        ResourceKey.create(Registries.ITEM, FrozenPizza.id("tomato_sauce"))

    val FROZEN_PIZZA: Item = Item(
        Item.Properties()
            .setId(FROZEN_PIZZA_KEY)
            .food(
                FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.8f)
                    .alwaysEdible()
                    .build()
            )
    )

    val TOMATO_SAUCE: Item = Item(Item.Properties().setId(TOMATO_SAUCE_KEY))

    fun register() {
        Registry.register(BuiltInRegistries.ITEM, FROZEN_PIZZA_KEY, FROZEN_PIZZA)
        Registry.register(BuiltInRegistries.ITEM, TOMATO_SAUCE_KEY, TOMATO_SAUCE)
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register { entries ->
            entries.accept(FROZEN_PIZZA)
            entries.accept(TOMATO_SAUCE)
        }
    }
}
