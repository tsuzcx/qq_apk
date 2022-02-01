import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig.1;
import com.tencent.biz.AuthorizeConfig.2;
import com.tencent.biz.AuthorizeConfig.4;
import com.tencent.biz.AuthorizeConfig.5;
import com.tencent.biz.AuthorizeConfig.6;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.webview.utils.WebViewConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Set<Ljava.lang.String;>;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jml
{
  protected static final ArrayMap<String, String> a;
  protected static jml a;
  private static final Object aB = new Object();
  private static final Object aC = new Object();
  public static final String[] aW = { "skey", "pskey", "a1", "a2", "ptlogin2", "pt4_token" };
  public static final AtomicBoolean aj;
  protected static final JSONArray i;
  public static volatile long qk;
  private static long qn;
  private static long qo;
  public static volatile long sLastUpdateTime;
  public volatile JSONObject A;
  public volatile JSONObject B;
  public volatile JSONObject C;
  protected volatile JSONObject D;
  protected volatile JSONObject E;
  protected volatile JSONObject F;
  protected volatile JSONObject G;
  public volatile JSONObject H;
  public final AtomicInteger I;
  public volatile JSONObject I;
  private final String Te = "faceUnblockCamera.startPTVActivity";
  private final String Tf = "https://mysec.qq.com/v2/account_control/index.html";
  private final String Tg = "qbizApi.getClientInfo";
  public joo a;
  public jop a;
  public WtTicketPromise a;
  protected volatile int aBH = -1;
  public final ConcurrentHashMap<String, JSONArray> aO = new ConcurrentHashMap(aW.length);
  public final ConcurrentHashMap<String, Set<String>> aP = new ConcurrentHashMap(aW.length);
  private boolean aaz;
  protected volatile JSONArray j;
  private ArrayList<String> jg = new ArrayList();
  protected volatile JSONArray k;
  public final Context mContext;
  public final SharedPreferences mPref;
  protected volatile JSONArray n;
  protected volatile JSONArray p;
  protected volatile long ql;
  protected volatile long qm = -1L;
  protected volatile JSONArray r;
  public volatile JSONArray s;
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(aW.length);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("skey", "[\"*.qq.com\",\"*.tenpay.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("pskey", "[\"game.qq.com\",\"kg.qq.com\",\"id.qq.com\",\"qzone.qq.com\",\"qzone.com\",\"openmobile.qq.com\", \"tenpay.com\", \"buluo.qq.com\", \"docs.qq.com\"],\"ti.qq.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("a1", "[]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("a2", "[\"aq.qq.com\",\"weloan.tenpay.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("ptlogin2", "[\"http://ptlogin2.qq.com\",\"https://ssl.ptlogin2.qq.com\", \"https://ptlogin2.qq.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("pt4_token", "[\"gamecenter.qq.com\",\"imgcache.qq.com\",\"vip.qq.com\",\"haoma.qq.com\"]");
    i = new JSONArray();
    i.put("com.tencent.qqcomic.aiogift");
    i.put("com.tencent.gamecenter.hebao");
    i.put("com.tencent.gamecenter.hebao2020");
    qk = -1L;
    sLastUpdateTime = -1L;
    aj = new AtomicBoolean(false);
  }
  
  private jml(Context paramContext)
  {
    this.jdField_I_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_OicqWlogin_sdkRequestWtTicketPromise = new jmn(this);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 2, "AuthorizeConfig init");
    }
    this.mContext = paramContext;
    this.mPref = this.mContext.getSharedPreferences("domainCmdRight", 4);
    this.jdField_a_of_type_Joo = new joo(this.mPref);
    this.jdField_a_of_type_Jop = new jop(this.mPref, this.jdField_a_of_type_Joo);
    this.jdField_a_of_type_Joo.a(this.jdField_a_of_type_Jop);
    FlatBuffersParser.loadLibrary();
    ayj();
    qn = this.mPref.getLong("lastPreloadPskey", 0L);
  }
  
  public static boolean A(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while ("*".equals(paramString1));
      if (!"*.*".equals(paramString1)) {
        break;
      }
      bool1 = bool2;
    } while (paramString2.indexOf('.') != -1);
    return false;
    if (paramString1.startsWith("*")) {
      return paramString2.endsWith(paramString1.substring(1));
    }
    if (paramString1.endsWith("*")) {
      return paramString2.startsWith(paramString1.substring(0, paramString1.length() - 1));
    }
    return paramString2.equals(paramString1);
  }
  
  private static String a(String paramString1, String paramString2, Set<String> paramSet)
  {
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject1 = Uri.parse(paramString2);
      localObject2 = ((Uri)localObject1).getScheme();
      if ((!"http".equals(localObject2)) && (!"https".equals(localObject2)))
      {
        localObject1 = "";
        return localObject1;
      }
      if (((Uri)localObject1).isHierarchical())
      {
        localObject1 = ((Uri)localObject1).getHost();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).toLowerCase();
          if (paramSet.contains(localObject1)) {
            paramSet = (Set<String>)localObject1;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = paramSet;
      if (!QLog.isColorLevel()) {
        break;
      }
      if (!TextUtils.isEmpty(paramSet))
      {
        QLog.d("AuthorizeConfig", 2, paramSet + " need " + paramString1 + " which extract from " + paramString2);
        return paramSet;
        localObject2 = paramSet.iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramSet = (String)((Iterator)localObject2).next();
        } while (!((String)localObject1).endsWith("." + paramSet));
      }
      else
      {
        QLog.d("AuthorizeConfig", 2, paramString2 + " not need " + paramString1);
        return paramSet;
        paramSet = "";
      }
    }
  }
  
  public static jml a()
  {
    if (jdField_a_of_type_Jml == null) {}
    try
    {
      if (jdField_a_of_type_Jml == null) {
        jdField_a_of_type_Jml = new jml(BaseApplication.getContext());
      }
      jdField_a_of_type_Jml.loadConfig();
      if (!jdField_a_of_type_Jml.M(true)) {
        jdField_a_of_type_Jml.ayh();
      }
      return jdField_a_of_type_Jml;
    }
    finally {}
  }
  
  public static jml a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Jml == null) {}
    try
    {
      if (jdField_a_of_type_Jml == null) {
        jdField_a_of_type_Jml = new jml(BaseApplication.getContext());
      }
      jdField_a_of_type_Jml.loadConfig();
      jdField_a_of_type_Jml.M(paramBoolean);
      return jdField_a_of_type_Jml;
    }
    finally {}
  }
  
  /* Error */
  private JSONArray a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokestatic 248	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +15 -> 21
    //   9: new 107	org/json/JSONArray
    //   12: dup
    //   13: invokespecial 109	org/json/JSONArray:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: areturn
    //   21: aload_0
    //   22: getfield 166	jml:aO	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 371	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 107	org/json/JSONArray
    //   32: astore 6
    //   34: aload 6
    //   36: astore 5
    //   38: aload 6
    //   40: ifnonnull -22 -> 18
    //   43: aload_0
    //   44: getfield 166	jml:aO	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: astore 8
    //   49: aload 8
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 166	jml:aO	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: aload_1
    //   57: invokevirtual 371	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 107	org/json/JSONArray
    //   63: astore 5
    //   65: aload 5
    //   67: astore 6
    //   69: aload 5
    //   71: ifnonnull +139 -> 210
    //   74: aload_0
    //   75: getfield 220	jml:jdField_a_of_type_Jop	Ljop;
    //   78: aload_1
    //   79: invokevirtual 373	jop:a	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   82: astore 6
    //   84: aload 6
    //   86: ifnonnull +195 -> 281
    //   89: new 107	org/json/JSONArray
    //   92: dup
    //   93: getstatic 89	jml:jdField_a_of_type_AndroidSupportV4UtilArrayMap	Landroid/support/v4/util/ArrayMap;
    //   96: aload_1
    //   97: invokevirtual 374	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 67	java/lang/String
    //   103: invokespecial 377	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   106: astore 5
    //   108: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +29 -> 140
    //   114: ldc 188
    //   116: iconst_2
    //   117: new 311	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 379
    //   127: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload 5
    //   142: astore 6
    //   144: aload 5
    //   146: ifnonnull +44 -> 190
    //   149: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +29 -> 181
    //   155: ldc 188
    //   157: iconst_2
    //   158: new 311	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   165: aload_1
    //   166: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 384
    //   172: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: new 107	org/json/JSONArray
    //   184: dup
    //   185: invokespecial 109	org/json/JSONArray:<init>	()V
    //   188: astore 6
    //   190: aload_0
    //   191: getfield 166	jml:aO	Ljava/util/concurrent/ConcurrentHashMap;
    //   194: aload_1
    //   195: aload 6
    //   197: invokevirtual 385	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: pop
    //   201: aload_0
    //   202: getfield 168	jml:aP	Ljava/util/concurrent/ConcurrentHashMap;
    //   205: aload_1
    //   206: invokevirtual 388	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   209: pop
    //   210: aload 8
    //   212: monitorexit
    //   213: aload 6
    //   215: areturn
    //   216: astore_1
    //   217: aload 8
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    //   222: astore 7
    //   224: aload 6
    //   226: astore 5
    //   228: aload 7
    //   230: astore 6
    //   232: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +151 -> 386
    //   238: ldc 188
    //   240: iconst_2
    //   241: new 311	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 390
    //   251: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_1
    //   255: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc_w 392
    //   261: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 6
    //   266: invokevirtual 395	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   269: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: goto +108 -> 386
    //   281: ldc 71
    //   283: aload_1
    //   284: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: istore 4
    //   289: iload 4
    //   291: ifeq +78 -> 369
    //   294: new 107	org/json/JSONArray
    //   297: dup
    //   298: getstatic 89	jml:jdField_a_of_type_AndroidSupportV4UtilArrayMap	Landroid/support/v4/util/ArrayMap;
    //   301: ldc 71
    //   303: invokevirtual 374	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast 67	java/lang/String
    //   309: invokespecial 377	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   312: astore 5
    //   314: aload 5
    //   316: invokevirtual 396	org/json/JSONArray:length	()I
    //   319: istore_2
    //   320: iload_3
    //   321: iload_2
    //   322: if_icmpge +32 -> 354
    //   325: aload 6
    //   327: aload 5
    //   329: iload_3
    //   330: invokevirtual 399	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   333: invokevirtual 116	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   336: pop
    //   337: iload_3
    //   338: iconst_1
    //   339: iadd
    //   340: istore_3
    //   341: goto -21 -> 320
    //   344: aload 7
    //   346: invokevirtual 402	org/json/JSONException:printStackTrace	()V
    //   349: iconst_0
    //   350: istore_2
    //   351: goto -31 -> 320
    //   354: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +12 -> 369
    //   360: ldc 188
    //   362: iconst_2
    //   363: ldc_w 404
    //   366: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload 6
    //   371: astore 5
    //   373: goto -233 -> 140
    //   376: astore 7
    //   378: goto -34 -> 344
    //   381: astore 6
    //   383: goto -151 -> 232
    //   386: goto -246 -> 140
    //   389: astore 7
    //   391: aconst_null
    //   392: astore 5
    //   394: goto -50 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	jml
    //   0	397	1	paramString	String
    //   319	32	2	m	int
    //   1	340	3	i1	int
    //   287	3	4	bool	boolean
    //   16	377	5	localObject1	Object
    //   32	338	6	localObject2	Object
    //   381	1	6	localJSONException1	JSONException
    //   222	123	7	localJSONException2	JSONException
    //   376	1	7	localJSONException3	JSONException
    //   389	1	7	localJSONException4	JSONException
    //   47	171	8	localConcurrentHashMap	ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   52	65	216	finally
    //   74	84	216	finally
    //   89	108	216	finally
    //   108	140	216	finally
    //   149	181	216	finally
    //   181	190	216	finally
    //   190	210	216	finally
    //   210	213	216	finally
    //   217	220	216	finally
    //   232	278	216	finally
    //   281	289	216	finally
    //   294	314	216	finally
    //   314	320	216	finally
    //   325	337	216	finally
    //   344	349	216	finally
    //   354	369	216	finally
    //   89	108	222	org/json/JSONException
    //   314	320	376	org/json/JSONException
    //   108	140	381	org/json/JSONException
    //   294	314	389	org/json/JSONException
  }
  
  private JSONObject g()
  {
    JSONObject localJSONObject3 = this.A;
    System.currentTimeMillis();
    Object localObject = localJSONObject3;
    JSONObject localJSONObject1;
    if (localJSONObject3 == null)
    {
      localObject = this.jdField_a_of_type_Jop.hH();
      localJSONObject1 = localJSONObject3;
      if (localObject == null) {}
    }
    try
    {
      localJSONObject1 = new JSONObject((String)localObject);
      localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject2 = localJSONObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "Decode mOfflineConfig  error");
          localJSONObject2 = localJSONObject3;
        }
      }
    }
  }
  
  private JSONObject h()
  {
    Object localObject3 = this.B;
    System.currentTimeMillis();
    Object localObject1 = localObject3;
    String str;
    if (localObject3 == null)
    {
      str = this.jdField_a_of_type_Jop.getExt();
      localObject1 = localObject3;
      if (str == null) {}
    }
    try
    {
      localObject1 = new JSONObject(str);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new JSONObject();
      }
      this.B = ((JSONObject)localObject3);
      localObject1 = localObject3;
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "Decode mExtraConfig error");
          localObject2 = localObject3;
        }
      }
    }
  }
  
  /* Error */
  public static String l(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 442	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 443	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: astore_1
    //   10: new 445	java/util/zip/Inflater
    //   13: dup
    //   14: invokespecial 446	java/util/zip/Inflater:<init>	()V
    //   17: astore_3
    //   18: aload_2
    //   19: astore_1
    //   20: aload_3
    //   21: aload_0
    //   22: invokevirtual 450	java/util/zip/Inflater:setInput	([B)V
    //   25: aload_2
    //   26: astore_1
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore_0
    //   33: aload_2
    //   34: astore_1
    //   35: aload_3
    //   36: invokevirtual 453	java/util/zip/Inflater:finished	()Z
    //   39: ifne +58 -> 97
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: aload_0
    //   46: iconst_0
    //   47: aload_3
    //   48: aload_0
    //   49: invokevirtual 457	java/util/zip/Inflater:inflate	([B)I
    //   52: invokevirtual 461	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -22 -> 33
    //   58: astore_1
    //   59: aload_2
    //   60: astore_0
    //   61: aload_1
    //   62: astore_2
    //   63: aload_0
    //   64: astore_1
    //   65: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +15 -> 83
    //   71: aload_0
    //   72: astore_1
    //   73: ldc 188
    //   75: iconst_2
    //   76: ldc_w 295
    //   79: aload_2
    //   80: invokestatic 464	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 467	java/io/ByteArrayOutputStream:close	()V
    //   91: ldc_w 295
    //   94: astore_0
    //   95: aload_0
    //   96: areturn
    //   97: aload_2
    //   98: astore_1
    //   99: aload_3
    //   100: invokevirtual 470	java/util/zip/Inflater:end	()V
    //   103: aload_2
    //   104: astore_1
    //   105: new 67	java/lang/String
    //   108: dup
    //   109: aload_2
    //   110: invokevirtual 474	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: invokespecial 476	java/lang/String:<init>	([B)V
    //   116: astore_3
    //   117: aload_3
    //   118: astore_0
    //   119: aload_2
    //   120: ifnull -25 -> 95
    //   123: aload_2
    //   124: invokevirtual 467	java/io/ByteArrayOutputStream:close	()V
    //   127: aload_3
    //   128: areturn
    //   129: astore_1
    //   130: aload_3
    //   131: astore_0
    //   132: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq -40 -> 95
    //   138: ldc 188
    //   140: iconst_2
    //   141: ldc_w 295
    //   144: aload_1
    //   145: invokestatic 464	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_3
    //   149: areturn
    //   150: astore_0
    //   151: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq -63 -> 91
    //   157: ldc 188
    //   159: iconst_2
    //   160: ldc_w 295
    //   163: aload_0
    //   164: invokestatic 464	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   167: goto -76 -> 91
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 467	java/io/ByteArrayOutputStream:close	()V
    //   181: aload_0
    //   182: athrow
    //   183: astore_1
    //   184: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq -6 -> 181
    //   190: ldc 188
    //   192: iconst_2
    //   193: ldc_w 295
    //   196: aload_1
    //   197: invokestatic 464	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   200: goto -19 -> 181
    //   203: astore_0
    //   204: goto -31 -> 173
    //   207: astore_2
    //   208: aconst_null
    //   209: astore_0
    //   210: goto -147 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramArrayOfByte	byte[]
    //   9	35	1	localObject1	Object
    //   58	4	1	localThrowable1	java.lang.Throwable
    //   64	41	1	localObject2	Object
    //   129	16	1	localException1	Exception
    //   172	6	1	localObject3	Object
    //   183	14	1	localException2	Exception
    //   7	117	2	localObject4	Object
    //   207	1	2	localThrowable2	java.lang.Throwable
    //   17	132	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   10	18	58	java/lang/Throwable
    //   20	25	58	java/lang/Throwable
    //   27	33	58	java/lang/Throwable
    //   35	42	58	java/lang/Throwable
    //   44	55	58	java/lang/Throwable
    //   99	103	58	java/lang/Throwable
    //   105	117	58	java/lang/Throwable
    //   123	127	129	java/lang/Exception
    //   87	91	150	java/lang/Exception
    //   0	8	170	finally
    //   177	181	183	java/lang/Exception
    //   10	18	203	finally
    //   20	25	203	finally
    //   27	33	203	finally
    //   35	42	203	finally
    //   44	55	203	finally
    //   65	71	203	finally
    //   73	83	203	finally
    //   99	103	203	finally
    //   105	117	203	finally
    //   0	8	207	java/lang/Throwable
  }
  
  private String removePrefix(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1.startsWith(paramString2)) {
      str = paramString1.substring(paramString2.length());
    }
    return str;
  }
  
  private boolean xV()
  {
    boolean bool2 = false;
    for (;;)
    {
      synchronized (this.jdField_I_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        if (this.jdField_I_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
          return false;
        }
        if (this.jdField_I_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) {
          return true;
        }
        if (this.jdField_I_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) {
          break label121;
        }
        bool1 = "com.tencent.tim".equals(MobileQQ.getMobileQQ().getQQProcessName());
        this.jdField_I_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        long l = System.currentTimeMillis() - sLastUpdateTime;
        if (l < 0L) {
          break label126;
        }
        if (l >= 1800000L)
        {
          break label126;
          return bool1;
        }
      }
      int m = 0;
      break label128;
      label121:
      boolean bool1 = false;
      continue;
      label126:
      m = 1;
      label128:
      if (!bool1)
      {
        bool1 = bool2;
        if (m == 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public boolean B(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      localObject1 = paramString1;
      if (!"about:blank".equalsIgnoreCase(paramString1)) {}
    }
    else
    {
      localObject1 = "https://localhost/";
    }
    Object localObject3 = Uri.parse((String)localObject1);
    paramString1 = ((Uri)localObject3).getScheme();
    if ("file".equals(paramString1))
    {
      if (((String)localObject1).length() > 200) {}
      for (paramString1 = ((String)localObject1).substring(0, 200);; paramString1 = (String)localObject1)
      {
        apue.m("webview", "file_scheme", paramString1, "", "", "");
        QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
        return false;
      }
    }
    if ((!"http".equals(paramString1)) && (!"https".equals(paramString1))) {
      return false;
    }
    Object localObject1 = this.jdField_I_of_type_OrgJsonJSONObject;
    System.currentTimeMillis();
    paramString1 = (String)localObject1;
    if (localObject1 == null) {}
    label240:
    for (;;)
    {
      try
      {
        paramString1 = this.jdField_a_of_type_Jop.i();
        if (paramString1 == null)
        {
          try
          {
            localObject1 = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
            paramString1 = (String)localObject1;
          }
          catch (JSONException localJSONException)
          {
            JSONArray localJSONArray;
            continue;
            localObject3 = ((Uri)localObject3).getHost();
            Object localObject2 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label240;
            }
            localObject2 = ((String)localObject3).toLowerCase();
            int i2 = localJSONArray.length();
            int m = 0;
            if (m >= i2) {
              break label335;
            }
            localObject3 = localJSONArray.optString(m);
            if (A((String)localObject3, (String)localObject2)) {
              break label280;
            }
            for (;;)
            {
              m += 1;
              break;
              localObject3 = paramString1.optJSONArray((String)localObject3);
              if (localObject3 != null)
              {
                int i3 = ((JSONArray)localObject3).length();
                int i1 = 0;
                while (i1 < i3)
                {
                  if (A(((JSONArray)localObject3).optString(i1), paramString2)) {
                    return true;
                  }
                  i1 += 1;
                }
              }
            }
            return false;
          }
          this.jdField_I_of_type_OrgJsonJSONObject = paramString1;
          localJSONArray = paramString1.names();
          if (localJSONArray == null) {
            return false;
          }
        }
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
        }
        paramString1 = (String)localObject1;
      }
    }
  }
  
  public void E(String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    System.currentTimeMillis();
    SharedPreferences.Editor localEditor = this.mPref.edit();
    if (FlatBuffersParser.isOk()) {}
    for (paramString1 = this.jdField_a_of_type_Joo.a(localEditor, paramString1); paramString1 == null; paramString1 = this.jdField_a_of_type_Jop.a(localEditor, paramString1)) {
      return;
    }
    long l = this.qm;
    this.qm = this.mPref.getLong("publishSeq", this.qm);
    QLog.i("AuthorizeConfig", 1, "update white list's publishSeq from " + l + " to " + this.qm + ".");
    if (TextUtils.isEmpty(paramString1))
    {
      this.jdField_I_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      localEditor.putLong("lastUpdate", System.currentTimeMillis());
      localEditor.putString("qqVersion", "2013 3.4.4");
      localEditor.putString(paramString3, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "White list update completed as version=" + paramString2);
      }
      anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_ok", 0, 1, 0, "", "", "", "");
    }
    for (;;)
    {
      localEditor.commit();
      ayf();
      ayh();
      this.aO.clear();
      this.aP.clear();
      return;
      this.jdField_I_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 0, 1, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("AuthorizeConfig", 2, "Authorize config parse failed include: " + paramString1);
      }
    }
  }
  
  public String H(String paramString1, String paramString2)
  {
    return h().optString(paramString1, paramString2);
  }
  
  protected boolean M(boolean paramBoolean)
  {
    if (xV())
    {
      this.jdField_I_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      ThreadManager.executeOnNetWorkThread(new AuthorizeConfig.2(this, paramBoolean));
      return true;
    }
    return false;
  }
  
  /* Error */
  public Boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +8 -> 9
    //   4: iconst_0
    //   5: invokestatic 628	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: areturn
    //   9: aload_1
    //   10: invokestatic 285	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 289	android/net/Uri:getScheme	()Ljava/lang/String;
    //   20: astore 6
    //   22: ldc_w 506
    //   25: aload 6
    //   27: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifeq +58 -> 88
    //   33: aload_1
    //   34: invokevirtual 275	java/lang/String:length	()I
    //   37: sipush 200
    //   40: if_icmple +45 -> 85
    //   43: aload_1
    //   44: iconst_0
    //   45: sipush 200
    //   48: invokevirtual 278	java/lang/String:substring	(II)Ljava/lang/String;
    //   51: astore_1
    //   52: ldc_w 508
    //   55: ldc_w 630
    //   58: aload_1
    //   59: ldc_w 295
    //   62: ldc_w 295
    //   65: ldc_w 295
    //   68: invokestatic 516	apue:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   71: ldc 188
    //   73: iconst_1
    //   74: ldc_w 518
    //   77: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: iconst_0
    //   81: invokestatic 628	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   84: areturn
    //   85: goto -33 -> 52
    //   88: ldc_w 291
    //   91: aload 6
    //   93: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   96: ifne +19 -> 115
    //   99: ldc_w 293
    //   102: aload 6
    //   104: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +8 -> 115
    //   110: iconst_0
    //   111: invokestatic 628	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   114: areturn
    //   115: aload 5
    //   117: invokevirtual 301	android/net/Uri:getHost	()Ljava/lang/String;
    //   120: astore_1
    //   121: aload_1
    //   122: astore 5
    //   124: aload_1
    //   125: invokestatic 248	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifne +9 -> 137
    //   131: aload_1
    //   132: invokevirtual 304	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   135: astore 5
    //   137: aload_0
    //   138: getfield 632	jml:C	Lorg/json/JSONObject;
    //   141: astore_1
    //   142: invokestatic 417	java/lang/System:currentTimeMillis	()J
    //   145: pop2
    //   146: aload_1
    //   147: ifnonnull +238 -> 385
    //   150: aload_0
    //   151: getfield 220	jml:jdField_a_of_type_Jop	Ljop;
    //   154: invokevirtual 635	jop:hI	()Ljava/lang/String;
    //   157: astore 6
    //   159: aload 6
    //   161: ifnull +101 -> 262
    //   164: new 422	org/json/JSONObject
    //   167: dup
    //   168: aload 6
    //   170: invokespecial 423	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   173: astore 6
    //   175: aload 6
    //   177: astore_1
    //   178: aload_1
    //   179: ifnonnull +203 -> 382
    //   182: new 422	org/json/JSONObject
    //   185: dup
    //   186: ldc_w 637
    //   189: invokespecial 423	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   192: astore 6
    //   194: aload 6
    //   196: astore_1
    //   197: aload_0
    //   198: aload_1
    //   199: putfield 632	jml:C	Lorg/json/JSONObject;
    //   202: aload_1
    //   203: ldc_w 639
    //   206: invokevirtual 642	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   209: astore 6
    //   211: aload 6
    //   213: invokevirtual 396	org/json/JSONArray:length	()I
    //   216: istore 4
    //   218: iconst_0
    //   219: istore_3
    //   220: iload_3
    //   221: iload 4
    //   223: if_icmpge +56 -> 279
    //   226: aload 6
    //   228: iload_3
    //   229: invokevirtual 399	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   232: aload 5
    //   234: invokestatic 532	jml:A	(Ljava/lang/String;Ljava/lang/String;)Z
    //   237: ifeq +33 -> 270
    //   240: iconst_1
    //   241: invokestatic 628	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   244: areturn
    //   245: astore 6
    //   247: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +12 -> 262
    //   253: ldc 188
    //   255: iconst_2
    //   256: ldc_w 644
    //   259: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto -84 -> 178
    //   265: astore 6
    //   267: goto -70 -> 197
    //   270: iload_3
    //   271: iconst_1
    //   272: iadd
    //   273: istore_3
    //   274: goto -54 -> 220
    //   277: astore 5
    //   279: aload_1
    //   280: ldc_w 646
    //   283: invokevirtual 642	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   286: astore 5
    //   288: aload 5
    //   290: invokevirtual 396	org/json/JSONArray:length	()I
    //   293: istore 4
    //   295: iconst_0
    //   296: istore_3
    //   297: iload_3
    //   298: iload 4
    //   300: if_icmpge +30 -> 330
    //   303: aload 5
    //   305: iload_3
    //   306: invokevirtual 399	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   309: aload_2
    //   310: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   313: ifeq +8 -> 321
    //   316: iconst_1
    //   317: invokestatic 628	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   320: areturn
    //   321: iload_3
    //   322: iconst_1
    //   323: iadd
    //   324: istore_3
    //   325: goto -28 -> 297
    //   328: astore 5
    //   330: aload_1
    //   331: ldc_w 648
    //   334: invokevirtual 642	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   337: astore_1
    //   338: aload_1
    //   339: invokevirtual 396	org/json/JSONArray:length	()I
    //   342: istore 4
    //   344: iconst_0
    //   345: istore_3
    //   346: iload_3
    //   347: iload 4
    //   349: if_icmpge +28 -> 377
    //   352: aload_1
    //   353: iload_3
    //   354: invokevirtual 399	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   357: aload_2
    //   358: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq +8 -> 369
    //   364: iconst_1
    //   365: invokestatic 628	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   368: areturn
    //   369: iload_3
    //   370: iconst_1
    //   371: iadd
    //   372: istore_3
    //   373: goto -27 -> 346
    //   376: astore_1
    //   377: iconst_0
    //   378: invokestatic 628	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   381: areturn
    //   382: goto -185 -> 197
    //   385: goto -183 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	jml
    //   0	388	1	paramString1	String
    //   0	388	2	paramString2	String
    //   219	154	3	m	int
    //   216	134	4	i1	int
    //   13	220	5	localObject1	Object
    //   277	1	5	localJSONException1	JSONException
    //   286	18	5	localJSONArray	JSONArray
    //   328	1	5	localJSONException2	JSONException
    //   20	207	6	localObject2	Object
    //   245	1	6	localJSONException3	JSONException
    //   265	1	6	localJSONException4	JSONException
    // Exception table:
    //   from	to	target	type
    //   164	175	245	org/json/JSONException
    //   182	194	265	org/json/JSONException
    //   202	218	277	org/json/JSONException
    //   226	240	277	org/json/JSONException
    //   279	295	328	org/json/JSONException
    //   303	316	328	org/json/JSONException
    //   330	344	376	org/json/JSONException
    //   352	364	376	org/json/JSONException
  }
  
  public Set<String> a(String paramString)
  {
    Object localObject1;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = new HashSet();
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = (Set)this.aP.get(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    for (;;)
    {
      int m;
      synchronized (this.aP)
      {
        localObject2 = (Set)this.aP.get(paramString);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label234;
        }
        localObject2 = new HashSet(32);
        localObject1 = a(paramString);
        if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0))
        {
          int i1 = ((JSONArray)localObject1).length();
          m = 0;
          if (m < i1) {
            if ("skey".equals(paramString)) {
              ((Set)localObject2).add(removePrefix(((JSONArray)localObject1).optString(m, ""), "*."));
            } else {
              ((Set)localObject2).add(((JSONArray)localObject1).optString(m, ""));
            }
          }
        }
      }
      this.aP.put(paramString, localObject2);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("AuthorizeConfig", 2, paramString + " domain white list: " + localObject2);
        localObject1 = localObject2;
      }
      label234:
      return localObject1;
      m += 1;
    }
  }
  
  public int aB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return 0;
        paramString = paramString.split("\\?");
        localJSONObject = g();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        int m = localJSONObject.getJSONObject(paramString[0]).getInt("delay");
        return m;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getCheckUpDelayTime error");
    return 0;
  }
  
  public void ayb()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveX5Config from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject1, "VASBiz_FuncDev_webview.json", false, null);
    if ((localObject2 != null) && (localObject1 != null) && (((AppRuntime)localObject1).isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "receive X5Config data: " + ((JSONObject)localObject2).toString());
      }
      localObject2 = ((JSONObject)localObject2).optJSONArray("vipGrayConfig2");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        int m = 0;
        boolean bool3 = true;
        boolean bool1 = true;
        if (m < ((JSONArray)localObject2).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(m);
          boolean bool2 = bool3;
          boolean bool4 = bool1;
          if (localJSONObject != null)
          {
            if (arcp.b(localJSONObject, "X5Config"))
            {
              if (localJSONObject.optInt("mainThreadControl", 0) != 0) {
                break label220;
              }
              bool1 = true;
            }
            label172:
            bool2 = bool3;
            bool4 = bool1;
            if (arcp.b(localJSONObject, "X5Config"))
            {
              if (localJSONObject.optInt("enableQuic", 1) != 1) {
                break label225;
              }
              bool2 = true;
            }
          }
          for (bool4 = bool1;; bool4 = bool1)
          {
            m += 1;
            bool3 = bool2;
            bool1 = bool4;
            break;
            label220:
            bool1 = false;
            break label172;
            label225:
            bool2 = false;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("AuthorizeConfig", 2, "readAndSaveX5Config isInitOnSubThread : " + bool1 + ", enable quick: " + bool3);
        }
        localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        localObject1 = ((AppRuntime)localObject1).getApplication().getSharedPreferences("sp_x5_config_" + (String)localObject2, 4).edit();
        ((SharedPreferences.Editor)localObject1).putBoolean("key_x5_init_sub_thread", bool1);
        ((SharedPreferences.Editor)localObject1).putBoolean("key_x5_enable_quic", bool3);
        ((SharedPreferences.Editor)localObject1).apply();
      }
    }
  }
  
  public void ayc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveX5PreloadWhiteListConfig from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    JSONObject localJSONObject = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject, "VASBiz_FuncDev_webview.json", false, null);
    if ((localJSONObject != null) && (localObject != null) && (((AppRuntime)localObject).isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "receive X5PreloadWhiteList data: " + localJSONObject.toString());
      }
      localObject = localJSONObject.optJSONArray("x5PreloadWhiteList");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        this.G = ((JSONArray)localObject).optJSONObject(0);
      }
    }
  }
  
  public void ayd()
  {
    int m = 0;
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveSonicWhiteListConfig from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject2, "VASBiz_FuncDev_webview.json", false, null);
    Object localObject3;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "receive WhiteListConfig data: " + ((JSONObject)localObject1).toString());
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("vipGrayConfig2");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        if (m >= ((JSONArray)localObject1).length()) {
          break label280;
        }
        localObject3 = ((JSONArray)localObject1).optJSONObject(m);
        if ((localObject3 == null) || (!m((JSONObject)localObject3))) {
          break label241;
        }
      }
    }
    label280:
    for (localObject1 = ((JSONObject)localObject3).optJSONObject("configs");; localObject1 = null)
    {
      localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject2 = ((AppRuntime)localObject2).getApplication().getSharedPreferences("sp_sonic_white_list_config_" + (String)localObject3, 4).edit();
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AuthorizeConfig", 2, "readAndSaveSonicWhiteListConfig: " + ((JSONObject)localObject1).toString());
        }
        ((SharedPreferences.Editor)localObject2).putString("key_sonic_white_list_conifg", ((JSONObject)localObject1).toString());
      }
      for (;;)
      {
        this.H = ((JSONObject)localObject1);
        ((SharedPreferences.Editor)localObject2).apply();
        return;
        label241:
        m += 1;
        break;
        QLog.e("AuthorizeConfig", 1, "readAndSaveSonicWhiteListConfig encounter error!. so remove all sonic white list.");
        ((SharedPreferences.Editor)localObject2).remove("key_sonic_white_list_conifg");
      }
      QLog.d("AuthorizeConfig", 1, "readAndSaveSonicWhiteListConfig VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW is null");
      return;
    }
  }
  
  public void aye()
  {
    boolean bool = true;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject == null) || (!((AppRuntime)localObject).isLogin()))
    {
      QLog.e("AuthorizeConfig", 1, "loadSonicWhiteListConfigFromSp, runtime is null or is not login!");
      return;
    }
    String str = ((AppRuntime)localObject).getAccount();
    localObject = ((AppRuntime)localObject).getApplication().getSharedPreferences("sp_sonic_white_list_config_" + str, 4).getString("key_sonic_white_list_conifg", null);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        this.H = new JSONObject((String)localObject);
        if (this.H == null) {
          ayd();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject = new StringBuilder().append("loadSonicWhiteListConfigFromSp:  ");
        if (this.H == null) {
          break label177;
        }
        QLog.i("AuthorizeConfig", 2, bool);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AuthorizeConfig", 2, "", localException);
        continue;
      }
      QLog.e("AuthorizeConfig", 1, "loadSonicWhiteListConfigFromSp is null!");
      continue;
      label177:
      bool = false;
    }
  }
  
  public void ayf()
  {
    long l = System.currentTimeMillis();
    if (l - qn < 86400000L) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 1, new Object[] { "cachePreloadPskeyList too often lastTime:", Long.valueOf(qn), " interval:", Long.valueOf(86400000L) });
      }
    }
    do
    {
      return;
      if (BaseApplicationImpl.getApplication().getRuntime().isLogin()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "cachePreloadPskeyList is not login");
    return;
    if (((aeos)aeif.a().o(585)).cOl == 1)
    {
      Object localObject3 = a("pskey");
      ArrayList localArrayList = new ArrayList(((Set)localObject3).size());
      ??? = new HashSet(20);
      Object localObject4 = WebViewConstant.DEFAULT_PSKEY_LIST;
      int i1 = localObject4.length;
      int m = 0;
      while (m < i1)
      {
        ((HashSet)???).add(localObject4[m]);
        m += 1;
      }
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        if (!((HashSet)???).contains(localObject4)) {
          localArrayList.add(localObject4);
        }
      }
      for (;;)
      {
        synchronized (aB)
        {
          this.jg = localArrayList;
          if (QLog.isColorLevel())
          {
            if (this.jg != null)
            {
              m = this.jg.size();
              QLog.d("AuthorizeConfig", 2, new Object[] { "preloadPskey list:", Integer.valueOf(m), " waitPt4Token:", Boolean.valueOf(this.aaz) });
            }
          }
          else
          {
            if (this.aaz) {
              break;
            }
            ayg();
            qn = l;
            this.mPref.edit().putLong("lastPreloadPskey", qn).commit();
            return;
          }
        }
        m = 0;
      }
    }
    QLog.d("AuthorizeConfig", 1, "do not support preloadPskey.");
  }
  
  public void ayg()
  {
    if (this.aaz) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "preloadPskey waiting");
      }
    }
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime.isLogin()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "preloadPskey is not login");
    return;
    TicketManager localTicketManager = (TicketManager)localAppRuntime.getManager(2);
    ArrayList localArrayList1 = new ArrayList(20);
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = aB;
    int m = 0;
    for (;;)
    {
      try
      {
        if (m < this.jg.size()) {
          if (m < 20) {
            localArrayList1.add(this.jg.get(m));
          } else {
            localArrayList2.add(this.jg.get(m));
          }
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, new Object[] { "preload:", Integer.valueOf(this.jg.size()), " cur:", Integer.valueOf(localArrayList1.size()), " left:", Integer.valueOf(localArrayList2.size()) });
      }
      this.jg = localArrayList2;
      if (localArrayList1.size() == 0) {
        break;
      }
      localObject2 = new String[localArrayList1.size()];
      m = 0;
      while (m < localArrayList1.size())
      {
        localObject2[m] = String.format("(%d)%s", new Object[] { Integer.valueOf(1048576), localArrayList1.get(m) });
        m += 1;
      }
      AuthorizeConfig.4 local4 = new AuthorizeConfig.4(this, localTicketManager, localObject1.getAccount(), (String[])localObject2);
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        local4.run();
        return;
      }
      ThreadManager.post(local4, 8, null, true);
      return;
      m += 1;
    }
  }
  
  public void ayh()
  {
    long l = System.currentTimeMillis();
    if (l - qo < 21600000L) {
      QLog.d("AuthorizeConfig", 1, "preload too often");
    }
    do
    {
      return;
      synchronized (aC)
      {
        if (l - qo < 21600000L)
        {
          QLog.d("AuthorizeConfig", 1, "preload too often");
          return;
        }
      }
      qo = l;
      ??? = BaseApplicationImpl.getApplication().getRuntime();
    } while ((!(??? instanceof QQAppInterface)) || ((!((AppRuntime)???).isLogin()) && (!"com.tencent.tim".equals(MobileQQ.getMobileQQ().getQQProcessName()))));
    if (com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[3].intValue() == 1)
    {
      TicketManager localTicketManager = (TicketManager)((AppRuntime)???).getManager(2);
      Object localObject3 = a("pt4_token");
      String[] arrayOfString = new String[((Set)localObject3).size()];
      localObject3 = ((Set)localObject3).iterator();
      int m = 0;
      while (((Iterator)localObject3).hasNext())
      {
        arrayOfString[m] = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), (String)((Iterator)localObject3).next() });
        m += 1;
      }
      ??? = new AuthorizeConfig.5(this, localTicketManager, ((AppRuntime)???).getAccount(), arrayOfString);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        ((Runnable)???).run();
      }
      for (;;)
      {
        this.aaz = true;
        return;
        ThreadManager.post((Runnable)???, 8, null, true);
      }
    }
    QLog.d("AuthorizeConfig", 1, "do not support preload.");
  }
  
  public void ayi()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio main process loadFuncDevWebViewConfig");
      localObject1 = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject1, "VASBiz_FuncDev_webview.json", true, null);
    }
    while (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio loadFuncDevWebViewConfig return " + ((JSONObject)localObject1).toString());
      }
      Object localObject2 = ((JSONObject)localObject1).optJSONArray("WebViewSwitchAioConfig");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
        this.D = ((JSONArray)localObject2).optJSONObject(0);
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("WebViewWhiteScreenDomains");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
        this.E = ((JSONArray)localObject2).optJSONObject(0);
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("arkShareWhiteList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        this.F = ((JSONArray)localObject1).optJSONObject(0);
      }
      return;
      localObject2 = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject1, "VASBiz_FuncDev_webview.json", false, null);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio calling main process to download FuncDevWebViewConfig");
        localObject1 = affz.a("download_FuncDev_webview", "", 0, null);
        afjy.a().cr((Bundle)localObject1);
        localObject1 = localObject2;
      }
    }
    QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio loadFuncDevWebViewConfig return null");
  }
  
  public void ayj()
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((l - this.ql < 1800000L) && (this.D != null) && (this.F != null)) {
        return;
      }
      this.ql = l;
      ThreadManager.post(new AuthorizeConfig.6(this), 5, null, false);
      return;
    }
    finally {}
  }
  
  public long bW()
  {
    if (-1L == this.qm) {
      this.qm = this.mPref.getLong("publishSeq", 0L);
    }
    return this.qm;
  }
  
  public boolean cQ(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    localObject = Uri.parse(paramString).getHost();
    paramString = (String)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = ((String)localObject).toLowerCase();
    }
    localObject = a("skey");
    int i1 = ((JSONArray)localObject).length();
    int m = 0;
    while (m < i1)
    {
      if (A(((JSONArray)localObject).optString(m), paramString)) {
        return true;
      }
      m += 1;
    }
    return false;
  }
  
  public boolean cR(String paramString)
  {
    for (;;)
    {
      int m;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.j == null) && (!xW()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "CgiConfig loadfromsp fail , url: " + jqo.filterKeyForLog(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            if ((this.j.length() != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              int i1 = this.j.length();
              m = 0;
              if (m < i1)
              {
                String str2 = this.j.optString(m, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label250;
                }
                if (!QLog.isColorLevel()) {
                  break label248;
                }
                QLog.d("AuthorizeConfig", 2, "CgiConfig hit , url: " + jqo.filterKeyForLog(paramString, new String[0]) + " domain: " + str2);
                break label248;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "CgiConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return false;
      label248:
      return true;
      label250:
      m += 1;
    }
  }
  
  public boolean cS(String paramString)
  {
    for (;;)
    {
      int m;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.k == null) && (!xX()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig loadfromsp fail , url: " + jqo.filterKeyForLog(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            int i1 = this.k.length();
            if ((i1 != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              m = 0;
              if (m < i1)
              {
                String str2 = this.k.optString(m, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label256;
                }
                if (!QLog.isColorLevel()) {
                  break label254;
                }
                QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig hit , url: " + jqo.filterKeyForLog(paramString, new String[0]) + " domain: " + str2);
                break label254;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "AsyncCheckConfig check exception", paramString);
        }
      }
      return false;
      label254:
      return true;
      label256:
      m += 1;
    }
  }
  
  public boolean cT(String paramString)
  {
    for (;;)
    {
      int m;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.n == null) && (!xY()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig loadfromsp fail , url: " + jqo.filterKeyForLog(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            int i1 = this.n.length();
            if ((i1 != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              m = 0;
              if (m < i1)
              {
                String str2 = this.n.optString(m, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label256;
                }
                if (!QLog.isColorLevel()) {
                  break label254;
                }
                QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig hit , url: " + jqo.filterKeyForLog(paramString, new String[0]) + " domain: " + str2);
                break label254;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "SkipInputWarningConfig check exception", paramString);
        }
      }
      return false;
      label254:
      return true;
      label256:
      m += 1;
    }
  }
  
  public boolean cU(String paramString)
  {
    for (;;)
    {
      int m;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.p == null) && (!ya()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "forceHttpsConfig loadfromsp fail , url: " + jqo.filterKeyForLog(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            int i1 = this.p.length();
            if ((i1 != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              m = 0;
              if (m < i1)
              {
                String str2 = this.p.optString(m, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label256;
                }
                if (!QLog.isColorLevel()) {
                  break label254;
                }
                QLog.d("AuthorizeConfig", 2, "forceHttpsConfig hit , url: " + jqo.filterKeyForLog(paramString, new String[0]) + " domain: " + str2);
                break label254;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "forceHttpsConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "forceHttpsConfig check exception", paramString);
        }
      }
      return false;
      label254:
      return true;
      label256:
      m += 1;
    }
  }
  
  public boolean cV(String paramString)
  {
    for (;;)
    {
      int m;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.r == null) && (!ya()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig loadfromsp fail , url: " + jqo.filterKeyForLog(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            int i1 = this.r.length();
            if ((i1 != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              m = 0;
              if (m < i1)
              {
                String str2 = this.r.optString(m, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label256;
                }
                if (!QLog.isColorLevel()) {
                  break label254;
                }
                QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig hit , url: " + jqo.filterKeyForLog(paramString, new String[0]) + " domain: " + str2);
                break label254;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "forceHttpsExcludeConfig check exception", paramString);
        }
      }
      return false;
      label254:
      return true;
      label256:
      m += 1;
    }
  }
  
  public boolean cW(String paramString)
  {
    Object localObject = Uri.parse(paramString);
    String str;
    int m;
    boolean bool;
    if ((localObject != null) && (((Uri)localObject).isHierarchical()))
    {
      if (this.H == null) {
        aye();
      }
      if (this.H != null)
      {
        str = ((Uri)localObject).getHost();
        localObject = ((Uri)localObject).getPath();
        if (this.H == null) {
          break label271;
        }
        JSONArray localJSONArray = this.H.optJSONArray(str);
        if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
          break label271;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AuthorizeConfig", 2, "isInSonicWhiteList, host: " + str + ", rules: " + localJSONArray.toString());
        }
        m = 0;
        if (m >= localJSONArray.length()) {
          break label271;
        }
        str = localJSONArray.optString(m);
        if ((str.equalsIgnoreCase((String)localObject)) || (str.equals("*"))) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "isInSonicWhiteList: " + bool + ", url: " + jqo.filterKeyForLog(paramString, new String[0]));
      }
      return bool;
      if ((str.endsWith("*")) && (((String)localObject).startsWith(str.replace("/*", ""))))
      {
        bool = true;
      }
      else
      {
        m += 1;
        break;
        QLog.e("AuthorizeConfig", 1, "mSonicWhiteListConfig is null! ");
        label271:
        bool = false;
      }
    }
  }
  
  public boolean cX(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    localObject = a("a1");
    paramString = Uri.parse(paramString).getHost();
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.toLowerCase();
    }
    for (;;)
    {
      if (((Set)localObject).contains(paramString)) {
        return true;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (A((String)((Iterator)localObject).next(), paramString)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public boolean cY(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (!"about:blank".equalsIgnoreCase(paramString)) {}
    }
    else
    {
      localObject = "https://localhost/";
    }
    Uri localUri = Uri.parse((String)localObject);
    paramString = localUri.getScheme();
    if ((!"http".equals(paramString)) && (!"https".equals(paramString))) {
      return false;
    }
    Object localObject = this.jdField_I_of_type_OrgJsonJSONObject;
    System.currentTimeMillis();
    paramString = (String)localObject;
    if (localObject == null) {}
    label169:
    label212:
    label223:
    for (;;)
    {
      try
      {
        paramString = this.jdField_a_of_type_Jop.i();
        if (paramString == null)
        {
          try
          {
            localObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
            paramString = (String)localObject;
          }
          catch (JSONException localJSONException)
          {
            JSONArray localJSONArray;
            continue;
            String str = localUri.getHost();
            paramString = str;
            if (TextUtils.isEmpty(str)) {
              break label169;
            }
            paramString = str.toLowerCase();
            int i1 = localJSONArray.length();
            int m = 0;
            if (m >= i1) {
              break label223;
            }
            str = localJSONArray.optString(m);
            if ((str == null) || (!str.equals("*"))) {
              break label212;
            }
            while (!A(str, paramString))
            {
              m += 1;
              break;
            }
            return true;
            return false;
          }
          localJSONArray = paramString.names();
          if (localJSONArray == null) {
            return false;
          }
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
        }
        paramString = (String)localObject;
      }
    }
  }
  
  public boolean cZ(String paramString)
  {
    ayj();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject1 = Uri.parse(paramString);
      Object localObject2 = ((Uri)localObject1).getScheme();
      if (("http".equals(localObject2)) || ("https".equals(localObject2)))
      {
        localObject1 = ((Uri)localObject1).getHost();
        localObject2 = this.D;
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio call canSwitchAIO url " + paramString + " config " + localObject2);
        }
        if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (((JSONObject)localObject2).optInt("enable", 0) == 1))
        {
          paramString = ((JSONObject)localObject2).optJSONArray("domains");
          if (paramString != null)
          {
            int m = paramString.length() - 1;
            while (m >= 0)
            {
              if (((String)localObject1).endsWith(paramString.optString(m))) {
                return true;
              }
              m -= 1;
            }
          }
        }
      }
    }
  }
  
  public String dE(String paramString)
  {
    return null;
  }
  
  public String dF(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return null;
        paramString = paramString.split("\\?");
        localJSONObject = g();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("bid");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getOfflineId error");
    return null;
  }
  
  public String dG(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return null;
        paramString = paramString.split("\\?");
        localJSONObject = g();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("duck");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getCheckUpType error");
    return null;
  }
  
  public String dH(String paramString)
  {
    return a("p_skey", paramString, a("pskey"));
  }
  
  public String dI(String paramString)
  {
    return a("pt4_token", paramString, a("pt4_token"));
  }
  
  public String dJ(String paramString)
  {
    return a("a2", paramString, a("a2"));
  }
  
  public boolean da(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "[canShareArkMsg] ArkName: " + paramString + " ArkShareConfig: " + this.F);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ayj();
    Object localObject = this.F;
    JSONArray localJSONArray = null;
    if (localObject != null) {
      localJSONArray = ((JSONObject)localObject).optJSONArray("validArkNames");
    }
    if (localObject != null)
    {
      localObject = localJSONArray;
      if (localJSONArray != null) {}
    }
    else
    {
      localObject = i;
    }
    int m = ((JSONArray)localObject).length() - 1;
    while (m >= 0)
    {
      if (paramString.equals(((JSONArray)localObject).optString(m))) {
        return true;
      }
      m -= 1;
    }
    return false;
  }
  
  public boolean db(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.G == null) {
      ayc();
    }
    Object localObject = this.G;
    JSONArray localJSONArray = null;
    if (localObject != null) {
      localJSONArray = ((JSONObject)localObject).optJSONArray("domainList");
    }
    if (localObject != null)
    {
      localObject = localJSONArray;
      if (localJSONArray != null) {}
    }
    else
    {
      localObject = new JSONArray();
      ((JSONArray)localObject).put("*.vip.qq.com");
    }
    int m = ((JSONArray)localObject).length() - 1;
    while (m >= 0)
    {
      if (A(((JSONArray)localObject).optString(m), paramString)) {
        return true;
      }
      m -= 1;
    }
    return false;
  }
  
  public boolean dc(String paramString)
  {
    ayj();
    Object localObject = this.E;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 1, "isInWhiteScreenWhiteList is called of domain " + paramString + " config " + localObject);
    }
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = ((JSONObject)localObject).optJSONArray("domains");
      if (localObject != null)
      {
        int m = ((JSONArray)localObject).length() - 1;
        while (m >= 0)
        {
          if (paramString.endsWith(((JSONArray)localObject).optString(m))) {
            return true;
          }
          m -= 1;
        }
      }
    }
    return false;
  }
  
  protected void loadConfig()
  {
    ThreadManager.executeOnSubThread(new AuthorizeConfig.1(this));
  }
  
  public boolean m(JSONObject paramJSONObject)
  {
    return arcp.b(paramJSONObject, "sonicWhiteList");
  }
  
  public void reload()
  {
    SharedPreferences.Editor localEditor = this.mPref.edit();
    localEditor.remove("lastVersion");
    localEditor.commit();
    this.jdField_I_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    M(false);
  }
  
  public boolean xW()
  {
    String str = jnx.hB();
    if (!TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "CgiConfig sp content: " + str);
      }
    }
    for (;;)
    {
      try
      {
        this.j = new JSONArray(str);
        if (this.j == null) {
          break;
        }
        return true;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AuthorizeConfig", 2, "CgiConfig load exception: " + localJSONException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "CgiConfig sp content empty!");
      }
    }
    return false;
  }
  
  public boolean xX()
  {
    String str = jnx.hC();
    if (!TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig sp content: " + str);
      }
    }
    for (;;)
    {
      try
      {
        this.k = new JSONArray(str);
        if (this.k == null) {
          break;
        }
        return true;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig load exception: " + localJSONException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig sp content empty!");
      }
    }
    return false;
  }
  
  public boolean xY()
  {
    String str = jnx.hD();
    if (!TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig sp content: " + str);
      }
    }
    for (;;)
    {
      try
      {
        this.n = new JSONArray(str);
        if (this.n == null) {
          break;
        }
        return true;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig load exception: " + localJSONException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig sp content empty!");
      }
    }
    return false;
  }
  
  public boolean xZ()
  {
    boolean bool = true;
    try
    {
      if ((this.aBH == -1) && (!ya()))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "forceHttpsConfig loadfromsp fail");
          return false;
        }
      }
      else
      {
        int m = this.aBH;
        if (m == 1) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AuthorizeConfig", 2, "forceHttps enable check exception", localException);
      }
    }
  }
  
  /* Error */
  public boolean ya()
  {
    // Byte code:
    //   0: invokestatic 1192	jnx:mR	()I
    //   3: istore_2
    //   4: iload_2
    //   5: iconst_1
    //   6: if_icmpne +141 -> 147
    //   9: iconst_1
    //   10: istore_1
    //   11: aload_0
    //   12: iload_1
    //   13: putfield 159	jml:aBH	I
    //   16: invokestatic 1195	jnx:hE	()Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: invokestatic 248	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +167 -> 191
    //   27: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +29 -> 59
    //   33: ldc 188
    //   35: iconst_2
    //   36: new 311	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 1197
    //   46: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_3
    //   50: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: new 107	org/json/JSONArray
    //   63: dup
    //   64: aload_3
    //   65: invokespecial 377	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   68: putfield 1050	jml:p	Lorg/json/JSONArray;
    //   71: invokestatic 1200	jnx:hF	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload_3
    //   76: invokestatic 248	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +169 -> 248
    //   82: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +29 -> 114
    //   88: ldc 188
    //   90: iconst_2
    //   91: new 311	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 1202
    //   101: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_3
    //   105: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_0
    //   115: new 107	org/json/JSONArray
    //   118: dup
    //   119: aload_3
    //   120: invokespecial 377	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   123: putfield 1064	jml:r	Lorg/json/JSONArray;
    //   126: iload_2
    //   127: iconst_m1
    //   128: if_icmpeq +138 -> 266
    //   131: aload_0
    //   132: getfield 1050	jml:p	Lorg/json/JSONArray;
    //   135: ifnull +131 -> 266
    //   138: aload_0
    //   139: getfield 1064	jml:r	Lorg/json/JSONArray;
    //   142: ifnull +124 -> 266
    //   145: iconst_1
    //   146: ireturn
    //   147: iconst_0
    //   148: istore_1
    //   149: goto -138 -> 11
    //   152: astore_3
    //   153: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -85 -> 71
    //   159: ldc 188
    //   161: iconst_2
    //   162: new 311	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 1204
    //   172: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_3
    //   176: invokevirtual 395	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   179: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: goto -117 -> 71
    //   191: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq -123 -> 71
    //   197: ldc 188
    //   199: iconst_2
    //   200: ldc_w 1206
    //   203: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: goto -135 -> 71
    //   209: astore_3
    //   210: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq -87 -> 126
    //   216: ldc 188
    //   218: iconst_2
    //   219: new 311	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 1208
    //   229: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_3
    //   233: invokevirtual 395	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: goto -119 -> 126
    //   248: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq -125 -> 126
    //   254: ldc 188
    //   256: iconst_2
    //   257: ldc_w 1210
    //   260: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: goto -137 -> 126
    //   266: iconst_0
    //   267: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	jml
    //   10	139	1	m	int
    //   3	126	2	i1	int
    //   19	101	3	str	String
    //   152	24	3	localJSONException1	JSONException
    //   209	24	3	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   59	71	152	org/json/JSONException
    //   114	126	209	org/json/JSONException
  }
  
  public boolean z(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    Uri localUri = Uri.parse(paramString1);
    String str = localUri.getScheme();
    if ("file".equals(str))
    {
      if (paramString1.length() > 200) {
        paramString1 = paramString1.substring(0, 200);
      }
      for (;;)
      {
        apue.m("webview", "file_js", paramString1, "", "", "");
        QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
        return false;
      }
    }
    if ((!"http".equals(str)) && (!"https".equals(str))) {
      return false;
    }
    if ("data.checkPermission".equals(paramString2)) {
      return paramString1.startsWith("https://qqweb.qq.com/m/whitelist/testing/");
    }
    if (paramString2.startsWith("CAPTCHA.")) {
      return true;
    }
    if ((paramString2.startsWith("login.openSmsPage")) && ("ti.qq.com".equals(localUri.getHost()))) {
      return true;
    }
    if (paramString2.equals("identification.loginVerify")) {
      return true;
    }
    if ("faceUnblockCamera.startPTVActivity".equals(paramString2)) {
      return true;
    }
    if (("qbizApi.getClientInfo".equals(paramString2)) && (paramString1.startsWith("https://mysec.qq.com/v2/account_control/index.html"))) {
      return true;
    }
    System.currentTimeMillis();
    int m = this.jdField_a_of_type_Jop.h(localUri.getHost(), paramString2);
    if (jon.cR(m)) {
      return true;
    }
    if (jon.y(m)) {
      return false;
    }
    if ("publicAccountNew.config".equals(paramString2)) {
      return true;
    }
    if (obw.ev(paramString1)) {
      return (!TextUtils.isEmpty(paramString2)) && (obw.K(paramString1, paramString2));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jml
 * JD-Core Version:    0.7.0.1
 */