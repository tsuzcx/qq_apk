package com.tencent.token;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CompoundButton;

public final class ig
{
  public ColorStateList a = null;
  public PorterDuff.Mode b = null;
  private final CompoundButton c;
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  
  public ig(CompoundButton paramCompoundButton)
  {
    this.c = paramCompoundButton;
  }
  
  private void b()
  {
    Drawable localDrawable = fp.a(this.c);
    if ((localDrawable != null) && ((this.d) || (this.e)))
    {
      localDrawable = dh.d(localDrawable).mutate();
      if (this.d) {
        dh.a(localDrawable, this.a);
      }
      if (this.e) {
        dh.a(localDrawable, this.b);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.c.getDrawableState());
      }
      this.c.setButtonDrawable(localDrawable);
    }
  }
  
  public final int a(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = fp.a(this.c);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  public final void a()
  {
    if (this.f)
    {
      this.f = false;
      return;
    }
    this.f = true;
    b();
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    this.a = paramColorStateList;
    this.d = true;
    b();
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    this.b = paramMode;
    this.e = true;
    b();
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.c.getContext().obtainStyledAttributes(paramAttributeSet, gp.j.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(gp.j.CompoundButton_android_button))
      {
        paramInt = paramAttributeSet.getResourceId(gp.j.CompoundButton_android_button, 0);
        if (paramInt != 0) {
          this.c.setButtonDrawable(gr.b(this.c.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(gp.j.CompoundButton_buttonTint)) {
        fp.a(this.c, paramAttributeSet.getColorStateList(gp.j.CompoundButton_buttonTint));
      }
      if (paramAttributeSet.hasValue(gp.j.CompoundButton_buttonTintMode)) {
        fp.a(this.c, ir.a(paramAttributeSet.getInt(gp.j.CompoundButton_buttonTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ig
 * JD-Core Version:    0.7.0.1
 */