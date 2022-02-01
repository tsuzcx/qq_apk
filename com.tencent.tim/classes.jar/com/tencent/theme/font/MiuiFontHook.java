package com.tencent.theme.font;

import java.lang.reflect.Field;
import java.util.HashSet;

public class MiuiFontHook
  implements IFontHook
{
  private static boolean a = false;
  private static HashSet<String> b;
  
  private HashSet<String> a()
  {
    try
    {
      localField1 = Class.forName("miui.util.TypefaceUtils$FontsWhiteListHolder").getDeclaredField("mFontsWhiteList");
      if (localField1 != null) {
        localField1.setAccessible(true);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          Field localField1;
          b = (HashSet)localField1.get(null);
          if (b == null)
          {
            b = new HashSet();
            localField1.set(null, b);
          }
          return b;
          localException1 = localException1;
          try
          {
            Field localField2 = Class.forName("miui.util.TypefaceUtils").getDeclaredField("mFontsWhiteList");
          }
          catch (Exception localException2)
          {
            Object localObject = null;
          }
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          localException3.printStackTrace();
        }
      }
    }
  }
  
  public boolean hookFont()
  {
    if (a) {
      return false;
    }
    if (b == null) {
      a();
    }
    if ((b != null) && (b.contains("com.tencent.mobileqq"))) {
      b.remove("com.tencent.mobileqq");
    }
    a = true;
    return a;
  }
  
  public boolean restore()
  {
    boolean bool = false;
    if (a) {}
    try
    {
      if (b != null) {
        b.add("com.tencent.mobileqq");
      }
      a = false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if (!a) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.theme.font.MiuiFontHook
 * JD-Core Version:    0.7.0.1
 */