package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter.WySender;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.OffLineFileInfo;
import com.tencent.mobileqq.service.message.MessageFactorySender;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor.A9Message;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import fyg;
import fyh;
import fyi;
import fyj;
import fyk;
import fyl;
import fym;
import fyn;
import fyo;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x1ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x2ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x3ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x5ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x7ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x1RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x2RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x3RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x5RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x7RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadAbsReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadAbsRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346.FileQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.FileQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccRsp;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x5.SubMsgType0x5.MsgBody;

public class FileTransferHandler
{
  public static final int a = -100000;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  public static final String a = "FileTransferHandler<FileAssistant>";
  public static final short a = 1;
  public static final byte[] a;
  public static final int b = -100001;
  private static final String b = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500";
  public static final short b = 2;
  public static final int c = -100002;
  private static final String c = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800";
  public static final short c = 4;
  public static final int d = -100003;
  private static final String d = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200";
  public static final short d = 0;
  public static final int e = 5002;
  private static final String e = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000";
  public static final short e = 57;
  public static final int f = 5003;
  private static final String f = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100";
  public static final short f = 70;
  public static final int g = 5004;
  private static final String g = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700";
  public static final short g = 71;
  public static final int h = 5005;
  private static final String h = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400";
  public static final short h = 5;
  public static final int i = 5006;
  private static final String i = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900";
  public static final short i = 1;
  public static final int j = 5007;
  private static final String j = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100";
  public static final short j = 2;
  public static final int k = 5013;
  private static final String k = "GTalkFileAppSvr.CMD_DISCUSS_FILE";
  public static final short k = 3;
  public static final int l = 5014;
  private static final String l = FileTransferObserver.class.getName();
  public static final short l = 112;
  public static final int m = 5015;
  private static final String m = "sendtimekey";
  public static final int n = 5016;
  private static final int o = 3;
  private static final int p = 1;
  private static final int q = 2;
  private static final int r = 3;
  private static final int s = 6;
  private static final int t = 7;
  private static int u = 0;
  private long jdField_a_of_type_Long;
  public final QQAppInterface a;
  private MessageFactoryReceiver jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactoryReceiver = new MessageFactoryReceiver();
  private MessageFactorySender jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactorySender = new MessageFactorySender();
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new fyg(Looper.getMainLooper());
    jdField_a_of_type_ArrayOfByte = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 101 };
  }
  
  public FileTransferHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private FileManagerEntity a(MessageHandler paramMessageHandler, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString3, String paramString4, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    paramLong4 = paramInt2;
    boolean bool1 = false;
    boolean bool2 = false;
    paramLong3 = 0L;
    if (0L != paramLong4)
    {
      paramMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramLong4);
      if (paramMessageHandler != null)
      {
        paramLong3 = paramMessageHandler.nSessionId;
        bool1 = true;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramLong4))
        {
          if ((paramBoolean2) && (paramBoolean1))
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. name: " + paramString4 + ". is  roma and readed, think okt!!");
            a(paramString1, paramLong4, paramInt1, paramString3, paramLong1);
          }
          for (;;)
          {
            return null;
            a(paramString1, paramLong4, paramInt1, paramString3, paramLong1);
          }
        }
        bool2 = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramLong3);
        QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. name: " + paramString4 + ". user had delete about onlinefile record!!! ");
      }
      paramLong1 = paramLong3;
    }
    for (paramBoolean1 = bool1;; paramBoolean1 = false)
    {
      TransfileUtile.a(BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString4, 0, null), paramLong2, 0, false, null);
      paramLong2 = MessageRecordFactory.a(-2005).uniseq;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (0L == paramLong4) {
        break label432;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramLong1);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "Recv a offline file name: " + paramString4 + ". and it is : online changto offline. OLfilesession=" + paramLong4 + "isPullRoam =" + paramBoolean2);
      }
      if (!paramBoolean2) {
        break;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. name: " + paramString4 + ". isPullRoam hadHasOlSessionRecord=" + paramBoolean1 + " isDelOlSessionRecord=" + bool2);
      if ((!paramBoolean1) || (bool2)) {
        break;
      }
      return null;
      paramLong1 = 0L;
      bool2 = true;
    }
    if ((0L != paramLong1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1))) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1, paramLong2, paramString1, 0);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong2, paramString1, 0);
    label432:
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong2, paramString1, 0);
  }
  
  private ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString);
  }
  
  private ToServiceMsg a(String paramString, FileTransferObserver paramFileTransferObserver)
  {
    ToServiceMsg localToServiceMsg = a(paramString);
    if (paramFileTransferObserver != null) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        long l1 = this.jdField_a_of_type_Long;
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_a_of_type_Long), paramFileTransferObserver);
        paramFileTransferObserver = localToServiceMsg.extraData;
        String str = l;
        long l2 = this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Long = (1L + l2);
        paramFileTransferObserver.putLong(str, l2);
        QLog.i("FileTransferHandler<FileAssistant>", 1, "createToServiceMsg, add.obseq=" + l1 + ".cmd=" + paramString.hashCode());
        return localToServiceMsg;
      }
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "createToServiceMsg. FileTransferObserver=null.cmd=" + paramString.hashCode());
    return localToServiceMsg;
  }
  
  private fyo a(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    if ((paramArrayOfByte == null) || (i1 == 0)) {
      return null;
    }
    fyo localfyo = new fyo(null);
    int i2;
    byte[] arrayOfByte;
    if (i1 >= 16)
    {
      i2 = PkgTools.a(paramArrayOfByte, 0);
      arrayOfByte = new byte[i2];
      if (i1 < i2 + 2) {
        break label180;
      }
      PkgTools.b(paramArrayOfByte, 2, arrayOfByte, i2);
      i2 += 2;
    }
    try
    {
      localfyo.jdField_a_of_type_JavaLangString = new String(arrayOfByte, "UTF-16LE");
      if (i1 >= i2 + 4)
      {
        long l1 = PkgTools.a(paramArrayOfByte, i2);
        int i3 = i2 + 4;
        if (i1 < i3 + 2) {
          break label212;
        }
        i2 = PkgTools.a(paramArrayOfByte, i3);
        i3 += 2;
        arrayOfByte = new byte[i2];
        if (i1 < i3 + i2) {
          break label223;
        }
        PkgTools.b(paramArrayOfByte, i3, arrayOfByte, i2);
        i2 = i3 + i2;
        if (i1 < i2 + 4) {
          break label234;
        }
        localfyo.jdField_a_of_type_Long = ((PkgTools.a(paramArrayOfByte, i2) << 32) + l1);
        return localfyo;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filenamelen");
        return null;
        label180:
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filenamebuf");
        return null;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filelenlo");
      return null;
    }
    label212:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- otherlen");
    return null;
    label223:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- bufotherinfo");
    return null;
    label234:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filelenhi");
    return null;
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactoryReceiver.a(paramToServiceMsg, paramFromServiceMsg);
      return localObject1;
    }
    catch (Exception paramToServiceMsg)
    {
      do
      {
        paramToServiceMsg.printStackTrace();
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.d("FileTransferHandler<FileAssistant>", 2, this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactoryReceiver.getClass().getSimpleName() + " decode error," + paramToServiceMsg.toString());
    }
    return null;
  }
  
  private void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, cmd0x345.RspBody.SubCmd0x5RspBody paramSubCmd0x5RspBody)
  {
    paramFromServiceMsg = "";
    String str = "";
    if (paramSubCmd0x5RspBody.str_ret_msg.has()) {
      paramFromServiceMsg = paramSubCmd0x5RspBody.str_ret_msg.get();
    }
    if (paramSubCmd0x5RspBody.str_file_id.has()) {
      str = paramSubCmd0x5RspBody.str_file_id.get();
    }
    if ((str != null) && (paramInt == 0)) {}
    long l1;
    for (boolean bool = true;; bool = false)
    {
      l1 = paramToServiceMsg.extraData.getLong("Context");
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
      if (paramToServiceMsg != null) {
        break;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
      return;
    }
    if (bool)
    {
      paramToServiceMsg.Uuid = str;
      paramToServiceMsg.cloudType = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 19, new Object[] { Integer.valueOf(paramInt), paramFromServiceMsg, Long.valueOf(0L), Long.valueOf(0L), str, Long.valueOf(l1) });
      a(l1, paramToServiceMsg.peerUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.fileName, paramToServiceMsg.fileSize, str, paramToServiceMsg.uniseq, paramToServiceMsg.msgUid, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, 6, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramToServiceMsg);
      return;
      paramToServiceMsg.status = 0;
      QLog.e("FileTransferHandler<FileAssistant>", 1, "nId[" + l1 + "],forward disc2disc faild, retCode[" + paramInt + "], retMsg[" + paramFromServiceMsg + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 19, new Object[] { Integer.valueOf(paramInt), paramFromServiceMsg, Long.valueOf(0L), Long.valueOf(0L), str, Long.valueOf(l1) });
    }
  }
  
  private void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, cmd0x345.RspBody.SubCmd0x6RspBody paramSubCmd0x6RspBody)
  {
    paramFromServiceMsg = "";
    if (paramSubCmd0x6RspBody.str_ret_msg.has()) {
      paramFromServiceMsg = paramSubCmd0x6RspBody.str_ret_msg.get();
    }
    if (paramSubCmd0x6RspBody.str_file_id.has()) {}
    for (paramSubCmd0x6RspBody = paramSubCmd0x6RspBody.str_file_id.get();; paramSubCmd0x6RspBody = "")
    {
      if ((paramSubCmd0x6RspBody != null) && (paramInt == 0)) {}
      long l1;
      for (boolean bool = true;; bool = false)
      {
        l1 = paramToServiceMsg.extraData.getLong("Context");
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
        if (paramToServiceMsg != null) {
          break;
        }
        QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
        return;
      }
      paramToServiceMsg.status = 0;
      if (bool)
      {
        paramToServiceMsg.status = 1;
        switch (paramToServiceMsg.nOpType)
        {
        default: 
          if (QLog.isDevelopLevel()) {
            throw new NullPointerException("类型错误！");
          }
          break;
        case 21: 
          paramToServiceMsg.Uuid = paramSubCmd0x6RspBody;
          paramToServiceMsg.cloudType = 1;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 19, new Object[] { Integer.valueOf(paramInt), paramFromServiceMsg, Long.valueOf(0L), Long.valueOf(0L), paramSubCmd0x6RspBody, Long.valueOf(l1) });
          a(paramToServiceMsg.peerUin, paramToServiceMsg, null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, 6, null);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramToServiceMsg);
        return;
        paramToServiceMsg.WeiYunFileId = paramSubCmd0x6RspBody;
        paramToServiceMsg.cloudType = 2;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 34, new Object[] { Integer.valueOf(paramInt), paramFromServiceMsg, paramSubCmd0x6RspBody, Long.valueOf(l1) });
      }
    }
  }
  
  private void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, cmd0x345.RspBody.SubCmd0x7RspBody paramSubCmd0x7RspBody)
  {
    boolean bool = false;
    Object localObject = "";
    String str1 = "";
    String str2 = "";
    int i1 = 0;
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      paramInt = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is timeout[" + paramFromServiceMsg.getResultCode() + "]");
      paramSubCmd0x7RspBody = str1;
      paramFromServiceMsg = str2;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if ((paramInt != -100001) || (i2 >= 3)) {
        break;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i2 + 1);
      a(paramToServiceMsg, false);
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        paramInt = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is failed[" + paramFromServiceMsg.getResultCode() + "]");
        paramFromServiceMsg = str2;
        paramSubCmd0x7RspBody = str1;
      }
      else if (paramInt != 0)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is failed[" + paramFromServiceMsg.getResultCode() + "]");
        paramFromServiceMsg = str2;
        paramSubCmd0x7RspBody = str1;
      }
      else
      {
        localObject = paramSubCmd0x7RspBody.str_server_ip.get();
        paramFromServiceMsg = paramSubCmd0x7RspBody.str_dns.get();
        i1 = paramSubCmd0x7RspBody.uint32_server_port.get();
        str1 = paramSubCmd0x7RspBody.str_url.get();
        bool = true;
        paramSubCmd0x7RspBody = (cmd0x345.RspBody.SubCmd0x7RspBody)localObject;
        localObject = str1;
      }
    }
    if (paramInt != 0) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handlePreviewResponse: return " + bool + ", retCode=" + paramInt + ", retMsg=" + "" + ", Key=" + (String)localObject + ", IP=" + paramSubCmd0x7RspBody + ", Domain=" + paramFromServiceMsg + ", port=" + i1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 21, new Object[] { Integer.valueOf(paramInt), "", localObject, paramSubCmd0x7RspBody, paramFromServiceMsg, Integer.valueOf(i1) });
  }
  
  private void a(long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, cmd0x345.RspBody.SubCmd0x1RspBody paramSubCmd0x1RspBody)
  {
    boolean bool;
    String str1;
    String str2;
    String str3;
    int i1;
    String str4;
    if (paramLong == 0L)
    {
      bool = true;
      paramFromServiceMsg = "";
      str1 = "";
      str2 = "";
      str3 = "";
      i1 = 0;
      str4 = "";
      if (paramSubCmd0x1RspBody.str_file_id.has()) {
        paramFromServiceMsg = paramSubCmd0x1RspBody.str_file_id.get();
      }
      if (paramSubCmd0x1RspBody.str_file_key.has()) {
        str1 = paramSubCmd0x1RspBody.str_file_key.get();
      }
      if (paramSubCmd0x1RspBody.str_check_sum.has()) {
        str2 = paramSubCmd0x1RspBody.str_check_sum.get();
      }
      if (paramSubCmd0x1RspBody.str_host.has()) {
        str3 = paramSubCmd0x1RspBody.str_host.get();
      }
      if (paramSubCmd0x1RspBody.uint32_port.has()) {
        i1 = paramSubCmd0x1RspBody.uint32_port.get();
      }
      if (paramSubCmd0x1RspBody.str_file_name.has()) {
        str4 = paramSubCmd0x1RspBody.str_file_name.get();
      }
      if (!paramSubCmd0x1RspBody.str_warn.has()) {
        break label323;
      }
    }
    label323:
    for (paramSubCmd0x1RspBody = paramSubCmd0x1RspBody.str_warn.get();; paramSubCmd0x1RspBody = "")
    {
      if ((str3 == null) || (str3.length() == 0)) {}
      for (int i2 = 1;; i2 = 0)
      {
        int i3 = paramToServiceMsg.extraData.getInt("bHostNullretryIndex", 0);
        if (i2 == 0) {
          break label251;
        }
        paramToServiceMsg.extraData.putInt("bHostNullretryIndex", i3 + 1);
        a(paramToServiceMsg, false);
        return;
        bool = false;
        break;
      }
      label251:
      QLog.i("FileTransferHandler<FileAssistant>", 1, "Send Discfile resp Ok");
      a(paramToServiceMsg, 5015, bool, new Object[] { Long.valueOf(paramLong), paramFromServiceMsg, str1, str2, str3, Integer.valueOf(i1), str4, paramSubCmd0x1RspBody });
      return;
    }
  }
  
  private void a(long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, cmd0x345.RspBody.SubCmd0x2RspBody paramSubCmd0x2RspBody)
  {
    boolean bool;
    long l1;
    if (paramLong == 0L)
    {
      bool = true;
      l1 = paramToServiceMsg.extraData.getLong("Context", 0L);
      if (l1 != 0L) {
        break label66;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "why there is 0?!");
    }
    label66:
    do
    {
      a(paramToServiceMsg, 5016, bool, new Object[] { Long.valueOf(paramLong) });
      return;
      bool = false;
      break;
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
    } while (paramFromServiceMsg == null);
    if (bool) {}
    for (paramFromServiceMsg.status = 1;; paramFromServiceMsg.status = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFromServiceMsg);
      break;
      QLog.e("FileTransferHandler<FileAssistant>", 1, "nSessionId[" + l1 + "] sendDiscFeed faild,retCode[" + paramLong + "]");
    }
  }
  
  private void a(long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, cmd0x345.RspBody.SubCmd0x3RspBody paramSubCmd0x3RspBody)
  {
    String str2 = "";
    int i1 = 80;
    String str1 = "";
    String str3 = "";
    String str4 = "";
    if (paramSubCmd0x3RspBody.str_host.has()) {
      str2 = paramSubCmd0x3RspBody.str_host.get();
    }
    if (paramSubCmd0x3RspBody.uint32_port.has()) {
      i1 = paramSubCmd0x3RspBody.uint32_port.get();
    }
    if (paramSubCmd0x3RspBody.str_check_sum.has()) {
      str1 = paramSubCmd0x3RspBody.str_check_sum.get();
    }
    if (paramSubCmd0x3RspBody.str_cookie.has()) {
      str3 = paramSubCmd0x3RspBody.str_cookie.get();
    }
    if (paramSubCmd0x3RspBody.int32_ret_code.has()) {
      paramLong = paramSubCmd0x3RspBody.int32_ret_code.get();
    }
    if (paramSubCmd0x3RspBody.str_ret_msg.has()) {
      str4 = paramSubCmd0x3RspBody.str_ret_msg.get();
    }
    if (paramSubCmd0x3RspBody.str_suggest_file_name.has()) {}
    for (paramSubCmd0x3RspBody = FileManagerUtil.a(paramSubCmd0x3RspBody.str_suggest_file_name.get());; paramSubCmd0x3RspBody = "")
    {
      int i2;
      if ((paramLong == 0L) && (str2 == null))
      {
        i2 = 1;
        if ((str2 == null) || (str2.length() <= 0)) {
          break label249;
        }
      }
      label249:
      for (boolean bool = true;; bool = false)
      {
        int i3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
        if (i2 == 0) {
          break label255;
        }
        paramToServiceMsg.extraData.putInt("retryIndex", i3 + 1);
        a(paramToServiceMsg, false);
        return;
        i2 = 0;
        break;
      }
      label255:
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("handleDownloadResp: return ").append(bool).append(", retCode=").append(paramLong).append(", strHost=").append(str2).append(", strCheckSum=");
        if (str1 == null) {
          break label445;
        }
      }
      label445:
      for (String str5 = str1;; str5 = "")
      {
        QLog.d("FileTransferHandler<FileAssistant>", 2, str5 + ", strCookie=" + str3 + ", port=" + i1);
        long l1 = paramToServiceMsg.extraData.getLong("Context");
        a(paramToServiceMsg, 5013, bool, new Object[] { Long.valueOf(paramLong), str4, paramSubCmd0x3RspBody, str2, Integer.valueOf(i1), str1, str3, Integer.valueOf(paramFromServiceMsg.getAppSeq()), Long.valueOf(l1) });
        return;
      }
    }
  }
  
  private void a(MessageHandler paramMessageHandler, List paramList, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString3, String paramString4, long paramLong2, int paramInt2, long paramLong3, long paramLong4, String paramString5, TempSessionInfo paramTempSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "internalHandleOffLineFileMsg friendUin[" + String.valueOf(paramString1) + "],senderuin[" + String.valueOf(paramString2) + "],time[" + String.valueOf(paramLong1) + "],seq[" + String.valueOf(paramShort) + "],isRead[" + String.valueOf(paramBoolean1) + "],isPullRoam[" + String.valueOf(paramBoolean2) + "],type[" + String.valueOf(paramInt1) + "],uuid[" + String.valueOf(paramString3) + "],type[" + String.valueOf(paramInt1) + "],strFileName[" + String.valueOf(paramString4) + "],dwFileSize[" + String.valueOf(paramLong2) + "],reserve[" + String.valueOf(paramInt2) + "],vipBubbleID[" + String.valueOf(paramLong3) + "]");
    }
    FileManagerEntity localFileManagerEntity = a(paramMessageHandler, paramString1, paramString2, paramLong1, paramShort, paramBoolean1, paramBoolean2, paramInt1, paramString3, paramString4, paramLong2, paramInt2, paramLong3, paramLong4);
    if (localFileManagerEntity == null) {
      QLog.w("FileTransferHandler<FileAssistant>", 1, "entry is null,may be is onlinefile!");
    }
    do
    {
      return;
      if ((paramString4 == null) || (paramString4.length() == 0))
      {
        QLog.w("FileTransferHandler<FileAssistant>", 1, "internalHandleOffLineFileMsg.  no file name . return!!!!");
        return;
      }
      if ((!paramBoolean2) && (!paramBoolean1)) {
        break;
      }
      paramMessageHandler = new ArrayList();
      if (!a(paramString1, paramString3, paramInt2, paramShort, paramLong4, paramMessageHandler, paramString2)) {
        break;
      }
    } while (paramMessageHandler.size() <= 0);
    paramList.add(paramMessageHandler.get(0));
    return;
    String str = TransfileUtile.a(BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString4, 0, null), paramLong2, 0, false, null);
    MessageRecordFactory.a(-2005);
    paramMessageHandler = paramString2;
    int i2;
    int i1;
    if (paramTempSessionInfo != null)
    {
      i2 = 1;
      if (paramTempSessionInfo.jdField_b_of_type_Int == -1)
      {
        i1 = 0;
        paramMessageHandler = paramString2;
        if (i1 == 0) {
          break label1131;
        }
        i1 = paramTempSessionInfo.jdField_b_of_type_Int;
        paramMessageHandler = paramString2;
      }
    }
    for (;;)
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localFileManagerEntity.cloudType = 1;
      localFileManagerEntity.fileName = paramString4;
      localFileManagerEntity.fileSize = paramLong2;
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, null, 0);
      localFileManagerEntity.peerType = i1;
      localFileManagerEntity.peerUin = paramString1;
      localFileManagerEntity.srvTime = (1000L * paramLong1);
      localFileManagerEntity.status = -1;
      localFileManagerEntity.Uuid = new String(paramString3);
      localFileManagerEntity.isReaded = paramBoolean1;
      localFileManagerEntity.bSend = false;
      localFileManagerEntity.msgSeq = paramShort;
      localFileManagerEntity.msgUid = paramLong4;
      localFileManagerEntity.strFileMd5 = paramString5;
      if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0))
      {
        localFileManagerEntity.nWeiYunSrcType = -2;
        paramString5 = "friendUin:" + String.valueOf(paramString1) + "senderuin:" + String.valueOf(paramMessageHandler) + "time:" + String.valueOf(paramLong1) + "seq:" + String.valueOf(paramShort) + "isRead:" + String.valueOf(paramBoolean1) + "isPullRoam:" + String.valueOf(paramBoolean2) + "type:" + String.valueOf(paramInt1) + "uuid:" + String.valueOf(paramString3) + "strFileName:" + String.valueOf(paramString4) + "dwFileSize:" + String.valueOf(paramLong2) + "reserve:" + String.valueOf(paramInt2) + "vipBubbleID:" + String.valueOf(paramLong3);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId, "actFileDownDetail", 0L, "", localFileManagerEntity.selfUin, localFileManagerEntity.Uuid, 9081L, paramString5, 0L, 0L, paramLong2, "", "", 0, "uuid null", null);
        label796:
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageHandler, "", localFileManagerEntity);
        if (paramString2.equals(paramMessageHandler))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, 0, localFileManagerEntity.uniseq);
          localFileManagerEntity.nOpType = 0;
          localFileManagerEntity.status = 1;
          localFileManagerEntity.bSend = true;
          localFileManagerEntity.isReaded = true;
          localFileManagerEntity.bDelInFM = true;
        }
        if ((!paramBoolean2) || (!paramBoolean1)) {
          break label1113;
        }
        QLog.w("FileTransferHandler<FileAssistant>", 1, "internalHandleOffLineFileMsg.  roam and readed ");
      }
      for (localFileManagerEntity.bDelInFM = true;; localFileManagerEntity.bDelInFM = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
        a(paramList, paramString1, paramMessageHandler, paramString4, paramLong2, paramBoolean1, i1, str, paramShort, paramShort, paramString3, paramInt1, localFileManagerEntity.uniseq, paramLong4, paramLong3, paramLong1, -2005);
        if (QLog.isColorLevel()) {
          QLog.i("FileTransferHandler<FileAssistant>", 2, "File Coming:" + FileManagerUtil.a(localFileManagerEntity));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, paramString1, i1, 17, null, 0, null);
        return;
        if ((paramTempSessionInfo.jdField_b_of_type_Int != 1000) && (paramTempSessionInfo.jdField_b_of_type_Int != 1020))
        {
          i1 = i2;
          if (paramTempSessionInfo.jdField_b_of_type_Int != 1004) {
            break;
          }
        }
        paramString2 = String.valueOf(paramTempSessionInfo.jdField_c_of_type_Long);
        i1 = i2;
        break;
        if (FileManagerUtil.a(paramString4) != 0) {
          break label796;
        }
        paramString5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.Uuid, 3, paramString2.equals(paramMessageHandler), localFileManagerEntity);
        if (paramString5 == null) {
          break label796;
        }
        localFileManagerEntity.strThumbPath = paramString5;
        break label796;
        label1113:
        QLog.w("FileTransferHandler<FileAssistant>", 1, "internalHandleOffLineFileMsg.  sync and readed ");
      }
      label1131:
      i1 = 0;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    int i1;
    if (paramFromServiceMsg.getWupBuffer() != null)
    {
      i1 = paramFromServiceMsg.getWupBuffer().length - 4;
      if (i1 >= 0) {}
    }
    else
    {
      return;
    }
    byte[] arrayOfByte = new byte[i1];
    PkgTools.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i1);
    paramFromServiceMsg.putWupBuffer(arrayOfByte);
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getWupBuffer() != null)
    {
      long l1 = paramToServiceMsg.getWupBuffer().length;
      byte[] arrayOfByte = new byte[(int)l1 + 4];
      PkgTools.a(arrayOfByte, 0, 4L + l1);
      PkgTools.a(arrayOfByte, 4, paramToServiceMsg.getWupBuffer(), (int)l1);
      paramToServiceMsg.putWupBuffer(arrayOfByte);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    long l3 = paramOffLineFileInfo.jdField_c_of_type_Long;
    long l1 = paramOffLineFileInfo.d;
    long l2 = paramOffLineFileInfo.e;
    long l4 = paramOffLineFileInfo.jdField_b_of_type_Long;
    String str2 = paramOffLineFileInfo.jdField_b_of_type_JavaLangString;
    paramFromServiceMsg = paramOffLineFileInfo.jdField_c_of_type_JavaLangString;
    String str1 = paramToServiceMsg.extraData.getString("friendUin");
    paramToServiceMsg.extraData.getBoolean("isRead");
    String str4 = "http://" + PkgTools.b(l3) + "/?ver=" + "2" + "&rkey=" + str2;
    str2 = TransfileUtile.a(BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramFromServiceMsg, 0, null), l2, 0, false, str4);
    String str3;
    String str5;
    FileManagerEntity localFileManagerEntity;
    if (str2 != null)
    {
      str3 = String.valueOf(l4);
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("filepath");
      l3 = MessageRecordFactory.a(-1000).uniseq;
      str5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l3, str1, 0);
      localFileManagerEntity.cloudType = 1;
      localFileManagerEntity.fileName = paramFromServiceMsg;
      localFileManagerEntity.fileSize = l2;
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, null, 0);
      localFileManagerEntity.peerType = 0;
      localFileManagerEntity.peerUin = str1;
      localFileManagerEntity.srvTime = (1000L * l1);
      localFileManagerEntity.status = -1;
      localFileManagerEntity.Uuid = new String(paramToServiceMsg);
      localFileManagerEntity.isReaded = false;
      localFileManagerEntity.strServerPath = str4;
      localFileManagerEntity.bSend = false;
      if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        break label563;
      }
      localFileManagerEntity.nWeiYunSrcType = -2;
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId, "actFileDownDetail", 0L, "", localFileManagerEntity.selfUin, localFileManagerEntity.Uuid, 9081L, paramOffLineFileInfo.toString(), 0L, 0L, l2, "", "", 0, "uuid null", null);
    }
    for (;;)
    {
      if (str5.equals(str3))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 0, l3);
        localFileManagerEntity.nOpType = 7;
        localFileManagerEntity.status = 1;
        localFileManagerEntity.bSend = true;
        localFileManagerEntity.isReaded = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, str3, localFileManagerEntity.bSend, paramFromServiceMsg, 0L, false, 0, str2, paramOffLineFileInfo.jdField_a_of_type_Short, paramOffLineFileInfo.jdField_a_of_type_Short, new String(paramToServiceMsg), 1, l3, localFileManagerEntity.msgUid, -1L, l1);
      if (QLog.isColorLevel()) {
        QLog.i("FileTransferHandler<FileAssistant>", 2, "File Coming:" + FileManagerUtil.a(localFileManagerEntity));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, localFileManagerEntity.nSessionId, str1, 0, 17, null, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      return;
      label563:
      if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0) || (l2 == 0L))
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId, "actFileDownDetail", 0L, "", localFileManagerEntity.selfUin, localFileManagerEntity.Uuid, 90451L, paramOffLineFileInfo.toString(), 0L, 0L, l2, "", "", 0, "A9 Name Null", null);
      }
      else if (FileManagerUtil.a(paramFromServiceMsg) == 0)
      {
        str4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.Uuid, 3, false, localFileManagerEntity);
        if (str4 != null) {
          localFileManagerEntity.strThumbPath = str4;
        }
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, List paramList, String paramString3)
  {
    if (paramLong1 != 0L)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramString1), paramLong1);
      if (localObject1 != null)
      {
        if (!((FileManagerEntity)localObject1).bDelInAio)
        {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramString1), ((FileManagerEntity)localObject1).peerType, ((FileManagerEntity)localObject1).uniseq);
          if (paramString1 != null) {
            paramList.add(paramString1);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "ol2offline duplicate msg, entity info" + FileManagerUtil.a((FileManagerEntity)localObject1));
        }
        return true;
      }
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "msgFilterByFMDB,friendUin[" + FileManagerUtil.e(paramString1) + "],uuid[" + paramString2 + "],olSessionId[" + paramLong1 + "],msgSeq[" + paramLong2 + "],msgUid[" + paramLong3 + "],senderuin[" + FileManagerUtil.e(paramString3) + "]");
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int i1 = 0;
    if (i1 < ((List)localObject1).size())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((List)localObject1).get(i1);
      switch (localFileManagerEntity.nOpType)
      {
      }
      Object localObject2;
      label580:
      do
      {
        do
        {
          do
          {
            if (QLog.isColorLevel()) {
              QLog.w("FileTransferHandler<FileAssistant>", 1, "Entity [" + FileManagerUtil.a(localFileManagerEntity) + "]");
            }
            i1 += 1;
            break;
            if ((paramLong2 != localFileManagerEntity.msgSeq) || (paramLong3 != localFileManagerEntity.msgUid)) {
              break label580;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, localFileManagerEntity.peerType, localFileManagerEntity.uniseq);
            if (localObject2 != null)
            {
              paramList.add(localObject2);
              if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "msgSeq and msguid are all equal, duplicate msg, entity info" + FileManagerUtil.a(localFileManagerEntity));
              }
              return true;
            }
            localObject2 = new ArrayList();
            a((List)localObject2, paramString1, paramString3, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.isReaded, 0, null, paramLong2, paramLong2, paramString2, 0, localFileManagerEntity.uniseq, paramLong3, -1L, localFileManagerEntity.srvTime / 1000L, -2005);
          } while (((List)localObject2).size() <= 0);
          paramList.add((MessageRecord)((List)localObject2).get(0));
          if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "msgSeq and msguid are all equal, duplicate msg, entity info" + FileManagerUtil.a(localFileManagerEntity));
          }
          return true;
        } while ((localFileManagerEntity.Uuid == null) || (!localFileManagerEntity.Uuid.equalsIgnoreCase(paramString2)));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, localFileManagerEntity.peerType, localFileManagerEntity.uniseq);
        if (localObject2 != null)
        {
          paramList.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "duplicate msg, entity info" + FileManagerUtil.a(localFileManagerEntity));
          }
          return true;
        }
        localObject2 = new ArrayList();
        a((List)localObject2, paramString1, paramString3, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.isReaded, 0, null, paramLong2, paramLong2, paramString2, 0, localFileManagerEntity.uniseq, paramLong3, -1L, localFileManagerEntity.srvTime / 1000L, -2005);
      } while (((List)localObject2).size() <= 0);
      paramList.add((MessageRecord)((List)localObject2).get(0));
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "Uuid are all equal, duplicate msg, entity info" + FileManagerUtil.a(localFileManagerEntity));
      }
      return true;
    }
    return false;
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, im_msg_body.GroupFile paramGroupFile)
  {
    if (paramGroupFile == null)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "disc file is coming but file info is null!");
      return -1L;
    }
    Object localObject1 = null;
    String str1 = String.valueOf(paramLong2);
    String str2 = String.valueOf(paramLong3);
    if (paramGroupFile.bytes_filename.has()) {}
    for (;;)
    {
      long l1;
      try
      {
        localObject2 = new String(paramGroupFile.bytes_filename.get().toByteArray(), "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        Object localObject2;
        localUnsupportedEncodingException1.printStackTrace();
        continue;
        paramGroupFile = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong1, str1, 3000);
        localFileManagerEntity.cloudType = 1;
        localFileManagerEntity.fileName = ((String)localObject1);
        localFileManagerEntity.fileSize = l1;
        localFileManagerEntity.nOpType = 1;
        localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, str2, 3000);
        localFileManagerEntity.peerType = 3000;
        localFileManagerEntity.peerUin = str1;
        localFileManagerEntity.selfUin = str2;
        localFileManagerEntity.srvTime = (1000L * paramLong6);
        localFileManagerEntity.status = -1;
        localFileManagerEntity.Uuid = new String(localUnsupportedEncodingException1);
        localFileManagerEntity.isReaded = false;
        localFileManagerEntity.bSend = false;
        localFileManagerEntity.msgSeq = paramLong4;
        localFileManagerEntity.msgUid = 0L;
        if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0))
        {
          localFileManagerEntity.nWeiYunSrcType = -2;
          if (paramGroupFile.equals(String.valueOf(paramLong3)))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str2, 3000, paramLong1);
            localFileManagerEntity.nOpType = 7;
            localFileManagerEntity.peerNick = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131558764);
            localFileManagerEntity.bSend = true;
            localFileManagerEntity.isReaded = true;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
          if (QLog.isColorLevel()) {
            QLog.i("FileTransferHandler<FileAssistant>", 2, "File Coming:" + FileManagerUtil.a(localFileManagerEntity));
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1, localFileManagerEntity.nSessionId, str1, 3000, 17, null, 0, null);
          return paramLong1;
        }
        if (FileManagerUtil.a((String)localObject1) != 0) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 3);
        continue;
      }
      try
      {
        localObject1 = FileManagerUtil.a((String)localObject2);
        if (!paramGroupFile.uint64_file_size.has()) {
          break label647;
        }
        l1 = paramGroupFile.uint64_file_size.get();
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        localObject1 = localUnsupportedEncodingException1;
        Object localObject3 = localUnsupportedEncodingException2;
        continue;
        localObject3 = null;
        continue;
        label647:
        l1 = 0L;
        continue;
      }
      if (paramGroupFile.bytes_file_id.has())
      {
        localObject2 = paramGroupFile.bytes_file_id.get().toByteArray();
        if (paramGroupFile.bytes_batch_id.has()) {
          paramGroupFile.bytes_batch_id.get().toByteArray();
        }
        if (paramGroupFile.bytes_file_key.has()) {
          paramGroupFile.bytes_file_key.get().toByteArray();
        }
        if (paramGroupFile.bytes_mark.has()) {
          paramGroupFile.bytes_mark.get().toByteArray();
        }
        if (paramGroupFile.uint64_sequence.has()) {
          paramGroupFile.uint64_sequence.get();
        }
        paramLong5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3000, paramLong4, paramLong6, paramLong2, paramLong5);
        if (paramLong5 > 0L)
        {
          paramGroupFile = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong5, String.valueOf(paramLong2), 3000);
          paramGroupFile.status = 1;
          paramGroupFile.fProgress = 1.0F;
          return paramLong5;
        }
      }
      localObject1 = null;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    int i1 = u;
    u = i1 + 1;
    localUniPacket.setRequestId(i1);
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactorySender.a(paramToServiceMsg, localUniPacket);
    paramToServiceMsg.putWupBuffer(localUniPacket.encode());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool1 = false;
    FileTransferHandler.FileUploadInfo localFileUploadInfo = new FileTransferHandler.FileUploadInfo(this);
    localFileUploadInfo.jdField_c_of_type_ArrayOfByte = paramToServiceMsg.extraData.getByteArray("MD5");
    Object localObject = null;
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      localFileUploadInfo.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is timeout[" + paramFromServiceMsg.getResultCode() + "]");
    }
    int i5;
    int i1;
    label135:
    int i2;
    label157:
    int i3;
    label192:
    int i4;
    label212:
    cmd0x346.RspBody localRspBody;
    for (;;)
    {
      i5 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if ((localFileUploadInfo.jdField_a_of_type_Int != 0) || ((localFileUploadInfo.jdField_b_of_type_JavaLangString != null) && (localFileUploadInfo.jdField_b_of_type_JavaLangString.length() != 0))) {
        break label859;
      }
      i1 = 1;
      if ((localFileUploadInfo.jdField_b_of_type_JavaLangString == null) || (localFileUploadInfo.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label864;
      }
      i2 = 1;
      if ((localFileUploadInfo.jdField_a_of_type_Int != -100001) && (localFileUploadInfo.jdField_a_of_type_Int != -91245) && (localFileUploadInfo.jdField_a_of_type_Int != -7010)) {
        break label870;
      }
      i3 = 1;
      if ((localFileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (localFileUploadInfo.jdField_a_of_type_ArrayOfByte.length != 0)) {
        break label876;
      }
      i4 = 1;
      if (((i4 == 0) || (i2 == 0)) && (((i3 == 0) && (i1 == 0)) || (i5 >= 3))) {
        break label882;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i5 + 1);
      if ((i4 != 0) && (i2 != 0)) {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L, "actFileUpDetail", 0L, "", "", "", 9045L, "retCode[" + localFileUploadInfo.jdField_a_of_type_Int + "]", 0L, 0L, 0L, "", "", 0, "retCode[" + localFileUploadInfo.jdField_a_of_type_Int + "]_uuid null", null);
      }
      a(paramToServiceMsg, false);
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        localFileUploadInfo.jdField_a_of_type_Int = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is failed[" + paramFromServiceMsg.getResultCode() + "]");
      }
      else
      {
        a(paramFromServiceMsg);
        byte[] arrayOfByte = paramFromServiceMsg.getWupBuffer();
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(arrayOfByte);
          if (localRspBody.msg_apply_upload_rsp.has()) {
            break;
          }
          localFileUploadInfo.jdField_a_of_type_Int = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localFileUploadInfo.jdField_a_of_type_Int = -100003;
        }
      }
    }
    localObject = (cmd0x346.ApplyUploadRsp)localRspBody.msg_apply_upload_rsp.get();
    if (((cmd0x346.ApplyUploadRsp)localObject).int32_ret_code.has()) {
      localFileUploadInfo.jdField_a_of_type_Int = ((cmd0x346.ApplyUploadRsp)localObject).int32_ret_code.get();
    }
    if (((cmd0x346.ApplyUploadRsp)localObject).str_ret_msg.has()) {
      localFileUploadInfo.jdField_a_of_type_JavaLangString = ((cmd0x346.ApplyUploadRsp)localObject).str_ret_msg.get();
    }
    if (((cmd0x346.ApplyUploadRsp)localObject).uint64_total_space.has()) {
      localFileUploadInfo.jdField_a_of_type_Long = ((cmd0x346.ApplyUploadRsp)localObject).uint64_total_space.get();
    }
    if (((cmd0x346.ApplyUploadRsp)localObject).uint64_used_space.has()) {
      localFileUploadInfo.jdField_b_of_type_Long = ((cmd0x346.ApplyUploadRsp)localObject).uint64_used_space.get();
    }
    if (((cmd0x346.ApplyUploadRsp)localObject).uint64_uploaded_size.has()) {
      localFileUploadInfo.jdField_c_of_type_Long = ((cmd0x346.ApplyUploadRsp)localObject).uint64_uploaded_size.get();
    }
    if (((cmd0x346.ApplyUploadRsp)localObject).str_upload_ip.has())
    {
      localFileUploadInfo.jdField_b_of_type_JavaLangString = ((cmd0x346.ApplyUploadRsp)localObject).str_upload_ip.get();
      label650:
      if (((cmd0x346.ApplyUploadRsp)localObject).uint32_upload_port.has()) {
        localFileUploadInfo.jdField_a_of_type_Short = ((short)((cmd0x346.ApplyUploadRsp)localObject).uint32_upload_port.get());
      }
      if (((cmd0x346.ApplyUploadRsp)localObject).bytes_uuid.has()) {
        localFileUploadInfo.jdField_a_of_type_ArrayOfByte = ((cmd0x346.ApplyUploadRsp)localObject).bytes_uuid.get().toByteArray();
      }
      if (((cmd0x346.ApplyUploadRsp)localObject).bytes_upload_key.has()) {
        localFileUploadInfo.jdField_b_of_type_ArrayOfByte = ((cmd0x346.ApplyUploadRsp)localObject).bytes_upload_key.get().toByteArray();
      }
      if (((cmd0x346.ApplyUploadRsp)localObject).bool_file_exist.has()) {
        localFileUploadInfo.jdField_a_of_type_Boolean = ((cmd0x346.ApplyUploadRsp)localObject).bool_file_exist.get();
      }
      if (((cmd0x346.ApplyUploadRsp)localObject).uint32_upload_port.has()) {
        localFileUploadInfo.jdField_b_of_type_Int = ((cmd0x346.ApplyUploadRsp)localObject).uint32_pack_size.get();
      }
      if ((!((cmd0x346.ApplyUploadRsp)localObject).rpt_str_uploadip_list.has()) || (((cmd0x346.ApplyUploadRsp)localObject).rpt_str_uploadip_list.get().size() <= 0)) {
        break label1120;
      }
    }
    label859:
    label1120:
    for (localObject = ((cmd0x346.ApplyUploadRsp)localObject).rpt_str_uploadip_list.get();; localObject = null)
    {
      bool1 = true;
      break;
      if (((cmd0x346.ApplyUploadRsp)localObject).str_upload_domain.has())
      {
        localFileUploadInfo.jdField_b_of_type_JavaLangString = ((cmd0x346.ApplyUploadRsp)localObject).str_upload_domain.get();
        break label650;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
      break label650;
      i1 = 0;
      break label135;
      label864:
      i2 = 0;
      break label157;
      label870:
      i3 = 0;
      break label192;
      label876:
      i4 = 0;
      break label212;
      label882:
      MessageObserver.StatictisInfo localStatictisInfo = new MessageObserver.StatictisInfo();
      localStatictisInfo.jdField_b_of_type_Int = localFileUploadInfo.jdField_a_of_type_Int;
      localStatictisInfo.jdField_c_of_type_Int = i5;
      localStatictisInfo.jdField_a_of_type_JavaLangString = MessageHandler.a(paramFromServiceMsg);
      boolean bool2 = bool1;
      if (i4 != 0)
      {
        bool2 = bool1;
        if (i2 != 0)
        {
          localFileUploadInfo.jdField_a_of_type_JavaLangString = ("uuid_null[" + localFileUploadInfo.toString() + "]");
          bool2 = false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool2 + ", retCode=" + localFileUploadInfo.jdField_a_of_type_Int + ", retMsg=" + localFileUploadInfo.jdField_a_of_type_JavaLangString + ", totalSpace=" + localFileUploadInfo.jdField_a_of_type_Long + ", usedSpace=" + localFileUploadInfo.jdField_b_of_type_Long + ", ip=" + localFileUploadInfo.jdField_b_of_type_JavaLangString + ", port=" + localFileUploadInfo.jdField_a_of_type_Short);
      }
      a(paramToServiceMsg, 5004, bool2, new Object[] { localFileUploadInfo, localStatictisInfo, localObject });
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    MessageObserver.StatictisInfo localStatictisInfo = new MessageObserver.StatictisInfo();
    localStatictisInfo.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
    localStatictisInfo.jdField_c_of_type_Int = i1;
    a(paramToServiceMsg, 5003, true, new Object[] { paramOffLineFileInfo.jdField_a_of_type_ArrayOfByte, localStatictisInfo });
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    b(paramToServiceMsg);
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), FileTransferServlet.class);
    localNewIntent.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    long l1 = System.currentTimeMillis();
    paramToServiceMsg.extraData.putLong("sendtimekey", l1);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    FileTransferHandler.FileUploadInfo localFileUploadInfo = new FileTransferHandler.FileUploadInfo(this);
    boolean bool;
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      localFileUploadInfo.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: resp is timeout[" + paramFromServiceMsg.getResultCode() + "]");
      bool = false;
    }
    int i1;
    for (;;)
    {
      i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if ((localFileUploadInfo.jdField_a_of_type_Int != -100001) || (i1 >= 3)) {
        break;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i1 + 1);
      a(paramToServiceMsg, false);
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        localFileUploadInfo.jdField_a_of_type_Int = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: resp is failed[" + paramFromServiceMsg.getResultCode() + "]");
        bool = false;
      }
      else
      {
        a(paramFromServiceMsg);
        byte[] arrayOfByte = paramFromServiceMsg.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(arrayOfByte);
          if (localRspBody.msg_upload_succ_rsp.has()) {
            break label261;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          localFileUploadInfo.jdField_a_of_type_Int = -100003;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localFileUploadInfo.jdField_a_of_type_Int = -100003;
          bool = false;
        }
        continue;
        label261:
        localObject = (cmd0x346.UploadSuccRsp)localRspBody.msg_upload_succ_rsp.get();
        if (((cmd0x346.UploadSuccRsp)localObject).int32_ret_code.has()) {
          localFileUploadInfo.jdField_a_of_type_Int = ((cmd0x346.UploadSuccRsp)localObject).int32_ret_code.get();
        }
        if (((cmd0x346.UploadSuccRsp)localObject).str_ret_msg.has()) {
          localFileUploadInfo.jdField_a_of_type_JavaLangString = ((cmd0x346.UploadSuccRsp)localObject).str_ret_msg.get();
        }
        bool = true;
      }
    }
    Object localObject = new MessageObserver.StatictisInfo();
    ((MessageObserver.StatictisInfo)localObject).jdField_b_of_type_Int = localFileUploadInfo.jdField_a_of_type_Int;
    ((MessageObserver.StatictisInfo)localObject).jdField_c_of_type_Int = i1;
    ((MessageObserver.StatictisInfo)localObject).jdField_a_of_type_JavaLangString = MessageHandler.a(paramFromServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleUploadSuccResponse: return " + bool + ", retCode=" + localFileUploadInfo.jdField_a_of_type_Int + ", retMsg=" + localFileUploadInfo.jdField_a_of_type_JavaLangString);
    }
    a(paramToServiceMsg, 5005, bool, new Object[] { localFileUploadInfo, localObject });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if ((paramOffLineFileInfo == null) || (paramOffLineFileInfo.jdField_a_of_type_Long != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSendOfflineFileResp-->handleError");
      }
      k(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSendOfflineFileResp-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    MessageObserver.StatictisInfo localStatictisInfo = new MessageObserver.StatictisInfo();
    localStatictisInfo.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
    localStatictisInfo.jdField_c_of_type_Int = i1;
    localStatictisInfo.jdField_a_of_type_Int = paramFromServiceMsg.getAppSeq();
    a(paramToServiceMsg, 5004, true, new Object[] { paramOffLineFileInfo, localStatictisInfo });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject13 = null;
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject12 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    Object localObject11 = null;
    Object localObject9 = null;
    short s1 = 0;
    short s3 = 0;
    short s2 = 0;
    Object localObject4 = null;
    Object localObject10 = null;
    cmd0x346.ApplyDownloadRsp localApplyDownloadRsp = null;
    Object localObject7 = null;
    Object localObject6 = null;
    boolean bool;
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      l1 = -100001L;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is timeout[" + paramFromServiceMsg.getResultCode() + "]");
      bool = false;
      localObject4 = localApplyDownloadRsp;
      s1 = s2;
      localObject1 = localObject9;
      localObject3 = localObject8;
    }
    int i1;
    label145:
    int i2;
    label175:
    Object localObject2;
    while ((l1 == 0L) && (localObject4 == null) && (localObject1 == null))
    {
      i1 = 1;
      if ((l1 != -100001L) && (l1 != -91245L) && (l1 != -7010L)) {
        break label758;
      }
      i2 = 1;
      int i3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if (((i2 == 0) && (i1 == 0)) || (i3 >= 3)) {
        break label764;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i3 + 1);
      a(paramToServiceMsg, false);
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        l1 = -100002L;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is failed[" + paramFromServiceMsg.getResultCode() + "]");
        bool = false;
        localObject3 = localObject8;
        localObject1 = localObject9;
        s1 = s2;
        localObject4 = localApplyDownloadRsp;
      }
      else
      {
        a(paramFromServiceMsg);
        byte[] arrayOfByte = paramFromServiceMsg.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(arrayOfByte);
          if (localRspBody.msg_apply_download_rsp.has()) {
            break label403;
          }
          l1 = -100003L;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: rspBody has not hasMsgApplyDownloadRsp");
          bool = false;
          localObject3 = localObject8;
          localObject1 = localObject9;
          s1 = s2;
          localObject4 = localApplyDownloadRsp;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          l1 = -100003L;
          bool = false;
          localObject3 = localObject8;
          localObject2 = localObject9;
          s1 = s2;
          localObject4 = localApplyDownloadRsp;
        }
        continue;
        label403:
        localApplyDownloadRsp = (cmd0x346.ApplyDownloadRsp)localRspBody.msg_apply_download_rsp.get();
        if (!localApplyDownloadRsp.int32_ret_code.has()) {
          break label987;
        }
      }
    }
    label545:
    label952:
    label966:
    label987:
    for (long l1 = localApplyDownloadRsp.int32_ret_code.get();; l1 = 0L)
    {
      localObject5 = localObject13;
      if (localApplyDownloadRsp.str_ret_msg.has()) {
        localObject5 = localApplyDownloadRsp.str_ret_msg.get();
      }
      localObject6 = localObject12;
      localObject7 = localObject11;
      s2 = s3;
      localObject8 = localObject10;
      if (localApplyDownloadRsp.msg_download_info.has())
      {
        localObject9 = (cmd0x346.DownloadInfo)localApplyDownloadRsp.msg_download_info.get();
        if (((cmd0x346.DownloadInfo)localObject9).bytes_download_key.has()) {
          localObject3 = ((cmd0x346.DownloadInfo)localObject9).bytes_download_key.get();
        }
        if (((cmd0x346.DownloadInfo)localObject9).str_download_ip.has())
        {
          localObject2 = ((cmd0x346.DownloadInfo)localObject9).str_download_ip.get();
          if (((cmd0x346.DownloadInfo)localObject9).uint32_port.has()) {
            s1 = (short)((cmd0x346.DownloadInfo)localObject9).uint32_port.get();
          }
          if (((cmd0x346.DownloadInfo)localObject9).str_download_url.has()) {
            localObject4 = ((cmd0x346.DownloadInfo)localObject9).str_download_url.get();
          }
          localObject6 = localObject3;
          localObject7 = localObject2;
          s2 = s1;
          localObject8 = localObject4;
          if (!((cmd0x346.DownloadInfo)localObject9).rpt_str_downloadip_list.has()) {
            break label966;
          }
          localObject6 = localObject3;
          localObject7 = localObject2;
          s2 = s1;
          localObject8 = localObject4;
          if (((cmd0x346.DownloadInfo)localObject9).rpt_str_downloadip_list.get().size() <= 0) {
            break label966;
          }
          localObject9 = ((cmd0x346.DownloadInfo)localObject9).rpt_str_downloadip_list.get();
        }
      }
      for (;;)
      {
        if (localApplyDownloadRsp.msg_file_info.has())
        {
          localObject6 = (cmd0x346.FileInfo)localApplyDownloadRsp.msg_file_info.get();
          if (!((cmd0x346.FileInfo)localObject6).str_file_name.has()) {}
        }
        for (localObject6 = FileManagerUtil.a(((cmd0x346.FileInfo)localObject6).str_file_name.get());; localObject6 = null)
        {
          localObject7 = localObject6;
          bool = true;
          localObject6 = localObject9;
          break;
          if (((cmd0x346.DownloadInfo)localObject9).str_download_domain.has())
          {
            localObject2 = ((cmd0x346.DownloadInfo)localObject9).str_download_domain.get();
            break label545;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: has neither ip nor domain");
          break label545;
          i1 = 0;
          break label145;
          label758:
          i2 = 0;
          break label175;
          label764:
          if (QLog.isColorLevel())
          {
            localObject9 = new StringBuilder().append("handleDownloadResp: return ").append(bool).append(", retCode=").append(l1).append(", retMsg=").append((String)localObject5).append(", key=");
            if (localObject3 == null) {
              break label952;
            }
          }
          for (localObject8 = ((ByteStringMicro)localObject3).toStringUtf8();; localObject8 = "")
          {
            QLog.d("FileTransferHandler<FileAssistant>", 2, (String)localObject8 + ", strIP=" + (String)localObject2 + ", port=" + s1 + ", strUrl=" + (String)localObject4);
            a(paramToServiceMsg, 5006, bool, new Object[] { Long.valueOf(l1), localObject5, localObject3, localObject2, Short.valueOf(s1), localObject4, localObject6, Integer.valueOf(paramFromServiceMsg.getAppSeq()), localObject7 });
            return;
          }
        }
        localObject9 = null;
        localObject3 = localObject6;
        localObject2 = localObject7;
        s1 = s2;
        localObject4 = localObject8;
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo)
  {
    if ((paramOffLineFileInfo == null) || (paramOffLineFileInfo.jdField_a_of_type_Long != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSetOfflineFileState-->handleError");
      }
      k(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSetOfflineFileState-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    MessageObserver.StatictisInfo localStatictisInfo = new MessageObserver.StatictisInfo();
    localStatictisInfo.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
    localStatictisInfo.jdField_c_of_type_Int = i1;
    a(paramToServiceMsg, 5005, true, new Object[] { paramOffLineFileInfo, localStatictisInfo });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    FileTransferHandler.FileUploadInfo localFileUploadInfo = new FileTransferHandler.FileUploadInfo(this);
    boolean bool;
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      localFileUploadInfo.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: resp is timeout[" + paramFromServiceMsg.getResultCode() + "]");
      bool = false;
    }
    int i1;
    for (;;)
    {
      i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if ((localFileUploadInfo.jdField_a_of_type_Int != -100001) || (i1 >= 3)) {
        break;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i1 + 1);
      a(paramToServiceMsg, false);
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        localFileUploadInfo.jdField_a_of_type_Int = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: resp is failed[" + paramFromServiceMsg.getResultCode() + "]");
        bool = false;
      }
      else
      {
        a(paramFromServiceMsg);
        byte[] arrayOfByte = paramFromServiceMsg.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(arrayOfByte);
          if (localRspBody.msg_download_succ_rsp.has()) {
            break label261;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          localFileUploadInfo.jdField_a_of_type_Int = -100003;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localFileUploadInfo.jdField_a_of_type_Int = -100003;
          bool = false;
        }
        continue;
        label261:
        localObject = (cmd0x346.DownloadSuccRsp)localRspBody.msg_download_succ_rsp.get();
        if (((cmd0x346.DownloadSuccRsp)localObject).int32_ret_code.has()) {
          localFileUploadInfo.jdField_a_of_type_Int = ((cmd0x346.DownloadSuccRsp)localObject).int32_ret_code.get();
        }
        if (((cmd0x346.DownloadSuccRsp)localObject).str_ret_msg.has()) {
          localFileUploadInfo.jdField_a_of_type_JavaLangString = ((cmd0x346.DownloadSuccRsp)localObject).str_ret_msg.get();
        }
        if (((cmd0x346.DownloadSuccRsp)localObject).int32_down_stat.has()) {
          localFileUploadInfo.jdField_c_of_type_Int = ((cmd0x346.DownloadSuccRsp)localObject).int32_down_stat.get();
        }
        bool = true;
      }
    }
    Object localObject = new MessageObserver.StatictisInfo();
    ((MessageObserver.StatictisInfo)localObject).jdField_b_of_type_Int = localFileUploadInfo.jdField_a_of_type_Int;
    ((MessageObserver.StatictisInfo)localObject).jdField_c_of_type_Int = i1;
    ((MessageObserver.StatictisInfo)localObject).jdField_a_of_type_JavaLangString = MessageHandler.a(paramFromServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleDownloadSuccResponse: return " + bool + ", retCode=" + localFileUploadInfo.jdField_a_of_type_Int + ", retMsg=" + localFileUploadInfo.jdField_a_of_type_JavaLangString + ", retStat" + localFileUploadInfo.jdField_c_of_type_Int);
    }
    a(paramToServiceMsg, 5007, bool, new Object[] { localFileUploadInfo, localObject });
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = 0;
    Object localObject1 = null;
    int i2;
    Object localObject2;
    boolean bool;
    FromServiceMsg localFromServiceMsg;
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is timeout[" + paramFromServiceMsg.getResultCode() + "]");
      i2 = 0;
      localObject2 = null;
      bool = false;
      localFromServiceMsg = null;
      localObject1 = null;
      i1 = -100001;
      paramFromServiceMsg = null;
    }
    int i3;
    for (;;)
    {
      i3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if ((i1 != -100001) || (i3 >= 3)) {
        break;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i3 + 1);
      a(paramToServiceMsg, false);
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is failed[" + paramFromServiceMsg.getResultCode() + "]");
        i2 = 0;
        localObject2 = null;
        bool = false;
        localFromServiceMsg = null;
        localObject1 = null;
        i1 = -100002;
        paramFromServiceMsg = null;
      }
      else
      {
        a(paramFromServiceMsg);
        paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
        localObject2 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom(paramFromServiceMsg);
          if (((cmd0x346.RspBody)localObject2).msg_apply_download_abs_rsp.has()) {
            break label291;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not hasMsgApplyDownloadAbsRsp");
          i2 = 0;
          localObject2 = null;
          bool = false;
          localFromServiceMsg = null;
          localObject1 = null;
          i1 = -100003;
          paramFromServiceMsg = null;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          i2 = 0;
          localObject2 = null;
          bool = false;
          localFromServiceMsg = null;
          localObject1 = null;
          i1 = -100003;
          paramFromServiceMsg = null;
        }
        continue;
        label291:
        localObject2 = (cmd0x346.ApplyDownloadAbsRsp)((cmd0x346.RspBody)localObject2).msg_apply_download_abs_rsp.get();
        if (((cmd0x346.ApplyDownloadAbsRsp)localObject2).int32_ret_code.has()) {
          i1 = ((cmd0x346.ApplyDownloadAbsRsp)localObject2).int32_ret_code.get();
        }
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        if (((cmd0x346.ApplyDownloadAbsRsp)localObject2).str_ret_msg.has()) {
          paramFromServiceMsg = ((cmd0x346.ApplyDownloadAbsRsp)localObject2).str_ret_msg.get();
        }
        if (!((cmd0x346.ApplyDownloadAbsRsp)localObject2).msg_download_info.has())
        {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not MsgDownloadSuccRsp");
          i2 = 0;
          localObject2 = null;
          bool = false;
          localFromServiceMsg = paramFromServiceMsg;
          localObject1 = null;
          i1 = -100003;
          paramFromServiceMsg = null;
        }
        else
        {
          localObject2 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadAbsRsp)localObject2).msg_download_info.get();
          String str = ((cmd0x346.DownloadInfo)localObject2).str_download_ip.get();
          localObject1 = ((cmd0x346.DownloadInfo)localObject2).str_download_domain.get();
          i2 = ((cmd0x346.DownloadInfo)localObject2).uint32_port.get();
          ((cmd0x346.DownloadInfo)localObject2).str_download_url.get();
          localObject2 = HexUtil.a(((cmd0x346.DownloadInfo)localObject2).bytes_download_key.get().toByteArray());
          bool = true;
          localFromServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = (FromServiceMsg)localObject1;
          localObject1 = str;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handlePreviewResponse: return " + bool + ", retCode=" + i1 + ", retMsg=" + localFromServiceMsg + ", Key=" + (String)localObject2 + ", IP=" + (String)localObject1 + ", Domain=" + paramFromServiceMsg + ", port=" + i2);
    }
    if (i1 == -100001) {
      i3 = 9043;
    }
    for (;;)
    {
      if (i3 != 0) {
        bool = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 18, new Object[] { Integer.valueOf(i3), localFromServiceMsg, localObject2, localObject1, paramFromServiceMsg, Integer.valueOf(i2) });
      return;
      i3 = i1;
      if (i1 == -100003) {
        i3 = 9045;
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    int i1 = 0;
    String str2 = null;
    String str1 = null;
    long l1 = 0L;
    long l2 = 0L;
    long l3 = paramToServiceMsg.extraData.getLong("Context");
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is timeout[" + paramFromServiceMsg.getResultCode() + "]");
      str1 = null;
      paramFromServiceMsg = null;
      i1 = -100001;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if ((i1 != -100001) || (i2 >= 3)) {
        break;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i2 + 1);
      a(paramToServiceMsg, false);
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is failed[" + paramFromServiceMsg.getResultCode() + "]");
        str1 = null;
        paramFromServiceMsg = null;
        i1 = -100002;
      }
      else
      {
        a(paramFromServiceMsg);
        paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
        Object localObject = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject).mergeFrom(paramFromServiceMsg);
          if (((cmd0x346.RspBody)localObject).msg_apply_forward_file_rsp.has()) {
            break label267;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse rspBody has not hasMsgApplyForwardFileRsp");
          str1 = null;
          paramFromServiceMsg = null;
          i1 = -100003;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          str1 = null;
          paramFromServiceMsg = null;
          i1 = -100003;
        }
        continue;
        label267:
        localObject = (cmd0x346.ApplyForwardFileRsp)((cmd0x346.RspBody)localObject).msg_apply_forward_file_rsp.get();
        if (((cmd0x346.ApplyForwardFileRsp)localObject).int32_ret_code.has()) {
          i1 = ((cmd0x346.ApplyForwardFileRsp)localObject).int32_ret_code.get();
        }
        paramFromServiceMsg = str2;
        if (((cmd0x346.ApplyForwardFileRsp)localObject).str_ret_msg.has()) {
          paramFromServiceMsg = ((cmd0x346.ApplyForwardFileRsp)localObject).str_ret_msg.get();
        }
        if (((cmd0x346.ApplyForwardFileRsp)localObject).bytes_uuid.has()) {
          str1 = new String(((cmd0x346.ApplyForwardFileRsp)localObject).bytes_uuid.get().toByteArray());
        }
        if (((cmd0x346.ApplyForwardFileRsp)localObject).uint64_total_space.has()) {
          l1 = ((cmd0x346.ApplyForwardFileRsp)localObject).uint64_total_space.get();
        }
        if (((cmd0x346.ApplyForwardFileRsp)localObject).uint64_used_space.has()) {
          l2 = ((cmd0x346.ApplyForwardFileRsp)localObject).uint64_used_space.get();
        }
        bool = true;
      }
    }
    if (i1 != 0) {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleForwardResponse: return " + bool + ", retCode=" + i1 + ", retMsg=" + paramFromServiceMsg + ", totalSpace=" + l1 + ", usedSpace=" + l2);
      }
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3);
      if (paramToServiceMsg == null) {
        QLog.e("FileTransferHandler<FileAssistant>", 1, "forward offline file, but entity is null!!!");
      }
      for (;;)
      {
        if (bool)
        {
          paramToServiceMsg = new FileManagerReporter.fileAssistantReportData();
          paramToServiceMsg.jdField_a_of_type_JavaLangString = "send_file_suc";
          paramToServiceMsg.jdField_a_of_type_Int = 1;
          FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, i1, paramFromServiceMsg, str1, l3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 19, new Object[] { Integer.valueOf(i1), paramFromServiceMsg, Long.valueOf(l1), Long.valueOf(l2), str1, Long.valueOf(l3) });
        return;
        if ((FileManagerUtil.a(paramToServiceMsg.fileName) == 0) && ((paramToServiceMsg.strThumbPath == null) || (paramToServiceMsg.strThumbPath.length() < 1)))
        {
          str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 3, true, paramToServiceMsg);
          if (str2 != null) {
            paramToServiceMsg.strThumbPath = str2;
          }
        }
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    int i1 = 0;
    Object localObject1 = null;
    long l1 = paramToServiceMsg.extraData.getLong("Context");
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is timeout[" + paramFromServiceMsg.getResultCode() + "]");
      paramFromServiceMsg = null;
      localObject1 = null;
      i1 = -100001;
    }
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if ((i1 != -100001) || (i2 >= 3)) {
        break label351;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i2 + 1);
      a(paramToServiceMsg, false);
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is failed[" + paramFromServiceMsg.getResultCode() + "]");
        paramFromServiceMsg = null;
        localObject1 = null;
        i1 = -100002;
      }
      else
      {
        a(paramFromServiceMsg);
        paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
        localObject2 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom(paramFromServiceMsg);
          if (((cmd0x346.RspBody)localObject2).msg_apply_copy_to_rsp.has()) {
            break;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse rspBody has not hasMsgApplyDownloadAbsRsp");
          paramFromServiceMsg = null;
          localObject1 = null;
          i1 = -100003;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = null;
          localObject1 = null;
          i1 = -100003;
        }
      }
    }
    Object localObject2 = (cmd0x346.ApplyCopyToRsp)((cmd0x346.RspBody)localObject2).msg_apply_copy_to_rsp.get();
    if (((cmd0x346.ApplyCopyToRsp)localObject2).int32_ret_code.has()) {
      i1 = ((cmd0x346.ApplyCopyToRsp)localObject2).int32_ret_code.get();
    }
    paramFromServiceMsg = (FromServiceMsg)localObject1;
    if (((cmd0x346.ApplyCopyToRsp)localObject2).str_ret_msg.has()) {
      paramFromServiceMsg = ((cmd0x346.ApplyCopyToRsp)localObject2).str_ret_msg.get();
    }
    if (((cmd0x346.ApplyCopyToRsp)localObject2).str_file_key.has()) {}
    for (localObject1 = ((cmd0x346.ApplyCopyToRsp)localObject2).str_file_key.get();; localObject1 = null)
    {
      localObject2 = paramFromServiceMsg;
      bool = true;
      paramFromServiceMsg = (FromServiceMsg)localObject1;
      localObject1 = localObject2;
      break;
      label351:
      if (i1 != 0) {
        bool = false;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleForwardResponse: return " + bool + ", retCode=" + i1 + ", retMsg=" + (String)localObject1);
        }
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
        if (paramToServiceMsg == null)
        {
          QLog.e("FileTransferHandler<FileAssistant>", 1, "forward offline file, but entity is null!!!");
          return;
        }
        if (bool)
        {
          localObject2 = new FileManagerReporter.fileAssistantReportData();
          ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_JavaLangString = "send_file_suc";
          ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_Int = 1;
          FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject2);
        }
        switch (paramToServiceMsg.nOpType)
        {
        case 5: 
        case 6: 
        default: 
          return;
        case 4: 
          if (((paramFromServiceMsg == null) || (paramFromServiceMsg.length() < 1)) && (QLog.isColorLevel())) {
            QLog.w("FileTransferHandler<FileAssistant>", 2, "forward offline to weiyun ,but weiyun fileid is null! retCode[" + String.valueOf(i1) + "retMsg[" + String.valueOf(localObject1) + "]");
          }
          if (!bool) {
            break;
          }
        }
        for (paramToServiceMsg.status = 1;; paramToServiceMsg.status = 0)
        {
          paramToServiceMsg.WeiYunFileId = paramFromServiceMsg;
          paramToServiceMsg.cloudType = 2;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramToServiceMsg);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 34, new Object[] { Integer.valueOf(i1), localObject1, paramFromServiceMsg, Long.valueOf(l1) });
          return;
          if (((paramFromServiceMsg == null) || (paramFromServiceMsg.length() < 1)) && (QLog.isColorLevel())) {
            QLog.w("FileTransferHandler<FileAssistant>", 2, "forward offline to weiyun ,but weiyun fileid is null! retCode[" + String.valueOf(i1) + "retMsg[" + String.valueOf(localObject1) + "]");
          }
          if (bool) {}
          for (paramToServiceMsg.status = 1;; paramToServiceMsg.status = 0)
          {
            paramToServiceMsg.Uuid = paramFromServiceMsg;
            paramToServiceMsg.cloudType = 1;
            a(paramToServiceMsg.nSessionId, paramToServiceMsg.peerUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg.fileName, paramToServiceMsg.fileSize, paramFromServiceMsg, paramToServiceMsg.uniseq, paramToServiceMsg.msgUid, null);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 19, new Object[] { Integer.valueOf(i1), localObject1, Long.valueOf(0L), Long.valueOf(0L), paramFromServiceMsg, Long.valueOf(l1) });
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, 6, "");
            return;
          }
        }
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    int i1 = 0;
    Object localObject2 = null;
    String str = null;
    Object localObject1 = null;
    long l1 = paramToServiceMsg.extraData.getLong("Context");
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      i1 = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryFileInfo: resp is timeout[" + paramFromServiceMsg.getResultCode() + "]");
      paramFromServiceMsg = localObject1;
      paramToServiceMsg = str;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleQueryFileInfo: return " + bool + ", retCode=" + i1 + ", retMsg=" + paramToServiceMsg);
      }
      if (paramFromServiceMsg != null) {
        break label391;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 190, new Object[] { Integer.valueOf(i1), paramToServiceMsg, Long.valueOf(l1) });
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        i1 = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryFileInfo: resp is failed[" + paramFromServiceMsg.getResultCode() + "]");
        paramToServiceMsg = str;
        paramFromServiceMsg = localObject1;
      }
      else
      {
        a(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
        paramFromServiceMsg = new cmd0x346.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg);
          if (paramFromServiceMsg.msg_file_query_rsp.has()) {
            break;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryFileInfo rspBody has not hasMsgFileQueryRsp");
          i1 = -100003;
          paramToServiceMsg = str;
          paramFromServiceMsg = localObject1;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
          i1 = -100003;
          paramToServiceMsg = str;
          paramFromServiceMsg = localObject1;
        }
      }
    }
    paramFromServiceMsg = (cmd0x346.FileQueryRsp)paramFromServiceMsg.msg_file_query_rsp.get();
    if (paramFromServiceMsg.int32_ret_code.has()) {
      i1 = paramFromServiceMsg.int32_ret_code.get();
    }
    paramToServiceMsg = localObject2;
    if (paramFromServiceMsg.str_ret_msg.has()) {
      paramToServiceMsg = paramFromServiceMsg.str_ret_msg.get();
    }
    if (paramFromServiceMsg.msg_file_info.has()) {}
    for (paramFromServiceMsg = (cmd0x346.FileInfo)paramFromServiceMsg.msg_file_info.get();; paramFromServiceMsg = null)
    {
      bool = true;
      break;
      label391:
      str = paramFromServiceMsg.str_file_name.get();
      int i2 = paramFromServiceMsg.uint32_danger_evel.get();
      long l2 = paramFromServiceMsg.uint64_file_size.get();
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "Query fileinfo success, filename[" + str + "], dangerlevel[" + String.valueOf(i2) + "], nFileSize[" + String.valueOf(l2) + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 190, new Object[] { Integer.valueOf(i1), paramToServiceMsg, Long.valueOf(l1), str, Integer.valueOf(i2), Long.valueOf(l2) });
      return;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    cmd0x346.RspBody localRspBody;
    if (paramFromServiceMsg.isSuccess())
    {
      a(paramFromServiceMsg);
      localObject = paramFromServiceMsg.getWupBuffer();
      paramToServiceMsg = paramToServiceMsg.extraData.getString("Context");
      paramFromServiceMsg = FMDataCache.a(paramToServiceMsg);
      localRspBody = new cmd0x346.RspBody();
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])localObject);
        if (localRspBody.msg_delete_file_rsp.has())
        {
          localObject = (cmd0x346.DeleteFileRsp)localRspBody.msg_delete_file_rsp.get();
          i1 = ((cmd0x346.DeleteFileRsp)localObject).int32_ret_code.get();
          localObject = ((cmd0x346.DeleteFileRsp)localObject).str_ret_msg.get();
          if (i1 == 0) {
            break label334;
          }
          bool = false;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse, bSucess[" + String.valueOf(bool) + "],fileName[" + paramFromServiceMsg + "],uuid[" + paramToServiceMsg + "]");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bool, 20, new Object[] { Integer.valueOf(i1), localObject, paramToServiceMsg, paramFromServiceMsg, Boolean.valueOf(true) });
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      int i1 = -100002;
      paramToServiceMsg = paramToServiceMsg.extraData.getString("Context");
      localObject = FMDataCache.a(paramToServiceMsg);
      if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
      {
        i1 = -100001;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is timeout[" + paramFromServiceMsg.getResultCode() + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 20, new Object[] { Integer.valueOf(i1), "", paramToServiceMsg, localObject, Boolean.valueOf(true) });
      return;
      label334:
      boolean bool = true;
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleReqOffFilePackError, count: " + i1);
    }
    if (i1 < 3)
    {
      paramToServiceMsg.extraData.putInt("retryIndex", i1 + 1);
      c(paramToServiceMsg);
      return;
    }
    MessageObserver.StatictisInfo localStatictisInfo = new MessageObserver.StatictisInfo();
    localStatictisInfo.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
    localStatictisInfo.jdField_c_of_type_Int = i1;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      localStatictisInfo.jdField_b_of_type_Int = 2900;
      localStatictisInfo.d = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 2139062142L);
    }
    localStatictisInfo.jdField_a_of_type_JavaLangString = MessageHandler.a(paramFromServiceMsg);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
    switch (paramToServiceMsg.extraData.getInt("offfile_type"))
    {
    case 0: 
    default: 
      return;
    case 1: 
      a(paramToServiceMsg, 5003, false, new Object[] { paramFromServiceMsg, localStatictisInfo });
      return;
    case 2: 
      a(paramToServiceMsg, 5005, false, new Object[] { paramFromServiceMsg, localStatictisInfo });
      return;
    }
    a(paramToServiceMsg, 5004, false, new Object[] { paramFromServiceMsg, localStatictisInfo });
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i1 = 1;
    long l1;
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is timeout[" + paramFromServiceMsg.getResultCode() + "]");
      l1 = -100001L;
      label62:
      if (l1 != -100001L) {
        break label466;
      }
    }
    label249:
    Object localObject;
    for (;;)
    {
      int i2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if ((i1 == 0) || (i2 >= 3)) {
        break label471;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i2 + 1);
      a(paramToServiceMsg, false);
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        l1 = -100002L;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is failed[" + paramFromServiceMsg.getResultCode() + "]");
        break label62;
      }
      a(paramFromServiceMsg);
      byte[] arrayOfByte = paramFromServiceMsg.getWupBuffer();
      cmd0x345.RspBody localRspBody = new cmd0x345.RspBody();
      try
      {
        localRspBody.mergeFrom(arrayOfByte);
        if (!localRspBody.msg_subcmd_0x1_rsp_body.has()) {
          break label249;
        }
        a(localRspBody.uint32_return_code.get(), paramToServiceMsg, paramFromServiceMsg, (cmd0x345.RspBody.SubCmd0x1RspBody)localRspBody.msg_subcmd_0x1_rsp_body.get());
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        l1 = -100003L;
      }
      break label62;
      if (localRspBody.msg_subcmd_0x2_rsp_body.has())
      {
        a(localRspBody.uint32_return_code.get(), paramToServiceMsg, paramFromServiceMsg, (cmd0x345.RspBody.SubCmd0x2RspBody)localRspBody.msg_subcmd_0x2_rsp_body.get());
        return;
      }
      if (localRspBody.msg_subcmd_0x3_rsp_body.has())
      {
        a(localRspBody.uint32_return_code.get(), paramToServiceMsg, paramFromServiceMsg, (cmd0x345.RspBody.SubCmd0x3RspBody)localRspBody.msg_subcmd_0x3_rsp_body.get());
        return;
      }
      if (localRspBody.msg_subcmd_0x5_rsp_body.has())
      {
        l1 = localRspBody.uint32_return_code.get();
        localObject = (cmd0x345.RspBody.SubCmd0x5RspBody)localRspBody.msg_subcmd_0x5_rsp_body.get();
        a((int)l1, paramToServiceMsg, paramFromServiceMsg, (cmd0x345.RspBody.SubCmd0x5RspBody)localObject);
        return;
      }
      if (localRspBody.msg_subcmd_0x6_rsp_body.has())
      {
        l1 = localRspBody.uint32_return_code.get();
        localObject = (cmd0x345.RspBody.SubCmd0x6RspBody)localRspBody.msg_subcmd_0x6_rsp_body.get();
        a((int)l1, paramToServiceMsg, paramFromServiceMsg, (cmd0x345.RspBody.SubCmd0x6RspBody)localObject);
        return;
      }
      if (!localRspBody.msg_subcmd_0x7_rsp_body.has()) {
        break;
      }
      l1 = localRspBody.uint32_return_code.get();
      localObject = (cmd0x345.RspBody.SubCmd0x7RspBody)localRspBody.msg_subcmd_0x7_rsp_body.get();
      a((int)l1, paramToServiceMsg, paramFromServiceMsg, (cmd0x345.RspBody.SubCmd0x7RspBody)localObject);
      return;
      label466:
      i1 = 0;
    }
    label471:
    if (i1 != 0) {
      l1 = 9043L;
    }
    for (;;)
    {
      localObject = new cmd0x345.RspBody();
      if (((cmd0x345.RspBody)localObject).msg_subcmd_0x1_rsp_body.has())
      {
        a(l1, paramToServiceMsg, paramFromServiceMsg, (cmd0x345.RspBody.SubCmd0x1RspBody)((cmd0x345.RspBody)localObject).msg_subcmd_0x1_rsp_body.get());
        return;
        if (l1 == -100003L) {
          l1 = 9045L;
        }
      }
      else
      {
        if (((cmd0x345.RspBody)localObject).msg_subcmd_0x2_rsp_body.has())
        {
          a(l1, paramToServiceMsg, paramFromServiceMsg, (cmd0x345.RspBody.SubCmd0x2RspBody)((cmd0x345.RspBody)localObject).msg_subcmd_0x2_rsp_body.get());
          return;
        }
        if (((cmd0x345.RspBody)localObject).msg_subcmd_0x3_rsp_body.has())
        {
          a(l1, paramToServiceMsg, paramFromServiceMsg, (cmd0x345.RspBody.SubCmd0x3RspBody)((cmd0x345.RspBody)localObject).msg_subcmd_0x3_rsp_body.get());
          return;
        }
        if (((cmd0x345.RspBody)localObject).msg_subcmd_0x5_rsp_body.has())
        {
          localObject = (cmd0x345.RspBody.SubCmd0x5RspBody)((cmd0x345.RspBody)localObject).msg_subcmd_0x5_rsp_body.get();
          a((int)l1, paramToServiceMsg, paramFromServiceMsg, (cmd0x345.RspBody.SubCmd0x5RspBody)localObject);
          return;
        }
        if (((cmd0x345.RspBody)localObject).msg_subcmd_0x6_rsp_body.has())
        {
          localObject = (cmd0x345.RspBody.SubCmd0x6RspBody)((cmd0x345.RspBody)localObject).msg_subcmd_0x6_rsp_body.get();
          a((int)l1, paramToServiceMsg, paramFromServiceMsg, (cmd0x345.RspBody.SubCmd0x6RspBody)localObject);
          return;
        }
        if (!((cmd0x345.RspBody)localObject).msg_subcmd_0x7_rsp_body.has()) {
          break;
        }
        localObject = (cmd0x345.RspBody.SubCmd0x7RspBody)((cmd0x345.RspBody)localObject).msg_subcmd_0x7_rsp_body.get();
        a((int)l1, paramToServiceMsg, paramFromServiceMsg, (cmd0x345.RspBody.SubCmd0x7RspBody)localObject);
        return;
      }
    }
  }
  
  public long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, im_msg_body.GroupFile paramGroupFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "handleDiscFileCome,uinseq[" + String.valueOf(paramLong1) + "],discUin[" + String.valueOf(paramLong2) + "],sendUin[" + String.valueOf(paramLong3) + "],seq[" + String.valueOf(paramLong4) + "],msgTime[" + String.valueOf(paramLong6) + "],fileInfo[" + String.valueOf(paramGroupFile) + "]");
    }
    return b(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramGroupFile);
  }
  
  public long a(List paramList, String paramString1, String paramString2, String paramString3, long paramLong1, boolean paramBoolean, int paramInt1, String paramString4, long paramLong2, long paramLong3, String paramString5, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt3)
  {
    paramString5 = MessageRecordFactory.a(paramInt3);
    paramString5.uniseq = paramLong4;
    paramString5.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramString5.frienduin = paramString1;
    paramString5.senderuin = paramString2;
    if ((paramString4 == null) || (paramString4.length() < 1)) {
      paramString4 = TransfileUtile.a(paramString3, paramLong1, 0, paramBoolean);
    }
    for (;;)
    {
      if (paramInt3 == -3008)
      {
        paramString5.msg = paramString3;
        paramString5.msgtype = paramInt3;
        paramString5.isread = paramBoolean;
        if (!paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
          break label431;
        }
        paramInt2 = 1;
        label110:
        paramString5.issend = paramInt2;
        paramString5.istroop = paramInt1;
        paramString5.msgseq = paramLong2;
        paramLong1 = paramLong3;
        if (paramLong3 == 0L) {
          paramLong1 = Math.abs(new Random().nextInt());
        }
        paramString5.shmsgseq = paramLong1;
        paramString5.msgUid = paramLong5;
        paramString5.time = paramLong7;
        if (!paramString5.isSend()) {
          break label437;
        }
        ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(paramString5);
      }
      for (;;)
      {
        if (paramInt3 == -2005) {
          ((MessageForFile)paramString5).parse();
        }
        paramList.add(paramString5);
        QLog.i("FileTransferHandler<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(paramString5.uniseq) + "], selfuin[" + FileManagerUtil.e(paramString5.selfuin) + "], frienduin[" + FileManagerUtil.e(paramString5.frienduin) + "], senderuin[" + FileManagerUtil.e(paramString5.senderuin) + "], issend[" + String.valueOf(paramString5.issend) + "], istroop[" + String.valueOf(paramString5.istroop) + "], shmsgseq[" + String.valueOf(paramString5.shmsgseq) + "], msgUid[" + String.valueOf(paramString5.msgUid) + "], time[" + String.valueOf(paramString5.time) + "], vipBubbleID[" + String.valueOf(paramLong6) + "]");
        return paramString5.uniseq;
        paramString3 = paramString4;
        break;
        label431:
        paramInt2 = 0;
        break label110;
        label437:
        if (paramLong6 != -1L) {
          paramString5.vipBubbleID = paramLong6;
        } else {
          paramString5.vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1);
        }
      }
    }
  }
  
  public MessageRecord a(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("------->msgFilter :msgIsTroop:").append(paramInt).append(",peerUin:").append(paramString1).append(",list size:");
      if (localObject == null)
      {
        paramInt = 0;
        QLog.d("FileTransferHandler<FileAssistant>", 2, paramInt);
      }
    }
    else
    {
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label257;
      }
      paramString1 = ((List)localObject).iterator();
      label98:
      do
      {
        if (!paramString1.hasNext()) {
          break label257;
        }
        localObject = (MessageRecord)paramString1.next();
        if ((((MessageRecord)localObject).msgUid == 0L) || (paramLong3 == 0L)) {
          break;
        }
      } while ((((MessageRecord)localObject).msgUid != paramLong3) || (((MessageRecord)localObject).shmsgseq != paramLong2) || (!((MessageRecord)localObject).senderuin.equals(paramString2)));
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
      }
    }
    do
    {
      return localObject;
      paramInt = ((List)localObject).size();
      break;
      if ((Math.abs(((MessageRecord)localObject).time - paramLong1) >= 30L) || (((MessageRecord)localObject).shmsgseq != paramLong2) || (!((MessageRecord)localObject).senderuin.equals(paramString2))) {
        break label98;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
    return localObject;
    label257:
    return null;
  }
  
  public OnlineFileSessionInfo a(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    if ((paramArrayOfByte == null) || (i1 == 0))
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed context=null");
      return null;
    }
    OnlineFileSessionInfo localOnlineFileSessionInfo = new OnlineFileSessionInfo();
    int i2;
    if (i1 >= 16)
    {
      PkgTools.b(paramArrayOfByte, 0, localOnlineFileSessionInfo.jdField_a_of_type_ArrayOfByte, 16);
      if (i1 >= 28)
      {
        localOnlineFileSessionInfo.jdField_b_of_type_Long = PkgTools.a(paramArrayOfByte, 24);
        if (i1 < 51) {
          break label115;
        }
        i2 = PkgTools.a(paramArrayOfByte, 49);
        if (i2 >= 4) {
          break label126;
        }
        localOnlineFileSessionInfo.jdField_b_of_type_Boolean = false;
        return localOnlineFileSessionInfo;
      }
    }
    else
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - bufAppGuid");
      return null;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - dwSessionId");
    return null;
    label115:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - bufOther");
    return null;
    label126:
    byte[] arrayOfByte = new byte[i2];
    label150:
    int i3;
    int i4;
    if (i1 >= i2 + 51)
    {
      PkgTools.b(paramArrayOfByte, 51, arrayOfByte, i2);
      i1 = 0;
      if (i1 < i2)
      {
        i3 = arrayOfByte[i1];
        i4 = i1 + 1;
        if (i2 < i4 + 2) {
          break label213;
        }
        i1 = PkgTools.a(arrayOfByte, i4);
        i4 += 2;
        if (i3 != 1) {
          break label225;
        }
      }
    }
    label213:
    label225:
    do
    {
      for (;;)
      {
        i1 = i4 + i1;
        break label150;
        break;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - ismulitendpoint");
        return null;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - L");
        break;
        if ((i3 != 2) && (i3 != 3))
        {
          if (i3 == 4)
          {
            paramArrayOfByte = new byte[i1];
            if (i2 >= i4 + i1)
            {
              PkgTools.b(arrayOfByte, i4, paramArrayOfByte, i1);
              paramArrayOfByte = a(paramArrayOfByte);
              if (paramArrayOfByte != null)
              {
                localOnlineFileSessionInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte.jdField_a_of_type_JavaLangString;
                localOnlineFileSessionInfo.jdField_a_of_type_Long = paramArrayOfByte.jdField_a_of_type_Long;
              }
            }
            else
            {
              QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - V");
              break;
            }
            QLog.e("FileTransferHandler<FileAssistant>", 1, "decode file info error for request or accept");
            return null;
          }
          if (i3 != 12) {
            if (i3 == 15)
            {
              if (i1 < 1)
              {
                localOnlineFileSessionInfo.jdField_b_of_type_Boolean = false;
              }
              else if (i2 >= i4 + i1)
              {
                paramArrayOfByte = new byte[i1];
                PkgTools.b(arrayOfByte, i4, paramArrayOfByte, i1);
                if (paramArrayOfByte[0] == 1) {}
                for (bool = true;; bool = false)
                {
                  localOnlineFileSessionInfo.jdField_b_of_type_Boolean = bool;
                  break;
                }
              }
            }
            else if (i3 == 17)
            {
              if (i1 >= 1) {
                break label414;
              }
              localOnlineFileSessionInfo.c = false;
            }
          }
        }
      }
    } while (i2 < i4 + i1);
    label414:
    paramArrayOfByte = new byte[i1];
    PkgTools.b(arrayOfByte, i4, paramArrayOfByte, i1);
    if (paramArrayOfByte[0] == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localOnlineFileSessionInfo.c = bool;
      break;
    }
  }
  
  /* Error */
  public List a(MessageHandler paramMessageHandler, List paramList, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 660	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 661	java/util/ArrayList:<init>	()V
    //   7: astore 16
    //   9: new 660	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 661	java/util/ArrayList:<init>	()V
    //   16: astore 17
    //   18: aload 17
    //   20: aload_2
    //   21: invokeinterface 1658 2 0
    //   26: pop
    //   27: iconst_0
    //   28: istore 7
    //   30: iload 7
    //   32: aload 17
    //   34: invokeinterface 669 1 0
    //   39: if_icmpge +805 -> 844
    //   42: aload 17
    //   44: iload 7
    //   46: invokeinterface 672 2 0
    //   51: checkcast 1660	msf/msgcomm/msg_comm$Msg
    //   54: astore 18
    //   56: aload 18
    //   58: getfield 1664	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   61: invokevirtual 1667	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   64: checkcast 1666	msf/msgcomm/msg_comm$MsgHead
    //   67: astore_1
    //   68: aload 18
    //   70: getfield 1671	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   73: invokevirtual 1674	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   76: checkcast 1673	tencent/im/msg/im_msg_body$MsgBody
    //   79: astore 19
    //   81: aload 18
    //   83: getfield 1664	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   86: invokevirtual 1675	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   89: ifne +68 -> 157
    //   92: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +752 -> 847
    //   98: ldc 11
    //   100: iconst_2
    //   101: new 168	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 1677
    //   111: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: iload 7
    //   116: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: ldc_w 1679
    //   122: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: iconst_1
    //   132: istore 6
    //   134: iload 6
    //   136: ifeq +12 -> 148
    //   139: aload_2
    //   140: aload 18
    //   142: invokeinterface 1682 2 0
    //   147: pop
    //   148: iload 7
    //   150: iconst_1
    //   151: iadd
    //   152: istore 7
    //   154: goto -124 -> 30
    //   157: aload_1
    //   158: getfield 1685	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   161: invokevirtual 549	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   164: i2s
    //   165: istore 9
    //   167: aload_1
    //   168: getfield 1688	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   171: invokevirtual 948	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   174: pop2
    //   175: aload_1
    //   176: getfield 1691	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   179: invokevirtual 948	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   182: lstore 10
    //   184: aload_1
    //   185: getfield 1694	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   188: invokevirtual 549	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   191: i2l
    //   192: lstore 12
    //   194: aload_1
    //   195: getfield 1697	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   198: invokevirtual 948	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   201: lstore 14
    //   203: aload_1
    //   204: getfield 1700	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   207: invokevirtual 549	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   210: istore 6
    //   212: aload 18
    //   214: getfield 1664	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   217: invokevirtual 1667	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   220: checkcast 1666	msf/msgcomm/msg_comm$MsgHead
    //   223: getfield 1703	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   226: invokevirtual 549	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   229: istore 8
    //   231: iload 6
    //   233: invokestatic 1708	com/tencent/mobileqq/service/message/MessageUtils:c	(I)Z
    //   236: ifeq +21 -> 257
    //   239: aload_1
    //   240: getfield 1703	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   243: invokevirtual 548	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   246: ifeq +11 -> 257
    //   249: iload 8
    //   251: sipush 169
    //   254: if_icmpeq +23 -> 277
    //   257: iload 6
    //   259: sipush 529
    //   262: if_icmpne +9 -> 271
    //   265: iload 8
    //   267: iconst_4
    //   268: if_icmpeq +9 -> 277
    //   271: iconst_0
    //   272: istore 6
    //   274: goto -140 -> 134
    //   277: iload 6
    //   279: invokestatic 1708	com/tencent/mobileqq/service/message/MessageUtils:c	(I)Z
    //   282: ifeq +199 -> 481
    //   285: aload_1
    //   286: getfield 1703	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   289: invokevirtual 548	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   292: ifeq +189 -> 481
    //   295: iload 8
    //   297: sipush 169
    //   300: if_icmpne +181 -> 481
    //   303: aload 18
    //   305: getfield 1671	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   308: invokevirtual 1709	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   311: ifeq +23 -> 334
    //   314: aload 18
    //   316: getfield 1671	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   319: invokevirtual 1674	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   322: checkcast 1673	tencent/im/msg/im_msg_body$MsgBody
    //   325: getfield 1713	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   328: invokevirtual 1716	tencent/im/msg/im_msg_body$RichText:has	()Z
    //   331: ifne +74 -> 405
    //   334: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +510 -> 847
    //   340: ldc 11
    //   342: iconst_2
    //   343: new 168	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 1718
    //   353: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 18
    //   358: getfield 1671	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   361: invokevirtual 1709	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   364: invokevirtual 239	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   367: ldc_w 1720
    //   370: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 18
    //   375: getfield 1671	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   378: invokevirtual 1674	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   381: checkcast 1673	tencent/im/msg/im_msg_body$MsgBody
    //   384: getfield 1713	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   387: invokevirtual 1716	tencent/im/msg/im_msg_body$RichText:has	()Z
    //   390: invokevirtual 239	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   393: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: iconst_1
    //   400: istore 6
    //   402: goto -268 -> 134
    //   405: aload 18
    //   407: getfield 1671	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   410: invokevirtual 1674	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   413: checkcast 1673	tencent/im/msg/im_msg_body$MsgBody
    //   416: getfield 1713	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   419: invokevirtual 1721	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   422: checkcast 1715	tencent/im/msg/im_msg_body$RichText
    //   425: astore 19
    //   427: aload 19
    //   429: getfield 1725	tencent/im/msg/im_msg_body$RichText:not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   432: invokevirtual 1728	tencent/im/msg/im_msg_body$NotOnlineFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   435: checkcast 1727	tencent/im/msg/im_msg_body$NotOnlineFile
    //   438: astore_1
    //   439: aload 19
    //   441: getfield 1725	tencent/im/msg/im_msg_body$RichText:not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   444: invokevirtual 1729	tencent/im/msg/im_msg_body$NotOnlineFile:has	()Z
    //   447: ifne +24 -> 471
    //   450: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   453: ifeq +394 -> 847
    //   456: ldc 11
    //   458: iconst_2
    //   459: ldc_w 1731
    //   462: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   465: iconst_1
    //   466: istore 6
    //   468: goto -334 -> 134
    //   471: aload_1
    //   472: ifnonnull +154 -> 626
    //   475: iconst_1
    //   476: istore 6
    //   478: goto -344 -> 134
    //   481: iload 6
    //   483: sipush 529
    //   486: if_icmpne +361 -> 847
    //   489: iload 8
    //   491: iconst_4
    //   492: if_icmpne +355 -> 847
    //   495: aload 18
    //   497: getfield 1671	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   500: invokevirtual 1674	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   503: checkcast 1673	tencent/im/msg/im_msg_body$MsgBody
    //   506: getfield 1734	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   509: invokevirtual 931	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   512: invokevirtual 936	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   515: astore_1
    //   516: new 1736	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody
    //   519: dup
    //   520: invokespecial 1737	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody:<init>	()V
    //   523: astore 19
    //   525: aload 19
    //   527: aload_1
    //   528: invokevirtual 1738	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   531: checkcast 1736	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody
    //   534: astore_1
    //   535: aload_1
    //   536: getfield 1741	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody:msg_not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   539: invokevirtual 1729	tencent/im/msg/im_msg_body$NotOnlineFile:has	()Z
    //   542: ifne +70 -> 612
    //   545: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   548: ifeq +299 -> 847
    //   551: ldc 11
    //   553: iconst_2
    //   554: ldc_w 1743
    //   557: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: iconst_1
    //   561: istore 6
    //   563: goto -429 -> 134
    //   566: astore_1
    //   567: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +13 -> 583
    //   573: ldc 11
    //   575: iconst_2
    //   576: ldc_w 1745
    //   579: aload_1
    //   580: invokestatic 1748	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   583: iconst_1
    //   584: istore 6
    //   586: goto -452 -> 134
    //   589: astore_1
    //   590: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   593: ifeq +13 -> 606
    //   596: ldc 11
    //   598: iconst_2
    //   599: ldc_w 1750
    //   602: aload_1
    //   603: invokestatic 1748	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   606: iconst_1
    //   607: istore 6
    //   609: goto -475 -> 134
    //   612: aload_1
    //   613: getfield 1741	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody:msg_not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   616: invokevirtual 1728	tencent/im/msg/im_msg_body$NotOnlineFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   619: checkcast 1727	tencent/im/msg/im_msg_body$NotOnlineFile
    //   622: astore_1
    //   623: goto -152 -> 471
    //   626: aload_1
    //   627: getfield 1753	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   630: invokevirtual 928	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   633: ifne +24 -> 657
    //   636: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq +208 -> 847
    //   642: ldc 11
    //   644: iconst_2
    //   645: ldc_w 1755
    //   648: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: iconst_1
    //   652: istore 6
    //   654: goto -520 -> 134
    //   657: aload_1
    //   658: getfield 1758	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   661: invokevirtual 549	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   664: istore 6
    //   666: aload_1
    //   667: getfield 1759	tencent/im/msg/im_msg_body$NotOnlineFile:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   670: invokevirtual 948	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   673: pop2
    //   674: aload_1
    //   675: getfield 1762	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_subcmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   678: invokevirtual 549	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   681: pop
    //   682: iload 5
    //   684: ifeq +15 -> 699
    //   687: iload 6
    //   689: iconst_1
    //   690: if_icmpne +9 -> 699
    //   693: iconst_1
    //   694: istore 6
    //   696: goto -562 -> 134
    //   699: aload_0
    //   700: iconst_0
    //   701: lload_3
    //   702: invokestatic 625	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   705: lload 10
    //   707: invokestatic 625	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   710: lload 12
    //   712: iload 9
    //   714: i2l
    //   715: lload 14
    //   717: invokevirtual 1764	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(ILjava/lang/String;Ljava/lang/String;JJJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   720: astore 19
    //   722: aload 19
    //   724: ifnull +34 -> 758
    //   727: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq +12 -> 742
    //   733: ldc 11
    //   735: iconst_2
    //   736: ldc_w 1618
    //   739: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   742: aload 16
    //   744: aload 19
    //   746: invokeinterface 676 2 0
    //   751: pop
    //   752: iconst_1
    //   753: istore 6
    //   755: goto -621 -> 134
    //   758: iconst_0
    //   759: istore 6
    //   761: aload_1
    //   762: getfield 1767	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_reserved	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   765: invokevirtual 548	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   768: ifeq +28 -> 796
    //   771: aload_1
    //   772: getfield 1767	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_reserved	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   775: invokevirtual 549	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   778: istore 8
    //   780: iload 8
    //   782: istore 6
    //   784: iload 8
    //   786: i2l
    //   787: lload 10
    //   789: lcmp
    //   790: ifne +6 -> 796
    //   793: iconst_0
    //   794: istore 6
    //   796: aload_0
    //   797: lload_3
    //   798: invokestatic 625	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   801: aload_1
    //   802: getfield 1770	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   805: invokevirtual 931	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   808: invokevirtual 1251	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   811: iload 6
    //   813: i2l
    //   814: iload 9
    //   816: i2l
    //   817: lload 14
    //   819: aload 16
    //   821: lload 10
    //   823: invokestatic 625	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   826: invokespecial 664	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(Ljava/lang/String;Ljava/lang/String;JJJLjava/util/List;Ljava/lang/String;)Z
    //   829: ifeq +9 -> 838
    //   832: iconst_1
    //   833: istore 6
    //   835: goto -701 -> 134
    //   838: iconst_0
    //   839: istore 6
    //   841: goto -707 -> 134
    //   844: aload 16
    //   846: areturn
    //   847: iconst_1
    //   848: istore 6
    //   850: goto -716 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	853	0	this	FileTransferHandler
    //   0	853	1	paramMessageHandler	MessageHandler
    //   0	853	2	paramList	List
    //   0	853	3	paramLong	long
    //   0	853	5	paramBoolean	boolean
    //   132	717	6	i1	int
    //   28	125	7	i2	int
    //   229	556	8	i3	int
    //   165	650	9	i4	int
    //   182	640	10	l1	long
    //   192	519	12	l2	long
    //   201	617	14	l3	long
    //   7	838	16	localArrayList1	ArrayList
    //   16	27	17	localArrayList2	ArrayList
    //   54	442	18	localMsg	msg_comm.Msg
    //   79	666	19	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   495	516	566	java/lang/Exception
    //   525	535	589	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a(int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardIntrlnal : uDstId[" + String.valueOf(paramFileManagerEntity.peerUin) + "]," + " uDstUin[" + String.valueOf(paramFileManagerEntity.selfUin) + " nDstSvcId[" + String.valueOf(paramInt) + " uFileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + " strFileName[" + String.valueOf(paramFileManagerEntity.fileName) + " strUuid[" + String.valueOf(paramFileManagerEntity.Uuid) + "]");
    }
    if ((paramFileManagerEntity.Uuid == null) || (paramFileManagerEntity.Uuid.length() < 1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "uuid or selfUin is null!!!");
      }
      return;
    }
    ToServiceMsg localToServiceMsg = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100");
    localToServiceMsg.extraData.putLong("Context", paramFileManagerEntity.nSessionId);
    Object localObject = new cmd0x346.ApplyCopyToReq();
    String str = paramFileManagerEntity.peerUin.replace("+", "");
    ((cmd0x346.ApplyCopyToReq)localObject).uint64_dst_id.set(Long.parseLong(str));
    if ((paramInt != 106) && (paramFileManagerEntity.selfUin != null) && (paramFileManagerEntity.selfUin.length() > 0))
    {
      str = paramFileManagerEntity.selfUin.replace("+", "");
      ((cmd0x346.ApplyCopyToReq)localObject).uint64_dst_uin.set(Long.parseLong(str));
    }
    ((cmd0x346.ApplyCopyToReq)localObject).uint32_dst_svcid.set(paramInt);
    str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().replace("+", "");
    ((cmd0x346.ApplyCopyToReq)localObject).uint64_src_uin.set(Long.parseLong(str));
    ((cmd0x346.ApplyCopyToReq)localObject).uint64_file_size.set(paramFileManagerEntity.fileSize);
    ((cmd0x346.ApplyCopyToReq)localObject).str_file_name.set(paramFileManagerEntity.fileName);
    ((cmd0x346.ApplyCopyToReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    paramFileManagerEntity = new cmd0x346.ReqBody();
    paramFileManagerEntity.msg_apply_copy_to_req.set((MessageMicro)localObject);
    paramFileManagerEntity.uint32_cmd.set(90100);
    localObject = paramFileManagerEntity.uint32_seq;
    paramInt = u;
    u = paramInt + 1;
    ((PBUInt32Field)localObject).set(paramInt);
    paramFileManagerEntity.uint32_business_id.set(3);
    paramFileManagerEntity.uint32_client_type.set(104);
    localToServiceMsg.putWupBuffer(paramFileManagerEntity.toByteArray());
    a(localToServiceMsg, true);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt2, String paramString3, OnlineFileSessionInfo paramOnlineFileSessionInfo, long paramLong2)
  {
    if (!a(paramOnlineFileSessionInfo)) {
      return;
    }
    switch (paramInt1)
    {
    case 130: 
    case 132: 
    default: 
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] handleOnLineFilePushMsg. error cmd:" + paramInt1);
      return;
    case 129: 
      QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] handle cmd 0x81. request");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramOnlineFileSessionInfo, paramLong2);
      return;
    case 131: 
      QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] handle cmd 0x83. accept");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long, 1);
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] handle cmd 0x85. cancel.type:" + paramOnlineFileSessionInfo.jdField_a_of_type_Short + " reason:" + paramOnlineFileSessionInfo.jdField_b_of_type_Short);
    if (2 == paramOnlineFileSessionInfo.jdField_a_of_type_Short)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long, 2);
      return;
    }
    if (1 == paramOnlineFileSessionInfo.jdField_a_of_type_Short)
    {
      if (57 == paramOnlineFileSessionInfo.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long, 5);
        return;
      }
      if (70 == paramOnlineFileSessionInfo.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long);
        return;
      }
      if (71 == paramOnlineFileSessionInfo.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long, 4);
        return;
      }
      if (5 == paramOnlineFileSessionInfo.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long, 2);
        return;
      }
      if (paramOnlineFileSessionInfo.jdField_b_of_type_Short == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long, 3);
        return;
      }
      if (58 == paramOnlineFileSessionInfo.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long);
        return;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] canceltype:1.unkonw reason:" + paramOnlineFileSessionInfo.jdField_b_of_type_Short);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] unknow canceltype:" + paramOnlineFileSessionInfo.jdField_a_of_type_Short);
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, String paramString2, FileTransferObserver paramFileTransferObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "getDiscFile : String[" + paramString2 + "], nDiscId[" + paramLong2 + "]");
    }
    paramString1 = a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramFileTransferObserver);
    paramString1.extraData.putLong("Context", paramLong1);
    paramFileTransferObserver = new cmd0x345.ReqBody.SubCmd0x3ReqBody();
    paramFileTransferObserver.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    paramFileTransferObserver.str_file_id.set(paramString2);
    paramFileTransferObserver.uint64_disscus_uin.set(paramLong2);
    paramFileTransferObserver.uint32_costom_id.set(0);
    paramString2 = new cmd0x345.ReqBody();
    paramString2.msg_subcmd_0x3_req_body.set(paramFileTransferObserver);
    paramString2.uint32_sub_cmd.set(3);
    paramString1.putWupBuffer(paramString2.toByteArray());
    a(paramString1, true);
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ToServiceMsg localToServiceMsg = a("GTalkFileAppSvr.CMD_DISCUSS_FILE");
    localToServiceMsg.extraData.putLong("Context", paramLong1);
    cmd0x345.ReqBody.SubCmd0x5ReqBody localSubCmd0x5ReqBody = new cmd0x345.ReqBody.SubCmd0x5ReqBody();
    localSubCmd0x5ReqBody.uint32_src_bus_id.set(106);
    localSubCmd0x5ReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom("/".getBytes()));
    localSubCmd0x5ReqBody.bytes_src_file_path.set(ByteStringMicro.copyFrom(paramString4.getBytes()));
    localSubCmd0x5ReqBody.uint32_dst_uin.set(Integer.parseInt(paramString1));
    localSubCmd0x5ReqBody.uint64_file_size.set(paramLong2);
    localSubCmd0x5ReqBody.uint32_from_uin.set(Integer.parseInt(paramString2));
    localSubCmd0x5ReqBody.str_file_name.set(paramString3);
    if ((paramString5 != null) && (paramString5.length() > 0)) {
      localSubCmd0x5ReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramString5.getBytes()));
    }
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x5_req_body.set(localSubCmd0x5ReqBody);
    paramString1.uint32_sub_cmd.set(6);
    localToServiceMsg.putWupBuffer(paramString1.toByteArray());
    a(localToServiceMsg, true);
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4, long paramLong3, long paramLong4, FileTransferObserver paramFileTransferObserver)
  {
    paramFileTransferObserver = a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramFileTransferObserver);
    cmd0x345.ReqBody.SubCmd0x2ReqBody localSubCmd0x2ReqBody = new cmd0x345.ReqBody.SubCmd0x2ReqBody();
    int i1 = (int)Long.parseLong(paramString1);
    localSubCmd0x2ReqBody.uint32_disscus_uin.set(i1);
    i1 = (int)Long.parseLong(paramString2);
    localSubCmd0x2ReqBody.uint32_sender_uin.set(i1);
    localSubCmd0x2ReqBody.str_file_name.set(paramString3);
    localSubCmd0x2ReqBody.uint64_file_size.set(paramLong2);
    localSubCmd0x2ReqBody.str_file_id.set(paramString4);
    paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
    localSubCmd0x2ReqBody.str_batch_id.set(paramString1);
    paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
    localSubCmd0x2ReqBody.str_batch_item_id.set(paramString1);
    localSubCmd0x2ReqBody.uint64_time.set(MessageCache.a());
    localSubCmd0x2ReqBody.uint32_busid.set(106);
    if ((paramLong4 == 0L) && (QLog.isDevelopLevel())) {
      throw new NullPointerException();
    }
    i1 = MessageUtils.a(paramLong4);
    localSubCmd0x2ReqBody.uint32_random.set(i1);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x2_req_body.set(localSubCmd0x2ReqBody);
    paramString1.uint32_sub_cmd.set(2);
    paramFileTransferObserver.putWupBuffer(paramString1.toByteArray());
    paramFileTransferObserver.extraData.putLong("Context", paramLong1);
    a(paramFileTransferObserver, true);
  }
  
  public void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, im_msg_body.NotOnlineFile paramNotOnlineFile, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    Object localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    localObject = null;
    if (paramMsg.msg_head.c2c_tmp_msg_head.has()) {
      localObject = MessageProtoCodec.a(paramMsg);
    }
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    short s1 = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    if (!paramNotOnlineFile.bytes_file_name.has()) {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not fileName");
      }
    }
    int i3;
    long l3;
    String str1;
    String str2;
    label418:
    do
    {
      do
      {
        do
        {
          return;
          paramMsg = FileManagerUtil.a(paramNotOnlineFile.bytes_file_name.get().toStringUtf8());
          i3 = paramNotOnlineFile.uint32_file_type.get();
          l3 = paramNotOnlineFile.uint64_file_size.get();
          i1 = paramNotOnlineFile.uint32_subcmd.get();
          str1 = HexUtil.a(paramNotOnlineFile.bytes_file_md5.get().toByteArray());
          str2 = String.valueOf(l4);
          str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (i3 != 1) {
            break label418;
          }
          if ((!paramBoolean1) && (!str2.equalsIgnoreCase(str3))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("FileTransferHandler<FileAssistant>", 2, "Recv a file receipt file name: " + paramMsg + "don't need to handle because isPullRoam[" + paramBoolean2 + "],senderuin[" + str2 + "]");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "Recv a file receipt file name: " + paramMsg + "type[" + i3 + "]. insert tips into aio");
        }
        paramMessageHandler = TransfileUtile.a(BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramMsg, 0, null), l3, 0, false, null);
        l4 = MessageRecordFactory.a(-2005).uniseq;
        a(paramList, paramString, str2, paramMsg, l3, paramBoolean1, 0, paramMessageHandler, s1, s1, "", i3, l4, l1, paramLong, l2, -3008);
        return;
        if (paramNotOnlineFile.bytes_file_uuid.has()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not uuid");
      return;
      str2 = paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8();
      String str3 = new String(paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8() + l2);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "offline file come, msgTime[" + l2 + "] msgSeq[" + s1 + "] msgUid[" + l1 + "]  fileName[" + paramMsg + "] uuid[" + str2 + "] fileType[" + i3 + "] subCmd[" + i1 + "]");
      }
      if ((!paramMessageHandler.a().a(str3)) || (paramBoolean2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileTransferHandler<FileAssistant>", 2, "isPullRoam[false] and local already recv.  fileName[" + paramMsg + "] uuid[" + str2 + "] fileType[" + i3 + "] subCmd[" + i1 + "]");
    return;
    int i1 = 0;
    if (paramNotOnlineFile.uint32_reserved.has())
    {
      int i2 = paramNotOnlineFile.uint32_reserved.get();
      i1 = i2;
      if (i2 == l4) {
        i1 = 0;
      }
    }
    if (i1 != 0)
    {
      paramNotOnlineFile = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, i1);
      if (paramNotOnlineFile != null)
      {
        paramNotOnlineFile.msgSeq = s1;
        paramNotOnlineFile.msgUid = l1;
        paramNotOnlineFile.msgTime = l2;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(paramNotOnlineFile);
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "online change to offline, update offline msg seq , uid and msgTime" + FileManagerUtil.a(paramNotOnlineFile));
        }
      }
    }
    if ((paramBoolean2) && (paramBoolean1))
    {
      paramNotOnlineFile = a(0, paramString, String.valueOf(l4), l2, s1, l1);
      if (paramNotOnlineFile != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
        }
        if (i3 == 1)
        {
          paramMessageHandler = MessageRecordFactory.a(-3008);
          paramMessageHandler.msgtype = -3008;
          paramMessageHandler.msg = paramNotOnlineFile.msg;
        }
        for (;;)
        {
          paramMessageHandler.uniseq = paramNotOnlineFile.uniseq;
          paramList.add(paramMessageHandler);
          return;
          paramMessageHandler = MessageRecordFactory.a(-2005);
          paramMessageHandler.msgtype = -2005;
          paramMessageHandler.msg = paramNotOnlineFile.msg;
          ((MessageForFile)paramMessageHandler).parse();
        }
      }
    }
    if (l3 == 0L) {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "<---decodeC2CMsgPkg_MsgType0x211:fileType[" + i3 + "], UUID[" + str2 + "], filename[" + paramMsg + "], fileSize[" + l3 + "]");
    }
    a(paramMessageHandler, paramList, paramString, String.valueOf(l4), l2, s1, paramBoolean1, paramBoolean2, i3, str2, paramMsg, l3, i1, paramLong, l1, str1, (TempSessionInfo)localObject);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardOfflineFile : PeerUin[" + FileManagerUtil.e(paramFileManagerEntity.peerUin) + "], FileUUID[" + paramFileManagerEntity.Uuid + "]");
    }
    ToServiceMsg localToServiceMsg = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700");
    localToServiceMsg.extraData.putLong("Context", paramFileManagerEntity.nSessionId);
    Object localObject2 = new cmd0x346.ApplyForwardFileReq();
    ((cmd0x346.ApplyForwardFileReq)localObject2).uint64_sender_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    Object localObject1 = paramFileManagerEntity.peerUin.replace("+", "");
    ((cmd0x346.ApplyForwardFileReq)localObject2).uint64_recver_uin.set(Long.parseLong((String)localObject1));
    ((cmd0x346.ApplyForwardFileReq)localObject2).bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    localObject1 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject1).msg_apply_forward_file_req.set((MessageMicro)localObject2);
    ((cmd0x346.ReqBody)localObject1).uint32_cmd.set(700);
    localObject2 = ((cmd0x346.ReqBody)localObject1).uint32_seq;
    int i1 = u;
    u = i1 + 1;
    ((PBUInt32Field)localObject2).set(i1);
    ((cmd0x346.ReqBody)localObject1).uint32_business_id.set(3);
    ((cmd0x346.ReqBody)localObject1).uint32_client_type.set(104);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      localObject2 = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject2).uint64_id.set(3L);
      ((cmd0x346.ExtensionReq)localObject2).uint64_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        ((cmd0x346.ExtensionReq)localObject2).bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
        ((cmd0x346.ExtensionReq)localObject2).str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
      }
      ((cmd0x346.ReqBody)localObject1).msg_extension_req.set((MessageMicro)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardOfflineFile : addtempinfo SessionType[" + paramFileManagerEntity.tmpSessionType + "], sessionId[" + paramFileManagerEntity.nSessionId + "]");
      }
    }
    localToServiceMsg.putWupBuffer(((cmd0x346.ReqBody)localObject1).toByteArray());
    a(localToServiceMsg, true);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("GTalkFileAppSvr.CMD_DISCUSS_FILE");
    localToServiceMsg.extraData.putLong("Context", paramFileManagerEntity.nSessionId);
    cmd0x345.ReqBody.SubCmd0x6ReqBody localSubCmd0x6ReqBody = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
    localSubCmd0x6ReqBody.uint32_dst_bus_id.set(paramInt);
    localSubCmd0x6ReqBody.uint64_file_size.set(paramFileManagerEntity.fileSize);
    localSubCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    if ((paramFileManagerEntity.strFileMd5 != null) && (paramFileManagerEntity.strFileMd5.length() > 0)) {
      localSubCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramFileManagerEntity.strFileMd5.getBytes()));
    }
    localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramFileManagerEntity.selfUin));
    String str = paramFileManagerEntity.peerUin.replace("+", "");
    localSubCmd0x6ReqBody.uint64_dst_uin.set(Long.parseLong(str));
    localSubCmd0x6ReqBody.str_file_name.set(paramFileManagerEntity.fileName);
    localSubCmd0x6ReqBody.str_src_file_path.set(paramFileManagerEntity.Uuid);
    localSubCmd0x6ReqBody.str_src_parent_folder.set("/");
    localSubCmd0x6ReqBody.uint32_client_type.set(103);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      if ((paramFileManagerEntity.tmpSessionRelatedUin != null) && (paramFileManagerEntity.tmpSessionRelatedUin.length() > 0)) {
        localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramFileManagerEntity.tmpSessionRelatedUin));
      }
      localSubCmd0x6ReqBody.uint64_app_id.set(3L);
      localSubCmd0x6ReqBody.uint64_talk_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        localSubCmd0x6ReqBody.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
        localSubCmd0x6ReqBody.str_dst_phone_number.set(paramFileManagerEntity.tmpSessionToPhone);
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardDiscFile : addtempinfo SessionType[" + paramFileManagerEntity.tmpSessionType + "], sessionId[" + paramFileManagerEntity.nSessionId + "]");
      }
    }
    for (;;)
    {
      paramFileManagerEntity = new cmd0x345.ReqBody();
      paramFileManagerEntity.msg_subcmd_0x6_req_body.set(localSubCmd0x6ReqBody);
      paramFileManagerEntity.uint32_sub_cmd.set(7);
      localToServiceMsg.putWupBuffer(paramFileManagerEntity.toByteArray());
      a(localToServiceMsg, true);
      return;
      localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramFileManagerEntity.selfUin));
    }
  }
  
  public final void a(ToServiceMsg arg1, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (???.extraData.containsKey(l))
    {
      long l1 = ???.extraData.getLong(l);
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        FileTransferObserver localFileTransferObserver = (FileTransferObserver)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(l1));
        if (localFileTransferObserver != null)
        {
          ??? = jdField_a_of_type_AndroidOsHandler.obtainMessage();
          ???.what = paramInt;
          ???.obj = new Object[] { localFileTransferObserver, Boolean.valueOf(paramBoolean), paramObject };
          ???.sendToTarget();
          QLog.i("FileTransferHandler<FileAssistant>", 1, "notifyUI. sendToTarget. seq=" + l1 + ".type=" + paramInt);
          return;
        }
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find observer. seq=" + l1 + ".type=" + paramInt);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find seq_key. type=" + paramInt);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileTransferHandler<FileAssistant>", 2, "handleResponse : req is null");
      }
      return;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      float f1 = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f1) + "sec.");
      }
    }
    if (paramToServiceMsg.getServiceCmd().equals("TransService.ReqOffFilePack"))
    {
      a(paramToServiceMsg, paramFromServiceMsg, (MessageFactoryReceiver.OffLineFileInfo)a(paramToServiceMsg, paramFromServiceMsg));
      return;
    }
    if (paramToServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500"))
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramToServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800"))
    {
      c(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramToServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200"))
    {
      d(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramToServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000"))
    {
      e(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramToServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100"))
    {
      f(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramToServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700"))
    {
      g(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramToServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100"))
    {
      h(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramToServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400"))
    {
      i(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramToServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900"))
    {
      j(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramToServiceMsg.getServiceCmd().equals("GTalkFileAppSvr.CMD_DISCUSS_FILE"))
    {
      l(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramToServiceMsg.getServiceCmd()))
    {
      int i2 = paramToServiceMsg.extraData.getInt("Sequence");
      if (paramFromServiceMsg.isSuccess()) {}
      for (int i1 = 0;; i1 = paramFromServiceMsg.getResultCode())
      {
        a(paramFromServiceMsg);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a().a(i2, i1, paramFromServiceMsg.getWupBuffer());
        return;
      }
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResponse : cmd " + paramToServiceMsg.getServiceCmd().hashCode() + "unknow");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, long paramLong)
  {
    boolean bool = true;
    long l2 = paramFromServiceMsg.getResultCode();
    if (l2 != 1002L)
    {
      l1 = l2;
      if (l2 != 1013L) {}
    }
    else
    {
      l1 = -100001L;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is timeout[" + paramFromServiceMsg + "]");
    }
    l2 = l1;
    if (l1 != 1000L)
    {
      l2 = -100002L;
      bool = false;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is failed[" + paramFromServiceMsg + "]");
    }
    if (l2 == -100001L) {}
    for (int i1 = 1;; i1 = 0)
    {
      int i2 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if ((i1 == 0) || (i2 >= 3)) {
        break;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i2 + 1);
      a(paramToServiceMsg, false);
      return;
    }
    long l1 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
    if (l1 != 0L) {}
    for (;;)
    {
      a(paramToServiceMsg, 5014, bool, new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Integer.valueOf(paramFromServiceMsg.getAppSeq()), Long.valueOf(paramLong) });
      return;
      l1 = l2;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      k(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramObject = (MessageFactoryReceiver.OffLineFileInfo)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "onReceive, MessageConstants.CMD_TRANSSERVICE_REQOFFFILEPACK: " + paramObject.jdField_b_of_type_Byte);
    }
    switch (paramObject.jdField_b_of_type_Byte)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 1: 
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 2: 
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 3: 
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramToServiceMsg);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), FileTransferServlet.class);
    localNewIntent.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    long l1 = System.currentTimeMillis();
    paramToServiceMsg.extraData.putLong("sendtimekey", l1);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "PreviewOfflineFile : FileUUID[" + paramString + "]");
    }
    ToServiceMsg localToServiceMsg = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100");
    Object localObject = new cmd0x346.ApplyDownloadAbsReq();
    ((cmd0x346.ApplyDownloadAbsReq)localObject).uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((cmd0x346.ApplyDownloadAbsReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    paramString = new cmd0x346.ReqBody();
    paramString.msg_apply_download_abs_req.set((MessageMicro)localObject);
    paramString.uint32_cmd.set(1100);
    localObject = paramString.uint32_seq;
    int i1 = u;
    u = i1 + 1;
    ((PBUInt32Field)localObject).set(i1);
    paramString.uint32_business_id.set(3);
    paramString.uint32_client_type.set(104);
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    a(localToServiceMsg, true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      long l1 = paramInt1;
      new Handler(localLooper).post(new fym(this, l1, paramInt3, paramInt2, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramInt1 + "] Handle upload progress notify. speed=" + paramInt3 + " progress =" + paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1, paramInt3, paramInt2);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      long l1 = paramInt1;
      new Handler(localLooper).post(new fyl(this, l1, paramInt2, paramString2, paramString1));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramInt1 + "] Handle upload failed notify. retCode =" + paramInt2 + "(1:cancel upload) reason=" + paramString2);
    if (1 == paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1);
      return;
    }
    if (2 == paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1);
      return;
    }
    if (3 == paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString1, paramInt1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "QueryFileInfo : FileUUID[" + paramString + "]");
    }
    ToServiceMsg localToServiceMsg = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400");
    localToServiceMsg.extraData.putLong("Context", paramLong);
    Object localObject = new cmd0x346.FileQueryReq();
    ((cmd0x346.FileQueryReq)localObject).uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((cmd0x346.FileQueryReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    paramString = new cmd0x346.ReqBody();
    paramString.msg_file_query_req.set((MessageMicro)localObject);
    paramString.uint32_cmd.set(1400);
    localObject = paramString.uint32_seq;
    int i1 = u;
    u = i1 + 1;
    ((PBUInt32Field)localObject).set(i1);
    paramString.uint32_business_id.set(3);
    paramString.uint32_client_type.set(104);
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    a(localToServiceMsg, true);
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, String paramString2, long paramLong2)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new fyn(this, paramLong1, paramString1, paramInt, paramString2, paramLong2));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "] upload competed:");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramLong1, paramInt, paramString2, paramLong2);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new fyj(this, paramLong, paramBoolean, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  handle recv onlinefile resp. sucess =" + paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "PreviewOfflineFile : FileUUID[" + paramString2 + "]");
    }
    ToServiceMsg localToServiceMsg = a("GTalkFileAppSvr.CMD_DISCUSS_FILE");
    cmd0x345.ReqBody.SubCmd0x7ReqBody localSubCmd0x7ReqBody = new cmd0x345.ReqBody.SubCmd0x7ReqBody();
    localSubCmd0x7ReqBody.uint64_disscus_uin.set(Long.parseLong(paramString1));
    localSubCmd0x7ReqBody.str_file_path.set(paramString2);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x7_req_body.set(localSubCmd0x7ReqBody);
    paramString1.uint32_sub_cmd.set(8);
    localToServiceMsg.putWupBuffer(paramString1.toByteArray());
    a(localToServiceMsg, true);
  }
  
  public void a(String paramString1, String paramString2, FileTransferObserver paramFileTransferObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "setDownloadSuccState : selfUin[" + FileManagerUtil.e(paramString1) + "], filePath[" + paramString2 + "]");
    }
    paramFileTransferObserver = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000", paramFileTransferObserver);
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(paramString1));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_download_succ_req.set(localDownloadSuccReq);
    paramString1.uint32_cmd.set(1000);
    paramString2 = paramString1.uint32_seq;
    int i1 = u;
    u = i1 + 1;
    paramString2.set(i1);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    paramFileTransferObserver.putWupBuffer(paramString1.toByteArray());
    a(paramFileTransferObserver, true);
  }
  
  public void a(String paramString1, String paramString2, BuddyTransfileProcessor.A9Message paramA9Message, long paramLong1, short paramShort, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "--->>getOffLineFile--toUin: " + paramString2 + " filePath: " + paramA9Message.jdField_a_of_type_JavaLangString + " delUin: " + paramLong2);
    }
    ToServiceMsg localToServiceMsg = a("TransService.ReqOffFilePack");
    localToServiceMsg.extraData.putString("selfuin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localToServiceMsg.extraData.putString("uin", paramString2);
    localToServiceMsg.extraData.putByteArray("filepath", paramA9Message.jdField_a_of_type_JavaLangString.getBytes());
    localToServiceMsg.extraData.putInt("offfile_type", 0);
    localToServiceMsg.extraData.putLong("msgTime", paramLong1);
    localToServiceMsg.extraData.putShort("msgSeq", paramShort);
    localToServiceMsg.extraData.putLong("delUin", paramLong2);
    localToServiceMsg.extraData.putByte("type", paramA9Message.jdField_a_of_type_Byte);
    localToServiceMsg.extraData.putInt("retryIndex", 0);
    localToServiceMsg.extraData.putString("friendUin", paramString1);
    localToServiceMsg.extraData.putBoolean("isRead", paramBoolean);
    c(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, FileTransferObserver paramFileTransferObserver)
  {
    paramFileTransferObserver = a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramFileTransferObserver);
    cmd0x345.ReqBody.SubCmd0x1ReqBody localSubCmd0x1ReqBody = new cmd0x345.ReqBody.SubCmd0x1ReqBody();
    localSubCmd0x1ReqBody.str_md5.set(paramString1);
    localSubCmd0x1ReqBody.str_sha.set(paramString2);
    localSubCmd0x1ReqBody.str_file_name.set(paramString3);
    localSubCmd0x1ReqBody.uint64_file_size.set(paramLong);
    localSubCmd0x1ReqBody.uint32_upload_type.set(1);
    paramLong = Long.parseLong(paramString4);
    localSubCmd0x1ReqBody.uint32_disscus_uin.set((int)paramLong);
    paramLong = Long.parseLong(paramString5);
    localSubCmd0x1ReqBody.uint32_sender_uin.set((int)paramLong);
    localSubCmd0x1ReqBody.uint32_costom_id.set(0);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x1_req_body.set(localSubCmd0x1ReqBody);
    paramString1.uint32_sub_cmd.set(1);
    paramFileTransferObserver.putWupBuffer(paramString1.toByteArray());
    a(paramFileTransferObserver, true);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, FileTransferObserver paramFileTransferObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "setUploadSuccState : selfUin[" + FileManagerUtil.e(paramString1) + "], toUin[" + FileManagerUtil.e(paramString2) + "], filePath[" + paramString3 + "]");
    }
    paramFileTransferObserver = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", paramFileTransferObserver);
    cmd0x346.UploadSuccReq localUploadSuccReq = new cmd0x346.UploadSuccReq();
    localUploadSuccReq.uint64_sender_uin.set(Long.parseLong(paramString1));
    paramString1 = paramString2.replace("+", "");
    localUploadSuccReq.uint64_recver_uin.set(Long.parseLong(paramString1));
    localUploadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_upload_succ_req.set(localUploadSuccReq);
    paramString1.uint32_cmd.set(800);
    paramString2 = paramString1.uint32_seq;
    int i1 = u;
    u = i1 + 1;
    paramString2.set(i1);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    paramFileTransferObserver.putWupBuffer(paramString1.toByteArray());
    a(paramFileTransferObserver, true);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "RemoveOfflineFile : PeerUin[" + FileManagerUtil.e(paramString1) + "], FileUUID[" + paramString2 + "], bSend[" + paramBoolean + "]");
    }
    ToServiceMsg localToServiceMsg = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900");
    localToServiceMsg.extraData.putString("Context", paramString2);
    if (paramBoolean) {
      i1 = 1;
    }
    Object localObject = new cmd0x346.DeleteFileReq();
    ((cmd0x346.DeleteFileReq)localObject).uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((cmd0x346.DeleteFileReq)localObject).uint64_peer_uin.set(Long.parseLong(paramString1));
    ((cmd0x346.DeleteFileReq)localObject).uint32_delete_type.set(i1);
    ((cmd0x346.DeleteFileReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_delete_file_req.set((MessageMicro)localObject);
    paramString1.uint32_cmd.set(900);
    localObject = paramString1.uint32_seq;
    i1 = u;
    u = i1 + 1;
    ((PBUInt32Field)localObject).set(i1);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    localToServiceMsg.putWupBuffer(paramString1.toByteArray());
    a(localToServiceMsg, true);
    FMDataCache.a(paramString2, paramString3);
  }
  
  public void a(String paramString, boolean paramBoolean, FileTransferObserver paramFileTransferObserver)
  {
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "getDownloadInfo : FileUUID[" + paramString + "], bSelfSend[" + paramBoolean + "]");
    }
    paramFileTransferObserver = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", paramFileTransferObserver);
    Object localObject = new cmd0x346.ApplyDownloadReq();
    ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    if (paramBoolean) {
      i1 = 1;
    }
    ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type.set(i1);
    paramString = new cmd0x346.ReqBody();
    paramString.msg_apply_download_req.set((MessageMicro)localObject);
    paramString.uint32_cmd.set(1200);
    localObject = paramString.uint32_seq;
    i1 = u;
    u = i1 + 1;
    ((PBUInt32Field)localObject).set(i1);
    paramString.uint32_business_id.set(3);
    paramString.uint32_client_type.set(104);
    paramFileTransferObserver.putWupBuffer(paramString.toByteArray());
    a(paramFileTransferObserver, true);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, FileTransferObserver paramFileTransferObserver, FileManagerEntity paramFileManagerEntity)
  {
    paramFileTransferObserver = a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500", paramFileTransferObserver);
    long l1 = 0L;
    if (paramFileTransferObserver.extraData.containsKey(l)) {
      l1 = paramFileTransferObserver.extraData.getLong(l);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "sendOfflineFile: toUin[" + FileManagerUtil.e(paramString) + "], filePath[" + paramArrayOfByte1 + "], filename[" + paramArrayOfByte2 + "], fileSize[" + paramLong + "], md5[" + paramArrayOfByte3 + "],requestSeq[" + u + "], oberservseq[" + l1 + "]");
    }
    paramFileTransferObserver.extraData.putByteArray("MD5", paramArrayOfByte3);
    cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
    localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    paramString = paramString.replace("+", "");
    localApplyUploadReq.uint64_recver_uin.set(Long.parseLong(paramString));
    localApplyUploadReq.uint32_file_type.set(3);
    localApplyUploadReq.uint64_file_size.set(paramLong);
    localApplyUploadReq.str_file_name.set(new String(paramArrayOfByte2));
    localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte3));
    localApplyUploadReq.str_local_filepath.set(new String(paramArrayOfByte1));
    paramString = new cmd0x346.ReqBody();
    paramString.msg_apply_upload_req.set(localApplyUploadReq);
    paramString.uint32_cmd.set(500);
    paramArrayOfByte1 = paramString.uint32_seq;
    int i1 = u;
    u = i1 + 1;
    paramArrayOfByte1.set(i1);
    paramString.uint32_business_id.set(3);
    paramString.uint32_client_type.set(104);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      paramArrayOfByte1 = new cmd0x346.ExtensionReq();
      paramArrayOfByte1.uint64_id.set(3L);
      paramArrayOfByte1.uint64_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        paramArrayOfByte1.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
        paramArrayOfByte1.str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
      }
      paramString.msg_extension_req.set(paramArrayOfByte1);
    }
    paramFileTransferObserver.putWupBuffer(paramString.toByteArray());
    a(paramFileTransferObserver, true);
  }
  
  public boolean a(OnlineFileSessionInfo paramOnlineFileSessionInfo)
  {
    if (paramOnlineFileSessionInfo != null)
    {
      if ((jdField_a_of_type_ArrayOfByte.equals(paramOnlineFileSessionInfo.jdField_a_of_type_ArrayOfByte)) || (!paramOnlineFileSessionInfo.jdField_b_of_type_Boolean)) {
        QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "]  is not surpport mulitendpoint");
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, FMTransC2CMsgInfo paramFMTransC2CMsgInfo)
  {
    paramFMTransC2CMsgInfo.subCmd = paramInt2;
    if (paramFMTransC2CMsgInfo.fileTransferObserver != null) {}
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramFMTransC2CMsgInfo.observerSeq = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_a_of_type_Long), paramFMTransC2CMsgInfo.fileTransferObserver);
      this.jdField_a_of_type_Long += 1L;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "send0x211c2cMsg transC2CMsgInfo:" + paramFMTransC2CMsgInfo.toString());
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, paramInt1, paramArrayOfByte, paramFMTransC2CMsgInfo);
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    OnlineFileSessionInfo localOnlineFileSessionInfo = new OnlineFileSessionInfo();
    localOnlineFileSessionInfo.jdField_a_of_type_ArrayOfByte = ((byte[])jdField_a_of_type_ArrayOfByte.clone());
    localOnlineFileSessionInfo.jdField_a_of_type_Short = 4;
    localOnlineFileSessionInfo.jdField_b_of_type_Long = paramLong;
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localOnlineFileSessionInfo);
    if (arrayOfByte == null)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + localOnlineFileSessionInfo.jdField_b_of_type_Long + "]. recvOnLineFile failed:");
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, paramLong, 133, arrayOfByte);
  }
  
  public boolean a(String paramString, FileManagerEntity paramFileManagerEntity, FileTransferObserver paramFileTransferObserver)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, 0, paramFileManagerEntity.uniseq);
    if (localObject1 != null)
    {
      paramFileManagerEntity.msgSeq = ((MessageRecord)localObject1).msgseq;
      paramFileManagerEntity.msgUid = ((MessageRecord)localObject1).msgUid;
    }
    localObject1 = new SubMsgType0x4.MsgBody();
    Object localObject2 = new im_msg_body.NotOnlineFile();
    ((im_msg_body.NotOnlineFile)localObject2).uint32_file_type.set(0);
    ((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    ((im_msg_body.NotOnlineFile)localObject2).uint64_file_size.set(paramFileManagerEntity.fileSize);
    ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.set(ByteStringMicro.copyFrom(paramFileManagerEntity.fileName.getBytes()));
    ((im_msg_body.NotOnlineFile)localObject2).uint32_subcmd.set(1);
    ((SubMsgType0x4.MsgBody)localObject1).msg_not_online_file.set((MessageMicro)localObject2);
    localObject1 = ((SubMsgType0x4.MsgBody)localObject1).toByteArray();
    localObject2 = new FMTransC2CMsgInfo();
    ((FMTransC2CMsgInfo)localObject2).busiType = 1028;
    ((FMTransC2CMsgInfo)localObject2).uuid = paramFileManagerEntity.Uuid;
    ((FMTransC2CMsgInfo)localObject2).uniseq = paramFileManagerEntity.uniseq;
    ((FMTransC2CMsgInfo)localObject2).fileTransferObserver = paramFileTransferObserver;
    ((FMTransC2CMsgInfo)localObject2).msgSeq = paramFileManagerEntity.msgSeq;
    ((FMTransC2CMsgInfo)localObject2).msgUid = paramFileManagerEntity.msgUid;
    ((FMTransC2CMsgInfo)localObject2).sessionId = paramFileManagerEntity.nSessionId;
    ((FMTransC2CMsgInfo)localObject2).entity = paramFileManagerEntity;
    return a(paramString, 529, 4, (byte[])localObject1, (FMTransC2CMsgInfo)localObject2);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    Object localObject = new SubMsgType0x4.MsgBody();
    im_msg_body.NotOnlineFile localNotOnlineFile = new im_msg_body.NotOnlineFile();
    localNotOnlineFile.uint32_file_type.set(1);
    localNotOnlineFile.bytes_file_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    localNotOnlineFile.uint64_file_size.set(paramLong1);
    localNotOnlineFile.bytes_file_name.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    localNotOnlineFile.uint32_subcmd.set(2);
    ((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.set(localNotOnlineFile);
    paramString2 = ((SubMsgType0x4.MsgBody)localObject).toByteArray();
    localObject = new FMTransC2CMsgInfo();
    ((FMTransC2CMsgInfo)localObject).busiType = 1029;
    ((FMTransC2CMsgInfo)localObject).uuid = paramString3;
    ((FMTransC2CMsgInfo)localObject).msgSeq = FileManagerUtil.a();
    ((FMTransC2CMsgInfo)localObject).msgUid = FileManagerUtil.b();
    return a(paramString1, 529, 4, paramString2, (FMTransC2CMsgInfo)localObject);
  }
  
  public byte[] a(OnlineFileSessionInfo paramOnlineFileSessionInfo)
  {
    if (paramOnlineFileSessionInfo == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[1024];
    PkgTools.a(arrayOfByte, 0, paramOnlineFileSessionInfo.jdField_a_of_type_ArrayOfByte, 16);
    PkgTools.a(arrayOfByte, 22, paramOnlineFileSessionInfo.jdField_b_of_type_Long);
    PkgTools.a(arrayOfByte, 28, paramOnlineFileSessionInfo.jdField_a_of_type_Short);
    PkgTools.a(arrayOfByte, 30, (short)1);
    arrayOfByte[32] = 1;
    PkgTools.a(arrayOfByte, 35, (short)11);
    arrayOfByte[37] = 15;
    PkgTools.a(arrayOfByte, 38, (short)1);
    arrayOfByte[40] = 1;
    arrayOfByte[41] = 16;
    PkgTools.a(arrayOfByte, 42, (short)4);
    PkgTools.a(arrayOfByte, 44, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramOnlineFileSessionInfo = new byte[48];
    PkgTools.a(paramOnlineFileSessionInfo, 0, arrayOfByte, 48);
    return paramOnlineFileSessionInfo;
  }
  
  public OnlineFileSessionInfo b(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    if ((paramArrayOfByte == null) || (i1 == 0))
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed context=null");
      return null;
    }
    OnlineFileSessionInfo localOnlineFileSessionInfo = new OnlineFileSessionInfo();
    int i2;
    int i3;
    if (i1 >= 16)
    {
      PkgTools.b(paramArrayOfByte, 0, localOnlineFileSessionInfo.jdField_a_of_type_ArrayOfByte, 16);
      if (i1 < 26) {
        break label166;
      }
      localOnlineFileSessionInfo.jdField_b_of_type_Long = PkgTools.a(paramArrayOfByte, 22);
      if (i1 < 30) {
        break label177;
      }
      localOnlineFileSessionInfo.jdField_a_of_type_Short = PkgTools.a(paramArrayOfByte, 28);
      if (i1 < 32) {
        break label188;
      }
      i2 = PkgTools.a(paramArrayOfByte, 30);
      if (i2 >= 2)
      {
        if (i1 < 34) {
          break label199;
        }
        localOnlineFileSessionInfo.jdField_b_of_type_Short = PkgTools.a(paramArrayOfByte, 32);
      }
      i3 = i2 + 32 + 2;
      if (i1 < i3 + 2) {
        break label210;
      }
      i2 = PkgTools.a(paramArrayOfByte, i3);
      if (i2 >= 4) {
        break label221;
      }
      localOnlineFileSessionInfo.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      return localOnlineFileSessionInfo;
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - bufAppGUID");
      return null;
      label166:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - dwSessionId");
      return null;
      label177:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wCancelType");
      return null;
      label188:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wReasonLen");
      return null;
      label199:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - bufReason");
      return null;
      label210:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wContextDataLen");
      return null;
      label221:
      byte[] arrayOfByte = new byte[i2];
      PkgTools.b(paramArrayOfByte, i3 + 2, arrayOfByte, i2);
      i1 = 0;
      label239:
      int i4;
      if (i1 < i2)
      {
        i3 = arrayOfByte[i1];
        i4 = i1 + 1;
        if (i2 <= i4 + 2) {
          break label303;
        }
        i1 = PkgTools.a(arrayOfByte, i4);
        i4 += 2;
        if (i3 != 15) {
          break label362;
        }
        if (i1 == 1) {
          break label315;
        }
        localOnlineFileSessionInfo.jdField_b_of_type_Boolean = false;
      }
      for (;;)
      {
        i1 = i4 + i1;
        break label239;
        break;
        label303:
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode Cancel or accept tlv error - L");
        break;
        label315:
        if (i2 >= i4 + i1)
        {
          paramArrayOfByte = new byte[i1];
          PkgTools.b(arrayOfByte, i4, paramArrayOfByte, i1);
          if (paramArrayOfByte[0] == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localOnlineFileSessionInfo.jdField_b_of_type_Boolean = bool;
            break;
          }
          label362:
          if (i3 == 4)
          {
            paramArrayOfByte = new byte[i1];
            if (i2 < i4 + i1) {
              break label420;
            }
            PkgTools.b(arrayOfByte, i4, paramArrayOfByte, i1);
            paramArrayOfByte = a(paramArrayOfByte);
            if (paramArrayOfByte == null) {
              break label432;
            }
            localOnlineFileSessionInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte.jdField_a_of_type_JavaLangString;
            localOnlineFileSessionInfo.jdField_a_of_type_Long = paramArrayOfByte.jdField_a_of_type_Long;
          }
        }
      }
      label420:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - V");
    }
    label432:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode fileinfo error for request or accept");
    return null;
  }
  
  public void b(int paramInt1, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt2, String paramString3, OnlineFileSessionInfo paramOnlineFileSessionInfo, long paramLong2)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new fyh(this, paramInt1, paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramOnlineFileSessionInfo, paramLong2));
      return;
    }
    a(paramInt1, paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramOnlineFileSessionInfo, paramLong2);
  }
  
  public void b(String paramString, long paramLong)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new fyi(this, paramLong, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  handle cmd 0x211-0x1.save to weiyun");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong, 4);
  }
  
  public void b(String paramString, long paramLong, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new fyk(this, paramLong, paramBoolean, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  handle query onlinefile upload progress resp. sucess =" + paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramLong, paramBoolean);
  }
  
  public boolean b(String paramString, long paramLong)
  {
    Object localObject = new SubMsgType0x5.MsgBody();
    ((SubMsgType0x5.MsgBody)localObject).uint32_sessionid.set((int)paramLong);
    localObject = ((SubMsgType0x5.MsgBody)localObject).toByteArray();
    FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
    localFMTransC2CMsgInfo.sessionId = paramLong;
    localFMTransC2CMsgInfo.busiType = 1025;
    localFMTransC2CMsgInfo.msgSeq = FileManagerUtil.a();
    localFMTransC2CMsgInfo.msgUid = FileManagerUtil.b();
    localFMTransC2CMsgInfo.entity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    return a(paramString, 529, 5, (byte[])localObject, localFMTransC2CMsgInfo);
  }
  
  public byte[] b(OnlineFileSessionInfo paramOnlineFileSessionInfo)
  {
    if (paramOnlineFileSessionInfo == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[1024];
    PkgTools.a(arrayOfByte, 0, paramOnlineFileSessionInfo.jdField_a_of_type_ArrayOfByte, 16);
    PkgTools.a(arrayOfByte, 22, paramOnlineFileSessionInfo.jdField_b_of_type_Long);
    PkgTools.a(arrayOfByte, 26, (short)112);
    PkgTools.a(arrayOfByte, 28, (short)0);
    paramOnlineFileSessionInfo = new byte[30];
    PkgTools.a(paramOnlineFileSessionInfo, 0, arrayOfByte, 30);
    return paramOnlineFileSessionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler
 * JD-Core Version:    0.7.0.1
 */