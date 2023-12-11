import com.google.gson.Gson
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.*

data class Info(
    val app: String,
    val category: String,
    val rating: String,
    val reviews: String,
    val size: String,
    val installs: Int,
    val type: String,
    val price: Boolean,
    val contentRating: String,
    val genres: List<String>,
    val lastUpdated: String,
    val currentVer: String,
    val androidVer: Double,  // Change the type to Double
)

fun read(filePath: String) {
    File(filePath).forEachLine {
        println(it.split(','))
    }
}

fun parseCsvLine(line: Array<String>): Info {
    return Info(
        line[0],
        line[1],
        line[2],
        line[3],
        line[4],
        line[5].replace("+", "").replace(",", "").toInt(),
        line[6],
        line[7] != "0",
        line[8],
        line[9].split("&"),
        getDate(line[10]),
        line[11],
        getAndroidVersion(line[12]).toDouble()  // Parse as Double
    )
}

fun getAndroidVersion(v: String): Number {
    return when (val version = "\\d+(\\.\\d+)?".toRegex().find(v)?.value ?: "0") {
        "Varies with device" -> 0.0
        else -> androidVersionToApi(version.toDouble())
    }
}

fun androidVersionToApi(version: Double): Int {
    return when (version) {
        in 1.0..1.5 -> 1
        in 1.5..1.6 -> 3
        in 1.6..2.0 -> 4
        in 2.0..2.1 -> 5
        in 2.1..2.2 -> 7
        in 2.2..2.3 -> 8
        in 2.3..3.0 -> 9
        in 3.0..3.1 -> 11
        in 3.1..3.2 -> 12
        in 3.2..4.0 -> 13
        in 4.0..4.1 -> 14
        in 4.1..4.2 -> 16
        in 4.2..4.3 -> 17
        in 4.3..4.4 -> 18
        in 4.4..5.0 -> 19
        in 5.0..5.1 -> 21
        in 5.1..6.0 -> 22
        in 6.0..7.0 -> 23
        in 7.0..7.1 -> 24
        in 7.1..8.0 -> 25
        in 8.0..8.1 -> 26
        in 8.1..9.0 -> 27
        in 9.0..10.0 -> 28
        in 10.0..11.0 -> 29
        in 11.0..12.0 -> 30
        else -> -1
    }
}

fun getDate(date: String): String {
    val input = SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH)
    val output = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
    return output.format(input.parse(date))
}

fun main() {
    val filePath = "src/main/resources/googleplaystore.csv"
    val startLineNumber = 3
    var answer = ""

    BufferedReader(FileReader(filePath)).use { reader ->
        var line: String?
        var currentLineNumber = 1

        // Skip lines until the specified startLineNumber
        while (currentLineNumber < startLineNumber && reader.readLine().also { line = it } != null) {
            currentLineNumber++
        }

        while (reader.readLine().also { line = it } != null) {
            val parts = line?.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)".toRegex())?.map { it.replace("\"", "") }

            try {
                val d = parseCsvLine(parts!!.toTypedArray())
                val gson = Gson()
                val json = gson.toJson(d)
                answer += json
            } catch (e: NumberFormatException) {
                println("Error parsing CSV line: $line")
            }
        }
    }

    val file = "src/main/resources/output.json"
    saveJsonStringToFile(answer, file)
}

fun saveJsonStringToFile(jsonString: String, filePath: String) {
    try {
        val file = File(filePath)
        FileWriter(file).use { writer ->
            writer.write(jsonString)
        }
        println("JSON string successfully saved to file: $filePath")
    } catch (e: Exception) {
        println("Error saving JSON string to file: ${e.message}")
    }

}
