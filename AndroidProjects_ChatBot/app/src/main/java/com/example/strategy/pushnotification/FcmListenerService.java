package com.example.botkommunicate.pushnotification;


import android.annotation.SuppressLint;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import io.kommunicate.Kommunicate;

//adaprorul din app in Kommunicat
//conectarea la Kommunicate

//Firebase e pentru a face un chat intre 2 persoane sau mai multe persoane
@SuppressLint("Registered")
public class FcmListenerService extends FirebaseMessagingService {

    private static final String TAG = "KmSampleFCMService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i(TAG, "FCM notification processing...");

        if (Kommunicate.isKmNotification(this, remoteMessage.getData())) {
            return;
        }
        super.onMessageReceived(remoteMessage);
    }

    @Override
    public void onNewToken(String registrationId) {
        super.onNewToken(registrationId);

        Log.i(TAG, "Found Registration Id:" + registrationId);

        Kommunicate.updateDeviceToken(this, registrationId);
    }
}