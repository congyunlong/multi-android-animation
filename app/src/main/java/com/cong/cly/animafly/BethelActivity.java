package com.cong.cly.animafly;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.cong.cly.animafly.anim.ArcTranslateAnimation;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cong on 16/3/6.
 */
public class BethelActivity extends AppCompatActivity {
    @Bind(R.id.start_view)
    View startView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bethel);
        ButterKnife.bind(this);
        startView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleAnimation(v);
            }
        });
    }

    void bethelAnimation(final View view) {
        //开始点
        int xy[] = new int[2];
        //获得在窗体的坐标，窗体不包含标题
        view.getLocationInWindow(xy);
        ViewGroup parent = (ViewGroup) view.getParent();
        //结束点
        int pxy[] = new int[2];
        parent.getLocationInWindow(pxy);
        //终点的位置坐标
        int ew = pxy[0] + parent.getWidth();
        //加上标题的纵坐标
        int eh = pxy[1] + parent.getHeight();
        //开始横坐标，结束横坐标，开始纵坐标，结束纵坐标
        ArcTranslateAnimation animation = new ArcTranslateAnimation(0, ew - xy[0] - view.getWidth(), 0, eh - xy[1] - view.getHeight());
        animation.setControl(new PointF(0, -300));
        animation.setDuration(400);
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
    }

    void scaleAnimation(final View view){
        Animation scale = new ScaleAnimation(0.6f, 1.2f, 0.6f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        scale.setDuration(200);
        scale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bethelAnimation(view);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(scale);
    }
}
