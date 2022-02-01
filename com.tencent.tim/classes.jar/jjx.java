import android.os.AsyncTask;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class jjx
{
  public static HttpClient a(boolean paramBoolean)
  {
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled((HttpParams)localObject2, false);
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, 5000);
    HttpConnectionParams.setTcpNoDelay((HttpParams)localObject2, true);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, 10000);
    HttpConnectionParams.setSocketBufferSize((HttpParams)localObject2, 8192);
    HttpProtocolParams.setVersion((HttpParams)localObject2, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent((HttpParams)localObject2, "randchat");
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      label99:
      if (paramBoolean) {}
      for (localObject1 = new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);; localObject1 = new SingleClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1))
      {
        localObject2 = new DefaultHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
        ((DefaultHttpClient)localObject2).setRoutePlanner(new DefaultHttpRoutePlanner(((ClientConnectionManager)localObject1).getSchemeRegistry()));
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      break label99;
    }
  }
  
  public static String l(String paramString1, String paramString2, String paramString3)
    throws ClientProtocolException, IOException
  {
    Object localObject = null;
    try
    {
      HttpClient localHttpClient = a(false);
      localObject = localHttpClient;
      paramString1 = new HttpPost(paramString1);
      localObject = localHttpClient;
      paramString1.setEntity(new StringEntity(paramString2, "utf8"));
      localObject = localHttpClient;
      paramString1.setHeader("Content-Type", "application/text");
      if (paramString3 != null)
      {
        localObject = localHttpClient;
        paramString1.setHeader("Cookie", paramString3);
      }
      localObject = localHttpClient;
      paramString1 = EntityUtils.toString(localHttpClient.execute(paramString1).getEntity());
      return paramString1;
    }
    finally
    {
      if (localObject != null) {
        localObject.getConnectionManager().shutdown();
      }
    }
  }
  
  public static class a
    extends AsyncTask<Void, Void, String>
  {
    String SA;
    String bZ;
    String mCookie;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      this.bZ = paramString1;
      this.SA = paramString2;
      this.mCookie = paramString3;
    }
    
    /* Error */
    protected String doInBackground(Void... paramVarArgs)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	jjx$a:bZ	Ljava/lang/String;
      //   4: aload_0
      //   5: getfield 21	jjx$a:SA	Ljava/lang/String;
      //   8: aload_0
      //   9: getfield 23	jjx$a:mCookie	Ljava/lang/String;
      //   12: invokestatic 39	jjx:l	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   15: astore_1
      //   16: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   19: ifeq +28 -> 47
      //   22: ldc 47
      //   24: iconst_2
      //   25: new 49	java/lang/StringBuilder
      //   28: dup
      //   29: invokespecial 50	java/lang/StringBuilder:<init>	()V
      //   32: ldc 52
      //   34: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: aload_1
      //   38: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   41: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   44: invokestatic 64	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   47: aload_1
      //   48: areturn
      //   49: astore_2
      //   50: aconst_null
      //   51: astore_1
      //   52: aload_2
      //   53: invokevirtual 67	org/apache/http/client/ClientProtocolException:printStackTrace	()V
      //   56: aload_1
      //   57: areturn
      //   58: astore_2
      //   59: aconst_null
      //   60: astore_1
      //   61: aload_2
      //   62: invokevirtual 68	java/lang/Exception:printStackTrace	()V
      //   65: aload_1
      //   66: areturn
      //   67: astore_2
      //   68: goto -7 -> 61
      //   71: astore_2
      //   72: goto -20 -> 52
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	this	a
      //   0	75	1	paramVarArgs	Void[]
      //   49	4	2	localClientProtocolException1	ClientProtocolException
      //   58	4	2	localException1	Exception
      //   67	1	2	localException2	Exception
      //   71	1	2	localClientProtocolException2	ClientProtocolException
      // Exception table:
      //   from	to	target	type
      //   0	16	49	org/apache/http/client/ClientProtocolException
      //   0	16	58	java/lang/Exception
      //   16	47	67	java/lang/Exception
      //   16	47	71	org/apache/http/client/ClientProtocolException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jjx
 * JD-Core Version:    0.7.0.1
 */