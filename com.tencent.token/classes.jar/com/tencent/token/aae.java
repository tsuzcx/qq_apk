package com.tencent.token;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.bean.FaceRecognitionParamResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.ZzbIntroItem;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.ImageCache;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aae
{
  public static ConfigResult a;
  public static int b;
  static int c = 0;
  static boolean d = false;
  static boolean e = false;
  private static ImageCache f = new ImageCache(2, RqdApplication.n());
  private static final FileFilter g;
  
  static
  {
    a = new ConfigResult();
    b = 600;
    g = new FileFilter()
    {
      public final boolean accept(File paramAnonymousFile)
      {
        paramAnonymousFile = paramAnonymousFile.getName();
        if (paramAnonymousFile.startsWith("cpu"))
        {
          int i = 3;
          while (i < paramAnonymousFile.length()) {
            if (paramAnonymousFile.charAt(i) >= '0')
            {
              if (paramAnonymousFile.charAt(i) > '9') {
                return false;
              }
              i += 1;
            }
            else
            {
              return false;
            }
          }
          return true;
        }
        return false;
      }
    };
  }
  
  public static long a(int paramInt, long paramLong)
  {
    try
    {
      localObject2 = RqdApplication.n().getSharedPreferences("features_file", 0);
      Object localObject1;
      if (paramInt == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("_login");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("_op");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      paramLong = ((SharedPreferences)localObject2).getLong((String)localObject1, 0L);
      return paramLong;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder("SharedPreferences msg ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      xb.c(((StringBuilder)localObject2).toString());
    }
    return 0L;
  }
  
  public static Bitmap a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    if (paramBoolean) {
      localOptions.inSampleSize = 2;
    }
    return BitmapFactory.decodeResource(paramContext.getResources(), paramInt, localOptions);
  }
  
  public static Bitmap a(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = BitmapFactory.decodeResource(paramResources, paramInt);
      return paramResources;
    }
    catch (OutOfMemoryError paramResources)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2)
  {
    paramResources = a(paramResources, paramInt1);
    if (paramResources == null) {
      return null;
    }
    paramInt1 = paramResources.getWidth();
    int i = paramResources.getHeight();
    float f1 = paramInt2 / paramInt1;
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(f1, f1);
    try
    {
      localObject = Bitmap.createBitmap(paramResources, 0, 0, paramInt1, i, (Matrix)localObject, true);
      paramResources.recycle();
      boolean bool = ((Bitmap)localObject).isRecycled();
      if (bool) {
        return null;
      }
      return localObject;
    }
    catch (OutOfMemoryError paramResources)
    {
      return null;
    }
    catch (Exception paramResources) {}
    return null;
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    paramResources = a(paramResources, paramInt1);
    if (paramResources == null) {
      return null;
    }
    paramInt1 = paramResources.getWidth();
    int i = paramResources.getHeight();
    float f1 = paramInt2 / paramInt1;
    float f2 = paramInt3 / i;
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(f1, f2);
    try
    {
      localObject = Bitmap.createBitmap(paramResources, 0, 0, paramInt1, i, (Matrix)localObject, true);
      paramResources.recycle();
      boolean bool = ((Bitmap)localObject).isRecycled();
      if (bool) {
        return null;
      }
      return localObject;
    }
    catch (OutOfMemoryError paramResources)
    {
      return null;
    }
    catch (Exception paramResources) {}
    return null;
  }
  
  public static Bitmap a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if (paramContext != null) {
      return ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
    }
    return null;
  }
  
  public static String a(String paramString, float paramFloat, int paramInt)
  {
    String str = "";
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    int i = 0;
    int j = 0;
    while (i < paramString.length())
    {
      int k = i + 1;
      StringBuilder localStringBuilder;
      if (localPaint.measureText(paramString, j, k) >= paramInt)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append('\n');
        localStringBuilder.append(paramString.charAt(i));
        str = localStringBuilder.toString();
        j = i;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(paramString.charAt(i));
        str = localStringBuilder.toString();
      }
      i = k;
    }
    return str;
  }
  
  public static void a()
  {
    try
    {
      Object localObject1 = RqdApplication.n().getSharedPreferences("features_file", 0);
      a.mStartUpImgStartTime = ((SharedPreferences)localObject1).getLong("startup_start_time", 0L);
      a.mStartUpImgEndTime = ((SharedPreferences)localObject1).getLong("startup_end_time", 0L);
      a.mStartUpImgUrl = ((SharedPreferences)localObject1).getString("startup_img_url", "");
      long l = qz.a().h();
      if ((a.mStartUpImgStartTime != 0L) && (a.mStartUpImgEndTime != 0L) && (l >= a.mStartUpImgStartTime) && (l <= a.mStartUpImgEndTime))
      {
        localObject1 = a;
        localObject2 = f;
        ((ConfigResult)localObject1).mStartUpImg = ((ImageCache)localObject2).b(((ImageCache)localObject2).c("startup_img"));
      }
      else
      {
        a.mStartUpImg = null;
      }
      localObject1 = new StringBuilder("startup current=");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(", start=");
      ((StringBuilder)localObject1).append(a.mStartUpImgStartTime);
      ((StringBuilder)localObject1).append(", end=");
      ((StringBuilder)localObject1).append(a.mStartUpImgEndTime);
      ((StringBuilder)localObject1).append(", url=");
      ((StringBuilder)localObject1).append(a.mStartUpImgUrl);
      ((StringBuilder)localObject1).append(", img=");
      ((StringBuilder)localObject1).append(a.mStartUpImg);
      xb.c(((StringBuilder)localObject1).toString());
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder("SharedPreferences msg ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      xb.c(((StringBuilder)localObject2).toString());
      a.mStartUpImg = null;
    }
  }
  
  public static void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt == 1) {}
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append("_login");
      localObject1 = ((StringBuilder)localObject1).toString();
      break label70;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append("_op");
      localObject1 = ((StringBuilder)localObject1).toString();
      label70:
      localObject2 = RqdApplication.n().getSharedPreferences("features_file", 0).edit();
      ((SharedPreferences.Editor)localObject2).putLong((String)localObject1, paramLong2);
      ((SharedPreferences.Editor)localObject2).commit();
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder("SharedPreferences msg ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      xb.c(((StringBuilder)localObject2).toString());
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.n().getSharedPreferences("features_file", 0).edit();
      localEditor.putLong("dns_time", paramLong);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
  }
  
  public static void a(Activity paramActivity)
  {
    ((InputMethodManager)paramActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramActivity.getWindow().peekDecorView().getWindowToken(), 0);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 21) && (c(paramActivity))) {
        paramActivity.getWindow().setStatusBarColor(paramActivity.getResources().getColor(paramInt));
      }
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(Activity paramActivity, View paramView, int paramInt)
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 21) && (c(paramActivity)))
      {
        paramActivity.getWindow().addFlags(-2147483648);
        paramActivity.getWindow().clearFlags(67108864);
        paramActivity.getWindow().setStatusBarColor(paramActivity.getResources().getColor(paramInt));
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).topMargin = b(paramActivity);
      }
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(ConfigResult paramConfigResult)
  {
    if ((paramConfigResult != null) && (paramConfigResult.mStartUpImgUrl != null))
    {
      if (paramConfigResult.mStartUpImg == null) {
        return;
      }
      try
      {
        localObject = RqdApplication.n().getSharedPreferences("features_file", 0).edit();
        ((SharedPreferences.Editor)localObject).putLong("startup_start_time", paramConfigResult.mStartUpImgStartTime);
        ((SharedPreferences.Editor)localObject).putLong("startup_end_time", paramConfigResult.mStartUpImgEndTime);
        ((SharedPreferences.Editor)localObject).putString("startup_img_url", paramConfigResult.mStartUpImgUrl);
        ((SharedPreferences.Editor)localObject).commit();
        ImageCache.a(f.c("startup_img"));
        localObject = f;
        ((ImageCache)localObject).a(((ImageCache)localObject).c("startup_img"), paramConfigResult.mStartUpImg);
        paramConfigResult.mStartUpImg.recycle();
        paramConfigResult.mStartUpImg = null;
        return;
      }
      catch (Exception paramConfigResult)
      {
        Object localObject = new StringBuilder("SharedPreferences msg ");
        ((StringBuilder)localObject).append(paramConfigResult.getMessage());
        xb.c(((StringBuilder)localObject).toString());
        return;
      }
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      localObject = RqdApplication.n().getSharedPreferences("features_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(paramString, true);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder("SharedPreferences msg ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      xb.c(((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    Object localObject = RqdApplication.n();
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("schemaparm_name", 0).edit();
      ((SharedPreferences.Editor)localObject).putString("key_schemaparm_key", paramString);
      ((SharedPreferences.Editor)localObject).putInt("key_schemaparm_timeout", paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder("SharedPreferences msg ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      xb.c(((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    try
    {
      localObject = RqdApplication.n().getSharedPreferences("features_file", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder("displayAngle");
      localStringBuilder.append(paramJSONObject.getInt("displayangle"));
      xb.a(localStringBuilder.toString());
      ((SharedPreferences.Editor)localObject).putInt("displayAngle_face", paramJSONObject.getInt("displayangle"));
      ((SharedPreferences.Editor)localObject).putInt("imageAngle_face", paramJSONObject.getInt("imageangle"));
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject = new StringBuilder("SharedPreferences msg ");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      xb.c(((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.n().getSharedPreferences("features_file", 0).edit();
      localEditor.putBoolean("start_camera", paramBoolean);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    long l1 = Runtime.getRuntime().maxMemory();
    long l2 = Runtime.getRuntime().totalMemory();
    int i = paramInt1 * paramInt2 * 4 * 1;
    if (l1 - l2 - 4194304L < i)
    {
      StringBuilder localStringBuilder = new StringBuilder("use low quality:mem=");
      localStringBuilder.append(Runtime.getRuntime().maxMemory() - 10485760L);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("*");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("*4*1=");
      localStringBuilder.append(i);
      xb.b(localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public static int b(Context paramContext)
  {
    int i = c;
    if (i <= 0) {
      try
      {
        i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i > 0)
        {
          i = paramContext.getResources().getDimensionPixelSize(i);
          c = i;
          return i;
        }
        Class localClass = Class.forName("com.android.internal.R$dimen");
        Object localObject = localClass.newInstance();
        i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
        i = paramContext.getResources().getDimensionPixelSize(i);
        c = i;
        return i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i = (int)paramContext.getResources().getDimension(2131034200);
        c = i;
        return i;
      }
    }
    return i;
  }
  
  public static Bitmap b(String paramString, int paramInt)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    int i = (int)(Math.max(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight) / paramInt);
    paramInt = i;
    if (i <= 0) {
      paramInt = 1;
    }
    ((BitmapFactory.Options)localObject).inSampleSize = paramInt;
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    try
    {
      localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      if (localObject == null) {
        return null;
      }
      paramInt = f(paramString);
      if (paramInt != 0)
      {
        paramString = new Matrix();
        paramString.preRotate(paramInt);
        Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), paramString, true);
        if (localObject != localBitmap)
        {
          paramString = localBitmap;
          if (((Bitmap)localObject).isRecycled()) {
            break label133;
          }
          ((Bitmap)localObject).recycle();
          return localBitmap;
        }
      }
      paramString = (String)localObject;
      label133:
      return paramString;
    }
    catch (Exception paramString)
    {
      label135:
      break label135;
    }
    xb.c("BitmapFactory.decodeFile failed...");
    return null;
  }
  
  public static void b(long paramLong)
  {
    try
    {
      sd.a();
      RqdApplication.n();
      SharedPreferences.Editor localEditor = sd.g().edit();
      String str1 = rx.b();
      aaw localaaw = new aaw();
      String str2 = Long.toString(paramLong);
      localObject2 = localaaw.b(str2.getBytes("UTF8"), aay.a(str1));
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localaaw.b(str2.getBytes("UTF8"), aay.a(str1));
      }
      localObject1 = ss.a((byte[])localObject1);
      localObject2 = new StringBuilder("verify_face_pwd_uin, hex=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", key=");
      ((StringBuilder)localObject2).append(str1);
      xb.a(((StringBuilder)localObject2).toString());
      localEditor.putString("verify_face_pwd_uin", (String)localObject1);
      localEditor.putString("verify_face_pwd_key", str1);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder("SharedPreferences msg ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      xb.c(((StringBuilder)localObject2).toString());
    }
  }
  
  public static void b(ConfigResult paramConfigResult)
  {
    if ((paramConfigResult != null) && (paramConfigResult.mToolsTitleList != null) && (paramConfigResult.mToolsList != null))
    {
      if (paramConfigResult.mToolsTitleList.length() != paramConfigResult.mToolsList.length()) {
        return;
      }
      a.mToolsTitleList = paramConfigResult.mToolsTitleList;
      a.mToolsList = paramConfigResult.mToolsList;
      paramConfigResult = new StringBuilder("storeconfig=");
      paramConfigResult.append(a.mToolsTitleList.toString());
      paramConfigResult.append("\n");
      paramConfigResult.append(a.mToolsList.toString());
      xb.a(paramConfigResult.toString());
      paramConfigResult = RqdApplication.n().getSharedPreferences("features_file", 0).edit();
      paramConfigResult.putString("tools_title", a.mToolsTitleList.toString());
      paramConfigResult.putString("tools_items", a.mToolsList.toString());
      paramConfigResult.commit();
      return;
    }
  }
  
  public static boolean b()
  {
    try
    {
      int i = RqdApplication.n().getSharedPreferences("features_file", 0).getInt("token_version", 0);
      int j = wx.d();
      return i != j;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      boolean bool = RqdApplication.n().getSharedPreferences("features_file", 0).getBoolean(paramString, false);
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static void c(ConfigResult paramConfigResult)
  {
    try
    {
      localObject = RqdApplication.n().getSharedPreferences("features_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("utils_flag", paramConfigResult.utilsShowFlag);
      ((SharedPreferences.Editor)localObject).putFloat("face_reg_thres", paramConfigResult.mFaceRecognitionParamResult.mRegRayThres);
      ((SharedPreferences.Editor)localObject).putFloat("face_verify_thres", paramConfigResult.mFaceRecognitionParamResult.mVerifyRayThres);
      ((SharedPreferences.Editor)localObject).putFloat("face_disparity_thres", paramConfigResult.mFaceRecognitionParamResult.mDisparityThres);
      ((SharedPreferences.Editor)localObject).putString("zzb_intro_list", paramConfigResult.zzbIntroList.toString());
      ((SharedPreferences.Editor)localObject).putInt("face_algorithm", paramConfigResult.face_algorithm);
      ((SharedPreferences.Editor)localObject).putInt("live_angle", paramConfigResult.live_angle);
      ((SharedPreferences.Editor)localObject).putString("so_param_ids", paramConfigResult.so_param_ids);
      ((SharedPreferences.Editor)localObject).putString("so_param_values", paramConfigResult.so_param_values);
      ((SharedPreferences.Editor)localObject).putInt("collect_device_info", paramConfigResult.uploadDeviceInfoInt);
      ((SharedPreferences.Editor)localObject).putInt("use_face_start", paramConfigResult.useFaceStart);
      ((SharedPreferences.Editor)localObject).putInt("use_face_chpwd", paramConfigResult.useFaceChpwd);
      ((SharedPreferences.Editor)localObject).putInt("use_face_chmobile", paramConfigResult.useFaceChmobile);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramConfigResult)
    {
      Object localObject = new StringBuilder("SharedPreferences msg ");
      ((StringBuilder)localObject).append(paramConfigResult.getMessage());
      xb.c(((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean c()
  {
    try
    {
      boolean bool = RqdApplication.n().getSharedPreferences("features_file", 0).getBoolean("start_camera", false);
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    if (d) {
      return e;
    }
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool2 = false;
    boolean bool3 = bool2;
    boolean bool4 = bool6;
    boolean bool5 = bool7;
    boolean bool1 = bool8;
    for (;;)
    {
      try
      {
        paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
        bool3 = bool2;
        bool4 = bool6;
        bool5 = bool7;
        bool1 = bool8;
        bool2 = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
        bool3 = bool2;
        bool4 = bool2;
        bool5 = bool2;
        bool1 = bool2;
        xb.c("notch screen".concat(String.valueOf(bool2)));
        bool1 = bool2;
      }
      catch (ClassNotFoundException paramContext) {}catch (NoSuchMethodException paramContext) {}catch (Exception paramContext) {}finally
      {
        continue;
      }
      d = true;
      e = bool1;
      return bool1;
      bool1 = bool5;
      xb.c("hasNotchInScreen Exception");
      bool1 = bool5;
      continue;
      bool1 = bool4;
      xb.c("hasNotchInScreen NoSuchMethodException");
      bool1 = bool4;
      continue;
      bool1 = bool3;
      xb.c("hasNotchInScreen ClassNotFoundException");
      bool1 = bool3;
    }
  }
  
  /* Error */
  public static byte[] c(String paramString)
  {
    // Byte code:
    //   0: new 102	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 103	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_3
    //   8: iconst_1
    //   9: istore_1
    //   10: aload_3
    //   11: iconst_1
    //   12: putfield 505	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   15: aload_0
    //   16: aload_3
    //   17: invokestatic 509	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   20: pop
    //   21: aload_3
    //   22: getfield 512	android/graphics/BitmapFactory$Options:outWidth	I
    //   25: i2f
    //   26: ldc_w 730
    //   29: fdiv
    //   30: aload_3
    //   31: getfield 515	android/graphics/BitmapFactory$Options:outHeight	I
    //   34: i2f
    //   35: ldc_w 730
    //   38: fdiv
    //   39: invokestatic 733	java/lang/Math:max	(FF)F
    //   42: f2i
    //   43: istore_2
    //   44: iload_2
    //   45: ifgt +6 -> 51
    //   48: goto +5 -> 53
    //   51: iload_2
    //   52: istore_1
    //   53: aload_3
    //   54: iload_1
    //   55: putfield 121	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   58: aload_3
    //   59: iconst_0
    //   60: putfield 505	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   63: aload_0
    //   64: aload_3
    //   65: invokestatic 509	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   68: astore_3
    //   69: aload_3
    //   70: ifnonnull +5 -> 75
    //   73: aconst_null
    //   74: areturn
    //   75: aload_0
    //   76: invokestatic 523	com/tencent/token/aae:f	(Ljava/lang/String;)I
    //   79: istore_1
    //   80: iload_1
    //   81: ifeq +62 -> 143
    //   84: new 150	android/graphics/Matrix
    //   87: dup
    //   88: invokespecial 151	android/graphics/Matrix:<init>	()V
    //   91: astore_0
    //   92: aload_0
    //   93: iload_1
    //   94: i2f
    //   95: invokevirtual 527	android/graphics/Matrix:preRotate	(F)Z
    //   98: pop
    //   99: aload_3
    //   100: iconst_0
    //   101: iconst_0
    //   102: aload_3
    //   103: invokevirtual 145	android/graphics/Bitmap:getWidth	()I
    //   106: aload_3
    //   107: invokevirtual 148	android/graphics/Bitmap:getHeight	()I
    //   110: aload_0
    //   111: iconst_1
    //   112: invokestatic 159	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   115: astore 4
    //   117: aload_3
    //   118: aload 4
    //   120: if_acmpeq +23 -> 143
    //   123: aload 4
    //   125: astore_0
    //   126: aload_3
    //   127: invokevirtual 166	android/graphics/Bitmap:isRecycled	()Z
    //   130: ifne +15 -> 145
    //   133: aload_3
    //   134: invokevirtual 162	android/graphics/Bitmap:recycle	()V
    //   137: aload 4
    //   139: astore_0
    //   140: goto +5 -> 145
    //   143: aload_3
    //   144: astore_0
    //   145: new 735	java/io/ByteArrayOutputStream
    //   148: dup
    //   149: invokespecial 736	java/io/ByteArrayOutputStream:<init>	()V
    //   152: astore_3
    //   153: getstatic 742	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   156: astore 4
    //   158: bipush 80
    //   160: istore_1
    //   161: aload_0
    //   162: aload 4
    //   164: bipush 80
    //   166: aload_3
    //   167: invokevirtual 746	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   170: pop
    //   171: aload_3
    //   172: invokevirtual 749	java/io/ByteArrayOutputStream:size	()I
    //   175: ldc_w 750
    //   178: if_icmple +25 -> 203
    //   181: iload_1
    //   182: bipush 20
    //   184: isub
    //   185: istore_1
    //   186: aload_3
    //   187: invokevirtual 753	java/io/ByteArrayOutputStream:reset	()V
    //   190: aload_0
    //   191: getstatic 742	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   194: iload_1
    //   195: aload_3
    //   196: invokevirtual 746	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   199: pop
    //   200: goto -29 -> 171
    //   203: aload_3
    //   204: invokevirtual 756	java/io/ByteArrayOutputStream:close	()V
    //   207: goto +24 -> 231
    //   210: astore_0
    //   211: goto +25 -> 236
    //   214: astore_0
    //   215: aload_0
    //   216: invokevirtual 351	java/lang/Exception:printStackTrace	()V
    //   219: aload_3
    //   220: invokevirtual 756	java/io/ByteArrayOutputStream:close	()V
    //   223: goto +8 -> 231
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 757	java/io/IOException:printStackTrace	()V
    //   231: aload_3
    //   232: invokevirtual 761	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   235: areturn
    //   236: aload_3
    //   237: invokevirtual 756	java/io/ByteArrayOutputStream:close	()V
    //   240: goto +8 -> 248
    //   243: astore_3
    //   244: aload_3
    //   245: invokevirtual 757	java/io/IOException:printStackTrace	()V
    //   248: aload_0
    //   249: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramString	String
    //   9	186	1	i	int
    //   43	9	2	j	int
    //   7	230	3	localObject1	Object
    //   243	2	3	localIOException	IOException
    //   115	48	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   153	158	210	finally
    //   161	171	210	finally
    //   171	181	210	finally
    //   186	200	210	finally
    //   215	219	210	finally
    //   153	158	214	java/lang/Exception
    //   161	171	214	java/lang/Exception
    //   171	181	214	java/lang/Exception
    //   186	200	214	java/lang/Exception
    //   203	207	226	java/io/IOException
    //   219	223	226	java/io/IOException
    //   236	240	243	java/io/IOException
  }
  
  public static long d()
  {
    try
    {
      long l = RqdApplication.n().getSharedPreferences("features_file", 0).getLong("dns_time", 0L);
      return l;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static byte[] d(String paramString)
  {
    try
    {
      paramString = new FileInputStream(new File(paramString));
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1000);
      byte[] arrayOfByte = new byte[1000];
      for (;;)
      {
        int i = paramString.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramString.close();
      localByteArrayOutputStream.close();
      paramString = localByteArrayOutputStream.toByteArray();
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static long e()
  {
    try
    {
      sd.a();
      RqdApplication.n();
      Object localObject1 = sd.g();
      aaw localaaw = new aaw();
      String str = ((SharedPreferences)localObject1).getString("verify_face_pwd_key", "");
      localObject1 = ((SharedPreferences)localObject1).getString("verify_face_pwd_uin", "");
      if (!n())
      {
        b(0L);
        return 0L;
      }
      if ((str != null) && (str.length() != 0) && (localObject1 != null))
      {
        if (((String)localObject1).length() == 0) {
          return 0L;
        }
        byte[] arrayOfByte = ss.a((String)localObject1);
        localObject2 = localaaw.a(arrayOfByte, aay.a(str));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = localaaw.a(arrayOfByte, aay.a(str));
        }
        localObject1 = new String((byte[])localObject1, "UTF8");
        if (((String)localObject1).length() == 0) {
          return 0L;
        }
        xb.a("facepwd verify uin=".concat(String.valueOf(localObject1)));
        long l = Long.parseLong((String)localObject1);
        return l;
      }
      return 0L;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder("SharedPreferences msg ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      xb.c(((StringBuilder)localObject2).toString());
    }
    return 0L;
  }
  
  private static boolean e(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("unknow"));
  }
  
  private static int f(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 0);
      if (i != 3)
      {
        if (i != 6)
        {
          if (i != 8) {
            return 0;
          }
          return 270;
        }
        return 90;
      }
      return 180;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static QQUser f()
  {
    try
    {
      long l = e();
      if (l == 0L) {
        return null;
      }
      QQUser localQQUser = ta.a().d(l);
      return localQQUser;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return null;
  }
  
  public static QQUser g()
  {
    try
    {
      long l = e();
      if (l == 0L) {
        return null;
      }
      QQUser localQQUser = ta.a().c(aad.f(l));
      return localQQUser;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return null;
  }
  
  public static FaceRecognitionParamResult h()
  {
    FaceRecognitionParamResult localFaceRecognitionParamResult = new FaceRecognitionParamResult();
    try
    {
      Object localObject = RqdApplication.n().getSharedPreferences("features_file", 0);
      localFaceRecognitionParamResult.mRegRayThres = ((SharedPreferences)localObject).getFloat("face_reg_thres", 0.1F);
      localFaceRecognitionParamResult.mVerifyRayThres = ((SharedPreferences)localObject).getFloat("face_verify_thres", 0.1F);
      localFaceRecognitionParamResult.mDisparityThres = ((SharedPreferences)localObject).getFloat("face_disparity_thres", 2.0F);
      localObject = new StringBuilder("faceparams: ");
      ((StringBuilder)localObject).append(localFaceRecognitionParamResult.mRegRayThres);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(localFaceRecognitionParamResult.mVerifyRayThres);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(localFaceRecognitionParamResult.mDisparityThres);
      xb.a(((StringBuilder)localObject).toString());
      return localFaceRecognitionParamResult;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
      localFaceRecognitionParamResult.mRegRayThres = 0.1F;
      localFaceRecognitionParamResult.mVerifyRayThres = 0.1F;
      localFaceRecognitionParamResult.mDisparityThres = 2.0F;
    }
    return localFaceRecognitionParamResult;
  }
  
  public static int i()
  {
    try
    {
      int i = RqdApplication.n().getSharedPreferences("features_file", 0).getInt("face_algorithm", 1);
      return i;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return 0;
  }
  
  public static JSONArray j()
  {
    if (a.mToolsTitleList != null) {
      return a.mToolsTitleList;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(RqdApplication.n().getSharedPreferences("features_file", 0).getString("tools_title", null));
      return localJSONArray;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static ArrayList<ArrayList<sm>> k()
  {
    try
    {
      JSONArray localJSONArray1 = new JSONArray(RqdApplication.n().getSharedPreferences("features_file", 0).getString("tools_items", null));
      ArrayList localArrayList1 = new ArrayList();
      if (localJSONArray1.length() >= 0)
      {
        int i = 0;
        while (i < localJSONArray1.length())
        {
          JSONArray localJSONArray2 = localJSONArray1.getJSONArray(i);
          ArrayList localArrayList2 = new ArrayList();
          int j = 0;
          while (j < localJSONArray2.length())
          {
            localArrayList2.add(new sm(localJSONArray2.getJSONObject(j)));
            j += 1;
          }
          localArrayList1.add(localArrayList2);
          i += 1;
        }
        return localArrayList1;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static ArrayList<ZzbIntroItem> l()
  {
    if (a.zzbIntroItemlist != null) {
      return a.zzbIntroItemlist;
    }
    Object localObject = RqdApplication.n();
    int i = 0;
    localObject = ((Context)localObject).getSharedPreferences("features_file", 0).getString("zzb_intro_list", null);
    try
    {
      localObject = new JSONArray((String)localObject);
      if (((JSONArray)localObject).length() > 0)
      {
        ArrayList localArrayList = new ArrayList();
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(new ZzbIntroItem(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
        return localArrayList;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean m()
  {
    try
    {
      int i = RqdApplication.n().getSharedPreferences("features_file", 0).getInt("collect_device_info", 0);
      return i == 1;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean n()
  {
    try
    {
      int i = RqdApplication.n().getSharedPreferences("features_file", 0).getInt("use_face_start", 0);
      return i == 1;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean o()
  {
    try
    {
      int i = RqdApplication.n().getSharedPreferences("features_file", 0).getInt("use_face_chpwd", 0);
      return i == 1;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean p()
  {
    try
    {
      int i = RqdApplication.n().getSharedPreferences("features_file", 0).getInt("use_face_chmobile", 0);
      return i == 1;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return false;
  }
  
  public static String q()
  {
    try
    {
      String str = RqdApplication.n().getSharedPreferences("features_file", 0).getString("so_param_ids", "");
      return str;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return "";
  }
  
  public static String r()
  {
    try
    {
      String str = RqdApplication.n().getSharedPreferences("features_file", 0).getString("so_param_values", "");
      return str;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return "";
  }
  
  public static int s()
  {
    try
    {
      int i = RqdApplication.n().getSharedPreferences("features_file", 0).getInt("live_angle", 21);
      return i;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return 0;
  }
  
  public static int t()
  {
    try
    {
      int i = RqdApplication.n().getSharedPreferences("features_file", 0).getInt("displayAngle_face", -1);
      return i;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return -1;
  }
  
  public static int u()
  {
    try
    {
      int i = RqdApplication.n().getSharedPreferences("features_file", 0).getInt("imageAngle_face", -1);
      return i;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return -1;
  }
  
  public static boolean v()
  {
    try
    {
      boolean bool = RqdApplication.n().getSharedPreferences("features_file", 0).getBoolean("show_bright_tip", false);
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
    return true;
  }
  
  public static void w()
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.n().getSharedPreferences("features_file", 0).edit();
      localEditor.putBoolean("show_bright_tip", true);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xb.c(localStringBuilder.toString());
    }
  }
  
  public static String x()
  {
    Object localObject1 = "";
    if (e(Build.MANUFACTURER))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(Build.MANUFACTURER);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = localObject1;
    if (e(Build.MODEL))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(Build.MODEL);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  public static int y()
  {
    if (Build.VERSION.SDK_INT <= 10) {
      return 1;
    }
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(g).length;
      return i;
    }
    catch (SecurityException|NullPointerException|Exception localSecurityException) {}
    return 1;
  }
  
  /* Error */
  public static int z()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_0
    //   4: iload_2
    //   5: invokestatic 928	com/tencent/token/aae:y	()I
    //   8: if_icmpge +138 -> 146
    //   11: new 65	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 930
    //   18: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: astore_3
    //   22: aload_3
    //   23: iload_2
    //   24: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_3
    //   29: ldc_w 932
    //   32: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: new 767	java/io/File
    //   39: dup
    //   40: aload_3
    //   41: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 768	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_3
    //   48: iload_0
    //   49: istore_1
    //   50: aload_3
    //   51: invokevirtual 935	java/io/File:exists	()Z
    //   54: ifeq +83 -> 137
    //   57: sipush 128
    //   60: newarray byte
    //   62: astore 4
    //   64: new 765	java/io/FileInputStream
    //   67: dup
    //   68: aload_3
    //   69: invokespecial 771	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: astore_3
    //   73: aload_3
    //   74: aload 4
    //   76: invokevirtual 777	java/io/FileInputStream:read	([B)I
    //   79: pop
    //   80: iconst_0
    //   81: istore_1
    //   82: goto +76 -> 158
    //   85: new 214	java/lang/String
    //   88: dup
    //   89: aload 4
    //   91: iconst_0
    //   92: iload_1
    //   93: invokespecial 937	java/lang/String:<init>	([BII)V
    //   96: invokestatic 496	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   99: invokestatic 940	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: astore 4
    //   104: iload_0
    //   105: istore_1
    //   106: aload 4
    //   108: invokevirtual 943	java/lang/Integer:intValue	()I
    //   111: iload_0
    //   112: if_icmple +9 -> 121
    //   115: aload 4
    //   117: invokevirtual 943	java/lang/Integer:intValue	()I
    //   120: istore_1
    //   121: aload_3
    //   122: invokevirtual 782	java/io/FileInputStream:close	()V
    //   125: goto +12 -> 137
    //   128: astore 4
    //   130: aload_3
    //   131: invokevirtual 782	java/io/FileInputStream:close	()V
    //   134: aload 4
    //   136: athrow
    //   137: iload_2
    //   138: iconst_1
    //   139: iadd
    //   140: istore_2
    //   141: iload_1
    //   142: istore_0
    //   143: goto -139 -> 4
    //   146: iload_0
    //   147: ireturn
    //   148: astore_3
    //   149: iconst_0
    //   150: ireturn
    //   151: astore 4
    //   153: iload_0
    //   154: istore_1
    //   155: goto -34 -> 121
    //   158: aload 4
    //   160: iload_1
    //   161: baload
    //   162: bipush 48
    //   164: if_icmplt -79 -> 85
    //   167: aload 4
    //   169: iload_1
    //   170: baload
    //   171: bipush 57
    //   173: if_icmpgt -88 -> 85
    //   176: iload_1
    //   177: sipush 128
    //   180: if_icmpge -95 -> 85
    //   183: iload_1
    //   184: iconst_1
    //   185: iadd
    //   186: istore_1
    //   187: goto -29 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	151	0	i	int
    //   49	138	1	j	int
    //   1	140	2	k	int
    //   21	110	3	localObject1	Object
    //   148	1	3	localIOException	IOException
    //   62	54	4	localObject2	Object
    //   128	7	4	localObject3	Object
    //   151	17	4	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   73	80	128	finally
    //   85	104	128	finally
    //   106	121	128	finally
    //   4	48	148	java/io/IOException
    //   50	73	148	java/io/IOException
    //   121	125	148	java/io/IOException
    //   130	137	148	java/io/IOException
    //   73	80	151	java/lang/NumberFormatException
    //   85	104	151	java/lang/NumberFormatException
    //   106	121	151	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aae
 * JD-Core Version:    0.7.0.1
 */