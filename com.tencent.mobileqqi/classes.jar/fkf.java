import AvatarInfo.QQHeadInfo;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class fkf
{
  private static final int jdField_a_of_type_Int = 30000;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "Q.qqhead.dh";
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130838088, 2130840347, 2130840348, 2130840349 };
  private byte jdField_a_of_type_Byte;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private fki[] jdField_a_of_type_ArrayOfFki = null;
  private int b = 2;
  private int c = 10;
  private int d = 4;
  private int e = 2;
  private int f = this.e;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j;
  
  public fkf(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = paramFriendListHandler;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (NetworkUtil.g(paramQQAppInterface.a()))
    {
      this.f = this.d;
      this.j = a();
      switch (this.j)
      {
      }
    }
    for (;;)
    {
      this.h = this.f;
      this.jdField_a_of_type_ArrayOfFki = new fki[this.f];
      while (k < this.jdField_a_of_type_ArrayOfFki.length)
      {
        this.jdField_a_of_type_ArrayOfFki[k] = new fki(this, k);
        this.jdField_a_of_type_ArrayOfFki[k].start();
        k += 1;
      }
      this.f = this.e;
      break;
      this.jdField_a_of_type_Byte = 3;
      continue;
      this.jdField_a_of_type_Byte = 2;
      continue;
      this.jdField_a_of_type_Byte = 0;
    }
  }
  
  private int a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    int k = Math.min(localBaseApplicationImpl.getResources().getDisplayMetrics().widthPixels, localBaseApplicationImpl.getResources().getDisplayMetrics().heightPixels);
    if (k > 720) {}
    while (k > 640) {
      return 100;
    }
    return 40;
  }
  
  private String a(String paramString, byte paramByte1, byte paramByte2)
  {
    paramByte2 = a(paramByte1);
    return paramString + paramByte2;
  }
  
  private void a(int paramInt, File paramFile)
  {
    int k;
    if (paramInt >= 0)
    {
      k = paramInt;
      if (paramInt < jdField_a_of_type_ArrayOfInt.length) {}
    }
    else
    {
      k = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dh", 2, "writeTroopSystemHead. systemFaceId=" + k);
    }
    InputStream localInputStream = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().openRawResource(jdField_a_of_type_ArrayOfInt[k]);
    byte[] arrayOfByte = new byte[512];
    paramFile = new FileOutputStream(paramFile);
    for (;;)
    {
      paramInt = localInputStream.read(arrayOfByte);
      if (paramInt <= 0) {
        break;
      }
      paramFile.write(arrayOfByte, 0, paramInt);
    }
    paramFile.close();
    localInputStream.close();
  }
  
  /* Error */
  private void a(fkh arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 199	fkh:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   4: astore 20
    //   6: aload_1
    //   7: getfield 202	fkh:jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   10: astore 22
    //   12: aload_0
    //   13: getfield 63	fkf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   16: aload 20
    //   18: getfield 208	AvatarInfo/QQHeadInfo:uin	J
    //   21: aload 20
    //   23: getfield 211	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   26: invokevirtual 216	com/tencent/mobileqq/app/FriendListHandler:a	(JLjava/lang/String;)Ljava/lang/String;
    //   29: astore 19
    //   31: iconst_0
    //   32: istore 9
    //   34: iconst_0
    //   35: istore 11
    //   37: iconst_0
    //   38: istore 8
    //   40: aload 20
    //   42: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   45: astore 17
    //   47: iconst_0
    //   48: istore 4
    //   50: iconst_0
    //   51: istore_3
    //   52: aload_0
    //   53: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   56: invokevirtual 222	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   59: invokevirtual 228	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   62: astore 21
    //   64: iload 11
    //   66: istore 10
    //   68: aload 20
    //   70: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   73: ifnull +1568 -> 1641
    //   76: iload 11
    //   78: istore 10
    //   80: ldc 230
    //   82: aload 20
    //   84: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   87: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifne +1551 -> 1641
    //   93: iload 11
    //   95: istore 10
    //   97: aload 20
    //   99: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   102: iconst_4
    //   103: if_icmpne +821 -> 924
    //   106: iload 11
    //   108: istore 10
    //   110: new 131	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   117: ldc 241
    //   119: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 19
    //   124: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: astore_1
    //   131: iload 11
    //   133: istore 10
    //   135: aload 21
    //   137: ldc 243
    //   139: aload_1
    //   140: invokevirtual 248	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   143: checkcast 243	com/tencent/mobileqq/data/Setting
    //   146: astore 18
    //   148: aload 18
    //   150: ifnonnull +1482 -> 1632
    //   153: iload 11
    //   155: istore 10
    //   157: new 243	com/tencent/mobileqq/data/Setting
    //   160: dup
    //   161: invokespecial 249	com/tencent/mobileqq/data/Setting:<init>	()V
    //   164: astore 18
    //   166: iload 11
    //   168: istore 10
    //   170: aload 18
    //   172: aload_1
    //   173: putfield 251	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   176: iconst_1
    //   177: istore 9
    //   179: iconst_0
    //   180: istore_2
    //   181: iload 9
    //   183: istore 10
    //   185: aload 18
    //   187: aload 20
    //   189: getfield 254	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   192: putfield 257	com/tencent/mobileqq/data/Setting:bFaceFlags	B
    //   195: iload 9
    //   197: istore 10
    //   199: aload 18
    //   201: aload 20
    //   203: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   206: putfield 260	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   209: iload 9
    //   211: istore 10
    //   213: aload 18
    //   215: aload 20
    //   217: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   220: putfield 263	com/tencent/mobileqq/data/Setting:url	Ljava/lang/String;
    //   223: iload 9
    //   225: istore 10
    //   227: aload 18
    //   229: invokestatic 269	java/lang/System:currentTimeMillis	()J
    //   232: putfield 272	com/tencent/mobileqq/data/Setting:updateTimestamp	J
    //   235: iload 9
    //   237: istore 10
    //   239: aload 20
    //   241: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   244: ifne +686 -> 930
    //   247: iload 9
    //   249: istore 10
    //   251: aload 18
    //   253: iconst_0
    //   254: putfield 278	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   257: iload 9
    //   259: istore 8
    //   261: iload 9
    //   263: ifne +127 -> 390
    //   266: iload 9
    //   268: istore 10
    //   270: aload 18
    //   272: getfield 281	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   275: aload 20
    //   277: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   280: if_icmpeq +798 -> 1078
    //   283: iconst_1
    //   284: istore 9
    //   286: iload 9
    //   288: istore 8
    //   290: iload 9
    //   292: ifeq +98 -> 390
    //   295: iload 9
    //   297: istore 8
    //   299: iload 9
    //   301: istore 10
    //   303: aload 18
    //   305: getfield 281	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   308: iconst_1
    //   309: if_icmpne +81 -> 390
    //   312: iload 9
    //   314: istore 8
    //   316: iload 9
    //   318: istore 10
    //   320: aload 20
    //   322: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   325: ifne +65 -> 390
    //   328: iload 9
    //   330: istore 10
    //   332: new 283	java/io/File
    //   335: dup
    //   336: aload_0
    //   337: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   340: aload 18
    //   342: getfield 260	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   345: aload 19
    //   347: invokevirtual 286	com/tencent/mobileqq/app/QQAppInterface:b	(ILjava/lang/String;)Ljava/lang/String;
    //   350: invokespecial 289	java/io/File:<init>	(Ljava/lang/String;)V
    //   353: astore_1
    //   354: iload 9
    //   356: istore 8
    //   358: aload_1
    //   359: ifnull +31 -> 390
    //   362: iload 9
    //   364: istore 8
    //   366: iload 9
    //   368: istore 10
    //   370: aload_1
    //   371: invokevirtual 292	java/io/File:exists	()Z
    //   374: ifeq +16 -> 390
    //   377: iload 9
    //   379: istore 10
    //   381: aload_1
    //   382: invokevirtual 295	java/io/File:delete	()Z
    //   385: pop
    //   386: iload 9
    //   388: istore 8
    //   390: aload 18
    //   392: aload 20
    //   394: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   397: putfield 281	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   400: aload 18
    //   402: aload 20
    //   404: getfield 299	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   407: putfield 300	com/tencent/mobileqq/data/Setting:systemHeadID	S
    //   410: aload 18
    //   412: aload 20
    //   414: getfield 303	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   417: putfield 306	com/tencent/mobileqq/data/Setting:headImgTimestamp	J
    //   420: aload_0
    //   421: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   424: aload 18
    //   426: invokevirtual 309	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;)V
    //   429: iload_2
    //   430: ifeq +729 -> 1159
    //   433: aload 21
    //   435: aload 18
    //   437: invokevirtual 312	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   440: pop
    //   441: aload_0
    //   442: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   445: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   448: invokevirtual 318	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   451: invokestatic 322	com/tencent/mobileqq/utils/ContactConfig:a	(Landroid/content/Context;)Z
    //   454: ifeq +106 -> 560
    //   457: invokestatic 326	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   460: ifeq +100 -> 560
    //   463: getstatic 39	fkf:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   466: astore_1
    //   467: aload_1
    //   468: monitorenter
    //   469: aload_0
    //   470: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   473: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   476: invokevirtual 318	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   479: invokestatic 322	com/tencent/mobileqq/utils/ContactConfig:a	(Landroid/content/Context;)Z
    //   482: ifeq +62 -> 544
    //   485: invokestatic 326	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   488: istore 9
    //   490: iload 9
    //   492: ifeq +52 -> 544
    //   495: new 131	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   502: getstatic 328	com/tencent/mobileqq/util/SystemUtil:a	Ljava/lang/String;
    //   505: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: ldc_w 330
    //   511: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: new 131	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   524: getstatic 335	com/tencent/mobileqq/app/AppConstants:an	Ljava/lang/String;
    //   527: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: ldc_w 330
    //   533: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: iconst_1
    //   540: invokestatic 340	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)I
    //   543: pop
    //   544: aload_0
    //   545: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   548: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   551: invokevirtual 318	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   554: iconst_0
    //   555: invokestatic 343	com/tencent/mobileqq/utils/ContactConfig:a	(Landroid/content/Context;Z)V
    //   558: aload_1
    //   559: monitorexit
    //   560: aload_0
    //   561: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   564: aload 20
    //   566: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   569: aload 19
    //   571: invokevirtual 286	com/tencent/mobileqq/app/QQAppInterface:b	(ILjava/lang/String;)Ljava/lang/String;
    //   574: astore_1
    //   575: new 283	java/io/File
    //   578: dup
    //   579: aload_1
    //   580: invokespecial 289	java/io/File:<init>	(Ljava/lang/String;)V
    //   583: astore 23
    //   585: iload 8
    //   587: ifne +624 -> 1211
    //   590: aload 23
    //   592: invokevirtual 292	java/io/File:exists	()Z
    //   595: istore 9
    //   597: iload 9
    //   599: ifne +606 -> 1205
    //   602: iconst_1
    //   603: istore 8
    //   605: iconst_0
    //   606: istore 10
    //   608: iload 8
    //   610: istore 9
    //   612: iload 10
    //   614: istore 8
    //   616: iload 9
    //   618: ifeq +993 -> 1611
    //   621: aload_0
    //   622: aload 20
    //   624: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   627: aload 20
    //   629: getfield 254	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   632: aload 20
    //   634: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   637: invokespecial 345	fkf:a	(Ljava/lang/String;BB)Ljava/lang/String;
    //   640: astore 16
    //   642: aload 20
    //   644: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   647: ifne +623 -> 1270
    //   650: aload 20
    //   652: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   655: istore_2
    //   656: iload_2
    //   657: iconst_4
    //   658: if_icmpne +612 -> 1270
    //   661: aload 23
    //   663: invokevirtual 292	java/io/File:exists	()Z
    //   666: ifne +14 -> 680
    //   669: aload_0
    //   670: aload 20
    //   672: getfield 299	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   675: aload 23
    //   677: invokespecial 347	fkf:a	(ILjava/io/File;)V
    //   680: iconst_1
    //   681: istore 8
    //   683: iload 4
    //   685: istore_2
    //   686: iload 8
    //   688: ifeq +792 -> 1480
    //   691: aload 19
    //   693: invokestatic 352	com/tencent/mobileqq/util/ProfileCardUtil:a	(Ljava/lang/String;)Z
    //   696: pop
    //   697: aload_0
    //   698: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   701: aload 19
    //   703: invokestatic 355	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   706: aload 20
    //   708: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   711: iconst_4
    //   712: if_icmpne +758 -> 1470
    //   715: aload_0
    //   716: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   719: iconst_4
    //   720: aload 19
    //   722: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;)V
    //   725: iload_3
    //   726: istore 4
    //   728: iload_2
    //   729: istore_3
    //   730: iload 4
    //   732: istore_2
    //   733: iload 8
    //   735: ifeq +34 -> 769
    //   738: aload 20
    //   740: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   743: bipush 11
    //   745: if_icmpne +746 -> 1491
    //   748: aload_0
    //   749: getfield 63	fkf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   752: aload 22
    //   754: bipush 39
    //   756: iconst_1
    //   757: iconst_1
    //   758: anewarray 4	java/lang/Object
    //   761: dup
    //   762: iconst_0
    //   763: aload 19
    //   765: aastore
    //   766: invokevirtual 361	com/tencent/mobileqq/app/FriendListHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;IZLjava/lang/Object;)V
    //   769: aload_0
    //   770: getfield 63	fkf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   773: bipush 45
    //   775: iconst_1
    //   776: aload 18
    //   778: invokevirtual 364	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   781: aload_0
    //   782: getfield 63	fkf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   785: aload 19
    //   787: iconst_1
    //   788: invokevirtual 367	com/tencent/mobileqq/app/FriendListHandler:b	(Ljava/lang/String;Z)V
    //   791: aload 21
    //   793: invokevirtual 369	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   796: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   799: ifeq +124 -> 923
    //   802: ldc 11
    //   804: iconst_2
    //   805: new 131	java/lang/StringBuilder
    //   808: dup
    //   809: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   812: ldc_w 371
    //   815: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: iload 8
    //   820: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   823: ldc_w 376
    //   826: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: iload_3
    //   830: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   833: ldc_w 378
    //   836: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: aload 20
    //   841: getfield 208	AvatarInfo/QQHeadInfo:uin	J
    //   844: invokevirtual 381	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   847: ldc_w 383
    //   850: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: iload 9
    //   855: invokevirtual 374	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   858: ldc_w 385
    //   861: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: aload 20
    //   866: getfield 211	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   869: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: ldc_w 387
    //   875: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: aload 20
    //   880: getfield 299	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   883: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   886: ldc_w 389
    //   889: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: iload_2
    //   893: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   896: ldc_w 391
    //   899: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: aload_1
    //   903: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: ldc_w 393
    //   909: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload 16
    //   914: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   923: return
    //   924: aload 19
    //   926: astore_1
    //   927: goto -796 -> 131
    //   930: iload 9
    //   932: istore 10
    //   934: aload 20
    //   936: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   939: iconst_1
    //   940: if_icmpne +121 -> 1061
    //   943: iload 9
    //   945: istore 10
    //   947: aload_0
    //   948: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   951: bipush 8
    //   953: invokevirtual 397	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   956: checkcast 399	com/tencent/mobileqq/model/FriendManager
    //   959: aload 18
    //   961: getfield 251	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   964: invokestatic 403	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   967: invokeinterface 406 2 0
    //   972: ifnonnull +58 -> 1030
    //   975: iload 9
    //   977: istore 10
    //   979: aload 18
    //   981: aload 20
    //   983: getfield 409	AvatarInfo/QQHeadInfo:soruceType	B
    //   986: putfield 278	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   989: goto -732 -> 257
    //   992: astore_1
    //   993: iconst_0
    //   994: istore_2
    //   995: aconst_null
    //   996: astore_1
    //   997: iconst_0
    //   998: istore 8
    //   1000: iload 10
    //   1002: istore 9
    //   1004: aload 17
    //   1006: astore 16
    //   1008: sipush 9204
    //   1011: istore_3
    //   1012: aload_0
    //   1013: getfield 63	fkf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1016: aload 19
    //   1018: iconst_1
    //   1019: invokevirtual 367	com/tencent/mobileqq/app/FriendListHandler:b	(Ljava/lang/String;Z)V
    //   1022: aload 21
    //   1024: invokevirtual 369	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1027: goto -231 -> 796
    //   1030: iload 9
    //   1032: istore 10
    //   1034: aload 18
    //   1036: iconst_0
    //   1037: putfield 278	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   1040: goto -783 -> 257
    //   1043: astore_1
    //   1044: aload_0
    //   1045: getfield 63	fkf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1048: aload 19
    //   1050: iconst_1
    //   1051: invokevirtual 367	com/tencent/mobileqq/app/FriendListHandler:b	(Ljava/lang/String;Z)V
    //   1054: aload 21
    //   1056: invokevirtual 369	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1059: aload_1
    //   1060: athrow
    //   1061: iload 9
    //   1063: istore 10
    //   1065: aload 18
    //   1067: aload 20
    //   1069: getfield 409	AvatarInfo/QQHeadInfo:soruceType	B
    //   1072: putfield 278	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   1075: goto -818 -> 257
    //   1078: iload 9
    //   1080: istore 10
    //   1082: aload 20
    //   1084: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   1087: ifne +26 -> 1113
    //   1090: iload 9
    //   1092: istore 10
    //   1094: aload 18
    //   1096: getfield 300	com/tencent/mobileqq/data/Setting:systemHeadID	S
    //   1099: aload 20
    //   1101: getfield 299	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   1104: if_icmpeq +560 -> 1664
    //   1107: iconst_1
    //   1108: istore 8
    //   1110: goto +547 -> 1657
    //   1113: iload 9
    //   1115: istore 10
    //   1117: aload 18
    //   1119: getfield 306	com/tencent/mobileqq/data/Setting:headImgTimestamp	J
    //   1122: lstore 12
    //   1124: iload 9
    //   1126: istore 10
    //   1128: aload 20
    //   1130: getfield 303	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   1133: lstore 14
    //   1135: lload 12
    //   1137: lload 14
    //   1139: lcmp
    //   1140: ifeq +13 -> 1153
    //   1143: iconst_1
    //   1144: istore 8
    //   1146: iload 8
    //   1148: istore 9
    //   1150: goto -864 -> 286
    //   1153: iconst_0
    //   1154: istore 8
    //   1156: goto -10 -> 1146
    //   1159: aload 21
    //   1161: aload 18
    //   1163: invokevirtual 412	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   1166: goto -725 -> 441
    //   1169: astore_1
    //   1170: iload 8
    //   1172: istore 9
    //   1174: aconst_null
    //   1175: astore_1
    //   1176: iconst_0
    //   1177: istore_2
    //   1178: iconst_0
    //   1179: istore 8
    //   1181: aload 17
    //   1183: astore 16
    //   1185: goto -177 -> 1008
    //   1188: astore 16
    //   1190: aload 16
    //   1192: invokevirtual 415	java/lang/Exception:printStackTrace	()V
    //   1195: goto -651 -> 544
    //   1198: astore 16
    //   1200: aload_1
    //   1201: monitorexit
    //   1202: aload 16
    //   1204: athrow
    //   1205: iconst_0
    //   1206: istore 8
    //   1208: goto -603 -> 605
    //   1211: aload 18
    //   1213: getfield 281	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   1216: ifeq +7 -> 1223
    //   1219: iload_2
    //   1220: ifne +402 -> 1622
    //   1223: aload 23
    //   1225: invokevirtual 292	java/io/File:exists	()Z
    //   1228: istore 9
    //   1230: iload 9
    //   1232: ifeq +390 -> 1622
    //   1235: iconst_1
    //   1236: istore 8
    //   1238: iconst_0
    //   1239: istore 9
    //   1241: goto -625 -> 616
    //   1244: astore_1
    //   1245: aload_0
    //   1246: getfield 63	fkf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1249: aload 19
    //   1251: iconst_1
    //   1252: invokevirtual 367	com/tencent/mobileqq/app/FriendListHandler:b	(Ljava/lang/String;Z)V
    //   1255: aload 21
    //   1257: invokevirtual 369	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1260: return
    //   1261: astore 17
    //   1263: sipush 9202
    //   1266: istore_2
    //   1267: goto -581 -> 686
    //   1270: aload_0
    //   1271: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1274: aload 16
    //   1276: aload 23
    //   1278: invokestatic 420	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)I
    //   1281: istore_2
    //   1282: iload_2
    //   1283: ifne +116 -> 1399
    //   1286: aload 23
    //   1288: invokevirtual 423	java/io/File:length	()J
    //   1291: lstore 12
    //   1293: lload 12
    //   1295: l2i
    //   1296: istore 5
    //   1298: aload_0
    //   1299: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1302: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1305: invokestatic 426	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   1308: invokevirtual 431	android/net/NetworkInfo:getType	()I
    //   1311: istore 6
    //   1313: iconst_0
    //   1314: istore_2
    //   1315: aload 20
    //   1317: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1320: iconst_1
    //   1321: if_icmpne +45 -> 1366
    //   1324: iconst_0
    //   1325: istore_2
    //   1326: aload_0
    //   1327: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1330: aload_0
    //   1331: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1334: invokevirtual 433	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1337: iconst_0
    //   1338: iload 6
    //   1340: ldc_w 434
    //   1343: iload_2
    //   1344: iload 5
    //   1346: bipush 126
    //   1348: iadd
    //   1349: sipush 239
    //   1352: iadd
    //   1353: i2l
    //   1354: invokevirtual 437	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;ZIIIJ)V
    //   1357: iconst_1
    //   1358: istore 8
    //   1360: iload 4
    //   1362: istore_2
    //   1363: goto -677 -> 686
    //   1366: aload 20
    //   1368: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1371: iconst_4
    //   1372: if_icmpne +8 -> 1380
    //   1375: iconst_1
    //   1376: istore_2
    //   1377: goto -51 -> 1326
    //   1380: aload 20
    //   1382: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1385: istore 7
    //   1387: iload 7
    //   1389: bipush 11
    //   1391: if_icmpne -65 -> 1326
    //   1394: iconst_3
    //   1395: istore_2
    //   1396: goto -70 -> 1326
    //   1399: iload_2
    //   1400: tableswitch	default:+36 -> 1436, 1:+49->1449, 2:+36->1436, 3:+36->1436, 4:+56->1456, 5:+63->1463
    //   1437: fload_1
    //   1438: <illegal opcode>
    //   1439: istore 4
    //   1441: iload_2
    //   1442: istore_3
    //   1443: iload 4
    //   1445: istore_2
    //   1446: goto -760 -> 686
    //   1449: sipush 9206
    //   1452: istore_2
    //   1453: goto -767 -> 686
    //   1456: sipush 9202
    //   1459: istore_2
    //   1460: goto -774 -> 686
    //   1463: sipush 9204
    //   1466: istore_2
    //   1467: goto -781 -> 686
    //   1470: aload_0
    //   1471: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1474: iconst_1
    //   1475: aload 19
    //   1477: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;)V
    //   1480: iload_2
    //   1481: istore 4
    //   1483: iload_3
    //   1484: istore_2
    //   1485: iload 4
    //   1487: istore_3
    //   1488: goto -755 -> 733
    //   1491: aload 20
    //   1493: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1496: iconst_4
    //   1497: if_icmpne +25 -> 1522
    //   1500: aload_0
    //   1501: getfield 63	fkf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1504: bipush 30
    //   1506: iconst_1
    //   1507: iconst_1
    //   1508: anewarray 4	java/lang/Object
    //   1511: dup
    //   1512: iconst_0
    //   1513: aload 19
    //   1515: aastore
    //   1516: invokevirtual 364	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   1519: goto -750 -> 769
    //   1522: aload_0
    //   1523: getfield 61	fkf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1526: aload 19
    //   1528: invokevirtual 439	com/tencent/mobileqq/app/QQAppInterface:c	(Ljava/lang/String;)V
    //   1531: aload_0
    //   1532: getfield 63	fkf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1535: aload 22
    //   1537: iconst_4
    //   1538: iconst_1
    //   1539: iconst_1
    //   1540: anewarray 4	java/lang/Object
    //   1543: dup
    //   1544: iconst_0
    //   1545: aload 19
    //   1547: aastore
    //   1548: invokevirtual 361	com/tencent/mobileqq/app/FriendListHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;IZLjava/lang/Object;)V
    //   1551: goto -782 -> 769
    //   1554: astore 16
    //   1556: iconst_0
    //   1557: istore 10
    //   1559: iload 8
    //   1561: istore 9
    //   1563: iconst_0
    //   1564: istore_2
    //   1565: aload 17
    //   1567: astore 16
    //   1569: iload 10
    //   1571: istore 8
    //   1573: goto -565 -> 1008
    //   1576: astore 16
    //   1578: iconst_0
    //   1579: istore_2
    //   1580: aload 17
    //   1582: astore 16
    //   1584: goto -576 -> 1008
    //   1587: astore 17
    //   1589: iconst_0
    //   1590: istore_2
    //   1591: goto -583 -> 1008
    //   1594: astore 17
    //   1596: iconst_0
    //   1597: istore_2
    //   1598: iconst_1
    //   1599: istore 8
    //   1601: goto -593 -> 1008
    //   1604: astore 17
    //   1606: iload_3
    //   1607: istore_2
    //   1608: goto -600 -> 1008
    //   1611: iconst_0
    //   1612: istore_3
    //   1613: iconst_0
    //   1614: istore_2
    //   1615: aload 17
    //   1617: astore 16
    //   1619: goto -886 -> 733
    //   1622: iload 8
    //   1624: istore 9
    //   1626: iconst_0
    //   1627: istore 8
    //   1629: goto -1013 -> 616
    //   1632: iconst_1
    //   1633: istore_2
    //   1634: iload 8
    //   1636: istore 9
    //   1638: goto -1457 -> 181
    //   1641: iconst_0
    //   1642: istore_2
    //   1643: aconst_null
    //   1644: astore_1
    //   1645: iconst_0
    //   1646: istore 8
    //   1648: iconst_0
    //   1649: istore_3
    //   1650: aload 17
    //   1652: astore 16
    //   1654: goto -873 -> 781
    //   1657: iload 8
    //   1659: istore 9
    //   1661: goto -1375 -> 286
    //   1664: iconst_0
    //   1665: istore 8
    //   1667: goto -10 -> 1657
    //   1670: astore 17
    //   1672: goto -664 -> 1008
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1675	0	this	fkf
    //   180	1463	2	k	int
    //   51	1599	3	m	int
    //   48	1438	4	n	int
    //   1296	53	5	i1	int
    //   1311	28	6	i2	int
    //   1385	7	7	i3	int
    //   38	1628	8	bool1	boolean
    //   32	1628	9	bool2	boolean
    //   66	1504	10	bool3	boolean
    //   35	132	11	bool4	boolean
    //   1122	172	12	l1	long
    //   1133	5	14	l2	long
    //   640	544	16	str1	String
    //   1188	3	16	localException1	java.lang.Exception
    //   1198	77	16	str2	String
    //   1554	1	16	localThrowable1	java.lang.Throwable
    //   1567	1	16	localException2	java.lang.Exception
    //   1576	1	16	localThrowable2	java.lang.Throwable
    //   1582	71	16	localObject	Object
    //   45	1137	17	str3	String
    //   1261	320	17	localException3	java.lang.Exception
    //   1587	1	17	localThrowable3	java.lang.Throwable
    //   1594	1	17	localThrowable4	java.lang.Throwable
    //   1604	47	17	localThrowable5	java.lang.Throwable
    //   1670	1	17	localThrowable6	java.lang.Throwable
    //   146	1066	18	localSetting	com.tencent.mobileqq.data.Setting
    //   29	1517	19	str4	String
    //   4	1488	20	localQQHeadInfo	QQHeadInfo
    //   62	1194	21	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   10	1526	22	localToServiceMsg	ToServiceMsg
    //   583	704	23	localFile	File
    // Exception table:
    //   from	to	target	type
    //   68	76	992	java/lang/Throwable
    //   80	93	992	java/lang/Throwable
    //   97	106	992	java/lang/Throwable
    //   110	131	992	java/lang/Throwable
    //   135	148	992	java/lang/Throwable
    //   157	166	992	java/lang/Throwable
    //   170	176	992	java/lang/Throwable
    //   185	195	992	java/lang/Throwable
    //   199	209	992	java/lang/Throwable
    //   213	223	992	java/lang/Throwable
    //   227	235	992	java/lang/Throwable
    //   239	247	992	java/lang/Throwable
    //   251	257	992	java/lang/Throwable
    //   270	283	992	java/lang/Throwable
    //   303	312	992	java/lang/Throwable
    //   320	328	992	java/lang/Throwable
    //   332	354	992	java/lang/Throwable
    //   370	377	992	java/lang/Throwable
    //   381	386	992	java/lang/Throwable
    //   934	943	992	java/lang/Throwable
    //   947	975	992	java/lang/Throwable
    //   979	989	992	java/lang/Throwable
    //   1034	1040	992	java/lang/Throwable
    //   1065	1075	992	java/lang/Throwable
    //   1082	1090	992	java/lang/Throwable
    //   1094	1107	992	java/lang/Throwable
    //   1117	1124	992	java/lang/Throwable
    //   1128	1135	992	java/lang/Throwable
    //   68	76	1043	finally
    //   80	93	1043	finally
    //   97	106	1043	finally
    //   110	131	1043	finally
    //   135	148	1043	finally
    //   157	166	1043	finally
    //   170	176	1043	finally
    //   185	195	1043	finally
    //   199	209	1043	finally
    //   213	223	1043	finally
    //   227	235	1043	finally
    //   239	247	1043	finally
    //   251	257	1043	finally
    //   270	283	1043	finally
    //   303	312	1043	finally
    //   320	328	1043	finally
    //   332	354	1043	finally
    //   370	377	1043	finally
    //   381	386	1043	finally
    //   390	429	1043	finally
    //   433	441	1043	finally
    //   441	469	1043	finally
    //   560	575	1043	finally
    //   575	585	1043	finally
    //   590	597	1043	finally
    //   621	642	1043	finally
    //   642	656	1043	finally
    //   661	680	1043	finally
    //   691	725	1043	finally
    //   738	769	1043	finally
    //   769	781	1043	finally
    //   934	943	1043	finally
    //   947	975	1043	finally
    //   979	989	1043	finally
    //   1034	1040	1043	finally
    //   1065	1075	1043	finally
    //   1082	1090	1043	finally
    //   1094	1107	1043	finally
    //   1117	1124	1043	finally
    //   1128	1135	1043	finally
    //   1159	1166	1043	finally
    //   1202	1205	1043	finally
    //   1211	1219	1043	finally
    //   1223	1230	1043	finally
    //   1270	1282	1043	finally
    //   1286	1293	1043	finally
    //   1298	1313	1043	finally
    //   1315	1324	1043	finally
    //   1326	1357	1043	finally
    //   1366	1375	1043	finally
    //   1380	1387	1043	finally
    //   1470	1480	1043	finally
    //   1491	1519	1043	finally
    //   1522	1551	1043	finally
    //   390	429	1169	java/lang/Throwable
    //   433	441	1169	java/lang/Throwable
    //   441	469	1169	java/lang/Throwable
    //   560	575	1169	java/lang/Throwable
    //   1159	1166	1169	java/lang/Throwable
    //   1202	1205	1169	java/lang/Throwable
    //   495	544	1188	java/lang/Exception
    //   469	490	1198	finally
    //   495	544	1198	finally
    //   544	560	1198	finally
    //   1190	1195	1198	finally
    //   1200	1202	1198	finally
    //   560	575	1244	java/lang/Exception
    //   575	585	1244	java/lang/Exception
    //   590	597	1244	java/lang/Exception
    //   1211	1219	1244	java/lang/Exception
    //   1223	1230	1244	java/lang/Exception
    //   661	680	1261	java/lang/Exception
    //   575	585	1554	java/lang/Throwable
    //   590	597	1554	java/lang/Throwable
    //   1211	1219	1554	java/lang/Throwable
    //   1223	1230	1554	java/lang/Throwable
    //   621	642	1576	java/lang/Throwable
    //   642	656	1587	java/lang/Throwable
    //   661	680	1587	java/lang/Throwable
    //   1270	1282	1587	java/lang/Throwable
    //   1286	1293	1587	java/lang/Throwable
    //   1298	1313	1594	java/lang/Throwable
    //   1315	1324	1594	java/lang/Throwable
    //   1326	1357	1594	java/lang/Throwable
    //   1366	1375	1594	java/lang/Throwable
    //   1380	1387	1594	java/lang/Throwable
    //   691	725	1604	java/lang/Throwable
    //   1470	1480	1604	java/lang/Throwable
    //   738	769	1670	java/lang/Throwable
    //   769	781	1670	java/lang/Throwable
    //   1491	1519	1670	java/lang/Throwable
    //   1522	1551	1670	java/lang/Throwable
  }
  
  protected int a(byte paramByte)
  {
    byte b3 = paramByte;
    if (paramByte == 0) {
      b3 = 1;
    }
    paramByte = 1 << this.jdField_a_of_type_Byte;
    if ((paramByte & b3) == paramByte) {
      return this.j;
    }
    byte b2 = 0;
    paramByte = this.jdField_a_of_type_Byte - 1;
    byte b1 = b2;
    if (paramByte >= 0)
    {
      b1 = (byte)(1 << paramByte);
      if ((b1 & b3) == b1) {
        b1 = 1;
      }
    }
    else
    {
      b2 = paramByte;
      if (b1 != 0) {
        break label167;
      }
      paramByte = this.jdField_a_of_type_Byte + 1;
      b2 = paramByte;
      if (paramByte >= 8) {
        break label167;
      }
      b2 = (byte)(1 << paramByte);
      if ((b2 & b3) != b2) {
        break label146;
      }
      b1 = 1;
    }
    for (;;)
    {
      if (b1 != 0) {}
      switch (paramByte)
      {
      case 1: 
      default: 
        return 100;
        paramByte -= 1;
        break;
        paramByte += 1;
        break;
      case 0: 
        return 40;
      case 2: 
        return 100;
      case 3: 
        return 140;
      case 4: 
        label146:
        return 640;
        label167:
        paramByte = b2;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQHeadDownloadHandler", 2, "QQHeadDownloadHandler close.");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    int k = 0;
    while (k < this.jdField_a_of_type_ArrayOfFki.length)
    {
      if (this.jdField_a_of_type_ArrayOfFki[k] != null) {
        this.jdField_a_of_type_ArrayOfFki[k].a();
      }
      k += 1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.notifyAll();
        return;
      }
    }
  }
  
  public void a(int paramInt)
  {
    int n = 0;
    int k = 0;
    int m;
    if ((paramInt == this.f) && (this.h < this.f) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.g))
    {
      m = this.h + this.jdField_a_of_type_JavaUtilArrayList.size() - this.g + 1;
      paramInt = m;
      if (m <= 0) {
        paramInt = 1;
      }
      if (paramInt >= this.f) {}
    }
    while (k < paramInt)
    {
      if (this.jdField_a_of_type_ArrayOfFki[k] == null)
      {
        this.jdField_a_of_type_ArrayOfFki[k] = new fki(this, k);
        this.jdField_a_of_type_ArrayOfFki[k].start();
        this.h += 1;
      }
      k += 1;
      continue;
      paramInt = this.f;
      continue;
      if ((paramInt > 0) && (paramInt != this.f))
      {
        fki[] arrayOffki = new fki[paramInt];
        m = 0;
        k = n;
        n = k;
        if (m < this.jdField_a_of_type_ArrayOfFki.length)
        {
          if ((this.jdField_a_of_type_ArrayOfFki[m] != null) && (k < paramInt))
          {
            arrayOffki[k] = this.jdField_a_of_type_ArrayOfFki[m];
            arrayOffki[k].a(k);
            n = k + 1;
          }
          for (;;)
          {
            m += 1;
            k = n;
            break;
            n = k;
            if (this.jdField_a_of_type_ArrayOfFki[m] != null)
            {
              this.jdField_a_of_type_ArrayOfFki[m].a();
              n = k;
            }
          }
        }
        while (n < paramInt)
        {
          arrayOffki[n] = new fki(this, n);
          arrayOffki[n].start();
          this.h += 1;
          n += 1;
        }
        this.f = paramInt;
        this.jdField_a_of_type_ArrayOfFki = arrayOffki;
      }
    }
  }
  
  public boolean a(QQHeadInfo arg1, ToServiceMsg paramToServiceMsg)
  {
    fkh localfkh = new fkh(this, null);
    localfkh.jdField_a_of_type_AvatarInfoQQHeadInfo = ???;
    localfkh.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dh", 2, "downloadAndNotifyQQhead|uin=" + ???.uin + ", phoneNum=" + ???.phoneNum + ", cHeadType=" + ???.cHeadType + ", dstUsrType=" + ???.dstUsrType + ", dwFaceFlgas=" + ???.dwFaceFlgas + ", systemHeadID=" + ???.systemHeadID + ", dwTimestamp=" + ???.dwTimestamp + ", downLoadUrl=" + ???.downLoadUrl);
    }
    int k = this.f;
    if (this.i > 5)
    {
      this.i = 0;
      if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        break label228;
      }
      k = this.d;
    }
    for (;;)
    {
      this.i += 1;
      a(k);
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(localfkh);
        this.jdField_a_of_type_JavaUtilArrayList.notify();
        return false;
        label228:
        k = this.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fkf
 * JD-Core Version:    0.7.0.1
 */