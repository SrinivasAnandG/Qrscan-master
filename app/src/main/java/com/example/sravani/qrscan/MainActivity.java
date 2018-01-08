package com.example.sravani.qrscan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
   import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    public static int z=0;
    TextView tbody,thead;
    private ZXingScannerView mScannerView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbody=(TextView)findViewById(R.id.tv);
        thead=(TextView) findViewById(R.id.tvh);
    }

    public void onClick(View v){
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }
/*    @Override
    protected void onResume()
    {
        super.onResume();
        if(z==1)
        startActivity(new Intent(MainActivity.this, MainActivity.class));
        z=0;
    }*/



    @Override
    public void handleResult(Result result) {
        if (result.getText().equals("Start")&&z==0) {
            mScannerView.stopCamera();
            setContentView(R.layout.activity_c1);
            z=1;
        }
        else if(result.getText().equals("cp1")&&z==1) {
            mScannerView.stopCamera();
            setContentView(R.layout.activity_c2);
            z=2;
        }
        else if(result.getText().equals("cp2")&&z==2) {
            mScannerView.stopCamera();
            setContentView(R.layout.activity_c3);
            z=3;
        }
        else if(result.getText().equals("cp3")&&z==3) {
            mScannerView.stopCamera();
            setContentView(R.layout.activity_c4);
            z=4;
        }
        else if(result.getText().equals("cp4")&&z==4) {
            mScannerView.stopCamera();
            setContentView(R.layout.activity_c5);
            z=5;
        }
        else if(result.getText().equals("cp5")&&z==5) {
            mScannerView.stopCamera();
            setContentView(R.layout.activity_c6);
            z=6;
        }

        else {

            Context context = getApplicationContext();
            CharSequence text = "Wrong Clue!! Try Again...";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            if(z==0)
                setContentView(R.layout.activity_main);
            else if(z==1)
                setContentView(R.layout.activity_c1);
            else if(z==2)
                setContentView(R.layout.activity_c2);
            else if(z==3)
                setContentView(R.layout.activity_c3);
            else if(z==4)
                setContentView(R.layout.activity_c4);
            else if(z==5)
                setContentView(R.layout.activity_c5);
            else if(z==6)
                setContentView(R.layout.activity_c6);
            mScannerView.resumeCameraPreview(this);

        }
    }
}
