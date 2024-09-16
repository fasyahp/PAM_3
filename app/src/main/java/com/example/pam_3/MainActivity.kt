package com.example.pam_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var textInput: TextView
    private lateinit var textOutput: TextView
    private var currentNumber: String = ""
    private var firstNumber: Double = 0.0
    private var operator: String = ""
    private var isOperatorPressed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi TextView untuk input dan output
        textInput = findViewById(R.id.textInput)
        textOutput = findViewById(R.id.textOutput)

        // Inisialisasi tombol-tombol angka
        val satu: Button = findViewById(R.id.satu)
        val dua: Button = findViewById(R.id.dua)
        val tiga: Button = findViewById(R.id.tiga)
        val empat: Button = findViewById(R.id.empat)
        val lima: Button = findViewById(R.id.lima)
        val enam: Button = findViewById(R.id.enam)
        val tujuh: Button = findViewById(R.id.tujuh)
        val delepan: Button = findViewById(R.id.delepan)
        val sembilan: Button = findViewById(R.id.sembilan)
        val nol: Button = findViewById(R.id.nol)

        // Inisialisasi tombol operator
        val tambah: Button = findViewById(R.id.tambah)
        val kurang: Button = findViewById(R.id.kurang)
        val kali: Button = findViewById(R.id.Kali)
        val bagi: Button = findViewById(R.id.Bagi)
        val hasil: Button = findViewById(R.id.hasil)

        // Inisialisasi tombol untuk hapus semua
        val hapusALL: Button = findViewById(R.id.HapusALL)

        // Listener untuk tombol angka
        satu.setOnClickListener { appendNumber("1") }
        dua.setOnClickListener { appendNumber("2") }
        tiga.setOnClickListener { appendNumber("3") }
        empat.setOnClickListener { appendNumber("4") }
        lima.setOnClickListener { appendNumber("5") }
        enam.setOnClickListener { appendNumber("6") }
        tujuh.setOnClickListener { appendNumber("7") }
        delepan.setOnClickListener { appendNumber("8") }
        sembilan.setOnClickListener { appendNumber("9") }
        nol.setOnClickListener { appendNumber("0") }

        // Listener untuk tombol operator
        tambah.setOnClickListener { setOperator("+") }
        kurang.setOnClickListener { setOperator("-") }
        kali.setOnClickListener { setOperator("*") }
        bagi.setOnClickListener { setOperator("/") }

        // Listener untuk tombol hasil
        hasil.setOnClickListener { calculateResult() }

        // Listener untuk tombol hapus semua
        hapusALL.setOnClickListener { clearAll() }
    }

    // Fungsi untuk menambahkan angka ke dalam input
    private fun appendNumber(number: String) {
        if (isOperatorPressed) {
            currentNumber = ""
            isOperatorPressed = false
        }
        currentNumber += number
        textInput.text = currentNumber
    }

    // Fungsi untuk menyimpan operator dan angka pertama
    private fun setOperator(op: String) {
        if (currentNumber.isNotEmpty()) {
            firstNumber = currentNumber.toDouble()
            operator = op
            isOperatorPressed = true
        }
    }

    // Fungsi untuk menghitung hasil berdasarkan operator yang dipilih
    private fun calculateResult() {
        if (currentNumber.isNotEmpty()) {
            val secondNumber = currentNumber.toDouble()
            val result = when (operator) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> if (secondNumber != 0.0) firstNumber / secondNumber else Double.NaN
                else -> 0.0
            }
            textOutput.text = result.toString()
            currentNumber = result.toString() // Menyimpan hasil sebagai angka saat ini
        }
    }

    // Fungsi untuk menghapus semua input dan output
    private fun clearAll() {
        currentNumber = ""
        firstNumber = 0.0
        operator = ""
        isOperatorPressed = false
        textInput.text = ""
        textOutput.text = ""
    }
}