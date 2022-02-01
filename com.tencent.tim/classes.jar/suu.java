import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class suu
{
  public volatile long DA;
  public volatile long DB;
  public volatile long Dy;
  public volatile long Dz;
  public final int STATE_CONNECTING = 2;
  public final int STATE_DESTROY = -1;
  public final int STATE_EMPTY = 1;
  public final int STATE_FINISH = 4;
  public final int STATE_READY = 3;
  volatile WebResourceResponse a = null;
  String aGX;
  public volatile String aGY = "null";
  public boolean aNk;
  boolean aNl = false;
  public volatile boolean aNm;
  AtomicInteger aw = new AtomicInteger(1);
  AtomicBoolean bj = new AtomicBoolean(false);
  public AtomicBoolean bk = new AtomicBoolean(false);
  public String currUrl = "";
  public Thread j;
  private long mStartRequestTime;
  
  private HttpURLConnection a(Intent paramIntent)
  {
    localObject2 = null;
    try
    {
      long l = System.currentTimeMillis();
      localObject1 = "";
      if (this.aNk)
      {
        paramIntent = bw();
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "get cookie cost: " + (System.currentTimeMillis() - l));
        }
        localObject1 = paramIntent;
        if (TextUtils.isEmpty(paramIntent))
        {
          if (QLog.isColorLevel()) {
            QLog.w("PubAccountWebViewHttpBridge", 2, " cookie is null!");
          }
          this.aGY = "Cookie_Not_Valid";
          localObject1 = paramIntent;
        }
      }
      paramIntent = (HttpURLConnection)new URL(this.currUrl).openConnection();
      if (paramIntent != null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        int m;
        int i;
        paramIntent = localObject2;
        if (QLog.isColorLevel()) {
          QLog.e("PubAccountWebViewHttpBridge", 2, "http async get handleEvent exception !!!!", localException1);
        }
        if (paramIntent != null) {
          paramIntent.disconnect();
        }
        int k = 1;
        Intent localIntent = paramIntent;
      }
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountWebViewHttpBridge", 2, "HttpURLConnection is null!");
      }
      this.aGY = "URLConnection_NULL";
      return null;
    }
    catch (Exception localException2)
    {
      break label297;
      return localException2;
    }
    paramIntent.setConnectTimeout(15000);
    paramIntent.setReadTimeout(15000);
    paramIntent.setInstanceFollowRedirects(false);
    paramIntent.setRequestProperty("Cookie", (String)localObject1);
    paramIntent.setRequestProperty("Accept-Encoding", "gzip");
    paramIntent.setRequestProperty("User-Agent", arcp.b(arcp.qc("httpAsync 1.0"), "", false));
    m = paramIntent.getResponseCode();
    this.aGY = String.valueOf(m);
    if (m != 200) {}
    for (i = 1;; i = 0)
    {
      localObject1 = paramIntent;
      k = i;
      if (m == 200)
      {
        this.aGX = paramIntent.getHeaderField("Content-Length");
        localObject1 = paramIntent;
        k = i;
        if (QLog.isColorLevel())
        {
          QLog.d("PubAccountWebViewHttpBridge", 2, "length is " + this.aGX);
          k = i;
          localObject1 = paramIntent;
        }
      }
      if (k == 0) {
        break;
      }
      return null;
    }
  }
  
  private void bBc()
  {
    if (this.aw.compareAndSet(2, 3)) {
      synchronized (this.aw)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "now notify all thread!");
        }
        this.aw.notify();
        return;
      }
    }
  }
  
  private void bBd()
  {
    if (!this.aw.compareAndSet(1, 2)) {}
    long l;
    HttpURLConnection localHttpURLConnection;
    do
    {
      return;
      l = System.currentTimeMillis();
      localHttpURLConnection = a(null);
    } while (localHttpURLConnection == null);
    a(l, localHttpURLConnection, true);
  }
  
  private String getMime(String paramString)
  {
    String str1 = "text/html";
    String str2 = Uri.parse(paramString).getPath();
    if (str2.contains(".css")) {
      paramString = "text/css";
    }
    do
    {
      return paramString;
      if (str2.contains(".js")) {
        return "application/x-javascript";
      }
      if ((str2.contains(".jpg")) || (str2.contains(".gif")) || (str2.contains(".png"))) {
        break;
      }
      paramString = str1;
    } while (!str2.contains(".jpeg"));
    return "image/*";
  }
  
  public WebResourceResponse a(String arg1, int paramInt)
  {
    if (TextUtils.isEmpty(this.currUrl)) {
      return null;
    }
    int i = aroc.getNetType(null);
    JSONObject localJSONObject = new JSONObject();
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        Uri localUri = Uri.parse(this.currUrl);
        ??? = Uri.parse(???);
        Object localObject1 = localUri.getHost() + localUri.getPath();
        String str = ???.getHost() + ???.getPath();
        if (!localUri.getHost().equalsIgnoreCase(???.getHost())) {
          return null;
        }
        ??? = (String)localObject1;
        if (!((String)localObject1).endsWith("/")) {
          ??? = (String)localObject1 + "/";
        }
        localObject1 = str;
        if (!str.endsWith("/")) {
          localObject1 = str + "/";
        }
        if (!???.equalsIgnoreCase((String)localObject1)) {
          return null;
        }
        if (this.aw.get() != 2) {
          continue;
        }
      }
      catch (Exception ???)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PubAccountWebViewHttpBridge", 2, " some thing goes wrong！ WebResourceResponse is null!", ???);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PubAccountWebViewHttpBridge", 2, "state not connecting: " + this.aw);
        continue;
      }
      synchronized (this.aw)
      {
        try
        {
          if ((this.aw.get() == 2) && (!this.bj.get()))
          {
            this.bj.compareAndSet(false, true);
            if (QLog.isColorLevel()) {
              QLog.d("PubAccountWebViewHttpBridge", 2, "now wait for response!");
            }
            this.aw.wait(30000L);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          QLog.e("PubAccountWebViewHttpBridge", 1, "wait fror response failed", localInterruptedException);
          continue;
        }
        if (this.a == null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("PubAccountWebViewHttpBridge", 2, "asyncMode: 1, some thing goes wrong！ WebResourceResponse is null!");
          }
          this.currUrl = "";
          return this.a;
        }
      }
      if (!this.aw.compareAndSet(3, 4))
      {
        if (QLog.isColorLevel()) {
          QLog.w("PubAccountWebViewHttpBridge", 2, "can not use response !");
        }
        this.a = null;
        this.Dz = (System.currentTimeMillis() - l);
        this.DA = (System.currentTimeMillis() - this.mStartRequestTime);
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "return reponse for url, wait for : " + (System.currentTimeMillis() - l) + ", from click: " + this.DA + " , cache size=" + this.DB + "  ,cururl=" + this.currUrl);
        }
      }
      try
      {
        localJSONObject.put("waitResponseTime", this.Dz);
        localJSONObject.put("clickReadinjoyTime", this.DA);
        localJSONObject.put("loadedSize", this.DB);
        localJSONObject.put("platform", "android");
        localJSONObject.put("position", paramInt);
        kbp.a(null, "", "0X8007775", "0X8007775", 0, 0, this.aNm + "", "" + i, localJSONObject.toString(), this.aGX);
        continue;
        this.aNm = true;
      }
      catch (JSONException ???)
      {
        for (;;)
        {
          ???.printStackTrace();
        }
      }
    }
  }
  
  void a(long paramLong, HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    Object localObject1;
    try
    {
      this.DB = paramHttpURLConnection.getContentLength();
      if (QLog.isColorLevel())
      {
        localObject1 = Formatter.formatFileSize(BaseApplicationImpl.getApplication().getApplicationContext(), this.DB);
        QLog.d("PubAccountWebViewHttpBridge", 2, "data encoding: " + paramHttpURLConnection.getContentEncoding() + " now read content: " + (String)localObject1 + " reportWebsiteLength: " + this.DB);
      }
      localObject1 = paramHttpURLConnection.getInputStream();
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "inputstream or contentType goes wrong!");
        }
        this.aGY = "InputStream_Error";
        throw new RuntimeException("InputStream is null!");
      }
    }
    catch (Exception paramHttpURLConnection)
    {
      QLog.e("PubAccountWebViewHttpBridge", 1, "swiftHttp read data exception !!!! ", paramHttpURLConnection);
    }
    label169:
    long l;
    do
    {
      return;
      if (!"gzip".equalsIgnoreCase(paramHttpURLConnection.getContentEncoding())) {
        break;
      }
      localObject1 = new BufferedInputStream(new GZIPInputStream((InputStream)localObject1));
      l = System.currentTimeMillis();
    } while (!paramBoolean);
    Object localObject2 = null;
    byte[] arrayOfByte = new byte[10240];
    int i = 0;
    int k = 0;
    for (;;)
    {
      if (!this.bj.get())
      {
        i = ((BufferedInputStream)localObject1).read(arrayOfByte);
        if (i != -1) {}
      }
      else
      {
        this.DB = k;
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "now read data: " + k + ", now is ShouldIntercept: " + this.bj.get());
        }
        localObject3 = localObject1;
        if (i == -1)
        {
          localObject3 = localObject1;
          if (k > 0)
          {
            if (QLog.isColorLevel()) {
              QLog.i("PubAccountWebViewHttpBridge", 2, "now read all data!");
            }
            localObject3 = null;
            paramHttpURLConnection.disconnect();
            this.aGY = "Read_All_Data";
          }
        }
        localObject1 = null;
        if (localObject2 != null) {
          localObject1 = new BufferedInputStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject2).toByteArray()));
        }
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "read byte stream cost : " + (System.currentTimeMillis() - l) + ", total cost: " + (System.currentTimeMillis() - paramLong));
        }
        this.a = new WebResourceResponse(getMime(this.currUrl), "utf-8", new suu.a((BufferedInputStream)localObject1, (BufferedInputStream)localObject3, (ByteArrayOutputStream)localObject2, paramHttpURLConnection));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PubAccountWebViewHttpBridge", 2, "swiftHttp get cost " + (System.currentTimeMillis() - paramLong));
        QLog.d("QQBrowser_report", 2, "Web_qqbrowser_http_async_get, cost " + (System.currentTimeMillis() - paramLong));
        return;
        localObject1 = new BufferedInputStream((InputStream)localObject1);
        break label169;
      }
      k += i;
      Object localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = new ByteArrayOutputStream();
      }
      ((ByteArrayOutputStream)localObject3).write(arrayOfByte, 0, i);
      Thread.sleep(20L);
      localObject2 = localObject3;
    }
  }
  
  /* Error */
  public void aG(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 69	suu:bk	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   18: iconst_0
    //   19: iconst_1
    //   20: invokevirtual 297	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   23: pop
    //   24: aload_0
    //   25: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   28: putfield 322	suu:mStartRequestTime	J
    //   31: aload_0
    //   32: aload_1
    //   33: putfield 43	suu:currUrl	Ljava/lang/String;
    //   36: aload_0
    //   37: iload_2
    //   38: putfield 89	suu:aNk	Z
    //   41: aload_0
    //   42: new 490	com/tencent/biz/webviewplugin/PubAccountWebViewHttpBridge$1
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 492	com/tencent/biz/webviewplugin/PubAccountWebViewHttpBridge$1:<init>	(Lsuu;)V
    //   50: ldc 101
    //   52: iconst_5
    //   53: invokestatic 498	com/tencent/mobileqq/app/ThreadManager:newFreeThread	(Ljava/lang/Runnable;Ljava/lang/String;I)Ljava/lang/Thread;
    //   56: putfield 500	suu:j	Ljava/lang/Thread;
    //   59: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +36 -> 98
    //   65: ldc 101
    //   67: iconst_2
    //   68: new 103	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 502
    //   78: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: iconst_0
    //   83: anewarray 187	java/lang/String
    //   86: invokestatic 508	jqo:filterKeyForLog	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   89: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 439	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_0
    //   99: getfield 500	suu:j	Ljava/lang/Thread;
    //   102: invokevirtual 511	java/lang/Thread:start	()V
    //   105: goto -94 -> 11
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	suu
    //   0	113	1	paramString	String
    //   0	113	2	paramBoolean	boolean
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	108	finally
    //   14	98	108	finally
    //   98	105	108	finally
  }
  
  public String bw()
    throws Exception
  {
    return SwiftBrowserCookieMonster.pZ(this.currUrl);
  }
  
  public void destroy()
  {
    if (this.aw.get() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PubAccountWebViewHttpBridge", 2, "async http get cost too much time, now destroy!");
      }
      this.aw.set(-1);
    }
    for (;;)
    {
      synchronized (this.aw)
      {
        this.aw.notify();
        this.aNl = true;
        this.j = null;
        this.currUrl = "";
        return;
      }
      this.aw.set(-1);
    }
  }
  
  class a
    extends InputStream
  {
    BufferedInputStream a;
    HttpURLConnection c;
    ByteArrayOutputStream e;
    BufferedInputStream netStream;
    
    public a(BufferedInputStream paramBufferedInputStream1, BufferedInputStream paramBufferedInputStream2, ByteArrayOutputStream paramByteArrayOutputStream, HttpURLConnection paramHttpURLConnection)
    {
      this.a = paramBufferedInputStream1;
      this.netStream = paramBufferedInputStream2;
      if (paramByteArrayOutputStream != null) {}
      for (;;)
      {
        this.e = paramByteArrayOutputStream;
        this.c = paramHttpURLConnection;
        return;
        paramByteArrayOutputStream = new ByteArrayOutputStream();
      }
    }
    
    public void close()
      throws IOException
    {
      if (QLog.isColorLevel()) {
        QLog.i("PubAccountWebViewHttpBridge", 2, "now close memory stream and socket stream!");
      }
      try
      {
        if (this.a != null)
        {
          this.a.close();
          this.a = null;
        }
        if (this.netStream != null)
        {
          this.netStream.close();
          this.netStream = null;
        }
        if (this.c != null) {
          this.c.disconnect();
        }
        suu.this.a = null;
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public int read()
      throws IOException
    {
      int j;
      if ((this.a == null) && (this.netStream == null))
      {
        j = -1;
        return j;
      }
      if (this.a != null) {}
      for (int i = this.a.read();; i = -1)
      {
        j = i;
        if (i != -1) {
          break;
        }
        j = i;
        if (this.netStream == null) {
          break;
        }
        return this.netStream.read();
      }
    }
    
    public int read(byte[] paramArrayOfByte)
      throws IOException
    {
      int i;
      if ((this.a == null) && (this.netStream == null))
      {
        i = -1;
        return i;
      }
      if (this.a != null)
      {
        i = this.a.read(paramArrayOfByte);
        j = i;
        if (QLog.isColorLevel()) {
          QLog.i("PubAccountWebViewHttpBridge", 2, "now read data from memory buffer second: " + i);
        }
      }
      for (int j = i;; j = -1)
      {
        i = j;
        if (j != -1) {
          break;
        }
        i = j;
        if (this.netStream == null) {
          break;
        }
        j = this.netStream.read(paramArrayOfByte);
        i = j;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("PubAccountWebViewHttpBridge", 2, "now read data from socket stream second: " + j);
        return j;
      }
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if ((this.a == null) && (this.netStream == null)) {
        return -1;
      }
      int i = paramArrayOfByte.length;
      if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "buffer three, error");
        }
        throw new ArrayIndexOutOfBoundsException();
      }
      int j = 0;
      label65:
      if (j < paramInt2) {}
      for (;;)
      {
        int k;
        try
        {
          if (this.a == null) {
            break label162;
          }
          i = this.a.read();
          k = i;
          if (i == -1)
          {
            k = i;
            if (this.netStream != null) {
              k = this.netStream.read();
            }
          }
          if (k == -1)
          {
            if (j == 0) {
              break;
            }
            return j;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          if (j != 0) {
            return j;
          }
          throw paramArrayOfByte;
        }
        paramArrayOfByte[(paramInt1 + j)] = ((byte)k);
        j += 1;
        break label65;
        return paramInt2;
        label162:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     suu
 * JD-Core Version:    0.7.0.1
 */