package com.example.quiz

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class Question : AppCompatActivity()
{

    private var currentPosition: Int=1
    private var questionlist:ArrayList<Questiondata>?=null
    private var selectedoption:Int=0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        questionlist=setdata.getQuestion()

        setQuestion()

        opt_1.setOnClickListener {

            selectedOptionStyle(opt_1,1)
        }
        opt_2.setOnClickListener {

            selectedOptionStyle(opt_2,2)
        }

        submit.setOnClickListener {
            if (selectedoption!=0)
            {
                val question= questionlist!![currentPosition-1]
                if (selectedoption!=question.correct_ans)
                {
                    setColor(selectedoption,R.drawable.wrong_question_option)

                }
                setColor(question.correct_ans,R.drawable.correct_question_option)
                if (currentPosition==questionlist!!.size)
                    submit.text="Finish"
                else
                    submit.text="Go To Next"
            }
            else
            {
                currentPosition++
                when
                {
                    currentPosition<=questionlist!!.size->
                    {
                        setQuestion()
                    }
                    else->
                    {
                        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            selectedoption=0
        }

    }

    fun setColor(opt:Int,color:Int)
    {
        when(opt)
        {
            1->
            {
                opt_1.background=ContextCompat.getDrawable(this,color)
            }
            2->
            {
                opt_2.background=ContextCompat.getDrawable(this,color)
            }
        }
    }

    fun setQuestion()
    {

        val question = questionlist!![currentPosition-1]
        setOptionStyle()

        question_text.text=question.question
        opt_1.text=question.optionone
        opt_2.text=question.optiontwo

    }

    fun setOptionStyle()
    {
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,opt_1)
        optionList.add(1,opt_2)

        for (op in optionList)
        {
            op.setTextColor(Color.parseColor("#403F3F"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface= Typeface.DEFAULT
        }

    }

    fun selectedOptionStyle(view: TextView,opt:Int)
    {
        setOptionStyle()
        selectedoption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface=Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("000000"))

    }
}