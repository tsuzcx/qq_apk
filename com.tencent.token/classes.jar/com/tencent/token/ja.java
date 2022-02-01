package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class ja
{
  private final ImageView a;
  private ju b;
  private ju c;
  private ju d;
  
  public ja(ImageView paramImageView)
  {
    this.a = paramImageView;
  }
  
  private boolean a(Drawable paramDrawable)
  {
    if (this.d == null) {
      this.d = new ju();
    }
    ju localju = this.d;
    localju.a();
    Object localObject = gl.a(this.a);
    if (localObject != null)
    {
      localju.d = true;
      localju.a = ((ColorStateList)localObject);
    }
    localObject = gl.b(this.a);
    if (localObject != null)
    {
      localju.c = true;
      localju.b = ((PorterDuff.Mode)localObject);
    }
    if ((!localju.d) && (!localju.c)) {
      return false;
    }
    iy.a(paramDrawable, localju, this.a.getDrawableState());
    return true;
  }
  
  private boolean e()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      return this.b != null;
    }
    return i == 21;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = hi.b(this.a.getContext(), paramInt);
      if (localDrawable != null) {
        ji.b(localDrawable);
      }
      this.a.setImageDrawable(localDrawable);
    }
    else
    {
      this.a.setImageDrawable(null);
    }
    d();
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    if (this.c == null) {
      this.c = new ju();
    }
    ju localju = this.c;
    localju.a = paramColorStateList;
    localju.d = true;
    d();
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (this.c == null) {
      this.c = new ju();
    }
    ju localju = this.c;
    localju.b = paramMode;
    localju.c = true;
    d();
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    jw localjw = jw.a(this.a.getContext(), paramAttributeSet, hg.j.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.a.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localjw.g(hg.j.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = hi.b(this.a.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.a.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        ji.b(paramAttributeSet);
      }
      if (localjw.f(hg.j.AppCompatImageView_tint)) {
        gl.a(this.a, localjw.e(hg.j.AppCompatImageView_tint));
      }
      if (localjw.f(hg.j.AppCompatImageView_tintMode)) {
        gl.a(this.a, ji.a(localjw.a(hg.j.AppCompatImageView_tintMode, -1), null));
      }
      return;
    }
    finally
    {
      localjw.a.recycle();
    }
  }
  
  public final boolean a()
  {
    Drawable localDrawable = this.a.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  public final ColorStateList b()
  {
    ju localju = this.c;
    if (localju != null) {
      return localju.a;
    }
    return null;
  }
  
  public final PorterDuff.Mode c()
  {
    ju localju = this.c;
    if (localju != null) {
      return localju.b;
    }
    return null;
  }
  
  public final void d()
  {
    Drawable localDrawable = this.a.getDrawable();
    if (localDrawable != null) {
      ji.b(localDrawable);
    }
    if (localDrawable != null)
    {
      if ((e()) && (a(localDrawable))) {
        return;
      }
      ju localju = this.c;
      if (localju != null)
      {
        iy.a(localDrawable, localju, this.a.getDrawableState());
        return;
      }
      localju = this.b;
      if (localju != null) {
        iy.a(localDrawable, localju, this.a.getDrawableState());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ja
 * JD-Core Version:    0.7.0.1
 */