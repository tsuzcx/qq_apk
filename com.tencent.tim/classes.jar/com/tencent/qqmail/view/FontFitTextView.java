package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.androidqqmail.R.styleable;

public class FontFitTextView
  extends TextView
{
  private Paint mTestPaint = new Paint();
  private float maxSize;
  private float minSize;
  
  public FontFitTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FontFitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTestPaint.set(getPaint());
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FontFitTextView);
    this.minSize = (14.0F * paramContext.getResources().getDisplayMetrics().density);
    this.maxSize = (18.0F * paramContext.getResources().getDisplayMetrics().density);
    this.minSize = paramAttributeSet.getDimensionPixelSize(R.styleable.FontFitTextView_minTextSize, Math.round(this.minSize));
    this.maxSize = paramAttributeSet.getDimensionPixelSize(R.styleable.FontFitTextView_maxTextSize, Math.round(this.maxSize));
    paramAttributeSet.recycle();
  }
  
  private void refitText(String paramString, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    paramInt = paramInt - getPaddingLeft() - getPaddingRight();
    float f3 = this.maxSize;
    float f2 = this.minSize;
    this.mTestPaint.set(getPaint());
    this.mTestPaint.setTextSize(this.maxSize);
    float f1;
    if (this.mTestPaint.measureText(paramString) <= paramInt) {
      f1 = this.maxSize;
    }
    do
    {
      setTextSize(0, f1);
      return;
      this.mTestPaint.setTextSize(this.minSize);
      f1 = f2;
    } while (this.mTestPaint.measureText(paramString) >= paramInt);
    for (;;)
    {
      f1 = f2;
      if (f3 - f2 <= 0.5F) {
        break;
      }
      f1 = (f3 + f2) / 2.0F;
      this.mTestPaint.setTextSize(f1);
      if (this.mTestPaint.measureText(paramString) >= paramInt) {
        f3 = f1;
      } else {
        f2 = f1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = getMeasuredHeight();
    refitText(getText().toString(), paramInt1);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != paramInt3) {
      refitText(getText().toString(), paramInt1);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    refitText(paramCharSequence.toString(), getWidth());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.FontFitTextView
 * JD-Core Version:    0.7.0.1
 */