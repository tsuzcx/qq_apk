package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import ankt;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class ContactsViewPager
  extends ViewPager
{
  private boolean ast;
  private boolean bqc;
  private boolean bqd;
  private HeaderScrollView c;
  private int mTouchDownX;
  private int mTouchDownY;
  
  public ContactsViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactsViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean UV()
  {
    if ((!this.bqc) && (this.c == null))
    {
      this.bqc = true;
      ViewParent localViewParent = getParent();
      while ((localViewParent != null) && (this.c == null)) {
        if ((localViewParent instanceof HeaderScrollView)) {
          this.c = ((HeaderScrollView)localViewParent);
        } else if ((localViewParent instanceof View)) {
          localViewParent = ((View)localViewParent).getParent();
        } else {
          localViewParent = null;
        }
      }
    }
    if (this.c != null) {
      return this.c.bpY;
    }
    return false;
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
      this.bqd = false;
      FrameHelperActivity.EO(false);
      i = 0;
      if (i != 0) {}
    }
    int j;
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
      int k;
      int m;
      label173:
      return false;
    }
    if (i == 2)
    {
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      k = Math.abs(j - this.mTouchDownX);
      i = Math.abs(i - this.mTouchDownY);
      m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      if ((!this.ast) || (k <= m)) {
        break label259;
      }
      if ((k * 0.5F <= i) || (this.mTouchDownX <= (int)(ankt.SCREEN_WIDTH * 0.1F))) {
        break label254;
      }
      j = 1;
      if (j == 0) {
        FrameHelperActivity.EO(true);
      }
      this.ast = false;
    }
    for (;;)
    {
      if (UV())
      {
        this.bqd = true;
        return false;
      }
      i = j;
      if (!this.bqd) {
        break;
      }
      i = j;
      if (k <= m * 3) {
        break;
      }
      return false;
      if ((i == 1) || (i == 3))
      {
        FrameHelperActivity.EO(true);
        this.ast = false;
        this.bqd = false;
      }
      i = 0;
      break;
      label254:
      j = 0;
      break label173;
      label259:
      j = 0;
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
        this.bqd = false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager
 * JD-Core Version:    0.7.0.1
 */