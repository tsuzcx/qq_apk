import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlConnection.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class abvb
{
  public int CONNECT_TIMEOUT_MILLIS = 5000;
  public int READ_TIMEOUT_MILLIS = 15000;
  private String YP;
  private abuy.a a;
  private boolean bFL;
  private HttpURLConnection c;
  private String hX;
  private BufferedInputStream responseStream;
  
  public abvb(String paramString1, boolean paramBoolean, abuy.a parama, String paramString2)
  {
    this.YP = paramString1;
    this.bFL = paramBoolean;
    this.a = parama;
    this.hX = paramString2;
  }
  
  /* Error */
  private BufferedInputStream getResponseStream()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	abvb:responseStream	Ljava/io/BufferedInputStream;
    //   6: ifnonnull +54 -> 60
    //   9: aload_0
    //   10: getfield 41	abvb:c	Ljava/net/HttpURLConnection;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +45 -> 60
    //   18: aload_0
    //   19: getfield 41	abvb:c	Ljava/net/HttpURLConnection;
    //   22: invokevirtual 53	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   25: astore_1
    //   26: ldc 55
    //   28: aload_0
    //   29: getfield 41	abvb:c	Ljava/net/HttpURLConnection;
    //   32: invokevirtual 59	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   35: invokevirtual 65	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   38: ifeq +31 -> 69
    //   41: aload_0
    //   42: new 67	java/io/BufferedInputStream
    //   45: dup
    //   46: new 69	java/util/zip/GZIPInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 72	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: invokespecial 73	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: putfield 47	abvb:responseStream	Ljava/io/BufferedInputStream;
    //   60: aload_0
    //   61: getfield 47	abvb:responseStream	Ljava/io/BufferedInputStream;
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: areturn
    //   69: aload_0
    //   70: new 67	java/io/BufferedInputStream
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 73	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: putfield 47	abvb:responseStream	Ljava/io/BufferedInputStream;
    //   81: goto -21 -> 60
    //   84: astore_1
    //   85: ldc 75
    //   87: iconst_2
    //   88: new 77	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   95: ldc 80
    //   97: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 87	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   104: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 89
    //   109: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: goto -58 -> 60
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	abvb
    //   13	62	1	localObject1	Object
    //   84	17	1	localThrowable	Throwable
    //   121	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	60	84	java/lang/Throwable
    //   69	81	84	java/lang/Throwable
    //   2	14	121	finally
    //   18	60	121	finally
    //   60	65	121	finally
    //   69	81	121	finally
    //   85	118	121	finally
  }
  
  abvb.a a(AtomicBoolean paramAtomicBoolean, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    boolean bool = false;
    for (;;)
    {
      BufferedInputStream localBufferedInputStream;
      ByteArrayOutputStream localByteArrayOutputStream;
      int j;
      try
      {
        localBufferedInputStream = getResponseStream();
        if (localBufferedInputStream != null)
        {
          localByteArrayOutputStream = paramByteArrayOutputStream;
          if (paramByteArrayOutputStream == null) {
            localByteArrayOutputStream = new ByteArrayOutputStream();
          }
          paramByteArrayOutputStream = new byte[10240];
          int i = 0;
          j = i;
          try
          {
            if (paramAtomicBoolean.get()) {
              continue;
            }
            i = localBufferedInputStream.read(paramByteArrayOutputStream);
            j = i;
            if (-1 == i) {
              continue;
            }
            localByteArrayOutputStream.write(paramByteArrayOutputStream, 0, i);
          }
          catch (Throwable paramAtomicBoolean)
          {
            QLog.e("apollo_client_ApolloUrlConnection", 2, " getResponseData error:" + paramAtomicBoolean.getMessage());
          }
        }
        paramAtomicBoolean = null;
        return paramAtomicBoolean;
      }
      finally {}
      paramAtomicBoolean = new abvb.a();
      paramAtomicBoolean.responseStream = localBufferedInputStream;
      paramAtomicBoolean.outputStream = localByteArrayOutputStream;
      if (-1 == j) {
        bool = true;
      }
      paramAtomicBoolean.isComplete = bool;
    }
  }
  
  int connect()
  {
    char c1 = '?';
    for (;;)
    {
      String str2;
      try
      {
        if (this.c != null) {
          continue;
        }
        long l = System.currentTimeMillis();
        localObject3 = "";
        if (this.bFL)
        {
          str1 = abuj.getCookie(this.YP);
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloUrlConnection", 2, "get cookie cost: " + (System.currentTimeMillis() - l));
          }
          localObject3 = str1;
          if (TextUtils.isEmpty(str1))
          {
            localObject3 = str1;
            if (QLog.isColorLevel())
            {
              QLog.w("apollo_client_ApolloUrlConnection", 2, " cookie is null!");
              localObject3 = str1;
            }
          }
        }
        if ((this.a == null) || (!this.a.jQ()) || (TextUtils.isEmpty(this.YP))) {
          break label893;
        }
        this.YP = this.a.mUrl;
        str2 = this.a.p(true);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlConnection", 2, "getUrlConnection mCgiConfig.parameterStr:" + str2);
        }
        if ((TextUtils.isEmpty(str2)) || (!"get".equals(this.a.mMethod.toLowerCase()))) {
          break label886;
        }
        i = this.YP.indexOf('?');
        j = this.YP.indexOf('#');
        if (i != -1) {
          continue;
        }
        if (j != -1) {
          continue;
        }
        str1 = this.YP + c1;
        this.YP = str1;
        this.YP += str2;
        str1 = null;
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlConnection", 2, " getUrlConnection mCurrentUrl:" + this.YP);
        }
        this.c = ((HttpURLConnection)new URL(this.YP).openConnection());
        if (this.c != null) {
          continue;
        }
        QLog.e("apollo_client_ApolloUrlConnection", 1, "getUrlConnection HttpURLConnection is null!");
        i = -1;
      }
      catch (IOException localIOException)
      {
        String str1;
        int j;
        QLog.e("apollo_client_ApolloUrlConnection", 2, "getUrlConnection connect http exception !!!!" + localIOException);
        if (this.c == null) {
          continue;
        }
        this.c.disconnect();
        i = -1;
        continue;
        if (TextUtils.isEmpty(this.hX)) {
          continue;
        }
        this.c.setRequestProperty("Origin", this.hX);
        this.c.setRequestProperty("Referer", this.hX);
        if ((this.a == null) || (!this.a.jQ())) {
          break label881;
        }
        if (!"get".equals(this.a.mMethod.toLowerCase())) {
          continue;
        }
        this.c.setDoOutput(false);
        this.c.setDoInput(true);
        this.c.setRequestMethod("GET");
        i = 0;
        if (i != 0) {
          break label899;
        }
        this.c.connect();
        break label899;
        if (!"post".equals(this.a.mMethod.toLowerCase())) {
          break label881;
        }
        this.c.setDoOutput(true);
        this.c.setDoInput(true);
        this.c.setRequestMethod("POST");
        if (TextUtils.isEmpty(localIOException)) {
          break label881;
        }
        Object localObject3 = new OutputStreamWriter(this.c.getOutputStream());
        ((OutputStreamWriter)localObject3).write(localIOException);
        ((OutputStreamWriter)localObject3).flush();
        ((OutputStreamWriter)localObject3).close();
        i = 1;
        continue;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("apollo_client_ApolloUrlConnection", 2, "getUrlConnection connect http exception !!!!" + localThrowable);
        if (this.c == null) {
          continue;
        }
        this.c.disconnect();
        continue;
      }
      finally {}
      return i;
      c1 = '&';
      continue;
      str1 = this.YP.substring(0, j) + c1 + this.YP.substring(j);
      continue;
      this.c.setConnectTimeout(this.CONNECT_TIMEOUT_MILLIS);
      this.c.setReadTimeout(this.READ_TIMEOUT_MILLIS);
      this.c.setInstanceFollowRedirects(false);
      this.c.setRequestProperty("Cookie", (String)localObject3);
      this.c.setRequestProperty("Accept-Encoding", "gzip");
      localObject3 = arcp.b(arcp.qc("httpAsync 1.0"), "", false);
      this.c.setRequestProperty("User-Agent", (String)localObject3);
      if (this.a != null)
      {
        localObject3 = this.a.mHeaders.keySet().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          str2 = (String)((Iterator)localObject3).next();
          this.c.setRequestProperty(str2, (String)this.a.mHeaders.get(str2));
          continue;
        }
      }
      label881:
      int i = 0;
      continue;
      label886:
      Object localObject2 = str2;
      continue;
      label893:
      localObject2 = null;
      continue;
      label899:
      i = 0;
    }
  }
  
  public void disconnect()
  {
    if (this.c == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnSubThread(new ApolloUrlConnection.1(this));
      return;
    }
    try
    {
      this.c.disconnect();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("apollo_client_ApolloUrlConnection", 2, "disconnect error:" + localException.getMessage());
    }
  }
  
  public int getResponseCode()
  {
    if (this.c != null) {
      try
      {
        int i = this.c.getResponseCode();
        return i;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("apollo_client_ApolloUrlConnection", 2, "getResponseCode error:" + localThrowable.getMessage());
      }
    }
    return -1;
  }
  
  Map<String, List<String>> getResponseHeaderFields()
  {
    Map localMap = null;
    try
    {
      if (this.c != null) {
        localMap = this.c.getHeaderFields();
      }
      return localMap;
    }
    catch (Exception localException)
    {
      QLog.e("apollo_client_ApolloUrlConnection", 1, localException, new Object[0]);
    }
    return null;
  }
  
  static class a
  {
    boolean isComplete;
    ByteArrayOutputStream outputStream;
    BufferedInputStream responseStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvb
 * JD-Core Version:    0.7.0.1
 */