package com.tencent.token;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class dn
  extends Drawable
  implements Drawable.Callback, dl, dm
{
  static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  a b;
  Drawable c;
  private int d;
  private PorterDuff.Mode e;
  private boolean f;
  private boolean g;
  
  dn(Drawable paramDrawable)
  {
    this.b = b();
    a(paramDrawable);
  }
  
  dn(a parama, Resources paramResources)
  {
    this.b = parama;
    parama = this.b;
    if ((parama != null) && (parama.b != null)) {
      a(this.b.b.newDrawable(paramResources));
    }
  }
  
  private boolean a(int[] paramArrayOfInt)
  {
    if (!c()) {
      return false;
    }
    ColorStateList localColorStateList = this.b.c;
    PorterDuff.Mode localMode = this.b.d;
    if ((localColorStateList != null) && (localMode != null))
    {
      int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
      if ((!this.f) || (i != this.d) || (localMode != this.e))
      {
        setColorFilter(i, localMode);
        this.d = i;
        this.e = localMode;
        this.f = true;
        return true;
      }
    }
    else
    {
      this.f = false;
      clearColorFilter();
    }
    return false;
  }
  
  public final Drawable a()
  {
    return this.c;
  }
  
  public final void a(Drawable paramDrawable)
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((Drawable)localObject).setCallback(null);
    }
    this.c = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      setVisible(paramDrawable.isVisible(), true);
      setState(paramDrawable.getState());
      setLevel(paramDrawable.getLevel());
      setBounds(paramDrawable.getBounds());
      localObject = this.b;
      if (localObject != null) {
        ((a)localObject).b = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
  }
  
  a b()
  {
    return new b(this.b);
  }
  
  protected boolean c()
  {
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.c.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    int j = super.getChangingConfigurations();
    a locala = this.b;
    int i;
    if (locala != null) {
      i = locala.getChangingConfigurations();
    } else {
      i = 0;
    }
    return j | i | this.c.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    a locala = this.b;
    if (locala != null)
    {
      int i;
      if (locala.b != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.b.a = getChangingConfigurations();
        return this.b;
      }
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.c.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return this.c.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.c.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.c.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.c.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.c.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.c.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    return this.c.getState();
  }
  
  public Region getTransparentRegion()
  {
    return this.c.getTransparentRegion();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    if (c())
    {
      localObject = this.b;
      if (localObject != null)
      {
        localObject = ((a)localObject).c;
        break label26;
      }
    }
    Object localObject = null;
    label26:
    return ((localObject != null) && (((ColorStateList)localObject).isStateful())) || (this.c.isStateful());
  }
  
  public void jumpToCurrentState()
  {
    this.c.jumpToCurrentState();
  }
  
  public Drawable mutate()
  {
    if ((!this.g) && (super.mutate() == this))
    {
      this.b = b();
      Object localObject = this.c;
      if (localObject != null) {
        ((Drawable)localObject).mutate();
      }
      a locala = this.b;
      if (locala != null)
      {
        localObject = this.c;
        if (localObject != null) {
          localObject = ((Drawable)localObject).getConstantState();
        } else {
          localObject = null;
        }
        locala.b = ((Drawable.ConstantState)localObject);
      }
      this.g = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.c;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return this.c.setLevel(paramInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.c.setAlpha(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    this.c.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.c.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.c.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.c.setFilterBitmap(paramBoolean);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    boolean bool = this.c.setState(paramArrayOfInt);
    return (a(paramArrayOfInt)) || (bool);
  }
  
  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.b.c = paramColorStateList;
    a(getState());
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.b.d = paramMode;
    a(getState());
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (super.setVisible(paramBoolean1, paramBoolean2)) || (this.c.setVisible(paramBoolean1, paramBoolean2));
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
  
  public static abstract class a
    extends Drawable.ConstantState
  {
    int a;
    Drawable.ConstantState b;
    ColorStateList c = null;
    PorterDuff.Mode d = dn.a;
    
    a(a parama)
    {
      if (parama != null)
      {
        this.a = parama.a;
        this.b = parama.b;
        this.c = parama.c;
        this.d = parama.d;
      }
    }
    
    public int getChangingConfigurations()
    {
      int j = this.a;
      Drawable.ConstantState localConstantState = this.b;
      int i;
      if (localConstantState != null) {
        i = localConstantState.getChangingConfigurations();
      } else {
        i = 0;
      }
      return j | i;
    }
    
    public Drawable newDrawable()
    {
      return newDrawable(null);
    }
    
    public abstract Drawable newDrawable(Resources paramResources);
  }
  
  static final class b
    extends dn.a
  {
    b(dn.a parama)
    {
      super();
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new dn(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dn
 * JD-Core Version:    0.7.0.1
 */