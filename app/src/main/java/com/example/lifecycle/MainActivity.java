package com.example.lifecycle;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lifecycle.databinding.ElementsBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ElementsBinding binding = ElementsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.RB3.setChecked(true);
        MediaPlayer shailushaimp3 = MediaPlayer.create(this, R.raw.shailushai);

        binding.But1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shailushaimp3.isPlaying()){
                    shailushaimp3.pause();
                    shailushaimp3.seekTo(0);
                }
                shailushaimp3.start();
            }
        });

        binding.Et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("MAINACTIVITY" + "BEFORE", s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("MAINACTIVITY" + "ON", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("MAINACTIVITY" + "AFTER", s.toString());
            }
        });

        binding.But2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear_all(binding);
            }
        });

        binding.RG.setOnCheckedChangeListener((group, checkedId) -> {
            int radioButID = binding.RG.getCheckedRadioButtonId();
            if (radioButID == binding.RB1.getId()){
                binding.mainLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.red));
            }
            if (radioButID == binding.RB2.getId()){
                binding.mainLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.green));
            }
            if (radioButID == binding.RB3.getId()){
                binding.mainLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.blue));
            }
        });
    }
    protected void clear_all(ElementsBinding binding){
        binding.Et.setText("");
        binding.RB1.setChecked(false);
        binding.RB2.setChecked(false);
        binding.RB3.setChecked(true);
        binding.CB1.setChecked(false);
        binding.CB2.setChecked(false);
        binding.CB3.setChecked(false);
        binding.CB4.setChecked(false);
        binding.CB5.setChecked(false);
        binding.CB6.setChecked(false);
        binding.CB7.setChecked(false);
        binding.CB8.setChecked(false);
        binding.CB9.setChecked(false);
        binding.CB10.setChecked(false);
        binding.CB11.setChecked(false);
        binding.CB12.setChecked(false);
        binding.mainLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.blue));
        Toast.makeText(this, "ОЧИЩЕНО", Toast.LENGTH_SHORT).show();
    }
    public void next_page(View v){
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }
}