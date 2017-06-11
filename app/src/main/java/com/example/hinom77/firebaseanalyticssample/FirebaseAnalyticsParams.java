package com.example.hinom77.firebaseanalyticssample;

import android.os.Bundle;

public class FirebaseAnalyticsParams {

    // ① 『Builderパターン』でパラメータ設定を定義
    private Bundle mParams;
    private FirebaseAnalyticsParams(Builder builder) {
        mParams = builder.params;
    }
    public static class Builder {
        private Bundle params = new Bundle();

        public Builder param1(String param1) {
            params.putString("param1", param1);
            return this;
        }

        public Builder param2(Integer param2) {
            params.putInt("param2", param2);
            return this;
        }

        public Builder param3(Double param3) {
            params.putDouble("param3", param3);
            return this;
        }

        public FirebaseAnalyticsParams build() {
            return new FirebaseAnalyticsParams(this);
        }
    }

    // ② Paramsの値をBundle型で返す
    public Bundle getBundleParams() {
        return mParams;
    }
}
