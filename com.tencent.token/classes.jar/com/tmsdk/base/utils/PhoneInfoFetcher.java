package com.tmsdk.base.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import btmsdkobf.dz;
import com.tencent.service.update.e;
import com.tmsdk.base.TMSDKBaseContext;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class PhoneInfoFetcher
{
  public static final String KEY_IMEI1 = "imei1";
  public static final String KEY_IMEI2 = "imei2";
  public static final String KEY_MEID = "meid";
  static final String TAG = "PhoneInfoFetcher";
  private static Integer cpuNum;
  private static long sTotalMemorySize = -1L;
  
  public static String getAndoidId(Context paramContext)
  {
    if (!e.a().b()) {
      return "";
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
    return "";
  }
  
  public static int getCellId()
  {
    boolean bool = e.a().b();
    int j = -1;
    if (!bool) {
      return -1;
    }
    int m = j;
    try
    {
      Object localObject = (TelephonyManager)TMSDKBaseContext.getApplicationContext().getSystemService("phone");
      int k = j;
      if (localObject != null)
      {
        m = j;
        localObject = ((TelephonyManager)localObject).getCellLocation();
        k = j;
        if (localObject != null)
        {
          int i = j;
          m = j;
          if ((localObject instanceof GsmCellLocation))
          {
            m = j;
            i = ((GsmCellLocation)localObject).getCid();
          }
          k = i;
          m = i;
          if ((localObject instanceof CdmaCellLocation))
          {
            m = i;
            k = ((CdmaCellLocation)localObject).getBaseStationId();
          }
        }
      }
      return k;
    }
    catch (Throwable localThrowable) {}
    return m;
  }
  
  public static int getCpuNum()
  {
    if (cpuNum == null) {}
    try
    {
      Object localObject = new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          return Pattern.matches("cpu[0-9]", paramAnonymousFile.getName());
        }
      };
      localObject = new File("/sys/devices/system/cpu/").listFiles((FileFilter)localObject);
      if (localObject == null) {
        return 1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CPU Count: ");
      localStringBuilder.append(localObject.length);
      Log.d("PhoneInfoFetcher", localStringBuilder.toString());
      cpuNum = Integer.valueOf(localObject.length);
      return cpuNum.intValue();
    }
    catch (Throwable localThrowable) {}
    return 1;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String getIMEI(Context paramContext)
  {
    if (!e.a().b()) {
      return "00000000000000";
    }
    Object localObject = null;
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    catch (Throwable paramContext)
    {
      Log.w("PhoneInfoFetcher", paramContext.getMessage());
      paramContext = (Context)localObject;
    }
    localObject = paramContext;
    if (paramContext == null) {
      localObject = "00000000000000";
    }
    return localObject;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String getIMSI(Context paramContext)
  {
    if (!e.a().b()) {
      return "00000000000000";
    }
    Object localObject = null;
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      if (paramContext == null) {
        return "000000000000000";
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public static Map<String, String> getImeiAndMeid(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    if (!e.a().b()) {
      return localHashMap;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    try
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("android api: ");
      ((StringBuilder)localObject3).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject3).append("\n");
      Log.i("PhoneInfoFetcher", ((StringBuilder)localObject3).toString());
      localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (Build.VERSION.SDK_INT < 21)
      {
        localObject2 = null;
        paramContext = (Context)localObject2;
      }
      else if (Build.VERSION.SDK_INT < 26)
      {
        localObject3 = localTelephonyManager.getClass().getMethod("getDeviceId", new Class[] { Integer.TYPE });
        ((Method)localObject3).setAccessible(true);
        paramContext = (String)((Method)localObject3).invoke(localTelephonyManager, new Object[] { Integer.valueOf(0) });
        if (!TextUtils.isEmpty(paramContext))
        {
          i = paramContext.length();
          if (i == 14)
          {
            localObject1 = paramContext;
            paramContext = null;
          }
          else
          {
            localObject1 = null;
          }
        }
        else
        {
          paramContext = null;
          localObject1 = paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      Object localObject3;
      TelephonyManager localTelephonyManager;
      int i;
      boolean bool;
      label284:
      break label452;
    }
    try
    {
      localObject3 = (String)((Method)localObject3).invoke(localTelephonyManager, new Object[] { Integer.valueOf(1) });
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        i = ((String)localObject3).length();
        localObject2 = localObject3;
        if (i == 14)
        {
          localObject1 = localObject3;
          localObject2 = null;
        }
      }
      else
      {
        localObject2 = null;
      }
    }
    catch (Throwable localThrowable2)
    {
      break label284;
    }
    try
    {
      bool = TextUtils.equals(paramContext, (CharSequence)localObject2);
      if (bool) {
        localObject2 = localObject4;
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    catch (Throwable localThrowable3)
    {
      break label284;
    }
    localObject3 = localObject1;
    localObject1 = localObject2;
    localObject2 = localObject3;
    break label458;
    paramContext = localTelephonyManager.getClass().getMethod("getMeid", new Class[] { Integer.TYPE });
    paramContext.setAccessible(true);
    localObject2 = (String)paramContext.invoke(localTelephonyManager, new Object[] { Integer.valueOf(0) });
    try
    {
      paramContext = localTelephonyManager.getClass().getMethod("getImei", new Class[] { Integer.TYPE });
      paramContext.setAccessible(true);
      localObject3 = (String)paramContext.invoke(localTelephonyManager, new Object[] { Integer.valueOf(0) });
    }
    catch (Throwable paramContext)
    {
      label439:
      break label447;
    }
    try
    {
      paramContext = (String)paramContext.invoke(localTelephonyManager, new Object[] { Integer.valueOf(1) });
    }
    catch (Throwable paramContext)
    {
      paramContext = localThrowable3;
      break label458;
    }
    try
    {
      bool = TextUtils.equals((CharSequence)localObject3, paramContext);
      if (bool)
      {
        paramContext = (Context)localObject3;
      }
      else
      {
        localObject1 = paramContext;
        paramContext = (Context)localObject3;
      }
    }
    catch (Throwable localThrowable1)
    {
      break label439;
    }
    localObject1 = paramContext;
    paramContext = (Context)localObject3;
    break label458;
    label447:
    paramContext = null;
    break label458;
    label452:
    localObject2 = null;
    paramContext = (Context)localObject2;
    label458:
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localHashMap.put("meid", localObject2);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      localHashMap.put("imei1", paramContext);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localHashMap.put("imei2", localObject1);
    }
    return localHashMap;
  }
  
  public static String getKernelVersion()
  {
    return getKernelVersion(true);
  }
  
  /* Error */
  public static String getKernelVersion(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 50
    //   2: astore_2
    //   3: new 238	java/io/FileInputStream
    //   6: dup
    //   7: ldc 240
    //   9: invokespecial 241	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_3
    //   13: new 243	java/io/BufferedReader
    //   16: dup
    //   17: new 245	java/io/InputStreamReader
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 248	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: sipush 8192
    //   28: invokespecial 251	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore 4
    //   33: new 111	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 50
    //   39: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload 4
    //   45: invokevirtual 255	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull +13 -> 65
    //   55: aload_1
    //   56: aload 5
    //   58: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -19 -> 43
    //   65: aload 4
    //   67: invokevirtual 258	java/io/BufferedReader:close	()V
    //   70: goto +25 -> 95
    //   73: astore_2
    //   74: aload 4
    //   76: invokevirtual 258	java/io/BufferedReader:close	()V
    //   79: aload_3
    //   80: invokevirtual 261	java/io/InputStream:close	()V
    //   83: aload_1
    //   84: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: pop
    //   88: aload_2
    //   89: athrow
    //   90: aload 4
    //   92: invokevirtual 258	java/io/BufferedReader:close	()V
    //   95: aload_3
    //   96: invokevirtual 261	java/io/InputStream:close	()V
    //   99: aload_1
    //   100: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore_3
    //   104: iload_0
    //   105: ifne +5 -> 110
    //   108: aload_3
    //   109: areturn
    //   110: aload_2
    //   111: astore_1
    //   112: aload_3
    //   113: ifnull +42 -> 155
    //   116: aload_2
    //   117: astore_1
    //   118: aload_3
    //   119: ldc 50
    //   121: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   124: ifne +31 -> 155
    //   127: aload_3
    //   128: aload_3
    //   129: ldc_w 266
    //   132: invokevirtual 270	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   135: bipush 8
    //   137: iadd
    //   138: invokevirtual 274	java/lang/String:substring	(I)Ljava/lang/String;
    //   141: astore_1
    //   142: aload_1
    //   143: iconst_0
    //   144: aload_1
    //   145: ldc_w 276
    //   148: invokevirtual 270	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   151: invokevirtual 279	java/lang/String:substring	(II)Ljava/lang/String;
    //   154: astore_1
    //   155: aload_1
    //   156: areturn
    //   157: astore_1
    //   158: ldc 50
    //   160: areturn
    //   161: astore 5
    //   163: goto -73 -> 90
    //   166: astore 4
    //   168: goto -73 -> 95
    //   171: astore 4
    //   173: goto -94 -> 79
    //   176: astore_3
    //   177: goto -94 -> 83
    //   180: astore_3
    //   181: goto -82 -> 99
    //   184: astore_1
    //   185: ldc 50
    //   187: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramBoolean	boolean
    //   42	114	1	localObject1	Object
    //   157	1	1	localThrowable1	Throwable
    //   184	1	1	localThrowable2	Throwable
    //   2	1	2	str1	String
    //   73	44	2	localObject2	Object
    //   12	117	3	localObject3	Object
    //   176	1	3	localThrowable3	Throwable
    //   180	1	3	localThrowable4	Throwable
    //   31	60	4	localBufferedReader	java.io.BufferedReader
    //   166	1	4	localThrowable5	Throwable
    //   171	1	4	localThrowable6	Throwable
    //   48	9	5	str2	String
    //   161	1	5	localThrowable7	Throwable
    // Exception table:
    //   from	to	target	type
    //   43	50	73	finally
    //   55	62	73	finally
    //   3	13	157	java/lang/Throwable
    //   43	50	161	java/lang/Throwable
    //   55	62	161	java/lang/Throwable
    //   65	70	166	java/lang/Throwable
    //   90	95	166	java/lang/Throwable
    //   74	79	171	java/lang/Throwable
    //   79	83	176	java/lang/Throwable
    //   95	99	180	java/lang/Throwable
    //   127	155	184	java/lang/Throwable
  }
  
  public static int getLac()
  {
    boolean bool = e.a().b();
    int j = -1;
    if (!bool) {
      return -1;
    }
    for (;;)
    {
      try
      {
        Object localObject = (TelephonyManager)TMSDKBaseContext.getApplicationContext().getSystemService("phone");
        i = j;
        if (localObject != null)
        {
          localObject = ((TelephonyManager)localObject).getCellLocation();
          i = j;
          if (localObject != null)
          {
            if (!(localObject instanceof GsmCellLocation)) {
              break label84;
            }
            i = ((GsmCellLocation)localObject).getLac();
            if ((localObject instanceof CdmaCellLocation))
            {
              i = ((CdmaCellLocation)localObject).getNetworkId();
              return i;
            }
          }
        }
        return i;
      }
      catch (Throwable localThrowable)
      {
        return -1;
      }
      label84:
      int i = -1;
    }
  }
  
  public static String getManufacturerRomVersion()
  {
    label269:
    String str1;
    for (;;)
    {
      try
      {
        Object localObject = Build.MANUFACTURER;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return null;
        }
        localObject = ((String)localObject).toLowerCase(Locale.ENGLISH);
        if (((String)localObject).contains("huawei")) {
          return getSystemProperties("ro.build.version.emui");
        }
        if (((String)localObject).contains("xiaomi")) {
          return getSystemProperties("ro.miui.ui.version.name");
        }
        if (((String)localObject).contains("gionee"))
        {
          localObject = getSystemProperties("ro.gn.extvernumber");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return getSystemProperties("ro.build.display.id");
          }
        }
        else
        {
          if (((String)localObject).contains("vivo"))
          {
            localObject = getSystemProperties("ro.vivo.os.name");
            String str2 = getSystemProperties("ro.vivo.os.version");
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str2)))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject);
              localStringBuilder.append("_");
              localStringBuilder.append(str2);
              return localStringBuilder.toString();
            }
            return getSystemProperties("ro.vivo.os.build.display.id");
          }
          if (((String)localObject).contains("meizu")) {
            return getSystemProperties("ro.build.display.id");
          }
          if (((String)localObject).contains("lenovo"))
          {
            localObject = getSystemProperties("ro.lenovo.lvp.version");
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break label269;
            }
            localObject = ((String)localObject).split("_");
            if ((localObject == null) || (localObject.length <= 0)) {
              break label269;
            }
            localObject = localObject[0];
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            return getSystemProperties("ro.build.version.incremental");
          }
          if (((String)localObject).contains("letv"))
          {
            localObject = getSystemProperties("ro.letv.eui");
            return localObject;
          }
          return null;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      return localException;
      str1 = null;
    }
    return str1;
  }
  
  public static String getMaxCpuFreq()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1) {
        localStringBuilder.append(new String(arrayOfByte));
      }
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      label75:
      break label75;
    }
    localStringBuilder = new StringBuilder("N/A");
    return localStringBuilder.toString().trim();
  }
  
  public static int getMcc()
  {
    boolean bool = e.a().b();
    int i = -1;
    if (!bool) {
      return -1;
    }
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)TMSDKBaseContext.getApplicationContext().getSystemService("phone");
      if (localTelephonyManager != null) {
        i = Integer.parseInt(localTelephonyManager.getNetworkOperator().substring(0, 3));
      }
      return i;
    }
    catch (Throwable localThrowable) {}
    return -1;
  }
  
  public static int getMnc()
  {
    boolean bool = e.a().b();
    int i = -1;
    if (!bool) {
      return -1;
    }
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)TMSDKBaseContext.getApplicationContext().getSystemService("phone");
      if (localTelephonyManager != null) {
        i = Integer.parseInt(localTelephonyManager.getNetworkOperator().substring(3));
      }
      return i;
    }
    catch (Throwable localThrowable) {}
    return -1;
  }
  
  public static int getNetworkType()
  {
    int i = -1;
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)TMSDKBaseContext.getApplicationContext().getSystemService("phone");
      if (localTelephonyManager != null) {
        i = localTelephonyManager.getNetworkType();
      }
      return i;
    }
    catch (Throwable localThrowable) {}
    return -1;
  }
  
  public static void getPhoneStorageSize(SizeInfo paramSizeInfo)
  {
    getSizeInfo(Environment.getDataDirectory(), paramSizeInfo);
  }
  
  public static long getRomSize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount();
  }
  
  /* Error */
  public static String getSDCid(boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_0
    //   1: ifeq +14 -> 15
    //   4: ldc_w 424
    //   7: astore_1
    //   8: ldc_w 426
    //   11: astore_2
    //   12: goto +11 -> 23
    //   15: ldc_w 428
    //   18: astore_1
    //   19: ldc_w 430
    //   22: astore_2
    //   23: aconst_null
    //   24: astore 4
    //   26: new 111	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: aload_1
    //   36: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: ldc_w 432
    //   44: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: new 243	java/io/BufferedReader
    //   51: dup
    //   52: new 434	java/io/FileReader
    //   55: dup
    //   56: aload_3
    //   57: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 435	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   63: invokespecial 438	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_3
    //   67: aload_3
    //   68: invokevirtual 255	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull +98 -> 173
    //   78: aload 5
    //   80: invokevirtual 441	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   83: aload_2
    //   84: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +86 -> 173
    //   90: new 111	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: aload_1
    //   100: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_2
    //   105: ldc_w 443
    //   108: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: new 243	java/io/BufferedReader
    //   115: dup
    //   116: new 434	java/io/FileReader
    //   119: dup
    //   120: aload_2
    //   121: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 435	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   127: invokespecial 438	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 255	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: astore 4
    //   137: aload_1
    //   138: astore_2
    //   139: aload 4
    //   141: ifnull +34 -> 175
    //   144: aload 4
    //   146: invokevirtual 384	java/lang/String:trim	()Ljava/lang/String;
    //   149: astore_2
    //   150: aload_3
    //   151: invokevirtual 258	java/io/BufferedReader:close	()V
    //   154: aload_1
    //   155: invokevirtual 258	java/io/BufferedReader:close	()V
    //   158: aload_2
    //   159: areturn
    //   160: astore 4
    //   162: aload_1
    //   163: astore_2
    //   164: aload 4
    //   166: astore_1
    //   167: goto +42 -> 209
    //   170: goto +64 -> 234
    //   173: aconst_null
    //   174: astore_2
    //   175: aload_3
    //   176: invokevirtual 258	java/io/BufferedReader:close	()V
    //   179: aload_2
    //   180: ifnull +72 -> 252
    //   183: aload_2
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 258	java/io/BufferedReader:close	()V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_1
    //   192: aload 4
    //   194: astore_2
    //   195: goto +14 -> 209
    //   198: aconst_null
    //   199: astore_1
    //   200: goto +34 -> 234
    //   203: astore_1
    //   204: aconst_null
    //   205: astore_3
    //   206: aload 4
    //   208: astore_2
    //   209: aload_3
    //   210: ifnull +10 -> 220
    //   213: aload_3
    //   214: invokevirtual 258	java/io/BufferedReader:close	()V
    //   217: goto +3 -> 220
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 258	java/io/BufferedReader:close	()V
    //   228: aload_1
    //   229: athrow
    //   230: aconst_null
    //   231: astore_1
    //   232: aload_1
    //   233: astore_3
    //   234: aload_3
    //   235: ifnull +10 -> 245
    //   238: aload_3
    //   239: invokevirtual 258	java/io/BufferedReader:close	()V
    //   242: goto +3 -> 245
    //   245: aload_1
    //   246: ifnull +6 -> 252
    //   249: goto -64 -> 185
    //   252: aconst_null
    //   253: areturn
    //   254: astore_1
    //   255: goto -25 -> 230
    //   258: astore_1
    //   259: goto -61 -> 198
    //   262: astore_2
    //   263: goto -93 -> 170
    //   266: astore_3
    //   267: goto -113 -> 154
    //   270: astore_1
    //   271: aload_2
    //   272: areturn
    //   273: astore_1
    //   274: goto -95 -> 179
    //   277: astore_1
    //   278: aconst_null
    //   279: areturn
    //   280: astore_3
    //   281: goto -61 -> 220
    //   284: astore_2
    //   285: goto -57 -> 228
    //   288: astore_2
    //   289: goto -44 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramBoolean	boolean
    //   7	179	1	localObject1	Object
    //   191	1	1	localObject2	Object
    //   199	1	1	localObject3	Object
    //   203	26	1	localObject4	Object
    //   231	15	1	localObject5	Object
    //   254	1	1	localThrowable1	Throwable
    //   258	1	1	localThrowable2	Throwable
    //   270	1	1	localIOException1	IOException
    //   273	1	1	localIOException2	IOException
    //   277	1	1	localIOException3	IOException
    //   11	214	2	localObject6	Object
    //   262	10	2	localThrowable3	Throwable
    //   284	1	2	localIOException4	IOException
    //   288	1	2	localIOException5	IOException
    //   33	206	3	localObject7	Object
    //   266	1	3	localIOException6	IOException
    //   280	1	3	localIOException7	IOException
    //   24	121	4	str1	String
    //   160	47	4	localObject8	Object
    //   71	8	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   131	137	160	finally
    //   144	150	160	finally
    //   67	73	191	finally
    //   78	131	191	finally
    //   26	67	203	finally
    //   26	67	254	java/lang/Throwable
    //   67	73	258	java/lang/Throwable
    //   78	131	258	java/lang/Throwable
    //   131	137	262	java/lang/Throwable
    //   144	150	262	java/lang/Throwable
    //   150	154	266	java/io/IOException
    //   154	158	270	java/io/IOException
    //   175	179	273	java/io/IOException
    //   185	189	277	java/io/IOException
    //   213	217	280	java/io/IOException
    //   224	228	284	java/io/IOException
    //   238	242	288	java/io/IOException
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static void getSizeInfo(File paramFile, SizeInfo paramSizeInfo)
  {
    try
    {
      paramFile = new StatFs(paramFile.getPath());
      long l = paramFile.getBlockSize();
      paramSizeInfo.availdSize = (paramFile.getAvailableBlocks() * l);
      paramSizeInfo.totalSize = (paramFile.getBlockCount() * l);
      return;
    }
    catch (Exception paramFile) {}
  }
  
  public static void getStorageCardSize(SizeInfo paramSizeInfo)
  {
    if (dz.cR())
    {
      getSizeInfo(Environment.getExternalStorageDirectory(), paramSizeInfo);
      return;
    }
    paramSizeInfo.availdSize = 0L;
    paramSizeInfo.totalSize = 0L;
  }
  
  public static long getSystemAndDataSize()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount() + getRomSize();
  }
  
  public static String getSystemProperties(String paramString)
  {
    try
    {
      paramString = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { paramString });
    }
    catch (Throwable paramString)
    {
      label40:
      String str;
      break label40;
    }
    paramString = null;
    str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  /* Error */
  public static long getTotalMemery()
  {
    // Byte code:
    //   0: getstatic 499	com/tmsdk/base/utils/PhoneInfoFetcher:sTotalMemorySize	J
    //   3: ldc2_w 27
    //   6: lcmp
    //   7: ifne +114 -> 121
    //   10: new 100	java/io/File
    //   13: dup
    //   14: ldc_w 501
    //   17: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 504	java/io/File:exists	()Z
    //   25: ifeq +96 -> 121
    //   28: new 506	java/io/DataInputStream
    //   31: dup
    //   32: new 238	java/io/FileInputStream
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 509	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 510	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_2
    //   44: aload_2
    //   45: invokevirtual 511	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +31 -> 81
    //   53: aload_3
    //   54: invokevirtual 384	java/lang/String:trim	()Ljava/lang/String;
    //   57: ldc_w 513
    //   60: invokevirtual 344	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   63: iconst_1
    //   64: aaload
    //   65: invokestatic 519	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   68: putstatic 499	com/tmsdk/base/utils/PhoneInfoFetcher:sTotalMemorySize	J
    //   71: aload_2
    //   72: invokevirtual 520	java/io/DataInputStream:close	()V
    //   75: goto +46 -> 121
    //   78: goto +43 -> 121
    //   81: new 353	java/io/IOException
    //   84: dup
    //   85: ldc_w 522
    //   88: invokespecial 523	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   91: athrow
    //   92: astore_3
    //   93: goto +9 -> 102
    //   96: goto +18 -> 114
    //   99: astore_3
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 520	java/io/DataInputStream:close	()V
    //   110: aload_3
    //   111: athrow
    //   112: aconst_null
    //   113: astore_2
    //   114: aload_2
    //   115: ifnull +6 -> 121
    //   118: goto -47 -> 71
    //   121: getstatic 499	com/tmsdk/base/utils/PhoneInfoFetcher:sTotalMemorySize	J
    //   124: lstore_0
    //   125: lload_0
    //   126: lconst_0
    //   127: lcmp
    //   128: ifle +5 -> 133
    //   131: lload_0
    //   132: lreturn
    //   133: lconst_1
    //   134: lreturn
    //   135: astore_2
    //   136: goto -24 -> 112
    //   139: astore_3
    //   140: goto -44 -> 96
    //   143: astore_2
    //   144: goto -66 -> 78
    //   147: astore_2
    //   148: goto -38 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   124	8	0	l	long
    //   20	95	2	localObject1	Object
    //   135	1	2	localThrowable1	Throwable
    //   143	1	2	localIOException1	IOException
    //   147	1	2	localIOException2	IOException
    //   48	6	3	str	String
    //   92	1	3	localObject2	Object
    //   99	12	3	localObject3	Object
    //   139	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   44	49	92	finally
    //   53	71	92	finally
    //   81	92	92	finally
    //   28	44	99	finally
    //   28	44	135	java/lang/Throwable
    //   44	49	139	java/lang/Throwable
    //   53	71	139	java/lang/Throwable
    //   81	92	139	java/lang/Throwable
    //   71	75	143	java/io/IOException
    //   106	110	147	java/io/IOException
  }
  
  public static class SizeInfo
  {
    public long availdSize;
    public long totalSize;
    
    public int percent()
    {
      long l = this.totalSize;
      if (l > 0L) {
        return (int)((float)(l - this.availdSize) / (float)l * 100.0F);
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.PhoneInfoFetcher
 * JD-Core Version:    0.7.0.1
 */