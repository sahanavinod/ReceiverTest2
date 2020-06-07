package com.example.receivertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ServerActivity extends AppCompatActivity {

    private static final String TAG = "ServerActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);
//        Log.i(TAG, "In ServerActivity class - onCreate");
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setDataAndType(Uri.parse("android.resource://com.example.receivertest/" + R.drawable.soham), "image/*");
//        startActivity(intent);
//
//        finish();
    }

   public void broadcastIntent(View view) {
       //Toast.makeText(view.getContext(), "Toast --> broadCastIntent() call..!", Toast.LENGTH_SHORT)
       //        .show();
       Intent intent = new Intent();
       intent.setAction("com.example.receivertest");
       intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
       sendBroadcast(intent);
   }
}
