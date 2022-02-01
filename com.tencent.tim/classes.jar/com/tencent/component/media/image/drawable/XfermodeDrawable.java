package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.ShapeDrawable;

public class XfermodeDrawable
  extends DrawableContainer
{
  private XfermodeState mState;
  
  public XfermodeDrawable(Drawable paramDrawable)
  {
    this(paramDrawable, null);
  }
  
  public XfermodeDrawable(Drawable paramDrawable, Xfermode paramXfermode)
  {
    if (!support(paramDrawable)) {
      throw new RuntimeException("No xfermode support for " + paramDrawable.getClass().getSimpleName());
    }
    this.mState = new XfermodeState(paramDrawable, this, paramXfermode);
    setConstantState(this.mState);
  }
  
  private XfermodeDrawable(XfermodeState paramXfermodeState, Resources paramResources)
  {
    this.mState = paramXfermodeState;
    setConstantState(this.mState);
  }
  
  public static Drawable create(Drawable paramDrawable, Xfermode paramXfermode)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable;
      if (support(paramDrawable)) {
        localObject = new XfermodeDrawable(paramDrawable, paramXfermode);
      }
    }
    return localObject;
  }
  
  private static Paint obtainPaint(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      do
      {
        return null;
      } while ((paramDrawable instanceof XfermodeDrawable));
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getPaint();
      }
      if ((paramDrawable instanceof NinePatchDrawable)) {
        return ((NinePatchDrawable)paramDrawable).getPaint();
      }
      if ((paramDrawable instanceof ShapeDrawable)) {
        return ((ShapeDrawable)paramDrawable).getPaint();
      }
      if ((paramDrawable instanceof ImageDrawable)) {
        return ((ImageDrawable)paramDrawable).getPaint();
      }
    } while (!(paramDrawable instanceof DrawableContainer));
    return obtainPaint(((DrawableContainer)paramDrawable).getDrawable());
  }
  
  public static boolean support(Drawable paramDrawable)
  {
    return (paramDrawable == null) || (obtainPaint(paramDrawable) != null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = obtainPaint(this.mState.mDrawable);
    Xfermode localXfermode = this.mState.mXfermode;
    if ((localPaint != null) && (localPaint.getXfermode() != localXfermode)) {
      localPaint.setXfermode(localXfermode);
    }
    super.draw(paramCanvas);
  }
  
  public void setXfermode(Xfermode paramXfermode)
  {
    if (this.mState.mXfermode != paramXfermode)
    {
      this.mState.mXfermode = paramXfermode;
      invalidateSelf();
    }
  }
  
  static class XfermodeState
    extends DrawableContainer.ContainerState
  {
    Xfermode mXfermode;
    
    XfermodeState(Drawable paramDrawable, DrawableContainer paramDrawableContainer, Xfermode paramXfermode)
    {
      super(paramDrawableContainer);
      this.mXfermode = paramXfermode;
    }
    
    XfermodeState(XfermodeState paramXfermodeState, DrawableContainer paramDrawableContainer, Resources paramResources)
    {
      super(paramDrawableContainer, paramResources);
      this.mXfermode = paramXfermodeState.mXfermode;
    }
    
    public Drawable newDrawable()
    {
      return new XfermodeDrawable(this, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.XfermodeDrawable
 * JD-Core Version:    0.7.0.1
 */