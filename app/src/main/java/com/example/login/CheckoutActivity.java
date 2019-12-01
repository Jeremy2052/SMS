package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.stripe.android.ApiResultCallback;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.Stripe;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import java.lang.ref.WeakReference;
import java.io.IOException;

import com.stripe.android.view.CardInputWidget;

public class CheckoutActivity extends AppCompatActivity {
    private Stripe stripe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PaymentConfiguration.init(getApplicationContext(), "pk_test_Q0lnRBMXAuyXiVM3JMIuY9ZA00BYbjDouQ");

        setContentView(R.layout.activity_checkout);
        Button payButton = findViewById(R.id.payButton);

        WeakReference<CheckoutActivity> weakActivity = new WeakReference<>(this);

        CardInputWidget cardInputWidget = findViewById(R.id.cardInputWidget);
        Card card = cardInputWidget.getCard();

        if (card != null) {
            // Create a Stripe token from the card details
            stripe = new Stripe(getApplicationContext(), PaymentConfiguration.getInstance(getApplicationContext()).getPublishableKey());
            stripe.createToken(card, new ApiResultCallback<Token>() {
                @Override
                public void onSuccess(@NonNull Token result) {
                    String tokenID = result.getId();
                    // Send the token identifier to the server...
                    //set up firebase and payment stuff for service here
                }

                @Override
                public void onError(@NonNull Exception e) {
                    // Handle error
                    //leave empty for now
                }
            });
        }

    }
}
