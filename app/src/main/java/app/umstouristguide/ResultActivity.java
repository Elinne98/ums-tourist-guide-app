package app.umstouristguide;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView tv, tv2, tv3,tv4;
    Button btnRestart;
    String tvStr;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView) findViewById(R.id.tvres);
        tv2 = (TextView) findViewById(R.id.tvres2);
        tv3 = (TextView) findViewById(R.id.tvres3);
        tv4 = (TextView) findViewById(R.id.tvres4);

        btnRestart = (Button) findViewById(R.id.btnRestart);
        sp = getSharedPreferences("MyPoint", Context.MODE_PRIVATE);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + QueActivity.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + QueActivity.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + QueActivity.correct + "\n");
        StringBuffer sb4 = new StringBuffer();
        //tv4.setText("Total Score: " +sb4);
        int point = QueActivity.correct;

        int point2 = QueActivity.correct * 100;


        QueActivity.correct = QueActivity.correct * 100;
        //point2 = getIntent().getIntExtra("QueActivity.correct",0);
      //  SharedPreferences sp = getSharedPreferences("ResultActivity", Context.MODE_PRIVATE);
        //int totalScore = settings.getInt("totalScore",0);
        // totalScore += score;
        // tv4.setText("Total Score: " +sb4);

        //QueActivity.correct =point2;

        sb4.append("Point Earn: " + point2 + "\n");

        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);
        tv4.setText(sb4);


        // string totalScore = point2;
        //sb4 = settings.getString("Total Score: ", 0);

        QueActivity.correct = 0;
        QueActivity.wrong = 0;
        //update total score
        // SharedPreferences.Editor editor = settings.edit();
        // editor.putInt("TotalScore",+totalScore);
        //editor.commit();

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvStr = tv4.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("tv4",tvStr);
                editor.commit();
                Toast.makeText(ResultActivity.this, "Information Saved", Toast.LENGTH_LONG).show();
                Intent in = new Intent(getApplicationContext(),ActivityMain.class);
                startActivity(in);
            }
        });
    }

}
