package com.example.yangweihan1221;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;

public class FlowView extends LinearLayout {
    //设置最高的子布局
    private int mChilderMaxHeight;
    //设置上下左右间距
    private int vSplce = 20;//上下
    private int hSplce = 20;//左右
    public FlowView(Context context) {
        super(context);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //找到最高的子布局
        findMaxHeightChildern();
        //设置初始值
        int top = 0 , left = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);

            if (left != 0 ){
                if (left + view.getMeasuredWidth() > sizeWidth){
                    top += mChilderMaxHeight + vSplce;
                    left = 0;
                }
            }
         left += view.getMeasuredWidth()+hSplce;
        }
        setMeasuredDimension(sizeWidth,(top+mChilderMaxHeight) > sizeHeight ? sizeHeight : top + mChilderMaxHeight);
    }

    private void findMaxHeightChildern() {
        mChilderMaxHeight = 0;
        //得到所有的子布局
        int childCount = getChildCount();
        for (int i = 0; i <childCount ; i++) {
            View view = getChildAt(i);
            if (view.getMeasuredHeight() > mChilderMaxHeight){
                mChilderMaxHeight = view.getMeasuredHeight();
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //找到最高的子布局
        findMaxHeightChildern();

        int left = 0 , top = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (left != 0 ){
                if (left + view.getMeasuredWidth() > getWidth()){
                    top += mChilderMaxHeight + vSplce;
                    left = 0;
                }
            }
            view.layout(left,top,left+view.getMeasuredWidth(),top+mChilderMaxHeight);
            left += view.getMeasuredWidth() + hSplce;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
