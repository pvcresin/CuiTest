import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigDecimal

object CuiTest {
    @JvmStatic
    fun main(args: Array<String>) {
        rotateProgressbar()
        linerProgressbar()
        inputName()
    }

    @Throws(Exception::class)
    private fun linerProgressbar() {
        val progressSize = 53
        for (x in 0 until progressSize) {
            var s = "["

            for (y in 0 until progressSize - 1) {
                if (y < x)
                    s += "="
                else if (y == x && x != 0)
                    s += ">"
                else
                    s += " "
            }

            val percentage =
                    BigDecimal((100f / progressSize * x).toDouble())
                            .setScale(1, BigDecimal.ROUND_HALF_UP)

            s += "] $percentage %"

            print("\r" + s)
            Thread.sleep((10000 / progressSize).toLong())
        }
    }

    @Throws(Exception::class)
    private fun rotateProgressbar() {
        val anim = "|/-\\"
        for (x in 0..99) {
            val data = "\r" + anim[x % anim.length] + " " + x
            System.out.write(data.toByteArray())
            Thread.sleep(100)
        }
    }

    @Throws(Exception::class)
    fun inputName() {
        println("\rPlease input your name")

        val reader = BufferedReader(InputStreamReader(System.`in`))
        val line = reader.readLine()
        println("Hello $line !")
    }
}
