package com.tencent.mobileqq.activity.contacts.friend;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import aqho;
import atau.a;
import com.tencent.theme.ISkinTypeface;

public class SimpleTextView
  extends View
  implements ISkinTypeface
{
  private Paint.FontMetrics c;
  private int ccv = -16777216;
  private int ccw = -1;
  private int mCurTextColor;
  private final TextPaint mPaint;
  private CharSequence mText = "";
  private ColorStateList o;
  
  public SimpleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SimpleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    this.mPaint = new TextPaint(1);
    this.mPaint.density = ((Resources)localObject).getDisplayMetrics().density;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.se);
      paramInt = paramAttributeSet.getDimensionPixelSize(0, (int)aqho.convertDpToPixel(paramContext, 12.0F));
      localObject = paramAttributeSet.getColorStateList(1);
      paramContext = paramAttributeSet.getString(2);
      this.mPaint.setTextSize(paramInt);
      this.c = this.mPaint.getFontMetrics();
      this.o = ((ColorStateList)localObject);
      localObject = getDrawableState();
      this.mCurTextColor = this.o.getColorForState((int[])localObject, this.ccv);
      this.mPaint.setColor(this.mCurTextColor);
      this.mPaint.setTypeface(Typeface.SANS_SERIF);
      setText(paramContext);
      paramAttributeSet.recycle();
    }
  }
  
  private void cnB()
  {
    int[] arrayOfInt = getDrawableState();
    int i = this.o.getColorForState(arrayOfInt, this.ccv);
    if (i != this.mCurTextColor)
    {
      this.mCurTextColor = i;
      this.mPaint.setColor(this.mCurTextColor);
      invalidate();
    }
  }
  
  private int measureDimension(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    if (j == 1073741824) {
      paramInt1 = i;
    }
    do
    {
      return paramInt1;
      paramInt1 = paramInt2;
    } while (j != -2147483648);
    return Math.min(i, paramInt2);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.o != null) && (this.o.isStateful())) {
      cnB();
    }
  }
  
  public Paint getPaint()
  {
    return this.mPaint;
  }
  
  public CharSequence getText()
  {
    return this.mText;
  }
  
  public Paint j()
  {
    return this.mPaint;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getMeasuredHeight();
    float f2 = this.c.bottom;
    float f3 = this.c.top;
    float f1 = i;
    f2 = (i - (f2 - f3)) / 2.0F;
    f3 = this.c.bottom;
    paramCanvas.drawText(this.mText, 0, this.mText.length(), getPaddingLeft(), f1 - f2 - f3, this.mPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.ccw != -1) {}
    for (int i = this.ccw;; i = (int)this.mPaint.measureText(this.mText, 0, this.mText.length()))
    {
      setMeasuredDimension(measureDimension(paramInt1, i), measureDimension(paramInt2, Math.max((int)(this.c.top - this.c.bottom), getSuggestedMinimumWidth())));
      return;
    }
  }
  
  public void setDefaultTextColor(int paramInt)
  {
    this.ccv = paramInt;
  }
  
  public void setFixedWidth(int paramInt)
  {
    this.ccw = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (localObject != this.mText)
    {
      this.mText = ((CharSequence)localObject);
      requestLayout();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.o = ColorStateList.valueOf(paramInt);
    cnB();
    invalidate();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.o = paramColorStateList;
    cnB();
  }
  
  public void setTextSize(float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(1, paramFloat, ((Resources)localObject).getDisplayMetrics());
      this.mPaint.setTextSize(paramFloat);
      this.c = this.mPaint.getFontMetrics();
      requestLayout();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.SimpleTextView
 * JD-Core Version:    0.7.0.1
 */