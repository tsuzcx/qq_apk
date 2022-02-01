package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class AutoFitTextView
  extends TextView
{
  private float AN;
  private a a;
  private Paint mTextPaint = new Paint();
  
  public AutoFitTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTextPaint.set(getPaint());
  }
  
  private void refitText(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramInt <= 0)) {
      return;
    }
    if (this.AN == 0.0F) {
      this.AN = getTextSize();
    }
    if (this.a != null) {}
    float f1;
    for (paramInt = this.a.oz();; paramInt = getWidth())
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getCompoundDrawablePadding();
      Rect localRect = new Rect();
      this.mTextPaint.setTextSize(this.AN);
      this.mTextPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
      float f2 = localRect.width();
      f1 = this.AN;
      while (f2 > paramInt - i - j - k)
      {
        f1 -= 1.0F;
        this.mTextPaint.setTextSize(f1);
        f2 = this.mTextPaint.measureText(paramString);
      }
    }
    setTextSize(0, f1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    refitText(getText().toString(), getWidth());
  }
  
  public void setOnGetMaxWidthCallback(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract int oz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AutoFitTextView
 * JD-Core Version:    0.7.0.1
 */