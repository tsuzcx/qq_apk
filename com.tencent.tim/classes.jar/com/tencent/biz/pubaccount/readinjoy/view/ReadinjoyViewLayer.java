package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import ankt;
import com.tencent.mobileqq.app.FrameHelperActivity;
import java.util.ArrayList;
import java.util.List;

public class ReadinjoyViewLayer
  extends FrameLayout
{
  private boolean ast;
  private List<View> kc = new ArrayList();
  private int mTouchDownX;
  private int mTouchDownY;
  
  public ReadinjoyViewLayer(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadinjoyViewLayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean e(View paramView, float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    paramView.getLocalVisibleRect(localRect);
    int i = arrayOfInt[0] + localRect.left;
    int j = localRect.width();
    int k = arrayOfInt[1] + localRect.top;
    int m = localRect.height();
    return (i < paramFloat1) && (paramFloat1 < j + i) && (k < paramFloat2) && (paramFloat2 < m + k);
  }
  
  public void dh(View paramView)
  {
    this.kc.add(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.mTouchDownX = ((int)(paramMotionEvent.getX() + 0.5F));
      this.mTouchDownY = ((int)(paramMotionEvent.getY() + 0.5F));
      i = 0;
      if (i < this.kc.size()) {
        if (e((View)this.kc.get(i), paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) {
          FrameHelperActivity.EO(false);
        }
      }
    }
    for (;;)
    {
      return false;
      i += 1;
      break;
      i = 0;
      if (i == 0) {}
      try
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        if (bool) {
          return true;
        }
      }
      catch (Exception paramMotionEvent)
      {
        int j;
        int k;
        label240:
        return false;
      }
    }
    if (i == 2)
    {
      i = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      i = Math.abs(i - this.mTouchDownX);
      j = Math.abs(j - this.mTouchDownY);
      k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      if ((!this.ast) || (i <= k)) {
        break label240;
      }
      if ((j / i >= 0.6F) || (this.mTouchDownX <= (int)(ankt.SCREEN_WIDTH * 0.1F))) {
        break label248;
      }
    }
    label248:
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
    boolean bool1 = false;
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      FrameHelperActivity.EO(false);
    }
    for (;;)
    {
      try
      {
        boolean bool2 = super.onTouchEvent(paramMotionEvent);
        bool1 = bool2;
      }
      catch (Exception paramMotionEvent)
      {
        continue;
      }
      if (!bool1) {
        FrameHelperActivity.EO(true);
      }
      return bool1;
      if ((i == 1) || (i == 3))
      {
        FrameHelperActivity.EO(true);
        this.ast = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyViewLayer
 * JD-Core Version:    0.7.0.1
 */