package com.tencent.biz.subscribe.account_folder.recommend_banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView;
import com.tencent.widget.SwipListView;

public class TopRecommendListView
  extends SwipListView
{
  private int bvR;
  private int mInitialTouchX;
  private int mInitialTouchY;
  private int mTouchSlop;
  private View pD;
  
  public TopRecommendListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TopRecommendListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 16842868);
    init();
  }
  
  public TopRecommendListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    case 0: 
      this.mInitialTouchX = ((int)(paramMotionEvent.getX() + 0.5F));
      this.mInitialTouchY = ((int)(paramMotionEvent.getY() + 0.5F));
      this.bvR = pointToPosition(this.mInitialTouchX, this.mInitialTouchY);
      this.pD = getChildAt(this.bvR - getFirstVisiblePosition());
    }
    int j;
    int i;
    do
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (!(this.pD instanceof TopPanelView)) {
        break label217;
      }
      bool1 = bool2;
      if (this.bvR < 0) {
        break;
      }
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.mInitialTouchX;
      i = (int)((i - this.mInitialTouchY) * 0.6F);
      if (Math.abs(j) > this.mTouchSlop)
      {
        bool1 = bool2;
        if (Math.abs(j) >= Math.abs(i)) {
          break;
        }
      }
    } while ((Math.abs(j) <= this.mTouchSlop) || (Math.abs(i) <= Math.abs(j)));
    return super.onInterceptTouchEvent(paramMotionEvent);
    label217:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.TopRecommendListView
 * JD-Core Version:    0.7.0.1
 */