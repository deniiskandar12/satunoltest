import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

suspend fun analyzeCustomerFeedback(feedback: String): String {
    // Simulate calling an AI service for sentiment analysis
    val result = simulateSentimentAnalysis(feedback)

    return result
}

suspend fun simulateSentimentAnalysis(feedback: String): String {
    // Simulate sentiment analysis logic (AI)
    return "Positive"
}

fun main() = runBlocking {
    val feedback = "I love this product! It's amazing."

    val result = coroutineScope {
        // Using async to call the suspend function concurrently
        val analysisJob = async(Dispatchers.Default) {
            analyzeCustomerFeedback(feedback)
        }

        // Await the result of the sentiment analysis
        analysisJob.await()
    }

    println("Sentiment Analysis Result: $result")
}
