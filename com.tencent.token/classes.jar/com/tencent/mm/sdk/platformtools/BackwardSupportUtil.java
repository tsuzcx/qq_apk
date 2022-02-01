package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ListView;
import java.io.IOException;
import java.io.InputStream;

public class BackwardSupportUtil
{
  public static final int ANDROID_API_LEVEL_16 = 16;
  
  public static class AnimationHelper
  {
    public static void cancelAnimation(View paramView, Animation paramAnimation)
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        new AnimationHelperImpl22().cancelAnimation(paramView, paramAnimation);
        return;
      }
      new AnimationHelperImpl21below().cancelAnimation(paramView, paramAnimation);
    }
    
    public static void overridePendingTransition(Activity paramActivity, int paramInt1, int paramInt2)
    {
      paramActivity.overridePendingTransition(paramInt1, paramInt2);
    }
    
    public static abstract interface IHelper
    {
      public abstract void cancelAnimation(View paramView, Animation paramAnimation);
    }
  }
  
  public static class BitmapFactory
  {
    public static Bitmap decodeFile(String paramString, float paramFloat)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      int i = (int)(paramFloat * 160.0F);
      localOptions.inDensity = i;
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      if (paramString != null) {
        paramString.setDensity(i);
      }
      return paramString;
    }
    
    public static Bitmap decodeStream(InputStream paramInputStream)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inDensity = 160;
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    }
    
    public static Bitmap decodeStream(InputStream paramInputStream, float paramFloat)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inDensity = ((int)(paramFloat * 160.0F));
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    }
    
    public static int fromDPToPix(Context paramContext, float paramFloat)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return Math.round(paramFloat * localDisplayMetrics.densityDpi / 160.0F);
    }
    
    /* Error */
    public static Bitmap getBitmapFromURL(String paramString)
    {
      // Byte code:
      //   0: new 88	java/lang/StringBuilder
      //   3: dup
      //   4: ldc 90
      //   6: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   9: astore_1
      //   10: aload_1
      //   11: aload_0
      //   12: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   15: pop
      //   16: ldc 99
      //   18: aload_1
      //   19: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   22: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   25: new 111	java/net/URL
      //   28: dup
      //   29: aload_0
      //   30: invokespecial 112	java/net/URL:<init>	(Ljava/lang/String;)V
      //   33: invokevirtual 116	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   36: checkcast 118	java/net/HttpURLConnection
      //   39: astore_0
      //   40: aload_0
      //   41: iconst_1
      //   42: invokevirtual 122	java/net/HttpURLConnection:setDoInput	(Z)V
      //   45: aload_0
      //   46: invokevirtual 125	java/net/HttpURLConnection:connect	()V
      //   49: aload_0
      //   50: invokevirtual 129	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   53: astore_0
      //   54: aload_0
      //   55: invokestatic 131	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
      //   58: astore_1
      //   59: aload_0
      //   60: invokevirtual 136	java/io/InputStream:close	()V
      //   63: aload_1
      //   64: areturn
      //   65: astore_0
      //   66: goto +17 -> 83
      //   69: astore_0
      //   70: ldc 99
      //   72: ldc 138
      //   74: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   77: aload_0
      //   78: invokevirtual 144	java/io/IOException:printStackTrace	()V
      //   81: aconst_null
      //   82: areturn
      //   83: aload_0
      //   84: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	85	0	paramString	String
      //   9	55	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   0	63	65	finally
      //   70	81	65	finally
      //   0	63	69	java/io/IOException
    }
    
    public static String getDisplayDensityType(Context paramContext)
    {
      Object localObject = paramContext.getResources().getDisplayMetrics();
      Configuration localConfiguration = paramContext.getResources().getConfiguration();
      if (((DisplayMetrics)localObject).density < 1.0F)
      {
        paramContext = new StringBuilder();
        paramContext.append("");
        localObject = "LDPI";
      }
      for (;;)
      {
        paramContext.append((String)localObject);
        paramContext = paramContext.toString();
        break;
        if (((DisplayMetrics)localObject).density >= 1.5F)
        {
          paramContext = new StringBuilder();
          paramContext.append("");
          localObject = "HDPI";
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("");
          localObject = "MDPI";
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      if (localConfiguration.orientation == 2) {
        paramContext = "_L";
      } else {
        paramContext = "_P";
      }
      ((StringBuilder)localObject).append(paramContext);
      return ((StringBuilder)localObject).toString();
    }
  }
  
  public static class ExifHelper
  {
    public static int getExifOrientation(String paramString)
    {
      try
      {
        paramString = new ExifInterface(paramString);
      }
      catch (IOException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder("cannot read exif");
        localStringBuilder.append(paramString);
        Log.e("MicroMsg.SDK.BackwardSupportUtil", localStringBuilder.toString());
        paramString = null;
      }
      if (paramString != null)
      {
        int i = paramString.getAttributeInt("Orientation", -1);
        if (i != -1) {
          if (i != 3)
          {
            if (i != 6)
            {
              if (i == 8) {
                return 270;
              }
            }
            else {
              return 90;
            }
          }
          else {
            return 180;
          }
        }
      }
      return 0;
    }
  }
  
  public static class SmoothScrollFactory
  {
    public static void scrollTo(ListView paramListView, int paramInt)
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        new SmoothScrollToPosition22().doScroll(paramListView, paramInt);
        return;
      }
      new SmoothScrollToPosition21below().doScroll(paramListView, paramInt);
    }
    
    public static void scrollToTop(ListView paramListView)
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        new SmoothScrollToPosition22().doScroll(paramListView);
        return;
      }
      new SmoothScrollToPosition21below().doScroll(paramListView);
    }
    
    public static abstract interface IScroll
    {
      public abstract void doScroll(ListView paramListView);
      
      public abstract void doScroll(ListView paramListView, int paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil
 * JD-Core Version:    0.7.0.1
 */