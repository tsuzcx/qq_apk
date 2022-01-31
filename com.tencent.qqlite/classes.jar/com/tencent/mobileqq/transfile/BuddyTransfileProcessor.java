package com.tencent.mobileqq.transfile;

import QQService.StreamData;
import QQService.StreamInfo;
import android.os.Environment;
import android.os.StatFs;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ehq;
import ehr;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BuddyTransfileProcessor
  extends BaseTransProcessor
{
  public static final String U = "pttcenter";
  public static final String V = "picplatform";
  private static final String Z = "photo/";
  public static final int aL = 0;
  public static final int aM = 1;
  public static final int aN = 2;
  private static final String aa = "file/";
  private static List jdField_b_of_type_JavaUtilList = new ArrayList();
  public static final String c = "streamptt";
  public static final String d = "streamptt.recv";
  public static final String e = "streamptt.send";
  public static final String f = "ftn";
  public static boolean k = true;
  private String W = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  private String X;
  private String Y;
  long jdField_a_of_type_Long = -1L;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ehq(this);
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  public boolean a;
  int aG = 0;
  int aH = -1;
  int aI = -1;
  public int aJ = 0;
  public int aK = 0;
  private int aO;
  int ao = 0;
  int ap = 1;
  private long jdField_b_of_type_Long;
  public boolean b;
  public boolean j = false;
  public boolean l = false;
  public boolean m = false;
  private boolean n = false;
  
  public BuddyTransfileProcessor(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, int paramInt1, int paramInt2, boolean paramBoolean2, TransFileController paramTransFileController, long paramLong)
  {
    super(paramString1, paramString2, paramBoolean1, paramTransFileController);
    this.jdField_a_of_type_Boolean = false;
    paramInt2 = paramInt1;
    if (paramInt1 == 131075)
    {
      paramInt2 = 1;
      this.jdField_a_of_type_Boolean = true;
    }
    this.Y = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.p = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.q = this.W;
    if ((!paramBoolean1) && (paramBoolean2))
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.m = this.W;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.n = paramString1;
    }
    for (this.X = this.W;; this.X = paramString1)
    {
      b(false);
      e(paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.aT = 0;
      if (FileUtils.c(paramString3)) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString = paramString3;
      }
      if ((paramString4 != null) && (!FileUtils.c(paramString4))) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i = paramString4;
      }
      if (paramInt2 == 65538)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.h = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d = "gif";
      }
      if (paramInt2 == 2) {
        RichMediaUtil.c(AppSetting.jdField_a_of_type_Int);
      }
      if ((paramInt2 == 2) && (paramBoolean1))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.X, 0, paramLong);
        if (paramString1 != null)
        {
          this.jdField_b_of_type_Long = MessageUtils.a(paramString1.msgUid);
          this.aO = ((int)paramString1.shmsgseq);
        }
        if (QLog.isColorLevel()) {
          QLog.e("streamptt", 2, "random:" + this.jdField_b_of_type_Long + " msgseq:" + this.aO);
        }
      }
      return;
    }
  }
  
  public static BuddyTransfileProcessor.A9Message a(byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    BuddyTransfileProcessor.A9Message localA9Message = new BuddyTransfileProcessor.A9Message();
    long l1 = paramArrayOfLong[0];
    byte[] arrayOfByte;
    if (paramArrayOfByte[0] == 1)
    {
      localA9Message.jdField_a_of_type_Byte = paramArrayOfByte[1];
      int i2 = PkgTools.a(paramArrayOfByte, 2) + 4;
      int i1 = paramArrayOfByte[i2];
      int i = i1;
      if (i1 < 0) {
        i = i1 + 256;
      }
      i1 = i2 + 1;
      arrayOfByte = new byte[i];
      PkgTools.a(arrayOfByte, 0, paramArrayOfByte, i1, i);
      i += i1;
      l1 = PkgTools.a(paramArrayOfByte, i + 2 + PkgTools.a(paramArrayOfByte, i));
      if (arrayOfByte != null) {
        if (l1 > 10000L) {
          paramArrayOfLong[0] = l1;
        }
      }
    }
    for (paramArrayOfByte = new String(arrayOfByte);; paramArrayOfByte = null)
    {
      localA9Message.jdField_a_of_type_JavaLangString = paramArrayOfByte;
      return localA9Message;
    }
  }
  
  public static BuddyTransfileProcessor.C2CPicMsgParseResult a(byte[] paramArrayOfByte, short paramShort, long[] paramArrayOfLong)
  {
    BuddyTransfileProcessor.C2CPicMsgParseResult localC2CPicMsgParseResult;
    long l1;
    if (paramArrayOfByte != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "getFileUuid msgHex:" + HexUtil.bytes2HexStr(paramArrayOfByte));
      }
      localC2CPicMsgParseResult = new BuddyTransfileProcessor.C2CPicMsgParseResult();
      if (paramShort != 169) {
        break label383;
      }
      localC2CPicMsgParseResult.jdField_a_of_type_Int = 1;
      if (paramArrayOfByte[0] != 1) {
        break label410;
      }
      paramShort = paramArrayOfByte[1];
      int i = PkgTools.a(paramArrayOfByte, 2);
      localC2CPicMsgParseResult.jdField_a_of_type_ArrayOfByte = new byte[i];
      PkgTools.a(localC2CPicMsgParseResult.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, 4, i);
      int i1 = i + 4;
      i = paramArrayOfByte[i1];
      i1 += 1;
      localC2CPicMsgParseResult.jdField_b_of_type_ArrayOfByte = new byte[i];
      PkgTools.a(localC2CPicMsgParseResult.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte, i1, i);
      i1 += i;
      i = PkgTools.a(paramArrayOfByte, i1);
      i1 += 2;
      localC2CPicMsgParseResult.jdField_c_of_type_ArrayOfByte = new byte[i];
      PkgTools.a(localC2CPicMsgParseResult.jdField_c_of_type_ArrayOfByte, 0, paramArrayOfByte, i1, i);
      l1 = PkgTools.a(paramArrayOfByte, i1 + i);
    }
    for (;;)
    {
      if (localC2CPicMsgParseResult.jdField_b_of_type_ArrayOfByte != null)
      {
        localC2CPicMsgParseResult.jdField_a_of_type_Long = 0L;
        if (l1 > 10000L) {
          paramArrayOfLong[0] = l1;
        }
        localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString = new String(localC2CPicMsgParseResult.jdField_b_of_type_ArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "analysisFileC2cMsg  dwReserved: " + l1 + " serverPath:" + localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString != null)
        {
          localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString = TransfileUtile.a(localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString, localC2CPicMsgParseResult.jdField_a_of_type_Long, paramShort, false, localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "getFriendPhotoMsg serverPath:" + localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString);
          }
        }
        return localC2CPicMsgParseResult;
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "getFriendPhotoMsg vMsg is null");
        }
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "analysisFileC2cMsg fail");
        }
        return null;
        label383:
        if ((paramArrayOfByte[0] == 22) && (paramArrayOfByte[1] == 32)) {
          return a(paramArrayOfByte, false);
        }
        paramShort = 0;
      }
      label410:
      l1 = 0L;
      paramShort = 0;
    }
  }
  
  public static BuddyTransfileProcessor.C2CPicMsgParseResult a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    BuddyTransfileProcessor.C2CPicMsgParseResult localC2CPicMsgParseResult = new BuddyTransfileProcessor.C2CPicMsgParseResult();
    localC2CPicMsgParseResult.jdField_a_of_type_Int = 2;
    PkgTools.a(paramArrayOfByte, 2, 3).longValue();
    int i1;
    int i;
    if ((paramArrayOfByte[5] == 49) && (paramArrayOfByte[6] == 48))
    {
      PkgTools.a(paramArrayOfByte, 7, 3).longValue();
      if (paramArrayOfByte[10] != 50) {
        break label309;
      }
      i1 = 11;
      localC2CPicMsgParseResult.jdField_b_of_type_Int = (paramArrayOfByte[11] - 65);
      i = i1;
      if (QLog.isColorLevel())
      {
        QLog.d("streamptt", 2, "getFriendPhotoMsg offline file path repeat");
        i = i1;
      }
    }
    for (;;)
    {
      if (paramArrayOfByte[i] == 65)
      {
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "parse down file path success");
        }
        if ((paramArrayOfByte.length <= i + 1) || (paramArrayOfByte[(i + 1)] != 10)) {}
      }
      try
      {
        localC2CPicMsgParseResult.d = new String(paramArrayOfByte, "utf-8").substring(i + 2);
        if (localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString != null)
        {
          paramArrayOfByte = null;
          if (localC2CPicMsgParseResult.jdField_b_of_type_JavaLangString.length() > 0) {
            paramArrayOfByte = localC2CPicMsgParseResult.jdField_b_of_type_JavaLangString.split("\\.")[0];
          }
          localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString = TransfileUtile.a(localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString, localC2CPicMsgParseResult.jdField_a_of_type_Long, 1, false, localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString, paramArrayOfByte, null);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "<---decodeOffLinePic : md5Str:" + paramArrayOfByte + ",afterDecode:" + TransfileUtile.a(localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString));
          }
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "getFriendPhotoMsg serverPath:" + localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString);
          }
        }
        return localC2CPicMsgParseResult;
        label309:
        if (paramArrayOfByte[10] == 49)
        {
          i = paramArrayOfByte[11];
          i = 12;
          if (paramArrayOfByte[12] - 65 == 0)
          {
            localC2CPicMsgParseResult.jdField_a_of_type_Long = PkgTools.a(paramArrayOfByte, 13, 10).longValue();
            i1 = 23;
            i = i1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("streamptt", 2, "getFriendPhotoMsg offline file path fail");
            i = i1;
            continue;
          }
          if (paramArrayOfByte[12] - 65 != 1) {
            continue;
          }
          localC2CPicMsgParseResult.jdField_a_of_type_Long = PkgTools.a(paramArrayOfByte, 13, 10).longValue();
          i = paramArrayOfByte[23] - 65;
          byte[] arrayOfByte = new byte[i];
          PkgTools.a(arrayOfByte, 0, paramArrayOfByte, 24, i);
          localC2CPicMsgParseResult.jdField_b_of_type_JavaLangString = new String(arrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "<---decodeOffLinePic : ret.fileName:" + localC2CPicMsgParseResult.jdField_b_of_type_JavaLangString);
          }
          i1 = i + 24;
          i = paramArrayOfByte[i1] - 65;
          i1 += 1;
          arrayOfByte = new byte[i];
          PkgTools.a(arrayOfByte, 0, paramArrayOfByte, i1, i);
          i1 += i;
          try
          {
            localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString = new String(arrayOfByte, "utf-8");
            i = i1;
            if (QLog.isColorLevel())
            {
              QLog.d("streamptt", 2, "getFriendPhotoMsg serverPath:" + localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString);
              i = i1;
            }
          }
          catch (Exception localException)
          {
            i = i1;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          QLog.w("streamptt", 2, "buddy_mixed, decode action error");
        }
        i = 10;
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    return a(paramString1, paramString2, paramInt, paramArrayOfByte, true);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Object localObject = AppConstants.as + paramString1 + "/";
    switch (paramInt)
    {
    default: 
      paramArrayOfByte = "";
      paramString1 = null;
      paramString2 = (String)localObject;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "getTransferFilePath dir: " + paramString2);
      }
      localObject = new File(paramString2);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString1 = new File(paramString2 + paramArrayOfByte + paramString1);
      if (paramInt == 0) {}
      String str1;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
        }
        return paramString1.getAbsoluteFile().toString();
        paramString1 = (String)localObject + "ptt/";
        String str2 = ".amr";
        str1 = str2;
        localObject = paramString1;
        if (paramString2 != null) {
          break label541;
        }
        if (QLog.isColorLevel()) {
          QLog.i("streamptt", 2, "pttdown,33333");
        }
        paramArrayOfByte = "stream_" + c();
        str1 = str2;
        paramString2 = paramString1;
        localObject = paramArrayOfByte;
        if (!QLog.isColorLevel()) {
          break label532;
        }
        QLog.i("streamptt", 2, "pttdown,name = " + paramArrayOfByte);
        localObject = ".amr";
        paramString2 = paramString1;
        paramString1 = (String)localObject;
        break;
        paramString1 = (String)localObject + "photo/";
        str2 = ".jpg";
        str1 = str2;
        localObject = paramString1;
        if (paramString2 != null) {
          break label541;
        }
        String str3 = c();
        str1 = str2;
        paramString2 = paramString1;
        localObject = str3;
        if (paramArrayOfByte == null) {
          break label532;
        }
        paramArrayOfByte = str3 + HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);
        localObject = ".jpg";
        paramString2 = paramString1;
        paramString1 = (String)localObject;
        break;
        str1 = AppConstants.ay;
        localObject = paramString2;
        if (paramString2 == null)
        {
          paramString1 = c();
          localObject = paramString1;
          if (paramArrayOfByte != null) {
            localObject = paramString1 + HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);
          }
        }
        paramString1 = "";
        paramString2 = str1;
        paramArrayOfByte = (byte[])localObject;
        break;
        if ((paramBoolean) && (!paramString1.exists())) {
          try
          {
            paramString1.createNewFile();
          }
          catch (IOException paramString2) {}
        }
      }
      label532:
      paramString1 = str1;
      paramArrayOfByte = (byte[])localObject;
      continue;
      label541:
      paramArrayOfByte = "";
      paramString1 = str1;
      paramString2 = (String)localObject;
    }
  }
  
  private void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString, paramInt1, paramLong);
    if ((localMessage != null) && (localMessage.uniseq == paramLong)) {
      localMessage.extraflag = 32768;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1, paramLong, 32768, paramInt2);
  }
  
  private void a(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct)
  {
    int i = paramUploadStreamStruct.jdField_a_of_type_Short;
    short s1 = (short)paramUploadStreamStruct.jdField_a_of_type_Int;
    String str = paramUploadStreamStruct.jdField_a_of_type_JavaLangString;
    if (paramBoolean) {
      if (paramUploadStreamStruct.jdField_b_of_type_Int != 0)
      {
        this.aI = paramUploadStreamStruct.jdField_b_of_type_Int;
        a(this.Y, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, this.aI);
        a(2, 9311, "friend_block");
        d();
        StreamDataManager.b(str);
        StreamDataManager.a(str);
        if (paramUploadStreamStruct.jdField_b_of_type_Int == 58) {
          q();
        }
      }
    }
    do
    {
      int i2;
      int i1;
      do
      {
        do
        {
          int i3;
          do
          {
            do
            {
              return;
              if (i == -1)
              {
                this.l = true;
                c(2);
                this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(StreamDataManager.b(str)));
                this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString).length();
                StreamDataManager.a(str);
                this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i = paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.fileKey;
                this.aH = 0;
                this.jdField_a_of_type_Long = paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.msgTime;
                e();
                return;
              }
            } while (this.l);
            s2 = StreamDataManager.a(str);
            if (s2 > 10)
            {
              if (QLog.isColorLevel()) {
                QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: preLayer > 10");
              }
              a(2, 9310, "retry overflow");
              d();
              StreamDataManager.b(str);
              StreamDataManager.a(str);
              return;
            }
            i3 = StreamDataManager.c(str);
            i2 = StreamDataManager.b(str);
            this.ap = i;
            QLog.d("streamptt.send", 2, "server reset.ResetSeq: " + i + " packnum: " + i2 + ",slices:" + i3 + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long + ",flowLayer:" + s1 + ",prelayer:" + s2);
          } while (s2 >= s1);
          StreamDataManager.a(str, s1);
          short s2 = i2;
          if (i2 == 0) {
            i1 = i3 - 1;
          }
          a(true, i, (short)i1);
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(2, 2);
          return;
        } while (this.l);
        i1 = StreamDataManager.c(str);
        i2 = StreamDataManager.a(str);
        if (paramUploadStreamStruct.jdField_a_of_type_Int >= i2) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: info.layer < flowlayer");
      return;
      if (this.aG == i)
      {
        if (this.ao < 8)
        {
          this.ao += 1;
          this.aG = 0;
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.send", 2, "client check timeout.retry:severAckSlice:" + this.ap + " packnum: " + i1 + " maxSendSeq:" + this.aG + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long + ",retryCount:" + this.ao + ",flowLayer:" + i2);
          }
          a(true, (short)this.ap, (short)i1);
          return;
        }
        a(2, 9310, "timeout");
        d();
        StreamDataManager.a(str);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: sendSeqMax != shResetSeq");
  }
  
  private static String c()
  {
    try
    {
      Thread.sleep(1L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void q()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    long l1 = MessageCache.a();
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2012);
    localMessageRecord.init(str, this.Y, str, "你已屏蔽%s的会话", l1, 0, 0, l1);
    localMessageRecord.msgtype = -2012;
    localMessageRecord.isread = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, str);
  }
  
  public MessageRecord a(long paramLong, StreamInfo paramStreamInfo)
  {
    Object localObject = new byte[3];
    PkgTools.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i.length(), (byte[])localObject, 0, 3, "utf-8");
    localObject = (MessageForPtt)MessageRecordFactory.a(-2002);
    ((MessageForPtt)localObject).voiceType = ((int)paramStreamInfo.pttFormat);
    ((MessageForPtt)localObject).voiceLength = ((int)paramStreamInfo.pttTime);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt", 2, "voiceLength createMessageDataBaseContent " + ((MessageForPtt)localObject).voiceLength);
    }
    ((MessageForPtt)localObject).selfuin = this.W;
    ((MessageForPtt)localObject).frienduin = this.Y;
    ((MessageForPtt)localObject).senderuin = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.m;
    ((MessageForPtt)localObject).isread = false;
    ((MessageForPtt)localObject).time = MessageCache.a();
    ((MessageForPtt)localObject).time = paramStreamInfo.msgTime;
    ((MessageForPtt)localObject).setPttStreamFlag(10001);
    ((MessageForPtt)localObject).msgtype = -2002;
    ((MessageForPtt)localObject).istroop = 0;
    ((MessageForPtt)localObject).urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i;
    ((MessageForPtt)localObject).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject).voiceType, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString);
    ((MessageForPtt)localObject).fileSize = 1000L;
    ((MessageForPtt)localObject).itemType = 2;
    ((MessageForPtt)localObject).isread = false;
    ((MessageForPtt)localObject).shmsgseq = paramStreamInfo.msgSeq;
    ((MessageForPtt)localObject).msgUid = MessageUtils.a((int)paramStreamInfo.random);
    ((MessageForPtt)localObject).sttAbility = 0;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((MessageForPtt)localObject).isSend()) {}
    for (paramStreamInfo = this.W;; paramStreamInfo = this.Y)
    {
      ((MessageForPtt)localObject).longPttVipFlag = MessageUtils.a(localQQAppInterface, paramStreamInfo);
      ((MessageForPtt)localObject).serial();
      long l1 = paramLong;
      if (paramLong == 4294967295L)
      {
        paramLong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPtt)localObject).frienduin);
        l1 = paramLong;
        if (QLog.isColorLevel())
        {
          QLog.e("streamptt.recv", 2, "Stream ptt:createMessageDataBaseContent: invalid bubbleID 0xffffffff. get one from cache:" + paramLong);
          l1 = paramLong;
        }
      }
      ((MessageForPtt)localObject).vipBubbleID = l1;
      if (QLog.isColorLevel()) {
        QLog.e("streamptt.recv", 2, "Stream ptt:createMessageDataBaseContent:time" + ((MessageForPtt)localObject).time + " urlAtServer:" + ((MessageForPtt)localObject).urlAtServer + " bubbleId:" + l1 + " msgseq:" + ((MessageForPtt)localObject).shmsgseq + " msgUid:" + ((MessageForPtt)localObject).msgUid);
      }
      paramStreamInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPtt)localObject).frienduin, ((MessageForPtt)localObject).istroop);
      if ((paramStreamInfo == null) || (paramStreamInfo.size() <= 0)) {
        break;
      }
      paramStreamInfo = paramStreamInfo.iterator();
      do
      {
        if (!paramStreamInfo.hasNext()) {
          break;
        }
      } while (!MsgProxyUtils.a((MessageRecord)paramStreamInfo.next(), (MessageRecord)localObject, true));
      if (QLog.isColorLevel()) {
        QLog.w("streamptt", 2, "same Ptt :" + ((MessageForPtt)localObject).getBaseInfoString());
      }
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject, this.W);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(((MessageForPtt)localObject).uniseq);
    return localObject;
  }
  
  public void a() {}
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.d = true;
    b(2);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(4, paramStreamData.vData.length);
    switch (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
          {
            if (!Environment.getExternalStorageState().equals("mounted")) {
              a(9039, "not mounted");
            }
            for (;;)
            {
              d();
              return;
              a(9040, "no enough storage");
            }
          }
          int i = StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.recv", 2, "curFlowLayer: " + i + " received shFlowLayer:" + paramStreamInfo.shFlowLayer + ",seq" + paramStreamData.shPackSeq + ",packNum:" + paramStreamInfo.shPackNum + " lkey:" + paramLong1);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), 2, 0, paramStreamData.vData.length);
          StreamDataManager.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, paramLong1);
          if (i != paramStreamInfo.shFlowLayer)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.W, this.X, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, StreamDataManager.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i), paramLong1);
            return;
          }
          if (StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, paramStreamData.shPackSeq))
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(2, 2);
            short s = (short)(StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i) + 1);
            StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, s);
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack JudgeReceiveError flowLayer: " + s);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.W, this.X, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, StreamDataManager.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i), paramLong1);
            return;
          }
          if (paramStreamInfo.oprType == 1) {}
          for (i = 1; i != 0; i = 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "cancelled:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.Y, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
            StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, true);
            StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
            return;
          }
          StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, paramStreamInfo.shFlowLayer);
          StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, paramStreamData.vData, 800, paramStreamData.shPackSeq);
        } while (paramStreamInfo.shPackNum <= 0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.Y, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
        StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, false);
        StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
        paramStreamData = this.W + "_" + this.X + "_" + paramStreamInfo.iMsgId;
        if (!jdField_b_of_type_JavaUtilList.contains(paramStreamData)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("streamptt.recv", 2, "find stream stream duplicate,discard it ,key:" + paramStreamData);
      return;
      jdField_b_of_type_JavaUtilList.add(paramStreamData);
      long l1 = paramStreamInfo.iSendTime;
      paramStreamData = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(l1 * 1000L));
      paramStreamData = this.X + "_" + paramStreamData;
      if (QLog.isColorLevel()) {
        QLog.d("streamptt.recv", 2, "stream duplicateKey:" + paramStreamData);
      }
      if (!StreamDataManager.e(paramStreamData)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.recv", 2, "find stream offline duplicate,stop stream recv");
    return;
    StreamDataManager.c(paramStreamData);
    c(2);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack received success path: " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.W, this.X, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, (short)-1, paramLong1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i = paramStreamInfo.fileKey;
    this.aH = 0;
    paramStreamInfo = a(paramLong2, paramStreamInfo);
    if ((paramStreamInfo != null) && (!paramStreamInfo.isread)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
    }
    e();
  }
  
  public void a(short paramShort, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.aJ = paramInt2;
    this.aK = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "startSendOneStreamPack:" + paramInt2 + ", " + paramInt1 + ", " + paramShort);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.d = true;
    String str = "";
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ("0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.B = 1001;
      b(2);
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      }
      b(2);
      if (paramShort > this.aG) {
        this.aG = paramShort;
      }
      switch (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int)
      {
      default: 
        return;
      }
    } while ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ehr(this, str, paramShort, paramBoolean));
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 2)
        {
          MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.Y, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
          localMessageForPtt.url = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
          localMessageForPtt.fileSize = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long;
          localMessageForPtt.itemType = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.ab != 1) {
            break label317;
          }
          paramBoolean = true;
          localMessageForPtt.isread = paramBoolean;
          localMessageForPtt.urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i;
          localMessageForPtt.sttAbility = this.aH;
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          Object localObject;
          if (localMessageForPtt.isSend())
          {
            localObject = this.W;
            localMessageForPtt.longPttVipFlag = MessageUtils.a(localQQAppInterface, (String)localObject);
            localMessageForPtt.serial();
            if (QLog.isColorLevel()) {
              QLog.e("streamptt.send", 2, "Stream ptt:updataMessageDataBaseContent:time" + localMessageForPtt.time + " urlAtServer:" + localMessageForPtt.urlAtServer);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.Y, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, localMessageForPtt.msgData);
            localMessageForPtt.time = this.jdField_a_of_type_Long;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.Y, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, this.jdField_a_of_type_Long);
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.Y, 0);
            if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
              ((QQMessageFacade.Message)localObject).pttUrl = localMessageForPtt.url;
            }
          }
          else
          {
            localObject = this.Y;
            continue;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label317:
      paramBoolean = false;
    }
  }
  
  public void a(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    while (paramShort1 <= paramShort2)
    {
      a((short)paramShort1, true, this.aK, this.aJ);
      paramShort1 += 1;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  }
  
  protected void c(boolean paramBoolean)
  {
    if (RichMediaStrategy.c(this.aw)) {}
    long l1;
    HashMap localHashMap;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 2) || (this.n) || (RichMediaStrategy.c(this.aw)));
      l1 = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
      localHashMap = new HashMap();
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.d) {
        localHashMap.put("param_step", this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a(1) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.a(2) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a(3));
      }
      if (!paramBoolean) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int != 0);
    localHashMap.put("param_toUin", this.X);
    localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.jdField_a_of_type_JavaUtilHashMap);
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CStreamPttUpload", true, l1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long, localHashMap, "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-2002);
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0)
    {
      if (BaseTransProcessor.a(this.aw, localHashMap)) {
        break label449;
      }
      localHashMap.put("param_FailCode", Integer.toString(this.aw));
      if ((this.aw != -9527) && (this.aw != 9311) && (this.aw != 9044) && (this.aw != 9350) && (this.aw != 9351)) {
        break label433;
      }
      localHashMap.put(BaseTransProcessor.N, this.L);
    }
    for (;;)
    {
      localHashMap.put("param_toUin", this.X);
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CStreamPttUpload", false, l1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long, localHashMap, "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-2002);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 2) {
        break;
      }
      RichMediaUtil.c(true, String.valueOf(this.aw) + "_" + this.L);
      return;
      label433:
      localHashMap.put("param_errorDesc", this.L);
      continue;
      label449:
      this.aw = -9527;
      localHashMap.put("param_errorDesc", this.L);
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
    }
    long l1 = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
      a(9366, "account switch");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {}
    for (String str = "streamptt.send";; str = "streamptt.recv")
    {
      QLog.d(str, 2, "onError elapsed:" + l1 + " errCode:" + this.aw + " errDesc:" + this.L + " reason:" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason") + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      c(false);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int != 0) {
        break;
      }
      d(1005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.Y, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      return;
    }
    d(2005);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.Y, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
  }
  
  void e()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
    }
    long l1 = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {}
    for (String str = "streamptt.send";; str = "streamptt.recv")
    {
      QLog.d(str, 2, "onSuccess elapsed:" + l1 + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      c(true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {
        a(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int != 0) {
        break;
      }
      d(1003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.m, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      return;
    }
    d(2003);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.Y, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor
 * JD-Core Version:    0.7.0.1
 */