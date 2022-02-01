package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.QQViewPager;

public class EmoticonPanelViewPager
  extends QQViewPager
{
  private boolean bZN;
  private boolean bZO;
  private boolean bZP;
  private int cSC;
  private int cSD;
  private int cSE;
  private float hP;
  private float mStartX;
  
  public EmoticonPanelViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmoticonPanelViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.bZP = true;
      this.cSE = 0;
      continue;
      this.cSE = 0;
      this.bZP = false;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.bZN) || (this.bZO))
    {
      switch (paramMotionEvent.getAction())
      {
      }
      do
      {
        for (;;)
        {
          return super.onInterceptTouchEvent(paramMotionEvent);
          this.mStartX = paramMotionEvent.getX();
        }
        this.hP = (paramMotionEvent.getX() - this.mStartX);
        this.mStartX = paramMotionEvent.getX();
      } while (((!this.bZN) || (this.hP <= 0.0F)) && ((!this.bZO) || (this.hP >= 0.0F)));
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if ((!this.bZP) || ((this.cSC == 0) && (this.cSD == 0)))
    {
      super.scrollTo(paramInt1, paramInt2);
      return;
    }
    int i = paramInt1;
    int j;
    if (getCurrentItem() == this.cSC)
    {
      i = paramInt1;
      if (this.cSC != 0)
      {
        i = paramInt1;
        if (this.bZN)
        {
          j = getScrollX();
          this.cSE = (paramInt1 - j + this.cSE);
          i = paramInt1;
          if (this.cSE < 0) {
            i = j;
          }
        }
      }
    }
    paramInt1 = i;
    if (getCurrentItem() == this.cSD)
    {
      paramInt1 = i;
      if (this.cSD != 0)
      {
        paramInt1 = i;
        if (this.bZO)
        {
          j = getScrollX();
          this.cSE = (i - j + this.cSE);
          paramInt1 = i;
          if (this.cSE > 0) {
            paramInt1 = j;
          }
        }
      }
    }
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setLeftScrollDisEnable(boolean paramBoolean)
  {
    this.bZO = paramBoolean;
  }
  
  public void setNoScrollItem(int paramInt1, int paramInt2)
  {
    this.cSC = paramInt1;
    this.cSD = paramInt2;
  }
  
  public void setRightScrollDisEnable(boolean paramBoolean)
  {
    this.bZN = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelViewPager
 * JD-Core Version:    0.7.0.1
 */