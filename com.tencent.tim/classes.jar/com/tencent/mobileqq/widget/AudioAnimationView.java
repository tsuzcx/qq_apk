package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class AudioAnimationView
  extends View
{
  private Handler bT = new Handler();
  private int eeU;
  private int eeV;
  private int eeW;
  private int eeX = 7;
  private Rect[] f;
  private Drawable mIcon;
  private Paint mPaint;
  private Resources mRes;
  volatile boolean mRunning = false;
  private int mStyle = 1;
  private int[] ph;
  
  public AudioAnimationView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AudioAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AudioAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public static int b(int paramInt, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramInt + 0.5F);
  }
  
  void ehL()
  {
    int j = (int)(this.eeW * 0.6777F);
    int i = 0;
    while (i < this.eeX)
    {
      this.ph[i] = ((int)(j * Math.random()));
      i += 1;
    }
  }
  
  void init()
  {
    this.mRes = getResources();
    this.eeU = b(2, getResources());
    this.eeV = b(2, getResources());
    this.eeW = b(12, getResources());
    this.mPaint = new Paint();
    this.mPaint.setColor(-1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(4.0F);
    this.mPaint.setAlpha(204);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.bT != null) {
      this.bT.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mRunning)
    {
      int i = 0;
      if (i < this.eeX)
      {
        Rect localRect = this.f[i];
        int k = this.eeU;
        int m = this.eeV;
        int n = this.ph[i];
        int i1 = this.eeU;
        int i2 = this.eeV;
        int j = this.eeW;
        if (this.mStyle == 1) {}
        for (j = this.eeW - this.ph[i];; j = this.eeW)
        {
          localRect.set((k + m) * i, n, i2 * i + i1 * (i + 1), j);
          paramCanvas.drawRect(localRect, this.mPaint);
          i += 1;
          break;
        }
      }
    }
    else if (this.mIcon != null)
    {
      this.mIcon.draw(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    super.onMeasure(paramInt1, paramInt2);
    if (this.mRunning)
    {
      paramInt1 = this.eeX;
      paramInt2 = this.eeU;
      paramInt2 = (this.eeX - 1) * this.eeV + paramInt1 * paramInt2;
      paramInt1 = this.eeW;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      if (this.mIcon != null)
      {
        paramInt2 = this.mIcon.getIntrinsicWidth();
        paramInt1 = this.mIcon.getIntrinsicHeight();
      }
      else
      {
        paramInt2 = 0;
        paramInt1 = i;
      }
    }
  }
  
  public void setColor(int paramInt)
  {
    if (this.mPaint != null) {
      this.mPaint.setColor(paramInt);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mIcon = paramDrawable;
    if (this.mIcon != null) {
      this.mIcon.setBounds(0, 0, this.mIcon.getIntrinsicWidth(), this.mIcon.getIntrinsicHeight());
    }
    requestLayout();
    invalidate();
  }
  
  public void setRectCount(int paramInt)
  {
    this.eeX = paramInt;
    this.f = new Rect[this.eeX];
    this.ph = new int[this.eeX];
    paramInt = 0;
    while (paramInt <= this.eeX - 1)
    {
      this.f[paramInt] = new Rect();
      this.ph[paramInt] = 0;
      paramInt += 1;
    }
    ehL();
    requestLayout();
    invalidate();
  }
  
  public void setRectHeightMax(int paramInt)
  {
    this.eeW = paramInt;
  }
  
  public void setRectInterval(int paramInt)
  {
    this.eeV = paramInt;
  }
  
  public void setRectWidth(int paramInt)
  {
    this.eeU = paramInt;
  }
  
  public void setSyle(int paramInt)
  {
    this.mStyle = paramInt;
  }
  
  public void startAnimation()
  {
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioAnimationView", 2, "startAnimation(), mRunning= " + this.mRunning);
    }
    if (!this.mRunning)
    {
      this.mRunning = true;
      this.bT.removeCallbacksAndMessages(null);
      this.bT.post(new Animator(null));
    }
  }
  
  public void stopAnimation()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioAnimationView", 2, "stopAnimation(), mRunning= " + this.mRunning);
    }
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if (this.mRunning)
    {
      this.mRunning = false;
      this.bT.removeCallbacksAndMessages(null);
      requestLayout();
      invalidate();
    }
  }
  
  class Animator
    implements Runnable
  {
    private Animator() {}
    
    public void run()
    {
      AudioAnimationView.this.ehL();
      if (AudioAnimationView.this.mRunning) {
        AudioAnimationView.a(AudioAnimationView.this).postDelayed(this, 100L);
      }
      AudioAnimationView.this.requestLayout();
      AudioAnimationView.this.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AudioAnimationView
 * JD-Core Version:    0.7.0.1
 */