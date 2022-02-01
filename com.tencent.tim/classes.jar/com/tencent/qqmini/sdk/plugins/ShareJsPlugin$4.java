package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class ShareJsPlugin$4
  implements Runnable
{
  ShareJsPlugin$4(ShareJsPlugin paramShareJsPlugin, RequestEvent paramRequestEvent) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_1
    //   3: istore 7
    //   5: aload_0
    //   6: getfield 14	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:this$0	Lcom/tencent/qqmini/sdk/plugins/ShareJsPlugin;
    //   9: invokestatic 29	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:access$600	(Lcom/tencent/qqmini/sdk/plugins/ShareJsPlugin;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   12: invokeinterface 35 1 0
    //   17: invokestatic 41	com/tencent/qqmini/sdk/widget/actionsheet/ActionSheet:create	(Landroid/content/Context;)Lcom/tencent/qqmini/sdk/widget/actionsheet/ActionSheet;
    //   20: astore 8
    //   22: new 43	org/json/JSONObject
    //   25: dup
    //   26: aload_0
    //   27: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   30: getfield 49	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   33: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   36: astore 9
    //   38: aload 9
    //   40: ldc 54
    //   42: invokevirtual 58	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   45: astore 10
    //   47: aload 9
    //   49: ldc 60
    //   51: iconst_0
    //   52: invokevirtual 64	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   55: istore_2
    //   56: iload_2
    //   57: tableswitch	default:+828 -> 885, 0:+82->139, 1:+204->261
    //   81: lstore_3
    //   82: new 68	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   89: aload_0
    //   90: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   93: getfield 72	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   96: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 78
    //   101: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload_2
    //   105: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 91	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: return
    //   115: aload 8
    //   117: aload 10
    //   119: iload_1
    //   120: invokevirtual 97	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   123: bipush 9
    //   125: aload 9
    //   127: ldc 99
    //   129: invokevirtual 102	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokevirtual 106	com/tencent/qqmini/sdk/widget/actionsheet/ActionSheet:addButton	(Ljava/lang/CharSequence;ILjava/lang/String;)V
    //   135: iload_1
    //   136: iconst_1
    //   137: iadd
    //   138: istore_1
    //   139: iload_1
    //   140: aload 10
    //   142: invokevirtual 110	org/json/JSONArray:length	()I
    //   145: if_icmpge +56 -> 201
    //   148: aload 10
    //   150: iload_1
    //   151: invokevirtual 114	org/json/JSONArray:isNull	(I)Z
    //   154: ifeq -39 -> 115
    //   157: aload_0
    //   158: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   161: invokevirtual 117	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   164: pop
    //   165: return
    //   166: astore 8
    //   168: ldc 66
    //   170: new 68	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   177: aload_0
    //   178: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   181: getfield 72	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   184: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 119
    //   189: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload 8
    //   197: invokestatic 122	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: return
    //   201: aload 8
    //   203: ldc 124
    //   205: invokevirtual 128	com/tencent/qqmini/sdk/widget/actionsheet/ActionSheet:addCancelButton	(Ljava/lang/CharSequence;)V
    //   208: aload 8
    //   210: invokevirtual 131	com/tencent/qqmini/sdk/widget/actionsheet/ActionSheet:show	()V
    //   213: aload 8
    //   215: iconst_1
    //   216: invokevirtual 135	com/tencent/qqmini/sdk/widget/actionsheet/ActionSheet:setOutsideDismissEnableCompat	(Z)V
    //   219: aload 8
    //   221: new 137	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4$1
    //   224: dup
    //   225: aload_0
    //   226: invokespecial 140	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4$1:<init>	(Lcom/tencent/qqmini/sdk/plugins/ShareJsPlugin$4;)V
    //   229: invokevirtual 144	com/tencent/qqmini/sdk/widget/actionsheet/ActionSheet:setOnDismissListener	(Lcom/tencent/qqmini/sdk/widget/actionsheet/ActionSheet$OnDismissListener;)V
    //   232: aload 8
    //   234: new 146	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4$2
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 147	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4$2:<init>	(Lcom/tencent/qqmini/sdk/plugins/ShareJsPlugin$4;)V
    //   242: invokevirtual 151	com/tencent/qqmini/sdk/widget/actionsheet/ActionSheet:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   245: aload 8
    //   247: new 153	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4$3
    //   250: dup
    //   251: aload_0
    //   252: aload 8
    //   254: invokespecial 156	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4$3:<init>	(Lcom/tencent/qqmini/sdk/plugins/ShareJsPlugin$4;Lcom/tencent/qqmini/sdk/widget/actionsheet/ActionSheet;)V
    //   257: invokevirtual 160	com/tencent/qqmini/sdk/widget/actionsheet/ActionSheet:setOnButtonClickListener	(Lcom/tencent/qqmini/sdk/widget/actionsheet/ActionSheet$OnButtonClickListener;)V
    //   260: return
    //   261: new 162	java/util/HashMap
    //   264: dup
    //   265: invokespecial 163	java/util/HashMap:<init>	()V
    //   268: astore 8
    //   270: aload_0
    //   271: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   274: getfield 49	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   277: ifnull +37 -> 314
    //   280: ldc 165
    //   282: aload_0
    //   283: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   286: getfield 49	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   289: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   292: ifne +22 -> 314
    //   295: ldc 173
    //   297: aload_0
    //   298: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   301: getfield 49	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   304: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   307: istore 6
    //   309: iload 6
    //   311: ifeq +94 -> 405
    //   314: new 43	org/json/JSONObject
    //   317: dup
    //   318: invokespecial 174	org/json/JSONObject:<init>	()V
    //   321: ldc 176
    //   323: ldc 178
    //   325: invokevirtual 182	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   328: pop
    //   329: aload_0
    //   330: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   333: invokevirtual 117	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   336: pop
    //   337: ldc 66
    //   339: new 68	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   346: aload_0
    //   347: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   350: getfield 72	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   353: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: ldc 184
    //   358: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 91	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: return
    //   368: astore 8
    //   370: ldc 66
    //   372: new 68	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   379: aload_0
    //   380: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   383: getfield 72	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   386: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: ldc 119
    //   391: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: aload 8
    //   399: invokestatic 122	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   402: goto -65 -> 337
    //   405: new 43	org/json/JSONObject
    //   408: dup
    //   409: aload_0
    //   410: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   413: getfield 49	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsonParams	Ljava/lang/String;
    //   416: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   419: ldc 54
    //   421: invokevirtual 188	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   424: checkcast 93	org/json/JSONArray
    //   427: astore 9
    //   429: aload 9
    //   431: ifnonnull +457 -> 888
    //   434: new 43	org/json/JSONObject
    //   437: dup
    //   438: invokespecial 174	org/json/JSONObject:<init>	()V
    //   441: ldc 176
    //   443: ldc 190
    //   445: invokevirtual 182	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   448: pop
    //   449: aload_0
    //   450: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   453: invokevirtual 117	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   456: pop
    //   457: ldc 66
    //   459: new 68	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   466: aload_0
    //   467: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   470: getfield 72	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   473: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc 192
    //   478: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 91	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: return
    //   488: astore 8
    //   490: aload 8
    //   492: invokevirtual 195	org/json/JSONException:printStackTrace	()V
    //   495: ldc 66
    //   497: aload 8
    //   499: invokevirtual 198	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   502: aload 8
    //   504: invokestatic 122	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   507: aload_0
    //   508: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   511: invokevirtual 117	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	()Ljava/lang/String;
    //   514: pop
    //   515: return
    //   516: astore 8
    //   518: ldc 66
    //   520: new 68	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   527: aload_0
    //   528: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   531: getfield 72	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   534: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: ldc 119
    //   539: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: aload 8
    //   547: invokestatic 122	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   550: goto -93 -> 457
    //   553: iload 5
    //   555: aload 9
    //   557: invokevirtual 110	org/json/JSONArray:length	()I
    //   560: if_icmpge +122 -> 682
    //   563: aload 9
    //   565: iload 5
    //   567: invokevirtual 201	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   570: astore 10
    //   572: aload 10
    //   574: ldc 203
    //   576: invokevirtual 207	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   579: ifeq +19 -> 598
    //   582: aload 8
    //   584: ldc 209
    //   586: iload 5
    //   588: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   591: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   594: pop
    //   595: iconst_1
    //   596: istore 4
    //   598: aload 10
    //   600: ldc 220
    //   602: invokevirtual 207	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   605: ifeq +18 -> 623
    //   608: aload 8
    //   610: ldc 222
    //   612: iload 5
    //   614: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   617: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   620: pop
    //   621: iconst_1
    //   622: istore_3
    //   623: aload 10
    //   625: ldc 224
    //   627: invokevirtual 207	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   630: ifeq +18 -> 648
    //   633: aload 8
    //   635: ldc 226
    //   637: iload 5
    //   639: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   642: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   645: pop
    //   646: iconst_1
    //   647: istore_2
    //   648: aload 10
    //   650: ldc 228
    //   652: invokevirtual 207	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   655: ifeq +18 -> 673
    //   658: aload 8
    //   660: ldc 230
    //   662: iload 5
    //   664: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   667: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   670: pop
    //   671: iconst_1
    //   672: istore_1
    //   673: iload 5
    //   675: iconst_1
    //   676: iadd
    //   677: istore 5
    //   679: goto -126 -> 553
    //   682: iload 4
    //   684: iconst_m1
    //   685: if_icmpne +197 -> 882
    //   688: iconst_0
    //   689: istore 4
    //   691: iload_3
    //   692: istore 5
    //   694: iload_3
    //   695: iconst_m1
    //   696: if_icmpne +6 -> 702
    //   699: iconst_0
    //   700: istore 5
    //   702: iload_2
    //   703: istore_3
    //   704: iload_2
    //   705: iconst_m1
    //   706: if_icmpne +5 -> 711
    //   709: iconst_0
    //   710: istore_3
    //   711: iload_1
    //   712: istore_2
    //   713: iload_1
    //   714: iconst_m1
    //   715: if_icmpne +5 -> 720
    //   718: iconst_0
    //   719: istore_2
    //   720: aload_0
    //   721: getfield 14	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:this$0	Lcom/tencent/qqmini/sdk/plugins/ShareJsPlugin;
    //   724: invokestatic 233	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:access$700	(Lcom/tencent/qqmini/sdk/plugins/ShareJsPlugin;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   727: invokestatic 239	com/tencent/qqmini/sdk/action/GetShareState:obtain	(Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;)Lcom/tencent/qqmini/sdk/launcher/model/ShareState;
    //   730: astore 9
    //   732: aload 9
    //   734: iconst_1
    //   735: putfield 245	com/tencent/qqmini/sdk/launcher/model/ShareState:launchFrom	I
    //   738: iload 4
    //   740: iconst_1
    //   741: if_icmpne +117 -> 858
    //   744: iconst_1
    //   745: istore 6
    //   747: aload 9
    //   749: iload 6
    //   751: putfield 249	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareQQ	Z
    //   754: iload 5
    //   756: iconst_1
    //   757: if_icmpne +107 -> 864
    //   760: iconst_1
    //   761: istore 6
    //   763: aload 9
    //   765: iload 6
    //   767: putfield 252	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareQzone	Z
    //   770: iload_3
    //   771: iconst_1
    //   772: if_icmpne +98 -> 870
    //   775: iconst_1
    //   776: istore 6
    //   778: aload 9
    //   780: iload 6
    //   782: putfield 255	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareWeChatFriend	Z
    //   785: iload_2
    //   786: iconst_1
    //   787: if_icmpne +89 -> 876
    //   790: iload 7
    //   792: istore 6
    //   794: aload 9
    //   796: iload 6
    //   798: putfield 258	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareWeChatMoment	Z
    //   801: aload 9
    //   803: iconst_1
    //   804: putfield 261	com/tencent/qqmini/sdk/launcher/model/ShareState:withShareOthers	Z
    //   807: aload 9
    //   809: aload 8
    //   811: putfield 265	com/tencent/qqmini/sdk/launcher/model/ShareState:tapIndexMap	Ljava/util/HashMap;
    //   814: aload 9
    //   816: aload_0
    //   817: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   820: getfield 72	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:event	Ljava/lang/String;
    //   823: putfield 268	com/tencent/qqmini/sdk/launcher/model/ShareState:shareEvent	Ljava/lang/String;
    //   826: aload 9
    //   828: aload_0
    //   829: getfield 16	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   832: getfield 271	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:callbackId	I
    //   835: putfield 274	com/tencent/qqmini/sdk/launcher/model/ShareState:shareCallbackId	I
    //   838: aload_0
    //   839: getfield 14	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:this$0	Lcom/tencent/qqmini/sdk/plugins/ShareJsPlugin;
    //   842: invokestatic 278	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:access$900	(Lcom/tencent/qqmini/sdk/plugins/ShareJsPlugin;)Lcom/tencent/qqmini/sdk/launcher/core/proxy/ShareProxy;
    //   845: aload_0
    //   846: getfield 14	com/tencent/qqmini/sdk/plugins/ShareJsPlugin$4:this$0	Lcom/tencent/qqmini/sdk/plugins/ShareJsPlugin;
    //   849: invokestatic 281	com/tencent/qqmini/sdk/plugins/ShareJsPlugin:access$800	(Lcom/tencent/qqmini/sdk/plugins/ShareJsPlugin;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   852: invokeinterface 287 2 0
    //   857: return
    //   858: iconst_0
    //   859: istore 6
    //   861: goto -114 -> 747
    //   864: iconst_0
    //   865: istore 6
    //   867: goto -104 -> 763
    //   870: iconst_0
    //   871: istore 6
    //   873: goto -95 -> 778
    //   876: iconst_0
    //   877: istore 6
    //   879: goto -85 -> 794
    //   882: goto -191 -> 691
    //   885: goto -805 -> 80
    //   888: iconst_0
    //   889: istore 5
    //   891: iconst_m1
    //   892: istore_1
    //   893: iconst_m1
    //   894: istore_2
    //   895: iconst_m1
    //   896: istore_3
    //   897: iconst_m1
    //   898: istore 4
    //   900: goto -347 -> 553
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	903	0	this	4
    //   1	892	1	i	int
    //   55	840	2	j	int
    //   622	275	3	k	int
    //   596	303	4	m	int
    //   553	337	5	n	int
    //   307	571	6	bool1	boolean
    //   3	788	7	bool2	boolean
    //   20	96	8	localActionSheet	com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet
    //   166	87	8	localJSONException1	org.json.JSONException
    //   268	1	8	localHashMap	java.util.HashMap
    //   368	30	8	localJSONException2	org.json.JSONException
    //   488	15	8	localJSONException3	org.json.JSONException
    //   516	294	8	localJSONException4	org.json.JSONException
    //   36	791	9	localObject1	Object
    //   45	604	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	56	166	org/json/JSONException
    //   80	114	166	org/json/JSONException
    //   115	135	166	org/json/JSONException
    //   139	165	166	org/json/JSONException
    //   201	260	166	org/json/JSONException
    //   261	309	166	org/json/JSONException
    //   337	367	166	org/json/JSONException
    //   370	402	166	org/json/JSONException
    //   490	515	166	org/json/JSONException
    //   720	738	166	org/json/JSONException
    //   747	754	166	org/json/JSONException
    //   763	770	166	org/json/JSONException
    //   778	785	166	org/json/JSONException
    //   794	857	166	org/json/JSONException
    //   314	337	368	org/json/JSONException
    //   405	429	488	org/json/JSONException
    //   457	487	488	org/json/JSONException
    //   518	550	488	org/json/JSONException
    //   553	572	488	org/json/JSONException
    //   572	595	488	org/json/JSONException
    //   598	621	488	org/json/JSONException
    //   623	646	488	org/json/JSONException
    //   648	671	488	org/json/JSONException
    //   434	457	516	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */