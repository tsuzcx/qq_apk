package com.tencent.token;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

final class je
  extends jd
{
  private ju f;
  private ju g;
  
  je(TextView paramTextView)
  {
    super(paramTextView);
  }
  
  final void a()
  {
    super.a();
    if ((this.f != null) || (this.g != null))
    {
      Drawable[] arrayOfDrawable = this.a.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.f);
      a(arrayOfDrawable[2], this.g);
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    Context localContext = this.a.getContext();
    iy localiy = iy.a();
    paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, hg.j.AppCompatTextHelper, paramInt, 0);
    if (paramAttributeSet.hasValue(hg.j.AppCompatTextHelper_android_drawableStart)) {
      this.f = a(localContext, localiy, paramAttributeSet.getResourceId(hg.j.AppCompatTextHelper_android_drawableStart, 0));
    }
    if (paramAttributeSet.hasValue(hg.j.AppCompatTextHelper_android_drawableEnd)) {
      this.g = a(localContext, localiy, paramAttributeSet.getResourceId(hg.j.AppCompatTextHelper_android_drawableEnd, 0));
    }
    paramAttributeSet.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.je
 * JD-Core Version:    0.7.0.1
 */