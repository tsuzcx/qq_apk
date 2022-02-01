package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RadioButton;
import com.tencent.qphone.base.util.QLog;

public class RedDotRadioButton
  extends RadioButton
{
  private boolean MX;
  private int aXU = (int)(this.mDensity * 9.0F + 0.5D);
  private Drawable bL;
  private float mDensity = getResources().getDisplayMetrics().density;
  
  public RedDotRadioButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean ds()
  {
    return this.MX;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.MX) && (this.bL != null))
    {
      this.bL.setState(getDrawableState());
      Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
      float f1 = Layout.getDesiredWidth(getText(), getPaint());
      float f2 = localFontMetrics.descent;
      float f3 = localFontMetrics.ascent;
      int j = getWidth();
      int i = getHeight();
      float f4 = j / 2;
      int k = (int)Math.ceil(f1 / 2.0F + f4 - this.mDensity * 2.0F);
      j = (int)Math.ceil(i / 2 - (f2 - f3) / 2.0F - this.aXU + 4.0F * this.mDensity);
      if (QLog.isColorLevel()) {
        QLog.i(RedDotRadioButton.class.getSimpleName(), 2, "reddot y:" + j);
      }
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.bL.setBounds(k, i, this.aXU + k, this.aXU + i);
      this.bL.draw(paramCanvas);
    }
  }
  
  public void showRedDot(boolean paramBoolean)
  {
    this.MX = paramBoolean;
    if ((this.MX) && (this.bL == null)) {
      this.bL = getResources().getDrawable(2130851400);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotRadioButton
 * JD-Core Version:    0.7.0.1
 */