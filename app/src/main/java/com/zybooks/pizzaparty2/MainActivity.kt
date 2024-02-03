package com.zybooks.pizzaparty2

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

// Slices of pizza in one pizza
const val SLICES_PER_PIZZA = 8

/**
 * Class that is the start of the app, calculates the number of pizzas
 * a party should order based on how many attendees and hunger level.
 */
class MainActivity : AppCompatActivity() {

    // Variables that change depending on input
    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup

    /**
     * Sets up all the variable inputs in the UI weather it is first initialization
     *  or reinitialization
     *
     * @param savedInstanceState contains the values of the app saved temporarily
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)

    }

    /**
     * When the calculate button is clicked, evaluate the inputs to create the
     * number of pizzas needed for the party
     *
     * @param view the button called calculate being clicked
     */
    fun calculateClick(view: View) {

        // Get the text that was typed into the EditText
        val numAttendStr = numAttendEditText.text.toString()

        // Convert the text into an integer
        val numAttend = numAttendStr.toInt()

        // Determine how many slices on average each person will eat
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }

        // Calculate and show the number of pizzas needed
        val totalPizzas = ceil(numAttend * slicesPerPerson / SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}