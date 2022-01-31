package com.tencent.mobileqq.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import evr;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

public class ReverseGeocode
{
  private static final int jdField_a_of_type_Int = 10;
  private static final Uri jdField_a_of_type_AndroidNetUri;
  public static final String a = "ctnet";
  private static final int b = 20000;
  public static final String b = "ctwap";
  private static final int c = 10000;
  public static final String c = "cmnet";
  private static final int d = 8192;
  public static final String d = "cmwap";
  private static final int e = 10;
  public static final String e = "uninet";
  private static final int f = 20000;
  public static final String f = "uniwap";
  private static final int g = 10000;
  public static final String g = "3gwap";
  
  static
  {
    a = Uri.parse("content://telephony/carriers/preferapn");
  }
  
  private static evr a(Context paramContext)
  {
    evr localevr = new evr();
    try
    {
      label244:
      for (;;)
      {
        String str1;
        try
        {
          Cursor localCursor = paramContext.getContentResolver().query(a, null, null, null, null);
          localCursor.moveToFirst();
          paramContext = localCursor.getString(localCursor.getColumnIndex("proxy"));
          if (paramContext == null) {
            break label244;
          }
          paramContext = paramContext.toLowerCase();
          String str3 = localCursor.getString(localCursor.getColumnIndex("port"));
          String str2 = localCursor.getString(localCursor.getColumnIndex("apn"));
          str1 = str2;
          if (str2 != null) {
            str1 = str2.toLowerCase();
          }
          localCursor.close();
          if ((paramContext != null) && (paramContext.length() > 0) && (Integer.valueOf(str3).intValue() > 0))
          {
            localevr.jdField_a_of_type_JavaLangString = paramContext;
            localevr.jdField_a_of_type_Int = Integer.valueOf(str3).intValue();
          }
          else if ((str1 != null) && (str1.startsWith("ctwap")))
          {
            localevr.jdField_a_of_type_JavaLangString = "10.0.0.200";
            localevr.jdField_a_of_type_Int = 80;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return localevr;
        }
        if ((str1 != null) && (str1.startsWith("cmwap")))
        {
          localevr.jdField_a_of_type_JavaLangString = "10.0.0.172";
          localevr.jdField_a_of_type_Int = 80;
          break;
        }
        if ((str1 == null) || (!str1.startsWith("uniwap"))) {
          break;
        }
        localevr.jdField_a_of_type_JavaLangString = "10.0.0.172";
        localevr.jdField_a_of_type_Int = 80;
        break;
      }
      return localevr;
    }
    finally {}
    return localevr;
  }
  
  private static String a(Context paramContext)
  {
    String str = null;
    int i;
    if (paramContext == null)
    {
      str = Proxy.getDefaultHost();
      i = Proxy.getDefaultPort();
    }
    for (;;)
    {
      if ((str != null) && (str.trim().length() > 0))
      {
        return str + ":" + i;
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo != null)
        {
          if (NetworkUtil.a(localNetworkInfo))
          {
            str = Proxy.getHost(paramContext);
            int j = Proxy.getPort(paramContext);
            if ((str != null) && (str.trim().length() != 0))
            {
              i = j;
              if (j > 0) {
                continue;
              }
            }
            str = Proxy.getDefaultHost();
            j = Proxy.getDefaultPort();
            if ((str != null) && (str.trim().length() != 0))
            {
              i = j;
              if (j > 0) {
                continue;
              }
            }
            paramContext = a(paramContext);
            str = paramContext.jdField_a_of_type_JavaLangString;
            i = paramContext.jdField_a_of_type_Int;
            continue;
          }
          return null;
        }
      }
      else
      {
        return "";
      }
      i = 0;
    }
  }
  
  /* Error */
  public static String a(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, HttpClient paramHttpClient)
  {
    // Byte code:
    //   0: new 137	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   7: ldc 185
    //   9: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: dload_1
    //   13: invokevirtual 188	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   16: ldc 190
    //   18: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: dload_3
    //   22: invokevirtual 188	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   25: ldc 192
    //   27: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 6
    //   35: new 194	org/apache/http/params/BasicHttpParams
    //   38: dup
    //   39: invokespecial 195	org/apache/http/params/BasicHttpParams:<init>	()V
    //   42: astore 7
    //   44: aload 7
    //   46: ldc2_w 196
    //   49: invokestatic 203	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   52: aload 7
    //   54: new 205	org/apache/http/conn/params/ConnPerRouteBean
    //   57: dup
    //   58: bipush 10
    //   60: invokespecial 208	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   63: invokestatic 212	org/apache/http/conn/params/ConnManagerParams:setMaxConnectionsPerRoute	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V
    //   66: aload 7
    //   68: bipush 10
    //   70: invokestatic 216	org/apache/http/conn/params/ConnManagerParams:setMaxTotalConnections	(Lorg/apache/http/params/HttpParams;I)V
    //   73: aload 7
    //   75: sipush 10000
    //   78: invokestatic 221	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   81: aload 7
    //   83: sipush 20000
    //   86: invokestatic 224	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   89: aload 7
    //   91: iconst_1
    //   92: invokestatic 228	org/apache/http/params/HttpConnectionParams:setTcpNoDelay	(Lorg/apache/http/params/HttpParams;Z)V
    //   95: aload 7
    //   97: sipush 8192
    //   100: invokestatic 231	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   103: aload 7
    //   105: getstatic 237	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   108: invokestatic 243	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   111: aload 7
    //   113: ldc 245
    //   115: invokestatic 249	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   118: new 251	org/apache/http/impl/client/DefaultHttpClient
    //   121: dup
    //   122: aload 7
    //   124: invokespecial 254	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   127: astore 7
    //   129: aload_0
    //   130: aload 7
    //   132: invokestatic 257	com/tencent/mobileqq/utils/ReverseGeocode:a	(Landroid/content/Context;Lorg/apache/http/client/HttpClient;)V
    //   135: new 259	java/io/BufferedReader
    //   138: dup
    //   139: new 261	java/io/InputStreamReader
    //   142: dup
    //   143: aload 7
    //   145: new 263	org/apache/http/client/methods/HttpGet
    //   148: dup
    //   149: aload 6
    //   151: invokespecial 266	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   154: invokeinterface 272 2 0
    //   159: invokeinterface 278 1 0
    //   164: invokeinterface 284 1 0
    //   169: invokespecial 287	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   172: invokespecial 290	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   175: astore 7
    //   177: ldc 178
    //   179: astore_0
    //   180: aload 7
    //   182: invokevirtual 293	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   185: astore 8
    //   187: aload_0
    //   188: astore 6
    //   190: aload 8
    //   192: ifnull +43 -> 235
    //   195: new 137	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   202: aload_0
    //   203: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 8
    //   208: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore 6
    //   216: aload 6
    //   218: astore_0
    //   219: goto -39 -> 180
    //   222: astore 6
    //   224: ldc 178
    //   226: astore_0
    //   227: aload 6
    //   229: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   232: aload_0
    //   233: astore 6
    //   235: new 296	org/json/JSONObject
    //   238: dup
    //   239: aload 6
    //   241: invokespecial 297	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   244: ldc_w 299
    //   247: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   250: astore_0
    //   251: aload_0
    //   252: iconst_0
    //   253: invokevirtual 309	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   256: astore 7
    //   258: ldc 178
    //   260: astore 6
    //   262: aload 6
    //   264: astore_0
    //   265: aload 7
    //   267: ifnull +12 -> 279
    //   270: aload 7
    //   272: ldc_w 311
    //   275: invokevirtual 314	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore_0
    //   279: aload_0
    //   280: ldc_w 316
    //   283: invokevirtual 319	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   286: istore 5
    //   288: aload_0
    //   289: astore 6
    //   291: iload 5
    //   293: iflt +15 -> 308
    //   296: aload_0
    //   297: iconst_0
    //   298: iload 5
    //   300: invokevirtual 323	java/lang/String:substring	(II)Ljava/lang/String;
    //   303: invokevirtual 135	java/lang/String:trim	()Ljava/lang/String;
    //   306: astore 6
    //   308: aload 6
    //   310: areturn
    //   311: astore_0
    //   312: ldc 178
    //   314: areturn
    //   315: astore_0
    //   316: aload_0
    //   317: invokevirtual 324	org/json/JSONException:printStackTrace	()V
    //   320: aload 6
    //   322: astore_0
    //   323: goto -44 -> 279
    //   326: astore 6
    //   328: goto -101 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramContext	Context
    //   0	331	1	paramDouble1	double
    //   0	331	3	paramDouble2	double
    //   0	331	5	paramInt	int
    //   0	331	6	paramHttpClient	HttpClient
    //   42	229	7	localObject	Object
    //   185	22	8	str	String
    // Exception table:
    //   from	to	target	type
    //   135	177	222	java/io/IOException
    //   235	251	311	org/json/JSONException
    //   270	279	315	org/json/JSONException
    //   180	187	326	java/io/IOException
    //   195	216	326	java/io/IOException
  }
  
  public static void a(Context paramContext, HttpClient paramHttpClient)
  {
    paramHttpClient.getParams().removeParameter("http.route.default-proxy");
    paramContext = a(paramContext);
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      paramContext = paramContext.split(":");
      if ((paramContext != null) && (paramContext.length == 2))
      {
        paramContext = new HttpHost(paramContext[0], Integer.valueOf(paramContext[1]).intValue());
        paramHttpClient.getParams().setParameter("http.route.default-proxy", paramContext);
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject, HashMap paramHashMap)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      try
      {
        String str2 = paramJSONObject.getString(str1);
        if (!str2.startsWith("{")) {
          break label66;
        }
        a(new JSONObject(str2), paramHashMap);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      continue;
      label66:
      paramHashMap.put(localJSONException, paramJSONObject.getString(localJSONException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ReverseGeocode
 * JD-Core Version:    0.7.0.1
 */