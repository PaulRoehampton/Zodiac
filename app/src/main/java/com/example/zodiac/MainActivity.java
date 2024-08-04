package com.example.zodiac;

import static com.example.zodiac.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText etDate;
    private ImageView ivZodiacSign;
    private SimpleDateFormat format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        etDate = findViewById(id.etDate);
        ivZodiacSign = findViewById(id.ivZodiacSign);
        Button btnFindSign = findViewById(id.btnFindSign);
        format = new SimpleDateFormat("dd.MM.yyyy");

        btnFindSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String birthDateString = etDate.getText().toString();
                try {
                    Date birthDate = format.parse(birthDateString);
                    String sign = getZodiacSign(birthDate);
                    int resourceId = getResources().getIdentifier(sign.toLowerCase(), "drawable", getPackageName());
                    ivZodiacSign.setImageResource(resourceId);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                etDate.setText(""); // Clear the text from EditText after processing
            }
        });

    }

    private String getZodiacSign(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1;  // 0 indexed

        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) return "Aries";
        if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) return "Taurus";
        if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) return "Gemini";
        if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) return "Cancer";
        if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) return "Leo";
        if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) return "Virgo";
        if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) return "Libra";
        if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) return "Scorpio";
        if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) return "Sagittarius";
        if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) return "Capricorn";
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) return "Aquarius";
        if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) return "Pisces";

        return "";
    }
}
