package com.tmsdk.base.utils;

import android.content.Context;
import android.content.pm.PackageManager;
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
import btmsdkobf.dz;
import btmsdkobf.eg;
import com.tmsdk.base.TMSDKBaseContext;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PhoneInfoFetcher
{
  public static final String KEY_IMEI1 = "imei1";
  public static final String KEY_IMEI2 = "imei2";
  public static final String KEY_MEID = "meid";
  private static Integer M = null;
  private static long N = -1L;
  
  public static String getAndoidId(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public static int getCellId()
  {
    for (;;)
    {
      try
      {
        Object localObject = (TelephonyManager)TMSDKBaseContext.getApplicationContext().getSystemService("phone");
        if (localObject == null) {
          break;
        }
        localObject = ((TelephonyManager)localObject).getCellLocation();
        if (localObject == null) {
          break;
        }
        int j;
        if ((localObject instanceof GsmCellLocation))
        {
          i = ((GsmCellLocation)localObject).getCid();
          j = i;
        }
        int i = -1;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if ((localObject instanceof CdmaCellLocation)) {
            j = ((CdmaCellLocation)localObject).getBaseStationId();
          }
          return j;
        }
        catch (Throwable localThrowable2)
        {
          return i;
        }
        localThrowable1 = localThrowable1;
        return -1;
      }
    }
    return -1;
  }
  
  public static int getCpuNum()
  {
    if (M == null) {}
    try
    {
      Object localObject = new PhoneInfoFetcher.1();
      localObject = new File("/sys/devices/system/cpu/").listFiles((FileFilter)localObject);
      if (localObject == null) {
        return 1;
      }
      eg.e("PhoneInfoFetcher", "CPU Count: " + localObject.length);
      M = Integer.valueOf(localObject.length);
      return M.intValue();
    }
    catch (Throwable localThrowable) {}
    return 1;
  }
  
  public static String getIMEI(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      Object localObject = paramContext;
      if (paramContext == null) {
        localObject = "00000000000000";
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        eg.g("PhoneInfoFetcher", paramContext.getMessage());
        paramContext = null;
      }
    }
  }
  
  public static String getIMSI(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      Object localObject = paramContext;
      if (paramContext == null) {
        localObject = "000000000000000";
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  public static Map getImeiAndMeid(Context paramContext)
  {
    localObject7 = null;
    HashMap localHashMap = new HashMap();
    try
    {
      eg.f("PhoneInfoFetcher", "android api: " + Build.VERSION.SDK_INT + "\n");
      localObject5 = (TelephonyManager)paramContext.getSystemService("phone");
      i = Build.VERSION.SDK_INT;
      if (i >= 21) {
        break label131;
      }
      localObject1 = null;
      paramContext = null;
      localObject2 = localObject7;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        try
        {
          int i;
          paramContext = localObject5.getClass().getMethod("getImei", new Class[] { Integer.TYPE });
          paramContext.setAccessible(true);
          str1 = (String)paramContext.invoke(localObject5, new Object[] { Integer.valueOf(0) });
          localObject4 = localObject3;
          localObject2 = str1;
          str2 = (String)paramContext.invoke(localObject5, new Object[] { Integer.valueOf(1) });
          localObject6 = str2;
          localObject5 = localObject3;
          localObject4 = str1;
          bool = TextUtils.equals(str1, str2);
          localObject1 = localObject3;
          paramContext = str1;
          localObject2 = localObject7;
          if (bool) {
            continue;
          }
          localObject2 = str2;
          localObject1 = localObject3;
          paramContext = str1;
        }
        catch (Throwable paramContext)
        {
          Object localObject5;
          Object localObject3;
          paramContext = null;
          localObject1 = localObject3;
          localObject2 = localObject7;
        }
        paramContext = paramContext;
        Object localObject1 = null;
        paramContext = null;
        Object localObject2 = localObject7;
        continue;
        continue;
        continue;
        continue;
        localObject2 = null;
        continue;
        localObject1 = null;
        paramContext = null;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localHashMap.put("meid", localObject1);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      localHashMap.put("imei1", paramContext);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localHashMap.put("imei2", localObject2);
    }
    return localHashMap;
    label131:
    if (Build.VERSION.SDK_INT < 26)
    {
      localObject3 = localObject5.getClass().getMethod("getDeviceId", new Class[] { Integer.TYPE });
      ((Method)localObject3).setAccessible(true);
      localObject1 = (String)((Method)localObject3).invoke(localObject5, new Object[] { Integer.valueOf(0) });
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        i = ((String)localObject1).length();
        if (i == 14) {
          paramContext = null;
        }
        for (;;)
        {
          for (;;)
          {
            Object localObject4 = localObject1;
            localObject2 = paramContext;
            Object localObject6;
            try
            {
              localObject3 = (String)((Method)localObject3).invoke(localObject5, new Object[] { Integer.valueOf(1) });
              localObject4 = localObject1;
              localObject2 = paramContext;
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label540;
              }
              localObject4 = localObject1;
              localObject2 = paramContext;
              i = ((String)localObject3).length();
              localObject2 = localObject3;
              if (i == 14)
              {
                localObject1 = localObject3;
                localObject2 = null;
              }
              localObject6 = localObject2;
              localObject5 = localObject1;
              localObject4 = paramContext;
            }
            catch (Throwable paramContext)
            {
              boolean bool;
              String str1;
              String str2;
              localObject1 = localObject4;
              paramContext = (Context)localObject2;
              localObject2 = localObject7;
            }
            try
            {
              bool = TextUtils.equals(paramContext, (CharSequence)localObject2);
              if (bool) {
                localObject2 = null;
              }
            }
            catch (Throwable paramContext)
            {
              localObject2 = localObject6;
              localObject1 = localObject5;
              paramContext = (Context)localObject4;
            }
          }
          paramContext = (Context)localObject1;
          localObject1 = null;
        }
      }
    }
    else
    {
      paramContext = localObject5.getClass().getMethod("getMeid", new Class[] { Integer.TYPE });
      paramContext.setAccessible(true);
      localObject3 = (String)paramContext.invoke(localObject5, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public static String getKernelVersion()
  {
    return getKernelVersion(true);
  }
  
  /* Error */
  public static String getKernelVersion(boolean paramBoolean)
  {
    // Byte code:
    //   0: new 220	java/io/FileInputStream
    //   3: dup
    //   4: ldc 222
    //   6: invokespecial 223	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: new 225	java/io/BufferedReader
    //   13: dup
    //   14: new 227	java/io/InputStreamReader
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 230	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: sipush 8192
    //   25: invokespecial 233	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore_3
    //   29: new 99	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 50
    //   35: invokespecial 234	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_3
    //   40: invokevirtual 237	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 4
    //   45: aload 4
    //   47: ifnull +46 -> 93
    //   50: aload_1
    //   51: aload 4
    //   53: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: goto -18 -> 39
    //   60: astore 4
    //   62: aload_3
    //   63: ifnull +7 -> 70
    //   66: aload_3
    //   67: invokevirtual 240	java/io/BufferedReader:close	()V
    //   70: aload_2
    //   71: ifnull +7 -> 78
    //   74: aload_2
    //   75: invokevirtual 243	java/io/InputStream:close	()V
    //   78: aload_1
    //   79: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_1
    //   83: iload_0
    //   84: ifne +59 -> 143
    //   87: aload_1
    //   88: areturn
    //   89: astore_1
    //   90: ldc 50
    //   92: areturn
    //   93: aload_3
    //   94: ifnull +7 -> 101
    //   97: aload_3
    //   98: invokevirtual 240	java/io/BufferedReader:close	()V
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 243	java/io/InputStream:close	()V
    //   109: aload_1
    //   110: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore_1
    //   114: goto -31 -> 83
    //   117: astore 4
    //   119: aload_3
    //   120: ifnull +7 -> 127
    //   123: aload_3
    //   124: invokevirtual 240	java/io/BufferedReader:close	()V
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 243	java/io/InputStream:close	()V
    //   135: aload_1
    //   136: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: pop
    //   140: aload 4
    //   142: athrow
    //   143: aload_1
    //   144: ifnull +72 -> 216
    //   147: aload_1
    //   148: ldc 50
    //   150: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   153: ifne +63 -> 216
    //   156: aload_1
    //   157: aload_1
    //   158: ldc 248
    //   160: invokevirtual 252	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   163: ldc 248
    //   165: invokevirtual 206	java/lang/String:length	()I
    //   168: iadd
    //   169: invokevirtual 256	java/lang/String:substring	(I)Ljava/lang/String;
    //   172: astore_1
    //   173: aload_1
    //   174: iconst_0
    //   175: aload_1
    //   176: ldc_w 258
    //   179: invokevirtual 252	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   182: invokevirtual 261	java/lang/String:substring	(II)Ljava/lang/String;
    //   185: astore_1
    //   186: aload_1
    //   187: areturn
    //   188: astore_1
    //   189: ldc 50
    //   191: areturn
    //   192: astore_3
    //   193: goto -92 -> 101
    //   196: astore_2
    //   197: goto -88 -> 109
    //   200: astore_3
    //   201: goto -131 -> 70
    //   204: astore_2
    //   205: goto -127 -> 78
    //   208: astore_3
    //   209: goto -82 -> 127
    //   212: astore_2
    //   213: goto -78 -> 135
    //   216: ldc 50
    //   218: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramBoolean	boolean
    //   38	50	1	localObject1	Object
    //   89	21	1	localThrowable1	Throwable
    //   113	74	1	str1	String
    //   188	1	1	localThrowable2	Throwable
    //   9	123	2	localFileInputStream	java.io.FileInputStream
    //   196	1	2	localThrowable3	Throwable
    //   204	1	2	localThrowable4	Throwable
    //   212	1	2	localThrowable5	Throwable
    //   28	96	3	localBufferedReader	java.io.BufferedReader
    //   192	1	3	localThrowable6	Throwable
    //   200	1	3	localThrowable7	Throwable
    //   208	1	3	localThrowable8	Throwable
    //   43	9	4	str2	String
    //   60	1	4	localThrowable9	Throwable
    //   117	24	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   39	45	60	java/lang/Throwable
    //   50	57	60	java/lang/Throwable
    //   0	10	89	java/lang/Throwable
    //   39	45	117	finally
    //   50	57	117	finally
    //   156	186	188	java/lang/Throwable
    //   97	101	192	java/lang/Throwable
    //   105	109	196	java/lang/Throwable
    //   66	70	200	java/lang/Throwable
    //   74	78	204	java/lang/Throwable
    //   123	127	208	java/lang/Throwable
    //   131	135	212	java/lang/Throwable
  }
  
  public static int getLac()
  {
    for (;;)
    {
      try
      {
        Object localObject = (TelephonyManager)TMSDKBaseContext.getApplicationContext().getSystemService("phone");
        if (localObject == null) {
          break;
        }
        localObject = ((TelephonyManager)localObject).getCellLocation();
        if (localObject == null) {
          break;
        }
        if ((localObject instanceof GsmCellLocation))
        {
          i = ((GsmCellLocation)localObject).getLac();
          if ((localObject instanceof CdmaCellLocation)) {
            i = ((CdmaCellLocation)localObject).getNetworkId();
          }
          return i;
        }
      }
      catch (Throwable localThrowable)
      {
        return -1;
      }
      int i = -1;
    }
    return -1;
  }
  
  public static String getManufacturerRomVersion()
  {
    Object localObject3;
    for (;;)
    {
      try
      {
        Object localObject1 = Build.MANUFACTURER;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return null;
        }
        localObject1 = ((String)localObject1).toLowerCase(Locale.ENGLISH);
        if (((String)localObject1).contains("huawei")) {
          return getSystemProperties("ro.build.version.emui");
        }
        if (((String)localObject1).contains("xiaomi")) {
          return getSystemProperties("ro.miui.ui.version.name");
        }
        if (((String)localObject1).contains("gionee"))
        {
          localObject1 = getSystemProperties("ro.gn.extvernumber");
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          return getSystemProperties("ro.build.display.id");
        }
        if (((String)localObject1).contains("vivo"))
        {
          localObject1 = getSystemProperties("ro.vivo.os.name");
          localObject3 = getSystemProperties("ro.vivo.os.version");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
            return (String)localObject1 + "_" + (String)localObject3;
          }
          return getSystemProperties("ro.vivo.os.build.display.id");
        }
        if (((String)localObject1).contains("meizu")) {
          return getSystemProperties("ro.build.display.id");
        }
        if (((String)localObject1).contains("lenovo"))
        {
          localObject1 = getSystemProperties("ro.lenovo.lvp.version");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label258;
          }
          localObject1 = ((String)localObject1).split("_");
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label258;
          }
          localObject1 = localObject1[0];
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          return getSystemProperties("ro.build.version.incremental");
        }
        if (((String)localObject1).contains("letv"))
        {
          localObject1 = getSystemProperties("ro.letv.eui");
          return localObject1;
        }
      }
      catch (Exception localException) {}
      return null;
      label258:
      Object localObject2 = null;
    }
    return localObject3;
  }
  
  public static String getMaxCpuFreq()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    InputStream localInputStream;
    try
    {
      localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1)
      {
        localStringBuilder1.append(new String(arrayOfByte));
        continue;
        StringBuilder localStringBuilder2;
        return localStringBuilder2.toString().trim();
      }
    }
    catch (IOException localIOException)
    {
      localStringBuilder2 = new StringBuilder("N/A");
    }
    for (;;)
    {
      localInputStream.close();
    }
  }
  
  public static int getMcc()
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)TMSDKBaseContext.getApplicationContext().getSystemService("phone");
      if (localTelephonyManager != null)
      {
        int i = Integer.parseInt(localTelephonyManager.getNetworkOperator().substring(0, 3));
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      return -1;
    }
    return -1;
  }
  
  public static int getMnc()
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)TMSDKBaseContext.getApplicationContext().getSystemService("phone");
      if (localTelephonyManager != null)
      {
        int i = Integer.parseInt(localTelephonyManager.getNetworkOperator().substring(3));
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      return -1;
    }
    return -1;
  }
  
  public static int getNetworkType()
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)TMSDKBaseContext.getApplicationContext().getSystemService("phone");
      if (localTelephonyManager != null)
      {
        int i = localTelephonyManager.getNetworkType();
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      return -1;
    }
    return -1;
  }
  
  public static void getPhoneStorageSize(PhoneInfoFetcher.SizeInfo paramSizeInfo)
  {
    getSizeInfo(Environment.getDataDirectory(), paramSizeInfo);
  }
  
  public static long getRomSize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  /* Error */
  public static String getSDCid(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iload_0
    //   4: ifeq +141 -> 145
    //   7: ldc_w 406
    //   10: astore_3
    //   11: ldc_w 408
    //   14: astore_2
    //   15: new 225	java/io/BufferedReader
    //   18: dup
    //   19: new 410	java/io/FileReader
    //   22: dup
    //   23: new 99	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   30: aload_3
    //   31: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 412
    //   37: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokespecial 413	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 416	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_1
    //   50: aload_1
    //   51: invokevirtual 237	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore 5
    //   56: aload 5
    //   58: ifnull +98 -> 156
    //   61: aload 5
    //   63: invokevirtual 419	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   66: aload_2
    //   67: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +86 -> 156
    //   73: new 225	java/io/BufferedReader
    //   76: dup
    //   77: new 410	java/io/FileReader
    //   80: dup
    //   81: new 99	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   88: aload_3
    //   89: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 421
    //   95: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 413	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   104: invokespecial 416	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   107: astore_2
    //   108: aload_2
    //   109: invokevirtual 237	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   112: astore 4
    //   114: aload_2
    //   115: astore_3
    //   116: aload 4
    //   118: ifnull +40 -> 158
    //   121: aload 4
    //   123: invokevirtual 366	java/lang/String:trim	()Ljava/lang/String;
    //   126: astore_3
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 240	java/io/BufferedReader:close	()V
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 240	java/io/BufferedReader:close	()V
    //   143: aload_3
    //   144: areturn
    //   145: ldc_w 423
    //   148: astore_3
    //   149: ldc_w 425
    //   152: astore_2
    //   153: goto -138 -> 15
    //   156: aconst_null
    //   157: astore_3
    //   158: aload_1
    //   159: ifnull +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 240	java/io/BufferedReader:close	()V
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 240	java/io/BufferedReader:close	()V
    //   174: aconst_null
    //   175: areturn
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_1
    //   179: aconst_null
    //   180: astore_2
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 240	java/io/BufferedReader:close	()V
    //   189: aload_1
    //   190: ifnull -16 -> 174
    //   193: aload_1
    //   194: invokevirtual 240	java/io/BufferedReader:close	()V
    //   197: goto -23 -> 174
    //   200: astore_1
    //   201: goto -27 -> 174
    //   204: astore_2
    //   205: aconst_null
    //   206: astore_1
    //   207: aload 4
    //   209: astore_3
    //   210: aload_1
    //   211: ifnull +7 -> 218
    //   214: aload_1
    //   215: invokevirtual 240	java/io/BufferedReader:close	()V
    //   218: aload_3
    //   219: ifnull +7 -> 226
    //   222: aload_3
    //   223: invokevirtual 240	java/io/BufferedReader:close	()V
    //   226: aload_2
    //   227: athrow
    //   228: astore_1
    //   229: goto -94 -> 135
    //   232: astore_1
    //   233: aload_3
    //   234: areturn
    //   235: astore_1
    //   236: goto -70 -> 166
    //   239: astore_1
    //   240: goto -66 -> 174
    //   243: astore_2
    //   244: goto -55 -> 189
    //   247: astore_1
    //   248: goto -30 -> 218
    //   251: astore_1
    //   252: goto -26 -> 226
    //   255: astore_2
    //   256: aload 4
    //   258: astore_3
    //   259: goto -49 -> 210
    //   262: astore 4
    //   264: aload_2
    //   265: astore_3
    //   266: aload 4
    //   268: astore_2
    //   269: goto -59 -> 210
    //   272: astore_2
    //   273: aconst_null
    //   274: astore_3
    //   275: aload_1
    //   276: astore_2
    //   277: aload_3
    //   278: astore_1
    //   279: goto -98 -> 181
    //   282: astore_3
    //   283: aload_1
    //   284: astore_3
    //   285: aload_2
    //   286: astore_1
    //   287: aload_3
    //   288: astore_2
    //   289: goto -108 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramBoolean	boolean
    //   49	114	1	localBufferedReader	java.io.BufferedReader
    //   176	1	1	localThrowable1	Throwable
    //   178	16	1	localObject1	Object
    //   200	1	1	localIOException1	IOException
    //   206	9	1	localObject2	Object
    //   228	1	1	localIOException2	IOException
    //   232	1	1	localIOException3	IOException
    //   235	1	1	localIOException4	IOException
    //   239	1	1	localIOException5	IOException
    //   247	1	1	localIOException6	IOException
    //   251	25	1	localIOException7	IOException
    //   278	9	1	localObject3	Object
    //   14	172	2	localObject4	Object
    //   204	23	2	localObject5	Object
    //   243	1	2	localIOException8	IOException
    //   255	10	2	localObject6	Object
    //   268	1	2	localObject7	Object
    //   272	1	2	localThrowable2	Throwable
    //   276	13	2	localObject8	Object
    //   10	268	3	localObject9	Object
    //   282	1	3	localThrowable3	Throwable
    //   284	4	3	localObject10	Object
    //   1	256	4	str1	String
    //   262	5	4	localObject11	Object
    //   54	8	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   15	50	176	java/lang/Throwable
    //   193	197	200	java/io/IOException
    //   15	50	204	finally
    //   131	135	228	java/io/IOException
    //   139	143	232	java/io/IOException
    //   162	166	235	java/io/IOException
    //   170	174	239	java/io/IOException
    //   185	189	243	java/io/IOException
    //   214	218	247	java/io/IOException
    //   222	226	251	java/io/IOException
    //   50	56	255	finally
    //   61	108	255	finally
    //   108	114	262	finally
    //   121	127	262	finally
    //   50	56	272	java/lang/Throwable
    //   61	108	272	java/lang/Throwable
    //   108	114	282	java/lang/Throwable
    //   121	127	282	java/lang/Throwable
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static void getSizeInfo(File paramFile, PhoneInfoFetcher.SizeInfo paramSizeInfo)
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
  
  public static void getStorageCardSize(PhoneInfoFetcher.SizeInfo paramSizeInfo)
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
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l + getRomSize();
  }
  
  public static String getSystemProperties(String paramString)
  {
    try
    {
      paramString = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  /* Error */
  public static long getTotalMemery()
  {
    // Byte code:
    //   0: getstatic 26	com/tmsdk/base/utils/PhoneInfoFetcher:N	J
    //   3: ldc2_w 23
    //   6: lcmp
    //   7: ifne +68 -> 75
    //   10: new 86	java/io/File
    //   13: dup
    //   14: ldc_w 484
    //   17: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: aconst_null
    //   22: astore_1
    //   23: aload_0
    //   24: invokevirtual 487	java/io/File:exists	()Z
    //   27: ifeq +48 -> 75
    //   30: new 489	java/io/DataInputStream
    //   33: dup
    //   34: new 220	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 492	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 493	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 494	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnonnull +35 -> 87
    //   55: new 335	java/io/IOException
    //   58: dup
    //   59: ldc_w 496
    //   62: invokespecial 497	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   65: athrow
    //   66: astore_1
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 498	java/io/DataInputStream:close	()V
    //   75: getstatic 26	com/tmsdk/base/utils/PhoneInfoFetcher:N	J
    //   78: lconst_0
    //   79: lcmp
    //   80: ifle +51 -> 131
    //   83: getstatic 26	com/tmsdk/base/utils/PhoneInfoFetcher:N	J
    //   86: lreturn
    //   87: aload_1
    //   88: invokevirtual 366	java/lang/String:trim	()Ljava/lang/String;
    //   91: ldc_w 500
    //   94: invokevirtual 326	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   97: iconst_1
    //   98: aaload
    //   99: invokestatic 506	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   102: putstatic 26	com/tmsdk/base/utils/PhoneInfoFetcher:N	J
    //   105: aload_0
    //   106: ifnull -31 -> 75
    //   109: aload_0
    //   110: invokevirtual 498	java/io/DataInputStream:close	()V
    //   113: goto -38 -> 75
    //   116: astore_0
    //   117: goto -42 -> 75
    //   120: astore_0
    //   121: aload_1
    //   122: ifnull +7 -> 129
    //   125: aload_1
    //   126: invokevirtual 498	java/io/DataInputStream:close	()V
    //   129: aload_0
    //   130: athrow
    //   131: lconst_1
    //   132: lreturn
    //   133: astore_0
    //   134: goto -59 -> 75
    //   137: astore_1
    //   138: goto -9 -> 129
    //   141: astore_2
    //   142: aload_0
    //   143: astore_1
    //   144: aload_2
    //   145: astore_0
    //   146: goto -25 -> 121
    //   149: astore_0
    //   150: aconst_null
    //   151: astore_0
    //   152: goto -85 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	90	0	localObject1	Object
    //   116	1	0	localIOException1	IOException
    //   120	10	0	localObject2	Object
    //   133	10	0	localIOException2	IOException
    //   145	1	0	localObject3	Object
    //   149	1	0	localThrowable1	Throwable
    //   151	1	0	localObject4	Object
    //   22	30	1	str	String
    //   66	60	1	localThrowable2	Throwable
    //   137	1	1	localIOException3	IOException
    //   143	1	1	localIOException4	IOException
    //   141	4	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   46	51	66	java/lang/Throwable
    //   55	66	66	java/lang/Throwable
    //   87	105	66	java/lang/Throwable
    //   109	113	116	java/io/IOException
    //   30	46	120	finally
    //   71	75	133	java/io/IOException
    //   125	129	137	java/io/IOException
    //   46	51	141	finally
    //   55	66	141	finally
    //   87	105	141	finally
    //   30	46	149	java/lang/Throwable
  }
  
  public static boolean isHUAWEI()
  {
    try
    {
      boolean bool = Build.MANUFACTURER.toLowerCase().contains("huawei");
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean isLenovo()
  {
    try
    {
      String str = Build.MANUFACTURER.toLowerCase();
      if (!str.contains("lenovo"))
      {
        boolean bool = str.contains("motorola");
        if (!bool) {}
      }
      else
      {
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean isMEIZU()
  {
    try
    {
      boolean bool = Build.MANUFACTURER.toLowerCase().contains("meizu");
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean isOPPO()
  {
    try
    {
      boolean bool = Build.MANUFACTURER.toLowerCase().contains("oppo");
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean isOnePlus(Context paramContext)
  {
    try
    {
      boolean bool = paramContext.getPackageManager().hasSystemFeature("com.oneplus.mobilephone");
      return bool;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean isVIVO()
  {
    try
    {
      boolean bool = Build.MANUFACTURER.toLowerCase().contains("vivo");
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean isXIAOMI()
  {
    try
    {
      boolean bool = Build.MANUFACTURER.toLowerCase().contains("xiaomi");
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.PhoneInfoFetcher
 * JD-Core Version:    0.7.0.1
 */