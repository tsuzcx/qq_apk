package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class ij
{
  private final ImageView a;
  private jd b;
  private jd c;
  private jd d;
  
  public ij(ImageView paramImageView)
  {
    this.a = paramImageView;
  }
  
  private boolean a(Drawable paramDrawable)
  {
    if (this.d == null) {
      this.d = new jd();
    }
    jd localjd = this.d;
    localjd.a();
    Object localObject = fu.a(this.a);
    if (localObject != null)
    {
      localjd.d = true;
      localjd.a = ((ColorStateList)localObject);
    }
    localObject = fu.b(this.a);
    if (localObject != null)
    {
      localjd.c = true;
      localjd.b = ((PorterDuff.Mode)localObject);
    }
    if ((!localjd.d) && (!localjd.c)) {
      return false;
    }
    ih.a(paramDrawable, localjd, this.a.getDrawableState());
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
      Drawable localDrawable = gr.b(this.a.getContext(), paramInt);
      if (localDrawable != null) {
        ir.b(localDrawable);
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
      this.c = new jd();
    }
    jd localjd = this.c;
    localjd.a = paramColorStateList;
    localjd.d = true;
    d();
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (this.c == null) {
      this.c = new jd();
    }
    jd localjd = this.c;
    localjd.b = paramMode;
    localjd.c = true;
    d();
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    jf localjf = jf.a(this.a.getContext(), paramAttributeSet, gp.j.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.a.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localjf.g(gp.j.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = gr.b(this.a.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.a.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        ir.b(paramAttributeSet);
      }
      if (localjf.f(gp.j.AppCompatImageView_tint)) {
        fu.a(this.a, localjf.e(gp.j.AppCompatImageView_tint));
      }
      if (localjf.f(gp.j.AppCompatImageView_tintMode)) {
        fu.a(this.a, ir.a(localjf.a(gp.j.AppCompatImageView_tintMode, -1), null));
      }
      return;
    }
    finally
    {
      localjf.a.recycle();
    }
  }
  
  public final boolean a()
  {
    Drawable localDrawable = this.a.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  public final ColorStateList b()
  {
    jd localjd = this.c;
    if (localjd != null) {
      return localjd.a;
    }
    return null;
  }
  
  public final PorterDuff.Mode c()
  {
    jd localjd = this.c;
    if (localjd != null) {
      return localjd.b;
    }
    return null;
  }
  
  public final void d()
  {
    Drawable localDrawable = this.a.getDrawable();
    if (localDrawable != null) {
      ir.b(localDrawable);
    }
    if (localDrawable != null)
    {
      if ((e()) && (a(localDrawable))) {
        return;
      }
      jd localjd = this.c;
      if (localjd != null)
      {
        ih.a(localDrawable, localjd, this.a.getDrawableState());
        return;
      }
      localjd = this.b;
      if (localjd != null) {
        ih.a(localDrawable, localjd, this.a.getDrawableState());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ij
 * JD-Core Version:    0.7.0.1
 */