package com.tencent.mobileqq.activity;

import acbn;
import acsh;
import acsm;
import ahyv;
import ahzs;
import amjb;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import aneo;
import aoop;
import aqft;
import aqil;
import aqrb;
import arhz;
import awsw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.messageclean.ScanSpaceManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.Vector;
import rvx;
import tbc;

public class QQSettingMsgHistoryActivity
  extends IphoneTitleBarActivity
  implements acsm, ViewTreeObserver.OnGlobalLayoutListener
{
  private static volatile ScanSpaceManager a;
  static final String aPg = BaseApplication.getContext().getFilesDir() + File.separator + "ChatHistoryEventConfig.json";
  private TextView Fq;
  private TextView Fr;
  private TextView Fs;
  private long GN;
  private String aPh;
  private int bKe;
  private int bKf;
  private String currentUin = "";
  private BounceScrollView e;
  private ProgressBar progressBar;
  private int screenWidth;
  private int totalLength;
  private View uA;
  private View us;
  private View ut;
  private View uu;
  private View uv;
  private View uw;
  private View ux;
  private View uy;
  private View uz;
  arhz v;
  boolean zU = true;
  
  private void Bt(int paramInt)
  {
    if (this.progressBar != null) {
      this.progressBar.setProgress(paramInt);
    }
    if (this.Fq != null) {
      this.Fq.setText(String.format(this.aPh, new Object[] { paramInt + "%" }));
    }
  }
  
  private static void aK(QQAppInterface paramQQAppInterface)
  {
    if (aoop.aW != null)
    {
      deleteFiles(aoop.aW.getAbsolutePath());
      if ((paramQQAppInterface.getApp() instanceof BaseApplicationImpl))
      {
        BaseApplicationImpl.getApplication();
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.getApplication();
          BaseApplicationImpl.sImageCache.evictAll();
        }
      }
    }
  }
  
  private static void aL(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getManager(10);
    if (paramQQAppInterface == null) {}
    while (!(paramQQAppInterface instanceof aneo)) {
      return;
    }
    ((aneo)paramQQAppInterface).Aq = null;
  }
  
  static void aM(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface.getApp() == null) {
      return;
    }
    BaseApplication.getContext().getPackageName();
    deleteFiles(aqft.aZ(BaseApplication.getContext()) + "thumbnails/");
  }
  
  public static void aU(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < CardHandler.w.size())
    {
      deleteFiles(CardHandler.bnU + ((Integer)CardHandler.w.get(i)).intValue() + "/");
      i += 1;
    }
    deleteFiles(CardHandler.bnU + "background" + "/");
    deleteFiles(acbn.SDCARD_PATH + "temp" + "/");
    deleteFiles(CardHandler.bnU + "temp" + "/");
    deleteFiles(CardHandler.bnU + "HDAvatar" + "/");
    deleteFiles(acbn.bni);
    deleteFiles(CardHandler.bnU + "voice" + "/");
    deleteFiles(tbc.ob() + "/");
    deleteFiles(acbn.bnt);
    deleteFiles(ahyv.bMr);
    deleteFiles(ahzs.bMy);
    deleteFiles(amjb.yR());
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.us.setVisibility(8);
    this.ut.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)this.uv.getLayoutParams();
    int i = Math.min(Math.max((int)(100L * paramLong1 / paramLong4), 2), 100) * this.totalLength / 100;
    ((LinearLayout.LayoutParams)localObject).width = i;
    this.uv.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.uw.getLayoutParams();
    int j = Math.min(Math.max((int)(100L * paramLong2 / paramLong4), 1), 100) * this.totalLength / 100;
    ((LinearLayout.LayoutParams)localObject).width = j;
    this.uw.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.ux.getLayoutParams();
    int k = Math.max(this.totalLength - i - j, 0);
    ((LinearLayout.LayoutParams)localObject).width = k;
    this.ux.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int m = (int)(100L * paramLong1 / paramLong4);
    if (m < 1) {}
    for (localObject = "<1%";; localObject = m + "%")
    {
      this.Fs.setText(String.format(getString(2131700850), new Object[] { localObject }));
      localObject = acsh.aV(paramLong1);
      this.Fr.setText((CharSequence)localObject);
      this.GN = paramLong1;
      QLog.d("QQSettingMsgHistoryActivity", 1, "showSpaceInfo qqSpaceLength: " + i + " phoneSpaceLength: " + j + " avaliableSpaceLength: " + k);
      return;
    }
  }
  
  /* Error */
  public static void b(android.app.Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: new 326	android/content/Intent
    //   3: dup
    //   4: ldc_w 328
    //   7: invokespecial 330	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: ldc_w 332
    //   15: iconst_1
    //   16: invokevirtual 336	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   19: pop
    //   20: aload_1
    //   21: invokevirtual 339	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   24: invokevirtual 345	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   27: aload_2
    //   28: invokevirtual 351	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   31: aload_1
    //   32: iconst_0
    //   33: invokestatic 356	avpw:e	(Lmqq/app/AppRuntime;Z)V
    //   36: aload_1
    //   37: invokestatic 358	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:aL	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   40: aload_1
    //   41: invokevirtual 361	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   44: iconst_0
    //   45: invokestatic 363	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:aU	(Ljava/lang/String;Z)V
    //   48: aload_1
    //   49: invokestatic 365	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:aM	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   52: invokestatic 368	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:bUx	()V
    //   55: aload_1
    //   56: invokestatic 370	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:aK	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   59: invokestatic 375	aqiv:edU	()V
    //   62: invokestatic 380	com/tencent/mobileqq/ark/ArkAppCenter:cTK	()V
    //   65: invokestatic 385	aipz:dtD	()V
    //   68: aload_0
    //   69: ifnull +12 -> 81
    //   72: aload_0
    //   73: aload_1
    //   74: invokevirtual 388	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   77: invokestatic 394	avja:c	(Landroid/app/Activity;Ljava/lang/String;)Z
    //   80: pop
    //   81: aload_1
    //   82: invokestatic 400	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:deleteAllH5Data	(Lcom/tencent/common/app/AppInterface;)V
    //   85: new 66	java/io/File
    //   88: dup
    //   89: new 47	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   96: getstatic 403	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:Vz	Ljava/lang/String;
    //   99: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 206
    //   104: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 406	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   111: invokestatic 412	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   126: invokestatic 424	jpe:hP	()Ljava/lang/String;
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull +14 -> 145
    //   134: new 66	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   145: invokestatic 427	jpe:hR	()Ljava/lang/String;
    //   148: astore_0
    //   149: aload_0
    //   150: ifnull +14 -> 164
    //   153: new 66	java/io/File
    //   156: dup
    //   157: aload_0
    //   158: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   161: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   164: invokestatic 430	jpe:hO	()Ljava/lang/String;
    //   167: astore_0
    //   168: aload_0
    //   169: ifnull +14 -> 183
    //   172: new 66	java/io/File
    //   175: dup
    //   176: aload_0
    //   177: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   180: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   183: invokestatic 433	jpe:hQ	()Ljava/lang/String;
    //   186: astore_0
    //   187: aload_0
    //   188: ifnull +14 -> 202
    //   191: new 66	java/io/File
    //   194: dup
    //   195: aload_0
    //   196: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   199: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   202: new 66	java/io/File
    //   205: dup
    //   206: new 47	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   213: invokestatic 438	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   216: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   219: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc_w 440
    //   225: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   234: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   237: new 66	java/io/File
    //   240: dup
    //   241: invokestatic 441	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   244: invokevirtual 60	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   247: ldc_w 443
    //   250: invokespecial 446	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   253: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   256: new 66	java/io/File
    //   259: dup
    //   260: invokestatic 441	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   263: invokevirtual 60	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   266: ldc_w 448
    //   269: invokespecial 446	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   272: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   275: aload_1
    //   276: invokevirtual 339	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   279: ldc_w 450
    //   282: iconst_4
    //   283: invokevirtual 454	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   286: invokeinterface 460 1 0
    //   291: invokeinterface 465 1 0
    //   296: invokeinterface 469 1 0
    //   301: pop
    //   302: aload_1
    //   303: invokevirtual 339	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   306: ldc_w 471
    //   309: iconst_4
    //   310: invokevirtual 454	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   313: invokeinterface 460 1 0
    //   318: invokeinterface 465 1 0
    //   323: invokeinterface 469 1 0
    //   328: pop
    //   329: new 66	java/io/File
    //   332: dup
    //   333: getstatic 474	acbn:bno	Ljava/lang/String;
    //   336: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   339: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   342: invokestatic 479	com/tencent/smtt/sdk/CacheManager:getCacheFileBaseDir	()Ljava/io/File;
    //   345: astore_0
    //   346: aload_0
    //   347: ifnull +7 -> 354
    //   350: aload_0
    //   351: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   354: invokestatic 484	com/tencent/mobileqq/shortvideo/ShortVideoUtils:dPu	()V
    //   357: new 66	java/io/File
    //   360: dup
    //   361: getstatic 487	acbn:bnr	Ljava/lang/String;
    //   364: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   367: astore_0
    //   368: aload_0
    //   369: invokevirtual 490	java/io/File:exists	()Z
    //   372: ifeq +7 -> 379
    //   375: aload_0
    //   376: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   379: aload_0
    //   380: invokevirtual 490	java/io/File:exists	()Z
    //   383: ifne +8 -> 391
    //   386: aload_0
    //   387: invokevirtual 493	java/io/File:mkdirs	()Z
    //   390: pop
    //   391: new 66	java/io/File
    //   394: dup
    //   395: getstatic 496	acbn:bmn	Ljava/lang/String;
    //   398: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   401: astore_0
    //   402: aload_0
    //   403: invokevirtual 490	java/io/File:exists	()Z
    //   406: ifeq +7 -> 413
    //   409: aload_0
    //   410: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   413: new 66	java/io/File
    //   416: dup
    //   417: getstatic 499	acbn:bmo	Ljava/lang/String;
    //   420: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   423: astore_0
    //   424: aload_0
    //   425: invokevirtual 490	java/io/File:exists	()Z
    //   428: ifeq +7 -> 435
    //   431: aload_0
    //   432: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   435: new 66	java/io/File
    //   438: dup
    //   439: getstatic 502	acbn:bnB	Ljava/lang/String;
    //   442: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   445: astore_0
    //   446: aload_0
    //   447: invokevirtual 490	java/io/File:exists	()Z
    //   450: ifeq +7 -> 457
    //   453: aload_0
    //   454: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   457: new 66	java/io/File
    //   460: dup
    //   461: getstatic 505	acbn:bnw	Ljava/lang/String;
    //   464: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   467: astore_0
    //   468: aload_0
    //   469: invokevirtual 490	java/io/File:exists	()Z
    //   472: ifeq +7 -> 479
    //   475: aload_0
    //   476: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   479: new 66	java/io/File
    //   482: dup
    //   483: new 47	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   490: getstatic 213	acbn:SDCARD_PATH	Ljava/lang/String;
    //   493: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc_w 507
    //   499: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   508: astore_0
    //   509: aload_0
    //   510: invokevirtual 490	java/io/File:exists	()Z
    //   513: ifeq +7 -> 520
    //   516: aload_0
    //   517: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   520: new 66	java/io/File
    //   523: dup
    //   524: getstatic 510	acbn:bmp	Ljava/lang/String;
    //   527: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   530: astore_0
    //   531: aload_0
    //   532: invokevirtual 490	java/io/File:exists	()Z
    //   535: ifeq +7 -> 542
    //   538: aload_0
    //   539: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   542: new 66	java/io/File
    //   545: dup
    //   546: getstatic 513	acbn:bmq	Ljava/lang/String;
    //   549: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   552: astore_0
    //   553: aload_0
    //   554: invokevirtual 490	java/io/File:exists	()Z
    //   557: ifeq +7 -> 564
    //   560: aload_0
    //   561: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   564: new 66	java/io/File
    //   567: dup
    //   568: getstatic 516	acbn:bmr	Ljava/lang/String;
    //   571: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   574: astore_0
    //   575: aload_0
    //   576: invokevirtual 490	java/io/File:exists	()Z
    //   579: ifeq +7 -> 586
    //   582: aload_0
    //   583: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   586: new 66	java/io/File
    //   589: dup
    //   590: getstatic 519	acbn:bms	Ljava/lang/String;
    //   593: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   596: astore_0
    //   597: aload_0
    //   598: invokevirtual 490	java/io/File:exists	()Z
    //   601: ifeq +7 -> 608
    //   604: aload_0
    //   605: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   608: new 66	java/io/File
    //   611: dup
    //   612: getstatic 522	acbn:bmt	Ljava/lang/String;
    //   615: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   618: astore_0
    //   619: aload_0
    //   620: invokevirtual 490	java/io/File:exists	()Z
    //   623: ifeq +7 -> 630
    //   626: aload_0
    //   627: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   630: new 66	java/io/File
    //   633: dup
    //   634: getstatic 525	acbn:bmu	Ljava/lang/String;
    //   637: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   640: astore_0
    //   641: aload_0
    //   642: invokevirtual 490	java/io/File:exists	()Z
    //   645: ifeq +7 -> 652
    //   648: aload_0
    //   649: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   652: new 66	java/io/File
    //   655: dup
    //   656: getstatic 528	acbn:bnH	Ljava/lang/String;
    //   659: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   662: astore_0
    //   663: aload_0
    //   664: invokevirtual 490	java/io/File:exists	()Z
    //   667: ifeq +7 -> 674
    //   670: aload_0
    //   671: invokestatic 419	dx:deleteFile	(Ljava/io/File;)V
    //   674: invokestatic 533	com/tencent/mobileqq/vas/VasQuickUpdateManager:cleanCache	()V
    //   677: invokestatic 538	ayzv:deleteCache	()V
    //   680: invokestatic 543	yhf:cip	()V
    //   683: return
    //   684: astore_0
    //   685: invokestatic 546	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   688: ifeq -5 -> 683
    //   691: ldc_w 548
    //   694: iconst_2
    //   695: new 47	java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   702: ldc_w 550
    //   705: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: aload_0
    //   709: invokevirtual 553	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   712: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: return
    //   722: astore_0
    //   723: goto -467 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	paramActivity	android.app.Activity
    //   0	726	1	paramQQAppInterface	QQAppInterface
    //   10	18	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   0	68	684	java/lang/Exception
    //   72	81	684	java/lang/Exception
    //   81	130	684	java/lang/Exception
    //   134	145	684	java/lang/Exception
    //   145	149	684	java/lang/Exception
    //   153	164	684	java/lang/Exception
    //   164	168	684	java/lang/Exception
    //   172	183	684	java/lang/Exception
    //   183	187	684	java/lang/Exception
    //   191	202	684	java/lang/Exception
    //   256	346	684	java/lang/Exception
    //   350	354	684	java/lang/Exception
    //   354	379	684	java/lang/Exception
    //   379	391	684	java/lang/Exception
    //   391	413	684	java/lang/Exception
    //   413	435	684	java/lang/Exception
    //   435	457	684	java/lang/Exception
    //   457	479	684	java/lang/Exception
    //   479	520	684	java/lang/Exception
    //   520	542	684	java/lang/Exception
    //   542	564	684	java/lang/Exception
    //   564	586	684	java/lang/Exception
    //   586	608	684	java/lang/Exception
    //   608	630	684	java/lang/Exception
    //   630	652	684	java/lang/Exception
    //   652	674	684	java/lang/Exception
    //   674	683	684	java/lang/Exception
    //   202	256	722	java/lang/Exception
  }
  
  private void bUs()
  {
    this.us = findViewById(2131365552);
    this.ut = findViewById(2131372002);
    this.progressBar = ((ProgressBar)this.us.findViewById(2131377675));
    this.Fq = ((TextView)this.us.findViewById(2131365553));
    this.aPh = getResources().getString(2131691047);
  }
  
  private void bUt()
  {
    if ((a != null) && (a.acb()))
    {
      b(a.GK, a.eZ(), a.fa(), a.fb());
      awsw.gC(this);
      if (VersionUtils.isGingerBread()) {
        this.e.setOverScrollMode(0);
      }
      return;
    }
    if (a != null) {
      a.onDestroy();
    }
    a = new ScanSpaceManager();
    a.a(this);
    a.bTy();
  }
  
  public static void bUu()
  {
    if (a != null)
    {
      a.onDestroy();
      a = null;
    }
  }
  
  private void bUw()
  {
    this.uu = findViewById(2131364547);
    this.uv = this.uu.findViewById(2131374986);
    this.uw = this.uu.findViewById(2131373062);
    this.ux = this.uu.findViewById(2131373032);
    this.uy = this.uu.findViewById(2131374730);
    this.uz = this.uu.findViewById(2131373030);
    this.uA = this.uu.findViewById(2131373027);
    this.Fr = ((TextView)this.uu.findViewById(2131374985));
    this.Fs = ((TextView)this.uu.findViewById(2131365238));
    ((GradientDrawable)this.uy.getBackground()).setColor(Color.parseColor("#00CAFC"));
    ((GradientDrawable)this.uz.getBackground()).setColor(Color.parseColor("#FFCC00"));
    ((GradientDrawable)this.uA.getBackground()).setColor(Color.parseColor("#EBEDF5"));
    this.bKe = getResources().getDimensionPixelOffset(2131298887);
    this.bKf = (this.bKe / 8);
    this.screenWidth = getResources().getDisplayMetrics().widthPixels;
    this.totalLength = (this.screenWidth - this.bKe * 2 - this.bKf * 2);
  }
  
  static void bUx()
  {
    deleteFiles(acbn.SDCARD_PATH + "photo/");
  }
  
  private void bUy()
  {
    int j = 0;
    Intent localIntent = getIntent();
    int i = j;
    if (localIntent != null)
    {
      i = j;
      if (localIntent.hasExtra("set_display_type")) {
        i = localIntent.getIntExtra("set_display_type", 0);
      }
    }
    if (i == 2)
    {
      setTitle(2131720397);
      return;
    }
    setTitle(2131701635);
  }
  
  private static void deleteFiles(String paramString)
  {
    paramString = new File(paramString);
    if (paramString != null)
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length)
        {
          paramString[i].delete();
          i += 1;
        }
      }
    }
  }
  
  private void fL(long paramLong)
  {
    this.GN -= paramLong;
    String str = acsh.aV(this.GN);
    this.Fr.setText(str);
  }
  
  public void Bs(int paramInt)
  {
    Bt(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    Bt(100);
    b(paramLong1, paramLong2, paramLong3, paramLong4);
    awsw.gC(this);
    if (VersionUtils.isGingerBread()) {
      this.e.setOverScrollMode(0);
    }
  }
  
  public void bUv()
  {
    if (this.progressBar != null) {
      this.progressBar.setMax(100);
    }
    Bt(0);
    this.us.setVisibility(0);
    this.ut.setVisibility(8);
    if (VersionUtils.isGingerBread()) {
      this.e.setOverScrollMode(2);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561688);
    this.e = ((BounceScrollView)findViewById(2131377757));
    setTitle(2131692497);
    bUs();
    bUw();
    bUt();
    this.currentUin = this.app.getCurrentAccountUin();
    setVolumeControlStream(3);
    if (aqil.bQ(this)) {
      VipUtils.a(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_installed_secure", 0, 0, null);
    }
    for (;;)
    {
      bUy();
      return true;
      VipUtils.a(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_not_intalled_secure", 0, 0, null);
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.v != null) && (this.v.isShowing())) {
      dismissDialog(1);
    }
    super.doOnDestroy();
    bUu();
    rvx.cJ(this);
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    if (this.zU) {}
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ((aqrb)this.app.getBusinessHandler(71)).a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 42255 });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    long l;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      l = paramIntent.getLongExtra("extra_delete_total_file_size", 0L);
    } while (l <= 0L);
    fL(l);
  }
  
  public void onGlobalLayout()
  {
    if (this.zU) {
      this.zU = false;
    }
  }
  
  public String setLastActivityName()
  {
    return getString(2131691410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity
 * JD-Core Version:    0.7.0.1
 */