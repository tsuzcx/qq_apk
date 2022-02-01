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
import btmsdkobf.dz;
import com.tencent.token.ro;
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
    if (!ro.a().b()) {
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
    boolean bool = ro.a().b();
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
        public final boolean accept(File paramAnonymousFile)
        {
          return Pattern.matches("cpu[0-9]", paramAnonymousFile.getName());
        }
      };
      localObject = new File("/sys/devices/system/cpu/").listFiles((FileFilter)localObject);
      if (localObject == null) {
        return 1;
      }
      new StringBuilder("CPU Count: ").append(localObject.length);
      cpuNum = Integer.valueOf(localObject.length);
      return cpuNum.intValue();
    }
    catch (Throwable localThrowable) {}
    return 1;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String getIMEI(Context paramContext)
  {
    if (!ro.a().b()) {
      return "00000000000000";
    }
    Object localObject = null;
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    catch (Throwable paramContext)
    {
      paramContext.getMessage();
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
    if (!ro.a().b()) {
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
    if (!ro.a().b()) {
      return localHashMap;
    }
    try
    {
      localObject1 = new StringBuilder("android api: ");
      ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject1).append("\n");
      localObject2 = (TelephonyManager)paramContext.getSystemService("phone");
      if (Build.VERSION.SDK_INT >= 21) {
        if (Build.VERSION.SDK_INT < 26)
        {
          localObject4 = localObject2.getClass().getMethod("getDeviceId", new Class[] { Integer.TYPE });
          ((Method)localObject4).setAccessible(true);
          localObject1 = (String)((Method)localObject4).invoke(localObject2, new Object[] { Integer.valueOf(0) });
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            i = ((String)localObject1).length();
            if (i == 14)
            {
              localObject3 = null;
            }
            else
            {
              paramContext = null;
              localObject3 = localObject1;
              localObject1 = paramContext;
            }
          }
          else
          {
            localObject3 = null;
            localObject1 = localObject3;
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      Object localObject1;
      Object localObject2;
      Object localObject4;
      int i;
      Object localObject3;
      boolean bool;
      label256:
      break label466;
    }
    try
    {
      localObject2 = (String)((Method)localObject4).invoke(localObject2, new Object[] { Integer.valueOf(1) });
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = ((String)localObject2).length();
        localObject4 = localObject1;
        paramContext = (Context)localObject2;
        if (i == 14)
        {
          paramContext = null;
          localObject4 = localObject2;
        }
      }
      else
      {
        paramContext = null;
        localObject4 = localObject1;
      }
    }
    catch (Throwable paramContext)
    {
      break label266;
    }
    try
    {
      bool = TextUtils.equals((CharSequence)localObject3, paramContext);
      localObject2 = localObject3;
      localObject1 = localObject4;
      if (!bool) {
        break label474;
      }
      paramContext = null;
      localObject2 = localObject3;
      localObject1 = localObject4;
    }
    catch (Throwable localThrowable1)
    {
      break label256;
    }
    localObject2 = localObject3;
    localObject1 = localObject4;
    break label474;
    label266:
    paramContext = null;
    localObject2 = localObject3;
    break label474;
    paramContext = localObject2.getClass().getMethod("getMeid", new Class[] { Integer.TYPE });
    paramContext.setAccessible(true);
    paramContext = (String)paramContext.invoke(localObject2, new Object[] { Integer.valueOf(0) });
    try
    {
      localObject3 = localObject2.getClass().getMethod("getImei", new Class[] { Integer.TYPE });
      ((Method)localObject3).setAccessible(true);
      localObject1 = (String)((Method)localObject3).invoke(localObject2, new Object[] { Integer.valueOf(0) });
    }
    catch (Throwable localThrowable2)
    {
      label431:
      break label440;
    }
    try
    {
      localObject3 = (String)((Method)localObject3).invoke(localObject2, new Object[] { Integer.valueOf(1) });
    }
    catch (Throwable localThrowable3)
    {
      break label431;
    }
    try
    {
      bool = TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject3);
      if (bool)
      {
        localObject3 = null;
        localObject2 = localObject1;
        localObject1 = paramContext;
        paramContext = (Context)localObject3;
      }
      else
      {
        localObject2 = localObject1;
        localObject1 = paramContext;
        paramContext = (Context)localObject3;
      }
    }
    catch (Throwable localThrowable4)
    {
      break label434;
    }
    localObject3 = null;
    label434:
    localObject2 = localObject1;
    break label447;
    label440:
    localObject3 = null;
    localObject2 = localObject3;
    label447:
    localObject1 = paramContext;
    paramContext = (Context)localObject3;
    break label474;
    paramContext = null;
    localObject2 = paramContext;
    localObject1 = localObject2;
    break label474;
    label466:
    paramContext = null;
    localObject2 = paramContext;
    localObject1 = localObject2;
    label474:
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localHashMap.put("meid", localObject1);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localHashMap.put("imei1", localObject2);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      localHashMap.put("imei2", paramContext);
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
    //   3: new 223	java/io/FileInputStream
    //   6: dup
    //   7: ldc 225
    //   9: invokespecial 226	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: new 228	java/io/BufferedReader
    //   16: dup
    //   17: new 230	java/io/InputStreamReader
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 233	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: sipush 8192
    //   28: invokespecial 236	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore 4
    //   33: new 111	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 50
    //   39: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload 4
    //   45: invokevirtual 239	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull +13 -> 65
    //   55: aload_3
    //   56: aload 5
    //   58: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -19 -> 43
    //   65: aload 4
    //   67: invokevirtual 242	java/io/BufferedReader:close	()V
    //   70: aload_1
    //   71: invokevirtual 245	java/io/InputStream:close	()V
    //   74: aload_3
    //   75: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_3
    //   79: goto +23 -> 102
    //   82: astore_2
    //   83: aload 4
    //   85: invokevirtual 242	java/io/BufferedReader:close	()V
    //   88: aload_1
    //   89: invokevirtual 245	java/io/InputStream:close	()V
    //   92: aload_2
    //   93: athrow
    //   94: aload 4
    //   96: invokevirtual 242	java/io/BufferedReader:close	()V
    //   99: goto -29 -> 70
    //   102: iload_0
    //   103: ifne +5 -> 108
    //   106: aload_3
    //   107: areturn
    //   108: aload_2
    //   109: astore_1
    //   110: aload_3
    //   111: ifnull +41 -> 152
    //   114: aload_2
    //   115: astore_1
    //   116: aload_3
    //   117: ldc 50
    //   119: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne +30 -> 152
    //   125: aload_3
    //   126: aload_3
    //   127: ldc 253
    //   129: invokevirtual 257	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   132: bipush 8
    //   134: iadd
    //   135: invokevirtual 261	java/lang/String:substring	(I)Ljava/lang/String;
    //   138: astore_1
    //   139: aload_1
    //   140: iconst_0
    //   141: aload_1
    //   142: ldc_w 263
    //   145: invokevirtual 257	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   148: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   151: astore_1
    //   152: aload_1
    //   153: areturn
    //   154: astore_1
    //   155: ldc 50
    //   157: areturn
    //   158: astore 5
    //   160: goto -66 -> 94
    //   163: astore 4
    //   165: goto -95 -> 70
    //   168: astore_1
    //   169: goto -95 -> 74
    //   172: astore_3
    //   173: goto -85 -> 88
    //   176: astore_1
    //   177: goto -85 -> 92
    //   180: astore_1
    //   181: ldc 50
    //   183: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramBoolean	boolean
    //   12	141	1	localObject1	Object
    //   154	1	1	localThrowable1	Throwable
    //   168	1	1	localThrowable2	Throwable
    //   176	1	1	localThrowable3	Throwable
    //   180	1	1	localThrowable4	Throwable
    //   2	1	2	str1	String
    //   82	33	2	localObject2	Object
    //   42	85	3	localObject3	Object
    //   172	1	3	localThrowable5	Throwable
    //   31	64	4	localBufferedReader	java.io.BufferedReader
    //   163	1	4	localThrowable6	Throwable
    //   48	9	5	str2	String
    //   158	1	5	localThrowable7	Throwable
    // Exception table:
    //   from	to	target	type
    //   43	50	82	finally
    //   55	62	82	finally
    //   3	13	154	java/lang/Throwable
    //   43	50	158	java/lang/Throwable
    //   55	62	158	java/lang/Throwable
    //   65	70	163	java/lang/Throwable
    //   94	99	163	java/lang/Throwable
    //   70	74	168	java/lang/Throwable
    //   83	88	172	java/lang/Throwable
    //   88	92	176	java/lang/Throwable
    //   125	152	180	java/lang/Throwable
  }
  
  public static int getLac()
  {
    boolean bool = ro.a().b();
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
    boolean bool = ro.a().b();
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
    boolean bool = ro.a().b();
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
    //   4: ldc_w 412
    //   7: astore_1
    //   8: ldc_w 414
    //   11: astore_2
    //   12: goto +11 -> 23
    //   15: ldc_w 416
    //   18: astore_1
    //   19: ldc_w 418
    //   22: astore_2
    //   23: aconst_null
    //   24: astore 4
    //   26: new 111	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: aload_1
    //   36: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: ldc_w 420
    //   44: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: new 228	java/io/BufferedReader
    //   51: dup
    //   52: new 422	java/io/FileReader
    //   55: dup
    //   56: aload_3
    //   57: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 423	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   63: invokespecial 426	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_3
    //   67: aload_3
    //   68: invokevirtual 239	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull +98 -> 173
    //   78: aload 5
    //   80: invokevirtual 429	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   83: aload_2
    //   84: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +86 -> 173
    //   90: new 111	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: aload_1
    //   100: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_2
    //   105: ldc_w 431
    //   108: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: new 228	java/io/BufferedReader
    //   115: dup
    //   116: new 422	java/io/FileReader
    //   119: dup
    //   120: aload_2
    //   121: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 423	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   127: invokespecial 426	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 239	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: astore 4
    //   137: aload_1
    //   138: astore_2
    //   139: aload 4
    //   141: ifnull +34 -> 175
    //   144: aload 4
    //   146: invokevirtual 372	java/lang/String:trim	()Ljava/lang/String;
    //   149: astore_2
    //   150: aload_3
    //   151: invokevirtual 242	java/io/BufferedReader:close	()V
    //   154: aload_1
    //   155: invokevirtual 242	java/io/BufferedReader:close	()V
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
    //   176: invokevirtual 242	java/io/BufferedReader:close	()V
    //   179: aload_2
    //   180: ifnull +72 -> 252
    //   183: aload_2
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 242	java/io/BufferedReader:close	()V
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
    //   214: invokevirtual 242	java/io/BufferedReader:close	()V
    //   217: goto +3 -> 220
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 242	java/io/BufferedReader:close	()V
    //   228: aload_1
    //   229: athrow
    //   230: aconst_null
    //   231: astore_1
    //   232: aload_1
    //   233: astore_3
    //   234: aload_3
    //   235: ifnull +10 -> 245
    //   238: aload_3
    //   239: invokevirtual 242	java/io/BufferedReader:close	()V
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
    //   0: getstatic 487	com/tmsdk/base/utils/PhoneInfoFetcher:sTotalMemorySize	J
    //   3: ldc2_w 27
    //   6: lcmp
    //   7: ifne +115 -> 122
    //   10: new 100	java/io/File
    //   13: dup
    //   14: ldc_w 489
    //   17: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aconst_null
    //   22: astore_3
    //   23: aload_2
    //   24: invokevirtual 492	java/io/File:exists	()Z
    //   27: ifeq +95 -> 122
    //   30: new 494	java/io/DataInputStream
    //   33: dup
    //   34: new 223	java/io/FileInputStream
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 497	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 498	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 499	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +31 -> 83
    //   55: aload_3
    //   56: invokevirtual 372	java/lang/String:trim	()Ljava/lang/String;
    //   59: ldc_w 501
    //   62: invokevirtual 332	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   65: iconst_1
    //   66: aaload
    //   67: invokestatic 507	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   70: putstatic 487	com/tmsdk/base/utils/PhoneInfoFetcher:sTotalMemorySize	J
    //   73: aload_2
    //   74: invokevirtual 508	java/io/DataInputStream:close	()V
    //   77: goto +45 -> 122
    //   80: goto +42 -> 122
    //   83: new 341	java/io/IOException
    //   86: dup
    //   87: ldc_w 510
    //   90: invokespecial 511	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   93: athrow
    //   94: astore_3
    //   95: goto +9 -> 104
    //   98: goto +16 -> 114
    //   101: astore_3
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 508	java/io/DataInputStream:close	()V
    //   112: aload_3
    //   113: athrow
    //   114: aload_2
    //   115: ifnull +7 -> 122
    //   118: aload_2
    //   119: invokevirtual 508	java/io/DataInputStream:close	()V
    //   122: getstatic 487	com/tmsdk/base/utils/PhoneInfoFetcher:sTotalMemorySize	J
    //   125: lstore_0
    //   126: lload_0
    //   127: lconst_0
    //   128: lcmp
    //   129: ifle +5 -> 134
    //   132: lload_0
    //   133: lreturn
    //   134: lconst_1
    //   135: lreturn
    //   136: astore_2
    //   137: aload_3
    //   138: astore_2
    //   139: goto -25 -> 114
    //   142: astore_3
    //   143: goto -45 -> 98
    //   146: astore_2
    //   147: goto -67 -> 80
    //   150: astore_2
    //   151: goto -39 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   125	8	0	l	long
    //   20	99	2	localObject1	Object
    //   136	1	2	localThrowable1	Throwable
    //   138	1	2	localObject2	Object
    //   146	1	2	localIOException1	IOException
    //   150	1	2	localIOException2	IOException
    //   22	34	3	str	String
    //   94	1	3	localObject3	Object
    //   101	37	3	localObject4	Object
    //   142	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   46	51	94	finally
    //   55	73	94	finally
    //   83	94	94	finally
    //   30	46	101	finally
    //   30	46	136	java/lang/Throwable
    //   46	51	142	java/lang/Throwable
    //   55	73	142	java/lang/Throwable
    //   83	94	142	java/lang/Throwable
    //   73	77	146	java/io/IOException
    //   118	122	146	java/io/IOException
    //   108	112	150	java/io/IOException
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