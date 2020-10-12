package com.goprojectstudio.attitube;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class KuisFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_kuis,null);

        View view = getLayoutInflater().inflate(R.layout.fragment_kuis,
                container, false);

        // note that we're looking for a button with id="@+id/myButton" in your inflated layout
        // Naturally, this can be any View; it doesn't have to be a button
        Button mButton = (Button) view.findViewById(R.id.btn_level_kuis);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                // e.g. launch a new activity
//                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), TtsActivity.class);
                startActivity(intent);
            }
        });

        // after you've done all your manipulation, return your layout to be shown
        return view;
    }

    @Override
    public void onClick(View v) {
//        Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
//        if (v.getId() == R.id.btn_level_kuis){
            Intent intent = new Intent(getActivity(), TtsActivity.class);
            startActivity(intent);
//        }
    }
}
