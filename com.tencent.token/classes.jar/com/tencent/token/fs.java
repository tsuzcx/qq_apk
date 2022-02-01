package com.tencent.token;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class fs
{
  private static final c a = new c();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      a = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new a();
      return;
    }
  }
  
  public static Drawable a(CompoundButton paramCompoundButton)
  {
    return a.a(paramCompoundButton);
  }
  
  public static void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    a.a(paramCompoundButton, paramColorStateList);
  }
  
  public static void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    a.a(paramCompoundButton, paramMode);
  }
  
  static class a
    extends fs.c
  {
    public final void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
    {
      paramCompoundButton.setButtonTintList(paramColorStateList);
    }
    
    public final void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
    {
      paramCompoundButton.setButtonTintMode(paramMode);
    }
  }
  
  static final class b
    extends fs.a
  {
    public final Drawable a(CompoundButton paramCompoundButton)
    {
      return paramCompoundButton.getButtonDrawable();
    }
  }
  
  static class c
  {
    private static Field a;
    private static boolean b;
    
    public Drawable a(CompoundButton paramCompoundButton)
    {
      if (!b) {}
      try
      {
        Field localField = CompoundButton.class.getDeclaredField("mButtonDrawable");
        a = localField;
        localField.setAccessible(true);
        label23:
        b = true;
        localField = a;
        if (localField != null) {}
        try
        {
          paramCompoundButton = (Drawable)localField.get(paramCompoundButton);
          return paramCompoundButton;
        }
        catch (IllegalAccessException paramCompoundButton)
        {
          label46:
          break label46;
        }
        a = null;
        return null;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label23;
      }
    }
    
    public void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
    {
      if ((paramCompoundButton instanceof gc)) {
        ((gc)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
      }
    }
    
    public void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
    {
      if ((paramCompoundButton instanceof gc)) {
        ((gc)paramCompoundButton).setSupportButtonTintMode(paramMode);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fs
 * JD-Core Version:    0.7.0.1
 */