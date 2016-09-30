package com.glemontree.buttonanimatordemo;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ButtonAnimatorActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimate();
            }
        });
    }

    private void performAnimate() {
        ViewWrapper wrapper = new ViewWrapper(button);
        ObjectAnimator.ofInt(wrapper, "width", 1000).setDuration(5000).start();
    }

    private static class ViewWrapper {
        private View mTarget;

        public ViewWrapper(View target) {
            mTarget = target;
        }

        public int getWidth() {
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width) {
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout(); // call this when something has changed;
        }
    }
}
