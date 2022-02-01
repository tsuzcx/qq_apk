package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.smtt.utils.TbsLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class e
{
  private static String a = "EmergencyManager";
  private static final Object f = new Object();
  private static HandlerThread g;
  private static Handler h;
  private String b;
  private String c;
  private String d;
  private Handler e;
  
  public e(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, paramString1, paramString2, "POST");
  }
  
  public e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = new Handler(paramContext.getMainLooper());
  }
  
  private static Handler b()
  {
    synchronized (f)
    {
      if (h == null)
      {
        g = new HandlerThread("HttpThread");
        g.start();
        h = new Handler(g.getLooper());
      }
      Handler localHandler = h;
      return localHandler;
    }
  }
  
  public String a(String paramString)
  {
    TbsLog.e(a, "Request url: " + this.b + ",params: " + this.c);
    int i;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      paramString = (HttpURLConnection)new URL(paramString.trim()).openConnection();
      paramString.setRequestMethod(this.d);
      paramString.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
      paramString.setRequestProperty("Content-Length", this.c.length() + "");
      paramString.setDoOutput(true);
      paramString.getOutputStream().write(this.c.getBytes());
      i = paramString.getResponseCode();
      if (200 == i)
      {
        paramString = paramString.getInputStream();
        localByteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          i = paramString.read(arrayOfByte);
          if (-1 == i) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
          localByteArrayOutputStream.flush();
        }
        return null;
      }
    }
    catch (Exception paramString)
    {
      TbsLog.e(a, "Http exception: " + paramString.getMessage());
    }
    for (;;)
    {
      return localByteArrayOutputStream.toString("utf-8");
      TbsLog.e(a, "Bad http request, code: " + i);
    }
  }
  
  public void a(a parama)
  {
    b().post(new e.1(this, parama));
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.e
 * JD-Core Version:    0.7.0.1
 */