import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.mobileqq.activity.bless.BlessResultActivity.VideoInfo;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.OnUploadVideoListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class wkr
  implements Runnable
{
  private long jdField_a_of_type_Long = -1L;
  public BlessResultActivity.VideoInfo a;
  private TroopBarShortVideoUploadUtil.OnUploadVideoListener jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private String b;
  private String c;
  private String d;
  
  public wkr(BlessResultActivity paramBlessResultActivity, String paramString1, String paramString2, BlessResultActivity.VideoInfo paramVideoInfo, TroopBarShortVideoUploadUtil.OnUploadVideoListener paramOnUploadVideoListener)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo = paramVideoInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener = paramOnUploadVideoListener;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = paramBlessResultActivity.getString(2131429282);
    }
    if (this.b == null) {
      this.b = paramBlessResultActivity.getString(2131438309);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "VideoUploadTask stop()");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean b()
  {
    if (!a()) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessResultActivity", 2, "VideoUploadTask isRunning(),result = " + bool);
      }
      return bool;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   3: lstore 8
    //   5: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +11 -> 19
    //   11: ldc 63
    //   13: iconst_2
    //   14: ldc 105
    //   16: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: getfield 30	wkr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: iconst_0
    //   24: invokevirtual 71	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   27: aload_0
    //   28: getfield 42	wkr:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   31: ifnonnull +26 -> 57
    //   34: aload_0
    //   35: getfield 30	wkr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   38: iconst_1
    //   39: invokevirtual 71	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   42: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +11 -> 56
    //   48: ldc 107
    //   50: iconst_2
    //   51: ldc 109
    //   53: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: return
    //   57: aload_0
    //   58: getfield 40	wkr:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   61: ifnull +23 -> 84
    //   64: aload_0
    //   65: getfield 36	wkr:c	Ljava/lang/String;
    //   68: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +13 -> 84
    //   74: aload_0
    //   75: getfield 38	wkr:d	Ljava/lang/String;
    //   78: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +96 -> 177
    //   84: aload_0
    //   85: getfield 30	wkr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   88: iconst_1
    //   89: invokevirtual 71	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   92: aload_0
    //   93: getfield 42	wkr:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   96: ldc2_w 31
    //   99: invokeinterface 120 3 0
    //   104: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -51 -> 56
    //   110: aload_0
    //   111: getfield 40	wkr:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   114: ifnonnull +39 -> 153
    //   117: ldc 122
    //   119: astore 12
    //   121: ldc 107
    //   123: iconst_2
    //   124: new 78	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   131: ldc 124
    //   133: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload 12
    //   138: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 126
    //   143: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: return
    //   153: aload_0
    //   154: getfield 36	wkr:c	Ljava/lang/String;
    //   157: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   160: ifeq +10 -> 170
    //   163: ldc 128
    //   165: astore 12
    //   167: goto -46 -> 121
    //   170: ldc 130
    //   172: astore 12
    //   174: goto -53 -> 121
    //   177: iconst_0
    //   178: istore 10
    //   180: aload_0
    //   181: getfield 40	wkr:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   184: getfield 133	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   187: astore 15
    //   189: new 135	java/io/File
    //   192: dup
    //   193: aload_0
    //   194: getfield 40	wkr:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   197: getfield 133	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   200: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   203: invokevirtual 141	java/io/File:getName	()Ljava/lang/String;
    //   206: astore 12
    //   208: new 143	android/os/Bundle
    //   211: dup
    //   212: invokespecial 144	android/os/Bundle:<init>	()V
    //   215: astore 13
    //   217: aload 13
    //   219: ldc 146
    //   221: aload_0
    //   222: getfield 44	wkr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   225: invokevirtual 150	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload 13
    //   230: ldc 152
    //   232: aload 15
    //   234: invokevirtual 150	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload 13
    //   239: ldc 154
    //   241: aload_0
    //   242: getfield 53	wkr:b	Ljava/lang/String;
    //   245: invokevirtual 150	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload 13
    //   250: ldc 156
    //   252: aload 12
    //   254: invokevirtual 150	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload 13
    //   259: ldc 158
    //   261: aload_0
    //   262: getfield 40	wkr:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo;
    //   265: getfield 159	com/tencent/mobileqq/activity/bless/BlessResultActivity$VideoInfo:b	Ljava/lang/String;
    //   268: invokevirtual 150	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: invokestatic 165	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   274: invokestatic 170	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;)Z
    //   277: ifeq +1115 -> 1392
    //   280: aload_0
    //   281: getfield 30	wkr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   284: invokevirtual 74	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   287: ifne +1105 -> 1392
    //   290: aload 13
    //   292: aload_0
    //   293: getfield 36	wkr:c	Ljava/lang/String;
    //   296: aload_0
    //   297: getfield 38	wkr:d	Ljava/lang/String;
    //   300: ldc 172
    //   302: iconst_0
    //   303: invokestatic 175	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   306: astore 14
    //   308: aload 14
    //   310: ifnull +1070 -> 1380
    //   313: aload 15
    //   315: invokestatic 180	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)J
    //   318: lstore 6
    //   320: lload 6
    //   322: ldc2_w 181
    //   325: lcmp
    //   326: ifle +229 -> 555
    //   329: ldc2_w 181
    //   332: lstore_2
    //   333: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +45 -> 381
    //   339: ldc 63
    //   341: iconst_2
    //   342: new 78	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   349: ldc 184
    //   351: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload 14
    //   356: getfield 189	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   359: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc 191
    //   364: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload 14
    //   369: getfield 192	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:d	Ljava/lang/String;
    //   372: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: ldc 194
    //   383: aload 14
    //   385: getfield 189	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   388: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   391: ifeq +170 -> 561
    //   394: aload_0
    //   395: getfield 42	wkr:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   398: lload_2
    //   399: l2d
    //   400: ldc2_w 201
    //   403: dmul
    //   404: d2l
    //   405: invokeinterface 204 3 0
    //   410: aload_0
    //   411: getfield 30	wkr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   414: invokevirtual 74	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   417: ifne +969 -> 1386
    //   420: aload 15
    //   422: aload_0
    //   423: getfield 20	wkr:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   426: getfield 205	com/tencent/mobileqq/activity/bless/BlessResultActivity:b	Ljava/lang/String;
    //   429: aload_0
    //   430: getfield 36	wkr:c	Ljava/lang/String;
    //   433: aload_0
    //   434: getfield 38	wkr:d	Ljava/lang/String;
    //   437: aload 14
    //   439: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   442: aload 14
    //   444: getfield 211	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:g	Ljava/lang/String;
    //   447: ldc 172
    //   449: invokestatic 214	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   452: istore 11
    //   454: iload 11
    //   456: istore 10
    //   458: lload_2
    //   459: ldc2_w 31
    //   462: lcmp
    //   463: ifeq +17 -> 480
    //   466: aload_0
    //   467: getfield 42	wkr:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   470: lload_2
    //   471: invokeinterface 204 3 0
    //   476: iload 11
    //   478: istore 10
    //   480: aload_0
    //   481: getfield 20	wkr:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   484: aload 14
    //   486: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   489: putfield 215	com/tencent/mobileqq/activity/bless/BlessResultActivity:d	Ljava/lang/String;
    //   492: aload_0
    //   493: getfield 30	wkr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   496: iconst_0
    //   497: iconst_1
    //   498: invokevirtual 219	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   501: ifeq +799 -> 1300
    //   504: iload 10
    //   506: ifeq +743 -> 1249
    //   509: aload_0
    //   510: getfield 42	wkr:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   513: invokeinterface 221 1 0
    //   518: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq -465 -> 56
    //   524: ldc 63
    //   526: iconst_2
    //   527: new 78	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   534: ldc 223
    //   536: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   542: lload 8
    //   544: lsub
    //   545: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   548: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: return
    //   555: lload 6
    //   557: lstore_2
    //   558: goto -225 -> 333
    //   561: aload 14
    //   563: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   566: ifnull +814 -> 1380
    //   569: aload 14
    //   571: getfield 227	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:c	Ljava/lang/String;
    //   574: invokestatic 232	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   577: astore 16
    //   579: aload 15
    //   581: invokestatic 235	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
    //   584: astore 17
    //   586: new 78	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   593: ldc 237
    //   595: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload 14
    //   600: getfield 238	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   603: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: ldc 240
    //   608: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload 14
    //   613: getfield 241	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:b	Ljava/lang/String;
    //   616: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: ldc 243
    //   621: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: astore 18
    //   629: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   632: ifeq +42 -> 674
    //   635: ldc 63
    //   637: iconst_2
    //   638: new 78	java/lang/StringBuilder
    //   641: dup
    //   642: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   645: ldc 245
    //   647: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: aload 18
    //   652: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: ldc 247
    //   657: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload 14
    //   662: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   665: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: aload_0
    //   675: getfield 42	wkr:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   678: invokeinterface 249 1 0
    //   683: new 251	java/io/RandomAccessFile
    //   686: dup
    //   687: aload 15
    //   689: ldc 253
    //   691: invokespecial 255	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   694: astore 13
    //   696: lconst_0
    //   697: lstore 4
    //   699: lload_2
    //   700: lload 4
    //   702: lsub
    //   703: l2i
    //   704: istore_1
    //   705: aload 13
    //   707: astore 12
    //   709: invokestatic 165	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   712: invokestatic 170	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;)Z
    //   715: ifeq +341 -> 1056
    //   718: aload 13
    //   720: astore 12
    //   722: aload_0
    //   723: getfield 30	wkr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   726: invokevirtual 74	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   729: ifne +327 -> 1056
    //   732: aload 13
    //   734: astore 12
    //   736: aload 16
    //   738: aload 17
    //   740: aload 18
    //   742: lload 6
    //   744: aload 13
    //   746: lload 4
    //   748: iload_1
    //   749: invokestatic 260	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   752: lstore 4
    //   754: aload 13
    //   756: astore 12
    //   758: aload_0
    //   759: lload 4
    //   761: putfield 34	wkr:jdField_a_of_type_Long	J
    //   764: lload 4
    //   766: ldc2_w 31
    //   769: lcmp
    //   770: ifeq +233 -> 1003
    //   773: aload 13
    //   775: astore 12
    //   777: aload_0
    //   778: invokevirtual 76	wkr:a	()Z
    //   781: ifne +617 -> 1398
    //   784: aload 13
    //   786: astore 12
    //   788: aload_0
    //   789: getfield 42	wkr:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   792: lload 4
    //   794: l2d
    //   795: ldc2_w 201
    //   798: dmul
    //   799: d2l
    //   800: invokeinterface 204 3 0
    //   805: goto +593 -> 1398
    //   808: aload 13
    //   810: astore 12
    //   812: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   815: ifeq +34 -> 849
    //   818: aload 13
    //   820: astore 12
    //   822: ldc 63
    //   824: iconst_2
    //   825: new 78	java/lang/StringBuilder
    //   828: dup
    //   829: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   832: ldc_w 262
    //   835: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: iload 10
    //   840: invokevirtual 88	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   843: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   849: iload 10
    //   851: ifeq +510 -> 1361
    //   854: aload 13
    //   856: astore 12
    //   858: aload_0
    //   859: getfield 30	wkr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   862: invokevirtual 74	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   865: ifne +496 -> 1361
    //   868: aload 13
    //   870: astore 12
    //   872: aload 15
    //   874: aload_0
    //   875: getfield 20	wkr:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   878: getfield 205	com/tencent/mobileqq/activity/bless/BlessResultActivity:b	Ljava/lang/String;
    //   881: aload_0
    //   882: getfield 36	wkr:c	Ljava/lang/String;
    //   885: aload_0
    //   886: getfield 38	wkr:d	Ljava/lang/String;
    //   889: aload 14
    //   891: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   894: aload 14
    //   896: getfield 211	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:g	Ljava/lang/String;
    //   899: ldc 172
    //   901: invokestatic 214	com/tencent/mobileqq/activity/bless/BlessResultActivity:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   904: istore 10
    //   906: iload 10
    //   908: istore 11
    //   910: lload_2
    //   911: ldc2_w 31
    //   914: lcmp
    //   915: ifeq +21 -> 936
    //   918: aload 13
    //   920: astore 12
    //   922: aload_0
    //   923: getfield 42	wkr:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   926: lload_2
    //   927: invokeinterface 204 3 0
    //   932: iload 10
    //   934: istore 11
    //   936: aload 13
    //   938: astore 12
    //   940: aload_0
    //   941: getfield 20	wkr:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity	Lcom/tencent/mobileqq/activity/bless/BlessResultActivity;
    //   944: aload 14
    //   946: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   949: putfield 215	com/tencent/mobileqq/activity/bless/BlessResultActivity:d	Ljava/lang/String;
    //   952: iload 11
    //   954: istore 10
    //   956: aload 13
    //   958: ifnull -466 -> 492
    //   961: aload 13
    //   963: invokevirtual 265	java/io/RandomAccessFile:close	()V
    //   966: iload 11
    //   968: istore 10
    //   970: goto -478 -> 492
    //   973: astore 12
    //   975: iload 11
    //   977: istore 10
    //   979: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   982: ifeq -490 -> 492
    //   985: ldc 63
    //   987: iconst_2
    //   988: aload 12
    //   990: invokestatic 269	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   993: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   996: iload 11
    //   998: istore 10
    //   1000: goto -508 -> 492
    //   1003: iconst_1
    //   1004: istore_1
    //   1005: aload 13
    //   1007: astore 12
    //   1009: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1012: ifeq +362 -> 1374
    //   1015: aload 13
    //   1017: astore 12
    //   1019: ldc 63
    //   1021: iconst_2
    //   1022: new 78	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1029: ldc_w 271
    //   1032: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   1038: lload 8
    //   1040: lsub
    //   1041: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1044: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1047: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1050: lload 4
    //   1052: lstore_2
    //   1053: goto +370 -> 1423
    //   1056: iconst_1
    //   1057: istore_1
    //   1058: aload 13
    //   1060: astore 12
    //   1062: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1065: ifeq +306 -> 1371
    //   1068: aload 13
    //   1070: astore 12
    //   1072: ldc 63
    //   1074: iconst_2
    //   1075: new 78	java/lang/StringBuilder
    //   1078: dup
    //   1079: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1082: ldc_w 273
    //   1085: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   1091: lload 8
    //   1093: lsub
    //   1094: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1097: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1100: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1103: goto +320 -> 1423
    //   1106: astore 14
    //   1108: aconst_null
    //   1109: astore 13
    //   1111: iconst_0
    //   1112: istore 11
    //   1114: aload 13
    //   1116: astore 12
    //   1118: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1121: ifeq +37 -> 1158
    //   1124: aload 13
    //   1126: astore 12
    //   1128: ldc 63
    //   1130: iconst_2
    //   1131: new 78	java/lang/StringBuilder
    //   1134: dup
    //   1135: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1138: ldc_w 275
    //   1141: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: aload 14
    //   1146: invokestatic 269	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1149: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1155: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1158: iload 11
    //   1160: istore 10
    //   1162: aload 13
    //   1164: ifnull -672 -> 492
    //   1167: aload 13
    //   1169: invokevirtual 265	java/io/RandomAccessFile:close	()V
    //   1172: iload 11
    //   1174: istore 10
    //   1176: goto -684 -> 492
    //   1179: astore 12
    //   1181: iload 11
    //   1183: istore 10
    //   1185: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1188: ifeq -696 -> 492
    //   1191: ldc 63
    //   1193: iconst_2
    //   1194: aload 12
    //   1196: invokestatic 269	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1199: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1202: iload 11
    //   1204: istore 10
    //   1206: goto -714 -> 492
    //   1209: astore 13
    //   1211: aconst_null
    //   1212: astore 12
    //   1214: aload 12
    //   1216: ifnull +8 -> 1224
    //   1219: aload 12
    //   1221: invokevirtual 265	java/io/RandomAccessFile:close	()V
    //   1224: aload 13
    //   1226: athrow
    //   1227: astore 12
    //   1229: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1232: ifeq -8 -> 1224
    //   1235: ldc 63
    //   1237: iconst_2
    //   1238: aload 12
    //   1240: invokestatic 269	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1243: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1246: goto -22 -> 1224
    //   1249: aload_0
    //   1250: getfield 42	wkr:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1253: aload_0
    //   1254: getfield 34	wkr:jdField_a_of_type_Long	J
    //   1257: invokeinterface 120 3 0
    //   1262: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1265: ifeq -1209 -> 56
    //   1268: ldc 63
    //   1270: iconst_2
    //   1271: new 78	java/lang/StringBuilder
    //   1274: dup
    //   1275: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1278: ldc_w 277
    //   1281: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   1287: lload 8
    //   1289: lsub
    //   1290: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1293: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1296: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1299: return
    //   1300: aload_0
    //   1301: getfield 42	wkr:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   1304: aload_0
    //   1305: getfield 34	wkr:jdField_a_of_type_Long	J
    //   1308: invokeinterface 279 3 0
    //   1313: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1316: ifeq -1260 -> 56
    //   1319: ldc 63
    //   1321: iconst_2
    //   1322: new 78	java/lang/StringBuilder
    //   1325: dup
    //   1326: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1329: ldc_w 281
    //   1332: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   1338: lload 8
    //   1340: lsub
    //   1341: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1344: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1347: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1350: return
    //   1351: astore 13
    //   1353: goto -139 -> 1214
    //   1356: astore 14
    //   1358: goto -247 -> 1111
    //   1361: iload 10
    //   1363: istore 11
    //   1365: goto -429 -> 936
    //   1368: goto -669 -> 699
    //   1371: goto +52 -> 1423
    //   1374: lload 4
    //   1376: lstore_2
    //   1377: goto +46 -> 1423
    //   1380: iconst_0
    //   1381: istore 10
    //   1383: goto -891 -> 492
    //   1386: iconst_1
    //   1387: istore 10
    //   1389: goto -909 -> 480
    //   1392: aconst_null
    //   1393: astore 14
    //   1395: goto -1087 -> 308
    //   1398: ldc2_w 181
    //   1401: lload 4
    //   1403: ladd
    //   1404: lload 6
    //   1406: lcmp
    //   1407: ifle +26 -> 1433
    //   1410: lload 6
    //   1412: lstore_2
    //   1413: lload 4
    //   1415: lload 6
    //   1417: lcmp
    //   1418: iflt -50 -> 1368
    //   1421: iconst_0
    //   1422: istore_1
    //   1423: iload_1
    //   1424: ifne -616 -> 808
    //   1427: iconst_1
    //   1428: istore 10
    //   1430: goto -622 -> 808
    //   1433: ldc2_w 181
    //   1436: lload 4
    //   1438: ladd
    //   1439: lstore_2
    //   1440: goto -27 -> 1413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1443	0	this	wkr
    //   704	720	1	i	int
    //   332	1108	2	l1	long
    //   697	740	4	l2	long
    //   318	1098	6	l3	long
    //   3	1336	8	l4	long
    //   178	1251	10	bool1	boolean
    //   452	912	11	bool2	boolean
    //   119	820	12	localObject1	Object
    //   973	16	12	localIOException1	java.io.IOException
    //   1007	120	12	localObject2	Object
    //   1179	16	12	localIOException2	java.io.IOException
    //   1212	8	12	localObject3	Object
    //   1227	12	12	localIOException3	java.io.IOException
    //   215	953	13	localObject4	Object
    //   1209	16	13	localObject5	Object
    //   1351	1	13	localObject6	Object
    //   306	639	14	localApplyUploadRsp	com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.ApplyUploadRsp
    //   1106	39	14	localException1	java.lang.Exception
    //   1356	1	14	localException2	java.lang.Exception
    //   1393	1	14	localObject7	Object
    //   187	686	15	str1	String
    //   577	160	16	arrayOfByte1	byte[]
    //   584	155	17	arrayOfByte2	byte[]
    //   627	114	18	str2	String
    // Exception table:
    //   from	to	target	type
    //   961	966	973	java/io/IOException
    //   674	696	1106	java/lang/Exception
    //   1167	1172	1179	java/io/IOException
    //   674	696	1209	finally
    //   1219	1224	1227	java/io/IOException
    //   709	718	1351	finally
    //   722	732	1351	finally
    //   736	754	1351	finally
    //   758	764	1351	finally
    //   777	784	1351	finally
    //   788	805	1351	finally
    //   812	818	1351	finally
    //   822	849	1351	finally
    //   858	868	1351	finally
    //   872	906	1351	finally
    //   922	932	1351	finally
    //   940	952	1351	finally
    //   1009	1015	1351	finally
    //   1019	1050	1351	finally
    //   1062	1068	1351	finally
    //   1072	1103	1351	finally
    //   1118	1124	1351	finally
    //   1128	1158	1351	finally
    //   709	718	1356	java/lang/Exception
    //   722	732	1356	java/lang/Exception
    //   736	754	1356	java/lang/Exception
    //   758	764	1356	java/lang/Exception
    //   777	784	1356	java/lang/Exception
    //   788	805	1356	java/lang/Exception
    //   812	818	1356	java/lang/Exception
    //   822	849	1356	java/lang/Exception
    //   858	868	1356	java/lang/Exception
    //   872	906	1356	java/lang/Exception
    //   922	932	1356	java/lang/Exception
    //   940	952	1356	java/lang/Exception
    //   1009	1015	1356	java/lang/Exception
    //   1019	1050	1356	java/lang/Exception
    //   1062	1068	1356	java/lang/Exception
    //   1072	1103	1356	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wkr
 * JD-Core Version:    0.7.0.1
 */