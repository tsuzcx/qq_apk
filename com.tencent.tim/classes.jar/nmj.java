import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class nmj
  implements ViewBase.OnClickListener
{
  nmj(nmi paramnmi) {}
  
  /* Error */
  public void onClick(com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase paramViewBase)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	nmj:a	Lnmi;
    //   4: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   7: getfield 34	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:aD	Lorg/json/JSONObject;
    //   10: astore 6
    //   12: aload_1
    //   13: invokevirtual 40	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getEventAttachedData	()Ljava/lang/String;
    //   16: astore_3
    //   17: aload_1
    //   18: invokevirtual 43	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getClickEvnet	()Ljava/lang/String;
    //   21: invokestatic 49	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/common/StringCommon:getStrIdFromString	(Ljava/lang/String;)I
    //   24: istore_2
    //   25: aload_0
    //   26: getfield 12	nmj:a	Lnmi;
    //   29: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   32: getfield 53	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:articleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   35: astore 4
    //   37: aload_0
    //   38: getfield 12	nmj:a	Lnmi;
    //   41: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   44: getfield 57	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:d	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;
    //   47: astore 5
    //   49: iload_2
    //   50: lookupswitch	default:+90->140, 1001:+561->611, 1002:+553->603, 1012:+320->370, 1023:+379->429, 1038:+773->823, 1040:+828->878, 1150:+720->770, 1153:+735->785, 1154:+576->626, 1166:+773->823
    //   141: iconst_3
    //   142: ifnull +1323 -> 1465
    //   145: aload 6
    //   147: ldc 59
    //   149: invokevirtual 65	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   152: ifnull +1313 -> 1465
    //   155: aload 6
    //   157: ldc 67
    //   159: invokevirtual 65	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   162: ifnull +1303 -> 1465
    //   165: ldc 69
    //   167: astore 5
    //   169: aload 5
    //   171: astore 4
    //   173: aload 6
    //   175: ldc 71
    //   177: invokevirtual 65	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   180: ifnull +35 -> 215
    //   183: aload 6
    //   185: ldc 71
    //   187: invokevirtual 75	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   190: astore 7
    //   192: aload 5
    //   194: astore 4
    //   196: aload 7
    //   198: ldc 77
    //   200: invokevirtual 65	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   203: ifnull +12 -> 215
    //   206: aload 7
    //   208: ldc 77
    //   210: invokevirtual 81	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   213: astore 4
    //   215: aload_0
    //   216: getfield 12	nmj:a	Lnmi;
    //   219: getfield 84	nmi:a	Lnmh$a;
    //   222: invokestatic 89	nmh$a:a	(Lnmh$a;)Z
    //   225: ifeq +717 -> 942
    //   228: ldc 91
    //   230: aload 4
    //   232: ldc 93
    //   234: invokestatic 99	kfq:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   237: invokestatic 103	kfq:ma	(Ljava/lang/String;)V
    //   240: ldc 91
    //   242: aload 4
    //   244: ldc 105
    //   246: invokestatic 99	kfq:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   249: invokestatic 103	kfq:ma	(Ljava/lang/String;)V
    //   252: aload_3
    //   253: astore 4
    //   255: aload_3
    //   256: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   259: ifne +23 -> 282
    //   262: aload_3
    //   263: aload 6
    //   265: invokestatic 116	kxm:a	(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    //   268: astore 4
    //   270: aload_0
    //   271: getfield 12	nmj:a	Lnmi;
    //   274: getfield 120	nmi:val$context	Landroid/content/Context;
    //   277: aload 4
    //   279: invokestatic 124	kxm:C	(Landroid/content/Context;Ljava/lang/String;)V
    //   282: aload_0
    //   283: getfield 12	nmj:a	Lnmi;
    //   286: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   289: getfield 128	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:mTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   292: aload_1
    //   293: invokevirtual 131	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   296: invokestatic 136	nns:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Ljava/lang/String;)Lorg/json/JSONObject;
    //   299: astore_3
    //   300: aload_0
    //   301: getfield 12	nmj:a	Lnmi;
    //   304: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   307: instanceof 138
    //   310: ifeq +619 -> 929
    //   313: aload_1
    //   314: invokevirtual 131	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   317: aload_0
    //   318: getfield 12	nmj:a	Lnmi;
    //   321: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   324: checkcast 138	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData
    //   327: aload_3
    //   328: invokestatic 141	nns:a	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData;Lorg/json/JSONObject;)V
    //   331: ldc 143
    //   333: iconst_1
    //   334: new 145	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   341: ldc 148
    //   343: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload 4
    //   348: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: ldc 154
    //   353: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_1
    //   357: invokevirtual 131	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   360: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: return
    //   370: aload_0
    //   371: getfield 12	nmj:a	Lnmi;
    //   374: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   377: instanceof 164
    //   380: ifeq -11 -> 369
    //   383: aload_0
    //   384: getfield 12	nmj:a	Lnmi;
    //   387: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   390: checkcast 164	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AuthorData
    //   393: invokevirtual 167	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AuthorData:aOi	()V
    //   396: aload_0
    //   397: getfield 12	nmj:a	Lnmi;
    //   400: getfield 84	nmi:a	Lnmh$a;
    //   403: getfield 170	nmh$a:a	Lnmh;
    //   406: invokestatic 175	nmh:a	(Lnmh;)Landroid/widget/BaseAdapter;
    //   409: ifnull -40 -> 369
    //   412: aload_0
    //   413: getfield 12	nmj:a	Lnmi;
    //   416: getfield 84	nmi:a	Lnmh$a;
    //   419: getfield 170	nmh$a:a	Lnmh;
    //   422: invokestatic 175	nmh:a	(Lnmh;)Landroid/widget/BaseAdapter;
    //   425: invokevirtual 180	android/widget/BaseAdapter:notifyDataSetChanged	()V
    //   428: return
    //   429: aload_0
    //   430: getfield 12	nmj:a	Lnmi;
    //   433: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   436: instanceof 164
    //   439: ifeq -70 -> 369
    //   442: aload_0
    //   443: getfield 12	nmj:a	Lnmi;
    //   446: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   449: checkcast 164	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AuthorData
    //   452: astore_3
    //   453: aload_3
    //   454: getfield 184	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AuthorData:alY	Ljava/lang/String;
    //   457: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   460: ifne -91 -> 369
    //   463: aload_3
    //   464: getfield 185	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AuthorData:articleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   467: ifnull -98 -> 369
    //   470: aload_3
    //   471: getfield 185	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AuthorData:articleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   474: putstatic 188	kxm:c	Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   477: aload_0
    //   478: getfield 12	nmj:a	Lnmi;
    //   481: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   484: checkcast 164	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AuthorData
    //   487: getfield 191	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AuthorData:hH	Ljava/lang/String;
    //   490: astore_1
    //   491: new 145	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   498: getstatic 196	kwt:acJ	Ljava/lang/String;
    //   501: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload_1
    //   505: invokestatic 202	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   508: invokevirtual 206	java/lang/String:getBytes	()[B
    //   511: iconst_2
    //   512: invokestatic 212	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   515: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: astore_1
    //   522: aload_0
    //   523: getfield 12	nmj:a	Lnmi;
    //   526: getfield 84	nmi:a	Lnmh$a;
    //   529: getfield 216	nmh$a:itemView	Landroid/view/View;
    //   532: invokevirtual 222	android/view/View:getContext	()Landroid/content/Context;
    //   535: aload_1
    //   536: invokestatic 225	kxm:aJ	(Landroid/content/Context;Ljava/lang/String;)V
    //   539: aload_0
    //   540: getfield 12	nmj:a	Lnmi;
    //   543: getfield 84	nmi:a	Lnmh$a;
    //   546: getfield 216	nmh$a:itemView	Landroid/view/View;
    //   549: invokevirtual 222	android/view/View:getContext	()Landroid/content/Context;
    //   552: astore 4
    //   554: aload_3
    //   555: getfield 185	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AuthorData:articleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   558: astore 5
    //   560: aload_3
    //   561: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AuthorData:d	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;
    //   564: invokevirtual 232	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo:FP	()Z
    //   567: ifeq +30 -> 597
    //   570: ldc 234
    //   572: astore_1
    //   573: aload 4
    //   575: aload 5
    //   577: iconst_0
    //   578: aload_1
    //   579: invokestatic 237	kxm:a	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;ILjava/lang/String;)Lorg/json/JSONObject;
    //   582: astore_1
    //   583: aload_3
    //   584: getfield 185	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AuthorData:articleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   587: ldc 239
    //   589: aload_1
    //   590: invokevirtual 240	org/json/JSONObject:toString	()Ljava/lang/String;
    //   593: invokestatic 243	nns:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   596: return
    //   597: ldc 245
    //   599: astore_1
    //   600: goto -27 -> 573
    //   603: aload 4
    //   605: aload 5
    //   607: invokestatic 250	nmv:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)V
    //   610: return
    //   611: aload_0
    //   612: getfield 12	nmj:a	Lnmi;
    //   615: getfield 120	nmi:val$context	Landroid/content/Context;
    //   618: aload 4
    //   620: aload 5
    //   622: invokestatic 253	nmv:a	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)V
    //   625: return
    //   626: aload_0
    //   627: getfield 12	nmj:a	Lnmi;
    //   630: getfield 84	nmi:a	Lnmh$a;
    //   633: getfield 170	nmh$a:a	Lnmh;
    //   636: invokestatic 175	nmh:a	(Lnmh;)Landroid/widget/BaseAdapter;
    //   639: ifnull -270 -> 369
    //   642: aload_0
    //   643: getfield 12	nmj:a	Lnmi;
    //   646: getfield 84	nmi:a	Lnmh$a;
    //   649: getfield 170	nmh$a:a	Lnmh;
    //   652: invokestatic 175	nmh:a	(Lnmh;)Landroid/widget/BaseAdapter;
    //   655: instanceof 255
    //   658: ifeq -289 -> 369
    //   661: aload_0
    //   662: getfield 12	nmj:a	Lnmi;
    //   665: getfield 120	nmi:val$context	Landroid/content/Context;
    //   668: instanceof 257
    //   671: ifeq -302 -> 369
    //   674: aload_0
    //   675: getfield 12	nmj:a	Lnmi;
    //   678: getfield 84	nmi:a	Lnmh$a;
    //   681: invokestatic 260	nmh$a:a	(Lnmh$a;)Ljava/util/ArrayList;
    //   684: ifnonnull +21 -> 705
    //   687: aload_0
    //   688: getfield 12	nmj:a	Lnmi;
    //   691: getfield 84	nmi:a	Lnmh$a;
    //   694: new 262	java/util/ArrayList
    //   697: dup
    //   698: invokespecial 263	java/util/ArrayList:<init>	()V
    //   701: invokestatic 266	nmh$a:a	(Lnmh$a;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   704: pop
    //   705: aload_0
    //   706: getfield 12	nmj:a	Lnmi;
    //   709: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   712: getfield 53	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:articleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   715: aload_0
    //   716: getfield 12	nmj:a	Lnmi;
    //   719: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   722: getfield 57	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:d	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;
    //   725: aload_0
    //   726: getfield 12	nmj:a	Lnmi;
    //   729: getfield 120	nmi:val$context	Landroid/content/Context;
    //   732: checkcast 257	com/tencent/biz/pubaccount/readinjoy/view/fastweb/FastWebActivity
    //   735: aload 6
    //   737: aload_0
    //   738: getfield 12	nmj:a	Lnmi;
    //   741: getfield 84	nmi:a	Lnmh$a;
    //   744: getfield 170	nmh$a:a	Lnmh;
    //   747: invokestatic 175	nmh:a	(Lnmh;)Landroid/widget/BaseAdapter;
    //   750: checkcast 255	nle
    //   753: invokevirtual 270	nle:bi	()Ljava/util/List;
    //   756: aload_0
    //   757: getfield 12	nmj:a	Lnmi;
    //   760: getfield 84	nmi:a	Lnmh$a;
    //   763: invokestatic 260	nmh$a:a	(Lnmh$a;)Ljava/util/ArrayList;
    //   766: invokestatic 275	nmw:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/FastWebActivity;Lorg/json/JSONObject;Ljava/util/List;Ljava/util/ArrayList;)V
    //   769: return
    //   770: aload_0
    //   771: getfield 12	nmj:a	Lnmi;
    //   774: getfield 120	nmi:val$context	Landroid/content/Context;
    //   777: aload 4
    //   779: aload 5
    //   781: invokestatic 277	nmv:b	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)V
    //   784: return
    //   785: aload 6
    //   787: ifnull -418 -> 369
    //   790: aload_0
    //   791: getfield 12	nmj:a	Lnmi;
    //   794: getfield 120	nmi:val$context	Landroid/content/Context;
    //   797: instanceof 257
    //   800: ifeq -431 -> 369
    //   803: aload 6
    //   805: aload_0
    //   806: getfield 12	nmj:a	Lnmi;
    //   809: getfield 120	nmi:val$context	Landroid/content/Context;
    //   812: checkcast 257	com/tencent/biz/pubaccount/readinjoy/view/fastweb/FastWebActivity
    //   815: aload 4
    //   817: aload 5
    //   819: invokestatic 282	nnj:a	(Lorg/json/JSONObject;Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)V
    //   822: return
    //   823: aload 4
    //   825: aload 5
    //   827: aload_0
    //   828: getfield 12	nmj:a	Lnmi;
    //   831: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   834: getfield 128	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:mTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   837: aload_1
    //   838: invokestatic 287	nmz:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;)V
    //   841: aload 4
    //   843: aload 5
    //   845: aload_0
    //   846: getfield 12	nmj:a	Lnmi;
    //   849: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   852: getfield 128	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:mTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   855: aload_1
    //   856: invokestatic 289	nmz:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;)V
    //   859: aload_3
    //   860: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   863: ifne -494 -> 369
    //   866: aload_0
    //   867: getfield 12	nmj:a	Lnmi;
    //   870: getfield 120	nmi:val$context	Landroid/content/Context;
    //   873: aload_3
    //   874: invokestatic 124	kxm:C	(Landroid/content/Context;Ljava/lang/String;)V
    //   877: return
    //   878: aload 4
    //   880: aload 5
    //   882: aload_0
    //   883: getfield 12	nmj:a	Lnmi;
    //   886: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   889: getfield 128	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:mTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   892: aload_1
    //   893: invokestatic 289	nmz:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;)V
    //   896: aload_3
    //   897: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   900: ifne -531 -> 369
    //   903: aload_0
    //   904: getfield 12	nmj:a	Lnmi;
    //   907: getfield 120	nmi:val$context	Landroid/content/Context;
    //   910: aload_3
    //   911: invokestatic 124	kxm:C	(Landroid/content/Context;Ljava/lang/String;)V
    //   914: return
    //   915: astore 4
    //   917: aload 4
    //   919: invokevirtual 292	org/json/JSONException:printStackTrace	()V
    //   922: aload 5
    //   924: astore 4
    //   926: goto -711 -> 215
    //   929: aload_1
    //   930: invokevirtual 131	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   933: aload 6
    //   935: aload_3
    //   936: invokestatic 295	nns:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   939: goto -608 -> 331
    //   942: ldc_w 297
    //   945: aload 4
    //   947: ldc 93
    //   949: invokestatic 99	kfq:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   952: invokestatic 103	kfq:ma	(Ljava/lang/String;)V
    //   955: aload 6
    //   957: ldc 67
    //   959: invokevirtual 300	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   962: astore_3
    //   963: invokestatic 305	arvv:a	()Larvv;
    //   966: aload_3
    //   967: invokevirtual 309	arvv:e	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   970: astore 5
    //   972: aload 5
    //   974: ifnonnull +238 -> 1212
    //   977: ldc_w 297
    //   980: aload 4
    //   982: ldc_w 311
    //   985: invokestatic 99	kfq:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   988: invokestatic 103	kfq:ma	(Ljava/lang/String;)V
    //   991: ldc_w 297
    //   994: aload 4
    //   996: ldc_w 313
    //   999: invokestatic 99	kfq:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1002: invokestatic 103	kfq:ma	(Ljava/lang/String;)V
    //   1005: new 315	com/tencent/open/downloadnew/DownloadInfo
    //   1008: dup
    //   1009: invokespecial 316	com/tencent/open/downloadnew/DownloadInfo:<init>	()V
    //   1012: astore 4
    //   1014: aload 4
    //   1016: aload_3
    //   1017: putfield 319	com/tencent/open/downloadnew/DownloadInfo:urlStr	Ljava/lang/String;
    //   1020: aload 4
    //   1022: ldc_w 321
    //   1025: putfield 324	com/tencent/open/downloadnew/DownloadInfo:source	Ljava/lang/String;
    //   1028: aload 4
    //   1030: ldc_w 326
    //   1033: putfield 329	com/tencent/open/downloadnew/DownloadInfo:packageName	Ljava/lang/String;
    //   1036: invokestatic 305	arvv:a	()Larvv;
    //   1039: aload 4
    //   1041: invokevirtual 332	arvv:b	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   1044: aload 6
    //   1046: ldc 59
    //   1048: invokevirtual 75	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1051: astore_3
    //   1052: aload_3
    //   1053: ldc_w 334
    //   1056: ldc_w 336
    //   1059: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1062: pop
    //   1063: aload_3
    //   1064: ldc_w 342
    //   1067: iconst_0
    //   1068: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1071: pop
    //   1072: aload_0
    //   1073: getfield 12	nmj:a	Lnmi;
    //   1076: getfield 84	nmi:a	Lnmh$a;
    //   1079: getfield 170	nmh$a:a	Lnmh;
    //   1082: invokestatic 175	nmh:a	(Lnmh;)Landroid/widget/BaseAdapter;
    //   1085: ifnull +19 -> 1104
    //   1088: aload_0
    //   1089: getfield 12	nmj:a	Lnmi;
    //   1092: getfield 84	nmi:a	Lnmh$a;
    //   1095: getfield 170	nmh$a:a	Lnmh;
    //   1098: invokestatic 175	nmh:a	(Lnmh;)Landroid/widget/BaseAdapter;
    //   1101: invokevirtual 180	android/widget/BaseAdapter:notifyDataSetChanged	()V
    //   1104: aload 6
    //   1106: ldc_w 347
    //   1109: invokevirtual 65	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   1112: ifnull +42 -> 1154
    //   1115: aload 6
    //   1117: ldc_w 347
    //   1120: invokevirtual 300	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1123: astore_3
    //   1124: aload_0
    //   1125: getfield 12	nmj:a	Lnmi;
    //   1128: getfield 120	nmi:val$context	Landroid/content/Context;
    //   1131: ldc_w 349
    //   1134: invokevirtual 354	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1137: checkcast 356	android/content/ClipboardManager
    //   1140: astore 4
    //   1142: aload 4
    //   1144: aload_3
    //   1145: invokestatic 361	alkw:a	(Landroid/content/ClipboardManager;Ljava/lang/CharSequence;)V
    //   1148: aload 4
    //   1150: aload_3
    //   1151: invokevirtual 365	android/content/ClipboardManager:setText	(Ljava/lang/CharSequence;)V
    //   1154: aload_0
    //   1155: getfield 12	nmj:a	Lnmi;
    //   1158: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   1161: getfield 128	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:mTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   1164: aload_1
    //   1165: invokevirtual 131	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   1168: invokestatic 136	nns:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1171: astore_3
    //   1172: aload_0
    //   1173: getfield 12	nmj:a	Lnmi;
    //   1176: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   1179: instanceof 138
    //   1182: ifeq +272 -> 1454
    //   1185: aload_1
    //   1186: invokevirtual 131	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   1189: aload_0
    //   1190: getfield 12	nmj:a	Lnmi;
    //   1193: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   1196: checkcast 138	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData
    //   1199: aload_3
    //   1200: invokestatic 141	nns:a	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData;Lorg/json/JSONObject;)V
    //   1203: return
    //   1204: astore_3
    //   1205: aload_3
    //   1206: invokevirtual 292	org/json/JSONException:printStackTrace	()V
    //   1209: goto -105 -> 1104
    //   1212: aload 5
    //   1214: invokevirtual 369	com/tencent/open/downloadnew/DownloadInfo:getState	()I
    //   1217: iconst_4
    //   1218: if_icmpne +39 -> 1257
    //   1221: ldc_w 297
    //   1224: aload 4
    //   1226: ldc_w 371
    //   1229: invokestatic 99	kfq:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1232: invokestatic 103	kfq:ma	(Ljava/lang/String;)V
    //   1235: invokestatic 305	arvv:a	()Larvv;
    //   1238: aload 5
    //   1240: invokevirtual 374	arvv:d	(Lcom/tencent/open/downloadnew/DownloadInfo;)Z
    //   1243: ifne -139 -> 1104
    //   1246: invokestatic 305	arvv:a	()Larvv;
    //   1249: aload 5
    //   1251: invokevirtual 332	arvv:b	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   1254: goto -150 -> 1104
    //   1257: aload 5
    //   1259: invokevirtual 369	com/tencent/open/downloadnew/DownloadInfo:getState	()I
    //   1262: bipush 30
    //   1264: if_icmpeq +41 -> 1305
    //   1267: aload 5
    //   1269: invokevirtual 369	com/tencent/open/downloadnew/DownloadInfo:getState	()I
    //   1272: bipush 10
    //   1274: if_icmpeq +31 -> 1305
    //   1277: aload 5
    //   1279: invokevirtual 369	com/tencent/open/downloadnew/DownloadInfo:getState	()I
    //   1282: bipush 20
    //   1284: if_icmpeq +21 -> 1305
    //   1287: aload 5
    //   1289: invokevirtual 369	com/tencent/open/downloadnew/DownloadInfo:getState	()I
    //   1292: iconst_1
    //   1293: if_icmpeq +12 -> 1305
    //   1296: aload 5
    //   1298: invokevirtual 369	com/tencent/open/downloadnew/DownloadInfo:getState	()I
    //   1301: iconst_2
    //   1302: if_icmpne +28 -> 1330
    //   1305: invokestatic 305	arvv:a	()Larvv;
    //   1308: aload_3
    //   1309: invokevirtual 377	arvv:fx	(Ljava/lang/String;)I
    //   1312: pop
    //   1313: ldc_w 297
    //   1316: aload 4
    //   1318: ldc_w 379
    //   1321: invokestatic 99	kfq:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1324: invokestatic 103	kfq:ma	(Ljava/lang/String;)V
    //   1327: goto -223 -> 1104
    //   1330: ldc_w 297
    //   1333: aload 4
    //   1335: ldc_w 313
    //   1338: invokestatic 99	kfq:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1341: invokestatic 103	kfq:ma	(Ljava/lang/String;)V
    //   1344: invokestatic 305	arvv:a	()Larvv;
    //   1347: aload 5
    //   1349: invokevirtual 332	arvv:b	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   1352: aload 6
    //   1354: ldc 59
    //   1356: invokevirtual 75	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1359: astore_3
    //   1360: aload_3
    //   1361: ldc_w 334
    //   1364: new 145	java/lang/StringBuilder
    //   1367: dup
    //   1368: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1371: ldc_w 381
    //   1374: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1377: aload 5
    //   1379: getfield 385	com/tencent/open/downloadnew/DownloadInfo:progress	I
    //   1382: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1385: ldc_w 390
    //   1388: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1394: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1397: pop
    //   1398: aload_3
    //   1399: ldc_w 342
    //   1402: aload 5
    //   1404: getfield 385	com/tencent/open/downloadnew/DownloadInfo:progress	I
    //   1407: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1410: pop
    //   1411: aload_0
    //   1412: getfield 12	nmj:a	Lnmi;
    //   1415: getfield 84	nmi:a	Lnmh$a;
    //   1418: getfield 170	nmh$a:a	Lnmh;
    //   1421: invokestatic 175	nmh:a	(Lnmh;)Landroid/widget/BaseAdapter;
    //   1424: ifnull -320 -> 1104
    //   1427: aload_0
    //   1428: getfield 12	nmj:a	Lnmi;
    //   1431: getfield 84	nmi:a	Lnmh$a;
    //   1434: getfield 170	nmh$a:a	Lnmh;
    //   1437: invokestatic 175	nmh:a	(Lnmh;)Landroid/widget/BaseAdapter;
    //   1440: invokevirtual 180	android/widget/BaseAdapter:notifyDataSetChanged	()V
    //   1443: goto -339 -> 1104
    //   1446: astore_3
    //   1447: aload_3
    //   1448: invokevirtual 292	org/json/JSONException:printStackTrace	()V
    //   1451: goto -347 -> 1104
    //   1454: aload_1
    //   1455: invokevirtual 131	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   1458: aload 6
    //   1460: aload_3
    //   1461: invokestatic 295	nns:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   1464: return
    //   1465: aload_3
    //   1466: astore 4
    //   1468: aload_3
    //   1469: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1472: ifne +23 -> 1495
    //   1475: aload_3
    //   1476: aload 6
    //   1478: invokestatic 116	kxm:a	(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    //   1481: astore 4
    //   1483: aload_0
    //   1484: getfield 12	nmj:a	Lnmi;
    //   1487: getfield 120	nmi:val$context	Landroid/content/Context;
    //   1490: aload 4
    //   1492: invokestatic 124	kxm:C	(Landroid/content/Context;Ljava/lang/String;)V
    //   1495: aload_0
    //   1496: getfield 12	nmj:a	Lnmi;
    //   1499: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   1502: getfield 128	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:mTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   1505: aload_1
    //   1506: invokevirtual 131	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   1509: invokestatic 136	nns:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1512: astore_3
    //   1513: aload_0
    //   1514: getfield 12	nmj:a	Lnmi;
    //   1517: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   1520: instanceof 138
    //   1523: ifeq +60 -> 1583
    //   1526: aload_1
    //   1527: invokevirtual 131	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   1530: aload_0
    //   1531: getfield 12	nmj:a	Lnmi;
    //   1534: getfield 28	nmi:b	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   1537: checkcast 138	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData
    //   1540: aload_3
    //   1541: invokestatic 141	nns:a	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData;Lorg/json/JSONObject;)V
    //   1544: ldc 143
    //   1546: iconst_1
    //   1547: new 145	java/lang/StringBuilder
    //   1550: dup
    //   1551: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1554: ldc 148
    //   1556: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: aload 4
    //   1561: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: ldc 154
    //   1566: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: aload_1
    //   1570: invokevirtual 131	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   1573: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1576: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1579: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1582: return
    //   1583: aload_1
    //   1584: invokevirtual 131	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   1587: aload 6
    //   1589: aload_3
    //   1590: invokestatic 295	nns:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   1593: goto -49 -> 1544
    //   1596: astore_3
    //   1597: goto -443 -> 1154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1600	0	this	nmj
    //   0	1600	1	paramViewBase	com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    //   24	26	2	i	int
    //   16	1184	3	localObject1	Object
    //   1204	105	3	localJSONException1	org.json.JSONException
    //   1359	40	3	localJSONObject1	org.json.JSONObject
    //   1446	30	3	localJSONException2	org.json.JSONException
    //   1512	78	3	localJSONObject2	org.json.JSONObject
    //   1596	1	3	localThrowable	java.lang.Throwable
    //   35	844	4	localObject2	Object
    //   915	3	4	localJSONException3	org.json.JSONException
    //   924	636	4	localObject3	Object
    //   47	1356	5	localObject4	Object
    //   10	1578	6	localJSONObject3	org.json.JSONObject
    //   190	17	7	localJSONObject4	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   183	192	915	org/json/JSONException
    //   196	215	915	org/json/JSONException
    //   1044	1104	1204	org/json/JSONException
    //   1352	1443	1446	org/json/JSONException
    //   1124	1154	1596	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmj
 * JD-Core Version:    0.7.0.1
 */