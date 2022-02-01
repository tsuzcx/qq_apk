package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;

public class SkinnableNinePatchDrawable
  extends Drawable
{
  private static final boolean a = true;
  private a b;
  private NinePatch c;
  private Rect d;
  private boolean e;
  private int f = 160;
  private int g;
  private int h;
  
  SkinnableNinePatchDrawable() {}
  
  public SkinnableNinePatchDrawable(Resources paramResources, Bitmap paramBitmap, byte[] paramArrayOfByte, Rect paramRect, String paramString)
  {
    this(new a(new NinePatch(paramBitmap, paramArrayOfByte, paramString), paramBitmap, paramRect), paramResources);
    this.b.f = this.f;
  }
  
  @Deprecated
  public SkinnableNinePatchDrawable(Bitmap paramBitmap, byte[] paramArrayOfByte, Rect paramRect, String paramString)
  {
    this(new a(new NinePatch(paramBitmap, paramArrayOfByte, paramString), paramBitmap, paramRect), null);
  }
  
  SkinnableNinePatchDrawable(a parama, Resources paramResources)
  {
    a(parama, paramResources);
  }
  
  private void a()
  {
    b();
    if (this.b.mImageSizeWhenOOM != null)
    {
      localObject = this.b.mImageSizeWhenOOM;
      this.g = BaseConstantState.scaleFromDensity(localObject[0], localObject[2], this.f);
      this.g = BaseConstantState.scaleFromDensity(localObject[1], localObject[2], this.f);
      this.d.set(0, 0, 0, 0);
      return;
    }
    int i = this.c.getDensity();
    int j = this.f;
    if (i == j)
    {
      this.g = this.c.getWidth();
      this.h = this.c.getHeight();
      return;
    }
    this.g = BaseConstantState.scaleFromDensity(this.c.getWidth(), i, j);
    this.h = BaseConstantState.scaleFromDensity(this.c.getHeight(), i, j);
    Rect localRect1 = this.d;
    Rect localRect2 = this.b.b;
    Object localObject = localRect1;
    if (localRect1 == localRect2)
    {
      localObject = new Rect(localRect2);
      this.d = ((Rect)localObject);
    }
    ((Rect)localObject).left = BaseConstantState.scaleFromDensity(localRect2.left, i, j);
    ((Rect)localObject).top = BaseConstantState.scaleFromDensity(localRect2.top, i, j);
    ((Rect)localObject).right = BaseConstantState.scaleFromDensity(localRect2.right, i, j);
    ((Rect)localObject).bottom = BaseConstantState.scaleFromDensity(localRect2.bottom, i, j);
  }
  
  private void a(a parama, Resources paramResources)
  {
    this.b = parama;
    this.c = parama.a;
    this.d = parama.b;
    if (paramResources != null) {}
    for (int i = paramResources.getDisplayMetrics().densityDpi;; i = parama.f)
    {
      this.f = i;
      if (true != parama.d) {
        setDither(parama.d);
      }
      if (this.c != null) {
        a();
      }
      return;
    }
  }
  
  private void b()
  {
    if (this.c != this.b.a)
    {
      this.c = this.b.a;
      this.d = this.b.b;
      if (this.b.mImageSizeWhenOOM != null)
      {
        localObject = this.b.mImageSizeWhenOOM;
        this.g = BaseConstantState.scaleFromDensity(localObject[0], localObject[2], this.f);
        this.g = BaseConstantState.scaleFromDensity(localObject[1], localObject[2], this.f);
        this.d.set(0, 0, 0, 0);
      }
    }
    else
    {
      return;
    }
    int i = this.c.getDensity();
    int j = this.f;
    if (i == j)
    {
      this.g = this.c.getWidth();
      this.h = this.c.getHeight();
      return;
    }
    this.g = BaseConstantState.scaleFromDensity(this.c.getWidth(), i, j);
    this.h = BaseConstantState.scaleFromDensity(this.c.getHeight(), i, j);
    Rect localRect1 = this.d;
    Rect localRect2 = this.b.b;
    Object localObject = localRect1;
    if (localRect1 == localRect2)
    {
      localObject = new Rect(localRect2);
      this.d = ((Rect)localObject);
    }
    ((Rect)localObject).left = BaseConstantState.scaleFromDensity(localRect2.left, i, j);
    ((Rect)localObject).top = BaseConstantState.scaleFromDensity(localRect2.top, i, j);
    ((Rect)localObject).right = BaseConstantState.scaleFromDensity(localRect2.right, i, j);
    ((Rect)localObject).bottom = BaseConstantState.scaleFromDensity(localRect2.bottom, i, j);
  }
  
  boolean a(Rect paramRect)
  {
    if (this.b.c == null) {
      return false;
    }
    paramRect.set(this.b.c);
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    b();
    if (this.b.mImageSizeWhenOOM != null) {}
    for (;;)
    {
      return;
      Rect localRect = getBounds();
      try
      {
        this.c.draw(paramCanvas, localRect, this.b.h);
        if (!this.b.hasProblem) {
          continue;
        }
        paramCanvas.drawRect(localRect, BaseConstantState.sColorPaint);
        paramCanvas.drawLine(localRect.left, localRect.top, localRect.right, localRect.bottom, BaseConstantState.sPaint);
        paramCanvas.drawLine(localRect.right, localRect.top, localRect.left, localRect.bottom, BaseConstantState.sPaint);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.b.g;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.b.e;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    this.b.e = super.getChangingConfigurations();
    return this.b;
  }
  
  public int getIntrinsicHeight()
  {
    b();
    return this.h;
  }
  
  public int getIntrinsicWidth()
  {
    b();
    return this.g;
  }
  
  public int getMinimumHeight()
  {
    b();
    return this.h;
  }
  
  public int getMinimumWidth()
  {
    b();
    return this.g;
  }
  
  public int getOpacity()
  {
    b();
    if ((this.c == null) || (this.c.hasAlpha()) || (this.b.h.getAlpha() < 255)) {
      return -3;
    }
    return -1;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    b();
    paramRect.set(this.d);
    return true;
  }
  
  public Paint getPaint()
  {
    return this.b.h;
  }
  
  public Region getTransparentRegion()
  {
    b();
    if (this.c == null) {
      return null;
    }
    return this.c.getTransparentRegion(getBounds());
  }
  
  public Drawable mutate()
  {
    return this;
  }
  
  public void setAlpha(int paramInt)
  {
    getPaint().setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    getPaint().setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    getPaint().setDither(paramBoolean);
  }
  
  public void setTargetDensity(int paramInt)
  {
    b();
    int i = paramInt;
    if (paramInt == 0) {
      i = 160;
    }
    this.f = i;
    if (this.c != null) {
      a();
    }
  }
  
  public void setTargetDensity(Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(DisplayMetrics paramDisplayMetrics)
  {
    b();
    this.f = paramDisplayMetrics.densityDpi;
    if (this.c != null) {
      a();
    }
  }
  
  static final class a
    extends BaseConstantState
  {
    NinePatch a;
    Rect b;
    Rect c;
    final boolean d;
    int e;
    int f = 160;
    Bitmap g;
    Paint h = new Paint();
    
    a(NinePatch paramNinePatch, Bitmap paramBitmap, Rect paramRect)
    {
      this(paramNinePatch, paramBitmap, paramRect, true);
    }
    
    a(NinePatch paramNinePatch, Bitmap paramBitmap, Rect paramRect, boolean paramBoolean)
    {
      this.g = paramBitmap;
      this.a = paramNinePatch;
      this.b = paramRect;
      this.d = paramBoolean;
    }
    
    a(a parama)
    {
      this.a = parama.a;
      this.b = parama.b;
      this.d = parama.d;
      this.e = parama.e;
      this.f = parama.f;
    }
    
    public int getChangingConfigurations()
    {
      return this.e;
    }
    
    public Drawable newDrawable()
    {
      return new SkinnableNinePatchDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new SkinnableNinePatchDrawable(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableNinePatchDrawable
 * JD-Core Version:    0.7.0.1
 */