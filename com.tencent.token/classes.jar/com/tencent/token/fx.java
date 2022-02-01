package com.tencent.token;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

public final class fx
{
  static final b a = new a();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new c();
      return;
    }
  }
  
  public static ColorStateList a(ImageView paramImageView)
  {
    return a.a(paramImageView);
  }
  
  public static void a(ImageView paramImageView, ColorStateList paramColorStateList)
  {
    a.a(paramImageView, paramColorStateList);
  }
  
  public static void a(ImageView paramImageView, PorterDuff.Mode paramMode)
  {
    a.a(paramImageView, paramMode);
  }
  
  public static PorterDuff.Mode b(ImageView paramImageView)
  {
    return a.b(paramImageView);
  }
  
  static class a
    implements fx.b
  {
    public ColorStateList a(ImageView paramImageView)
    {
      if ((paramImageView instanceof gd)) {
        return ((gd)paramImageView).getSupportImageTintList();
      }
      return null;
    }
    
    public void a(ImageView paramImageView, ColorStateList paramColorStateList)
    {
      if ((paramImageView instanceof gd)) {
        ((gd)paramImageView).setSupportImageTintList(paramColorStateList);
      }
    }
    
    public void a(ImageView paramImageView, PorterDuff.Mode paramMode)
    {
      if ((paramImageView instanceof gd)) {
        ((gd)paramImageView).setSupportImageTintMode(paramMode);
      }
    }
    
    public PorterDuff.Mode b(ImageView paramImageView)
    {
      if ((paramImageView instanceof gd)) {
        return ((gd)paramImageView).getSupportImageTintMode();
      }
      return null;
    }
  }
  
  static abstract interface b
  {
    public abstract ColorStateList a(ImageView paramImageView);
    
    public abstract void a(ImageView paramImageView, ColorStateList paramColorStateList);
    
    public abstract void a(ImageView paramImageView, PorterDuff.Mode paramMode);
    
    public abstract PorterDuff.Mode b(ImageView paramImageView);
  }
  
  static final class c
    extends fx.a
  {
    public final ColorStateList a(ImageView paramImageView)
    {
      return paramImageView.getImageTintList();
    }
    
    public final void a(ImageView paramImageView, ColorStateList paramColorStateList)
    {
      paramImageView.setImageTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramImageView.getDrawable();
        int i;
        if ((paramImageView.getImageTintList() != null) && (paramImageView.getImageTintMode() != null)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramColorStateList);
        }
      }
    }
    
    public final void a(ImageView paramImageView, PorterDuff.Mode paramMode)
    {
      paramImageView.setImageTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramImageView.getDrawable();
        int i;
        if ((paramImageView.getImageTintList() != null) && (paramImageView.getImageTintMode() != null)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((paramMode != null) && (i != 0))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramMode);
        }
      }
    }
    
    public final PorterDuff.Mode b(ImageView paramImageView)
    {
      return paramImageView.getImageTintMode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fx
 * JD-Core Version:    0.7.0.1
 */