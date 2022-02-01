package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import sac;

public class SubScribeSwipeRefreshLayout
  extends SwipeRefreshLayout
{
  private TopGestureLayout a;
  private Rect aL;
  private int bvR;
  private int mInitialTouchX;
  private int mInitialTouchY;
  private int mTouchSlop;
  private View pC;
  
  public SubScribeSwipeRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubScribeSwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  protected void bku()
  {
    if (this.a == null)
    {
      ViewGroup localViewGroup = (ViewGroup)((Activity)getContext()).getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.a = ((TopGestureLayout)localObject);
      }
    }
    if (this.a != null) {
      this.a.setInterceptTouchEventListener(new sac(this));
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = paramMotionEvent.getActionIndex();
    switch (i)
    {
    case 1: 
    default: 
      return super.onInterceptTouchEvent(paramMotionEvent);
    case 0: 
      this.mInitialTouchX = ((int)(paramMotionEvent.getX() + 0.5F));
      this.mInitialTouchY = ((int)(paramMotionEvent.getY() + 0.5F));
      this.bvR = MotionEventCompat.findPointerIndex(paramMotionEvent, j);
    }
    do
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.mInitialTouchX;
      i = (int)((i - this.mInitialTouchY) * 0.6F);
      if ((Math.abs(j) > this.mTouchSlop) && (Math.abs(j) >= Math.abs(i))) {
        return false;
      }
    } while ((Math.abs(j) <= this.mTouchSlop) || (Math.abs(i) <= Math.abs(j)));
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setConflictView(View paramView)
  {
    this.pC = paramView;
    this.aL = new Rect();
    bku();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.SubScribeSwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */