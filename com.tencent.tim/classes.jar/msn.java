import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdVideoGuide.a;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

class msn
  implements ReadInJoyAdVideoGuide.a
{
  msn(msl parammsl, AdvertisementInfo paramAdvertisementInfo, mye.b paramb) {}
  
  /* Error */
  public void B(android.view.View paramView, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: getstatic 34	jzk:aGj	I
    //   4: if_icmpne +87 -> 91
    //   7: aload_0
    //   8: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   11: invokestatic 40	knd:j	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   14: ifeq +77 -> 91
    //   17: aload_0
    //   18: getfield 16	msn:a	Lmsl;
    //   21: invokestatic 45	msl:a	(Lmsl;)Landroid/app/Activity;
    //   24: aload_0
    //   25: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   28: getfield 51	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mPopFormH5Url	Ljava/lang/String;
    //   31: aload_0
    //   32: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   35: getfield 54	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdRl	Ljava/lang/String;
    //   38: aload_0
    //   39: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   42: getfield 57	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   45: invokestatic 63	ods:h	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   48: new 65	kku$a
    //   51: dup
    //   52: invokespecial 66	kku$a:<init>	()V
    //   55: aload_0
    //   56: getfield 16	msn:a	Lmsl;
    //   59: invokestatic 45	msl:a	(Lmsl;)Landroid/app/Activity;
    //   62: invokevirtual 69	kku$a:a	(Landroid/content/Context;)Lkku$a;
    //   65: getstatic 72	jzk:aFu	I
    //   68: invokevirtual 75	kku$a:a	(I)Lkku$a;
    //   71: getstatic 78	jzk:aFw	I
    //   74: invokevirtual 80	kku$a:b	(I)Lkku$a;
    //   77: aload_0
    //   78: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   81: invokevirtual 83	kku$a:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lkku$a;
    //   84: invokevirtual 86	kku$a:a	()Lkku;
    //   87: invokestatic 89	jzk:a	(Lkku;)V
    //   90: return
    //   91: iload_2
    //   92: getstatic 92	jzk:aGk	I
    //   95: if_icmpeq +56 -> 151
    //   98: aload_0
    //   99: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   102: getfield 95	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mImaxShowAdType	I
    //   105: sipush 1001
    //   108: if_icmpne +43 -> 151
    //   111: aload_0
    //   112: getfield 16	msn:a	Lmsl;
    //   115: invokestatic 45	msl:a	(Lmsl;)Landroid/app/Activity;
    //   118: aload_0
    //   119: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   122: getfield 98	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdLandingPage	Ljava/lang/String;
    //   125: aload_0
    //   126: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   129: invokestatic 101	ods:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   132: aload_0
    //   133: getfield 16	msn:a	Lmsl;
    //   136: invokestatic 45	msl:a	(Lmsl;)Landroid/app/Activity;
    //   139: aload_0
    //   140: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   143: iconst_0
    //   144: getstatic 104	jzk:aFR	I
    //   147: invokestatic 107	ods:a	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;II)V
    //   150: return
    //   151: new 65	kku$a
    //   154: dup
    //   155: invokespecial 66	kku$a:<init>	()V
    //   158: aload_1
    //   159: invokevirtual 113	android/view/View:getContext	()Landroid/content/Context;
    //   162: invokevirtual 69	kku$a:a	(Landroid/content/Context;)Lkku$a;
    //   165: getstatic 116	jzk:aEJ	I
    //   168: invokevirtual 75	kku$a:a	(I)Lkku$a;
    //   171: getstatic 78	jzk:aFw	I
    //   174: invokevirtual 80	kku$a:b	(I)Lkku$a;
    //   177: aload_0
    //   178: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   181: invokevirtual 83	kku$a:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lkku$a;
    //   184: iload_2
    //   185: invokevirtual 119	kku$a:d	(I)Lkku$a;
    //   188: invokevirtual 86	kku$a:a	()Lkku;
    //   191: invokestatic 89	jzk:a	(Lkku;)V
    //   194: iload_2
    //   195: getstatic 92	jzk:aGk	I
    //   198: if_icmpne +55 -> 253
    //   201: aload_0
    //   202: getfield 16	msn:a	Lmsl;
    //   205: invokestatic 122	msl:a	(Lmsl;)Ljava/util/concurrent/ConcurrentHashMap;
    //   208: aload_0
    //   209: getfield 20	msn:b	Lmye$b;
    //   212: getfield 127	mye$b:position	I
    //   215: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   218: invokevirtual 139	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   221: pop
    //   222: aload_0
    //   223: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   226: iconst_0
    //   227: putfield 143	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isShowingGuide	Z
    //   230: aload_0
    //   231: getfield 16	msn:a	Lmsl;
    //   234: iconst_0
    //   235: invokevirtual 146	msl:a	(Z)Lmye$b;
    //   238: astore_1
    //   239: aload_1
    //   240: ifnull -150 -> 90
    //   243: aload_0
    //   244: getfield 16	msn:a	Lmsl;
    //   247: aconst_null
    //   248: aload_1
    //   249: invokevirtual 149	msl:b	(Lmye$b;Lmye$b;)V
    //   252: return
    //   253: new 151	org/json/JSONObject
    //   256: dup
    //   257: aload_0
    //   258: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   261: getfield 154	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   264: invokespecial 157	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   267: astore_1
    //   268: aload_1
    //   269: ldc 159
    //   271: invokevirtual 163	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   274: astore 5
    //   276: aload_1
    //   277: ldc 165
    //   279: invokevirtual 163	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   282: pop
    //   283: aload_0
    //   284: getfield 16	msn:a	Lmsl;
    //   287: invokestatic 45	msl:a	(Lmsl;)Landroid/app/Activity;
    //   290: aload 5
    //   292: invokestatic 171	aqiz:isAppInstalled	(Landroid/content/Context;Ljava/lang/String;)Z
    //   295: istore_3
    //   296: aload 5
    //   298: invokestatic 177	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   301: ifne +187 -> 488
    //   304: aload_0
    //   305: getfield 16	msn:a	Lmsl;
    //   308: invokestatic 45	msl:a	(Lmsl;)Landroid/app/Activity;
    //   311: aload 5
    //   313: invokestatic 181	jzh:B	(Landroid/content/Context;Ljava/lang/String;)Z
    //   316: istore 4
    //   318: aload_0
    //   319: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   322: invokestatic 185	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   325: ifeq +95 -> 420
    //   328: iload_3
    //   329: ifne +8 -> 337
    //   332: iload 4
    //   334: ifeq +86 -> 420
    //   337: iload_3
    //   338: ifne +145 -> 483
    //   341: new 187	kks
    //   344: dup
    //   345: iconst_0
    //   346: invokespecial 190	kks:<init>	(Z)V
    //   349: astore_1
    //   350: aload_0
    //   351: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   354: iload_2
    //   355: aconst_null
    //   356: invokestatic 193	knd:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;ILcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)V
    //   359: aload_0
    //   360: getfield 16	msn:a	Lmsl;
    //   363: invokestatic 45	msl:a	(Lmsl;)Landroid/app/Activity;
    //   366: aload_0
    //   367: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   370: aconst_null
    //   371: aload_0
    //   372: getfield 16	msn:a	Lmsl;
    //   375: invokestatic 196	msl:a	(Lmsl;)I
    //   378: iconst_1
    //   379: aload_1
    //   380: invokestatic 200	ods:c	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lndi;IZLkks;)Z
    //   383: pop
    //   384: invokestatic 205	lbz:a	()Llbz;
    //   387: aload_0
    //   388: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   391: getfield 209	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mArticleID	J
    //   394: invokestatic 215	java/lang/System:currentTimeMillis	()J
    //   397: invokevirtual 219	lbz:H	(JJ)V
    //   400: aload_0
    //   401: getfield 16	msn:a	Lmsl;
    //   404: invokestatic 222	msl:a	(Lmsl;)Lndi;
    //   407: invokevirtual 227	ndi:notifyDataSetChanged	()V
    //   410: return
    //   411: astore_1
    //   412: iconst_0
    //   413: istore_3
    //   414: iconst_0
    //   415: istore 4
    //   417: goto -99 -> 318
    //   420: invokestatic 233	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   423: invokestatic 239	aqiw:getNetworkType	(Landroid/content/Context;)I
    //   426: iconst_1
    //   427: if_icmpne +51 -> 478
    //   430: iconst_1
    //   431: istore_3
    //   432: aload_0
    //   433: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   436: iload_2
    //   437: aconst_null
    //   438: invokestatic 193	knd:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;ILcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;)V
    //   441: aload_0
    //   442: getfield 16	msn:a	Lmsl;
    //   445: invokestatic 45	msl:a	(Lmsl;)Landroid/app/Activity;
    //   448: aload_0
    //   449: getfield 18	msn:f	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
    //   452: aload_0
    //   453: getfield 16	msn:a	Lmsl;
    //   456: invokestatic 222	msl:a	(Lmsl;)Lndi;
    //   459: aload_0
    //   460: getfield 16	msn:a	Lmsl;
    //   463: invokestatic 196	msl:a	(Lmsl;)I
    //   466: iload_3
    //   467: aconst_null
    //   468: invokestatic 242	ods:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lndi;IZLkks;)V
    //   471: goto -87 -> 384
    //   474: astore_1
    //   475: goto -61 -> 414
    //   478: iconst_0
    //   479: istore_3
    //   480: goto -48 -> 432
    //   483: aconst_null
    //   484: astore_1
    //   485: goto -135 -> 350
    //   488: iconst_0
    //   489: istore 4
    //   491: goto -173 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	msn
    //   0	494	1	paramView	android.view.View
    //   0	494	2	paramInt	int
    //   295	185	3	bool1	boolean
    //   316	174	4	bool2	boolean
    //   274	38	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   253	296	411	org/json/JSONException
    //   296	318	474	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msn
 * JD-Core Version:    0.7.0.1
 */