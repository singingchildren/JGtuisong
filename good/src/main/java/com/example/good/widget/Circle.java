package com.example.good.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.good.R;

public class Circle extends View{

    float jd = 90;
    private Context mContext;
    public Circle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int mcWidth = getSuggestedMinimumWidth();
        int mcHeight = getSuggestedMinimumHeight();
        setMeasuredDimension(mcWidth,mcHeight);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.myColor));
        canvas.drawCircle(0,0,jd,paint);
    }


}
