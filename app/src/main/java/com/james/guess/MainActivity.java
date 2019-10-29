package com.james.guess;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
EditText guess;
TextView result;
int answer;
Random random = new Random();
int secret = random.nextInt(10) + 1;
int secret2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        guess = findViewById(R.id.guess);
        result = findViewById(R.id.result);
        Log.d("hi","sec1"+secret);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
public void enter(View view){
    answer = Integer.parseInt(guess.getText().toString());
    if(answer > secret){
result.setText("smaller");
        new AlertDialog.Builder(MainActivity.this)
        .setTitle("OLAOLA")
        .setMessage("smaller")
        .setPositiveButton("OK",null)
        .show();
    }else if(answer < secret){
        result.setText("bigger");
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("MUDAMUDA")
                .setMessage("bigger")
                .setPositiveButton("OK",null)
                .show();
    }else{
        result.setText("bingo");
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("WRYYYYYYYY")
                .setMessage("bingo")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        secret2 = random.nextInt(10) + 1;
                        secret = secret2;
                        Log.d("hi","sec2"+ secret2);

                    }
                })
                .show();
    }

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
}
