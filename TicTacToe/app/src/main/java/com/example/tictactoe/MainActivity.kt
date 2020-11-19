package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() , View.OnClickListener {
    lateinit var board: Array<Array<Button>>
    var player = true
    var turncount = 0
    lateinit var displayTop : TextView
    var boardstatus = Array(3){IntArray(3)};
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val reset = findViewById<Button>(R.id.reset)
        displayTop = findViewById<TextView>(R.id.displayTop)
        board = arrayOf(
                arrayOf(button1,button2,button3),
                arrayOf(button4,button5,button6),
                arrayOf(button7,button8,button9)
        )
        for(i in board){
            for(button in i)
                button.setOnClickListener(this)
        }
        initBoard()
        reset.setOnClickListener{
            player = true
            turncount = 0
            initBoard()
            updatedisplay("Player X turn")
        }
    }
    private fun initBoard() {
        for(i in 0..2){
            for(j in 0..2){
                boardstatus[i][j] = -1
                board[i][j].isEnabled = true
                board[i][j].text = ""
            }
        }
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.button1->{
                setValue(row = 0, col = 0, play = player)
            }
            R.id.button2->{
                setValue(row = 0, col = 1, play = player)
            }
            R.id.button3->{
                setValue(row = 0, col = 2, play = player)
            }
            R.id.button4->{
                setValue(row = 1, col = 0, play = player)
            }
            R.id.button5->{
                setValue(row = 1, col = 1, play = player)
            }
            R.id.button6->{
                setValue(row = 1, col = 2, play = player)
            }
            R.id.button7->{
                setValue(row = 2, col = 0, play = player)
            }
            R.id.button8->{
                setValue(row = 2, col = 1, play = player)
            }R.id.button9->{
                setValue(row = 2, col = 2, play = player)
            }
        }
        player = !player
        turncount++
        if(player) updatedisplay("Player X turn")
        else updatedisplay("player O turn")
        if(turncount == 9) updatedisplay("Game Draw Reset To Play Again")
        checkWinner()

    }
    private fun checkWinner() {
        for(i in 0..2){
           if(boardstatus[i][0] == boardstatus[i][1] && boardstatus[i][0] == boardstatus[i][2]){
               if(boardstatus[i][0] == 0) {
                   updatedisplay("O won Reset To Play Again")
                   for(i in 0..2) {
                       for (j in 0..2) {
                           board[i][j].isEnabled = false
                       }
                   }
                   break;
               }
               if(boardstatus[i][0] == 1){
                   updatedisplay("X won Reset To Play Again")
                   for(i in 0..2) {
                       for (j in 0..2) {
                           board[i][j].isEnabled = false
                       }
                   }
                   break;
               }
           }
        }
        for(i in 0..2){
            if(boardstatus[0][i] == boardstatus[1][i] && boardstatus[0][i] == boardstatus[2][i]){
                if(boardstatus[0][i] == 0) {
                    updatedisplay("O won Reset To Play Again")
                    for(i in 0..2) {
                        for (j in 0..2) {
                            board[i][j].isEnabled = false
                        }
                    }
                    break;
                }
                if(boardstatus[0][i] == 1){
                    updatedisplay("X won Reset To Play Again")
                    for(i in 0..2) {
                        for (j in 0..2) {
                            board[i][j].isEnabled = false
                        }
                    }
                    break;
                }
            }
        }
        if(boardstatus[0][0] == boardstatus[1][1] && boardstatus[0][0] == boardstatus[2][2]){
            if(boardstatus[0][0] == 0) {
                updatedisplay("O won Reset To Play Again")
                for(i in 0..2) {
                    for (j in 0..2) {
                        board[i][j].isEnabled = false
                    }
                }
            }
            if(boardstatus[0][0] == 1){
                updatedisplay("X won Reset To Play Again")
                for(i in 0..2) {
                    for (j in 0..2) {
                        board[i][j].isEnabled = false
                    }
                }
            }
        }
        if(boardstatus[0][2] == boardstatus[1][1] && boardstatus[0][2] == boardstatus[2][0]){
            if(boardstatus[0][2] == 0) {
                updatedisplay("O won Reset To Play Again")
                for(i in 0..2) {
                    for (j in 0..2) {
                        board[i][j].isEnabled = false
                    }
                }
            }
            if(boardstatus[0][2] == 1){
                updatedisplay("X won Reset To Play Again")
                for(i in 0..2) {
                    for (j in 0..2) {
                        board[i][j].isEnabled = false
                    }
                }
            }
        }
    }

    fun updatedisplay(text: String) {
        displayTop.text = text
    }
    private fun setValue(row: Int, col: Int, play: Boolean) {
        val text = if(play) "X" else "O"
        val value = if(play) 1 else 0
        board[row][col].apply{
            isEnabled = false;
            setText(text)
        }
        boardstatus[row][col] = value

    }
}