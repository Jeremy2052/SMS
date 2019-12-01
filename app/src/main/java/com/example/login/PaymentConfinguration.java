package com.example.login;

import android.app.Application;
import com.stripe.android.PaymentConfiguration;

public class PaymentConfinguration extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PaymentConfiguration.init(getApplicationContext(), "pk_test_Q0lnRBMXAuyXiVM3JMIuY9ZA00BYbjDouQ\n");
    }
}