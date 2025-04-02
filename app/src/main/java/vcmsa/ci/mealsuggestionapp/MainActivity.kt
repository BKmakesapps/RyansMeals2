package vcmsa.ci.mealsuggestionapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.ci.mealsuggestionapp.R.id.edtInputTime

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val btnReset = findViewById<Button>(R.id.btnReset)
        val Results = findViewById<TextView>(R.id.txtResults)
        val Time = findViewById<EditText>(R.id.edtInputTime)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val txtOutput = findViewById<TextView>(R.id.txtOutput)

        txtOutput.text = "Enter the time of day (Breakfast, Lunch, Dinner)" //this outputs the meal options

        btnSearch.setOnClickListener {
            val inputTime = Time.text.toString().trim().lowercase()

            if (inputTime == "breakfast") {
                Results.text = "Suggested meals: Pancakes, Oats, Muesli, Toasted Bread, Cornflakes, Scrambled Eggs, French Toast, Avocado Toast, Waffles"
            } else if (inputTime == "lunch") {
                Results.text = "Suggested meals: Grilled Chicken Sandwich, Tacos, Burgers and Fries, Chicken Quesadilla, Caesar Salad, Wraps, Sushi Rolls, Ramen"
            } else if (inputTime == "dinner") {
                Results.text = "Suggested meals: Lasagna, Chicken Alfredo, Steak and Mashed Potatoes, Creamy Pasta, Mac and Cheese, BBQ Wings and Chips, BBQ Ribs and Chips, Spaghetti and Mince, Roast Chicken, Shrimp Scampi"
            } else {
                Results.text = "Invalid time of day. Please enter Breakfast, Lunch, or Dinner."
            }
        }

        btnReset.setOnClickListener{
            Results.text = ""       //this clears the text in results
            Time.text.clear()       //this clears the time input
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}