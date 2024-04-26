package com.example.blanguernonpa;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.blanguernonpa.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMain2Binding binding;

    protected Integer result;
    private int attempt = 0;

    static int getRandomNumber(int max, int min) {
        return (int)((Math.random() * (max - min)) + min);
    }

    public void makeToast(String str) {
        Toast.makeText(MainActivity2.this, str, Toast.LENGTH_SHORT).show();
    }


    public int setAttempts(int attempts) {
        attempt = attempts;
        return (int)(attempts);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int min = 1;
        int max = 100;
        result = getRandomNumber(min, max);
        setAttempts(0);

        Button buttonSubmit = (Button) findViewById(R.id.button_submit_number);
        EditText guessedNumberId = (EditText) findViewById(R.id.editTextNumber);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String Player_1 = extras.getString("player1");
                    String Player_2 = extras.getString("player2");

                    Integer guessedNumber = Integer.parseInt(guessedNumberId.getText().toString());

                    if(guessedNumber != null){
                        if (guessedNumber < result) {
                            makeToast("C'est plus");
                            attempt++;
                        } else if (guessedNumber > result) {
                            makeToast("C'est moins");
                            attempt++;
                        } else {
                            if (attempt == 0) {
                                makeToast("Félicitations !" + "Tu as trouvé le bon chiffre du premier coup !");
                                setAttempts(0);
                            } else {
                                makeToast("Bravo !" + "Tu as trouvé le bon chiffre en " + attempt + " coups !");
                                setAttempts(0);
                            }
                        }

                        Log.i("RESULT : ", Player_1 + "," + Player_2 + "," + "number is: " + result + " guess: " + guessedNumber + " tentatives: " + attempt);
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

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}