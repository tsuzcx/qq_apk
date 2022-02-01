package c.t.m.g;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLException;

public final class aj
{
  public String a;
  public String b;
  public String c;
  
  public aj(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString2;
    this.b = paramString1;
    this.c = paramString3;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte, int paramInt, Object paramObject)
  {
    c localc = (c)paramObject;
    for (;;)
    {
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
        localHttpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setConnectTimeout(10000);
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
        localHttpURLConnection.setRequestProperty("Connection", "close");
        Object localObject = localHttpURLConnection.getOutputStream();
        ((OutputStream)localObject).write(paramArrayOfByte);
        ((OutputStream)localObject).flush();
        ((OutputStream)localObject).close();
        int i = localHttpURLConnection.getResponseCode();
        switch (i)
        {
        case 200: 
          localc.b("net sdk error: ".concat(String.valueOf(i)));
          localHttpURLConnection.disconnect();
          return;
          localObject = b(localHttpURLConnection.getHeaderField("content-type"));
          localc.a(new String(a(localHttpURLConnection.getInputStream()), (String)localObject));
        }
      }
      catch (Throwable localThrowable)
      {
        if ((paramInt <= 0) && (((localThrowable instanceof GeneralSecurityException)) || ((localThrowable instanceof SSLException))))
        {
          paramString = paramString.replaceAll("https:", "http:");
          paramInt += 1;
          break;
        }
        localc.b("tryTime=" + paramInt + "," + paramString + "," + Log.getStackTraceString(localThrowable));
        return;
      }
    }
  }
  
  private static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(256);
    byte[] arrayOfByte = aa.a().a(512);
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream.close();
    aa.a().a(arrayOfByte);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] a(String paramString, Object paramObject)
  {
    paramObject = (c)paramObject;
    try
    {
      paramString = new URL(paramString).openConnection();
      paramString.connect();
      paramString = a(paramString.getInputStream());
      paramObject.a(new String(paramString, "UTF-8"));
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramObject.b(paramString.toString());
    }
    return null;
  }
  
  private static String b(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i].trim();
        int k = str1.indexOf("charset=");
        if (-1 != k) {
          str1 = str1.substring(k + 8, str1.length());
        }
      }
      else
      {
        return str1;
      }
      i += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract byte[] a(byte[] paramArrayOfByte);
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString);
    
    public abstract void b(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString);
    
    public abstract void b(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.aj
 * JD-Core Version:    0.7.0.1
 */