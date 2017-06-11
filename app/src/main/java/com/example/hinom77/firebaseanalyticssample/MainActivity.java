package com.example.hinom77.firebaseanalyticssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // ① FirebaseAnalyticsインスタンスをクラス内全体で利用出来るようフィールドに定義
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ② onCreateのタイミングでFirebaseAnalyticsインスタンスをセット
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        TextView helloWorld = (TextView) findViewById(R.id.hello_world);
        helloWorld.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.hello_world) {
            // ③ 「Hello World!」のテキストがクリックされるとイベントログを発火
            Bundle params = new Bundle();
            params.putString("param1", "test");
            params.putInt("param2", 100);
            params.putDouble("param3", 3.14);
            mFirebaseAnalytics.logEvent("event1", params);
        }
    }
}
