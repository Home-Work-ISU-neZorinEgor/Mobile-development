import java.io.File

fun main() {
    data class Message(val address: String?, val topic: String?, val sender: String?, val content: String?) {
        fun toHTML(): String {
            val template = StringBuilder()
            template.append("<div style='background-color: #f0f0f0; padding: 20px; border: 1px solid #ccc; border-radius: 5px; box-shadow: 2px 2px 5px #888; max-width: 400px; margin: 0 auto;'>\n")
            template.append("<h2 style='background-color: #0077b6; color: #fff; padding: 10px; border-top-left-radius: 5px; border-top-right-radius: 5px;'>Message Details</h2>\n")
            val bgColor = when (topic) {
                "Meeting Request" -> "#c6e2ff"
                "Important Announcement" -> "#ff9999"
                else -> "#f0f0f0"
            }
            template.append("<table style='font-family: Arial; width: 100%; background-color: $bgColor;'>\n")

            address?.let { template.append("<tr><td style='padding: 5px;'>Address:</td><td style='padding: 5px;'>$it</td></tr>\n") }
            topic?.let { template.append("<tr><td style='padding: 5px;'>Topic:</td><td style='padding: 5px;'>$it</td></tr>\n") }
            sender?.let { template.append("<tr><td style='padding: 5px;'>Sender:</td><td style='padding: 5px;'>$it</td></tr>\n") }
            content?.let { template.append("<tr><td style='padding: 5px;'>Content:</td><td style='padding: 5px;'>$it</td></tr>\n") }

            template.append("</table>\n")
            template.append("</div>\n")
            return template.toString()
        }
    }

    val m = Message("askbill@microsoft.com", null, "John Doe", "Hello, Bill! How are you?")
    val htmlContent = m.toHTML()

    File("email.html").writeText(htmlContent)
}
