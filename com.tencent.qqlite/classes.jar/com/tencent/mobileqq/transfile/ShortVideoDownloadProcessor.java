package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ehn;
import ehr;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ShortVideoDownloadProcessor
  extends BaseDownloadProcessor
{
  public static final String U = "ShortVideoDownloadProcessor";
  static HashSet a;
  private String V;
  private int aG;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public ShortVideoDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    paramTransFileController = paramTransferRequest.h;
    String[] arrayOfString = paramTransFileController.split("QQ_&_MoblieQQ_&_QQ");
    if (3 != arrayOfString.length)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "path was not set correctlly------path = " + paramTransFileController);
      }
      throw new IllegalArgumentException("path was not set correctlly.");
    }
    paramTransferRequest.g = arrayOfString[0];
    this.V = arrayOfString[1];
    this.aG = Integer.parseInt(arrayOfString[2]);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "start()----runningTasks.contains(mFileId) = " + jdField_a_of_type_JavaUtilHashSet.contains(this.V));
    }
    if (jdField_a_of_type_JavaUtilHashSet.contains(this.V)) {
      return;
    }
    jdField_a_of_type_JavaUtilHashSet.add(this.V);
    d(2001);
    c();
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = paramLong1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = paramLong2;
    d(2002);
  }
  
  /* Error */
  public void a(NetResp paramNetResp)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 117	com/tencent/mobileqq/transfile/BaseDownloadProcessor:a	(Lcom/tencent/mobileqq/transfile/NetResp;)V
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 120	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   12: new 47	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   19: ldc 122
    //   21: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 126	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Boolean	Z
    //   28: invokevirtual 91	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: ldc 128
    //   33: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: astore 4
    //   38: aload_1
    //   39: getfield 132	com/tencent/mobileqq/transfile/NetResp:jdField_d_of_type_Int	I
    //   42: ifne +296 -> 338
    //   45: iconst_1
    //   46: istore_2
    //   47: aload_0
    //   48: ldc 134
    //   50: aload 4
    //   52: iload_2
    //   53: invokevirtual 91	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   56: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 137	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +87 -> 152
    //   68: ldc 8
    //   70: iconst_2
    //   71: new 47	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   78: ldc 139
    //   80: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: getfield 132	com/tencent/mobileqq/transfile/NetResp:jdField_d_of_type_Int	I
    //   87: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: ldc 8
    //   98: iconst_2
    //   99: new 47	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   106: ldc 144
    //   108: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: getfield 146	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   115: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: ldc 8
    //   126: iconst_2
    //   127: new 47	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   134: ldc 148
    //   136: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_1
    //   140: getfield 150	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   143: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_0
    //   153: getfield 126	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Boolean	Z
    //   156: ifeq +187 -> 343
    //   159: aload_0
    //   160: getfield 153	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   163: astore 4
    //   165: aload_1
    //   166: getfield 132	com/tencent/mobileqq/transfile/NetResp:jdField_d_of_type_Int	I
    //   169: ifne +183 -> 352
    //   172: iload_3
    //   173: istore_2
    //   174: aload_0
    //   175: aload 4
    //   177: aload_1
    //   178: iload_2
    //   179: invokevirtual 156	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   182: aload_0
    //   183: aload_1
    //   184: getfield 157	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Long	J
    //   187: putfield 158	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Long	J
    //   190: aload_0
    //   191: getfield 158	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Long	J
    //   194: lconst_0
    //   195: lcmp
    //   196: ifgt +19 -> 215
    //   199: aload_0
    //   200: aload_1
    //   201: getfield 160	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Long	J
    //   204: aload_1
    //   205: getfield 161	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   208: getfield 164	com/tencent/mobileqq/transfile/NetReq:jdField_a_of_type_Long	J
    //   211: ladd
    //   212: putfield 158	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Long	J
    //   215: aload_0
    //   216: aload_0
    //   217: getfield 165	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Long	J
    //   220: aload_1
    //   221: getfield 167	com/tencent/mobileqq/transfile/NetResp:jdField_c_of_type_Long	J
    //   224: ladd
    //   225: putfield 165	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Long	J
    //   228: aload_1
    //   229: getfield 132	com/tencent/mobileqq/transfile/NetResp:jdField_d_of_type_Int	I
    //   232: ifne +277 -> 509
    //   235: aload_0
    //   236: getfield 170	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   239: getfield 172	com/tencent/mobileqq/transfile/TransferRequest:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   242: astore 5
    //   244: aload 5
    //   246: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   249: ifne +133 -> 382
    //   252: aload_0
    //   253: getfield 170	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   256: getfield 72	com/tencent/mobileqq/transfile/TransferRequest:g	Ljava/lang/String;
    //   259: astore 6
    //   261: new 180	java/io/FileInputStream
    //   264: dup
    //   265: aload 6
    //   267: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   270: astore 4
    //   272: aload 4
    //   274: astore_1
    //   275: aload 4
    //   277: aload 4
    //   279: invokevirtual 185	java/io/FileInputStream:available	()I
    //   282: i2l
    //   283: invokestatic 191	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   286: astore 7
    //   288: aload 7
    //   290: ifnull +82 -> 372
    //   293: aload 4
    //   295: astore_1
    //   296: aload 7
    //   298: invokestatic 197	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   301: aload 5
    //   303: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   306: ifne +66 -> 372
    //   309: aload 4
    //   311: astore_1
    //   312: aload_0
    //   313: ldc 201
    //   315: ldc 203
    //   317: invokevirtual 206	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   320: aload 4
    //   322: astore_1
    //   323: aload_0
    //   324: invokevirtual 208	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   327: aload 4
    //   329: ifnull +8 -> 337
    //   332: aload 4
    //   334: invokevirtual 211	java/io/FileInputStream:close	()V
    //   337: return
    //   338: iconst_0
    //   339: istore_2
    //   340: goto -293 -> 47
    //   343: aload_0
    //   344: getfield 213	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   347: astore 4
    //   349: goto -184 -> 165
    //   352: iconst_0
    //   353: istore_2
    //   354: goto -180 -> 174
    //   357: astore_1
    //   358: aload_0
    //   359: sipush 9041
    //   362: ldc 215
    //   364: invokevirtual 206	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   367: aload_0
    //   368: invokevirtual 208	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   371: return
    //   372: aload 4
    //   374: ifnull +8 -> 382
    //   377: aload 4
    //   379: invokevirtual 211	java/io/FileInputStream:close	()V
    //   382: aload_0
    //   383: invokevirtual 217	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:e	()V
    //   386: return
    //   387: astore_1
    //   388: aload_0
    //   389: sipush 9041
    //   392: ldc 215
    //   394: invokevirtual 206	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   397: aload_0
    //   398: invokevirtual 208	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   401: return
    //   402: astore 5
    //   404: aconst_null
    //   405: astore 4
    //   407: aload 4
    //   409: astore_1
    //   410: aload_0
    //   411: aload 5
    //   413: invokevirtual 220	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Ljava/io/IOException;)V
    //   416: aload 4
    //   418: astore_1
    //   419: aload_0
    //   420: sipush 9041
    //   423: new 47	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   430: ldc 222
    //   432: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload 6
    //   437: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokevirtual 206	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   446: aload 4
    //   448: astore_1
    //   449: aload_0
    //   450: invokevirtual 208	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   453: aload 4
    //   455: ifnull -118 -> 337
    //   458: aload 4
    //   460: invokevirtual 211	java/io/FileInputStream:close	()V
    //   463: return
    //   464: astore_1
    //   465: aload_0
    //   466: sipush 9041
    //   469: ldc 215
    //   471: invokevirtual 206	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   474: aload_0
    //   475: invokevirtual 208	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   478: return
    //   479: astore 4
    //   481: aconst_null
    //   482: astore_1
    //   483: aload_1
    //   484: ifnull +7 -> 491
    //   487: aload_1
    //   488: invokevirtual 211	java/io/FileInputStream:close	()V
    //   491: aload 4
    //   493: athrow
    //   494: astore_1
    //   495: aload_0
    //   496: sipush 9041
    //   499: ldc 215
    //   501: invokevirtual 206	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   504: aload_0
    //   505: invokevirtual 208	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   508: return
    //   509: aload_0
    //   510: getfield 126	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Boolean	Z
    //   513: ifeq +8 -> 521
    //   516: aload_0
    //   517: invokevirtual 100	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:c	()V
    //   520: return
    //   521: aload_1
    //   522: getfield 146	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   525: sipush 9364
    //   528: if_icmpne +38 -> 566
    //   531: aload_0
    //   532: getfield 225	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:ay	I
    //   535: iconst_3
    //   536: if_icmpge +30 -> 566
    //   539: aload_0
    //   540: ldc 227
    //   542: ldc 229
    //   544: invokevirtual 137	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   547: aload_0
    //   548: aload_0
    //   549: getfield 225	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:ay	I
    //   552: iconst_1
    //   553: iadd
    //   554: putfield 225	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:ay	I
    //   557: aload_0
    //   558: invokevirtual 232	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:o	()V
    //   561: aload_0
    //   562: invokevirtual 100	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:c	()V
    //   565: return
    //   566: aload_0
    //   567: aload_1
    //   568: getfield 146	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   571: aload_1
    //   572: getfield 150	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   575: invokevirtual 206	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   578: aload_0
    //   579: invokevirtual 208	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   582: return
    //   583: astore 4
    //   585: goto -102 -> 483
    //   588: astore 5
    //   590: goto -183 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	593	0	this	ShortVideoDownloadProcessor
    //   0	593	1	paramNetResp	NetResp
    //   46	308	2	bool1	boolean
    //   1	172	3	bool2	boolean
    //   36	423	4	localObject1	java.lang.Object
    //   479	13	4	localObject2	java.lang.Object
    //   583	1	4	localObject3	java.lang.Object
    //   242	60	5	str1	String
    //   402	10	5	localIOException1	java.io.IOException
    //   588	1	5	localIOException2	java.io.IOException
    //   259	177	6	str2	String
    //   286	11	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   332	337	357	java/io/IOException
    //   377	382	387	java/io/IOException
    //   261	272	402	java/io/IOException
    //   458	463	464	java/io/IOException
    //   261	272	479	finally
    //   487	491	494	java/io/IOException
    //   275	288	583	finally
    //   296	309	583	finally
    //   312	320	583	finally
    //   323	327	583	finally
    //   410	416	583	finally
    //   419	446	583	finally
    //   449	453	583	finally
    //   275	288	588	java/io/IOException
    //   296	309	588	java/io/IOException
    //   312	320	588	java/io/IOException
    //   323	327	588	java/io/IOException
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    int i;
    if (paramRichProtoResp != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
        if (paramRichProtoReq.jdField_c_of_type_Int != 0) {
          break;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- mIpList:" + this.jdField_a_of_type_JavaUtilArrayList);
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- downResp.md5:" + Arrays.toString(paramRichProtoReq.jdField_a_of_type_ArrayOfByte));
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- downResp.md5:" + HexUtil.bytes2HexStr(paramRichProtoReq.jdField_a_of_type_ArrayOfByte));
        }
        this.jdField_e_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
        String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString;
        if ((!TextUtils.isEmpty(str)) && (paramRichProtoReq.jdField_a_of_type_ArrayOfByte != null) && (!str.equals(HexUtil.bytes2HexStr(paramRichProtoReq.jdField_a_of_type_ArrayOfByte))))
        {
          a(-5103066, "申请信令阶段md5校验失败");
          d();
        }
      }
      else
      {
        return;
      }
      q();
      i += 1;
    }
    if (-5100026 == this.aw) {
      a(-5100026, "安全打击");
    }
    for (;;)
    {
      d();
      return;
      a(9045, "申请信令失败");
    }
  }
  
  protected String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localServerAddr.jdField_a_of_type_JavaLangString);
    if (localServerAddr.jdField_b_of_type_Int != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localServerAddr.jdField_b_of_type_Int);
    }
    localStringBuilder.append("/qqdownload?ver=");
    localStringBuilder.append("544");
    localStringBuilder.append("&rkey=");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("&filetype=");
    localStringBuilder.append(this.aG);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "getConnUrl()---------- url = " + localStringBuilder.toString());
    }
    localStringBuilder.append("&mType=shortVideo");
    return localStringBuilder.toString();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.ShortVideoDownReq localShortVideoDownReq = new RichProto.RichProtoReq.ShortVideoDownReq();
    localShortVideoDownReq.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + localShortVideoDownReq.jdField_d_of_type_Int);
    }
    localShortVideoDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
    localShortVideoDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localShortVideoDownReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localShortVideoDownReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localShortVideoDownReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localShortVideoDownReq.jdField_e_of_type_Int = 0;
    if (localShortVideoDownReq.jdField_c_of_type_Int == 0) {
      localShortVideoDownReq.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localShortVideoDownReq.jdField_b_of_type_Int = 2;
      localShortVideoDownReq.jdField_a_of_type_JavaLangString = this.V;
      localShortVideoDownReq.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "short_video_dw";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localShortVideoDownReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (d()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
      if (1 == localShortVideoDownReq.jdField_c_of_type_Int) {
        localShortVideoDownReq.jdField_a_of_type_Int = 1;
      } else if (3000 == localShortVideoDownReq.jdField_c_of_type_Int) {
        localShortVideoDownReq.jdField_a_of_type_Int = 2;
      } else {
        localShortVideoDownReq.jdField_a_of_type_Int = 3;
      }
    }
    if (QLog.isColorLevel()) {
      a("requestStart", localRichProtoReq.toString());
    }
    if (!e())
    {
      jdField_a_of_type_JavaUtilHashSet.remove(this.V);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  protected void c(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aw))) {}
    while ((this.jdField_c_of_type_Boolean) || ((paramBoolean) && ((this.az & 0x2) > 0)) || ((!paramBoolean) && ((this.az & 0x1) > 0))) {
      return;
    }
    int j = this.az;
    int i;
    String str1;
    label88:
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.az = (i | j);
      str1 = "actShortVideoDownloadVideo";
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 7) {
        break label327;
      }
      str1 = "actShortVideoDownloadThumb";
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "reportTag = " + str1);
      }
      l = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.V);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long));
      if (!paramBoolean) {
        break label411;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      n();
      return;
      i = 1;
      break;
      label327:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 6)
      {
        str1 = "actShortVideoDownloadVideo";
        break label88;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 16) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 18))
      {
        str1 = "actShortVideoDiscussgroupDownloadThumb";
        break label88;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 9) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 17)) {
        break label88;
      }
      str1 = "actShortVideoDiscussgroupDownloadVideo";
      break label88;
      label411:
      if (this.aw != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aw));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.L);
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  void d()
  {
    super.d();
    jdField_a_of_type_JavaUtilHashSet.remove(this.V);
    if (-5100026 == this.aw) {
      d(5001);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errCode:" + this.aw);
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errDesc:" + this.L);
      }
      return;
      d(2005);
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendMessageToUpdate state = " + paramInt);
    }
    if ((this.jdField_d_of_type_Boolean) && (2004 != paramInt)) {
      return;
    }
    ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g == null)
    {
      a(9302, "下载路径文件保存路径未指定。");
      d();
      return -1;
    }
    this.g = true;
    return 0;
  }
  
  void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "successfully downloaded.");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.V);
    d(2003);
  }
  
  public int f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "resume()");
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.h = false;
      d(2001);
      this.aw = 0;
      this.L = "";
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new ehn(this));
    }
    return 0;
  }
  
  public int g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "cancel()");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.V);
    return super.g();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "pause() mIsPause : " + this.jdField_d_of_type_Boolean);
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      d(2004);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      }
    }
  }
  
  void q()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    String str = c();
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = str;
    localHttpNetReq.jdField_c_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localHttpNetReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
    localHttpNetReq.jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    localHttpNetReq.jdField_a_of_type_Long = 0L;
    ShortVideoUtils.a(localHttpNetReq.jdField_b_of_type_JavaLangString, localHttpNetReq.jdField_a_of_type_JavaLangString);
    localHttpNetReq.jdField_a_of_type_Boolean = true;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    a("httpDown", "url:" + str + ",downOffset:" + localHttpNetReq.jdField_a_of_type_Long);
    if (!e())
    {
      jdField_a_of_type_JavaUtilHashSet.remove(this.V);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
    p();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */