package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

public final class if
{
  private final View a;
  private final ih b;
  private int c = -1;
  private jd d;
  private jd e;
  private jd f;
  
  public if(View paramView)
  {
    this.a = paramView;
    this.b = ih.a();
  }
  
  private boolean a(Drawable paramDrawable)
  {
    if (this.f == null) {
      this.f = new jd();
    }
    jd localjd = this.f;
    localjd.a();
    Object localObject = ex.m(this.a);
    if (localObject != null)
    {
      localjd.d = true;
      localjd.a = ((ColorStateList)localObject);
    }
    localObject = ex.n(this.a);
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
  
  private void b(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.d == null) {
        this.d = new jd();
      }
      jd localjd = this.d;
      localjd.a = paramColorStateList;
      localjd.d = true;
    }
    else
    {
      this.d = null;
    }
    d();
  }
  
  private boolean e()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      return this.d != null;
    }
    return i == 21;
  }
  
  public final void a()
  {
    this.c = -1;
    b(null);
    d();
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((ih)localObject).b(this.a.getContext(), paramInt);
    } else {
      localObject = null;
    }
    b((ColorStateList)localObject);
    d();
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    if (this.e == null) {
      this.e = new jd();
    }
    jd localjd = this.e;
    localjd.a = paramColorStateList;
    localjd.d = true;
    d();
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (this.e == null) {
      this.e = new jd();
    }
    jd localjd = this.e;
    localjd.b = paramMode;
    localjd.c = true;
    d();
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = jf.a(this.a.getContext(), paramAttributeSet, gp.j.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.f(gp.j.ViewBackgroundHelper_android_background))
      {
        this.c = paramAttributeSet.g(gp.j.ViewBackgroundHelper_android_background, -1);
        ColorStateList localColorStateList = this.b.b(this.a.getContext(), this.c);
        if (localColorStateList != null) {
          b(localColorStateList);
        }
      }
      if (paramAttributeSet.f(gp.j.ViewBackgroundHelper_backgroundTint)) {
        ex.a(this.a, paramAttributeSet.e(gp.j.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.f(gp.j.ViewBackgroundHelper_backgroundTintMode)) {
        ex.a(this.a, ir.a(paramAttributeSet.a(gp.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.a.recycle();
    }
  }
  
  public final ColorStateList b()
  {
    jd localjd = this.e;
    if (localjd != null) {
      return localjd.a;
    }
    return null;
  }
  
  public final PorterDuff.Mode c()
  {
    jd localjd = this.e;
    if (localjd != null) {
      return localjd.b;
    }
    return null;
  }
  
  public final void d()
  {
    Drawable localDrawable = this.a.getBackground();
    if (localDrawable != null)
    {
      if ((e()) && (a(localDrawable))) {
        return;
      }
      jd localjd = this.e;
      if (localjd != null)
      {
        ih.a(localDrawable, localjd, this.a.getDrawableState());
        return;
      }
      localjd = this.d;
      if (localjd != null) {
        ih.a(localDrawable, localjd, this.a.getDrawableState());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.if
 * JD-Core Version:    0.7.0.1
 */