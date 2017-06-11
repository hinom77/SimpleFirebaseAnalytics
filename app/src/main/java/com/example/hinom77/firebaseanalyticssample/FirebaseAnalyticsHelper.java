package com.example.hinom77.firebaseanalyticssample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.google.firebase.analytics.FirebaseAnalytics;

public class FirebaseAnalyticsHelper {

    // ① FirebaseAnalyticsインスタンスをフィールドに定義
    private FirebaseAnalytics mFirebaseAnalytics;

    // ②『Singletonパターン』でFirebase Analyticsインスタンスを設定
    private static FirebaseAnalyticsHelper sInstance;
    private FirebaseAnalyticsHelper(Context context){
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context.getApplicationContext());
    }
    public static synchronized FirebaseAnalyticsHelper getInstance(Context context){
        if(sInstance == null){
            sInstance = new FirebaseAnalyticsHelper(context);
        }
        return sInstance;
    }

    // ③ イベントログを発火するメソッドを作成
    public void logEvent(@NonNull final String name, FirebaseAnalyticsParams params) {
        Bundle bundleParams = (params == null) ? null : params.getBundleParams();
        mFirebaseAnalytics.logEvent(name, bundleParams);
    }
    public void logEvent(@NonNull final String name) {
        mFirebaseAnalytics.logEvent(name, null);
    }

}
