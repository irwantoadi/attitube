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

public class KoleksiFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_koleksi,null);

        View view = getLayoutInflater().inflate(R.layout.fragment_koleksi,
                container, false);

        CardView cardView0;
        cardView0 = view.findViewById(R.id.card_view0);
        cardView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                startActivity(intent);
            }
        });

        // after you've done all your manipulation, return your layout to be shown
        return view;
    }

}
