package com.example.blanguernonpa;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.blanguernonpa.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    public String level;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(binding.radioButton.isChecked()) level = "Easy";
                if(binding.radioButton2.isChecked()) level = "Medium";
                if(binding.radioButton3.isChecked()) level = "Hard";
            }
        });

        binding.buttonPlay.setOnClickListener(v -> {
            MainActivity activity = (MainActivity)  getActivity();
            if (activity != null) {
                activity.player2.setName(binding.editTextText.getText().toString());
                activity.player2.setLevel(level);
            }
            Intent intent = new Intent(view.getContext(), MainActivity2.class);
            intent.putExtra("msg", activity.player1.getPlayer() + "," + activity.player2.getPlayer());
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}