package app.umstouristguide;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import androidx.appcompat.app.AppCompatActivity;

public class RewardActivity extends AppCompatActivity {
    Button reward;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);

        TextView t1;
        t1 = findViewById(R.id.tvPerc);


       // SharedPreferences sp = getApplicationContext().getSharedPreferences(
        SharedPreferences sp = getSharedPreferences("MyPoint", Context.MODE_PRIVATE);
        String tvStr = sp.getString("tvStr", "0");
       t1.setText(tvStr);
        Button reward;
        reward = findViewById(R.id.reward);

        reward.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                startActivity(new Intent(RewardActivity.this, MyPointActivity.class));
            }
        });
    }

}