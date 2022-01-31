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
import android.media.ExifInterface;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.token.ag;
import com.tencent.token.ah;
import com.tencent.token.ap;
import com.tencent.token.ax;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.bean.FaceRecognitionParamResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.utils.encrypt.a;
import com.tencent.token.utils.encrypt.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.json.JSONArray;

public final class t
{
  public static ConfigResult a = new ConfigResult();
  public static int b = 600;
  private static ImageCache c = new ImageCache(2, RqdApplication.i());
  private static final FileFilter d = new u();
  
  public static long a(int paramInt, long paramLong)
  {
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.i().getSharedPreferences("features_file", 0);
      if (paramInt == 1) {}
      for (String str = "" + paramLong + "_login";; str = "" + paramLong + "_op") {
        return localSharedPreferences.getLong(str, 0L);
      }
      return 0L;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
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
  
  public static Bitmap a(Resources paramResources, int paramInt, float paramFloat1, float paramFloat2)
  {
    paramResources = a(paramResources, paramInt);
    if (paramResources == null) {
      return null;
    }
    paramInt = paramResources.getWidth();
    int i = paramResources.getHeight();
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(paramFloat1, paramFloat2);
    try
    {
      localObject = Bitmap.createBitmap(paramResources, 0, 0, paramInt, i, (Matrix)localObject, true);
      paramResources.recycle();
      return localObject;
    }
    catch (OutOfMemoryError paramResources)
    {
      return null;
    }
    catch (Exception paramResources) {}
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
    float f = paramInt2 / paramInt1;
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(f, f);
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
  
  public static void a()
  {
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.i().getSharedPreferences("features_file", 0);
      a.mStartUpImgStartTime = localSharedPreferences.getLong("startup_start_time", 0L);
      a.mStartUpImgEndTime = localSharedPreferences.getLong("startup_end_time", 0L);
      a.mStartUpImgUrl = localSharedPreferences.getString("startup_img_url", "");
      long l = ag.c().r() / 1000L;
      if ((a.mStartUpImgStartTime != 0L) && (a.mStartUpImgEndTime != 0L) && (l >= a.mStartUpImgStartTime) && (l <= a.mStartUpImgEndTime)) {}
      for (a.mStartUpImg = c.b(c.c("startup_img"));; a.mStartUpImg = null)
      {
        e.c("startup current=" + l + ", start=" + a.mStartUpImgStartTime + ", end=" + a.mStartUpImgEndTime + ", url=" + a.mStartUpImgUrl + ", img=" + a.mStartUpImg);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
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
        SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("features_file", 0).edit();
        localEditor.putLong(str, paramLong2);
        localEditor.commit();
        return;
      }
      catch (Exception localException)
      {
        String str;
        e.c("SharedPreferences msg " + localException.getMessage());
      }
      str = "" + paramLong1 + "_op";
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("features_file", 0).edit();
      localEditor.putLong("dns_time", paramLong);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public static void a(Activity paramActivity)
  {
    ((InputMethodManager)paramActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramActivity.getWindow().peekDecorView().getWindowToken(), 0);
  }
  
  public static void a(ConfigResult paramConfigResult)
  {
    if ((paramConfigResult == null) || (paramConfigResult.mStartUpImgUrl == null) || (paramConfigResult.mStartUpImg == null)) {
      return;
    }
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("features_file", 0).edit();
      localEditor.putLong("startup_start_time", paramConfigResult.mStartUpImgStartTime);
      localEditor.putLong("startup_end_time", paramConfigResult.mStartUpImgEndTime);
      localEditor.putString("startup_img_url", paramConfigResult.mStartUpImgUrl);
      localEditor.commit();
      ImageCache.a(c.c("startup_img"));
      c.a(c.c("startup_img"), paramConfigResult.mStartUpImg);
      paramConfigResult.mStartUpImg.recycle();
      paramConfigResult.mStartUpImg = null;
      return;
    }
    catch (Exception paramConfigResult)
    {
      e.c("SharedPreferences msg " + paramConfigResult.getMessage());
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    Object localObject = RqdApplication.i();
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
      e.c("SharedPreferences msg " + paramString.getMessage());
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("features_file", 0).edit();
      localEditor.putBoolean("start_camera", paramBoolean);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    Runtime.getRuntime().freeMemory();
    Runtime.getRuntime().maxMemory();
    Runtime.getRuntime().totalMemory();
    if (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() - 4194304L < paramInt1 * paramInt2 * 4 * 1)
    {
      e.b("use low quality:mem=" + (Runtime.getRuntime().maxMemory() - 10485760L) + " " + paramInt1 + "*" + paramInt2 + "*4*" + 1 + "=" + paramInt1 * paramInt2 * 4 * 1);
      return true;
    }
    return false;
  }
  
  public static byte[] a(String paramString)
  {
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    int j = (int)Math.max(((BitmapFactory.Options)localObject).outWidth / 960.0F, ((BitmapFactory.Options)localObject).outHeight / 960.0F);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (localObject == null) {
      return null;
    }
    i = c(paramString);
    paramString = (String)localObject;
    if (i != 0)
    {
      paramString = new Matrix();
      paramString.preRotate(i);
      Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), paramString, true);
      paramString = (String)localObject;
      if (localObject != localBitmap)
      {
        if (!((Bitmap)localObject).isRecycled()) {
          ((Bitmap)localObject).recycle();
        }
        paramString = localBitmap;
      }
    }
    localObject = new ByteArrayOutputStream();
    try
    {
      paramString.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject);
      i = 80;
      while (((ByteArrayOutputStream)localObject).size() > 153600)
      {
        i -= 20;
        ((ByteArrayOutputStream)localObject).reset();
        paramString.compress(Bitmap.CompressFormat.JPEG, i, (OutputStream)localObject);
      }
      try
      {
        ((ByteArrayOutputStream)localObject).close();
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
        ((ByteArrayOutputStream)localObject).close();
        for (;;)
        {
          return ((ByteArrayOutputStream)localObject).toByteArray();
          try
          {
            ((ByteArrayOutputStream)localObject).close();
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
          e.c("BitmapFactory.decodeFile failed...");
          return null;
        }
        paramInt = c(paramString);
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
      ah.a();
      SharedPreferences.Editor localEditor = ah.h().edit();
      String str1 = com.tencent.token.u.b();
      a locala = new a();
      String str2 = Long.toString(paramLong);
      byte[] arrayOfByte = locala.b(str2.getBytes("UTF8"), c.a(str1));
      Object localObject = arrayOfByte;
      if (arrayOfByte == null) {
        localObject = locala.b(str2.getBytes("UTF8"), c.a(str1));
      }
      localObject = ap.a((byte[])localObject);
      e.a("verify_face_pwd_uin, hex=" + (String)localObject + ", key=" + str1);
      localEditor.putString("verify_face_pwd_uin", (String)localObject);
      localEditor.putString("verify_face_pwd_key", str1);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public static void b(ConfigResult paramConfigResult)
  {
    if (paramConfigResult == null) {
      return;
    }
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.i().getSharedPreferences("features_file", 0);
      paramConfigResult.mActivityName = localSharedPreferences.getString("activity_name", "");
      paramConfigResult.mActivityUrl = localSharedPreferences.getString("activity_url", "");
      paramConfigResult.mActivityVersion = localSharedPreferences.getInt("activity_version", 0);
      paramConfigResult.headlinetip = localSharedPreferences.getString("headline_tip", "");
      paramConfigResult.headlineurl = localSharedPreferences.getString("headline_url", "");
      paramConfigResult.headlineVersion = localSharedPreferences.getInt("headline_version", 0);
      paramConfigResult.fucntionItemlist = n();
      return;
    }
    catch (Exception paramConfigResult)
    {
      e.c("SharedPreferences msg " + paramConfigResult.getMessage());
    }
  }
  
  public static boolean b()
  {
    try
    {
      int i = RqdApplication.i().getSharedPreferences("features_file", 0).getInt("token_version", 0);
      int j = b.b();
      if (i == j) {
        return false;
      }
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
      return false;
    }
    return true;
  }
  
  public static byte[] b(String paramString)
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
  
  private static int c(String paramString)
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
  
  public static void c(ConfigResult paramConfigResult)
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("features_file", 0).edit();
      localEditor.putInt("utils_flag", paramConfigResult.utilsShowFlag);
      localEditor.putString("activity_name", paramConfigResult.mActivityName);
      localEditor.putString("activity_url", paramConfigResult.mActivityUrl);
      localEditor.putInt("activity_version", paramConfigResult.mActivityVersion);
      localEditor.putString("headline_tip", paramConfigResult.headlinetip);
      localEditor.putString("headline_url", paramConfigResult.headlineurl);
      localEditor.putInt("headline_version", paramConfigResult.headlineVersion);
      localEditor.putFloat("face_reg_thres", paramConfigResult.mFaceRecognitionParamResult.mRegRayThres);
      localEditor.putFloat("face_verify_thres", paramConfigResult.mFaceRecognitionParamResult.mVerifyRayThres);
      localEditor.putFloat("face_disparity_thres", paramConfigResult.mFaceRecognitionParamResult.mDisparityThres);
      localEditor.putString("fucntion_list", paramConfigResult.fucntionlist.toString());
      localEditor.putString("banner_list", paramConfigResult.bannerlist.toString());
      localEditor.putInt("face_algorithm", paramConfigResult.face_algorithm);
      localEditor.putInt("displayAngle", paramConfigResult.displayAngle);
      localEditor.putInt("imageAngle", paramConfigResult.imageAngle);
      localEditor.commit();
      return;
    }
    catch (Exception paramConfigResult)
    {
      e.c("SharedPreferences msg " + paramConfigResult.getMessage());
    }
  }
  
  public static boolean c()
  {
    try
    {
      boolean bool = RqdApplication.i().getSharedPreferences("features_file", 0).getBoolean("start_camera", false);
      return bool;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
    return false;
  }
  
  public static long d()
  {
    try
    {
      long l = RqdApplication.i().getSharedPreferences("features_file", 0).getLong("dns_time", 0L);
      return l;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
    return 0L;
  }
  
  public static long e()
  {
    try
    {
      ah.a();
      Object localObject = ah.h();
      a locala = new a();
      String str = ((SharedPreferences)localObject).getString("verify_face_pwd_key", "");
      localObject = ((SharedPreferences)localObject).getString("verify_face_pwd_uin", "");
      if ((str != null) && (str.length() != 0) && (localObject != null))
      {
        if (((String)localObject).length() == 0) {
          return 0L;
        }
        byte[] arrayOfByte2 = ap.a((String)localObject);
        byte[] arrayOfByte1 = locala.a(arrayOfByte2, c.a(str));
        localObject = arrayOfByte1;
        if (arrayOfByte1 == null) {
          localObject = locala.a(arrayOfByte2, c.a(str));
        }
        localObject = new String((byte[])localObject, "UTF8");
        if (((String)localObject).length() != 0)
        {
          e.a("facepwd verify uin=" + (String)localObject);
          long l = Long.parseLong((String)localObject);
          return l;
        }
      }
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
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
      QQUser localQQUser = ax.a().d(l);
      return localQQUser;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
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
      QQUser localQQUser = ax.a().c(s.f(l));
      return localQQUser;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
    return null;
  }
  
  public static void h()
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("features_file", 0).edit();
      localEditor.putBoolean("intro_login_dialog", true);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public static boolean i()
  {
    boolean bool = false;
    try
    {
      int i = RqdApplication.i().getSharedPreferences("features_file", 0).getInt("intro_facepk_dialog", 0);
      if (i <= 2) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
    return false;
  }
  
  public static void j()
  {
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.i().getSharedPreferences("features_file", 0);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putInt("intro_facepk_dialog", localSharedPreferences.getInt("intro_facepk_dialog", 0) + 1);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  public static FaceRecognitionParamResult k()
  {
    FaceRecognitionParamResult localFaceRecognitionParamResult = new FaceRecognitionParamResult();
    try
    {
      SharedPreferences localSharedPreferences = RqdApplication.i().getSharedPreferences("features_file", 0);
      localFaceRecognitionParamResult.mRegRayThres = localSharedPreferences.getFloat("face_reg_thres", 0.1F);
      localFaceRecognitionParamResult.mVerifyRayThres = localSharedPreferences.getFloat("face_verify_thres", 0.1F);
      localFaceRecognitionParamResult.mDisparityThres = localSharedPreferences.getFloat("face_disparity_thres", 2.0F);
      e.a("faceparams: " + localFaceRecognitionParamResult.mRegRayThres + "," + localFaceRecognitionParamResult.mVerifyRayThres + "," + localFaceRecognitionParamResult.mDisparityThres);
      return localFaceRecognitionParamResult;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
      localFaceRecognitionParamResult.mRegRayThres = 0.1F;
      localFaceRecognitionParamResult.mVerifyRayThres = 0.1F;
      localFaceRecognitionParamResult.mDisparityThres = 2.0F;
    }
    return localFaceRecognitionParamResult;
  }
  
  public static int l()
  {
    try
    {
      int i = RqdApplication.i().getSharedPreferences("features_file", 0).getInt("face_algorithm", 1);
      return i;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
    return 0;
  }
  
  /* Error */
  public static java.util.ArrayList m()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: invokestatic 22	com/tencent/token/global/RqdApplication:i	()Landroid/content/Context;
    //   5: ldc 48
    //   7: iconst_0
    //   8: invokevirtual 54	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   11: ldc_w 601
    //   14: aconst_null
    //   15: invokeinterface 212 3 0
    //   20: astore_1
    //   21: new 598	org/json/JSONArray
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 679	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual 680	org/json/JSONArray:length	()I
    //   34: ifle +46 -> 80
    //   37: new 682	java/util/ArrayList
    //   40: dup
    //   41: invokespecial 683	java/util/ArrayList:<init>	()V
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: iload_0
    //   48: aload_3
    //   49: invokevirtual 680	org/json/JSONArray:length	()I
    //   52: if_icmpge +30 -> 82
    //   55: aload_2
    //   56: new 685	com/tencent/token/core/bean/a
    //   59: dup
    //   60: aload_3
    //   61: iload_0
    //   62: invokevirtual 689	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   65: invokespecial 692	com/tencent/token/core/bean/a:<init>	(Lorg/json/JSONObject;)V
    //   68: invokevirtual 696	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   71: pop
    //   72: iload_0
    //   73: iconst_1
    //   74: iadd
    //   75: istore_0
    //   76: goto -31 -> 45
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	75	0	i	int
    //   20	27	1	localObject	Object
    //   79	1	1	localException	Exception
    //   81	2	1	localArrayList1	java.util.ArrayList
    //   44	12	2	localArrayList2	java.util.ArrayList
    //   29	32	3	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   21	45	79	java/lang/Exception
    //   47	72	79	java/lang/Exception
  }
  
  /* Error */
  public static java.util.ArrayList n()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: invokestatic 22	com/tencent/token/global/RqdApplication:i	()Landroid/content/Context;
    //   5: ldc 48
    //   7: iconst_0
    //   8: invokevirtual 54	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   11: ldc_w 592
    //   14: aconst_null
    //   15: invokeinterface 212 3 0
    //   20: astore_1
    //   21: new 598	org/json/JSONArray
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 679	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual 680	org/json/JSONArray:length	()I
    //   34: ifle +46 -> 80
    //   37: new 682	java/util/ArrayList
    //   40: dup
    //   41: invokespecial 683	java/util/ArrayList:<init>	()V
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: iload_0
    //   48: aload_3
    //   49: invokevirtual 680	org/json/JSONArray:length	()I
    //   52: if_icmpge +30 -> 82
    //   55: aload_2
    //   56: new 698	com/tencent/token/core/bean/UtilFucntionItem
    //   59: dup
    //   60: aload_3
    //   61: iload_0
    //   62: invokevirtual 689	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   65: invokespecial 699	com/tencent/token/core/bean/UtilFucntionItem:<init>	(Lorg/json/JSONObject;)V
    //   68: invokevirtual 696	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   71: pop
    //   72: iload_0
    //   73: iconst_1
    //   74: iadd
    //   75: istore_0
    //   76: goto -31 -> 45
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	75	0	i	int
    //   20	27	1	localObject	Object
    //   79	1	1	localException	Exception
    //   81	2	1	localArrayList1	java.util.ArrayList
    //   44	12	2	localArrayList2	java.util.ArrayList
    //   29	32	3	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   21	45	79	java/lang/Exception
    //   47	72	79	java/lang/Exception
  }
  
  public static int o()
  {
    try
    {
      int i = RqdApplication.i().getSharedPreferences("features_file", 0).getInt("displayAngle", 0);
      return i;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
    return 0;
  }
  
  public static int p()
  {
    try
    {
      int i = RqdApplication.i().getSharedPreferences("features_file", 0).getInt("imageAngle", 0);
      return i;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
    return 0;
  }
  
  public static String q()
  {
    int j = 1;
    String str1 = "";
    String str2 = Build.MANUFACTURER;
    if ((!TextUtils.isEmpty(str2)) && (!str2.startsWith("unknow")))
    {
      i = 1;
      if (i != 0) {
        str1 = "" + Build.MANUFACTURER;
      }
      str2 = Build.MODEL;
      if ((TextUtils.isEmpty(str2)) || (str2.startsWith("unknow"))) {
        break label111;
      }
    }
    label111:
    for (int i = j;; i = 0)
    {
      str2 = str1;
      if (i != 0) {
        str2 = str1 + Build.MODEL;
      }
      return str2;
      i = 0;
      break;
    }
  }
  
  public static int r()
  {
    if (Build.VERSION.SDK_INT <= 10) {
      return 1;
    }
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(d).length;
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
  
  public static int s()
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      try
      {
        if (k < r())
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
 * Qualified Name:     com.tencent.token.utils.t
 * JD-Core Version:    0.7.0.1
 */