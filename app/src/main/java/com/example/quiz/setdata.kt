package com.example.quiz

object setdata {

    fun getQuestion(): ArrayList<Questiondata>
    {
        var que:ArrayList<Questiondata> = arrayListOf();
        var que1= Questiondata(
            "Is Delhi the capital of India.",
            1,
            "True",
            "False",
            1
        )

        var que2= Questiondata(
            "Is Mount Kilimanjaro in China",
            2,
            "True",
            "False",
            2
        )

        var que3= Questiondata(
            "Which is the economic capital of India",
            3,
            "Delhi",
            "Mumbai",
            2
        )

        var que4= Questiondata(
            "The Sahara Desert is located in Africa.",
            4,
            "True",
            "False",
            1
        )

        var que5= Questiondata(
            "The Nile flows into the Mediterranean sea.",
            5,
            "True",
            "False",
            1
        )

        var que6= Questiondata(
            "Which of this is not an Ocean.",
            6,
            "Bay of Bengal",
            "Indian",
            1
        )
        que.add(que1)
        que.add(que2)
        que.add(que3)
        que.add(que4)
        que.add(que5)
        que.add(que6)
        return que
    }
}