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
import java.net.HttpURLConnection;
import java.net.URL;

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
      paramFloat = 160.0F * paramFloat;
      localOptions.inDensity = ((int)paramFloat);
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      if (paramString != null) {
        paramString.setDensity((int)paramFloat);
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
      localOptions.inDensity = ((int)(160.0F * paramFloat));
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    }
    
    public static int fromDPToPix(Context paramContext, float paramFloat)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return Math.round(localDisplayMetrics.densityDpi * paramFloat / 160.0F);
    }
    
    public static Bitmap getBitmapFromURL(String paramString)
    {
      try
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "get bitmap from url:" + paramString);
        paramString = (HttpURLConnection)new URL(paramString).openConnection();
        paramString.setDoInput(true);
        paramString.connect();
        paramString = paramString.getInputStream();
        Bitmap localBitmap = decodeStream(paramString);
        paramString.close();
        return localBitmap;
      }
      catch (IOException paramString)
      {
        paramString = paramString;
        Log.e("MicroMsg.SDK.BackwardSupportUtil", "get bitmap from url failed");
        paramString.printStackTrace();
        return null;
      }
      finally {}
    }
    
    public static String getDisplayDensityType(Context paramContext)
    {
      Object localObject = paramContext.getResources().getDisplayMetrics();
      Configuration localConfiguration = paramContext.getResources().getConfiguration();
      if (((DisplayMetrics)localObject).density < 1.0F)
      {
        paramContext = "" + "LDPI";
        localObject = new StringBuilder().append(paramContext);
        if (localConfiguration.orientation != 2) {
          break label136;
        }
      }
      label136:
      for (paramContext = "_L";; paramContext = "_P")
      {
        return paramContext;
        if (((DisplayMetrics)localObject).density >= 1.5F)
        {
          paramContext = "" + "HDPI";
          break;
        }
        paramContext = "" + "MDPI";
        break;
      }
    }
  }
  
  public static class ExifHelper
  {
    public static int getExifOrientation(String paramString)
    {
      try
      {
        paramString = new ExifInterface(paramString);
        int i;
        if (paramString != null)
        {
          i = paramString.getAttributeInt("Orientation", -1);
          if (i == -1) {}
        }
        switch (i)
        {
        case 4: 
        case 5: 
        case 7: 
        default: 
          return 0;
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BackwardSupportUtil", "cannot read exif" + paramString);
          paramString = null;
        }
        return 90;
      }
      return 180;
      return 270;
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