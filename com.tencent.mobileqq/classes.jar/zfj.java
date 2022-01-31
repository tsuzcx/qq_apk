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
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class zfj
{
  public final int a;
  public volatile long a;
  volatile WebResourceResponse jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse = null;
  public String a;
  public Thread a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  public boolean a;
  public final int b;
  public volatile long b;
  String jdField_b_of_type_JavaLangString;
  public AtomicBoolean b;
  boolean jdField_b_of_type_Boolean = false;
  public final int c;
  public volatile long c;
  public volatile String c;
  public volatile boolean c;
  public final int d;
  public volatile long d;
  public final int e;
  private long e;
  
  public zfj()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = 3;
    this.jdField_d_of_type_Int = 4;
    this.jdField_e_of_type_Int = -1;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaLangString = "null";
  }
  
  private String a(String paramString)
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
  
  private HttpURLConnection a(Intent paramIntent)
  {
    localObject2 = null;
    try
    {
      long l = System.currentTimeMillis();
      localObject1 = "";
      if (this.jdField_a_of_type_Boolean)
      {
        paramIntent = a();
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "get cookie cost: " + (System.currentTimeMillis() - l));
        }
        localObject1 = paramIntent;
        if (TextUtils.isEmpty(paramIntent))
        {
          if (QLog.isColorLevel()) {
            QLog.w("PubAccountWebViewHttpBridge", 2, " cookie is null!");
          }
          this.jdField_c_of_type_JavaLangString = "Cookie_Not_Valid";
          localObject1 = paramIntent;
        }
      }
      paramIntent = (HttpURLConnection)new URL(this.jdField_a_of_type_JavaLangString).openConnection();
      if (paramIntent != null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        int k;
        int i;
        paramIntent = localObject2;
        if (QLog.isColorLevel()) {
          QLog.e("PubAccountWebViewHttpBridge", 2, "http async get handleEvent exception !!!!", localException1);
        }
        if (paramIntent != null) {
          paramIntent.disconnect();
        }
        int j = 1;
        Intent localIntent = paramIntent;
      }
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountWebViewHttpBridge", 2, "HttpURLConnection is null!");
      }
      this.jdField_c_of_type_JavaLangString = "URLConnection_NULL";
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
    paramIntent.setRequestProperty("User-Agent", beka.a(beka.c("httpAsync 1.0"), "", false));
    k = paramIntent.getResponseCode();
    this.jdField_c_of_type_JavaLangString = String.valueOf(k);
    if (k != 200) {}
    for (i = 1;; i = 0)
    {
      localObject1 = paramIntent;
      j = i;
      if (k == 200)
      {
        this.jdField_b_of_type_JavaLangString = paramIntent.getHeaderField("Content-Length");
        localObject1 = paramIntent;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("PubAccountWebViewHttpBridge", 2, "length is " + this.jdField_b_of_type_JavaLangString);
          j = i;
          localObject1 = paramIntent;
        }
      }
      if (j == 0) {
        break;
      }
      return null;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(2, 3)) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "now notify all thread!");
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notify();
        return;
      }
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2)) {}
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
  
  public WebResourceResponse a(String arg1, int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return null;
    }
    int i = bfbh.a(null);
    JSONObject localJSONObject = new JSONObject();
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        Uri localUri = Uri.parse(this.jdField_a_of_type_JavaLangString);
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
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) {
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
        QLog.d("PubAccountWebViewHttpBridge", 2, "state not connecting: " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
        continue;
      }
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        try
        {
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
          {
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
            if (QLog.isColorLevel()) {
              QLog.d("PubAccountWebViewHttpBridge", 2, "now wait for response!");
            }
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait(30000L);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          QLog.e("PubAccountWebViewHttpBridge", 1, "wait fror response failed", localInterruptedException);
          continue;
        }
        if (this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse == null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("PubAccountWebViewHttpBridge", 2, "asyncMode: 1, some thing goes wrong！ WebResourceResponse is null!");
          }
          this.jdField_a_of_type_JavaLangString = "";
          return this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse;
        }
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(3, 4))
      {
        if (QLog.isColorLevel()) {
          QLog.w("PubAccountWebViewHttpBridge", 2, "can not use response !");
        }
        this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse = null;
        this.jdField_b_of_type_Long = (System.currentTimeMillis() - l);
        this.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_e_of_type_Long);
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "return reponse for url, wait for : " + (System.currentTimeMillis() - l) + ", from click: " + this.jdField_c_of_type_Long + " , cache size=" + this.jdField_d_of_type_Long + "  ,cururl=" + this.jdField_a_of_type_JavaLangString);
        }
      }
      try
      {
        localJSONObject.put("waitResponseTime", this.jdField_b_of_type_Long);
        localJSONObject.put("clickReadinjoyTime", this.jdField_c_of_type_Long);
        localJSONObject.put("loadedSize", this.jdField_d_of_type_Long);
        localJSONObject.put("platform", "android");
        localJSONObject.put("position", paramInt);
        nrt.a(null, "", "0X8007775", "0X8007775", 0, 0, this.jdField_c_of_type_Boolean + "", "" + i, localJSONObject.toString(), this.jdField_b_of_type_JavaLangString);
        continue;
        this.jdField_c_of_type_Boolean = true;
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
  
  public String a()
  {
    return SwiftBrowserCookieMonster.c(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PubAccountWebViewHttpBridge", 2, "async http get cost too much time, now destroy!");
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notify();
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangThread = null;
        this.jdField_a_of_type_JavaLangString = "";
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    }
  }
  
  void a(long paramLong, HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    Object localObject1;
    try
    {
      this.jdField_d_of_type_Long = paramHttpURLConnection.getContentLength();
      if (QLog.isColorLevel())
      {
        localObject1 = Formatter.formatFileSize(BaseApplicationImpl.getApplication().getApplicationContext(), this.jdField_d_of_type_Long);
        QLog.d("PubAccountWebViewHttpBridge", 2, "data encoding: " + paramHttpURLConnection.getContentEncoding() + " now read content: " + (String)localObject1 + " reportWebsiteLength: " + this.jdField_d_of_type_Long);
      }
      localObject1 = paramHttpURLConnection.getInputStream();
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "inputstream or contentType goes wrong!");
        }
        this.jdField_c_of_type_JavaLangString = "InputStream_Error";
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
    int j = 0;
    for (;;)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        i = ((BufferedInputStream)localObject1).read(arrayOfByte);
        if (i != -1) {}
      }
      else
      {
        this.jdField_d_of_type_Long = j;
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "now read data: " + j + ", now is ShouldIntercept: " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        }
        localObject3 = localObject1;
        if (i == -1)
        {
          localObject3 = localObject1;
          if (j > 0)
          {
            if (QLog.isColorLevel()) {
              QLog.i("PubAccountWebViewHttpBridge", 2, "now read all data!");
            }
            localObject3 = null;
            paramHttpURLConnection.disconnect();
            this.jdField_c_of_type_JavaLangString = "Read_All_Data";
          }
        }
        localObject1 = null;
        if (localObject2 != null) {
          localObject1 = new BufferedInputStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject2).toByteArray()));
        }
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountWebViewHttpBridge", 2, "read byte stream cost : " + (System.currentTimeMillis() - l) + ", total cost: " + (System.currentTimeMillis() - paramLong));
        }
        this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse = new WebResourceResponse(a(this.jdField_a_of_type_JavaLangString), "utf-8", new zfk(this, (BufferedInputStream)localObject1, (BufferedInputStream)localObject3, (ByteArrayOutputStream)localObject2, paramHttpURLConnection));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PubAccountWebViewHttpBridge", 2, "swiftHttp get cost " + (System.currentTimeMillis() - paramLong));
        QLog.d("QQBrowser_report", 2, "Web_qqbrowser_http_async_get, cost " + (System.currentTimeMillis() - paramLong));
        return;
        localObject1 = new BufferedInputStream((InputStream)localObject1);
        break label169;
      }
      j += i;
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
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 51	zfj:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   18: iconst_0
    //   19: iconst_1
    //   20: invokevirtual 270	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   23: pop
    //   24: aload_0
    //   25: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   28: putfield 295	zfj:jdField_e_of_type_Long	J
    //   31: aload_0
    //   32: aload_1
    //   33: putfield 25	zfj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: aload_0
    //   37: iload_2
    //   38: putfield 108	zfj:jdField_a_of_type_Boolean	Z
    //   41: aload_0
    //   42: new 474	com/tencent/biz/webviewplugin/PubAccountWebViewHttpBridge$1
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 476	com/tencent/biz/webviewplugin/PubAccountWebViewHttpBridge$1:<init>	(Lzfj;)V
    //   50: ldc 118
    //   52: iconst_5
    //   53: invokestatic 482	com/tencent/mobileqq/app/ThreadManager:newFreeThread	(Ljava/lang/Runnable;Ljava/lang/String;I)Ljava/lang/Thread;
    //   56: putfield 358	zfj:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   59: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +36 -> 98
    //   65: ldc 118
    //   67: iconst_2
    //   68: new 120	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 484
    //   78: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: iconst_0
    //   83: anewarray 77	java/lang/String
    //   86: invokestatic 489	ndq:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   89: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 422	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_0
    //   99: getfield 358	zfj:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   102: invokevirtual 492	java/lang/Thread:start	()V
    //   105: goto -94 -> 11
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	zfj
    //   0	113	1	paramString	String
    //   0	113	2	paramBoolean	boolean
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	108	finally
    //   14	98	108	finally
    //   98	105	108	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zfj
 * JD-Core Version:    0.7.0.1
 */