package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.smtt.sdk.SecuritySwitch;
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
        SecuritySwitch.setContext(paramContext);
        ThirdAppInfoNew localThirdAppInfoNew = new ThirdAppInfoNew();
        localThirdAppInfoNew.sAppName = paramContext.getPackageName();
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        localThirdAppInfoNew.sTime = localSimpleDateFormat.format(Calendar.getInstance().getTime());
        localThirdAppInfoNew.sGuid = paramString1;
        localThirdAppInfoNew.sQua = paramString2;
        localThirdAppInfoNew.sLc = paramString3;
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null) {}
        try
        {
          paramString1 = paramContext.getDeviceId();
          if ((paramString1 != null) && (!"".equals(paramString1))) {
            localThirdAppInfoNew.sImei = paramString1;
          }
          paramContext = paramContext.getSubscriberId();
          if ((paramContext != null) && (!"".equals(paramContext))) {
            localThirdAppInfoNew.sImsi = paramContext;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          continue;
        }
        localThirdAppInfoNew.sMac = "";
        localThirdAppInfoNew.iPv = paramInt;
        if (paramBoolean)
        {
          paramInt = 1;
          localThirdAppInfoNew.iCoreType = paramInt;
          post(localThirdAppInfoNew);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      paramInt = 0;
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
      localStringBuffer.append("iCoreType").append("=").append(URLEncoder.encode(String.valueOf(paramThirdAppInfoNew.iCoreType), "utf-8")).append("|");
      localStringBuffer.append("SECURITY:");
      boolean bool = SecuritySwitch.isSecurityApplyed();
      int i = SecuritySwitch.getSecuritySdkVersion();
      int j = SecuritySwitch.getSecurityJsVersion();
      localStringBuffer.append("status").append("=").append(URLEncoder.encode("" + bool, "utf-8")).append(",");
      localStringBuffer.append("verSdk").append("=").append(URLEncoder.encode("" + i, "utf-8")).append(",");
      localStringBuffer.append("verJs").append("=").append(URLEncoder.encode("" + j, "utf-8"));
      localStringBuffer.append(";");
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
        //   38: astore 4
        //   40: aload 4
        //   42: ldc 56
        //   44: invokevirtual 59	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   47: aload 4
        //   49: iconst_1
        //   50: invokevirtual 63	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   53: aload 4
        //   55: iconst_1
        //   56: invokevirtual 66	java/net/HttpURLConnection:setDoInput	(Z)V
        //   59: aload 4
        //   61: iconst_0
        //   62: invokevirtual 69	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   65: aload 4
        //   67: sipush 20000
        //   70: invokevirtual 73	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   73: getstatic 79	android/os/Build$VERSION:SDK_INT	I
        //   76: bipush 13
        //   78: if_icmple +12 -> 90
        //   81: aload 4
        //   83: ldc 81
        //   85: ldc 83
        //   87: invokevirtual 87	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   90: aconst_null
        //   91: astore_2
        //   92: aload_0
        //   93: getfield 15	com/tencent/smtt/sdk/stat/HttpUtils$1:val$appInfo	LMTT/ThirdAppInfoNew;
        //   96: invokestatic 91	com/tencent/smtt/sdk/stat/HttpUtils:access$000	(LMTT/ThirdAppInfoNew;)Ljava/lang/StringBuffer;
        //   99: invokevirtual 97	java/lang/StringBuffer:toString	()Ljava/lang/String;
        //   102: ldc 37
        //   104: invokevirtual 43	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   107: astore_3
        //   108: aload_3
        //   109: astore_2
        //   110: aload_2
        //   111: ifnull -89 -> 22
        //   114: getstatic 33	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   117: aload_2
        //   118: iconst_1
        //   119: invokestatic 103	com/tencent/smtt/sdk/stat/DesUtils:DesEncrypt	([B[BI)[B
        //   122: astore_2
        //   123: aload 4
        //   125: ldc 105
        //   127: ldc 107
        //   129: invokevirtual 87	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   132: aload 4
        //   134: ldc 109
        //   136: aload_2
        //   137: arraylength
        //   138: invokestatic 113	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   141: invokevirtual 87	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   144: aload 4
        //   146: invokevirtual 117	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   149: astore_3
        //   150: aload_3
        //   151: aload_2
        //   152: invokevirtual 123	java/io/OutputStream:write	([B)V
        //   155: aload_3
        //   156: invokevirtual 126	java/io/OutputStream:flush	()V
        //   159: aload 4
        //   161: invokevirtual 130	java/net/HttpURLConnection:getResponseCode	()I
        //   164: istore_1
        //   165: iload_1
        //   166: sipush 200
        //   169: if_icmpne -147 -> 22
        //   172: return
        //   173: astore_2
        //   174: return
        //   175: astore_2
        //   176: return
        //   177: astore_2
        //   178: return
        //   179: astore_3
        //   180: goto -70 -> 110
        //   183: astore_2
        //   184: goto -168 -> 16
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	187	0	this	1
        //   164	6	1	i	int
        //   91	61	2	localObject1	Object
        //   173	1	2	localIOException	java.io.IOException
        //   175	1	2	localThrowable1	Throwable
        //   177	1	2	localThrowable2	Throwable
        //   183	1	2	localUnsupportedEncodingException	UnsupportedEncodingException
        //   107	49	3	localObject2	Object
        //   179	1	3	localException	Exception
        //   38	122	4	localHttpURLConnection	java.net.HttpURLConnection
        // Exception table:
        //   from	to	target	type
        //   23	47	173	java/io/IOException
        //   114	123	175	java/lang/Throwable
        //   144	165	177	java/lang/Throwable
        //   92	108	179	java/lang/Exception
        //   6	16	183	java/io/UnsupportedEncodingException
      }
    }.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.HttpUtils
 * JD-Core Version:    0.7.0.1
 */