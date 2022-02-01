package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TBaseLogger
{
  protected static volatile ExecutorService a = Executors.newSingleThreadExecutor(new MinPriorityThreadFactory(null));
  private static boolean b = false;
  private static boolean c = false;
  private static String d = "tencent" + File.separator + ".TPush";
  private static int e = 2;
  private static List<String> f = Collections.synchronizedList(new ArrayList());
  private static boolean g = false;
  private static boolean h = false;
  private static String i = null;
  private static String j = null;
  private static Context k;
  private static DeviceInfo l;
  private static boolean m = false;
  private static LoggerInterface n = new DefaultLogger();
  
  private static void a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if (m) {}
    for (;;)
    {
      return;
      String str1;
      if (paramString2 != null)
      {
        str1 = paramString2;
        if (!paramString2.trim().equals("")) {}
      }
      else
      {
        str1 = "TBase - TPush";
      }
      try
      {
        String str2 = LogUtil.formatDate(new Date(), "MM.dd_HH:mm:ss_SSS");
        paramString2 = paramString3;
        if (paramString3 == null) {
          paramString2 = "";
        }
        paramString2 = new BufferedReader(new StringReader(paramString2), 256);
        paramString3 = "[" + str1 + "]";
        try
        {
          for (;;)
          {
            str1 = paramString2.readLine();
            if (str1 == null) {
              break;
            }
            b(str2 + " " + e() + " " + paramString1 + " " + paramString3 + " " + str1);
          }
          if (paramThrowable == null) {
            continue;
          }
        }
        catch (IOException paramString2)
        {
          paramString2.printStackTrace();
        }
        paramString2 = new StringWriter();
        paramThrowable.printStackTrace(new PrintWriter(paramString2));
        paramString2 = paramString2.toString();
        b(str2 + " " + e() + " " + paramString1 + paramString2);
        return;
      }
      catch (Throwable paramString1) {}
    }
  }
  
  private static void a(List<String> paramList, WriteFileCallback paramWriteFileCallback)
  {
    try
    {
      a.execute(new TBaseLogger.2(paramWriteFileCallback, paramList));
      return;
    }
    catch (Throwable paramList)
    {
      e("TBase - TPush", "savelog error", paramList);
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt >= e;
  }
  
  public static void addThirdLog(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    switch (paramInt)
    {
    default: 
      ee(paramString1, "illegal log level: " + paramString2, paramThrowable);
      return;
    case 2: 
      vv(paramString1, paramString2, paramThrowable);
      return;
    case 3: 
      dd(paramString1, paramString2, paramThrowable);
      return;
    case 4: 
      ii(paramString1, paramString2, paramThrowable);
      return;
    case 5: 
      ww(paramString1, paramString2, paramThrowable);
      return;
    }
    ee(paramString1, paramString2, paramThrowable);
  }
  
  private static void b(String paramString)
  {
    if (h) {}
    do
    {
      return;
      f.add(paramString);
    } while (f.size() != 100);
    paramString = f;
    f = Collections.synchronizedList(new ArrayList());
    g = LogUtil.isSDCardMounted(k);
    if (g)
    {
      v("TBase - TPush", "have writable external storage, write log file!");
      a(paramString, null);
      return;
    }
    v("TBase - TPush", "no writable external storage");
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if ((b) && (a(3)))
    {
      n.d("TPush", "[" + paramString1 + "] " + paramString2);
      if (c) {
        a("DEBUG", paramString1, paramString2, null);
      }
    }
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((b) && (a(3)))
    {
      n.d("TPush", "[" + paramString1 + "] " + paramString2, paramThrowable);
      if (c) {
        a("DEBUG", paramString1, paramString2, paramThrowable);
      }
    }
  }
  
  public static void dd(String paramString1, String paramString2)
  {
    if (a(3))
    {
      n.d("TPush", "[" + paramString1 + "] " + paramString2);
      a("DEBUG", paramString1, paramString2, null);
    }
  }
  
  public static void dd(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a(3))
    {
      n.d("TPush", "[" + paramString1 + "] " + paramString2, paramThrowable);
      a("DEBUG", paramString1, paramString2, paramThrowable);
    }
  }
  
  private static String e()
  {
    try
    {
      String str = Process.myPid() + " " + Thread.currentThread().getId();
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if ((b) && (a(6))) {
      n.e("TPush", "[" + paramString1 + "] " + paramString2);
    }
    a("ERROR", paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((b) && (a(6))) {
      n.e("TPush", "[" + paramString1 + "] " + paramString2, paramThrowable);
    }
    a("ERROR", paramString1, paramString2, paramThrowable);
  }
  
  public static void ee(String paramString1, String paramString2)
  {
    if (a(6)) {
      n.e("TPush", "[" + paramString1 + "] " + paramString2);
    }
    a("ERROR", paramString1, paramString2, null);
  }
  
  public static void ee(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a(6)) {
      n.e("TPush", "[" + paramString1 + "] " + paramString2, paramThrowable);
    }
    a("ERROR", paramString1, paramString2, paramThrowable);
  }
  
  public static void enableDebug(Context paramContext, boolean paramBoolean)
  {
    b = paramBoolean;
    c = paramBoolean;
    init(paramContext);
  }
  
  private static String f()
  {
    if (i != null) {
      return i;
    }
    try
    {
      if (k != null) {
        i = k.getExternalFilesDir(d).getAbsolutePath();
      }
      String str = i;
      return str;
    }
    catch (Throwable localThrowable)
    {
      w("TBase - TPush", "TLogger ->getFileNamePre:" + localThrowable.getMessage());
    }
    return null;
  }
  
  public static void flush()
  {
    flush(null);
  }
  
  public static void flush(WriteFileCallback paramWriteFileCallback)
  {
    h = true;
    List localList = f;
    f = Collections.synchronizedList(new ArrayList());
    if (g) {
      a(localList, paramWriteFileCallback);
    }
    h = false;
  }
  
  public static Context getAppContent()
  {
    return k;
  }
  
  public static String getStackTraceString(Throwable paramThrowable)
  {
    return Log.getStackTraceString(paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if ((b) && (a(4)))
    {
      n.i("TPush", "[" + paramString1 + "] " + paramString2);
      if (c) {
        a("INFO", paramString1, paramString2, null);
      }
    }
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((b) && (a(4)))
    {
      n.i("TPush", "[" + paramString1 + "] " + paramString2, paramThrowable);
      if (c) {
        a("INFO", paramString1, paramString2, paramThrowable);
      }
    }
  }
  
  public static void ii(String paramString1, String paramString2)
  {
    if (a(4))
    {
      n.i("TPush", "[" + paramString1 + "] " + paramString2);
      a("INFO", paramString1, paramString2, null);
    }
  }
  
  public static void ii(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a(4))
    {
      n.i("TPush", "[" + paramString1 + "] " + paramString2, paramThrowable);
      a("INFO", paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    if (k == null) {
      k = paramContext.getApplicationContext();
    }
    g = LogUtil.isSDCardMounted(k);
  }
  
  public static boolean isFileEnabled()
  {
    return c;
  }
  
  public static void removeOldDebugLogFiles(int paramInt)
  {
    try
    {
      Object localObject = f();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = (String)localObject + File.separator + "Logs";
      File localFile = new File((String)localObject);
      int i3;
      int i4;
      if (localFile.exists())
      {
        int i6 = ((String)localObject).length() + 5;
        int i7 = LogUtil.PATTERN_DATETIME_FILENAME.length();
        if ((localFile != null) && (localFile.listFiles() != null) && (localFile.listFiles().length > 0))
        {
          localObject = localFile.listFiles();
          int i8 = localObject.length;
          int i5 = 0;
          for (int i1 = 7;; i1 = i3)
          {
            if (i5 >= i8) {
              return;
            }
            localFile = localObject[i5];
            i3 = i1;
            i4 = i1;
            try
            {
              if (localFile.isFile())
              {
                i4 = i1;
                String str = localFile.getAbsolutePath();
                i4 = i1;
                Date localDate = LogUtil.parseDateInFilename(str.substring(i6, i6 + i7));
                int i2 = i1;
                if (paramInt > 0) {
                  i2 = i1 - paramInt;
                }
                i3 = i2;
                i4 = i2;
                if (LogUtil.isDaysAgo(localDate, i2))
                {
                  i4 = i2;
                  d("TBase - TPush", "delete logs file " + str);
                  i4 = i2;
                  localFile.delete();
                  i3 = i2;
                }
              }
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                e("TBase - TPush", "removeOldDebugLogFiles" + localThrowable2);
                i3 = i4;
              }
            }
            i5 += 1;
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      e("TBase - TPush", "removeOldDebugLogFiles", localThrowable1);
    }
  }
  
  public static void setDebugLevel(int paramInt)
  {
    if ((paramInt < 2) || (paramInt > 6)) {
      return;
    }
    e = paramInt;
  }
  
  public static void setLogger(LoggerInterface paramLoggerInterface)
  {
    n = paramLoggerInterface;
    m = true;
    n.i("TBase - TPush", "set third logger delegate");
  }
  
  public static void uploadLogFile(Context paramContext, HttpRequestCallback paramHttpRequestCallback)
  {
    try
    {
      init(paramContext);
      flush(new TBaseLogger.1(paramContext, f(), paramHttpRequestCallback));
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if ((b) && (a(2)))
    {
      n.v("TPush", "[" + paramString1 + "] " + paramString2);
      if (c) {
        a("TRACE", paramString1, paramString2, null);
      }
    }
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((b) && (a(2)))
    {
      n.v("TPush", "[" + paramString1 + "] " + paramString2, paramThrowable);
      if (c) {
        a("TRACE", paramString1, paramString2, paramThrowable);
      }
    }
  }
  
  public static void vv(String paramString1, String paramString2)
  {
    if (a(2))
    {
      n.v("TPush", "[" + paramString1 + "] " + paramString2);
      a("TRACE", paramString1, paramString2, null);
    }
  }
  
  public static void vv(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a(2))
    {
      n.v("TPush", "[" + paramString1 + "] " + paramString2, paramThrowable);
      a("TRACE", paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if ((b) && (a(5))) {
      n.w("TPush", "[" + paramString1 + "] " + paramString2);
    }
    a("WARN", paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((b) && (a(5))) {
      n.w("TPush", "[" + paramString1 + "] " + paramString2, paramThrowable);
    }
    a("WARN", paramString1, paramString2, paramThrowable);
  }
  
  public static void ww(String paramString1, String paramString2)
  {
    if (a(5)) {
      n.w("TPush", "[" + paramString1 + "] " + paramString2);
    }
    a("WARN", paramString1, paramString2, null);
  }
  
  public static void ww(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a(5)) {
      n.w("TPush", "[" + paramString1 + "] " + paramString2, paramThrowable);
    }
    a("WARN", paramString1, paramString2, paramThrowable);
  }
  
  static class MinPriorityThreadFactory
    implements ThreadFactory
  {
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      paramRunnable.setPriority(10);
      return paramRunnable;
    }
  }
  
  public static abstract interface WriteFileCallback
  {
    public abstract void onFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.logger.TBaseLogger
 * JD-Core Version:    0.7.0.1
 */