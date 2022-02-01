package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

public final class jc
  extends jb
{
  public final SeekBar b;
  public Drawable c;
  private ColorStateList d = null;
  private PorterDuff.Mode e = null;
  private boolean f = false;
  private boolean g = false;
  
  public jc(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.b = paramSeekBar;
  }
  
  private void a()
  {
    if ((this.c != null) && ((this.f) || (this.g)))
    {
      this.c = dy.d(this.c.mutate());
      if (this.f) {
        dy.a(this.c, this.d);
      }
      if (this.g) {
        dy.a(this.c, this.e);
      }
      if (this.c.isStateful()) {
        this.c.setState(this.b.getDrawableState());
      }
    }
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = jw.a(this.b.getContext(), paramAttributeSet, hg.j.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable1 = paramAttributeSet.b(hg.j.AppCompatSeekBar_android_thumb);
    if (localDrawable1 != null) {
      this.b.setThumb(localDrawable1);
    }
    localDrawable1 = paramAttributeSet.a(hg.j.AppCompatSeekBar_tickMark);
    Drawable localDrawable2 = this.c;
    if (localDrawable2 != null) {
      localDrawable2.setCallback(null);
    }
    this.c = localDrawable1;
    if (localDrawable1 != null)
    {
      localDrawable1.setCallback(this.b);
      dy.b(localDrawable1, fo.c(this.b));
      if (localDrawable1.isStateful()) {
        localDrawable1.setState(this.b.getDrawableState());
      }
      a();
    }
    this.b.invalidate();
    if (paramAttributeSet.f(hg.j.AppCompatSeekBar_tickMarkTintMode))
    {
      this.e = ji.a(paramAttributeSet.a(hg.j.AppCompatSeekBar_tickMarkTintMode, -1), this.e);
      this.g = true;
    }
    if (paramAttributeSet.f(hg.j.AppCompatSeekBar_tickMarkTint))
    {
      this.d = paramAttributeSet.e(hg.j.AppCompatSeekBar_tickMarkTint);
      this.f = true;
    }
    paramAttributeSet.a.recycle();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jc
 * JD-Core Version:    0.7.0.1
 */