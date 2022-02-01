package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CircleCountdownView
  extends View
{
  private RectF H;
  private Paint aF;
  private Paint aG;
  private int mDuration;
  private int mHeight;
  private int mStrokeWidth;
  private Paint mTextPaint;
  private int mTime;
  private int mWidth;
  
  public CircleCountdownView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CircleCountdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleCountdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mStrokeWidth = ((int)(getResources().getDisplayMetrics().density * 1.5F + 0.5F));
    this.H = new RectF();
    this.mDuration = 5000;
    int i = Color.parseColor("#80FFFFFF");
    int j = Color.parseColor("#FFFFFFFF");
    int k = (int)(getResources().getDisplayMetrics().density * 12.0F + 0.5F);
    this.aF = new Paint();
    this.aF.setColor(i);
    this.aF.setStyle(Paint.Style.STROKE);
    this.aF.setStrokeWidth(this.mStrokeWidth);
    this.aF.setFlags(1);
    this.aG = new Paint();
    this.aG.setColor(j);
    this.aG.setStyle(Paint.Style.STROKE);
    this.aG.setStrokeWidth(this.mStrokeWidth);
    this.aG.setFlags(1);
    this.mTextPaint = new Paint();
    this.mTextPaint.setColor(j);
    this.mTextPaint.setTextSize(k);
    this.mTextPaint.setAntiAlias(true);
    setBackgroundColor(0);
  }
  
  public boolean ea(int paramInt)
  {
    if (paramInt > 0)
    {
      if (this.mTime + paramInt > this.mDuration) {}
      for (paramInt = this.mDuration;; paramInt = this.mTime + paramInt)
      {
        this.mTime = paramInt;
        invalidate();
        if (this.mTime != this.mDuration) {
          break;
        }
        return true;
      }
      return false;
    }
    return false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    float f = this.mTime * 360.0F / this.mDuration;
    paramCanvas.save();
    paramCanvas.drawArc(this.H, -90.0F, f, false, this.aG);
    paramCanvas.drawArc(this.H, f - 90.0F, 360.0F - f, false, this.aF);
    String str = String.valueOf((int)Math.ceil((this.mDuration - this.mTime) / 1000.0D));
    paramCanvas.drawText(str, (this.mWidth - this.mTextPaint.measureText(str)) / 2.0F, this.mHeight / 2 - (this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0F, this.mTextPaint);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.H.set(this.mStrokeWidth / 2, this.mStrokeWidth / 2, this.mWidth - this.mStrokeWidth / 2, this.mHeight - this.mStrokeWidth / 2);
  }
  
  public void resetTime()
  {
    this.mTime = 0;
    invalidate();
  }
  
  public void setDuration(int paramInt)
  {
    if (paramInt > 0) {
      this.mDuration = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView
 * JD-Core Version:    0.7.0.1
 */