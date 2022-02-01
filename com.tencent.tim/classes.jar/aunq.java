import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class aunq
{
  private static volatile aunq a;
  public static volatile int cdv;
  private static final Object mLock = new Object();
  protected BusinessInfoCheckUpdate.TimeRspBody a;
  public boolean brs;
  public HashMap<String, aunr> hq = new HashMap();
  Object lock = new Object();
  protected List<aunr> ux = new ArrayList();
  
  private aunq()
  {
    cdv = 0;
  }
  
  public static aunq a()
  {
    if (jdField_a_of_type_Aunq == null) {}
    synchronized (mLock)
    {
      if (jdField_a_of_type_Aunq == null) {
        jdField_a_of_type_Aunq = new aunq();
      }
      return jdField_a_of_type_Aunq;
    }
  }
  
  public static boolean dp(long paramLong)
  {
    return (paramLong == 3042L) || (paramLong == 1058L);
  }
  
  public static boolean dq(long paramLong)
  {
    return (paramLong == 1061L) || (paramLong == 3043L);
  }
  
  public static Bitmap e(File paramFile)
  {
    Bitmap localBitmap = null;
    Object localObject = localBitmap;
    if (paramFile != null)
    {
      localObject = localBitmap;
      if (BaseApplicationImpl.sImageCache != null)
      {
        String str = "LebaIcon://" + paramFile.getAbsolutePath();
        localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
        localObject = localBitmap;
        if (localBitmap == null)
        {
          localObject = localBitmap;
          if (paramFile.exists())
          {
            paramFile = auns.d(paramFile);
            localObject = paramFile;
            if (paramFile != null)
            {
              BaseApplicationImpl.sImageCache.put(str, paramFile);
              localObject = paramFile;
            }
          }
        }
      }
    }
    return localObject;
  }
  
  private void e(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    synchronized (this.lock)
    {
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody = paramTimeRspBody;
      return;
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean, long paramLong)
  {
    synchronized (this.lock)
    {
      BusinessInfoCheckUpdate.AppSetting localAppSetting = new BusinessInfoCheckUpdate.AppSetting();
      localAppSetting.appid.set(paramInt);
      localAppSetting.setting.set(paramBoolean);
      localAppSetting.modify_ts.set(paramLong);
      paramLong = -1L;
      try
      {
        l = Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue();
        paramLong = l;
        if (QLog.isColorLevel())
        {
          paramLong = l;
          QLog.d("TimLebaShowListManager", 2, "updateSettingById:" + l);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody;
          Object localObject2;
          int j;
          int i;
          long l = paramLong;
          continue;
          i += 1;
        }
      }
      localTimeRspBody = a(paramQQAppInterface);
      if ((localTimeRspBody != null) && ((localTimeRspBody.has()) || (localTimeRspBody.rptSetting.has())))
      {
        localObject2 = localTimeRspBody.rptSetting.get();
        j = ((List)localObject2).size();
        i = 0;
        if (i < j)
        {
          if (paramInt != ((BusinessInfoCheckUpdate.AppSetting)((BusinessInfoCheckUpdate.AppSetting)((List)localObject2).get(i)).get()).appid.get()) {
            break label356;
          }
          ((List)localObject2).set(i, localAppSetting);
        }
        if (i == j) {
          ((List)localObject2).add(localAppSetting);
        }
        localTimeRspBody.uiUin.set(l);
        if (!a(paramQQAppInterface, localTimeRspBody))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TimLebaShowListManager", 2, "updateSettingById exception!");
          }
          return -4;
        }
      }
      else
      {
        localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localAppSetting);
        localTimeRspBody.rptSetting.set((List)localObject2);
        localTimeRspBody.uiUin.set(l);
        if (!a(paramQQAppInterface, localTimeRspBody))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TimLebaShowListManager", 2, "updateSettingById new exception!");
          }
          return -4;
        }
      }
    }
    return 0;
  }
  
  public aunr a(long paramLong)
  {
    Iterator localIterator = dp().iterator();
    while (localIterator.hasNext())
    {
      aunr localaunr = (aunr)localIterator.next();
      if (localaunr.c.uiResId == paramLong) {
        return localaunr;
      }
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.lock)
    {
      if ((this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody != null) && (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody.uiUin.has()) && (String.valueOf(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody.uiUin.get()).equals(paramQQAppInterface.getCurrentAccountUin())))
      {
        paramQQAppInterface = this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody;
        return paramQQAppInterface;
      }
      paramQQAppInterface = new File(paramQQAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_switch_" + paramQQAppInterface.getCurrentAccountUin());
      if (!paramQQAppInterface.exists()) {
        if (QLog.isColorLevel()) {
          QLog.d("TimLebaShowListManager", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
        }
      }
    }
    try
    {
      paramQQAppInterface.createNewFile();
      try
      {
        paramQQAppInterface = aqhq.fileToBytes(paramQQAppInterface);
        if (paramQQAppInterface != null) {
          break label174;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TimLebaShowListManager", 2, "Can not translate BusinessInfoCheckUpdateItem pb file to byte");
        }
        return null;
      }
      finally {}
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    label174:
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
    try
    {
      localTimeRspBody.mergeFrom(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody = localTimeRspBody;
      return localTimeRspBody;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public List<aunr> a(android.content.Context paramContext, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 310	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +59 -> 62
    //   6: ldc_w 312
    //   9: iconst_4
    //   10: new 67	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 314
    //   20: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 316	aunq:brs	Z
    //   27: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: ldc_w 321
    //   33: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: ldc_w 321
    //   43: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_2
    //   47: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   50: ldc_w 326
    //   53: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 329	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: new 37	java/util/ArrayList
    //   65: dup
    //   66: invokespecial 38	java/util/ArrayList:<init>	()V
    //   69: astore 4
    //   71: new 37	java/util/ArrayList
    //   74: dup
    //   75: invokespecial 38	java/util/ArrayList:<init>	()V
    //   78: astore 5
    //   80: aload_2
    //   81: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:ee	()Ljava/util/List;
    //   84: astore 6
    //   86: aload 6
    //   88: ifnull +617 -> 705
    //   91: new 37	java/util/ArrayList
    //   94: dup
    //   95: aload 6
    //   97: invokespecial 335	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   100: astore 7
    //   102: new 37	java/util/ArrayList
    //   105: dup
    //   106: invokespecial 38	java/util/ArrayList:<init>	()V
    //   109: astore 6
    //   111: aload 7
    //   113: invokeinterface 234 1 0
    //   118: astore 7
    //   120: aload 7
    //   122: invokeinterface 239 1 0
    //   127: ifeq +545 -> 672
    //   130: aload 7
    //   132: invokeinterface 243 1 0
    //   137: checkcast 251	com/tencent/mobileqq/data/ResourcePluginInfo
    //   140: astore 9
    //   142: aload 9
    //   144: ifnull -24 -> 120
    //   147: aload 9
    //   149: getfield 339	com/tencent/mobileqq/data/ResourcePluginInfo:cLocalState	B
    //   152: ifeq -32 -> 120
    //   155: new 245	aunr
    //   158: dup
    //   159: invokespecial 340	aunr:<init>	()V
    //   162: astore 8
    //   164: aload 9
    //   166: getfield 343	com/tencent/mobileqq/data/ResourcePluginInfo:cDataType	B
    //   169: iconst_1
    //   170: if_icmpeq +395 -> 565
    //   173: aload_1
    //   174: aload 9
    //   176: getfield 347	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   179: aload 9
    //   181: getfield 350	com/tencent/mobileqq/data/ResourcePluginInfo:strResURL	Ljava/lang/String;
    //   184: invokestatic 354	auns:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   187: astore 10
    //   189: aload 10
    //   191: invokestatic 356	aunq:e	(Ljava/io/File;)Landroid/graphics/Bitmap;
    //   194: astore 11
    //   196: aload 11
    //   198: ifnull +321 -> 519
    //   201: aload 8
    //   203: new 358	android/graphics/drawable/BitmapDrawable
    //   206: dup
    //   207: aload 11
    //   209: invokespecial 361	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   212: putfield 365	aunr:icon	Landroid/graphics/drawable/Drawable;
    //   215: aload 10
    //   217: invokevirtual 95	java/io/File:exists	()Z
    //   220: ifeq +8 -> 228
    //   223: aload 11
    //   225: ifnonnull +109 -> 334
    //   228: aload 10
    //   230: invokevirtual 95	java/io/File:exists	()Z
    //   233: ifeq +30 -> 263
    //   236: aload 11
    //   238: ifnonnull +25 -> 263
    //   241: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +13 -> 257
    //   247: ldc_w 367
    //   250: iconst_2
    //   251: ldc_w 369
    //   254: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload 10
    //   259: invokevirtual 372	java/io/File:delete	()Z
    //   262: pop
    //   263: new 30	java/util/HashMap
    //   266: dup
    //   267: invokespecial 31	java/util/HashMap:<init>	()V
    //   270: astore 11
    //   272: aload 11
    //   274: ldc_w 374
    //   277: aload 9
    //   279: getfield 347	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   282: invokeinterface 377 3 0
    //   287: pop
    //   288: aload 11
    //   290: ldc_w 379
    //   293: new 381	java/net/URL
    //   296: dup
    //   297: aload 9
    //   299: getfield 350	com/tencent/mobileqq/data/ResourcePluginInfo:strResURL	Ljava/lang/String;
    //   302: invokespecial 384	java/net/URL:<init>	(Ljava/lang/String;)V
    //   305: invokeinterface 377 3 0
    //   310: pop
    //   311: aload 11
    //   313: ldc_w 386
    //   316: aload 10
    //   318: invokeinterface 377 3 0
    //   323: pop
    //   324: aload 5
    //   326: aload 11
    //   328: invokeinterface 212 2 0
    //   333: pop
    //   334: aload 8
    //   336: aload 9
    //   338: putfield 249	aunr:c	Lcom/tencent/mobileqq/data/ResourcePluginInfo;
    //   341: aload 9
    //   343: getfield 343	com/tencent/mobileqq/data/ResourcePluginInfo:cDataType	B
    //   346: iconst_1
    //   347: if_icmpeq +115 -> 462
    //   350: aload_2
    //   351: aload_1
    //   352: aload 9
    //   354: getfield 389	com/tencent/mobileqq/data/ResourcePluginInfo:strGotoUrl	Ljava/lang/String;
    //   357: invokestatic 394	aqik:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Laqhv;
    //   360: astore 10
    //   362: aload 10
    //   364: ifnull +98 -> 462
    //   367: ldc_w 396
    //   370: aload 10
    //   372: invokevirtual 401	aqhv:getServerName	()Ljava/lang/String;
    //   375: invokevirtual 268	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   378: ifeq +84 -> 462
    //   381: aload 10
    //   383: ldc_w 403
    //   386: invokevirtual 407	aqhv:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   389: astore 9
    //   391: aload 10
    //   393: ldc_w 409
    //   396: invokevirtual 407	aqhv:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   399: astore 11
    //   401: aload 9
    //   403: ifnull +20 -> 423
    //   406: aload 9
    //   408: ldc_w 411
    //   411: invokevirtual 415	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   414: ifne +9 -> 423
    //   417: invokestatic 420	awit:aMA	()Z
    //   420: ifeq -300 -> 120
    //   423: aload 9
    //   425: ifnull +37 -> 462
    //   428: aload 11
    //   430: ifnull +32 -> 462
    //   433: aload_1
    //   434: invokevirtual 426	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   437: astore 10
    //   439: new 428	android/content/ComponentName
    //   442: dup
    //   443: aload 11
    //   445: aload 9
    //   447: invokespecial 431	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: astore 9
    //   452: aload 10
    //   454: aload 9
    //   456: bipush 32
    //   458: invokevirtual 437	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   461: pop
    //   462: aload 8
    //   464: invokestatic 440	auns:a	(Launr;)Z
    //   467: ifeq +148 -> 615
    //   470: aload_0
    //   471: getfield 33	aunq:hq	Ljava/util/HashMap;
    //   474: aload 8
    //   476: getfield 249	aunr:c	Lcom/tencent/mobileqq/data/ResourcePluginInfo;
    //   479: getfield 347	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   482: aload 8
    //   484: invokevirtual 441	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   487: pop
    //   488: goto -368 -> 120
    //   491: astore 8
    //   493: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq -376 -> 120
    //   499: aload 8
    //   501: ifnull -381 -> 120
    //   504: ldc_w 312
    //   507: iconst_2
    //   508: aload 8
    //   510: invokevirtual 442	java/lang/Exception:toString	()Ljava/lang/String;
    //   513: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: goto -396 -> 120
    //   519: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +34 -> 556
    //   525: ldc_w 367
    //   528: iconst_2
    //   529: new 67	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 444
    //   539: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload 9
    //   544: getfield 447	com/tencent/mobileqq/data/ResourcePluginInfo:strResName	Ljava/lang/String;
    //   547: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: aload 8
    //   558: aconst_null
    //   559: putfield 365	aunr:icon	Landroid/graphics/drawable/Drawable;
    //   562: goto -347 -> 215
    //   565: aload_1
    //   566: invokevirtual 451	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   569: aload 9
    //   571: getfield 350	com/tencent/mobileqq/data/ResourcePluginInfo:strResURL	Ljava/lang/String;
    //   574: ldc_w 453
    //   577: aload_1
    //   578: invokevirtual 456	android/content/Context:getPackageName	()Ljava/lang/String;
    //   581: invokevirtual 462	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   584: istore_3
    //   585: iload_3
    //   586: ifeq -252 -> 334
    //   589: aload 8
    //   591: aload_1
    //   592: invokevirtual 451	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   595: iload_3
    //   596: invokevirtual 466	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   599: putfield 365	aunr:icon	Landroid/graphics/drawable/Drawable;
    //   602: goto -268 -> 334
    //   605: astore 8
    //   607: aload 8
    //   609: invokevirtual 467	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   612: goto -492 -> 120
    //   615: aload 8
    //   617: getfield 249	aunr:c	Lcom/tencent/mobileqq/data/ResourcePluginInfo;
    //   620: ifnull +39 -> 659
    //   623: aload 8
    //   625: getfield 249	aunr:c	Lcom/tencent/mobileqq/data/ResourcePluginInfo;
    //   628: getfield 255	com/tencent/mobileqq/data/ResourcePluginInfo:uiResId	J
    //   631: ldc2_w 468
    //   634: lcmp
    //   635: ifne +24 -> 659
    //   638: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   641: ifeq +12 -> 653
    //   644: ldc 165
    //   646: iconst_2
    //   647: ldc_w 471
    //   650: invokestatic 329	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   653: aload 8
    //   655: iconst_1
    //   656: putfield 474	aunr:bo	B
    //   659: aload 6
    //   661: aload 8
    //   663: invokeinterface 212 2 0
    //   668: pop
    //   669: goto -549 -> 120
    //   672: aload 6
    //   674: new 476	auns$a
    //   677: dup
    //   678: invokespecial 477	auns$a:<init>	()V
    //   681: invokestatic 483	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   684: aload_0
    //   685: aload_2
    //   686: aload 6
    //   688: aload_0
    //   689: aload_2
    //   690: invokevirtual 487	aunq:q	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   693: invokevirtual 490	aunq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;Ljava/util/List;)V
    //   696: aload 4
    //   698: aload_0
    //   699: invokevirtual 492	aunq:dq	()Ljava/util/List;
    //   702: invokestatic 496	auns:F	(Ljava/util/List;Ljava/util/List;)V
    //   705: aload 5
    //   707: invokeinterface 197 1 0
    //   712: ifle +12 -> 724
    //   715: aload_2
    //   716: getfield 499	com/tencent/mobileqq/app/QQAppInterface:a	Launo;
    //   719: aload 5
    //   721: invokevirtual 504	auno:oc	(Ljava/util/List;)V
    //   724: aload 4
    //   726: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	727	0	this	aunq
    //   0	727	1	paramContext	android.content.Context
    //   0	727	2	paramQQAppInterface	QQAppInterface
    //   584	12	3	i	int
    //   69	656	4	localArrayList1	ArrayList
    //   78	642	5	localArrayList2	ArrayList
    //   84	603	6	localObject1	Object
    //   100	31	7	localObject2	Object
    //   162	321	8	localaunr	aunr
    //   491	99	8	localException	Exception
    //   605	57	8	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   140	430	9	localObject3	Object
    //   187	266	10	localObject4	Object
    //   194	250	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   164	196	491	java/lang/Exception
    //   201	215	491	java/lang/Exception
    //   215	223	491	java/lang/Exception
    //   228	236	491	java/lang/Exception
    //   241	257	491	java/lang/Exception
    //   257	263	491	java/lang/Exception
    //   263	334	491	java/lang/Exception
    //   334	362	491	java/lang/Exception
    //   367	401	491	java/lang/Exception
    //   406	423	491	java/lang/Exception
    //   433	452	491	java/lang/Exception
    //   452	462	491	java/lang/Exception
    //   462	488	491	java/lang/Exception
    //   519	556	491	java/lang/Exception
    //   556	562	491	java/lang/Exception
    //   565	585	491	java/lang/Exception
    //   589	602	491	java/lang/Exception
    //   607	612	491	java/lang/Exception
    //   615	653	491	java/lang/Exception
    //   653	659	491	java/lang/Exception
    //   659	669	491	java/lang/Exception
    //   452	462	605	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    for (;;)
    {
      aunr localaunr;
      label103:
      int j;
      synchronized (this.ux)
      {
        Iterator localIterator = this.ux.iterator();
        if (!localIterator.hasNext()) {
          break label261;
        }
        localaunr = (aunr)localIterator.next();
        if ((localaunr == null) || (localaunr.c == null) || (localaunr.c.uiResId != paramLong1)) {
          continue;
        }
        if (paramBoolean)
        {
          i = 0;
          localaunr.bo = ((byte)i);
          if (paramLong3 != -9223372036854775808L) {
            break label191;
          }
          localaunr.WQ = paramLong2;
          i = 1;
          j = i;
          if (paramQQAppInterface != null)
          {
            j = i;
            if (i == 1)
            {
              i = (int)paramLong1;
              if (paramLong3 != -9223372036854775808L) {
                break label221;
              }
            }
          }
        }
      }
      try
      {
        for (;;)
        {
          j = a(paramQQAppInterface, i, paramBoolean, paramLong2);
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, ret = " + j);
          }
          return;
          i = 1;
          break;
          label191:
          if (paramLong2 != localaunr.WQ) {
            break label267;
          }
          localaunr.WQ = paramLong3;
          i = 1;
          break label103;
          paramQQAppInterface = finally;
          throw paramQQAppInterface;
          label221:
          paramLong2 = paramLong3;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          i = -2;
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.lebatab.mgr", 2, paramQQAppInterface.toString());
            j = i;
          }
        }
      }
      label261:
      int i = 1;
      continue;
      label267:
      i = -2147483648;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<aunr> paramList, List<BusinessInfoCheckUpdate.AppSetting> paramList1)
  {
    int i;
    if (QLog.isDevelopLevel())
    {
      ??? = new StringBuilder().append("setAllLebaList, ");
      if (paramList != null) {
        break label112;
      }
      i = 0;
    }
    for (;;)
    {
      QLog.i("Q.lebatab.mgr", 4, i);
      synchronized (this.ux)
      {
        this.ux.clear();
        if (paramList != null) {
          this.ux.addAll(paramList);
        }
        hl(paramList1);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = (ackq)paramQQAppInterface.getBusinessHandler(31);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.notifyUI(1, true, null);
          }
        }
        return;
        label112:
        i = paramList.size();
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    synchronized (this.lock)
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      boolean bool = aqhq.a(new File(paramQQAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_switch_" + str).getAbsolutePath(), paramTimeRspBody.toByteArray(), false);
      if (bool) {
        anec.io.put(str, Boolean.valueOf(false));
      }
      if (bool) {
        e(paramTimeRspBody);
      }
      return bool;
    }
  }
  
  public List<aunr> dp()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.ux)
    {
      Iterator localIterator = this.ux.iterator();
      while (localIterator.hasNext())
      {
        aunr localaunr = (aunr)localIterator.next();
        if ((localaunr != null) && (localaunr.c != null) && (localaunr.c.uiResId != 886L) && (localaunr.c.uiResId != 905L)) {
          localArrayList.add(localaunr);
        }
      }
    }
    return localList1;
  }
  
  public List<aunr> dq()
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      aunr localaunr;
      synchronized (this.ux)
      {
        Iterator localIterator = this.ux.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localaunr = (aunr)localIterator.next();
        if ((localaunr == null) || (localaunr.c == null) || (localaunr.c.uiResId == 905L)) {
          continue;
        }
        if (dp(localaunr.c.uiResId))
        {
          if ((!obt.awi) || (!obt.awj) || (localaunr.bo != 0)) {
            continue;
          }
          localArrayList.add(localaunr);
        }
      }
      if ((!dq(localaunr.c.uiResId)) && ((localaunr.bo == 0) || (localaunr.c.uiResId == 0L))) {
        localList1.add(localaunr);
      }
    }
    return localList1;
  }
  
  public ArrayList<Long> es()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(21L));
    localArrayList.add(Long.valueOf(18L));
    localArrayList.add(Long.valueOf(17L));
    localArrayList.add(Long.valueOf(26L));
    localArrayList.add(Long.valueOf(19L));
    localArrayList.add(Long.valueOf(22L));
    localArrayList.add(Long.valueOf(35L));
    localArrayList.add(Long.valueOf(24L));
    return localArrayList;
  }
  
  public void hl(List<BusinessInfoCheckUpdate.AppSetting> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    for (;;)
    {
      synchronized (this.ux)
      {
        Iterator localIterator1 = this.ux.iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        aunr localaunr = (aunr)localIterator1.next();
        if ((localaunr == null) || (localaunr.c == null)) {
          continue;
        }
        long l = localaunr.c.uiResId;
        if (l == 0L) {
          continue;
        }
        Iterator localIterator2 = paramList.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator2.next();
        if ((localAppSetting == null) || (localAppSetting.appid.get() != l)) {
          continue;
        }
        if (localAppSetting.setting.get())
        {
          b = 0;
          localaunr.bo = b;
          localaunr.WQ = localAppSetting.modify_ts.get();
        }
      }
      byte b = 1;
    }
  }
  
  public List<BusinessInfoCheckUpdate.AppSetting> q(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.lock)
    {
      ArrayList localArrayList = new ArrayList();
      paramQQAppInterface = a(paramQQAppInterface);
      if ((paramQQAppInterface == null) || (!paramQQAppInterface.rptSetting.has())) {
        return localArrayList;
      }
      paramQQAppInterface = paramQQAppInterface.rptSetting.get();
      if (paramQQAppInterface != null) {
        localArrayList.addAll(paramQQAppInterface);
      }
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aunq
 * JD-Core Version:    0.7.0.1
 */