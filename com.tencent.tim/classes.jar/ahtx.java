import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;

public class ahtx
  extends WebViewPlugin
{
  public ahtx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterInterruptPlugin", 2, "GameCenterInterruptPlugin init");
    }
    this.mPluginNameSpace = "gameCenter";
  }
  
  private WadlParams a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    WadlParams localWadlParams = new WadlParams();
    localWadlParams.from = 6;
    localWadlParams.setFlags(1);
    localWadlParams.setFlags(2);
    localWadlParams.setFlags(4);
    localWadlParams.apkUrl = paramString1;
    localWadlParams.appId = paramString2;
    localWadlParams.versionCode = 0;
    localWadlParams.packageName = paramString3;
    localWadlParams.appName = paramString4;
    localWadlParams.via = "GameCenterIntterup";
    localWadlParams.ekZ = 2;
    localWadlParams.bLE = "interrupt";
    localWadlParams.sourceId = "biz_src_zf_games";
    return localWadlParams;
  }
  
  /* Error */
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +479 -> 482
    //   6: aload_1
    //   7: ldc 83
    //   9: invokevirtual 89	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12: ifne +6 -> 18
    //   15: goto +467 -> 482
    //   18: invokestatic 94	asbw:a	()Lasbw;
    //   21: ldc 96
    //   23: invokevirtual 100	asbw:w	(Ljava/lang/String;)Ljava/lang/Object;
    //   26: checkcast 102	asbv
    //   29: astore 5
    //   31: aload 5
    //   33: ifnull +451 -> 484
    //   36: aload 5
    //   38: aload_1
    //   39: invokevirtual 105	asbv:a	(Ljava/lang/String;)Lasbr;
    //   42: astore_2
    //   43: invokestatic 14	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +37 -> 83
    //   49: ldc 16
    //   51: iconst_1
    //   52: new 107	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   59: ldc 110
    //   61: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 116
    //   70: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_2
    //   74: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_2
    //   84: ifnull +16 -> 100
    //   87: invokestatic 129	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   90: aload_2
    //   91: getfield 134	asbr:pkgName	Ljava/lang/String;
    //   94: invokestatic 140	aqiz:isAppInstalled	(Landroid/content/Context;Ljava/lang/String;)Z
    //   97: ifeq +46 -> 143
    //   100: invokestatic 145	ascg:a	()Lascg;
    //   103: astore 4
    //   105: new 147	java/net/URL
    //   108: dup
    //   109: aload_1
    //   110: invokespecial 150	java/net/URL:<init>	(Ljava/lang/String;)V
    //   113: invokevirtual 153	java/net/URL:getHost	()Ljava/lang/String;
    //   116: astore_2
    //   117: aload 4
    //   119: aload_1
    //   120: putfield 156	ascg:bXT	Ljava/lang/String;
    //   123: aload 4
    //   125: aload_2
    //   126: putfield 159	ascg:cEl	Ljava/lang/String;
    //   129: invokestatic 164	awot:a	()Lawot;
    //   132: ldc 166
    //   134: ldc 168
    //   136: aload 4
    //   138: invokevirtual 172	awot:c	(Ljava/lang/String;Ljava/lang/String;Lascg;)V
    //   141: iconst_0
    //   142: ireturn
    //   143: ldc 16
    //   145: iconst_1
    //   146: new 107	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   153: ldc 174
    //   155: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_2
    //   159: getfield 177	asbr:channel	Ljava/lang/String;
    //   162: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 179
    //   167: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_2
    //   171: getfield 134	asbr:pkgName	Ljava/lang/String;
    //   174: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc 181
    //   179: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_2
    //   183: getfield 182	asbr:appId	Ljava/lang/String;
    //   186: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc 184
    //   191: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_2
    //   195: getfield 185	asbr:appName	Ljava/lang/String;
    //   198: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 187
    //   203: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_1
    //   207: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 190	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload_0
    //   217: getfield 194	ahtx:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   220: ifnull +269 -> 489
    //   223: aload_0
    //   224: getfield 194	ahtx:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   227: invokevirtual 200	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   230: astore_3
    //   231: aload_3
    //   232: ifnull +242 -> 474
    //   235: ldc 16
    //   237: iconst_1
    //   238: new 107	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   245: ldc 202
    //   247: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_3
    //   251: invokevirtual 207	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   254: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc 187
    //   259: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_3
    //   263: invokevirtual 210	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   266: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 190	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_0
    //   276: aload_2
    //   277: getfield 213	asbr:cEf	Ljava/lang/String;
    //   280: aload_2
    //   281: getfield 182	asbr:appId	Ljava/lang/String;
    //   284: aload_2
    //   285: getfield 134	asbr:pkgName	Ljava/lang/String;
    //   288: aload_2
    //   289: getfield 185	asbr:appName	Ljava/lang/String;
    //   292: invokespecial 215	ahtx:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcooperation/wadl/ipc/WadlParams;
    //   295: astore 6
    //   297: aload 6
    //   299: aload_2
    //   300: getfield 177	asbr:channel	Ljava/lang/String;
    //   303: putfield 218	cooperation/wadl/ipc/WadlParams:apkChannel	Ljava/lang/String;
    //   306: aload_3
    //   307: invokevirtual 210	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   310: astore 4
    //   312: aload 4
    //   314: astore_1
    //   315: aload 4
    //   317: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   320: ifeq +8 -> 328
    //   323: aload_3
    //   324: invokevirtual 207	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   327: astore_1
    //   328: aload 6
    //   330: aload_1
    //   331: putfield 226	cooperation/wadl/ipc/WadlParams:extraData	Ljava/lang/String;
    //   334: aload 6
    //   336: getfield 226	cooperation/wadl/ipc/WadlParams:extraData	Ljava/lang/String;
    //   339: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   342: ifeq +10 -> 352
    //   345: aload 6
    //   347: ldc 228
    //   349: putfield 226	cooperation/wadl/ipc/WadlParams:extraData	Ljava/lang/String;
    //   352: invokestatic 233	awok:eEF	()V
    //   355: invokestatic 236	awok:a	()Lawol;
    //   358: aload 6
    //   360: invokevirtual 242	awol:h	(Lcooperation/wadl/ipc/WadlParams;)V
    //   363: aload 5
    //   365: ifnull +73 -> 438
    //   368: aload 5
    //   370: getfield 245	asbv:cEh	Ljava/lang/String;
    //   373: astore_1
    //   374: aload_1
    //   375: astore 4
    //   377: aload_1
    //   378: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   381: ifeq +7 -> 388
    //   384: ldc 247
    //   386: astore 4
    //   388: aload_3
    //   389: aload 4
    //   391: invokevirtual 250	com/tencent/biz/pubaccount/CustomWebView:loadUrl	(Ljava/lang/String;)V
    //   394: aconst_null
    //   395: ldc 252
    //   397: ldc 254
    //   399: aload_2
    //   400: getfield 182	asbr:appId	Ljava/lang/String;
    //   403: ldc_w 256
    //   406: ldc_w 258
    //   409: ldc_w 260
    //   412: invokestatic 265	tbb:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   415: invokestatic 145	ascg:a	()Lascg;
    //   418: astore_1
    //   419: aload_1
    //   420: aload 6
    //   422: invokevirtual 268	ascg:f	(Lcooperation/wadl/ipc/WadlParams;)V
    //   425: invokestatic 164	awot:a	()Lawot;
    //   428: ldc 254
    //   430: ldc 168
    //   432: aload_1
    //   433: invokevirtual 172	awot:c	(Ljava/lang/String;Ljava/lang/String;Lascg;)V
    //   436: iconst_1
    //   437: ireturn
    //   438: ldc 247
    //   440: astore_1
    //   441: goto -67 -> 374
    //   444: astore_1
    //   445: ldc 16
    //   447: iconst_1
    //   448: new 107	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   455: ldc_w 270
    //   458: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload_1
    //   462: invokevirtual 271	java/lang/Exception:toString	()Ljava/lang/String;
    //   465: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   474: iconst_0
    //   475: ireturn
    //   476: astore_2
    //   477: aload_3
    //   478: astore_2
    //   479: goto -362 -> 117
    //   482: iconst_0
    //   483: ireturn
    //   484: aconst_null
    //   485: astore_2
    //   486: goto -443 -> 43
    //   489: aconst_null
    //   490: astore_3
    //   491: goto -260 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	ahtx
    //   0	494	1	paramString1	String
    //   0	494	2	paramString2	String
    //   1	490	3	localCustomWebView	com.tencent.biz.pubaccount.CustomWebView
    //   103	287	4	localObject	java.lang.Object
    //   29	340	5	localasbv	asbv
    //   295	126	6	localWadlParams	WadlParams
    // Exception table:
    //   from	to	target	type
    //   6	15	444	java/lang/Exception
    //   18	31	444	java/lang/Exception
    //   36	43	444	java/lang/Exception
    //   43	83	444	java/lang/Exception
    //   87	100	444	java/lang/Exception
    //   100	105	444	java/lang/Exception
    //   105	117	444	java/lang/Exception
    //   117	141	444	java/lang/Exception
    //   143	231	444	java/lang/Exception
    //   235	312	444	java/lang/Exception
    //   315	328	444	java/lang/Exception
    //   328	352	444	java/lang/Exception
    //   352	363	444	java/lang/Exception
    //   368	374	444	java/lang/Exception
    //   377	384	444	java/lang/Exception
    //   388	436	444	java/lang/Exception
    //   105	117	476	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtx
 * JD-Core Version:    0.7.0.1
 */