package com.tencent.ad.tangram.net;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;

@Keep
public final class AdHttp
{
  private static final String TAG = "AdHttp";
  
  private static byte[] read(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      arrayOfByte = new byte[1024];
      i = paramInputStream.read(arrayOfByte);
      if (i >= 0) {}
    }
    catch (Throwable paramInputStream)
    {
      try
      {
        for (;;)
        {
          byte[] arrayOfByte;
          int i;
          localByteArrayOutputStream.close();
          return localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
          continue;
          paramInputStream = paramInputStream;
          AdLog.e("AdHttp", "read", paramInputStream);
        }
      }
      catch (Throwable paramInputStream)
      {
        for (;;)
        {
          AdLog.e("AdHttp", "read", paramInputStream);
        }
      }
    }
  }
  
  /* Error */
  public static void send(Params paramParams)
  {
    // Byte code:
    //   0: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: ifnull +10 -> 15
    //   8: aload_0
    //   9: invokevirtual 62	com/tencent/ad/tangram/net/AdHttp$Params:canSend	()Z
    //   12: ifne +4 -> 16
    //   15: return
    //   16: aconst_null
    //   17: astore_3
    //   18: aconst_null
    //   19: astore 6
    //   21: aload_0
    //   22: invokestatic 66	com/tencent/ad/tangram/net/AdHttp$Params:access$000	(Lcom/tencent/ad/tangram/net/AdHttp$Params;)Ljava/net/URL;
    //   25: invokevirtual 72	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   28: checkcast 74	java/net/HttpURLConnection
    //   31: astore 4
    //   33: aload 4
    //   35: aload_0
    //   36: getfield 78	com/tencent/ad/tangram/net/AdHttp$Params:connectTimeoutMillis	I
    //   39: invokevirtual 82	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   42: aload 4
    //   44: aload_0
    //   45: getfield 85	com/tencent/ad/tangram/net/AdHttp$Params:readTimeoutMillis	I
    //   48: invokevirtual 88	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   51: aload 4
    //   53: iconst_1
    //   54: invokevirtual 92	java/net/HttpURLConnection:setDoInput	(Z)V
    //   57: aload_0
    //   58: getfield 95	com/tencent/ad/tangram/net/AdHttp$Params:method	Ljava/lang/String;
    //   61: ldc 97
    //   63: invokestatic 103	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   66: ifeq +195 -> 261
    //   69: aload 4
    //   71: iconst_0
    //   72: invokevirtual 106	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   75: aload 4
    //   77: aload_0
    //   78: getfield 95	com/tencent/ad/tangram/net/AdHttp$Params:method	Ljava/lang/String;
    //   81: invokevirtual 110	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   84: aload 4
    //   86: iconst_0
    //   87: invokevirtual 113	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   90: aload 4
    //   92: aload_0
    //   93: getfield 117	com/tencent/ad/tangram/net/AdHttp$Params:isInstanceFollowRedirects	Z
    //   96: invokevirtual 120	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   99: aload_0
    //   100: getfield 123	com/tencent/ad/tangram/net/AdHttp$Params:contentType	Ljava/lang/String;
    //   103: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifne +14 -> 120
    //   109: aload 4
    //   111: ldc 129
    //   113: aload_0
    //   114: getfield 123	com/tencent/ad/tangram/net/AdHttp$Params:contentType	Ljava/lang/String;
    //   117: invokevirtual 133	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: getfield 136	com/tencent/ad/tangram/net/AdHttp$Params:referer	Ljava/lang/String;
    //   124: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +14 -> 141
    //   130: aload 4
    //   132: ldc 138
    //   134: aload_0
    //   135: getfield 136	com/tencent/ad/tangram/net/AdHttp$Params:referer	Ljava/lang/String;
    //   138: invokevirtual 133	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 4
    //   143: invokevirtual 141	java/net/HttpURLConnection:getDoOutput	()Z
    //   146: ifeq +45 -> 191
    //   149: aload_0
    //   150: getfield 145	com/tencent/ad/tangram/net/AdHttp$Params:requestData	[B
    //   153: ifnull +38 -> 191
    //   156: new 147	java/io/DataOutputStream
    //   159: dup
    //   160: aload 4
    //   162: invokevirtual 151	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   165: invokespecial 154	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   168: astore_3
    //   169: aload_3
    //   170: aload_0
    //   171: getfield 145	com/tencent/ad/tangram/net/AdHttp$Params:requestData	[B
    //   174: iconst_0
    //   175: aload_0
    //   176: getfield 145	com/tencent/ad/tangram/net/AdHttp$Params:requestData	[B
    //   179: arraylength
    //   180: invokevirtual 155	java/io/DataOutputStream:write	([BII)V
    //   183: aload_3
    //   184: invokevirtual 158	java/io/DataOutputStream:flush	()V
    //   187: aload_3
    //   188: invokevirtual 159	java/io/DataOutputStream:close	()V
    //   191: aload 4
    //   193: invokevirtual 162	java/net/HttpURLConnection:connect	()V
    //   196: aload_0
    //   197: aload 4
    //   199: invokevirtual 166	java/net/HttpURLConnection:getResponseCode	()I
    //   202: putfield 169	com/tencent/ad/tangram/net/AdHttp$Params:responseCode	I
    //   205: aload_0
    //   206: getfield 169	com/tencent/ad/tangram/net/AdHttp$Params:responseCode	I
    //   209: sipush 200
    //   212: if_icmpne +29 -> 241
    //   215: aload 4
    //   217: invokevirtual 172	java/net/HttpURLConnection:getDoInput	()Z
    //   220: ifeq +21 -> 241
    //   223: aload 4
    //   225: invokevirtual 176	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   228: astore_3
    //   229: aload_0
    //   230: aload_3
    //   231: invokestatic 178	com/tencent/ad/tangram/net/AdHttp:read	(Ljava/io/InputStream;)[B
    //   234: putfield 181	com/tencent/ad/tangram/net/AdHttp$Params:responseData	[B
    //   237: aload_3
    //   238: invokevirtual 182	java/io/InputStream:close	()V
    //   241: aload 4
    //   243: ifnull +8 -> 251
    //   246: aload 4
    //   248: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   251: aload_0
    //   252: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   255: lload_1
    //   256: lsub
    //   257: putfield 189	com/tencent/ad/tangram/net/AdHttp$Params:durationMillis	J
    //   260: return
    //   261: aload_0
    //   262: getfield 95	com/tencent/ad/tangram/net/AdHttp$Params:method	Ljava/lang/String;
    //   265: ldc 191
    //   267: invokestatic 103	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   270: ifeq -195 -> 75
    //   273: aload 4
    //   275: iconst_1
    //   276: invokevirtual 106	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   279: goto -204 -> 75
    //   282: astore 5
    //   284: aload 4
    //   286: astore_3
    //   287: ldc 15
    //   289: ldc 192
    //   291: aload 5
    //   293: invokestatic 50	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   296: aload 4
    //   298: ifnull +8 -> 306
    //   301: aload 4
    //   303: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   306: aload_0
    //   307: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   310: lload_1
    //   311: lsub
    //   312: putfield 189	com/tencent/ad/tangram/net/AdHttp$Params:durationMillis	J
    //   315: return
    //   316: astore 5
    //   318: aload_3
    //   319: astore 4
    //   321: aload 5
    //   323: astore_3
    //   324: aload 4
    //   326: ifnull +8 -> 334
    //   329: aload 4
    //   331: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   334: aload_0
    //   335: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   338: lload_1
    //   339: lsub
    //   340: putfield 189	com/tencent/ad/tangram/net/AdHttp$Params:durationMillis	J
    //   343: aload_3
    //   344: athrow
    //   345: astore_3
    //   346: goto -22 -> 324
    //   349: astore 5
    //   351: aload 6
    //   353: astore 4
    //   355: goto -71 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramParams	Params
    //   3	336	1	l	long
    //   17	327	3	localObject1	Object
    //   345	1	3	localObject2	Object
    //   31	323	4	localObject3	Object
    //   282	10	5	localThrowable1	Throwable
    //   316	6	5	localObject4	Object
    //   349	1	5	localThrowable2	Throwable
    //   19	333	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   33	75	282	java/lang/Throwable
    //   75	120	282	java/lang/Throwable
    //   120	141	282	java/lang/Throwable
    //   141	191	282	java/lang/Throwable
    //   191	241	282	java/lang/Throwable
    //   261	279	282	java/lang/Throwable
    //   21	33	316	finally
    //   287	296	316	finally
    //   33	75	345	finally
    //   75	120	345	finally
    //   120	141	345	finally
    //   141	191	345	finally
    //   191	241	345	finally
    //   261	279	345	finally
    //   21	33	349	java/lang/Throwable
  }
  
  public static boolean sendAsync(Params paramParams, WeakReference<a> paramWeakReference)
  {
    if ((paramParams == null) || (!paramParams.canSend())) {
      return false;
    }
    AdThreadManager.INSTANCE.post(new AdHttp.1(paramParams, paramWeakReference), 4);
    return true;
  }
  
  @Keep
  public static class Params
  {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public int connectTimeoutMillis = 10000;
    public String contentType;
    public long durationMillis = -2147483648L;
    public boolean isInstanceFollowRedirects = false;
    public String method;
    public int readTimeoutMillis = 10000;
    public String referer;
    public byte[] requestData;
    public int responseCode = -2147483648;
    public byte[] responseData;
    private URL url;
    
    public boolean canSend()
    {
      boolean bool;
      if ((this.url != null) && (!TextUtils.isEmpty(this.method))) {
        bool = true;
      }
      while (TextUtils.equals(this.method, "POST")) {
        if ((bool) && (this.requestData != null))
        {
          return true;
          bool = false;
        }
        else
        {
          return false;
        }
      }
      return bool;
    }
    
    public String getUrl()
    {
      if (this.url != null) {
        return this.url.toString();
      }
      return null;
    }
    
    public boolean isSuccess()
    {
      return (canSend()) && (this.responseCode == 200);
    }
    
    public void setUrl(String paramString)
    {
      try
      {
        this.url = new URL(paramString);
        return;
      }
      catch (Throwable localThrowable)
      {
        AdLog.e("AdHttp", "setUrl " + paramString);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onResponse(AdHttp.Params paramParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdHttp
 * JD-Core Version:    0.7.0.1
 */