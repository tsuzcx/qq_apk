package com.tencent.mobileqq.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.ShapeDrawable;
import com.tencent.theme.SkinnableBitmapDrawable;
import hid;

public class XfermodeDrawable
  extends DrawableContainer
{
  private hid a;
  
  public XfermodeDrawable(Drawable paramDrawable)
  {
    this(paramDrawable, null);
  }
  
  public XfermodeDrawable(Drawable paramDrawable, Xfermode paramXfermode)
  {
    if (!a(paramDrawable)) {
      throw new RuntimeException("No xfermode support for " + paramDrawable.getClass().getSimpleName());
    }
    this.a = new hid(paramDrawable, this, paramXfermode);
    a(this.a);
  }
  
  private XfermodeDrawable(hid paramhid, Resources paramResources)
  {
    this.a = paramhid;
    a(this.a);
  }
  
  private static Paint a(Drawable paramDrawable)
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
      if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)paramDrawable).getPaint();
      }
    } while (!(paramDrawable instanceof DrawableContainer));
    return a(((DrawableContainer)paramDrawable).a());
  }
  
  public static Drawable a(Drawable paramDrawable, Xfermode paramXfermode)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable;
      if (a(paramDrawable)) {
        localObject = new XfermodeDrawable(paramDrawable, paramXfermode);
      }
    }
    return localObject;
  }
  
  public static boolean a(Drawable paramDrawable)
  {
    return (paramDrawable == null) || (a(paramDrawable) != null);
  }
  
  public void a(Xfermode paramXfermode)
  {
    if (this.a.jdField_a_of_type_AndroidGraphicsXfermode != paramXfermode)
    {
      this.a.jdField_a_of_type_AndroidGraphicsXfermode = paramXfermode;
      invalidateSelf();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = a(this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    Xfermode localXfermode = this.a.jdField_a_of_type_AndroidGraphicsXfermode;
    if ((localPaint != null) && (localPaint.getXfermode() != localXfermode)) {
      localPaint.setXfermode(localXfermode);
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.XfermodeDrawable
 * JD-Core Version:    0.7.0.1
 */