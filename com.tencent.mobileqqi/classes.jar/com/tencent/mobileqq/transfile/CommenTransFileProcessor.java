package com.tencent.mobileqq.transfile;

import KQQFS.CheckVerifyCode;
import KQQFS.DefineAvatarInfo;
import KQQFS.HttpDownloadReq;
import KQQFS.HttpDownloadResp;
import KQQFS.HttpUploadReq;
import KQQFS.HttpUploadResp;
import KQQFS.RefreshVerifyCode;
import KQQFS.UsrInfo;
import KQQFS.VerifyCode;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import gnb;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import mqq.manager.VerifyCodeManager;
import mqq.observer.HttpVerifyHandler;

public abstract class CommenTransFileProcessor
  extends BaseTransProcessor
  implements IHttpCommunicatorListener, HttpVerifyHandler
{
  public static String S;
  public static String T;
  public static final String U = "9u23fh$jkf^%43hj";
  public static final String V = "http://120.196.213.173:8080/";
  public static final String W = "http://113.105.95.81:8080/";
  public static final String X = "http://163.177.66.82:8080/";
  static final String Y = "http://mqq.tc.qq.com/";
  private static SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String[] a;
  protected static final int aD = 1;
  protected static final int aE = 2;
  protected static final int aF = 3;
  protected static final int aG = 4;
  protected static final int aH = 5;
  protected static final int aI = 6;
  protected static final int aJ = 7;
  protected static final int aK = 1;
  protected static final int aL = 2;
  protected static final int aM = 3;
  protected static final int aN = 1;
  protected static final int aO = 2;
  protected static final int aP = 3;
  protected static final int aQ = 4;
  private static int aR = 0;
  private static final int aV = 1048576;
  private static final int aW = 122880;
  private static final int aX = -1;
  private static final int aY = -6102;
  private static final int aZ = 0;
  public static int ak = 122880;
  public static final int al = 16715521;
  public static final int am = 16715522;
  private static final int ba = 1;
  private static final int bb = 2;
  private static final int bc = 3;
  private static final int bd = 4;
  public static String e;
  public static String f;
  public static boolean h = true;
  private byte jdField_a_of_type_Byte;
  private HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  protected short a;
  protected boolean a;
  protected byte[] a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private int aS;
  private int aT;
  private int aU;
  protected int aj;
  private byte jdField_b_of_type_Byte;
  private byte[] jdField_b_of_type_ArrayOfByte;
  protected String c;
  protected String d;
  protected boolean g;
  private boolean i = false;
  
  static
  {
    jdField_e_of_type_JavaLangString = "http://112.90.138.173:8080/mmu/0";
    f = "http://112.90.138.173:8080/mmd/0";
    S = "http://112.90.138.173:8080/1/0";
    T = "http://112.90.138.173:8080/2/0";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "http://120.196.213.173:8080/", "http://113.105.95.81:8080/", "http://163.177.66.82:8080/" };
  }
  
  public CommenTransFileProcessor(String arg1, int paramInt, String paramString2, boolean paramBoolean, TransFileController paramTransFileController)
  {
    super(???, paramBoolean, paramTransFileController);
    this.jdField_a_of_type_Short = 0;
    this.jdField_a_of_type_Boolean = false;
    if (paramString2 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c(paramString2);
      this.jdField_b_of_type_Byte = TransfileUtile.a(paramString2);
    }
    this.d = ???;
    this.aj = paramInt;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.aT = 0;
    this.aU = 0;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      aR += 1;
      this.aS = aR;
      if (NetworkUtil.b(BaseApplication.getContext()) == 1)
      {
        ak = 1048576;
        return;
      }
    }
    ak = 122880;
  }
  
  private void a(JceInputStream paramJceInputStream)
  {
    for (;;)
    {
      HttpUploadResp localHttpUploadResp;
      int j;
      try
      {
        localHttpUploadResp = new HttpUploadResp();
        localHttpUploadResp.readFrom(paramJceInputStream);
        j = localHttpUploadResp.iReplyCode;
        if (!QLog.isColorLevel()) {
          break label397;
        }
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "decodeSendResp event " + j);
      }
      catch (Exception paramJceInputStream)
      {
        paramJceInputStream.printStackTrace();
        b(null, null);
        return;
      }
      b(null, null);
      return;
      this.aT = (localHttpUploadResp.uSeq + 1);
      this.aU = localHttpUploadResp.uFromPos;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d = this.aU;
      if (localHttpUploadResp.vFileKey != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString = a(localHttpUploadResp.vFileKey);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "decodeSendResp file.fileKey1 " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString);
      }
      q();
      f();
      return;
      k();
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
      if (localHttpUploadResp.vFileKey != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString = a(localHttpUploadResp.vFileKey);
        r();
        f();
        a(1003, 100L);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "decodeSendResp file.fileKey2 " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString);
        return;
        b(null, null);
      }
      k();
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_KQQFSVerifyCode = localHttpUploadResp.stVerifyCode;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ArrayOfByte = a();
      paramJceInputStream = new HashMap();
      paramJceInputStream.put("userInfo", this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ArrayOfByte);
      paramJceInputStream.put("key", a());
      ((VerifyCodeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(6)).onRecvHttpVerifyCode(this, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_KQQFSVerifyCode.vVerifyCode, a(), paramJceInputStream);
      d(3000);
      return;
      k();
      d(3002);
      return;
      d(3001);
      return;
      label397:
      switch (j)
      {
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface != null) && (paramString != null) && (!"".equals(paramString)))
    {
      paramAppInterface = paramString.toLowerCase();
      if (paramAppInterface.startsWith("http://"))
      {
        jdField_e_of_type_JavaLangString = paramAppInterface + "mmu/0";
        f = paramAppInterface + "mmd/0";
        S = paramAppInterface + "1/0";
        T = paramAppInterface + "2/0";
      }
    }
    else
    {
      return;
    }
    jdField_e_of_type_JavaLangString = "http://" + paramAppInterface + "/mmu/0";
    f = "http://" + paramAppInterface + "/mmd/0";
    S = "http://" + paramAppInterface + "/1/0";
    T = "http://" + paramAppInterface + "/2/0";
  }
  
  private void a(FileMsg paramFileMsg, byte[] paramArrayOfByte)
  {
    HttpMsg localHttpMsg = new HttpMsg(paramFileMsg.i, paramArrayOfByte, this);
    localHttpMsg.c("POST");
    localHttpMsg.b(5);
    localHttpMsg.a(true);
    if (this.i) {
      localHttpMsg.a("Connection", "close");
    }
    localHttpMsg.a("Content-Length", String.valueOf(paramArrayOfByte.length));
    b(localHttpMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localHttpMsg);
    paramFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new HttpMsg(paramString, paramArrayOfByte, this);
    paramString.c("POST");
    paramString.a("Content-Length", String.valueOf(paramArrayOfByte.length));
    paramString.a(false);
    paramString.b(5);
    b(paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(paramString);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new RefreshVerifyCode(paramArrayOfByte, (byte)2);
    a(T, paramArrayOfByte.toByteArray());
  }
  
  private void a(byte[] paramArrayOfByte, String paramString)
  {
    paramArrayOfByte = new CheckVerifyCode(paramArrayOfByte, paramString);
    a(S, paramArrayOfByte.toByteArray());
  }
  
  private byte[] a(HttpDownloadResp paramHttpDownloadResp)
  {
    byte[] arrayOfByte1 = paramHttpDownloadResp.vFileData;
    int m = arrayOfByte1.length;
    byte[] arrayOfByte2 = paramHttpDownloadResp.encryKey;
    int j = paramHttpDownloadResp.encryFrom;
    int k = paramHttpDownloadResp.encryTo;
    if ((1 == paramHttpDownloadResp.encryType) && (arrayOfByte2 != null) && (arrayOfByte2.length >= 1) && (j >= 0) && (j < m) && (k >= 0) && (k <= m))
    {
      m = arrayOfByte2[0];
      while (j < k)
      {
        arrayOfByte1[j] = ((byte)(arrayOfByte1[j] ^ m));
        j += 1;
      }
    }
    return arrayOfByte1;
  }
  
  private void b(JceInputStream paramJceInputStream)
  {
    for (;;)
    {
      HttpDownloadResp localHttpDownloadResp;
      int j;
      try
      {
        localHttpDownloadResp = new HttpDownloadResp();
        try
        {
          localHttpDownloadResp.readFrom(paramJceInputStream);
          j = localHttpDownloadResp.iReplyCode;
          if (!QLog.isColorLevel()) {
            break label435;
          }
          QLog.d("Q.profilecard.PhotoWall.Trans", 2, "decodeReceivedResp event " + j);
        }
        catch (Exception paramJceInputStream)
        {
          b(null, null);
          return;
        }
        b(null, null);
        return;
      }
      catch (Exception paramJceInputStream)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a();
        b(null, null);
        paramJceInputStream.printStackTrace();
        return;
      }
      this.aT += 1;
      this.aU += localHttpDownloadResp.vFileData.length;
      this.jdField_b_of_type_ArrayOfByte = a(localHttpDownloadResp);
      paramJceInputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      paramJceInputStream.d += this.jdField_b_of_type_ArrayOfByte.length;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = localHttpDownloadResp.uFileLen;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a().write(this.jdField_b_of_type_ArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a().flush();
      f();
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long > this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d)
      {
        s();
        return;
      }
      b(null, null);
      return;
      k();
      this.jdField_b_of_type_ArrayOfByte = a(localHttpDownloadResp);
      paramJceInputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      paramJceInputStream.d += this.jdField_b_of_type_ArrayOfByte.length;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = localHttpDownloadResp.uFileLen;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a().write(this.jdField_b_of_type_ArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a().flush();
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a();
      u();
      f();
      a(2003, 100L);
      return;
      k();
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_KQQFSVerifyCode = localHttpDownloadResp.stVerifyCode;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ArrayOfByte = a();
      paramJceInputStream = new HashMap();
      paramJceInputStream.put("userInfo", this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ArrayOfByte);
      paramJceInputStream.put("key", a());
      ((VerifyCodeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(6)).onRecvHttpVerifyCode(this, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_KQQFSVerifyCode.vVerifyCode, a(), paramJceInputStream);
      d(3000);
      return;
      k();
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a().close();
      d(3002);
      return;
      d(3001);
      return;
      label435:
      switch (j)
      {
      }
    }
  }
  
  private void b(HttpMsg paramHttpMsg)
  {
    if (a() == 1)
    {
      paramHttpMsg.d = 131073;
      return;
    }
    paramHttpMsg.d = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int;
    paramHttpMsg.jdField_e_of_type_Int = this.aj;
  }
  
  private byte c()
  {
    byte b1 = 2;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 65537)) {
      b1 = 1;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 2) {
      return b1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 3) {
      return 3;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 0) {
      return 4;
    }
    return 0;
  }
  
  private void c(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a().write(paramHttpMsg2.a());
      paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      paramHttpMsg1.d += paramHttpMsg2.a().length;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = paramHttpMsg2.a();
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d >= this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long)
      {
        k();
        u();
        f();
        a(2003, 100L);
        return;
      }
    }
    catch (IOException paramHttpMsg1)
    {
      do
      {
        for (;;)
        {
          paramHttpMsg1.printStackTrace();
        }
      } while (this.g);
      f();
    }
  }
  
  private byte d()
  {
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
      return 1;
    }
    return 4;
  }
  
  protected abstract byte a();
  
  protected abstract String a(byte[] paramArrayOfByte);
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokespecial 476	com/tencent/mobileqq/transfile/BaseTransProcessor:a	()V
    //   6: aload_0
    //   7: getfield 157	com/tencent/mobileqq/transfile/CommenTransFileProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: aload_0
    //   11: invokevirtual 478	com/tencent/mobileqq/transfile/CommenTransFileProcessor:d	()Ljava/lang/String;
    //   14: invokestatic 480	com/tencent/mobileqq/transfile/CommenTransFileProcessor:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 138	com/tencent/mobileqq/transfile/CommenTransFileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   21: astore_2
    //   22: aload_0
    //   23: getfield 138	com/tencent/mobileqq/transfile/CommenTransFileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   26: getfield 482	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Int	I
    //   29: ifne +28 -> 57
    //   32: getstatic 104	com/tencent/mobileqq/transfile/CommenTransFileProcessor:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   35: astore_1
    //   36: aload_2
    //   37: aload_1
    //   38: invokevirtual 484	com/tencent/mobileqq/transfile/FileMsg:e	(Ljava/lang/String;)V
    //   41: invokestatic 183	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   44: invokestatic 487	com/tencent/mobileqq/utils/NetworkUtil:e	(Landroid/content/Context;)Z
    //   47: ifne +17 -> 64
    //   50: aload_0
    //   51: aconst_null
    //   52: aconst_null
    //   53: invokevirtual 229	com/tencent/mobileqq/transfile/CommenTransFileProcessor:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   56: return
    //   57: getstatic 108	com/tencent/mobileqq/transfile/CommenTransFileProcessor:f	Ljava/lang/String;
    //   60: astore_1
    //   61: goto -25 -> 36
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 475	com/tencent/mobileqq/transfile/CommenTransFileProcessor:g	Z
    //   69: aload_0
    //   70: getfield 138	com/tencent/mobileqq/transfile/CommenTransFileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   73: getfield 482	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Int	I
    //   76: ifne +112 -> 188
    //   79: new 489	java/io/FileInputStream
    //   82: dup
    //   83: aload_0
    //   84: getfield 138	com/tencent/mobileqq/transfile/CommenTransFileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   87: getfield 490	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   90: invokespecial 492	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   93: astore_2
    //   94: aload_2
    //   95: astore_1
    //   96: aload_0
    //   97: aload_2
    //   98: aload_0
    //   99: getfield 138	com/tencent/mobileqq/transfile/CommenTransFileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   102: getfield 260	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Long	J
    //   105: invokestatic 498	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   108: putfield 500	com/tencent/mobileqq/transfile/CommenTransFileProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   111: aload_2
    //   112: astore_1
    //   113: aload_0
    //   114: invokevirtual 250	com/tencent/mobileqq/transfile/CommenTransFileProcessor:q	()V
    //   117: aload_2
    //   118: astore_1
    //   119: aload_0
    //   120: sipush 1001
    //   123: invokevirtual 311	com/tencent/mobileqq/transfile/CommenTransFileProcessor:d	(I)V
    //   126: aload_2
    //   127: ifnull -71 -> 56
    //   130: aload_2
    //   131: invokevirtual 501	java/io/FileInputStream:close	()V
    //   134: return
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   140: return
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_2
    //   144: aload_2
    //   145: astore_1
    //   146: aload_0
    //   147: aconst_null
    //   148: aconst_null
    //   149: invokevirtual 229	com/tencent/mobileqq/transfile/CommenTransFileProcessor:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   152: aload_2
    //   153: ifnull -97 -> 56
    //   156: aload_2
    //   157: invokevirtual 501	java/io/FileInputStream:close	()V
    //   160: return
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   166: return
    //   167: astore_1
    //   168: aload_3
    //   169: astore_2
    //   170: aload_2
    //   171: ifnull +7 -> 178
    //   174: aload_2
    //   175: invokevirtual 501	java/io/FileInputStream:close	()V
    //   178: aload_1
    //   179: athrow
    //   180: astore_2
    //   181: aload_2
    //   182: invokevirtual 473	java/io/IOException:printStackTrace	()V
    //   185: goto -7 -> 178
    //   188: aload_0
    //   189: getfield 138	com/tencent/mobileqq/transfile/CommenTransFileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   192: getfield 482	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Int	I
    //   195: iconst_1
    //   196: if_icmpne -140 -> 56
    //   199: aload_0
    //   200: getfield 138	com/tencent/mobileqq/transfile/CommenTransFileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   203: getfield 490	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   206: ifnonnull +16 -> 222
    //   209: aload_0
    //   210: getfield 138	com/tencent/mobileqq/transfile/CommenTransFileProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   213: aload_0
    //   214: getfield 152	com/tencent/mobileqq/transfile/CommenTransFileProcessor:d	Ljava/lang/String;
    //   217: aconst_null
    //   218: invokevirtual 504	com/tencent/mobileqq/transfile/FileMsg:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   221: pop
    //   222: aload_0
    //   223: invokevirtual 450	com/tencent/mobileqq/transfile/CommenTransFileProcessor:s	()V
    //   226: aload_0
    //   227: sipush 2001
    //   230: invokevirtual 311	com/tencent/mobileqq/transfile/CommenTransFileProcessor:d	(I)V
    //   233: return
    //   234: astore_3
    //   235: aload_1
    //   236: astore_2
    //   237: aload_3
    //   238: astore_1
    //   239: goto -69 -> 170
    //   242: astore_1
    //   243: goto -99 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	CommenTransFileProcessor
    //   35	84	1	localObject1	Object
    //   135	2	1	localIOException1	IOException
    //   141	1	1	localIOException2	IOException
    //   145	1	1	localObject2	Object
    //   161	2	1	localIOException3	IOException
    //   167	69	1	localObject3	Object
    //   238	1	1	localObject4	Object
    //   242	1	1	localIOException4	IOException
    //   21	154	2	localObject5	Object
    //   180	2	2	localIOException5	IOException
    //   236	1	2	localObject6	Object
    //   1	168	3	localObject7	Object
    //   234	4	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   130	134	135	java/io/IOException
    //   79	94	141	java/io/IOException
    //   156	160	161	java/io/IOException
    //   79	94	167	finally
    //   174	178	180	java/io/IOException
    //   96	111	234	finally
    //   113	117	234	finally
    //   119	126	234	finally
    //   146	152	234	finally
    //   96	111	242	java/io/IOException
    //   113	117	242	java/io/IOException
    //   119	126	242	java/io/IOException
  }
  
  public void a(byte paramByte)
  {
    if (paramByte > 0)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Byte = paramByte;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.PhotoWall.Trans", 2, "Trans decode " + paramHttpMsg2.g);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfInt)
      {
        if (this.g) {
          return;
        }
        l();
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 1) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 65537)))
        {
          c(paramHttpMsg1, paramHttpMsg2);
          return;
        }
      }
      paramHttpMsg1 = new JceInputStream(paramHttpMsg2.a());
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {
        a(paramHttpMsg1);
      } else if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 1) {
        b(paramHttpMsg1);
      }
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, HashMap paramHashMap)
  {
    a((byte[])paramHashMap.get("userInfo"), paramString);
  }
  
  public void a(HashMap paramHashMap)
  {
    a((byte[])paramHashMap.get("userInfo"));
  }
  
  public void a(short paramShort)
  {
    this.jdField_a_of_type_Short = paramShort;
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if ((paramHttpMsg2 != null) && (paramInt == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "statusChanged() begin");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) && (QLog.isColorLevel())) {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "filekey = " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "respHeader : " + paramHttpMsg2.ag);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "statusChanged() end");
      }
    }
    return true;
  }
  
  public byte[] a()
  {
    return new Cryptor().encrypt(new UsrInfo(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), Long.valueOf(this.d).longValue(), this.aS, this.aT, AppSetting.jdField_a_of_type_Int, (short)a(), (short)c(), (short)1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid().getBytes(), (byte)1, b(), d(), b()).toByteArray(), "9u23fh$jkf^%43hj".getBytes());
  }
  
  protected abstract byte[] a(String paramString);
  
  protected abstract byte b();
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    k();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0)
    {
      d(1005);
      FMTSrvAddrProvider.a().a(0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
    }
    for (;;)
    {
      h();
      return;
      d(2005);
      FMTSrvAddrProvider.a().a(1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
    }
  }
  
  protected abstract byte[] b();
  
  protected String c()
  {
    return String.valueOf(this.jdField_a_of_type_Short);
  }
  
  public void c()
  {
    super.a();
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b(paramString);
  }
  
  public void cancelVerifyCode(String paramString, HashMap paramHashMap) {}
  
  protected String d()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    QLog.i("Q.profilecard.PhotoWall.Trans", 2, "getServerAddress|url = " + str);
    return str;
  }
  
  public void d(String paramString)
  {
    paramString = new HttpMsg(paramString, null, this);
    paramString.c("GET");
    paramString.b(5);
    paramString.a(true);
    paramString.a("Accept-Encoding", "identity");
    b(paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramString;
  }
  
  protected String e()
  {
    if (NetworkUtil.b(BaseApplication.getContext())) {
      return "http://113.105.95.81:8080/";
    }
    return "http://163.177.66.82:8080/";
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int = paramInt;
  }
  
  public void g()
  {
    super.g();
    this.g = false;
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, d());
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0)
    {
      str = jdField_e_of_type_JavaLangString;
      localFileMsg.e(str);
      if (this.aU != 0) {
        break label63;
      }
      a();
    }
    label63:
    do
    {
      return;
      str = f;
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0)
      {
        q();
        f();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int != 1);
    s();
    f();
  }
  
  protected int h()
  {
    DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    int j = localDisplayMetrics.widthPixels;
    int k = localDisplayMetrics.heightPixels;
    if (j > k) {
      return j;
    }
    return k;
  }
  
  public void h()
  {
    super.h();
    this.g = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    }
  }
  
  public void i()
  {
    super.i();
  }
  
  protected void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u == 2003) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u == 1003)) {
      return;
    }
    b(null, null);
  }
  
  protected void q()
  {
    int j = 1;
    int k = 0;
    Object localObject2 = a();
    try
    {
      Object localObject1;
      label41:
      byte b1;
      long l;
      label79:
      int m;
      byte[] arrayOfByte;
      StringBuilder localStringBuilder;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = new DefineAvatarInfo(this.jdField_a_of_type_Byte, this.jdField_b_of_type_Byte);
        if (!this.jdField_a_of_type_Boolean) {
          break label337;
        }
        b1 = (byte)j;
        if (ak + this.aU <= this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long) {
          break label342;
        }
        l = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long - this.aU;
        m = (int)l;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall.Trans", 2, "dataSliceSize: " + ak + "  fromPos : " + this.aU + " file.fileSize: " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
        }
        arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(this.aU, m);
        if (this.aU + m >= this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long) {
          this.i = true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall.Trans", 2, "slice length: " + m);
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("buff length: ");
          if (arrayOfByte != null) {
            break label351;
          }
        }
      }
      label337:
      label342:
      label351:
      for (j = k;; j = arrayOfByte.length)
      {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, j);
        localObject2 = new HttpUploadReq((byte[])localObject2, (int)this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.aU, m, arrayOfByte, b1, (DefineAvatarInfo)localObject1, null);
        localObject1 = new JceOutputStream();
        ((HttpUploadReq)localObject2).writeTo((JceOutputStream)localObject1);
        try
        {
          localObject2 = ((JceOutputStream)localObject1).toByteArray();
          a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg, (byte[])localObject2);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          System.gc();
          localObject1 = new gnb(this, (JceOutputStream)localObject1);
          new Timer().schedule((TimerTask)localObject1, 350L);
          return;
        }
        localObject1 = null;
        break;
        j = 0;
        break label41;
        l = ak;
        break label79;
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "OOM happened when assembling data packet.");
      }
      b(null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      b(null, null);
    }
  }
  
  protected abstract void r();
  
  public void refreVerifyCode(String paramString, HashMap paramHashMap)
  {
    if ((paramString != null) && (paramString.equals(a()))) {
      a(paramHashMap);
    }
  }
  
  protected void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 65537))
    {
      t();
      return;
    }
    Object localObject1 = new HttpDownloadReq(a(), a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString), this.aU, ak, this.jdField_a_of_type_Short);
    try
    {
      Object localObject2 = new JceOutputStream();
      ((HttpDownloadReq)localObject1).writeTo((JceOutputStream)localObject2);
      localObject1 = ((JceOutputStream)localObject2).toByteArray();
      localObject2 = new HttpMsg(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, (byte[])localObject1, this);
      ((HttpMsg)localObject2).c("POST");
      ((HttpMsg)localObject2).b(5);
      ((HttpMsg)localObject2).a(false);
      ((HttpMsg)localObject2).a("Content-Length", String.valueOf(localObject1.length));
      b((HttpMsg)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((HttpMsg)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = ((HttpMsg)localObject2);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, localException.toString());
      }
      b(null, null);
    }
  }
  
  public void submitVerifyCode(String paramString1, HashMap paramHashMap, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(a()))) {
      a(paramString2, paramHashMap);
    }
  }
  
  protected void t()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = FMTSrvAddrProvider.a().a(1);
    if (str != null) {
      localStringBuilder.append(str);
    }
    for (;;)
    {
      localStringBuilder.append("mqq_photo/").append(this.jdField_c_of_type_JavaLangString).append("/").append(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString).append("/").append(c());
      d(localStringBuilder.toString());
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall.Trans", 2, "common file receive: " + localStringBuilder.toString());
      }
      return;
      localStringBuilder.append("http://mqq.tc.qq.com/");
    }
  }
  
  protected abstract void u();
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0)
    {
      d(1004);
      return;
    }
    d(2004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.CommenTransFileProcessor
 * JD-Core Version:    0.7.0.1
 */