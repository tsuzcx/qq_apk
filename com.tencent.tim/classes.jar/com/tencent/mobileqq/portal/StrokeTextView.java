package com.tencent.mobileqq.portal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import wja;

public class StrokeTextView
  extends TextView
{
  private boolean cvE;
  private int dqW;
  private float dx;
  private float dy;
  private int mStrokeColor;
  private int mTextColor;
  private TextPaint mTextPaint;
  private int shadowColor;
  private float shadowRadius;
  
  public StrokeTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  @TargetApi(11)
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void SD(int paramInt)
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mCurTextColor");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      localField.setAccessible(false);
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("StrokeTextView", 2, "innerSetTextColor, exception=" + localThrowable.getMessage());
          localThrowable.printStackTrace();
        }
        int i = 1;
      }
      this.cvE = false;
      setTextColor(this.mTextColor);
      setShadowLayer(this.shadowRadius, this.dx, this.dy, this.shadowColor);
      invalidate();
    }
    if (i == 0)
    {
      this.mTextPaint.setColor(paramInt);
      return;
    }
  }
  
  private void init()
  {
    this.mTextPaint = getPaint();
    this.cvE = false;
    this.dqW = wja.dp2px(2.0F, getResources());
    if (Build.VERSION.SDK_INT > 11) {
      setLayerType(1, null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.cvE)
    {
      SD(this.mStrokeColor);
      this.mTextPaint.setStrokeWidth(this.dqW);
      this.mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.mTextPaint.setShadowLayer(this.shadowRadius, this.dx, this.dy, this.shadowColor);
      super.onDraw(paramCanvas);
      SD(this.mTextColor);
      this.mTextPaint.setStrokeWidth(0.0F);
      this.mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.mTextPaint.setFakeBoldText(false);
      this.mTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setInnerTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
    setTextColor(paramInt);
  }
  
  public void setShadow(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.shadowRadius = paramFloat1;
    this.dx = paramFloat2;
    this.dy = paramFloat3;
    this.shadowColor = paramInt;
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.mStrokeColor = paramInt;
  }
  
  public void setStrokeEnable(boolean paramBoolean)
  {
    this.cvE = paramBoolean;
  }
  
  public void setStrokeSize(int paramInt)
  {
    this.dqW = paramInt;
  }
  
  public void setTextBold(boolean paramBoolean)
  {
    this.mTextPaint.setFakeBoldText(paramBoolean);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    super.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.StrokeTextView
 * JD-Core Version:    0.7.0.1
 */