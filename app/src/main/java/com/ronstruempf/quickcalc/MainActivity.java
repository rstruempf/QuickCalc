package com.ronstruempf.quickcalc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String APP_TAG = "QuickCalc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //
        // Create a button click listener and programmatically bind this to three new test buttons
        //
        View.OnClickListener myonClickListener=
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: Programmatically bind button to click handler
                        if (v instanceof Button) {
                            Log.d(APP_TAG, "Button click on " + ((Button) v).getText());
                        }
                    }
                };
        Button testButton1 = (Button) findViewById(R.id.testButton1);
        testButton1.setOnClickListener(myonClickListener);
        Button testButton2 = (Button) findViewById(R.id.testButton2);
        testButton2.setOnClickListener(myonClickListener);
        ImageButton testButton3 = (ImageButton) findViewById(R.id.testButton3);
        testButton3.setOnClickListener(myonClickListener);

        //
        // Set an editor action listener on a second text field to detect Send button pressed and copy
        //  text from new field to display field
        //
        EditText email = (EditText) findViewById(
                R.id.editText);
        email.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v,
                                                  int actionId,
                                                  KeyEvent event) {
                        EditText email=(EditText) v;
                        TextView tv=(TextView) findViewById(
                                R.id.display);
                        if(actionId== EditorInfo.IME_ACTION_SEND){
                            tv.setText(email.getText());
                            return true;
                        }
                        return false;
                    }
                });
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

    private int total = 0;

    public void onButtonClick(View v) {
        Button button = (Button) v;
        String bText = button.getText().toString();
        int value = Integer.parseInt(bText);
        total += value;
        TextView myTextView = (TextView)findViewById(R.id.display);
        myTextView.setText(Integer.toString(total));
    }
}
