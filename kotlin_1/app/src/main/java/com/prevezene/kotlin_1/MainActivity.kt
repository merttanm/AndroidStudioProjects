package com.prevezene.kotlin_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var x=5
        var y=4
        println( x *y )

        var age=35

        val result = age / 7
        println(result)

        val pi =3.14
        println( pi * 2 )

        var myAge : Double
        myAge =23.34534
        println(myAge )
        println(myAge / 2)

        //Stringler

        println("-------- Stringler ---------")

        val myString ="Mert tan"
        val fullString = myString.length
        println(fullString)
        println("-------- Boolean ---------")

        var myBoolean : Boolean = true
      //  myBoolean = false
        println(myBoolean )
        println(6 < 3)

        println("-------- Conversion ---------")

        var myNumber =5;
        var myLongNumber = myNumber.toLong()

        println (myLongNumber)

        var input="10"
        var inputString =input.toInt()
        println(inputString)

        println("-------- Array ---------")


        val myArray = arrayOf("Ali", "AK","NuMAN", "Dumaneder" )
        println(myArray[0])
        println(myArray[1])

        val numberArray= arrayOf(1,2,3,4,5,6,7,8,9,0)
        println(numberArray[0])
        println(numberArray[1])
        println(numberArray[2])
        println(numberArray[3])
        println(numberArray[4])

        val mixArray = arrayOf("Aliş", 1453)
        println(mixArray[0] )
        println(mixArray[1])



    }
}