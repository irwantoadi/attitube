package com.goprojectstudio.attitube;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class KonsultanFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_konsultan,null);
        View view = getLayoutInflater().inflate(R.layout.fragment_konsultan,
                container, false);

        // note that we're looking for a button with id="@+id/myButton" in your inflated layout
        // Naturally, this can be any View; it doesn't have to be a button
//        Button mButton = (Button) view.findViewById(R.id.btn_level_kuis);
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // here you set what you want to do when user clicks your button,
//                // e.g. launch a new activity
////                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getActivity(), TtsActivity.class);
//                startActivity(intent);
//            }
//        });


        CardView cardView1, cardView2, cardView3;
        cardView1 = view.findViewById(R.id.card_view1);
        cardView2 = view.findViewById(R.id.card_view2);
        cardView3 = view.findViewById(R.id.card_view3);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RaportActivity.class);
                startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReminderActivity.class);
                startActivity(intent);
            }
        });

        // after you've done all your manipulation, return your layout to be shown
        return view;
    }
}
