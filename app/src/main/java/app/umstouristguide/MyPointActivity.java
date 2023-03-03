package app.umstouristguide;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MyPointActivity extends AppCompatActivity {

    public ActionBar actionBar;
    private Button redeem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_point);
        //actionBar.setTitle(R.string.title_nav_shop);

       redeem = findViewById(R.id.redeem);
       redeem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(MyPointActivity.this, "Please redeem your reward at EVIC UMS!", Toast.LENGTH_LONG).show();

           }



    });
}
}