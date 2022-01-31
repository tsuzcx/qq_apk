package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackwardSupportUtil$BitmapFactory
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory
 * JD-Core Version:    0.7.0.1
 */