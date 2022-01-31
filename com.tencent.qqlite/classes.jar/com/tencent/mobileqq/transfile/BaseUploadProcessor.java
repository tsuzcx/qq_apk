package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseUploadProcessor
  extends BaseTransProcessor
{
  static final int aJ = 14600;
  static final int aK = 32768;
  static final int aL = 131072;
  String U;
  String V;
  public long a;
  public Transaction a;
  SSCM jdField_a_of_type_ComTencentWsttSSCMSSCM = new SSCM();
  RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean a;
  byte[] jdField_a_of_type_ArrayOfByte;
  int aG = 0;
  int aH = 0;
  int aI = 0;
  public int aM = 0;
  int ao;
  int ap;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = false;
  String c;
  String d;
  String e;
  String f;
  public long h = 0L;
  long i;
  boolean j = false;
  protected boolean k = false;
  
  public BaseUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_i_of_type_Long = 20480L;
    this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
    b(paramTransferRequest.jdField_b_of_type_JavaLangString + paramTransferRequest.jdField_a_of_type_Long);
    this.jdField_a_of_type_Boolean = paramTransferRequest.e;
  }
  
  protected long a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    return Math.min(this.jdField_i_of_type_Long, l - paramLong);
  }
  
  protected HttpNetReq a(byte[] paramArrayOfByte)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = a(paramArrayOfByte);
    localHttpNetReq.c = 1;
    localHttpNetReq.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localHttpNetReq.jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    localHttpNetReq.jdField_a_of_type_Boolean = true;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + this.h + "-");
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    return localHttpNetReq;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 1, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 1, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile.seek(paramInt1);
      byte[] arrayOfByte = new byte[paramInt2];
      int m = 0;
      paramInt1 = paramInt2;
      while (m < paramInt2)
      {
        int n = this.jdField_a_of_type_JavaIoRandomAccessFile.read(arrayOfByte, m, paramInt1);
        if (n == -1)
        {
          a(9303, "fileSize not enough");
          this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
          return null;
        }
        m += n;
        paramInt1 -= n;
      }
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      localIOException.printStackTrace();
    }
    return null;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    long l1 = this.h;
    long l2 = a(l1);
    Object localObject = a((int)l1, (int)l2);
    if (localObject == null) {
      d();
    }
    do
    {
      return;
      a("sendingdata", "pos:" + l1 + "  transferData len:" + localObject.length);
      localObject = a((byte[])localObject);
      if (l1 + l2 >= this.jdField_a_of_type_Long) {
        ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject);
    p();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, paramString);
    }
  }
  
  public int f()
  {
    return super.f();
  }
  
  /* Error */
  boolean f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 133	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   4: getfield 271	com/tencent/mobileqq/transfile/TransferRequest:h	Ljava/lang/String;
    //   7: astore_3
    //   8: new 273	java/io/FileInputStream
    //   11: dup
    //   12: aload_3
    //   13: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: astore_1
    //   19: aload_0
    //   20: aload_2
    //   21: aload_0
    //   22: getfield 278	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   25: getfield 281	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Long	J
    //   28: invokestatic 287	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   31: putfield 288	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   34: aload_2
    //   35: astore_1
    //   36: aload_0
    //   37: getfield 288	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   40: ifnonnull +49 -> 89
    //   43: aload_2
    //   44: astore_1
    //   45: aload_0
    //   46: sipush 9041
    //   49: new 79	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 290
    //   59: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_3
    //   63: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokevirtual 200	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	(ILjava/lang/String;)V
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 292	java/io/FileInputStream:close	()V
    //   80: iconst_0
    //   81: ireturn
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   87: iconst_0
    //   88: ireturn
    //   89: aload_2
    //   90: astore_1
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 288	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   96: invokestatic 297	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   99: putfield 298	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   102: aload_2
    //   103: astore_1
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 298	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   109: putfield 300	com/tencent/mobileqq/transfile/BaseUploadProcessor:c	Ljava/lang/String;
    //   112: aload_2
    //   113: astore_1
    //   114: aload_0
    //   115: getfield 278	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   118: aload_0
    //   119: getfield 298	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   122: putfield 301	com/tencent/mobileqq/transfile/FileMsg:h	Ljava/lang/String;
    //   125: aload_2
    //   126: astore_1
    //   127: aload_0
    //   128: new 79	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   135: aload_0
    //   136: getfield 298	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   139: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 303
    //   145: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_0
    //   149: getfield 305	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   152: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: putfield 298	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   161: aload_2
    //   162: ifnull +7 -> 169
    //   165: aload_2
    //   166: invokevirtual 292	java/io/FileInputStream:close	()V
    //   169: iconst_1
    //   170: ireturn
    //   171: astore_1
    //   172: aload_1
    //   173: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   176: goto -7 -> 169
    //   179: astore_3
    //   180: aconst_null
    //   181: astore_2
    //   182: aload_2
    //   183: astore_1
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 288	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   189: aload_2
    //   190: astore_1
    //   191: aload_0
    //   192: aload_3
    //   193: invokevirtual 210	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	(Ljava/io/IOException;)V
    //   196: aload_2
    //   197: ifnull -117 -> 80
    //   200: aload_2
    //   201: invokevirtual 292	java/io/FileInputStream:close	()V
    //   204: iconst_0
    //   205: ireturn
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   211: iconst_0
    //   212: ireturn
    //   213: astore_2
    //   214: aconst_null
    //   215: astore_1
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 292	java/io/FileInputStream:close	()V
    //   224: aload_2
    //   225: athrow
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   231: goto -7 -> 224
    //   234: astore_2
    //   235: goto -19 -> 216
    //   238: astore_3
    //   239: goto -57 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	BaseUploadProcessor
    //   18	27	1	localFileInputStream1	java.io.FileInputStream
    //   82	2	1	localIOException1	IOException
    //   90	37	1	localFileInputStream2	java.io.FileInputStream
    //   171	2	1	localIOException2	IOException
    //   183	8	1	localFileInputStream3	java.io.FileInputStream
    //   206	2	1	localIOException3	IOException
    //   215	6	1	localObject1	Object
    //   226	2	1	localIOException4	IOException
    //   16	185	2	localFileInputStream4	java.io.FileInputStream
    //   213	12	2	localObject2	Object
    //   234	1	2	localObject3	Object
    //   7	56	3	str	String
    //   179	14	3	localIOException5	IOException
    //   238	1	3	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   76	80	82	java/io/IOException
    //   165	169	171	java/io/IOException
    //   8	17	179	java/io/IOException
    //   200	204	206	java/io/IOException
    //   8	17	213	finally
    //   220	224	226	java/io/IOException
    //   19	34	234	finally
    //   36	43	234	finally
    //   45	72	234	finally
    //   91	102	234	finally
    //   104	112	234	finally
    //   114	125	234	finally
    //   127	161	234	finally
    //   184	189	234	finally
    //   191	196	234	finally
    //   19	34	238	java/io/IOException
    //   36	43	238	java/io/IOException
    //   45	72	238	java/io/IOException
    //   91	102	238	java/io/IOException
    //   104	112	238	java/io/IOException
    //   114	125	238	java/io/IOException
    //   127	161	238	java/io/IOException
  }
  
  public int g()
  {
    return super.g();
  }
  
  public void i()
  {
    super.i();
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        a("pause", "");
      }
      d(1004);
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
  
  protected void q()
  {
    int m = 1;
    if ((this.aM == 2) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("param_BdhTrans"))) {
      if ((this.f > 0L) && (this.g > 0L))
      {
        if ((this.jdField_i_of_type_Boolean) && (m != 0))
        {
          this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
          this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.aF).append("_").append("tr").append(this.f).append("_").append("ht").append(this.jdField_e_of_type_Long).append("_").append("pic").append(this.g).append(";");
          this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.g));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_CostEach", this.jdField_a_of_type_JavaLangStringBuilder.toString());
          this.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(this.aF));
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sn:").append(this.aF).append(";").append("tc_s:").append(this.f).append(";").append("tc_h:").append(this.jdField_e_of_type_Long).append(";").append("tc_p:").append(this.g).append(";");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", localStringBuilder.toString());
      }
    }
    while ((this.aM != 1) || (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction == null)) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        return;
        m = 0;
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.timeCost_Cache));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseUploadProcessor
 * JD-Core Version:    0.7.0.1
 */