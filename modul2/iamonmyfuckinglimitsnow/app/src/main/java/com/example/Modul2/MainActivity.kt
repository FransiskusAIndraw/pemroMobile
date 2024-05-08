package com.example.Modul2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.iamonmyfuckinglimitsnow.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener {
            rollDice()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            } }
    private fun rollDice() {
        val dice2 = Dice2(6)
        val dice = Dice(6)
        val diceRoll2 = dice2.roll()
        var diceRoll = dice.roll()
        val resultImageView: ImageView = findViewById(R.id.imageView)
        val resultImageView2: ImageView = findViewById(R.id.imageView2)
        if (diceRoll == diceRoll2) {
            Toast.makeText(this, "Selamat Anda mendapatkan dadu double", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Anda belum beruntung", Toast.LENGTH_SHORT).show() }
        when (diceRoll) {
            1 ->  resultImageView.setImageResource(R.drawable.dice_1)
            2 ->  resultImageView.setImageResource(R.drawable.dice_2)
            3 ->  resultImageView.setImageResource(R.drawable.dice_3)
            4 ->  resultImageView.setImageResource(R.drawable.dice_4)
            5 ->  resultImageView.setImageResource(R.drawable.dice_5)
            6 ->  resultImageView.setImageResource(R.drawable.dice_6)
        }
        when (diceRoll2) {
            1 ->  resultImageView2.setImageResource(R.drawable.dice_1)
            2 ->  resultImageView2.setImageResource(R.drawable.dice_2)
            3 ->  resultImageView2.setImageResource(R.drawable.dice_3)
            4 ->  resultImageView2.setImageResource(R.drawable.dice_4)
            5 ->  resultImageView2.setImageResource(R.drawable.dice_5)
            6 ->  resultImageView2.setImageResource(R.drawable.dice_6)
        }
        resultImageView.contentDescription = diceRoll.toString()
        resultImageView2.contentDescription = diceRoll2.toString() }
    class Dice2(val numSides: Int){
        fun roll(): Int{
            return (1..numSides).random() } }
    class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random() } } }

