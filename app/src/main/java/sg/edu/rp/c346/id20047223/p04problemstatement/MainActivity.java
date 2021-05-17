package sg.edu.rp.c346.id20047223.p04problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    EditText txtNumber;
    EditText txtPax;
    DatePicker dp;
    TimePicker tp;
    CheckBox ensmokingarea;
    Button btnSubmit;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.editTextTextPersonName);
        txtNumber = findViewById(R.id.editTextTextNumber);
        txtPax = findViewById(R.id.editTextSize);
        dp = findViewById(R.id.datepicker);
        tp = findViewById(R.id.timepicker);
        ensmokingarea = findViewById(R.id.smokingarea);
        btnSubmit = findViewById(R.id.btnsubmit);
        btnReset = findViewById(R.id.btnreset);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "";
                String smoke = "";
                if(ensmokingarea.isChecked() == true){
                    smoke = "smoking";
                } else {
                    smoke = "non-smoking";
                }

                if (tp.getCurrentMinute() > 11) {
                    msg = "Hi, " + txtName.getText() + " you have booked a " + txtPax.getText() + " person(s) " + smoke + " table on " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear() + " at " + tp.getCurrentHour() + ":" + tp.getCurrentMinute() + ". Your phone number is " + txtNumber.getText();

                } else {
                    msg = "Hi, " + txtName.getText() + " you have booked a " + txtPax.getText() + " person(s) " + smoke + " table on " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear() + " at " + tp.getCurrentHour() + ":0" + tp.getCurrentMinute() + ". Your phone number is " + txtNumber.getText();
                }

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtName.setText("");
                txtNumber.setText("");
                txtPax.setText("");
                ensmokingarea.setChecked(false);
                dp.updateDate(2021,5,1);
                tp.setCurrentHour(20);
                tp.setCurrentMinute(30);
            }
        });
    }
}