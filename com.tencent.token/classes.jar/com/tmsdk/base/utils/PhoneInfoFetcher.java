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
import java.util.regex.Pattern;

public class PhoneInfoFetcher
{
  public static final String KEY_IMEI1 = "imei1";
  public static final String KEY_IMEI2 = "imei2";
  public static final String KEY_MEID = "meid";
  private static Integer M;
  private static long N = -1L;
  
  public static String getAndoidId(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label12:
      break label12;
    }
    return "";
  }
  
  public static int getCellId()
  {
    int j = -1;
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
    if (M == null) {}
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
      eg.e("PhoneInfoFetcher", localStringBuilder.toString());
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
    }
    catch (Throwable paramContext)
    {
      eg.g("PhoneInfoFetcher", paramContext.getMessage());
      paramContext = null;
    }
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = "00000000000000";
    }
    return localObject;
  }
  
  public static String getIMSI(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    }
    catch (Throwable paramContext)
    {
      label16:
      Object localObject;
      break label16;
    }
    paramContext = null;
    localObject = paramContext;
    if (paramContext == null) {
      localObject = "000000000000000";
    }
    return localObject;
  }
  
  public static Map<String, String> getImeiAndMeid(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    localObject6 = null;
    localObject8 = null;
    for (;;)
    {
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("android api: ");
        ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
        ((StringBuilder)localObject1).append("\n");
        eg.f("PhoneInfoFetcher", ((StringBuilder)localObject1).toString());
        localObject7 = (TelephonyManager)paramContext.getSystemService("phone");
        if (Build.VERSION.SDK_INT < 21) {
          continue;
        }
        if (Build.VERSION.SDK_INT < 26)
        {
          localObject3 = localObject7.getClass().getMethod("getDeviceId", new Class[] { Integer.TYPE });
          ((Method)localObject3).setAccessible(true);
          localObject1 = (String)((Method)localObject3).invoke(localObject7, new Object[] { Integer.valueOf(0) });
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            i = ((String)localObject1).length();
            if (i == 14)
            {
              paramContext = (Context)localObject1;
              localObject1 = null;
            }
            else
            {
              paramContext = null;
            }
          }
          else
          {
            localObject1 = null;
            paramContext = (Context)localObject1;
          }
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject1;
        Object localObject7;
        Object localObject3;
        int i;
        boolean bool;
        Object localObject4;
        Object localObject5 = null;
        paramContext = localObject5;
        Object localObject2 = localThrowable4;
        continue;
      }
      try
      {
        localObject7 = (String)((Method)localObject3).invoke(localObject7, new Object[] { Integer.valueOf(1) });
        localObject3 = paramContext;
        if (!TextUtils.isEmpty((CharSequence)localObject7))
        {
          i = ((String)localObject7).length();
          localObject6 = localObject7;
          if (i == 14) {
            localObject3 = localObject7;
          }
        }
        else
        {
          localObject6 = null;
          paramContext = (Context)localObject3;
        }
      }
      catch (Throwable localThrowable2)
      {
        localObject4 = localObject8;
        continue;
      }
      try
      {
        bool = TextUtils.equals((CharSequence)localObject1, localObject6);
        if (bool)
        {
          localObject3 = localObject8;
          localObject6 = localObject1;
          localObject1 = localObject3;
          localObject3 = paramContext;
          paramContext = localObject6;
        }
      }
      catch (Throwable localThrowable3)
      {
        continue;
      }
      localObject3 = localObject6;
    }
    paramContext = localObject7.getClass().getMethod("getMeid", new Class[] { Integer.TYPE });
    paramContext.setAccessible(true);
    localObject3 = (String)paramContext.invoke(localObject7, new Object[] { Integer.valueOf(0) });
    try
    {
      localObject1 = localObject7.getClass().getMethod("getImei", new Class[] { Integer.TYPE });
      ((Method)localObject1).setAccessible(true);
      paramContext = (String)((Method)localObject1).invoke(localObject7, new Object[] { Integer.valueOf(0) });
    }
    catch (Throwable paramContext)
    {
      label397:
      label400:
      label405:
      break label400;
    }
    try
    {
      localObject1 = (String)((Method)localObject1).invoke(localObject7, new Object[] { Integer.valueOf(1) });
    }
    catch (Throwable localThrowable1)
    {
      localObject2 = localObject6;
      break label405;
    }
    try
    {
      bool = TextUtils.equals(paramContext, (CharSequence)localObject1);
      if (bool) {
        localObject1 = localObject6;
      }
    }
    catch (Throwable localThrowable4)
    {
      break label397;
    }
    break label405;
    paramContext = null;
    localObject1 = localObject6;
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      localHashMap.put("meid", localObject3);
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
    //   0: ldc 51
    //   2: astore_2
    //   3: new 223	java/io/FileInputStream
    //   6: dup
    //   7: ldc 225
    //   9: invokespecial 226	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_3
    //   13: new 228	java/io/BufferedReader
    //   16: dup
    //   17: new 230	java/io/InputStreamReader
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 233	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: sipush 8192
    //   28: invokespecial 236	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore 4
    //   33: new 98	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 51
    //   39: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload 4
    //   45: invokevirtual 240	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull +13 -> 65
    //   55: aload_1
    //   56: aload 5
    //   58: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -19 -> 43
    //   65: aload 4
    //   67: invokevirtual 243	java/io/BufferedReader:close	()V
    //   70: goto +25 -> 95
    //   73: astore_2
    //   74: aload 4
    //   76: invokevirtual 243	java/io/BufferedReader:close	()V
    //   79: aload_3
    //   80: invokevirtual 246	java/io/InputStream:close	()V
    //   83: aload_1
    //   84: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: pop
    //   88: aload_2
    //   89: athrow
    //   90: aload 4
    //   92: invokevirtual 243	java/io/BufferedReader:close	()V
    //   95: aload_3
    //   96: invokevirtual 246	java/io/InputStream:close	()V
    //   99: aload_1
    //   100: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore_3
    //   104: iload_0
    //   105: ifne +5 -> 110
    //   108: aload_3
    //   109: areturn
    //   110: aload_2
    //   111: astore_1
    //   112: aload_3
    //   113: ifnull +41 -> 154
    //   116: aload_2
    //   117: astore_1
    //   118: aload_3
    //   119: ldc 51
    //   121: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   124: ifne +30 -> 154
    //   127: aload_3
    //   128: aload_3
    //   129: ldc 251
    //   131: invokevirtual 255	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   134: bipush 8
    //   136: iadd
    //   137: invokevirtual 259	java/lang/String:substring	(I)Ljava/lang/String;
    //   140: astore_1
    //   141: aload_1
    //   142: iconst_0
    //   143: aload_1
    //   144: ldc_w 261
    //   147: invokevirtual 255	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   150: invokevirtual 264	java/lang/String:substring	(II)Ljava/lang/String;
    //   153: astore_1
    //   154: aload_1
    //   155: areturn
    //   156: astore_1
    //   157: ldc 51
    //   159: areturn
    //   160: astore 5
    //   162: goto -72 -> 90
    //   165: astore 4
    //   167: goto -72 -> 95
    //   170: astore 4
    //   172: goto -93 -> 79
    //   175: astore_3
    //   176: goto -93 -> 83
    //   179: astore_3
    //   180: goto -81 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramBoolean	boolean
    //   42	113	1	localObject1	Object
    //   156	1	1	localThrowable1	Throwable
    //   2	1	2	str1	String
    //   73	44	2	localObject2	Object
    //   12	117	3	localObject3	Object
    //   175	1	3	localThrowable2	Throwable
    //   179	1	3	localThrowable3	Throwable
    //   31	60	4	localBufferedReader	java.io.BufferedReader
    //   165	1	4	localThrowable4	Throwable
    //   170	1	4	localThrowable5	Throwable
    //   48	9	5	str2	String
    //   160	1	5	localThrowable6	Throwable
    // Exception table:
    //   from	to	target	type
    //   43	50	73	finally
    //   55	62	73	finally
    //   3	13	156	java/lang/Throwable
    //   127	154	156	java/lang/Throwable
    //   43	50	160	java/lang/Throwable
    //   55	62	160	java/lang/Throwable
    //   65	70	165	java/lang/Throwable
    //   90	95	165	java/lang/Throwable
    //   74	79	170	java/lang/Throwable
    //   79	83	175	java/lang/Throwable
    //   95	99	179	java/lang/Throwable
  }
  
  public static int getLac()
  {
    int j = -1;
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
              break label71;
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
      label71:
      int i = -1;
    }
  }
  
  public static String getManufacturerRomVersion()
  {
    String str1;
    for (Object localObject = null;; str1 = null)
    {
      try
      {
        String str2 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str2)) {
          return null;
        }
        str2 = str2.toLowerCase(Locale.ENGLISH);
        if (str2.contains("huawei")) {
          return getSystemProperties("ro.build.version.emui");
        }
        if (str2.contains("xiaomi")) {
          return getSystemProperties("ro.miui.ui.version.name");
        }
        if (str2.contains("gionee"))
        {
          localObject = getSystemProperties("ro.gn.extvernumber");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return getSystemProperties("ro.build.display.id");
          }
        }
        else
        {
          if (str2.contains("vivo"))
          {
            localObject = getSystemProperties("ro.vivo.os.name");
            str2 = getSystemProperties("ro.vivo.os.version");
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
          if (str2.contains("meizu")) {
            return getSystemProperties("ro.build.display.id");
          }
          if (str2.contains("lenovo"))
          {
            localObject = getSystemProperties("ro.lenovo.lvp.version");
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              continue;
            }
            localObject = ((String)localObject).split("_");
            if ((localObject == null) || (localObject.length <= 0)) {
              continue;
            }
            localObject = localObject[0];
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            return getSystemProperties("ro.build.version.incremental");
          }
          if (str2.contains("letv")) {
            localObject = getSystemProperties("ro.letv.eui");
          }
          return localObject;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      return localException;
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
    int i = -1;
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
    int i = -1;
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
    //   4: ldc_w 409
    //   7: astore_1
    //   8: ldc_w 411
    //   11: astore_2
    //   12: goto +11 -> 23
    //   15: ldc_w 413
    //   18: astore_1
    //   19: ldc_w 415
    //   22: astore_2
    //   23: aconst_null
    //   24: astore 4
    //   26: new 98	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: aload_1
    //   36: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: ldc_w 417
    //   44: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: new 228	java/io/BufferedReader
    //   51: dup
    //   52: new 419	java/io/FileReader
    //   55: dup
    //   56: aload_3
    //   57: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 420	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   63: invokespecial 423	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_3
    //   67: aload_3
    //   68: invokevirtual 240	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull +98 -> 173
    //   78: aload 5
    //   80: invokevirtual 426	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   83: aload_2
    //   84: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +86 -> 173
    //   90: new 98	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: aload_1
    //   100: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_2
    //   105: ldc_w 428
    //   108: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: new 228	java/io/BufferedReader
    //   115: dup
    //   116: new 419	java/io/FileReader
    //   119: dup
    //   120: aload_2
    //   121: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 420	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   127: invokespecial 423	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 240	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: astore 4
    //   137: aload_1
    //   138: astore_2
    //   139: aload 4
    //   141: ifnull +34 -> 175
    //   144: aload 4
    //   146: invokevirtual 369	java/lang/String:trim	()Ljava/lang/String;
    //   149: astore_2
    //   150: aload_3
    //   151: invokevirtual 243	java/io/BufferedReader:close	()V
    //   154: aload_1
    //   155: invokevirtual 243	java/io/BufferedReader:close	()V
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
    //   176: invokevirtual 243	java/io/BufferedReader:close	()V
    //   179: aload_2
    //   180: ifnull +72 -> 252
    //   183: aload_2
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 243	java/io/BufferedReader:close	()V
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
    //   214: invokevirtual 243	java/io/BufferedReader:close	()V
    //   217: goto +3 -> 220
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 243	java/io/BufferedReader:close	()V
    //   228: aload_1
    //   229: athrow
    //   230: aconst_null
    //   231: astore_1
    //   232: aload_1
    //   233: astore_3
    //   234: aload_3
    //   235: ifnull +10 -> 245
    //   238: aload_3
    //   239: invokevirtual 243	java/io/BufferedReader:close	()V
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
    //   0: getstatic 485	com/tmsdk/base/utils/PhoneInfoFetcher:N	J
    //   3: ldc2_w 24
    //   6: lcmp
    //   7: ifne +114 -> 121
    //   10: new 87	java/io/File
    //   13: dup
    //   14: ldc_w 487
    //   17: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 490	java/io/File:exists	()Z
    //   25: ifeq +96 -> 121
    //   28: new 492	java/io/DataInputStream
    //   31: dup
    //   32: new 223	java/io/FileInputStream
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 495	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 496	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_2
    //   44: aload_2
    //   45: invokevirtual 497	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +31 -> 81
    //   53: aload_3
    //   54: invokevirtual 369	java/lang/String:trim	()Ljava/lang/String;
    //   57: ldc_w 499
    //   60: invokevirtual 329	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   63: iconst_1
    //   64: aaload
    //   65: invokestatic 505	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   68: putstatic 485	com/tmsdk/base/utils/PhoneInfoFetcher:N	J
    //   71: aload_2
    //   72: invokevirtual 506	java/io/DataInputStream:close	()V
    //   75: goto +46 -> 121
    //   78: goto +43 -> 121
    //   81: new 338	java/io/IOException
    //   84: dup
    //   85: ldc_w 508
    //   88: invokespecial 509	java/io/IOException:<init>	(Ljava/lang/String;)V
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
    //   107: invokevirtual 506	java/io/DataInputStream:close	()V
    //   110: aload_3
    //   111: athrow
    //   112: aconst_null
    //   113: astore_2
    //   114: aload_2
    //   115: ifnull +6 -> 121
    //   118: goto -47 -> 71
    //   121: getstatic 485	com/tmsdk/base/utils/PhoneInfoFetcher:N	J
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
  
  public static boolean isHUAWEI()
  {
    try
    {
      boolean bool = Build.MANUFACTURER.toLowerCase().contains("huawei");
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      label19:
      break label19;
    }
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
    catch (Throwable localThrowable)
    {
      label31:
      break label31;
    }
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
    catch (Throwable localThrowable)
    {
      label19:
      break label19;
    }
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
    catch (Throwable localThrowable)
    {
      label19:
      break label19;
    }
    return false;
  }
  
  public static boolean isOnePlus(Context paramContext)
  {
    try
    {
      boolean bool = paramContext.getPackageManager().hasSystemFeature("com.oneplus.mobilephone");
      return bool;
    }
    catch (Throwable paramContext)
    {
      label13:
      break label13;
    }
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
    catch (Throwable localThrowable)
    {
      label19:
      break label19;
    }
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
    catch (Throwable localThrowable)
    {
      label19:
      break label19;
    }
    return false;
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