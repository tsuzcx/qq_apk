package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

public final class ii
{
  private final View a;
  private final ik b;
  private int c = -1;
  private jg d;
  private jg e;
  private jg f;
  
  public ii(View paramView)
  {
    this.a = paramView;
    this.b = ik.a();
  }
  
  private boolean a(Drawable paramDrawable)
  {
    if (this.f == null) {
      this.f = new jg();
    }
    jg localjg = this.f;
    localjg.a();
    Object localObject = fa.m(this.a);
    if (localObject != null)
    {
      localjg.d = true;
      localjg.a = ((ColorStateList)localObject);
    }
    localObject = fa.n(this.a);
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
  
  private void b(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.d == null) {
        this.d = new jg();
      }
      jg localjg = this.d;
      localjg.a = paramColorStateList;
      localjg.d = true;
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
      localObject = ((ik)localObject).b(this.a.getContext(), paramInt);
    } else {
      localObject = null;
    }
    b((ColorStateList)localObject);
    d();
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    if (this.e == null) {
      this.e = new jg();
    }
    jg localjg = this.e;
    localjg.a = paramColorStateList;
    localjg.d = true;
    d();
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (this.e == null) {
      this.e = new jg();
    }
    jg localjg = this.e;
    localjg.b = paramMode;
    localjg.c = true;
    d();
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = ji.a(this.a.getContext(), paramAttributeSet, gs.j.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.f(gs.j.ViewBackgroundHelper_android_background))
      {
        this.c = paramAttributeSet.g(gs.j.ViewBackgroundHelper_android_background, -1);
        ColorStateList localColorStateList = this.b.b(this.a.getContext(), this.c);
        if (localColorStateList != null) {
          b(localColorStateList);
        }
      }
      if (paramAttributeSet.f(gs.j.ViewBackgroundHelper_backgroundTint)) {
        fa.a(this.a, paramAttributeSet.e(gs.j.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.f(gs.j.ViewBackgroundHelper_backgroundTintMode)) {
        fa.a(this.a, iu.a(paramAttributeSet.a(gs.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
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
    jg localjg = this.e;
    if (localjg != null) {
      return localjg.a;
    }
    return null;
  }
  
  public final PorterDuff.Mode c()
  {
    jg localjg = this.e;
    if (localjg != null) {
      return localjg.b;
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
      jg localjg = this.e;
      if (localjg != null)
      {
        ik.a(localDrawable, localjg, this.a.getDrawableState());
        return;
      }
      localjg = this.d;
      if (localjg != null) {
        ik.a(localDrawable, localjg, this.a.getDrawableState());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ii
 * JD-Core Version:    0.7.0.1
 */