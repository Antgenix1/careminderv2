package com.example.careminder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.careminder.R;
import com.example.careminder.dal.PatientDao;
import com.example.careminder.model.Patient;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class PatientActivity extends AppCompatActivity {

    private PatientDao patientDao;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        patientDao = new PatientDao(this);

        getPatients();

        LinearLayout linearLayout = findViewById(R.id.patient_detail);
        int numViews = 7;
        String[] textArray = {
                "Name",
                "Doctor",
                "Nurse",
                "1st Visit",
                "Examinations",
                "Examinations",
                "Hospitalization"
        };

        String[] secondRowTextArray = {
                "Second row text 1",
                "Second row text 2",
                "Second row text 3",
                "Second row text 4",
                "Second row text 5",
                "Second row text 6",
                "Second row text 7"
        };

        for (int i = 0; i < numViews; i++) {
            LinearLayout rowLayout = new LinearLayout(this);
            rowLayout.setOrientation(LinearLayout.VERTICAL);

            // First Row (original text)
            TextView textView1 = new TextView(this);
            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(
                    dpToPx(155), dpToPx(46)
            );

            layoutParams1.setMargins(dpToPx(10), dpToPx(5), dpToPx(10), dpToPx(5));
            textView1.setLayoutParams(layoutParams1);

            if (i == 0 || i == numViews - 1) {
                textView1.setBackgroundResource(R.drawable.rounded_box_dark);
            } else {
                textView1.setBackgroundResource(R.drawable.rounded_box_light);
            }

            String text1 = textArray[i];
            textView1.setText(text1);
            textView1.setGravity(Gravity.CENTER);
            textView1.setSingleLine(false);
            textView1.setTextSize(20);

            TextView textView2 = new TextView(this);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, dpToPx(46)
            );

            layoutParams2.setMargins(dpToPx(10), dpToPx(5), dpToPx(10), dpToPx(5));
            textView2.setLayoutParams(layoutParams2);

            textView2.setBackgroundResource(R.drawable.rounded_box_response);

            String text2 = secondRowTextArray[i];
            textView2.setText(text2);
            textView2.setGravity(Gravity.CENTER);
            textView2.setSingleLine(false);
            textView2.setTextSize(20);

            rowLayout.addView(textView1);
            rowLayout.addView(textView2);

            linearLayout.addView(rowLayout);
        }
    }

    public int dpToPx(int dp) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    private void getPatients() {
        patientDao.getPatientById(new PatientDao.PatientCallBack(){
            @Override
            public void onSuccess(Patient patient){
                Log.d("Patient", patient.toString());
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }
        });
    };
}
