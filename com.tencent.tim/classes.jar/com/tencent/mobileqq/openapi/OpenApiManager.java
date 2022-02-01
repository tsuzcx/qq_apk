package com.tencent.mobileqq.openapi;

import acff;
import achq;
import akuo;
import akup;
import akuq;
import akuq.a;
import akur;
import akus.b;
import akut;
import akuu;
import akuv.a;
import akuv.b;
import akuw;
import android.content.ContentProvider;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import aofk;
import aojs;
import aoko;
import aqgv;
import aqhq;
import aqjh;
import aqmr;
import asgx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import jqs;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tog;
import top;
import ujt;
import ujt.d;
import wja;
import wla;
import wla.a;
import xkx;

public class OpenApiManager
{
  public static final int AUTO_CLEAR_BUFFER_SIZE = 200;
  private static final boolean DEBUG_MSG = true;
  public static final int NOTICE_BUFFER_SZIE = 50;
  private static final String TAG = "OpenApi.Manager";
  private static OpenApiManager sInstance;
  private String mLastGetPayCodePermission;
  private String mLastGetPayCodePkgName;
  private QQAppInterface mLoginSucApp;
  private achq mMsgObserver = new akuo(this);
  private final Queue<akuv.b> mPayMsgRspQueue = new LinkedList();
  private View mPttHolderView;
  private wla.a mPttTransferCallback;
  private ConcurrentHashMap<Long, String> mSendingMsgMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, akur> mThirdAppMap = new ConcurrentHashMap();
  private int msgTypeFilterOfApps = 0;
  private int uinTypeFilterOfApps = 0;
  
  private void checkDownloadPtt(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    MessageForPtt localMessageForPtt;
    int i;
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForPtt)))
    {
      localMessageForPtt = (MessageForPtt)paramMessageRecord;
      i = xkx.a(paramQQAppInterface, localMessageForPtt);
      if (i != -1) {
        break label46;
      }
      ujt.a(paramQQAppInterface, paramMessageRecord.frienduin, localMessageForPtt, true, 3, 0, true);
    }
    label46:
    while ((!paramBoolean) || ((i != 2005) && (i != 2004))) {
      return;
    }
    ujt.a(paramQQAppInterface, paramMessageRecord.frienduin, localMessageForPtt, true, 2, 0, false);
  }
  
  private void checkDownloadPtt(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    checkDownloadPtt(paramQQAppInterface, paramQQAppInterface.b().b(paramString, paramInt, paramLong), false);
  }
  
  private boolean checkNeedPayAuth(akuv.b paramb)
  {
    if ((paramb == null) || (paramb.type != 3)) {}
    for (;;)
    {
      return false;
      try
      {
        int i = new JSONObject(paramb.bUs).optInt("retcode");
        if (i != 10001) {
          continue;
        }
        try
        {
          paramb = this.mLoginSucApp;
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("userId", paramb.getCurrentAccountUin());
          ((JSONObject)localObject).put("viewTag", "showWearPayAuthor");
          ((JSONObject)localObject).put("app_info", "appInfo");
          ((JSONObject)localObject).put("come_from", 2);
          ((JSONObject)localObject).put("extra_data", "{}");
          Bundle localBundle = new Bundle();
          localBundle.putString("json", ((JSONObject)localObject).toString());
          localBundle.putString("callbackSn", "0");
          localObject = new Intent(paramb.getApplication(), PayBridgeActivity.class);
          ((Intent)localObject).putExtras(localBundle);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).putExtra("pay_requestcode", 5);
          paramb.getApplication().startActivity((Intent)localObject);
          return true;
        }
        catch (Exception paramb)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              paramb.printStackTrace();
            }
          }
        }
        return false;
      }
      catch (JSONException paramb) {}
    }
  }
  
  @Deprecated
  private void cleanupPttCallback()
  {
    this.mPttHolderView = null;
    this.mPttTransferCallback = null;
  }
  
  private akuu copyMsgFromMessageRecord(MessageRecord paramMessageRecord, String paramString, int paramInt)
  {
    return null;
  }
  
  public static OpenApiManager getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new OpenApiManager();
      }
      OpenApiManager localOpenApiManager = sInstance;
      return localOpenApiManager;
    }
    finally {}
  }
  
  private void onRuntimeDisactive(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new OpenApiManager.2(this, paramQQAppInterface, paramBoolean));
  }
  
  private void resetFilters()
  {
    Iterator localIterator = this.mThirdAppMap.values().iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      akur localakur = (akur)localIterator.next();
      j |= localakur.Hf();
      i = localakur.Hg() | i;
    }
    this.msgTypeFilterOfApps = j;
    this.uinTypeFilterOfApps = i;
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "resetFilters | " + this.msgTypeFilterOfApps + " | " + this.uinTypeFilterOfApps);
    }
  }
  
  @Deprecated
  private void setupPttTransferCallback()
  {
    if (this.mPttHolderView != null) {
      return;
    }
    this.mPttHolderView = new View(BaseApplicationImpl.sApplication);
    this.mPttTransferCallback = new akup(this);
    wla.a(this.mLoginSucApp).a(this.mPttHolderView, this.mPttTransferCallback);
  }
  
  /* Error */
  public Pair<Integer, Integer> decodePtt(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/tencent/mobileqq/openapi/OpenApiManager:mLoginSucApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: astore 17
    //   6: aload 17
    //   8: ifnonnull +21 -> 29
    //   11: new 337	android/util/Pair
    //   14: dup
    //   15: iconst_m1
    //   16: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: iconst_0
    //   20: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   26: astore_1
    //   27: aload_1
    //   28: areturn
    //   29: aload_0
    //   30: getfield 47	com/tencent/mobileqq/openapi/OpenApiManager:mThirdAppMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: aload_1
    //   34: invokevirtual 350	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 279	akur
    //   40: astore_1
    //   41: aload_1
    //   42: ifnonnull +20 -> 62
    //   45: new 337	android/util/Pair
    //   48: dup
    //   49: bipush 254
    //   51: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: iconst_0
    //   55: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   61: areturn
    //   62: aload_1
    //   63: getfield 353	akur:packageName	Ljava/lang/String;
    //   66: aload_2
    //   67: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +20 -> 90
    //   73: new 337	android/util/Pair
    //   76: dup
    //   77: bipush 249
    //   79: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: iconst_0
    //   83: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   89: areturn
    //   90: aload_1
    //   91: sipush 256
    //   94: invokevirtual 363	akur:kL	(I)Z
    //   97: ifne +20 -> 117
    //   100: new 337	android/util/Pair
    //   103: dup
    //   104: bipush 252
    //   106: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: iconst_0
    //   110: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   116: areturn
    //   117: aload_1
    //   118: aload_3
    //   119: invokevirtual 367	akur:decrypt	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_2
    //   123: aload_1
    //   124: aload 5
    //   126: invokevirtual 367	akur:decrypt	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_3
    //   130: lconst_0
    //   131: lstore 13
    //   133: aload_3
    //   134: invokestatic 373	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   137: lstore 11
    //   139: aload_2
    //   140: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifne +17 -> 160
    //   146: aload_3
    //   147: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +10 -> 160
    //   153: lload 11
    //   155: lconst_0
    //   156: lcmp
    //   157: ifne +48 -> 205
    //   160: new 337	android/util/Pair
    //   163: dup
    //   164: bipush 250
    //   166: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: iconst_0
    //   170: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   176: areturn
    //   177: astore_1
    //   178: lload 13
    //   180: lstore 11
    //   182: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq -46 -> 139
    //   188: ldc 16
    //   190: iconst_2
    //   191: ldc_w 381
    //   194: aload_1
    //   195: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   198: lload 13
    //   200: lstore 11
    //   202: goto -63 -> 139
    //   205: iload 4
    //   207: iconst_1
    //   208: if_icmpne +598 -> 806
    //   211: aload 6
    //   213: getstatic 389	acbn:SDCARD_ROOT	Ljava/lang/String;
    //   216: invokevirtual 393	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   219: ifne +31 -> 250
    //   222: aload 7
    //   224: getstatic 389	acbn:SDCARD_ROOT	Ljava/lang/String;
    //   227: invokevirtual 393	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   230: ifne +20 -> 250
    //   233: new 337	android/util/Pair
    //   236: dup
    //   237: bipush 240
    //   239: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: iconst_0
    //   243: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   249: areturn
    //   250: aload 6
    //   252: invokestatic 398	aqhq:fileExists	(Ljava/lang/String;)Z
    //   255: ifne +20 -> 275
    //   258: new 337	android/util/Pair
    //   261: dup
    //   262: bipush 246
    //   264: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: iconst_0
    //   268: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   274: areturn
    //   275: aconst_null
    //   276: astore 16
    //   278: aconst_null
    //   279: astore_2
    //   280: iconst_0
    //   281: istore 9
    //   283: aconst_null
    //   284: astore 15
    //   286: aconst_null
    //   287: astore 5
    //   289: new 400	java/io/FileInputStream
    //   292: dup
    //   293: aload 6
    //   295: invokespecial 401	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   298: astore_1
    //   299: aload_1
    //   300: invokestatic 406	aqlv:a	(Ljava/io/InputStream;)B
    //   303: istore 8
    //   305: iload 8
    //   307: ifge +57 -> 364
    //   310: new 337	android/util/Pair
    //   313: dup
    //   314: bipush 251
    //   316: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   319: iconst_0
    //   320: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   326: astore_3
    //   327: aload_1
    //   328: ifnull +7 -> 335
    //   331: aload_1
    //   332: invokevirtual 409	java/io/FileInputStream:close	()V
    //   335: iconst_0
    //   336: ifeq +11 -> 347
    //   339: new 411	java/lang/NullPointerException
    //   342: dup
    //   343: invokespecial 412	java/lang/NullPointerException:<init>	()V
    //   346: athrow
    //   347: aload_3
    //   348: astore_1
    //   349: iconst_0
    //   350: ifeq -323 -> 27
    //   353: new 411	java/lang/NullPointerException
    //   356: dup
    //   357: invokespecial 412	java/lang/NullPointerException:<init>	()V
    //   360: athrow
    //   361: astore_1
    //   362: aload_3
    //   363: areturn
    //   364: aload 7
    //   366: invokestatic 416	aqhq:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   369: pop
    //   370: new 418	java/io/FileOutputStream
    //   373: dup
    //   374: aload 7
    //   376: invokespecial 419	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   379: astore_3
    //   380: iload 8
    //   382: invokestatic 423	aqlv:e	(B)I
    //   385: istore 4
    //   387: iload 4
    //   389: invokestatic 427	aqlv:kg	(I)I
    //   392: istore 9
    //   394: iload 9
    //   396: newarray byte
    //   398: astore 6
    //   400: iload 9
    //   402: newarray byte
    //   404: astore 7
    //   406: new 429	com/tencent/mobileqq/utils/SilkCodecWrapper
    //   409: dup
    //   410: aload 17
    //   412: invokevirtual 433	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   415: iconst_0
    //   416: invokespecial 436	com/tencent/mobileqq/utils/SilkCodecWrapper:<init>	(Landroid/content/Context;Z)V
    //   419: astore_2
    //   420: aload_2
    //   421: iload 4
    //   423: iconst_0
    //   424: iconst_1
    //   425: invokevirtual 440	com/tencent/mobileqq/utils/SilkCodecWrapper:init	(III)V
    //   428: iconst_2
    //   429: newarray byte
    //   431: astore 5
    //   433: aload_1
    //   434: aload 5
    //   436: invokevirtual 444	java/io/FileInputStream:read	([B)I
    //   439: istore 10
    //   441: iload 10
    //   443: iconst_m1
    //   444: if_icmpne +44 -> 488
    //   447: aload_1
    //   448: ifnull +7 -> 455
    //   451: aload_1
    //   452: invokevirtual 409	java/io/FileInputStream:close	()V
    //   455: aload_3
    //   456: ifnull +7 -> 463
    //   459: aload_3
    //   460: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   463: aload_2
    //   464: ifnull +7 -> 471
    //   467: aload_2
    //   468: invokevirtual 448	com/tencent/mobileqq/utils/SilkCodecWrapper:eer	()V
    //   471: new 337	android/util/Pair
    //   474: dup
    //   475: iconst_0
    //   476: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   479: iload 4
    //   481: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   487: areturn
    //   488: aload 5
    //   490: invokestatic 451	aqlv:z	([B)I
    //   493: istore 10
    //   495: iload 10
    //   497: ifgt +55 -> 552
    //   500: new 337	android/util/Pair
    //   503: dup
    //   504: bipush 241
    //   506: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   509: iconst_0
    //   510: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   513: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   516: astore 5
    //   518: aload_1
    //   519: ifnull +7 -> 526
    //   522: aload_1
    //   523: invokevirtual 409	java/io/FileInputStream:close	()V
    //   526: aload_3
    //   527: ifnull +7 -> 534
    //   530: aload_3
    //   531: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   534: aload 5
    //   536: astore_1
    //   537: aload_2
    //   538: ifnull -511 -> 27
    //   541: aload_2
    //   542: invokevirtual 448	com/tencent/mobileqq/utils/SilkCodecWrapper:eer	()V
    //   545: aload 5
    //   547: areturn
    //   548: astore_1
    //   549: aload 5
    //   551: areturn
    //   552: aload_1
    //   553: aload 6
    //   555: iconst_0
    //   556: iload 10
    //   558: invokevirtual 454	java/io/FileInputStream:read	([BII)I
    //   561: ifne +55 -> 616
    //   564: new 337	android/util/Pair
    //   567: dup
    //   568: bipush 241
    //   570: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   573: iconst_0
    //   574: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   577: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   580: astore 5
    //   582: aload_1
    //   583: ifnull +7 -> 590
    //   586: aload_1
    //   587: invokevirtual 409	java/io/FileInputStream:close	()V
    //   590: aload_3
    //   591: ifnull +7 -> 598
    //   594: aload_3
    //   595: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   598: aload 5
    //   600: astore_1
    //   601: aload_2
    //   602: ifnull -575 -> 27
    //   605: aload_2
    //   606: invokevirtual 448	com/tencent/mobileqq/utils/SilkCodecWrapper:eer	()V
    //   609: aload 5
    //   611: areturn
    //   612: astore_1
    //   613: aload 5
    //   615: areturn
    //   616: aload_2
    //   617: aload 6
    //   619: aload 7
    //   621: iload 10
    //   623: iload 9
    //   625: invokevirtual 457	com/tencent/mobileqq/utils/SilkCodecWrapper:a	([B[BII)I
    //   628: ifne +55 -> 683
    //   631: new 337	android/util/Pair
    //   634: dup
    //   635: bipush 239
    //   637: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   640: iconst_0
    //   641: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   644: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   647: astore 5
    //   649: aload_1
    //   650: ifnull +7 -> 657
    //   653: aload_1
    //   654: invokevirtual 409	java/io/FileInputStream:close	()V
    //   657: aload_3
    //   658: ifnull +7 -> 665
    //   661: aload_3
    //   662: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   665: aload 5
    //   667: astore_1
    //   668: aload_2
    //   669: ifnull -642 -> 27
    //   672: aload_2
    //   673: invokevirtual 448	com/tencent/mobileqq/utils/SilkCodecWrapper:eer	()V
    //   676: aload 5
    //   678: areturn
    //   679: astore_1
    //   680: aload 5
    //   682: areturn
    //   683: aload_3
    //   684: aload 7
    //   686: invokevirtual 461	java/io/FileOutputStream:write	([B)V
    //   689: goto -256 -> 433
    //   692: astore 6
    //   694: aload_2
    //   695: astore 5
    //   697: aload_3
    //   698: astore_2
    //   699: aload 6
    //   701: astore_3
    //   702: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   705: ifeq +13 -> 718
    //   708: ldc 16
    //   710: iconst_2
    //   711: ldc_w 463
    //   714: aload_3
    //   715: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   718: new 337	android/util/Pair
    //   721: dup
    //   722: bipush 244
    //   724: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   727: iload 4
    //   729: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   732: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   735: astore_3
    //   736: aload_1
    //   737: ifnull +7 -> 744
    //   740: aload_1
    //   741: invokevirtual 409	java/io/FileInputStream:close	()V
    //   744: aload_2
    //   745: ifnull +7 -> 752
    //   748: aload_2
    //   749: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   752: aload_3
    //   753: astore_1
    //   754: aload 5
    //   756: ifnull -729 -> 27
    //   759: aload 5
    //   761: invokevirtual 448	com/tencent/mobileqq/utils/SilkCodecWrapper:eer	()V
    //   764: aload_3
    //   765: areturn
    //   766: astore_1
    //   767: aload_3
    //   768: areturn
    //   769: astore_2
    //   770: aconst_null
    //   771: astore_1
    //   772: aconst_null
    //   773: astore_3
    //   774: aload 15
    //   776: astore 5
    //   778: aload_1
    //   779: ifnull +7 -> 786
    //   782: aload_1
    //   783: invokevirtual 409	java/io/FileInputStream:close	()V
    //   786: aload_3
    //   787: ifnull +7 -> 794
    //   790: aload_3
    //   791: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   794: aload 5
    //   796: ifnull +8 -> 804
    //   799: aload 5
    //   801: invokevirtual 448	com/tencent/mobileqq/utils/SilkCodecWrapper:eer	()V
    //   804: aload_2
    //   805: athrow
    //   806: new 337	android/util/Pair
    //   809: dup
    //   810: bipush 251
    //   812: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   815: iconst_0
    //   816: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   819: invokespecial 346	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   822: areturn
    //   823: astore_1
    //   824: goto -489 -> 335
    //   827: astore_1
    //   828: goto -481 -> 347
    //   831: astore_1
    //   832: goto -306 -> 526
    //   835: astore_1
    //   836: goto -302 -> 534
    //   839: astore_1
    //   840: goto -250 -> 590
    //   843: astore_1
    //   844: goto -246 -> 598
    //   847: astore_1
    //   848: goto -191 -> 657
    //   851: astore_1
    //   852: goto -187 -> 665
    //   855: astore_1
    //   856: goto -401 -> 455
    //   859: astore_1
    //   860: goto -397 -> 463
    //   863: astore_1
    //   864: goto -393 -> 471
    //   867: astore_1
    //   868: goto -124 -> 744
    //   871: astore_1
    //   872: goto -120 -> 752
    //   875: astore_1
    //   876: goto -90 -> 786
    //   879: astore_1
    //   880: goto -86 -> 794
    //   883: astore_1
    //   884: goto -80 -> 804
    //   887: astore_2
    //   888: aconst_null
    //   889: astore_3
    //   890: aload 15
    //   892: astore 5
    //   894: goto -116 -> 778
    //   897: astore_2
    //   898: aload 15
    //   900: astore 5
    //   902: goto -124 -> 778
    //   905: astore 6
    //   907: aload_2
    //   908: astore 5
    //   910: aload 6
    //   912: astore_2
    //   913: goto -135 -> 778
    //   916: astore 6
    //   918: aload_2
    //   919: astore_3
    //   920: aload 6
    //   922: astore_2
    //   923: goto -145 -> 778
    //   926: astore_3
    //   927: iload 9
    //   929: istore 4
    //   931: aload 16
    //   933: astore_1
    //   934: goto -232 -> 702
    //   937: astore_3
    //   938: iload 9
    //   940: istore 4
    //   942: goto -240 -> 702
    //   945: astore 6
    //   947: aload_3
    //   948: astore_2
    //   949: aload 6
    //   951: astore_3
    //   952: iload 9
    //   954: istore 4
    //   956: goto -254 -> 702
    //   959: astore 6
    //   961: aload_3
    //   962: astore_2
    //   963: aload 6
    //   965: astore_3
    //   966: goto -264 -> 702
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	969	0	this	OpenApiManager
    //   0	969	1	paramString1	String
    //   0	969	2	paramString2	String
    //   0	969	3	paramString3	String
    //   0	969	4	paramInt	int
    //   0	969	5	paramString4	String
    //   0	969	6	paramString5	String
    //   0	969	7	paramString6	String
    //   303	78	8	b	byte
    //   281	672	9	i	int
    //   439	183	10	j	int
    //   137	64	11	l1	long
    //   131	68	13	l2	long
    //   284	615	15	localObject1	Object
    //   276	656	16	localObject2	Object
    //   4	407	17	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   133	139	177	java/lang/Exception
    //   353	361	361	java/lang/Throwable
    //   541	545	548	java/lang/Throwable
    //   605	609	612	java/lang/Throwable
    //   672	676	679	java/lang/Throwable
    //   420	433	692	java/lang/Throwable
    //   433	441	692	java/lang/Throwable
    //   488	495	692	java/lang/Throwable
    //   500	518	692	java/lang/Throwable
    //   552	582	692	java/lang/Throwable
    //   616	649	692	java/lang/Throwable
    //   683	689	692	java/lang/Throwable
    //   759	764	766	java/lang/Throwable
    //   289	299	769	finally
    //   331	335	823	java/lang/Exception
    //   339	347	827	java/lang/Exception
    //   522	526	831	java/lang/Exception
    //   530	534	835	java/lang/Exception
    //   586	590	839	java/lang/Exception
    //   594	598	843	java/lang/Exception
    //   653	657	847	java/lang/Exception
    //   661	665	851	java/lang/Exception
    //   451	455	855	java/lang/Exception
    //   459	463	859	java/lang/Exception
    //   467	471	863	java/lang/Throwable
    //   740	744	867	java/lang/Exception
    //   748	752	871	java/lang/Exception
    //   782	786	875	java/lang/Exception
    //   790	794	879	java/lang/Exception
    //   799	804	883	java/lang/Throwable
    //   299	305	887	finally
    //   310	327	887	finally
    //   364	380	887	finally
    //   380	387	897	finally
    //   387	420	897	finally
    //   420	433	905	finally
    //   433	441	905	finally
    //   488	495	905	finally
    //   500	518	905	finally
    //   552	582	905	finally
    //   616	649	905	finally
    //   683	689	905	finally
    //   702	718	916	finally
    //   718	736	916	finally
    //   289	299	926	java/lang/Throwable
    //   299	305	937	java/lang/Throwable
    //   310	327	937	java/lang/Throwable
    //   364	380	937	java/lang/Throwable
    //   380	387	945	java/lang/Throwable
    //   387	420	959	java/lang/Throwable
  }
  
  public Pair<Integer, Integer> downloadMedia(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new Pair(Integer.valueOf(-1), Integer.valueOf(0));
    }
    paramString1 = (akur)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return new Pair(Integer.valueOf(-2), Integer.valueOf(0));
    }
    if (!paramString1.packageName.equals(paramString2)) {
      return new Pair(Integer.valueOf(-7), Integer.valueOf(0));
    }
    if (!paramString1.kL(512)) {
      return new Pair(Integer.valueOf(-4), Integer.valueOf(0));
    }
    paramString2 = paramString1.decrypt(paramString3);
    paramString1 = paramString1.decrypt(paramString4);
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return new Pair(Integer.valueOf(-6), Integer.valueOf(0));
    }
    long l;
    try
    {
      l = Long.parseLong(paramString1);
      if (paramInt == 1)
      {
        paramString1 = ((acff)localQQAppInterface.getManager(51)).e(paramString2);
        if ((paramString1 == null) || (!paramString1.isFriend())) {
          return new Pair(Integer.valueOf(-11), Integer.valueOf(0));
        }
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Manager", 2, "downMedia", paramString1);
      }
      return new Pair(Integer.valueOf(-6), Integer.valueOf(0));
    }
    if ((paramInt == 2) || (paramInt == 1) || (paramInt == 4))
    {
      paramString1 = localQQAppInterface.b().b(paramString2, akuw.iz(paramInt), l);
      if ((paramString1 == null) || (paramString1.isSendFromLocal())) {
        return new Pair(Integer.valueOf(-14), Integer.valueOf(0));
      }
      checkDownloadPtt(localQQAppInterface, paramString1, true);
      return new Pair(Integer.valueOf(0), Integer.valueOf(akuw.a(localQQAppInterface, (MessageForPtt)paramString1)));
    }
    return new Pair(Integer.valueOf(-5), Integer.valueOf(0));
  }
  
  public akuv.b[] exchangeUins(String paramString1, String paramString2, long paramLong1, long paramLong2, String[] paramArrayOfString)
  {
    paramString2 = new akuv.b[1];
    paramString2[0] = new akuv.b(0, null);
    paramString1 = akuq.b(BaseApplicationImpl.sApplication, paramString1);
    if (paramString1.aet != paramLong2)
    {
      paramString2[0].dpq = -20;
      return paramString2;
    }
    if (paramString1.aer != paramLong1)
    {
      paramString2[0].dpq = -19;
      return paramString2;
    }
    paramString1 = new akur(paramString1);
    if (!paramString1.kL(4))
    {
      paramString2[0].dpq = -4;
      return paramString2;
    }
    paramString2 = new akuv.b[paramArrayOfString.length];
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfString.length)
      {
        paramString2[i] = new akuv.b(0, null);
        try
        {
          paramString2[i].bUs = paramString1.encrypt(paramString1.mF(paramArrayOfString[i]));
          Object localObject = paramString2[i];
          if (TextUtils.isEmpty(paramString2[i].bUs))
          {
            j = -6;
            localObject.dpq = j;
            i += 1;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int j;
            if (QLog.isColorLevel())
            {
              QLog.d("OpenApi.Manager", 2, "", localException);
              continue;
              j = 0;
            }
          }
        }
      }
    }
    return paramString2;
  }
  
  public akuv.b getAvatarPath(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new akuv.b(-1, null);
    }
    paramString1 = (akur)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return new akuv.b(-2, null);
    }
    if (!paramString1.packageName.equals(paramString2)) {
      return new akuv.b(-7, null);
    }
    if (!paramString1.kL(4)) {
      return new akuv.b(-4, null);
    }
    paramString1 = paramString1.decrypt(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return new akuv.b(-6, null);
    }
    int i = 1;
    if (paramInt == 2) {
      i = 101;
    }
    for (;;)
    {
      return new akuv.b(0, localQQAppInterface.getCustomFaceFilePath(i, paramString1, 0));
      if (paramInt == 4) {
        i = 4;
      }
    }
  }
  
  public int getLastMessages(List<akuu> paramList, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return -1;
    }
    if (!akut.kO(paramInt1)) {
      return -5;
    }
    akur localakur = (akur)this.mThirdAppMap.get(paramString1);
    if (localakur == null) {
      return -2;
    }
    if (!localakur.packageName.equals(paramString2)) {
      return -7;
    }
    paramString1 = localakur.decrypt(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return -6;
    }
    if (!localakur.kL(2)) {
      return -4;
    }
    List localList = localQQAppInterface.b().i(paramString1, akuw.iz(paramInt1), paramInt2);
    top.a(paramString1, akuw.iz(paramInt1), localList, localQQAppInterface);
    paramInt2 = 0;
    if (paramInt2 < localList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(paramInt2);
      if ((paramBoolean1) && (localMessageRecord.isSend())) {}
      while ((paramBoolean2) && (localMessageRecord.isread))
      {
        paramInt2 += 1;
        break;
      }
      if ((localMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)localMessageRecord).parse();
      }
      int i = akuw.ix(localMessageRecord.msgtype);
      String str2 = localakur.encrypt(String.valueOf(localMessageRecord.uniseq));
      paramString1 = null;
      paramString2 = null;
      int j = 1007;
      if ((i == 1) && (localakur.bc(paramInt1, 1)))
      {
        paramString1 = new aofk(localMessageRecord.msg, 3).AE();
        label269:
        if (paramInt1 != 1) {
          break label545;
        }
      }
      label545:
      for (String str1 = "";; str1 = localakur.encrypt(localMessageRecord.senderuin))
      {
        paramList.add(new akuu(paramString3, paramInt1, str1, i, str2, localMessageRecord.time, localMessageRecord.isSend(), paramString1, paramString2, j));
        break;
        if ((i == 2) && ((localMessageRecord instanceof MessageForPtt)) && (localakur.bc(paramInt1, 2)))
        {
          checkDownloadPtt(localQQAppInterface, localMessageRecord, false);
          paramString2 = ((MessageForPtt)localMessageRecord).getLocalFilePath();
          j = akuw.a(localQQAppInterface, (MessageForPtt)localMessageRecord);
          break label269;
        }
        if ((i == 4) && (localakur.bc(paramInt1, 4)))
        {
          paramString1 = new aofk(localMessageRecord.msg, 3).AE();
          break label269;
        }
        if ((i == 8) && (localakur.bc(paramInt1, 8)))
        {
          paramString1 = akuu.bUn;
          break label269;
        }
        if ((i == 16) && (localakur.bc(paramInt1, 16)))
        {
          paramString1 = akuu.bUo;
          break label269;
        }
        if ((i == 32) && (localakur.bc(paramInt1, 32)))
        {
          paramString1 = akuu.bUp;
          break label269;
        }
        if ((i == 64) && (localakur.bc(paramInt1, 64)))
        {
          paramString1 = akuu.bUq;
          break label269;
        }
        if (!localakur.bc(paramInt1, 1073741824)) {
          break;
        }
        i = 1073741824;
        paramString1 = akuu.bUr;
        break label269;
      }
    }
    return 0;
  }
  
  public akuv.b getNickName(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.mLoginSucApp == null) {
      return new akuv.b(-1, null);
    }
    paramString1 = (akur)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return new akuv.b(-2, null);
    }
    if (!paramString1.packageName.equals(paramString2)) {
      return new akuv.b(-7, null);
    }
    if (!paramString1.kL(8)) {
      return new akuv.b(-4, null);
    }
    if (!akut.kO(paramInt)) {
      return new akuv.b(-5, null);
    }
    paramString1 = paramString1.decrypt(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return new akuv.b(-6, null);
    }
    paramInt = akuw.iz(paramInt);
    return new akuv.b(0, aqgv.d(this.mLoginSucApp, paramString1, paramInt));
  }
  
  public List<akuv.b> handlePayMsgReq(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return handlePayMsgRsp(new akuv.b(paramInt, -1, paramString4));
    }
    if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return handlePayMsgRsp(new akuv.b(paramInt, -6, paramString4));
    }
    paramString1 = akuq.b(BaseApplicationImpl.sApplication, paramString1);
    if (paramString1 == null) {
      return handlePayMsgRsp(new akuv.b(paramInt, -8, paramString4));
    }
    if (!paramString1.pkgName.equals(paramString2)) {
      return handlePayMsgRsp(new akuv.b(paramInt, -7, paramString4));
    }
    if (!akuq.j(BaseApplicationImpl.sApplication, paramString2, paramString1.bUk)) {
      return handlePayMsgRsp(new akuv.b(paramInt, -7, paramString4));
    }
    this.mLastGetPayCodePkgName = paramString2;
    this.mLastGetPayCodePermission = paramString3;
    paramString2 = new Bundle();
    paramString2.putInt("PayInvokerId", 15);
    paramString3 = new HashMap();
    paramString3.put("pkgName", paramString1.pkgName);
    paramString3.put("businessType", String.valueOf(paramInt));
    paramString3.put("reqData", paramString4);
    paramString4 = localQQAppInterface.getCurrentAccountUin();
    paramString1 = (TicketManager)localQQAppInterface.getManager(2);
    if (paramString1 != null) {}
    for (paramString1 = paramString1.getSkey(paramString4);; paramString1 = "")
    {
      paramString2.putString("uin", paramString4);
      paramString2.putString("skey", paramString1);
      paramString2.putString("skey_type", "2");
      paramString2.putSerializable("map", paramString3);
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, localQQAppInterface, paramString2);
      paramString1 = localQQAppInterface.getApp();
      if (Build.VERSION.SDK_INT > 10) {}
      for (paramInt = 4;; paramInt = 0)
      {
        paramString1 = paramString1.getSharedPreferences("qwallet_multi", paramInt);
        if (paramString1 != null) {
          paramString1.edit().putLong("tenwatch_req_time_prefix_" + paramString4, NetConnInfoCenter.getServerTimeMillis() / 1000L).commit();
        }
        return handlePayMsgRsp(null);
      }
    }
  }
  
  public List<akuv.b> handlePayMsgRsp(akuv.b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mPayMsgRspQueue)
    {
      if (!this.mPayMsgRspQueue.isEmpty()) {
        localArrayList.add(this.mPayMsgRspQueue.poll());
      }
    }
    this.mPayMsgRspQueue.clear();
    if (paramb != null) {
      localArrayList.add(paramb);
    }
    return localArrayList;
  }
  
  public boolean isSDKEnable()
  {
    String str2 = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.openapi_switch.name(), null);
    if (str2 != null)
    {
      String str1 = str2;
      if (str2.length() > 1) {
        str1 = str2.substring(0, 1);
      }
      return str1.equals("0");
    }
    return true;
  }
  
  public void onFileTransStatusChanged(aoko paramaoko, int paramInt1, int paramInt2)
  {
    if (paramaoko.fileType != 2) {}
    label641:
    label647:
    for (;;)
    {
      return;
      if ((paramInt1 != 2002) && (paramInt1 != 1002) && (paramInt1 != 2001) && (this.mThirdAppMap.size() != 0) && (isSDKEnable()))
      {
        Object localObject1;
        Object localObject2;
        if ((this.mSendingMsgMap.contains(Long.valueOf(paramaoko.uniseq))) && ((paramInt1 == 1004) || (paramInt1 == 1005) || (paramInt1 == 1003)))
        {
          localObject1 = (String)this.mSendingMsgMap.remove(Long.valueOf(paramaoko.uniseq));
          localObject1 = (akur)this.mThirdAppMap.get(localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Manager", 2, "onPttStateChange, thirdApp = " + localObject1 + ", status = " + paramInt1);
          }
          if (localObject1 != null)
          {
            localObject2 = new Intent("com.tencent.mobileqq.openapi.ACTION_MSG_SENDED." + ((akur)localObject1).packageName);
            ((Intent)localObject2).putExtra("msgid", ((akur)localObject1).encrypt(String.valueOf(paramaoko.uniseq)));
            if (paramInt1 != 1003) {
              break label595;
            }
            paramInt2 = 0;
            label229:
            ((Intent)localObject2).putExtra("rs_code", paramInt2);
            BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, ((akur)localObject1).bUl);
          }
        }
        int i;
        if (paramaoko.uinType == 0)
        {
          paramInt2 = 0;
          i = 1;
        }
        for (;;)
        {
          label264:
          if (((this.msgTypeFilterOfApps & 0x2) <= 0) || ((this.uinTypeFilterOfApps & i) <= 0)) {
            break label647;
          }
          String str = paramaoko.friendUin;
          localObject1 = this.mLoginSucApp;
          if (paramaoko.actionType == 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramInt1 = akuw.a((QQAppInterface)localObject1, paramInt1, bool);
            if (QLog.isColorLevel()) {
              QLog.d("OpenApi.Manager", 2, "onPttStateChange, uin = " + str + ", extStatus = " + paramInt1);
            }
            Iterator localIterator = this.mThirdAppMap.values().iterator();
            localObject2 = null;
            while (localIterator.hasNext())
            {
              akur localakur = (akur)localIterator.next();
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("uin_type", i);
                ((Intent)localObject1).putExtra("msg_type", 2);
                ((Intent)localObject1).putExtra("mediaStatus", paramInt1);
              }
              if ((paramInt1 == 1003) && (this.mLoginSucApp != null))
              {
                localObject2 = this.mLoginSucApp.b();
                if (localObject2 != null)
                {
                  localObject2 = ((QQMessageFacade)localObject2).b(str, paramInt2, paramaoko.uniseq);
                  if (localObject2 != null) {
                    ((Intent)localObject1).putExtra("media_path", ((MessageForPtt)localObject2).getLocalFilePath());
                  }
                }
              }
              localObject2 = localObject1;
              if (localakur.bd(i, 2))
              {
                ((Intent)localObject1).putExtra("msgid", localakur.encrypt(String.valueOf(paramaoko.uniseq)));
                ((Intent)localObject1).setAction("com.tencent.mobileqq.openapi.ACTION_MSG_STATUS_UPDATE." + localakur.packageName);
                BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject1, localakur.bUl);
                localObject2 = localObject1;
              }
            }
            break;
            label595:
            paramInt2 = -9;
            break label229;
            if (paramaoko.uinType == 2)
            {
              paramInt2 = 3000;
              i = 2;
              break label264;
            }
            if (paramaoko.uinType != 1) {
              break label641;
            }
            paramInt2 = 1;
            i = 4;
            break label264;
          }
          paramInt2 = 0;
          i = 0;
        }
      }
    }
  }
  
  public void onMessageReaded(String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((this.mThirdAppMap.size() == 0) || (this.mLoginSucApp == null) || (!isSDKEnable())) {
      break label24;
    }
    for (;;)
    {
      label24:
      return;
      if ((paramInt == 0) || (paramInt == 3000) || (paramInt == 1))
      {
        paramInt = akuw.iy(paramInt);
        if ((this.uinTypeFilterOfApps & paramInt) <= 0) {
          break;
        }
        Object localObject1 = null;
        Iterator localIterator = this.mThirdAppMap.values().iterator();
        while (localIterator.hasNext())
        {
          akur localakur = (akur)localIterator.next();
          Object localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("uin_type", paramInt);
            ((Intent)localObject2).putExtra("is_all", paramBoolean);
            ((Intent)localObject2).putExtra("msgTime", paramLong);
          }
          localObject1 = localObject2;
          if (localakur.kN(paramInt))
          {
            ((Intent)localObject2).putExtra("uin", localakur.encrypt(paramString));
            ((Intent)localObject2).setAction("com.tencent.mobileqq.openapi.ACTION_MSG_READED." + localakur.packageName);
            BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, localakur.bUl);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public final void onPayMsgRsp(akuv.b paramb)
  {
    if (checkNeedPayAuth(paramb)) {}
    for (;;)
    {
      return;
      synchronized (this.mPayMsgRspQueue)
      {
        int i = this.mPayMsgRspQueue.size();
        if (i > 200) {
          this.mPayMsgRspQueue.clear();
        }
        while ((i <= 50) || (!QLog.isDevelopLevel()))
        {
          this.mPayMsgRspQueue.add(paramb);
          if ((this.mLoginSucApp == null) || (!isSDKEnable())) {
            break;
          }
          paramb = new Intent();
          paramb.setAction("com.tencent.mobileqq.openapi.ACTION_PAYMSG_RCV." + this.mLastGetPayCodePkgName);
          BaseApplicationImpl.sApplication.sendBroadcast(paramb, this.mLastGetPayCodePermission);
          return;
        }
        QLog.i("OpenApi.Manager", 4, "Pay rsp queue size:" + i);
      }
    }
  }
  
  public void onReceiveNewMsg(QQMessageFacade.Message paramMessage)
  {
    int i = 0;
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if ((this.mThirdAppMap.size() == 0) || (localQQAppInterface == null) || (!isSDKEnable())) {}
    int k;
    int m;
    do
    {
      do
      {
        return;
      } while ((paramMessage.istroop != 0) && (paramMessage.istroop != 3000) && (paramMessage.istroop != 1));
      k = akuw.ix(paramMessage.msgtype);
      m = akuw.iy(paramMessage.istroop);
    } while ((((this.msgTypeFilterOfApps & k) <= 0) && ((this.msgTypeFilterOfApps & 0x40000000) <= 0)) || ((this.uinTypeFilterOfApps & m) <= 0));
    String str1 = paramMessage.frienduin;
    String str2 = paramMessage.senderuin;
    int n = localQQAppInterface.a().A(paramMessage.frienduin, paramMessage.istroop);
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "new msg, uin = " + aqmr.getSimpleUinForPrint(str1));
    }
    Object localObject1 = null;
    Iterator localIterator = this.mThirdAppMap.values().iterator();
    label188:
    Object localObject2;
    int j;
    if (localIterator.hasNext())
    {
      akur localakur = (akur)localIterator.next();
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("uin_type", m);
        ((Intent)localObject2).putExtra("unreadCount", n);
      }
      boolean bool = localakur.bd(m, k);
      if ((!bool) && (!localakur.kM(m))) {
        break label415;
      }
      if (!bool) {
        break label410;
      }
      j = k;
      label284:
      ((Intent)localObject2).putExtra("msg_type", j);
      ((Intent)localObject2).putExtra("uin", localakur.encrypt(str1));
      ((Intent)localObject2).putExtra("senderUin", localakur.encrypt(str2));
      ((Intent)localObject2).setAction("com.tencent.mobileqq.openapi.ACTION_NEW_MSG." + localakur.packageName);
      BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, localakur.bUl);
      if ((paramMessage.msgtype != -2002) || (i != 0)) {
        break label415;
      }
      checkDownloadPtt(localQQAppInterface, paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
      i = 1;
    }
    label410:
    label415:
    for (;;)
    {
      localObject1 = localObject2;
      break label188;
      break;
      j = 0;
      break label284;
    }
  }
  
  public void onRuntimeActive(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new OpenApiManager.1(this, paramQQAppInterface));
  }
  
  public void onRuntimeDestroy(QQAppInterface paramQQAppInterface)
  {
    onRuntimeDisactive(paramQQAppInterface, false);
  }
  
  public void onUserLogout(QQAppInterface paramQQAppInterface)
  {
    onRuntimeDisactive(paramQQAppInterface, true);
  }
  
  public int openAIO(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return -1;
    }
    paramString1 = (akur)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return -2;
    }
    if (!paramString1.packageName.equals(paramString2)) {
      return -7;
    }
    if (!paramString1.kL(64)) {
      return -4;
    }
    paramString1 = paramString1.decrypt(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return -6;
    }
    if (paramInt == 1)
    {
      paramString2 = ((acff)localQQAppInterface.getManager(51)).e(paramString1);
      if ((paramString2 == null) || (!paramString2.isFriend())) {
        return -11;
      }
      paramString3 = wja.a(new Intent(BaseApplicationImpl.sApplication, SplashActivity.class), new int[] { 2 });
      paramString3.addFlags(268435456);
      paramString3.putExtra("uin", paramString1);
      paramString3.putExtra("cSpecialFlag", paramString2.cSpecialFlag);
      paramString3.putExtra("uinname", aqgv.c(paramString2));
      if ((jqs.cU(paramString2.cSpecialFlag)) || (asgx.mS(paramString2.cSpecialFlag)))
      {
        paramString3.setClass(BaseApplicationImpl.sApplication, SplashActivity.class);
        paramString3.putExtra("chat_subType", 1);
      }
      paramString3.putExtra("entrance", 0);
      paramString3.putExtra("uintype", 0);
      BaseApplicationImpl.sApplication.startActivity(paramString3);
      return 0;
    }
    return -5;
  }
  
  public akuv.a registerThirdApp(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2, String paramString3)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new akuv.a(-1, 0L, null);
    }
    Object localObject = (akur)this.mThirdAppMap.get(paramString1);
    if (localObject == null)
    {
      localObject = akuq.b(BaseApplicationImpl.sApplication, paramString1);
      if (localObject == null) {
        return new akuv.a(-8, 0L, null);
      }
      if (!((akuq.a)localObject).pkgName.equals(paramString2)) {
        return new akuv.a(-7, 0L, null);
      }
      if (!akuq.j(BaseApplicationImpl.sApplication, paramString2, ((akuq.a)localObject).bUk)) {
        return new akuv.a(-7, 0L, null);
      }
      if ((((akuq.a)localObject).cuE) && (paramLong != ((akuq.a)localObject).aet)) {
        return new akuv.a(-18, ((akuq.a)localObject).aet, null);
      }
      if ((!((akuq.a)localObject).cuE) && (paramLong != ((akuq.a)localObject).aer)) {
        return new akuv.a(-18, ((akuq.a)localObject).aer, null);
      }
      if (((akuq.a)localObject).cuE) {
        akuq.a(BaseApplicationImpl.sApplication, (akuq.a)localObject);
      }
      paramString2 = new akur((akuq.a)localObject);
      paramString2.bUl = paramString3;
      this.mThirdAppMap.put(paramString1, paramString2);
      paramString3 = paramString2;
    }
    while (paramLong != paramString3.aeu)
    {
      this.mThirdAppMap.remove(paramString1);
      resetFilters();
      return new akuv.a(-18, paramString3.aeu, null);
      paramString3 = (String)localObject;
      if (!((akur)localObject).packageName.equals(paramString2)) {
        return new akuv.a(-7, 0L, null);
      }
    }
    paramString3.iY(paramInt1, paramInt2);
    resetFilters();
    return new akuv.a(0, 0L, paramString3.encrypt(localQQAppInterface.getCurrentAccountUin()));
  }
  
  public akuv.b sendMessage(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new akuv.b(-1, null);
    }
    akur localakur = (akur)this.mThirdAppMap.get(paramString1);
    if (localakur == null) {
      return new akuv.b(-2, null);
    }
    if (!localakur.packageName.equals(paramString2)) {
      return new akuv.b(-7, null);
    }
    if (!localakur.kL(8)) {
      return new akuv.b(-4, null);
    }
    paramString3 = localakur.decrypt(paramString3);
    if (TextUtils.isEmpty(paramString3)) {
      return new akuv.b(-6, null);
    }
    long l1 = 0L;
    if (paramInt1 == 1)
    {
      paramString2 = ((acff)localQQAppInterface.getManager(51)).e(paramString3);
      if ((paramString2 == null) || (!paramString2.isFriend())) {
        return new akuv.b(-11, null);
      }
      paramString2 = new SessionInfo();
      paramString2.aTl = paramString3;
      paramString2.cZ = 0;
      paramString2.aTn = aqgv.D(localQQAppInterface, paramString3);
      if (paramInt2 == 1)
      {
        if (TextUtils.isEmpty(paramString4)) {
          return new akuv.b(-6, null);
        }
        paramString2 = ujt.a(localQQAppInterface, localQQAppInterface.getApp(), paramString2, paramString4, null, new ujt.d());
        if ((paramString2 == null) || (paramString2.length == 0)) {
          return new akuv.b(-9, null);
        }
        l1 = paramString2[(paramString2.length - 1)];
      }
      for (;;)
      {
        this.mSendingMsgMap.put(Long.valueOf(l1), paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("OpenApi.Manager", 2, "send message: " + l1);
        }
        return new akuv.b(0, localakur.encrypt(String.valueOf(l1)));
        if (paramInt2 == 2)
        {
          if (TextUtils.isEmpty(paramString5)) {
            return new akuv.b(-6, null);
          }
          paramString3 = new File(paramString5);
          if ((!paramString3.exists()) || (paramString3.length() < 700L) || (paramString3.length() > 42000L)) {
            return new akuv.b(-6, null);
          }
          if (!aqjh.e(paramString5, akus.b.ml)) {
            return new akuv.b(-13, null);
          }
          paramString3 = MessageForPtt.getLocalFilePath(2, aojs.a(localQQAppInterface.getCurrentAccountUin(), null, 2, null));
          aqhq.copyFile(paramString5, paramString3);
          paramString4 = ujt.a(localQQAppInterface, paramString3, paramString2, -3, 0);
          ((MessageForPtt)paramString4).c2cViaOffline = true;
          l1 = paramString4.uniseq;
          long l2 = QQRecorder.fi(paramString3);
          paramString5 = new Bundle();
          paramString5.putInt("DiyTextId", paramString4.vipBubbleDiyTextId);
          ujt.a(localQQAppInterface, paramString2.cZ, paramString2.aTl, paramString3, l1, true, (int)(1000L * l2), 0, true, 0, 0, true, paramString4.vipSubBubbleId, paramString5);
        }
      }
    }
    return new akuv.b(-5, null);
  }
  
  public int setMessageReaded(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return -1;
    }
    akur localakur = (akur)this.mThirdAppMap.get(paramString1);
    if (localakur == null) {
      return -2;
    }
    if (!localakur.packageName.equals(paramString2)) {
      return -7;
    }
    if (!localakur.kL(16)) {
      return -4;
    }
    paramString1 = localakur.decrypt(paramString3);
    paramString2 = localakur.decrypt(paramString4);
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString2);
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (l1 == 0L)) {
        return -6;
      }
    }
    catch (Exception paramString3)
    {
      long l1;
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("OpenApi.Manager", 2, "setMsgReaded, id = " + paramString2, paramString3);
          l1 = l2;
        }
      }
      if (paramInt == 1)
      {
        paramString2 = localQQAppInterface.b();
        paramString3 = paramString2.b(paramString1, 0, l1);
        if (paramString3 == null) {
          return -14;
        }
        paramString2.s(paramString1, 0, paramString3.time);
        return 0;
      }
    }
    return -5;
  }
  
  public int unregisterThirdApp(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "unregister, appid = " + paramString1);
    }
    akur localakur = (akur)this.mThirdAppMap.get(paramString1);
    if ((localakur != null) && (!localakur.packageName.equals(paramString2))) {
      return -7;
    }
    this.mThirdAppMap.remove(paramString1);
    return 0;
  }
  
  public boolean verifyCallingPackage(ContentProvider paramContentProvider, String paramString)
  {
    try
    {
      int i = Binder.getCallingUid();
      if (i == 0) {
        return false;
      }
      paramContentProvider = BaseApplicationImpl.sApplication.getPackageManager().getPackagesForUid(i);
      int j = paramContentProvider.length;
      i = 0;
      while (i < j)
      {
        boolean bool = paramContentProvider[i].equals(paramString);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramContentProvider)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OpenApi.Manager", 2, "verifyPackage " + paramString, paramContentProvider);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.OpenApiManager
 * JD-Core Version:    0.7.0.1
 */