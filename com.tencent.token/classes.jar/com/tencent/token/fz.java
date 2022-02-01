package com.tencent.token;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class fz
{
  static final d a = new d();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      a = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new a();
      return;
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    a.a(paramPopupWindow, paramInt);
  }
  
  public static void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a.a(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    a.a(paramPopupWindow, paramBoolean);
  }
  
  static class a
    extends fz.d
  {
    public final void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  static class b
    extends fz.a
  {
    private static Field a;
    
    static
    {
      try
      {
        Field localField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
        a = localField;
        localField.setAccessible(true);
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException) {}
    }
    
    public void a(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      Field localField = a;
      if (localField != null) {}
      try
      {
        localField.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
        return;
      }
      catch (IllegalAccessException paramPopupWindow) {}
      return;
    }
  }
  
  static final class c
    extends fz.b
  {
    public final void a(PopupWindow paramPopupWindow, int paramInt)
    {
      paramPopupWindow.setWindowLayoutType(paramInt);
    }
    
    public final void a(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
    }
  }
  
  static class d
  {
    private static Method a;
    private static boolean b;
    
    public void a(PopupWindow paramPopupWindow, int paramInt)
    {
      if (!b) {}
      try
      {
        Method localMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
        a = localMethod;
        localMethod.setAccessible(true);
        label33:
        b = true;
        localMethod = a;
        if (localMethod != null) {}
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow) {}
        return;
      }
      catch (Exception localException)
      {
        break label33;
      }
    }
    
    public void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      int i = paramInt1;
      if ((en.a(paramInt3, fa.c(paramView)) & 0x7) == 5) {
        i = paramInt1 - (paramPopupWindow.getWidth() - paramView.getWidth());
      }
      paramPopupWindow.showAsDropDown(paramView, i, paramInt2);
    }
    
    public void a(PopupWindow paramPopupWindow, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fz
 * JD-Core Version:    0.7.0.1
 */