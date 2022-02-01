import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.2;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.4;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.5;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.6;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class msg
{
  private static msg a;
  public static int aTV;
  public static int aTW;
  private static final String ajL = "QQ/3.4.4 Android/0.17 Android/" + Build.VERSION.RELEASE;
  public static String ajR;
  public static String ajS = "1";
  public static String ajT = "2";
  public static String ajU = "3";
  public static String ajV = "4";
  public static String ajW = "1";
  public static String ajX = "0";
  public static String ajY = "1";
  public static String ajZ = "2";
  public static String aka = "3";
  public static List<String> jA;
  private static long rh;
  private String ajM = "";
  private String ajN = "";
  private String ajO = "";
  private String ajP = "";
  private String ajQ = "";
  private ViolaBaseView b;
  private volatile HashMap<String, Long> ef = new HashMap();
  private long wz;
  
  static
  {
    aTV = 404;
    aTW = 200;
    ajR = "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/viola_service/viola_service.js?v_bid=3685&_rij_violaUrl=1";
    jA = new ArrayList();
  }
  
  public static boolean Ee()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    if (localQQAppInterface == null) {}
    while (localQQAppInterface.getApp() == null) {
      return false;
    }
    if ((AppNetConnInfo.isWifiConn()) || ((AppNetConnInfo.isMobileConn()) && (AppNetConnInfo.getMobileInfo() == 3))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean G(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while ((!paramString2.equals(paramString1)) && ((paramString1.indexOf(".") <= 0) || (!paramString2.endsWith("." + paramString1)))) {
      return false;
    }
    return true;
  }
  
  public static boolean J(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      return false;
      if ((ndi.P(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c != null))
      {
        switch ((int)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.longValue())
        {
        case 11: 
        default: 
          return false;
        }
        return true;
      }
    } while ((!ndi.K(paramArticleInfo)) && (!ndi.R(paramArticleInfo)));
    return true;
  }
  
  private String M(String paramString1, String paramString2)
  {
    return auro.decode(paramString1, paramString2);
  }
  
  public static msg a()
  {
    if (a == null) {
      a = new msg();
    }
    return a;
  }
  
  /* Error */
  private void a(String paramString1, msg.a parama, JSONObject paramJSONObject, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 133	kxm:getAppRuntime	()Lmqq/app/AppRuntime;
    //   3: checkcast 135	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 226	org/json/JSONObject
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 229	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore 7
    //   24: aload 7
    //   26: ldc 231
    //   28: invokevirtual 235	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 5
    //   33: aload 5
    //   35: astore_1
    //   36: aload 5
    //   38: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifne +20 -> 61
    //   44: aload 5
    //   46: ldc 243
    //   48: ldc 245
    //   50: invokevirtual 249	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   53: ldc 251
    //   55: ldc 253
    //   57: invokevirtual 249	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   60: astore_1
    //   61: aload_3
    //   62: ldc 231
    //   64: aload_1
    //   65: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   68: pop
    //   69: aload 7
    //   71: ldc_w 259
    //   74: invokevirtual 235	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 5
    //   79: aload 5
    //   81: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: ifeq +20 -> 104
    //   87: aload_2
    //   88: aload_3
    //   89: invokeinterface 263 2 0
    //   94: return
    //   95: astore_1
    //   96: aload_2
    //   97: aload_3
    //   98: invokeinterface 263 2 0
    //   103: return
    //   104: new 265	java/net/URL
    //   107: dup
    //   108: aload 4
    //   110: invokespecial 266	java/net/URL:<init>	(Ljava/lang/String;)V
    //   113: invokevirtual 269	java/net/URL:getHost	()Ljava/lang/String;
    //   116: astore_1
    //   117: aload 7
    //   119: ldc_w 271
    //   122: invokevirtual 235	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 4
    //   127: aload 4
    //   129: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   132: ifne +458 -> 590
    //   135: aload_0
    //   136: aload 4
    //   138: aload_1
    //   139: invokespecial 273	msg:G	(Ljava/lang/String;Ljava/lang/String;)Z
    //   142: ifeq +45 -> 187
    //   145: aload 4
    //   147: astore_1
    //   148: aload_1
    //   149: astore 4
    //   151: aload_1
    //   152: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifeq +8 -> 163
    //   158: ldc_w 275
    //   161: astore 4
    //   163: aload 7
    //   165: ldc_w 277
    //   168: invokevirtual 235	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore_1
    //   172: aload_1
    //   173: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifeq +19 -> 195
    //   179: aload_2
    //   180: aload_3
    //   181: invokeinterface 263 2 0
    //   186: return
    //   187: aload_2
    //   188: aload_3
    //   189: invokeinterface 263 2 0
    //   194: return
    //   195: aload_0
    //   196: aload 4
    //   198: aload 5
    //   200: aload_1
    //   201: invokespecial 281	msg:n	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   204: astore 7
    //   206: aload 7
    //   208: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   211: ifeq +11 -> 222
    //   214: aload_2
    //   215: aload_3
    //   216: invokeinterface 263 2 0
    //   221: return
    //   222: new 283	java/io/File
    //   225: dup
    //   226: new 45	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   233: getstatic 288	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:Vz	Ljava/lang/String;
    //   236: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc_w 290
    //   242: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 6
    //   247: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   250: invokestatic 298	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   253: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc_w 290
    //   259: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 4
    //   264: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc_w 290
    //   270: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 5
    //   275: invokestatic 298	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 290
    //   284: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_1
    //   288: invokestatic 298	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokespecial 299	java/io/File:<init>	(Ljava/lang/String;)V
    //   300: astore 5
    //   302: aload 5
    //   304: invokevirtual 302	java/io/File:exists	()Z
    //   307: ifne +22 -> 329
    //   310: aload_3
    //   311: ldc_w 304
    //   314: ldc_w 306
    //   317: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   320: pop
    //   321: aload_2
    //   322: aload_3
    //   323: invokeinterface 263 2 0
    //   328: return
    //   329: aload_0
    //   330: monitorenter
    //   331: new 308	java/io/FileInputStream
    //   334: dup
    //   335: aload 5
    //   337: invokespecial 311	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   340: astore_1
    //   341: aload_1
    //   342: astore 4
    //   344: aload 5
    //   346: invokevirtual 314	java/io/File:length	()J
    //   349: l2i
    //   350: newarray byte
    //   352: astore 5
    //   354: aload_1
    //   355: astore 4
    //   357: aload_1
    //   358: aload 5
    //   360: invokevirtual 320	java/io/InputStream:read	([B)I
    //   363: pop
    //   364: aload_1
    //   365: astore 4
    //   367: aload_0
    //   368: new 155	java/lang/String
    //   371: dup
    //   372: aload 5
    //   374: invokespecial 323	java/lang/String:<init>	([B)V
    //   377: aload 7
    //   379: invokespecial 325	msg:M	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   382: astore 5
    //   384: aload 5
    //   386: ifnonnull +47 -> 433
    //   389: aload_1
    //   390: astore 4
    //   392: aload_3
    //   393: ldc_w 304
    //   396: ldc_w 327
    //   399: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   402: pop
    //   403: aload_1
    //   404: astore 4
    //   406: aload_2
    //   407: aload_3
    //   408: invokeinterface 263 2 0
    //   413: aload_1
    //   414: astore 4
    //   416: aload_0
    //   417: monitorexit
    //   418: aload_1
    //   419: ifnull +174 -> 593
    //   422: aload_1
    //   423: invokevirtual 330	java/io/InputStream:close	()V
    //   426: return
    //   427: astore_1
    //   428: aload_1
    //   429: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   432: return
    //   433: aload_1
    //   434: astore 4
    //   436: aload_3
    //   437: ldc_w 335
    //   440: aload 5
    //   442: ldc 243
    //   444: ldc 245
    //   446: invokevirtual 249	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   449: ldc 251
    //   451: ldc 253
    //   453: invokevirtual 249	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   456: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   459: pop
    //   460: aload_1
    //   461: astore 4
    //   463: aload_2
    //   464: aload_3
    //   465: invokeinterface 263 2 0
    //   470: aload_1
    //   471: astore 4
    //   473: aload_0
    //   474: monitorexit
    //   475: aload_1
    //   476: ifnull +117 -> 593
    //   479: aload_1
    //   480: invokevirtual 330	java/io/InputStream:close	()V
    //   483: return
    //   484: astore_1
    //   485: aload_1
    //   486: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   489: return
    //   490: astore 5
    //   492: aconst_null
    //   493: astore_1
    //   494: aload_1
    //   495: astore 4
    //   497: aload_0
    //   498: monitorexit
    //   499: aload_1
    //   500: astore 4
    //   502: aload 5
    //   504: athrow
    //   505: astore 4
    //   507: aload_1
    //   508: astore 4
    //   510: aload_3
    //   511: ldc_w 304
    //   514: ldc_w 337
    //   517: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   520: pop
    //   521: aload_1
    //   522: astore 4
    //   524: aload_2
    //   525: aload_3
    //   526: invokeinterface 263 2 0
    //   531: aload_1
    //   532: ifnull +61 -> 593
    //   535: aload_1
    //   536: invokevirtual 330	java/io/InputStream:close	()V
    //   539: return
    //   540: astore_1
    //   541: aload_1
    //   542: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   545: return
    //   546: astore_1
    //   547: aconst_null
    //   548: astore 4
    //   550: aload 4
    //   552: ifnull +8 -> 560
    //   555: aload 4
    //   557: invokevirtual 330	java/io/InputStream:close	()V
    //   560: aload_1
    //   561: athrow
    //   562: astore 4
    //   564: aload 4
    //   566: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   569: goto -9 -> 560
    //   572: astore_1
    //   573: goto -23 -> 550
    //   576: astore_1
    //   577: aconst_null
    //   578: astore_1
    //   579: goto -72 -> 507
    //   582: astore 5
    //   584: aload 4
    //   586: astore_1
    //   587: goto -93 -> 494
    //   590: goto -442 -> 148
    //   593: return
    //   594: astore_1
    //   595: aconst_null
    //   596: astore_1
    //   597: goto -480 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	this	msg
    //   0	600	1	paramString1	String
    //   0	600	2	parama	msg.a
    //   0	600	3	paramJSONObject	JSONObject
    //   0	600	4	paramString2	String
    //   31	410	5	localObject1	Object
    //   490	13	5	localObject2	Object
    //   582	1	5	localObject3	Object
    //   6	240	6	localQQAppInterface	QQAppInterface
    //   22	356	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	95	org/json/JSONException
    //   14	33	95	org/json/JSONException
    //   36	61	95	org/json/JSONException
    //   61	94	95	org/json/JSONException
    //   104	117	95	org/json/JSONException
    //   117	145	95	org/json/JSONException
    //   151	158	95	org/json/JSONException
    //   163	186	95	org/json/JSONException
    //   187	194	95	org/json/JSONException
    //   195	221	95	org/json/JSONException
    //   222	328	95	org/json/JSONException
    //   422	426	95	org/json/JSONException
    //   428	432	95	org/json/JSONException
    //   479	483	95	org/json/JSONException
    //   485	489	95	org/json/JSONException
    //   535	539	95	org/json/JSONException
    //   541	545	95	org/json/JSONException
    //   555	560	95	org/json/JSONException
    //   560	562	95	org/json/JSONException
    //   564	569	95	org/json/JSONException
    //   422	426	427	java/io/IOException
    //   479	483	484	java/io/IOException
    //   331	341	490	finally
    //   502	505	505	java/io/IOException
    //   535	539	540	java/io/IOException
    //   329	331	546	finally
    //   555	560	562	java/io/IOException
    //   502	505	572	finally
    //   510	521	572	finally
    //   524	531	572	finally
    //   329	331	576	java/io/IOException
    //   344	354	582	finally
    //   357	364	582	finally
    //   367	384	582	finally
    //   392	403	582	finally
    //   406	413	582	finally
    //   416	418	582	finally
    //   436	460	582	finally
    //   463	470	582	finally
    //   473	475	582	finally
    //   497	499	582	finally
    //   104	117	594	java/net/MalformedURLException
  }
  
  private void a(String paramString1, JSONObject paramJSONObject, String paramString2, msg.b paramb)
  {
    ThreadManager.post(new ReadInJoyWebDataManager.5(this, paramString1, paramString2, paramb, paramJSONObject), 5, null, true);
  }
  
  /* Error */
  private void a(URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 133	kxm:getAppRuntime	()Lmqq/app/AppRuntime;
    //   3: checkcast 135	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 9
    //   8: aload 9
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 226	org/json/JSONObject
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 229	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore 10
    //   24: aload 10
    //   26: ldc 231
    //   28: invokevirtual 235	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 8
    //   33: aload 8
    //   35: astore 7
    //   37: aload 8
    //   39: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifne +21 -> 63
    //   45: aload 8
    //   47: ldc 243
    //   49: ldc 245
    //   51: invokevirtual 249	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   54: ldc 251
    //   56: ldc 253
    //   58: invokevirtual 249	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   61: astore 7
    //   63: aload 4
    //   65: ldc 231
    //   67: aload 7
    //   69: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   72: pop
    //   73: getstatic 352	msg:rh	J
    //   76: ldc2_w 353
    //   79: lcmp
    //   80: ifle +20 -> 100
    //   83: new 356	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager$3
    //   86: dup
    //   87: aload_0
    //   88: aload_1
    //   89: aload_2
    //   90: aload_3
    //   91: aload 4
    //   93: invokespecial 359	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager$3:<init>	(Lmsg;Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   96: invokestatic 363	com/tencent/mobileqq/app/ThreadManager:executeOnNetWorkThread	(Ljava/lang/Runnable;)V
    //   99: return
    //   100: aload 10
    //   102: ldc_w 259
    //   105: invokevirtual 235	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_3
    //   109: aload_3
    //   110: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne +423 -> 536
    //   116: aload 10
    //   118: ldc_w 277
    //   121: invokevirtual 235	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   124: astore 4
    //   126: aload 4
    //   128: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +405 -> 536
    //   134: aload 10
    //   136: ldc_w 335
    //   139: invokevirtual 235	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   142: astore 7
    //   144: aload 7
    //   146: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +387 -> 536
    //   152: aload_1
    //   153: invokevirtual 269	java/net/URL:getHost	()Ljava/lang/String;
    //   156: astore_1
    //   157: aload 10
    //   159: ldc_w 271
    //   162: invokevirtual 235	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: astore_2
    //   166: aload_2
    //   167: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +363 -> 533
    //   173: aload_0
    //   174: aload_2
    //   175: aload_1
    //   176: invokespecial 273	msg:G	(Ljava/lang/String;Ljava/lang/String;)Z
    //   179: ifeq +357 -> 536
    //   182: aload_2
    //   183: astore_1
    //   184: aload_1
    //   185: astore_2
    //   186: aload_1
    //   187: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   190: ifeq +7 -> 197
    //   193: ldc_w 275
    //   196: astore_2
    //   197: aload_0
    //   198: aload 7
    //   200: invokespecial 366	msg:hash	(Ljava/lang/String;)Ljava/lang/String;
    //   203: astore_1
    //   204: aload_0
    //   205: aload_2
    //   206: aload_3
    //   207: aload 4
    //   209: aload_1
    //   210: invokespecial 370	msg:h	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: aload 7
    //   216: aload_1
    //   217: invokespecial 373	msg:encrypt	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   220: astore 7
    //   222: new 283	java/io/File
    //   225: dup
    //   226: new 45	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   233: getstatic 288	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:Vz	Ljava/lang/String;
    //   236: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc_w 290
    //   242: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 9
    //   247: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   250: invokestatic 298	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   253: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokespecial 299	java/io/File:<init>	(Ljava/lang/String;)V
    //   262: astore_1
    //   263: aload_1
    //   264: invokevirtual 302	java/io/File:exists	()Z
    //   267: ifne +153 -> 420
    //   270: aload_1
    //   271: invokevirtual 376	java/io/File:mkdirs	()Z
    //   274: pop
    //   275: new 283	java/io/File
    //   278: dup
    //   279: aload_1
    //   280: aload_2
    //   281: invokespecial 379	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual 302	java/io/File:exists	()Z
    //   289: ifne +151 -> 440
    //   292: aload_1
    //   293: invokevirtual 376	java/io/File:mkdirs	()Z
    //   296: pop
    //   297: new 283	java/io/File
    //   300: dup
    //   301: aload_1
    //   302: aload_3
    //   303: invokestatic 298	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   306: invokespecial 379	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   309: astore 8
    //   311: aload 8
    //   313: invokevirtual 302	java/io/File:exists	()Z
    //   316: ifne +144 -> 460
    //   319: aload 8
    //   321: invokevirtual 376	java/io/File:mkdirs	()Z
    //   324: pop
    //   325: aconst_null
    //   326: astore_2
    //   327: aconst_null
    //   328: astore_1
    //   329: aconst_null
    //   330: astore_3
    //   331: aload_0
    //   332: monitorenter
    //   333: aload_3
    //   334: astore_2
    //   335: new 283	java/io/File
    //   338: dup
    //   339: aload 8
    //   341: aload 4
    //   343: invokestatic 298	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   346: invokespecial 379	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   349: astore 4
    //   351: aload_3
    //   352: astore_2
    //   353: aload 4
    //   355: invokevirtual 302	java/io/File:exists	()Z
    //   358: ifeq +11 -> 369
    //   361: aload_3
    //   362: astore_2
    //   363: aload 4
    //   365: invokevirtual 382	java/io/File:delete	()Z
    //   368: pop
    //   369: aload_3
    //   370: astore_2
    //   371: new 384	java/io/FileWriter
    //   374: dup
    //   375: aload 4
    //   377: invokespecial 385	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   380: astore_1
    //   381: aload_1
    //   382: aload 7
    //   384: invokevirtual 388	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   387: getstatic 352	msg:rh	J
    //   390: lstore 5
    //   392: aload 4
    //   394: invokevirtual 314	java/io/File:length	()J
    //   397: lload 5
    //   399: ladd
    //   400: putstatic 352	msg:rh	J
    //   403: aload_0
    //   404: monitorexit
    //   405: aload_1
    //   406: ifnull +130 -> 536
    //   409: aload_1
    //   410: invokevirtual 389	java/io/FileWriter:close	()V
    //   413: return
    //   414: astore_1
    //   415: aload_1
    //   416: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   419: return
    //   420: aload_1
    //   421: invokevirtual 392	java/io/File:isFile	()Z
    //   424: ifeq -149 -> 275
    //   427: aload_1
    //   428: invokevirtual 382	java/io/File:delete	()Z
    //   431: pop
    //   432: aload_1
    //   433: invokevirtual 376	java/io/File:mkdirs	()Z
    //   436: pop
    //   437: goto -162 -> 275
    //   440: aload_1
    //   441: invokevirtual 392	java/io/File:isFile	()Z
    //   444: ifeq -147 -> 297
    //   447: aload_1
    //   448: invokevirtual 382	java/io/File:delete	()Z
    //   451: pop
    //   452: aload_1
    //   453: invokevirtual 376	java/io/File:mkdirs	()Z
    //   456: pop
    //   457: goto -160 -> 297
    //   460: aload 8
    //   462: invokevirtual 392	java/io/File:isFile	()Z
    //   465: ifeq -140 -> 325
    //   468: aload 8
    //   470: invokevirtual 382	java/io/File:delete	()Z
    //   473: pop
    //   474: aload 8
    //   476: invokevirtual 376	java/io/File:mkdirs	()Z
    //   479: pop
    //   480: goto -155 -> 325
    //   483: astore_3
    //   484: aload_2
    //   485: astore_1
    //   486: aload_1
    //   487: astore_2
    //   488: aload_0
    //   489: monitorexit
    //   490: aload_1
    //   491: astore_2
    //   492: aload_3
    //   493: athrow
    //   494: astore_1
    //   495: aload_2
    //   496: ifnull +40 -> 536
    //   499: aload_2
    //   500: invokevirtual 389	java/io/FileWriter:close	()V
    //   503: return
    //   504: astore_1
    //   505: aload_1
    //   506: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   509: return
    //   510: astore_2
    //   511: aload_1
    //   512: ifnull +7 -> 519
    //   515: aload_1
    //   516: invokevirtual 389	java/io/FileWriter:close	()V
    //   519: aload_2
    //   520: athrow
    //   521: astore_1
    //   522: aload_1
    //   523: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   526: goto -7 -> 519
    //   529: astore_3
    //   530: goto -44 -> 486
    //   533: goto -349 -> 184
    //   536: return
    //   537: astore_1
    //   538: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	msg
    //   0	539	1	paramURL	URL
    //   0	539	2	paramString1	String
    //   0	539	3	paramString2	String
    //   0	539	4	paramJSONObject	JSONObject
    //   390	8	5	l	long
    //   35	348	7	localObject1	Object
    //   31	444	8	localObject2	Object
    //   6	240	9	localQQAppInterface	QQAppInterface
    //   22	136	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   409	413	414	java/io/IOException
    //   335	351	483	finally
    //   353	361	483	finally
    //   363	369	483	finally
    //   371	381	483	finally
    //   488	490	483	finally
    //   331	333	494	java/io/IOException
    //   492	494	494	java/io/IOException
    //   499	503	504	java/io/IOException
    //   331	333	510	finally
    //   492	494	510	finally
    //   515	519	521	java/io/IOException
    //   381	405	529	finally
    //   0	8	537	org/json/JSONException
    //   14	33	537	org/json/JSONException
    //   37	63	537	org/json/JSONException
    //   63	99	537	org/json/JSONException
    //   100	182	537	org/json/JSONException
    //   186	193	537	org/json/JSONException
    //   197	275	537	org/json/JSONException
    //   275	297	537	org/json/JSONException
    //   297	325	537	org/json/JSONException
    //   409	413	537	org/json/JSONException
    //   415	419	537	org/json/JSONException
    //   420	437	537	org/json/JSONException
    //   440	457	537	org/json/JSONException
    //   460	480	537	org/json/JSONException
    //   499	503	537	org/json/JSONException
    //   505	509	537	org/json/JSONException
    //   515	519	537	org/json/JSONException
    //   519	521	537	org/json/JSONException
    //   522	526	537	org/json/JSONException
  }
  
  public static void aRK()
  {
    for (;;)
    {
      JSONArray localJSONArray;
      synchronized (jA)
      {
        Iterator localIterator = jA.iterator();
        if (QLog.isColorLevel()) {
          QLog.w("ReadInJoyWebDataManager", 2, "addLog :TLogCache size :" + jA.size());
        }
        if (jA.size() <= 0) {
          return;
        }
        try
        {
          localJSONArray = new JSONArray();
          if (!localIterator.hasNext()) {
            break label149;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("postTime", System.currentTimeMillis() / 1000L);
          localJSONObject.put("logContent", localIterator.next());
          localJSONArray.put(localJSONObject);
          continue;
          jA.clear();
        }
        catch (JSONException localJSONException) {}
        return;
      }
      label149:
      nP(localJSONArray.toString());
    }
  }
  
  private void b(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    try
    {
      ThreadManager.post(new ReadInJoyWebDataManager.2(this, new URL(paramString1), paramString2, paramString3, paramJSONObject), 5, null, false);
      return;
    }
    catch (MalformedURLException paramString1) {}
  }
  
  private void bI(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (ajT.equals(paramString1)))
    {
      paramString1 = hash(paramString2);
      if (!paramString1.equals(this.ajP))
      {
        this.ajP = paramString1;
        this.ajQ = paramString2;
      }
    }
  }
  
  private static long bZ()
  {
    Object localObject = new File(PublicAccountJavascriptInterface.Vz);
    if (!((File)localObject).exists()) {
      return 0L;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    long l = 0L;
    while (!localArrayList.isEmpty())
    {
      localObject = (File)localArrayList.remove(0);
      if (((File)localObject).isFile())
      {
        l = ((File)localObject).length() + l;
      }
      else
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localArrayList.add(localObject[i]);
            i += 1;
          }
        }
      }
    }
    return l;
  }
  
  public static String ej(String paramString)
  {
    long l = 5381L;
    int i = 0;
    while (i < paramString.length())
    {
      l += (l << 5 & 0x7FFFFFFF) + paramString.charAt(i);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "getCSRFToken " + (l & 0x7FFFFFFF));
    }
    return String.valueOf(l & 0x7FFFFFFF);
  }
  
  private String encrypt(String paramString1, String paramString2)
  {
    return auro.encode(paramString1, paramString2);
  }
  
  private void h(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getAccount()).createEntityManager();
    CouponH5Data localCouponH5Data = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (localCouponH5Data == null) {
      ((EntityManager)localObject).persist(new CouponH5Data(paramString1, paramString2, paramString3, paramString4));
    }
    for (;;)
    {
      ((EntityManager)localObject).close();
      return;
      localCouponH5Data.mData = paramString4;
      ((EntityManager)localObject).update(localCouponH5Data);
    }
  }
  
  private String hash(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = aqhs.bytes2HexStr(localMessageDigest.digest());
      localMessageDigest.reset();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      return "wronghash";
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label33:
      break label33;
    }
  }
  
  private String kq()
  {
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    if (localObject == null) {
      return "";
    }
    TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject).getManager(2);
    if (localTicketManager == null) {
      return "";
    }
    localObject = localTicketManager.getSkey(((QQAppInterface)localObject).getCurrentAccountUin());
    long l = 5381L;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    int i = 0;
    while (i < ((String)localObject).length())
    {
      l += (l << 5 & 0x7FFFFFFF) + ((String)localObject).charAt(i);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "getCSRFToken " + (l & 0x7FFFFFFF));
    }
    return String.valueOf(l & 0x7FFFFFFF);
  }
  
  private String n(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    if (localObject == null) {
      return null;
    }
    localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    ((EntityManager)localObject).close();
    if (paramString1 != null) {}
    for (paramString1 = paramString1.mData;; paramString1 = null) {
      return paramString1;
    }
  }
  
  public static void nP(String paramString)
  {
    AppRuntime localAppRuntime = kxm.getAppRuntime();
    if (localAppRuntime == null) {
      return;
    }
    ThreadManager.post(new ReadInJoyWebDataManager.6(localAppRuntime, paramString), 5, null, true);
  }
  
  public boolean Ed()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    if (localQQAppInterface == null) {
      return false;
    }
    if ((Ee()) && (awit.O(localQQAppInterface))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void H(String paramString1, String paramString2, String paramString3)
  {
    kbp.a(null, "", "0X8008220", "0X8008220", 0, 0, paramString1, paramString2, paramString3, "", false);
  }
  
  /* Error */
  public void a(ArticleInfo paramArticleInfo, boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokestatic 624	msg:J	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   14: ifne +10 -> 24
    //   17: aload_0
    //   18: ldc 115
    //   20: putfield 121	msg:ajO	Ljava/lang/String;
    //   23: return
    //   24: new 226	org/json/JSONObject
    //   27: dup
    //   28: invokespecial 441	org/json/JSONObject:<init>	()V
    //   31: astore 8
    //   33: aload_1
    //   34: getfield 627	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   37: istore 4
    //   39: aload_1
    //   40: invokestatic 175	ndi:P	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   43: invokestatic 632	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   46: astore 9
    //   48: aload_1
    //   49: invokestatic 201	ndi:K	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   52: ifne +1516 -> 1568
    //   55: aload_1
    //   56: invokestatic 204	ndi:R	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   59: ifeq +813 -> 872
    //   62: goto +1506 -> 1568
    //   65: iload 7
    //   67: invokestatic 632	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: astore 10
    //   72: aload 10
    //   74: invokevirtual 635	java/lang/Boolean:booleanValue	()Z
    //   77: ifne +17 -> 94
    //   80: aload 9
    //   82: invokevirtual 635	java/lang/Boolean:booleanValue	()Z
    //   85: ifne +9 -> 94
    //   88: aload_0
    //   89: ldc 115
    //   91: putfield 121	msg:ajO	Ljava/lang/String;
    //   94: aload_3
    //   95: invokestatic 641	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   98: ldc_w 643
    //   101: invokevirtual 646	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_3
    //   105: aload_3
    //   106: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: istore 7
    //   111: iload 7
    //   113: ifne +52 -> 165
    //   116: new 155	java/lang/String
    //   119: dup
    //   120: aload_3
    //   121: iconst_0
    //   122: invokestatic 651	aqgo:decode	(Ljava/lang/String;I)[B
    //   125: invokespecial 323	java/lang/String:<init>	([B)V
    //   128: astore_3
    //   129: aload_3
    //   130: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne +32 -> 165
    //   136: aload 8
    //   138: ldc_w 653
    //   141: new 45	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 655
    //   151: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_3
    //   155: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: iload_2
    //   166: ifeq +712 -> 878
    //   169: aload_1
    //   170: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   173: ifnull +705 -> 878
    //   176: aload_1
    //   177: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   180: getfield 186	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$c;
    //   183: ifnull +695 -> 878
    //   186: aload 8
    //   188: ldc_w 657
    //   191: aload_1
    //   192: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   195: getfield 186	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$c;
    //   198: getfield 660	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$c:y	Ljava/lang/Long;
    //   201: invokestatic 663	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   204: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 8
    //   210: ldc_w 665
    //   213: aload_1
    //   214: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   217: getfield 186	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$c;
    //   220: getfield 192	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$c:z	Ljava/lang/Long;
    //   223: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   226: pop
    //   227: aload 8
    //   229: ldc_w 667
    //   232: aload_1
    //   233: getfield 670	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeID	Ljava/lang/String;
    //   236: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   239: pop
    //   240: aload 8
    //   242: ldc_w 672
    //   245: aload_1
    //   246: getfield 675	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   249: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   252: pop
    //   253: aload 8
    //   255: ldc_w 677
    //   258: aload_1
    //   259: getfield 670	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeID	Ljava/lang/String;
    //   262: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: invokevirtual 680	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 8
    //   271: ldc_w 682
    //   274: ldc 115
    //   276: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload 8
    //   282: ldc_w 684
    //   285: aload_1
    //   286: getfield 687	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mArticleID	J
    //   289: invokevirtual 453	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload 8
    //   295: ldc_w 689
    //   298: aload_1
    //   299: getfield 692	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mArticleContentUrl	Ljava/lang/String;
    //   302: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   305: pop
    //   306: aload 8
    //   308: ldc_w 694
    //   311: aload_1
    //   312: getfield 697	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   315: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   318: pop
    //   319: aload 8
    //   321: ldc_w 699
    //   324: aload_1
    //   325: getfield 702	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   328: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   331: pop
    //   332: aload 8
    //   334: ldc_w 704
    //   337: aload_1
    //   338: getfield 707	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTime	J
    //   341: invokestatic 712	kxl:ap	(J)Ljava/lang/String;
    //   344: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   347: pop
    //   348: aload_1
    //   349: getfield 716	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSinglePicture	Ljava/net/URL;
    //   352: ifnull +556 -> 908
    //   355: aload_1
    //   356: getfield 716	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSinglePicture	Ljava/net/URL;
    //   359: invokevirtual 719	java/net/URL:getFile	()Ljava/lang/String;
    //   362: astore_3
    //   363: aload 8
    //   365: ldc_w 721
    //   368: aload_3
    //   369: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   372: pop
    //   373: aload_1
    //   374: getfield 725	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mShowBigPicture	Z
    //   377: ifeq +1197 -> 1574
    //   380: iconst_2
    //   381: istore 4
    //   383: aload 8
    //   385: ldc_w 727
    //   388: iload 4
    //   390: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload_1
    //   395: ifnull +59 -> 454
    //   398: aload_1
    //   399: invokestatic 734	kxm:j	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   402: ifeq +52 -> 454
    //   405: aload 8
    //   407: ldc_w 736
    //   410: iconst_1
    //   411: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   414: pop
    //   415: aload_1
    //   416: getfield 739	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   419: ifnull +19 -> 438
    //   422: aload 8
    //   424: ldc_w 721
    //   427: aload_1
    //   428: getfield 739	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   431: invokevirtual 740	java/net/URL:toString	()Ljava/lang/String;
    //   434: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   437: pop
    //   438: aload 8
    //   440: ldc_w 742
    //   443: aload_1
    //   444: getfield 745	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoDuration	I
    //   447: invokestatic 751	mde:ba	(I)Ljava/lang/String;
    //   450: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   453: pop
    //   454: iload_2
    //   455: ifne +620 -> 1075
    //   458: aload 9
    //   460: invokevirtual 635	java/lang/Boolean:booleanValue	()Z
    //   463: ifeq +612 -> 1075
    //   466: aload_1
    //   467: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   470: ifnull +605 -> 1075
    //   473: aload_1
    //   474: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   477: getfield 754	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$e;
    //   480: ifnull +43 -> 523
    //   483: aload 10
    //   485: invokevirtual 635	java/lang/Boolean:booleanValue	()Z
    //   488: ifeq +428 -> 916
    //   491: iload 6
    //   493: istore 4
    //   495: aload_1
    //   496: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   499: getfield 754	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$e;
    //   502: getfield 759	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$e:type	I
    //   505: iconst_1
    //   506: if_icmpne +6 -> 512
    //   509: iconst_1
    //   510: istore 4
    //   512: aload 8
    //   514: ldc_w 682
    //   517: iload 4
    //   519: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   522: pop
    //   523: aload 9
    //   525: invokevirtual 635	java/lang/Boolean:booleanValue	()Z
    //   528: ifeq +547 -> 1075
    //   531: aload_1
    //   532: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   535: getfield 186	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$c;
    //   538: ifnull +537 -> 1075
    //   541: aload 8
    //   543: ldc_w 761
    //   546: aload_1
    //   547: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   550: getfield 186	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$c;
    //   553: getfield 660	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$c:y	Ljava/lang/Long;
    //   556: invokestatic 663	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   559: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   562: pop
    //   563: aload 8
    //   565: ldc_w 763
    //   568: aload_1
    //   569: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   572: getfield 186	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$c;
    //   575: getfield 192	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$c:z	Ljava/lang/Long;
    //   578: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   581: pop
    //   582: new 434	org/json/JSONArray
    //   585: dup
    //   586: invokespecial 435	org/json/JSONArray:<init>	()V
    //   589: astore_3
    //   590: aload_1
    //   591: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   594: getfield 186	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$c;
    //   597: getfield 766	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$c:iT	Ljava/util/List;
    //   600: invokeinterface 413 1 0
    //   605: astore 9
    //   607: aload 9
    //   609: invokeinterface 440 1 0
    //   614: ifeq +451 -> 1065
    //   617: aload 9
    //   619: invokeinterface 459 1 0
    //   624: checkcast 768	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   627: astore 10
    //   629: new 226	org/json/JSONObject
    //   632: dup
    //   633: invokespecial 441	org/json/JSONObject:<init>	()V
    //   636: astore 11
    //   638: aload 11
    //   640: ldc_w 770
    //   643: aload 10
    //   645: getfield 773	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:x	Ljava/lang/Long;
    //   648: invokestatic 663	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   651: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   654: pop
    //   655: aload 11
    //   657: ldc_w 775
    //   660: aload 10
    //   662: getfield 778	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:aLh	I
    //   665: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   668: pop
    //   669: aload 11
    //   671: ldc_w 780
    //   674: new 155	java/lang/String
    //   677: dup
    //   678: aload 10
    //   680: getfield 783	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:i	Ljava/lang/Long;
    //   683: invokevirtual 198	java/lang/Long:longValue	()J
    //   686: invokestatic 785	java/lang/Long:toString	(J)Ljava/lang/String;
    //   689: invokevirtual 787	java/lang/String:getBytes	()[B
    //   692: iconst_0
    //   693: invokestatic 790	aqgo:encode	([BI)[B
    //   696: invokespecial 323	java/lang/String:<init>	([B)V
    //   699: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   702: pop
    //   703: aload 11
    //   705: ldc_w 792
    //   708: ldc 115
    //   710: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload 11
    //   716: ldc_w 794
    //   719: ldc 115
    //   721: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   724: pop
    //   725: invokestatic 133	kxm:getAppRuntime	()Lmqq/app/AppRuntime;
    //   728: ifnull +48 -> 776
    //   731: invokestatic 133	kxm:getAppRuntime	()Lmqq/app/AppRuntime;
    //   734: checkcast 135	com/tencent/mobileqq/app/QQAppInterface
    //   737: aload 10
    //   739: getfield 783	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:i	Ljava/lang/Long;
    //   742: invokevirtual 198	java/lang/Long:longValue	()J
    //   745: invokestatic 785	java/lang/Long:toString	(J)Ljava/lang/String;
    //   748: iconst_1
    //   749: invokestatic 799	aqgv:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   752: astore 12
    //   754: aload 11
    //   756: ldc_w 792
    //   759: aload 12
    //   761: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   764: pop
    //   765: aload 11
    //   767: ldc_w 794
    //   770: aload 12
    //   772: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   775: pop
    //   776: aload 11
    //   778: ldc_w 801
    //   781: aload 10
    //   783: getfield 804	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:ahj	Ljava/lang/String;
    //   786: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   789: pop
    //   790: aload 11
    //   792: ldc_w 806
    //   795: aload 10
    //   797: getfield 809	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:aRW	I
    //   800: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   803: pop
    //   804: aload 11
    //   806: ldc_w 811
    //   809: aload 10
    //   811: getfield 814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:aSO	I
    //   814: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   817: pop
    //   818: aload_3
    //   819: aload 11
    //   821: invokevirtual 462	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   824: pop
    //   825: goto -218 -> 607
    //   828: astore_1
    //   829: aload_0
    //   830: ldc 115
    //   832: putfield 121	msg:ajO	Ljava/lang/String;
    //   835: invokestatic 418	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   838: ifeq -815 -> 23
    //   841: ldc_w 420
    //   844: iconst_2
    //   845: new 45	java/lang/StringBuilder
    //   848: dup
    //   849: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   852: ldc_w 816
    //   855: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: aload_1
    //   859: invokevirtual 817	org/json/JSONException:toString	()Ljava/lang/String;
    //   862: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokestatic 820	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   871: return
    //   872: iconst_0
    //   873: istore 7
    //   875: goto -810 -> 65
    //   878: aload 8
    //   880: ldc_w 657
    //   883: aload_1
    //   884: getfield 823	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedId	J
    //   887: invokestatic 513	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   890: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   893: pop
    //   894: aload 8
    //   896: ldc_w 665
    //   899: iload 4
    //   901: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   904: pop
    //   905: goto -678 -> 227
    //   908: aload_1
    //   909: getfield 826	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   912: astore_3
    //   913: goto -550 -> 363
    //   916: aload 9
    //   918: invokevirtual 635	java/lang/Boolean:booleanValue	()Z
    //   921: ifeq -398 -> 523
    //   924: aload_1
    //   925: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   928: getfield 754	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$e;
    //   931: getfield 828	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$e:uin	J
    //   934: invokestatic 831	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   937: astore_3
    //   938: aload 8
    //   940: ldc_w 643
    //   943: new 155	java/lang/String
    //   946: dup
    //   947: aload_3
    //   948: invokevirtual 198	java/lang/Long:longValue	()J
    //   951: invokestatic 785	java/lang/Long:toString	(J)Ljava/lang/String;
    //   954: invokevirtual 787	java/lang/String:getBytes	()[B
    //   957: iconst_0
    //   958: invokestatic 790	aqgo:encode	([BI)[B
    //   961: invokespecial 323	java/lang/String:<init>	([B)V
    //   964: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   967: pop
    //   968: aload 8
    //   970: ldc_w 833
    //   973: ldc 115
    //   975: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   978: pop
    //   979: aload 8
    //   981: ldc_w 835
    //   984: ldc 115
    //   986: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   989: pop
    //   990: invokestatic 133	kxm:getAppRuntime	()Lmqq/app/AppRuntime;
    //   993: ifnull +41 -> 1034
    //   996: invokestatic 133	kxm:getAppRuntime	()Lmqq/app/AppRuntime;
    //   999: checkcast 135	com/tencent/mobileqq/app/QQAppInterface
    //   1002: aload_3
    //   1003: invokevirtual 198	java/lang/Long:longValue	()J
    //   1006: invokestatic 785	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1009: iconst_1
    //   1010: invokestatic 799	aqgv:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   1013: astore_3
    //   1014: aload 8
    //   1016: ldc_w 833
    //   1019: aload_3
    //   1020: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1023: pop
    //   1024: aload 8
    //   1026: ldc_w 835
    //   1029: aload_3
    //   1030: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1033: pop
    //   1034: aload_1
    //   1035: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1038: getfield 754	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$e;
    //   1041: getfield 759	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$e:type	I
    //   1044: iconst_1
    //   1045: if_icmpne +535 -> 1580
    //   1048: iconst_1
    //   1049: istore 4
    //   1051: aload 8
    //   1053: ldc_w 837
    //   1056: iload 4
    //   1058: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1061: pop
    //   1062: goto -539 -> 523
    //   1065: aload 8
    //   1067: ldc_w 839
    //   1070: aload_3
    //   1071: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1074: pop
    //   1075: aload_1
    //   1076: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1079: ifnull +95 -> 1174
    //   1082: aload 8
    //   1084: ldc_w 704
    //   1087: aload_1
    //   1088: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1091: getfield 840	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:aRW	I
    //   1094: i2l
    //   1095: iconst_1
    //   1096: invokestatic 844	kxl:c	(JZ)Ljava/lang/String;
    //   1099: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1102: pop
    //   1103: aload_1
    //   1104: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1107: getfield 847	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:aSG	I
    //   1110: istore 6
    //   1112: iload 6
    //   1114: tableswitch	default:+472 -> 1586, 1:+492->1606, 2:+492->1606, 3:+50->1164, 4:+50->1164, 5:+475->1589, 6:+475->1589, 7:+50->1164, 8:+50->1164, 9:+210->1324
    //   1165: iconst_5
    //   1166: ldc_w 727
    //   1169: iconst_1
    //   1170: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1173: pop
    //   1174: invokestatic 418	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1177: ifeq +34 -> 1211
    //   1180: ldc_w 420
    //   1183: iconst_2
    //   1184: new 45	java/lang/StringBuilder
    //   1187: dup
    //   1188: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1191: ldc_w 849
    //   1194: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: aload 8
    //   1199: invokevirtual 850	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1202: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokestatic 820	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1211: aload_0
    //   1212: aload 8
    //   1214: invokevirtual 850	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1217: putfield 121	msg:ajO	Ljava/lang/String;
    //   1220: aload_0
    //   1221: aload 8
    //   1223: ldc_w 657
    //   1226: invokevirtual 853	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1229: invokestatic 856	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1232: invokevirtual 198	java/lang/Long:longValue	()J
    //   1235: putfield 858	msg:wz	J
    //   1238: return
    //   1239: aload 8
    //   1241: ldc_w 727
    //   1244: iload 4
    //   1246: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1249: pop
    //   1250: aload 8
    //   1252: ldc_w 736
    //   1255: iconst_1
    //   1256: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1259: pop
    //   1260: aload_1
    //   1261: getfield 739	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   1264: ifnull +27 -> 1291
    //   1267: aload 8
    //   1269: ldc_w 721
    //   1272: aload_1
    //   1273: getfield 739	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   1276: invokevirtual 740	java/net/URL:toString	()Ljava/lang/String;
    //   1279: ldc_w 860
    //   1282: ldc 115
    //   1284: invokevirtual 249	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1287: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1290: pop
    //   1291: aload 8
    //   1293: ldc_w 742
    //   1296: aload_1
    //   1297: getfield 745	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoDuration	I
    //   1300: invokestatic 751	mde:ba	(I)Ljava/lang/String;
    //   1303: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1306: pop
    //   1307: goto -133 -> 1174
    //   1310: aload 8
    //   1312: ldc_w 727
    //   1315: iload 4
    //   1317: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1320: pop
    //   1321: goto -147 -> 1174
    //   1324: aload 8
    //   1326: ldc_w 862
    //   1329: iconst_1
    //   1330: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1333: pop
    //   1334: aload_1
    //   1335: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1338: getfield 865	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$m;
    //   1341: ifnull -167 -> 1174
    //   1344: aload_1
    //   1345: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1348: getfield 865	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$m;
    //   1351: getfield 871	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$m:kY	Ljava/util/ArrayList;
    //   1354: ifnull -180 -> 1174
    //   1357: aload_1
    //   1358: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1361: getfield 865	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$m;
    //   1364: getfield 871	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$m:kY	Ljava/util/ArrayList;
    //   1367: invokevirtual 872	java/util/ArrayList:size	()I
    //   1370: ifle -196 -> 1174
    //   1373: aload_1
    //   1374: getfield 181	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1377: getfield 865	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$m;
    //   1380: getfield 871	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$m:kY	Ljava/util/ArrayList;
    //   1383: astore_1
    //   1384: new 434	org/json/JSONArray
    //   1387: dup
    //   1388: invokespecial 435	org/json/JSONArray:<init>	()V
    //   1391: astore_3
    //   1392: aload_1
    //   1393: invokeinterface 413 1 0
    //   1398: astore 9
    //   1400: aload 9
    //   1402: invokeinterface 440 1 0
    //   1407: ifeq +144 -> 1551
    //   1410: aload 9
    //   1412: invokeinterface 459 1 0
    //   1417: checkcast 874	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$n
    //   1420: astore 10
    //   1422: aload 10
    //   1424: getfield 877	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$n:pic_url	Ljava/lang/String;
    //   1427: ifnonnull +11 -> 1438
    //   1430: aload 10
    //   1432: getfield 880	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$n:aii	Ljava/lang/String;
    //   1435: ifnull -35 -> 1400
    //   1438: new 226	org/json/JSONObject
    //   1441: dup
    //   1442: invokespecial 441	org/json/JSONObject:<init>	()V
    //   1445: astore 11
    //   1447: aload 10
    //   1449: getfield 877	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$n:pic_url	Ljava/lang/String;
    //   1452: ifnull +81 -> 1533
    //   1455: aload 10
    //   1457: getfield 877	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$n:pic_url	Ljava/lang/String;
    //   1460: astore_1
    //   1461: aload 11
    //   1463: ldc_w 882
    //   1466: aload_1
    //   1467: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1470: pop
    //   1471: aload 10
    //   1473: getfield 880	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$n:aii	Ljava/lang/String;
    //   1476: ifnull +66 -> 1542
    //   1479: aload 10
    //   1481: getfield 880	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$n:aii	Ljava/lang/String;
    //   1484: astore_1
    //   1485: aload 11
    //   1487: ldc_w 884
    //   1490: aload_1
    //   1491: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1494: pop
    //   1495: aload 11
    //   1497: ldc_w 886
    //   1500: aload 10
    //   1502: getfield 888	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$n:pic_width	I
    //   1505: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1508: pop
    //   1509: aload 11
    //   1511: ldc_w 886
    //   1514: aload 10
    //   1516: getfield 888	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$n:pic_width	I
    //   1519: invokevirtual 730	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1522: pop
    //   1523: aload_3
    //   1524: aload 11
    //   1526: invokevirtual 462	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1529: pop
    //   1530: goto -130 -> 1400
    //   1533: aload 10
    //   1535: getfield 880	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$n:aii	Ljava/lang/String;
    //   1538: astore_1
    //   1539: goto -78 -> 1461
    //   1542: aload 10
    //   1544: getfield 877	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$n:pic_url	Ljava/lang/String;
    //   1547: astore_1
    //   1548: goto -63 -> 1485
    //   1551: aload 8
    //   1553: ldc_w 890
    //   1556: aload_3
    //   1557: invokevirtual 257	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1560: pop
    //   1561: goto -387 -> 1174
    //   1564: astore_3
    //   1565: goto -1400 -> 165
    //   1568: iconst_1
    //   1569: istore 7
    //   1571: goto -1506 -> 65
    //   1574: iconst_1
    //   1575: istore 4
    //   1577: goto -1194 -> 383
    //   1580: iconst_0
    //   1581: istore 4
    //   1583: goto -532 -> 1051
    //   1586: goto -422 -> 1164
    //   1589: iload 5
    //   1591: istore 4
    //   1593: iload 6
    //   1595: bipush 6
    //   1597: if_icmpne -358 -> 1239
    //   1600: iconst_2
    //   1601: istore 4
    //   1603: goto -364 -> 1239
    //   1606: iload 6
    //   1608: iconst_2
    //   1609: if_icmpne +9 -> 1618
    //   1612: iconst_2
    //   1613: istore 4
    //   1615: goto -305 -> 1310
    //   1618: iconst_1
    //   1619: istore 4
    //   1621: goto -311 -> 1310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1624	0	this	msg
    //   0	1624	1	paramArticleInfo	ArticleInfo
    //   0	1624	2	paramBoolean	boolean
    //   0	1624	3	paramString	String
    //   37	1583	4	i	int
    //   4	1586	5	j	int
    //   1	1609	6	k	int
    //   65	1505	7	bool	boolean
    //   31	1521	8	localJSONObject1	JSONObject
    //   46	1365	9	localObject1	Object
    //   70	1473	10	localObject2	Object
    //   636	889	11	localJSONObject2	JSONObject
    //   752	19	12	str	String
    // Exception table:
    //   from	to	target	type
    //   24	62	828	org/json/JSONException
    //   65	94	828	org/json/JSONException
    //   94	111	828	org/json/JSONException
    //   116	165	828	org/json/JSONException
    //   169	227	828	org/json/JSONException
    //   227	363	828	org/json/JSONException
    //   363	380	828	org/json/JSONException
    //   383	394	828	org/json/JSONException
    //   398	438	828	org/json/JSONException
    //   438	454	828	org/json/JSONException
    //   458	491	828	org/json/JSONException
    //   495	509	828	org/json/JSONException
    //   512	523	828	org/json/JSONException
    //   523	607	828	org/json/JSONException
    //   607	776	828	org/json/JSONException
    //   776	825	828	org/json/JSONException
    //   878	905	828	org/json/JSONException
    //   908	913	828	org/json/JSONException
    //   916	1034	828	org/json/JSONException
    //   1034	1048	828	org/json/JSONException
    //   1051	1062	828	org/json/JSONException
    //   1065	1075	828	org/json/JSONException
    //   1075	1112	828	org/json/JSONException
    //   1164	1174	828	org/json/JSONException
    //   1174	1211	828	org/json/JSONException
    //   1211	1238	828	org/json/JSONException
    //   1239	1291	828	org/json/JSONException
    //   1291	1307	828	org/json/JSONException
    //   1310	1321	828	org/json/JSONException
    //   1324	1400	828	org/json/JSONException
    //   1400	1438	828	org/json/JSONException
    //   1438	1461	828	org/json/JSONException
    //   1461	1485	828	org/json/JSONException
    //   1485	1530	828	org/json/JSONException
    //   1533	1539	828	org/json/JSONException
    //   1542	1548	828	org/json/JSONException
    //   1551	1561	828	org/json/JSONException
    //   116	165	1564	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new ReadInJoyWebDataManager.1(this, paramString1, paramString2, paramString3, paramJSONObject));
      return;
    }
    b(paramString1, paramString2, paramString3, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, msg.a parama)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    new Thread(new ReadInJoyWebDataManager.4(this, paramString2, parama, localJSONObject, paramString1)).start();
  }
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, msg.b paramb, Boolean paramBoolean)
  {
    if (this.ef != null) {
      if ((this.ef.containsKey(paramString2)) && (System.currentTimeMillis() - ((Long)this.ef.get(paramString2)).longValue() < 1800000L)) {
        H(paramString3, ajX, aka);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        H(paramString3, ajW, "");
        if (!paramBoolean.booleanValue()) {
          this.ef.put(paramString2, Long.valueOf(System.currentTimeMillis()));
        }
        if (paramString2.indexOf("?") != -1) {}
        for (paramString2 = paramString2 + "&g_tk=" + kq(); "get".equals(paramString1); paramString2 = paramString2 + "?g_tk=" + kq())
        {
          a(paramString2, paramJSONObject, paramString3, paramb);
          return;
        }
      }
    }
    QLog.w("ReadInJoyWebDataManager", 2, "httpFetchAsync mCgiLoadedMap cause mCgiLoadedMap is null ");
  }
  
  public void aN(String paramString, int paramInt)
  {
    boolean bool = true;
    if (!dW(ajT)) {
      return;
    }
    msj localmsj = null;
    for (;;)
    {
      try
      {
        String str = Integer.toString(paramInt);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("callid", "0");
        localJSONObject.put("host", "kandian.qq.com");
        localJSONObject.put("path", "kandian_messagebox");
        localJSONObject.put("key", "kandian_messagebox_data_key2_isNew_" + str + "_" + paramString);
        str = "https://kandian.qq.com/qz_kandian_social/kandian_ext/getMessageBox?readTimestamp=0&pageNo=1&pageSize=20&isBiuLevel=1&isNew=" + str;
        paramString = str;
        if (paramInt == 1)
        {
          localmsj = new msj(this);
          paramString = str + "&ispreload=1";
        }
        str = ajT;
        if (paramInt == 1)
        {
          a("get", paramString, localJSONObject, str, localmsj, Boolean.valueOf(bool));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("ReadInJoyWebDataManager", 2, "preloadWebDataMessageBox:isNew " + paramInt);
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      bool = false;
    }
  }
  
  public void b(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3)
  {
    a(paramString1, paramString2, paramJSONObject, paramString3, null, Boolean.valueOf(false));
  }
  
  public void bH(String paramString1, String paramString2)
  {
    kbp.a(null, "", "0X8008221", "0X8008221", 0, 0, paramString1, paramString2, "", "", false);
  }
  
  public boolean dW(String paramString)
  {
    if (!Ed())
    {
      if (!Ee()) {
        H(paramString, ajX, ajY);
      }
      for (;;)
      {
        return false;
        H(paramString, ajX, ajZ);
      }
    }
    return true;
  }
  
  public void destroy()
  {
    this.ajO = "";
    this.ajM = "";
    if (this.ef != null) {
      this.ef.clear();
    }
    if (this.b != null)
    {
      this.b.onActivityDestroy();
      this.b = null;
    }
  }
  
  public void k(String paramString, JSONObject paramJSONObject)
  {
    if ((BaseApplication.getContext() == null) || (!kzs.Bo())) {}
    do
    {
      do
      {
        return;
      } while ((this.ef == null) || ((this.ef.containsKey(paramString)) && (System.currentTimeMillis() - ((Long)this.ef.get(paramString)).longValue() < 1800000L)));
      if (this.b == null)
      {
        this.b = new ViolaBaseView(BaseApplication.getContext());
        this.b.a(ajR, null, new ViolaBaseView.d(ajR, new JSONObject(), null));
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("url", paramString);
        localJSONObject.put("param", paramJSONObject);
        paramJSONObject = new JSONObject();
        paramJSONObject.put("preloadViola", localJSONObject);
        this.b.updateInstance(paramJSONObject.toString());
        this.ef.put(paramString, Long.valueOf(System.currentTimeMillis()));
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.w("ReadInJoyWebDataManager", 2, "preLoadComCgi e " + paramString.getMessage());
  }
  
  public String kr()
  {
    return this.ajM;
  }
  
  public String ks()
  {
    return this.ajO;
  }
  
  public void nQ(String paramString)
  {
    k(paramString, null);
  }
  
  public void nR(String paramString)
  {
    if (!dW(ajS)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("callid", "0");
      localJSONObject.put("host", "kandian.qq.com");
      localJSONObject.put("path", "kandian_homepage");
      localJSONObject.put("key", "kandian_homepage2_data_key_" + paramString);
      b("get", "https://kandian.qq.com/qz_kandian_social/kandian_ext/getPersonPage?pageNo=1&pageSize=20&is715=1&uin=" + paramString, localJSONObject, ajS);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static abstract interface a
  {
    public abstract void ac(JSONObject paramJSONObject);
  }
  
  public static abstract interface b
  {
    public abstract void aa(JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msg
 * JD-Core Version:    0.7.0.1
 */