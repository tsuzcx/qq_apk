import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.animation.AnimationUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class aols
  extends ProtocolDownloader.Adapter
{
  private DefaultHttpClient sHttpClient;
  
  public aols()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      Object localObject = SSLSocketFactory.getSocketFactory();
      ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject, 443));
      label60:
      localObject = new BasicHttpParams();
      ConnManagerParams.setTimeout((HttpParams)localObject, 3000L);
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 30000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, 30000);
      this.sHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(new BasicHttpParams(), localSchemeRegistry), null);
      return;
    }
    catch (Exception localException)
    {
      break label60;
    }
  }
  
  private String getLastModified(String paramString)
  {
    return aroi.a().getContext().getSharedPreferences("http_lastmodify", 0).getString(paramString, "");
  }
  
  public static String lE(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    paramString = InitUrlDrawable.b.l(paramString);
    if (paramString.exists()) {
      return paramString.getAbsolutePath();
    }
    return null;
  }
  
  private void saveLastModified(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = aroi.a().getContext().getSharedPreferences("http_lastmodify", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws IOException
  {
    Object localObject1 = paramDownloadParams.urlStr;
    String str = Utils.Crc64String((String)localObject1);
    Object localObject2 = InitUrlDrawable.b.l(str);
    if ((localObject2 != null) && (((File)localObject2).exists())) {}
    for (int i = 1;; i = 0)
    {
      str = ((String)localObject1).replace("gamead", "http");
      localObject1 = new HttpGet(str);
      Object localObject3;
      if (paramDownloadParams.cookies != null)
      {
        localObject3 = this.sHttpClient.getCookieSpecs().getCookieSpec("best-match").formatCookies(paramDownloadParams.cookies.getCookies()).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((HttpGet)localObject1).addHeader((Header)((Iterator)localObject3).next());
        }
      }
      int j;
      if ((paramDownloadParams.headers != null) && (paramDownloadParams.headers.length > 0))
      {
        localObject3 = paramDownloadParams.headers;
        int k = localObject3.length;
        j = 0;
        while (j < k)
        {
          ((HttpGet)localObject1).addHeader(localObject3[j]);
          j += 1;
        }
      }
      if (i != 0) {
        ((HttpGet)localObject1).addHeader("If-Modified-Since", getLastModified(Utils.Crc64String(str)));
      }
      try
      {
        localObject3 = this.sHttpClient.execute((HttpUriRequest)localObject1);
        j = ((HttpResponse)localObject3).getStatusLine().getStatusCode();
        if (QLog.isColorLevel()) {
          QLog.d("LastModifySupportDownloader", 2, "-->status code: " + j);
        }
        if ((j != 200) && (j != 304)) {
          throw new IOException(paramDownloadParams.url + " response error! response code: " + j + " . reason: " + ((HttpResponse)localObject3).getStatusLine().getReasonPhrase());
        }
      }
      finally
      {
        ((HttpGet)localObject1).abort();
      }
      HttpEntity localHttpEntity = ((HttpResponse)localObject3).getEntity();
      if (j == 200)
      {
        if (i != 0) {
          ((File)localObject2).delete();
        }
        paramDownloadParams = new BufferedInputStream(localHttpEntity.getContent(), 4096);
        long l1 = 0L;
        try
        {
          localObject2 = new byte[4096];
          for (;;)
          {
            i = paramDownloadParams.read((byte[])localObject2);
            if (i == -1) {
              break;
            }
            paramOutputStream.write((byte[])localObject2, 0, i);
            long l2 = l1 + i;
            l1 = l2;
            if (AnimationUtils.currentAnimationTimeMillis() - 0L > 100L)
            {
              paramURLDrawableHandler.publishProgress((int)((float)l2 / (float)localHttpEntity.getContentLength() * 9500.0F));
              l1 = l2;
            }
          }
          if (!((HttpResponse)localObject3).containsHeader("Last-Modified")) {
            break label523;
          }
        }
        finally
        {
          paramDownloadParams.close();
        }
        paramOutputStream = ((HttpResponse)localObject3).getFirstHeader("Last-Modified").getValue();
        saveLastModified(Utils.Crc64String(str), paramOutputStream);
        label523:
        paramDownloadParams.close();
      }
      for (;;)
      {
        ((HttpGet)localObject1).abort();
        return null;
        if ((j != 304) && (paramURLDrawableHandler != null)) {
          paramURLDrawableHandler.publishProgress(10000);
        }
      }
    }
  }
  
  /* Error */
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 160	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   4: invokestatic 114	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_3
    //   8: getstatic 120	com/tencent/mobileqq/startup/step/InitUrlDrawable:b	Laokj;
    //   11: aload_3
    //   12: invokevirtual 364	aokj:a	(Ljava/lang/String;)Laokj$a;
    //   15: astore 5
    //   17: new 366	java/io/FileOutputStream
    //   20: dup
    //   21: aload 5
    //   23: getfield 372	aokj$a:aS	Ljava/io/File;
    //   26: iconst_0
    //   27: invokespecial 375	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   30: astore 4
    //   32: aload 4
    //   34: astore_3
    //   35: aload_0
    //   36: aload 4
    //   38: aload_1
    //   39: aload_2
    //   40: invokevirtual 377	aols:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   43: pop
    //   44: aload 4
    //   46: astore_3
    //   47: aload 5
    //   49: invokevirtual 381	aokj$a:I	()Ljava/io/File;
    //   52: astore_1
    //   53: aload 4
    //   55: ifnull +8 -> 63
    //   58: aload 4
    //   60: invokevirtual 382	java/io/OutputStream:close	()V
    //   63: aload_1
    //   64: areturn
    //   65: astore_2
    //   66: aconst_null
    //   67: astore_1
    //   68: aload 5
    //   70: ifnull +11 -> 81
    //   73: aload_1
    //   74: astore_3
    //   75: aload 5
    //   77: iconst_0
    //   78: invokevirtual 385	aokj$a:abort	(Z)V
    //   81: aload_1
    //   82: astore_3
    //   83: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +15 -> 101
    //   89: aload_1
    //   90: astore_3
    //   91: ldc 255
    //   93: iconst_2
    //   94: ldc_w 387
    //   97: aload_2
    //   98: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: aload_1
    //   102: astore_3
    //   103: aload_2
    //   104: athrow
    //   105: astore_1
    //   106: aload_3
    //   107: ifnull +7 -> 114
    //   110: aload_3
    //   111: invokevirtual 382	java/io/OutputStream:close	()V
    //   114: aload_1
    //   115: athrow
    //   116: astore_2
    //   117: aload_1
    //   118: areturn
    //   119: astore_2
    //   120: goto -6 -> 114
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_3
    //   126: goto -20 -> 106
    //   129: astore_2
    //   130: aload 4
    //   132: astore_1
    //   133: goto -65 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	aols
    //   0	136	1	paramDownloadParams	DownloadParams
    //   0	136	2	paramURLDrawableHandler	URLDrawableHandler
    //   7	119	3	localObject	Object
    //   30	101	4	localFileOutputStream	java.io.FileOutputStream
    //   15	61	5	locala	aokj.a
    // Exception table:
    //   from	to	target	type
    //   17	32	65	java/lang/Exception
    //   35	44	105	finally
    //   47	53	105	finally
    //   75	81	105	finally
    //   83	89	105	finally
    //   91	101	105	finally
    //   103	105	105	finally
    //   58	63	116	java/io/IOException
    //   110	114	119	java/io/IOException
    //   17	32	123	finally
    //   35	44	129	java/lang/Exception
    //   47	53	129	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aols
 * JD-Core Version:    0.7.0.1
 */