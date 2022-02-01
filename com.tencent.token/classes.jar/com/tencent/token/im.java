package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class im
{
  private final ImageView a;
  private jg b;
  private jg c;
  private jg d;
  
  public im(ImageView paramImageView)
  {
    this.a = paramImageView;
  }
  
  private boolean a(Drawable paramDrawable)
  {
    if (this.d == null) {
      this.d = new jg();
    }
    jg localjg = this.d;
    localjg.a();
    Object localObject = fx.a(this.a);
    if (localObject != null)
    {
      localjg.d = true;
      localjg.a = ((ColorStateList)localObject);
    }
    localObject = fx.b(this.a);
    if (localObject != null)
    {
      localjg.c = true;
      localjg.b = ((PorterDuff.Mode)localObject);
    }
    if ((!localjg.d) && (!localjg.c)) {
      return false;
    }
    ik.a(paramDrawable, localjg, this.a.getDrawableState());
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
      Drawable localDrawable = gu.b(this.a.getContext(), paramInt);
      if (localDrawable != null) {
        iu.b(localDrawable);
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
      this.c = new jg();
    }
    jg localjg = this.c;
    localjg.a = paramColorStateList;
    localjg.d = true;
    d();
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (this.c == null) {
      this.c = new jg();
    }
    jg localjg = this.c;
    localjg.b = paramMode;
    localjg.c = true;
    d();
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    ji localji = ji.a(this.a.getContext(), paramAttributeSet, gs.j.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.a.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localji.g(gs.j.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = gu.b(this.a.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.a.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        iu.b(paramAttributeSet);
      }
      if (localji.f(gs.j.AppCompatImageView_tint)) {
        fx.a(this.a, localji.e(gs.j.AppCompatImageView_tint));
      }
      if (localji.f(gs.j.AppCompatImageView_tintMode)) {
        fx.a(this.a, iu.a(localji.a(gs.j.AppCompatImageView_tintMode, -1), null));
      }
      return;
    }
    finally
    {
      localji.a.recycle();
    }
  }
  
  public final boolean a()
  {
    Drawable localDrawable = this.a.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  public final ColorStateList b()
  {
    jg localjg = this.c;
    if (localjg != null) {
      return localjg.a;
    }
    return null;
  }
  
  public final PorterDuff.Mode c()
  {
    jg localjg = this.c;
    if (localjg != null) {
      return localjg.b;
    }
    return null;
  }
  
  public final void d()
  {
    Drawable localDrawable = this.a.getDrawable();
    if (localDrawable != null) {
      iu.b(localDrawable);
    }
    if (localDrawable != null)
    {
      if ((e()) && (a(localDrawable))) {
        return;
      }
      jg localjg = this.c;
      if (localjg != null)
      {
        ik.a(localDrawable, localjg, this.a.getDrawableState());
        return;
      }
      localjg = this.b;
      if (localjg != null) {
        ik.a(localDrawable, localjg, this.a.getDrawableState());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.im
 * JD-Core Version:    0.7.0.1
 */