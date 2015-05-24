package com.trofimyuk.www.buttonsleftright;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class main extends ActionBarActivity {
    private TextView currentnumber;
    private Button incBut;
    private Button decBut;

    private int textNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentnumber = (TextView) findViewById(R.id.textView);
        incBut = (Button) findViewById(R.id.incBut);
        decBut = (Button) findViewById(R.id.decBut);
        ImageView tempImg = (ImageView) findViewById(R.id.imageView);
        tempImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_bug_report_black_48dp));

        View.OnClickListener myclickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.incBut:
                        changeTextArea(1);
                        break;
                    case R.id.decBut:
                        changeTextArea(-1);
                        break;
                    case R.id.textView:
                        changeTextArea(0);
                        break;
                }
            }
        };
        incBut.setOnClickListener(myclickListener);
        decBut.setOnClickListener(myclickListener);
        currentnumber.setOnClickListener(myclickListener);
        currentnumber.setText(String.valueOf(textNumber));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void changeTextArea(int num)
    {
        if (num!=0) {
            textNumber = textNumber + num;
            currentnumber.setText(String.valueOf(textNumber));
        }
        else
        {
            textNumber = 0;
            currentnumber.setText(String.valueOf(textNumber));
        }
    }

}
