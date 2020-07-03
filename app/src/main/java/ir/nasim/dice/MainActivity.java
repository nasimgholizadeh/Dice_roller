package ir.nasim.dice;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random=new Random();
    int randomNumber;
    private ImageView diceImageView;
    private TextView textView;
    private Button btnTwoDice;
    MediaPlayer mediaPlayer;
    private long backPress;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface typeface=Typeface.createFromAsset(getAssets(),"font/Magico.ttf");

        initViews();

        textView.setTypeface(typeface); //set font
        diceImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.FadeOut).duration(800).playOn(diceImageView);
                mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.roll); //create a mediaPlayer object
                mediaPlayer.start(); //playing sound when dice clicked

                randomNumber=random.nextInt(6)+1; //generate a random num
                int a=randomNumber;
                switch (a) {
                    case 1: {
                        diceImageView.setImageResource(R.drawable.dice1);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImageView);
                        break;
                    }
                    case 2: {
                        diceImageView.setImageResource(R.drawable.dice2);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImageView);
                        break;
                    }
                    case 3: {
                        diceImageView.setImageResource(R.drawable.dice3);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImageView);
                        break;
                    }
                    case 4: {
                        diceImageView.setImageResource(R.drawable.dice4);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImageView);
                        break;
                    }
                    case 5: {
                        diceImageView.setImageResource(R.drawable.dice5);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImageView);
                        break;
                    }
                    case 6: {
                        diceImageView.setImageResource(R.drawable.dice_6);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImageView);
                        break;
                    }
                    default:
                }
            }
        });

        //intent to TwoDice activity
        btnTwoDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,TwoDice.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //function for initialize views
    public void initViews() {
        textView=findViewById(R.id.textView);
        btnTwoDice=findViewById(R.id.btnTwoDice);
        diceImageView=findViewById(R.id.diceImageView);
    }

    //press back again to exit function
    @Override
    public void onBackPressed() {
        if (backPress+2000>System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            backToast=Toast.makeText(getBaseContext(),"Press back again to exit.",Toast.LENGTH_LONG);
            backToast.show();
        }
        backPress=System.currentTimeMillis();
    }
}