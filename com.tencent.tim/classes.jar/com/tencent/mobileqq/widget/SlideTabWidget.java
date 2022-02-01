package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TabWidget;
import arjg;
import com.tencent.common.app.BaseApplicationImpl;

public class SlideTabWidget
  extends TabWidget
{
  private static int aXs = (int)(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density * 3.0F + 0.5F);
  private a a;
  private int aXA = -1;
  private boolean animated;
  private boolean dbE;
  private boolean dbF;
  private int ein = -1;
  private float ki;
  private Handler mHandler = new arjg(this);
  private Paint mPaint = new Paint();
  
  public SlideTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mPaint.setColor(getResources().getColor(2131167312));
  }
  
  public SlideTabWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setColor(getResources().getColor(2131167312));
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.dbE) && ((this.ki >= 1.0F) || (this.ein == this.aXA))) {}
    do
    {
      return;
      View localView1 = getChildTabViewAt(this.ein);
      if (localView1 != null)
      {
        int k = localView1.getLeft();
        int m = localView1.getRight();
        int j = m;
        int i = k;
        if (this.ki > 0.0F)
        {
          View localView2 = getChildAt(this.aXA);
          j = m;
          i = k;
          if (localView2 != null)
          {
            i = (int)(localView1.getLeft() + this.ki * (localView2.getLeft() - localView1.getLeft()));
            float f1 = localView1.getRight();
            float f2 = this.ki;
            j = (int)(f1 + (localView2.getRight() - localView1.getRight()) * f2);
          }
        }
        paramCanvas.drawRect(i, getHeight() - aXs, j, getHeight(), this.mPaint);
      }
    } while ((this.dbE) || (this.a == null) || (!this.dbF));
    this.dbF = false;
    post(new SlideTabWidget.2(this));
  }
  
  public void setCurrentTab(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getTabCount()) || (paramInt == this.ein)) {
      return;
    }
    this.dbF = true;
    this.aXA = paramInt;
    if (this.animated)
    {
      this.dbE = true;
      this.mHandler.sendEmptyMessage(0);
    }
    for (;;)
    {
      super.setCurrentTab(paramInt);
      return;
      this.ein = this.aXA;
    }
  }
  
  public void setOnTabSlideCompleteListener(a parama)
  {
    this.a = parama;
  }
  
  public void setSlideAnimaPlay(boolean paramBoolean)
  {
    this.animated = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void eje();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideTabWidget
 * JD-Core Version:    0.7.0.1
 */