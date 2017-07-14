package com.android.cgcxy.drollcyclopedia.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.cgcxy.drollcyclopedia.R;

/**
 * Created by chuangguo.qi on 2017/7/14.
 */

public class RefreshViewGroup extends RelativeLayout {

    private static final String TAG = "RefreshViewGroup";
    private MarginLayoutParams marginLayoutParams;
    private int downX;
    private int downY;
    private int measuredHeight;
    private Context mContext;
    private View refreshView;
    private TextView textView;
    private ImageView imageView;

    public RefreshViewGroup(Context context) {
        this(context, null);
    }

    public RefreshViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        refreshView = LayoutInflater.from(mContext).inflate(R.layout.refresh_hand_view, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dip2px(mContext,50));
        refreshView.setVisibility(GONE);
        textView = (TextView) refreshView.findViewById(R.id.textView);
        imageView = (ImageView) refreshView.findViewById(R.id.imageView);
        addView(refreshView,params);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasured = getMeasured(MeasureSpec.getMode(widthMeasureSpec), MeasureSpec.getSize(widthMeasureSpec));
        int heightMeasured = getMeasured(MeasureSpec.getMode(heightMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasured, heightMeasured);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i == 1) {

                View childAt = getChildAt(i);
                measuredHeight = childAt.getMeasuredHeight();
                marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                marginLayoutParams.topMargin = -measuredHeight;

            }else if (i==0){

                final View childAt = getChildAt(i);
                if (childAt instanceof RecyclerView) {

                    childAt.setOnTouchListener(new OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            LinearLayoutManager layoutManager = (LinearLayoutManager) ((RecyclerView) childAt).getLayoutManager();
                            int ItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
                           if (ItemPosition==0){
                               refreshView.setVisibility(VISIBLE);
                               onTouchEvent(event);
                           }else {
                               View childAt = getChildAt(1);
                               refreshView.setVisibility(GONE);
                               marginLayoutParams.topMargin=0;
                               childAt.setLayoutParams(marginLayoutParams);
                           }
                            return false;
                        }
                    });
                }

            }
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            downX = (int) event.getX();
            downY = (int) event.getY();

        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {

            View childAt = getChildAt(1);
            int offsetY = (int) (event.getY() - downY) / 3;

            marginLayoutParams.topMargin = -measuredHeight + offsetY;
            if (marginLayoutParams.topMargin >= 0) {
                marginLayoutParams.topMargin = 0;
                textView.setText("松开刷新");
                imageView.setImageResource(R.drawable.ic_arrow_upward_white_24dp);
            }else {
                imageView.setImageResource(R.drawable.ic_arrow_downward_white_24dp);
                textView.setText("下拉刷新");
            }

            childAt.setLayoutParams(marginLayoutParams);
        }else if (event.getAction() == MotionEvent.ACTION_UP){
            View childAt = getChildAt(1);
            if (marginLayoutParams.topMargin < 0) {
                marginLayoutParams.topMargin = -measuredHeight;
                childAt.setLayoutParams(marginLayoutParams);

            }else {


            }

        }
        return super.onTouchEvent(event);
    }

    public int getMeasured(int mode, int size) {

        int result = 0;
        if (mode == MeasureSpec.AT_MOST) {
            result = Math.min(result, size);
            Log.i(TAG, "getMeasured: AT_MOST");
        } else if (mode == MeasureSpec.EXACTLY) {
            Log.i(TAG, "getMeasured: EXACTLY");//match_parent
            result = size;
        } else if (mode == MeasureSpec.UNSPECIFIED) {
            Log.i(TAG, "getMeasured: UNSPECIFIED");
            result = size;
        }
        return result;
    }

    public int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}
