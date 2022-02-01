package com.idlefish.flutterboost;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StatusbarColorUtils
{
  private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
  private static Method mSetStatusBarColorIcon;
  private static Method mSetStatusBarDarkIcon;
  private static Field mStatusBarColorFiled;
  
  static
  {
    try
    {
      mSetStatusBarColorIcon = Activity.class.getMethod("setStatusBarDarkIcon", new Class[] { Integer.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      try
      {
        mSetStatusBarDarkIcon = Activity.class.getMethod("setStatusBarDarkIcon", new Class[] { Boolean.TYPE });
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        try
        {
          for (;;)
          {
            mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("statusBarColor");
            try
            {
              SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
              return;
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              localIllegalAccessException.printStackTrace();
              return;
            }
            catch (NoSuchFieldException localNoSuchFieldException2)
            {
              localNoSuchFieldException2.printStackTrace();
            }
            localNoSuchMethodException1 = localNoSuchMethodException1;
            localNoSuchMethodException1.printStackTrace();
            continue;
            localNoSuchMethodException2 = localNoSuchMethodException2;
            localNoSuchMethodException2.printStackTrace();
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException1)
        {
          for (;;)
          {
            localNoSuchFieldException1.printStackTrace();
          }
        }
      }
    }
  }
  
  /* Error */
  private static boolean changeMeizuFlag(WindowManager.LayoutParams paramLayoutParams, java.lang.String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 82	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: aload_1
    //   5: invokevirtual 85	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   8: astore_1
    //   9: aload_1
    //   10: iconst_1
    //   11: invokevirtual 89	java/lang/reflect/Field:setAccessible	(Z)V
    //   14: aload_1
    //   15: aload_0
    //   16: invokevirtual 61	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   19: istore_3
    //   20: aload_0
    //   21: invokevirtual 82	java/lang/Object:getClass	()Ljava/lang/Class;
    //   24: ldc 91
    //   26: invokevirtual 85	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   29: astore_1
    //   30: aload_1
    //   31: iconst_1
    //   32: invokevirtual 89	java/lang/reflect/Field:setAccessible	(Z)V
    //   35: aload_1
    //   36: aload_0
    //   37: invokevirtual 61	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   40: istore 4
    //   42: iload_2
    //   43: ifeq +22 -> 65
    //   46: iload_3
    //   47: iload 4
    //   49: ior
    //   50: istore_3
    //   51: iload 4
    //   53: iload_3
    //   54: if_icmpeq +26 -> 80
    //   57: aload_1
    //   58: aload_0
    //   59: iload_3
    //   60: invokevirtual 95	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   63: iconst_1
    //   64: ireturn
    //   65: iload_3
    //   66: iconst_m1
    //   67: ixor
    //   68: iload 4
    //   70: iand
    //   71: istore_3
    //   72: goto -21 -> 51
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 96	java/lang/Throwable:printStackTrace	()V
    //   80: iconst_0
    //   81: ireturn
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 97	java/lang/IllegalArgumentException:printStackTrace	()V
    //   87: goto -7 -> 80
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 68	java/lang/IllegalAccessException:printStackTrace	()V
    //   95: goto -15 -> 80
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 67	java/lang/NoSuchFieldException:printStackTrace	()V
    //   103: goto -23 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramLayoutParams	WindowManager.LayoutParams
    //   0	106	1	paramString	java.lang.String
    //   0	106	2	paramBoolean	boolean
    //   19	53	3	i	int
    //   40	31	4	j	int
    // Exception table:
    //   from	to	target	type
    //   0	42	75	java/lang/Throwable
    //   57	63	75	java/lang/Throwable
    //   0	42	82	java/lang/IllegalArgumentException
    //   57	63	82	java/lang/IllegalArgumentException
    //   0	42	90	java/lang/IllegalAccessException
    //   57	63	90	java/lang/IllegalAccessException
    //   0	42	98	java/lang/NoSuchFieldException
    //   57	63	98	java/lang/NoSuchFieldException
  }
  
  public static boolean isBlackColor(int paramInt1, int paramInt2)
  {
    return toGrey(paramInt1) < paramInt2;
  }
  
  private static void setStatusBarColor(Window paramWindow, int paramInt)
  {
    WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
    if (mStatusBarColorFiled != null) {}
    try
    {
      if (mStatusBarColorFiled.getInt(localLayoutParams) != paramInt)
      {
        mStatusBarColorFiled.set(localLayoutParams, Integer.valueOf(paramInt));
        paramWindow.setAttributes(localLayoutParams);
      }
      return;
    }
    catch (IllegalAccessException paramWindow)
    {
      paramWindow.printStackTrace();
    }
  }
  
  public static void setStatusBarDarkIcon(Activity paramActivity, int paramInt)
  {
    if (mSetStatusBarColorIcon != null) {
      try
      {
        mSetStatusBarColorIcon.invoke(paramActivity, new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (InvocationTargetException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    boolean bool = isBlackColor(paramInt, 50);
    if (mStatusBarColorFiled != null)
    {
      setStatusBarDarkIcon(paramActivity, bool, bool);
      setStatusBarDarkIcon(paramActivity.getWindow(), paramInt);
      return;
    }
    setStatusBarDarkIcon(paramActivity, bool);
  }
  
  public static void setStatusBarDarkIcon(Activity paramActivity, boolean paramBoolean)
  {
    setStatusBarDarkIcon(paramActivity, paramBoolean, true);
  }
  
  private static void setStatusBarDarkIcon(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mSetStatusBarDarkIcon != null) {}
    while (!paramBoolean2) {
      try
      {
        mSetStatusBarDarkIcon.invoke(paramActivity, new Object[] { Boolean.valueOf(paramBoolean1) });
        return;
      }
      catch (InvocationTargetException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    setStatusBarDarkIcon(paramActivity.getWindow(), paramBoolean1);
  }
  
  private static void setStatusBarDarkIcon(View paramView, boolean paramBoolean)
  {
    int j = paramView.getSystemUiVisibility();
    if (paramBoolean) {}
    for (int i = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | j;; i = (SYSTEM_UI_FLAG_LIGHT_STATUS_BAR ^ 0xFFFFFFFF) & j)
    {
      if (i != j) {
        paramView.setSystemUiVisibility(i);
      }
      return;
    }
  }
  
  public static void setStatusBarDarkIcon(Window paramWindow, int paramInt)
  {
    try
    {
      setStatusBarColor(paramWindow, paramInt);
      if (Build.VERSION.SDK_INT > 22) {
        setStatusBarDarkIcon(paramWindow.getDecorView(), true);
      }
      return;
    }
    catch (Exception paramWindow)
    {
      paramWindow.printStackTrace();
    }
  }
  
  public static void setStatusBarDarkIcon(Window paramWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 23) {
      changeMeizuFlag(paramWindow.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", paramBoolean);
    }
    View localView;
    do
    {
      return;
      localView = paramWindow.getDecorView();
    } while (localView == null);
    setStatusBarDarkIcon(localView, paramBoolean);
    setStatusBarColor(paramWindow, 0);
  }
  
  public static int toGrey(int paramInt)
  {
    return ((0xFF0000 & paramInt) >> 16) * 38 + ((0xFF00 & paramInt) >> 8) * 75 + (paramInt & 0xFF) * 15 >> 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.StatusbarColorUtils
 * JD-Core Version:    0.7.0.1
 */