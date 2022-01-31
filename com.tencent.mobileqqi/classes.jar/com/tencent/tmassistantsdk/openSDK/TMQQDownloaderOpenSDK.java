package com.tencent.tmassistantsdk.openSDK;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.b.c;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.f.j;
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
  
  public static boolean isExistActoin(long paramLong)
  {
    if (paramLong < 0L) {
      return false;
    }
    Object localObject = new com.tencent.tmassistantsdk.b.b().a();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if ((localc.a == paramLong) && (localc.c - localc.b <= 300000L)) {
          return true;
        }
      }
    }
    return false;
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
    return this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, paramString, l, l + 300000L);
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
          int i = com.tencent.tmassistantsdk.f.e.a().n();
          int j = com.tencent.tmassistantsdk.f.e.a().m();
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
    com.tencent.tmassistantsdk.c.b.a().b();
    com.tencent.tmassistantsdk.c.e.a();
    com.tencent.tmassistantsdk.c.e.d();
    com.tencent.tmassistantsdk.c.e.a().b();
    if (this.mContext != null)
    {
      DownloadStateChangedReceiver.a().b(this.mContext);
      DownloadStateChangedReceiver.a().b(this);
    }
    com.tencent.tmassistantsdk.f.e.a().c();
    this.mContext = null;
  }
  
  /* Error */
  public com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo getDownloadTaskState(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 203	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mContext	Landroid/content/Context;
    //   4: ifnonnull +14 -> 18
    //   7: new 205	java/lang/Exception
    //   10: dup
    //   11: ldc_w 273
    //   14: invokespecial 208	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_1
    //   19: ifnonnull +14 -> 33
    //   22: new 205	java/lang/Exception
    //   25: dup
    //   26: ldc_w 275
    //   29: invokespecial 208	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   32: athrow
    //   33: aload_0
    //   34: getfield 203	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mContext	Landroid/content/Context;
    //   37: invokevirtual 279	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   40: astore 10
    //   42: aload 10
    //   44: getstatic 32	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:CONTENT_URI	Landroid/net/Uri;
    //   47: aconst_null
    //   48: ldc_w 281
    //   51: iconst_3
    //   52: anewarray 283	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: getfield 286	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload_1
    //   65: getfield 289	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   68: invokestatic 293	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   71: aastore
    //   72: dup
    //   73: iconst_2
    //   74: aload_1
    //   75: getfield 296	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:channelId	Ljava/lang/String;
    //   78: aastore
    //   79: aconst_null
    //   80: invokevirtual 302	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 10
    //   85: ldc 15
    //   87: new 304	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 306
    //   94: invokespecial 307	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload_1
    //   98: getfield 286	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   101: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 313
    //   107: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_1
    //   111: getfield 289	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   114: invokestatic 293	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   117: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 315
    //   123: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_1
    //   127: getfield 296	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:channelId	Ljava/lang/String;
    //   130: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 321	com/tencent/tmassistantsdk/f/j:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload 10
    //   141: ifnull +572 -> 713
    //   144: aload 10
    //   146: invokeinterface 326 1 0
    //   151: ifeq +562 -> 713
    //   154: ldc 15
    //   156: new 304	java/lang/StringBuilder
    //   159: dup
    //   160: ldc_w 328
    //   163: invokespecial 307	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: aload_1
    //   167: getfield 286	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   170: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 330	com/tencent/tmassistantsdk/f/j:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload 10
    //   181: aload 10
    //   183: ldc_w 332
    //   186: invokeinterface 336 2 0
    //   191: invokeinterface 340 2 0
    //   196: lstore_3
    //   197: aload 10
    //   199: aload 10
    //   201: ldc_w 342
    //   204: invokeinterface 336 2 0
    //   209: invokeinterface 345 2 0
    //   214: invokestatic 348	com/tencent/tmassistantsdk/f/e:d	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   217: iconst_0
    //   218: invokevirtual 352	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   221: checkcast 283	java/lang/String
    //   224: astore 12
    //   226: aload 10
    //   228: aload 10
    //   230: ldc_w 354
    //   233: invokeinterface 336 2 0
    //   238: invokeinterface 345 2 0
    //   243: astore 11
    //   245: aload 10
    //   247: aload 10
    //   249: ldc_w 356
    //   252: invokeinterface 336 2 0
    //   257: invokeinterface 340 2 0
    //   262: lstore 5
    //   264: aload 10
    //   266: aload 10
    //   268: ldc_w 358
    //   271: invokeinterface 336 2 0
    //   276: invokeinterface 340 2 0
    //   281: lstore 7
    //   283: aload 10
    //   285: aload 10
    //   287: ldc_w 360
    //   290: invokeinterface 336 2 0
    //   295: invokeinterface 363 2 0
    //   300: invokestatic 365	com/tencent/tmassistantsdk/f/e:a	(I)I
    //   303: istore_2
    //   304: ldc 15
    //   306: new 304	java/lang/StringBuilder
    //   309: dup
    //   310: ldc_w 367
    //   313: invokespecial 307	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: iload_2
    //   317: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 330	com/tencent/tmassistantsdk/f/j:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: iconst_4
    //   327: iload_2
    //   328: if_icmpne +34 -> 362
    //   331: aload_0
    //   332: aload 11
    //   334: invokespecial 372	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:isFileExist	(Ljava/lang/String;)Z
    //   337: istore 9
    //   339: iload 9
    //   341: ifne +21 -> 362
    //   344: aload 10
    //   346: ifnull +10 -> 356
    //   349: aload 10
    //   351: invokeinterface 375 1 0
    //   356: aconst_null
    //   357: astore 11
    //   359: aload 11
    //   361: areturn
    //   362: new 377	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo
    //   365: dup
    //   366: aload 12
    //   368: aload 11
    //   370: iload_2
    //   371: lload 5
    //   373: lload 7
    //   375: ldc_w 379
    //   378: invokespecial 382	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo:<init>	(Ljava/lang/String;Ljava/lang/String;IJJLjava/lang/String;)V
    //   381: astore 11
    //   383: iload_2
    //   384: iconst_5
    //   385: if_icmpeq +13 -> 398
    //   388: iload_2
    //   389: iconst_4
    //   390: if_icmpeq +8 -> 398
    //   393: iload_2
    //   394: iconst_3
    //   395: if_icmpne +52 -> 447
    //   398: invokestatic 387	com/tencent/tmassistantsdk/c/a:a	()Lcom/tencent/tmassistantsdk/c/a;
    //   401: pop
    //   402: iconst_1
    //   403: invokestatic 390	com/tencent/tmassistantsdk/c/a:a	(B)Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;
    //   406: astore 13
    //   408: aload 13
    //   410: aload_1
    //   411: getfield 393	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:via	Ljava/lang/String;
    //   414: putfield 396	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:via	Ljava/lang/String;
    //   417: aload 13
    //   419: lload_3
    //   420: invokestatic 399	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   423: putfield 402	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:appId	Ljava/lang/String;
    //   426: aload 13
    //   428: iload_2
    //   429: putfield 405	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:resultState	I
    //   432: aload 13
    //   434: aload 12
    //   436: putfield 408	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:requestUrl	Ljava/lang/String;
    //   439: invokestatic 387	com/tencent/tmassistantsdk/c/a:a	()Lcom/tencent/tmassistantsdk/c/a;
    //   442: aload 13
    //   444: invokevirtual 411	com/tencent/tmassistantsdk/c/a:a	(Lcom/qq/taf/jce/JceStruct;)V
    //   447: aload 11
    //   449: astore 12
    //   451: aload_0
    //   452: getfield 40	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mDownloadParams	Ljava/util/Map;
    //   455: ifnull +160 -> 615
    //   458: aload_0
    //   459: getfield 40	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mDownloadParams	Ljava/util/Map;
    //   462: invokeinterface 415 1 0
    //   467: invokeinterface 418 1 0
    //   472: astore 12
    //   474: aload 12
    //   476: invokeinterface 74 1 0
    //   481: ifeq +227 -> 708
    //   484: aload 12
    //   486: invokeinterface 78 1 0
    //   491: checkcast 420	java/util/Map$Entry
    //   494: invokeinterface 423 1 0
    //   499: checkcast 159	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam
    //   502: astore 13
    //   504: aload 13
    //   506: ifnull -32 -> 474
    //   509: aload 13
    //   511: getfield 286	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   514: aload_1
    //   515: getfield 286	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   518: invokevirtual 427	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   521: ifeq -47 -> 474
    //   524: aload 13
    //   526: getfield 289	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   529: aload_1
    //   530: getfield 289	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskVersion	I
    //   533: if_icmpne -59 -> 474
    //   536: iconst_1
    //   537: istore_2
    //   538: aload 11
    //   540: astore 12
    //   542: iload_2
    //   543: ifne +72 -> 615
    //   546: ldc 15
    //   548: new 304	java/lang/StringBuilder
    //   551: dup
    //   552: ldc_w 328
    //   555: invokespecial 307	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   558: aload_1
    //   559: getfield 286	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskPackageName	Ljava/lang/String;
    //   562: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 330	com/tencent/tmassistantsdk/f/j:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: invokestatic 154	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   574: invokevirtual 157	java/util/UUID:toString	()Ljava/lang/String;
    //   577: astore 12
    //   579: aload_1
    //   580: lload_3
    //   581: invokestatic 399	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   584: putfield 430	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam:taskApkId	Ljava/lang/String;
    //   587: aload_0
    //   588: getfield 40	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mDownloadParams	Ljava/util/Map;
    //   591: aload 12
    //   593: aload_1
    //   594: invokeinterface 115 3 0
    //   599: pop
    //   600: aload_0
    //   601: aload_0
    //   602: getfield 203	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:mContext	Landroid/content/Context;
    //   605: aload_1
    //   606: aload 12
    //   608: invokespecial 432	com/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDK:relateToQQDownloader	(Landroid/content/Context;Lcom/tencent/tmassistantsdk/openSDK/TMQQDownloaderOpenSDKParam;Ljava/lang/String;)V
    //   611: aload 11
    //   613: astore 12
    //   615: aload 12
    //   617: astore 11
    //   619: aload 10
    //   621: ifnull -262 -> 359
    //   624: aload 10
    //   626: invokeinterface 375 1 0
    //   631: aload 12
    //   633: areturn
    //   634: astore 11
    //   636: aconst_null
    //   637: astore 10
    //   639: aconst_null
    //   640: astore_1
    //   641: aload 11
    //   643: invokevirtual 433	java/lang/Exception:printStackTrace	()V
    //   646: aload_1
    //   647: astore 11
    //   649: aload 10
    //   651: ifnull -292 -> 359
    //   654: aload 10
    //   656: invokeinterface 375 1 0
    //   661: aload_1
    //   662: areturn
    //   663: astore_1
    //   664: aconst_null
    //   665: astore 10
    //   667: aload 10
    //   669: ifnull +10 -> 679
    //   672: aload 10
    //   674: invokeinterface 375 1 0
    //   679: aload_1
    //   680: athrow
    //   681: astore_1
    //   682: goto -15 -> 667
    //   685: astore_1
    //   686: goto -19 -> 667
    //   689: astore 11
    //   691: aconst_null
    //   692: astore_1
    //   693: goto -52 -> 641
    //   696: astore 12
    //   698: aload 11
    //   700: astore_1
    //   701: aload 12
    //   703: astore 11
    //   705: goto -64 -> 641
    //   708: iconst_0
    //   709: istore_2
    //   710: goto -172 -> 538
    //   713: aconst_null
    //   714: astore 12
    //   716: goto -101 -> 615
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	this	TMQQDownloaderOpenSDK
    //   0	719	1	paramTMQQDownloaderOpenSDKParam	TMQQDownloaderOpenSDKParam
    //   303	407	2	i	int
    //   196	385	3	l1	long
    //   262	110	5	l2	long
    //   281	93	7	l3	long
    //   337	3	9	bool	boolean
    //   40	633	10	localObject1	Object
    //   243	375	11	localObject2	Object
    //   634	8	11	localException1	Exception
    //   647	1	11	localTMQQDownloaderOpenSDKParam	TMQQDownloaderOpenSDKParam
    //   689	10	11	localException2	Exception
    //   703	1	11	localException3	Exception
    //   224	408	12	localObject3	Object
    //   696	6	12	localException4	Exception
    //   714	1	12	localObject4	Object
    //   406	119	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   42	85	634	java/lang/Exception
    //   42	85	663	finally
    //   85	139	681	finally
    //   144	326	681	finally
    //   331	339	681	finally
    //   362	383	681	finally
    //   398	447	681	finally
    //   451	474	681	finally
    //   474	504	681	finally
    //   509	536	681	finally
    //   546	611	681	finally
    //   641	646	685	finally
    //   85	139	689	java/lang/Exception
    //   144	326	689	java/lang/Exception
    //   331	339	689	java/lang/Exception
    //   362	383	689	java/lang/Exception
    //   398	447	696	java/lang/Exception
    //   451	474	696	java/lang/Exception
    //   474	504	696	java/lang/Exception
    //   509	536	696	java/lang/Exception
    //   546	611	696	java/lang/Exception
  }
  
  public void initQQDownloaderOpenSDK(Context paramContext)
  {
    this.mContext = paramContext;
    this.hostPackageName = paramContext.getPackageName();
    this.hostVersionCode = com.tencent.tmassistantsdk.f.e.c(this.mContext);
    com.tencent.tmassistantsdk.f.e.a().a(this.mContext);
    this.sdkAPILevel = 1;
    DownloadStateChangedReceiver.a().a(this.mContext);
    DownloadStateChangedReceiver.a().a(this);
    NetworkMonitorReceiver.a().b();
    com.tencent.tmassistantsdk.c.b.a().c();
    com.tencent.tmassistantsdk.c.e.a();
    com.tencent.tmassistantsdk.c.e.c();
  }
  
  public void onDownloadStateChanged(d paramd)
  {
    TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = paramd.a;
    int i = com.tencent.tmassistantsdk.f.e.a(paramd.c);
    int j = com.tencent.tmassistantsdk.f.e.b(paramd.d);
    Object localObject2 = paramd.e;
    Object localObject3 = paramd.b;
    j.b("QQDownloaderOpenSDK", "onDownloadStateChanged state = " + i);
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
            j.b("QQDownloaderOpenSDK", "onDownloadStateChanged storeParam = null");
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
    j.b("QQDownloaderOpenSDK", "startToWebView finalPath:" + paramString);
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if ((paramContext instanceof Application)) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK
 * JD-Core Version:    0.7.0.1
 */