package com.tencent.token;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

final class iq
  extends ip
{
  private jg f;
  private jg g;
  
  iq(TextView paramTextView)
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
    ik localik = ik.a();
    paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, gs.j.AppCompatTextHelper, paramInt, 0);
    if (paramAttributeSet.hasValue(gs.j.AppCompatTextHelper_android_drawableStart)) {
      this.f = a(localContext, localik, paramAttributeSet.getResourceId(gs.j.AppCompatTextHelper_android_drawableStart, 0));
    }
    if (paramAttributeSet.hasValue(gs.j.AppCompatTextHelper_android_drawableEnd)) {
      this.g = a(localContext, localik, paramAttributeSet.getResourceId(gs.j.AppCompatTextHelper_android_drawableEnd, 0));
    }
    paramAttributeSet.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.iq
 * JD-Core Version:    0.7.0.1
 */