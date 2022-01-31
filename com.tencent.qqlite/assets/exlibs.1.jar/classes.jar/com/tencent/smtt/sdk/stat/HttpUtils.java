package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.utils.SysCoreQua2Utils;
import com.tencent.smtt.utils.TbsCommonConfig;
import com.tencent.smtt.utils.TbsLog;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class HttpUtils
{
  public static final String DEFAULT_ENCODE_NAME = "utf-8";
  private static final int DEFAULT_TIME_OUT = 20000;
  private static final String LOGTAG = "HttpUtils";
  public static byte[] POST_DATA_KEY = null;
  private static final int PROTOCOL_VERSION = 3;
  private static final int TIDTYPE_MM = 0;
  private static final int TIDTYPE_QQ = 1;
  private static final String qqPackageName = "com.tencent.mobileqq";
  
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
    Object localObject4 = "";
    localObject3 = localObject4;
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
      localObject1 = localObject4;
      localObject3 = localObject4;
      if ("com.tencent.mobileqq".equals(localApplicationInfo.packageName))
      {
        localObject3 = localObject4;
        localObject4 = paramContext.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0).versionName;
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber()))
        {
          localObject3 = localObject4;
          localObject1 = (String)localObject4 + "." + QbSdk.getQQBuildNumber();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        label206:
        localException.printStackTrace();
        localObject2 = localObject3;
        continue;
        ((ThirdAppInfoNew)localObject3).sQua2 = SysCoreQua2Utils.getQUA2(paramContext);
      }
    }
    try
    {
      localObject3 = new ThirdAppInfoNew();
      ((ThirdAppInfoNew)localObject3).sAppName = paramContext.getApplicationInfo().packageName;
      TbsCommonConfig.getInstance(paramContext);
      localObject4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      ((SimpleDateFormat)localObject4).setTimeZone(TimeZone.getTimeZone("GMT+08"));
      ((ThirdAppInfoNew)localObject3).sTime = ((SimpleDateFormat)localObject4).format(Calendar.getInstance().getTime());
      ((ThirdAppInfoNew)localObject3).sGuid = paramString1;
      if (paramBoolean)
      {
        ((ThirdAppInfoNew)localObject3).sQua2 = paramString2;
        ((ThirdAppInfoNew)localObject3).sLc = paramString3;
        paramString1 = null;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    try
    {
      paramString2 = (TelephonyManager)paramContext.getSystemService("phone");
      paramString1 = paramString2;
    }
    catch (SecurityException paramString2)
    {
      paramString2.printStackTrace();
      break label206;
    }
    if (paramString1 != null) {}
    try
    {
      paramString2 = paramString1.getDeviceId();
      if ((paramString2 != null) && (!"".equals(paramString2))) {
        ((ThirdAppInfoNew)localObject3).sImei = paramString2;
      }
      paramString1 = paramString1.getSubscriberId();
      if ((paramString1 != null) && (!"".equals(paramString1))) {
        ((ThirdAppInfoNew)localObject3).sImsi = paramString1;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        continue;
        paramString1 = paramString1.getConnectionInfo();
        continue;
        paramString1 = paramString1.getMacAddress();
      }
    }
    paramString2 = "";
    try
    {
      paramString1 = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramString1 != null) {
        break label386;
      }
      paramString1 = null;
      if (paramString1 != null) {
        break label394;
      }
      paramString1 = "";
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Object localObject2;
        TbsLog.e("sdkreport", "doReport exception:" + paramString1.getMessage());
        paramString1.printStackTrace();
        paramString1 = paramString2;
        continue;
        paramInt = 0;
      }
    }
    ((ThirdAppInfoNew)localObject3).sMac = paramString1;
    ((ThirdAppInfoNew)localObject3).iPv = paramInt;
    if (paramBoolean)
    {
      paramInt = 1;
      ((ThirdAppInfoNew)localObject3).iCoreType = paramInt;
      ((ThirdAppInfoNew)localObject3).sAppVersionName = ((String)localObject1);
      ((ThirdAppInfoNew)localObject3).sAppSignature = getSHA1(paramContext);
      post((ThirdAppInfoNew)localObject3);
      return;
    }
  }
  
  /* Error */
  private static org.json.JSONObject getPostData(ThirdAppInfoNew paramThirdAppInfoNew)
  {
    // Byte code:
    //   0: new 256	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 257	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc_w 259
    //   12: aload_0
    //   13: getfield 120	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   16: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   19: pop
    //   20: aload_1
    //   21: ldc_w 265
    //   24: aload_0
    //   25: getfield 161	MTT/ThirdAppInfoNew:sTime	Ljava/lang/String;
    //   28: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   31: pop
    //   32: aload_1
    //   33: ldc_w 267
    //   36: aload_0
    //   37: getfield 167	MTT/ThirdAppInfoNew:sQua2	Ljava/lang/String;
    //   40: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_1
    //   45: ldc_w 269
    //   48: aload_0
    //   49: getfield 170	MTT/ThirdAppInfoNew:sLc	Ljava/lang/String;
    //   52: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload_1
    //   57: ldc_w 271
    //   60: aload_0
    //   61: getfield 164	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
    //   64: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload_1
    //   69: ldc_w 273
    //   72: aload_0
    //   73: getfield 184	MTT/ThirdAppInfoNew:sImei	Ljava/lang/String;
    //   76: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload_1
    //   81: ldc_w 275
    //   84: aload_0
    //   85: getfield 190	MTT/ThirdAppInfoNew:sImsi	Ljava/lang/String;
    //   88: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   91: pop
    //   92: aload_1
    //   93: ldc_w 277
    //   96: aload_0
    //   97: getfield 201	MTT/ThirdAppInfoNew:sMac	Ljava/lang/String;
    //   100: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   103: pop
    //   104: aload_1
    //   105: ldc_w 279
    //   108: aload_0
    //   109: getfield 205	MTT/ThirdAppInfoNew:iPv	J
    //   112: invokevirtual 282	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload_1
    //   117: ldc_w 284
    //   120: aload_0
    //   121: getfield 208	MTT/ThirdAppInfoNew:iCoreType	I
    //   124: invokevirtual 287	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   127: pop
    //   128: aload_1
    //   129: ldc_w 289
    //   132: aload_0
    //   133: getfield 211	MTT/ThirdAppInfoNew:sAppVersionName	Ljava/lang/String;
    //   136: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload_0
    //   141: getfield 218	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   144: ifnonnull +69 -> 213
    //   147: aload_1
    //   148: ldc_w 291
    //   151: ldc_w 293
    //   154: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload_1
    //   159: ldc_w 294
    //   162: iconst_3
    //   163: invokevirtual 287	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   166: pop
    //   167: invokestatic 297	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   170: ifnull +41 -> 211
    //   173: aload_0
    //   174: getfield 120	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   177: ldc 27
    //   179: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   182: ifeq +57 -> 239
    //   185: aload_1
    //   186: ldc_w 299
    //   189: invokestatic 304	com/tencent/smtt/utils/PostEncryption:getInstance	()Lcom/tencent/smtt/utils/PostEncryption;
    //   192: invokestatic 297	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   195: invokevirtual 308	com/tencent/smtt/utils/PostEncryption:RSAEncode	(Ljava/lang/String;)Ljava/lang/String;
    //   198: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   201: pop
    //   202: aload_1
    //   203: ldc_w 310
    //   206: iconst_1
    //   207: invokevirtual 287	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   210: pop
    //   211: aload_1
    //   212: areturn
    //   213: aload_1
    //   214: ldc_w 291
    //   217: aload_0
    //   218: getfield 218	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   221: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   224: pop
    //   225: goto -67 -> 158
    //   228: astore_0
    //   229: ldc 243
    //   231: ldc_w 312
    //   234: invokestatic 254	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aconst_null
    //   238: areturn
    //   239: aload_0
    //   240: getfield 120	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   243: ldc_w 314
    //   246: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq -38 -> 211
    //   252: aload_1
    //   253: ldc_w 299
    //   256: invokestatic 297	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   259: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   262: pop
    //   263: aload_1
    //   264: ldc_w 310
    //   267: iconst_0
    //   268: invokevirtual 287	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   271: pop
    //   272: goto -61 -> 211
    //   275: astore_0
    //   276: goto -65 -> 211
    //   279: astore_0
    //   280: goto -51 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramThirdAppInfoNew	ThirdAppInfoNew
    //   7	257	1	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   8	158	228	java/lang/Exception
    //   158	167	228	java/lang/Exception
    //   213	225	228	java/lang/Exception
    //   167	211	275	java/lang/Exception
    //   239	272	275	java/lang/Exception
    //   0	8	279	java/lang/Exception
  }
  
  private static String getSHA1(Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray();
        if (paramContext == null) {
          break label140;
        }
        localObject = MessageDigest.getInstance("SHA-1");
        ((MessageDigest)localObject).update(paramContext);
        paramContext = ((MessageDigest)localObject).digest();
        if (paramContext == null) {
          break label140;
        }
        localObject = new StringBuilder("");
        if (paramContext == null) {
          break label142;
        }
        if (paramContext.length > 0) {
          break label144;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject;
        String str;
        paramContext.printStackTrace();
      }
      if (i < paramContext.length)
      {
        str = Integer.toHexString(paramContext[i] & 0xFF).toUpperCase();
        if (i > 0) {
          ((StringBuilder)localObject).append(":");
        }
        if (str.length() < 2) {
          ((StringBuilder)localObject).append(0);
        }
        ((StringBuilder)localObject).append(str);
        i += 1;
      }
      else
      {
        paramContext = ((StringBuilder)localObject).toString();
        return paramContext;
        label140:
        return null;
        label142:
        return null;
        label144:
        i = 0;
      }
    }
  }
  
  public static void post(final ThirdAppInfoNew paramThirdAppInfoNew)
  {
    new Thread("HttpUtils")
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: getstatic 39	android/os/Build$VERSION:SDK_INT	I
        //   3: bipush 8
        //   5: if_icmpge +4 -> 9
        //   8: return
        //   9: getstatic 43	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   12: ifnonnull +13 -> 25
        //   15: ldc 45
        //   17: ldc 47
        //   19: invokevirtual 53	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   22: putstatic 43	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   25: getstatic 43	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   28: ifnonnull +26 -> 54
        //   31: ldc 55
        //   33: ldc 57
        //   35: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   38: return
        //   39: astore_1
        //   40: aconst_null
        //   41: putstatic 43	com/tencent/smtt/sdk/stat/HttpUtils:POST_DATA_KEY	[B
        //   44: ldc 55
        //   46: ldc 65
        //   48: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   51: goto -26 -> 25
        //   54: invokestatic 71	com/tencent/smtt/utils/TbsCommonConfig:getInstance	()Lcom/tencent/smtt/utils/TbsCommonConfig;
        //   57: invokevirtual 75	com/tencent/smtt/utils/TbsCommonConfig:getPvUploadPostUrl	()Ljava/lang/String;
        //   60: astore_1
        //   61: invokestatic 80	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
        //   64: invokevirtual 83	com/tencent/smtt/utils/Post3DESEncryption:getRSAKeyValue	()Ljava/lang/String;
        //   67: astore_2
        //   68: new 85	java/net/URL
        //   71: dup
        //   72: new 87	java/lang/StringBuilder
        //   75: dup
        //   76: invokespecial 89	java/lang/StringBuilder:<init>	()V
        //   79: aload_1
        //   80: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   83: aload_2
        //   84: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   87: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   90: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
        //   93: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   96: checkcast 103	java/net/HttpURLConnection
        //   99: astore_3
        //   100: aload_3
        //   101: ldc 105
        //   103: invokevirtual 108	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   106: aload_3
        //   107: iconst_1
        //   108: invokevirtual 112	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   111: aload_3
        //   112: iconst_1
        //   113: invokevirtual 115	java/net/HttpURLConnection:setDoInput	(Z)V
        //   116: aload_3
        //   117: iconst_0
        //   118: invokevirtual 118	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   121: aload_3
        //   122: sipush 20000
        //   125: invokevirtual 122	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   128: getstatic 39	android/os/Build$VERSION:SDK_INT	I
        //   131: bipush 13
        //   133: if_icmple +11 -> 144
        //   136: aload_3
        //   137: ldc 124
        //   139: ldc 126
        //   141: invokevirtual 129	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   144: aconst_null
        //   145: astore_1
        //   146: aload_0
        //   147: getfield 15	com/tencent/smtt/sdk/stat/HttpUtils$1:val$appInfo	LMTT/ThirdAppInfoNew;
        //   150: invokestatic 133	com/tencent/smtt/sdk/stat/HttpUtils:access$000	(LMTT/ThirdAppInfoNew;)Lorg/json/JSONObject;
        //   153: astore_2
        //   154: aload_2
        //   155: astore_1
        //   156: aload_1
        //   157: ifnonnull +97 -> 254
        //   160: ldc 55
        //   162: ldc 135
        //   164: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   167: return
        //   168: astore_1
        //   169: ldc 55
        //   171: new 87	java/lang/StringBuilder
        //   174: dup
        //   175: invokespecial 89	java/lang/StringBuilder:<init>	()V
        //   178: ldc 137
        //   180: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   183: aload_1
        //   184: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   187: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   190: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   193: return
        //   194: astore_1
        //   195: ldc 55
        //   197: new 87	java/lang/StringBuilder
        //   200: dup
        //   201: invokespecial 89	java/lang/StringBuilder:<init>	()V
        //   204: ldc 142
        //   206: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   209: aload_1
        //   210: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   213: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   216: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   219: return
        //   220: astore_1
        //   221: ldc 55
        //   223: new 87	java/lang/StringBuilder
        //   226: dup
        //   227: invokespecial 89	java/lang/StringBuilder:<init>	()V
        //   230: ldc 144
        //   232: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   235: aload_1
        //   236: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   239: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   242: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   245: return
        //   246: astore_2
        //   247: aload_2
        //   248: invokevirtual 147	java/lang/Exception:printStackTrace	()V
        //   251: goto -95 -> 156
        //   254: aload_1
        //   255: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
        //   258: ldc 47
        //   260: invokevirtual 53	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   263: astore_1
        //   264: invokestatic 80	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
        //   267: aload_1
        //   268: invokevirtual 154	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
        //   271: astore_1
        //   272: aload_3
        //   273: ldc 156
        //   275: ldc 158
        //   277: invokevirtual 129	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   280: aload_3
        //   281: ldc 160
        //   283: aload_1
        //   284: arraylength
        //   285: invokestatic 164	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   288: invokevirtual 129	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   291: aload_3
        //   292: invokevirtual 168	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   295: astore_2
        //   296: aload_2
        //   297: aload_1
        //   298: invokevirtual 174	java/io/OutputStream:write	([B)V
        //   301: aload_2
        //   302: invokevirtual 177	java/io/OutputStream:flush	()V
        //   305: aload_3
        //   306: invokevirtual 181	java/net/HttpURLConnection:getResponseCode	()I
        //   309: sipush 200
        //   312: if_icmpeq -304 -> 8
        //   315: ldc 55
        //   317: ldc 183
        //   319: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   322: return
        //   323: astore_1
        //   324: ldc 55
        //   326: new 87	java/lang/StringBuilder
        //   329: dup
        //   330: invokespecial 89	java/lang/StringBuilder:<init>	()V
        //   333: ldc 185
        //   335: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   338: aload_1
        //   339: invokevirtual 188	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   342: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   345: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   348: invokestatic 63	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   351: return
        //   352: astore_1
        //   353: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	354	0	this	1
        //   39	1	1	localUnsupportedEncodingException	UnsupportedEncodingException
        //   60	97	1	localObject1	Object
        //   168	16	1	localIOException	java.io.IOException
        //   194	16	1	localAssertionError	java.lang.AssertionError
        //   220	35	1	localNoClassDefFoundError	java.lang.NoClassDefFoundError
        //   263	35	1	arrayOfByte	byte[]
        //   323	16	1	localThrowable1	Throwable
        //   352	1	1	localThrowable2	Throwable
        //   67	88	2	localObject2	Object
        //   246	2	2	localException	Exception
        //   295	7	2	localOutputStream	java.io.OutputStream
        //   99	207	3	localHttpURLConnection	java.net.HttpURLConnection
        // Exception table:
        //   from	to	target	type
        //   15	25	39	java/io/UnsupportedEncodingException
        //   54	106	168	java/io/IOException
        //   54	106	194	java/lang/AssertionError
        //   54	106	220	java/lang/NoClassDefFoundError
        //   146	154	246	java/lang/Exception
        //   291	322	323	java/lang/Throwable
        //   254	272	352	java/lang/Throwable
      }
    }.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.HttpUtils
 * JD-Core Version:    0.7.0.1
 */