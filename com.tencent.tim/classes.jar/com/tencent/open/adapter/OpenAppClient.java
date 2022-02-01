package com.tencent.open.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import aroi;
import arue;
import arug;
import arwo;
import arwt;
import aryg;
import aryr;
import asad;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class OpenAppClient
{
  public static final String TAG = OpenAppClient.class.getName();
  protected static boolean dcu;
  protected static int ekC = 7;
  protected static int ekD = 11;
  
  public static void J(AppInterface paramAppInterface)
  {
    aryg.fR(aroi.a().getContext());
    String str = "";
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        break label70;
      }
      ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
      str = ((QQAppInterface)paramAppInterface).getAccount();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {}
      label70:
      try
      {
        aroi.a().setUin(Long.valueOf(str).longValue());
        return;
      }
      catch (Exception paramAppInterface) {}
      if ((paramAppInterface instanceof BrowserAppInterface))
      {
        str = ((BrowserAppInterface)paramAppInterface).getAccount();
        ThreadManager.executeOnNetWorkThread(new GetVkeyRunnable(paramAppInterface, 0, ""));
      }
    }
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    arwt.i(TAG, "onPcPushMsgBackground " + paramString1);
    if (arwo.cr(paramContext))
    {
      Object localObject = arug.y(paramString1);
      ((HashMap)localObject).put("schemaUrl", paramString1);
      ((HashMap)localObject).put("friendUin", paramString2);
      ((HashMap)localObject).put("istroop", paramInt + "");
      if (c(paramContext, (HashMap)localObject)) {
        return null;
      }
      paramContext = (String)((HashMap)localObject).get("appid");
      String str1 = (String)((HashMap)localObject).get("packname");
      String str2 = (String)((HashMap)localObject).get("downurl");
      localObject = (String)((HashMap)localObject).get("appname");
      String str3 = "_" + paramContext;
      if (aryr.sz(paramContext))
      {
        new Handler(Looper.getMainLooper()).post(new OpenAppClient.1(paramContext, (String)localObject, str1, str3, str2, paramString1, paramString2, paramInt));
        return null;
      }
      return asad.a(paramString1, paramString2, paramInt);
    }
    return asad.a(paramString1, paramString2, paramInt);
  }
  
  /* Error */
  protected static boolean c(Context paramContext, HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 207	java/util/HashMap:size	()I
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ldc 209
    //   16: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 162	java/lang/String
    //   22: invokestatic 215	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   25: istore_2
    //   26: iload_2
    //   27: iconst_1
    //   28: if_icmpne +82 -> 110
    //   31: aload_1
    //   32: ldc 156
    //   34: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 162	java/lang/String
    //   40: invokestatic 176	aryr:sz	(Ljava/lang/String;)Z
    //   43: istore_3
    //   44: iload_3
    //   45: ifeq +22 -> 67
    //   48: iconst_0
    //   49: ireturn
    //   50: astore 4
    //   52: getstatic 24	com/tencent/open/adapter/OpenAppClient:TAG	Ljava/lang/String;
    //   55: ldc 217
    //   57: aload 4
    //   59: invokestatic 221	arwt:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   62: iconst_m1
    //   63: istore_2
    //   64: goto -38 -> 26
    //   67: new 223	com/tencent/open/adapter/OpenAppClient$2
    //   70: dup
    //   71: aload_0
    //   72: aload_1
    //   73: invokespecial 226	com/tencent/open/adapter/OpenAppClient$2:<init>	(Landroid/content/Context;Ljava/util/HashMap;)V
    //   76: invokestatic 229	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   79: iconst_1
    //   80: ireturn
    //   81: astore_0
    //   82: new 107	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   89: ldc 231
    //   91: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_1
    //   102: getstatic 24	com/tencent/open/adapter/OpenAppClient:TAG	Ljava/lang/String;
    //   105: aload_1
    //   106: aload_0
    //   107: invokestatic 237	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: iconst_0
    //   111: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramContext	Context
    //   0	112	1	paramHashMap	HashMap<String, String>
    //   25	39	2	i	int
    //   43	2	3	bool	boolean
    //   50	8	4	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   13	26	50	java/lang/NumberFormatException
    //   31	44	81	java/lang/Exception
    //   67	79	81	java/lang/Exception
  }
  
  public static void da(Context paramContext, String paramString)
  {
    arwt.i(TAG, "onPcPushMsgForground " + paramString);
    if (arwo.cr(paramContext)) {
      c(paramContext, arug.y(paramString));
    }
  }
  
  /* Error */
  protected static void e(Context paramContext, HashMap<String, String> paramHashMap)
    throws Exception
  {
    // Byte code:
    //   0: getstatic 24	com/tencent/open/adapter/OpenAppClient:TAG	Ljava/lang/String;
    //   3: new 107	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   10: ldc 245
    //   12: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 123	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: iconst_m1
    //   26: istore_2
    //   27: iconst_m1
    //   28: istore_3
    //   29: aload_1
    //   30: ldc 156
    //   32: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 162	java/lang/String
    //   38: astore 11
    //   40: aload_1
    //   41: ldc 164
    //   43: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 162	java/lang/String
    //   49: astore 12
    //   51: aload_1
    //   52: ldc 247
    //   54: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 162	java/lang/String
    //   60: astore 8
    //   62: aload_1
    //   63: ldc 166
    //   65: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 162	java/lang/String
    //   71: astore 13
    //   73: aload_1
    //   74: ldc 249
    //   76: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 162	java/lang/String
    //   82: astore 9
    //   84: aload_1
    //   85: ldc 168
    //   87: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 162	java/lang/String
    //   93: astore_1
    //   94: aload_1
    //   95: astore 7
    //   97: aload_1
    //   98: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +7 -> 108
    //   104: ldc 54
    //   106: astore 7
    //   108: new 107	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   115: ldc 170
    //   117: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 11
    //   122: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: astore 14
    //   130: invokestatic 254	aryy:a	()Laryy;
    //   133: aload 11
    //   135: invokevirtual 257	aryy:qz	(Ljava/lang/String;)Ljava/lang/String;
    //   138: astore_1
    //   139: aload 12
    //   141: invokestatic 262	arxn:fA	(Ljava/lang/String;)I
    //   144: ifle +9 -> 153
    //   147: aload 12
    //   149: invokestatic 262	arxn:fA	(Ljava/lang/String;)I
    //   152: istore_2
    //   153: aload_1
    //   154: invokestatic 265	arxn:fB	(Ljava/lang/String;)I
    //   157: ifle +8 -> 165
    //   160: aload_1
    //   161: invokestatic 265	arxn:fB	(Ljava/lang/String;)I
    //   164: istore_3
    //   165: getstatic 24	com/tencent/open/adapter/OpenAppClient:TAG	Ljava/lang/String;
    //   168: new 107	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 267
    //   178: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload_2
    //   182: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: ldc_w 269
    //   188: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: iload_3
    //   192: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 271
    //   198: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: iload_3
    //   202: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 274	arwt:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 8
    //   213: invokestatic 277	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   216: invokevirtual 280	java/lang/Integer:intValue	()I
    //   219: istore 4
    //   221: aconst_null
    //   222: astore_1
    //   223: aconst_null
    //   224: astore 10
    //   226: aload 9
    //   228: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   231: ifne +173 -> 404
    //   234: aload 9
    //   236: ldc_w 282
    //   239: invokevirtual 286	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   242: astore 15
    //   244: aload 15
    //   246: ifnull +308 -> 554
    //   249: aload 15
    //   251: arraylength
    //   252: iconst_2
    //   253: if_icmplt +301 -> 554
    //   256: new 107	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   263: astore 8
    //   265: iconst_0
    //   266: istore 5
    //   268: aload 8
    //   270: astore_1
    //   271: iload 5
    //   273: aload 15
    //   275: arraylength
    //   276: if_icmpge +280 -> 556
    //   279: iload 5
    //   281: iconst_1
    //   282: if_icmpeq +76 -> 358
    //   285: aload 8
    //   287: aload 15
    //   289: iload 5
    //   291: aaload
    //   292: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: iload 5
    //   298: aload 15
    //   300: arraylength
    //   301: iconst_1
    //   302: isub
    //   303: if_icmpeq +12 -> 315
    //   306: aload 8
    //   308: ldc_w 288
    //   311: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: iload 5
    //   317: iconst_1
    //   318: iadd
    //   319: istore 5
    //   321: goto -53 -> 268
    //   324: astore_1
    //   325: getstatic 24	com/tencent/open/adapter/OpenAppClient:TAG	Ljava/lang/String;
    //   328: new 107	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 290
    //   338: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload 8
    //   343: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 292	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: iconst_0
    //   353: istore 4
    //   355: goto -134 -> 221
    //   358: aload 8
    //   360: aload 15
    //   362: iload 5
    //   364: aaload
    //   365: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc_w 288
    //   371: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: ldc_w 294
    //   377: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: goto -85 -> 296
    //   384: astore 10
    //   386: aload 8
    //   388: astore_1
    //   389: aload 10
    //   391: astore 8
    //   393: getstatic 24	com/tencent/open/adapter/OpenAppClient:TAG	Ljava/lang/String;
    //   396: ldc_w 296
    //   399: aload 8
    //   401: invokestatic 237	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   404: aload 9
    //   406: astore 8
    //   408: aload_1
    //   409: ifnull +9 -> 418
    //   412: aload_1
    //   413: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: astore 8
    //   418: new 298	com/tencent/open/downloadnew/common/NoticeParam
    //   421: dup
    //   422: invokespecial 299	com/tencent/open/downloadnew/common/NoticeParam:<init>	()V
    //   425: astore_1
    //   426: aload_1
    //   427: aload 11
    //   429: putfield 302	com/tencent/open/downloadnew/common/NoticeParam:appId	Ljava/lang/String;
    //   432: aload_1
    //   433: aload 7
    //   435: putfield 305	com/tencent/open/downloadnew/common/NoticeParam:title	Ljava/lang/String;
    //   438: aload_1
    //   439: aload 12
    //   441: putfield 308	com/tencent/open/downloadnew/common/NoticeParam:packName	Ljava/lang/String;
    //   444: aload_1
    //   445: aload 14
    //   447: putfield 311	com/tencent/open/downloadnew/common/NoticeParam:nKey	Ljava/lang/String;
    //   450: new 313	android/os/Bundle
    //   453: dup
    //   454: invokespecial 314	android/os/Bundle:<init>	()V
    //   457: astore 9
    //   459: aload 9
    //   461: ldc_w 316
    //   464: aload 11
    //   466: invokevirtual 319	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: aload 9
    //   471: ldc 249
    //   473: aload 8
    //   475: invokevirtual 319	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: aload 9
    //   480: ldc_w 321
    //   483: aload 13
    //   485: invokevirtual 319	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: aload 9
    //   490: ldc_w 323
    //   493: aload 12
    //   495: invokevirtual 319	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: aload 9
    //   500: ldc_w 325
    //   503: ldc_w 327
    //   506: invokevirtual 319	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: iload 4
    //   511: iload_2
    //   512: if_icmpgt +47 -> 559
    //   515: ldc_w 329
    //   518: ldc_w 331
    //   521: aload 11
    //   523: invokestatic 337	arxt:br	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   526: aload_1
    //   527: iconst_2
    //   528: putfield 340	com/tencent/open/downloadnew/common/NoticeParam:noticeType	I
    //   531: aload_1
    //   532: aload 13
    //   534: putfield 343	com/tencent/open/downloadnew/common/NoticeParam:cDW	Ljava/lang/String;
    //   537: aload_1
    //   538: aload 9
    //   540: invokestatic 347	asad:b	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   543: putfield 351	com/tencent/open/downloadnew/common/NoticeParam:as	Landroid/content/Intent;
    //   546: invokestatic 356	asab:a	()Lasab;
    //   549: aload_1
    //   550: invokevirtual 359	asab:a	(Lcom/tencent/open/downloadnew/common/NoticeParam;)V
    //   553: return
    //   554: aconst_null
    //   555: astore_1
    //   556: goto -152 -> 404
    //   559: iload 4
    //   561: iload_3
    //   562: if_icmpgt +87 -> 649
    //   565: ldc_w 329
    //   568: ldc_w 361
    //   571: aload 11
    //   573: invokestatic 337	arxt:br	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   576: aload_1
    //   577: iconst_3
    //   578: putfield 340	com/tencent/open/downloadnew/common/NoticeParam:noticeType	I
    //   581: aload_1
    //   582: aload 13
    //   584: putfield 343	com/tencent/open/downloadnew/common/NoticeParam:cDW	Ljava/lang/String;
    //   587: aload_1
    //   588: aload 9
    //   590: invokestatic 347	asad:b	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   593: putfield 351	com/tencent/open/downloadnew/common/NoticeParam:as	Landroid/content/Intent;
    //   596: invokestatic 356	asab:a	()Lasab;
    //   599: aload_1
    //   600: invokevirtual 359	asab:a	(Lcom/tencent/open/downloadnew/common/NoticeParam;)V
    //   603: invokestatic 254	aryy:a	()Laryy;
    //   606: aload 11
    //   608: invokevirtual 257	aryy:qz	(Ljava/lang/String;)Ljava/lang/String;
    //   611: astore_1
    //   612: invokestatic 254	aryy:a	()Laryy;
    //   615: aload 11
    //   617: invokevirtual 364	aryy:qK	(Ljava/lang/String;)Ljava/lang/String;
    //   620: astore 7
    //   622: aload_1
    //   623: invokestatic 367	arxn:lh	(Ljava/lang/String;)Ljava/lang/String;
    //   626: ifnull +13 -> 639
    //   629: aload_0
    //   630: aload_1
    //   631: aload 7
    //   633: invokestatic 370	arxn:v	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   636: ifeq -83 -> 553
    //   639: getstatic 24	com/tencent/open/adapter/OpenAppClient:TAG	Ljava/lang/String;
    //   642: ldc_w 372
    //   645: invokestatic 292	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   648: return
    //   649: invokestatic 254	aryy:a	()Laryy;
    //   652: aload 11
    //   654: invokevirtual 375	aryy:c	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   657: ifnull +14 -> 671
    //   660: ldc_w 329
    //   663: ldc_w 377
    //   666: aload 11
    //   668: invokestatic 337	arxt:br	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   671: aload 9
    //   673: invokestatic 347	asad:b	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   676: astore_0
    //   677: aload 12
    //   679: ifnull +54 -> 733
    //   682: aload 12
    //   684: invokevirtual 380	java/lang/String:trim	()Ljava/lang/String;
    //   687: ldc 54
    //   689: invokevirtual 384	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   692: ifne +41 -> 733
    //   695: iconst_1
    //   696: istore 6
    //   698: new 386	com/tencent/open/downloadnew/DownloadInfo
    //   701: dup
    //   702: aload 11
    //   704: aload 13
    //   706: invokevirtual 380	java/lang/String:trim	()Ljava/lang/String;
    //   709: aload 12
    //   711: aload 7
    //   713: aload 8
    //   715: aload_0
    //   716: ldc_w 388
    //   719: iload 6
    //   721: invokespecial 391	com/tencent/open/downloadnew/DownloadInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;Z)V
    //   724: astore_0
    //   725: invokestatic 254	aryy:a	()Laryy;
    //   728: aload_0
    //   729: invokevirtual 394	aryy:b	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   732: return
    //   733: iconst_0
    //   734: istore 6
    //   736: goto -38 -> 698
    //   739: astore 8
    //   741: aload 10
    //   743: astore_1
    //   744: goto -351 -> 393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	747	0	paramContext	Context
    //   0	747	1	paramHashMap	HashMap<String, String>
    //   26	487	2	i	int
    //   28	535	3	j	int
    //   219	344	4	k	int
    //   266	97	5	m	int
    //   696	39	6	bool	boolean
    //   95	617	7	localObject1	Object
    //   60	654	8	localObject2	Object
    //   739	1	8	localException1	Exception
    //   82	590	9	localObject3	Object
    //   224	1	10	localObject4	Object
    //   384	358	10	localException2	Exception
    //   38	665	11	str1	String
    //   49	661	12	str2	String
    //   71	634	13	str3	String
    //   128	318	14	str4	String
    //   242	119	15	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   211	221	324	java/lang/NumberFormatException
    //   271	279	384	java/lang/Exception
    //   285	296	384	java/lang/Exception
    //   296	315	384	java/lang/Exception
    //   358	381	384	java/lang/Exception
    //   234	244	739	java/lang/Exception
    //   249	265	739	java/lang/Exception
  }
  
  public static void q(Activity paramActivity, Bundle paramBundle)
  {
    for (;;)
    {
      String str2;
      Object localObject;
      try
      {
        boolean bool = dcu;
        if (bool) {
          return;
        }
        dcu = true;
        str2 = paramBundle.getString("schemaurl");
        localObject = paramBundle.getString("uin");
        String str1 = paramBundle.getString("vkey");
        if (localObject != null)
        {
          paramBundle = (Bundle)localObject;
          if (!((String)localObject).equals("0")) {}
        }
        else
        {
          paramBundle = String.valueOf(aroi.a().getUin());
        }
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = aroi.a().getSkey();
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          ThreadManager.executeOnSubThread(new GetVkeyRunnable(paramActivity, 1, str2));
          continue;
        }
        dcu = false;
      }
      finally {}
      arue.j(paramActivity, str2, paramBundle, (String)localObject);
    }
  }
  
  public static void r(Activity paramActivity, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        boolean bool = dcu;
        if (bool) {
          return;
        }
        dcu = true;
        String str = paramBundle.getString("schemaurl");
        paramBundle.getString("uin");
        if (TextUtils.isEmpty(str)) {
          dcu = false;
        } else {
          try
          {
            ThreadManager.executeOnNetWorkThread(new GetVkeyRunnable(paramActivity, 2, new URL(str).getQuery()));
          }
          catch (MalformedURLException paramActivity)
          {
            paramActivity.printStackTrace();
            dcu = false;
          }
        }
      }
      finally {}
    }
  }
  
  public static class GetVkeyRunnable
    implements Runnable
  {
    protected String AG;
    protected Activity K;
    protected AppRuntime mAppRuntime;
    protected int mType;
    
    public GetVkeyRunnable(Activity paramActivity, int paramInt, String paramString)
    {
      this.K = paramActivity;
      if ((this.K instanceof BaseActivity)) {
        this.mAppRuntime = ((BaseActivity)this.K).getAppRuntime();
      }
      this.mType = paramInt;
      this.AG = paramString;
    }
    
    public GetVkeyRunnable(AppRuntime paramAppRuntime, int paramInt, String paramString)
    {
      this.mAppRuntime = paramAppRuntime;
      this.mType = paramInt;
      this.AG = paramString;
    }
    
    public void run()
    {
      if (!arwo.cs(aroi.a().getContext())) {}
      while (this.mAppRuntime == null) {
        return;
      }
      String str2 = ((TicketManager)this.mAppRuntime.getManager(2)).getSkey(this.mAppRuntime.getAccount());
      String str1;
      if ((this.mAppRuntime instanceof QQAppInterface)) {
        str1 = ((QQAppInterface)this.mAppRuntime).getCurrentAccountUin();
      }
      for (;;)
      {
        if ((str1 != null) && (!str1.equals(String.valueOf(aroi.a().getUin())))) {
          aroi.a().setUin(Long.valueOf(str1).longValue());
        }
        if (!TextUtils.isEmpty(str2))
        {
          arwt.i(OpenAppClient.TAG, "Get skey success");
          aroi.a().WH(str2);
        }
        OpenAppClient.dcu = false;
        switch (this.mType)
        {
        default: 
          return;
        case 1: 
          arue.j(this.K, this.AG, str1, str2);
          return;
          if ((this.mAppRuntime instanceof BrowserAppInterface)) {
            str1 = ((BrowserAppInterface)this.mAppRuntime).getAccount();
          }
          break;
        case 2: 
          arue.k(this.K, this.AG, str1, str2);
          return;
          str1 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient
 * JD-Core Version:    0.7.0.1
 */