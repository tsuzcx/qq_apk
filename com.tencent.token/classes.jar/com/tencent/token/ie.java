package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

public final class ie
{
  private final View a;
  private final ig b;
  private int c = -1;
  private jc d;
  private jc e;
  private jc f;
  
  public ie(View paramView)
  {
    this.a = paramView;
    this.b = ig.a();
  }
  
  private boolean a(Drawable paramDrawable)
  {
    if (this.f == null) {
      this.f = new jc();
    }
    jc localjc = this.f;
    localjc.a();
    Object localObject = ew.m(this.a);
    if (localObject != null)
    {
      localjc.d = true;
      localjc.a = ((ColorStateList)localObject);
    }
    localObject = ew.n(this.a);
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
  
  private void b(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.d == null) {
        this.d = new jc();
      }
      jc localjc = this.d;
      localjc.a = paramColorStateList;
      localjc.d = true;
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
      localObject = ((ig)localObject).b(this.a.getContext(), paramInt);
    } else {
      localObject = null;
    }
    b((ColorStateList)localObject);
    d();
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    if (this.e == null) {
      this.e = new jc();
    }
    jc localjc = this.e;
    localjc.a = paramColorStateList;
    localjc.d = true;
    d();
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (this.e == null) {
      this.e = new jc();
    }
    jc localjc = this.e;
    localjc.b = paramMode;
    localjc.c = true;
    d();
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = je.a(this.a.getContext(), paramAttributeSet, go.j.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.f(go.j.ViewBackgroundHelper_android_background))
      {
        this.c = paramAttributeSet.g(go.j.ViewBackgroundHelper_android_background, -1);
        ColorStateList localColorStateList = this.b.b(this.a.getContext(), this.c);
        if (localColorStateList != null) {
          b(localColorStateList);
        }
      }
      if (paramAttributeSet.f(go.j.ViewBackgroundHelper_backgroundTint)) {
        ew.a(this.a, paramAttributeSet.e(go.j.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.f(go.j.ViewBackgroundHelper_backgroundTintMode)) {
        ew.a(this.a, iq.a(paramAttributeSet.a(go.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
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
    jc localjc = this.e;
    if (localjc != null) {
      return localjc.a;
    }
    return null;
  }
  
  public final PorterDuff.Mode c()
  {
    jc localjc = this.e;
    if (localjc != null) {
      return localjc.b;
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
      jc localjc = this.e;
      if (localjc != null)
      {
        ig.a(localDrawable, localjc, this.a.getDrawableState());
        return;
      }
      localjc = this.d;
      if (localjc != null) {
        ig.a(localDrawable, localjc, this.a.getDrawableState());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ie
 * JD-Core Version:    0.7.0.1
 */