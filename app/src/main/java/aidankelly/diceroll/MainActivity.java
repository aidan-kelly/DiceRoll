package aidankelly.diceroll;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton = (Button)findViewById(R.id.button);
        final EditText mEdit = (EditText)findViewById(R.id.editText);
        final TextView resultText =(TextView)findViewById(R.id.textView3);
        mEdit.setText("0");
        mButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Random rand = new Random();

                //initalizes the dice modifier.
                long mod;

                //checks if the field is empty. If it is the mod is 0.
                if(mEdit.getText().toString().matches("")){
                    mod = 0;
                    long randomNum = rand.nextInt(20)+1;
                    long roll = randomNum + mod;

                    if(randomNum==20){
                        resultText.setText(""+roll+"! \nNAT 20!");
                    }else if(randomNum==1){
                        resultText.setText(""+roll+" \nNat 1 :(");
                    }else{
                        resultText.setText(""+roll);
                    }

                //if field is not empty we use what is inside.
                }else{
                    mod = Integer.valueOf(mEdit.getText().toString());

                    long randomNum = rand.nextInt(20)+1;
                    long roll = randomNum + mod;

                    if(randomNum==20){
                        resultText.setText(""+roll+"! \nNAT 20!");
                    }else if(randomNum==1){
                        resultText.setText(""+roll+" \nNat 1 :(");
                    }else{
                        resultText.setText(""+roll);
                    }
                }
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

}
