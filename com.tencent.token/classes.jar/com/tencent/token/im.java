package com.tencent.token;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

final class im
  extends il
{
  private jc f;
  private jc g;
  
  im(TextView paramTextView)
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
    ig localig = ig.a();
    paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, go.j.AppCompatTextHelper, paramInt, 0);
    if (paramAttributeSet.hasValue(go.j.AppCompatTextHelper_android_drawableStart)) {
      this.f = a(localContext, localig, paramAttributeSet.getResourceId(go.j.AppCompatTextHelper_android_drawableStart, 0));
    }
    if (paramAttributeSet.hasValue(go.j.AppCompatTextHelper_android_drawableEnd)) {
      this.g = a(localContext, localig, paramAttributeSet.getResourceId(go.j.AppCompatTextHelper_android_drawableEnd, 0));
    }
    paramAttributeSet.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.im
 * JD-Core Version:    0.7.0.1
 */