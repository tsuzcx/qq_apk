package com.tencent.viola.ui.dom.style;

import alla;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.utils.ViolaLogUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FlexConvertUtils
{
  public static String TAG = "FlexConvertUtils";
  private static String deviceid = "";
  private static int mScreenContentHeight;
  private static int mScreenHeight;
  private static int mScreenWidth;
  private static final boolean mUseWebPx = false;
  
  public static int converColor(String paramString)
  {
    return converColor(paramString, -2147483648);
  }
  
  public static int converColor(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramInt;
    }
    paramString.trim();
    return paramInt;
  }
  
  public static FlexPositionType converPosition(String paramString)
  {
    FlexPositionType localFlexPositionType = FlexPositionType.RELATIVE;
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("relative")) || (paramString.equals("sticky"))) {
      localFlexPositionType = FlexPositionType.RELATIVE;
    }
    while ((!paramString.equals("absolute")) && (!paramString.equals("fixed"))) {
      return localFlexPositionType;
    }
    return FlexPositionType.ABSOLUTE;
  }
  
  public static float converPxByViewportToRealPx(Object paramObject, int paramInt)
  {
    return getFloatByViewport(paramObject, paramInt);
  }
  
  public static int[] converStringArrayToIntArray(String paramString)
  {
    int[] arrayOfInt = new int[4];
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length == 4))
      {
        int i = 0;
        while (i < paramString.length)
        {
          arrayOfInt[i] = ((int)converPxByViewportToRealPx(paramString[i], 750));
          i += 1;
        }
      }
    }
    return arrayOfInt;
  }
  
  public static String[] converTransFormScaleToStringArray(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramString1 = paramString1.replace(paramString2, "").replace(paramString3, "");
    if (TextUtils.isEmpty(paramString4)) {
      return new String[] { paramString1 };
    }
    return paramString1.split(paramString4);
  }
  
  public static String[] converTransformOriginStringToStringArray(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString.trim();
    return paramString.split("\\s+");
  }
  
  public static FlexAlign convertAlignItem(String paramString)
  {
    FlexAlign localFlexAlign = FlexAlign.STRETCH;
    if (TextUtils.isEmpty(paramString)) {
      localFlexAlign = FlexAlign.STRETCH;
    }
    do
    {
      return localFlexAlign;
      if (paramString.equals("stretch")) {
        return FlexAlign.STRETCH;
      }
      if (paramString.equals("flex-start")) {
        return FlexAlign.FLEX_START;
      }
      if (paramString.equals("flex-end")) {
        return FlexAlign.FLEX_END;
      }
    } while (!paramString.equals("center"));
    return FlexAlign.CENTER;
  }
  
  public static FlexAlign convertAlignSelf(String paramString)
  {
    FlexAlign localFlexAlign = FlexAlign.AUTO;
    if (TextUtils.isEmpty(paramString)) {
      localFlexAlign = FlexAlign.AUTO;
    }
    do
    {
      return localFlexAlign;
      if (paramString.equals("flex-start")) {
        return FlexAlign.FLEX_START;
      }
      if (paramString.equals("flex-end")) {
        return FlexAlign.FLEX_END;
      }
      if (paramString.equals("stretch")) {
        return FlexAlign.STRETCH;
      }
    } while (!paramString.equals("center"));
    return FlexAlign.CENTER;
  }
  
  public static FlexDirection convertDirection(String paramString)
  {
    FlexDirection localFlexDirection = FlexDirection.COLUMN;
    if (TextUtils.isEmpty(paramString)) {
      localFlexDirection = FlexDirection.COLUMN;
    }
    do
    {
      return localFlexDirection;
      if (paramString.equals("column")) {
        return FlexDirection.COLUMN;
      }
      if (paramString.equals("column-reverse")) {
        return FlexDirection.COLUMN_REVERSE;
      }
      if (paramString.equals("row")) {
        return FlexDirection.ROW;
      }
    } while (!paramString.equals("row-reverse"));
    return FlexDirection.ROW_REVERSE;
  }
  
  public static ImageSpanAlign convertImageSpanAlign(String paramString)
  {
    ImageSpanAlign localImageSpanAlign = ImageSpanAlign.BASELINE;
    if (TextUtils.isEmpty(paramString)) {
      localImageSpanAlign = ImageSpanAlign.BASELINE;
    }
    do
    {
      return localImageSpanAlign;
      if (paramString.equals("top")) {
        return ImageSpanAlign.TOP;
      }
      if (paramString.equals("bottom")) {
        return ImageSpanAlign.BOTTOM;
      }
    } while (!paramString.equals("center"));
    return ImageSpanAlign.CENTER;
  }
  
  public static FlexJustifyContent convertJustifyContent(String paramString)
  {
    FlexJustifyContent localFlexJustifyContent = FlexJustifyContent.FLEX_START;
    if (TextUtils.isEmpty(paramString)) {
      localFlexJustifyContent = FlexJustifyContent.FLEX_START;
    }
    do
    {
      return localFlexJustifyContent;
      if (paramString.equals("flex-start")) {
        return FlexJustifyContent.FLEX_START;
      }
      if (paramString.equals("flex-end")) {
        return FlexJustifyContent.FLEX_END;
      }
      if (paramString.equals("center")) {
        return FlexJustifyContent.CENTER;
      }
      if (paramString.equals("space-between")) {
        return FlexJustifyContent.SPACE_BETWEEN;
      }
    } while (!paramString.equals("space-around"));
    return FlexJustifyContent.SPACE_AROUND;
  }
  
  public static FlexWrap convertWrap(String paramString)
  {
    FlexWrap localFlexWrap = FlexWrap.NOWRAP;
    if (TextUtils.isEmpty(paramString)) {
      localFlexWrap = FlexWrap.NOWRAP;
    }
    do
    {
      return localFlexWrap;
      if (paramString.equals("nowrap")) {
        return FlexWrap.NOWRAP;
      }
    } while (!paramString.equals("wrap"));
    return FlexWrap.WRAP;
  }
  
  public static int dip2px(float paramFloat)
  {
    try
    {
      f = ViolaEnvironment.getApplication().getResources().getDisplayMetrics().density;
      paramFloat = f * paramFloat + 0.5F;
      if ((paramFloat > 0.0F) && (paramFloat < 1.0F)) {
        return 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e(TAG, "Exception e:" + localException.getMessage());
        float f = 2.0F;
      }
    }
    return (int)paramFloat;
  }
  
  public static int dip2px(int paramInt)
  {
    float f;
    try
    {
      f = ViolaEnvironment.getApplication().getResources().getDisplayMetrics().density;
      f *= paramInt;
      if ((f > 0.0F) && (f < 1.0F)) {
        return 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e(TAG, "Exception e:" + localException.getMessage());
        f = 2.0F;
      }
    }
    return (int)f;
  }
  
  public static float getFloatByViewport(Object paramObject, int paramInt)
  {
    if (paramObject == null) {}
    do
    {
      return (0.0F / 0.0F);
      paramObject = paramObject.toString().trim();
    } while (("auto".equals(paramObject)) || ("undefined".equals(paramObject)) || (TextUtils.isEmpty(paramObject)));
    float f;
    if (paramObject.endsWith("vx")) {
      try
      {
        f = transferVxToViewPortPx(paramObject, paramInt);
        return f;
      }
      catch (NumberFormatException paramObject)
      {
        ViolaLogUtils.e(TAG, "getFloatByViewport NumberFormatException e:" + paramObject.getMessage());
        return (0.0F / 0.0F);
      }
      catch (Exception paramObject)
      {
        ViolaLogUtils.e(TAG, "getFloatByViewport Exception e:" + paramObject.getMessage());
        return (0.0F / 0.0F);
      }
    }
    if (paramObject.endsWith("px")) {
      try
      {
        f = Float.parseFloat(paramObject.substring(0, paramObject.indexOf("px")));
        return f;
      }
      catch (NumberFormatException paramObject)
      {
        ViolaLogUtils.e(TAG, "getFloatByViewport NumberFormatException e:" + paramObject.getMessage());
        return (0.0F / 0.0F);
      }
      catch (Exception paramObject)
      {
        ViolaLogUtils.e(TAG, "getFloatByViewport Exception e:" + paramObject.getMessage());
        return (0.0F / 0.0F);
      }
    }
    if (paramObject.endsWith("dp")) {
      try
      {
        paramInt = dip2px(Float.parseFloat(paramObject.substring(0, paramObject.indexOf("dp"))));
        return paramInt;
      }
      catch (NumberFormatException paramObject)
      {
        ViolaLogUtils.e(TAG, "getFloatByViewport NumberFormatException e:" + paramObject.getMessage());
        return (0.0F / 0.0F);
      }
      catch (Exception paramObject)
      {
        ViolaLogUtils.e(TAG, "getFloatByViewport Exception e:" + paramObject.getMessage());
        return (0.0F / 0.0F);
      }
    }
    if (paramObject.endsWith("vw")) {
      try
      {
        paramObject = paramObject.substring(0, paramObject.indexOf("vw"));
        f = paramInt;
        f = getRealPxByWidth(Float.parseFloat(paramObject) * f / 100.0F, paramInt);
        return f;
      }
      catch (Exception paramObject)
      {
        ViolaLogUtils.e(TAG, "getFloatByViewport Exception e:" + paramObject.getMessage());
        return (0.0F / 0.0F);
      }
    }
    if (paramObject.endsWith("rt")) {
      try
      {
        f = getRealPxByWidth(Float.parseFloat(paramObject.substring(0, paramObject.indexOf("rt"))), paramInt);
        return f;
      }
      catch (Exception paramObject)
      {
        ViolaLogUtils.e(TAG, "getFloatByViewport Exception e:" + paramObject.getMessage());
        return (0.0F / 0.0F);
      }
    }
    try
    {
      f = getRealPxByWidth(Float.parseFloat(paramObject), paramInt);
      return f;
    }
    catch (NumberFormatException paramObject)
    {
      ViolaLogUtils.e(TAG, "getFloatByViewport NumberFormatException e:" + paramObject.getMessage());
      return (0.0F / 0.0F);
    }
    catch (Exception paramObject)
    {
      ViolaLogUtils.e(TAG, "getFloatByViewport Exception e:" + paramObject.getMessage());
    }
    return (0.0F / 0.0F);
  }
  
  @SuppressLint({"MissingPermission"})
  public static String getIMEI()
  {
    if ((deviceid != null) && (deviceid.length() > 0)) {
      return deviceid;
    }
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)ViolaEnvironment.sApplication.getSystemService("phone");
      if (Build.VERSION.SDK_INT < 26) {
        deviceid = alla.a(localTelephonyManager);
      }
      return deviceid;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        deviceid = "";
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        deviceid = "";
      }
    }
  }
  
  public static float getRealPxByWidth(float paramFloat, int paramInt)
  {
    float f = 1.0F;
    if (Float.isNaN(paramFloat)) {
      return paramFloat;
    }
    paramFloat = getScreenWidth() * paramFloat / paramInt;
    if ((paramFloat > 0.005D) && (paramFloat < 1.0F)) {}
    for (paramFloat = f;; paramFloat = (float)Math.rint(paramFloat)) {
      return paramFloat;
    }
  }
  
  public static int getScreenContentHeight()
  {
    return getScreenContentHeight(ViolaEnvironment.sApplication);
  }
  
  public static int getScreenContentHeight(Context paramContext)
  {
    if ((paramContext != null) && (mScreenContentHeight == 0))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      mScreenContentHeight = localDisplayMetrics.heightPixels;
    }
    return mScreenContentHeight;
  }
  
  public static int getScreenHeight()
  {
    return Math.max(getScreenWidth(ViolaEnvironment.sApplication), getScreenHeight(ViolaEnvironment.sApplication));
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    if ((paramContext != null) && (mScreenHeight == 0))
    {
      mScreenHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
      if (Build.VERSION.SDK_INT > 16)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
        mScreenHeight = localDisplayMetrics.heightPixels;
      }
    }
    return mScreenHeight;
  }
  
  public static int getScreenWidth()
  {
    return Math.min(getScreenWidth(ViolaEnvironment.sApplication), getScreenHeight(ViolaEnvironment.sApplication));
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if ((paramContext != null) && (mScreenWidth == 0))
    {
      mScreenWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
      if (Build.VERSION.SDK_INT > 16)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
        mScreenWidth = localDisplayMetrics.widthPixels;
      }
    }
    return mScreenWidth;
  }
  
  public static float px2dip(float paramFloat)
  {
    float f2 = 2.0F;
    try
    {
      f1 = ViolaEnvironment.getApplication().getResources().getDisplayMetrics().density;
      if (f1 == 0.0F)
      {
        f1 = f2;
        DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
        DecimalFormatSymbols localDecimalFormatSymbols = new DecimalFormatSymbols();
        localDecimalFormatSymbols.setDecimalSeparator('.');
        localDecimalFormat.setDecimalFormatSymbols(localDecimalFormatSymbols);
        return Float.valueOf(localDecimalFormat.format(paramFloat / f1)).floatValue();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e(TAG, "Exception e:" + localException.getMessage());
        float f1 = 2.0F;
      }
    }
  }
  
  public static int sp2px(float paramFloat)
  {
    try
    {
      f = ViolaEnvironment.getApplication().getResources().getDisplayMetrics().scaledDensity;
      paramFloat = f * paramFloat + 0.5F;
      if ((paramFloat > 0.0F) && (paramFloat < 1.0F)) {
        return 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e(TAG, "Exception e:" + localException.getMessage());
        float f = 2.0F;
      }
    }
    return (int)paramFloat;
  }
  
  public static int transRealPxToWebDp(int paramInt1, int paramInt2)
  {
    return paramInt1 * paramInt2 / getScreenWidth();
  }
  
  public static float transferVxToViewPortPx(String paramString, int paramInt)
  {
    if (paramString.isEmpty()) {
      return 0.0F;
    }
    String str = paramString;
    if (paramString.endsWith("vx")) {
      str = paramString.substring(0, paramString.indexOf("vx"));
    }
    return Float.valueOf(Float.parseFloat(str)).floatValue() * paramInt / getScreenWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.FlexConvertUtils
 * JD-Core Version:    0.7.0.1
 */