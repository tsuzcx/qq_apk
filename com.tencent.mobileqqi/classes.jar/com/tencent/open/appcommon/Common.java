package com.tencent.open.appcommon;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Common
{
  public static final int a = 2;
  public static final String a = "Common";
  public static final String b = "qzoneappcenter";
  public static final String c = ".AppCenterWebBuffer_QQ";
  public static final String d = "qapp_social_apps.html";
  public static final String e = "qapp_center_index.htm";
  public static final String f = "qapp_center_detail.htm";
  public static final String g = "system_old_";
  public static final String h = "tmp";
  public static final String i = "user";
  public static final String j = "resource.zip";
  public static final String k = "resource.diff";
  public static final String l = "resource_merged.zip";
  public static final String m = "Page/system";
  protected static final String n = "/mnt/sdcard-ext";
  public static final String o = "sd://";
  public static final String p = "file:///";
  public static final String q = "file:///android_asset" + File.separator + "Page/system";
  public static final String r = "applist.db";
  
  public static int a()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getInt("appTabVersionCode", -1);
  }
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(b());
    return localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
  }
  
  /* Error */
  public static long a(java.io.InputStream paramInputStream, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 74	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 130	java/io/File:exists	()Z
    //   13: ifne +8 -> 21
    //   16: aload_1
    //   17: invokevirtual 133	java/io/File:mkdir	()Z
    //   20: pop
    //   21: new 74	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: aload_2
    //   27: invokespecial 136	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore 4
    //   32: new 138	java/io/FileOutputStream
    //   35: dup
    //   36: aload 4
    //   38: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: sipush 4096
    //   47: newarray byte
    //   49: astore 5
    //   51: aload_2
    //   52: astore_1
    //   53: aload_0
    //   54: aload 5
    //   56: invokevirtual 147	java/io/InputStream:read	([B)I
    //   59: istore_3
    //   60: iconst_m1
    //   61: iload_3
    //   62: if_icmpeq +32 -> 94
    //   65: aload_2
    //   66: astore_1
    //   67: aload_2
    //   68: aload 5
    //   70: iconst_0
    //   71: iload_3
    //   72: invokevirtual 151	java/io/FileOutputStream:write	([BII)V
    //   75: goto -24 -> 51
    //   78: astore_0
    //   79: aload_2
    //   80: astore_1
    //   81: aload_0
    //   82: athrow
    //   83: astore_0
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   92: aload_0
    //   93: athrow
    //   94: aload_2
    //   95: astore_1
    //   96: aload_2
    //   97: invokevirtual 157	java/io/FileOutputStream:flush	()V
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   108: aload 4
    //   110: invokevirtual 160	java/io/File:length	()J
    //   113: lreturn
    //   114: astore_0
    //   115: goto -7 -> 108
    //   118: astore_1
    //   119: goto -27 -> 92
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -41 -> 84
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_1
    //   131: goto -50 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramInputStream	java.io.InputStream
    //   0	134	1	paramString1	String
    //   0	134	2	paramString2	String
    //   59	13	3	i1	int
    //   30	79	4	localFile	File
    //   49	20	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   44	51	78	java/lang/Exception
    //   53	60	78	java/lang/Exception
    //   67	75	78	java/lang/Exception
    //   96	100	78	java/lang/Exception
    //   44	51	83	finally
    //   53	60	83	finally
    //   67	75	83	finally
    //   81	83	83	finally
    //   96	100	83	finally
    //   104	108	114	java/lang/Exception
    //   88	92	118	java/lang/Exception
    //   32	42	122	finally
    //   32	42	128	java/lang/Exception
  }
  
  public static File a()
  {
    Object localObject;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localObject = Environment.getExternalStorageDirectory();
    }
    File localFile;
    do
    {
      return localObject;
      localFile = new File("/mnt/sdcard-ext");
      localObject = localFile;
    } while (localFile.isDirectory());
    return null;
  }
  
  public static String a()
  {
    return b() + File.separator + ".AppCenterWebBuffer_QQ";
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 185	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 186	java/lang/StringBuffer:<init>	()V
    //   7: astore 4
    //   9: new 74	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 130	java/io/File:exists	()Z
    //   22: ifne +30 -> 52
    //   25: ldc 188
    //   27: new 63	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   34: ldc 190
    //   36: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 195	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: ldc 197
    //   51: areturn
    //   52: new 199	java/io/InputStreamReader
    //   55: dup
    //   56: new 201	java/io/FileInputStream
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 205	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   67: astore_2
    //   68: aload_2
    //   69: astore_0
    //   70: aload_2
    //   71: invokevirtual 209	java/io/Reader:read	()I
    //   74: istore_1
    //   75: iload_1
    //   76: iconst_m1
    //   77: if_icmpeq +58 -> 135
    //   80: iload_1
    //   81: i2c
    //   82: bipush 13
    //   84: if_icmpeq -16 -> 68
    //   87: iload_1
    //   88: i2c
    //   89: bipush 10
    //   91: if_icmpeq -23 -> 68
    //   94: iload_1
    //   95: i2c
    //   96: bipush 9
    //   98: if_icmpeq -30 -> 68
    //   101: aload_2
    //   102: astore_0
    //   103: aload 4
    //   105: iload_1
    //   106: i2c
    //   107: invokevirtual 212	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   110: pop
    //   111: goto -43 -> 68
    //   114: astore_3
    //   115: aload_2
    //   116: astore_0
    //   117: aload_3
    //   118: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   121: aload_2
    //   122: ifnull +7 -> 129
    //   125: aload_2
    //   126: invokevirtual 216	java/io/Reader:close	()V
    //   129: aload 4
    //   131: invokevirtual 217	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   134: areturn
    //   135: aload_2
    //   136: astore_0
    //   137: aload_2
    //   138: invokevirtual 216	java/io/Reader:close	()V
    //   141: iconst_0
    //   142: ifeq -13 -> 129
    //   145: new 219	java/lang/NullPointerException
    //   148: dup
    //   149: invokespecial 220	java/lang/NullPointerException:<init>	()V
    //   152: athrow
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   158: goto -29 -> 129
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   166: goto -37 -> 129
    //   169: astore_2
    //   170: aconst_null
    //   171: astore_0
    //   172: aload_0
    //   173: ifnull +7 -> 180
    //   176: aload_0
    //   177: invokevirtual 216	java/io/Reader:close	()V
    //   180: aload_2
    //   181: athrow
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   187: goto -7 -> 180
    //   190: astore_2
    //   191: goto -19 -> 172
    //   194: astore_3
    //   195: aconst_null
    //   196: astore_2
    //   197: goto -82 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramString	String
    //   74	32	1	i1	int
    //   17	121	2	localObject1	Object
    //   169	12	2	localObject2	Object
    //   190	1	2	localObject3	Object
    //   196	1	2	localObject4	Object
    //   114	4	3	localException1	Exception
    //   194	1	3	localException2	Exception
    //   7	123	4	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   70	75	114	java/lang/Exception
    //   103	111	114	java/lang/Exception
    //   137	141	114	java/lang/Exception
    //   145	153	153	java/io/IOException
    //   125	129	161	java/io/IOException
    //   52	68	169	finally
    //   176	180	182	java/io/IOException
    //   70	75	190	finally
    //   103	111	190	finally
    //   117	121	190	finally
    //   137	141	190	finally
    //   52	68	194	java/lang/Exception
  }
  
  public static String a(Map paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i1 = 1;
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str1);
      if (i1 != 0)
      {
        localStringBuilder.append(str1 + "=" + URLEncoder.encode(str2, "utf-8"));
        i1 = 0;
      }
      for (;;)
      {
        break;
        if (str2 != null) {
          localStringBuilder.append("&" + str1 + "=" + URLEncoder.encode(str2, "utf-8"));
        } else {
          localStringBuilder.append("&" + str1 + "=");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      Object localObject;
      if (!paramString.startsWith("?"))
      {
        localObject = paramString;
        if (!paramString.startsWith("&")) {}
      }
      else
      {
        localObject = paramString.substring(1);
      }
      paramString = ((String)localObject).split("&");
      int i2 = paramString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = paramString[i1].split("=");
        if (localObject.length > 1)
        {
          String str = URLDecoder.decode(localObject[1]);
          localHashMap.put(localObject[0], str);
        }
        i1 += 1;
      }
    }
    return localHashMap;
  }
  
  public static void a()
  {
    try
    {
      LogUtility.b("Common", "<initSystemFolder> begin to init system file... ");
      File localFile = new File(a());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      a(true);
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putInt("appTabVersionCode", paramInt);
    localEditor.commit();
  }
  
  public static void a(long paramLong1, long paramLong2)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putLong("remaxage", paramLong1);
    localEditor.putLong("relasttime", paramLong2);
    localEditor.commit();
  }
  
  public static void a(String paramString)
  {
    LogUtility.c("Common", "setResourceMD5=" + paramString);
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putString("relastmd5", paramString);
    localEditor.commit();
  }
  
  /* Error */
  public static void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 335	java/util/concurrent/Executors:newSingleThreadScheduledExecutor	()Ljava/util/concurrent/ScheduledExecutorService;
    //   6: astore_3
    //   7: new 337	hom
    //   10: dup
    //   11: invokespecial 338	hom:<init>	()V
    //   14: astore 4
    //   16: iload_0
    //   17: ifeq +24 -> 41
    //   20: ldc2_w 339
    //   23: lstore_1
    //   24: aload_3
    //   25: aload 4
    //   27: lload_1
    //   28: getstatic 346	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   31: invokeinterface 352 5 0
    //   36: pop
    //   37: ldc 2
    //   39: monitorexit
    //   40: return
    //   41: lconst_0
    //   42: lstore_1
    //   43: goto -19 -> 24
    //   46: astore_3
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_3
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramBoolean	boolean
    //   23	20	1	l1	long
    //   6	19	3	localScheduledExecutorService	java.util.concurrent.ScheduledExecutorService
    //   46	5	3	localObject	Object
    //   14	12	4	localhom	hom
    // Exception table:
    //   from	to	target	type
    //   3	16	46	finally
    //   24	37	46	finally
  }
  
  public static boolean a()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    while (new File("/mnt/sdcard-ext").isDirectory()) {
      return true;
    }
    return false;
  }
  
  public static long[] a()
  {
    SharedPreferences localSharedPreferences = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0);
    return new long[] { localSharedPreferences.getLong("remaxage", 0L), localSharedPreferences.getLong("relasttime", 0L) };
  }
  
  public static String[] a(String paramString)
  {
    String str2;
    String str1;
    if (paramString.toLowerCase().startsWith("sd://"))
    {
      str2 = paramString.substring("sd://".length());
      int i1 = str2.indexOf("?");
      if (i1 != -1)
      {
        str1 = str2.substring(0, i1);
        paramString = str2.substring(i1 + 1);
        if (new File(e() + File.separator + str1).exists())
        {
          str2 = "file:///" + e() + File.separator + str1;
          str1 = paramString;
        }
      }
    }
    for (;;)
    {
      paramString = str1;
      if (!TextUtils.isEmpty(str1)) {
        paramString = "&" + str1;
      }
      LogUtility.c("Common", "url params= " + str2 + " " + paramString);
      return new String[] { str2, paramString };
      str2 = "file:///android_asset/Page/system/" + str1;
      str1 = paramString;
      continue;
      paramString = "";
      str1 = str2;
      break;
      str1 = "";
      str2 = paramString;
    }
  }
  
  public static String b()
  {
    String str = ".";
    if (Environment.getExternalStorageState().equals("mounted")) {
      str = Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    while (!new File("/mnt/sdcard-ext").isDirectory()) {
      return str;
    }
    return "/mnt/sdcard-ext";
  }
  
  public static void b(String paramString)
  {
    LogUtility.c("Common", "setLastResourceZipMd5=" + paramString);
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putString("lastresourcezipmd5", paramString);
    localEditor.commit();
  }
  
  public static void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putBoolean("appstoreclearcache", paramBoolean);
    localEditor.commit();
  }
  
  public static boolean b()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getBoolean("appstoreclearcache", false);
  }
  
  public static String c()
  {
    return e() + File.separator + "qapp_social_apps.html";
  }
  
  public static void c(String paramString)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putString("appstoreagentversion", paramString);
    localEditor.commit();
  }
  
  public static String d()
  {
    return e() + File.separator + "qapp_center_index.htm";
  }
  
  public static void d(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
      localEditor.putString("sdhtmldir", paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String e()
  {
    String str = p();
    LogUtility.b("Common", "<getSDResDir> getSDResDir=" + str);
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    return a() + File.separator + str;
  }
  
  public static String f()
  {
    return a() + File.separator + "tmp";
  }
  
  public static String g()
  {
    return a() + File.separator + "system_old_";
  }
  
  public static String h()
  {
    return a() + File.separator + "user";
  }
  
  public static String i()
  {
    return a() + File.separator + "resource.zip";
  }
  
  public static String j()
  {
    return a() + File.separator + "resource.diff";
  }
  
  public static String k()
  {
    return a() + File.separator + "resource_merged.zip";
  }
  
  public static String l()
  {
    return "file:///android_asset" + File.separator + "Page/system";
  }
  
  public static String m()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getString("relastmd5", "");
  }
  
  public static String n()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getString("lastresourcezipmd5", "");
  }
  
  public static String o()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getString("appstoreagentversion", "");
  }
  
  public static String p()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getString("sdhtmldir", "");
  }
  
  public static String q()
  {
    int i1 = Process.myPid();
    try
    {
      Object localObject = CommonDataAdapter.a().a();
      if (localObject != null)
      {
        localObject = ((ActivityManager)((Context)localObject).getSystemService("activity")).getRunningAppProcesses().iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (localRunningAppProcessInfo.pid == i1)
          {
            localObject = localRunningAppProcessInfo.processName;
            return localObject;
          }
        }
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("Common", "exception happened!");
      return "";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.Common
 * JD-Core Version:    0.7.0.1
 */