package com.example.havodagi_oyin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Random son tanlash
        val randomNumber = Random.nextInt(1, 101)

        // Test uchun random sonni chiqarish
        println("Random son: $randomNumber")

        // O'yinni boshlash
        startGame(randomNumber)
    }

    private fun startGame(randomNumber: Int) {
        var guessCount = 0
        var guessedNumber: Int

        println("Hush kelibsiz! Men 1 dan 100 gacha bo'lgan sonni o'yladim. Uni topa olasizmi?")

        do {
            // Foydalanuvchidan son kiritish
            print("Sonni kiriting: ")
            guessedNumber = readLine()?.toIntOrNull() ?: 0

            // Tahmin qilingan sonni tekshirish va ma'lumot berish
            if (guessedNumber == 0) {
                println("Xatolik: Sonni kiriting.")
            } else if (guessedNumber < randomNumber) {
                println("Yomon, men o'ylagan son kattaroq. Qayta urinib ko'ring.")
            } else if (guessedNumber > randomNumber) {
                println("Yomon, men o'ylagan son kichikroq. Qayta urinib ko'ring.")
            }

            // Tahminlar sonini oshirish
            guessCount++
        } while (guessedNumber != randomNumber)

        // To'g'ri javobni ekranga chiqarish
        println("Tabriklayman! $randomNumber sonini $guessCount ta urinishda topdingiz.")
    }
}
