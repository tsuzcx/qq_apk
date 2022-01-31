package com.tencent.mobileqq.transfile;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gnn;

public class LbsTransfileProcessor
  extends CommenTransFileProcessor
{
  public static final String Z = "LbsTransfileProcessor";
  MessageObserver a;
  private final String aa;
  
  public LbsTransfileProcessor(String paramString1, int paramInt, String paramString2, boolean paramBoolean, TransFileController paramTransFileController)
  {
    super(paramString1, paramInt, paramString2, paramBoolean, paramTransFileController);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new gnn(this);
    b(false);
    this.aa = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e();
  }
  
  private void w()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
    try
    {
      localObject = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.d, 1001, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      ((MessageForPtt)localObject).url = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
      ((MessageForPtt)localObject).fileSize = -1L;
      ((MessageForPtt)localObject).urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString;
      ((MessageForPtt)localObject).itemType = 0;
      ((MessageForPtt)localObject).isReadPtt = true;
      ((MessageForPtt)localObject).serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.d, 1001, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, ((MessageForPtt)localObject).msgData);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.d, this.aj);
      if ((localObject != null) && (((QQMessageFacade.Message)localObject).pttUrl != null) && (((QQMessageFacade.Message)localObject).pttUrl.equals(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString))) {
        ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected byte a()
  {
    return 4;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 125	com/tencent/mobileqq/transfile/LbsTransfileProcessor:c	()V
    //   4: aload_0
    //   5: getfield 29	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: aload_0
    //   9: invokevirtual 127	com/tencent/mobileqq/transfile/LbsTransfileProcessor:d	()Ljava/lang/String;
    //   12: invokestatic 130	com/tencent/mobileqq/transfile/LbsTransfileProcessor:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   19: ifnull +13 -> 32
    //   22: aload_0
    //   23: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   26: getfield 49	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   29: ifnonnull +57 -> 86
    //   32: aload_0
    //   33: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   36: ifnonnull +44 -> 80
    //   39: ldc 132
    //   41: astore_1
    //   42: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +28 -> 73
    //   48: ldc 8
    //   50: iconst_2
    //   51: new 140	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   58: ldc 144
    //   60: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_0
    //   74: aconst_null
    //   75: aconst_null
    //   76: invokevirtual 157	com/tencent/mobileqq/transfile/LbsTransfileProcessor:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   79: return
    //   80: ldc 159
    //   82: astore_1
    //   83: goto -41 -> 42
    //   86: aload_0
    //   87: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   90: ifnull +27 -> 117
    //   93: aload_0
    //   94: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   97: astore_2
    //   98: aload_0
    //   99: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   102: getfield 161	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Int	I
    //   105: ifne +28 -> 133
    //   108: getstatic 162	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   111: astore_1
    //   112: aload_2
    //   113: aload_1
    //   114: invokevirtual 165	com/tencent/mobileqq/transfile/FileMsg:e	(Ljava/lang/String;)V
    //   117: invokestatic 171	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   120: invokestatic 176	com/tencent/mobileqq/utils/NetworkUtil:e	(Landroid/content/Context;)Z
    //   123: ifne +17 -> 140
    //   126: aload_0
    //   127: aconst_null
    //   128: aconst_null
    //   129: invokevirtual 157	com/tencent/mobileqq/transfile/LbsTransfileProcessor:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   132: return
    //   133: getstatic 179	com/tencent/mobileqq/transfile/LbsTransfileProcessor:f	Ljava/lang/String;
    //   136: astore_1
    //   137: goto -25 -> 112
    //   140: aload_0
    //   141: iconst_0
    //   142: putfield 182	com/tencent/mobileqq/transfile/LbsTransfileProcessor:g	Z
    //   145: aload_0
    //   146: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   149: ifnull +118 -> 267
    //   152: aload_0
    //   153: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   156: getfield 161	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Int	I
    //   159: ifne +108 -> 267
    //   162: aload_0
    //   163: sipush 1001
    //   166: invokevirtual 185	com/tencent/mobileqq/transfile/LbsTransfileProcessor:d	(I)V
    //   169: new 187	java/io/FileInputStream
    //   172: dup
    //   173: aload_0
    //   174: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   177: getfield 49	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   180: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   183: astore_2
    //   184: aload_2
    //   185: astore_1
    //   186: aload_0
    //   187: aload_2
    //   188: aload_0
    //   189: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   192: getfield 191	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Long	J
    //   195: invokestatic 197	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   198: putfield 199	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   201: aload_2
    //   202: astore_1
    //   203: aload_0
    //   204: invokevirtual 202	com/tencent/mobileqq/transfile/LbsTransfileProcessor:q	()V
    //   207: aload_2
    //   208: ifnull -129 -> 79
    //   211: aload_2
    //   212: invokevirtual 205	java/io/FileInputStream:close	()V
    //   215: return
    //   216: astore_1
    //   217: aload_1
    //   218: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   221: return
    //   222: astore_3
    //   223: aconst_null
    //   224: astore_2
    //   225: aload_2
    //   226: astore_1
    //   227: aload_3
    //   228: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   231: aload_2
    //   232: ifnull -153 -> 79
    //   235: aload_2
    //   236: invokevirtual 205	java/io/FileInputStream:close	()V
    //   239: return
    //   240: astore_1
    //   241: aload_1
    //   242: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   245: return
    //   246: astore_2
    //   247: aconst_null
    //   248: astore_1
    //   249: aload_1
    //   250: ifnull +7 -> 257
    //   253: aload_1
    //   254: invokevirtual 205	java/io/FileInputStream:close	()V
    //   257: aload_2
    //   258: athrow
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   264: goto -7 -> 257
    //   267: aload_0
    //   268: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   271: ifnull -192 -> 79
    //   274: aload_0
    //   275: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   278: getfield 161	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Int	I
    //   281: iconst_1
    //   282: if_icmpne -203 -> 79
    //   285: aload_0
    //   286: sipush 2001
    //   289: invokevirtual 185	com/tencent/mobileqq/transfile/LbsTransfileProcessor:d	(I)V
    //   292: aload_0
    //   293: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   296: getfield 208	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_Int	I
    //   299: ldc 209
    //   301: if_icmpeq +14 -> 315
    //   304: aload_0
    //   305: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   308: getfield 208	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_Int	I
    //   311: iconst_1
    //   312: if_icmpne +96 -> 408
    //   315: aload_0
    //   316: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   319: getfield 49	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   322: ifnull +16 -> 338
    //   325: aload_0
    //   326: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   329: getfield 49	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   332: invokestatic 214	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;)Z
    //   335: ifne +22 -> 357
    //   338: aload_0
    //   339: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   342: aload_0
    //   343: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   346: aload_0
    //   347: getfield 55	com/tencent/mobileqq/transfile/LbsTransfileProcessor:d	Ljava/lang/String;
    //   350: aconst_null
    //   351: invokevirtual 217	com/tencent/mobileqq/transfile/FileMsg:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   354: putfield 49	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   357: aload_0
    //   358: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   361: new 140	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   368: aload_0
    //   369: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   372: getfield 49	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   375: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: ldc 219
    //   380: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: putfield 221	com/tencent/mobileqq/transfile/FileMsg:g	Ljava/lang/String;
    //   389: aload_0
    //   390: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   393: aload_0
    //   394: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   397: getfield 221	com/tencent/mobileqq/transfile/FileMsg:g	Ljava/lang/String;
    //   400: invokevirtual 223	com/tencent/mobileqq/transfile/FileMsg:f	(Ljava/lang/String;)V
    //   403: aload_0
    //   404: invokevirtual 226	com/tencent/mobileqq/transfile/LbsTransfileProcessor:s	()V
    //   407: return
    //   408: aload_0
    //   409: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   412: getfield 49	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   415: ifnull +16 -> 431
    //   418: aload_0
    //   419: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   422: getfield 49	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   425: invokevirtual 230	java/lang/String:length	()I
    //   428: ifne -25 -> 403
    //   431: aload_0
    //   432: getfield 45	com/tencent/mobileqq/transfile/LbsTransfileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   435: aload_0
    //   436: getfield 55	com/tencent/mobileqq/transfile/LbsTransfileProcessor:d	Ljava/lang/String;
    //   439: aconst_null
    //   440: invokevirtual 232	com/tencent/mobileqq/transfile/FileMsg:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   443: pop
    //   444: goto -41 -> 403
    //   447: astore_2
    //   448: goto -199 -> 249
    //   451: astore_3
    //   452: goto -227 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	this	LbsTransfileProcessor
    //   41	162	1	localObject1	Object
    //   216	2	1	localIOException1	java.io.IOException
    //   226	1	1	localObject2	Object
    //   240	2	1	localIOException2	java.io.IOException
    //   248	6	1	localObject3	Object
    //   259	2	1	localIOException3	java.io.IOException
    //   97	139	2	localObject4	Object
    //   246	12	2	localObject5	Object
    //   447	1	2	localObject6	Object
    //   222	6	3	localIOException4	java.io.IOException
    //   451	1	3	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   211	215	216	java/io/IOException
    //   162	184	222	java/io/IOException
    //   235	239	240	java/io/IOException
    //   162	184	246	finally
    //   253	257	259	java/io/IOException
    //   186	201	447	finally
    //   203	207	447	finally
    //   227	231	447	finally
    //   186	201	451	java/io/IOException
    //   203	207	451	java/io/IOException
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    byte b = 0;
    if ((paramInt == 1) || (paramInt == 65538)) {
      b = 3;
    }
    for (;;)
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, 1001);
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString2, paramString5, b, paramString3, l, paramString1.uniseq);
      return;
      if (paramInt == 2) {
        b = 4;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 65537)) {
        break label166;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.d, 1001, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      if ((localObject2 instanceof MessageForPic))
      {
        localObject2 = (MessageForPic)localObject2;
        ((MessageForPic)localObject2).size = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
        ((MessageForPic)localObject2).uuid = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString;
        ((MessageForPic)localObject2).path = ((String)localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.S != 1) {
          break label161;
        }
        paramBoolean = true;
        label112:
        ((MessageForPic)localObject2).isRead = paramBoolean;
        ((MessageForPic)localObject2).serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.d, 1001, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, ((MessageForPic)localObject2).msgData);
      }
    }
    for (;;)
    {
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i;
      break;
      label161:
      paramBoolean = false;
      break label112;
      label166:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 2) {
        try
        {
          localObject1 = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.d, 1001, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
          ((MessageForPtt)localObject1).url = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
          ((MessageForPtt)localObject1).fileSize = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
          ((MessageForPtt)localObject1).urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString;
          ((MessageForPtt)localObject1).itemType = 2;
          ((MessageForPtt)localObject1).serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.d, 1001, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, ((MessageForPtt)localObject1).msgData);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.d, this.aj);
          if ((localObject1 != null) && (((QQMessageFacade.Message)localObject1).pttUrl != null) && (((QQMessageFacade.Message)localObject1).pttUrl.equals(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString)))
          {
            ((QQMessageFacade.Message)localObject1).pttUrl = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 1) && (paramInt == 3))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 65537) {
        break label38;
      }
      c(paramHttpMsg2.a());
    }
    label38:
    while (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 1) {
      return true;
    }
    b(paramHttpMsg2.a());
    return true;
  }
  
  protected byte[] a(String paramString)
  {
    return paramString.getBytes();
  }
  
  protected byte b()
  {
    return 0;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    super.b(paramHttpMsg1, paramHttpMsg2);
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 2)) {
      w();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.d, 1001, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, 0);
  }
  
  protected byte[] b()
  {
    return null;
  }
  
  protected String c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 65537) {
      return "100";
    }
    return "0";
  }
  
  protected String d()
  {
    Object localObject2 = null;
    FMTSrvAddrProvider localFMTSrvAddrProvider = FMTSrvAddrProvider.a();
    Object localObject1 = localObject2;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null)
    {
      localObject1 = localObject2;
      if (localFMTSrvAddrProvider != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int != 0) {
          break label96;
        }
        i = 1;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 2) {
          break label101;
        }
        localObject1 = localFMTSrvAddrProvider.a(0);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = e();
      }
      QLog.i("Q.profilecard.PhotoWall.Trans", 2, "getServerAddress|url = " + (String)localObject2);
      return localObject2;
      label96:
      i = 0;
      break;
      label101:
      if (i != 0) {
        localObject1 = localFMTSrvAddrProvider.a(0);
      } else {
        localObject1 = localFMTSrvAddrProvider.a(1);
      }
    }
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString = paramString;
    }
  }
  
  protected void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.d, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
    a(true);
    a(this.jdField_c_of_type_JavaLangString, this.d, this.aa, null, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString);
  }
  
  protected void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 65537) {}
    for (int i = 1;; i = 0)
    {
      byte b = (byte)i;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString, b, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      return;
    }
  }
  
  protected void u()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.d, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
    a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 65537)
    {
      str = ImageUtil.a(BaseApplication.getContext(), Uri.parse(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString));
      FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.g, str);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 1)
    {
      String str;
      return;
    }
    FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.g, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.LbsTransfileProcessor
 * JD-Core Version:    0.7.0.1
 */