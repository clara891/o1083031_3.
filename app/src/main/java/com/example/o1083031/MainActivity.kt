package com.example.o1083031

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnTouchListener{

    var counter: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txv.setOnClickListener(this)
        img.setOnClickListener(this)
        btn4.setOnClickListener(this)

        btn4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                counter = (1..100).random()
                txv.text = counter.toString()
            }
        })

        txv.setOnClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                counter+=2
                txv.text = counter.toString()
                return true
            }
        })

        txvvb.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent): Boolean {
                //tvxbb.text="touch test"
                if (event?.action == MotionEvent.ACTION_DOWN) {
                    txvvb.text = "手指壓下"
                }
                if (event?.action == MotionEvent.ACTION_UP) {
                    txvvb.text = "手指彈開"
                }

                return true
            })




    fun AddOne(v: View) {
        counter++
        txv.text = counter.toString()
    }

    fun AddTwo(v: View) {
        counter += 2
        txv.text = counter.toString()

    }

        fun Add(v: View) {
            counter =0
            txv.text = counter.toString()
    }

    override fun onClick(v: View?) {
        if (v == txv){
            counter++
        }
        else if (v == img){
            counter += 2
        }
            else{
                counter= (1..100).random()
                txv.text = counter.toString()
            }
        txv.text = counter.toString()

        override fun onTouch(v: View?, event: MotionEvent): Boolean {
            //txvvb.text="touch test"
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (event.action == MotionEvent.ACTION_DOWN){
                txvvb.text="手指壓下"
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    //Build.VERSION.SDK_INT >= 26, New vibrate method for API Level 26 or higher
                    vibrator.vibrate(VibrationEffect.createOneShot(milliseconds: 5000, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    vibrator.vibrate(milliseconds: 5000)
                }
            }
            else{
                vibrator.cancel()
            }
            return true

        }
