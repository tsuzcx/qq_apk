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

public class cvf
{
  private static final int jdField_a_of_type_Int = 30000;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "Q.qqhead.dh";
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130838106, 2130839464, 2130839465, 2130839466 };
  private byte jdField_a_of_type_Byte;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private cvi[] jdField_a_of_type_ArrayOfCvi = null;
  private int b = 2;
  private int c = 10;
  private int d = 4;
  private int e = 2;
  private int f = this.e;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j;
  
  public cvf(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
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
      this.jdField_a_of_type_ArrayOfCvi = new cvi[this.f];
      while (k < this.jdField_a_of_type_ArrayOfCvi.length)
      {
        this.jdField_a_of_type_ArrayOfCvi[k] = new cvi(this, k);
        this.jdField_a_of_type_ArrayOfCvi[k].start();
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
    if (paramByte2 == 32) {}
    for (paramByte2 = 140;; paramByte2 = a(paramByte1)) {
      return paramString + paramByte2;
    }
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
  private void a(cvh paramcvh)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 199	cvh:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   4: astore 21
    //   6: aload_1
    //   7: getfield 202	cvh:jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   10: astore 23
    //   12: aload_0
    //   13: getfield 63	cvf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   16: aload 21
    //   18: getfield 208	AvatarInfo/QQHeadInfo:uin	J
    //   21: aload 21
    //   23: getfield 211	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   26: invokevirtual 216	com/tencent/mobileqq/app/FriendListHandler:a	(JLjava/lang/String;)Ljava/lang/String;
    //   29: astore 20
    //   31: iconst_0
    //   32: istore 10
    //   34: iconst_0
    //   35: istore 12
    //   37: iconst_0
    //   38: istore 9
    //   40: aload 21
    //   42: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   45: astore_1
    //   46: iconst_0
    //   47: istore_3
    //   48: iconst_0
    //   49: istore 6
    //   51: iconst_0
    //   52: istore 5
    //   54: iconst_0
    //   55: istore 4
    //   57: aload_0
    //   58: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: invokevirtual 222	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   64: invokevirtual 228	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   67: astore 22
    //   69: iload 12
    //   71: istore 11
    //   73: aload 21
    //   75: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   78: ifnull +2562 -> 2640
    //   81: iload 12
    //   83: istore 11
    //   85: ldc 230
    //   87: aload 21
    //   89: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   92: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifne +2545 -> 2640
    //   98: iload 12
    //   100: istore 11
    //   102: aload 21
    //   104: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   107: iconst_4
    //   108: if_icmpne +1082 -> 1190
    //   111: iload 12
    //   113: istore 11
    //   115: new 128	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   122: ldc 241
    //   124: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 20
    //   129: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore 17
    //   137: iload 12
    //   139: istore 11
    //   141: aload 22
    //   143: ldc 243
    //   145: aload 17
    //   147: invokevirtual 248	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   150: checkcast 243	com/tencent/mobileqq/data/Setting
    //   153: astore 18
    //   155: aload 18
    //   157: ifnonnull +2467 -> 2624
    //   160: iload 12
    //   162: istore 11
    //   164: new 243	com/tencent/mobileqq/data/Setting
    //   167: dup
    //   168: invokespecial 249	com/tencent/mobileqq/data/Setting:<init>	()V
    //   171: astore 18
    //   173: iload 12
    //   175: istore 11
    //   177: aload 18
    //   179: aload 17
    //   181: putfield 251	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   184: iconst_1
    //   185: istore 10
    //   187: iconst_0
    //   188: istore_2
    //   189: iload 10
    //   191: istore 11
    //   193: aload 18
    //   195: aload 21
    //   197: getfield 254	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   200: putfield 257	com/tencent/mobileqq/data/Setting:bFaceFlags	B
    //   203: iload 10
    //   205: istore 11
    //   207: aload 18
    //   209: aload 21
    //   211: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   214: putfield 260	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   217: iload 10
    //   219: istore 11
    //   221: aload 18
    //   223: aload 21
    //   225: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   228: putfield 263	com/tencent/mobileqq/data/Setting:url	Ljava/lang/String;
    //   231: iload 10
    //   233: istore 11
    //   235: aload 18
    //   237: invokestatic 269	java/lang/System:currentTimeMillis	()J
    //   240: putfield 272	com/tencent/mobileqq/data/Setting:updateTimestamp	J
    //   243: iload 10
    //   245: istore 11
    //   247: aload 21
    //   249: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   252: ifne +999 -> 1251
    //   255: iload 10
    //   257: istore 11
    //   259: aload 18
    //   261: iconst_0
    //   262: putfield 278	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   265: iload 10
    //   267: istore 9
    //   269: iload 10
    //   271: ifne +136 -> 407
    //   274: iload 10
    //   276: istore 11
    //   278: aload 18
    //   280: getfield 281	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   283: aload 21
    //   285: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   288: if_icmpeq +1266 -> 1554
    //   291: iconst_1
    //   292: istore 10
    //   294: iload 10
    //   296: istore 9
    //   298: iload 10
    //   300: ifeq +107 -> 407
    //   303: iload 10
    //   305: istore 9
    //   307: iload 10
    //   309: istore 11
    //   311: aload 18
    //   313: getfield 281	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   316: iconst_1
    //   317: if_icmpne +90 -> 407
    //   320: iload 10
    //   322: istore 9
    //   324: iload 10
    //   326: istore 11
    //   328: aload 21
    //   330: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   333: ifne +74 -> 407
    //   336: iload 10
    //   338: istore 11
    //   340: new 283	java/io/File
    //   343: dup
    //   344: aload_0
    //   345: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   348: aload 18
    //   350: getfield 260	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   353: aload 20
    //   355: aload 21
    //   357: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   360: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   363: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   366: astore 17
    //   368: iload 10
    //   370: istore 9
    //   372: aload 17
    //   374: ifnull +33 -> 407
    //   377: iload 10
    //   379: istore 9
    //   381: iload 10
    //   383: istore 11
    //   385: aload 17
    //   387: invokevirtual 295	java/io/File:exists	()Z
    //   390: ifeq +17 -> 407
    //   393: iload 10
    //   395: istore 11
    //   397: aload 17
    //   399: invokevirtual 298	java/io/File:delete	()Z
    //   402: pop
    //   403: iload 10
    //   405: istore 9
    //   407: aload 18
    //   409: aload 21
    //   411: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   414: putfield 281	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   417: aload 18
    //   419: aload 21
    //   421: getfield 302	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   424: putfield 303	com/tencent/mobileqq/data/Setting:systemHeadID	S
    //   427: aload 18
    //   429: aload 21
    //   431: getfield 306	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   434: putfield 309	com/tencent/mobileqq/data/Setting:headImgTimestamp	J
    //   437: aload_0
    //   438: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   441: aload 18
    //   443: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;)V
    //   446: iload_2
    //   447: ifeq +1188 -> 1635
    //   450: aload 22
    //   452: aload 18
    //   454: invokevirtual 315	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   457: pop
    //   458: aload_0
    //   459: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   462: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   465: invokevirtual 321	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   468: invokestatic 325	com/tencent/mobileqq/utils/ContactConfig:a	(Landroid/content/Context;)Z
    //   471: ifeq +109 -> 580
    //   474: invokestatic 329	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   477: ifeq +103 -> 580
    //   480: getstatic 39	cvf:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   483: astore 17
    //   485: aload 17
    //   487: monitorenter
    //   488: aload_0
    //   489: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   492: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   495: invokevirtual 321	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   498: invokestatic 325	com/tencent/mobileqq/utils/ContactConfig:a	(Landroid/content/Context;)Z
    //   501: ifeq +62 -> 563
    //   504: invokestatic 329	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   507: istore 10
    //   509: iload 10
    //   511: ifeq +52 -> 563
    //   514: new 128	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   521: getstatic 331	com/tencent/mobileqq/util/SystemUtil:a	Ljava/lang/String;
    //   524: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 333
    //   530: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: new 128	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   543: getstatic 338	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   546: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 333
    //   552: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: iconst_1
    //   559: invokestatic 343	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)I
    //   562: pop
    //   563: aload_0
    //   564: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   567: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   570: invokevirtual 321	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   573: iconst_0
    //   574: invokestatic 346	com/tencent/mobileqq/utils/ContactConfig:a	(Landroid/content/Context;Z)V
    //   577: aload 17
    //   579: monitorexit
    //   580: aload_0
    //   581: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   584: aload 21
    //   586: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   589: aload 20
    //   591: aload 21
    //   593: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   596: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   599: astore 17
    //   601: new 283	java/io/File
    //   604: dup
    //   605: aload 17
    //   607: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   610: astore 24
    //   612: iload 9
    //   614: ifne +1076 -> 1690
    //   617: aload 24
    //   619: invokevirtual 295	java/io/File:exists	()Z
    //   622: istore 10
    //   624: iload 10
    //   626: ifne +1058 -> 1684
    //   629: iconst_1
    //   630: istore 9
    //   632: iconst_0
    //   633: istore 10
    //   635: iload 9
    //   637: istore 11
    //   639: iload 10
    //   641: istore 9
    //   643: iload 11
    //   645: ifeq +1962 -> 2607
    //   648: aload_0
    //   649: aload 21
    //   651: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   654: aload 21
    //   656: getfield 254	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   659: aload 21
    //   661: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   664: invokespecial 348	cvf:a	(Ljava/lang/String;BB)Ljava/lang/String;
    //   667: astore 19
    //   669: aload 19
    //   671: astore_1
    //   672: ldc_w 350
    //   675: aload 19
    //   677: invokestatic 356	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   680: astore 19
    //   682: aload 19
    //   684: astore_1
    //   685: aload 21
    //   687: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   690: bipush 32
    //   692: if_icmpne +1909 -> 2601
    //   695: aload 19
    //   697: astore_1
    //   698: new 128	java/lang/StringBuilder
    //   701: dup
    //   702: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   705: aload 19
    //   707: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: ldc_w 358
    //   713: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokestatic 269	java/lang/System:currentTimeMillis	()J
    //   719: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   722: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: astore 19
    //   727: aload 19
    //   729: astore_1
    //   730: aload 21
    //   732: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   735: ifne +1100 -> 1835
    //   738: aload 21
    //   740: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   743: istore_2
    //   744: iload_2
    //   745: iconst_4
    //   746: if_icmpne +1089 -> 1835
    //   749: aload 24
    //   751: invokevirtual 295	java/io/File:exists	()Z
    //   754: ifne +14 -> 768
    //   757: aload_0
    //   758: aload 21
    //   760: getfield 302	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   763: aload 24
    //   765: invokespecial 363	cvf:a	(ILjava/io/File;)V
    //   768: iconst_1
    //   769: istore 9
    //   771: iload 6
    //   773: istore_2
    //   774: iload 9
    //   776: ifeq +1603 -> 2379
    //   779: iload 9
    //   781: istore 12
    //   783: iload 4
    //   785: istore 6
    //   787: aload 21
    //   789: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   792: bipush 32
    //   794: if_icmpne +1478 -> 2272
    //   797: iload 9
    //   799: istore 12
    //   801: iload 4
    //   803: istore 6
    //   805: new 128	java/lang/StringBuilder
    //   808: dup
    //   809: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   812: ldc_w 365
    //   815: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: aload 21
    //   820: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   823: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   826: ldc_w 367
    //   829: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: aload 20
    //   834: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: astore 19
    //   842: iload 9
    //   844: istore 12
    //   846: iload 4
    //   848: istore 6
    //   850: aload 19
    //   852: invokestatic 372	com/tencent/mobileqq/util/ProfileCardUtil:a	(Ljava/lang/String;)Z
    //   855: pop
    //   856: iload 9
    //   858: istore 12
    //   860: iload 4
    //   862: istore 6
    //   864: aload_0
    //   865: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   868: aload 19
    //   870: invokestatic 375	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   873: iload 9
    //   875: istore 12
    //   877: iload 4
    //   879: istore 6
    //   881: aload 21
    //   883: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   886: iconst_4
    //   887: if_icmpne +1419 -> 2306
    //   890: iload 9
    //   892: istore 12
    //   894: iload 4
    //   896: istore 6
    //   898: aload_0
    //   899: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   902: iconst_4
    //   903: aload 20
    //   905: aload 21
    //   907: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   910: invokevirtual 378	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)V
    //   913: iload_2
    //   914: istore_3
    //   915: iload 4
    //   917: istore_2
    //   918: iload 9
    //   920: ifeq +34 -> 954
    //   923: aload 21
    //   925: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   928: bipush 11
    //   930: if_icmpne +1457 -> 2387
    //   933: aload_0
    //   934: getfield 63	cvf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   937: aload 23
    //   939: bipush 39
    //   941: iconst_1
    //   942: iconst_1
    //   943: anewarray 4	java/lang/Object
    //   946: dup
    //   947: iconst_0
    //   948: aload 20
    //   950: aastore
    //   951: invokevirtual 381	com/tencent/mobileqq/app/FriendListHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;IZLjava/lang/Object;)V
    //   954: aload_0
    //   955: getfield 63	cvf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   958: bipush 45
    //   960: iconst_1
    //   961: aload 18
    //   963: invokevirtual 384	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   966: new 128	java/lang/StringBuilder
    //   969: dup
    //   970: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   973: aload 21
    //   975: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   978: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   981: ldc_w 367
    //   984: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: aload 20
    //   989: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: astore 18
    //   997: aload 21
    //   999: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1002: bipush 32
    //   1004: if_icmpne +43 -> 1047
    //   1007: new 128	java/lang/StringBuilder
    //   1010: dup
    //   1011: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1014: ldc_w 365
    //   1017: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: aload 21
    //   1022: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   1025: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1028: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: ldc_w 367
    //   1034: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: aload 20
    //   1039: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: astore 18
    //   1047: aload_0
    //   1048: getfield 63	cvf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1051: aload 18
    //   1053: iconst_1
    //   1054: invokevirtual 391	com/tencent/mobileqq/app/FriendListHandler:c	(Ljava/lang/String;Z)V
    //   1057: aload 22
    //   1059: invokevirtual 393	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1062: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1065: ifeq +124 -> 1189
    //   1068: ldc 11
    //   1070: iconst_2
    //   1071: new 128	java/lang/StringBuilder
    //   1074: dup
    //   1075: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1078: ldc_w 395
    //   1081: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: iload 9
    //   1086: invokevirtual 398	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1089: ldc_w 400
    //   1092: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: iload_3
    //   1096: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1099: ldc_w 402
    //   1102: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: aload 21
    //   1107: getfield 208	AvatarInfo/QQHeadInfo:uin	J
    //   1110: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1113: ldc_w 404
    //   1116: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: iload 11
    //   1121: invokevirtual 398	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1124: ldc_w 406
    //   1127: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: aload 21
    //   1132: getfield 211	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   1135: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: ldc_w 408
    //   1141: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: aload 21
    //   1146: getfield 302	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   1149: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1152: ldc_w 410
    //   1155: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: iload_2
    //   1159: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1162: ldc_w 412
    //   1165: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: aload 17
    //   1170: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: ldc_w 414
    //   1176: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1179: aload_1
    //   1180: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1189: return
    //   1190: iload 12
    //   1192: istore 11
    //   1194: aload 21
    //   1196: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1199: bipush 32
    //   1201: if_icmpne +1432 -> 2633
    //   1204: iload 12
    //   1206: istore 11
    //   1208: new 128	java/lang/StringBuilder
    //   1211: dup
    //   1212: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1215: ldc_w 365
    //   1218: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: aload 21
    //   1223: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   1226: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1229: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: ldc_w 367
    //   1235: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: aload 20
    //   1240: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1246: astore 17
    //   1248: goto -1111 -> 137
    //   1251: iload 10
    //   1253: istore 11
    //   1255: aload 21
    //   1257: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1260: iconst_1
    //   1261: if_icmpne +276 -> 1537
    //   1264: iload 10
    //   1266: istore 11
    //   1268: aload_0
    //   1269: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1272: bipush 8
    //   1274: invokevirtual 418	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1277: checkcast 420	com/tencent/mobileqq/model/FriendManager
    //   1280: aload 18
    //   1282: getfield 251	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   1285: invokestatic 423	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1288: invokeinterface 426 2 0
    //   1293: ifnonnull +133 -> 1426
    //   1296: iload 10
    //   1298: istore 11
    //   1300: aload 18
    //   1302: aload 21
    //   1304: getfield 429	AvatarInfo/QQHeadInfo:soruceType	B
    //   1307: putfield 278	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   1310: goto -1045 -> 265
    //   1313: astore 17
    //   1315: iconst_0
    //   1316: istore 9
    //   1318: aconst_null
    //   1319: astore 17
    //   1321: iconst_0
    //   1322: istore_2
    //   1323: new 128	java/lang/StringBuilder
    //   1326: dup
    //   1327: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1330: aload 21
    //   1332: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1335: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1338: ldc_w 367
    //   1341: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: aload 20
    //   1346: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1352: astore 18
    //   1354: aload 21
    //   1356: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1359: bipush 32
    //   1361: if_icmpne +43 -> 1404
    //   1364: new 128	java/lang/StringBuilder
    //   1367: dup
    //   1368: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1371: ldc_w 365
    //   1374: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1377: aload 21
    //   1379: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   1382: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1385: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: ldc_w 367
    //   1391: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: aload 20
    //   1396: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1402: astore 18
    //   1404: aload_0
    //   1405: getfield 63	cvf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1408: aload 18
    //   1410: iconst_1
    //   1411: invokevirtual 391	com/tencent/mobileqq/app/FriendListHandler:c	(Ljava/lang/String;Z)V
    //   1414: aload 22
    //   1416: invokevirtual 393	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1419: sipush 9204
    //   1422: istore_3
    //   1423: goto -361 -> 1062
    //   1426: iload 10
    //   1428: istore 11
    //   1430: aload 18
    //   1432: iconst_0
    //   1433: putfield 278	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   1436: goto -1171 -> 265
    //   1439: astore 17
    //   1441: new 128	java/lang/StringBuilder
    //   1444: dup
    //   1445: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1448: aload 21
    //   1450: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1453: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1456: ldc_w 367
    //   1459: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1462: aload 20
    //   1464: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1470: astore_1
    //   1471: aload 21
    //   1473: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1476: bipush 32
    //   1478: if_icmpne +42 -> 1520
    //   1481: new 128	java/lang/StringBuilder
    //   1484: dup
    //   1485: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1488: ldc_w 365
    //   1491: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: aload 21
    //   1496: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   1499: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1502: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1505: ldc_w 367
    //   1508: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1511: aload 20
    //   1513: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1519: astore_1
    //   1520: aload_0
    //   1521: getfield 63	cvf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1524: aload_1
    //   1525: iconst_1
    //   1526: invokevirtual 391	com/tencent/mobileqq/app/FriendListHandler:c	(Ljava/lang/String;Z)V
    //   1529: aload 22
    //   1531: invokevirtual 393	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1534: aload 17
    //   1536: athrow
    //   1537: iload 10
    //   1539: istore 11
    //   1541: aload 18
    //   1543: aload 21
    //   1545: getfield 429	AvatarInfo/QQHeadInfo:soruceType	B
    //   1548: putfield 278	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   1551: goto -1286 -> 265
    //   1554: iload 10
    //   1556: istore 11
    //   1558: aload 21
    //   1560: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   1563: ifne +26 -> 1589
    //   1566: iload 10
    //   1568: istore 11
    //   1570: aload 18
    //   1572: getfield 303	com/tencent/mobileqq/data/Setting:systemHeadID	S
    //   1575: aload 21
    //   1577: getfield 302	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   1580: if_icmpeq +1084 -> 2664
    //   1583: iconst_1
    //   1584: istore 9
    //   1586: goto +1071 -> 2657
    //   1589: iload 10
    //   1591: istore 11
    //   1593: aload 18
    //   1595: getfield 309	com/tencent/mobileqq/data/Setting:headImgTimestamp	J
    //   1598: lstore 13
    //   1600: iload 10
    //   1602: istore 11
    //   1604: aload 21
    //   1606: getfield 306	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   1609: lstore 15
    //   1611: lload 13
    //   1613: lload 15
    //   1615: lcmp
    //   1616: ifeq +13 -> 1629
    //   1619: iconst_1
    //   1620: istore 9
    //   1622: iload 9
    //   1624: istore 10
    //   1626: goto -1332 -> 294
    //   1629: iconst_0
    //   1630: istore 9
    //   1632: goto -10 -> 1622
    //   1635: aload 22
    //   1637: aload 18
    //   1639: invokevirtual 432	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   1642: goto -1184 -> 458
    //   1645: astore 17
    //   1647: iconst_0
    //   1648: istore 10
    //   1650: iload 9
    //   1652: istore 11
    //   1654: aconst_null
    //   1655: astore 17
    //   1657: iconst_0
    //   1658: istore_2
    //   1659: iload 10
    //   1661: istore 9
    //   1663: goto -340 -> 1323
    //   1666: astore 19
    //   1668: aload 19
    //   1670: invokevirtual 435	java/lang/Exception:printStackTrace	()V
    //   1673: goto -1110 -> 563
    //   1676: astore 18
    //   1678: aload 17
    //   1680: monitorexit
    //   1681: aload 18
    //   1683: athrow
    //   1684: iconst_0
    //   1685: istore 9
    //   1687: goto -1055 -> 632
    //   1690: aload 18
    //   1692: getfield 281	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   1695: ifeq +7 -> 1702
    //   1698: iload_2
    //   1699: ifne +915 -> 2614
    //   1702: aload 24
    //   1704: invokevirtual 295	java/io/File:exists	()Z
    //   1707: ifeq +907 -> 2614
    //   1710: aload 21
    //   1712: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1715: istore_2
    //   1716: iload_2
    //   1717: bipush 32
    //   1719: if_icmpeq +895 -> 2614
    //   1722: iconst_1
    //   1723: istore 9
    //   1725: iconst_0
    //   1726: istore 11
    //   1728: goto -1085 -> 643
    //   1731: astore_1
    //   1732: new 128	java/lang/StringBuilder
    //   1735: dup
    //   1736: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1739: aload 21
    //   1741: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1744: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1747: ldc_w 367
    //   1750: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1753: aload 20
    //   1755: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1758: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1761: astore_1
    //   1762: aload 21
    //   1764: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1767: bipush 32
    //   1769: if_icmpne +42 -> 1811
    //   1772: new 128	java/lang/StringBuilder
    //   1775: dup
    //   1776: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1779: ldc_w 365
    //   1782: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1785: aload 21
    //   1787: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   1790: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1793: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: ldc_w 367
    //   1799: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1802: aload 20
    //   1804: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1807: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1810: astore_1
    //   1811: aload_0
    //   1812: getfield 63	cvf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1815: aload_1
    //   1816: iconst_1
    //   1817: invokevirtual 391	com/tencent/mobileqq/app/FriendListHandler:c	(Ljava/lang/String;Z)V
    //   1820: aload 22
    //   1822: invokevirtual 393	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1825: return
    //   1826: astore 19
    //   1828: sipush 9202
    //   1831: istore_2
    //   1832: goto -1058 -> 774
    //   1835: aload_0
    //   1836: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1839: aload_1
    //   1840: aload 24
    //   1842: invokestatic 440	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)I
    //   1845: istore 7
    //   1847: iload 7
    //   1849: ifne +339 -> 2188
    //   1852: aload 24
    //   1854: invokevirtual 443	java/io/File:length	()J
    //   1857: lstore 13
    //   1859: lload 13
    //   1861: l2i
    //   1862: istore 4
    //   1864: aload_0
    //   1865: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1868: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1871: invokestatic 446	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   1874: invokevirtual 451	android/net/NetworkInfo:getType	()I
    //   1877: istore 6
    //   1879: iconst_0
    //   1880: istore_2
    //   1881: aload 21
    //   1883: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1886: iconst_1
    //   1887: if_icmpne +251 -> 2138
    //   1890: iconst_0
    //   1891: istore_2
    //   1892: aload_0
    //   1893: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1896: aload_0
    //   1897: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1900: invokevirtual 453	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1903: iconst_0
    //   1904: iload 6
    //   1906: ldc_w 454
    //   1909: iload_2
    //   1910: iload 4
    //   1912: bipush 126
    //   1914: iadd
    //   1915: sipush 239
    //   1918: iadd
    //   1919: i2l
    //   1920: invokevirtual 457	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;ZIIIJ)V
    //   1923: iconst_1
    //   1924: istore 10
    //   1926: iload 10
    //   1928: istore 12
    //   1930: iload 5
    //   1932: istore 6
    //   1934: aload 21
    //   1936: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1939: iconst_1
    //   1940: if_icmpeq +53 -> 1993
    //   1943: iload 10
    //   1945: istore 12
    //   1947: iload 5
    //   1949: istore 6
    //   1951: aload 21
    //   1953: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1956: bipush 11
    //   1958: if_icmpeq +35 -> 1993
    //   1961: iload 10
    //   1963: istore 12
    //   1965: iload 5
    //   1967: istore 6
    //   1969: aload 21
    //   1971: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1974: istore 8
    //   1976: iload 10
    //   1978: istore 9
    //   1980: iload 5
    //   1982: istore 4
    //   1984: iload_3
    //   1985: istore_2
    //   1986: iload 8
    //   1988: bipush 32
    //   1990: if_icmpne -1216 -> 774
    //   1993: iload 10
    //   1995: istore 12
    //   1997: iload 5
    //   1999: istore 6
    //   2001: aload 24
    //   2003: invokevirtual 443	java/io/File:length	()J
    //   2006: l2i
    //   2007: istore_2
    //   2008: iload 10
    //   2010: istore 12
    //   2012: iload 5
    //   2014: istore 6
    //   2016: ldc_w 459
    //   2019: iconst_1
    //   2020: new 128	java/lang/StringBuilder
    //   2023: dup
    //   2024: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2027: ldc_w 461
    //   2030: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: aload 21
    //   2035: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2038: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2041: ldc_w 463
    //   2044: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2047: iload 7
    //   2049: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2052: ldc_w 465
    //   2055: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2058: aload_1
    //   2059: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2062: ldc_w 467
    //   2065: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2068: iload_2
    //   2069: bipush 126
    //   2071: iadd
    //   2072: sipush 239
    //   2075: iadd
    //   2076: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2079: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2082: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2085: iload 10
    //   2087: istore 9
    //   2089: iload 5
    //   2091: istore 4
    //   2093: iload_3
    //   2094: istore_2
    //   2095: goto -1321 -> 774
    //   2098: astore 19
    //   2100: iload 10
    //   2102: istore 12
    //   2104: iload 5
    //   2106: istore 6
    //   2108: aload 19
    //   2110: invokevirtual 435	java/lang/Exception:printStackTrace	()V
    //   2113: iload 10
    //   2115: istore 9
    //   2117: iload 5
    //   2119: istore 4
    //   2121: iload_3
    //   2122: istore_2
    //   2123: goto -1349 -> 774
    //   2126: astore 18
    //   2128: iload 12
    //   2130: istore 9
    //   2132: iload 6
    //   2134: istore_2
    //   2135: goto -812 -> 1323
    //   2138: aload 21
    //   2140: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2143: iconst_4
    //   2144: if_icmpne +8 -> 2152
    //   2147: iconst_1
    //   2148: istore_2
    //   2149: goto -257 -> 1892
    //   2152: aload 21
    //   2154: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2157: bipush 11
    //   2159: if_icmpne +8 -> 2167
    //   2162: iconst_3
    //   2163: istore_2
    //   2164: goto -272 -> 1892
    //   2167: aload 21
    //   2169: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2172: istore 8
    //   2174: iload 8
    //   2176: bipush 32
    //   2178: if_icmpne -286 -> 1892
    //   2181: sipush 1003
    //   2184: istore_2
    //   2185: goto -293 -> 1892
    //   2188: iload 7
    //   2190: tableswitch	default:+34 -> 2224, 1:+49->2239, 2:+34->2224, 3:+34->2224, 4:+60->2250, 5:+71->2261
    //   2225: fload_1
    //   2226: <illegal opcode>
    //   2227: istore_3
    //   2228: iload 7
    //   2230: istore 5
    //   2232: iload 9
    //   2234: istore 10
    //   2236: goto -310 -> 1926
    //   2239: sipush 9206
    //   2242: istore_3
    //   2243: iload 9
    //   2245: istore 10
    //   2247: goto -321 -> 1926
    //   2250: sipush 9202
    //   2253: istore_3
    //   2254: iload 9
    //   2256: istore 10
    //   2258: goto -332 -> 1926
    //   2261: sipush 9204
    //   2264: istore_3
    //   2265: iload 9
    //   2267: istore 10
    //   2269: goto -343 -> 1926
    //   2272: iload 9
    //   2274: istore 12
    //   2276: iload 4
    //   2278: istore 6
    //   2280: aload 20
    //   2282: invokestatic 372	com/tencent/mobileqq/util/ProfileCardUtil:a	(Ljava/lang/String;)Z
    //   2285: pop
    //   2286: iload 9
    //   2288: istore 12
    //   2290: iload 4
    //   2292: istore 6
    //   2294: aload_0
    //   2295: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2298: aload 20
    //   2300: invokestatic 375	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   2303: goto -1430 -> 873
    //   2306: iload 9
    //   2308: istore 12
    //   2310: iload 4
    //   2312: istore 6
    //   2314: aload 21
    //   2316: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2319: bipush 32
    //   2321: if_icmpne +35 -> 2356
    //   2324: iload 9
    //   2326: istore 12
    //   2328: iload 4
    //   2330: istore 6
    //   2332: aload_0
    //   2333: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2336: bipush 32
    //   2338: aload 20
    //   2340: aload 21
    //   2342: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   2345: invokevirtual 378	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)V
    //   2348: iload_2
    //   2349: istore_3
    //   2350: iload 4
    //   2352: istore_2
    //   2353: goto -1435 -> 918
    //   2356: iload 9
    //   2358: istore 12
    //   2360: iload 4
    //   2362: istore 6
    //   2364: aload_0
    //   2365: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2368: iconst_1
    //   2369: aload 20
    //   2371: aload 21
    //   2373: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   2376: invokevirtual 378	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)V
    //   2379: iload_2
    //   2380: istore_3
    //   2381: iload 4
    //   2383: istore_2
    //   2384: goto -1466 -> 918
    //   2387: aload 21
    //   2389: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2392: iconst_4
    //   2393: if_icmpne +35 -> 2428
    //   2396: aload_0
    //   2397: getfield 63	cvf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   2400: bipush 30
    //   2402: iconst_1
    //   2403: iconst_1
    //   2404: anewarray 4	java/lang/Object
    //   2407: dup
    //   2408: iconst_0
    //   2409: aload 20
    //   2411: aastore
    //   2412: invokevirtual 384	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   2415: aload_0
    //   2416: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2419: aload 20
    //   2421: iconst_4
    //   2422: invokevirtual 470	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;I)V
    //   2425: goto -1471 -> 954
    //   2428: aload 21
    //   2430: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2433: bipush 32
    //   2435: if_icmpne +91 -> 2526
    //   2438: sipush 3000
    //   2441: istore 5
    //   2443: iload 5
    //   2445: istore 4
    //   2447: aload 21
    //   2449: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   2452: tableswitch	default:+223 -> 2675, 200:+230->2682, 201:+36->2488, 202:+238->2690, 203:+36->2488, 204:+246->2698
    //   2489: getfield 63	cvf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   2492: aload 23
    //   2494: iconst_5
    //   2495: iconst_1
    //   2496: iconst_3
    //   2497: anewarray 4	java/lang/Object
    //   2500: dup
    //   2501: iconst_0
    //   2502: aload 20
    //   2504: aastore
    //   2505: dup
    //   2506: iconst_1
    //   2507: iload 4
    //   2509: invokestatic 475	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2512: aastore
    //   2513: dup
    //   2514: iconst_2
    //   2515: iconst_1
    //   2516: invokestatic 480	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2519: aastore
    //   2520: invokevirtual 381	com/tencent/mobileqq/app/FriendListHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;IZLjava/lang/Object;)V
    //   2523: goto -1569 -> 954
    //   2526: aload_0
    //   2527: getfield 61	cvf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2530: aload 20
    //   2532: iconst_1
    //   2533: invokevirtual 470	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;I)V
    //   2536: aload_0
    //   2537: getfield 63	cvf:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   2540: aload 23
    //   2542: iconst_4
    //   2543: iconst_1
    //   2544: iconst_1
    //   2545: anewarray 4	java/lang/Object
    //   2548: dup
    //   2549: iconst_0
    //   2550: aload 20
    //   2552: aastore
    //   2553: invokevirtual 381	com/tencent/mobileqq/app/FriendListHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;IZLjava/lang/Object;)V
    //   2556: goto -1602 -> 954
    //   2559: astore 18
    //   2561: iconst_0
    //   2562: istore 10
    //   2564: iload 9
    //   2566: istore 11
    //   2568: iconst_0
    //   2569: istore_2
    //   2570: iload 10
    //   2572: istore 9
    //   2574: goto -1251 -> 1323
    //   2577: astore 18
    //   2579: iconst_0
    //   2580: istore_2
    //   2581: goto -1258 -> 1323
    //   2584: astore 18
    //   2586: iconst_0
    //   2587: istore_2
    //   2588: goto -1265 -> 1323
    //   2591: astore 18
    //   2593: iconst_0
    //   2594: istore_2
    //   2595: iconst_1
    //   2596: istore 9
    //   2598: goto -1275 -> 1323
    //   2601: aload 19
    //   2603: astore_1
    //   2604: goto -1874 -> 730
    //   2607: iconst_0
    //   2608: istore_3
    //   2609: iconst_0
    //   2610: istore_2
    //   2611: goto -1693 -> 918
    //   2614: iload 9
    //   2616: istore 11
    //   2618: iconst_0
    //   2619: istore 9
    //   2621: goto -1978 -> 643
    //   2624: iconst_1
    //   2625: istore_2
    //   2626: iload 9
    //   2628: istore 10
    //   2630: goto -2441 -> 189
    //   2633: aload 20
    //   2635: astore 17
    //   2637: goto -2500 -> 137
    //   2640: iconst_0
    //   2641: istore_2
    //   2642: aconst_null
    //   2643: astore 17
    //   2645: iconst_0
    //   2646: istore 9
    //   2648: iconst_0
    //   2649: istore_3
    //   2650: iload 10
    //   2652: istore 11
    //   2654: goto -1688 -> 966
    //   2657: iload 9
    //   2659: istore 10
    //   2661: goto -2367 -> 294
    //   2664: iconst_0
    //   2665: istore 9
    //   2667: goto -10 -> 2657
    //   2670: astore 18
    //   2672: goto -1349 -> 1323
    //   2675: iload 5
    //   2677: istore 4
    //   2679: goto -191 -> 2488
    //   2682: sipush 3000
    //   2685: istore 4
    //   2687: goto -199 -> 2488
    //   2690: sipush 3001
    //   2693: istore 4
    //   2695: goto -207 -> 2488
    //   2698: sipush 3002
    //   2701: istore 4
    //   2703: goto -215 -> 2488
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2706	0	this	cvf
    //   0	2706	1	paramcvh	cvh
    //   188	2454	2	k	int
    //   47	2603	3	m	int
    //   55	2647	4	n	int
    //   52	2624	5	i1	int
    //   49	2314	6	i2	int
    //   1845	384	7	i3	int
    //   1974	205	8	i4	int
    //   38	2628	9	bool1	boolean
    //   32	2628	10	bool2	boolean
    //   71	2582	11	bool3	boolean
    //   35	2324	12	bool4	boolean
    //   1598	262	13	l1	long
    //   1609	5	15	l2	long
    //   135	1112	17	localObject1	Object
    //   1313	1	17	localThrowable1	java.lang.Throwable
    //   1319	1	17	localObject2	Object
    //   1439	96	17	localObject3	Object
    //   1645	1	17	localThrowable2	java.lang.Throwable
    //   1655	989	17	str1	String
    //   153	1485	18	localObject4	Object
    //   1676	15	18	localObject5	Object
    //   2126	1	18	localThrowable3	java.lang.Throwable
    //   2559	1	18	localThrowable4	java.lang.Throwable
    //   2577	1	18	localThrowable5	java.lang.Throwable
    //   2584	1	18	localThrowable6	java.lang.Throwable
    //   2591	1	18	localThrowable7	java.lang.Throwable
    //   2670	1	18	localThrowable8	java.lang.Throwable
    //   667	202	19	str2	String
    //   1666	3	19	localException1	java.lang.Exception
    //   1826	1	19	localException2	java.lang.Exception
    //   2098	504	19	localException3	java.lang.Exception
    //   29	2605	20	str3	String
    //   4	2444	21	localQQHeadInfo	QQHeadInfo
    //   67	1754	22	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   10	2531	23	localToServiceMsg	ToServiceMsg
    //   610	1392	24	localFile	File
    // Exception table:
    //   from	to	target	type
    //   73	81	1313	java/lang/Throwable
    //   85	98	1313	java/lang/Throwable
    //   102	111	1313	java/lang/Throwable
    //   115	137	1313	java/lang/Throwable
    //   141	155	1313	java/lang/Throwable
    //   164	173	1313	java/lang/Throwable
    //   177	184	1313	java/lang/Throwable
    //   193	203	1313	java/lang/Throwable
    //   207	217	1313	java/lang/Throwable
    //   221	231	1313	java/lang/Throwable
    //   235	243	1313	java/lang/Throwable
    //   247	255	1313	java/lang/Throwable
    //   259	265	1313	java/lang/Throwable
    //   278	291	1313	java/lang/Throwable
    //   311	320	1313	java/lang/Throwable
    //   328	336	1313	java/lang/Throwable
    //   340	368	1313	java/lang/Throwable
    //   385	393	1313	java/lang/Throwable
    //   397	403	1313	java/lang/Throwable
    //   1194	1204	1313	java/lang/Throwable
    //   1208	1248	1313	java/lang/Throwable
    //   1255	1264	1313	java/lang/Throwable
    //   1268	1296	1313	java/lang/Throwable
    //   1300	1310	1313	java/lang/Throwable
    //   1430	1436	1313	java/lang/Throwable
    //   1541	1551	1313	java/lang/Throwable
    //   1558	1566	1313	java/lang/Throwable
    //   1570	1583	1313	java/lang/Throwable
    //   1593	1600	1313	java/lang/Throwable
    //   1604	1611	1313	java/lang/Throwable
    //   73	81	1439	finally
    //   85	98	1439	finally
    //   102	111	1439	finally
    //   115	137	1439	finally
    //   141	155	1439	finally
    //   164	173	1439	finally
    //   177	184	1439	finally
    //   193	203	1439	finally
    //   207	217	1439	finally
    //   221	231	1439	finally
    //   235	243	1439	finally
    //   247	255	1439	finally
    //   259	265	1439	finally
    //   278	291	1439	finally
    //   311	320	1439	finally
    //   328	336	1439	finally
    //   340	368	1439	finally
    //   385	393	1439	finally
    //   397	403	1439	finally
    //   407	446	1439	finally
    //   450	458	1439	finally
    //   458	488	1439	finally
    //   580	601	1439	finally
    //   601	612	1439	finally
    //   617	624	1439	finally
    //   648	669	1439	finally
    //   672	682	1439	finally
    //   685	695	1439	finally
    //   698	727	1439	finally
    //   730	744	1439	finally
    //   749	768	1439	finally
    //   787	797	1439	finally
    //   805	842	1439	finally
    //   850	856	1439	finally
    //   864	873	1439	finally
    //   881	890	1439	finally
    //   898	913	1439	finally
    //   923	954	1439	finally
    //   954	966	1439	finally
    //   1194	1204	1439	finally
    //   1208	1248	1439	finally
    //   1255	1264	1439	finally
    //   1268	1296	1439	finally
    //   1300	1310	1439	finally
    //   1430	1436	1439	finally
    //   1541	1551	1439	finally
    //   1558	1566	1439	finally
    //   1570	1583	1439	finally
    //   1593	1600	1439	finally
    //   1604	1611	1439	finally
    //   1635	1642	1439	finally
    //   1681	1684	1439	finally
    //   1690	1698	1439	finally
    //   1702	1716	1439	finally
    //   1835	1847	1439	finally
    //   1852	1859	1439	finally
    //   1864	1879	1439	finally
    //   1881	1890	1439	finally
    //   1892	1923	1439	finally
    //   1934	1943	1439	finally
    //   1951	1961	1439	finally
    //   1969	1976	1439	finally
    //   2001	2008	1439	finally
    //   2016	2085	1439	finally
    //   2108	2113	1439	finally
    //   2138	2147	1439	finally
    //   2152	2162	1439	finally
    //   2167	2174	1439	finally
    //   2280	2286	1439	finally
    //   2294	2303	1439	finally
    //   2314	2324	1439	finally
    //   2332	2348	1439	finally
    //   2364	2379	1439	finally
    //   2387	2425	1439	finally
    //   2428	2438	1439	finally
    //   2447	2488	1439	finally
    //   2488	2523	1439	finally
    //   2526	2556	1439	finally
    //   407	446	1645	java/lang/Throwable
    //   450	458	1645	java/lang/Throwable
    //   458	488	1645	java/lang/Throwable
    //   580	601	1645	java/lang/Throwable
    //   1635	1642	1645	java/lang/Throwable
    //   1681	1684	1645	java/lang/Throwable
    //   514	563	1666	java/lang/Exception
    //   488	509	1676	finally
    //   514	563	1676	finally
    //   563	580	1676	finally
    //   1668	1673	1676	finally
    //   1678	1681	1676	finally
    //   580	601	1731	java/lang/Exception
    //   601	612	1731	java/lang/Exception
    //   617	624	1731	java/lang/Exception
    //   1690	1698	1731	java/lang/Exception
    //   1702	1716	1731	java/lang/Exception
    //   749	768	1826	java/lang/Exception
    //   2001	2008	2098	java/lang/Exception
    //   2016	2085	2098	java/lang/Exception
    //   787	797	2126	java/lang/Throwable
    //   805	842	2126	java/lang/Throwable
    //   850	856	2126	java/lang/Throwable
    //   864	873	2126	java/lang/Throwable
    //   881	890	2126	java/lang/Throwable
    //   898	913	2126	java/lang/Throwable
    //   1934	1943	2126	java/lang/Throwable
    //   1951	1961	2126	java/lang/Throwable
    //   1969	1976	2126	java/lang/Throwable
    //   2001	2008	2126	java/lang/Throwable
    //   2016	2085	2126	java/lang/Throwable
    //   2108	2113	2126	java/lang/Throwable
    //   2280	2286	2126	java/lang/Throwable
    //   2294	2303	2126	java/lang/Throwable
    //   2314	2324	2126	java/lang/Throwable
    //   2332	2348	2126	java/lang/Throwable
    //   2364	2379	2126	java/lang/Throwable
    //   601	612	2559	java/lang/Throwable
    //   617	624	2559	java/lang/Throwable
    //   1690	1698	2559	java/lang/Throwable
    //   1702	1716	2559	java/lang/Throwable
    //   648	669	2577	java/lang/Throwable
    //   672	682	2577	java/lang/Throwable
    //   685	695	2577	java/lang/Throwable
    //   698	727	2577	java/lang/Throwable
    //   730	744	2584	java/lang/Throwable
    //   749	768	2584	java/lang/Throwable
    //   1835	1847	2584	java/lang/Throwable
    //   1852	1859	2584	java/lang/Throwable
    //   1864	1879	2591	java/lang/Throwable
    //   1881	1890	2591	java/lang/Throwable
    //   1892	1923	2591	java/lang/Throwable
    //   2138	2147	2591	java/lang/Throwable
    //   2152	2162	2591	java/lang/Throwable
    //   2167	2174	2591	java/lang/Throwable
    //   923	954	2670	java/lang/Throwable
    //   954	966	2670	java/lang/Throwable
    //   2387	2425	2670	java/lang/Throwable
    //   2428	2438	2670	java/lang/Throwable
    //   2447	2488	2670	java/lang/Throwable
    //   2488	2523	2670	java/lang/Throwable
    //   2526	2556	2670	java/lang/Throwable
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
    while (k < this.jdField_a_of_type_ArrayOfCvi.length)
    {
      if (this.jdField_a_of_type_ArrayOfCvi[k] != null) {
        this.jdField_a_of_type_ArrayOfCvi[k].a();
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
      if (this.jdField_a_of_type_ArrayOfCvi[k] == null)
      {
        this.jdField_a_of_type_ArrayOfCvi[k] = new cvi(this, k);
        this.jdField_a_of_type_ArrayOfCvi[k].start();
        this.h += 1;
      }
      k += 1;
      continue;
      paramInt = this.f;
      continue;
      if ((paramInt > 0) && (paramInt != this.f))
      {
        cvi[] arrayOfcvi = new cvi[paramInt];
        m = 0;
        k = n;
        n = k;
        if (m < this.jdField_a_of_type_ArrayOfCvi.length)
        {
          if ((this.jdField_a_of_type_ArrayOfCvi[m] != null) && (k < paramInt))
          {
            arrayOfcvi[k] = this.jdField_a_of_type_ArrayOfCvi[m];
            arrayOfcvi[k].a(k);
            n = k + 1;
          }
          for (;;)
          {
            m += 1;
            k = n;
            break;
            n = k;
            if (this.jdField_a_of_type_ArrayOfCvi[m] != null)
            {
              this.jdField_a_of_type_ArrayOfCvi[m].a();
              n = k;
            }
          }
        }
        while (n < paramInt)
        {
          arrayOfcvi[n] = new cvi(this, n);
          arrayOfcvi[n].start();
          this.h += 1;
          n += 1;
        }
        this.f = paramInt;
        this.jdField_a_of_type_ArrayOfCvi = arrayOfcvi;
      }
    }
  }
  
  public boolean a(QQHeadInfo arg1, ToServiceMsg paramToServiceMsg)
  {
    cvh localcvh = new cvh(this, null);
    localcvh.jdField_a_of_type_AvatarInfoQQHeadInfo = ???;
    localcvh.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
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
        this.jdField_a_of_type_JavaUtilArrayList.add(localcvh);
        this.jdField_a_of_type_JavaUtilArrayList.notify();
        return false;
        label228:
        k = this.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cvf
 * JD-Core Version:    0.7.0.1
 */