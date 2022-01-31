package com.tencent.token.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.token.cm;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.bean.FaceRecognitionParamResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.ZzbIntroItem;
import com.tencent.token.cx;
import com.tencent.token.cy;
import com.tencent.token.dg;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.utils.encrypt.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class x
{
  public static ConfigResult a;
  public static int b;
  static int c = 0;
  static boolean d = false;
  static boolean e = false;
  private static ImageCache f = new ImageCache("", 2, RqdApplication.l());
  private static final FileFilter g;
  
  static
  {
    a = new ConfigResult();
    b = 600;
    g = new y();
  }
  
  public static long a(int paramInt, long paramLong)
  {
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.l().getSharedPreferences("features_file", 0);
      if (paramInt == 1) {}
      for (String str = "" + paramLong + "_login";; str = "" + paramLong + "_op") {
        return localSharedPreferences.getLong(str, 0L);
      }
      return 0L;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
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
    catch (OutOfMemoryError paramResources) {}
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
    catch (OutOfMemoryError paramArrayOfByte) {}
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
    int i = 0;
    String str = "";
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    int j = 0;
    if (i < paramString.length())
    {
      if (localPaint.measureText(paramString, j, i + 1) >= paramInt)
      {
        str = str + '\n' + paramString.charAt(i);
        j = i;
      }
      for (;;)
      {
        i += 1;
        break;
        str = str + paramString.charAt(i);
      }
    }
    return str;
  }
  
  public static void a()
  {
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.l().getSharedPreferences("features_file", 0);
      a.mStartUpImgStartTime = localSharedPreferences.getLong("startup_start_time", 0L);
      a.mStartUpImgEndTime = localSharedPreferences.getLong("startup_end_time", 0L);
      a.mStartUpImgUrl = localSharedPreferences.getString("startup_img_url", "");
      long l = cx.c().s() / 1000L;
      if ((a.mStartUpImgStartTime != 0L) && (a.mStartUpImgEndTime != 0L) && (l >= a.mStartUpImgStartTime) && (l <= a.mStartUpImgEndTime)) {}
      for (a.mStartUpImg = f.b(f.c("startup_img"));; a.mStartUpImg = null)
      {
        h.c("startup current=" + l + ", start=" + a.mStartUpImgStartTime + ", end=" + a.mStartUpImgEndTime + ", url=" + a.mStartUpImgUrl + ", img=" + a.mStartUpImg);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
      a.mStartUpImg = null;
    }
  }
  
  public static void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        str = "" + paramLong1 + "_login";
        SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
        localEditor.putLong(str, paramLong2);
        localEditor.commit();
        return;
      }
      catch (Exception localException)
      {
        String str;
        h.c("SharedPreferences msg " + localException.getMessage());
      }
      str = "" + paramLong1 + "_op";
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
      localEditor.putLong("dns_time", paramLong);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
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
    if ((paramConfigResult == null) || (paramConfigResult.mStartUpImgUrl == null) || (paramConfigResult.mStartUpImg == null)) {
      return;
    }
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
      localEditor.putLong("startup_start_time", paramConfigResult.mStartUpImgStartTime);
      localEditor.putLong("startup_end_time", paramConfigResult.mStartUpImgEndTime);
      localEditor.putString("startup_img_url", paramConfigResult.mStartUpImgUrl);
      localEditor.commit();
      f.a(f.c("startup_img"));
      f.a(f.c("startup_img"), paramConfigResult.mStartUpImg);
      paramConfigResult.mStartUpImg.recycle();
      paramConfigResult.mStartUpImg = null;
      return;
    }
    catch (Exception paramConfigResult)
    {
      h.c("SharedPreferences msg " + paramConfigResult.getMessage());
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    Object localObject = RqdApplication.l();
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
      h.c("SharedPreferences msg " + paramString.getMessage());
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
      localEditor.putBoolean(paramString, paramBoolean);
      localEditor.commit();
      return;
    }
    catch (Exception paramString)
    {
      h.c("SharedPreferences msg " + paramString.getMessage());
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
      h.a("displayAngle" + paramJSONObject.getInt("displayangle"));
      localEditor.putInt("displayAngle_face", paramJSONObject.getInt("displayangle"));
      localEditor.putInt("imageAngle_face", paramJSONObject.getInt("imageangle"));
      localEditor.commit();
      return;
    }
    catch (Exception paramJSONObject)
    {
      h.c("SharedPreferences msg " + paramJSONObject.getMessage());
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
      localEditor.putBoolean("start_camera", paramBoolean);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() - 4194304L < paramInt1 * paramInt2 * 4 * paramInt3)
    {
      h.b("use low quality:mem=" + (Runtime.getRuntime().maxMemory() - 10485760L) + " " + paramInt1 + "*" + paramInt2 + "*4*" + paramInt3 + "=" + paramInt1 * paramInt2 * 4 * paramInt3);
      return true;
    }
    return false;
  }
  
  public static byte[] a(String paramString)
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
      return null;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return null;
      paramString.close();
      localByteArrayOutputStream.close();
      paramString = localByteArrayOutputStream.toByteArray();
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static byte[] a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
    int i;
    Object localObject2;
    if (paramInt1 != 0)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 != 0) {}
    }
    else
    {
      localObject2 = RqdApplication.l().getResources().getDisplayMetrics();
      i = ((DisplayMetrics)localObject2).widthPixels;
      paramInt1 = ((DisplayMetrics)localObject2).heightPixels;
    }
    paramInt2 = (int)Math.max(((BitmapFactory.Options)localObject1).outWidth / i, ((BitmapFactory.Options)localObject1).outHeight / paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    ((BitmapFactory.Options)localObject1).inSampleSize = paramInt1;
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    localObject1 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
    if (localObject1 == null) {
      return null;
    }
    paramInt1 = b(paramString);
    paramString = (String)localObject1;
    if (paramInt1 != 0)
    {
      paramString = new Matrix();
      paramString.preRotate(paramInt1);
      localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramString, true);
      paramString = (String)localObject1;
      if (localObject1 != localObject2)
      {
        if (!((Bitmap)localObject1).isRecycled()) {
          ((Bitmap)localObject1).recycle();
        }
        paramString = (String)localObject2;
      }
    }
    paramInt1 = 80;
    localObject1 = new ByteArrayOutputStream();
    try
    {
      paramString.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject1);
      while (((ByteArrayOutputStream)localObject1).size() > paramInt3)
      {
        paramInt1 -= 20;
        ((ByteArrayOutputStream)localObject1).reset();
        paramString.compress(Bitmap.CompressFormat.JPEG, paramInt1, (OutputStream)localObject1);
      }
      try
      {
        ((ByteArrayOutputStream)localObject1).close();
        throw paramString;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      paramString.printStackTrace();
      try
      {
        ((ByteArrayOutputStream)localObject1).close();
        for (;;)
        {
          return ((ByteArrayOutputStream)localObject1).toByteArray();
          try
          {
            ((ByteArrayOutputStream)localObject1).close();
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public static int b(Context paramContext)
  {
    if (c <= 0) {
      try
      {
        int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i > 0)
        {
          c = paramContext.getResources().getDimensionPixelSize(i);
          return c;
        }
        Class localClass = Class.forName("com.android.internal.R$dimen");
        Object localObject = localClass.newInstance();
        i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
        c = paramContext.getResources().getDimensionPixelSize(i);
        i = c;
        return i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        c = (int)paramContext.getResources().getDimension(2131296371);
        return c;
      }
    }
    return c;
  }
  
  public static int b(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 0);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
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
    Bitmap localBitmap;
    do
    {
      do
      {
        try
        {
          localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
          if (localObject == null)
          {
            paramString = null;
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          h.c("BitmapFactory.decodeFile failed...");
          return null;
        }
        paramInt = b(paramString);
        paramString = (String)localObject;
      } while (paramInt == 0);
      paramString = new Matrix();
      paramString.preRotate(paramInt);
      localBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), paramString, true);
      paramString = (String)localObject;
    } while (localObject == localBitmap);
    if (!((Bitmap)localObject).isRecycled()) {
      ((Bitmap)localObject).recycle();
    }
    return localBitmap;
  }
  
  public static void b(long paramLong)
  {
    try
    {
      SharedPreferences.Editor localEditor = cy.a().c(RqdApplication.l()).edit();
      String str1 = cm.d();
      a locala = new a();
      String str2 = Long.toString(paramLong);
      byte[] arrayOfByte = locala.b(str2.getBytes("UTF8"), com.tencent.token.utils.encrypt.c.a(str1));
      Object localObject = arrayOfByte;
      if (arrayOfByte == null) {
        localObject = locala.b(str2.getBytes("UTF8"), com.tencent.token.utils.encrypt.c.a(str1));
      }
      localObject = dg.a((byte[])localObject);
      h.a("verify_face_pwd_uin, hex=" + (String)localObject + ", key=" + str1);
      localEditor.putString("verify_face_pwd_uin", (String)localObject);
      localEditor.putString("verify_face_pwd_key", str1);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public static void b(ConfigResult paramConfigResult)
  {
    if ((paramConfigResult == null) || (paramConfigResult.mToolsTitleList == null) || (paramConfigResult.mToolsList == null) || (paramConfigResult.mToolsTitleList.length() != paramConfigResult.mToolsList.length())) {
      return;
    }
    a.mToolsTitleList = paramConfigResult.mToolsTitleList;
    a.mToolsList = paramConfigResult.mToolsList;
    h.a("storeconfig=" + a.mToolsTitleList.toString() + "\n" + a.mToolsList.toString());
    paramConfigResult = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
    paramConfigResult.putString("tools_title", a.mToolsTitleList.toString());
    paramConfigResult.putString("tools_items", a.mToolsList.toString());
    paramConfigResult.commit();
  }
  
  public static boolean b()
  {
    try
    {
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("token_version", 0);
      int j = com.tencent.token.global.c.d();
      if (i == j) {
        return false;
      }
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
      return false;
    }
    return true;
  }
  
  public static boolean b(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = RqdApplication.l().getSharedPreferences("features_file", 0).getBoolean(paramString, paramBoolean);
      return bool;
    }
    catch (Exception paramString) {}
    return paramBoolean;
  }
  
  public static void c(ConfigResult paramConfigResult)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
      localEditor.putInt("utils_flag", paramConfigResult.utilsShowFlag);
      localEditor.putFloat("face_reg_thres", paramConfigResult.mFaceRecognitionParamResult.mRegRayThres);
      localEditor.putFloat("face_verify_thres", paramConfigResult.mFaceRecognitionParamResult.mVerifyRayThres);
      localEditor.putFloat("face_disparity_thres", paramConfigResult.mFaceRecognitionParamResult.mDisparityThres);
      localEditor.putString("zzb_intro_list", paramConfigResult.zzbIntroList.toString());
      localEditor.putInt("face_algorithm", paramConfigResult.face_algorithm);
      localEditor.putInt("live_angle", paramConfigResult.live_angle);
      localEditor.putString("so_param_ids", paramConfigResult.so_param_ids);
      localEditor.putString("so_param_values", paramConfigResult.so_param_values);
      localEditor.putInt("collect_device_info", paramConfigResult.uploadDeviceInfoInt);
      localEditor.putInt("use_face_start", paramConfigResult.useFaceStart);
      localEditor.putInt("use_face_chpwd", paramConfigResult.useFaceChpwd);
      localEditor.putInt("use_face_chmobile", paramConfigResult.useFaceChmobile);
      localEditor.commit();
      return;
    }
    catch (Exception paramConfigResult)
    {
      h.c("SharedPreferences msg " + paramConfigResult.getMessage());
    }
  }
  
  public static boolean c()
  {
    try
    {
      boolean bool = RqdApplication.l().getSharedPreferences("features_file", 0).getBoolean("start_camera", false);
      return bool;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return false;
  }
  
  /* Error */
  public static boolean c(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 51	com/tencent/token/utils/x:d	Z
    //   3: ifeq +7 -> 10
    //   6: getstatic 53	com/tencent/token/utils/x:e	Z
    //   9: ireturn
    //   10: aload_0
    //   11: invokevirtual 767	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   14: ldc_w 769
    //   17: invokevirtual 774	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   20: astore_0
    //   21: aload_0
    //   22: ldc_w 776
    //   25: iconst_0
    //   26: anewarray 567	java/lang/Class
    //   29: invokevirtual 780	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   32: aload_0
    //   33: iconst_0
    //   34: anewarray 4	java/lang/Object
    //   37: invokevirtual 786	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 788	java/lang/Boolean
    //   43: invokevirtual 791	java/lang/Boolean:booleanValue	()Z
    //   46: istore_2
    //   47: iload_2
    //   48: istore_1
    //   49: new 67	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 793
    //   59: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: iload_2
    //   63: invokevirtual 796	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   66: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 99	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   72: iconst_1
    //   73: putstatic 51	com/tencent/token/utils/x:d	Z
    //   76: iload_2
    //   77: putstatic 53	com/tencent/token/utils/x:e	Z
    //   80: iload_2
    //   81: ireturn
    //   82: astore_0
    //   83: iconst_0
    //   84: istore_2
    //   85: iload_2
    //   86: istore_1
    //   87: ldc_w 798
    //   90: invokestatic 99	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   93: iconst_1
    //   94: putstatic 51	com/tencent/token/utils/x:d	Z
    //   97: iload_2
    //   98: putstatic 53	com/tencent/token/utils/x:e	Z
    //   101: iload_2
    //   102: ireturn
    //   103: astore_0
    //   104: iconst_0
    //   105: istore_2
    //   106: iload_2
    //   107: istore_1
    //   108: ldc_w 800
    //   111: invokestatic 99	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   114: iconst_1
    //   115: putstatic 51	com/tencent/token/utils/x:d	Z
    //   118: iload_2
    //   119: putstatic 53	com/tencent/token/utils/x:e	Z
    //   122: iload_2
    //   123: ireturn
    //   124: astore_0
    //   125: iconst_0
    //   126: istore_2
    //   127: iload_2
    //   128: istore_1
    //   129: ldc_w 802
    //   132: invokestatic 99	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   135: iconst_1
    //   136: putstatic 51	com/tencent/token/utils/x:d	Z
    //   139: iload_2
    //   140: putstatic 53	com/tencent/token/utils/x:e	Z
    //   143: iload_2
    //   144: ireturn
    //   145: astore_0
    //   146: iconst_0
    //   147: istore_1
    //   148: iconst_1
    //   149: putstatic 51	com/tencent/token/utils/x:d	Z
    //   152: iload_1
    //   153: putstatic 53	com/tencent/token/utils/x:e	Z
    //   156: iload_1
    //   157: ireturn
    //   158: astore_0
    //   159: goto -11 -> 148
    //   162: astore_0
    //   163: goto -36 -> 127
    //   166: astore_0
    //   167: goto -61 -> 106
    //   170: astore_0
    //   171: goto -86 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramContext	Context
    //   48	109	1	bool1	boolean
    //   46	98	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   10	47	82	java/lang/ClassNotFoundException
    //   10	47	103	java/lang/NoSuchMethodException
    //   10	47	124	java/lang/Exception
    //   10	47	145	finally
    //   49	72	158	finally
    //   87	93	158	finally
    //   108	114	158	finally
    //   129	135	158	finally
    //   49	72	162	java/lang/Exception
    //   49	72	166	java/lang/NoSuchMethodException
    //   49	72	170	java/lang/ClassNotFoundException
  }
  
  private static boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("unknow"));
  }
  
  public static long d()
  {
    try
    {
      long l = RqdApplication.l().getSharedPreferences("features_file", 0).getLong("dns_time", 0L);
      return l;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return 0L;
  }
  
  public static long e()
  {
    try
    {
      Object localObject = cy.a().c(RqdApplication.l());
      a locala = new a();
      String str = ((SharedPreferences)localObject).getString("verify_face_pwd_key", "");
      localObject = ((SharedPreferences)localObject).getString("verify_face_pwd_uin", "");
      if (!n())
      {
        b(0L);
        return 0L;
      }
      if ((str != null) && (str.length() != 0) && (localObject != null) && (((String)localObject).length() != 0))
      {
        byte[] arrayOfByte2 = dg.a((String)localObject);
        byte[] arrayOfByte1 = locala.a(arrayOfByte2, com.tencent.token.utils.encrypt.c.a(str));
        localObject = arrayOfByte1;
        if (arrayOfByte1 == null) {
          localObject = locala.a(arrayOfByte2, com.tencent.token.utils.encrypt.c.a(str));
        }
        localObject = new String((byte[])localObject, "UTF8");
        if ((localObject != null) && (((String)localObject).length() != 0))
        {
          h.a("facepwd verify uin=" + (String)localObject);
          long l = Long.parseLong((String)localObject);
          return l;
        }
      }
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return 0L;
  }
  
  public static QQUser f()
  {
    try
    {
      long l = e();
      if (l == 0L) {
        return null;
      }
      QQUser localQQUser = do.a().d(l);
      return localQQUser;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
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
      QQUser localQQUser = do.a().c(w.f(l));
      return localQQUser;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return null;
  }
  
  public static FaceRecognitionParamResult h()
  {
    FaceRecognitionParamResult localFaceRecognitionParamResult = new FaceRecognitionParamResult();
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.l().getSharedPreferences("features_file", 0);
      localFaceRecognitionParamResult.mRegRayThres = localSharedPreferences.getFloat("face_reg_thres", 0.1F);
      localFaceRecognitionParamResult.mVerifyRayThres = localSharedPreferences.getFloat("face_verify_thres", 0.1F);
      localFaceRecognitionParamResult.mDisparityThres = localSharedPreferences.getFloat("face_disparity_thres", 2.0F);
      h.a("faceparams: " + localFaceRecognitionParamResult.mRegRayThres + "," + localFaceRecognitionParamResult.mVerifyRayThres + "," + localFaceRecognitionParamResult.mDisparityThres);
      return localFaceRecognitionParamResult;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
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
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("face_algorithm", 1);
      return i;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
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
      JSONArray localJSONArray = new JSONArray(RqdApplication.l().getSharedPreferences("features_file", 0).getString("tools_title", null));
      return localJSONArray;
    }
    catch (Exception localException) {}
    return null;
  }
  
  /* Error */
  public static ArrayList k()
  {
    // Byte code:
    //   0: new 664	org/json/JSONArray
    //   3: dup
    //   4: invokestatic 28	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
    //   7: ldc 59
    //   9: iconst_0
    //   10: invokevirtual 65	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   13: ldc_w 674
    //   16: aconst_null
    //   17: invokeinterface 243 3 0
    //   22: invokespecial 867	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: new 871	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 872	java/util/ArrayList:<init>	()V
    //   34: astore_3
    //   35: aload 4
    //   37: ifnull +90 -> 127
    //   40: aload 4
    //   42: invokevirtual 665	org/json/JSONArray:length	()I
    //   45: iflt +82 -> 127
    //   48: iconst_0
    //   49: istore_0
    //   50: aload_3
    //   51: astore_2
    //   52: iload_0
    //   53: aload 4
    //   55: invokevirtual 665	org/json/JSONArray:length	()I
    //   58: if_icmpge +71 -> 129
    //   61: aload 4
    //   63: iload_0
    //   64: invokevirtual 876	org/json/JSONArray:getJSONArray	(I)Lorg/json/JSONArray;
    //   67: astore_2
    //   68: new 871	java/util/ArrayList
    //   71: dup
    //   72: invokespecial 872	java/util/ArrayList:<init>	()V
    //   75: astore 5
    //   77: iconst_0
    //   78: istore_1
    //   79: iload_1
    //   80: aload_2
    //   81: invokevirtual 665	org/json/JSONArray:length	()I
    //   84: if_icmpge +28 -> 112
    //   87: aload 5
    //   89: new 878	com/tencent/token/core/bean/i
    //   92: dup
    //   93: aload_2
    //   94: iload_1
    //   95: invokevirtual 882	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   98: invokespecial 884	com/tencent/token/core/bean/i:<init>	(Lorg/json/JSONObject;)V
    //   101: invokevirtual 888	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   104: pop
    //   105: iload_1
    //   106: iconst_1
    //   107: iadd
    //   108: istore_1
    //   109: goto -30 -> 79
    //   112: aload_3
    //   113: aload 5
    //   115: invokevirtual 888	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   118: pop
    //   119: iload_0
    //   120: iconst_1
    //   121: iadd
    //   122: istore_0
    //   123: goto -73 -> 50
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_2
    //   130: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	74	0	i	int
    //   78	31	1	j	int
    //   51	43	2	localObject	Object
    //   126	1	2	localException	Exception
    //   128	2	2	localArrayList1	ArrayList
    //   34	79	3	localArrayList2	ArrayList
    //   25	37	4	localJSONArray	JSONArray
    //   75	39	5	localArrayList3	ArrayList
    // Exception table:
    //   from	to	target	type
    //   0	35	126	java/lang/Exception
    //   40	48	126	java/lang/Exception
    //   52	77	126	java/lang/Exception
    //   79	105	126	java/lang/Exception
    //   112	119	126	java/lang/Exception
  }
  
  public static ArrayList l()
  {
    int i = 0;
    Object localObject;
    if (a.zzbIntroItemlist != null) {
      localObject = a.zzbIntroItemlist;
    }
    for (;;)
    {
      return localObject;
      localObject = RqdApplication.l().getSharedPreferences("features_file", 0).getString("zzb_intro_list", null);
      try
      {
        JSONArray localJSONArray = new JSONArray((String)localObject);
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          ArrayList localArrayList = new ArrayList();
          for (;;)
          {
            localObject = localArrayList;
            if (i >= localJSONArray.length()) {
              break;
            }
            localArrayList.add(new ZzbIntroItem(localJSONArray.getJSONObject(i)));
            i += 1;
          }
        }
        return null;
      }
      catch (Exception localException) {}
    }
  }
  
  public static boolean m()
  {
    try
    {
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("collect_device_info", 0);
      return i == 1;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return false;
  }
  
  public static boolean n()
  {
    try
    {
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("use_face_start", 0);
      return i == 1;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return false;
  }
  
  public static boolean o()
  {
    try
    {
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("use_face_chpwd", 0);
      return i == 1;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return false;
  }
  
  public static boolean p()
  {
    try
    {
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("use_face_chmobile", 0);
      return i == 1;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return false;
  }
  
  public static String q()
  {
    try
    {
      String str = RqdApplication.l().getSharedPreferences("features_file", 0).getString("so_param_ids", "");
      return str;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return "";
  }
  
  public static String r()
  {
    try
    {
      String str = RqdApplication.l().getSharedPreferences("features_file", 0).getString("so_param_values", "");
      return str;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return "";
  }
  
  public static int s()
  {
    try
    {
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("live_angle", 21);
      return i;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return 0;
  }
  
  public static int t()
  {
    try
    {
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("displayAngle_face", -1);
      return i;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return -1;
  }
  
  public static int u()
  {
    try
    {
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("imageAngle_face", -1);
      return i;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return -1;
  }
  
  public static boolean v()
  {
    try
    {
      boolean bool = RqdApplication.l().getSharedPreferences("features_file", 0).getBoolean("show_bright_tip", false);
      return bool;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
    return true;
  }
  
  public static void w()
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
      localEditor.putBoolean("show_bright_tip", true);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public static String x()
  {
    String str1 = "";
    if (c(Build.MANUFACTURER)) {
      str1 = "" + Build.MANUFACTURER;
    }
    String str2 = str1;
    if (c(Build.MODEL)) {
      str2 = str1 + Build.MODEL;
    }
    return str2;
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
    catch (Exception localException)
    {
      return 1;
    }
    catch (NullPointerException localNullPointerException)
    {
      return 1;
    }
    catch (SecurityException localSecurityException) {}
    return 1;
  }
  
  public static int z()
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      try
      {
        if (k < y())
        {
          Object localObject1 = new File("/sys/devices/system/cpu/cpu" + k + "/cpufreq/cpuinfo_max_freq");
          j = i;
          if (((File)localObject1).exists())
          {
            Object localObject2 = new byte[''];
            localObject1 = new FileInputStream((File)localObject1);
            try
            {
              ((FileInputStream)localObject1).read((byte[])localObject2);
              j = 0;
              while ((localObject2[j] >= 48) && (localObject2[j] <= 57) && (j < localObject2.length)) {
                j += 1;
              }
              localObject2 = Integer.valueOf(Integer.parseInt(new String((byte[])localObject2, 0, j)));
              j = i;
              if (((Integer)localObject2).intValue() > i) {
                j = ((Integer)localObject2).intValue();
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              ((FileInputStream)localObject1).close();
              j = i;
            }
            finally
            {
              ((FileInputStream)localObject1).close();
            }
          }
          k += 1;
          i = j;
        }
      }
      catch (IOException localIOException)
      {
        j = 0;
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.x
 * JD-Core Version:    0.7.0.1
 */