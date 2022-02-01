package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

public class URLTextImageView
  extends URLImageView
{
  float Ch = 0.0F;
  int baseline;
  int mTextColor = 2131165685;
  public int mTextSize;
  public String text;
  Paint textPaint;
  
  public URLTextImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public URLTextImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public URLTextImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (!TextUtils.isEmpty(this.text))
    {
      if (this.textPaint == null)
      {
        this.textPaint = new Paint(1);
        this.textPaint.setColor(getContext().getResources().getColor(this.mTextColor));
        this.textPaint.setTextAlign(Paint.Align.CENTER);
      }
      if (this.mTextSize != this.textPaint.getTextSize())
      {
        this.textPaint.setTextSize(this.mTextSize);
        Paint.FontMetricsInt localFontMetricsInt = this.textPaint.getFontMetricsInt();
        this.baseline = ((getHeight() - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top);
      }
      int i = this.baseline;
      if (this.Ch != 0.0F) {
        i = (int)(this.Ch * getHeight());
      }
      paramCanvas.drawText(this.text, getWidth() / 2, i, this.textPaint);
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
    if (this.textPaint != null) {
      this.textPaint.setColor(getContext().getResources().getColor(this.mTextColor));
    }
  }
  
  public void setTextSize(int paramInt)
  {
    this.mTextSize = paramInt;
  }
  
  public void setTopPercent(float paramFloat)
  {
    this.Ch = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.URLTextImageView
 * JD-Core Version:    0.7.0.1
 */