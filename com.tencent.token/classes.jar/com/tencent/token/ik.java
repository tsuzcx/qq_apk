package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

public final class ik
  extends ij
{
  public final SeekBar b;
  public Drawable c;
  private ColorStateList d = null;
  private PorterDuff.Mode e = null;
  private boolean f = false;
  private boolean g = false;
  
  public ik(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.b = paramSeekBar;
  }
  
  private void a()
  {
    if ((this.c != null) && ((this.f) || (this.g)))
    {
      this.c = dg.d(this.c.mutate());
      if (this.f) {
        dg.a(this.c, this.d);
      }
      if (this.g) {
        dg.a(this.c, this.e);
      }
      if (this.c.isStateful()) {
        this.c.setState(this.b.getDrawableState());
      }
    }
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = je.a(this.b.getContext(), paramAttributeSet, go.j.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable1 = paramAttributeSet.b(go.j.AppCompatSeekBar_android_thumb);
    if (localDrawable1 != null) {
      this.b.setThumb(localDrawable1);
    }
    localDrawable1 = paramAttributeSet.a(go.j.AppCompatSeekBar_tickMark);
    Drawable localDrawable2 = this.c;
    if (localDrawable2 != null) {
      localDrawable2.setCallback(null);
    }
    this.c = localDrawable1;
    if (localDrawable1 != null)
    {
      localDrawable1.setCallback(this.b);
      dg.b(localDrawable1, ew.c(this.b));
      if (localDrawable1.isStateful()) {
        localDrawable1.setState(this.b.getDrawableState());
      }
      a();
    }
    this.b.invalidate();
    if (paramAttributeSet.f(go.j.AppCompatSeekBar_tickMarkTintMode))
    {
      this.e = iq.a(paramAttributeSet.a(go.j.AppCompatSeekBar_tickMarkTintMode, -1), this.e);
      this.g = true;
    }
    if (paramAttributeSet.f(go.j.AppCompatSeekBar_tickMarkTint))
    {
      this.d = paramAttributeSet.e(go.j.AppCompatSeekBar_tickMarkTint);
      this.f = true;
    }
    paramAttributeSet.a.recycle();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ik
 * JD-Core Version:    0.7.0.1
 */