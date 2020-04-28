package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonDatePicker.setOnClickListener{view -> clickDatePicker(view)}
    }

    fun clickDatePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

       val dpd =  DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view,selectedYear,selectedMonth,selectedDayOfMonth -> Toast.makeText(this,"The chosen year is $selectedYear , month is ${selectedMonth+1} and day is $selectedDayOfMonth"  , Toast .LENGTH_LONG).show()
            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

            tvSelectedDate.setText(selectedDate)
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)

            val selectedDateInMinutes = theDate!!.time / 60000

            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentDateInMinute = currentDate!!.time / 60000

           val selectedDateInDays = selectedDateInMinutes/1440

           val currentDateInDays = currentDateInMinute/1440

            val differenceInDays = currentDateInDays - selectedDateInDays

            tvSelectedDateInMinutes.setText(differenceInDays.toString())

            
        }
            ,
            year,
            month,
            day)

        dpd.datePicker.setMaxDate(Date().time - 84600000)
        dpd.show()

    }
}
