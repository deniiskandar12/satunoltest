import androidx.lifecycle.MutableLiveData

data class ProductReview(val id: Int, val reviewText: String)

class ProductReviewAnalyzer {
    // Define your LiveData object containing a list of ProductReview
    val productReviewsLiveData: MutableLiveData<List<ProductReview>> = MutableLiveData()

    init {
        // Set up the observer for LiveData
        productReviewsLiveData.observeForever { reviews ->
            // Call the function to analyze reviews and display insights
            analyzeReviews(reviews)
        }
    }

    // Function to analyze reviews and extract key insights
    private fun analyzeReviews(reviews: List<ProductReview>) {
        // Count the occurrences of words in the reviews
        val wordCountMap = mutableMapOf<String, Int>()

        for (review in reviews) {
            val words = review.reviewText.split("\\s+".toRegex())
            for (word in words) {
                wordCountMap[word] = wordCountMap.getOrDefault(word, 0) + 1
            }
        }

        // Find the most mentioned feature (word) in the reviews
        val mostMentionedFeature = wordCountMap.maxByOrNull { it.value }?.key

        // Display insights as console output
        println("Most mentioned feature: $mostMentionedFeature")
    }
}

fun main() {
    // Create an instance of ProductReviewAnalyzer
    val productReviewAnalyzer = ProductReviewAnalyzer()

    // Simulate updating LiveData with new reviews
    productReviewAnalyzer.productReviewsLiveData.value = listOf(
        ProductReview(1, "Great product with amazing features."),
        ProductReview(2, "The battery life is excellent."),
        ProductReview(3, "Easy to use and user-friendly."),
        ProductReview(4, "The camera quality could be better.")
    )

    // Simulate another update to LiveData
    productReviewAnalyzer.productReviewsLiveData.value = listOf(
        ProductReview(5, "Amazing camera quality."),
        ProductReview(6, "The user interface is a bit confusing."),
        ProductReview(7, "Battery life is not up to the mark.")
    )
}
