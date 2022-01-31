package com.tencent.analysis;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.analysis.d.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;

public class a
{
  public static Context a;
  private static a b;
  private volatile boolean c = false;
  
  public static a a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a();
      }
      return b;
    }
    finally {}
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "-1";
    }
    for (;;)
    {
      return paramContext;
      Object localObject5 = null;
      AssetManager localAssetManager = paramContext.getAssets();
      Object localObject1 = localObject5;
      try
      {
        String str3 = paramContext.getSharedPreferences("analysis_sdk", 0).getString("key_channelpath", "");
        Object localObject3 = str3;
        localObject1 = localObject5;
        if (str3.equals("")) {
          localObject3 = "channel.ini";
        }
        if (localObject3 != null)
        {
          localObject1 = localObject5;
          localObject3 = localAssetManager.open((String)localObject3);
          localObject1 = localObject3;
        }
        try
        {
          localObject5 = new Properties();
          localObject1 = localObject3;
          ((Properties)localObject5).load((InputStream)localObject3);
          localObject1 = localObject3;
          localObject5 = ((Properties)localObject5).getProperty("CHANNEL", "-1");
          localObject1 = localObject5;
          paramContext = localObject1;
          if (localObject3 == null) {
            continue;
          }
          try
          {
            ((InputStream)localObject3).close();
            return localObject1;
          }
          catch (IOException localIOException1)
          {
            paramContext = "-1";
            str1 = localIOException1.toString();
          }
          if (!b.c) {
            continue;
          }
          Log.i("ApplicationManager", str1);
          return "-1";
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            String str1;
            String str2;
            Object localObject2 = localObject4;
            Object localObject4 = localException2;
          }
        }
        return "-1";
      }
      catch (Exception localException1)
      {
        str1 = null;
      }
      finally
      {
        try
        {
          paramContext.getSharedPreferences("analysis_sdk", 0).edit().putString("key_channelpath", "").commit();
          paramContext = "-1";
          localObject4 = localException1.toString();
          if (b.c) {
            Log.i("ApplicationManager", (String)localObject4);
          }
          if (str1 == null) {
            continue;
          }
          try
          {
            str1.close();
            return "-1";
          }
          catch (IOException localIOException2)
          {
            paramContext = "-1";
            str2 = localIOException2.toString();
          }
          if (!b.c) {
            continue;
          }
          Log.i("ApplicationManager", str2);
          return "-1";
        }
        finally
        {
          label226:
          break label226;
        }
        paramContext = finally;
        if (str2 != null) {}
        try
        {
          str2.close();
          throw paramContext;
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            localObject2 = localIOException3.toString();
            if (b.c) {
              Log.i("ApplicationManager", (String)localObject2);
            }
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      paramBundle = paramBundle.getString(PrismCenter.INIT_CHANNEL_PATH);
    } while ((paramBundle == null) || (paramBundle.equals("")));
    paramContext.getSharedPreferences("analysis_sdk", 0).edit().putString("key_channelpath", paramBundle).commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return;
      paramString1 = paramString1 + "#" + paramString2;
      try
      {
        paramString1 = com.tencent.analysis.d.a.c.b().b.c(paramString1.getBytes());
        paramContext.getSharedPreferences("analysis_sdk", 0).edit().putString("key_user", paramString1).commit();
        return;
      }
      catch (Exception paramContext)
      {
        paramContext = "setUserId error" + paramContext.toString();
      }
    } while (!b.c);
    Log.i("ApplicationManager", paramContext);
  }
  
  public static void a(Context paramContext, GL10 paramGL10)
  {
    if (paramGL10 == null) {}
    do
    {
      return;
      String str = paramGL10.glGetString(7937);
      paramGL10.glGetString(7936);
      paramGL10.glGetString(7938);
      paramGL10.glGetString(7939);
      try
      {
        paramGL10 = com.tencent.analysis.d.a.c.b().b.c(str.getBytes());
        paramContext.getSharedPreferences("analysis_sdk", 0).edit().putString("gpu_user", paramGL10).commit();
        return;
      }
      catch (Exception paramContext)
      {
        paramContext = "setUserId error" + paramContext.toString();
      }
    } while (!b.c);
    Log.i("ApplicationManager", paramContext);
  }
  
  public static void b()
  {
    b.b = System.currentTimeMillis();
    String str = "onPause SdkConfig.timeStemp is " + b.b;
    if (b.c) {
      Log.i("ApplicationManager", str);
    }
  }
  
  public final String b(Context paramContext)
  {
    if (!this.c) {
      throw new IllegalStateException("Function onResume() must be called before function getQimei() ");
    }
    if (paramContext == null) {
      return "UNKNOWN";
    }
    try
    {
      paramContext = paramContext.getSharedPreferences("analysis_sdk", 0).getString("key_qimei", "UNKNOWN");
      if (paramContext.equals("UNKNOWN")) {
        return "UNKNOWN";
      }
      paramContext = new String(com.tencent.analysis.d.a.c.b().b.a(com.tencent.analysis.d.a.b.a(paramContext)), "UTF-8");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = "getQimei Error :" + paramContext.toString();
      if (b.c) {
        Log.i("ApplicationManager", paramContext);
      }
    }
    return "UNKNOWN";
  }
  
  public final void c(Context paramContext)
  {
    this.c = true;
    if (paramContext != null) {
      a = paramContext.getApplicationContext();
    }
    Object localObject = "onResume currentTimeMillis is " + System.currentTimeMillis();
    if (b.c) {
      Log.i("ApplicationManager", (String)localObject);
    }
    localObject = "onResume SdkConfig.timeStemp is " + b.b;
    if (b.c) {
      Log.i("ApplicationManager", (String)localObject);
    }
    localObject = "onResume time space  is " + (System.currentTimeMillis() - b.b);
    if (b.c) {
      Log.i("ApplicationManager", (String)localObject);
    }
    if (System.currentTimeMillis() - b.b > b.a)
    {
      if (b.c) {
        Log.i("ApplicationManager", "startShakeHands ");
      }
      localObject = new com.tencent.analysis.c.b.a();
      com.tencent.analysis.c.a.a.a().a((com.tencent.analysis.c.a.c)localObject);
      if ((paramContext == null) || (!paramContext.getSharedPreferences("analysis_sdk", 0).getString("key_resolution", "").equals(""))) {}
    }
    try
    {
      localObject = new DisplayMetrics();
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      localObject = ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels;
      paramContext.getSharedPreferences("analysis_sdk", 0).edit().putString("key_resolution", (String)localObject).commit();
      return;
    }
    catch (Exception paramContext)
    {
      do
      {
        paramContext = paramContext.toString();
      } while (!b.c);
      Log.i("ApplicationManager", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.a
 * JD-Core Version:    0.7.0.1
 */