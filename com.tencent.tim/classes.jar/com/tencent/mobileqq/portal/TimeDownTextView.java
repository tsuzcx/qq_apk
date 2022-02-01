package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import wja;

public class TimeDownTextView
  extends View
{
  private CharSequence ab = "";
  private int acD;
  private Rect cq;
  boolean cvF = false;
  private int dqX;
  private int dqY;
  private int dqZ;
  private int dra;
  private int drb;
  private int drc;
  private int height;
  private TextPaint j;
  private Rect mBounds;
  private CharSequence mText = "";
  protected TextPaint mTextPaint = new TextPaint(1);
  private int width;
  private int x;
  private int y;
  
  public TimeDownTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TimeDownTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/DS-DIGIB.TTF");
    this.mTextPaint.setTypeface(paramContext);
    this.mTextPaint.setColor(Color.parseColor("#FCD383"));
    setTextSize(1, 18.0F);
    this.mBounds = new Rect();
    this.j = new TextPaint(1);
    this.j.setColor(Color.parseColor("#FFFFFF"));
    this.j.setTextSize(wja.dp2px(16.0F, getResources()));
    this.cq = new Rect();
    this.drc = wja.dp2px(5.0F, getResources());
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.cvF) {
      paramCanvas.drawText(this.ab, 0, this.ab.length(), this.dqY, this.dqZ, this.j);
    }
    paramCanvas.drawText(this.mText, 0, this.mText.length(), this.x, this.y, this.mTextPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    if (!this.cvF)
    {
      this.x = (this.width / 2 - this.acD / 2);
      this.y = (this.height / 2 + this.dqX / 2);
      return;
    }
    this.dqY = (this.width / 2 - (this.dra + this.drc + this.acD) / 2);
    this.dqZ = (this.height / 2 + (this.drb + this.dqX) / 2);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() != this.mText.length())
    {
      this.mTextPaint.getTextBounds(paramCharSequence.toString(), 0, paramCharSequence.length(), this.mBounds);
      this.acD = this.mBounds.width();
      this.dqX = this.mBounds.height();
      this.x = (this.width / 2 - this.acD / 2);
      this.y = (this.height / 2 + this.dqX / 2);
      Paint.FontMetricsInt localFontMetricsInt = this.mTextPaint.getFontMetricsInt();
      this.y = ((this.height - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top);
    }
    this.mText = paramCharSequence;
    this.cvF = false;
    invalidate();
  }
  
  public void setText2(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence2.length() != this.ab.length()) || (paramCharSequence1.length() != this.mText.length()))
    {
      this.j.getTextBounds(paramCharSequence2.toString(), 0, paramCharSequence2.length(), this.cq);
      this.dra = this.cq.width();
      this.drb = this.cq.height();
      this.mTextPaint.getTextBounds(paramCharSequence1.toString(), 0, paramCharSequence1.length(), this.mBounds);
      this.acD = this.mBounds.width();
      this.dqX = this.mBounds.height();
      this.dqY = (this.width / 2 - (this.dra + this.acD) / 2);
      Paint.FontMetricsInt localFontMetricsInt = this.j.getFontMetricsInt();
      this.dqZ = ((this.height - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top);
      this.x = (this.dqY + this.dra + this.drc);
      localFontMetricsInt = this.mTextPaint.getFontMetricsInt();
      this.y = ((this.height - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top);
    }
    this.cvF = true;
    this.mText = paramCharSequence1;
    this.ab = paramCharSequence2;
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextPaint.setColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.mTextPaint.setTextSize(TypedValue.applyDimension(paramInt, paramFloat, getResources().getDisplayMetrics()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.TimeDownTextView
 * JD-Core Version:    0.7.0.1
 */