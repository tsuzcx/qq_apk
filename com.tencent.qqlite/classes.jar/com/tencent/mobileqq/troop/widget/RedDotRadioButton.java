package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RadioButton;

public class RedDotRadioButton
  extends RadioButton
{
  private static final int jdField_a_of_type_Int = 9;
  private static final int b = 2;
  private static final int c = 2;
  private float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int d = (int)(this.jdField_a_of_type_Float * 9.0F + 0.5D);
  
  public RedDotRadioButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedDotRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839370);
    }
    invalidate();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
      Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
      float f1 = Layout.getDesiredWidth(getText(), getPaint());
      float f2 = localFontMetrics.descent;
      float f3 = localFontMetrics.ascent;
      int j = getWidth();
      int i = getHeight();
      float f4 = j / 2;
      j = (int)Math.ceil(f1 / 2.0F + f4 - this.jdField_a_of_type_Float * 2.0F);
      i = (int)Math.ceil(i / 2 - (f2 - f3) / 2.0F - this.d + 4.0F * this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(j, i, this.d + j, this.d + i);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotRadioButton
 * JD-Core Version:    0.7.0.1
 */