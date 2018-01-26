package com.harshilyadav.bucketdrops.adapters;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.harshilyadav.bucketdrops.R;

/**
 * Created by harshilyadav on 24/01/18.
 */

public class Dividers extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    private int mOrientation;
    public Dividers(Context context, int orientation){
        mDivider=context.getDrawable(R.drawable.divider);
        if(orientation != LinearLayoutManager.VERTICAL){
            throw new IllegalArgumentException("");
        }
        mOrientation=orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if(mOrientation==LinearLayoutManager.VERTICAL){
            drawHorizontalDivider(c,parent,state);
        }
    }

    private void drawHorizontalDivider(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left,top,right,bottom;
        left=parent.getPaddingLeft()-parent.getPaddingRight();
        right=parent.getWidth();
        int count=parent.getChildCount();
        for(int i=0;i<count;i++){
            if(AdapterDrops.FOOTER!=parent.getAdapter().getItemViewType(i)){
                View current=parent.getChildAt(i);
                RecyclerView.LayoutParams params=(RecyclerView.LayoutParams) current.getLayoutParams();
                top=current.getTop()-params.topMargin;
                bottom=top+mDivider.getIntrinsicHeight();
                mDivider.setBounds(left,top,right,bottom);
                mDivider.draw(c);
            }

        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }
}
