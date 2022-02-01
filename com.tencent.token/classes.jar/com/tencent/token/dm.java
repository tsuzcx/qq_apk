package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import java.lang.reflect.Method;

final class dm
  extends dl
{
  private static Method d;
  
  dm(Drawable paramDrawable)
  {
    super(paramDrawable);
    d();
  }
  
  dm(dk.a parama, Resources paramResources)
  {
    super(parama, paramResources);
    d();
  }
  
  private static void d()
  {
    if (d == null) {}
    try
    {
      d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
      return;
    }
    catch (Exception localException) {}
    return;
  }
  
  final dk.a b()
  {
    return new a(this.b);
  }
  
  protected final boolean c()
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      Drawable localDrawable = this.c;
      return ((localDrawable instanceof GradientDrawable)) || ((localDrawable instanceof DrawableContainer)) || ((localDrawable instanceof InsetDrawable)) || ((localDrawable instanceof RippleDrawable));
    }
    return false;
  }
  
  public final Rect getDirtyBounds()
  {
    return this.c.getDirtyBounds();
  }
  
  public final void getOutline(Outline paramOutline)
  {
    this.c.getOutline(paramOutline);
  }
  
  public final void setHotspot(float paramFloat1, float paramFloat2)
  {
    this.c.setHotspot(paramFloat1, paramFloat2);
  }
  
  public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    if (super.setState(paramArrayOfInt))
    {
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public final void setTint(int paramInt)
  {
    if (c())
    {
      super.setTint(paramInt);
      return;
    }
    this.c.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (c())
    {
      super.setTintList(paramColorStateList);
      return;
    }
    this.c.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (c())
    {
      super.setTintMode(paramMode);
      return;
    }
    this.c.setTintMode(paramMode);
  }
  
  static final class a
    extends dk.a
  {
    a(dk.a parama)
    {
      super();
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new dm(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dm
 * JD-Core Version:    0.7.0.1
 */