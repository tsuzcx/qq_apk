import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.weiyun.utils.NetworkUtils;
import cooperation.weiyun.channel.HttpChannel.1;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

public class awpn
{
  private static HttpPost a(String paramString)
  {
    paramString = new HttpPost(paramString);
    paramString.addHeader("Accept", "*/*");
    paramString.addHeader("User-Agent", "QdiskAndroid1.1.0");
    paramString.addHeader("Accept-Language", "zh-CN");
    paramString.addHeader("Referer", "http://udisk.qq.com/android");
    paramString.addHeader("Charset", "UTF-8");
    paramString.addHeader("Pragma", "no-cache");
    paramString.addHeader("Content-type", "application/json");
    return paramString;
  }
  
  public static DefaultHttpClient a()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    localBasicHttpParams.setParameter("http.connection.timeout", Integer.valueOf(30000));
    localBasicHttpParams.setParameter("http.socket.timeout", Integer.valueOf(45000));
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    return new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
  }
  
  private static void a(HttpClient paramHttpClient)
  {
    if (paramHttpClient != null) {
      paramHttpClient.getConnectionManager().shutdown();
    }
  }
  
  public static void a(HttpClient paramHttpClient, int paramInt)
  {
    if (!NetworkUtils.isWifiAvailable(BaseApplicationImpl.getApplication()))
    {
      paramHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(paramInt * 5000 + 45000));
      paramHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(60000 + paramInt * 5000));
      return;
    }
    paramHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(paramInt * 5000 + 30000));
    paramHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(paramInt * 5000 + 45000));
  }
  
  /* Error */
  public static int b(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 142	awpn:a	()Lorg/apache/http/impl/client/DefaultHttpClient;
    //   3: astore_3
    //   4: aload_3
    //   5: iconst_1
    //   6: invokestatic 144	awpn:a	(Lorg/apache/http/client/HttpClient;I)V
    //   9: aload_0
    //   10: invokestatic 146	awpn:a	(Ljava/lang/String;)Lorg/apache/http/client/methods/HttpPost;
    //   13: astore_0
    //   14: new 148	org/apache/http/entity/StringEntity
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 154	org/json/JSONObject:toString	()Ljava/lang/String;
    //   22: invokespecial 155	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_1
    //   27: ldc 36
    //   29: invokevirtual 158	org/apache/http/entity/StringEntity:setContentEncoding	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: ldc 44
    //   35: invokevirtual 161	org/apache/http/entity/StringEntity:setContentType	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 165	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   43: aload_3
    //   44: aload_0
    //   45: invokeinterface 169 2 0
    //   50: invokeinterface 175 1 0
    //   55: invokeinterface 181 1 0
    //   60: istore_2
    //   61: aload_3
    //   62: invokestatic 183	awpn:a	(Lorg/apache/http/client/HttpClient;)V
    //   65: iload_2
    //   66: ireturn
    //   67: astore_0
    //   68: aload_3
    //   69: invokestatic 183	awpn:a	(Lorg/apache/http/client/HttpClient;)V
    //   72: iconst_m1
    //   73: ireturn
    //   74: astore_0
    //   75: aload_3
    //   76: invokestatic 183	awpn:a	(Lorg/apache/http/client/HttpClient;)V
    //   79: aload_0
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	paramString	String
    //   0	81	1	paramJSONObject	JSONObject
    //   60	6	2	i	int
    //   3	73	3	localDefaultHttpClient	DefaultHttpClient
    // Exception table:
    //   from	to	target	type
    //   14	61	67	java/lang/Exception
    //   14	61	74	finally
  }
  
  public static void s(String paramString, JSONObject paramJSONObject)
  {
    ThreadManager.post(new HttpChannel.1(paramString, paramJSONObject), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpn
 * JD-Core Version:    0.7.0.1
 */