package com.tencent.tmassistantsdk.downloadservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.e.b;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.f.k;
import java.io.File;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class c
{
  private static String a = c.class.getSimpleName();
  
  public static PowerManager.WakeLock a()
  {
    return null;
  }
  
  public static String a(String paramString)
  {
    paramString = paramString.replace("\r", "").replace("\n", "").trim();
    String str1 = new String(paramString);
    try
    {
      Uri localUri = Uri.parse(paramString);
      String str2 = localUri.getLastPathSegment();
      paramString = str1;
      if (str2 != null)
      {
        paramString = str1;
        if (str2.length() > 0) {
          paramString = str1.replace(str2, URLEncoder.encode(localUri.getLastPathSegment()).replace("+", "%20"));
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return str1;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str2 = f.c(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = Integer.toString(Math.abs(paramString1.hashCode()));
    }
    str2 = "";
    paramString1 = str2;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (!paramString2.equals("application/vnd.android.package-archive")) {
        break label68;
      }
      paramString1 = ".apk";
    }
    for (;;)
    {
      return str1 + paramString1;
      label68:
      if (paramString2.equals("application/tm.android.apkdiff"))
      {
        paramString1 = ".diff";
      }
      else
      {
        paramString1 = str2;
        if (paramString2.equals("resource/tm.android.unknown")) {
          paramString1 = ".other";
        }
      }
    }
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    long l2 = 0L;
    long l1 = -1L;
    int i;
    long l3;
    if (!TextUtils.isEmpty(paramString)) {
      if ((paramString != null) && (paramString.contains("/data/data")))
      {
        i = 1;
        if (i != 1) {
          break label150;
        }
        paramString = new StatFs(Environment.getDataDirectory().getPath());
        l1 = paramString.getBlockSize();
        l3 = (paramString.getAvailableBlocks() - 4L) * l1;
        l1 = l3;
        if (l3 >= 0L) {
          break label230;
        }
        l1 = l2;
      }
    }
    label145:
    label150:
    label230:
    for (;;)
    {
      paramLong = ((float)paramLong * 1.5F);
      if (paramLong <= 104857600L) {
        break label235;
      }
      if (l1 < paramLong) {
        break label233;
      }
      return true;
      if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite())) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label145;
        }
        i = 2;
        break;
      }
      i = 0;
      break;
      if (i == 2)
      {
        l1 = l2;
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
          paramString = new StatFs(new File(Environment.getExternalStorageDirectory().getPath()).getPath());
          l1 = paramString.getBlockSize();
          l3 = (paramString.getAvailableBlocks() - 4L) * l1;
          l1 = l2;
          if (l3 >= 0L) {
            l1 = l3;
          }
        }
      }
    }
    label233:
    return false;
    label235:
    return l1 >= 104857600L;
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 169	com/tencent/tmassistantsdk/f/f:a	()Lcom/tencent/tmassistantsdk/f/f;
    //   6: invokevirtual 172	com/tencent/tmassistantsdk/f/f:b	()Landroid/content/Context;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +11 -> 22
    //   14: ldc 28
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: aload_0
    //   23: ldc 174
    //   25: invokevirtual 180	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   28: ifeq +16 -> 44
    //   31: ldc 28
    //   33: astore_0
    //   34: goto -17 -> 17
    //   37: astore_0
    //   38: ldc 28
    //   40: astore_0
    //   41: goto -24 -> 17
    //   44: aload_0
    //   45: ldc 182
    //   47: invokevirtual 186	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   50: checkcast 188	android/net/ConnectivityManager
    //   53: invokevirtual 192	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   56: astore_0
    //   57: aload_0
    //   58: ifnonnull +9 -> 67
    //   61: ldc 28
    //   63: astore_0
    //   64: goto -47 -> 17
    //   67: aload_0
    //   68: invokevirtual 197	android/net/NetworkInfo:getType	()I
    //   71: iconst_1
    //   72: if_icmpne +9 -> 81
    //   75: ldc 199
    //   77: astore_0
    //   78: goto -61 -> 17
    //   81: aload_0
    //   82: invokevirtual 202	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   85: astore_0
    //   86: aload_0
    //   87: ifnonnull +9 -> 96
    //   90: ldc 28
    //   92: astore_0
    //   93: goto -76 -> 17
    //   96: aload_0
    //   97: invokevirtual 205	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   100: astore_0
    //   101: getstatic 16	com/tencent/tmassistantsdk/downloadservice/c:a	Ljava/lang/String;
    //   104: new 104	java/lang/StringBuilder
    //   107: dup
    //   108: ldc 207
    //   110: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: aload_0
    //   114: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 213	com/tencent/tmassistantsdk/f/k:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: goto -106 -> 17
    //   126: astore_0
    //   127: ldc 2
    //   129: monitorexit
    //   130: aload_0
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	25	0	localObject1	Object
    //   37	1	0	localException	Exception
    //   40	74	0	localObject2	Object
    //   126	5	0	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	31	37	java/lang/Exception
    //   3	10	126	finally
    //   22	31	126	finally
    //   44	57	126	finally
    //   67	75	126	finally
    //   81	86	126	finally
    //   96	123	126	finally
  }
  
  public static String b(String paramString)
  {
    if (paramString.contains(".apk"))
    {
      String str = paramString.trim().substring(paramString.lastIndexOf("/") + 1).trim();
      paramString = str;
      if (str.contains("?")) {
        paramString = str.substring(0, str.lastIndexOf("?"));
      }
      if (!TextUtils.isEmpty(paramString))
      {
        k.b(a, "file name = " + paramString);
        return e(paramString);
      }
    }
    return null;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = new File(b.a(a(paramString1, paramString2))).exists();
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      paramString1.printStackTrace();
      return false;
    }
    finally {}
  }
  
  public static String c(String paramString)
  {
    if (paramString != null) {
      return URLDecoder.decode(paramString);
    }
    return null;
  }
  
  public static boolean c()
  {
    Object localObject = f.a().b();
    if (localObject == null)
    {
      k.d(a, "GlobalUtil.getInstance().getContext() == null.");
      return false;
    }
    localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
    if (localObject != null) {}
    for (boolean bool = ((NetworkInfo)localObject).isAvailable();; bool = false) {
      return bool;
    }
  }
  
  public static String d(String paramString)
  {
    return paramString.replace("?", "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace("&", "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(":", "_").replace("/", "_").replace("\\", "_").replace("\"", "_");
  }
  
  public static String e(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf('.');
    if ((i <= 0) || (i == paramString.length() - 1)) {
      return paramString;
    }
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString.substring(0, i);
    arrayOfString[1] = paramString.substring(i, paramString.length());
    i = 0;
    if (i == 0) {}
    for (String str = paramString;; str = arrayOfString[0] + "(" + i + ")" + arrayOfString[1])
    {
      i += 1;
      if (new File(b.d() + File.separator + str).exists()) {
        break;
      }
      return str;
    }
  }
  
  public static boolean f(String paramString)
  {
    try
    {
      new URI(a(paramString));
      return true;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean g(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      try
      {
        boolean bool = new File(b.a(paramString)).exists();
        if (!bool) {
          continue;
        }
        return true;
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        paramString.printStackTrace();
        return false;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.c
 * JD-Core Version:    0.7.0.1
 */