package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

public final class il
  extends ik
{
  public final SeekBar b;
  public Drawable c;
  private ColorStateList d = null;
  private PorterDuff.Mode e = null;
  private boolean f = false;
  private boolean g = false;
  
  public il(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.b = paramSeekBar;
  }
  
  private void a()
  {
    if ((this.c != null) && ((this.f) || (this.g)))
    {
      this.c = dh.d(this.c.mutate());
      if (this.f) {
        dh.a(this.c, this.d);
      }
      if (this.g) {
        dh.a(this.c, this.e);
      }
      if (this.c.isStateful()) {
        this.c.setState(this.b.getDrawableState());
      }
    }
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = jf.a(this.b.getContext(), paramAttributeSet, gp.j.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable1 = paramAttributeSet.b(gp.j.AppCompatSeekBar_android_thumb);
    if (localDrawable1 != null) {
      this.b.setThumb(localDrawable1);
    }
    localDrawable1 = paramAttributeSet.a(gp.j.AppCompatSeekBar_tickMark);
    Drawable localDrawable2 = this.c;
    if (localDrawable2 != null) {
      localDrawable2.setCallback(null);
    }
    this.c = localDrawable1;
    if (localDrawable1 != null)
    {
      localDrawable1.setCallback(this.b);
      dh.b(localDrawable1, ex.c(this.b));
      if (localDrawable1.isStateful()) {
        localDrawable1.setState(this.b.getDrawableState());
      }
      a();
    }
    this.b.invalidate();
    if (paramAttributeSet.f(gp.j.AppCompatSeekBar_tickMarkTintMode))
    {
      this.e = ir.a(paramAttributeSet.a(gp.j.AppCompatSeekBar_tickMarkTintMode, -1), this.e);
      this.g = true;
    }
    if (paramAttributeSet.f(gp.j.AppCompatSeekBar_tickMarkTint))
    {
      this.d = paramAttributeSet.e(gp.j.AppCompatSeekBar_tickMarkTint);
      this.f = true;
    }
    paramAttributeSet.a.recycle();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.il
 * JD-Core Version:    0.7.0.1
 */