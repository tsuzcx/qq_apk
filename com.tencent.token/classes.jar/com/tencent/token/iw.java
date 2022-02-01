package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

public final class iw
{
  private final View a;
  private final iy b;
  private int c = -1;
  private ju d;
  private ju e;
  private ju f;
  
  public iw(View paramView)
  {
    this.a = paramView;
    this.b = iy.a();
  }
  
  private boolean a(Drawable paramDrawable)
  {
    if (this.f == null) {
      this.f = new ju();
    }
    ju localju = this.f;
    localju.a();
    Object localObject = fo.m(this.a);
    if (localObject != null)
    {
      localju.d = true;
      localju.a = ((ColorStateList)localObject);
    }
    localObject = fo.n(this.a);
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
  
  private void b(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.d == null) {
        this.d = new ju();
      }
      ju localju = this.d;
      localju.a = paramColorStateList;
      localju.d = true;
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
      localObject = ((iy)localObject).b(this.a.getContext(), paramInt);
    } else {
      localObject = null;
    }
    b((ColorStateList)localObject);
    d();
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    if (this.e == null) {
      this.e = new ju();
    }
    ju localju = this.e;
    localju.a = paramColorStateList;
    localju.d = true;
    d();
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (this.e == null) {
      this.e = new ju();
    }
    ju localju = this.e;
    localju.b = paramMode;
    localju.c = true;
    d();
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = jw.a(this.a.getContext(), paramAttributeSet, hg.j.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.f(hg.j.ViewBackgroundHelper_android_background))
      {
        this.c = paramAttributeSet.g(hg.j.ViewBackgroundHelper_android_background, -1);
        ColorStateList localColorStateList = this.b.b(this.a.getContext(), this.c);
        if (localColorStateList != null) {
          b(localColorStateList);
        }
      }
      if (paramAttributeSet.f(hg.j.ViewBackgroundHelper_backgroundTint)) {
        fo.a(this.a, paramAttributeSet.e(hg.j.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.f(hg.j.ViewBackgroundHelper_backgroundTintMode)) {
        fo.a(this.a, ji.a(paramAttributeSet.a(hg.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
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
    ju localju = this.e;
    if (localju != null) {
      return localju.a;
    }
    return null;
  }
  
  public final PorterDuff.Mode c()
  {
    ju localju = this.e;
    if (localju != null) {
      return localju.b;
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
      ju localju = this.e;
      if (localju != null)
      {
        iy.a(localDrawable, localju, this.a.getDrawableState());
        return;
      }
      localju = this.d;
      if (localju != null) {
        iy.a(localDrawable, localju, this.a.getDrawableState());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.iw
 * JD-Core Version:    0.7.0.1
 */