package com.tencent.component.network.downloader.impl.ipc;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.component.network.module.common.a.f;
import com.tencent.component.network.module.common.a.j;
import com.tencent.component.network.utils.NetworkUtils;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;

public final class Const
{
  private static Context t;
  private static com.tencent.component.network.module.base.inter.Log u;
  public int a;
  public String b;
  public long c;
  public long d;
  public long e;
  public int f;
  public HttpResponse g;
  public Throwable h;
  public String i;
  public String j;
  public int k;
  public String l;
  public String m;
  public long n;
  public long o;
  public long p;
  public long q;
  public int r;
  public String s;
  
  public static Context a()
  {
    return t;
  }
  
  public static Parcel a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    if (paramArrayOfByte == null) {
      return localParcel;
    }
    try
    {
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      return localParcel;
    }
    catch (Exception paramArrayOfByte) {}
    return localParcel;
  }
  
  private static String a(int paramInt, float paramFloat)
  {
    for (;;)
    {
      if (paramFloat < 0.0F) {
        return "";
      }
      if (paramFloat < 1024.0F)
      {
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(String.format("%.2f", new Object[] { Float.valueOf(paramFloat) })));
        String str;
        if (paramInt == 0) {
          str = "byte";
        }
        for (;;)
        {
          return str;
          if (paramInt == 1) {
            str = "KB";
          } else if (paramInt == 2) {
            str = "MB";
          } else if (paramInt == 3) {
            str = "GB";
          } else if (paramInt == 4) {
            str = "TB";
          } else if (paramInt == 5) {
            str = "PB";
          } else {
            str = "";
          }
        }
      }
      paramInt += 1;
      paramFloat /= 1024.0F;
    }
  }
  
  public static void a(Context paramContext)
  {
    t = paramContext;
    NetworkManager.init(t);
    NetworkState.g().setContext(t);
  }
  
  public static void a(com.tencent.component.network.module.base.inter.Log paramLog)
  {
    u = paramLog;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((u != null) && (u.isVerboseEnabled()))
    {
      u.v(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= 65535);
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (NetworkUtils.isNetworkUrl(paramString));
  }
  
  public static boolean a(Pattern paramPattern, String paramString)
  {
    if ((paramPattern == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      boolean bool = paramPattern.matcher(paramString).matches();
      return bool;
    }
    catch (Exception paramPattern)
    {
      d("Utils", "", paramPattern);
    }
    return false;
  }
  
  public static InetAddress[] a(String paramString, long paramLong)
  {
    if (paramString == null) {
      paramString = "";
    }
    Object localObject;
    for (;;)
    {
      b("DnsMain", "hostName:" + paramString + ",timeout:" + paramLong, null);
      b("DnsMain", "get better host for name:" + paramString, null);
      if ((paramString != null) && (paramString.trim().length() > 0)) {
        break;
      }
      return null;
      localObject = paramString.trim();
      paramString = ((String)localObject).toLowerCase();
      int i1;
      if (paramString.startsWith("http://"))
      {
        i1 = ((String)localObject).indexOf("/", 8);
        if (i1 > 7) {
          paramString = ((String)localObject).substring(7, i1);
        } else {
          paramString = ((String)localObject).substring(7);
        }
      }
      else if (paramString.startsWith("https://"))
      {
        i1 = ((String)localObject).indexOf("/", 9);
        if (i1 > 8) {
          paramString = ((String)localObject).substring(8, i1);
        } else {
          paramString = ((String)localObject).substring(8);
        }
      }
      else
      {
        paramString = (String)localObject;
        if (((String)localObject).indexOf("/", 1) > 1) {
          paramString = ((String)localObject).substring(0, ((String)localObject).indexOf("/", 1));
        }
      }
    }
    paramString = paramString.trim();
    try
    {
      localObject = new f("114.114.114.114").a(paramString, paramLong);
      if ((localObject != null) && (localObject.length > 0))
      {
        b("DnsMain", "get ip from Lookup: " + paramString + " --- " + localObject, null);
        return localObject;
      }
    }
    catch (UnknownHostException localUnknownHostException)
    {
      d("DnsMain", "UnknownHostException cause[" + paramString + "][114.114.114.114]." + localUnknownHostException.getMessage(), null);
      for (;;)
      {
        return null;
        d("DnsMain", "114 - Address == null ? WTF ?!", null);
      }
    }
    catch (j localj)
    {
      for (;;)
      {
        d("DnsMain", "WireParseException cause[" + paramString + "][114.114.114.114]." + localj.getMessage(), null);
      }
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      for (;;)
      {
        d("DnsMain", "SocketTimeoutException cause[" + paramString + "][114.114.114.114]." + localSocketTimeoutException.getMessage(), null);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        d("DnsMain", "IOException cause[" + paramString + "][114.114.114.114]." + localIOException.getMessage(), null);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d("DnsMain", "Exception cause[" + paramString + "][114.114.114.114]." + localException.getMessage(), null);
      }
    }
  }
  
  public static String b(Context paramContext)
  {
    int i1 = Process.myPid();
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getRunningAppProcesses();
    if ((paramContext != null) && (paramContext.size() > 0)) {
      paramContext = paramContext.iterator();
    }
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!paramContext.hasNext()) {
        return null;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while (localRunningAppProcessInfo.pid != i1);
    return localRunningAppProcessInfo.processName;
  }
  
  public static String b(String paramString)
  {
    String str2 = null;
    String str1 = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = str1;
    }
    for (;;)
    {
      return paramString;
      str1 = str2;
      try
      {
        str2 = new URL(paramString).getAuthority();
        paramString = str2;
        str1 = str2;
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          int i1 = str2.indexOf(":");
          paramString = str2;
          if (i1 >= 0)
          {
            paramString = str2;
            str1 = str2;
            if (i1 < str2.length())
            {
              str1 = str2;
              paramString = str2.substring(0, i1);
              return paramString;
            }
          }
        }
      }
      catch (MalformedURLException paramString) {}
    }
    return str1;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if ((u != null) && (u.isDebugEnabled()))
    {
      u.d(paramString1, paramString2, null);
      return;
    }
    android.util.Log.d(paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((u != null) && (u.isInfoEnabled()))
    {
      u.i(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static boolean b()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static String c()
  {
    if (!b()) {}
    StatFs localStatFs;
    for (long l1 = -1L; l1 >= 0L; l1 = localStatFs.getBlockCount() * l1)
    {
      return a(0, (float)l1);
      localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      l1 = localStatFs.getBlockSize();
    }
    return "无SD Card";
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL(paramString).getAuthority();
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
  
  public static void c(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((u != null) && (u.isWarnEnabled()))
    {
      u.w(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.w(paramString1, paramString2, paramThrowable);
  }
  
  /* Error */
  public static int d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_m1
    //   8: ireturn
    //   9: new 309	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 310	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 313	java/net/URL:getAuthority	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne -18 -> 7
    //   28: aload_0
    //   29: ldc_w 315
    //   32: invokevirtual 318	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   35: istore_1
    //   36: iload_1
    //   37: iflt -30 -> 7
    //   40: aload_0
    //   41: invokevirtual 200	java/lang/String:length	()I
    //   44: istore_2
    //   45: iload_1
    //   46: iload_2
    //   47: if_icmpge -40 -> 7
    //   50: aload_0
    //   51: iload_1
    //   52: iconst_1
    //   53: iadd
    //   54: invokevirtual 221	java/lang/String:substring	(I)Ljava/lang/String;
    //   57: invokestatic 381	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   60: invokevirtual 384	java/lang/Integer:intValue	()I
    //   63: istore_1
    //   64: iload_1
    //   65: ireturn
    //   66: astore_0
    //   67: iconst_m1
    //   68: ireturn
    //   69: astore_0
    //   70: iconst_m1
    //   71: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramString	String
    //   35	30	1	i1	int
    //   44	4	2	i2	int
    // Exception table:
    //   from	to	target	type
    //   9	36	66	java/net/MalformedURLException
    //   40	45	66	java/net/MalformedURLException
    //   50	64	66	java/net/MalformedURLException
    //   50	64	69	java/lang/Exception
  }
  
  public static String d()
  {
    if (!b()) {}
    StatFs localStatFs;
    for (long l1 = -1L; l1 >= 0L; l1 = localStatFs.getAvailableBlocks() * l1)
    {
      return a(0, (float)l1);
      localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      l1 = localStatFs.getBlockSize();
    }
    return "无SD Card";
  }
  
  public static void d(String paramString1, String paramString2)
  {
    c(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((u != null) && (u.isErrorEnabled()))
    {
      u.e(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static int e(String paramString)
  {
    int i1 = 0;
    int i3 = 0;
    if (paramString == null) {
      return i3;
    }
    int i4 = paramString.length();
    int i2 = 0;
    for (;;)
    {
      i3 = i1;
      if (i2 >= i4) {
        break;
      }
      i3 = i1;
      if (':' == paramString.charAt(i2)) {
        i3 = i1 + 1;
      }
      i2 += 1;
      i1 = i3;
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static boolean f(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if (paramString1 == null) {
      return false;
    }
    return paramString1.regionMatches(true, 0, paramString2, 0, paramString2.length());
  }
  
  public static class SimpleRequest
    implements Parcelable
  {
    public static final Parcelable.Creator<SimpleRequest> CREATOR = new a();
    private String a;
    private List<String> b;
    private int c;
    private Downloader.DownloadMode d;
    
    public SimpleRequest() {}
    
    public SimpleRequest(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.a = paramParcel.readString();
      this.b = new ArrayList();
      paramParcel.readStringList(this.b);
      this.c = paramParcel.readInt();
      if (paramParcel.readInt() == 0) {}
      for (paramParcel = Downloader.DownloadMode.FastMode;; paramParcel = Downloader.DownloadMode.StrictMode)
      {
        this.d = paramParcel;
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof SimpleRequest))) {
          return false;
        }
        paramObject = (SimpleRequest)paramObject;
      } while (this.a.equalsIgnoreCase(paramObject.a));
      return false;
    }
    
    public String toString()
    {
      String str;
      int i;
      if (this.b != null)
      {
        str = "";
        i = 0;
        if (i < this.b.size()) {}
      }
      for (;;)
      {
        return new String("Download SimpleRequest: " + this.a + ", Path:" + str + ", content_type:" + this.c);
        str = str + (String)this.b.get(i) + ";";
        i += 1;
        break;
        str = "";
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeString(this.a);
      paramParcel.writeStringList(this.b);
      paramParcel.writeInt(this.c);
      if (this.d == Downloader.DownloadMode.FastMode) {}
      for (paramInt = 0;; paramInt = 1)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.Const
 * JD-Core Version:    0.7.0.1
 */