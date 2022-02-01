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
import com.tencent.token.bx;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.cj;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.bean.FaceRecognitionParamResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.ZzbIntroItem;
import com.tencent.token.cr;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.encrypt.a;
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

public class m
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
    g = new FileFilter()
    {
      public boolean accept(File paramAnonymousFile)
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
      localObject2 = RqdApplication.l().getSharedPreferences("features_file", 0);
      Object localObject1;
      if (paramInt == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("_login");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("_op");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      paramLong = ((SharedPreferences)localObject2).getLong((String)localObject1, 0L);
      return paramLong;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SharedPreferences msg ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      com.tencent.token.global.g.c(((StringBuilder)localObject2).toString());
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
      Object localObject = RqdApplication.l().getSharedPreferences("features_file", 0);
      a.mStartUpImgStartTime = ((SharedPreferences)localObject).getLong("startup_start_time", 0L);
      a.mStartUpImgEndTime = ((SharedPreferences)localObject).getLong("startup_end_time", 0L);
      a.mStartUpImgUrl = ((SharedPreferences)localObject).getString("startup_img_url", "");
      long l = cc.c().s() / 1000L;
      if ((a.mStartUpImgStartTime != 0L) && (a.mStartUpImgEndTime != 0L) && (l >= a.mStartUpImgStartTime) && (l <= a.mStartUpImgEndTime)) {
        a.mStartUpImg = f.b(f.c("startup_img"));
      } else {
        a.mStartUpImg = null;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startup current=");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(", start=");
      ((StringBuilder)localObject).append(a.mStartUpImgStartTime);
      ((StringBuilder)localObject).append(", end=");
      ((StringBuilder)localObject).append(a.mStartUpImgEndTime);
      ((StringBuilder)localObject).append(", url=");
      ((StringBuilder)localObject).append(a.mStartUpImgUrl);
      ((StringBuilder)localObject).append(", img=");
      ((StringBuilder)localObject).append(a.mStartUpImg);
      com.tencent.token.global.g.c(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
      a.mStartUpImg = null;
    }
  }
  
  public static void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt == 1) {}
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append("_login");
      localObject1 = ((StringBuilder)localObject1).toString();
      break label86;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append("_op");
      localObject1 = ((StringBuilder)localObject1).toString();
      label86:
      localObject2 = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
      ((SharedPreferences.Editor)localObject2).putLong((String)localObject1, paramLong2);
      ((SharedPreferences.Editor)localObject2).commit();
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SharedPreferences msg ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      com.tencent.token.global.g.c(((StringBuilder)localObject2).toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
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
      if ((Build.VERSION.SDK_INT >= 21) && (c(paramActivity)))
      {
        paramActivity.getWindow().setStatusBarColor(paramActivity.getResources().getColor(paramInt));
        return;
      }
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
        return;
      }
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
        localObject = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
        ((SharedPreferences.Editor)localObject).putLong("startup_start_time", paramConfigResult.mStartUpImgStartTime);
        ((SharedPreferences.Editor)localObject).putLong("startup_end_time", paramConfigResult.mStartUpImgEndTime);
        ((SharedPreferences.Editor)localObject).putString("startup_img_url", paramConfigResult.mStartUpImgUrl);
        ((SharedPreferences.Editor)localObject).commit();
        f.a(f.c("startup_img"));
        f.a(f.c("startup_img"), paramConfigResult.mStartUpImg);
        paramConfigResult.mStartUpImg.recycle();
        paramConfigResult.mStartUpImg = null;
        return;
      }
      catch (Exception paramConfigResult)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SharedPreferences msg ");
        ((StringBuilder)localObject).append(paramConfigResult.getMessage());
        com.tencent.token.global.g.c(((StringBuilder)localObject).toString());
        return;
      }
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SharedPreferences msg ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      com.tencent.token.global.g.c(((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    try
    {
      localObject = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(paramString, paramBoolean);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SharedPreferences msg ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      com.tencent.token.global.g.c(((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    try
    {
      localObject = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("displayAngle");
      localStringBuilder.append(paramJSONObject.getInt("displayangle"));
      com.tencent.token.global.g.a(localStringBuilder.toString());
      ((SharedPreferences.Editor)localObject).putInt("displayAngle_face", paramJSONObject.getInt("displayangle"));
      ((SharedPreferences.Editor)localObject).putInt("imageAngle_face", paramJSONObject.getInt("imageangle"));
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SharedPreferences msg ");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      com.tencent.token.global.g.c(((StringBuilder)localObject).toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = Runtime.getRuntime().maxMemory();
    long l2 = Runtime.getRuntime().totalMemory();
    int i = paramInt1 * paramInt2 * 4 * paramInt3;
    if (l1 - l2 - 4194304L < i)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("use low quality:mem=");
      localStringBuilder.append(Runtime.getRuntime().maxMemory() - 10485760L);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("*");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("*4*");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("=");
      localStringBuilder.append(i);
      com.tencent.token.global.g.b(localStringBuilder.toString());
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
  
  /* Error */
  public static byte[] a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: new 102	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 103	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: iconst_1
    //   12: putfield 499	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   15: aload_0
    //   16: aload 5
    //   18: invokestatic 503	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   21: pop
    //   22: iload_1
    //   23: ifeq +12 -> 35
    //   26: iload_1
    //   27: istore 4
    //   29: iload_2
    //   30: istore_1
    //   31: iload_2
    //   32: ifne +29 -> 61
    //   35: invokestatic 30	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
    //   38: invokevirtual 125	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   41: invokevirtual 507	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   44: astore 6
    //   46: aload 6
    //   48: getfield 512	android/util/DisplayMetrics:widthPixels	I
    //   51: istore_2
    //   52: aload 6
    //   54: getfield 515	android/util/DisplayMetrics:heightPixels	I
    //   57: istore_1
    //   58: iload_2
    //   59: istore 4
    //   61: aload 5
    //   63: getfield 518	android/graphics/BitmapFactory$Options:outWidth	I
    //   66: i2f
    //   67: iload 4
    //   69: i2f
    //   70: fdiv
    //   71: aload 5
    //   73: getfield 521	android/graphics/BitmapFactory$Options:outHeight	I
    //   76: i2f
    //   77: iload_1
    //   78: i2f
    //   79: fdiv
    //   80: invokestatic 527	java/lang/Math:max	(FF)F
    //   83: f2i
    //   84: istore_2
    //   85: iload_2
    //   86: istore_1
    //   87: iload_2
    //   88: ifgt +5 -> 93
    //   91: iconst_1
    //   92: istore_1
    //   93: aload 5
    //   95: iload_1
    //   96: putfield 121	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   99: aload 5
    //   101: iconst_0
    //   102: putfield 499	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   105: aload_0
    //   106: aload 5
    //   108: invokestatic 503	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   111: astore 5
    //   113: aload 5
    //   115: ifnonnull +5 -> 120
    //   118: aconst_null
    //   119: areturn
    //   120: aload_0
    //   121: invokestatic 529	com/tencent/token/utils/m:b	(Ljava/lang/String;)I
    //   124: istore_1
    //   125: iload_1
    //   126: ifeq +68 -> 194
    //   129: new 150	android/graphics/Matrix
    //   132: dup
    //   133: invokespecial 151	android/graphics/Matrix:<init>	()V
    //   136: astore_0
    //   137: aload_0
    //   138: iload_1
    //   139: i2f
    //   140: invokevirtual 533	android/graphics/Matrix:preRotate	(F)Z
    //   143: pop
    //   144: aload 5
    //   146: iconst_0
    //   147: iconst_0
    //   148: aload 5
    //   150: invokevirtual 145	android/graphics/Bitmap:getWidth	()I
    //   153: aload 5
    //   155: invokevirtual 148	android/graphics/Bitmap:getHeight	()I
    //   158: aload_0
    //   159: iconst_1
    //   160: invokestatic 159	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   163: astore 6
    //   165: aload 5
    //   167: aload 6
    //   169: if_acmpeq +25 -> 194
    //   172: aload 6
    //   174: astore_0
    //   175: aload 5
    //   177: invokevirtual 166	android/graphics/Bitmap:isRecycled	()Z
    //   180: ifne +17 -> 197
    //   183: aload 5
    //   185: invokevirtual 162	android/graphics/Bitmap:recycle	()V
    //   188: aload 6
    //   190: astore_0
    //   191: goto +6 -> 197
    //   194: aload 5
    //   196: astore_0
    //   197: bipush 80
    //   199: istore_1
    //   200: new 475	java/io/ByteArrayOutputStream
    //   203: dup
    //   204: invokespecial 534	java/io/ByteArrayOutputStream:<init>	()V
    //   207: astore 5
    //   209: aload_0
    //   210: getstatic 540	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   213: bipush 80
    //   215: aload 5
    //   217: invokevirtual 544	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   220: pop
    //   221: aload 5
    //   223: invokevirtual 547	java/io/ByteArrayOutputStream:size	()I
    //   226: iload_3
    //   227: if_icmple +27 -> 254
    //   230: iload_1
    //   231: bipush 20
    //   233: isub
    //   234: istore_1
    //   235: aload 5
    //   237: invokevirtual 550	java/io/ByteArrayOutputStream:reset	()V
    //   240: aload_0
    //   241: getstatic 540	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   244: iload_1
    //   245: aload 5
    //   247: invokevirtual 544	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   250: pop
    //   251: goto -30 -> 221
    //   254: aload 5
    //   256: invokevirtual 489	java/io/ByteArrayOutputStream:close	()V
    //   259: goto +25 -> 284
    //   262: astore_0
    //   263: goto +27 -> 290
    //   266: astore_0
    //   267: aload_0
    //   268: invokevirtual 351	java/lang/Exception:printStackTrace	()V
    //   271: aload 5
    //   273: invokevirtual 489	java/io/ByteArrayOutputStream:close	()V
    //   276: goto +8 -> 284
    //   279: astore_0
    //   280: aload_0
    //   281: invokevirtual 494	java/io/IOException:printStackTrace	()V
    //   284: aload 5
    //   286: invokevirtual 493	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   289: areturn
    //   290: aload 5
    //   292: invokevirtual 489	java/io/ByteArrayOutputStream:close	()V
    //   295: goto +10 -> 305
    //   298: astore 5
    //   300: aload 5
    //   302: invokevirtual 494	java/io/IOException:printStackTrace	()V
    //   305: aload_0
    //   306: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramString	String
    //   0	307	1	paramInt1	int
    //   0	307	2	paramInt2	int
    //   0	307	3	paramInt3	int
    //   27	41	4	i	int
    //   7	284	5	localObject1	Object
    //   298	3	5	localIOException	IOException
    //   44	145	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   209	221	262	finally
    //   221	230	262	finally
    //   235	251	262	finally
    //   267	271	262	finally
    //   209	221	266	java/lang/Exception
    //   221	230	266	java/lang/Exception
    //   235	251	266	java/lang/Exception
    //   254	259	279	java/io/IOException
    //   271	276	279	java/io/IOException
    //   290	295	298	java/io/IOException
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
        c = (int)paramContext.getResources().getDimension(2131034200);
        return c;
      }
    }
    return i;
  }
  
  public static int b(String paramString)
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
      paramInt = b(paramString);
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
    com.tencent.token.global.g.c("BitmapFactory.decodeFile failed...");
    return null;
  }
  
  public static void b(long paramLong)
  {
    try
    {
      SharedPreferences.Editor localEditor = cd.a().c(RqdApplication.l()).edit();
      String str1 = bx.d();
      a locala = new a();
      String str2 = Long.toString(paramLong);
      localObject2 = locala.b(str2.getBytes("UTF8"), com.tencent.token.utils.encrypt.c.a(str1));
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = locala.b(str2.getBytes("UTF8"), com.tencent.token.utils.encrypt.c.a(str1));
      }
      localObject1 = cj.a((byte[])localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("verify_face_pwd_uin, hex=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", key=");
      ((StringBuilder)localObject2).append(str1);
      com.tencent.token.global.g.a(((StringBuilder)localObject2).toString());
      localEditor.putString("verify_face_pwd_uin", (String)localObject1);
      localEditor.putString("verify_face_pwd_key", str1);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SharedPreferences msg ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      com.tencent.token.global.g.c(((StringBuilder)localObject2).toString());
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
      paramConfigResult = new StringBuilder();
      paramConfigResult.append("storeconfig=");
      paramConfigResult.append(a.mToolsTitleList.toString());
      paramConfigResult.append("\n");
      paramConfigResult.append(a.mToolsList.toString());
      com.tencent.token.global.g.a(paramConfigResult.toString());
      paramConfigResult = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
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
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("token_version", 0);
      int j = com.tencent.token.global.c.d();
      return i != j;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
    }
    return false;
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
      localObject = RqdApplication.l().getSharedPreferences("features_file", 0).edit();
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SharedPreferences msg ");
      ((StringBuilder)localObject).append(paramConfigResult.getMessage());
      com.tencent.token.global.g.c(((StringBuilder)localObject).toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
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
        paramContext = new StringBuilder();
        bool3 = bool2;
        bool4 = bool2;
        bool5 = bool2;
        bool1 = bool2;
        paramContext.append("notch screen");
        bool3 = bool2;
        bool4 = bool2;
        bool5 = bool2;
        bool1 = bool2;
        paramContext.append(bool2);
        bool3 = bool2;
        bool4 = bool2;
        bool5 = bool2;
        bool1 = bool2;
        com.tencent.token.global.g.c(paramContext.toString());
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
      com.tencent.token.global.g.c("hasNotchInScreen Exception");
      bool1 = bool5;
      continue;
      bool1 = bool4;
      com.tencent.token.global.g.c("hasNotchInScreen NoSuchMethodException");
      bool1 = bool4;
      continue;
      bool1 = bool3;
      com.tencent.token.global.g.c("hasNotchInScreen ClassNotFoundException");
      bool1 = bool3;
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static long e()
  {
    try
    {
      Object localObject1 = cd.a().c(RqdApplication.l());
      a locala = new a();
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
        byte[] arrayOfByte = cj.a((String)localObject1);
        localObject2 = locala.a(arrayOfByte, com.tencent.token.utils.encrypt.c.a(str));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = locala.a(arrayOfByte, com.tencent.token.utils.encrypt.c.a(str));
        }
        localObject1 = new String((byte[])localObject1, "UTF8");
        if (((String)localObject1).length() == 0) {
          return 0L;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("facepwd verify uin=");
        ((StringBuilder)localObject2).append((String)localObject1);
        com.tencent.token.global.g.a(((StringBuilder)localObject2).toString());
        long l = Long.parseLong((String)localObject1);
        return l;
      }
      return 0L;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SharedPreferences msg ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      com.tencent.token.global.g.c(((StringBuilder)localObject2).toString());
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
      QQUser localQQUser = cr.a().d(l);
      return localQQUser;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
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
      QQUser localQQUser = cr.a().c(l.f(l));
      return localQQUser;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
    }
    return null;
  }
  
  public static FaceRecognitionParamResult h()
  {
    FaceRecognitionParamResult localFaceRecognitionParamResult = new FaceRecognitionParamResult();
    try
    {
      Object localObject = RqdApplication.l().getSharedPreferences("features_file", 0);
      localFaceRecognitionParamResult.mRegRayThres = ((SharedPreferences)localObject).getFloat("face_reg_thres", 0.1F);
      localFaceRecognitionParamResult.mVerifyRayThres = ((SharedPreferences)localObject).getFloat("face_verify_thres", 0.1F);
      localFaceRecognitionParamResult.mDisparityThres = ((SharedPreferences)localObject).getFloat("face_disparity_thres", 2.0F);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("faceparams: ");
      ((StringBuilder)localObject).append(localFaceRecognitionParamResult.mRegRayThres);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(localFaceRecognitionParamResult.mVerifyRayThres);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(localFaceRecognitionParamResult.mDisparityThres);
      com.tencent.token.global.g.a(((StringBuilder)localObject).toString());
      return localFaceRecognitionParamResult;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
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
  
  public static ArrayList<ArrayList<com.tencent.token.core.bean.g>> k()
  {
    try
    {
      JSONArray localJSONArray1 = new JSONArray(RqdApplication.l().getSharedPreferences("features_file", 0).getString("tools_items", null));
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
            localArrayList2.add(new com.tencent.token.core.bean.g(localJSONArray2.getJSONObject(j)));
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
    Object localObject = RqdApplication.l();
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
    boolean bool = false;
    try
    {
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("collect_device_info", 0);
      if (i == 1) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean n()
  {
    boolean bool = false;
    try
    {
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("use_face_start", 0);
      if (i == 1) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean o()
  {
    boolean bool = false;
    try
    {
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("use_face_chpwd", 0);
      if (i == 1) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean p()
  {
    boolean bool = false;
    try
    {
      int i = RqdApplication.l().getSharedPreferences("features_file", 0).getInt("use_face_chmobile", 0);
      if (i == 1) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      com.tencent.token.global.g.c(localStringBuilder.toString());
    }
  }
  
  public static String x()
  {
    Object localObject1 = "";
    if (c(Build.MANUFACTURER))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(Build.MANUFACTURER);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = localObject1;
    if (c(Build.MODEL))
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
    //   5: invokestatic 936	com/tencent/token/utils/m:y	()I
    //   8: if_icmpge +172 -> 180
    //   11: new 67	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: ldc_w 938
    //   23: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_3
    //   28: iload_2
    //   29: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_3
    //   34: ldc_w 940
    //   37: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: new 468	java/io/File
    //   44: dup
    //   45: aload_3
    //   46: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 470	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore_3
    //   53: iload_0
    //   54: istore_1
    //   55: aload_3
    //   56: invokevirtual 943	java/io/File:exists	()Z
    //   59: ifeq +112 -> 171
    //   62: sipush 128
    //   65: newarray byte
    //   67: astore 4
    //   69: new 466	java/io/FileInputStream
    //   72: dup
    //   73: aload_3
    //   74: invokespecial 473	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   77: astore_3
    //   78: aload_3
    //   79: aload 4
    //   81: invokevirtual 481	java/io/FileInputStream:read	([B)I
    //   84: pop
    //   85: iconst_0
    //   86: istore_1
    //   87: aload 4
    //   89: iload_1
    //   90: baload
    //   91: bipush 48
    //   93: if_icmplt +26 -> 119
    //   96: aload 4
    //   98: iload_1
    //   99: baload
    //   100: bipush 57
    //   102: if_icmpgt +17 -> 119
    //   105: iload_1
    //   106: aload 4
    //   108: arraylength
    //   109: if_icmpge +10 -> 119
    //   112: iload_1
    //   113: iconst_1
    //   114: iadd
    //   115: istore_1
    //   116: goto -29 -> 87
    //   119: new 212	java/lang/String
    //   122: dup
    //   123: aload 4
    //   125: iconst_0
    //   126: iload_1
    //   127: invokespecial 945	java/lang/String:<init>	([BII)V
    //   130: invokestatic 590	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   133: invokestatic 949	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   136: astore 4
    //   138: iload_0
    //   139: istore_1
    //   140: aload 4
    //   142: invokevirtual 952	java/lang/Integer:intValue	()I
    //   145: iload_0
    //   146: if_icmple +9 -> 155
    //   149: aload 4
    //   151: invokevirtual 952	java/lang/Integer:intValue	()I
    //   154: istore_1
    //   155: aload_3
    //   156: invokevirtual 488	java/io/FileInputStream:close	()V
    //   159: goto +12 -> 171
    //   162: astore 4
    //   164: aload_3
    //   165: invokevirtual 488	java/io/FileInputStream:close	()V
    //   168: aload 4
    //   170: athrow
    //   171: iload_2
    //   172: iconst_1
    //   173: iadd
    //   174: istore_2
    //   175: iload_1
    //   176: istore_0
    //   177: goto -173 -> 4
    //   180: iload_0
    //   181: ireturn
    //   182: astore_3
    //   183: iconst_0
    //   184: ireturn
    //   185: astore 4
    //   187: iload_0
    //   188: istore_1
    //   189: goto -34 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	185	0	i	int
    //   54	135	1	j	int
    //   1	174	2	k	int
    //   18	147	3	localObject1	Object
    //   182	1	3	localIOException	IOException
    //   67	83	4	localObject2	Object
    //   162	7	4	localObject3	Object
    //   185	1	4	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   78	85	162	finally
    //   105	112	162	finally
    //   119	138	162	finally
    //   140	155	162	finally
    //   4	53	182	java/io/IOException
    //   55	78	182	java/io/IOException
    //   155	159	182	java/io/IOException
    //   164	171	182	java/io/IOException
    //   78	85	185	java/lang/NumberFormatException
    //   105	112	185	java/lang/NumberFormatException
    //   119	138	185	java/lang/NumberFormatException
    //   140	155	185	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.m
 * JD-Core Version:    0.7.0.1
 */