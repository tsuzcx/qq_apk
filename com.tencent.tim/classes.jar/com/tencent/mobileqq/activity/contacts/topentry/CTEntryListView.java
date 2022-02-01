package com.tencent.mobileqq.activity.contacts.topentry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import ankt;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.widget.HorizontalListView;

public class CTEntryListView
  extends HorizontalListView
{
  private boolean ast;
  private int mTouchDownX;
  private int mTouchDownY;
  
  public CTEntryListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CTEntryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.mTouchDownX = ((int)(paramMotionEvent.getX() + 0.5F));
      this.mTouchDownY = ((int)(paramMotionEvent.getY() + 0.5F));
      this.ast = true;
      FrameHelperActivity.EO(false);
      i = 0;
      if (i != 0) {}
    }
    try
    {
      boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramMotionEvent)
    {
      int j;
      int k;
      return false;
    }
    if (i == 2)
    {
      i = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      i = Math.abs(i - this.mTouchDownX);
      j = Math.abs(j - this.mTouchDownY);
      k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      if ((!this.ast) || (i <= k)) {
        break label200;
      }
      if ((j / i >= 0.6F) || (this.mTouchDownX <= (int)(ankt.SCREEN_WIDTH * 0.1F))) {
        break label208;
      }
    }
    label200:
    label208:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        FrameHelperActivity.EO(true);
      }
      this.ast = false;
      break;
      if ((i == 1) || (i == 3))
      {
        FrameHelperActivity.EO(true);
        this.ast = false;
      }
      i = 0;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      FrameHelperActivity.EO(false);
    }
    for (;;)
    {
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent) {}
      if ((i == 1) || (i == 3))
      {
        FrameHelperActivity.EO(true);
        this.ast = false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryListView
 * JD-Core Version:    0.7.0.1
 */