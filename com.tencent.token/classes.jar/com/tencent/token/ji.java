package com.tencent.token;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class ji
{
  public static final Rect a = new Rect();
  private static Class<?> b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      b = Class.forName("android.graphics.Insets");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return;
  }
  
  public static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
  
  public static Rect a(Drawable paramDrawable)
  {
    if (b != null)
    {
      Object localObject = paramDrawable;
      for (;;)
      {
        try
        {
          if ((paramDrawable instanceof ea)) {
            localObject = ((ea)paramDrawable).a();
          }
          paramDrawable = localObject.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(localObject, new Object[0]);
          if (paramDrawable == null) {
            continue;
          }
          localObject = new Rect();
          Field[] arrayOfField = b.getFields();
          int k = arrayOfField.length;
          j = 0;
          if (j >= k) {
            continue;
          }
          localField = arrayOfField[j];
          String str = localField.getName();
          i = str.hashCode();
          if (i != -1383228885)
          {
            if (i != 115029)
            {
              if (i != 3317767)
              {
                if ((i != 108511772) || (!str.equals("right"))) {
                  continue;
                }
                i = 2;
                continue;
              }
              if (!str.equals("left")) {
                continue;
              }
              i = 0;
              continue;
            }
            if (!str.equals("top")) {
              continue;
            }
            i = 1;
            continue;
          }
          if (!str.equals("bottom")) {
            continue;
          }
          i = 3;
        }
        catch (Exception paramDrawable)
        {
          int j;
          Field localField;
          continue;
          int i = -1;
          switch (i)
          {
          }
          continue;
        }
        ((Rect)localObject).bottom = localField.getInt(paramDrawable);
        continue;
        ((Rect)localObject).right = localField.getInt(paramDrawable);
        continue;
        ((Rect)localObject).top = localField.getInt(paramDrawable);
        continue;
        ((Rect)localObject).left = localField.getInt(paramDrawable);
        j += 1;
      }
      return localObject;
    }
    return a;
  }
  
  static void b(Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName())))
    {
      int[] arrayOfInt = paramDrawable.getState();
      if ((arrayOfInt != null) && (arrayOfInt.length != 0)) {
        paramDrawable.setState(js.h);
      } else {
        paramDrawable.setState(js.e);
      }
      paramDrawable.setState(arrayOfInt);
    }
  }
  
  public static boolean c(Drawable paramDrawable)
  {
    for (;;)
    {
      if ((Build.VERSION.SDK_INT < 15) && ((paramDrawable instanceof InsetDrawable))) {
        return false;
      }
      if ((Build.VERSION.SDK_INT < 15) && ((paramDrawable instanceof GradientDrawable))) {
        return false;
      }
      if ((Build.VERSION.SDK_INT < 17) && ((paramDrawable instanceof LayerDrawable))) {
        return false;
      }
      if ((paramDrawable instanceof DrawableContainer))
      {
        paramDrawable = paramDrawable.getConstantState();
        if (!(paramDrawable instanceof DrawableContainer.DrawableContainerState)) {
          break;
        }
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int j = paramDrawable.length;
        int i = 0;
        while (i < j)
        {
          if (!c(paramDrawable[i])) {
            return false;
          }
          i += 1;
        }
      }
      if ((paramDrawable instanceof ea))
      {
        paramDrawable = ((ea)paramDrawable).a();
      }
      else if ((paramDrawable instanceof hk))
      {
        paramDrawable = ((hk)paramDrawable).a;
      }
      else
      {
        if (!(paramDrawable instanceof ScaleDrawable)) {
          break;
        }
        paramDrawable = ((ScaleDrawable)paramDrawable).getDrawable();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ji
 * JD-Core Version:    0.7.0.1
 */