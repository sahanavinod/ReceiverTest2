package com.example.receivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


import static android.content.Intent.ACTION_BOOT_COMPLETED;
import static android.content.Intent.ACTION_POWER_CONNECTED;
import static android.content.Intent.ACTION_POWER_DISCONNECTED;
import static android.content.Intent.ACTION_SHUTDOWN;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //Toast.makeText(context, "Toast --> onReceive() call..!", Toast.LENGTH_SHORT)
        //        .show();
        /*
        String action = intent.getAction();
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        if (action.equals(ACTION_BOOT_COMPLETED))
            toast.setText("Whao.. Caught the BOOT COMPLETED event");
        else if (action.equals(ACTION_POWER_CONNECTED))
            toast.setText("Whao.. Caught the POWER CONNECTED event");
        else if (action.equals(ACTION_POWER_DISCONNECTED))
            toast.setText("Whao.. Caught the POWER DISCONNECTED event");
        else if (action.equals(ACTION_SHUTDOWN))
            toast.setText("Whao.. Caught the SHUTDOWN event");
        else
            toast.setText("Caught an UNEXPECTED event");
        toast.show();
        */
        Log.i("MyReceiver", "In the onReceive method");
        Intent i = new Intent(context, tvImageActivity.class);
//        Intent i = new Intent();
//        i.setClassName(context, "com.example.receivertest.ServerActivity");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (i.resolveActivity(context.getPackageManager())
                != null) {
            context.startActivity(i);
        }
        else {
            Toast.makeText(context, "Hmmm.. Intent not right!!", Toast.LENGTH_SHORT);
        }
        //throw new UnsupportedOperationException("Not yet implemented");
        /*
                <action android:name="android.intent.action.BOOT_COMPLETED" />
                <action android:name="android.intent.action.ACTION_POWER_CONNECTED" />
                <action android:name="android.intent.action.ACTION_POWER_DISCONNECTED" />
                <action android:name="android.intent.action.ACTION_SHUTDOWN" />

         */
    }
}
