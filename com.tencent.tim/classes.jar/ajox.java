import android.content.Context;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.myapp.net.HttpResponseException;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class ajox
{
  private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
  public static ThreadSafeClientConnManager a;
  
  private static ajoy a()
  {
    Object localObject1 = BaseApplication.getContext();
    ajoy localajoy = new ajoy();
    try
    {
      String str1;
      String str2;
      String str3;
      try
      {
        localObject1 = alld.query(((Context)localObject1).getContentResolver(), PREFERRED_APN_URI, null, null, null, null);
        ((Cursor)localObject1).moveToFirst();
        str1 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("proxy"));
        if (str1 != null) {
          str1.toLowerCase();
        }
        str2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("port"));
        str3 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("apn"));
        if (str3 != null) {
          str3.toLowerCase();
        }
        ((Cursor)localObject1).close();
        if ((str3 != null) && (str3.startsWith("ctwap"))) {
          if ((str1 != null) && (str1.length() > 0) && (Integer.valueOf(str2).intValue() < 0))
          {
            localajoy.address = str1;
            localajoy.port = Integer.valueOf(str2).intValue();
          }
          else
          {
            localajoy.address = "10.0.0.200";
            localajoy.port = 80;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localajoy;
      }
      if ((str3 != null) && (str3.startsWith("cmwap")))
      {
        if ((str1 != null) && (str1.length() > 0) && (Integer.valueOf(str2).intValue() < 0))
        {
          localajoy.address = str1;
          localajoy.port = Integer.valueOf(str2).intValue();
        }
        else
        {
          localajoy.address = "10.0.0.172";
          localajoy.port = 80;
        }
      }
      else if ((str3 != null) && (str3.startsWith("uniwap"))) {
        if ((str1 != null) && (str1.length() > 0) && (Integer.valueOf(str2).intValue() < 0))
        {
          localajoy.address = str1;
          localajoy.port = Integer.valueOf(str2).intValue();
        }
        else
        {
          localajoy.address = "10.0.0.172";
          localajoy.port = 80;
        }
      }
      return localajoy;
    }
    finally {}
    return localajoy;
  }
  
  public static HttpEntity a(String paramString1, byte[] paramArrayOfByte, String paramString2, BasicHeader[] paramArrayOfBasicHeader)
    throws HttpResponseException, IOException
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 15000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    if (paramString2.equals("POST"))
    {
      paramString1 = new HttpPost(paramString1);
      paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte);
      ((HttpPost)paramString1).setEntity(paramArrayOfByte);
      paramArrayOfByte = paramString1;
    }
    int j;
    int i;
    while (paramArrayOfBasicHeader != null)
    {
      j = paramArrayOfBasicHeader.length;
      i = 0;
      while (i < j)
      {
        paramArrayOfByte.addHeader(paramArrayOfBasicHeader[i]);
        i += 1;
      }
      if (paramArrayOfByte != null) {
        paramArrayOfByte = new HttpGet(paramString1 + "?" + new String(paramArrayOfByte));
      } else {
        paramArrayOfByte = new HttpGet(paramString1);
      }
    }
    if (a == null)
    {
      paramString1 = new SchemeRegistry();
      paramString1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      paramString1.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      a = new ThreadSafeClientConnManager(localBasicHttpParams, paramString1);
    }
    paramString2 = new DefaultHttpClient(a, localBasicHttpParams);
    if (b() != null)
    {
      Proxy.getDefaultHost();
      Proxy.getDefaultPort();
      paramArrayOfBasicHeader = BaseApplication.getContext();
      if (paramArrayOfBasicHeader != null) {
        break label363;
      }
      paramString1 = Proxy.getDefaultHost();
      i = Proxy.getDefaultPort();
    }
    for (;;)
    {
      if ((paramString1 != null) && (paramString1.trim().length() != 0))
      {
        j = i;
        if (i > 0) {}
      }
      else
      {
        paramArrayOfBasicHeader = a();
        paramString1 = paramArrayOfBasicHeader.address;
        j = paramArrayOfBasicHeader.port;
      }
      paramString1 = new HttpHost(paramString1, j);
      paramString2.getParams().setParameter("http.route.default-proxy", paramString1);
      paramString1 = paramString2.execute(paramArrayOfByte);
      i = paramString1.getStatusLine().getStatusCode();
      if (i == 200) {
        break;
      }
      throw new HttpResponseException(i);
      label363:
      paramString1 = Proxy.getHost(paramArrayOfBasicHeader);
      j = Proxy.getPort(paramArrayOfBasicHeader);
      if ((paramString1 != null) && (paramString1.trim().length() != 0))
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        paramString1 = Proxy.getDefaultHost();
        i = Proxy.getDefaultPort();
      }
    }
    return paramString1.getEntity();
  }
  
  public static byte[] a(String paramString1, byte[] paramArrayOfByte, String paramString2, BasicHeader[] paramArrayOfBasicHeader)
    throws HttpResponseException, IOException
  {
    paramString1 = a(paramString1, paramArrayOfByte, paramString2, paramArrayOfBasicHeader);
    paramArrayOfByte = EntityUtils.toByteArray(paramString1);
    paramString1.consumeContent();
    return paramArrayOfByte;
  }
  
  public static InetSocketAddress b()
  {
    Object localObject2 = null;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str;
    int i;
    if (localBaseApplication == null)
    {
      str = Proxy.getDefaultHost();
      i = Proxy.getDefaultPort();
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (str.trim().length() > 0) {
          localObject1 = new InetSocketAddress(str, i);
        }
      }
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (!AppNetConnInfo.isMobileConn());
      str = Proxy.getHost(localBaseApplication);
      int j = Proxy.getPort(localBaseApplication);
      if ((str != null) && (str.trim().length() != 0))
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        str = Proxy.getDefaultHost();
        j = Proxy.getDefaultPort();
        if ((str != null) && (str.trim().length() != 0))
        {
          i = j;
          if (j > 0) {}
        }
        else
        {
          localObject1 = a();
          str = ((ajoy)localObject1).address;
          i = ((ajoy)localObject1).port;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajox
 * JD-Core Version:    0.7.0.1
 */