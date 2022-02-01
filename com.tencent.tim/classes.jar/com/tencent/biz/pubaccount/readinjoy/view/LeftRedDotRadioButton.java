package com.tencent.biz.pubaccount.readinjoy.view;

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

public class LeftRedDotRadioButton
  extends RadioButton
{
  private boolean MX;
  private int aXU = (int)(this.mDensity * 9.0F + 0.5D);
  private Drawable bL;
  private float mDensity = getResources().getDisplayMetrics().density;
  
  public LeftRedDotRadioButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LeftRedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LeftRedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
      Layout.getDesiredWidth(getText(), getPaint());
      float f1 = localFontMetrics.descent;
      float f2 = localFontMetrics.ascent;
      getWidth();
      int j = (int)Math.ceil(getHeight() / 2 - (f1 - f2) / 2.0F - this.aXU + 4.0F * this.mDensity);
      if (QLog.isColorLevel()) {
        QLog.i(LeftRedDotRadioButton.class.getSimpleName(), 2, "reddot y:" + j);
      }
      int i = j;
      if (j < 0) {
        i = 0;
      }
      this.bL.setBounds(0, i, this.aXU + 0, this.aXU + i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.LeftRedDotRadioButton
 * JD-Core Version:    0.7.0.1
 */