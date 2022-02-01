import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.http.base.SNIVerifier;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jqc
{
  private static final SNIVerifier a = new SNIVerifier();
  private static boolean abf;
  
  /* Error */
  public static final String J(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +10 -> 20
    //   13: aload_1
    //   14: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +15 -> 32
    //   20: ldc 34
    //   22: iconst_1
    //   23: ldc 36
    //   25: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aconst_null
    //   29: astore_3
    //   30: aload_3
    //   31: areturn
    //   32: new 44	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   39: astore_3
    //   40: new 47	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 6
    //   50: aload 6
    //   52: ifnull +558 -> 610
    //   55: aload 6
    //   57: invokevirtual 54	java/io/File:exists	()Z
    //   60: ifeq +550 -> 610
    //   63: aload_3
    //   64: ldc 56
    //   66: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 62
    //   75: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc 64
    //   80: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 6
    //   85: invokevirtual 68	java/io/File:getName	()Ljava/lang/String;
    //   88: ldc 70
    //   90: invokestatic 75	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 77
    //   98: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 79
    //   103: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_3
    //   108: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore 7
    //   113: aload 4
    //   115: astore_3
    //   116: new 84	anzp
    //   119: dup
    //   120: invokespecial 85	anzp:<init>	()V
    //   123: astore 8
    //   125: aload 4
    //   127: astore_3
    //   128: ldc 87
    //   130: invokestatic 93	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   133: astore_0
    //   134: aload 4
    //   136: astore_3
    //   137: aload_0
    //   138: aconst_null
    //   139: iconst_1
    //   140: anewarray 95	javax/net/ssl/TrustManager
    //   143: dup
    //   144: iconst_0
    //   145: aload 8
    //   147: aastore
    //   148: aconst_null
    //   149: invokevirtual 99	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   152: aload 4
    //   154: astore_3
    //   155: new 101	anzr
    //   158: dup
    //   159: aload_0
    //   160: invokevirtual 105	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   163: invokespecial 108	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   166: astore 8
    //   168: aload 4
    //   170: astore_3
    //   171: aload 8
    //   173: invokestatic 113	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   176: aload 4
    //   178: astore_3
    //   179: new 115	java/net/URL
    //   182: dup
    //   183: aload 7
    //   185: invokespecial 116	java/net/URL:<init>	(Ljava/lang/String;)V
    //   188: invokevirtual 120	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   191: checkcast 110	javax/net/ssl/HttpsURLConnection
    //   194: astore_0
    //   195: aload_0
    //   196: aload 8
    //   198: invokevirtual 123	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   201: aload_0
    //   202: sipush 5000
    //   205: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   208: aload_0
    //   209: sipush 30000
    //   212: invokevirtual 130	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   215: aload_0
    //   216: iconst_1
    //   217: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   220: aload_0
    //   221: iconst_1
    //   222: invokevirtual 137	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   225: aload_0
    //   226: iconst_0
    //   227: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   230: aload_0
    //   231: ldc 142
    //   233: invokevirtual 145	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   236: aload_0
    //   237: ldc 147
    //   239: ldc 149
    //   241: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload_0
    //   245: ldc 155
    //   247: new 44	java/lang/StringBuilder
    //   250: dup
    //   251: ldc 157
    //   253: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   256: ldc 160
    //   258: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: getstatic 166	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   264: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 160
    //   269: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: getstatic 171	android/os/Build:DEVICE	Ljava/lang/String;
    //   275: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 160
    //   280: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: getstatic 174	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   286: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc 160
    //   291: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 176
    //   296: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc 160
    //   301: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc 178
    //   306: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokestatic 183	com/tencent/common/config/AppSetting:getVersion	()Ljava/lang/String;
    //   312: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload_0
    //   322: ldc 185
    //   324: ldc 187
    //   326: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload_0
    //   330: ldc 189
    //   332: new 44	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   339: ldc 191
    //   341: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc 193
    //   346: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: new 195	java/util/HashMap
    //   358: dup
    //   359: invokespecial 196	java/util/HashMap:<init>	()V
    //   362: astore 8
    //   364: aload 8
    //   366: ldc 147
    //   368: ldc 198
    //   370: invokeinterface 204 3 0
    //   375: pop
    //   376: aload 8
    //   378: ldc 206
    //   380: aload 7
    //   382: invokeinterface 204 3 0
    //   387: pop
    //   388: invokestatic 212	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   391: invokevirtual 216	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   394: iconst_2
    //   395: invokevirtual 222	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   398: checkcast 224	mqq/manager/TicketManager
    //   401: astore_3
    //   402: aload_3
    //   403: aload_1
    //   404: invokeinterface 228 2 0
    //   409: astore 9
    //   411: aload 7
    //   413: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   416: ifne +725 -> 1141
    //   419: aload_3
    //   420: aload_1
    //   421: ldc 230
    //   423: invokeinterface 233 3 0
    //   428: astore_3
    //   429: aload_3
    //   430: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   433: ifeq +188 -> 621
    //   436: ldc 34
    //   438: iconst_1
    //   439: ldc 235
    //   441: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: invokestatic 240	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   447: astore_1
    //   448: aload_1
    //   449: ifnull +19 -> 468
    //   452: aload 8
    //   454: ldc 242
    //   456: aload_1
    //   457: aload 7
    //   459: invokevirtual 245	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   462: invokeinterface 204 3 0
    //   467: pop
    //   468: aload 8
    //   470: invokeinterface 249 1 0
    //   475: invokeinterface 255 1 0
    //   480: astore_3
    //   481: aload_3
    //   482: invokeinterface 260 1 0
    //   487: ifeq +203 -> 690
    //   490: aload_3
    //   491: invokeinterface 264 1 0
    //   496: checkcast 266	java/util/Map$Entry
    //   499: astore_1
    //   500: aload_0
    //   501: aload_1
    //   502: invokeinterface 269 1 0
    //   507: checkcast 271	java/lang/String
    //   510: aload_1
    //   511: invokeinterface 274 1 0
    //   516: checkcast 271	java/lang/String
    //   519: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   522: goto -41 -> 481
    //   525: astore 4
    //   527: aconst_null
    //   528: astore_3
    //   529: aload_0
    //   530: astore_1
    //   531: aload_3
    //   532: astore_0
    //   533: aload_1
    //   534: astore_3
    //   535: ldc_w 276
    //   538: iconst_1
    //   539: new 44	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 278
    //   549: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload 4
    //   554: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   557: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: aload_0
    //   567: astore_3
    //   568: aload_1
    //   569: ifnull -539 -> 30
    //   572: aload_1
    //   573: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   576: aload_0
    //   577: areturn
    //   578: astore_0
    //   579: ldc 34
    //   581: iconst_1
    //   582: new 44	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 287
    //   592: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload_0
    //   596: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   599: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: aconst_null
    //   609: areturn
    //   610: ldc 34
    //   612: iconst_1
    //   613: ldc_w 289
    //   616: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: aconst_null
    //   620: areturn
    //   621: aload 8
    //   623: ldc 242
    //   625: new 44	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 291
    //   635: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload_3
    //   639: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: ldc_w 293
    //   645: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload_1
    //   649: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: ldc_w 295
    //   655: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload 9
    //   660: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokeinterface 204 3 0
    //   671: pop
    //   672: goto -204 -> 468
    //   675: astore_1
    //   676: aload_0
    //   677: astore_3
    //   678: aload_1
    //   679: astore_0
    //   680: aload_3
    //   681: ifnull +7 -> 688
    //   684: aload_3
    //   685: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   688: aload_0
    //   689: athrow
    //   690: new 297	java/io/DataOutputStream
    //   693: dup
    //   694: aload_0
    //   695: invokevirtual 301	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   698: invokespecial 304	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   701: astore_3
    //   702: new 306	java/lang/StringBuffer
    //   705: dup
    //   706: invokespecial 307	java/lang/StringBuffer:<init>	()V
    //   709: astore_1
    //   710: aload_1
    //   711: ldc_w 309
    //   714: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   717: ldc_w 314
    //   720: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   723: ldc 193
    //   725: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   728: ldc_w 309
    //   731: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   734: pop
    //   735: aload_1
    //   736: ldc_w 316
    //   739: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   742: ldc_w 318
    //   745: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   748: ldc_w 320
    //   751: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   754: aload 6
    //   756: invokevirtual 68	java/io/File:getName	()Ljava/lang/String;
    //   759: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   762: ldc_w 322
    //   765: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   768: pop
    //   769: aload_1
    //   770: new 44	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   777: ldc_w 324
    //   780: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: ldc_w 326
    //   786: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: ldc_w 328
    //   792: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   801: pop
    //   802: aload_3
    //   803: aload_1
    //   804: invokevirtual 329	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   807: invokevirtual 333	java/lang/String:getBytes	()[B
    //   810: invokevirtual 339	java/io/OutputStream:write	([B)V
    //   813: new 341	java/io/BufferedInputStream
    //   816: dup
    //   817: new 341	java/io/BufferedInputStream
    //   820: dup
    //   821: new 343	java/io/FileInputStream
    //   824: dup
    //   825: aload 6
    //   827: invokespecial 346	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   830: invokespecial 349	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   833: invokespecial 349	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   836: astore_1
    //   837: sipush 3072
    //   840: newarray byte
    //   842: astore 7
    //   844: aload_1
    //   845: aload 7
    //   847: invokevirtual 353	java/io/BufferedInputStream:read	([B)I
    //   850: istore_2
    //   851: iload_2
    //   852: iconst_m1
    //   853: if_icmpeq +93 -> 946
    //   856: aload_3
    //   857: aload 7
    //   859: iconst_0
    //   860: iload_2
    //   861: invokevirtual 356	java/io/OutputStream:write	([BII)V
    //   864: goto -20 -> 844
    //   867: astore 7
    //   869: ldc 34
    //   871: iconst_1
    //   872: new 44	java/lang/StringBuilder
    //   875: dup
    //   876: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   879: ldc_w 358
    //   882: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: aload 6
    //   887: invokevirtual 362	java/io/File:length	()J
    //   890: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   893: ldc_w 367
    //   896: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: aload 6
    //   901: invokevirtual 370	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   904: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   913: aload_3
    //   914: invokevirtual 373	java/io/OutputStream:flush	()V
    //   917: aload_3
    //   918: invokevirtual 376	java/io/OutputStream:close	()V
    //   921: aload_0
    //   922: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   925: aload 4
    //   927: astore_3
    //   928: aload_1
    //   929: invokevirtual 377	java/io/BufferedInputStream:close	()V
    //   932: iconst_0
    //   933: ifeq +11 -> 944
    //   936: new 379	java/lang/NullPointerException
    //   939: dup
    //   940: invokespecial 380	java/lang/NullPointerException:<init>	()V
    //   943: athrow
    //   944: aconst_null
    //   945: areturn
    //   946: aload_1
    //   947: invokevirtual 377	java/io/BufferedInputStream:close	()V
    //   950: aload_3
    //   951: new 44	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   958: ldc_w 382
    //   961: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: ldc 193
    //   966: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: ldc_w 384
    //   972: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   978: invokevirtual 333	java/lang/String:getBytes	()[B
    //   981: invokevirtual 339	java/io/OutputStream:write	([B)V
    //   984: aload_3
    //   985: invokevirtual 373	java/io/OutputStream:flush	()V
    //   988: aload_3
    //   989: invokevirtual 376	java/io/OutputStream:close	()V
    //   992: new 306	java/lang/StringBuffer
    //   995: dup
    //   996: invokespecial 307	java/lang/StringBuffer:<init>	()V
    //   999: astore 4
    //   1001: aload_0
    //   1002: invokevirtual 388	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1005: istore_2
    //   1006: iload_2
    //   1007: sipush 200
    //   1010: if_icmpeq +35 -> 1045
    //   1013: ldc 34
    //   1015: iconst_1
    //   1016: new 44	java/lang/StringBuilder
    //   1019: dup
    //   1020: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   1023: ldc_w 390
    //   1026: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: iload_2
    //   1030: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1033: ldc_w 395
    //   1036: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1042: invokestatic 398	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1045: new 400	java/io/BufferedReader
    //   1048: dup
    //   1049: new 402	java/io/InputStreamReader
    //   1052: dup
    //   1053: aload_0
    //   1054: invokevirtual 406	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1057: invokespecial 407	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1060: invokespecial 410	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1063: astore_1
    //   1064: aload_1
    //   1065: invokevirtual 413	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1068: astore_3
    //   1069: aload_3
    //   1070: ifnull +26 -> 1096
    //   1073: aload 4
    //   1075: aload_3
    //   1076: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1079: ldc_w 415
    //   1082: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1085: pop
    //   1086: goto -22 -> 1064
    //   1089: astore_3
    //   1090: aload_1
    //   1091: invokevirtual 377	java/io/BufferedInputStream:close	()V
    //   1094: aload_3
    //   1095: athrow
    //   1096: aload 4
    //   1098: invokevirtual 329	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1101: astore_3
    //   1102: aload_1
    //   1103: invokevirtual 416	java/io/BufferedReader:close	()V
    //   1106: aload_0
    //   1107: ifnull +32 -> 1139
    //   1110: aload_0
    //   1111: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1114: aload_3
    //   1115: areturn
    //   1116: astore_0
    //   1117: goto -437 -> 680
    //   1120: astore 4
    //   1122: aconst_null
    //   1123: astore_0
    //   1124: aload 5
    //   1126: astore_1
    //   1127: goto -594 -> 533
    //   1130: astore 4
    //   1132: aload_0
    //   1133: astore_1
    //   1134: aload_3
    //   1135: astore_0
    //   1136: goto -603 -> 533
    //   1139: aload_3
    //   1140: areturn
    //   1141: aconst_null
    //   1142: astore_3
    //   1143: goto -714 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1146	0	paramString1	String
    //   0	1146	1	paramString2	String
    //   850	180	2	i	int
    //   29	1047	3	localObject1	Object
    //   1089	6	3	localObject2	Object
    //   1101	42	3	str1	String
    //   1	176	4	localObject3	Object
    //   525	401	4	localException1	Exception
    //   999	98	4	localStringBuffer	java.lang.StringBuffer
    //   1120	1	4	localException2	Exception
    //   1130	1	4	localException3	Exception
    //   4	1121	5	localObject4	Object
    //   48	852	6	localFile	java.io.File
    //   111	747	7	localObject5	Object
    //   867	1	7	localOutOfMemoryError	OutOfMemoryError
    //   123	499	8	localObject6	Object
    //   409	250	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   195	429	525	java/lang/Exception
    //   429	448	525	java/lang/Exception
    //   452	468	525	java/lang/Exception
    //   468	481	525	java/lang/Exception
    //   481	522	525	java/lang/Exception
    //   621	672	525	java/lang/Exception
    //   690	844	525	java/lang/Exception
    //   946	1006	525	java/lang/Exception
    //   1013	1045	525	java/lang/Exception
    //   1045	1064	525	java/lang/Exception
    //   1064	1069	525	java/lang/Exception
    //   1073	1086	525	java/lang/Exception
    //   1090	1096	525	java/lang/Exception
    //   1096	1102	525	java/lang/Exception
    //   63	107	578	java/lang/Exception
    //   195	429	675	finally
    //   429	448	675	finally
    //   452	468	675	finally
    //   468	481	675	finally
    //   481	522	675	finally
    //   621	672	675	finally
    //   690	844	675	finally
    //   946	1006	675	finally
    //   1013	1045	675	finally
    //   1045	1064	675	finally
    //   1064	1069	675	finally
    //   1073	1086	675	finally
    //   1090	1096	675	finally
    //   1096	1102	675	finally
    //   1102	1106	675	finally
    //   844	851	867	java/lang/OutOfMemoryError
    //   856	864	867	java/lang/OutOfMemoryError
    //   844	851	1089	finally
    //   856	864	1089	finally
    //   869	925	1089	finally
    //   116	125	1116	finally
    //   128	134	1116	finally
    //   137	152	1116	finally
    //   155	168	1116	finally
    //   171	176	1116	finally
    //   179	195	1116	finally
    //   535	566	1116	finally
    //   928	932	1116	finally
    //   116	125	1120	java/lang/Exception
    //   128	134	1120	java/lang/Exception
    //   137	152	1120	java/lang/Exception
    //   155	168	1120	java/lang/Exception
    //   171	176	1120	java/lang/Exception
    //   179	195	1120	java/lang/Exception
    //   928	932	1120	java/lang/Exception
    //   1102	1106	1130	java/lang/Exception
  }
  
  /* Error */
  public static final String K(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +16 -> 26
    //   13: ldc 34
    //   15: iconst_1
    //   16: ldc_w 419
    //   19: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aconst_null
    //   23: astore_3
    //   24: aload_3
    //   25: areturn
    //   26: new 44	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: ldc 56
    //   37: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: new 44	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 421
    //   54: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_3
    //   69: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 6
    //   74: aload 4
    //   76: astore_3
    //   77: new 84	anzp
    //   80: dup
    //   81: invokespecial 85	anzp:<init>	()V
    //   84: astore_0
    //   85: aload 4
    //   87: astore_3
    //   88: ldc 87
    //   90: invokestatic 93	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   93: astore 7
    //   95: aload 4
    //   97: astore_3
    //   98: aload 7
    //   100: aconst_null
    //   101: iconst_1
    //   102: anewarray 95	javax/net/ssl/TrustManager
    //   105: dup
    //   106: iconst_0
    //   107: aload_0
    //   108: aastore
    //   109: aconst_null
    //   110: invokevirtual 99	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   113: aload 4
    //   115: astore_3
    //   116: new 101	anzr
    //   119: dup
    //   120: aload 7
    //   122: invokevirtual 105	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   125: invokespecial 108	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   128: astore 7
    //   130: aload 4
    //   132: astore_3
    //   133: aload 7
    //   135: invokestatic 113	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   138: aload 4
    //   140: astore_3
    //   141: new 115	java/net/URL
    //   144: dup
    //   145: aload 6
    //   147: invokespecial 116	java/net/URL:<init>	(Ljava/lang/String;)V
    //   150: invokevirtual 120	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   153: checkcast 110	javax/net/ssl/HttpsURLConnection
    //   156: astore_0
    //   157: aload_0
    //   158: aload 7
    //   160: invokevirtual 123	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   163: aload_0
    //   164: sipush 5000
    //   167: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   170: aload_0
    //   171: sipush 30000
    //   174: invokevirtual 130	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   177: aload_0
    //   178: iconst_1
    //   179: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   182: aload_0
    //   183: iconst_1
    //   184: invokevirtual 137	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   187: aload_0
    //   188: iconst_0
    //   189: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   192: aload_0
    //   193: ldc_w 423
    //   196: invokevirtual 145	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   199: aload_0
    //   200: ldc 147
    //   202: ldc 149
    //   204: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_0
    //   208: ldc 155
    //   210: new 44	java/lang/StringBuilder
    //   213: dup
    //   214: ldc 157
    //   216: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: ldc 160
    //   221: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: getstatic 166	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   227: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc 160
    //   232: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: getstatic 171	android/os/Build:DEVICE	Ljava/lang/String;
    //   238: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc 160
    //   243: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: getstatic 174	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   249: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 160
    //   254: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc 176
    //   259: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc 160
    //   264: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc_w 425
    //   270: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 427
    //   276: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_0
    //   286: ldc 189
    //   288: ldc_w 429
    //   291: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_0
    //   295: ldc 185
    //   297: ldc 187
    //   299: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload_0
    //   303: ldc_w 431
    //   306: ldc 70
    //   308: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: new 195	java/util/HashMap
    //   314: dup
    //   315: invokespecial 196	java/util/HashMap:<init>	()V
    //   318: astore 4
    //   320: aload 4
    //   322: ldc 147
    //   324: ldc 198
    //   326: invokeinterface 204 3 0
    //   331: pop
    //   332: aload 4
    //   334: ldc 206
    //   336: aload 6
    //   338: invokeinterface 204 3 0
    //   343: pop
    //   344: invokestatic 212	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   347: invokevirtual 216	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   350: iconst_2
    //   351: invokevirtual 222	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   354: checkcast 224	mqq/manager/TicketManager
    //   357: astore_3
    //   358: aload_3
    //   359: aload_1
    //   360: invokeinterface 228 2 0
    //   365: astore 5
    //   367: aload 6
    //   369: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   372: ifne +372 -> 744
    //   375: aload_3
    //   376: aload_1
    //   377: ldc 230
    //   379: invokeinterface 233 3 0
    //   384: astore_3
    //   385: aload_3
    //   386: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   389: ifeq +146 -> 535
    //   392: ldc 34
    //   394: iconst_1
    //   395: ldc_w 433
    //   398: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: invokestatic 240	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   404: astore_1
    //   405: aload_1
    //   406: ifnull +19 -> 425
    //   409: aload 4
    //   411: ldc 242
    //   413: aload_1
    //   414: aload 6
    //   416: invokevirtual 245	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   419: invokeinterface 204 3 0
    //   424: pop
    //   425: aload 4
    //   427: invokeinterface 249 1 0
    //   432: invokeinterface 255 1 0
    //   437: astore_1
    //   438: aload_1
    //   439: invokeinterface 260 1 0
    //   444: ifeq +156 -> 600
    //   447: aload_1
    //   448: invokeinterface 264 1 0
    //   453: checkcast 266	java/util/Map$Entry
    //   456: astore_3
    //   457: aload_0
    //   458: aload_3
    //   459: invokeinterface 269 1 0
    //   464: checkcast 271	java/lang/String
    //   467: aload_3
    //   468: invokeinterface 274 1 0
    //   473: checkcast 271	java/lang/String
    //   476: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: goto -41 -> 438
    //   482: astore 4
    //   484: aconst_null
    //   485: astore_3
    //   486: aload_0
    //   487: astore_1
    //   488: aload_3
    //   489: astore_0
    //   490: aload_1
    //   491: astore_3
    //   492: ldc_w 276
    //   495: iconst_1
    //   496: new 44	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   503: ldc_w 435
    //   506: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload 4
    //   511: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   514: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aload_0
    //   524: astore_3
    //   525: aload_1
    //   526: ifnull -502 -> 24
    //   529: aload_1
    //   530: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   533: aload_0
    //   534: areturn
    //   535: aload 4
    //   537: ldc 242
    //   539: new 44	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 291
    //   549: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload_3
    //   553: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc_w 293
    //   559: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_1
    //   563: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: ldc_w 295
    //   569: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload 5
    //   574: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokeinterface 204 3 0
    //   585: pop
    //   586: goto -161 -> 425
    //   589: astore_1
    //   590: aload_0
    //   591: ifnull +7 -> 598
    //   594: aload_0
    //   595: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   598: aload_1
    //   599: athrow
    //   600: new 306	java/lang/StringBuffer
    //   603: dup
    //   604: invokespecial 307	java/lang/StringBuffer:<init>	()V
    //   607: astore_3
    //   608: aload_0
    //   609: invokevirtual 388	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   612: istore_2
    //   613: iload_2
    //   614: sipush 200
    //   617: if_icmpeq +35 -> 652
    //   620: ldc 34
    //   622: iconst_1
    //   623: new 44	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   630: ldc_w 437
    //   633: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: iload_2
    //   637: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   640: ldc_w 395
    //   643: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 398	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   652: new 400	java/io/BufferedReader
    //   655: dup
    //   656: new 402	java/io/InputStreamReader
    //   659: dup
    //   660: aload_0
    //   661: invokevirtual 406	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   664: invokespecial 407	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   667: invokespecial 410	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   670: astore_1
    //   671: aload_1
    //   672: invokevirtual 413	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   675: astore 4
    //   677: aload 4
    //   679: ifnull +19 -> 698
    //   682: aload_3
    //   683: aload 4
    //   685: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   688: ldc_w 415
    //   691: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   694: pop
    //   695: goto -24 -> 671
    //   698: aload_3
    //   699: invokevirtual 329	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   702: astore_3
    //   703: aload_1
    //   704: invokevirtual 416	java/io/BufferedReader:close	()V
    //   707: aload_0
    //   708: ifnull +34 -> 742
    //   711: aload_0
    //   712: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   715: aload_3
    //   716: areturn
    //   717: astore_1
    //   718: aload_3
    //   719: astore_0
    //   720: goto -130 -> 590
    //   723: astore 4
    //   725: aconst_null
    //   726: astore_0
    //   727: aload 5
    //   729: astore_1
    //   730: goto -240 -> 490
    //   733: astore 4
    //   735: aload_0
    //   736: astore_1
    //   737: aload_3
    //   738: astore_0
    //   739: goto -249 -> 490
    //   742: aload_3
    //   743: areturn
    //   744: aconst_null
    //   745: astore_3
    //   746: goto -361 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	749	0	paramString1	String
    //   0	749	1	paramString2	String
    //   612	25	2	i	int
    //   23	723	3	localObject1	Object
    //   1	425	4	localHashMap	HashMap
    //   482	54	4	localException1	Exception
    //   675	9	4	str1	String
    //   723	1	4	localException2	Exception
    //   733	1	4	localException3	Exception
    //   4	724	5	str2	String
    //   72	343	6	str3	String
    //   93	66	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   157	385	482	java/lang/Exception
    //   385	405	482	java/lang/Exception
    //   409	425	482	java/lang/Exception
    //   425	438	482	java/lang/Exception
    //   438	479	482	java/lang/Exception
    //   535	586	482	java/lang/Exception
    //   600	613	482	java/lang/Exception
    //   620	652	482	java/lang/Exception
    //   652	671	482	java/lang/Exception
    //   671	677	482	java/lang/Exception
    //   682	695	482	java/lang/Exception
    //   698	703	482	java/lang/Exception
    //   157	385	589	finally
    //   385	405	589	finally
    //   409	425	589	finally
    //   425	438	589	finally
    //   438	479	589	finally
    //   535	586	589	finally
    //   600	613	589	finally
    //   620	652	589	finally
    //   652	671	589	finally
    //   671	677	589	finally
    //   682	695	589	finally
    //   698	703	589	finally
    //   703	707	589	finally
    //   77	85	717	finally
    //   88	95	717	finally
    //   98	113	717	finally
    //   116	130	717	finally
    //   133	138	717	finally
    //   141	157	717	finally
    //   492	523	717	finally
    //   77	85	723	java/lang/Exception
    //   88	95	723	java/lang/Exception
    //   98	113	723	java/lang/Exception
    //   116	130	723	java/lang/Exception
    //   133	138	723	java/lang/Exception
    //   141	157	723	java/lang/Exception
    //   703	707	733	java/lang/Exception
  }
  
  /* Error */
  public static com.tencent.util.Pair<Integer, String> a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: iconst_1
    //   4: istore 4
    //   6: iconst_1
    //   7: istore 5
    //   9: ldc_w 440
    //   12: iconst_1
    //   13: new 44	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 442
    //   23: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +17 -> 57
    //   43: aload_1
    //   44: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifne +10 -> 57
    //   50: aload_2
    //   51: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifeq +5 -> 59
    //   57: aconst_null
    //   58: areturn
    //   59: new 115	java/net/URL
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 116	java/net/URL:<init>	(Ljava/lang/String;)V
    //   67: invokevirtual 120	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   70: checkcast 110	javax/net/ssl/HttpsURLConnection
    //   73: astore 7
    //   75: iload 5
    //   77: istore_3
    //   78: new 444	jqe
    //   81: dup
    //   82: invokespecial 445	jqe:<init>	()V
    //   85: astore_0
    //   86: iload 5
    //   88: istore_3
    //   89: aload 7
    //   91: new 447	aqok
    //   94: dup
    //   95: ldc_w 449
    //   98: aload_0
    //   99: invokespecial 452	aqok:<init>	(Ljava/lang/String;Ljavax/net/ssl/HostnameVerifier;)V
    //   102: invokevirtual 123	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   105: iload 5
    //   107: istore_3
    //   108: aload 7
    //   110: aload_0
    //   111: invokevirtual 456	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   114: iload 5
    //   116: istore_3
    //   117: aload 7
    //   119: sipush 5000
    //   122: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   125: iload 5
    //   127: istore_3
    //   128: aload 7
    //   130: sipush 30000
    //   133: invokevirtual 130	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   136: iload 5
    //   138: istore_3
    //   139: aload 7
    //   141: ldc_w 423
    //   144: invokevirtual 145	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   147: iload 5
    //   149: istore_3
    //   150: aload 7
    //   152: ldc 147
    //   154: ldc 149
    //   156: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: iload 5
    //   161: istore_3
    //   162: aload 7
    //   164: ldc 155
    //   166: new 44	java/lang/StringBuilder
    //   169: dup
    //   170: ldc 157
    //   172: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: ldc 160
    //   177: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: getstatic 166	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   183: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc 160
    //   188: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: getstatic 171	android/os/Build:DEVICE	Ljava/lang/String;
    //   194: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc 160
    //   199: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: getstatic 174	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   205: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc 160
    //   210: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc 176
    //   215: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: iload 5
    //   226: istore_3
    //   227: aload 7
    //   229: ldc 206
    //   231: ldc_w 458
    //   234: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: iload 5
    //   239: istore_3
    //   240: aload 7
    //   242: ldc_w 460
    //   245: ldc_w 449
    //   248: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: iload 5
    //   253: istore_3
    //   254: invokestatic 212	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   257: invokevirtual 216	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   260: iconst_2
    //   261: invokevirtual 222	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   264: checkcast 224	mqq/manager/TicketManager
    //   267: aload_1
    //   268: ldc_w 449
    //   271: invokeinterface 233 3 0
    //   276: astore_0
    //   277: iload 5
    //   279: istore_3
    //   280: aload_0
    //   281: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   284: ifne +123 -> 407
    //   287: iload 5
    //   289: istore_3
    //   290: aload 7
    //   292: ldc 242
    //   294: new 44	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 462
    //   304: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_1
    //   308: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 464
    //   314: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: iload 5
    //   329: istore_3
    //   330: aload 7
    //   332: invokevirtual 388	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   335: istore 6
    //   337: iload 6
    //   339: sipush 200
    //   342: if_icmpeq +162 -> 504
    //   345: iload 5
    //   347: istore_3
    //   348: ldc_w 440
    //   351: iconst_1
    //   352: new 44	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 466
    //   362: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload 6
    //   367: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: iload 5
    //   378: istore_3
    //   379: new 468	com/tencent/util/Pair
    //   382: dup
    //   383: iload 6
    //   385: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: ldc_w 476
    //   391: invokespecial 479	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   394: astore_0
    //   395: aload 7
    //   397: ifnull +8 -> 405
    //   400: aload 7
    //   402: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   405: aload_0
    //   406: areturn
    //   407: iload 5
    //   409: istore_3
    //   410: aload 7
    //   412: ldc 242
    //   414: new 44	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 481
    //   424: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc_w 295
    //   434: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_2
    //   438: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: goto -120 -> 327
    //   450: astore_1
    //   451: aload 7
    //   453: astore_0
    //   454: ldc_w 440
    //   457: iconst_1
    //   458: new 44	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   465: ldc_w 483
    //   468: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload_1
    //   472: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   481: aload_0
    //   482: ifnull +258 -> 740
    //   485: aload_0
    //   486: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   489: aconst_null
    //   490: astore_0
    //   491: new 468	com/tencent/util/Pair
    //   494: dup
    //   495: iload_3
    //   496: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: aload_0
    //   500: invokespecial 479	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   503: areturn
    //   504: iload 5
    //   506: istore_3
    //   507: new 44	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   514: astore_0
    //   515: iload 5
    //   517: istore_3
    //   518: new 400	java/io/BufferedReader
    //   521: dup
    //   522: new 402	java/io/InputStreamReader
    //   525: dup
    //   526: aload 7
    //   528: invokevirtual 406	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   531: invokespecial 407	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   534: invokespecial 410	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   537: astore_1
    //   538: iload 5
    //   540: istore_3
    //   541: aload_1
    //   542: invokevirtual 413	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   545: astore_2
    //   546: aload_2
    //   547: ifnull +35 -> 582
    //   550: iload 5
    //   552: istore_3
    //   553: aload_0
    //   554: aload_2
    //   555: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: ldc_w 415
    //   561: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: goto -27 -> 538
    //   568: astore_1
    //   569: aload 7
    //   571: astore_0
    //   572: aload_0
    //   573: ifnull +7 -> 580
    //   576: aload_0
    //   577: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   580: aload_1
    //   581: athrow
    //   582: iload 5
    //   584: istore_3
    //   585: aload_1
    //   586: invokevirtual 416	java/io/BufferedReader:close	()V
    //   589: iload 5
    //   591: istore_3
    //   592: aload_0
    //   593: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: astore_0
    //   597: iload 5
    //   599: istore_3
    //   600: aload_0
    //   601: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   604: ifne +109 -> 713
    //   607: iload 5
    //   609: istore_3
    //   610: new 488	org/json/JSONObject
    //   613: dup
    //   614: aload_0
    //   615: invokespecial 489	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   618: astore_0
    //   619: iload 5
    //   621: istore_3
    //   622: aload_0
    //   623: ldc_w 491
    //   626: invokevirtual 495	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   629: istore 4
    //   631: iload 4
    //   633: ifne +49 -> 682
    //   636: iload 4
    //   638: istore_3
    //   639: aload_0
    //   640: ldc_w 497
    //   643: invokevirtual 501	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   646: ifeq +36 -> 682
    //   649: iload 4
    //   651: istore_3
    //   652: aload_0
    //   653: ldc_w 497
    //   656: invokevirtual 505	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   659: ldc_w 507
    //   662: invokevirtual 510	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   665: astore_0
    //   666: iload 4
    //   668: istore_3
    //   669: aload 7
    //   671: ifnull +74 -> 745
    //   674: aload 7
    //   676: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   679: goto -188 -> 491
    //   682: iload 4
    //   684: istore_3
    //   685: ldc_w 440
    //   688: iconst_1
    //   689: new 44	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   696: ldc_w 512
    //   699: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: iload 4
    //   704: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   707: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   713: iload 4
    //   715: istore_3
    //   716: aload 8
    //   718: astore_0
    //   719: goto -50 -> 669
    //   722: astore_1
    //   723: aconst_null
    //   724: astore_0
    //   725: goto -153 -> 572
    //   728: astore_1
    //   729: goto -157 -> 572
    //   732: astore_1
    //   733: iconst_1
    //   734: istore_3
    //   735: aconst_null
    //   736: astore_0
    //   737: goto -283 -> 454
    //   740: aconst_null
    //   741: astore_0
    //   742: goto -251 -> 491
    //   745: goto -254 -> 491
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	748	0	paramString1	String
    //   0	748	1	paramString2	String
    //   0	748	2	paramString3	String
    //   77	658	3	i	int
    //   4	710	4	j	int
    //   7	613	5	k	int
    //   335	49	6	m	int
    //   73	602	7	localHttpsURLConnection	HttpsURLConnection
    //   1	716	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   78	86	450	java/lang/Exception
    //   89	105	450	java/lang/Exception
    //   108	114	450	java/lang/Exception
    //   117	125	450	java/lang/Exception
    //   128	136	450	java/lang/Exception
    //   139	147	450	java/lang/Exception
    //   150	159	450	java/lang/Exception
    //   162	224	450	java/lang/Exception
    //   227	237	450	java/lang/Exception
    //   240	251	450	java/lang/Exception
    //   254	277	450	java/lang/Exception
    //   280	287	450	java/lang/Exception
    //   290	327	450	java/lang/Exception
    //   330	337	450	java/lang/Exception
    //   348	376	450	java/lang/Exception
    //   379	395	450	java/lang/Exception
    //   410	447	450	java/lang/Exception
    //   507	515	450	java/lang/Exception
    //   518	538	450	java/lang/Exception
    //   541	546	450	java/lang/Exception
    //   553	565	450	java/lang/Exception
    //   585	589	450	java/lang/Exception
    //   592	597	450	java/lang/Exception
    //   600	607	450	java/lang/Exception
    //   610	619	450	java/lang/Exception
    //   622	631	450	java/lang/Exception
    //   639	649	450	java/lang/Exception
    //   652	666	450	java/lang/Exception
    //   685	713	450	java/lang/Exception
    //   78	86	568	finally
    //   89	105	568	finally
    //   108	114	568	finally
    //   117	125	568	finally
    //   128	136	568	finally
    //   139	147	568	finally
    //   150	159	568	finally
    //   162	224	568	finally
    //   227	237	568	finally
    //   240	251	568	finally
    //   254	277	568	finally
    //   280	287	568	finally
    //   290	327	568	finally
    //   330	337	568	finally
    //   348	376	568	finally
    //   379	395	568	finally
    //   410	447	568	finally
    //   507	515	568	finally
    //   518	538	568	finally
    //   541	546	568	finally
    //   553	565	568	finally
    //   585	589	568	finally
    //   592	597	568	finally
    //   600	607	568	finally
    //   610	619	568	finally
    //   622	631	568	finally
    //   639	649	568	finally
    //   652	666	568	finally
    //   685	713	568	finally
    //   59	75	722	finally
    //   454	481	728	finally
    //   59	75	732	java/lang/Exception
  }
  
  /* Error */
  public static ByteArrayOutputStream a(HttpResponse paramHttpResponse)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 523 1 0
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload 5
    //   17: invokeinterface 528 1 0
    //   22: astore 5
    //   24: aload 5
    //   26: astore_3
    //   27: aload 5
    //   29: astore_2
    //   30: aload 5
    //   32: astore 4
    //   34: new 530	java/io/ByteArrayOutputStream
    //   37: dup
    //   38: invokespecial 531	java/io/ByteArrayOutputStream:<init>	()V
    //   41: astore 6
    //   43: aload 5
    //   45: astore_3
    //   46: aload 5
    //   48: astore_2
    //   49: aload 5
    //   51: astore 4
    //   53: aload_0
    //   54: ldc_w 533
    //   57: invokeinterface 537 2 0
    //   62: astore 7
    //   64: aload 5
    //   66: astore_0
    //   67: aload 7
    //   69: ifnull +55 -> 124
    //   72: aload 5
    //   74: astore_0
    //   75: aload 5
    //   77: astore_3
    //   78: aload 5
    //   80: astore_2
    //   81: aload 5
    //   83: astore 4
    //   85: aload 7
    //   87: invokeinterface 541 1 0
    //   92: invokevirtual 544	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   95: ldc_w 546
    //   98: invokevirtual 549	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +23 -> 124
    //   104: aload 5
    //   106: astore_3
    //   107: aload 5
    //   109: astore_2
    //   110: aload 5
    //   112: astore 4
    //   114: new 551	java/util/zip/GZIPInputStream
    //   117: dup
    //   118: aload 5
    //   120: invokespecial 552	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   123: astore_0
    //   124: aload_0
    //   125: astore_3
    //   126: aload_0
    //   127: astore_2
    //   128: aload_0
    //   129: astore 4
    //   131: sipush 512
    //   134: newarray byte
    //   136: astore 5
    //   138: aload_0
    //   139: astore_3
    //   140: aload_0
    //   141: astore_2
    //   142: aload_0
    //   143: astore 4
    //   145: aload_0
    //   146: aload 5
    //   148: invokevirtual 555	java/io/InputStream:read	([B)I
    //   151: istore_1
    //   152: iload_1
    //   153: iconst_m1
    //   154: if_icmpeq +38 -> 192
    //   157: aload_0
    //   158: astore_3
    //   159: aload_0
    //   160: astore_2
    //   161: aload_0
    //   162: astore 4
    //   164: aload 6
    //   166: aload 5
    //   168: iconst_0
    //   169: iload_1
    //   170: invokevirtual 556	java/io/ByteArrayOutputStream:write	([BII)V
    //   173: goto -35 -> 138
    //   176: astore_0
    //   177: aload_3
    //   178: astore_2
    //   179: aload_0
    //   180: athrow
    //   181: astore_0
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 557	java/io/InputStream:close	()V
    //   190: aload_0
    //   191: athrow
    //   192: aload_0
    //   193: ifnull +7 -> 200
    //   196: aload_0
    //   197: invokevirtual 557	java/io/InputStream:close	()V
    //   200: aload 6
    //   202: areturn
    //   203: astore_0
    //   204: aload 4
    //   206: astore_2
    //   207: new 517	java/io/IOException
    //   210: dup
    //   211: invokespecial 558	java/io/IOException:<init>	()V
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramHttpResponse	HttpResponse
    //   151	19	1	i	int
    //   9	198	2	localObject1	Object
    //   14	164	3	localObject2	Object
    //   11	194	4	localObject3	Object
    //   6	161	5	localObject4	Object
    //   41	160	6	localByteArrayOutputStream	ByteArrayOutputStream
    //   62	24	7	localHeader	org.apache.http.Header
    // Exception table:
    //   from	to	target	type
    //   15	24	176	java/io/IOException
    //   34	43	176	java/io/IOException
    //   53	64	176	java/io/IOException
    //   85	104	176	java/io/IOException
    //   114	124	176	java/io/IOException
    //   131	138	176	java/io/IOException
    //   145	152	176	java/io/IOException
    //   164	173	176	java/io/IOException
    //   15	24	181	finally
    //   34	43	181	finally
    //   53	64	181	finally
    //   85	104	181	finally
    //   114	124	181	finally
    //   131	138	181	finally
    //   145	152	181	finally
    //   164	173	181	finally
    //   179	181	181	finally
    //   207	215	181	finally
    //   15	24	203	java/lang/Exception
    //   34	43	203	java/lang/Exception
    //   53	64	203	java/lang/Exception
    //   85	104	203	java/lang/Exception
    //   114	124	203	java/lang/Exception
    //   131	138	203	java/lang/Exception
    //   145	152	203	java/lang/Exception
    //   164	173	203	java/lang/Exception
  }
  
  protected static final String a(Context paramContext, String paramString1, String paramString2, int paramInt, JSONArray paramJSONArray)
  {
    Bundle localBundle = new Bundle();
    String str = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getPskey(paramString1, "openmobile.qq.com");
    if (!TextUtils.isEmpty(str)) {
      localBundle.putString("cookie", "p_uin=" + paramString1 + ";p_skey=" + str);
    }
    for (;;)
    {
      localBundle.putString("Referer", "http://openmobile.qq.com/");
      paramString1 = new Bundle();
      paramString1.putString("type", String.valueOf(paramInt));
      paramString1.putString("value", paramJSONArray.toString());
      paramString1.putString("mType", "qb_share");
      try
      {
        paramContext = a(paramContext, "https://openmobile.qq.com/api/url_change", "POST", paramString1, localBundle);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        QLog.d("zivonchen", 4, paramContext.getMessage());
      }
      localBundle.putString("cookie", "uin=" + paramString1 + ";skey=" + paramString2);
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
    throws IOException
  {
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString1).getHost();
      try
      {
        HttpResponse localHttpResponse = a(paramContext, paramString1, null, paramString2, paramBundle1, paramBundle2);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(rwt.aCV))
        {
          str1 = rwt.s(paramContext, str2);
          if (str1 == null) {
            break label186;
          }
          paramString1 = paramString1.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label186:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext);
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2, String paramString3)
    throws IOException
  {
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str = Uri.parse(paramString1).getHost();
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString3)) {
            continue;
          }
          paramString3 = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          paramContext = paramString3;
        }
        catch (IOException paramString3)
        {
          if (!str.equals(rwt.aCV)) {
            continue;
          }
          paramString3 = rwt.s(paramContext, str);
          if (paramString3 == null) {
            break label265;
          }
          paramString1 = paramString1.replace(str, paramString3);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          continue;
          throw new IOException("0");
        }
        catch (OutOfMemoryError paramContext)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("HttpUtil", 2, "openRequest fail OutOfMemoryError");
          paramContext = null;
          continue;
          int i = paramContext.getStatusLine().getStatusCode();
          if (i != 200) {
            continue;
          }
          try
          {
            paramContext = a(paramContext);
            return paramContext;
          }
          catch (OutOfMemoryError paramContext)
          {
            throw new IOException("-1");
          }
          throw new IOException("" + i);
        }
        if (paramContext != null) {
          continue;
        }
        throw new IOException("0");
        paramString3 = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2, 15000, 30000, paramString3);
        paramContext = paramString3;
      }
      label265:
      for (;;) {}
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, boolean paramBoolean)
  {
    try
    {
      HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)new URL(paramString1).openConnection();
      jqf localjqf = new jqf(paramString2);
      if (!paramBoolean) {
        localHttpsURLConnection.setSSLSocketFactory(new aqok(paramString2, localjqf));
      }
      localHttpsURLConnection.setHostnameVerifier(localjqf);
      localHttpsURLConnection.setRequestProperty("Host", paramString2);
      paramString2 = a(localHttpsURLConnection, paramString1, paramString3, paramString4, paramMap1, paramMap2, paramMap3, paramBoolean);
      return paramString2;
    }
    catch (MalformedURLException paramString2)
    {
      QLog.e("Q.share.sdk", 1, new Object[] { "urlStr=", paramString1, ", MalformedURLException uploadImage|err=", paramString2 });
      return null;
    }
    catch (IOException paramString2)
    {
      QLog.e("Q.share.sdk", 1, new Object[] { "urlStr=", paramString1, ", IOException uploadImage|err=", paramString2 });
    }
    return null;
  }
  
  public static final String a(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      QLog.d("Q.share.sdk", 1, "uploadImage param invalid");
      return null;
    }
    boolean bool = paramString1.startsWith("http://cgi.connect.qq.com/qqconnectopen/upload_share_image");
    try
    {
      paramString2 = a((HttpURLConnection)new URL(paramString1).openConnection(), paramString1, paramString2, paramString3, paramMap1, paramMap2, paramMap3, bool);
      return paramString2;
    }
    catch (MalformedURLException paramString2)
    {
      QLog.e("Q.share.sdk", 1, new Object[] { "urlStr=", paramString1, ", MalformedURLException uploadImage|err=", paramString2 });
      return null;
    }
    catch (IOException paramString2)
    {
      QLog.e("Q.share.sdk", 1, new Object[] { "urlStr=", paramString1, ", IOException uploadImage|err=", paramString2 });
    }
    return null;
  }
  
  /* Error */
  public static final String a(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 10
    //   3: aload_0
    //   4: astore 9
    //   6: aload_0
    //   7: sipush 5000
    //   10: invokevirtual 690	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   13: aload_0
    //   14: astore 10
    //   16: aload_0
    //   17: astore 9
    //   19: aload_0
    //   20: sipush 30000
    //   23: invokevirtual 691	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   26: aload_0
    //   27: astore 10
    //   29: aload_0
    //   30: astore 9
    //   32: aload_0
    //   33: iconst_1
    //   34: invokevirtual 692	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   37: aload_0
    //   38: astore 10
    //   40: aload_0
    //   41: astore 9
    //   43: aload_0
    //   44: iconst_1
    //   45: invokevirtual 693	java/net/HttpURLConnection:setDoInput	(Z)V
    //   48: aload_0
    //   49: astore 10
    //   51: aload_0
    //   52: astore 9
    //   54: aload_0
    //   55: iconst_0
    //   56: invokevirtual 694	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   59: aload_0
    //   60: astore 10
    //   62: aload_0
    //   63: astore 9
    //   65: aload_0
    //   66: ldc 142
    //   68: invokevirtual 695	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: astore 10
    //   74: aload_0
    //   75: astore 9
    //   77: aload_0
    //   78: ldc 147
    //   80: ldc 149
    //   82: invokevirtual 696	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: astore 10
    //   88: aload_0
    //   89: astore 9
    //   91: aload_0
    //   92: ldc 155
    //   94: new 44	java/lang/StringBuilder
    //   97: dup
    //   98: ldc 157
    //   100: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: ldc 160
    //   105: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: getstatic 166	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   111: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 160
    //   116: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 171	android/os/Build:DEVICE	Ljava/lang/String;
    //   122: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 160
    //   127: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: getstatic 174	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   133: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 160
    //   138: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 176
    //   143: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokevirtual 696	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_0
    //   153: astore 10
    //   155: aload_0
    //   156: astore 9
    //   158: aload_0
    //   159: ldc 189
    //   161: new 44	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   168: ldc 191
    //   170: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc 193
    //   175: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokevirtual 696	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 6
    //   186: astore 11
    //   188: aload 6
    //   190: ifnonnull +18 -> 208
    //   193: aload_0
    //   194: astore 10
    //   196: aload_0
    //   197: astore 9
    //   199: new 195	java/util/HashMap
    //   202: dup
    //   203: invokespecial 196	java/util/HashMap:<init>	()V
    //   206: astore 11
    //   208: iload 7
    //   210: ifeq +94 -> 304
    //   213: aload_0
    //   214: astore 10
    //   216: aload_0
    //   217: astore 9
    //   219: invokestatic 212	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   222: invokevirtual 216	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   225: iconst_2
    //   226: invokevirtual 222	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   229: checkcast 224	mqq/manager/TicketManager
    //   232: aload_2
    //   233: ldc_w 449
    //   236: invokeinterface 233 3 0
    //   241: astore 6
    //   243: aload_0
    //   244: astore 10
    //   246: aload_0
    //   247: astore 9
    //   249: aload 6
    //   251: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +50 -> 304
    //   257: aload_0
    //   258: astore 10
    //   260: aload_0
    //   261: astore 9
    //   263: aload 11
    //   265: ldc 242
    //   267: new 44	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 462
    //   277: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_2
    //   281: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc_w 464
    //   287: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 6
    //   292: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokeinterface 204 3 0
    //   303: pop
    //   304: aload_0
    //   305: astore 10
    //   307: aload_0
    //   308: astore 9
    //   310: aload 11
    //   312: ldc 242
    //   314: invokeinterface 699 2 0
    //   319: ifne +49 -> 368
    //   322: aload_0
    //   323: astore 10
    //   325: aload_0
    //   326: astore 9
    //   328: aload 11
    //   330: ldc 242
    //   332: new 44	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   339: ldc_w 481
    //   342: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload_2
    //   346: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc_w 295
    //   352: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_3
    //   356: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokeinterface 204 3 0
    //   367: pop
    //   368: aload_0
    //   369: astore 10
    //   371: aload_0
    //   372: astore 9
    //   374: aload 11
    //   376: invokeinterface 249 1 0
    //   381: invokeinterface 255 1 0
    //   386: astore_3
    //   387: aload_0
    //   388: astore 10
    //   390: aload_0
    //   391: astore 9
    //   393: aload_3
    //   394: invokeinterface 260 1 0
    //   399: ifeq +139 -> 538
    //   402: aload_0
    //   403: astore 10
    //   405: aload_0
    //   406: astore 9
    //   408: aload_3
    //   409: invokeinterface 264 1 0
    //   414: checkcast 266	java/util/Map$Entry
    //   417: astore_2
    //   418: aload_0
    //   419: astore 10
    //   421: aload_0
    //   422: astore 9
    //   424: aload_0
    //   425: aload_2
    //   426: invokeinterface 269 1 0
    //   431: checkcast 271	java/lang/String
    //   434: aload_2
    //   435: invokeinterface 274 1 0
    //   440: checkcast 271	java/lang/String
    //   443: invokevirtual 696	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: goto -59 -> 387
    //   449: astore_3
    //   450: aconst_null
    //   451: astore_2
    //   452: aload 10
    //   454: astore_0
    //   455: aload_0
    //   456: astore 9
    //   458: ldc 34
    //   460: iconst_1
    //   461: new 44	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   468: ldc_w 701
    //   471: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload_1
    //   475: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: aload_3
    //   482: invokestatic 704	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   485: aload_2
    //   486: astore_1
    //   487: aload_0
    //   488: ifnull +48 -> 536
    //   491: aload_0
    //   492: invokevirtual 705	java/net/HttpURLConnection:getResponseCode	()I
    //   495: istore 8
    //   497: invokestatic 655	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +30 -> 530
    //   503: ldc 34
    //   505: iconst_2
    //   506: new 44	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   513: ldc_w 707
    //   516: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: iload 8
    //   521: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   524: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   530: aload_0
    //   531: invokevirtual 708	java/net/HttpURLConnection:disconnect	()V
    //   534: aload_2
    //   535: astore_1
    //   536: aload_1
    //   537: areturn
    //   538: aload_0
    //   539: astore 10
    //   541: aload_0
    //   542: astore 9
    //   544: new 297	java/io/DataOutputStream
    //   547: dup
    //   548: aload_0
    //   549: invokevirtual 709	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   552: invokespecial 304	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   555: astore_3
    //   556: aload 4
    //   558: ifnull +267 -> 825
    //   561: aload_0
    //   562: astore 10
    //   564: aload_0
    //   565: astore 9
    //   567: new 306	java/lang/StringBuffer
    //   570: dup
    //   571: invokespecial 307	java/lang/StringBuffer:<init>	()V
    //   574: astore_2
    //   575: aload_0
    //   576: astore 10
    //   578: aload_0
    //   579: astore 9
    //   581: aload 4
    //   583: invokeinterface 249 1 0
    //   588: invokeinterface 255 1 0
    //   593: astore 6
    //   595: aload_0
    //   596: astore 10
    //   598: aload_0
    //   599: astore 9
    //   601: aload 6
    //   603: invokeinterface 260 1 0
    //   608: ifeq +200 -> 808
    //   611: aload_0
    //   612: astore 10
    //   614: aload_0
    //   615: astore 9
    //   617: aload 6
    //   619: invokeinterface 264 1 0
    //   624: checkcast 266	java/util/Map$Entry
    //   627: astore 11
    //   629: aload_0
    //   630: astore 10
    //   632: aload_0
    //   633: astore 9
    //   635: aload 11
    //   637: invokeinterface 269 1 0
    //   642: checkcast 271	java/lang/String
    //   645: astore 4
    //   647: aload_0
    //   648: astore 10
    //   650: aload_0
    //   651: astore 9
    //   653: aload 11
    //   655: invokeinterface 274 1 0
    //   660: checkcast 271	java/lang/String
    //   663: astore 11
    //   665: aload 11
    //   667: ifnull -72 -> 595
    //   670: aload_0
    //   671: astore 10
    //   673: aload_0
    //   674: astore 9
    //   676: aload_2
    //   677: ldc_w 309
    //   680: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   683: ldc_w 314
    //   686: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   689: ldc 193
    //   691: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   694: ldc_w 309
    //   697: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   700: pop
    //   701: aload_0
    //   702: astore 10
    //   704: aload_0
    //   705: astore 9
    //   707: aload_2
    //   708: new 44	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   715: ldc_w 316
    //   718: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: aload 4
    //   723: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: ldc_w 711
    //   729: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   738: pop
    //   739: aload_0
    //   740: astore 10
    //   742: aload_0
    //   743: astore 9
    //   745: aload_2
    //   746: aload 11
    //   748: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   751: pop
    //   752: goto -157 -> 595
    //   755: astore_1
    //   756: aload 9
    //   758: ifnull +48 -> 806
    //   761: aload 9
    //   763: invokevirtual 705	java/net/HttpURLConnection:getResponseCode	()I
    //   766: istore 8
    //   768: invokestatic 655	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   771: ifeq +30 -> 801
    //   774: ldc 34
    //   776: iconst_2
    //   777: new 44	java/lang/StringBuilder
    //   780: dup
    //   781: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   784: ldc_w 707
    //   787: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: iload 8
    //   792: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   795: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   801: aload 9
    //   803: invokevirtual 708	java/net/HttpURLConnection:disconnect	()V
    //   806: aload_1
    //   807: athrow
    //   808: aload_0
    //   809: astore 10
    //   811: aload_0
    //   812: astore 9
    //   814: aload_3
    //   815: aload_2
    //   816: invokevirtual 329	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   819: invokevirtual 333	java/lang/String:getBytes	()[B
    //   822: invokevirtual 339	java/io/OutputStream:write	([B)V
    //   825: aload 5
    //   827: ifnull +527 -> 1354
    //   830: aload_0
    //   831: astore 10
    //   833: aload_0
    //   834: astore 9
    //   836: aload 5
    //   838: invokeinterface 249 1 0
    //   843: invokeinterface 255 1 0
    //   848: astore 4
    //   850: aload_0
    //   851: astore 10
    //   853: aload_0
    //   854: astore 9
    //   856: aload 4
    //   858: invokeinterface 260 1 0
    //   863: ifeq +491 -> 1354
    //   866: aload_0
    //   867: astore 10
    //   869: aload_0
    //   870: astore 9
    //   872: aload 4
    //   874: invokeinterface 264 1 0
    //   879: checkcast 266	java/util/Map$Entry
    //   882: astore_2
    //   883: aload_0
    //   884: astore 10
    //   886: aload_0
    //   887: astore 9
    //   889: aload_2
    //   890: invokeinterface 269 1 0
    //   895: checkcast 271	java/lang/String
    //   898: astore 6
    //   900: aload_0
    //   901: astore 10
    //   903: aload_0
    //   904: astore 9
    //   906: aload_2
    //   907: invokeinterface 274 1 0
    //   912: checkcast 271	java/lang/String
    //   915: astore_2
    //   916: aload_2
    //   917: ifnull -67 -> 850
    //   920: aload_0
    //   921: astore 10
    //   923: aload_0
    //   924: astore 9
    //   926: new 47	java/io/File
    //   929: dup
    //   930: aload_2
    //   931: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   934: astore 5
    //   936: aload_0
    //   937: astore 10
    //   939: aload_0
    //   940: astore 9
    //   942: aload 5
    //   944: invokevirtual 68	java/io/File:getName	()Ljava/lang/String;
    //   947: astore 11
    //   949: aload_0
    //   950: astore 10
    //   952: aload_0
    //   953: astore 9
    //   955: aload 11
    //   957: ldc_w 713
    //   960: invokevirtual 716	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   963: ifeq +3 -> 966
    //   966: ldc_w 718
    //   969: astore_2
    //   970: ldc_w 718
    //   973: ifnull +634 -> 1607
    //   976: aload_0
    //   977: astore 10
    //   979: aload_0
    //   980: astore 9
    //   982: ldc_w 718
    //   985: ldc_w 476
    //   988: invokevirtual 620	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   991: ifeq +6 -> 997
    //   994: goto +613 -> 1607
    //   997: aload_0
    //   998: astore 10
    //   1000: aload_0
    //   1001: astore 9
    //   1003: new 306	java/lang/StringBuffer
    //   1006: dup
    //   1007: invokespecial 307	java/lang/StringBuffer:<init>	()V
    //   1010: astore 12
    //   1012: aload_0
    //   1013: astore 10
    //   1015: aload_0
    //   1016: astore 9
    //   1018: aload 12
    //   1020: ldc_w 309
    //   1023: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1026: ldc_w 314
    //   1029: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1032: ldc 193
    //   1034: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1037: ldc_w 309
    //   1040: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1043: pop
    //   1044: aload_0
    //   1045: astore 10
    //   1047: aload_0
    //   1048: astore 9
    //   1050: aload 12
    //   1052: new 44	java/lang/StringBuilder
    //   1055: dup
    //   1056: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   1059: ldc_w 316
    //   1062: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: aload 6
    //   1067: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: ldc_w 320
    //   1073: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: aload 11
    //   1078: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: ldc_w 322
    //   1084: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1090: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1093: pop
    //   1094: aload_0
    //   1095: astore 10
    //   1097: aload_0
    //   1098: astore 9
    //   1100: aload 12
    //   1102: new 44	java/lang/StringBuilder
    //   1105: dup
    //   1106: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   1109: ldc_w 324
    //   1112: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: aload_2
    //   1116: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: ldc_w 328
    //   1122: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1128: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1131: pop
    //   1132: aload_0
    //   1133: astore 10
    //   1135: aload_0
    //   1136: astore 9
    //   1138: aload_3
    //   1139: aload 12
    //   1141: invokevirtual 329	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1144: invokevirtual 333	java/lang/String:getBytes	()[B
    //   1147: invokevirtual 339	java/io/OutputStream:write	([B)V
    //   1150: aload_0
    //   1151: astore 10
    //   1153: aload_0
    //   1154: astore 9
    //   1156: new 341	java/io/BufferedInputStream
    //   1159: dup
    //   1160: new 341	java/io/BufferedInputStream
    //   1163: dup
    //   1164: new 343	java/io/FileInputStream
    //   1167: dup
    //   1168: aload 5
    //   1170: invokespecial 346	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1173: invokespecial 349	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1176: invokespecial 349	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1179: astore_2
    //   1180: aload_0
    //   1181: astore 10
    //   1183: aload_0
    //   1184: astore 9
    //   1186: sipush 3072
    //   1189: newarray byte
    //   1191: astore 6
    //   1193: aload_2
    //   1194: aload 6
    //   1196: invokevirtual 353	java/io/BufferedInputStream:read	([B)I
    //   1199: istore 8
    //   1201: iload 8
    //   1203: iconst_m1
    //   1204: if_icmpeq +104 -> 1308
    //   1207: aload_3
    //   1208: aload 6
    //   1210: iconst_0
    //   1211: iload 8
    //   1213: invokevirtual 356	java/io/OutputStream:write	([BII)V
    //   1216: goto -23 -> 1193
    //   1219: astore 4
    //   1221: ldc 34
    //   1223: iconst_1
    //   1224: iconst_4
    //   1225: anewarray 4	java/lang/Object
    //   1228: dup
    //   1229: iconst_0
    //   1230: ldc_w 720
    //   1233: aastore
    //   1234: dup
    //   1235: iconst_1
    //   1236: aload 5
    //   1238: invokevirtual 362	java/io/File:length	()J
    //   1241: invokestatic 725	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1244: aastore
    //   1245: dup
    //   1246: iconst_2
    //   1247: ldc_w 367
    //   1250: aastore
    //   1251: dup
    //   1252: iconst_3
    //   1253: aload 5
    //   1255: invokevirtual 370	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1258: aastore
    //   1259: invokestatic 675	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1262: aload_3
    //   1263: invokevirtual 373	java/io/OutputStream:flush	()V
    //   1266: aload_3
    //   1267: invokevirtual 376	java/io/OutputStream:close	()V
    //   1270: aload_0
    //   1271: invokevirtual 708	java/net/HttpURLConnection:disconnect	()V
    //   1274: aconst_null
    //   1275: astore 9
    //   1277: aconst_null
    //   1278: astore 10
    //   1280: aconst_null
    //   1281: astore_0
    //   1282: aload_2
    //   1283: invokevirtual 377	java/io/BufferedInputStream:close	()V
    //   1286: aload_0
    //   1287: astore_1
    //   1288: iconst_0
    //   1289: ifeq -753 -> 536
    //   1292: new 379	java/lang/NullPointerException
    //   1295: dup
    //   1296: invokespecial 380	java/lang/NullPointerException:<init>	()V
    //   1299: athrow
    //   1300: new 379	java/lang/NullPointerException
    //   1303: dup
    //   1304: invokespecial 380	java/lang/NullPointerException:<init>	()V
    //   1307: athrow
    //   1308: aload_0
    //   1309: astore 10
    //   1311: aload_0
    //   1312: astore 9
    //   1314: aload_2
    //   1315: invokevirtual 377	java/io/BufferedInputStream:close	()V
    //   1318: goto -468 -> 850
    //   1321: astore_0
    //   1322: ldc 34
    //   1324: iconst_1
    //   1325: ldc_w 727
    //   1328: aload_0
    //   1329: invokestatic 704	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1332: goto -32 -> 1300
    //   1335: astore_3
    //   1336: aload_0
    //   1337: astore 10
    //   1339: aload_0
    //   1340: astore 9
    //   1342: aload_2
    //   1343: invokevirtual 377	java/io/BufferedInputStream:close	()V
    //   1346: aload_0
    //   1347: astore 10
    //   1349: aload_0
    //   1350: astore 9
    //   1352: aload_3
    //   1353: athrow
    //   1354: aload_0
    //   1355: astore 10
    //   1357: aload_0
    //   1358: astore 9
    //   1360: aload_3
    //   1361: new 44	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   1368: ldc_w 382
    //   1371: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: ldc 193
    //   1376: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: ldc_w 384
    //   1382: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1388: invokevirtual 333	java/lang/String:getBytes	()[B
    //   1391: invokevirtual 339	java/io/OutputStream:write	([B)V
    //   1394: aload_0
    //   1395: astore 10
    //   1397: aload_0
    //   1398: astore 9
    //   1400: aload_3
    //   1401: invokevirtual 373	java/io/OutputStream:flush	()V
    //   1404: aload_0
    //   1405: astore 10
    //   1407: aload_0
    //   1408: astore 9
    //   1410: aload_3
    //   1411: invokevirtual 376	java/io/OutputStream:close	()V
    //   1414: aload_0
    //   1415: astore 10
    //   1417: aload_0
    //   1418: astore 9
    //   1420: new 306	java/lang/StringBuffer
    //   1423: dup
    //   1424: invokespecial 307	java/lang/StringBuffer:<init>	()V
    //   1427: astore_2
    //   1428: aload_0
    //   1429: astore 10
    //   1431: aload_0
    //   1432: astore 9
    //   1434: new 400	java/io/BufferedReader
    //   1437: dup
    //   1438: new 402	java/io/InputStreamReader
    //   1441: dup
    //   1442: aload_0
    //   1443: invokevirtual 728	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1446: invokespecial 407	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1449: invokespecial 410	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1452: astore_3
    //   1453: aload_0
    //   1454: astore 10
    //   1456: aload_0
    //   1457: astore 9
    //   1459: aload_3
    //   1460: invokevirtual 413	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1463: astore 4
    //   1465: aload 4
    //   1467: ifnull +25 -> 1492
    //   1470: aload_0
    //   1471: astore 10
    //   1473: aload_0
    //   1474: astore 9
    //   1476: aload_2
    //   1477: aload 4
    //   1479: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1482: ldc_w 415
    //   1485: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1488: pop
    //   1489: goto -36 -> 1453
    //   1492: aload_0
    //   1493: astore 10
    //   1495: aload_0
    //   1496: astore 9
    //   1498: aload_2
    //   1499: invokevirtual 329	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1502: astore_2
    //   1503: aload_0
    //   1504: astore 9
    //   1506: aload_3
    //   1507: invokevirtual 416	java/io/BufferedReader:close	()V
    //   1510: aload_2
    //   1511: astore_1
    //   1512: aload_0
    //   1513: ifnull -977 -> 536
    //   1516: aload_0
    //   1517: invokevirtual 705	java/net/HttpURLConnection:getResponseCode	()I
    //   1520: istore 8
    //   1522: invokestatic 655	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1525: ifeq +30 -> 1555
    //   1528: ldc 34
    //   1530: iconst_2
    //   1531: new 44	java/lang/StringBuilder
    //   1534: dup
    //   1535: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   1538: ldc_w 707
    //   1541: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: iload 8
    //   1546: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1549: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1552: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1555: aload_0
    //   1556: invokevirtual 708	java/net/HttpURLConnection:disconnect	()V
    //   1559: aload_2
    //   1560: areturn
    //   1561: astore_1
    //   1562: ldc 34
    //   1564: iconst_1
    //   1565: ldc_w 727
    //   1568: aload_1
    //   1569: invokestatic 704	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1572: goto -17 -> 1555
    //   1575: astore_1
    //   1576: ldc 34
    //   1578: iconst_1
    //   1579: ldc_w 727
    //   1582: aload_1
    //   1583: invokestatic 704	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1586: goto -1056 -> 530
    //   1589: astore_0
    //   1590: ldc 34
    //   1592: iconst_1
    //   1593: ldc_w 727
    //   1596: aload_0
    //   1597: invokestatic 704	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1600: goto -799 -> 801
    //   1603: astore_3
    //   1604: goto -1149 -> 455
    //   1607: ldc_w 326
    //   1610: astore_2
    //   1611: goto -614 -> 997
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1614	0	paramHttpURLConnection	HttpURLConnection
    //   0	1614	1	paramString1	String
    //   0	1614	2	paramString2	String
    //   0	1614	3	paramString3	String
    //   0	1614	4	paramMap1	Map<String, String>
    //   0	1614	5	paramMap2	Map<String, String>
    //   0	1614	6	paramMap3	Map<String, String>
    //   0	1614	7	paramBoolean	boolean
    //   495	1050	8	i	int
    //   4	1501	9	localHttpURLConnection1	HttpURLConnection
    //   1	1493	10	localHttpURLConnection2	HttpURLConnection
    //   186	891	11	localObject	Object
    //   1010	130	12	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   6	13	449	java/lang/Exception
    //   19	26	449	java/lang/Exception
    //   32	37	449	java/lang/Exception
    //   43	48	449	java/lang/Exception
    //   54	59	449	java/lang/Exception
    //   65	71	449	java/lang/Exception
    //   77	85	449	java/lang/Exception
    //   91	152	449	java/lang/Exception
    //   158	184	449	java/lang/Exception
    //   199	208	449	java/lang/Exception
    //   219	243	449	java/lang/Exception
    //   249	257	449	java/lang/Exception
    //   263	304	449	java/lang/Exception
    //   310	322	449	java/lang/Exception
    //   328	368	449	java/lang/Exception
    //   374	387	449	java/lang/Exception
    //   393	402	449	java/lang/Exception
    //   408	418	449	java/lang/Exception
    //   424	446	449	java/lang/Exception
    //   544	556	449	java/lang/Exception
    //   567	575	449	java/lang/Exception
    //   581	595	449	java/lang/Exception
    //   601	611	449	java/lang/Exception
    //   617	629	449	java/lang/Exception
    //   635	647	449	java/lang/Exception
    //   653	665	449	java/lang/Exception
    //   676	701	449	java/lang/Exception
    //   707	739	449	java/lang/Exception
    //   745	752	449	java/lang/Exception
    //   814	825	449	java/lang/Exception
    //   836	850	449	java/lang/Exception
    //   856	866	449	java/lang/Exception
    //   872	883	449	java/lang/Exception
    //   889	900	449	java/lang/Exception
    //   906	916	449	java/lang/Exception
    //   926	936	449	java/lang/Exception
    //   942	949	449	java/lang/Exception
    //   955	966	449	java/lang/Exception
    //   982	994	449	java/lang/Exception
    //   1003	1012	449	java/lang/Exception
    //   1018	1044	449	java/lang/Exception
    //   1050	1094	449	java/lang/Exception
    //   1100	1132	449	java/lang/Exception
    //   1138	1150	449	java/lang/Exception
    //   1156	1180	449	java/lang/Exception
    //   1186	1193	449	java/lang/Exception
    //   1282	1286	449	java/lang/Exception
    //   1314	1318	449	java/lang/Exception
    //   1342	1346	449	java/lang/Exception
    //   1352	1354	449	java/lang/Exception
    //   1360	1394	449	java/lang/Exception
    //   1400	1404	449	java/lang/Exception
    //   1410	1414	449	java/lang/Exception
    //   1420	1428	449	java/lang/Exception
    //   1434	1453	449	java/lang/Exception
    //   1459	1465	449	java/lang/Exception
    //   1476	1489	449	java/lang/Exception
    //   1498	1503	449	java/lang/Exception
    //   6	13	755	finally
    //   19	26	755	finally
    //   32	37	755	finally
    //   43	48	755	finally
    //   54	59	755	finally
    //   65	71	755	finally
    //   77	85	755	finally
    //   91	152	755	finally
    //   158	184	755	finally
    //   199	208	755	finally
    //   219	243	755	finally
    //   249	257	755	finally
    //   263	304	755	finally
    //   310	322	755	finally
    //   328	368	755	finally
    //   374	387	755	finally
    //   393	402	755	finally
    //   408	418	755	finally
    //   424	446	755	finally
    //   458	485	755	finally
    //   544	556	755	finally
    //   567	575	755	finally
    //   581	595	755	finally
    //   601	611	755	finally
    //   617	629	755	finally
    //   635	647	755	finally
    //   653	665	755	finally
    //   676	701	755	finally
    //   707	739	755	finally
    //   745	752	755	finally
    //   814	825	755	finally
    //   836	850	755	finally
    //   856	866	755	finally
    //   872	883	755	finally
    //   889	900	755	finally
    //   906	916	755	finally
    //   926	936	755	finally
    //   942	949	755	finally
    //   955	966	755	finally
    //   982	994	755	finally
    //   1003	1012	755	finally
    //   1018	1044	755	finally
    //   1050	1094	755	finally
    //   1100	1132	755	finally
    //   1138	1150	755	finally
    //   1156	1180	755	finally
    //   1186	1193	755	finally
    //   1282	1286	755	finally
    //   1314	1318	755	finally
    //   1342	1346	755	finally
    //   1352	1354	755	finally
    //   1360	1394	755	finally
    //   1400	1404	755	finally
    //   1410	1414	755	finally
    //   1420	1428	755	finally
    //   1434	1453	755	finally
    //   1459	1465	755	finally
    //   1476	1489	755	finally
    //   1498	1503	755	finally
    //   1506	1510	755	finally
    //   1193	1201	1219	java/lang/OutOfMemoryError
    //   1207	1216	1219	java/lang/OutOfMemoryError
    //   1292	1300	1321	java/lang/Exception
    //   1193	1201	1335	finally
    //   1207	1216	1335	finally
    //   1221	1274	1335	finally
    //   1516	1555	1561	java/lang/Exception
    //   491	530	1575	java/lang/Exception
    //   761	801	1589	java/lang/Exception
    //   1506	1510	1603	java/lang/Exception
  }
  
  public static String a(HttpResponse paramHttpResponse)
    throws IllegalStateException, IOException
  {
    return new String(a(paramHttpResponse).toByteArray());
  }
  
  /* Error */
  public static final String a(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +16 -> 29
    //   16: ldc 34
    //   18: iconst_1
    //   19: ldc_w 741
    //   22: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_3
    //   28: areturn
    //   29: new 44	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   36: astore 4
    //   38: aload 4
    //   40: ldc 56
    //   42: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 743
    //   52: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 745
    //   58: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 4
    //   64: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 6
    //   69: aload_3
    //   70: astore 4
    //   72: new 84	anzp
    //   75: dup
    //   76: invokespecial 85	anzp:<init>	()V
    //   79: astore 7
    //   81: aload_3
    //   82: astore 4
    //   84: ldc 87
    //   86: invokestatic 93	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   89: astore 8
    //   91: aload_3
    //   92: astore 4
    //   94: aload 8
    //   96: aconst_null
    //   97: iconst_1
    //   98: anewarray 95	javax/net/ssl/TrustManager
    //   101: dup
    //   102: iconst_0
    //   103: aload 7
    //   105: aastore
    //   106: aconst_null
    //   107: invokevirtual 99	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   110: aload_3
    //   111: astore 4
    //   113: new 101	anzr
    //   116: dup
    //   117: aload 8
    //   119: invokevirtual 105	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   122: invokespecial 108	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   125: astore 7
    //   127: aload_3
    //   128: astore 4
    //   130: aload 7
    //   132: invokestatic 113	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   135: aload_3
    //   136: astore 4
    //   138: new 115	java/net/URL
    //   141: dup
    //   142: aload 6
    //   144: invokespecial 116	java/net/URL:<init>	(Ljava/lang/String;)V
    //   147: invokevirtual 120	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   150: checkcast 110	javax/net/ssl/HttpsURLConnection
    //   153: astore_3
    //   154: aload_3
    //   155: aload 7
    //   157: invokevirtual 123	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   160: aload_3
    //   161: sipush 5000
    //   164: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   167: aload_3
    //   168: sipush 30000
    //   171: invokevirtual 130	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   174: aload_3
    //   175: iconst_1
    //   176: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   179: aload_3
    //   180: iconst_1
    //   181: invokevirtual 137	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   184: aload_3
    //   185: iconst_0
    //   186: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   189: aload_3
    //   190: ldc 142
    //   192: invokevirtual 145	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   195: aload_3
    //   196: ldc 147
    //   198: ldc 149
    //   200: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_3
    //   204: ldc 155
    //   206: new 44	java/lang/StringBuilder
    //   209: dup
    //   210: ldc 157
    //   212: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: ldc 160
    //   217: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: getstatic 166	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   223: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc 160
    //   228: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: getstatic 171	android/os/Build:DEVICE	Ljava/lang/String;
    //   234: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc 160
    //   239: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: getstatic 174	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   245: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 160
    //   250: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc 176
    //   255: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc 160
    //   260: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 178
    //   265: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokestatic 183	com/tencent/common/config/AppSetting:getVersion	()Ljava/lang/String;
    //   271: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_3
    //   281: ldc 189
    //   283: ldc_w 429
    //   286: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload_3
    //   290: ldc 185
    //   292: ldc 187
    //   294: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload_3
    //   298: ldc_w 431
    //   301: ldc 70
    //   303: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: new 195	java/util/HashMap
    //   309: dup
    //   310: invokespecial 196	java/util/HashMap:<init>	()V
    //   313: astore 5
    //   315: aload 5
    //   317: ldc 147
    //   319: ldc 198
    //   321: invokeinterface 204 3 0
    //   326: pop
    //   327: aload 5
    //   329: ldc 206
    //   331: aload 6
    //   333: invokeinterface 204 3 0
    //   338: pop
    //   339: invokestatic 212	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   342: invokevirtual 216	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   345: iconst_2
    //   346: invokevirtual 222	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   349: checkcast 224	mqq/manager/TicketManager
    //   352: astore 4
    //   354: aload 4
    //   356: aload_1
    //   357: invokeinterface 228 2 0
    //   362: astore 7
    //   364: aload 6
    //   366: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   369: ifne +438 -> 807
    //   372: aload 4
    //   374: aload_1
    //   375: ldc 230
    //   377: invokeinterface 233 3 0
    //   382: astore 4
    //   384: aload 4
    //   386: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   389: ifeq +149 -> 538
    //   392: ldc 34
    //   394: iconst_1
    //   395: ldc_w 433
    //   398: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: invokestatic 240	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   404: astore_1
    //   405: aload_1
    //   406: ifnull +19 -> 425
    //   409: aload 5
    //   411: ldc 242
    //   413: aload_1
    //   414: aload 6
    //   416: invokevirtual 245	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   419: invokeinterface 204 3 0
    //   424: pop
    //   425: aload 5
    //   427: invokeinterface 249 1 0
    //   432: invokeinterface 255 1 0
    //   437: astore_1
    //   438: aload_1
    //   439: invokeinterface 260 1 0
    //   444: ifeq +170 -> 614
    //   447: aload_1
    //   448: invokeinterface 264 1 0
    //   453: checkcast 266	java/util/Map$Entry
    //   456: astore 4
    //   458: aload_3
    //   459: aload 4
    //   461: invokeinterface 269 1 0
    //   466: checkcast 271	java/lang/String
    //   469: aload 4
    //   471: invokeinterface 274 1 0
    //   476: checkcast 271	java/lang/String
    //   479: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: goto -44 -> 438
    //   485: astore 4
    //   487: aconst_null
    //   488: astore_0
    //   489: aload_3
    //   490: astore_1
    //   491: aload 4
    //   493: astore_3
    //   494: aload_1
    //   495: astore 4
    //   497: ldc 34
    //   499: iconst_1
    //   500: new 44	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   507: ldc_w 435
    //   510: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload_3
    //   514: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   517: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: aload_0
    //   527: astore_3
    //   528: aload_1
    //   529: ifnull -502 -> 27
    //   532: aload_1
    //   533: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   536: aload_0
    //   537: areturn
    //   538: aload 5
    //   540: ldc 242
    //   542: new 44	java/lang/StringBuilder
    //   545: dup
    //   546: new 44	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   553: ldc_w 291
    //   556: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: aload 4
    //   561: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: ldc_w 293
    //   567: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload_1
    //   571: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: ldc_w 295
    //   577: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: aload 7
    //   582: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   591: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokeinterface 204 3 0
    //   599: pop
    //   600: goto -175 -> 425
    //   603: astore_0
    //   604: aload_3
    //   605: ifnull +7 -> 612
    //   608: aload_3
    //   609: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   612: aload_0
    //   613: athrow
    //   614: new 297	java/io/DataOutputStream
    //   617: dup
    //   618: aload_3
    //   619: invokevirtual 301	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   622: invokespecial 304	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   625: astore_1
    //   626: aload_1
    //   627: aload_0
    //   628: invokevirtual 746	org/json/JSONObject:toString	()Ljava/lang/String;
    //   631: ldc 70
    //   633: invokevirtual 749	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   636: invokevirtual 339	java/io/OutputStream:write	([B)V
    //   639: aload_1
    //   640: invokevirtual 373	java/io/OutputStream:flush	()V
    //   643: aload_1
    //   644: invokevirtual 376	java/io/OutputStream:close	()V
    //   647: new 306	java/lang/StringBuffer
    //   650: dup
    //   651: invokespecial 307	java/lang/StringBuffer:<init>	()V
    //   654: astore_0
    //   655: aload_3
    //   656: invokevirtual 388	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   659: istore_2
    //   660: iload_2
    //   661: sipush 200
    //   664: if_icmpeq +35 -> 699
    //   667: ldc 34
    //   669: iconst_1
    //   670: new 44	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   677: ldc_w 751
    //   680: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: iload_2
    //   684: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   687: ldc_w 395
    //   690: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokestatic 398	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   699: new 400	java/io/BufferedReader
    //   702: dup
    //   703: new 402	java/io/InputStreamReader
    //   706: dup
    //   707: aload_3
    //   708: invokevirtual 406	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   711: invokespecial 407	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   714: invokespecial 410	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   717: astore_1
    //   718: aload_1
    //   719: invokevirtual 413	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   722: astore 4
    //   724: aload 4
    //   726: ifnull +34 -> 760
    //   729: aload_0
    //   730: aload 4
    //   732: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   735: ldc_w 415
    //   738: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   741: pop
    //   742: goto -24 -> 718
    //   745: astore_0
    //   746: aload_1
    //   747: invokevirtual 376	java/io/OutputStream:close	()V
    //   750: aload_3
    //   751: ifnull +7 -> 758
    //   754: aload_3
    //   755: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   758: aconst_null
    //   759: areturn
    //   760: aload_0
    //   761: invokevirtual 329	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   764: astore_0
    //   765: aload_1
    //   766: invokevirtual 416	java/io/BufferedReader:close	()V
    //   769: aload_3
    //   770: ifnull +35 -> 805
    //   773: aload_3
    //   774: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   777: aload_0
    //   778: areturn
    //   779: astore_0
    //   780: aload 4
    //   782: astore_3
    //   783: goto -179 -> 604
    //   786: astore_3
    //   787: aconst_null
    //   788: astore_0
    //   789: aload 5
    //   791: astore_1
    //   792: goto -298 -> 494
    //   795: astore 4
    //   797: aload_3
    //   798: astore_1
    //   799: aload 4
    //   801: astore_3
    //   802: goto -308 -> 494
    //   805: aload_0
    //   806: areturn
    //   807: aconst_null
    //   808: astore 4
    //   810: goto -426 -> 384
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	813	0	paramJSONObject	JSONObject
    //   0	813	1	paramString	String
    //   659	25	2	i	int
    //   1	782	3	localObject1	Object
    //   786	12	3	localException1	Exception
    //   801	1	3	localObject2	Object
    //   36	434	4	localObject3	Object
    //   485	7	4	localException2	Exception
    //   495	286	4	str1	String
    //   795	5	4	localException3	Exception
    //   808	1	4	localObject4	Object
    //   3	787	5	localHashMap	HashMap
    //   67	348	6	str2	String
    //   79	502	7	localObject5	Object
    //   89	29	8	localSSLContext	javax.net.ssl.SSLContext
    // Exception table:
    //   from	to	target	type
    //   154	384	485	java/lang/Exception
    //   384	405	485	java/lang/Exception
    //   409	425	485	java/lang/Exception
    //   425	438	485	java/lang/Exception
    //   438	482	485	java/lang/Exception
    //   538	600	485	java/lang/Exception
    //   614	626	485	java/lang/Exception
    //   647	660	485	java/lang/Exception
    //   667	699	485	java/lang/Exception
    //   699	718	485	java/lang/Exception
    //   718	724	485	java/lang/Exception
    //   729	742	485	java/lang/Exception
    //   746	750	485	java/lang/Exception
    //   760	765	485	java/lang/Exception
    //   154	384	603	finally
    //   384	405	603	finally
    //   409	425	603	finally
    //   425	438	603	finally
    //   438	482	603	finally
    //   538	600	603	finally
    //   614	626	603	finally
    //   626	647	603	finally
    //   647	660	603	finally
    //   667	699	603	finally
    //   699	718	603	finally
    //   718	724	603	finally
    //   729	742	603	finally
    //   746	750	603	finally
    //   760	765	603	finally
    //   765	769	603	finally
    //   626	647	745	java/lang/Exception
    //   72	81	779	finally
    //   84	91	779	finally
    //   94	110	779	finally
    //   113	127	779	finally
    //   130	135	779	finally
    //   138	154	779	finally
    //   497	526	779	finally
    //   72	81	786	java/lang/Exception
    //   84	91	786	java/lang/Exception
    //   94	110	786	java/lang/Exception
    //   113	127	786	java/lang/Exception
    //   130	135	786	java/lang/Exception
    //   138	154	786	java/lang/Exception
    //   765	769	795	java/lang/Exception
  }
  
  public static final HashMap<String, String> a(Context paramContext, String paramString1, String paramString2, int paramInt, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    if (paramHashMap == null) {
      paramContext = new HashMap();
    }
    HashMap localHashMap;
    for (;;)
    {
      return paramContext;
      localHashMap = new HashMap(paramHashMap);
      JSONArray localJSONArray = new JSONArray();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramHashMap.get(str1);
        if (!TextUtils.isEmpty(str2))
        {
          localJSONArray.put(str2);
          localArrayList.add(str1);
        }
      }
      paramContext = a(paramContext, paramString1, paramString2, paramInt, localJSONArray);
      if (paramContext != null) {
        try
        {
          paramContext = new JSONObject(paramContext);
          paramInt = paramContext.getInt("retcode");
          if (paramBundle != null) {
            paramBundle.putInt("retcode", paramInt);
          }
          if (paramInt == 0)
          {
            paramContext = paramContext.getJSONObject("result");
            if (paramContext == null) {
              return localHashMap;
            }
            paramContext = paramContext.getJSONArray("list");
            if (paramContext == null) {
              return localHashMap;
            }
            if (paramContext.length() != localArrayList.size()) {
              break label328;
            }
            paramString1 = new HashMap();
            paramInt = 0;
            while (paramInt < paramContext.length())
            {
              paramString1.put(localArrayList.get(paramInt), paramContext.getString(paramInt));
              paramInt += 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("HttpUtil", 2, "batchUrlExchange results: " + paramString1.toString() + ", input: " + paramHashMap);
            }
            paramContext = paramString1;
            if (paramBundle == null) {
              continue;
            }
            paramBundle.putBoolean("isSuccess", true);
            return paramString1;
          }
        }
        catch (JSONException paramContext)
        {
          QLog.d("Q.share.sdk", 4, paramContext.getMessage());
        }
      }
    }
    for (;;)
    {
      return localHashMap;
      label328:
      QLog.e("Q.share.sdk", 4, "!!!!urlArray.length() != srcKeyArray.size()");
    }
  }
  
  public static final HashMap<String, String> a(HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    if (paramHashMap == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap(paramHashMap);
    Object localObject1 = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramHashMap.keySet().iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = (String)paramHashMap.get(localObject3);
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        ((JSONArray)localObject1).put(localObject4);
        localArrayList.add(localObject3);
      }
    }
    Object localObject3 = new Bundle();
    localObject2 = getAccount();
    Object localObject5;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject5 = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
      localObject4 = ((TicketManager)localObject5).getPskey((String)localObject2, "openmobile.qq.com");
      localObject5 = ((TicketManager)localObject5).getSkey((String)localObject2);
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label296;
      }
      ((Bundle)localObject3).putString("cookie", "p_uin=" + (String)localObject2 + ";p_skey=" + (String)localObject4);
    }
    for (;;)
    {
      ((Bundle)localObject3).putString("Referer", "http://openmobile.qq.com/");
      localObject4 = new Bundle();
      ((Bundle)localObject4).putString("value", ((JSONArray)localObject1).toString());
      ((Bundle)localObject4).putString("mType", "qb_share");
      localObject2 = null;
      try
      {
        localObject1 = a(BaseApplication.getContext(), MsfSdkUtils.insertMtype("AppDepart", "https://openmobile.qq.com/api/shortUrl"), "POST", (Bundle)localObject4, (Bundle)localObject3);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          return localHashMap;
          label296:
          ((Bundle)localObject3).putString("cookie", "uin=" + (String)localObject2 + ";skey=" + (String)localObject5);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("HttpUtil", 2, localIOException.getMessage());
            localObject1 = localObject2;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("HttpUtil", 2, localOutOfMemoryError.getMessage());
            localObject1 = localObject2;
          }
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        i = ((JSONObject)localObject1).getInt("retcode");
        if (paramBundle != null) {
          paramBundle.putInt("retcode", i);
        }
        if (i != 0)
        {
          if (!QLog.isColorLevel()) {
            break label657;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error retcode:" + i);
          break label657;
        }
        paramBundle = ((JSONObject)localObject1).getJSONObject("result");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label660;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          break label660;
        }
        paramBundle = paramBundle.getJSONArray("list");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label663;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          break label663;
        }
        if (paramBundle.length() == localArrayList.size())
        {
          i = 0;
          if (i < paramBundle.length())
          {
            localObject1 = paramBundle.getString(i);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label666;
            }
            localHashMap.put(localArrayList.get(i), localObject1);
            break label666;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("HttpUtil", 2, "shortenUrl error result size");
        }
      }
      catch (JSONException paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("HttpUtil", 2, "shortenUrl parse response error");
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HttpUtil", 2, "shortenUrl results: " + localHashMap.toString() + ", input: " + paramHashMap);
      }
      return localHashMap;
      label657:
      return localHashMap;
      label660:
      return localHashMap;
      label663:
      return localHashMap;
      label666:
      i += 1;
    }
  }
  
  public static jqc.a a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return null;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return null;
    }
    if (aqiw.isMobileNetworkInfo((NetworkInfo)localObject))
    {
      localObject = getProxyHost(paramContext);
      int i = getProxyPort(paramContext);
      if ((!isEmpty((String)localObject)) && (i >= 0)) {
        return new jqc.a((String)localObject, i, null);
      }
    }
    return null;
  }
  
  public static HttpResponse a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2)
    throws IOException
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramBundle1, paramBundle2, 15000, 30000);
  }
  
  public static HttpResponse a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt1, int paramInt2)
    throws IOException
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramBundle1, paramBundle2, paramInt1, paramInt2, null);
  }
  
  public static HttpResponse a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt1, int paramInt2, String paramString4)
    throws IOException
  {
    if (!abf)
    {
      abf = true;
      rwt.be(paramContext, rwt.aCV);
    }
    if (paramContext == null) {
      return null;
    }
    paramString4 = a(paramContext, paramInt1, paramInt2, paramString4);
    if (paramString4 == null) {
      return null;
    }
    QLog.d("QRHttpUtil", 2, paramString1);
    paramContext = paramString1;
    if (paramString1.contains("#")) {
      paramContext = paramString1.substring(0, paramString1.indexOf('#'));
    }
    paramString1 = paramContext.replace(" ", "%20");
    if ("GET".equals(paramString3))
    {
      paramString3 = b(paramBundle1);
      paramContext = paramString1;
      if (paramString3 != null)
      {
        paramContext = paramString1;
        if (paramString3.length() > 0)
        {
          paramBundle1 = new StringBuilder().append(paramString1);
          if (!paramString1.contains("?")) {
            break label255;
          }
          paramContext = "&";
        }
      }
      for (;;)
      {
        paramContext = paramContext + paramString3;
        try
        {
          paramContext = new HttpGet(paramContext);
          paramContext.addHeader("Accept-Encoding", "gzip");
          paramContext.addHeader("Connection", "close");
          if (paramBundle2 != null)
          {
            paramString1 = paramBundle2.keySet().iterator();
            while (paramString1.hasNext())
            {
              paramString3 = (String)paramString1.next();
              paramBundle1 = paramBundle2.get(paramString3);
              if ((paramBundle1 instanceof String))
              {
                paramContext.addHeader(paramString3, (String)paramBundle1);
                continue;
                label255:
                paramContext = "?";
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          return null;
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        paramContext.getParams().setParameter("http.virtual-host", new HttpHost(paramString2));
      }
      try
      {
        paramContext = paramString4.execute(paramContext);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail IOException", paramContext);
        return null;
      }
      catch (OutOfMemoryError paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label708;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail OutOfMemoryError");
        return null;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label728;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail Exception", paramContext);
      }
      paramString1 = new HttpPost(paramString1);
      paramString1.addHeader("Accept-Encoding", "gzip");
      paramString1.addHeader("Connection", "close");
      paramContext = "";
      paramInt1 = paramBundle1.getInt("PostBodyType");
      if (paramInt1 == 0)
      {
        paramContext = b(paramBundle1);
        paramString1.setHeader("Content-Type", "application/x-www-form-urlencoded");
      }
      for (;;)
      {
        paramContext = paramContext.getBytes();
        if (paramBundle2 == null) {
          break;
        }
        paramString3 = paramBundle2.keySet().iterator();
        Object localObject1;
        while (paramString3.hasNext())
        {
          paramBundle1 = (String)paramString3.next();
          localObject1 = paramBundle2.get(paramBundle1);
          if ((localObject1 instanceof String)) {
            paramString1.addHeader(paramBundle1, (String)localObject1);
          }
        }
        if (paramInt1 == 1)
        {
          paramString1.setHeader("Content-Type", "application/json; charset=UTF-8");
          paramBundle1.remove("PostBodyType");
          paramContext = new JSONObject();
          paramString3 = paramBundle1.keySet().iterator();
          while (paramString3.hasNext())
          {
            localObject1 = (String)paramString3.next();
            Object localObject2 = paramBundle1.get((String)localObject1);
            try
            {
              if (!(localObject2 instanceof String)) {
                break label560;
              }
              paramContext.put(URLEncoder.encode((String)localObject1), paramBundle1.getString((String)localObject1));
            }
            catch (JSONException localJSONException) {}
            if (QLog.isColorLevel())
            {
              QLog.d("QRHttpUtil", 2, "postBodyType=POST_BODY_TYPE_JSON parse Params to Json failed.");
              continue;
              label560:
              if (((localObject2 instanceof Long)) || ((localObject2 instanceof Integer)) || ((localObject2 instanceof Float)) || ((localObject2 instanceof Double)) || ((localObject2 instanceof Byte))) {
                paramContext.put(URLEncoder.encode(localJSONException), localObject2);
              } else if (((localObject2 instanceof JSONObject)) || ((localObject2 instanceof JSONArray))) {
                paramContext.put(URLEncoder.encode(localJSONException), localObject2);
              }
            }
          }
          paramContext = paramContext.toString();
        }
      }
      paramString1.setEntity(new ByteArrayEntity(paramContext));
      paramContext = paramString1;
    }
    label708:
    label728:
    return null;
  }
  
  private static HttpClient a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = null;
    if (paramContext == null)
    {
      paramContext = (Context)localObject;
      return paramContext;
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      try
      {
        localObject = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore)localObject).load(null, null);
        localObject = new ien.a((KeyStore)localObject);
        ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        if (!TextUtils.isEmpty(paramString)) {
          ((SSLSocketFactory)localObject).setHostnameVerifier(new jqd(paramString));
        }
        paramString = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(paramString, paramInt1);
        HttpConnectionParams.setSoTimeout(paramString, paramInt2);
        HttpProtocolParams.setVersion(paramString, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(paramString, "UTF-8");
        HttpProtocolParams.setUserAgent(paramString, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject, 443));
        paramString = new DefaultHttpClient(new ThreadSafeClientConnManager(paramString, localSchemeRegistry), paramString);
        localObject = a(paramContext);
        paramContext = paramString;
        if (localObject == null) {
          break;
        }
        paramContext = new HttpHost(((jqc.a)localObject).host, ((jqc.a)localObject).port);
        paramString.getParams().setParameter("http.route.default-proxy", paramContext);
        return paramString;
      }
      catch (Exception localException)
      {
        localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        localSSLSocketFactory.setHostnameVerifier(a);
        continue;
      }
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    }
  }
  
  public static byte[] a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
    throws IOException
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString1).getHost();
      try
      {
        HttpResponse localHttpResponse = a(paramContext, paramString1, null, paramString2, paramBundle1, paramBundle2);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(rwt.aCV))
        {
          str1 = rwt.s(paramContext, str2);
          if (str1 == null) {
            break label198;
          }
          paramString1 = paramString1.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label198:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext).toByteArray();
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  public static byte[] a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2, String paramString3)
    throws IOException
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str = Uri.parse(paramString1).getHost();
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString3)) {
            continue;
          }
          paramString3 = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          paramContext = paramString3;
        }
        catch (IOException paramString3)
        {
          if (!str.equals(rwt.aCV)) {
            continue;
          }
          paramString3 = rwt.s(paramContext, str);
          if (paramString3 == null) {
            break label242;
          }
          paramString1 = paramString1.replace(str, paramString3);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          continue;
          throw new IOException("0");
        }
        if (paramContext != null) {
          break label184;
        }
        throw new IOException("0");
        paramString3 = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2, 15000, 30000, paramString3);
        paramContext = paramString3;
      }
      label184:
      label242:
      for (;;)
      {
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext).toByteArray();
        }
        throw new IOException("" + i);
      }
    }
  }
  
  public static boolean ak(Context paramContext)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HttpUtil", 2, "isConnect(), context == null");
      }
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()))
        {
          paramContext = paramContext.getState();
          NetworkInfo.State localState = NetworkInfo.State.CONNECTED;
          if (paramContext == localState) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.d("HttpUtil", 2, paramContext.toString());
    }
    return false;
  }
  
  public static void an(Bundle paramBundle)
  {
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getSkey(str1);
    paramBundle.putString("cookie", "uin=" + str1 + ";skey=" + str2);
  }
  
  public static String b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramBundle.get((String)localObject1);
      if (((localObject2 instanceof String)) || ((localObject2 instanceof String[]))) {
        if ((localObject2 instanceof String[]))
        {
          int j;
          if (i != 0)
          {
            i = 0;
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=");
            localObject1 = (String[])paramBundle.getStringArray((String)localObject1);
            j = 0;
            label131:
            if (j >= localObject1.length) {
              break label206;
            }
            if (j != 0) {
              break label172;
            }
            localStringBuilder.append(URLEncoder.encode(localObject1[j]));
          }
          for (;;)
          {
            j += 1;
            break label131;
            localStringBuilder.append("&");
            break;
            label172:
            localStringBuilder.append(URLEncoder.encode("," + localObject1[j]));
          }
        }
        else
        {
          label206:
          if (i != 0) {
            i = 0;
          }
          for (;;)
          {
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=" + URLEncoder.encode(paramBundle.getString((String)localObject1)));
            break;
            localStringBuilder.append("&");
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static final HashMap<String, String> b(HashMap<String, String> paramHashMap)
  {
    return a(paramHashMap, null);
  }
  
  public static String dR(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
  }
  
  public static String dS(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = new String[27];
    localObject[0] = "li";
    localObject[1] = "del";
    localObject[2] = "ins";
    localObject[3] = "fieldset";
    localObject[4] = "legend";
    localObject[5] = "tr";
    localObject[6] = "th";
    localObject[7] = "caption";
    localObject[8] = "thead";
    localObject[9] = "tbody";
    localObject[10] = "tfoot";
    localObject[11] = "p";
    localObject[12] = "h[1-6]";
    localObject[13] = "dl";
    localObject[14] = "dt";
    localObject[15] = "dd";
    localObject[16] = "ol";
    localObject[17] = "ul";
    localObject[18] = "dir";
    localObject[19] = "address";
    localObject[20] = "blockquote";
    localObject[21] = "center";
    localObject[22] = "hr";
    localObject[23] = "pre";
    localObject[24] = "form";
    localObject[25] = "textarea";
    localObject[26] = "table";
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      Matcher localMatcher = Pattern.compile("<(\\s*" + localObject[i] + ")[^>]*>").matcher(paramString);
      if (localMatcher.find()) {
        paramString = localMatcher.replaceAll(" ");
      }
      localMatcher = Pattern.compile("</?(\\s*" + localObject[i] + ")[^>]*>").matcher(paramString);
      if (localMatcher.find()) {
        paramString = localMatcher.replaceAll("\n");
      }
      i += 1;
    }
    localObject = Pattern.compile("<br>").matcher(paramString);
    if (((Matcher)localObject).find()) {
      paramString = ((Matcher)localObject).replaceAll("\n");
    }
    return paramString.replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
  }
  
  private static String dT(String paramString)
  {
    Object localObject = null;
    String str = paramString.trim();
    String[] arrayOfString = str.split("[?]");
    paramString = localObject;
    if (str.length() > 1)
    {
      paramString = localObject;
      if (arrayOfString.length > 1)
      {
        paramString = localObject;
        if (arrayOfString[1] != null) {
          paramString = arrayOfString[1];
        }
      }
    }
    return paramString;
  }
  
  /* Error */
  public static final String dU(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 5
    //   7: new 47	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 54	java/io/File:exists	()Z
    //   18: ifeq +116 -> 134
    //   21: ldc_w 1263
    //   24: invokestatic 1268	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   27: astore 5
    //   29: new 343	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 1269	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: astore 4
    //   39: aload 4
    //   41: astore_0
    //   42: sipush 1024
    //   45: newarray byte
    //   47: astore 7
    //   49: aload 4
    //   51: astore_0
    //   52: aload 4
    //   54: aload 7
    //   56: invokevirtual 1270	java/io/FileInputStream:read	([B)I
    //   59: istore_1
    //   60: iload_1
    //   61: iconst_m1
    //   62: if_icmpeq +75 -> 137
    //   65: aload 4
    //   67: astore_0
    //   68: aload 5
    //   70: aload 7
    //   72: iconst_0
    //   73: iload_1
    //   74: invokevirtual 1273	java/security/MessageDigest:update	([BII)V
    //   77: goto -28 -> 49
    //   80: astore 5
    //   82: aload 4
    //   84: astore_0
    //   85: ldc_w 1275
    //   88: iconst_1
    //   89: new 44	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 1277
    //   99: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 5
    //   104: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   107: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload 6
    //   118: astore 5
    //   120: aload 4
    //   122: ifnull +12 -> 134
    //   125: aload 4
    //   127: invokevirtual 1278	java/io/FileInputStream:close	()V
    //   130: aload 6
    //   132: astore 5
    //   134: aload 5
    //   136: areturn
    //   137: aload 4
    //   139: astore_0
    //   140: aload 4
    //   142: invokevirtual 1278	java/io/FileInputStream:close	()V
    //   145: aload 4
    //   147: astore_0
    //   148: new 44	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   155: astore 7
    //   157: aload 4
    //   159: astore_0
    //   160: aload 5
    //   162: invokevirtual 1281	java/security/MessageDigest:digest	()[B
    //   165: astore 8
    //   167: aload 4
    //   169: astore_0
    //   170: aload 8
    //   172: arraylength
    //   173: istore_2
    //   174: iconst_0
    //   175: istore_1
    //   176: goto +195 -> 371
    //   179: aload 4
    //   181: astore_0
    //   182: aload 7
    //   184: aload 5
    //   186: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 4
    //   192: astore_0
    //   193: aload 7
    //   195: iload_3
    //   196: invokestatic 1284	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   199: invokevirtual 544	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   202: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: iload_1
    //   207: iconst_1
    //   208: iadd
    //   209: istore_1
    //   210: goto +161 -> 371
    //   213: aload 4
    //   215: astore_0
    //   216: aload 7
    //   218: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: astore 5
    //   223: aload 5
    //   225: astore_0
    //   226: aload_0
    //   227: astore 5
    //   229: aload 4
    //   231: ifnull -97 -> 134
    //   234: aload 4
    //   236: invokevirtual 1278	java/io/FileInputStream:close	()V
    //   239: aload_0
    //   240: areturn
    //   241: astore 4
    //   243: ldc_w 1275
    //   246: iconst_1
    //   247: new 44	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 1286
    //   257: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 4
    //   262: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   265: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_0
    //   275: areturn
    //   276: astore_0
    //   277: ldc_w 1275
    //   280: iconst_1
    //   281: new 44	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 1286
    //   291: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_0
    //   295: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   298: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aconst_null
    //   308: areturn
    //   309: astore 4
    //   311: aconst_null
    //   312: astore_0
    //   313: aload_0
    //   314: ifnull +7 -> 321
    //   317: aload_0
    //   318: invokevirtual 1278	java/io/FileInputStream:close	()V
    //   321: aload 4
    //   323: athrow
    //   324: astore_0
    //   325: ldc_w 1275
    //   328: iconst_1
    //   329: new 44	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 1286
    //   339: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_0
    //   343: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   346: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: goto -34 -> 321
    //   358: astore 4
    //   360: goto -47 -> 313
    //   363: astore 5
    //   365: aconst_null
    //   366: astore 4
    //   368: goto -286 -> 82
    //   371: iload_1
    //   372: iload_2
    //   373: if_icmpge -160 -> 213
    //   376: aload 8
    //   378: iload_1
    //   379: baload
    //   380: sipush 255
    //   383: iand
    //   384: istore_3
    //   385: iload_3
    //   386: bipush 16
    //   388: if_icmpge +11 -> 399
    //   391: ldc_w 649
    //   394: astore 5
    //   396: goto -217 -> 179
    //   399: ldc_w 476
    //   402: astore 5
    //   404: goto -225 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	paramString	String
    //   59	320	1	i	int
    //   173	201	2	j	int
    //   195	194	3	k	int
    //   37	198	4	localFileInputStream	java.io.FileInputStream
    //   241	20	4	localException1	Exception
    //   309	13	4	localObject1	Object
    //   358	1	4	localObject2	Object
    //   366	1	4	localObject3	Object
    //   5	64	5	localObject4	Object
    //   80	23	5	localException2	Exception
    //   118	110	5	localObject5	Object
    //   363	1	5	localException3	Exception
    //   394	9	5	str	String
    //   1	130	6	localObject6	Object
    //   47	170	7	localObject7	Object
    //   165	212	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   42	49	80	java/lang/Exception
    //   52	60	80	java/lang/Exception
    //   68	77	80	java/lang/Exception
    //   140	145	80	java/lang/Exception
    //   148	157	80	java/lang/Exception
    //   160	167	80	java/lang/Exception
    //   170	174	80	java/lang/Exception
    //   182	190	80	java/lang/Exception
    //   193	206	80	java/lang/Exception
    //   216	223	80	java/lang/Exception
    //   234	239	241	java/lang/Exception
    //   125	130	276	java/lang/Exception
    //   21	39	309	finally
    //   317	321	324	java/lang/Exception
    //   42	49	358	finally
    //   52	60	358	finally
    //   68	77	358	finally
    //   85	116	358	finally
    //   140	145	358	finally
    //   148	157	358	finally
    //   160	167	358	finally
    //   170	174	358	finally
    //   182	190	358	finally
    //   193	206	358	finally
    //   216	223	358	finally
    //   21	39	363	java/lang/Exception
  }
  
  public static String escape(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&", "&amp;").replace("'", "&apos;").replace("\"", "&quot;").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;");
  }
  
  public static HashMap<String, String> f(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString == null) {}
    do
    {
      return localHashMap;
      paramString = dT(paramString);
    } while (paramString == null);
    paramString = paramString.split("[&]");
    int j = paramString.length;
    int i = 0;
    label36:
    String[] arrayOfString;
    if (i < j)
    {
      arrayOfString = paramString[i].split("[=]");
      if (arrayOfString.length <= 1) {
        break label85;
      }
      localHashMap.put(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
    }
    for (;;)
    {
      i += 1;
      break label36;
      break;
      label85:
      if (!TextUtils.isEmpty(arrayOfString[0])) {
        localHashMap.put(arrayOfString[0], "");
      }
    }
  }
  
  private static String getAccount()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.getApplication();
    if (localObject2 != null) {
      localObject1 = ((BaseApplicationImpl)localObject2).getRuntime();
    }
    if (localObject1 == null) {
      localObject1 = "0";
    }
    do
    {
      return localObject1;
      localObject2 = ((AppRuntime)localObject1).getAccount();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return "0";
  }
  
  public static int getNetWorkType()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return 0;
      if (AppNetConnInfo.isWifiConn()) {
        return 1;
      }
    } while (!AppNetConnInfo.isMobileConn());
    switch (AppNetConnInfo.getMobileInfo())
    {
    case -1: 
    default: 
      return -1;
    case 0: 
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 4;
  }
  
  public static String getProxyHost(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (paramContext != null)
      {
        String str = Proxy.getHost(paramContext);
        paramContext = str;
        if (isEmpty(str)) {
          paramContext = Proxy.getDefaultHost();
        }
        return paramContext;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  public static int getProxyPort(Context paramContext)
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11) {
      if (paramContext != null)
      {
        int j = Proxy.getPort(paramContext);
        i = j;
        if (j < 0) {
          i = Proxy.getDefaultPort();
        }
      }
    }
    do
    {
      return i;
      return Proxy.getDefaultPort();
      paramContext = System.getProperty("http.proxyPort");
    } while (isEmpty(paramContext));
    try
    {
      i = Integer.parseInt(paramContext);
      return i;
    }
    catch (NumberFormatException paramContext) {}
    return -1;
  }
  
  public static String hS()
  {
    switch ()
    {
    default: 
      return null;
    case -1: 
      return "UNKNOWN";
    case 0: 
      return "NONE";
    case 1: 
      return "WIFI";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "CABLE";
  }
  
  private static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static final boolean isValidUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static String m(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokevirtual 1366	java/lang/String:toString	()Ljava/lang/String;
    //   7: astore 5
    //   9: new 84	anzp
    //   12: dup
    //   13: invokespecial 85	anzp:<init>	()V
    //   16: astore_1
    //   17: ldc 87
    //   19: invokestatic 93	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   22: astore 6
    //   24: aload 6
    //   26: aconst_null
    //   27: iconst_1
    //   28: anewarray 95	javax/net/ssl/TrustManager
    //   31: dup
    //   32: iconst_0
    //   33: aload_1
    //   34: aastore
    //   35: aconst_null
    //   36: invokevirtual 99	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   39: new 101	anzr
    //   42: dup
    //   43: aload 6
    //   45: invokevirtual 105	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   48: invokespecial 108	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   51: astore 6
    //   53: aload 6
    //   55: invokestatic 113	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   58: new 115	java/net/URL
    //   61: dup
    //   62: aload 5
    //   64: invokespecial 116	java/net/URL:<init>	(Ljava/lang/String;)V
    //   67: invokevirtual 120	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   70: checkcast 110	javax/net/ssl/HttpsURLConnection
    //   73: astore_1
    //   74: aload_1
    //   75: aload 6
    //   77: invokevirtual 123	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   80: aload_1
    //   81: sipush 5000
    //   84: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   87: aload_1
    //   88: sipush 30000
    //   91: invokevirtual 130	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   94: aload_1
    //   95: iconst_1
    //   96: invokevirtual 137	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   99: aload_1
    //   100: iconst_0
    //   101: invokevirtual 140	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   104: aload_1
    //   105: ldc_w 423
    //   108: invokevirtual 145	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   111: aload_1
    //   112: ldc 147
    //   114: ldc 149
    //   116: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_1
    //   120: ldc 155
    //   122: new 44	java/lang/StringBuilder
    //   125: dup
    //   126: ldc 157
    //   128: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: ldc 160
    //   133: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: getstatic 166	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   139: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 160
    //   144: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: getstatic 171	android/os/Build:DEVICE	Ljava/lang/String;
    //   150: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 160
    //   155: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: getstatic 174	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   161: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 160
    //   166: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc 176
    //   171: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc 160
    //   176: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc 178
    //   181: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokestatic 183	com/tencent/common/config/AppSetting:getVersion	()Ljava/lang/String;
    //   187: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload_1
    //   197: ldc 189
    //   199: ldc_w 429
    //   202: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload_1
    //   206: ldc 185
    //   208: ldc 187
    //   210: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_1
    //   214: ldc_w 431
    //   217: ldc 70
    //   219: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: new 195	java/util/HashMap
    //   225: dup
    //   226: invokespecial 196	java/util/HashMap:<init>	()V
    //   229: astore 4
    //   231: aload 4
    //   233: ldc 147
    //   235: ldc 198
    //   237: invokeinterface 204 3 0
    //   242: pop
    //   243: aload 4
    //   245: ldc 206
    //   247: aload 5
    //   249: invokeinterface 204 3 0
    //   254: pop
    //   255: invokestatic 212	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   258: invokevirtual 216	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   261: iconst_2
    //   262: invokevirtual 222	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   265: checkcast 224	mqq/manager/TicketManager
    //   268: astore 7
    //   270: aload 7
    //   272: aload_0
    //   273: invokeinterface 228 2 0
    //   278: astore 6
    //   280: aload 5
    //   282: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   285: ifne +373 -> 658
    //   288: aload 7
    //   290: aload_0
    //   291: aload_2
    //   292: invokeinterface 233 3 0
    //   297: astore_2
    //   298: aload_2
    //   299: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   302: ifeq +137 -> 439
    //   305: ldc 34
    //   307: iconst_1
    //   308: ldc_w 433
    //   311: invokestatic 42	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: invokestatic 240	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   317: astore_0
    //   318: aload_0
    //   319: ifnull +19 -> 338
    //   322: aload 4
    //   324: ldc 242
    //   326: aload_0
    //   327: aload 5
    //   329: invokevirtual 245	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   332: invokeinterface 204 3 0
    //   337: pop
    //   338: aload 4
    //   340: invokeinterface 249 1 0
    //   345: invokeinterface 255 1 0
    //   350: astore_0
    //   351: aload_0
    //   352: invokeinterface 260 1 0
    //   357: ifeq +147 -> 504
    //   360: aload_0
    //   361: invokeinterface 264 1 0
    //   366: checkcast 266	java/util/Map$Entry
    //   369: astore_2
    //   370: aload_1
    //   371: aload_2
    //   372: invokeinterface 269 1 0
    //   377: checkcast 271	java/lang/String
    //   380: aload_2
    //   381: invokeinterface 274 1 0
    //   386: checkcast 271	java/lang/String
    //   389: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: goto -41 -> 351
    //   395: astore_2
    //   396: aload_1
    //   397: astore_0
    //   398: aconst_null
    //   399: astore_1
    //   400: ldc 34
    //   402: iconst_1
    //   403: new 44	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 1368
    //   413: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_2
    //   417: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   420: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aload_0
    //   430: ifnull +7 -> 437
    //   433: aload_0
    //   434: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   437: aload_1
    //   438: areturn
    //   439: aload 4
    //   441: ldc 242
    //   443: new 44	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   450: ldc_w 291
    //   453: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload_2
    //   457: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: ldc_w 293
    //   463: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_0
    //   467: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc_w 295
    //   473: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 6
    //   478: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokeinterface 204 3 0
    //   489: pop
    //   490: goto -152 -> 338
    //   493: astore_0
    //   494: aload_1
    //   495: ifnull +7 -> 502
    //   498: aload_1
    //   499: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   502: aload_0
    //   503: athrow
    //   504: new 306	java/lang/StringBuffer
    //   507: dup
    //   508: invokespecial 307	java/lang/StringBuffer:<init>	()V
    //   511: astore_2
    //   512: aload_1
    //   513: invokevirtual 388	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   516: istore_3
    //   517: iload_3
    //   518: sipush 200
    //   521: if_icmpeq +35 -> 556
    //   524: ldc 34
    //   526: iconst_1
    //   527: new 44	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   534: ldc_w 1370
    //   537: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: iload_3
    //   541: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   544: ldc_w 395
    //   547: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 398	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: new 400	java/io/BufferedReader
    //   559: dup
    //   560: new 402	java/io/InputStreamReader
    //   563: dup
    //   564: aload_1
    //   565: invokevirtual 406	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   568: invokespecial 407	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   571: invokespecial 410	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   574: astore_0
    //   575: aload_0
    //   576: invokevirtual 413	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   579: astore 4
    //   581: aload 4
    //   583: ifnull +19 -> 602
    //   586: aload_2
    //   587: aload 4
    //   589: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   592: ldc_w 415
    //   595: invokevirtual 312	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   598: pop
    //   599: goto -24 -> 575
    //   602: aload_2
    //   603: invokevirtual 329	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   606: astore_2
    //   607: aload_0
    //   608: invokevirtual 416	java/io/BufferedReader:close	()V
    //   611: aload_1
    //   612: ifnull +44 -> 656
    //   615: aload_1
    //   616: invokevirtual 285	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   619: aload_2
    //   620: areturn
    //   621: astore_0
    //   622: aload 4
    //   624: astore_1
    //   625: goto -131 -> 494
    //   628: astore_2
    //   629: aload_0
    //   630: astore_1
    //   631: aload_2
    //   632: astore_0
    //   633: goto -139 -> 494
    //   636: astore_2
    //   637: aconst_null
    //   638: astore_0
    //   639: aconst_null
    //   640: astore_1
    //   641: goto -241 -> 400
    //   644: astore 4
    //   646: aload_1
    //   647: astore_0
    //   648: aload_2
    //   649: astore_1
    //   650: aload 4
    //   652: astore_2
    //   653: goto -253 -> 400
    //   656: aload_2
    //   657: areturn
    //   658: aconst_null
    //   659: astore_2
    //   660: goto -362 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	paramString1	String
    //   0	663	1	paramString2	String
    //   0	663	2	paramString3	String
    //   516	25	3	i	int
    //   1	622	4	localObject1	Object
    //   644	7	4	localException	Exception
    //   7	321	5	str	String
    //   22	455	6	localObject2	Object
    //   268	21	7	localTicketManager	TicketManager
    // Exception table:
    //   from	to	target	type
    //   74	298	395	java/lang/Exception
    //   298	318	395	java/lang/Exception
    //   322	338	395	java/lang/Exception
    //   338	351	395	java/lang/Exception
    //   351	392	395	java/lang/Exception
    //   439	490	395	java/lang/Exception
    //   504	517	395	java/lang/Exception
    //   524	556	395	java/lang/Exception
    //   556	575	395	java/lang/Exception
    //   575	581	395	java/lang/Exception
    //   586	599	395	java/lang/Exception
    //   602	607	395	java/lang/Exception
    //   74	298	493	finally
    //   298	318	493	finally
    //   322	338	493	finally
    //   338	351	493	finally
    //   351	392	493	finally
    //   439	490	493	finally
    //   504	517	493	finally
    //   524	556	493	finally
    //   556	575	493	finally
    //   575	581	493	finally
    //   586	599	493	finally
    //   602	607	493	finally
    //   607	611	493	finally
    //   9	74	621	finally
    //   400	429	628	finally
    //   9	74	636	java/lang/Exception
    //   607	611	644	java/lang/Exception
  }
  
  public static class a
  {
    public final String host;
    public final int port;
    
    private a(String paramString, int paramInt)
    {
      this.host = paramString;
      this.port = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     jqc
 * JD-Core Version:    0.7.0.1
 */