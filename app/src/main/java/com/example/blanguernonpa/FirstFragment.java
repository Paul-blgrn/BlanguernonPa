package com.example.blanguernonpa;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.blanguernonpa.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    public String level;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
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

        binding.buttonFirst.setOnClickListener(v -> {
            MainActivity activity = (MainActivity) getActivity();
            if(activity != null) {
                activity.player1.setName(binding.editTextText.getText().toString());
                activity.player1.setLevel(level);
                Log.i("FirstFragment", activity.player1.getPlayer());
                NavHostFragment
                        .findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}