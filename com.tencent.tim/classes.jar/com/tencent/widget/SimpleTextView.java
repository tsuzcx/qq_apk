package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.theme.ISkinTypeface;

public class SimpleTextView
  extends View
  implements ISkinTypeface
{
  private boolean dkU;
  private int mCurTextColor;
  private int mGravity = 17;
  private CharSequence mText = "";
  private Rect mTextBounds;
  private final TextPaint mTextPaint;
  private float mX;
  private float mY;
  private ColorStateList o;
  
  public SimpleTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SimpleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SimpleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getResources();
    this.mTextPaint = new TextPaint(1);
    this.mTextPaint.density = paramContext.getDisplayMetrics().density;
    this.mTextBounds = new Rect();
    this.dkU = true;
    this.mTextPaint.setTypeface(Typeface.SANS_SERIF);
  }
  
  private void cnB()
  {
    int i = this.o.getColorForState(getDrawableState(), 0);
    if (i != this.mCurTextColor)
    {
      this.mCurTextColor = i;
      invalidate();
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.mTextPaint.getTextSize())
    {
      this.mTextPaint.setTextSize(paramFloat);
      this.dkU = true;
      invalidate();
    }
  }
  
  public Paint getPaint()
  {
    return this.mTextPaint;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    String str = this.mText.toString();
    int i = this.mCurTextColor;
    this.mTextPaint.setColor(i);
    this.mTextPaint.drawableState = getDrawableState();
    paramCanvas.save();
    paramCanvas.translate(getScrollX(), getScrollY());
    float f1;
    int m;
    int n;
    int j;
    int i1;
    int k;
    int i2;
    float f2;
    if (this.dkU)
    {
      this.mTextPaint.getTextBounds(str, 0, str.length(), this.mTextBounds);
      f1 = Layout.getDesiredWidth(str, this.mTextPaint);
      m = getPaddingLeft();
      n = getPaddingRight();
      i = getPaddingTop();
      j = getPaddingBottom();
      i1 = getWidth();
      k = getHeight();
      i2 = this.mGravity & 0x7;
      this.mX = m;
      if (i2 != 1) {
        break label284;
      }
      f2 = this.mX;
      this.mX = ((i1 - m - n - f1) / 2.0F + f2);
      m = this.mGravity & 0x70;
      Paint.FontMetricsInt localFontMetricsInt = this.mTextPaint.getFontMetricsInt();
      n = localFontMetricsInt.descent - localFontMetricsInt.ascent;
      this.mY = (n - localFontMetricsInt.descent + i);
      if (m != 16) {
        break label315;
      }
      this.mY += (k - j - i - n) / 2;
    }
    for (;;)
    {
      this.dkU = false;
      paramCanvas.drawText(str, this.mX, this.mY, this.mTextPaint);
      paramCanvas.restore();
      return;
      label284:
      if (i2 != 5) {
        break;
      }
      f2 = this.mX;
      this.mX = (i1 - m - n - f1 + f2);
      break;
      label315:
      if (m == 80) {
        this.mY += k - j - i - n;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = getMeasuredWidth();
    int m = getMeasuredHeight();
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i1 == 1073741824)
    {
      paramInt1 = i;
      if (n != 1073741824) {
        break label122;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      if ((m != paramInt2) || (k != paramInt1)) {
        this.dkU = true;
      }
      return;
      int j = (int)Math.ceil(Layout.getDesiredWidth(this.mText, this.mTextPaint)) + (getPaddingLeft() + getPaddingRight());
      paramInt1 = j;
      if (i1 != -2147483648) {
        break;
      }
      paramInt1 = Math.min(i, j);
      break;
      label122:
      i = this.mTextPaint.getFontMetricsInt(null) + (getPaddingTop() + getPaddingBottom());
      if (n == -2147483648) {
        paramInt2 = Math.min(paramInt2, i);
      } else {
        paramInt2 = i;
      }
    }
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      this.mGravity = paramInt;
      this.dkU = true;
      invalidate();
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    if ((this.mText == paramCharSequence) || ((paramCharSequence == null) && ("".equals(this.mText)))) {
      return;
    }
    this.mText = paramCharSequence;
    if (this.mText == null) {
      this.mText = "";
    }
    requestLayout();
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.o = ColorStateList.valueOf(paramInt);
    cnB();
  }
  
  public void setTextSize(float paramFloat)
  {
    setTextSize(2, paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.SimpleTextView
 * JD-Core Version:    0.7.0.1
 */