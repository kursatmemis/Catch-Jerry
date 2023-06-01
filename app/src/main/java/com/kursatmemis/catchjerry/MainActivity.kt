package com.kursatmemis.catchjerry

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var intent: Intent
    private lateinit var timeTextView: TextView
    private lateinit var scoreTextView: TextView
    private lateinit var imageView0: ImageView
    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var imageView4: ImageView
    private lateinit var imageView5: ImageView
    private lateinit var imageView6: ImageView
    private lateinit var imageView7: ImageView
    private lateinit var imageView8: ImageView
    private lateinit var imageView9: ImageView
    private lateinit var imageView10: ImageView
    private lateinit var imageView11: ImageView
    private lateinit var images: Array<ImageView>
    private var clickNumber = 0
    private var prevIndex = 0
    private var currentIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViews()
        intent = Intent(this, MainActivity::class.java)

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Game Over")
        alertDialog.setMessage("Restart The Game?")

        alertDialog.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                finish()
                startActivity(intent)
            }
        })
        alertDialog.setNegativeButton("No", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(this@MainActivity, "Game Over", Toast.LENGTH_SHORT).show()
            }
        })

        images = arrayOf(
            imageView0, imageView1, imageView2, imageView3, imageView4, imageView5,
            imageView6, imageView7, imageView8, imageView9, imageView10, imageView11
        )

        val countDownTimerForTextView = object : CountDownTimer(15000, 1000) {

            override fun onTick(time: Long) {
                timeTextView.text = "Time: ${time / 1000}"
            }

            override fun onFinish() {
                alertDialog.show()
            }

        }
        val countDownTimerForJerry = object : CountDownTimer(15000, 400) {
            override fun onTick(time: Long) {
                setCarryPlace()
            }

            override fun onFinish() {

            }

        }

        countDownTimerForTextView.start()
        countDownTimerForJerry.start()

    }

    fun increaseScore(view: View?) {
        scoreTextView.text = "Score: ${++clickNumber}"
    }

    fun setCarryPlace() {
        prevIndex = currentIndex
        currentIndex = (Math.random() * 12).toInt()
        images[prevIndex].visibility = View.INVISIBLE
        images[currentIndex].visibility = View.VISIBLE
    }

    fun setViews() {
        imageView0 = findViewById(R.id.imageView0)
        imageView1 = findViewById(R.id.imageView1)
        imageView2 = findViewById(R.id.imageView2)
        imageView3 = findViewById(R.id.imageView3)
        imageView4 = findViewById(R.id.imageView4)
        imageView5 = findViewById(R.id.imageView5)
        imageView6 = findViewById(R.id.imageView6)
        imageView7 = findViewById(R.id.imageView7)
        imageView8 = findViewById(R.id.imageView8)
        imageView9 = findViewById(R.id.imageView9)
        imageView10 = findViewById(R.id.imageView10)
        imageView11 = findViewById(R.id.imageView11)
        timeTextView = findViewById(R.id.timeTextView)
        scoreTextView = findViewById(R.id.scoreTextView)
    }
}