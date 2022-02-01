package com.tencent.token;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CompoundButton;

public final class if
{
  public ColorStateList a = null;
  public PorterDuff.Mode b = null;
  private final CompoundButton c;
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  
  public if(CompoundButton paramCompoundButton)
  {
    this.c = paramCompoundButton;
  }
  
  private void b()
  {
    Drawable localDrawable = fo.a(this.c);
    if ((localDrawable != null) && ((this.d) || (this.e)))
    {
      localDrawable = dg.d(localDrawable).mutate();
      if (this.d) {
        dg.a(localDrawable, this.a);
      }
      if (this.e) {
        dg.a(localDrawable, this.b);
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
      Drawable localDrawable = fo.a(this.c);
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
    paramAttributeSet = this.c.getContext().obtainStyledAttributes(paramAttributeSet, go.j.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(go.j.CompoundButton_android_button))
      {
        paramInt = paramAttributeSet.getResourceId(go.j.CompoundButton_android_button, 0);
        if (paramInt != 0) {
          this.c.setButtonDrawable(gq.b(this.c.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(go.j.CompoundButton_buttonTint)) {
        fo.a(this.c, paramAttributeSet.getColorStateList(go.j.CompoundButton_buttonTint));
      }
      if (paramAttributeSet.hasValue(go.j.CompoundButton_buttonTintMode)) {
        fo.a(this.c, iq.a(paramAttributeSet.getInt(go.j.CompoundButton_buttonTintMode, -1), null));
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
 * Qualified Name:     com.tencent.token.if
 * JD-Core Version:    0.7.0.1
 */