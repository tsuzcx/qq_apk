package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class RedDotTextView
  extends TextView
{
  private static String TAG = "RedDotTextView";
  private int aXU = (int)(this.mDensity * 9.0F + 0.5D);
  private boolean dbq = true;
  private boolean gS;
  private Drawable gq;
  private float mDensity = getResources().getDisplayMetrics().density;
  private Rect mTextBounds = new Rect();
  
  public RedDotTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedDotTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean aGD()
  {
    return this.gS;
  }
  
  public void bB(Canvas paramCanvas)
  {
    float f2 = 0.0F;
    float f3;
    int j;
    int i;
    float f4;
    float f5;
    if (this.gS)
    {
      if (this.gq == null) {
        this.gq = getResources().getDrawable(2130851400);
      }
      String str = getText().toString();
      TextPaint localTextPaint = getPaint();
      localTextPaint.getTextBounds(str, 0, str.length(), this.mTextBounds);
      f3 = this.mTextBounds.height();
      f1 = Layout.getDesiredWidth(str, localTextPaint);
      j = getWidth();
      i = getHeight();
      f4 = j / 2;
      f5 = f1 / 2.0F;
      if (!this.dbq) {
        break label212;
      }
    }
    label212:
    for (float f1 = this.mDensity * 2.0F;; f1 = 0.0F)
    {
      j = (int)(f4 + f5 - f1);
      f4 = i / 2;
      f3 /= 2.0F;
      f5 = this.aXU;
      f1 = f2;
      if (this.dbq) {
        f1 = this.mDensity * 2.0F;
      }
      i = (int)(f1 + (f4 - f3 - f5));
      this.gq.setBounds(j, i, this.aXU + j, this.aXU + i);
      this.gq.draw(paramCanvas);
      return;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.translate(getScrollX(), getScrollY());
    bB(paramCanvas);
    paramCanvas.restore();
  }
  
  public void showRedDot(boolean paramBoolean)
  {
    this.gS = paramBoolean;
    invalidate();
  }
  
  public void showRedDot(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.dbq = paramBoolean2;
    showRedDot(paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RedDotTextView
 * JD-Core Version:    0.7.0.1
 */