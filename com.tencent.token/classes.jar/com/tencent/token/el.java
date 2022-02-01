package com.tencent.token;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

public final class el
{
  static final b a = new b();
  private static Field b;
  private static boolean c;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new a();
      return;
    }
  }
  
  static void a(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    if (!c) {}
    try
    {
      localObject = LayoutInflater.class.getDeclaredField("mFactory2");
      b = (Field)localObject;
      ((Field)localObject).setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Object localObject;
      label26:
      break label26;
    }
    localObject = new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ");
    ((StringBuilder)localObject).append(LayoutInflater.class.getName());
    ((StringBuilder)localObject).append("; inflation may have unexpected results.");
    c = true;
    localObject = b;
    if (localObject != null) {}
    try
    {
      ((Field)localObject).set(paramLayoutInflater, paramFactory2);
      return;
    }
    catch (IllegalAccessException paramFactory2)
    {
      label72:
      break label72;
    }
    paramFactory2 = new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
    paramFactory2.append(paramLayoutInflater);
    paramFactory2.append("; inflation may have unexpected results.");
  }
  
  public static void b(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    a.a(paramLayoutInflater, paramFactory2);
  }
  
  static final class a
    extends el.b
  {
    public final void a(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
    {
      paramLayoutInflater.setFactory2(paramFactory2);
    }
  }
  
  static class b
  {
    public void a(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
    {
      paramLayoutInflater.setFactory2(paramFactory2);
      LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
      if ((localFactory instanceof LayoutInflater.Factory2))
      {
        el.a(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
        return;
      }
      el.a(paramLayoutInflater, paramFactory2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.el
 * JD-Core Version:    0.7.0.1
 */