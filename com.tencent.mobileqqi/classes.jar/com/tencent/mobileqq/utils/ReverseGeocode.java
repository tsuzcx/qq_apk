package com.tencent.mobileqq.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import hea;
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
  
  private static hea a(Context paramContext)
  {
    hea localhea = new hea();
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
            localhea.jdField_a_of_type_JavaLangString = paramContext;
            localhea.jdField_a_of_type_Int = Integer.valueOf(str3).intValue();
          }
          else if ((str1 != null) && (str1.startsWith("ctwap")))
          {
            localhea.jdField_a_of_type_JavaLangString = "10.0.0.200";
            localhea.jdField_a_of_type_Int = 80;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return localhea;
        }
        if ((str1 != null) && (str1.startsWith("cmwap")))
        {
          localhea.jdField_a_of_type_JavaLangString = "10.0.0.172";
          localhea.jdField_a_of_type_Int = 80;
          break;
        }
        if ((str1 == null) || (!str1.startsWith("uniwap"))) {
          break;
        }
        localhea.jdField_a_of_type_JavaLangString = "10.0.0.172";
        localhea.jdField_a_of_type_Int = 80;
        break;
      }
      return localhea;
    }
    finally {}
    return localhea;
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
  public static String a(Context paramContext, double paramDouble1, double paramDouble2, int paramInt)
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
    //   35: new 194	java/util/ArrayList
    //   38: dup
    //   39: invokespecial 195	java/util/ArrayList:<init>	()V
    //   42: pop
    //   43: new 197	org/apache/http/params/BasicHttpParams
    //   46: dup
    //   47: invokespecial 198	org/apache/http/params/BasicHttpParams:<init>	()V
    //   50: astore 7
    //   52: aload 7
    //   54: ldc2_w 199
    //   57: invokestatic 206	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   60: aload 7
    //   62: new 208	org/apache/http/conn/params/ConnPerRouteBean
    //   65: dup
    //   66: bipush 10
    //   68: invokespecial 211	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   71: invokestatic 215	org/apache/http/conn/params/ConnManagerParams:setMaxConnectionsPerRoute	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V
    //   74: aload 7
    //   76: bipush 10
    //   78: invokestatic 219	org/apache/http/conn/params/ConnManagerParams:setMaxTotalConnections	(Lorg/apache/http/params/HttpParams;I)V
    //   81: aload 7
    //   83: sipush 10000
    //   86: invokestatic 224	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   89: aload 7
    //   91: sipush 20000
    //   94: invokestatic 227	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   97: aload 7
    //   99: iconst_1
    //   100: invokestatic 231	org/apache/http/params/HttpConnectionParams:setTcpNoDelay	(Lorg/apache/http/params/HttpParams;Z)V
    //   103: aload 7
    //   105: sipush 8192
    //   108: invokestatic 234	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   111: aload 7
    //   113: getstatic 240	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   116: invokestatic 246	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   119: aload 7
    //   121: ldc 248
    //   123: invokestatic 252	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   126: new 254	org/apache/http/impl/client/DefaultHttpClient
    //   129: dup
    //   130: aload 7
    //   132: invokespecial 257	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   135: astore 7
    //   137: aload_0
    //   138: aload 7
    //   140: invokestatic 260	com/tencent/mobileqq/utils/ReverseGeocode:a	(Landroid/content/Context;Lorg/apache/http/client/HttpClient;)V
    //   143: new 262	java/io/BufferedReader
    //   146: dup
    //   147: new 264	java/io/InputStreamReader
    //   150: dup
    //   151: aload 7
    //   153: new 266	org/apache/http/client/methods/HttpGet
    //   156: dup
    //   157: aload 6
    //   159: invokespecial 269	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   162: invokeinterface 275 2 0
    //   167: invokeinterface 281 1 0
    //   172: invokeinterface 287 1 0
    //   177: invokespecial 290	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   180: invokespecial 293	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   183: astore 7
    //   185: ldc 178
    //   187: astore_0
    //   188: aload 7
    //   190: invokevirtual 296	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   193: astore 8
    //   195: aload_0
    //   196: astore 6
    //   198: aload 8
    //   200: ifnull +43 -> 243
    //   203: new 137	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   210: aload_0
    //   211: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 8
    //   216: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: astore 6
    //   224: aload 6
    //   226: astore_0
    //   227: goto -39 -> 188
    //   230: astore 6
    //   232: ldc 178
    //   234: astore_0
    //   235: aload 6
    //   237: invokevirtual 297	java/io/IOException:printStackTrace	()V
    //   240: aload_0
    //   241: astore 6
    //   243: new 299	org/json/JSONObject
    //   246: dup
    //   247: aload 6
    //   249: invokespecial 300	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   252: ldc_w 302
    //   255: invokevirtual 306	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   258: astore_0
    //   259: aload_0
    //   260: iconst_0
    //   261: invokevirtual 312	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   264: astore 7
    //   266: ldc 178
    //   268: astore 6
    //   270: aload 6
    //   272: astore_0
    //   273: aload 7
    //   275: ifnull +12 -> 287
    //   278: aload 7
    //   280: ldc_w 314
    //   283: invokevirtual 317	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   286: astore_0
    //   287: aload_0
    //   288: ldc_w 319
    //   291: invokevirtual 322	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   294: istore 5
    //   296: aload_0
    //   297: astore 6
    //   299: iload 5
    //   301: iflt +15 -> 316
    //   304: aload_0
    //   305: iconst_0
    //   306: iload 5
    //   308: invokevirtual 326	java/lang/String:substring	(II)Ljava/lang/String;
    //   311: invokevirtual 135	java/lang/String:trim	()Ljava/lang/String;
    //   314: astore 6
    //   316: aload 6
    //   318: areturn
    //   319: astore_0
    //   320: ldc 178
    //   322: areturn
    //   323: astore_0
    //   324: aload_0
    //   325: invokevirtual 327	org/json/JSONException:printStackTrace	()V
    //   328: aload 6
    //   330: astore_0
    //   331: goto -44 -> 287
    //   334: astore 6
    //   336: goto -101 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramContext	Context
    //   0	339	1	paramDouble1	double
    //   0	339	3	paramDouble2	double
    //   0	339	5	paramInt	int
    //   33	192	6	localObject1	Object
    //   230	6	6	localIOException1	java.io.IOException
    //   241	88	6	localObject2	Object
    //   334	1	6	localIOException2	java.io.IOException
    //   50	229	7	localObject3	Object
    //   193	22	8	str	String
    // Exception table:
    //   from	to	target	type
    //   143	185	230	java/io/IOException
    //   243	259	319	org/json/JSONException
    //   278	287	323	org/json/JSONException
    //   188	195	334	java/io/IOException
    //   203	224	334	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ReverseGeocode
 * JD-Core Version:    0.7.0.1
 */