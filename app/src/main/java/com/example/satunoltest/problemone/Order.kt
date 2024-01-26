data class Order(
    val orderId: String,
    val productNames: List<String>,
    val quantity: Map<String, Int>
)

fun suggestPackagingStrategies(orders: List<Order>): Map<String, String> {
    val packagingSuggestions = mutableMapOf<String, String>()

    for (order in orders) {
        val orderId = order.orderId
        val productNames = order.productNames
        val quantity = order.quantity

        // Simulate AI-based optimization for packaging
        val suggestedPackagingStrategy = simulateOptimization(productNames, quantity)

        packagingSuggestions[orderId] = suggestedPackagingStrategy
    }

    return packagingSuggestions
}

fun simulateOptimization(productNames: List<String>, quantity: Map<String, Int>): String {
    val totalQuantity = quantity.values.sum()

    if (totalQuantity <= 5) {
        if (productNames.contains("Fragile"))
            return "Pack all products in one box with special packaging for fragile items."
        else if (productNames.contains("Electronic"))
            return "Pack all products in one box with protective packaging for electronics."
        return "Pack all products in one box."
    } else {
        if (productNames.contains("Fragile"))
            return "Pack all products in multiple boxes with special packaging for fragile items."
        else if (productNames.contains("Electronic"))
            return "Pack all products in multiple boxes with protective packaging for electronics."
        return "Pack all products in multiple boxes."
    }
}
