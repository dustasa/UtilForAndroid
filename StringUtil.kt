package com.decard.launchsettings.utils

import java.nio.charset.Charset
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class StringUtil {

    /**
     * 判断字符串是否是16进制
     * @param s
     * @return
     */
    public fun isHex(s: String): Boolean {
        val regex = Regex("^[A-Fa-f0-9]+$")
        return s.matches(regex)
    }

    /**
     * 16进制转换成为string类型字符串
     * @param s
     * @return
     */
    public fun hexStringToString(s: String?): String? {
        var s = s
        if (s == null || s == "") {
            return null
        }
        s = s.replace(" ", "")
        val baKeyword = ByteArray(s.length / 2)
        for (i in baKeyword.indices) {
            try {
                baKeyword[i] = (0xff and s.substring(i * 2, i * 2 + 2).toInt(16)).toByte()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        try {
            s = String(baKeyword, Charset.forName("UTF-8"))
        } catch (e1: Exception) {
            e1.printStackTrace()
        }
        return s
    }


    @Throws(ParseException::class)
    public fun dateToStamp(s: String?): String? {
        val res: String
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date: Date = simpleDateFormat.parse(s)
        val ts: Long = date.time
        res = ts.toString()
        return res
    }
}