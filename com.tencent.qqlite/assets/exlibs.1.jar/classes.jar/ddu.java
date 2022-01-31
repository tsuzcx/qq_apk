import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ddu
  extends DownloadListener
{
  public ddu(EmojiManager paramEmojiManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    long l1 = paramDownloadTask.h;
    long l2 = paramDownloadTask.g;
    Object localObject1 = paramDownloadTask.a();
    boolean bool = ((Bundle)localObject1).getBoolean("newPkgAdd", false);
    int i = ((Bundle)localObject1).getInt(paramDownloadTask.jdField_b_of_type_JavaLangString);
    localObject1 = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDone:epId=" + ((EmoticonPackage)localObject1).epId + " task:" + paramDownloadTask + " localVersion=" + ((EmoticonPackage)localObject1).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject1).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject1).updateFlag);
    }
    if (paramDownloadTask.a() != 3)
    {
      int j = EmosmUtils.checkResultCode(paramDownloadTask.z);
      if (this.a.a(i)) {
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject1, i, -1, j);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject1, j, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.a((EmoticonPackage)localObject1, j);
      this.a.a((EmoticonPackage)localObject1, j, 0L);
      return;
    }
    ((EmoticonPackage)localObject1).updateFlag &= 0xFFFFFFFE;
    if (((EmoticonPackage)localObject1).latestVersion > ((EmoticonPackage)localObject1).localVersion) {
      ((EmoticonPackage)localObject1).localVersion = ((EmoticonPackage)localObject1).latestVersion;
    }
    ((EmoticonPackage)localObject1).hasReadUpdatePage = false;
    ((EmoticonPackage)localObject1).status = 2;
    ((EmoticonPackage)localObject1).valid = true;
    this.a.a().a((EmoticonPackage)localObject1);
    paramDownloadTask = (EmoticonManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    Object localObject2 = (ArrayList)paramDownloadTask.b();
    Object localObject3 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject3).hasNext()) {
      if (((EmoticonPackage)((Iterator)localObject3).next()).epId.equals(((EmoticonPackage)localObject1).epId))
      {
        ((ArrayList)localObject2).remove(localObject1);
        ((ArrayList)localObject2).add(0, localObject1);
      }
    }
    paramDownloadTask.c();
    localObject3 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject3).add(((EmoticonPackage)((Iterator)localObject2).next()).epId);
    }
    paramDownloadTask.b((List)localObject3);
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.d((EmoticonPackage)localObject1);
    if (bool) {
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject1, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.a.a((EmoticonPackage)localObject1, 0);
    this.a.a((EmoticonPackage)localObject1, 0, l1 - l2);
  }
  
  /* Error */
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokevirtual 30	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   15: iconst_m1
    //   16: invokevirtual 222	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   19: istore_2
    //   20: aload 4
    //   22: ldc 48
    //   24: invokevirtual 52	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   27: checkcast 54	com/tencent/mobileqq/data/EmoticonPackage
    //   30: astore 7
    //   32: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +41 -> 76
    //   38: aload_0
    //   39: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   42: getfield 64	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   45: iconst_2
    //   46: new 66	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   53: ldc 224
    //   55: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 7
    //   60: getfield 78	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   63: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   80: getfield 128	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   83: aload 7
    //   85: aload_1
    //   86: getfield 226	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Long	J
    //   89: l2i
    //   90: aload_1
    //   91: getfield 228	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_Long	J
    //   94: l2i
    //   95: invokevirtual 231	com/tencent/mobileqq/emoticon/EmojiListenerManager:b	(Lcom/tencent/mobileqq/data/EmoticonPackage;II)V
    //   98: aload_1
    //   99: getfield 234	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   102: aload_1
    //   103: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokeinterface 240 2 0
    //   111: checkcast 242	java/io/File
    //   114: astore 8
    //   116: iload_2
    //   117: lookupswitch	default:+35->152, 2:+54->171, 7:+113->230, 10:+72->189
    //   153: iconst_m1
    //   154: if_icmpeq +16 -> 170
    //   157: aload_0
    //   158: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   161: ldc 244
    //   163: iload_2
    //   164: invokestatic 248	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   167: invokevirtual 250	com/tencent/mobileqq/emoticon/EmojiManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: return
    //   171: aload_0
    //   172: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   175: getfield 128	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   178: aload 7
    //   180: iconst_2
    //   181: iconst_0
    //   182: iconst_0
    //   183: invokevirtual 133	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;III)V
    //   186: goto -34 -> 152
    //   189: aload 8
    //   191: invokevirtual 253	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   194: aload 7
    //   196: getfield 78	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   199: invokestatic 257	com/tencent/mobileqq/emosm/EmosmUtils:getEmoticonPackageFolder	(Ljava/lang/String;)Ljava/lang/String;
    //   202: iconst_0
    //   203: invokestatic 262	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   206: aload 8
    //   208: invokevirtual 265	java/io/File:delete	()Z
    //   211: pop
    //   212: goto -60 -> 152
    //   215: astore 4
    //   217: aload_1
    //   218: iconst_1
    //   219: putfield 267	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   222: aload 4
    //   224: invokevirtual 270	java/io/IOException:printStackTrace	()V
    //   227: goto -21 -> 206
    //   230: aload_0
    //   231: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   234: getfield 271	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   237: aload_1
    //   238: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   241: invokeinterface 274 2 0
    //   246: ifeq +435 -> 681
    //   249: aload_0
    //   250: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   253: getfield 271	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   256: astore 5
    //   258: aload 5
    //   260: monitorenter
    //   261: aload_0
    //   262: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   265: getfield 271	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   268: aload_1
    //   269: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   272: invokeinterface 240 2 0
    //   277: checkcast 189	java/lang/String
    //   280: astore 4
    //   282: aload_0
    //   283: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   286: getfield 271	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   289: aload_1
    //   290: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   293: invokeinterface 276 2 0
    //   298: pop
    //   299: aload 5
    //   301: monitorexit
    //   302: aload 8
    //   304: ifnull +371 -> 675
    //   307: aload 8
    //   309: invokestatic 279	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   312: astore 6
    //   314: aload 8
    //   316: invokevirtual 253	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   319: astore 5
    //   321: aload 8
    //   323: invokevirtual 265	java/io/File:delete	()Z
    //   326: pop
    //   327: goto +360 -> 687
    //   330: aload_1
    //   331: iconst_1
    //   332: putfield 267	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   335: aload_0
    //   336: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   339: getfield 128	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   342: aload 7
    //   344: sipush 11009
    //   347: aload_0
    //   348: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   351: getfield 136	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   354: invokevirtual 139	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   357: return
    //   358: astore 4
    //   360: aload 4
    //   362: invokevirtual 280	java/lang/Throwable:printStackTrace	()V
    //   365: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   368: ifeq +63 -> 431
    //   371: aload_0
    //   372: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   375: getfield 64	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   378: iconst_2
    //   379: new 66	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 282
    //   389: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 4
    //   394: invokevirtual 283	java/lang/Throwable:toString	()Ljava/lang/String;
    //   397: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc_w 285
    //   403: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokestatic 291	java/lang/System:currentTimeMillis	()J
    //   409: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   412: ldc_w 296
    //   415: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload_1
    //   419: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   422: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload_1
    //   432: iconst_1
    //   433: putfield 267	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   436: aload_0
    //   437: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   440: getfield 128	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   443: aload 7
    //   445: sipush 11020
    //   448: aload_0
    //   449: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   452: getfield 136	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   455: invokevirtual 139	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   458: goto -306 -> 152
    //   461: astore 4
    //   463: aload 5
    //   465: monitorexit
    //   466: aload 4
    //   468: athrow
    //   469: aload 6
    //   471: aload 4
    //   473: aload 5
    //   475: invokestatic 300	com/tencent/mobileqq/emosm/EmosmUtils:saveEmosm	([BLjava/lang/String;Ljava/lang/String;)I
    //   478: istore_3
    //   479: iload_3
    //   480: ifeq +130 -> 610
    //   483: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq +37 -> 523
    //   489: aload_0
    //   490: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   493: getfield 64	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   496: iconst_2
    //   497: new 66	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   504: ldc_w 302
    //   507: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_1
    //   511: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   514: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: invokestatic 307	com/tencent/mobileqq/util/Utils:e	()Z
    //   526: ifeq +84 -> 610
    //   529: invokestatic 309	com/tencent/mobileqq/util/Utils:b	()J
    //   532: ldc2_w 310
    //   535: lcmp
    //   536: ifle +74 -> 610
    //   539: new 66	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   546: getstatic 316	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   549: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc_w 318
    //   555: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: getstatic 321	java/io/File:separator	Ljava/lang/String;
    //   561: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload 7
    //   566: getfield 78	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   569: invokestatic 324	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   572: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: ldc_w 326
    //   578: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 4
    //   583: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: ldc_w 326
    //   589: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload 8
    //   594: invokevirtual 329	java/io/File:getName	()Ljava/lang/String;
    //   597: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: aload 6
    //   605: iconst_0
    //   606: invokestatic 332	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[BZ)Z
    //   609: pop
    //   610: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   613: ifeq -461 -> 152
    //   616: aload_0
    //   617: getfield 10	ddu:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   620: getfield 64	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   623: iconst_2
    //   624: new 66	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   631: ldc_w 334
    //   634: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: iload_3
    //   638: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   641: ldc_w 285
    //   644: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokestatic 291	java/lang/System:currentTimeMillis	()J
    //   650: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   653: ldc_w 296
    //   656: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload_1
    //   660: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   663: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: goto -520 -> 152
    //   675: aconst_null
    //   676: astore 5
    //   678: goto +9 -> 687
    //   681: aconst_null
    //   682: astore 4
    //   684: goto -382 -> 302
    //   687: aload 6
    //   689: ifnull -359 -> 330
    //   692: aload 4
    //   694: ifnull -364 -> 330
    //   697: aload 5
    //   699: ifnonnull -230 -> 469
    //   702: goto -372 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	705	0	this	ddu
    //   0	705	1	paramDownloadTask	DownloadTask
    //   19	145	2	i	int
    //   478	160	3	j	int
    //   7	14	4	localBundle	Bundle
    //   215	8	4	localIOException	java.io.IOException
    //   280	1	4	str1	String
    //   358	35	4	localThrowable	java.lang.Throwable
    //   461	121	4	str2	String
    //   682	11	4	localObject1	Object
    //   1	687	6	arrayOfByte	byte[]
    //   30	535	7	localEmoticonPackage	EmoticonPackage
    //   114	479	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   189	206	215	java/io/IOException
    //   230	261	358	java/lang/Throwable
    //   307	327	358	java/lang/Throwable
    //   330	357	358	java/lang/Throwable
    //   466	469	358	java/lang/Throwable
    //   469	479	358	java/lang/Throwable
    //   483	523	358	java/lang/Throwable
    //   523	610	358	java/lang/Throwable
    //   610	672	358	java/lang/Throwable
    //   261	302	461	finally
    //   463	466	461	finally
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramDownloadTask.a().getSerializable("emoticonPackage");
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage);
    this.a.a("param_epId", localEmoticonPackage.epId);
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ddu
 * JD-Core Version:    0.7.0.1
 */