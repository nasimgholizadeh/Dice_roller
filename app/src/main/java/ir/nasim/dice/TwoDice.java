package ir.nasim.dice;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class TwoDice extends AppCompatActivity {

    Random random=new Random();
    int randomNumber1,randomNumber2;
    private ImageView diceImageView2,diceImg1,diceImg2;
    private TextView textView2;
    private Button btnOneDice;
    private RelativeLayout relativeLayout;
    MediaPlayer mediaPlayer;
    private long backPress;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_dice);

        Typeface typeface=Typeface.createFromAsset(getAssets(),"font/Magico.ttf");

        initViews();

        textView2.setTypeface(typeface); //set font
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.FadeOut).duration(800).playOn(diceImageView2);
                diceImageView2.setVisibility(View.GONE);
                mediaPlayer=MediaPlayer.create(TwoDice.this,R.raw.roll); //create a mediaPlayer object
                mediaPlayer.start(); //playing sound when dice clicked

                randomNumber1=random.nextInt(6)+1; //generate a random num for dice1
                randomNumber2=random.nextInt(6)+1; //generate a random num for dice2
                int a=randomNumber1;
                int b=randomNumber2;
                //dice1
                switch (a) {
                    case 1: {
                        diceImg1.setImageResource(R.drawable.dice1);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImg1);
                        break;
                    }
                    case 2: {
                        diceImg1.setImageResource(R.drawable.dice2);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImg1);
                        break;
                    }
                    case 3: {
                        diceImg1.setImageResource(R.drawable.dice3);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImg1);
                        break;
                    }
                    case 4: {
                        diceImg1.setImageResource(R.drawable.dice4);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImg1);
                        break;
                    }
                    case 5: {
                        diceImg1.setImageResource(R.drawable.dice5);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImg1);
                        break;
                    }
                    case 6: {
                        diceImg1.setImageResource(R.drawable.dice_6);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImg1);
                        break;
                    }
                    default:
                }
                //dice2
                switch (b) {
                    case 1: {
                        diceImg2.setImageResource(R.drawable.dice1);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImg2);
                        break;
                    }
                    case 2: {
                        diceImg2.setImageResource(R.drawable.dice2);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImg2);
                        break;
                    }
                    case 3: {
                        diceImg2.setImageResource(R.drawable.dice3);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImg2);
                        break;
                    }
                    case 4: {
                        diceImg2.setImageResource(R.drawable.dice4);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImg2);
                        break;
                    }
                    case 5: {
                        diceImg2.setImageResource(R.drawable.dice5);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImg2);
                        break;
                    }
                    case 6: {
                        diceImg2.setImageResource(R.drawable.dice_6);
                        YoYo.with(Techniques.FadeIn).duration(800).playOn(diceImg2);
                        break;
                    }
                    default:
                }
            }
        });
        //intent to MainActivity
        btnOneDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TwoDice.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //function for initialize views
    public void initViews() {
        textView2=findViewById(R.id.textView2);
        btnOneDice=findViewById(R.id.btnOneDice);
        diceImageView2=findViewById(R.id.diceImageView2);
        diceImg1=findViewById(R.id.diceImg1);
        diceImg2=findViewById(R.id.diceImg2);
        relativeLayout=findViewById(R.id.relativeLayout);
    }
    //back to MainActivity
    @Override
    public void onBackPressed() {
            Intent intent=new Intent(TwoDice.this,MainActivity.class);
            startActivity(intent);
            super.onBackPressed();
    }
}