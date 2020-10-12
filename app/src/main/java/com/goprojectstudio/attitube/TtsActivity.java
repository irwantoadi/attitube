package com.goprojectstudio.attitube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TtsActivity extends AppCompatActivity {

    Button btn_selesai, btn_restart;
    ImageView kotak_v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);

        btn_selesai = findViewById(R.id.btn_selesai);
        btn_restart = findViewById(R.id.btn_restart);
        btn_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TtsActivity.this, PoinActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TtsActivity.this, TtsActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(0,0);
            }
        });

        findViewById(R.id.id_v).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.id_s).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.id_o).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.id_h).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.id_t).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.id_b).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.id_a).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.id_n).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.id_d).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.id_a2).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.id_r).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.id_n2).setOnTouchListener(new MyTouchListener());
//        findViewById(R.id.drop_zone).setOnDragListener(new MyDragListener());
        findViewById(R.id.kosong1).setOnDragListener(new MyDragListener());
        findViewById(R.id.kosong2).setOnDragListener(new MyDragListener());
        findViewById(R.id.kosong3).setOnDragListener(new MyDragListener());
        findViewById(R.id.kosong4).setOnDragListener(new MyDragListener());
    }

    // This defines your touch listener
    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(
                R.drawable.kotak_v);
        Drawable normalShape = getResources().getDrawable(R.drawable.kotak_kosong);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
//                    v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
    }
}
