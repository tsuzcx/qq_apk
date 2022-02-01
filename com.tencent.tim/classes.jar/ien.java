import android.content.Context;
import android.os.Build.VERSION;
import android.util.Pair;
import com.rookery.asyncHttpClient.AsyncHttpRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class ien
{
  private static String ENCODING = "UTF-8";
  private static int agb = 6;
  private static int akN = 10000;
  private final HttpContext a;
  private final DefaultHttpClient b;
  private final Map<Context, List<WeakReference<Future<?>>>> cH;
  private final Map<String, String> cI;
  private ThreadPoolExecutor g;
  
  public ien()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout(localBasicHttpParams, akN);
    try
    {
      ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(agb));
      ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 6);
      try
      {
        label40:
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, akN);
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, akN);
        HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        label73:
        Object localObject1 = new SchemeRegistry();
        ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (Build.VERSION.SDK_INT < 11) {}
        for (;;)
        {
          try
          {
            Object localObject2 = KeyStore.getInstance(KeyStore.getDefaultType());
            ((KeyStore)localObject2).load(null, null);
            localObject2 = new ien.a((KeyStore)localObject2);
            ((SSLSocketFactory)localObject2).setHostnameVerifier(new ieo(this));
            ((SchemeRegistry)localObject1).register(new Scheme("https", (SocketFactory)localObject2, 443));
            localObject1 = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject1);
            this.a = new SyncBasicHttpContext(new BasicHttpContext());
            this.b = new DefaultHttpClient((ClientConnectionManager)localObject1, localBasicHttpParams);
            this.b.addRequestInterceptor(new iep(this));
            this.b.addResponseInterceptor(new ieq(this));
            this.b.setHttpRequestRetryHandler(new ieu(3));
            this.g = ((ThreadPoolExecutor)Executors.newCachedThreadPool());
            this.cH = new WeakHashMap();
            this.cI = new HashMap();
            return;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Translator", 2, "accept all ssl factory error" + localException);
            }
            ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            continue;
          }
          ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
      }
      catch (NoSuchMethodError localNoSuchMethodError1)
      {
        break label73;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError2)
    {
      break label40;
    }
  }
  
  public static String g(String paramString, List<Pair<String, String>> paramList)
  {
    Object localObject = paramString;
    if (paramList != null)
    {
      localObject = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Pair localPair = (Pair)paramList.next();
        ((List)localObject).add(new BasicNameValuePair((String)localPair.first, (String)localPair.second));
      }
      paramList = URLEncodedUtils.format((List)localObject, ENCODING);
      if (paramString.indexOf("?") == -1) {
        localObject = paramString + "?" + paramList;
      }
    }
    else
    {
      return localObject;
    }
    return paramString + "&" + paramList;
  }
  
  public void a(Context paramContext, String paramString, Header[] paramArrayOfHeader, List<Pair<String, String>> paramList, ier paramier)
  {
    paramString = new HttpGet(g(paramString, paramList));
    if (paramArrayOfHeader != null) {
      paramString.setHeaders(paramArrayOfHeader);
    }
    a(this.b, this.a, paramString, null, paramier, paramContext);
  }
  
  public void a(Context paramContext, String paramString1, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString2, ier paramier)
  {
    paramString1 = new HttpPost(paramString1);
    if ((paramHttpEntity != null) && (paramString1 != null)) {
      paramString1.setEntity(paramHttpEntity);
    }
    if ((paramArrayOfHeader != null) && (paramString1 != null)) {
      paramString1.setHeaders(paramArrayOfHeader);
    }
    a(this.b, this.a, paramString1, paramString2, paramier, paramContext);
  }
  
  protected void a(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, ier paramier, Context paramContext)
  {
    if (paramString != null) {
      paramHttpUriRequest.addHeader("Content-Type", paramString);
    }
    paramHttpUriRequest = this.g.submit(new AsyncHttpRequest(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramier));
    if (paramContext != null)
    {
      paramHttpContext = (List)this.cH.get(paramContext);
      paramDefaultHttpClient = paramHttpContext;
      if (paramHttpContext == null)
      {
        paramDefaultHttpClient = new LinkedList();
        this.cH.put(paramContext, paramDefaultHttpClient);
      }
      paramDefaultHttpClient.add(new WeakReference(paramHttpUriRequest));
    }
  }
  
  public void n(Context paramContext, boolean paramBoolean)
  {
    Object localObject = (List)this.cH.get(paramContext);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Future localFuture = (Future)((WeakReference)((Iterator)localObject).next()).get();
        if (localFuture != null)
        {
          localFuture.cancel(paramBoolean);
          if (QLog.isColorLevel()) {
            QLog.e("Translator", 2, "[cancel] cancel task" + localFuture.toString());
          }
        }
      }
    }
    this.cH.remove(paramContext);
  }
  
  static class b
    extends HttpEntityWrapper
  {
    public b(HttpEntity paramHttpEntity)
    {
      super();
    }
    
    public InputStream getContent()
      throws IOException
    {
      return new GZIPInputStream(this.wrappedEntity.getContent());
    }
    
    public long getContentLength()
    {
      return -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ien
 * JD-Core Version:    0.7.0.1
 */