package com.example.hinom77.firebaseanalyticssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView helloWorld = (TextView) findViewById(R.id.hello_world);
        helloWorld.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.hello_world) {
            //「Hello World!」のテキストがクリックされるとイベントログを発火
            FirebaseAnalyticsParams params = new FirebaseAnalyticsParams
                    .Builder().param1("test").param2(100).param3(3.14).build();
            FirebaseAnalyticsHelper.getInstance(this).logEvent("event1", params);
        }
    }
}
