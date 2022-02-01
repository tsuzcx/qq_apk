import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aidi
  extends WebViewPlugin
{
  private String appType;
  protected String bNb;
  protected BroadcastReceiver bm = new aidj(this);
  private int dcZ = -1;
  private String mAction;
  protected skj mClient;
  protected Context mContext;
  private int mCurrentProgress;
  private long mStartTime;
  private int mState;
  private Handler mUIHandler = new aidk(this, Looper.getMainLooper());
  protected String pluginPackageName;
  
  public aidi()
  {
    this.mPluginNameSpace = "huayang";
  }
  
  private void cVD()
  {
    try
    {
      this.mContext.unregisterReceiver(this.bm);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private JSONObject i(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("state", Integer.valueOf(paramInt));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangJsPlugin", 2, paramString);
    }
  }
  
  public static String lu(String paramString)
  {
    return "com.tencent.mobileqq.intervideo.huayang.downloadPreLoad" + paramString;
  }
  
  public static String lv(String paramString)
  {
    return "com.tencent.mobileqq.intervideo.backPressed" + paramString;
  }
  
  public static String lw(String paramString)
  {
    return "com.tencent.mobileqq.intervideo.userCacheState" + paramString;
  }
  
  public static String lx(String paramString)
  {
    return "com.tencent.mobileqq.huayang.launcher" + paramString;
  }
  
  public static boolean mU(String paramString)
  {
    return TextUtils.equals(paramString, "com.tencent.od");
  }
  
  public static boolean mV(String paramString)
  {
    return TextUtils.equals(paramString, "com.tencent.huayang");
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 51
    //   2: aload_3
    //   3: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +14 -> 20
    //   9: ldc 169
    //   11: aload_3
    //   12: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifne +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: new 125	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   27: ldc 171
    //   29: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload 4
    //   34: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 173
    //   39: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: astore_2
    //   43: aload 5
    //   45: ifnull +299 -> 344
    //   48: aload 5
    //   50: arraylength
    //   51: ifle +293 -> 344
    //   54: aload 5
    //   56: iconst_0
    //   57: aaload
    //   58: astore_1
    //   59: aload_0
    //   60: aload_2
    //   61: aload_1
    //   62: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 74	aidi:log	(Ljava/lang/String;)V
    //   71: ldc 175
    //   73: aload 4
    //   75: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +510 -> 588
    //   81: ldc 177
    //   83: invokestatic 182	aids:Lb	(Ljava/lang/String;)V
    //   86: aconst_null
    //   87: astore 4
    //   89: aconst_null
    //   90: astore 8
    //   92: aconst_null
    //   93: astore 9
    //   95: aconst_null
    //   96: astore 10
    //   98: aload 8
    //   100: astore_3
    //   101: aload 9
    //   103: astore_2
    //   104: aload 10
    //   106: astore_1
    //   107: aload 5
    //   109: ifnull +351 -> 460
    //   112: aload 8
    //   114: astore_3
    //   115: aload 9
    //   117: astore_2
    //   118: aload 10
    //   120: astore_1
    //   121: aload 5
    //   123: arraylength
    //   124: ifle +336 -> 460
    //   127: aload 4
    //   129: astore_1
    //   130: new 93	org/json/JSONObject
    //   133: dup
    //   134: aload 5
    //   136: iconst_0
    //   137: aaload
    //   138: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   141: astore 5
    //   143: aload 4
    //   145: astore_1
    //   146: aload 5
    //   148: ldc 186
    //   150: invokevirtual 189	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   153: astore_3
    //   154: aload_3
    //   155: astore_1
    //   156: aload 5
    //   158: ldc 191
    //   160: invokevirtual 189	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore_2
    //   164: aload_2
    //   165: astore_1
    //   166: aload_0
    //   167: aload 5
    //   169: ldc 193
    //   171: invokevirtual 189	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: putfield 195	aidi:bNb	Ljava/lang/String;
    //   177: aload_0
    //   178: aload 5
    //   180: ldc 197
    //   182: invokevirtual 189	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: putfield 64	aidi:mAction	Ljava/lang/String;
    //   188: aload_0
    //   189: aload 5
    //   191: ldc 198
    //   193: invokevirtual 189	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: putfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   199: aload 5
    //   201: ldc 202
    //   203: invokevirtual 189	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 4
    //   208: aload_0
    //   209: aload 5
    //   211: ldc 203
    //   213: invokevirtual 189	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   216: putfield 205	aidi:appType	Ljava/lang/String;
    //   219: aload 5
    //   221: ldc 207
    //   223: invokevirtual 189	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore_2
    //   227: aload 5
    //   229: ldc 209
    //   231: invokevirtual 189	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   234: astore 8
    //   236: aload 5
    //   238: ldc 211
    //   240: invokevirtual 215	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   243: i2l
    //   244: lstore 6
    //   246: aload 8
    //   248: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifne +99 -> 350
    //   254: new 221	android/content/Intent
    //   257: dup
    //   258: aload_0
    //   259: getfield 83	aidi:mContext	Landroid/content/Context;
    //   262: ldc 223
    //   264: invokespecial 226	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   267: astore_2
    //   268: aload_2
    //   269: ldc 211
    //   271: lload 6
    //   273: invokevirtual 230	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   276: pop
    //   277: aload_2
    //   278: ldc 232
    //   280: aload_0
    //   281: getfield 205	aidi:appType	Ljava/lang/String;
    //   284: invokevirtual 235	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   287: pop
    //   288: aload_2
    //   289: ldc 198
    //   291: aload_0
    //   292: getfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   295: invokevirtual 235	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   298: pop
    //   299: aload_2
    //   300: ldc 202
    //   302: aload 4
    //   304: invokevirtual 235	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   307: pop
    //   308: aload_2
    //   309: ldc 197
    //   311: aload_0
    //   312: getfield 64	aidi:mAction	Ljava/lang/String;
    //   315: invokevirtual 235	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   318: pop
    //   319: aload_2
    //   320: ldc 191
    //   322: aload_1
    //   323: invokevirtual 235	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   326: pop
    //   327: aload_2
    //   328: ldc 236
    //   330: invokevirtual 240	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   333: pop
    //   334: aload_0
    //   335: getfield 83	aidi:mContext	Landroid/content/Context;
    //   338: aload_2
    //   339: invokevirtual 244	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   342: iconst_1
    //   343: ireturn
    //   344: ldc 246
    //   346: astore_1
    //   347: goto -288 -> 59
    //   350: aload_0
    //   351: getfield 83	aidi:mContext	Landroid/content/Context;
    //   354: aload_0
    //   355: getfield 205	aidi:appType	Ljava/lang/String;
    //   358: aload_2
    //   359: invokestatic 252	aidt:B	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   362: aload_1
    //   363: astore_2
    //   364: aload_1
    //   365: ifnull +10 -> 375
    //   368: aload_1
    //   369: ldc 254
    //   371: invokestatic 260	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   374: astore_2
    //   375: aload 4
    //   377: astore_1
    //   378: aload_0
    //   379: getfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   382: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   385: ifeq +9 -> 394
    //   388: aload_0
    //   389: ldc 158
    //   391: putfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   394: new 262	android/content/IntentFilter
    //   397: dup
    //   398: aload_0
    //   399: getfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   402: invokestatic 264	aidi:lu	(Ljava/lang/String;)Ljava/lang/String;
    //   405: invokespecial 265	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   408: astore 4
    //   410: aload 4
    //   412: aload_0
    //   413: getfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   416: invokestatic 267	aidi:lv	(Ljava/lang/String;)Ljava/lang/String;
    //   419: invokevirtual 270	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   422: aload 4
    //   424: aload_0
    //   425: getfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   428: invokestatic 272	aidi:lw	(Ljava/lang/String;)Ljava/lang/String;
    //   431: invokevirtual 270	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   434: aload 4
    //   436: aload_0
    //   437: getfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   440: invokestatic 274	aidi:lx	(Ljava/lang/String;)Ljava/lang/String;
    //   443: invokevirtual 270	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   446: aload_0
    //   447: getfield 83	aidi:mContext	Landroid/content/Context;
    //   450: aload_0
    //   451: getfield 36	aidi:bm	Landroid/content/BroadcastReceiver;
    //   454: aload 4
    //   456: invokevirtual 278	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   459: pop
    //   460: aload_0
    //   461: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   464: putfield 286	aidi:mStartTime	J
    //   467: aload_0
    //   468: getfield 288	aidi:mClient	Lskj;
    //   471: aload_0
    //   472: getfield 205	aidi:appType	Ljava/lang/String;
    //   475: aload_3
    //   476: aload_2
    //   477: aload_0
    //   478: getfield 64	aidi:mAction	Ljava/lang/String;
    //   481: aload_0
    //   482: getfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   485: aload_1
    //   486: invokevirtual 294	skj:g	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   489: ldc 51
    //   491: ldc_w 296
    //   494: aload_0
    //   495: getfield 60	aidi:mState	I
    //   498: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   501: aload_0
    //   502: getfield 286	aidi:mStartTime	J
    //   505: lsub
    //   506: l2i
    //   507: iconst_4
    //   508: anewarray 164	java/lang/String
    //   511: dup
    //   512: iconst_0
    //   513: aload_0
    //   514: getfield 64	aidi:mAction	Ljava/lang/String;
    //   517: aastore
    //   518: dup
    //   519: iconst_1
    //   520: aconst_null
    //   521: aastore
    //   522: dup
    //   523: iconst_2
    //   524: aload_0
    //   525: getfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   528: aastore
    //   529: dup
    //   530: iconst_3
    //   531: ldc_w 298
    //   534: aastore
    //   535: invokestatic 303	rar:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   538: iconst_1
    //   539: ireturn
    //   540: astore_2
    //   541: aload_2
    //   542: invokevirtual 304	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   545: aconst_null
    //   546: astore_2
    //   547: goto -172 -> 375
    //   550: astore 4
    //   552: aconst_null
    //   553: astore_2
    //   554: aconst_null
    //   555: astore 5
    //   557: aload_1
    //   558: astore_3
    //   559: aload 5
    //   561: astore_1
    //   562: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +15 -> 580
    //   568: ldc 117
    //   570: iconst_2
    //   571: aload 4
    //   573: iconst_0
    //   574: anewarray 306	java/lang/Object
    //   577: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   580: aload 4
    //   582: invokestatic 316	aide:j	(Ljava/lang/Throwable;)V
    //   585: goto -207 -> 378
    //   588: ldc_w 318
    //   591: aload 4
    //   593: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   596: ifeq +153 -> 749
    //   599: aload_0
    //   600: getfield 288	aidi:mClient	Lskj;
    //   603: aload_0
    //   604: getfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   607: aload_0
    //   608: getfield 205	aidi:appType	Ljava/lang/String;
    //   611: invokevirtual 322	skj:cF	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload_0
    //   615: getfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   618: invokestatic 324	aidi:mU	(Ljava/lang/String;)Z
    //   621: ifeq +67 -> 688
    //   624: ldc_w 326
    //   627: invokestatic 182	aids:Lb	(Ljava/lang/String;)V
    //   630: aload_0
    //   631: invokespecial 328	aidi:cVD	()V
    //   634: ldc 51
    //   636: ldc_w 318
    //   639: aload_0
    //   640: getfield 60	aidi:mState	I
    //   643: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   646: aload_0
    //   647: getfield 286	aidi:mStartTime	J
    //   650: lsub
    //   651: l2i
    //   652: iconst_4
    //   653: anewarray 164	java/lang/String
    //   656: dup
    //   657: iconst_0
    //   658: aload_0
    //   659: getfield 29	aidi:dcZ	I
    //   662: invokestatic 331	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   665: aastore
    //   666: dup
    //   667: iconst_1
    //   668: aconst_null
    //   669: aastore
    //   670: dup
    //   671: iconst_2
    //   672: aload_0
    //   673: getfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   676: aastore
    //   677: dup
    //   678: iconst_3
    //   679: ldc_w 298
    //   682: aastore
    //   683: invokestatic 303	rar:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   686: iconst_0
    //   687: ireturn
    //   688: aload_0
    //   689: getfield 200	aidi:pluginPackageName	Ljava/lang/String;
    //   692: invokestatic 333	aidi:mV	(Ljava/lang/String;)Z
    //   695: ifeq +12 -> 707
    //   698: ldc_w 335
    //   701: invokestatic 182	aids:Lb	(Ljava/lang/String;)V
    //   704: goto -74 -> 630
    //   707: getstatic 339	aidt:ls	Ljava/util/Map;
    //   710: aload_0
    //   711: getfield 205	aidi:appType	Ljava/lang/String;
    //   714: invokeinterface 345 2 0
    //   719: ifnull -89 -> 630
    //   722: getstatic 339	aidt:ls	Ljava/util/Map;
    //   725: aload_0
    //   726: getfield 205	aidi:appType	Ljava/lang/String;
    //   729: invokeinterface 345 2 0
    //   734: checkcast 248	aidt
    //   737: getfield 348	aidt:ddh	I
    //   740: invokestatic 331	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   743: invokestatic 351	aids:report	(Ljava/lang/String;)V
    //   746: goto -116 -> 630
    //   749: ldc_w 353
    //   752: aload 4
    //   754: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   757: ifeq -71 -> 686
    //   760: new 221	android/content/Intent
    //   763: dup
    //   764: aload_0
    //   765: getfield 83	aidi:mContext	Landroid/content/Context;
    //   768: ldc 223
    //   770: invokespecial 226	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   773: astore_1
    //   774: aload_1
    //   775: ldc 236
    //   777: invokevirtual 240	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   780: pop
    //   781: aload_1
    //   782: ldc_w 355
    //   785: aload 5
    //   787: iconst_0
    //   788: aaload
    //   789: invokevirtual 235	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   792: pop
    //   793: aload_1
    //   794: ldc_w 357
    //   797: iconst_1
    //   798: invokevirtual 360	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   801: pop
    //   802: aload_0
    //   803: getfield 83	aidi:mContext	Landroid/content/Context;
    //   806: aload_1
    //   807: invokevirtual 244	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   810: goto -124 -> 686
    //   813: astore 4
    //   815: aload_1
    //   816: astore_2
    //   817: aconst_null
    //   818: astore_1
    //   819: goto -257 -> 562
    //   822: astore 5
    //   824: aload_1
    //   825: astore_2
    //   826: aload 4
    //   828: astore_1
    //   829: aload 5
    //   831: astore 4
    //   833: goto -271 -> 562
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	836	0	this	aidi
    //   0	836	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	836	2	paramString1	String
    //   0	836	3	paramString2	String
    //   0	836	4	paramString3	String
    //   0	836	5	paramVarArgs	String[]
    //   244	28	6	l	long
    //   90	157	8	str	String
    //   93	23	9	localObject1	java.lang.Object
    //   96	23	10	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   368	375	540	java/io/UnsupportedEncodingException
    //   130	143	550	org/json/JSONException
    //   146	154	550	org/json/JSONException
    //   156	164	550	org/json/JSONException
    //   166	208	813	org/json/JSONException
    //   208	342	822	org/json/JSONException
    //   350	362	822	org/json/JSONException
    //   368	375	822	org/json/JSONException
    //   541	545	822	org/json/JSONException
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mClient = skj.a();
    this.mClient.bzj();
    this.mContext = this.mRuntime.getActivity().getApplicationContext();
    log(" onCreate");
  }
  
  public void onDestroy()
  {
    if (this.mClient != null)
    {
      this.mClient.cF(this.pluginPackageName, this.appType);
      this.mClient.bzk();
    }
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("HuayangJsPlugin", 2, " onDestroy");
    }
    aids.Lb("2597860");
    cVD();
    this.mUIHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidi
 * JD-Core Version:    0.7.0.1
 */