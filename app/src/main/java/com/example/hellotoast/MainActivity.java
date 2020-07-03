package com.example.hellotoast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button mReset, bCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        mReset = (Button) findViewById(R.id.button_zero);
        bCount = (Button) findViewById(R.id.button_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void countUp(View view) {
        ++mCount;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            mReset.setBackgroundColor(getColor(R.color.colorOrangeLight));
        }
        if (mCount % 2 != 0) {
            bCount.setBackgroundColor(getColor(R.color.colorPrimaryDark));
        }
        else
            bCount.setBackgroundColor(getColor(R.color.colorPrimary));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void makeZero(View view) {
        mCount = 0;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
        if (mCount == 0)
            mReset.setBackgroundColor(getColor(R.color.colorGray));

    }
}