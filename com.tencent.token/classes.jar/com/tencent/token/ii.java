package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class ii
{
  private final ImageView a;
  private jc b;
  private jc c;
  private jc d;
  
  public ii(ImageView paramImageView)
  {
    this.a = paramImageView;
  }
  
  private boolean a(Drawable paramDrawable)
  {
    if (this.d == null) {
      this.d = new jc();
    }
    jc localjc = this.d;
    localjc.a();
    Object localObject = ft.a(this.a);
    if (localObject != null)
    {
      localjc.d = true;
      localjc.a = ((ColorStateList)localObject);
    }
    localObject = ft.b(this.a);
    if (localObject != null)
    {
      localjc.c = true;
      localjc.b = ((PorterDuff.Mode)localObject);
    }
    if ((!localjc.d) && (!localjc.c)) {
      return false;
    }
    ig.a(paramDrawable, localjc, this.a.getDrawableState());
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
      Drawable localDrawable = gq.b(this.a.getContext(), paramInt);
      if (localDrawable != null) {
        iq.b(localDrawable);
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
      this.c = new jc();
    }
    jc localjc = this.c;
    localjc.a = paramColorStateList;
    localjc.d = true;
    d();
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (this.c == null) {
      this.c = new jc();
    }
    jc localjc = this.c;
    localjc.b = paramMode;
    localjc.c = true;
    d();
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    je localje = je.a(this.a.getContext(), paramAttributeSet, go.j.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.a.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localje.g(go.j.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = gq.b(this.a.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.a.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        iq.b(paramAttributeSet);
      }
      if (localje.f(go.j.AppCompatImageView_tint)) {
        ft.a(this.a, localje.e(go.j.AppCompatImageView_tint));
      }
      if (localje.f(go.j.AppCompatImageView_tintMode)) {
        ft.a(this.a, iq.a(localje.a(go.j.AppCompatImageView_tintMode, -1), null));
      }
      return;
    }
    finally
    {
      localje.a.recycle();
    }
  }
  
  public final boolean a()
  {
    Drawable localDrawable = this.a.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  public final ColorStateList b()
  {
    jc localjc = this.c;
    if (localjc != null) {
      return localjc.a;
    }
    return null;
  }
  
  public final PorterDuff.Mode c()
  {
    jc localjc = this.c;
    if (localjc != null) {
      return localjc.b;
    }
    return null;
  }
  
  public final void d()
  {
    Drawable localDrawable = this.a.getDrawable();
    if (localDrawable != null) {
      iq.b(localDrawable);
    }
    if (localDrawable != null)
    {
      if ((e()) && (a(localDrawable))) {
        return;
      }
      jc localjc = this.c;
      if (localjc != null)
      {
        ig.a(localDrawable, localjc, this.a.getDrawableState());
        return;
      }
      localjc = this.b;
      if (localjc != null) {
        ig.a(localDrawable, localjc, this.a.getDrawableState());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ii
 * JD-Core Version:    0.7.0.1
 */