package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.MessageProgressView;

public class AutoStartProgressBar
  extends MessageProgressView
{
  protected static int buN = 50;
  protected static int buO = -1;
  protected boolean mIsStop;
  protected String mKey;
  protected int mMax = 100;
  
  public AutoStartProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AutoStartProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AutoStartProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private double a(int paramInt)
  {
    if (paramInt == buO) {
      return Math.pow(10.0D - (1.0D - this.mProgress * 1.0D / this.mMax) * 100.0D, 2.5D);
    }
    return 0.0D;
  }
  
  public void bjr()
  {
    if (!sd(this.mKey))
    {
      this.mProgress = 0;
      this.mIsStop = false;
      new ProgressThread(null).start();
    }
  }
  
  public void bwe()
  {
    setAnimProgress(100, this.mKey);
    this.mIsStop = true;
  }
  
  public void setKey(String paramString)
  {
    this.mKey = paramString;
  }
  
  class ProgressThread
    extends Thread
  {
    private ProgressThread() {}
    
    private boolean a(int paramInt1, int paramInt2, double paramDouble)
    {
      return a(paramInt1, paramInt2, paramDouble, true);
    }
    
    private boolean a(int paramInt1, int paramInt2, double paramDouble, boolean paramBoolean)
    {
      boolean bool2 = true;
      boolean bool1;
      if ((paramInt1 < 0) || (paramInt2 < 0)) {
        bool1 = false;
      }
      do
      {
        return bool1;
        if (AutoStartProgressBar.this.mProgress >= paramInt1) {
          break;
        }
        int i = (paramInt1 - AutoStartProgressBar.this.mProgress) / (paramInt2 / AutoStartProgressBar.buN);
        paramInt2 = i;
        if (i == 0) {
          paramInt2 = 1;
        }
        bool1 = bool2;
      } while (AutoStartProgressBar.this.mProgress > paramInt1);
      if ((paramBoolean) && (isFinish())) {
        return false;
      }
      AutoStartProgressBar localAutoStartProgressBar = AutoStartProgressBar.this;
      localAutoStartProgressBar.mProgress += paramInt2;
      AutoStartProgressBar.this.setAnimProgress(AutoStartProgressBar.this.mProgress, AutoStartProgressBar.this.mKey);
      AutoStartProgressBar.this.postInvalidate();
      for (;;)
      {
        try
        {
          double d2 = AutoStartProgressBar.buN;
          if (paramDouble >= 0.0D) {
            break label170;
          }
          d1 = AutoStartProgressBar.a(AutoStartProgressBar.this, (int)paramDouble);
          Thread.sleep((d1 * d2));
        }
        catch (InterruptedException localInterruptedException) {}
        break;
        label170:
        double d1 = paramDouble;
      }
      return false;
    }
    
    private boolean an(int paramInt1, int paramInt2)
    {
      return a(paramInt1, paramInt2, 1.0D, true);
    }
    
    private boolean isFinish()
    {
      boolean bool = false;
      if (AutoStartProgressBar.this.mIsStop) {
        bool = a(AutoStartProgressBar.this.mMax, 400, 0.3300000131130219D, false);
      }
      return bool;
    }
    
    public void run()
    {
      if (!an((int)(40.0D + Math.random() * 31.0D) * AutoStartProgressBar.this.mMax / 100, 1500)) {}
      while (!an(AutoStartProgressBar.this.mMax * 90 / 100, 1500)) {
        return;
      }
      a(AutoStartProgressBar.this.mMax * 99 / 100, AutoStartProgressBar.buN * 10, AutoStartProgressBar.buO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.AutoStartProgressBar
 * JD-Core Version:    0.7.0.1
 */