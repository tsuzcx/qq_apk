package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class HttpUtils
{
  public static final String DEFAULT_ENCODE_NAME = "utf-8";
  public static final String DEFAULT_POST_ADDR = "http://p.mb.qq.com/thirdapp";
  private static final int DEFAULT_TIME_OUT = 20000;
  public static byte[] POST_DATA_KEY = null;
  private static final String TAG = "HttpUtils";
  public static final String WUP_PROXY_DOMAIN = "http://wup.imtt.qq.com:8080";
  
  static
  {
    try
    {
      POST_DATA_KEY = "65dRa93L".getBytes("utf-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
  
  public static void doReport(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        ThirdAppInfoNew localThirdAppInfoNew = new ThirdAppInfoNew();
        localThirdAppInfoNew.sAppName = paramContext.getPackageName();
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        localThirdAppInfoNew.sTime = localSimpleDateFormat.format(Calendar.getInstance().getTime());
        localThirdAppInfoNew.sGuid = paramString1;
        localThirdAppInfoNew.sQua = paramString2;
        localThirdAppInfoNew.sLc = paramString3;
        if (Build.VERSION.SDK_INT > 23)
        {
          localThirdAppInfoNew.sMac = "";
          localThirdAppInfoNew.iPv = paramInt;
          if (paramBoolean)
          {
            paramInt = 1;
            localThirdAppInfoNew.iCoreType = paramInt;
            post(localThirdAppInfoNew);
          }
        }
        else
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext == null) {
            continue;
          }
          try
          {
            paramString1 = paramContext.getDeviceId();
            if ((paramString1 != null) && (!"".equals(paramString1))) {
              localThirdAppInfoNew.sImei = paramString1;
            }
            paramContext = paramContext.getSubscriberId();
            if ((paramContext == null) || ("".equals(paramContext))) {
              continue;
            }
            localThirdAppInfoNew.sImsi = paramContext;
          }
          catch (Exception paramContext)
          {
            paramContext.printStackTrace();
          }
          continue;
        }
        paramInt = 0;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
  }
  
  private static StringBuffer getPostData(ThirdAppInfoNew paramThirdAppInfoNew)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      localStringBuffer.append("sAppName").append("=").append(URLEncoder.encode(paramThirdAppInfoNew.sAppName, "utf-8")).append("|");
      localStringBuffer.append("sTime").append("=").append(URLEncoder.encode(paramThirdAppInfoNew.sTime, "utf-8")).append("|");
      localStringBuffer.append("sQua").append("=").append(URLEncoder.encode(paramThirdAppInfoNew.sQua, "utf-8")).append("|");
      localStringBuffer.append("sLc").append("=").append(URLEncoder.encode(paramThirdAppInfoNew.sLc, "utf-8")).append("|");
      localStringBuffer.append("sGuid").append("=").append(URLEncoder.encode(paramThirdAppInfoNew.sGuid, "utf-8")).append("|");
      localStringBuffer.append("sImei").append("=").append(URLEncoder.encode(paramThirdAppInfoNew.sImei, "utf-8")).append("|");
      localStringBuffer.append("sImsi").append("=").append(URLEncoder.encode(paramThirdAppInfoNew.sImsi, "utf-8")).append("|");
      localStringBuffer.append("sMac").append("=").append(URLEncoder.encode(paramThirdAppInfoNew.sMac, "utf-8")).append("|");
      localStringBuffer.append("iPv").append("=").append(URLEncoder.encode(String.valueOf(paramThirdAppInfoNew.iPv), "utf-8")).append("|");
      localStringBuffer.append("iCoreType").append("=").append(URLEncoder.encode(String.valueOf(paramThirdAppInfoNew.iCoreType), "utf-8"));
      return localStringBuffer;
    }
    catch (Exception paramThirdAppInfoNew) {}
    return null;
  }
  
  public static void post(final ThirdAppInfoNew paramThirdAppInfoNew)
  {
    new Thread("HttpUtils")
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: getstatic 33	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   3: ifnonnull +13 -> 16
        //   6: ldc 35
        //   8: ldc 37
        //   10: invokevirtual 43	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   13: putstatic 33	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   16: getstatic 33	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   19: ifnonnull +4 -> 23
        //   22: return
        //   23: new 45	java/net/URL
        //   26: dup
        //   27: ldc 47
        //   29: invokespecial 48	java/net/URL:<init>	(Ljava/lang/String;)V
        //   32: invokevirtual 52	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   35: checkcast 54	java/net/HttpURLConnection
        //   38: astore_3
        //   39: aload_3
        //   40: ldc 56
        //   42: invokevirtual 59	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   45: aload_3
        //   46: iconst_1
        //   47: invokevirtual 63	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   50: aload_3
        //   51: iconst_1
        //   52: invokevirtual 66	java/net/HttpURLConnection:setDoInput	(Z)V
        //   55: aload_3
        //   56: iconst_0
        //   57: invokevirtual 69	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   60: aload_3
        //   61: sipush 20000
        //   64: invokevirtual 73	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   67: getstatic 79	android/os/Build$VERSION:SDK_INT	I
        //   70: bipush 13
        //   72: if_icmple +11 -> 83
        //   75: aload_3
        //   76: ldc 81
        //   78: ldc 83
        //   80: invokevirtual 87	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   83: aconst_null
        //   84: astore_1
        //   85: aload_0
        //   86: getfield 15	com/tencent/smtt/sdk/stat/HttpUtils$1:val$appInfo	LMTT/ThirdAppInfoNew;
        //   89: invokestatic 91	com/tencent/smtt/sdk/stat/HttpUtils:access$000	(LMTT/ThirdAppInfoNew;)Ljava/lang/StringBuffer;
        //   92: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
        //   95: ldc 37
        //   97: invokevirtual 43	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   100: astore_2
        //   101: aload_2
        //   102: astore_1
        //   103: aload_1
        //   104: ifnull -82 -> 22
        //   107: getstatic 33	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   110: aload_1
        //   111: iconst_1
        //   112: invokestatic 103	com/tencent/smtt/sdk/stat/DesUtils:DesEncrypt	([B[BI)[B
        //   115: astore_1
        //   116: aload_3
        //   117: ldc 105
        //   119: ldc 107
        //   121: invokevirtual 87	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   124: aload_3
        //   125: ldc 109
        //   127: aload_1
        //   128: arraylength
        //   129: invokestatic 113	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   132: invokevirtual 87	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   135: aload_3
        //   136: invokevirtual 117	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   139: astore_2
        //   140: aload_2
        //   141: aload_1
        //   142: invokevirtual 123	java/io/OutputStream:write	([B)V
        //   145: aload_2
        //   146: invokevirtual 126	java/io/OutputStream:flush	()V
        //   149: aload_3
        //   150: invokevirtual 130	java/net/HttpURLConnection:getResponseCode	()I
        //   153: sipush 200
        //   156: if_icmpne +12 -> 168
        //   159: ldc 132
        //   161: ldc 134
        //   163: invokestatic 140	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   166: pop
        //   167: return
        //   168: ldc 132
        //   170: ldc 142
        //   172: invokestatic 140	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   175: pop
        //   176: return
        //   177: astore_2
        //   178: goto -75 -> 103
        //   181: astore_1
        //   182: goto -166 -> 16
        //   185: astore_1
        //   186: return
        //   187: astore_1
        //   188: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	189	0	this	1
        //   84	58	1	localObject1	Object
        //   181	1	1	localUnsupportedEncodingException	UnsupportedEncodingException
        //   185	1	1	localThrowable	Throwable
        //   187	1	1	localIOException	java.io.IOException
        //   100	46	2	localObject2	Object
        //   177	1	2	localException	Exception
        //   38	112	3	localHttpURLConnection	java.net.HttpURLConnection
        // Exception table:
        //   from	to	target	type
        //   85	101	177	java/lang/Exception
        //   6	16	181	java/io/UnsupportedEncodingException
        //   135	167	185	java/lang/Throwable
        //   168	176	185	java/lang/Throwable
        //   23	45	187	java/io/IOException
      }
    }.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.HttpUtils
 * JD-Core Version:    0.7.0.1
 */