package com.idlefish.flutterboost;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Utils
{
  public static void assertCallOnMainThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      Debuger.exception("must call method on main thread");
    }
  }
  
  public static boolean checkImageValid(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return false;
    }
    int m = paramBitmap.getWidth();
    int n = paramBitmap.getHeight();
    Object localObject = new int[m * n];
    paramBitmap.getPixels((int[])localObject, 0, m, 0, 0, m, n);
    paramBitmap = new int[18];
    int i = 0;
    int j;
    while (i < 5)
    {
      int i1 = 4 - i % 2;
      for (j = 0; j < i1; j = k)
      {
        int i2 = i + 1;
        int i3 = i2 / 2;
        int i4 = n / 6;
        k = j + 1;
        paramBitmap[(j + i * 3 + i3)] = localObject[(i2 * i4 * m + m / (i1 + 1) * k)];
      }
      i += 1;
    }
    i = paramBitmap.length;
    localObject = (float[][])Array.newInstance(Float.TYPE, new int[] { i, 3 });
    i = 0;
    while (i < paramBitmap.length)
    {
      j = paramBitmap[i];
      Color.RGBToHSV((0xFF0000 & j) >> 16, (0xFF00 & j) >> 8, j & 0xFF, localObject[i]);
      i += 1;
    }
    i = 0;
    int k = 0;
    while (i < paramBitmap.length)
    {
      j = i + 1;
      m = j;
      while (m < paramBitmap.length)
      {
        n = k;
        if (Math.sqrt(Math.pow(localObject[i][0] - localObject[m][0], 2.0D) + Math.pow(localObject[i][1] - localObject[m][1], 2.0D) + Math.pow(localObject[i][2] - localObject[m][2], 2.0D)) >= 1.0D) {
          n = k + 1;
        }
        m += 1;
        k = n;
      }
      i = j;
    }
    return k > 10;
  }
  
  public static void fixInputMethodManagerLeak(Context paramContext)
  {
    if (paramContext == null) {}
    label117:
    label122:
    for (;;)
    {
      return;
      InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        String[] arrayOfString = new String[3];
        arrayOfString[0] = "mLastSrvView";
        arrayOfString[1] = "mServedView";
        arrayOfString[2] = "mNextServedView";
        int i = 0;
        for (;;)
        {
          for (;;)
          {
            if (i >= arrayOfString.length) {
              break label122;
            }
            Object localObject1 = arrayOfString[i];
            try
            {
              localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
              if (!((Field)localObject1).isAccessible()) {
                ((Field)localObject1).setAccessible(true);
              }
              Object localObject2 = ((Field)localObject1).get(localInputMethodManager);
              if ((localObject2 != null) && ((localObject2 instanceof View)))
              {
                if (((View)localObject2).getContext() != paramContext) {
                  break;
                }
                ((Field)localObject1).set(localInputMethodManager, null);
              }
            }
            catch (Throwable localThrowable)
            {
              break label117;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public static String getMIUISystemVersion()
  {
    // Byte code:
    //   0: new 138	java/io/BufferedReader
    //   3: dup
    //   4: new 140	java/io/InputStreamReader
    //   7: dup
    //   8: invokestatic 146	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   11: ldc 148
    //   13: invokevirtual 152	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   16: invokevirtual 158	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   19: invokespecial 161	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: sipush 1024
    //   25: invokespecial 164	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 167	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_1
    //   34: aload_0
    //   35: invokevirtual 170	java/io/BufferedReader:close	()V
    //   38: aload_0
    //   39: invokevirtual 170	java/io/BufferedReader:close	()V
    //   42: aload_1
    //   43: areturn
    //   44: astore_1
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokevirtual 170	java/io/BufferedReader:close	()V
    //   53: aconst_null
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: ifnull +7 -> 66
    //   62: aload_0
    //   63: invokevirtual 170	java/io/BufferedReader:close	()V
    //   66: aload_1
    //   67: athrow
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_0
    //   71: goto -26 -> 45
    //   74: astore_0
    //   75: aload_1
    //   76: areturn
    //   77: astore_0
    //   78: goto -12 -> 66
    //   81: astore_0
    //   82: goto -29 -> 53
    //   85: astore_1
    //   86: goto -28 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   28	35	0	localBufferedReader	java.io.BufferedReader
    //   68	1	0	localIOException1	java.io.IOException
    //   70	1	0	localObject1	Object
    //   74	1	0	localIOException2	java.io.IOException
    //   77	1	0	localIOException3	java.io.IOException
    //   81	1	0	localIOException4	java.io.IOException
    //   33	10	1	str1	String
    //   44	1	1	localIOException5	java.io.IOException
    //   55	21	1	str2	String
    //   85	1	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	38	44	java/io/IOException
    //   0	29	55	finally
    //   0	29	68	java/io/IOException
    //   38	42	74	java/io/IOException
    //   62	66	77	java/io/IOException
    //   49	53	81	java/io/IOException
    //   29	38	85	finally
  }
  
  public static int getMetricsHeight(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
      if (localWindowManager != null)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        if ((localDisplayMetrics.widthPixels > 0) && (localDisplayMetrics.heightPixels > 0)) {
          return localDisplayMetrics.heightPixels;
        }
      }
    }
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getMetricsWidth(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
      if (localWindowManager != null)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        if ((localDisplayMetrics.widthPixels > 0) && (localDisplayMetrics.heightPixels > 0)) {
          return localDisplayMetrics.widthPixels;
        }
      }
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static boolean isCurrentMIUIVersionBiggerAndEqual(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int j = Integer.parseInt(paramString.substring(1));
    paramString = getMIUISystemVersion();
    int i;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() > 1))
    {
      i = Integer.parseInt(paramString.substring(1));
      if ((i == 0) || (j == 0) || (i < j)) {
        break label68;
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label68:
      bool = false;
    }
  }
  
  public static void saveBitmap(Bitmap paramBitmap, File paramFile, String paramString)
  {
    try
    {
      paramString = new File(paramFile, paramString);
      if (!paramFile.exists())
      {
        if (!paramFile.mkdirs()) {
          break label113;
        }
        if (!paramString.createNewFile()) {}
      }
      else
      {
        paramFile = new FileOutputStream(paramString);
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramFile);
        paramFile.flush();
        paramFile.close();
        paramBitmap = new StringBuilder();
        paramBitmap.append("saved bitmap:");
        paramBitmap.append(paramString.getAbsolutePath());
        Debuger.exception(paramBitmap.toString());
        return;
      }
      throw new Exception("createNewFile except");
    }
    catch (Throwable paramBitmap)
    {
      throw new RuntimeException(paramBitmap);
    }
    label113:
    throw new Exception("mkdir except");
  }
  
  private static void setMIUISetStatusBarLightMode(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      if ((isCurrentMIUIVersionBiggerAndEqual("V9")) && (Build.VERSION.SDK_INT >= 23))
      {
        Log.e("ImmerseTheme", "setMIUISetStatusBarLightMode MIUI > 9");
        if (paramBoolean)
        {
          paramActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
          return;
        }
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      Debuger.exception(paramActivity);
      return;
    }
    if (paramActivity.getWindow() != null)
    {
      Log.e("ImmerseTheme", "setMIUISetStatusBarLightMode MIUI < 9");
      paramActivity = paramActivity.getWindow();
      Object localObject = paramActivity.getClass();
      Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
      int i = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
      localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
      if (paramBoolean)
      {
        ((Method)localObject).invoke(paramActivity, new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
        return;
      }
      ((Method)localObject).invoke(paramActivity, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
    }
  }
  
  public static void setStatusBarLightMode(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      Object localObject2 = Build.MANUFACTURER;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "unknow";
      }
      localObject1 = ((String)localObject1).toLowerCase();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("current MANUFACTURER=");
      ((StringBuilder)localObject2).append((String)localObject1);
      Log.e("ImmerseTheme", ((StringBuilder)localObject2).toString());
      if ((((String)localObject1).contains("xiaomi")) || (((String)localObject1).contains("redmi")))
      {
        setMIUISetStatusBarLightMode(paramActivity, paramBoolean);
        return;
      }
      if (((String)localObject1).contains("meizu"))
      {
        StatusbarColorUtils.setStatusBarDarkIcon(paramActivity, true);
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      Debuger.exception(paramActivity);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      Log.e("ImmerseTheme", "setStatusBarLightMode");
      if (paramBoolean)
      {
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        return;
      }
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.Utils
 * JD-Core Version:    0.7.0.1
 */