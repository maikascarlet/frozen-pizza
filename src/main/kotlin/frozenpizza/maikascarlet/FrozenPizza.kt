package frozenpizza.maikascarlet

import frozenpizza.maikascarlet.item.FrozenPizzaItems
import net.fabricmc.api.ModInitializer
import net.minecraft.resources.Identifier
import org.slf4j.LoggerFactory

object FrozenPizza : ModInitializer {
	const val MOD_ID: String = "frozen-pizza"

	private val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		FrozenPizzaItems.register()
		LOGGER.info("Frozen Pizza initialized")
	}

	fun id(path: String): Identifier
		= Identifier.fromNamespaceAndPath(MOD_ID, path)
}
