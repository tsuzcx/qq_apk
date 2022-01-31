package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import etm;

public class EllipsizingTextView
  extends TextView
{
  private int jdField_a_of_type_Int = 0;
  private etm jdField_a_of_type_Etm;
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private etm a()
  {
    if (this.jdField_a_of_type_Etm == null) {
      this.jdField_a_of_type_Etm = new etm();
    }
    return this.jdField_a_of_type_Etm;
  }
  
  public int getLineCount()
  {
    return a().a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    String str = getText().toString();
    Object localObject = getPaint();
    ((TextPaint)localObject).setColor(getCurrentTextColor());
    ((TextPaint)localObject).drawableState = getDrawableState();
    localObject = a();
    ((etm)localObject).a(str, getPaint(), getMeasuredWidth(), getLineHeight(), this.jdField_a_of_type_Int);
    if (getEllipsize() == TextUtils.TruncateAt.END)
    {
      ((etm)localObject).a(paramCanvas, TextUtils.TruncateAt.END);
      return;
    }
    if (getEllipsize() == TextUtils.TruncateAt.MIDDLE)
    {
      ((etm)localObject).a(paramCanvas, TextUtils.TruncateAt.MIDDLE);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.EllipsizingTextView
 * JD-Core Version:    0.7.0.1
 */