package com.tencent.mobileqq.webview.swift.component;

import android.content.Context;
import arbz;

public class SwiftBrowserStatistics$4
  implements Runnable
{
  public SwiftBrowserStatistics$4(arbz paramarbz, String paramString1, Context paramContext, long paramLong, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:val$reportUrl	Ljava/lang/String;
    //   4: invokestatic 42	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnull +124 -> 135
    //   14: aload 4
    //   16: invokevirtual 46	android/net/Uri:getHost	()Ljava/lang/String;
    //   19: astore 5
    //   21: aload 5
    //   23: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +13 -> 39
    //   29: aload 5
    //   31: ldc 54
    //   33: invokevirtual 60	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   36: ifne +33 -> 69
    //   39: aload_0
    //   40: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   43: getfield 66	arbz:a	Larbz$b;
    //   46: getfield 72	arbz$b:mCurrentStep	I
    //   49: bipush 11
    //   51: if_icmpge +18 -> 69
    //   54: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +678 -> 735
    //   60: ldc 80
    //   62: iconst_2
    //   63: ldc 82
    //   65: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: return
    //   69: aload 4
    //   71: ldc 88
    //   73: invokevirtual 92	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 5
    //   78: aload 5
    //   80: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   83: ifne +20 -> 103
    //   86: aload_0
    //   87: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   90: getfield 66	arbz:a	Larbz$b;
    //   93: aload 5
    //   95: ldc 94
    //   97: invokevirtual 97	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   100: putfield 101	arbz$b:dw	Z
    //   103: aload 4
    //   105: ldc 103
    //   107: invokevirtual 92	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore 4
    //   112: aload 4
    //   114: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +18 -> 135
    //   120: aload_0
    //   121: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   124: getfield 66	arbz:a	Larbz$b;
    //   127: aload 4
    //   129: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   132: putfield 112	arbz$b:eeo	I
    //   135: aload_0
    //   136: getfield 21	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:val$reportUrl	Ljava/lang/String;
    //   139: ldc 114
    //   141: invokevirtual 117	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   144: istore_1
    //   145: iload_1
    //   146: iconst_m1
    //   147: if_icmpeq +559 -> 706
    //   150: aload_0
    //   151: getfield 21	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:val$reportUrl	Ljava/lang/String;
    //   154: iconst_0
    //   155: iload_1
    //   156: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   159: astore 4
    //   161: bipush 10
    //   163: istore_1
    //   164: getstatic 125	arbz$b:pE	Ljava/util/HashMap;
    //   167: invokevirtual 129	java/util/HashMap:isEmpty	()Z
    //   170: ifeq +55 -> 225
    //   173: aload_0
    //   174: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   177: aload_0
    //   178: getfield 23	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:val$context	Landroid/content/Context;
    //   181: aload_0
    //   182: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   185: getfield 66	arbz:a	Larbz$b;
    //   188: invokevirtual 132	arbz:a	(Landroid/content/Context;Larbz$b;)V
    //   191: getstatic 125	arbz$b:pE	Ljava/util/HashMap;
    //   194: invokevirtual 129	java/util/HashMap:isEmpty	()Z
    //   197: ifne +14 -> 211
    //   200: getstatic 125	arbz$b:pE	Ljava/util/HashMap;
    //   203: ldc 134
    //   205: invokevirtual 138	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   208: ifne +17 -> 225
    //   211: getstatic 125	arbz$b:pE	Ljava/util/HashMap;
    //   214: ldc 134
    //   216: bipush 10
    //   218: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: invokevirtual 146	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   224: pop
    //   225: getstatic 125	arbz$b:pE	Ljava/util/HashMap;
    //   228: ldc 134
    //   230: invokevirtual 138	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   233: ifeq +18 -> 251
    //   236: getstatic 125	arbz$b:pE	Ljava/util/HashMap;
    //   239: ldc 134
    //   241: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   244: checkcast 105	java/lang/Integer
    //   247: invokevirtual 154	java/lang/Integer:intValue	()I
    //   250: istore_1
    //   251: getstatic 125	arbz$b:pE	Ljava/util/HashMap;
    //   254: aload 4
    //   256: invokevirtual 138	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   259: ifeq +471 -> 730
    //   262: getstatic 125	arbz$b:pE	Ljava/util/HashMap;
    //   265: aload 4
    //   267: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   270: checkcast 105	java/lang/Integer
    //   273: invokevirtual 154	java/lang/Integer:intValue	()I
    //   276: istore_2
    //   277: iconst_0
    //   278: istore_3
    //   279: invokestatic 160	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   282: invokevirtual 164	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   285: astore 6
    //   287: iload_3
    //   288: istore_1
    //   289: aload 6
    //   291: ifnull +445 -> 736
    //   294: iload_3
    //   295: istore_1
    //   296: aload 6
    //   298: invokevirtual 170	mqq/app/AppRuntime:getLongAccountUin	()J
    //   301: lconst_0
    //   302: lcmp
    //   303: ifeq +433 -> 736
    //   306: aload 6
    //   308: invokevirtual 170	mqq/app/AppRuntime:getLongAccountUin	()J
    //   311: iload_2
    //   312: i2l
    //   313: lrem
    //   314: aload_0
    //   315: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   318: getfield 66	arbz:a	Larbz$b;
    //   321: getfield 173	arbz$b:eep	I
    //   324: i2l
    //   325: lcmp
    //   326: ifne +389 -> 715
    //   329: iconst_1
    //   330: istore_1
    //   331: goto +405 -> 736
    //   334: iload_1
    //   335: ifeq +400 -> 735
    //   338: aload 4
    //   340: astore 5
    //   342: aload_0
    //   343: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   346: getfield 66	arbz:a	Larbz$b;
    //   349: getfield 112	arbz$b:eeo	I
    //   352: iconst_m1
    //   353: if_icmpeq +38 -> 391
    //   356: new 175	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   363: aload 4
    //   365: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc 182
    //   370: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_0
    //   374: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   377: getfield 66	arbz:a	Larbz$b;
    //   380: getfield 112	arbz$b:eeo	I
    //   383: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   386: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: astore 5
    //   391: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +129 -> 523
    //   397: ldc 80
    //   399: iconst_2
    //   400: new 175	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   407: ldc 190
    //   409: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_0
    //   413: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   416: getfield 66	arbz:a	Larbz$b;
    //   419: getfield 72	arbz$b:mCurrentStep	I
    //   422: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: ldc 192
    //   427: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_0
    //   431: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   434: getfield 66	arbz:a	Larbz$b;
    //   437: getfield 101	arbz$b:dw	Z
    //   440: invokevirtual 195	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   443: ldc 197
    //   445: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_0
    //   449: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   452: getfield 66	arbz:a	Larbz$b;
    //   455: getfield 112	arbz$b:eeo	I
    //   458: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   461: ldc 199
    //   463: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_0
    //   467: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   470: getfield 66	arbz:a	Larbz$b;
    //   473: getfield 202	arbz$b:aiB	J
    //   476: aload_0
    //   477: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   480: getfield 205	arbz:mClickTime	J
    //   483: lsub
    //   484: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: ldc 210
    //   489: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_0
    //   493: getfield 25	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:avn	J
    //   496: aload_0
    //   497: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   500: getfield 205	arbz:mClickTime	J
    //   503: lsub
    //   504: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   507: ldc 212
    //   509: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 5
    //   514: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aload_0
    //   524: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   527: aload_0
    //   528: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   531: getfield 66	arbz:a	Larbz$b;
    //   534: getfield 101	arbz$b:dw	Z
    //   537: aload 6
    //   539: invokevirtual 215	arbz:a	(ZLmqq/app/AppRuntime;)Ljava/lang/String;
    //   542: astore 6
    //   544: new 217	org/json/JSONObject
    //   547: dup
    //   548: invokespecial 218	org/json/JSONObject:<init>	()V
    //   551: astore 4
    //   553: new 217	org/json/JSONObject
    //   556: dup
    //   557: invokespecial 218	org/json/JSONObject:<init>	()V
    //   560: astore 7
    //   562: aload 7
    //   564: ldc 220
    //   566: aload 6
    //   568: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   571: pop
    //   572: aload 4
    //   574: ldc 225
    //   576: aload 7
    //   578: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   581: pop
    //   582: aload 4
    //   584: invokevirtual 226	org/json/JSONObject:toString	()Ljava/lang/String;
    //   587: astore 4
    //   589: aload_0
    //   590: getfield 27	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:bhz	Ljava/lang/String;
    //   593: astore 6
    //   595: aload_0
    //   596: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   599: getfield 66	arbz:a	Larbz$b;
    //   602: getfield 101	arbz$b:dw	Z
    //   605: ifeq +115 -> 720
    //   608: iconst_1
    //   609: istore_1
    //   610: aconst_null
    //   611: ldc 228
    //   613: ldc 230
    //   615: ldc 232
    //   617: aload 4
    //   619: aload 6
    //   621: iload_1
    //   622: iconst_1
    //   623: aload_0
    //   624: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   627: getfield 66	arbz:a	Larbz$b;
    //   630: getfield 72	arbz$b:mCurrentStep	I
    //   633: aload 5
    //   635: getstatic 237	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   638: aload_0
    //   639: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   642: getfield 66	arbz:a	Larbz$b;
    //   645: getfield 202	arbz$b:aiB	J
    //   648: aload_0
    //   649: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   652: getfield 205	arbz:mClickTime	J
    //   655: lsub
    //   656: invokestatic 240	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   659: aload_0
    //   660: getfield 25	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:avn	J
    //   663: aload_0
    //   664: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   667: getfield 205	arbz:mClickTime	J
    //   670: lsub
    //   671: invokestatic 240	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   674: invokestatic 246	anot:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   677: aload_0
    //   678: getfield 19	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:this$0	Larbz;
    //   681: getfield 66	arbz:a	Larbz$b;
    //   684: iconst_m1
    //   685: putfield 112	arbz$b:eeo	I
    //   688: iconst_m1
    //   689: putstatic 249	arbz$b:eeq	I
    //   692: return
    //   693: astore 4
    //   695: ldc 80
    //   697: iconst_1
    //   698: ldc 251
    //   700: aload 4
    //   702: invokestatic 255	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   705: return
    //   706: aload_0
    //   707: getfield 21	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics$4:val$reportUrl	Ljava/lang/String;
    //   710: astore 4
    //   712: goto -551 -> 161
    //   715: iconst_0
    //   716: istore_1
    //   717: goto +19 -> 736
    //   720: iconst_0
    //   721: istore_1
    //   722: goto -112 -> 610
    //   725: astore 6
    //   727: goto -145 -> 582
    //   730: iload_1
    //   731: istore_2
    //   732: goto -455 -> 277
    //   735: return
    //   736: iload_2
    //   737: iconst_1
    //   738: if_icmpne -404 -> 334
    //   741: iconst_1
    //   742: istore_1
    //   743: goto -409 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	746	0	this	4
    //   144	599	1	i	int
    //   276	463	2	j	int
    //   278	17	3	k	int
    //   7	611	4	localObject1	Object
    //   693	8	4	localThrowable	java.lang.Throwable
    //   710	1	4	str	String
    //   19	615	5	localObject2	Object
    //   285	335	6	localObject3	Object
    //   725	1	6	localJSONException	org.json.JSONException
    //   560	17	7	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	9	693	java/lang/Throwable
    //   14	39	693	java/lang/Throwable
    //   39	68	693	java/lang/Throwable
    //   69	103	693	java/lang/Throwable
    //   103	135	693	java/lang/Throwable
    //   135	145	693	java/lang/Throwable
    //   150	161	693	java/lang/Throwable
    //   164	211	693	java/lang/Throwable
    //   211	225	693	java/lang/Throwable
    //   225	251	693	java/lang/Throwable
    //   251	277	693	java/lang/Throwable
    //   279	287	693	java/lang/Throwable
    //   296	329	693	java/lang/Throwable
    //   342	391	693	java/lang/Throwable
    //   391	523	693	java/lang/Throwable
    //   523	562	693	java/lang/Throwable
    //   562	582	693	java/lang/Throwable
    //   582	608	693	java/lang/Throwable
    //   610	692	693	java/lang/Throwable
    //   706	712	693	java/lang/Throwable
    //   562	582	725	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.4
 * JD-Core Version:    0.7.0.1
 */