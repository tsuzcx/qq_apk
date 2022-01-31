package com.tencent.tmassistantsdk.openSDK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.f.k;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class TMQQDownloaderOpenSDK
  extends BaseQQDownloaderOpenSDK
  implements b
{
  public static final String AUTHORITY = "com.tencent.android.qqdownloader.provider";
  public static final Uri CONTENT_URI = com.tencent.tmassistantsdk.openSDK.QQDownloader.a.a;
  protected static final String TAG = "QQDownloaderOpenSDK";
  protected static TMQQDownloaderOpenSDK mInstance = null;
  Map mDownloadParams = null;
  protected int sdkAPILevel = 1;
  
  public static String about()
  {
    return "TMQQDownloaderOpenSDK_2014_05_13_17_36_release_35169";
  }
  
  public static TMQQDownloaderOpenSDK getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMQQDownloaderOpenSDK();
      }
      TMQQDownloaderOpenSDK localTMQQDownloaderOpenSDK = mInstance;
      return localTMQQDownloaderOpenSDK;
    }
    finally {}
  }
  
  private boolean isFileExist(String paramString)
  {
    return new File(paramString).exists();
  }
  
  private void relateToQQDownloader(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    paramTMQQDownloaderOpenSDKParam = super.formatMapParams(paramTMQQDownloaderOpenSDKParam, false, false);
    paramTMQQDownloaderOpenSDKParam.put("taskid", paramString);
    paramTMQQDownloaderOpenSDKParam = super.formatIntentUriPath(4, paramTMQQDownloaderOpenSDKParam);
    paramString = new Intent("com.tencent.android.qqdownloader.action.RELATED");
    paramString.setPackage("com.tencent.android.qqdownloader");
    paramString.putExtra("command", "cmd_updatedownload");
    paramString.putExtra("relatedurl", paramTMQQDownloaderOpenSDKParam);
    paramContext.sendBroadcast(paramString);
  }
  
  public long addDownloadTaskFromAppDetail(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mDownloadParams != null) && (paramTMQQDownloaderOpenSDKParam != null))
    {
      String str = UUID.randomUUID().toString();
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    return super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, paramTMQQDownloaderOpenSDKParam.actionFlag, null, 2);
  }
  
  public long addDownloadTaskFromAuthorize(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    if ((this.mDownloadParams != null) && (paramTMQQDownloaderOpenSDKParam != null))
    {
      String str = UUID.randomUUID().toString();
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    return super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, true, true, paramTMQQDownloaderOpenSDKParam.actionFlag, paramString, 3);
  }
  
  public long addDownloadTaskFromAuthorize(String paramString)
  {
    paramString = super.formatEncryptUrl(paramString);
    long l = System.currentTimeMillis();
    return this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, paramString, l, l + 300000L, 0, null);
  }
  
  public long addDownloadTaskFromTaskList(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mDownloadParams != null) && (paramTMQQDownloaderOpenSDKParam != null))
    {
      String str = UUID.randomUUID().toString();
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    return super.buildAddDBData(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, paramTMQQDownloaderOpenSDKParam.actionFlag, null, 1);
  }
  
  public int checkQQDownloaderInstalled(int paramInt)
  {
    if (this.mContext == null) {
      throw new Exception("you must initial openSDK,by calling initQQDownloaderOpenSDK method!");
    }
    PackageManager localPackageManager = this.mContext.getPackageManager();
    if (localPackageManager != null) {
      try
      {
        if (localPackageManager.getPackageInfo("com.tencent.android.qqdownloader", 0) != null)
        {
          int i = f.a().n();
          int j = f.a().m();
          int k = this.sdkAPILevel;
          if (k > j) {}
          while (paramInt > i) {
            return 2;
          }
          return 0;
        }
        return 1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    return 1;
  }
  
  public void destroyQQDownloaderOpenSDK()
  {
    NetworkMonitorReceiver.a().c();
    com.tencent.tmassistantsdk.c.d.a();
    com.tencent.tmassistantsdk.c.d.d();
    com.tencent.tmassistantsdk.c.d.a().b();
    if (this.mContext != null)
    {
      DownloadStateChangedReceiver.a().b(this.mContext);
      DownloadStateChangedReceiver.a().b(this);
    }
    f.a().c();
    this.mContext = null;
  }
  
  /* Error */
  public com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 167	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mContext	Landroid/content/Context;
    //   4: ifnonnull +13 -> 17
    //   7: new 169	java/lang/Exception
    //   10: dup
    //   11: ldc 234
    //   13: invokespecial 172	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_1
    //   18: ifnonnull +13 -> 31
    //   21: new 169	java/lang/Exception
    //   24: dup
    //   25: ldc 236
    //   27: invokespecial 172	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   30: athrow
    //   31: aload_0
    //   32: getfield 167	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mContext	Landroid/content/Context;
    //   35: invokevirtual 240	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: astore 10
    //   40: aload 10
    //   42: getstatic 32	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:CONTENT_URI	Landroid/net/Uri;
    //   45: aconst_null
    //   46: ldc 242
    //   48: iconst_3
    //   49: anewarray 244	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: getfield 247	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: aload_1
    //   62: getfield 250	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   65: invokestatic 254	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: aload_1
    //   72: getfield 257	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:channelId	Ljava/lang/String;
    //   75: aastore
    //   76: aconst_null
    //   77: invokevirtual 263	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore 10
    //   82: ldc 15
    //   84: new 265	java/lang/StringBuilder
    //   87: dup
    //   88: ldc_w 267
    //   91: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_1
    //   95: getfield 247	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   98: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 274
    //   104: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: getfield 250	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   111: invokestatic 254	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   114: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc_w 276
    //   120: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: getfield 257	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:channelId	Ljava/lang/String;
    //   127: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 282	com/tencent/tmassistantsdk/f/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 10
    //   138: ifnull +572 -> 710
    //   141: aload 10
    //   143: invokeinterface 287 1 0
    //   148: ifeq +562 -> 710
    //   151: ldc 15
    //   153: new 265	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 289
    //   160: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: aload_1
    //   164: getfield 247	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   167: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 291	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload 10
    //   178: aload 10
    //   180: ldc_w 293
    //   183: invokeinterface 297 2 0
    //   188: invokeinterface 301 2 0
    //   193: lstore_3
    //   194: aload 10
    //   196: aload 10
    //   198: ldc_w 303
    //   201: invokeinterface 297 2 0
    //   206: invokeinterface 306 2 0
    //   211: invokestatic 309	com/tencent/tmassistantsdk/f/f:d	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   214: iconst_0
    //   215: invokevirtual 315	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   218: checkcast 244	java/lang/String
    //   221: astore 12
    //   223: aload 10
    //   225: aload 10
    //   227: ldc_w 317
    //   230: invokeinterface 297 2 0
    //   235: invokeinterface 306 2 0
    //   240: astore 11
    //   242: aload 10
    //   244: aload 10
    //   246: ldc_w 319
    //   249: invokeinterface 297 2 0
    //   254: invokeinterface 301 2 0
    //   259: lstore 5
    //   261: aload 10
    //   263: aload 10
    //   265: ldc_w 321
    //   268: invokeinterface 297 2 0
    //   273: invokeinterface 301 2 0
    //   278: lstore 7
    //   280: aload 10
    //   282: aload 10
    //   284: ldc_w 323
    //   287: invokeinterface 297 2 0
    //   292: invokeinterface 326 2 0
    //   297: invokestatic 328	com/tencent/tmassistantsdk/f/f:a	(I)I
    //   300: istore_2
    //   301: ldc 15
    //   303: new 265	java/lang/StringBuilder
    //   306: dup
    //   307: ldc_w 330
    //   310: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   313: iload_2
    //   314: invokevirtual 333	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 291	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: iconst_4
    //   324: iload_2
    //   325: if_icmpne +34 -> 359
    //   328: aload_0
    //   329: aload 11
    //   331: invokespecial 335	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:isFileExist	(Ljava/lang/String;)Z
    //   334: istore 9
    //   336: iload 9
    //   338: ifne +21 -> 359
    //   341: aload 10
    //   343: ifnull +10 -> 353
    //   346: aload 10
    //   348: invokeinterface 338 1 0
    //   353: aconst_null
    //   354: astore 11
    //   356: aload 11
    //   358: areturn
    //   359: new 340	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo
    //   362: dup
    //   363: aload 12
    //   365: aload 11
    //   367: iload_2
    //   368: lload 5
    //   370: lload 7
    //   372: ldc_w 342
    //   375: invokespecial 345	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo:<init>	(Ljava/lang/String;Ljava/lang/String;IJJLjava/lang/String;)V
    //   378: astore 11
    //   380: iload_2
    //   381: iconst_5
    //   382: if_icmpeq +13 -> 395
    //   385: iload_2
    //   386: iconst_4
    //   387: if_icmpeq +8 -> 395
    //   390: iload_2
    //   391: iconst_3
    //   392: if_icmpne +52 -> 444
    //   395: invokestatic 350	com/tencent/tmassistantsdk/c/a:a	()Lcom/tencent/tmassistantsdk/c/a;
    //   398: pop
    //   399: iconst_1
    //   400: invokestatic 353	com/tencent/tmassistantsdk/c/a:a	(B)Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;
    //   403: astore 13
    //   405: aload 13
    //   407: aload_1
    //   408: getfield 356	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:via	Ljava/lang/String;
    //   411: putfield 359	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:via	Ljava/lang/String;
    //   414: aload 13
    //   416: lload_3
    //   417: invokestatic 362	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   420: putfield 365	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:appId	Ljava/lang/String;
    //   423: aload 13
    //   425: iload_2
    //   426: putfield 368	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:resultState	I
    //   429: aload 13
    //   431: aload 12
    //   433: putfield 371	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:requestUrl	Ljava/lang/String;
    //   436: invokestatic 350	com/tencent/tmassistantsdk/c/a:a	()Lcom/tencent/tmassistantsdk/c/a;
    //   439: aload 13
    //   441: invokevirtual 374	com/tencent/tmassistantsdk/c/a:a	(Lcom/qq/taf/jce/JceStruct;)V
    //   444: aload 11
    //   446: astore 12
    //   448: aload_0
    //   449: getfield 40	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mDownloadParams	Ljava/util/Map;
    //   452: ifnull +160 -> 612
    //   455: aload_0
    //   456: getfield 40	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mDownloadParams	Ljava/util/Map;
    //   459: invokeinterface 378 1 0
    //   464: invokeinterface 384 1 0
    //   469: astore 12
    //   471: aload 12
    //   473: invokeinterface 389 1 0
    //   478: ifeq +227 -> 705
    //   481: aload 12
    //   483: invokeinterface 393 1 0
    //   488: checkcast 395	java/util/Map$Entry
    //   491: invokeinterface 398 1 0
    //   496: checkcast 119	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam
    //   499: astore 13
    //   501: aload 13
    //   503: ifnull -32 -> 471
    //   506: aload 13
    //   508: getfield 247	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   511: aload_1
    //   512: getfield 247	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   515: invokevirtual 402	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   518: ifeq -47 -> 471
    //   521: aload 13
    //   523: getfield 250	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   526: aload_1
    //   527: getfield 250	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   530: if_icmpne -59 -> 471
    //   533: iconst_1
    //   534: istore_2
    //   535: aload 11
    //   537: astore 12
    //   539: iload_2
    //   540: ifne +72 -> 612
    //   543: ldc 15
    //   545: new 265	java/lang/StringBuilder
    //   548: dup
    //   549: ldc_w 289
    //   552: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   555: aload_1
    //   556: getfield 247	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   559: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 291	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: invokestatic 114	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   571: invokevirtual 117	java/util/UUID:toString	()Ljava/lang/String;
    //   574: astore 12
    //   576: aload_1
    //   577: lload_3
    //   578: invokestatic 362	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   581: putfield 405	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskApkId	Ljava/lang/String;
    //   584: aload_0
    //   585: getfield 40	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mDownloadParams	Ljava/util/Map;
    //   588: aload 12
    //   590: aload_1
    //   591: invokeinterface 75 3 0
    //   596: pop
    //   597: aload_0
    //   598: aload_0
    //   599: getfield 167	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mContext	Landroid/content/Context;
    //   602: aload_1
    //   603: aload 12
    //   605: invokespecial 407	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:relateToQQDownloader	(Landroid/content/Context;Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;Ljava/lang/String;)V
    //   608: aload 11
    //   610: astore 12
    //   612: aload 12
    //   614: astore 11
    //   616: aload 10
    //   618: ifnull -262 -> 356
    //   621: aload 10
    //   623: invokeinterface 338 1 0
    //   628: aload 12
    //   630: areturn
    //   631: astore 11
    //   633: aconst_null
    //   634: astore 10
    //   636: aconst_null
    //   637: astore_1
    //   638: aload 11
    //   640: invokevirtual 408	java/lang/Exception:printStackTrace	()V
    //   643: aload_1
    //   644: astore 11
    //   646: aload 10
    //   648: ifnull -292 -> 356
    //   651: aload 10
    //   653: invokeinterface 338 1 0
    //   658: aload_1
    //   659: areturn
    //   660: astore_1
    //   661: aconst_null
    //   662: astore 10
    //   664: aload 10
    //   666: ifnull +10 -> 676
    //   669: aload 10
    //   671: invokeinterface 338 1 0
    //   676: aload_1
    //   677: athrow
    //   678: astore_1
    //   679: goto -15 -> 664
    //   682: astore_1
    //   683: goto -19 -> 664
    //   686: astore 11
    //   688: aconst_null
    //   689: astore_1
    //   690: goto -52 -> 638
    //   693: astore 12
    //   695: aload 11
    //   697: astore_1
    //   698: aload 12
    //   700: astore 11
    //   702: goto -64 -> 638
    //   705: iconst_0
    //   706: istore_2
    //   707: goto -172 -> 535
    //   710: aconst_null
    //   711: astore 12
    //   713: goto -101 -> 612
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	716	0	this	TMQQDownloaderOpenSDK
    //   0	716	1	paramTMQQDownloaderOpenSDKParam	TMQQDownloaderOpenSDKParam
    //   300	407	2	i	int
    //   193	385	3	l1	long
    //   259	110	5	l2	long
    //   278	93	7	l3	long
    //   334	3	9	bool	boolean
    //   38	632	10	localObject1	Object
    //   240	375	11	localObject2	Object
    //   631	8	11	localException1	Exception
    //   644	1	11	localTMQQDownloaderOpenSDKParam	TMQQDownloaderOpenSDKParam
    //   686	10	11	localException2	Exception
    //   700	1	11	localException3	Exception
    //   221	408	12	localObject3	Object
    //   693	6	12	localException4	Exception
    //   711	1	12	localObject4	Object
    //   403	119	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   40	82	631	java/lang/Exception
    //   40	82	660	finally
    //   82	136	678	finally
    //   141	323	678	finally
    //   328	336	678	finally
    //   359	380	678	finally
    //   395	444	678	finally
    //   448	471	678	finally
    //   471	501	678	finally
    //   506	533	678	finally
    //   543	608	678	finally
    //   638	643	682	finally
    //   82	136	686	java/lang/Exception
    //   141	323	686	java/lang/Exception
    //   328	336	686	java/lang/Exception
    //   359	380	686	java/lang/Exception
    //   395	444	693	java/lang/Exception
    //   448	471	693	java/lang/Exception
    //   471	501	693	java/lang/Exception
    //   506	533	693	java/lang/Exception
    //   543	608	693	java/lang/Exception
  }
  
  public void initQQDownloaderOpenSDK(Context paramContext)
  {
    this.mContext = paramContext;
    this.hostPackageName = paramContext.getPackageName();
    this.hostVersionCode = f.c(this.mContext);
    f.a().a(this.mContext);
    this.sdkAPILevel = 1;
    DownloadStateChangedReceiver.a().a(this.mContext);
    DownloadStateChangedReceiver.a().a(this);
    NetworkMonitorReceiver.a().b();
  }
  
  public void onDownloadStateChanged(d paramd)
  {
    TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = paramd.a;
    int i = f.a(paramd.c);
    int j = f.b(paramd.d);
    Object localObject2 = paramd.e;
    Object localObject3 = paramd.b;
    k.b("QQDownloaderOpenSDK", "onDownloadStateChanged state = " + i);
    Object localObject1 = null;
    paramd = (d)localObject1;
    if (localObject3 != null)
    {
      paramd = (d)localObject1;
      if (((String)localObject3).trim().length() > 0) {
        paramd = (TMQQDownloaderOpenSDKParam)this.mDownloadParams.get(localObject3);
      }
    }
    if (paramd != null) {
      onStateChanged(paramd, i, j, (String)localObject2);
    }
    while (6 == i)
    {
      paramd = new ArrayList();
      localObject1 = this.mDownloadParams.entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (TMQQDownloaderOpenSDKParam)((Map.Entry)localObject3).getValue();
          localObject3 = (String)((Map.Entry)localObject3).getKey();
          if ((localObject2 != null) && (!TextUtils.isEmpty(localTMQQDownloaderOpenSDKParam.taskPackageName)) && (((TMQQDownloaderOpenSDKParam)localObject2).taskPackageName.equals(localTMQQDownloaderOpenSDKParam.taskPackageName)) && (((TMQQDownloaderOpenSDKParam)localObject2).taskVersion == localTMQQDownloaderOpenSDKParam.taskVersion))
          {
            paramd.add(localObject3);
            continue;
            k.b("QQDownloaderOpenSDK", "onDownloadStateChanged storeParam = null");
            break;
          }
        }
      }
      paramd = paramd.iterator();
      while (paramd.hasNext())
      {
        localObject1 = (String)paramd.next();
        this.mDownloadParams.remove(localObject1);
      }
    }
  }
  
  public void startQQDownloader(Context paramContext)
  {
    if (paramContext != null)
    {
      Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage("com.tencent.android.qqdownloader");
      if ((paramContext instanceof Application)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
    }
  }
  
  public void startToAppDetail(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    String str = UUID.randomUUID().toString();
    if (this.mDownloadParams != null) {
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    if (paramBoolean1)
    {
      com.tencent.tmassistantsdk.c.a.a();
      DownloadChunkLogInfo localDownloadChunkLogInfo = com.tencent.tmassistantsdk.c.a.a((byte)1);
      localDownloadChunkLogInfo.via = paramTMQQDownloaderOpenSDKParam.via;
      localDownloadChunkLogInfo.UUID = str;
      localDownloadChunkLogInfo.appId = paramTMQQDownloaderOpenSDKParam.taskAppId;
      localDownloadChunkLogInfo.resultState = 1;
      com.tencent.tmassistantsdk.c.a.a().a(localDownloadChunkLogInfo);
    }
    paramTMQQDownloaderOpenSDKParam = super.formatMapParams(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2);
    paramTMQQDownloaderOpenSDKParam.put("taskid", str);
    paramTMQQDownloaderOpenSDKParam = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(2, paramTMQQDownloaderOpenSDKParam)));
    if ((paramContext instanceof Application)) {
      paramTMQQDownloaderOpenSDKParam.addFlags(268435456);
    }
    paramContext.startActivity(paramTMQQDownloaderOpenSDKParam);
  }
  
  public void startToAuthorized(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, String paramString)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMQQDownloaderOpenSDKParam == null) {
      throw new Exception("QQDownloaderParam param cann't be null!");
    }
    String str = UUID.randomUUID().toString();
    if (this.mDownloadParams != null) {
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    com.tencent.tmassistantsdk.c.a.a();
    DownloadChunkLogInfo localDownloadChunkLogInfo = com.tencent.tmassistantsdk.c.a.a((byte)1);
    localDownloadChunkLogInfo.via = paramTMQQDownloaderOpenSDKParam.via;
    localDownloadChunkLogInfo.UUID = str;
    localDownloadChunkLogInfo.appId = paramTMQQDownloaderOpenSDKParam.taskAppId;
    localDownloadChunkLogInfo.resultState = 1;
    com.tencent.tmassistantsdk.c.a.a().a(localDownloadChunkLogInfo);
    paramTMQQDownloaderOpenSDKParam = super.formatMapParams(paramTMQQDownloaderOpenSDKParam, true, true);
    paramTMQQDownloaderOpenSDKParam.put("verifytype", paramString);
    paramTMQQDownloaderOpenSDKParam.put("taskid", str);
    paramTMQQDownloaderOpenSDKParam = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(3, paramTMQQDownloaderOpenSDKParam)));
    if ((paramContext instanceof Application)) {
      paramTMQQDownloaderOpenSDKParam.addFlags(268435456);
    }
    paramContext.startActivity(paramTMQQDownloaderOpenSDKParam);
  }
  
  public void startToAuthorized(Context paramContext, String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(formatEncryptUrl(paramString)));
    if ((paramContext instanceof Application)) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
  }
  
  public void startToDownloadTaskList(Context paramContext, TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMQQDownloaderOpenSDKParam == null) {
      return;
    }
    String str = UUID.randomUUID().toString();
    if (this.mDownloadParams != null) {
      this.mDownloadParams.put(str, paramTMQQDownloaderOpenSDKParam);
    }
    if (paramBoolean1)
    {
      com.tencent.tmassistantsdk.c.a.a();
      DownloadChunkLogInfo localDownloadChunkLogInfo = com.tencent.tmassistantsdk.c.a.a((byte)1);
      localDownloadChunkLogInfo.UUID = str;
      localDownloadChunkLogInfo.requestUrl = "";
      localDownloadChunkLogInfo.via = paramTMQQDownloaderOpenSDKParam.via;
      localDownloadChunkLogInfo.appId = paramTMQQDownloaderOpenSDKParam.taskAppId;
      com.tencent.tmassistantsdk.c.a.a().a(localDownloadChunkLogInfo);
    }
    paramTMQQDownloaderOpenSDKParam = super.formatMapParams(paramTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2);
    paramTMQQDownloaderOpenSDKParam.put("taskid", str);
    paramTMQQDownloaderOpenSDKParam = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(1, paramTMQQDownloaderOpenSDKParam)));
    if ((paramContext instanceof Application)) {
      paramTMQQDownloaderOpenSDKParam.addFlags(268435456);
    }
    paramContext.startActivity(paramTMQQDownloaderOpenSDKParam);
  }
  
  public void startToWebView(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new Exception("you must input an application or activity context!");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new Exception("param url shouldn't be null!");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString);
    paramString = super.formatIntentUriPath(5, localHashMap);
    k.b("QQDownloaderOpenSDK", "startToWebView finalPath:" + paramString);
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if ((paramContext instanceof Application)) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK
 * JD-Core Version:    0.7.0.1
 */