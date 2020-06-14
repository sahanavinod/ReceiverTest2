package com.example.receivertest;

import androidx.fragment.app.FragmentActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Calendar;

public class tvImageActivity extends FragmentActivity {
//    String [] img_arr = {"img1", "img2"};
    private ImageView iView;
    private int[] imageArray;
    private int currentIndex;
    private int prevIndex;
    private int startIndex;
    private long startTime;
    private int endIndex;
    private Calendar c;
    private boolean isFirst = true;
    private boolean exit = false;
    private static final String TAG = "TVImageActivity";
    private final long MILLIS_TO_SECS = 1000;

    private Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        iView = (ImageView) findViewById(R.id.show_img);
        imageArray = new int[3];
        imageArray[0] = R.drawable.waterfall;
        imageArray[1] = R.drawable.dates;
        imageArray[2] = R.drawable.glassart;
        startIndex = 0;
        endIndex = 2;
        prevIndex = -1;
        Log.i(TAG, "onCreate: calling nextImage()");
        c = Calendar.getInstance();
        Log.i(TAG, "Current time => "+ c.getTime());
        nextImage();

        Log.i(TAG, "onCreate: Exiting..");
        //setContentView(R.layout.activity_tv);
        //sleep 5 seconds
        //setContein
    }

    public void nextImage(){
        if(exit) return;
        if(!isFirst) {
            Log.i(TAG, "nextImage(): index=" + prevIndex + " screenTime=" + (System.currentTimeMillis() - startTime)/MILLIS_TO_SECS + "s");
        }
        else {
            isFirst = false;
        }
        prevIndex = currentIndex;
        startTime = System.currentTimeMillis();
        iView.setImageResource(imageArray[currentIndex]);
        currentIndex++;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(currentIndex>endIndex){
                    currentIndex = startIndex;
                }
                nextImage();
            }
        },5000); // here 1000(1 second) interval to change from current  to next image

    }

    @Override
    protected void onUserLeaveHint(){
        super.onUserLeaveHint();
        Log.i(TAG, "onUserLeaveHint() called");
        finish();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        exit = true;
        Log.i(TAG, "onDestroy() called");
        Log.i(TAG, "nextImage(): index=" + prevIndex + " screenTime=" + (System.currentTimeMillis() - startTime)/MILLIS_TO_SECS + "s");
    }
}
