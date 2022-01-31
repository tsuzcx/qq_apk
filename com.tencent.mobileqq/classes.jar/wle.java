import android.content.Context;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.bless.BlessMtaReport;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Properties;

public class wle
  extends AsyncTask
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  long jdField_b_of_type_Long = 0L;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  
  public wle(QQAppInterface paramQQAppInterface, Context paramContext, ArrayList paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  protected Integer a(java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +11 -> 16
    //   8: ldc 47
    //   10: iconst_2
    //   11: ldc 49
    //   13: invokestatic 53	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: invokestatic 58	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   19: astore 5
    //   21: aload 5
    //   23: monitorenter
    //   24: invokestatic 58	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   27: invokevirtual 63	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   30: ifne +69 -> 99
    //   33: invokestatic 69	android/os/SystemClock:elapsedRealtime	()J
    //   36: lstore_2
    //   37: invokestatic 58	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   40: invokestatic 71	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:a	()J
    //   43: invokevirtual 77	java/lang/Object:wait	(J)V
    //   46: invokestatic 69	android/os/SystemClock:elapsedRealtime	()J
    //   49: lload_2
    //   50: lsub
    //   51: invokestatic 80	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	(J)J
    //   54: pop2
    //   55: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +41 -> 99
    //   61: ldc 47
    //   63: iconst_2
    //   64: new 82	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   71: ldc 85
    //   73: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokestatic 91	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()J
    //   79: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc 96
    //   84: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokestatic 99	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:a	()I
    //   90: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload 5
    //   101: monitorexit
    //   102: invokestatic 91	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()J
    //   105: invokestatic 71	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:a	()J
    //   108: lcmp
    //   109: iflt +57 -> 166
    //   112: bipush 9
    //   114: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: areturn
    //   118: astore 6
    //   120: aload 5
    //   122: monitorexit
    //   123: aload 6
    //   125: athrow
    //   126: astore 5
    //   128: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq -29 -> 102
    //   134: ldc 47
    //   136: iconst_2
    //   137: new 82	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   144: ldc 117
    //   146: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 5
    //   151: invokevirtual 120	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: goto -61 -> 102
    //   166: invokestatic 99	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:a	()I
    //   169: iconst_1
    //   170: if_icmpeq +10 -> 180
    //   173: invokestatic 99	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:a	()I
    //   176: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: areturn
    //   180: aload_0
    //   181: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   184: putfield 18	wle:jdField_a_of_type_Long	J
    //   187: getstatic 127	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: astore 8
    //   192: aload_0
    //   193: getfield 29	wle:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   196: invokevirtual 130	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   199: checkcast 132	com/tencent/mobileqq/app/QQAppInterface
    //   202: sipush 137
    //   205: invokevirtual 136	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   208: checkcast 138	com/tencent/mobileqq/activity/bless/BlessManager
    //   211: invokevirtual 141	com/tencent/mobileqq/activity/bless/BlessManager:a	()Lcom/tencent/mobileqq/data/MessageForShortVideo;
    //   214: astore 7
    //   216: aload 7
    //   218: ifnonnull +8 -> 226
    //   221: iconst_5
    //   222: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: areturn
    //   226: aload 7
    //   228: instanceof 143
    //   231: ifeq +52 -> 283
    //   234: aload 7
    //   236: checkcast 143	com/tencent/mobileqq/data/MessageForBlessPTV
    //   239: aload_0
    //   240: getfield 31	wle:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   243: putfield 146	com/tencent/mobileqq/data/MessageForBlessPTV:uinList	Ljava/util/ArrayList;
    //   246: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +34 -> 283
    //   252: ldc 47
    //   254: iconst_2
    //   255: new 82	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   262: ldc 148
    //   264: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: getfield 31	wle:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   271: invokevirtual 151	java/util/ArrayList:toString	()Ljava/lang/String;
    //   274: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_0
    //   284: getfield 29	wle:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   287: invokevirtual 130	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   290: checkcast 132	com/tencent/mobileqq/app/QQAppInterface
    //   293: astore 6
    //   295: aload 6
    //   297: ifnull +11 -> 308
    //   300: aload 6
    //   302: invokevirtual 155	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   305: invokevirtual 160	com/tencent/mobileqq/highway/HwEngine:preConnect	()V
    //   308: aload 7
    //   310: getfield 165	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
    //   313: invokestatic 170	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   316: ifeq +273 -> 589
    //   319: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +11 -> 333
    //   325: ldc 47
    //   327: iconst_2
    //   328: ldc 172
    //   330: invokestatic 53	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload 7
    //   335: getfield 175	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   338: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   341: ifeq +82 -> 423
    //   344: aload 7
    //   346: aload_0
    //   347: getfield 182	wle:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   350: putfield 175	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   353: aload 7
    //   355: ldc 184
    //   357: invokestatic 189	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Lcom/tencent/mobileqq/data/MessageForShortVideo;Ljava/lang/String;)Ljava/lang/String;
    //   360: astore_1
    //   361: aload 8
    //   363: aload_1
    //   364: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   367: ifne +41 -> 408
    //   370: aload 8
    //   372: aload_1
    //   373: invokestatic 199	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   376: pop
    //   377: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +28 -> 408
    //   383: ldc 47
    //   385: iconst_2
    //   386: new 82	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   393: ldc 201
    //   395: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_1
    //   399: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: aload_1
    //   409: putstatic 206	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	Ljava/lang/String;
    //   412: aload 7
    //   414: aload_1
    //   415: putfield 165	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
    //   418: aload 7
    //   420: invokevirtual 209	com/tencent/mobileqq/data/MessageForShortVideo:serial	()V
    //   423: aload 6
    //   425: ifnull +518 -> 943
    //   428: invokestatic 211	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()Z
    //   431: ifne +512 -> 943
    //   434: iconst_0
    //   435: iconst_3
    //   436: invokestatic 216	com/tencent/mobileqq/shortvideo/ShortVideoBusiManager:a	(II)Lcom/tencent/mobileqq/shortvideo/ShortVideoReq;
    //   439: astore_1
    //   440: aload 7
    //   442: aload_1
    //   443: invokestatic 219	com/tencent/mobileqq/shortvideo/ShortVideoBusiManager:a	(Ljava/lang/Object;Lcom/tencent/mobileqq/shortvideo/ShortVideoReq;)Lcom/tencent/mobileqq/shortvideo/ShortVideoUploadInfo;
    //   446: astore 5
    //   448: aload 5
    //   450: iconst_0
    //   451: putfield 224	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:a	Z
    //   454: aload 5
    //   456: iconst_1
    //   457: putfield 226	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:d	Z
    //   460: aload 5
    //   462: getfield 229	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:r	Ljava/lang/String;
    //   465: ifnull +32 -> 497
    //   468: aload 5
    //   470: getfield 229	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:r	Ljava/lang/String;
    //   473: invokevirtual 232	java/lang/String:length	()I
    //   476: bipush 39
    //   478: if_icmpne +19 -> 497
    //   481: aload 5
    //   483: aload 5
    //   485: getfield 229	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:r	Ljava/lang/String;
    //   488: iconst_0
    //   489: bipush 28
    //   491: invokevirtual 236	java/lang/String:substring	(II)Ljava/lang/String;
    //   494: putfield 229	com/tencent/mobileqq/shortvideo/ShortVideoUploadInfo:r	Ljava/lang/String;
    //   497: aload_1
    //   498: aload 5
    //   500: invokevirtual 241	com/tencent/mobileqq/shortvideo/ShortVideoReq:a	(Lcom/tencent/mobileqq/shortvideo/ShortVideoUploadInfo;)V
    //   503: aload_1
    //   504: aload 6
    //   506: invokestatic 244	com/tencent/mobileqq/shortvideo/ShortVideoBusiManager:a	(Lcom/tencent/mobileqq/shortvideo/ShortVideoReq;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   509: aload_0
    //   510: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   513: putfield 20	wle:jdField_b_of_type_Long	J
    //   516: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +65 -> 584
    //   522: ldc 47
    //   524: iconst_2
    //   525: new 82	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   532: ldc 246
    //   534: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload 7
    //   539: getfield 249	com/tencent/mobileqq/data/MessageForShortVideo:uniseq	J
    //   542: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   545: ldc 251
    //   547: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload 7
    //   552: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   555: ldc_w 256
    //   558: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload_0
    //   562: getfield 20	wle:jdField_b_of_type_Long	J
    //   565: aload_0
    //   566: getfield 18	wle:jdField_a_of_type_Long	J
    //   569: lsub
    //   570: l2d
    //   571: ldc2_w 257
    //   574: ddiv
    //   575: invokevirtual 261	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   578: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: iconst_1
    //   585: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   588: areturn
    //   589: aload 8
    //   591: invokestatic 170	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   594: ifne +24 -> 618
    //   597: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   600: ifeq +12 -> 612
    //   603: ldc 47
    //   605: iconst_2
    //   606: ldc_w 263
    //   609: invokestatic 53	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: bipush 10
    //   614: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   617: areturn
    //   618: new 265	java/io/File
    //   621: dup
    //   622: aload 8
    //   624: invokespecial 268	java/io/File:<init>	(Ljava/lang/String;)V
    //   627: astore 5
    //   629: aload 5
    //   631: invokevirtual 270	java/io/File:length	()J
    //   634: lstore_2
    //   635: lload_2
    //   636: lconst_0
    //   637: lcmp
    //   638: ifne +23 -> 661
    //   641: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   644: ifeq +12 -> 656
    //   647: ldc 47
    //   649: iconst_2
    //   650: ldc_w 272
    //   653: invokestatic 53	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   656: iconst_3
    //   657: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   660: areturn
    //   661: new 274	java/io/FileInputStream
    //   664: dup
    //   665: aload 5
    //   667: invokespecial 277	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   670: astore 5
    //   672: aload 5
    //   674: ifnull +196 -> 870
    //   677: aload 5
    //   679: lload_2
    //   680: invokestatic 283	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   683: invokestatic 289	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   686: astore 5
    //   688: aload 5
    //   690: astore_1
    //   691: aload 5
    //   693: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   696: ifeq +174 -> 870
    //   699: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   702: ifeq +30 -> 732
    //   705: ldc 47
    //   707: iconst_2
    //   708: new 82	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   715: ldc_w 291
    //   718: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: aload 5
    //   723: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokestatic 53	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   732: iconst_3
    //   733: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   736: areturn
    //   737: astore 5
    //   739: aload 5
    //   741: invokevirtual 294	java/io/FileNotFoundException:printStackTrace	()V
    //   744: iconst_0
    //   745: ifeq +125 -> 870
    //   748: aconst_null
    //   749: lload_2
    //   750: invokestatic 283	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   753: invokestatic 289	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   756: astore 5
    //   758: aload 5
    //   760: astore_1
    //   761: aload 5
    //   763: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   766: ifeq +104 -> 870
    //   769: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   772: ifeq +30 -> 802
    //   775: ldc 47
    //   777: iconst_2
    //   778: new 82	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   785: ldc_w 291
    //   788: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: aload 5
    //   793: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 53	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   802: iconst_3
    //   803: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   806: areturn
    //   807: astore_1
    //   808: iconst_0
    //   809: ifeq +59 -> 868
    //   812: aconst_null
    //   813: lload_2
    //   814: invokestatic 283	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   817: invokestatic 289	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   820: astore 5
    //   822: aload 5
    //   824: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   827: ifeq +41 -> 868
    //   830: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   833: ifeq +30 -> 863
    //   836: ldc 47
    //   838: iconst_2
    //   839: new 82	java/lang/StringBuilder
    //   842: dup
    //   843: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   846: ldc_w 291
    //   849: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: aload 5
    //   854: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: invokestatic 53	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   863: iconst_3
    //   864: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   867: areturn
    //   868: aload_1
    //   869: athrow
    //   870: aload_0
    //   871: aload_1
    //   872: putfield 182	wle:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   875: aload 7
    //   877: lload_2
    //   878: l2i
    //   879: putfield 297	com/tencent/mobileqq/data/MessageForShortVideo:videoFileSize	I
    //   882: aload 7
    //   884: getfield 300	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   887: invokestatic 170	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   890: ifeq -557 -> 333
    //   893: aload 7
    //   895: getfield 303	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
    //   898: ldc_w 305
    //   901: invokestatic 308	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   904: astore_1
    //   905: aload_1
    //   906: aload 7
    //   908: getfield 300	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   911: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   914: ifne -581 -> 333
    //   917: aload_1
    //   918: aload 7
    //   920: getfield 300	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   923: invokestatic 199	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   926: ifne +8 -> 934
    //   929: iconst_3
    //   930: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   933: areturn
    //   934: aload 7
    //   936: aload_1
    //   937: putfield 300	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   940: goto -607 -> 333
    //   943: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   946: ifeq -362 -> 584
    //   949: new 82	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   956: ldc_w 310
    //   959: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: astore_1
    //   963: aload 6
    //   965: ifnull +36 -> 1001
    //   968: iconst_1
    //   969: istore 4
    //   971: ldc 47
    //   973: iconst_2
    //   974: aload_1
    //   975: iload 4
    //   977: invokevirtual 313	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   980: ldc_w 315
    //   983: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: invokestatic 211	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()Z
    //   989: invokevirtual 313	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   992: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   998: goto -414 -> 584
    //   1001: iconst_0
    //   1002: istore 4
    //   1004: goto -33 -> 971
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1007	0	this	wle
    //   0	1007	1	paramVarArgs	java.lang.Void[]
    //   36	842	2	l	long
    //   969	34	4	bool	boolean
    //   126	24	5	localInterruptedException	java.lang.InterruptedException
    //   446	276	5	localObject1	java.lang.Object
    //   737	3	5	localFileNotFoundException	java.io.FileNotFoundException
    //   756	97	5	str1	String
    //   118	6	6	localObject2	java.lang.Object
    //   293	671	6	localQQAppInterface	QQAppInterface
    //   214	721	7	localMessageForShortVideo	com.tencent.mobileqq.data.MessageForShortVideo
    //   190	433	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   24	99	118	finally
    //   99	102	118	finally
    //   120	123	118	finally
    //   16	24	126	java/lang/InterruptedException
    //   123	126	126	java/lang/InterruptedException
    //   661	672	737	java/io/FileNotFoundException
    //   661	672	807	finally
    //   739	744	807	finally
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    QLog.i("BlessSelectMemberActivity", 1, "BlessPTVUploadTask: onPostExecute result=" + paramInteger + " ,entrance=" + this.jdField_a_of_type_Int);
    Properties localProperties = new Properties();
    localProperties.setProperty("bless_param_ptv_result", "" + paramInteger);
    localProperties.setProperty("bless_param_entrance_type", "" + this.jdField_a_of_type_Int);
    BlessMtaReport.a("bless_event_ptv_result", localProperties);
    if (paramInteger.intValue() != 1)
    {
      ((BlessSelectMemberActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e();
      switch (paramInteger.intValue())
      {
      }
    }
    for (;;)
    {
      BlessSelectMemberActivity.b(1);
      return;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131437386, true);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131437393, true);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131437391, true);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131437394, true);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131437395);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131437377, true);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    BlessSelectMemberActivity.b(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wle
 * JD-Core Version:    0.7.0.1
 */