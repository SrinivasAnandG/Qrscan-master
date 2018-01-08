package com.example.sravani.qrscan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class c1 extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    public static int z1=0;
    private ZXingScannerView mScannerView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1);
    }

    public void onClick(View v){
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }
   /* @Override
    protected void onResume()
    {
        super.onResume();
        if(z1==1)
            startActivity(new Intent(c1.this, c1.class));
        z1=0;
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
        z1=1;
    }

    @Override
    public void handleResult(Result result) {
        if (result.getText().equals("Start"))
        setContentView(R.layout.activity_c2);
        else {

            Context context = getApplicationContext();
            CharSequence text = "Wrong Clue!! Try Again...";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            startActivity(new Intent(c1.this, c1.class));
            mScannerView.resumeCameraPreview(this);

        }
    }
}
