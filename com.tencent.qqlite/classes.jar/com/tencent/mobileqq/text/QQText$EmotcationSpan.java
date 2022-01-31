package com.tencent.mobileqq.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import java.lang.ref.WeakReference;

public class QQText$EmotcationSpan
  extends ReplacementSpan
{
  public static final int c = -2147483648;
  public int a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public boolean a;
  int b;
  
  public QQText$EmotcationSpan(QQText paramQQText, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int a()
  {
    return 0x7FFFFFFF & this.jdField_a_of_type_Int;
  }
  
  public Drawable a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    Drawable localDrawable = null;
    if (localObject != null) {
      localDrawable = (Drawable)((WeakReference)localObject).get();
    }
    localObject = localDrawable;
    if (localDrawable == null)
    {
      localObject = b();
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
    }
    return localObject;
  }
  
  protected Drawable b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      localDrawable = TextUtils.a(this.jdField_a_of_type_Int);
      localDrawable.setBounds(0, 0, this.b, this.b);
      return localDrawable;
    }
    if ((0x80000000 & this.jdField_a_of_type_Int) == 0)
    {
      localDrawable = TextUtils.a(this.jdField_a_of_type_Int, false);
      localDrawable.setBounds(0, 0, this.b, this.b);
      return localDrawable;
    }
    int i = 0x7FFFFFFF & this.jdField_a_of_type_Int;
    if (EmotcationConstants.a[i] == 2130837760 + i)
    {
      localDrawable = TextUtils.a(i, false);
      localDrawable.setBounds(0, 0, this.b, this.b);
      return localDrawable;
    }
    Drawable localDrawable = TextUtils.a(i, true);
    localDrawable.setBounds(0, 0, this.b, this.b);
    return localDrawable;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = a();
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt5 - this.b);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-this.b);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.EmotcationSpan
 * JD-Core Version:    0.7.0.1
 */