package com.khjqwer.wildanimalapp

// Singleton
object Session {
    var questionsAnsweredCount = 0
    val score: Int
        get() = questionsAnsweredCount * 5

    val currentQuestion: QuestionBank
        get() = questions[currentQuestionIndex]

    private lateinit var questions: List<QuestionBank>

    var currentQuestionIndex: Int = 0

    fun createQuestionBank() {
        questions = listOf(
            QuestionBank(
                question = "which of following is greenhouse gas(GHG)?",
                q1 = "CO2",
                q2 = "CH4",
                q3 = "Water Vapor",
                q4 = "All of the above ",
                correct = 3,
                explanation = "Greenhouse gasses may be a result of natural occurrence or human activity. These gasses include carbon dioxide (CO2), methane (CH4), water vapor, nitrous oxide (N2O) and ozone (O3). Fluorinated gasses are also considered to be greenhouse gasses.",
            ),
            QuestionBank(
                question = "How much have sea levels risen in the past 100 years?",
                q1 = "7 inches",
                q2 = "2 inches",
                q3 = "5 inches",
                q4 = "16 inches",
                correct = 0,
                explanation = "On average, global sea level has risen about seven inches in the last 100 years. By 2100, sea level is expected to increase by another 1.5 to 3 feet, resulting in stronger and more frequent storm surges.",
            ),
            QuestionBank(
                question = "What is climate change?",
                q1 = "Helping people with making the climate warmer.",
                q2 = "It is long-term shifts in temperatures and weather patterns",
                q3 = "Climate change is a phenomenon that people feel more warm about the climate",
                q4 = "I like climate change",
                correct = 1,
                explanation = "Climate change is the significant variation of average weather conditions becoming, for example, warmer, wetter, or drier—over several decades or longer. It is the longer-term trend that differentiates climate change from natural weather variability.",
            ),
            QuestionBank(
                question = "What ation can make the climate change worse?",
                q1 = "ride bike ",
                q2 = "walking close distance",
                q3 = "burning fossil fuel",
                q4 = "using solar power generation",
                correct = 3,
                explanation = "Burning fossil fuel can make the atmosphere worse which can ead to make the climate change worse",
            ),
            QuestionBank(
                question = "What percentage of the global greenhouse gas emissions does the transportation sector emit?",
                q1 = "1%",
                q2 = "20%",
                q3 = "33%",
                q4 = "70%",
                correct = 1,
                explanation = "Transportation is the fastest growing source of emissions worldwide, and now accounts for 20% of global greenhouse gas emissions - behind only the power sector. ",
            ),
            QuestionBank(
                question = "Which of these countries emits the most carbon dioxide?",
                q1 = "China",
                q2 = "USA",
                q3 = "Russia ",
                q4 = "UK",
                correct = 0,
                explanation = "China is currently the largest single-country contributor to global GHG emissions. In 2020, China accounted for about 26% of global CO2 emissions, followed by the US at 11%, and then India at about 7%. While China has the greatest present emissions, the U.S. cumulatively has the largest GHG emissions.",
            ),
            QuestionBank(
                question = "Globally, which of the following economic sectors emits the largest percentage of greenhouse gas emissions?",
                q1 = "Residential",
                q2 = "Transportation",
                q3 = "Indutry",
                q4 = "Electric power",
                correct = 3,
                explanation = "The electric power sector accounted for 39.3% of global CO2 emissions in 2022 followed behind by the industry sector. While emissions are still on the rise, the rate of increase has slowed since 2021.",
            ),
            QuestionBank(
                question = "What can you do to help fight climate change?",
                q1 = "Utilize public transit",
                q2 = "Consume less meat products",
                q3 = "Vote for political candidates who will advocate for climate-related legislation and policy improvement",
                q4 = "All of the above",
                correct = 3,
                explanation = "All of the answers above can help to fight against environment problems.",
            ),
            QuestionBank(
                question = "Which disater is most likely to be influenced by climate change?",
                q1 = "Earthquake",
                q2 = "Tsunamis",
                q3 = "Tropiclal cyclones",
                q4 = "volcanic eruptions",
                correct = 2,
                explanation = "Climate change affect tropical cyclones in a variety of ways: an intensification of rainfall and wind speed, an increase in the frequency of very intense storms and a poleward extension of where the cyclones reach maximum intensity are among the consequences of human-induced climate change.",
            ),
            QuestionBank(
                question = "What has the scientific community concluded about climate change?",
                q1 = "The consensus is that it is both real and man-made.",
                q2 = "Scientists have shown it to be real but aren’t sure whether it is man-made.",
                q3 = "Scientists do not think climate change is real.",
                q4 = "There is little consensus.",
                correct = 0,
                explanation = "The U.N. Intergovernmental Panel on Climate Change (IPCC), the leading scientific body on the subject, declared last August that human-caused warming of the atmosphere, land and oceans is “unequivocal.”",
            ),
            QuestionBank(
                question = "Which of these factors most contributes to current global warming?",
                q1 = "Sunspots",
                q2 = "The hole in the ozone layer",
                q3 = "Littering",
                q4 = "Carbon dioxide emissions",
                correct = 3,
                explanation = "Carbon dioxide, a greenhouse gas that traps heat in the atmosphere, is the main cause of global warming. Scientists do not think changes in the sun can explain the warming we’re seeing.",
            ),
            QuestionBank(
                question = "What is the greenhouse effect?",
                q1 = "The measurement of plant growth in areas affected by flooding.",
                q2 = "The phenomenon in which gases in the Earth’s atmosphere prevent heat from escaping into space.",
                q3 = "When climate change affects ecosystems.",
                q4 = "The impact trees have on global temperatures.",
                correct = 1,
                explanation = "Greenhouse gases, such as carbon dioxide, methane, nitrous oxide and water vapor, trap heat energy emanating from the Earth and prevent it from going into space. This keeps the planet much warmer than it would be otherwise. But human activities, such as burning fossil fuels, are adding even more carbon dioxide to the atmosphere and causing added warming.",
            ),
            QuestionBank(
                question = "What famous goal did 195 countries affirm in Paris in 2015?",
                q1 = "Reducing global temperatures by 0.5 degrees.",
                q2 = "Bringing global temperatures back to preindustrial averages.",
                q3 = "Limiting warming to no more than 1 degree Celsius above preindustrial averages.",
                q4 = "Limiting warming to “well below” 2 degrees Celsius above preindustrial averages.",
                correct = 3,
                explanation = "While the Paris agreement did indeed identify 2 degrees Celsius (3.6 degrees Fahrenheit) as a line not to be crossed, it also suggested that countries should make an effort to keep warming even lower, to 1.5 degrees Celsius (2.7 degrees Fahrenheit) above preindustrial levels. Since then, additional evidence has suggested that this more stringent limit may be needed to avoid many severe consequences of warming. ",
            ),
            QuestionBank(
                question = "Which country announced in 2017 that it would withdraw from that Paris climate agreement?",
                q1 = "Austrailia",
                q2 = "Sweden",
                q3 = "The United Statehe ",
                q4 = "Britain",
                correct = 2,
                explanation = "On June 1, 2017, President Donald Trump spurred global criticism by declaring that the United States would back out of the landmark deal. Trump took additional steps in November 2019 toward withdrawal. However, on Jan. 20, 2021, President Biden returned the United States to the agreement shortly after his inauguration. The Post is tracking all of Biden’s steps to reverse Trump’s climate policies.",
            ),
            QuestionBank(
                question = "In a high-emissions scenario, how much does the IPCC predict the Earth will heat up by the end of the century, compared with the preindustrial era?",
                q1 = "1.2° to 1.7° C",
                q2 = "2.1° to 3.5° C",
                q3 = "3.3° to 5.7° C",
                q4 = "Scientists do not predict a measurable change",
                correct = 2,
                explanation = "A “high-emissions scenario” is one that represents a major failure to curb greenhouse gas emissions. The IPCC predicts that in such a case the average global temperature could rise by 3.3° to 5.7° degrees Celsius, an increase that could trigger catastrophic consequences, such as massive sea-level rise. But with swift reductions in emissions, worst-case scenarios like this can still be avoided. The Paris climate agreement, if fully implemented, would steer the world off this severe pathway.",
            ),
            QuestionBank(
                question = "Combined, how much mass are ice sheets in Greenland and Antarctica losing annually?",
                q1 = "189 billion tons",
                q2 = "294 million tons",
                q3 = "427 billion tons",
                q4 = "None; they are gaining ice.",
                correct = 2,
                explanation = "Antarctica is losing 152 billion tons of ice per year at present, and Greenland is losing 275 billion tons per year, according to NASA. Scientists have found that the rate of ice loss in Greenland has grown by a factor of six since the 1980s, and that in Antarctica a similar acceleration is underway.",
            ),
            QuestionBank(
                question = "Extreme heat in Siberia has caused permafrost to melt. The remains of which ancient creature are now emerging from the frozen ground?",
                q1 = "Giant sloths",
                q2 = "T. rex",
                q3 = "Neanderthals",
                q4 = "Woolly mammoths",
                correct = 3,
                explanation = "The remains of woolly mammoths, once lodged in permafrost, are starting to appear in Siberia, one of the fastest-warming places in the world.",
            ),
            QuestionBank(
                question = "What percentage of heat from global warming has the ocean absorbed in the last forty years?",
                q1 = "11%",
                q2 = "1%",
                q3 = "35%",
                q4 = "84%",
                correct = 3,
                explanation = "In the last forty years, the ocean has absorbed 84% of the heat from global warming. This means that a significant amount of the heat generated by global warming is being absorbed by the ocean, which has important implications for the Earth's climate system.",
            ),
            QuestionBank(
                question = "What is NFCCC stand for?",
                q1 = "United Nations Framework Control on Climate Change",
                q2 = "United Nations Framework Convention on Climate Change",
                q3 = "United Nations Framework Communications on Climate Change",
                q4 = "united Nations Framwork Climate Communications council",
                correct = 1,
                explanation = "NFCCC stand for United Nations Framework Convention on Climate Change",
            ),
        )
    }
}