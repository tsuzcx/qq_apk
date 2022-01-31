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
  private static final int jdField_a_of_type_Int = 9;
  private static String jdField_a_of_type_JavaLangString = "RedDotTextView";
  private static final int b = 2;
  private static final int c = 2;
  private float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  private int d = (int)(this.jdField_a_of_type_Float * 9.0F + 0.5D);
  
  public RedDotTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedDotTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839370);
      }
      String str = getText().toString();
      TextPaint localTextPaint = getPaint();
      localTextPaint.getTextBounds(str, 0, str.length(), this.jdField_a_of_type_AndroidGraphicsRect);
      float f1 = this.jdField_a_of_type_AndroidGraphicsRect.height();
      float f2 = Layout.getDesiredWidth(str, localTextPaint);
      int j = getWidth();
      int i = getHeight();
      float f3 = j / 2;
      j = (int)(f2 / 2.0F + f3 - this.jdField_a_of_type_Float * 2.0F);
      i = (int)(i / 2 - f1 / 2.0F - this.d + this.jdField_a_of_type_Float * 2.0F);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(j, i, this.d + j, this.d + i);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
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
    a(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RedDotTextView
 * JD-Core Version:    0.7.0.1
 */