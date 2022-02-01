package com.tencent.qqmail.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TextView;

public class QMTextView
  extends TextView
{
  private float mBaseLine;
  private int mHeight;
  private int mLineHeight;
  private int mLines;
  private Paint mPaint;
  private String mText;
  private int mTextTotalCount;
  private float mTextTotalLength;
  private float mThreePointLength;
  private int mWidth;
  
  public QMTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QMTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void getSource()
  {
    this.mText = getText().toString();
    this.mPaint = getPaint();
    this.mBaseLine = (-1.0F * this.mPaint.ascent());
    this.mTextTotalLength = this.mPaint.measureText(this.mText);
    this.mTextTotalCount = this.mText.length();
    this.mThreePointLength = this.mPaint.measureText("...");
    this.mLineHeight = getLineHeight();
    this.mLines = getLineCount();
    if (Build.VERSION.SDK_INT >= 16) {
      this.mLines = Math.min(getLineCount(), getMaxLines());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    float f1 = 0.0F;
    int k;
    for (int i = 0; j < this.mLines; i = k)
    {
      float f3 = this.mWidth;
      float f2 = f3;
      if (j == this.mLines - 1)
      {
        f2 = f3;
        if ((int)(this.mTextTotalLength / this.mWidth + 1.0F) > this.mLines)
        {
          f2 = this.mWidth - this.mThreePointLength;
          f3 = this.mBaseLine;
          paramCanvas.drawText("...", 0, 3, f2, this.mLineHeight * j + f3, this.mPaint);
        }
      }
      f1 += f2;
      k = this.mPaint.breakText(this.mText, 0, this.mTextTotalCount, true, f1, null);
      paramCanvas.drawText(this.mText, i, k, 0.0F, this.mBaseLine + this.mLineHeight * j, this.mPaint);
      j += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mWidth = (getMeasuredWidth() - getPaddingRight() - getPaddingLeft());
    getSource();
    paramInt1 = (int)(this.mTextTotalLength / this.mWidth + 1.0F);
    this.mLines = Math.min(this.mLines, paramInt1);
    this.mHeight = (this.mLines * this.mLineHeight);
    setMeasuredDimension(this.mWidth, this.mHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMTextView
 * JD-Core Version:    0.7.0.1
 */