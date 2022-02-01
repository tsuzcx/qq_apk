package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TbsLogClient
{
  static TbsLogClient a = null;
  static File c = null;
  static String d = null;
  static byte[] e = null;
  private static boolean i = true;
  TextView b;
  private SimpleDateFormat f = null;
  private Context g = null;
  private StringBuffer h = new StringBuffer();
  
  public TbsLogClient(Context paramContext)
  {
    try
    {
      this.g = paramContext.getApplicationContext();
      this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
      return;
    }
    catch (Exception paramContext)
    {
      this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
    }
  }
  
  private void a()
  {
    try
    {
      if (c == null) {
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          String str = FileUtil.a(this.g, 6);
          if (str == null)
          {
            c = null;
            return;
          }
          c = new File(str, "tbslog.txt");
          d = LogFileUtils.createKey();
          e = LogFileUtils.createHeaderText(c.getName(), d);
          return;
        }
      }
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return;
      c = null;
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public static void setWriteLogJIT(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public void d(String paramString1, String paramString2) {}
  
  public void e(String paramString1, String paramString2) {}
  
  public void i(String paramString1, String paramString2) {}
  
  public void setLogView(TextView paramTextView)
  {
    this.b = paramTextView;
  }
  
  public void showLog(String paramString)
  {
    if (this.b != null) {
      this.b.post(new a(paramString));
    }
  }
  
  public void v(String paramString1, String paramString2) {}
  
  public void w(String paramString1, String paramString2) {}
  
  public void writeLog(String paramString)
  {
    try
    {
      String str = this.f.format(Long.valueOf(System.currentTimeMillis()));
      this.h.append(str).append(" pid=").append(Process.myPid()).append(" tid=").append(Process.myTid()).append(paramString).append("\n");
      if ((Thread.currentThread() != Looper.getMainLooper().getThread()) || (i)) {
        writeLogToDisk();
      }
      if (this.h.length() > 524288) {
        this.h.delete(0, this.h.length());
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void writeLogToDisk()
  {
    try
    {
      a();
      if (c != null)
      {
        LogFileUtils.writeDataToStorage(c, d, e, this.h.toString(), true);
        this.h.delete(0, this.h.length());
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  class a
    implements Runnable
  {
    String a = null;
    
    a(String paramString)
    {
      this.a = paramString;
    }
    
    public void run()
    {
      if (TbsLogClient.this.b != null) {
        TbsLogClient.this.b.append(this.a + "\n");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsLogClient
 * JD-Core Version:    0.7.0.1
 */