package com.tencent.mobileqq.mini.entry.desktop;

import android.view.View.OnClickListener;

class MiniAppDesktopAdapter$3
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$3(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 28	android/view/View:getTag	()Ljava/lang/Object;
    //   4: astore 5
    //   6: aload 5
    //   8: instanceof 30
    //   11: ifne +43 -> 54
    //   14: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +29 -> 46
    //   20: ldc 38
    //   22: iconst_2
    //   23: new 40	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   30: ldc 43
    //   32: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload 5
    //   37: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 58	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: invokestatic 64	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   49: aload_1
    //   50: invokevirtual 67	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   53: return
    //   54: aload_1
    //   55: invokevirtual 71	android/view/View:getParent	()Landroid/view/ViewParent;
    //   58: checkcast 73	android/support/v7/widget/RecyclerView
    //   61: aload_1
    //   62: invokevirtual 77	android/support/v7/widget/RecyclerView:getChildViewHolder	(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    //   65: checkcast 79	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder
    //   68: astore 6
    //   70: aload 6
    //   72: getfield 83	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:miniAppInfo	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   75: astore 5
    //   77: aload 6
    //   79: getfield 87	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   82: iconst_1
    //   83: if_icmpne +353 -> 436
    //   86: sipush 3001
    //   89: istore_2
    //   90: ldc 38
    //   92: iconst_1
    //   93: new 40	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   100: ldc 89
    //   102: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 5
    //   107: getfield 95	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   110: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc 97
    //   115: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 6
    //   120: getfield 87	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   123: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload 6
    //   134: getfield 87	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   137: iconst_2
    //   138: if_icmpne +330 -> 468
    //   141: aload 6
    //   143: getfield 107	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   146: ifnull +322 -> 468
    //   149: aload 6
    //   151: getfield 107	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   154: getfield 112	com/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo:fromBackup	I
    //   157: iconst_1
    //   158: if_icmpne +310 -> 468
    //   161: new 114	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   164: dup
    //   165: invokespecial 115	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   168: astore 7
    //   170: aload 7
    //   172: iload_2
    //   173: putfield 118	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   176: aload_0
    //   177: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   180: invokestatic 124	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2400	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;)Ljava/lang/ref/WeakReference;
    //   183: invokevirtual 129	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   186: checkcast 131	android/content/Context
    //   189: aload 5
    //   191: getfield 95	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   194: aconst_null
    //   195: aconst_null
    //   196: aload 7
    //   198: aconst_null
    //   199: invokestatic 137	com/tencent/mobileqq/mini/sdk/MiniAppController:startAppByAppid	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;Lcom/tencent/mobileqq/mini/sdk/MiniAppLauncher$MiniAppLaunchListener;)V
    //   202: ldc 38
    //   204: iconst_1
    //   205: new 40	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   212: ldc 89
    //   214: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 5
    //   219: getfield 95	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   222: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc 97
    //   227: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload 6
    //   232: getfield 87	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   235: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: ldc 139
    //   240: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 6
    //   245: getfield 107	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   248: getfield 112	com/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo:fromBackup	I
    //   251: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 142	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload_0
    //   261: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   264: aload 5
    //   266: getfield 95	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   269: invokestatic 146	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2500	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;Ljava/lang/String;)I
    //   272: istore_3
    //   273: new 148	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   276: dup
    //   277: aload 5
    //   279: invokespecial 151	com/tencent/mobileqq/mini/apkg/MiniAppConfig:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   282: astore 6
    //   284: aload 6
    //   286: getfield 155	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   289: iload_2
    //   290: putfield 118	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   293: aload 6
    //   295: ldc 157
    //   297: ldc 159
    //   299: aconst_null
    //   300: iload_3
    //   301: invokestatic 165	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   304: invokestatic 171	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC04239:reportAsync	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload 5
    //   309: getfield 174	com/tencent/mobileqq/mini/apkg/MiniAppInfo:amsAdInfo	Ljava/lang/String;
    //   312: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   315: istore 4
    //   317: iload 4
    //   319: ifne +79 -> 398
    //   322: new 182	org/json/JSONObject
    //   325: dup
    //   326: aload 5
    //   328: getfield 174	com/tencent/mobileqq/mini/apkg/MiniAppInfo:amsAdInfo	Ljava/lang/String;
    //   331: invokespecial 185	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   334: astore 6
    //   336: ldc 187
    //   338: new 187	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   341: dup
    //   342: invokespecial 188	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   345: aload 6
    //   347: invokestatic 194	tkv:pbFromJson	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   350: invokevirtual 200	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   353: checkcast 187	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   356: getfield 204	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   359: getfield 210	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   362: invokevirtual 214	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   365: astore 6
    //   367: aload 6
    //   369: invokestatic 219	com/tencent/mobileqq/mini/entry/MiniAppUtils:reportMiniAppAd	(Ljava/lang/String;)V
    //   372: ldc 38
    //   374: iconst_1
    //   375: new 40	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   382: ldc 221
    //   384: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload 6
    //   389: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload 5
    //   400: getfield 224	com/tencent/mobileqq/mini/apkg/MiniAppInfo:tianshuAdId	I
    //   403: ifle -357 -> 46
    //   406: ldc 226
    //   408: ldc 226
    //   410: aload 5
    //   412: getfield 224	com/tencent/mobileqq/mini/apkg/MiniAppInfo:tianshuAdId	I
    //   415: invokestatic 165	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   418: bipush 102
    //   420: invokestatic 230	com/tencent/mobileqq/mini/entry/MiniAppUtils:miniAppTianShuReport	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   423: goto -377 -> 46
    //   426: astore 5
    //   428: aload 5
    //   430: invokevirtual 233	com/tencent/mobileqq/mini/sdk/MiniAppException:printStackTrace	()V
    //   433: goto -387 -> 46
    //   436: aload 6
    //   438: getfield 87	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   441: iconst_2
    //   442: if_icmpne +10 -> 452
    //   445: sipush 3002
    //   448: istore_2
    //   449: goto -359 -> 90
    //   452: aload 6
    //   454: getfield 87	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   457: iconst_3
    //   458: if_icmpne +66 -> 524
    //   461: sipush 3003
    //   464: istore_2
    //   465: goto -375 -> 90
    //   468: aload_0
    //   469: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   472: invokestatic 124	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2400	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;)Ljava/lang/ref/WeakReference;
    //   475: invokevirtual 129	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   478: checkcast 235	android/app/Activity
    //   481: aload 5
    //   483: iload_2
    //   484: invokestatic 239	com/tencent/mobileqq/mini/sdk/MiniAppController:launchMiniAppByAppInfo	(Landroid/app/Activity;Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;I)V
    //   487: goto -227 -> 260
    //   490: astore 6
    //   492: ldc 38
    //   494: iconst_1
    //   495: new 40	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   502: ldc 241
    //   504: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload 6
    //   509: invokestatic 247	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   512: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: goto -123 -> 398
    //   524: sipush 9999
    //   527: istore_2
    //   528: goto -438 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	3
    //   0	531	1	paramView	android.view.View
    //   89	439	2	i	int
    //   272	29	3	j	int
    //   315	3	4	bool	boolean
    //   4	407	5	localObject1	Object
    //   426	56	5	localMiniAppException	com.tencent.mobileqq.mini.sdk.MiniAppException
    //   68	385	6	localObject2	Object
    //   490	18	6	localException	java.lang.Exception
    //   168	29	7	localLaunchParam	com.tencent.mobileqq.mini.sdk.LaunchParam
    // Exception table:
    //   from	to	target	type
    //   90	260	426	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   260	317	426	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   322	398	426	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   398	423	426	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   468	487	426	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   492	521	426	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   322	398	490	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.3
 * JD-Core Version:    0.7.0.1
 */