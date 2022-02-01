import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.10;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.11;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.12;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.3;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.4;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.6;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.7;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.8;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.9;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x1ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x2ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x3ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x5ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x7ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0xaReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x1RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x2RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x3RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x5RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x7RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0xaRspBody;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadAbsReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadAbsRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346.RecallFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.RecallFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.RecvListQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.RecvListQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.SendListQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.SendListQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccRsp;
import tencent.im.cs.face2face_file.face2face_file.msg;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.msg.resv21.hummer_resv_21.FileApkInfo;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x5.SubMsgType0x5.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;

public class agib
{
  private static final String SEQ_KEY = agie.class.getName();
  private static int cRe;
  public static final byte[] dG = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 101 };
  private static Handler handler = new agic(Looper.getMainLooper());
  private anbd jdField_a_of_type_Anbd = new anbd();
  private anbe jdField_a_of_type_Anbe = new anbe();
  aocq jdField_a_of_type_Aocq = null;
  public final QQAppInterface app;
  private DecimalFormat decimalFormat = new DecimalFormat("0.00");
  private Map<Long, agie> ky = new HashMap();
  private long observerSeq;
  
  public agib(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void P(ToServiceMsg paramToServiceMsg)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    int i = cRe;
    cRe = i + 1;
    localUniPacket.setRequestId(i);
    this.jdField_a_of_type_Anbe.n(paramToServiceMsg, localUniPacket);
    paramToServiceMsg.putWupBuffer(localUniPacket.encode());
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, im_msg_body.GroupFile paramGroupFile, int paramInt1, int paramInt2)
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
      long l;
      try
      {
        localObject2 = new String(paramGroupFile.bytes_filename.get().toByteArray(), "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        Object localObject2;
        localUnsupportedEncodingException1.printStackTrace();
        QLog.e("FileTransferHandler<FileAssistant>", 1, "internalDiscOfflineFile: Exception is " + localUnsupportedEncodingException1.toString());
        continue;
        paramGroupFile = this.app.getCurrentAccountUin();
        FileManagerEntity localFileManagerEntity = this.app.a().b(paramLong1, str1, 3000);
        localFileManagerEntity.setCloudType(1);
        localFileManagerEntity.fileName = ((String)localObject1);
        localFileManagerEntity.fileSize = l;
        localFileManagerEntity.nOpType = 1;
        localFileManagerEntity.peerNick = ahav.a(this.app, str1, str2, 3000);
        localFileManagerEntity.peerType = 3000;
        localFileManagerEntity.peerUin = str1;
        localFileManagerEntity.selfUin = str2;
        localFileManagerEntity.srvTime = (1000L * paramLong6);
        localFileManagerEntity.status = -1;
        if (localUnsupportedEncodingException1 != null) {
          localFileManagerEntity.Uuid = new String(localUnsupportedEncodingException1);
        }
        localFileManagerEntity.isReaded = false;
        localFileManagerEntity.bSend = false;
        localFileManagerEntity.msgSeq = paramLong4;
        localFileManagerEntity.msgUid = 0L;
        localFileManagerEntity.imgHeight = paramInt2;
        localFileManagerEntity.imgWidth = paramInt1;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "=_=k recv DiscFile Id[" + localFileManagerEntity.nSessionId + "],File[" + (String)localObject1 + "]");
        ahav.getFileType((String)localObject1);
        if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0)) {
          localFileManagerEntity.nWeiYunSrcType = -2;
        }
        ahav.a(this.app, localFileManagerEntity);
        if (paramGroupFile.equals(String.valueOf(paramLong3)))
        {
          this.app.a().d(str2, 3000, paramLong1);
          localFileManagerEntity.nOpType = 7;
          localFileManagerEntity.peerNick = this.app.getApplication().getString(2131693798);
          localFileManagerEntity.bSend = true;
          localFileManagerEntity.isReaded = true;
          localFileManagerEntity.bOnceSuccess = true;
        }
        this.app.a().s(localFileManagerEntity);
        ahav.a(localFileManagerEntity, this.app, null);
        if (QLog.isColorLevel()) {
          QLog.i("FileTransferHandler<FileAssistant>", 2, "File Coming:" + ahav.d(localFileManagerEntity));
        }
        ahav.j(this.app, String.valueOf(paramLong3), str1, 3000);
        this.app.a().a(paramLong1, localFileManagerEntity.nSessionId, str1, 3000, 17, null, 0, null);
        return paramLong1;
      }
      try
      {
        localObject1 = ahav.getFileName((String)localObject2);
        if (!paramGroupFile.uint64_file_size.has()) {
          break label725;
        }
        l = paramGroupFile.uint64_file_size.get();
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        localObject1 = localUnsupportedEncodingException1;
        Object localObject3 = localUnsupportedEncodingException2;
        continue;
        localObject3 = null;
        continue;
        label725:
        l = 0L;
        continue;
      }
      if (paramGroupFile.bytes_file_id.has())
      {
        localObject2 = paramGroupFile.bytes_file_id.get().toByteArray();
        if (paramGroupFile.bytes_batch_id.has()) {
          paramGroupFile.bytes_batch_id.get().toByteArray();
        }
        if (paramGroupFile.bytes_mark.has()) {
          paramGroupFile.bytes_mark.get().toByteArray();
        }
        paramLong5 = this.app.a().a(3000, paramLong4, paramLong6, paramLong2, paramLong5);
        if (paramLong5 > 0L)
        {
          paramGroupFile = this.app.a().a(paramLong5, String.valueOf(paramLong2), 3000);
          if (paramGroupFile != null)
          {
            paramGroupFile.status = 1;
            paramGroupFile.fProgress = 1.0F;
          }
          return paramLong5;
        }
      }
      localObject1 = null;
    }
  }
  
  private agib.c a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    int i = paramArrayOfByte.length;
    agib.c localc = new agib.c(null);
    int j;
    byte[] arrayOfByte;
    if (i >= 16)
    {
      j = aqoj.b(paramArrayOfByte, 0);
      arrayOfByte = new byte[j];
      if (i < j + 2) {
        break label181;
      }
      aqoj.c(paramArrayOfByte, 2, arrayOfByte, j);
      j += 2;
    }
    try
    {
      localc.name = new String(arrayOfByte, "UTF-16LE");
      if (i >= j + 4)
      {
        long l = aqoj.getLongData(paramArrayOfByte, j);
        int k = j + 4;
        if (i < k + 2) {
          break label243;
        }
        j = aqoj.b(paramArrayOfByte, k);
        k += 2;
        arrayOfByte = new byte[j];
        if (i < k + j) {
          break label254;
        }
        aqoj.c(paramArrayOfByte, k, arrayOfByte, j);
        j = k + j;
        if (i < j + 4) {
          break label265;
        }
        localc.size = ((aqoj.getLongData(paramArrayOfByte, j) << 32) + l);
        return localc;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filenamelen");
        return null;
        label181:
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filenamebuf");
        return null;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo: Exception is " + localUnsupportedEncodingException.toString());
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filelenlo");
      return null;
    }
    label243:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- otherlen");
    return null;
    label254:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- bufotherinfo");
    return null;
    label265:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filelenhi");
    return null;
  }
  
  private agzs a(agzw paramagzw)
  {
    agzs localagzs = new agzs();
    long l = Long.parseLong(this.app.getCurrentAccountUin());
    if (paramagzw.cYU == 1700)
    {
      localagzs.jdField_a_of_type_Agzr = new agzr();
      paramagzw.bJz = paramagzw.bJz.replace("+", "");
      localagzs.jdField_a_of_type_Agzr.uint64_sender_uin = l;
      localagzs.jdField_a_of_type_Agzr.uint64_recver_uin = Long.parseLong(paramagzw.bJz);
      localagzs.jdField_a_of_type_Agzr.uint64_file_size = paramagzw.fileSize;
      localagzs.jdField_a_of_type_Agzr.str_file_name = new String(paramagzw.ej);
      localagzs.jdField_a_of_type_Agzr.str_local_filepath = new String(paramagzw.ei);
      localagzs.jdField_a_of_type_Agzr.bytes_10m_md5 = paramagzw.md5;
      localagzs.jdField_a_of_type_Agzr.bytes_sha = paramagzw.sha1;
      localagzs.jdField_a_of_type_Agzr.eh = paramagzw.ek;
      localagzs.jdField_a_of_type_Agzr.bytes_3sha = paramagzw.el;
    }
    while (paramagzw.cYU != 1600) {
      return localagzs;
    }
    localagzs.jdField_a_of_type_Agzq = new agzq();
    paramagzw.bJz = paramagzw.bJz.replace("+", "");
    localagzs.jdField_a_of_type_Agzq.uint64_sender_uin = l;
    localagzs.jdField_a_of_type_Agzq.uint64_recver_uin = Long.parseLong(paramagzw.bJz);
    localagzs.jdField_a_of_type_Agzq.uint64_file_size = paramagzw.fileSize;
    localagzs.jdField_a_of_type_Agzq.str_file_name = new String(paramagzw.ej);
    localagzs.jdField_a_of_type_Agzq.str_local_filepath = new String(paramagzw.ei);
    localagzs.jdField_a_of_type_Agzq.bytes_10m_md5 = paramagzw.md5;
    localagzs.jdField_a_of_type_Agzq.bytes_3sha = paramagzw.el;
    return localagzs;
  }
  
  private FileManagerEntity a(MessageHandler paramMessageHandler, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    long l = paramInt2;
    boolean bool1 = false;
    boolean bool2 = false;
    paramLong3 = 0L;
    if (0L != l)
    {
      paramMessageHandler = this.app.a().a(paramString1, l);
      if (paramMessageHandler != null)
      {
        paramLong3 = paramMessageHandler.nSessionId;
        bool1 = true;
        if (!this.app.a().r(paramString1, l))
        {
          paramMessageHandler.Uuid = paramString3;
          if (!paramString4.isEmpty())
          {
            paramMessageHandler.fileIdCrc = paramString4;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. fileIdCrc: " + paramString4);
          }
          ahav.a(this.app, paramMessageHandler);
          ahav.a(paramMessageHandler, this.app, null);
          if ((paramBoolean2) && (paramBoolean1))
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. name: " + paramString5 + ". is  roma and readed, think okt!!");
            a(paramString1, l, paramInt1, paramString3, paramLong1);
          }
          for (;;)
          {
            paramMessageHandler = this.app.b().b(paramString1, 0, paramMessageHandler.uniseq);
            if (paramMessageHandler != null)
            {
              if ((paramMessageHandler instanceof MessageForFile))
              {
                paramString2 = (MessageForFile)paramMessageHandler;
                paramString2.originalmsgShseq = paramMessageHandler.shmsgseq;
                paramString2.originalMsgUid = paramMessageHandler.msgUid;
                paramString2.originalTime = paramMessageHandler.time;
              }
              paramMessageHandler.shmsgseq = paramShort;
              paramMessageHandler.time = paramLong1;
              paramMessageHandler.msgUid = paramLong4;
              this.app.b().a(paramInt1).a(paramString1, paramInt1, paramMessageHandler, 3);
            }
            return null;
            a(paramString1, l, paramInt1, paramString3, paramLong1);
          }
        }
        bool2 = true;
        this.app.a().ju(paramLong3);
        QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. name: " + paramString5 + ". user had delete about onlinefile record!!! ");
      }
      paramLong1 = paramLong3;
    }
    for (paramBoolean1 = bool1;; paramBoolean1 = false)
    {
      aoon.a(aojs.a(this.app.getAccount(), paramString5, 0, null), paramLong2, 0, false, null);
      paramLong2 = anbi.d(-2005).uniseq;
      this.app.getCurrentAccountUin();
      if (0L == l) {
        break label590;
      }
      this.app.a().ju(paramLong1);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "Recv a offline file name: " + paramString5 + ". and it is : online changto offline. OLfilesession=" + l + "isPullRoam =" + paramBoolean2);
      }
      if (paramBoolean2) {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. name: " + paramString5 + ". isPullRoam hadHasOlSessionRecord=" + paramBoolean1 + " isDelOlSessionRecord=" + bool2);
      }
      if ((0L == paramLong1) || (this.app.a().cb(paramLong1))) {
        break;
      }
      return this.app.a().a(paramLong1, paramLong2, paramString1, 0);
      paramLong1 = 0L;
      bool2 = true;
    }
    return this.app.a().b(paramLong2, paramString1, 0);
    label590:
    return this.app.a().b(paramLong2, paramString1, 0);
  }
  
  private List<String> a(agib.b paramb, List<String> paramList, cmd0x346.ApplyUploadRspV2 paramApplyUploadRspV2)
  {
    if (paramApplyUploadRspV2.int32_ret_code.has()) {
      paramb.retCode = paramApplyUploadRspV2.int32_ret_code.get();
    }
    if (paramApplyUploadRspV2.str_ret_msg.has()) {
      paramb.retMsg = paramApplyUploadRspV2.str_ret_msg.get();
    }
    if (paramApplyUploadRspV2.uint64_total_space.has()) {
      paramb.totalSpace = paramApplyUploadRspV2.uint64_total_space.get();
    }
    if (paramApplyUploadRspV2.uint64_used_space.has()) {
      paramb.usedSpace = paramApplyUploadRspV2.uint64_used_space.get();
    }
    if (paramApplyUploadRspV2.uint64_uploaded_size.has()) {
      paramb.fileSize = paramApplyUploadRspV2.uint64_uploaded_size.get();
    }
    if (paramApplyUploadRspV2.str_upload_ip.has()) {
      paramb.strIP = paramApplyUploadRspV2.str_upload_ip.get();
    }
    for (;;)
    {
      if (paramApplyUploadRspV2.uint32_upload_port.has()) {
        paramb.ag = ((short)paramApplyUploadRspV2.uint32_upload_port.get());
      }
      if (paramApplyUploadRspV2.bytes_uuid.has()) {
        paramb.uuid = paramApplyUploadRspV2.bytes_uuid.get().toByteArray();
      }
      if (paramApplyUploadRspV2.bytes_upload_key.has()) {
        paramb.key = paramApplyUploadRspV2.bytes_upload_key.get().toByteArray();
      }
      if (paramApplyUploadRspV2.bool_file_exist.has()) {
        paramb.fileExist = paramApplyUploadRspV2.bool_file_exist.get();
      }
      if (paramApplyUploadRspV2.uint32_upload_port.has()) {
        paramb.packetSize = paramApplyUploadRspV2.uint32_pack_size.get();
      }
      if (paramApplyUploadRspV2.uint32_httpsvr_api_ver.has()) {
        paramb.cXe = paramApplyUploadRspV2.uint32_httpsvr_api_ver.get();
      }
      if (paramApplyUploadRspV2.bytes_sha.has()) {
        paramb.sha = paramApplyUploadRspV2.bytes_sha.get().toByteArray();
      }
      Object localObject = paramList;
      if (paramApplyUploadRspV2.rpt_str_uploadip_list.has())
      {
        localObject = paramList;
        if (paramApplyUploadRspV2.rpt_str_uploadip_list.get().size() > 0) {
          localObject = paramApplyUploadRspV2.rpt_str_uploadip_list.get();
        }
      }
      if (paramApplyUploadRspV2.str_upload_https_domain.has()) {
        paramb.bHe = paramApplyUploadRspV2.str_upload_https_domain.get();
      }
      if (paramApplyUploadRspV2.uint32_upload_https_port.has()) {
        paramb.ah = ((short)paramApplyUploadRspV2.uint32_upload_https_port.get());
      }
      if (paramApplyUploadRspV2.str_upload_dns.has()) {
        paramb.bHg = paramApplyUploadRspV2.str_upload_dns.get();
      }
      if (paramApplyUploadRspV2.str_upload_lanip.has()) {
        paramb.bHh = paramApplyUploadRspV2.str_upload_lanip.get();
      }
      return localObject;
      if (paramApplyUploadRspV2.str_upload_domain.has()) {
        paramb.strIP = paramApplyUploadRspV2.str_upload_domain.get();
      } else {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse has neither ip nor domain");
      }
    }
  }
  
  private List<String> a(agib.b paramb, List<String> paramList, cmd0x346.ApplyUploadRspV3 paramApplyUploadRspV3)
  {
    if (paramApplyUploadRspV3.int32_ret_code.has()) {
      paramb.retCode = paramApplyUploadRspV3.int32_ret_code.get();
    }
    if (paramApplyUploadRspV3.str_ret_msg.has()) {
      paramb.retMsg = paramApplyUploadRspV3.str_ret_msg.get();
    }
    if (paramApplyUploadRspV3.uint64_total_space.has()) {
      paramb.totalSpace = paramApplyUploadRspV3.uint64_total_space.get();
    }
    if (paramApplyUploadRspV3.uint64_used_space.has()) {
      paramb.usedSpace = paramApplyUploadRspV3.uint64_used_space.get();
    }
    if (paramApplyUploadRspV3.uint64_uploaded_size.has()) {
      paramb.fileSize = paramApplyUploadRspV3.uint64_uploaded_size.get();
    }
    if (paramApplyUploadRspV3.str_upload_ip.has())
    {
      paramb.strIP = paramApplyUploadRspV3.str_upload_ip.get();
      if (paramApplyUploadRspV3.uint32_upload_port.has()) {
        paramb.ag = ((short)paramApplyUploadRspV3.uint32_upload_port.get());
      }
      if (paramApplyUploadRspV3.bytes_uuid.has()) {
        paramb.uuid = paramApplyUploadRspV3.bytes_uuid.get().toByteArray();
      }
      if (paramApplyUploadRspV3.bytes_upload_key.has()) {
        paramb.key = paramApplyUploadRspV3.bytes_upload_key.get().toByteArray();
      }
      if (paramApplyUploadRspV3.bool_file_exist.has()) {
        paramb.fileExist = paramApplyUploadRspV3.bool_file_exist.get();
      }
      if (paramb.bUseMediaPlatform)
      {
        if (!paramb.fileExist) {
          break label437;
        }
        if (paramApplyUploadRspV3.str_fileidcrc.has()) {
          paramb.bHi = paramApplyUploadRspV3.str_fileidcrc.get();
        }
      }
    }
    for (;;)
    {
      if (paramApplyUploadRspV3.uint32_upload_port.has()) {
        paramb.packetSize = paramApplyUploadRspV3.uint32_pack_size.get();
      }
      Object localObject = paramList;
      if (paramApplyUploadRspV3.rpt_str_uploadip_list.has())
      {
        localObject = paramList;
        if (paramApplyUploadRspV3.rpt_str_uploadip_list.get().size() > 0) {
          localObject = paramApplyUploadRspV3.rpt_str_uploadip_list.get();
        }
      }
      if (paramApplyUploadRspV3.str_upload_https_domain.has()) {
        paramb.bHe = paramApplyUploadRspV3.str_upload_https_domain.get();
      }
      if (paramApplyUploadRspV3.uint32_upload_https_port.has()) {
        paramb.ah = ((short)paramApplyUploadRspV3.uint32_upload_https_port.get());
      }
      if (paramApplyUploadRspV3.str_upload_dns.has()) {
        paramb.bHg = paramApplyUploadRspV3.str_upload_dns.get();
      }
      if (paramApplyUploadRspV3.str_upload_lanip.has()) {
        paramb.bHh = paramApplyUploadRspV3.str_upload_lanip.get();
      }
      return localObject;
      if (paramApplyUploadRspV3.str_upload_domain.has())
      {
        paramb.strIP = paramApplyUploadRspV3.str_upload_domain.get();
        break;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse has neither ip nor domain");
      break;
      label437:
      if (paramApplyUploadRspV3.bytes_media_plateform_upload_key.has()) {
        paramb.dJ = paramApplyUploadRspV3.bytes_media_plateform_upload_key.get().toByteArray();
      } else {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponseV3: bUseMediaPlatform but has not bytes_media_plateform_upload_key");
      }
    }
  }
  
  private void a(long paramLong, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramLong != -5L) && (paramLong != -6L)) {}
    MessageHandler localMessageHandler;
    do
    {
      return;
      localMessageHandler = (MessageHandler)this.app.getBusinessHandler(0);
    } while (localMessageHandler == null);
    localMessageHandler.f(3008, false, new Object[] { paramFileManagerEntity.peerUin, Integer.valueOf(3000), Integer.valueOf(103) });
  }
  
  private void a(long paramLong, boolean paramBoolean, int paramInt, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    switch (paramFileManagerEntity.nOpType)
    {
    default: 
      return;
    case 7: 
    case 28: 
      if ((TextUtils.isEmpty(paramString2)) && (QLog.isColorLevel())) {
        QLog.w("FileTransferHandler<FileAssistant>", 2, "forward offline to weiyun ,but weiyun fileid is null! retCode[" + String.valueOf(paramInt) + "retMsg[" + String.valueOf(paramString1) + "]");
      }
      if (paramBoolean) {}
      for (paramFileManagerEntity.status = 1;; paramFileManagerEntity.status = 0)
      {
        if (paramBoolean)
        {
          paramFileManagerEntity.Uuid = paramString2;
          paramFileManagerEntity.setCloudType(1);
          paramFileManagerEntity.peerType = 3000;
          a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, this.app.getCurrentAccountUin(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramString2, paramFileManagerEntity.uniseq, paramFileManagerEntity.msgUid, null);
        }
        if ((paramInt == -6101) || (paramInt == -7003))
        {
          paramFileManagerEntity.status = 16;
          if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
          {
            localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
            ((FileManagerEntity)localObject).status = 16;
            this.app.a().u((FileManagerEntity)localObject);
            paramFileManagerEntity.mContext = null;
          }
          this.app.a().u(paramFileManagerEntity);
        }
        this.app.a().b(paramBoolean, 19, new Object[] { Integer.valueOf(paramInt), paramString1, Long.valueOf(0L), Long.valueOf(0L), paramString2, Long.valueOf(paramLong) });
        return;
      }
    case 4: 
      if (((paramString2 == null) || (paramString2.length() < 1)) && (QLog.isColorLevel())) {
        QLog.w("FileTransferHandler<FileAssistant>", 2, "forward offline to weiyun ,but weiyun fileid is null! retCode[" + String.valueOf(paramInt) + "retMsg[" + String.valueOf(paramString1) + "]");
      }
      if (paramBoolean)
      {
        paramFileManagerEntity.status = 1;
        paramFileManagerEntity.setCloudType(2);
        if ((paramInt == -6101) || (paramInt == -7003))
        {
          paramFileManagerEntity.status = 16;
          if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
          {
            localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
            ((FileManagerEntity)localObject).status = 16;
            this.app.a().u((FileManagerEntity)localObject);
            paramFileManagerEntity.mContext = null;
          }
          this.app.a().u(paramFileManagerEntity);
        }
        localObject = e(paramString2);
        if (localObject == null) {
          break label649;
        }
        paramFileManagerEntity.WeiYunDirKey = ((String)((Pair)localObject).first);
      }
      for (paramFileManagerEntity.WeiYunFileId = ((String)((Pair)localObject).second);; paramFileManagerEntity.WeiYunFileId = paramString2)
      {
        this.app.a().u(paramFileManagerEntity);
        this.app.a().b(paramBoolean, 34, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(paramLong) });
        return;
        paramFileManagerEntity.status = 0;
        break;
      }
    case 26: 
    case 27: 
    case 32: 
      try
      {
        label649:
        ((ahbm)paramFileManagerEntity.mContext).a(paramBoolean, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, paramInt, paramString1, String.valueOf(paramFileManagerEntity.peerUin), paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: Exception is " + paramString1.toString());
        return;
      }
    }
    try
    {
      ((ahbm)paramFileManagerEntity.mContext).b(paramBoolean, paramFileManagerEntity.datalineEntitySessionId, paramInt, paramString1, null, null, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: Exception is " + paramString1.toString());
    }
  }
  
  private void a(agib.a parama, cmd0x346.ApplyDownloadRsp paramApplyDownloadRsp, boolean paramBoolean)
  {
    if (parama == null) {
      break label4;
    }
    label4:
    while (paramApplyDownloadRsp == null) {
      return;
    }
    if (paramApplyDownloadRsp.int32_ret_code.has()) {
      parama.retCode = paramApplyDownloadRsp.int32_ret_code.get();
    }
    if (paramApplyDownloadRsp.str_ret_msg.has()) {
      parama.retMsg = paramApplyDownloadRsp.str_ret_msg.get();
    }
    cmd0x346.DownloadInfo localDownloadInfo;
    if (paramApplyDownloadRsp.msg_download_info.has())
    {
      localDownloadInfo = (cmd0x346.DownloadInfo)paramApplyDownloadRsp.msg_download_info.get();
      if (localDownloadInfo.bytes_download_key.has()) {
        parama.c = localDownloadInfo.bytes_download_key.get();
      }
      if (!localDownloadInfo.str_download_ip.has()) {
        break label509;
      }
      parama.strIP = localDownloadInfo.str_download_ip.get();
      label120:
      if (localDownloadInfo.uint32_port.has()) {
        parama.ag = ((short)localDownloadInfo.uint32_port.get());
      }
      if (!paramBoolean) {
        break label547;
      }
      if (localDownloadInfo.bytes_media_platform_download_key.has())
      {
        parama.c = localDownloadInfo.bytes_media_platform_download_key.get();
        String str = aqhs.bytes2HexStr(parama.c.toByteArray());
        parama.strUrl = String.format("/asn.com/qqdownloadftnv5?ver=0&filetype=4001&openid=%s&&rkey=%s&&isthumb=0", new Object[] { this.app.getAccount(), str });
      }
    }
    for (;;)
    {
      if (localDownloadInfo.str_cookie.has()) {
        parama.strCookie = ("FTN5K=" + localDownloadInfo.str_cookie.get());
      }
      if ((localDownloadInfo.rpt_str_downloadip_list.has()) && (localDownloadInfo.rpt_str_downloadip_list.get().size() > 0)) {
        parama.AV = localDownloadInfo.rpt_str_downloadip_list.get();
      }
      if (localDownloadInfo.str_https_download_domain.has()) {
        parama.bHe = localDownloadInfo.str_https_download_domain.get();
      }
      if (localDownloadInfo.uint32_https_port.has()) {
        parama.ah = ((short)localDownloadInfo.uint32_https_port.get());
      }
      if (localDownloadInfo.str_download_dns.has()) {
        parama.bHf = localDownloadInfo.str_download_dns.get();
      }
      if (!paramApplyDownloadRsp.msg_file_info.has()) {
        break;
      }
      paramApplyDownloadRsp = (cmd0x346.FileInfo)paramApplyDownloadRsp.msg_file_info.get();
      if (paramApplyDownloadRsp.str_file_name.has())
      {
        parama.strFileName = paramApplyDownloadRsp.str_file_name.get();
        parama.strFileName = ahav.getFileName(parama.strFileName);
      }
      parama.strMd5 = agoy.t(paramApplyDownloadRsp.bytes_10m_md5.get().toByteArray());
      QLog.i("FileTransferHandler<FileAssistant>", 1, "file md5:" + parama.strMd5);
      parama.bHd = agoy.t(paramApplyDownloadRsp.bytes_sha.get().toByteArray());
      QLog.i("FileTransferHandler<FileAssistant>", 1, "file sha:" + parama.bHd);
      return;
      label509:
      if (localDownloadInfo.str_download_domain.has())
      {
        parama.strIP = localDownloadInfo.str_download_domain.get();
        break label120;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: has neither ip nor domain");
      break label120;
      label547:
      if (localDownloadInfo.str_download_url.has()) {
        parama.strUrl = localDownloadInfo.str_download_url.get();
      }
    }
  }
  
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2, long paramLong3, long paramLong4, String paramString6, anbm paramanbm, int paramInt3, hummer_resv_21.FileImgInfo paramFileImgInfo, byte[] paramArrayOfByte, String paramString7, hummer_resv_21.FileApkInfo paramFileApkInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "internalHandleOffLineFileMsg friendUin[" + String.valueOf(paramString1) + "],senderuin[" + String.valueOf(paramString2) + "],time[" + String.valueOf(paramLong1) + "],seq[" + String.valueOf(paramShort) + "],isRead[" + String.valueOf(paramBoolean1) + "],isPullRoam[" + String.valueOf(paramBoolean2) + "],type[" + String.valueOf(paramInt1) + "],uuid[" + String.valueOf(paramString3) + "],fileIdCrc[" + paramString4 + "],type[" + String.valueOf(paramInt1) + "],strFileName[" + String.valueOf(paramString5) + "],dwFileSize[" + String.valueOf(paramLong2) + "],reserve[" + String.valueOf(paramInt2) + "],vipBubbleID[" + String.valueOf(paramLong3) + "],vipBubbleDiyTextID[" + String.valueOf(paramInt3) + "]");
    }
    FileManagerEntity localFileManagerEntity = a(paramMessageHandler, paramString1, paramString2, paramLong1, paramShort, paramBoolean1, paramBoolean2, paramInt1, paramString3, paramString4, paramString5, paramLong2, paramInt2, paramLong3, paramLong4);
    if (localFileManagerEntity == null) {
      QLog.w("FileTransferHandler<FileAssistant>", 1, "entry is null,may be is onlinefile!");
    }
    do
    {
      do
      {
        return;
        if (TextUtils.isEmpty(paramString5))
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
      paramString3 = (MessageRecord)paramMessageHandler.get(0);
      paramList.add(paramMessageHandler.get(0));
      ahav.j(this.app, paramString2, paramString1, paramString3.istroop);
      if (this.jdField_a_of_type_Aocq == null) {
        this.jdField_a_of_type_Aocq = ((aocq)this.app.getManager(272));
      }
    } while (!(paramString3 instanceof MessageForFile));
    ((MessageForFile)paramString3).fileName = paramString5;
    this.jdField_a_of_type_Aocq.Z((MessageForFile)paramString3);
    return;
    String str = aoon.a(aojs.a(this.app.getAccount(), paramString5, 0, null), paramLong2, 0, false, null);
    paramMessageHandler = paramString2;
    int j;
    int i;
    if (paramanbm != null)
    {
      j = 1;
      if (paramanbm.friendType == -1)
      {
        i = 0;
        paramMessageHandler = paramString2;
        if (i == 0) {
          break label1503;
        }
        i = paramanbm.friendType;
        paramMessageHandler = paramString2;
      }
    }
    for (;;)
    {
      paramString2 = this.app.getCurrentAccountUin();
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.fileName = paramString5;
      localFileManagerEntity.fileSize = paramLong2;
      localFileManagerEntity.peerNick = ahav.a(this.app, paramString1, null, 0);
      localFileManagerEntity.peerType = i;
      localFileManagerEntity.peerUin = paramString1;
      localFileManagerEntity.srvTime = (1000L * paramLong1);
      localFileManagerEntity.status = -1;
      localFileManagerEntity.Uuid = paramString3;
      localFileManagerEntity.fileIdCrc = paramString4;
      localFileManagerEntity.isReaded = paramBoolean1;
      localFileManagerEntity.bSend = false;
      localFileManagerEntity.msgSeq = paramShort;
      localFileManagerEntity.msgUid = paramLong4;
      localFileManagerEntity.strFileMd5 = paramString6;
      localFileManagerEntity.nFileType = ahav.getFileType(paramString5);
      if (agmy.mt(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "tencentdoc use new type");
        }
        localFileManagerEntity.nFileType = 13;
        localFileManagerEntity.bombData = paramArrayOfByte;
        localFileManagerEntity.strThumbPath = paramString7;
        localFileManagerEntity.nOpType = 0;
        if (paramMessageHandler.equals(paramString1)) {
          localFileManagerEntity.nOpType = 1;
        }
        if (paramanbm != null)
        {
          if (paramanbm.friendType != -1) {
            localFileManagerEntity.peerType = 1;
          }
          localFileManagerEntity.TroopUin = paramanbm.groupUin;
        }
        localFileManagerEntity.bDelInFM = false;
      }
      if (paramFileImgInfo != null)
      {
        localFileManagerEntity.imgWidth = paramFileImgInfo.uint32_file_width.get();
        localFileManagerEntity.imgHeight = paramFileImgInfo.uint32_file_height.get();
      }
      if ((paramFileApkInfo != null) && (paramFileApkInfo.str_package_name.has()))
      {
        localFileManagerEntity.yybApkPackageName = paramFileApkInfo.str_package_name.get();
        localFileManagerEntity.yybApkName = paramFileApkInfo.str_app_name.get();
        localFileManagerEntity.yybApkIconUrl = paramFileApkInfo.str_icon_url.get();
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_=k recv OfflineFile Id[" + localFileManagerEntity.nSessionId + "],File[" + localFileManagerEntity.fileName + "], Md5[" + localFileManagerEntity.strFileMd5 + "]");
      ahav.getFileType(paramString5);
      if (TextUtils.isEmpty(localFileManagerEntity.Uuid))
      {
        localFileManagerEntity.nWeiYunSrcType = -2;
        paramString4 = "friendUin:" + String.valueOf(paramString1) + "senderuin:" + String.valueOf(paramMessageHandler) + "time:" + String.valueOf(paramLong1) + "seq:" + String.valueOf(paramShort) + "isRead:" + String.valueOf(paramBoolean1) + "isPullRoam:" + String.valueOf(paramBoolean2) + "type:" + String.valueOf(paramInt1) + "uuid:" + String.valueOf(paramString3) + "strFileName:" + String.valueOf(paramString5) + "dwFileSize:" + String.valueOf(paramLong2) + "reserve:" + String.valueOf(paramInt2) + "vipBubbleID:" + String.valueOf(paramLong3) + "vipBubbleDiyTextID:" + String.valueOf(paramInt3);
        ahav.a(this.app, localFileManagerEntity.nSessionId, "actFileDownDetail", 0L, "", localFileManagerEntity.selfUin, localFileManagerEntity.Uuid, localFileManagerEntity.strFileMd5, 9081L, paramString4, 0L, 0L, paramLong2, "", "", 0, "uuid null", null);
      }
      ahav.a(this.app, localFileManagerEntity);
      ahav.a(this.app, paramMessageHandler, "", localFileManagerEntity);
      if (paramString2.equals(paramMessageHandler))
      {
        this.app.a().d(paramString1, 0, localFileManagerEntity.uniseq);
        localFileManagerEntity.nOpType = 0;
        localFileManagerEntity.status = 1;
        localFileManagerEntity.bSend = true;
        localFileManagerEntity.isReaded = true;
        localFileManagerEntity.bDelInFM = false;
        localFileManagerEntity.bOnceSuccess = true;
      }
      localFileManagerEntity.bDelInFM = false;
      this.app.a().s(localFileManagerEntity);
      this.app.a().u(localFileManagerEntity);
      ahav.a(localFileManagerEntity, this.app, null);
      if (QLog.isDevelopLevel()) {
        QLog.w("FileTransferHandler<FileAssistant>", 2, "offline file come:fileName[" + paramString5 + "],uuid[" + paramString3 + "] insert To AIO");
      }
      a(paramList, paramString1, paramMessageHandler, paramString5, paramLong2, paramBoolean1, i, str, paramShort, paramShort, paramString3, paramInt1, localFileManagerEntity.uniseq, paramLong4, paramLong3, paramLong1, -2005, paramInt3, paramFileImgInfo);
      if (QLog.isColorLevel()) {
        QLog.i("FileTransferHandler<FileAssistant>", 2, "File Coming:" + ahav.d(localFileManagerEntity));
      }
      this.app.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, paramString1, i, 17, null, 0, null);
      return;
      if ((paramanbm.friendType != 1000) && (paramanbm.friendType != 1020))
      {
        i = j;
        if (paramanbm.friendType != 1004) {
          break;
        }
      }
      paramString2 = String.valueOf(paramanbm.groupUin);
      i = j;
      break;
      label1503:
      i = 0;
    }
  }
  
  private void a(ProtoReqManager.c paramc)
  {
    paramc.a = new agid(this);
    this.app.getProtoReqManager().b(paramc);
  }
  
  private void a(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    ArrayList localArrayList = new ArrayList();
    if (a(paramd)) {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
    }
    Object localObject;
    for (;;)
    {
      a(((agib.d)paramc.fi).a(), 5021, bool2, new Object[] { Boolean.valueOf(bool1), localArrayList });
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: resp is failed[" + paramd.g.getResultCode() + "]");
      }
      else
      {
        paramd = paramd.g.getWupBuffer();
        localObject = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject).mergeFrom(paramd);
          if (((cmd0x346.RspBody)localObject).msg_recv_list_query_rsp.has()) {
            break label207;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: rspBody has not msg_recv_list_query_rsp");
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
        }
        continue;
        label207:
        paramd = (cmd0x346.RecvListQueryRsp)((cmd0x346.RspBody)localObject).msg_recv_list_query_rsp.get();
        if (!paramd.int32_ret_code.has()) {
          break;
        }
        int i = paramd.int32_ret_code.get();
        if (i == 0) {
          break;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: failed retCode[" + i + "]");
      }
    }
    if (((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.has()) {
      if (((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.get() == 1)
      {
        bool1 = true;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: bUseMediaPlatform " + bool1);
      }
    }
    for (;;)
    {
      localObject = paramd.rpt_msg_file_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        cmd0x346.FileInfo localFileInfo = (cmd0x346.FileInfo)((Iterator)localObject).next();
        OfflineFileInfo localOfflineFileInfo = new OfflineFileInfo();
        localOfflineFileInfo.bSend = false;
        localOfflineFileInfo.cYg = localFileInfo.uint32_danger_evel.get();
        localOfflineFileInfo.nFileSize = localFileInfo.uint64_file_size.get();
        localOfflineFileInfo.Zm = (anaz.gQ() * 1000L + localFileInfo.uint32_life_time.get() * 1000L);
        localOfflineFileInfo.Zn = (localFileInfo.uint32_upload_time.get() * 1000L);
        localOfflineFileInfo.strFileName = localFileInfo.str_file_name.get();
        localOfflineFileInfo.bHK = new String(localFileInfo.bytes_uuid.get().toByteArray());
        if (bool1) {
          localOfflineFileInfo.bHL = localFileInfo.str_fileidcrc.get();
        }
        localOfflineFileInfo.uFriendUin = localFileInfo.uint64_uin.get();
        localArrayList.add(localOfflineFileInfo);
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleQueryRecvListResponse OfflineFileInfo[" + localOfflineFileInfo.toString() + "]");
        }
      }
      bool1 = false;
      break;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
      bool1 = false;
    }
    if (paramd.uint32_is_end.get() > 0) {}
    for (bool1 = true;; bool1 = false)
    {
      bool2 = true;
      break;
    }
  }
  
  private void a(boolean paramBoolean, FileManagerEntity paramFileManagerEntity, String paramString1, int paramInt, String paramString2, long paramLong)
  {
    if (paramBoolean)
    {
      paramFileManagerEntity.status = 1;
      switch (paramFileManagerEntity.nOpType)
      {
      default: 
        if (QLog.isDevelopLevel()) {
          throw new NullPointerException(acfp.m(2131706292));
        }
        break;
      case 21: 
        paramFileManagerEntity.Uuid = paramString1;
        paramFileManagerEntity.peerType = 0;
        paramFileManagerEntity.setCloudType(1);
        this.app.a().b(paramBoolean, 19, new Object[] { Integer.valueOf(paramInt), paramString2, Long.valueOf(0L), Long.valueOf(0L), paramString1, Long.valueOf(paramLong) });
        a(paramFileManagerEntity.peerUin, paramFileManagerEntity, null);
        this.app.a().a(paramFileManagerEntity, 6, null);
      }
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = e(paramString1);
          if (localObject != null) {
            paramFileManagerEntity.WeiYunDirKey = ((String)((Pair)localObject).first);
          }
          for (paramFileManagerEntity.WeiYunFileId = ((String)((Pair)localObject).second);; paramFileManagerEntity.WeiYunFileId = paramString1)
          {
            paramFileManagerEntity.setCloudType(2);
            this.app.a().b(paramBoolean, 34, new Object[] { Integer.valueOf(paramInt), paramString2, paramString1, Long.valueOf(paramLong) });
            return;
          }
        } while (!(paramFileManagerEntity.mContext instanceof ahbm));
        wte.a().h(this.app, paramFileManagerEntity.uniseq);
        ((ahbm)paramFileManagerEntity.mContext).a(paramBoolean, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, paramInt, paramString2, String.valueOf(paramFileManagerEntity.peerUin), paramString1);
        return;
        switch (paramFileManagerEntity.nOpType)
        {
        }
      } while (!QLog.isDevelopLevel());
      throw new NullPointerException(acfp.m(2131706293));
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        paramFileManagerEntity.status = 16;
        if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
        {
          localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
          ((FileManagerEntity)localObject).status = 16;
          this.app.a().u((FileManagerEntity)localObject);
          paramFileManagerEntity.mContext = null;
        }
        this.app.a().u(paramFileManagerEntity);
      }
      this.app.a().b(paramBoolean, 19, new Object[] { Integer.valueOf(paramInt), paramString2, Long.valueOf(0L), Long.valueOf(0L), paramString1, Long.valueOf(paramLong) });
      return;
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        paramFileManagerEntity.status = 16;
        if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
        {
          localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
          ((FileManagerEntity)localObject).status = 16;
          this.app.a().u((FileManagerEntity)localObject);
          paramFileManagerEntity.mContext = null;
        }
        this.app.a().u(paramFileManagerEntity);
      }
      this.app.a().b(paramBoolean, 34, new Object[] { Integer.valueOf(paramInt), paramString2, paramString1, Long.valueOf(paramLong) });
      return;
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        paramFileManagerEntity.status = 16;
        if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
        {
          localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
          ((FileManagerEntity)localObject).status = 16;
          this.app.a().u((FileManagerEntity)localObject);
          paramFileManagerEntity.mContext = null;
        }
        this.app.a().u(paramFileManagerEntity);
      }
    } while (!(paramFileManagerEntity.mContext instanceof ahbm));
    ((ahbm)paramFileManagerEntity.mContext).a(paramBoolean, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, paramInt, paramString2, String.valueOf(paramFileManagerEntity.peerUin), paramString1);
  }
  
  private boolean a(ProtoReqManager.d paramd)
  {
    return (paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013);
  }
  
  private boolean a(ProtoReqManager.d paramd, agib.b paramb)
  {
    if (a(paramd))
    {
      paramb.retCode = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      return true;
    }
    if (paramd.g.getResultCode() != 1000)
    {
      paramb.retCode = -100002;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is failed[" + paramd.g.getResultCode() + "]");
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, List<MessageRecord> paramList, String paramString3)
  {
    if (paramLong1 != 0L)
    {
      localObject = this.app.a().a(String.valueOf(paramString1), paramLong1);
      if (localObject != null)
      {
        if (!((FileManagerEntity)localObject).bDelInAio)
        {
          paramString1 = this.app.b().b(String.valueOf(paramString1), ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).uniseq);
          if (paramString1 != null) {
            paramList.add(paramString1);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "ol2offline duplicate msg, entity info" + ahav.d((FileManagerEntity)localObject));
        }
        return true;
      }
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "msgFilterByFMDB,friendUin[" + ahav.kZ(paramString1) + "],uuid[" + paramString2 + "],olSessionId[" + paramLong1 + "],msgSeq[" + paramLong2 + "],msgUid[" + paramLong3 + "],senderuin[" + ahav.kZ(paramString3) + "]");
    Object localObject = paramString2.replace("/offline", "");
    List localList = this.app.a().eW();
    int i = 0;
    if (i < localList.size())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localList.get(i);
      paramString2 = "";
      String str = ((String)localObject).replace("/offline", "");
      if (localFileManagerEntity.Uuid != null) {
        paramString2 = localFileManagerEntity.Uuid.replace("/offline", "");
      }
      switch (localFileManagerEntity.nOpType)
      {
      }
      label628:
      do
      {
        do
        {
          do
          {
            if (QLog.isColorLevel()) {
              QLog.w("FileTransferHandler<FileAssistant>", 1, "Entity [" + ahav.d(localFileManagerEntity) + "]");
            }
            i += 1;
            break;
            if ((paramLong2 != localFileManagerEntity.msgSeq) || (paramLong3 != localFileManagerEntity.msgUid)) {
              break label628;
            }
            paramString2 = this.app.b().b(paramString1, localFileManagerEntity.peerType, localFileManagerEntity.uniseq);
            if (paramString2 != null)
            {
              paramList.add(paramString2);
              if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "msgSeq and msguid are all equal, duplicate msg, entity info" + ahav.d(localFileManagerEntity));
              }
              return true;
            }
            paramString2 = new ArrayList();
            a(paramString2, paramString1, paramString3, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.isReaded, 0, null, paramLong2, paramLong2, (String)localObject, 0, localFileManagerEntity.uniseq, paramLong3, -1L, localFileManagerEntity.srvTime / 1000L, -2005, 0, null);
          } while (paramString2.size() <= 0);
          paramList.add((MessageRecord)paramString2.get(0));
          if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "msgSeq and msguid are all equal, duplicate msg, entity info" + ahav.d(localFileManagerEntity));
          }
          return true;
        } while (!paramString2.equalsIgnoreCase(str));
        paramString2 = this.app.b().b(paramString1, localFileManagerEntity.peerType, localFileManagerEntity.uniseq);
        if (paramString2 != null)
        {
          paramList.add(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "duplicate msg, entity info" + ahav.d(localFileManagerEntity));
          }
          return true;
        }
        paramString2 = new ArrayList();
        a(paramString2, paramString1, paramString3, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.isReaded, 0, null, paramLong2, paramLong2, (String)localObject, 0, localFileManagerEntity.uniseq, paramLong3, -1L, localFileManagerEntity.srvTime / 1000L, -2005, 0, null);
      } while (paramString2.size() <= 0);
      paramList.add((MessageRecord)paramString2.get(0));
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "Uuid are all equal, duplicate msg, entity info" + ahav.d(localFileManagerEntity));
      }
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    return ((paramBoolean4) && (paramBoolean2)) || (((paramBoolean3) || (paramBoolean1)) && (paramInt < 3));
  }
  
  private void aA(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleReqOffFilePackError, count: " + i);
    }
    if (i < 3)
    {
      paramToServiceMsg.extraData.putInt("retryIndex", i + 1);
      send(paramToServiceMsg);
      return;
    }
    achq.a locala = new achq.a();
    locala.errCode = paramFromServiceMsg.getResultCode();
    locala.retryCount = i;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      locala.errCode = 2900;
      locala.Qw = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 2139062142L);
    }
    locala.timeoutReason = MessageHandler.b(paramFromServiceMsg);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
    switch (paramToServiceMsg.extraData.getInt("offfile_type"))
    {
    case 0: 
    default: 
      return;
    case 1: 
      notifyUI(paramToServiceMsg, 5003, false, new Object[] { paramFromServiceMsg, locala });
      return;
    case 2: 
      notifyUI(paramToServiceMsg, 5005, false, new Object[] { paramFromServiceMsg, locala });
      return;
    }
    notifyUI(paramToServiceMsg, 5004, false, new Object[] { paramFromServiceMsg, locala });
  }
  
  private boolean ald()
  {
    return ((agiq)this.app.getManager(317)).ald();
  }
  
  private agzs b(agzw paramagzw)
  {
    agzs localagzs = new agzs();
    localagzs.jdField_a_of_type_Agzp = new agzp();
    paramagzw.bJz = paramagzw.bJz.replace("+", "");
    long l = Long.parseLong(this.app.getCurrentAccountUin());
    localagzs.jdField_a_of_type_Agzp.uint64_sender_uin = l;
    localagzs.jdField_a_of_type_Agzp.uint64_recver_uin = Long.parseLong(paramagzw.bJz);
    localagzs.jdField_a_of_type_Agzp.uint64_file_size = paramagzw.fileSize;
    localagzs.jdField_a_of_type_Agzp.str_file_name = new String(paramagzw.ej);
    localagzs.jdField_a_of_type_Agzp.str_local_filepath = new String(paramagzw.ei);
    localagzs.jdField_a_of_type_Agzp.bytes_10m_md5 = paramagzw.md5;
    localagzs.jdField_a_of_type_Agzp.bytes_sha = paramagzw.sha1;
    localagzs.jdField_a_of_type_Agzp.bytes_3sha = paramagzw.el;
    return localagzs;
  }
  
  private void b(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    ArrayList localArrayList = new ArrayList();
    if (a(paramd)) {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
    }
    Object localObject;
    for (;;)
    {
      a(((agib.d)paramc.fi).a(), 5022, bool2, new Object[] { Boolean.valueOf(bool1), localArrayList });
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: resp is failed[" + paramd.g.getResultCode() + "]");
      }
      else
      {
        paramd = paramd.g.getWupBuffer();
        localObject = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject).mergeFrom(paramd);
          if (((cmd0x346.RspBody)localObject).msg_send_list_query_rsp.has()) {
            break label207;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: rspBody has not msg_send_list_query_rsp");
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
        }
        continue;
        label207:
        paramd = (cmd0x346.SendListQueryRsp)((cmd0x346.RspBody)localObject).msg_send_list_query_rsp.get();
        if (!paramd.int32_ret_code.has()) {
          break;
        }
        int i = paramd.int32_ret_code.get();
        if (i == 0) {
          break;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: failed retCode[" + i + "]");
      }
    }
    if (((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.has()) {
      if (((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.get() == 1)
      {
        bool1 = true;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: bUseMediaPlatform " + bool1);
      }
    }
    for (;;)
    {
      localObject = paramd.rpt_msg_file_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        cmd0x346.FileInfo localFileInfo = (cmd0x346.FileInfo)((Iterator)localObject).next();
        OfflineFileInfo localOfflineFileInfo = new OfflineFileInfo();
        localOfflineFileInfo.bSend = true;
        localOfflineFileInfo.cYg = localFileInfo.uint32_danger_evel.get();
        localOfflineFileInfo.nFileSize = localFileInfo.uint64_file_size.get();
        localOfflineFileInfo.Zm = (anaz.gQ() * 1000L + localFileInfo.uint32_life_time.get() * 1000L);
        localOfflineFileInfo.Zn = (localFileInfo.uint32_upload_time.get() * 1000L);
        localOfflineFileInfo.strFileName = localFileInfo.str_file_name.get();
        localOfflineFileInfo.bHK = new String(localFileInfo.bytes_uuid.get().toByteArray());
        if (bool1) {
          localOfflineFileInfo.bHL = localFileInfo.str_fileidcrc.get();
        }
        localOfflineFileInfo.uFriendUin = localFileInfo.uint64_uin.get();
        localArrayList.add(localOfflineFileInfo);
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleQuerySendListResponse OfflineFileInfo[" + localOfflineFileInfo.toString() + "]");
        }
      }
      bool1 = false;
      break;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
      bool1 = false;
    }
    if (paramd.uint32_is_end.get() > 0) {}
    for (bool1 = true;; bool1 = false)
    {
      bool2 = true;
      break;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, anbd.a parama)
  {
    if ((parama == null) || (parama.akw != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSendOfflineFileResp-->handleError");
      }
      aA(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSendOfflineFileResp-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    achq.a locala = new achq.a();
    locala.errCode = paramFromServiceMsg.getResultCode();
    locala.retryCount = i;
    locala.appSeq = paramFromServiceMsg.getAppSeq();
    notifyUI(paramToServiceMsg, 5004, true, new Object[] { parama, locala });
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      localObject1 = this.jdField_a_of_type_Anbd.M(paramToServiceMsg, paramFromServiceMsg);
      return localObject1;
    }
    catch (Exception paramToServiceMsg)
    {
      do
      {
        paramToServiceMsg.printStackTrace();
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.d("FileTransferHandler<FileAssistant>", 2, this.jdField_a_of_type_Anbd.getClass().getSimpleName() + " decode error," + paramToServiceMsg.toString());
    }
    return null;
  }
  
  private void c(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    agib.b localb = new agib.b();
    agib.d locald = null;
    byte[] arrayOfByte;
    boolean bool1;
    label57:
    boolean bool3;
    label79:
    boolean bool4;
    if (a(paramd, localb))
    {
      arrayOfByte = null;
      bool1 = false;
      if ((localb.retCode != 0) || ((localb.strIP != null) && (localb.strIP.length() != 0))) {
        break label662;
      }
      bool2 = true;
      if ((localb.strIP == null) || (localb.strIP.length() <= 0)) {
        break label668;
      }
      bool3 = true;
      if ((localb.retCode != -91245) && (localb.retCode != -7010)) {
        break label674;
      }
      bool4 = true;
      label104:
      if ((localb.uuid != null) && (localb.uuid.length != 0)) {
        break label680;
      }
    }
    Object localObject1;
    label265:
    label662:
    label668:
    label674:
    label680:
    for (boolean bool5 = true;; bool5 = false)
    {
      for (;;)
      {
        locald = (agib.d)paramc.fi;
        if (!a(bool2, bool3, bool4, bool5, locald.Ee())) {
          break label686;
        }
        locald.dgs();
        a(paramc.clW, paramc.fW, locald);
        return;
        arrayOfByte = paramd.g.getWupBuffer();
        localb.dI = arrayOfByte;
        localObject2 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom(arrayOfByte);
          if (((cmd0x346.RspBody)localObject2).msg_apply_upload_rsp.has()) {
            break label265;
          }
          localb.retCode = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          arrayOfByte = null;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localb.retCode = -100003;
          localObject1 = null;
          bool1 = false;
        }
      }
      break;
      Object localObject2 = (cmd0x346.ApplyUploadRsp)((cmd0x346.RspBody)localObject2).msg_apply_upload_rsp.get();
      if (((cmd0x346.ApplyUploadRsp)localObject2).int32_ret_code.has()) {
        localb.retCode = ((cmd0x346.ApplyUploadRsp)localObject2).int32_ret_code.get();
      }
      if (((cmd0x346.ApplyUploadRsp)localObject2).str_ret_msg.has()) {
        localb.retMsg = ((cmd0x346.ApplyUploadRsp)localObject2).str_ret_msg.get();
      }
      if (((cmd0x346.ApplyUploadRsp)localObject2).uint64_total_space.has()) {
        localb.totalSpace = ((cmd0x346.ApplyUploadRsp)localObject2).uint64_total_space.get();
      }
      if (((cmd0x346.ApplyUploadRsp)localObject2).uint64_used_space.has()) {
        localb.usedSpace = ((cmd0x346.ApplyUploadRsp)localObject2).uint64_used_space.get();
      }
      if (((cmd0x346.ApplyUploadRsp)localObject2).uint64_uploaded_size.has()) {
        localb.fileSize = ((cmd0x346.ApplyUploadRsp)localObject2).uint64_uploaded_size.get();
      }
      if (((cmd0x346.ApplyUploadRsp)localObject2).str_upload_ip.has()) {
        localb.strIP = ((cmd0x346.ApplyUploadRsp)localObject2).str_upload_ip.get();
      }
      for (;;)
      {
        if (((cmd0x346.ApplyUploadRsp)localObject2).uint32_upload_port.has()) {
          localb.ag = ((short)((cmd0x346.ApplyUploadRsp)localObject2).uint32_upload_port.get());
        }
        if (((cmd0x346.ApplyUploadRsp)localObject2).bytes_uuid.has()) {
          localb.uuid = ((cmd0x346.ApplyUploadRsp)localObject2).bytes_uuid.get().toByteArray();
        }
        if (((cmd0x346.ApplyUploadRsp)localObject2).bytes_upload_key.has()) {
          localb.key = ((cmd0x346.ApplyUploadRsp)localObject2).bytes_upload_key.get().toByteArray();
        }
        if (((cmd0x346.ApplyUploadRsp)localObject2).bool_file_exist.has()) {
          localb.fileExist = ((cmd0x346.ApplyUploadRsp)localObject2).bool_file_exist.get();
        }
        if (((cmd0x346.ApplyUploadRsp)localObject2).uint32_upload_port.has()) {
          localb.packetSize = ((cmd0x346.ApplyUploadRsp)localObject2).uint32_pack_size.get();
        }
        localObject1 = locald;
        if (((cmd0x346.ApplyUploadRsp)localObject2).rpt_str_uploadip_list.has())
        {
          localObject1 = locald;
          if (((cmd0x346.ApplyUploadRsp)localObject2).rpt_str_uploadip_list.get().size() > 0) {
            localObject1 = ((cmd0x346.ApplyUploadRsp)localObject2).rpt_str_uploadip_list.get();
          }
        }
        if (((cmd0x346.ApplyUploadRsp)localObject2).str_upload_dns.has()) {
          localb.bHg = ((cmd0x346.ApplyUploadRsp)localObject2).str_upload_dns.get();
        }
        bool1 = true;
        break;
        if (((cmd0x346.ApplyUploadRsp)localObject2).str_upload_domain.has()) {
          localb.strIP = ((cmd0x346.ApplyUploadRsp)localObject2).str_upload_domain.get();
        } else {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
        }
      }
      bool2 = false;
      break label57;
      bool3 = false;
      break label79;
      bool4 = false;
      break label104;
    }
    label686:
    paramc = new achq.a();
    paramc.errCode = localb.retCode;
    paramc.retryCount = paramd.dPU;
    boolean bool2 = bool1;
    if (bool5)
    {
      bool2 = bool1;
      if (bool3)
      {
        localb.retMsg = ("uuid_null[" + localb.toString() + "]");
        bool2 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool2 + ", retCode=" + localb.retCode + ", retMsg=" + localb.retMsg + ", totalSpace=" + localb.totalSpace + ", usedSpace=" + localb.usedSpace + ", ip=" + localb.strIP + ", port=" + localb.ag);
    }
    a(locald.a(), 5004, bool2, new Object[] { localb, paramc, localObject1 });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, anbd.a parama)
  {
    if ((parama == null) || (parama.akw != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSetOfflineFileState-->handleError");
      }
      aA(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSetOfflineFileState-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    achq.a locala = new achq.a();
    locala.errCode = paramFromServiceMsg.getResultCode();
    locala.retryCount = i;
    notifyUI(paramToServiceMsg, 5005, true, new Object[] { parama, locala });
  }
  
  private ToServiceMsg createToServiceMsg(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), paramString);
  }
  
  private void d(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    agib.b localb = new agib.b();
    boolean bool;
    if (a(paramd))
    {
      localb.retCode = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool = false;
      if (localb.retCode == 0) {
        break label405;
      }
      bool = false;
    }
    label405:
    for (;;)
    {
      cmd0x346.RspBody localRspBody;
      for (;;)
      {
        Object localObject = new achq.a();
        ((achq.a)localObject).errCode = localb.retCode;
        ((achq.a)localObject).retryCount = paramd.dPU;
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleUploadSuccResponse: return " + bool + ", retCode=" + localb.retCode + ", retMsg=" + localb.retMsg);
        }
        a(((agib.d)paramc.fi).a(), 5005, bool, new Object[] { localb, localObject });
        return;
        if (paramd.g.getResultCode() != 1000)
        {
          localb.retCode = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: resp is failed[" + paramd.g.getResultCode() + "]");
          bool = false;
          break;
        }
        localObject = paramd.g.getWupBuffer();
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_upload_succ_rsp.has()) {
            break label339;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          localb.retCode = -100003;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localb.retCode = -100003;
          bool = false;
        }
      }
      break;
      label339:
      cmd0x346.UploadSuccRsp localUploadSuccRsp = (cmd0x346.UploadSuccRsp)localRspBody.msg_upload_succ_rsp.get();
      if (localUploadSuccRsp.int32_ret_code.has()) {
        localb.retCode = localUploadSuccRsp.int32_ret_code.get();
      }
      if (localUploadSuccRsp.str_ret_msg.has()) {
        localb.retMsg = localUploadSuccRsp.str_ret_msg.get();
      }
      bool = true;
      break;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, anbd.a parama)
  {
    long l3 = parama.akx;
    long l1 = parama.time;
    long l2 = parama.fileSize;
    long l4 = parama.senderUin;
    String str2 = parama.url;
    paramFromServiceMsg = parama.fileName;
    String str1 = paramToServiceMsg.extraData.getString("friendUin");
    paramToServiceMsg.extraData.getBoolean("isRead");
    str2 = "http://" + aqoj.bT(l3) + "/?ver=" + "2" + "&rkey=" + str2;
    String str3 = aoon.a(aojs.a(this.app.getAccount(), paramFromServiceMsg, 0, null), l2, 0, false, str2);
    String str4;
    String str5;
    FileManagerEntity localFileManagerEntity;
    if (str3 != null)
    {
      str4 = String.valueOf(l4);
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("filepath");
      l3 = anbi.d(-1000).uniseq;
      str5 = this.app.getCurrentAccountUin();
      localFileManagerEntity = this.app.a().b(l3, str1, 0);
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.fileName = paramFromServiceMsg;
      localFileManagerEntity.fileSize = l2;
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.peerNick = ahav.a(this.app, str1, null, 0);
      localFileManagerEntity.peerType = 0;
      localFileManagerEntity.peerUin = str1;
      localFileManagerEntity.srvTime = (1000L * l1);
      localFileManagerEntity.status = -1;
      if (paramToServiceMsg != null) {
        localFileManagerEntity.Uuid = new String(paramToServiceMsg);
      }
      localFileManagerEntity.isReaded = false;
      localFileManagerEntity.strServerPath = str2;
      localFileManagerEntity.bSend = false;
      if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
        break label597;
      }
      localFileManagerEntity.nWeiYunSrcType = -2;
      ahav.a(this.app, localFileManagerEntity.nSessionId, "actFileDownDetail", 0L, "", localFileManagerEntity.selfUin, localFileManagerEntity.Uuid, localFileManagerEntity.strFileMd5, 9081L, parama.toString(), 0L, 0L, l2, "", "", 0, "uuid null", null);
    }
    for (;;)
    {
      ahav.a(this.app, localFileManagerEntity);
      ahav.a(localFileManagerEntity, this.app, null);
      if (str5.equals(str4))
      {
        this.app.a().d(str1, 0, l3);
        localFileManagerEntity.nOpType = 7;
        localFileManagerEntity.status = 1;
        localFileManagerEntity.bSend = true;
        localFileManagerEntity.isReaded = true;
        localFileManagerEntity.bOnceSuccess = true;
      }
      this.app.a().s(localFileManagerEntity);
      this.app.a().a(str1, str4, localFileManagerEntity.bSend, paramFromServiceMsg, 0L, false, 0, str3, parama.aq, parama.aq, new String(paramToServiceMsg), 1, l3, localFileManagerEntity.msgUid, -1L, l1);
      if (QLog.isColorLevel()) {
        QLog.i("FileTransferHandler<FileAssistant>", 2, "File Coming:" + ahav.d(localFileManagerEntity));
      }
      this.app.a().a(l3, localFileManagerEntity.nSessionId, str1, 0, 17, null, 0, null);
      this.app.a().dhl();
      return;
      label597:
      if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0) || (l2 == 0L)) {
        ahav.a(this.app, localFileManagerEntity.nSessionId, "actFileDownDetail", 0L, "", localFileManagerEntity.selfUin, localFileManagerEntity.Uuid, localFileManagerEntity.strFileMd5, 90451L, parama.toString(), 0L, 0L, l2, "", "", 0, "A9 Name Null", null);
      }
    }
  }
  
  public static Pair<String, String> e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = paramString.getBytes();
    } while (paramString.length <= 36);
    byte[] arrayOfByte1 = new byte[32];
    byte[] arrayOfByte2 = new byte[paramString.length - 32];
    int i = 0;
    if (i < paramString.length)
    {
      if (i < 32) {
        arrayOfByte1[i] = paramString[i];
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfByte2[(i - 32)] = paramString[i];
      }
    }
    return new Pair(new String(arrayOfByte1), new String(arrayOfByte2));
  }
  
  private void e(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    long l1 = 0L;
    paramc = new face2face_file.msg();
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("QlinkResistTerrorist", 0);
    long l2;
    if (a(paramd))
    {
      l1 = -100001L;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResistTerrorist: resp is timeout[" + paramd.g.getResultCode() + "]");
      if (l1 != 0L) {}
      paramd = localSharedPreferences.edit();
      if ((paramc.has()) && (paramc.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleResistTerrorist: return resMessage.result:" + paramc.result.get());
        }
        paramd.putInt("QlinkResistTerrorist_res", paramc.result.get());
        paramd.putLong("SettingQlinkResistTerroristLastTime", anaz.gQ());
        paramd.putString("SettingQlinkResistTerroristLastAccount", this.app.getCurrentAccountUin());
      }
      paramd.commit();
      if (l1 != -100001L) {
        break label346;
      }
      l2 = 9043L;
    }
    for (;;)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleResistTerrorist: return " + paramc.result + " ,retCode:" + l2);
        }
        return;
        if (paramd.g.getResultCode() != 1000)
        {
          l1 = -100002L;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResistTerrorist: resp is failed[" + paramd.g.getResultCode() + "]");
          break;
        }
        paramd = paramd.g.getWupBuffer();
        try
        {
          paramc.mergeFrom(paramd);
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
          l1 = -100003L;
        }
      }
      break;
      label346:
      l2 = l1;
      if (l1 == -100003L) {
        l2 = 9045L;
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, anbd.a parama)
  {
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    achq.a locala = new achq.a();
    locala.errCode = paramFromServiceMsg.getResultCode();
    locala.retryCount = i;
    notifyUI(paramToServiceMsg, 5003, true, new Object[] { parama.fu, locala });
  }
  
  private void f(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    agib.a locala = new agib.a(null);
    long l;
    boolean bool2;
    boolean bool1;
    int i;
    if (a(paramd))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is timeout[" + paramd.g.getResultCode() + "]");
      l = -100001L;
      bool2 = false;
      bool1 = false;
      if ((l != 0L) || (locala.strUrl != null) || (locala.strIP != null)) {
        break label417;
      }
      i = 1;
      label93:
      if ((l != -91245L) && (l != -7010L)) {
        break label422;
      }
    }
    Object localObject2;
    label417:
    label422:
    for (int j = 1;; j = 0)
    {
      for (;;)
      {
        Object localObject1 = (agib.d)paramc.fi;
        int k = ((agib.d)localObject1).Ee();
        if (((j == 0) && (i == 0)) || (k >= 3)) {
          break label428;
        }
        ((agib.d)localObject1).dgs();
        a(paramc.clW, paramc.fW, (agib.d)localObject1);
        return;
        if (paramd.g.getResultCode() != 1000)
        {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is failed[" + paramd.g.getResultCode() + "]");
          l = -100002L;
          bool2 = false;
          bool1 = false;
          break;
        }
        localObject1 = paramd.g.getWupBuffer();
        localObject2 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom((byte[])localObject1);
          if (((cmd0x346.RspBody)localObject2).msg_apply_download_rsp.has()) {
            break label311;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: rspBody has not hasMsgApplyDownloadRsp");
          l = -100003L;
          bool2 = false;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          l = -100003L;
          bool2 = false;
          bool1 = false;
        }
      }
      break;
      label311:
      if (((cmd0x346.RspBody)localObject2).uint32_flag_use_media_platform.has()) {
        if (((cmd0x346.RspBody)localObject2).uint32_flag_use_media_platform.get() == 1)
        {
          bool1 = true;
          label337:
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: bUseMediaPlatform " + bool1);
        }
      }
      for (;;)
      {
        a(locala, (cmd0x346.ApplyDownloadRsp)((cmd0x346.RspBody)localObject2).msg_apply_download_rsp.get(), bool1);
        l = locala.retCode;
        bool2 = true;
        break;
        bool1 = false;
        break label337;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: bUseMediaPlatform false uint32_flag_use_media_platform not set");
        bool1 = false;
      }
      i = 0;
      break label93;
    }
    label428:
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("handleDownloadResp: return ").append(bool2).append(", retCode=").append(l).append(", retMsg=").append(locala.retMsg).append(", key=");
      if (locala.c == null) {
        break label803;
      }
    }
    label803:
    for (paramc = locala.c.toStringUtf8();; paramc = "")
    {
      QLog.d("FileTransferHandler<FileAssistant>", 2, paramc + ", strIP=" + locala.strIP + ", port=" + locala.ag + ", strUrl=" + locala.strUrl + ", strHttpsDomain=" + locala.bHe + ", httpsPort=" + locala.ah);
      paramc = new Bundle();
      if (locala.bHe != null) {
        paramc.putString("strHttpsDomain", locala.bHe);
      }
      if (locala.bHf != null) {
        paramc.putString("IPv6Dns", locala.bHf);
      }
      paramc.putShort("httpsPort", locala.ah);
      a(localInvalidProtocolBufferMicroException.a(), 5006, bool2, new Object[] { Long.valueOf(l), locala.retMsg, locala.strCookie, locala.c, Boolean.valueOf(bool1), locala.strIP, Short.valueOf(locala.ag), locala.strUrl, locala.AV, Integer.valueOf(paramd.g.getAppSeq()), locala.strFileName, locala.strMd5, locala.bHd, Long.valueOf(localInvalidProtocolBufferMicroException.fD()), paramc });
      return;
    }
  }
  
  private void g(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    agib.b localb = new agib.b();
    boolean bool;
    if (a(paramd))
    {
      localb.retCode = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool = false;
    }
    for (;;)
    {
      Object localObject = new achq.a();
      ((achq.a)localObject).errCode = localb.retCode;
      ((achq.a)localObject).retryCount = paramd.dPU;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleDownloadSuccResponse: return " + bool + ", retCode=" + localb.retCode + ", retMsg=" + localb.retMsg + ", retStat" + localb.cXd);
      }
      a(((agib.d)paramc.fi).a(), 5007, bool, new Object[] { localb, localObject });
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        localb.retCode = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: resp is failed[" + paramd.g.getResultCode() + "]");
        bool = false;
      }
      else
      {
        localObject = paramd.g.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_download_succ_rsp.has()) {
            break label343;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          localb.retCode = -100003;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localb.retCode = -100003;
          bool = false;
        }
        continue;
        label343:
        cmd0x346.DownloadSuccRsp localDownloadSuccRsp = (cmd0x346.DownloadSuccRsp)localRspBody.msg_download_succ_rsp.get();
        if (localDownloadSuccRsp.int32_ret_code.has()) {
          localb.retCode = localDownloadSuccRsp.int32_ret_code.get();
        }
        if (localDownloadSuccRsp.str_ret_msg.has()) {
          localb.retMsg = localDownloadSuccRsp.str_ret_msg.get();
        }
        if (localDownloadSuccRsp.int32_down_stat.has()) {
          localb.cXd = localDownloadSuccRsp.int32_down_stat.get();
        }
        bool = true;
      }
    }
  }
  
  private void h(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    int i = 0;
    Object localObject1 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    short s = 0;
    Object localObject7 = "";
    int j;
    Object localObject2;
    Object localObject4;
    boolean bool;
    if (a(paramd))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      i = -100001;
      j = 0;
      paramd = null;
      localObject1 = null;
      localObject2 = null;
      localObject3 = null;
      localObject4 = null;
      bool = false;
    }
    label234:
    Object localObject8;
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handlePreviewResponse: return " + bool + ", retCode=" + i + ", retMsg=" + (String)localObject4 + ", Key=" + (String)localObject3 + ", IP=" + (String)localObject2 + ", Domain=" + (String)localObject1 + ", port=" + j + ", strHttpsDomain=" + (String)localObject6 + ", httpsPort=" + s + "ipv6Domain=" + (String)localObject7);
      }
      if (i != -100001) {
        break label996;
      }
      i = 9043;
      if (i != 0) {
        bool = false;
      }
      paramc = (agib.d)paramc.fi;
      localObject8 = new Bundle();
      if (localObject6 != null) {
        ((Bundle)localObject8).putString("strHttpsDomain", (String)localObject6);
      }
      ((Bundle)localObject8).putShort("httpsPort", s);
      if (!TextUtils.isEmpty((CharSequence)localObject7)) {
        ((Bundle)localObject8).putString("IPv6Dns", (String)localObject7);
      }
      if (!paramc.ale()) {
        break label1012;
      }
      this.app.a().b(bool, 191, new Object[] { Integer.valueOf(i), localObject4, localObject5, localObject3, localObject2, localObject1, Integer.valueOf(j), paramd, Long.valueOf(paramc.fD()), localObject8 });
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is failed[" + paramd.g.getResultCode() + "]");
        i = -100002;
        j = 0;
        paramd = null;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        bool = false;
      }
      else
      {
        paramd = paramd.g.getWupBuffer();
        localObject2 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom(paramd);
          if (((cmd0x346.RspBody)localObject2).msg_apply_download_abs_rsp.has()) {
            break;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not hasMsgApplyDownloadAbsRsp");
          i = -100003;
          j = 0;
          paramd = null;
          localObject1 = null;
          localObject2 = null;
          localObject3 = null;
          localObject4 = null;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
          i = -100003;
          j = 0;
          paramd = null;
          localObject1 = null;
          localObject2 = null;
          localObject3 = null;
          localObject4 = null;
          bool = false;
        }
      }
    }
    Object localObject3 = (cmd0x346.ApplyDownloadAbsRsp)((cmd0x346.RspBody)localObject2).msg_apply_download_abs_rsp.get();
    if (((cmd0x346.ApplyDownloadAbsRsp)localObject3).int32_ret_code.has()) {
      i = ((cmd0x346.ApplyDownloadAbsRsp)localObject3).int32_ret_code.get();
    }
    if (((cmd0x346.ApplyDownloadAbsRsp)localObject3).str_ret_msg.has()) {}
    for (paramd = ((cmd0x346.ApplyDownloadAbsRsp)localObject3).str_ret_msg.get();; paramd = null)
    {
      if ((i == 0) && (!((cmd0x346.ApplyDownloadAbsRsp)localObject3).msg_download_info.has()))
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not MsgDownloadSuccRsp");
        i = -100003;
        bool = false;
        j = 0;
        localObject8 = null;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = paramd;
        paramd = (ProtoReqManager.d)localObject8;
        break;
      }
      localObject3 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadAbsRsp)localObject3).msg_download_info.get();
      localObject5 = ((cmd0x346.DownloadInfo)localObject3).str_download_ip.get();
      localObject4 = ((cmd0x346.DownloadInfo)localObject3).str_download_domain.get();
      j = ((cmd0x346.DownloadInfo)localObject3).uint32_port.get();
      String str = ((cmd0x346.DownloadInfo)localObject3).str_download_url.get();
      if (((cmd0x346.DownloadInfo)localObject3).str_cookie.has()) {
        localObject1 = "FTN5K=" + ((cmd0x346.DownloadInfo)localObject3).str_cookie.get();
      }
      bool = false;
      if (((cmd0x346.RspBody)localObject2).uint32_flag_use_media_platform.has()) {
        if (((cmd0x346.RspBody)localObject2).uint32_flag_use_media_platform.get() == 1)
        {
          bool = true;
          label810:
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: bUseMediaPlatform " + bool);
          label837:
          if (!bool) {
            break label983;
          }
          localObject2 = ((cmd0x346.DownloadInfo)localObject3).bytes_media_platform_download_key.get();
          label852:
          localObject6 = aqhs.bytes2HexStr(((ByteStringMicro)localObject2).toByteArray());
          if (!((cmd0x346.DownloadInfo)localObject3).str_https_download_domain.has()) {
            break label1096;
          }
        }
      }
      label1096:
      for (localObject2 = ((cmd0x346.DownloadInfo)localObject3).str_https_download_domain.get();; localObject2 = null)
      {
        if (((cmd0x346.DownloadInfo)localObject3).uint32_https_port.has()) {}
        for (s = (short)((cmd0x346.DownloadInfo)localObject3).uint32_https_port.get();; s = 0)
        {
          if (((cmd0x346.DownloadInfo)localObject3).str_download_dns.has()) {}
          for (localObject3 = ((cmd0x346.DownloadInfo)localObject3).str_download_dns.get();; localObject3 = "")
          {
            localObject7 = localObject3;
            localObject3 = localObject6;
            bool = true;
            localObject6 = localObject2;
            localObject2 = localObject5;
            localObject8 = paramd;
            localObject5 = localObject1;
            paramd = str;
            localObject1 = localObject4;
            localObject4 = localObject8;
            break;
            bool = false;
            break label810;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
            break label837;
            label983:
            localObject2 = ((cmd0x346.DownloadInfo)localObject3).bytes_download_key.get();
            break label852;
            label996:
            if (i == -100003)
            {
              i = 9045;
              break label234;
              label1012:
              this.app.a().b(bool, 18, new Object[] { Integer.valueOf(i), localObject4, localObject5, localObject3, localObject2, localObject1, Integer.valueOf(j), localObject8 });
              return;
            }
            break label234;
          }
        }
      }
    }
  }
  
  private void i(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    int i = 0;
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    long l1 = 0L;
    long l2 = 0L;
    boolean bool2;
    boolean bool1;
    if (a(paramd))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      l1 = 0L;
      l2 = 0L;
      localObject1 = null;
      bool2 = false;
      paramd = null;
      i = -100001;
      bool1 = false;
    }
    long l3;
    for (;;)
    {
      if (i != 0) {
        bool1 = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleForwardResponse: return " + bool1 + ", retCode=" + i + ", retMsg=" + paramd + ", totalSpace=" + l2 + ", usedSpace=" + l1);
      }
      l3 = ((agib.d)paramc.fi).fD();
      paramc = this.app.a().b(l3);
      ahav.a(this.app, paramc);
      if (bool1)
      {
        localObject3 = new ahau.a();
        ((ahau.a)localObject3).bJE = "send_file_suc";
        ((ahau.a)localObject3).cYX = 1;
        ahau.a(this.app.getCurrentAccountUin(), (ahau.a)localObject3);
      }
      this.app.a().a(bool1, i, paramd, (String)localObject2, bool2, (String)localObject1, l3);
      this.app.a().b(bool1, 19, new Object[] { Integer.valueOf(i), paramd, Long.valueOf(l2), Long.valueOf(l1), localObject2, Long.valueOf(l3) });
      if ((paramc.nOpType == 26) || (paramc.nOpType == 27)) {}
      try
      {
        ((ahbm)paramc.mContext).a(bool1, paramc.strTroopFileUuid, paramc.nSessionId, i, paramd, String.valueOf(paramc.peerUin), (String)localObject2);
        return;
      }
      catch (Exception paramc)
      {
        Object localObject5;
        paramc.printStackTrace();
        QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: Exception is " + paramc.toString());
      }
      if (paramd.g.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is failed[" + paramd.g.getResultCode() + "]");
        l1 = 0L;
        l2 = 0L;
        localObject1 = null;
        bool2 = false;
        paramd = null;
        i = -100002;
        bool1 = false;
      }
      else
      {
        paramd = paramd.g.getWupBuffer();
        localObject5 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject5).mergeFrom(paramd);
          if (((cmd0x346.RspBody)localObject5).msg_apply_forward_file_rsp.has()) {
            break;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse rspBody has not hasMsgApplyForwardFileRsp");
          l1 = 0L;
          l2 = 0L;
          localObject1 = null;
          bool2 = false;
          paramd = null;
          i = -100003;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
          l1 = 0L;
          l2 = 0L;
          localObject1 = null;
          bool2 = false;
          paramd = null;
          i = -100003;
          bool1 = false;
        }
      }
    }
    if (((cmd0x346.RspBody)localObject5).uint32_flag_use_media_platform.has()) {
      if (((cmd0x346.RspBody)localObject5).uint32_flag_use_media_platform.get() == 1)
      {
        bool1 = true;
        label573:
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: bUseMediaPlatform " + bool1);
      }
    }
    for (;;)
    {
      localObject5 = (cmd0x346.ApplyForwardFileRsp)((cmd0x346.RspBody)localObject5).msg_apply_forward_file_rsp.get();
      if (((cmd0x346.ApplyForwardFileRsp)localObject5).int32_ret_code.has()) {
        i = ((cmd0x346.ApplyForwardFileRsp)localObject5).int32_ret_code.get();
      }
      paramd = localObject4;
      if (((cmd0x346.ApplyForwardFileRsp)localObject5).str_ret_msg.has()) {
        paramd = ((cmd0x346.ApplyForwardFileRsp)localObject5).str_ret_msg.get();
      }
      if (((cmd0x346.ApplyForwardFileRsp)localObject5).bytes_uuid.has()) {
        localObject1 = new String(((cmd0x346.ApplyForwardFileRsp)localObject5).bytes_uuid.get().toByteArray());
      }
      localObject2 = localObject3;
      if (bool1)
      {
        localObject2 = localObject3;
        if (((cmd0x346.ApplyForwardFileRsp)localObject5).str_fileidcrc.has()) {
          localObject2 = ((cmd0x346.ApplyForwardFileRsp)localObject5).str_fileidcrc.get();
        }
      }
      if (((cmd0x346.ApplyForwardFileRsp)localObject5).uint64_total_space.has()) {
        l1 = ((cmd0x346.ApplyForwardFileRsp)localObject5).uint64_total_space.get();
      }
      if (((cmd0x346.ApplyForwardFileRsp)localObject5).uint64_used_space.has()) {
        l2 = ((cmd0x346.ApplyForwardFileRsp)localObject5).uint64_used_space.get();
      }
      l3 = l1;
      localObject3 = localObject2;
      bool2 = bool1;
      bool1 = true;
      localObject2 = localObject1;
      localObject1 = localObject3;
      l1 = l2;
      l2 = l3;
      break;
      bool1 = false;
      break label573;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
      bool1 = false;
    }
  }
  
  private void j(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    int i = -100003;
    boolean bool;
    if (a(paramd))
    {
      i = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      localObject1 = null;
      paramd = null;
      bool = false;
    }
    long l;
    for (;;)
    {
      if (i != 0) {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleForwardFromOfflineResponse: return " + bool + ", retCode=" + i + ", retMsg=" + paramd);
      }
      l = ((agib.d)paramc.fi).fD();
      paramc = this.app.a().b(l);
      if (paramc != null) {
        break label378;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward offline file, but entity is null!!!");
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: resp is failed[" + paramd.g.getResultCode() + "]");
        localObject1 = null;
        paramd = null;
        bool = false;
      }
      else
      {
        paramd = paramd.g.getWupBuffer();
        localObject1 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject1).mergeFrom(paramd);
          if (((cmd0x346.RspBody)localObject1).msg_apply_copy_to_rsp.has()) {
            break;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse rspBody has not hasMsgApplyDownloadAbsRsp");
          localObject1 = null;
          paramd = null;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
          localObject1 = null;
          paramd = null;
          bool = false;
        }
      }
    }
    Object localObject1 = (cmd0x346.ApplyCopyToRsp)((cmd0x346.RspBody)localObject1).msg_apply_copy_to_rsp.get();
    if (((cmd0x346.ApplyCopyToRsp)localObject1).int32_ret_code.has()) {}
    for (i = ((cmd0x346.ApplyCopyToRsp)localObject1).int32_ret_code.get();; i = 0)
    {
      if (((cmd0x346.ApplyCopyToRsp)localObject1).str_ret_msg.has()) {}
      for (paramd = ((cmd0x346.ApplyCopyToRsp)localObject1).str_ret_msg.get();; paramd = null)
      {
        if (((cmd0x346.ApplyCopyToRsp)localObject1).str_file_key.has()) {}
        for (localObject1 = ((cmd0x346.ApplyCopyToRsp)localObject1).str_file_key.get();; localObject1 = null)
        {
          bool = true;
          break;
          label378:
          Object localObject2;
          if (bool)
          {
            localObject2 = new ahau.a();
            ((ahau.a)localObject2).bJE = "send_file_suc";
            ((ahau.a)localObject2).cYX = 1;
            ahau.a(this.app.getCurrentAccountUin(), (ahau.a)localObject2);
          }
          if ((i == -6101) || (i == -7003))
          {
            paramc.status = 16;
            if ((paramc.mContext != null) && ((paramc.mContext instanceof FileManagerEntity)))
            {
              localObject2 = (FileManagerEntity)paramc.mContext;
              ((FileManagerEntity)localObject2).status = 16;
              this.app.a().u((FileManagerEntity)localObject2);
              paramc.mContext = null;
            }
            this.app.a().u(paramc);
          }
          a(l, bool, i, paramd, (String)localObject1, paramc);
          return;
        }
      }
    }
  }
  
  private boolean jE(int paramInt)
  {
    return (paramInt == 1002) || (paramInt == 1013);
  }
  
  private void k(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    WeiYunFileInfo localWeiYunFileInfo = null;
    boolean bool;
    if (a(paramd))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      i = -100001;
      bool = false;
      paramd = localWeiYunFileInfo;
    }
    while (i != 0)
    {
      bool = false;
      label66:
      paramc = ((agib.d)paramc.fi).uY();
      localWeiYunFileInfo = agmz.a(paramc);
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse, bSuccess[" + String.valueOf(bool) + "]");
      if (localWeiYunFileInfo != null) {
        this.app.a().b(bool, 20, new Object[] { Integer.valueOf(i), paramd, paramc, localWeiYunFileInfo.strFileName, Boolean.valueOf(true) });
      }
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is failed[" + paramd.g.getResultCode() + "]");
        i = -100002;
        bool = false;
        paramd = localWeiYunFileInfo;
      }
      else
      {
        paramd = paramd.g.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(paramd);
          if (localRspBody.msg_delete_file_rsp.has()) {
            break label312;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse rspBody has not hasMsgApplyDownloadAbsRsp");
          i = -100003;
          bool = false;
          paramd = localWeiYunFileInfo;
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
          i = -100003;
          bool = false;
          paramd = localWeiYunFileInfo;
        }
        continue;
        label312:
        paramd = (cmd0x346.DeleteFileRsp)localRspBody.msg_delete_file_rsp.get();
        if (!paramd.int32_ret_code.has()) {
          break label374;
        }
      }
    }
    label374:
    for (int i = paramd.int32_ret_code.get();; i = 0)
    {
      if (paramd.str_ret_msg.has()) {}
      for (paramd = paramd.str_ret_msg.get();; paramd = null)
      {
        bool = true;
        break;
        break label66;
      }
    }
  }
  
  private void l(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    agib.d locald = (agib.d)paramc.fi;
    switch (locald.Ed())
    {
    case 9: 
    default: 
      QLog.e("FileTransferHandler<FileAssistant>", 1, "handleDiscGetFileInfo: subcmd[" + locald.Ed() + "] is not implemented");
    case 4: 
    case 5: 
      return;
    case 1: 
      q(paramc, paramd);
      return;
    case 2: 
      r(paramc, paramd);
      return;
    case 3: 
      p(paramc, paramd);
      return;
    case 6: 
      m(paramc, paramd);
      return;
    case 7: 
      o(paramc, paramd);
      return;
    case 8: 
      n(paramc, paramd);
      return;
    }
    w(paramc, paramd);
  }
  
  private void m(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    String str = "";
    int i;
    boolean bool;
    if (a(paramd))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is timeout[" + paramd.g.getResultCode() + "]");
      str = null;
      i = -100001;
      bool = false;
    }
    label80:
    long l;
    for (paramd = "";; paramd = "")
    {
      if (i != 0) {
        bool = false;
      }
      if (str != null) {
        break label687;
      }
      bool = false;
      l = ((agib.d)paramc.fi).fD();
      paramc = this.app.a().b(l);
      if (paramc != null) {
        break label353;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
      return;
      if (paramd.g.getResultCode() == 1000) {
        break;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is failed[" + paramd.g.getResultCode() + "]");
      str = null;
      i = -100002;
      bool = false;
    }
    paramd = paramd.g.getWupBuffer();
    Object localObject = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x345.RspBody)localObject).mergeFrom(paramd);
        if (!((cmd0x345.RspBody)localObject).uint32_return_code.has()) {
          break label696;
        }
        i = ((cmd0x345.RspBody)localObject).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject).msg_subcmd_0x5_rsp_body.has()) {
          break label290;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: rspBody has not hasMsgApplyDownloadRsp");
        str = null;
        i = -100003;
        bool = false;
        paramd = "";
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
        str = null;
        i = -100003;
        bool = false;
        paramd = "";
      }
      break;
      label290:
      localObject = (cmd0x345.RspBody.SubCmd0x5RspBody)((cmd0x345.RspBody)localObject).msg_subcmd_0x5_rsp_body.get();
      paramd = str;
      if (((cmd0x345.RspBody.SubCmd0x5RspBody)localObject).str_ret_msg.has()) {
        paramd = ((cmd0x345.RspBody.SubCmd0x5RspBody)localObject).str_ret_msg.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x5RspBody)localObject).str_file_id.has()) {}
      for (str = ((cmd0x345.RspBody.SubCmd0x5RspBody)localObject).str_file_id.get();; str = null)
      {
        bool = true;
        break;
        label353:
        if (bool)
        {
          paramc.Uuid = str;
          paramc.setCloudType(1);
          this.app.a().b(bool, 19, new Object[] { Integer.valueOf(i), paramd, Long.valueOf(0L), Long.valueOf(0L), str, Long.valueOf(l) });
          a(l, paramc.peerUin, this.app.getCurrentAccountUin(), paramc.fileName, paramc.fileSize, str, paramc.uniseq, paramc.msgUid, null);
          this.app.a().a(paramc, 6, null);
        }
        for (;;)
        {
          this.app.a().u(paramc);
          return;
          paramc.status = 0;
          QLog.e("FileTransferHandler<FileAssistant>", 1, "nId[" + l + "],forward disc2disc faild, retCode[" + i + "], retMsg[" + paramd + "]");
          if ((i == -6101) || (i == -7003))
          {
            paramc.status = 16;
            if ((paramc.mContext != null) && ((paramc.mContext instanceof FileManagerEntity)))
            {
              localObject = (FileManagerEntity)paramc.mContext;
              ((FileManagerEntity)localObject).status = 16;
              this.app.a().u((FileManagerEntity)localObject);
              paramc.mContext = null;
            }
            this.app.a().u(paramc);
          }
          this.app.a().b(bool, 19, new Object[] { Integer.valueOf(i), paramd, Long.valueOf(0L), Long.valueOf(0L), str, Long.valueOf(l) });
        }
        label687:
        break label80;
      }
      label696:
      i = 0;
    }
  }
  
  private void n(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    String str5 = "";
    String str4 = "";
    String str3 = "";
    String str2 = "";
    String str1 = "";
    int j = 0;
    Object localObject2 = null;
    Bundle localBundle = null;
    short s2 = 0;
    short s1 = 0;
    Object localObject1 = "";
    boolean bool;
    int i;
    if (a(paramd))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool = false;
      i = -100001;
      paramd = localBundle;
    }
    label109:
    cmd0x345.RspBody localRspBody;
    for (;;)
    {
      if (i != 0)
      {
        bool = false;
        localBundle = new Bundle();
        if (paramd != null) {
          localBundle.putString("strHttpsDomain", paramd);
        }
        localBundle.putShort("httpsPort", s1);
        localBundle.putString("IPv6Dns", (String)localObject1);
        paramc = (agib.d)paramc.fi;
        if (paramc.ale())
        {
          long l = paramc.fD();
          this.app.a().b(bool, 192, new Object[] { Integer.valueOf(i), str5, str1, str4, str3, str2, Integer.valueOf(j), null, Long.valueOf(l), localBundle });
          return;
          if (paramd.g.getResultCode() != 1000)
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: resp is failed[" + paramd.g.getResultCode() + "]");
            bool = false;
            i = -100002;
            paramd = localBundle;
            continue;
          }
          paramd = paramd.g.getWupBuffer();
          localRspBody = new cmd0x345.RspBody();
        }
      }
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramd);
        if (!localRspBody.uint32_return_code.has()) {
          break label665;
        }
        i = localRspBody.uint32_return_code.get();
        if (localRspBody.msg_subcmd_0x7_rsp_body.has()) {
          break label417;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        bool = false;
        i = -100003;
        paramd = localBundle;
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
        bool = false;
        i = -100003;
        paramd = localBundle;
      }
      break;
      label417:
      localObject1 = (cmd0x345.RspBody.SubCmd0x7RspBody)localRspBody.msg_subcmd_0x7_rsp_body.get();
      str3 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_server_ip.get();
      str2 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_dns.get();
      j = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).uint32_server_port.get();
      str4 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_url.get();
      str5 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_ret_msg.get();
      str1 = "FTN5K=" + ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).bytes_cookie.get().toStringUtf8();
      paramd = localObject2;
      if (((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_https_domain.has()) {
        paramd = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_https_domain.get();
      }
      s1 = s2;
      if (((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).uint32_https_port.has()) {
        s1 = (short)((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).uint32_https_port.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_dns.has()) {}
      for (localObject1 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_dns.get();; localObject1 = "")
      {
        bool = true;
        break;
        this.app.a().b(bool, 21, new Object[] { Integer.valueOf(i), str5, str1, str4, str3, str2, Integer.valueOf(j), localBundle });
        return;
        break label109;
      }
      label665:
      i = 0;
    }
  }
  
  private void o(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    int j = -100003;
    String str = "";
    Object localObject = null;
    int i;
    if (a(paramd))
    {
      i = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: resp is timeout[" + paramd.g.getResultCode() + "]");
      paramd = "";
    }
    long l;
    for (boolean bool = false;; bool = false)
    {
      if (i != 0) {
        bool = false;
      }
      if (localObject == null) {
        bool = false;
      }
      l = ((agib.d)paramc.fi).fD();
      paramc = this.app.a().b(l);
      if (paramc != null) {
        break label347;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
      return;
      if (paramd.g.getResultCode() == 1000) {
        break;
      }
      i = -100002;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: resp is failed[" + paramd.g.getResultCode() + "]");
      paramd = "";
    }
    paramd = paramd.g.getWupBuffer();
    cmd0x345.RspBody localRspBody = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramd);
        if (!localRspBody.uint32_return_code.has()) {
          break label383;
        }
        i = localRspBody.uint32_return_code.get();
        if (localRspBody.msg_subcmd_0x6_rsp_body.has()) {
          break label284;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        paramd = "";
        bool = false;
        i = j;
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
        paramd = "";
        bool = false;
        i = j;
      }
      break;
      label284:
      localObject = (cmd0x345.RspBody.SubCmd0x6RspBody)localRspBody.msg_subcmd_0x6_rsp_body.get();
      paramd = str;
      if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_ret_msg.has()) {
        paramd = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_ret_msg.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_file_id.has()) {}
      for (localObject = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_file_id.get();; localObject = null)
      {
        bool = true;
        break;
        label347:
        paramc.status = 0;
        a(bool, paramc, (String)localObject, i, paramd, l);
        this.app.a().u(paramc);
        return;
      }
      label383:
      i = 0;
    }
  }
  
  private void p(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    String str2 = "";
    String str3 = "";
    String str4 = "";
    short s = 0;
    Object localObject3 = "";
    Bundle localBundle = new Bundle();
    long l1;
    if (jE(paramd.g.getResultCode()))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: resp is timeout[" + paramd.g.getResultCode() + "]");
      localObject2 = "";
      l1 = -100001L;
      localObject1 = "";
    }
    agib.d locald;
    long l2;
    label132:
    boolean bool;
    for (int i = 80;; i = 80)
    {
      if (l1 != 0L) {}
      locald = (agib.d)paramc.fi;
      if (l1 != -100001L) {
        break label807;
      }
      l2 = 9043L;
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label891;
      }
      bool = true;
      label148:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("internalDownloadDiscFile: return ").append(bool).append(", retCode=").append(l2).append(", strHost=").append((String)localObject2).append(", strCheckSum=");
        if (localObject1 == null) {
          break label897;
        }
        paramc = (ProtoReqManager.c)localObject1;
        label210:
        QLog.i("FileTransferHandler<FileAssistant>", 1, paramc + ", strCookie=" + str2 + ", port=" + i);
      }
      localBundle.putShort("httpsPort", s);
      localBundle.putString("IPv6Dns", (String)localObject3);
      a(locald.a(), 5013, bool, new Object[] { Long.valueOf(l2), str3, str4, localObject2, Integer.valueOf(i), localObject1, str2, Integer.valueOf(paramd.g.getAppSeq()), Long.valueOf(locald.fD()), localBundle });
      return;
      if (paramd.g.getResultCode() == 1000) {
        break;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: resp is failed[" + paramd.g.getResultCode() + "]");
      localObject2 = "";
      l1 = -100002L;
      localObject1 = "";
    }
    Object localObject1 = paramd.g.getWupBuffer();
    Object localObject2 = new cmd0x345.RspBody();
    for (;;)
    {
      String str1;
      try
      {
        ((cmd0x345.RspBody)localObject2).mergeFrom((byte[])localObject1);
        if (!((cmd0x345.RspBody)localObject2).uint32_return_code.has()) {
          break label964;
        }
        l1 = ((cmd0x345.RspBody)localObject2).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject2).msg_subcmd_0x3_rsp_body.has()) {
          break label552;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        localObject2 = "";
        l1 = -100003L;
        localObject1 = "";
        i = 80;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        localObject2 = "";
        l1 = -100003L;
        str1 = "";
        i = 80;
      }
      break;
      label552:
      localObject3 = (cmd0x345.RspBody.SubCmd0x3RspBody)((cmd0x345.RspBody)localObject2).msg_subcmd_0x3_rsp_body.get();
      if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_host.has()) {}
      for (localObject2 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_host.get();; localObject2 = "")
      {
        if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).uint32_port.has()) {}
        for (i = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).uint32_port.get();; i = 80)
        {
          if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_check_sum.has()) {}
          for (str1 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_check_sum.get();; str1 = "")
          {
            if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_cookie.has()) {}
            for (str2 = "FTN5K=" + ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_cookie.get();; str2 = "")
            {
              if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).int32_ret_code.has()) {
                l1 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).int32_ret_code.get();
              }
              if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_ret_msg.has()) {}
              for (str3 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_ret_msg.get();; str3 = "")
              {
                if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_suggest_file_name.has()) {}
                for (str4 = ahav.getFileName(((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_suggest_file_name.get());; str4 = "")
                {
                  if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_https_domain.has()) {
                    localBundle.putString("strHttpsDomain", ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_https_domain.get());
                  }
                  if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).uint32_https_port.has()) {}
                  for (s = (short)((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).uint32_https_port.get();; s = 0)
                  {
                    if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_dns.has()) {}
                    for (localObject3 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject3).str_dns.get();; localObject3 = "")
                    {
                      break;
                      label807:
                      if (l1 == -100003L)
                      {
                        l2 = 9045L;
                        break label132;
                      }
                      if ((l1 == 0L) && (localObject2 == null)) {}
                      for (int j = 1;; j = 0)
                      {
                        int k = locald.Ee();
                        l2 = l1;
                        if (j == 0) {
                          break;
                        }
                        l2 = l1;
                        if (k >= 3) {
                          break;
                        }
                        locald.dgs();
                        a(paramc.clW, paramc.fW, locald);
                        return;
                      }
                      label891:
                      bool = false;
                      break label148;
                      label897:
                      paramc = "";
                      break label210;
                    }
                  }
                }
              }
            }
          }
        }
      }
      label964:
      l1 = 0L;
    }
  }
  
  private void q(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    Object localObject2 = "";
    Object localObject3 = "";
    int i = 0;
    String str1 = "";
    String str2 = "";
    String str3 = null;
    short s = 0;
    Object localObject4 = "";
    Object localObject1;
    boolean bool;
    long l;
    if (a(paramd))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is timeout[" + paramd.g.getResultCode() + "]");
      localObject1 = "";
      bool = false;
      paramd = "";
      l = -100001L;
    }
    label106:
    Object localObject5;
    for (;;)
    {
      if (l != 0L)
      {
        bool = false;
        localObject5 = (agib.d)paramc.fi;
        if (l == -100001L)
        {
          l = 9043L;
          label129:
          paramc = new Bundle();
          if (str3 != null) {
            paramc.putString("strHttpsDomain", str3);
          }
          paramc.putShort("httpsPort", s);
          paramc.putString("IPv6Dns", (String)localObject4);
          a(((agib.d)localObject5).a(), 5015, bool, new Object[] { Long.valueOf(l), localObject1, paramd, localObject2, localObject3, Integer.valueOf(i), str1, str2, paramc });
          return;
          if (paramd.g.getResultCode() != 1000)
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is failed[" + paramd.g.getResultCode() + "]");
            localObject1 = "";
            bool = false;
            paramd = "";
            l = -100002L;
            continue;
          }
          paramd = paramd.g.getWupBuffer();
          localObject1 = new cmd0x345.RspBody();
        }
      }
    }
    for (;;)
    {
      try
      {
        ((cmd0x345.RspBody)localObject1).mergeFrom(paramd);
        if (!((cmd0x345.RspBody)localObject1).uint32_return_code.has()) {
          break label819;
        }
        l = ((cmd0x345.RspBody)localObject1).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject1).msg_subcmd_0x1_rsp_body.has()) {
          break label422;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: rspBody has not hasMsgApplyDownloadRsp");
        localObject1 = "";
        bool = false;
        paramd = "";
        l = -100003L;
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
        localObject1 = "";
        bool = false;
        paramd = "";
        l = -100003L;
      }
      break;
      label422:
      localObject4 = (cmd0x345.RspBody.SubCmd0x1RspBody)((cmd0x345.RspBody)localObject1).msg_subcmd_0x1_rsp_body.get();
      if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_file_id.has()) {}
      for (localObject1 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_file_id.get();; localObject1 = "")
      {
        if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_file_key.has()) {}
        for (localObject3 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_file_key.get();; localObject3 = "")
        {
          if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_check_sum.has()) {}
          for (paramd = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_check_sum.get();; paramd = "")
          {
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_host.has()) {}
            for (localObject2 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_host.get();; localObject2 = "")
            {
              if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).uint32_port.has()) {}
              for (i = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).uint32_port.get();; i = 0)
              {
                if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_file_name.has()) {}
                for (str1 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_file_name.get();; str1 = "")
                {
                  if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_warn.has()) {}
                  for (str2 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_warn.get();; str2 = "")
                  {
                    if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_https_domain.has()) {}
                    for (str3 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_https_domain.get();; str3 = null)
                    {
                      if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).uint32_https_port.has()) {}
                      for (s = (short)((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).uint32_https_port.get();; s = 0)
                      {
                        if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_dns.has()) {}
                        for (localObject4 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_dns.get();; localObject4 = "")
                        {
                          localObject5 = localObject3;
                          bool = true;
                          localObject3 = localObject2;
                          localObject2 = paramd;
                          paramd = (ProtoReqManager.d)localObject5;
                          break;
                          if (l == -100003L)
                          {
                            l = 9045L;
                            break label129;
                          }
                          if ((localObject3 == null) || (((String)localObject3).length() == 0)) {}
                          for (int j = 1;; j = 0)
                          {
                            int k = ((agib.d)localObject5).Ee();
                            if ((j == 0) || (k >= 3)) {
                              break;
                            }
                            ((agib.d)localObject5).dgs();
                            a(paramc.clW, paramc.fW, (agib.d)localObject5);
                            return;
                          }
                          break label129;
                          break label106;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label819:
      l = 0L;
    }
  }
  
  private void r(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    paramc = (agib.d)paramc.fi;
    long l2 = paramc.fD();
    QLog.i("FileTransferHandler<FileAssistant>", 2, "=_= ^ [Feed Replay] Id[" + l2 + "]sendDiscFeed Replay");
    boolean bool = false;
    long l1 = 0L;
    if (a(paramd))
    {
      l1 = -100001L;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay] Id[" + l2 + "]internalSendDiscFileRequest: resp is timeout[" + paramd.g.getResultCode() + "]");
      if (l1 != 0L) {
        bool = false;
      }
      if (l2 != 0L) {
        break label367;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay]why sessoinId is 0?!");
    }
    label361:
    label367:
    do
    {
      for (;;)
      {
        if ((bool) && (l2 > 0L)) {
          ahav.l(this.app, l2);
        }
        a(paramc.a(), 5016, bool, new Object[] { Long.valueOf(l1) });
        return;
        if (paramd.g.getResultCode() != 1000)
        {
          l1 = -100002L;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay] Id[" + l2 + "]internalSendDiscFileRequest: resp is failed[" + paramd.g.getResultCode() + "]");
          break;
        }
        paramd = paramd.g.getWupBuffer();
        cmd0x345.RspBody localRspBody = new cmd0x345.RspBody();
        try
        {
          localRspBody.mergeFrom(paramd);
          if (localRspBody.uint32_return_code.has()) {
            l1 = localRspBody.uint32_return_code.get();
          }
          if (localRspBody.msg_subcmd_0x2_rsp_body.has()) {
            break label361;
          }
          l1 = -100003L;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay] Id[" + l2 + "]internalSendDiscFileRequest: rspBody has not hasMsgApplyDownloadRsp");
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
          l1 = -100003L;
        }
      }
      break;
      bool = true;
      break;
      paramd = this.app.a().b(l2);
    } while (paramd == null);
    if (bool)
    {
      paramd.status = 1;
      this.app.a().a(paramd, 6, "");
    }
    for (;;)
    {
      this.app.a().u(paramd);
      break;
      QLog.e("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay]nSessionId[" + l2 + "] sendDiscFeed faild,retCode[" + l1 + "]");
      paramd.status = 0;
      a(l1, paramd);
    }
  }
  
  private void s(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^> [CS Replay]reponse V3");
    agib.b localb = new agib.b();
    List localList = null;
    boolean bool;
    int i;
    label105:
    int j;
    label125:
    Object localObject;
    if (a(paramd))
    {
      localb.retCode = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool = false;
      localb.cXe = 2;
      if ((localb.strIP == null) || (localb.strIP.length() <= 0)) {
        break label630;
      }
      i = 1;
      if ((localb.uuid != null) && (localb.uuid.length != 0)) {
        break label635;
      }
      j = 1;
      localObject = new achq.a();
      ((achq.a)localObject).errCode = localb.retCode;
      ((achq.a)localObject).retryCount = paramd.dPU;
      if ((j == 0) || (i == 0)) {
        break label641;
      }
      localb.retMsg = ("uuid_null[" + localb.toString() + "]");
      bool = false;
    }
    label641:
    for (;;)
    {
      cmd0x346.RspBody localRspBody;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool + ", retCode=" + localb.retCode + ", retMsg=" + localb.retMsg + ", totalSpace=" + localb.totalSpace + ", usedSpace=" + localb.usedSpace + ", ip=" + localb.strIP + ", port=" + localb.ag);
        }
        a(((agib.d)paramc.fi).a(), 5004, bool, new Object[] { localb, localObject, localList });
        return;
        if (paramd.g.getResultCode() != 1000)
        {
          localb.retCode = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + paramd.g.getResultCode() + "]");
          bool = false;
          break;
        }
        localObject = paramd.g.getWupBuffer();
        localb.dI = ((byte[])localObject);
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_apply_upload_rsp_v3.has()) {
            break label509;
          }
          localb.retCode = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localb.retCode = -100003;
          bool = false;
        }
      }
      break;
      label509:
      if (localRspBody.uint32_flag_use_media_platform.has()) {
        if (localRspBody.uint32_flag_use_media_platform.get() == 1)
        {
          bool = true;
          localb.bUseMediaPlatform = bool;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponseV3: bUseMediaPlatform " + localb.bUseMediaPlatform);
        }
      }
      for (;;)
      {
        label535:
        localList = a(localb, null, (cmd0x346.ApplyUploadRspV3)localRspBody.msg_apply_upload_rsp_v3.get());
        if (localb.retCode != 0) {
          break label624;
        }
        bool = true;
        break;
        bool = false;
        break label535;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponseV3: bUseMediaPlatform false uint32_flag_use_media_platform not set");
      }
      label624:
      bool = false;
      break;
      label630:
      i = 0;
      break label105;
      label635:
      j = 0;
      break label125;
    }
  }
  
  private void send(ToServiceMsg paramToServiceMsg)
  {
    P(paramToServiceMsg);
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), agif.class);
    localNewIntent.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
    this.app.startServlet(localNewIntent);
    long l = System.currentTimeMillis();
    paramToServiceMsg.extraData.putLong("sendtimekey", l);
  }
  
  private void t(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    QLog.e("FileTransferHandler<FileAssistant>", 2, "=_= ^> [CS Replay]response V2");
    agib.b localb = new agib.b();
    List localList = null;
    boolean bool;
    int i;
    label99:
    int j;
    label119:
    Object localObject;
    if (a(paramd))
    {
      localb.retCode = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool = false;
      if ((localb.strIP == null) || (localb.strIP.length() <= 0)) {
        break label529;
      }
      i = 1;
      if ((localb.uuid != null) && (localb.uuid.length != 0)) {
        break label534;
      }
      j = 1;
      localObject = new achq.a();
      ((achq.a)localObject).errCode = localb.retCode;
      ((achq.a)localObject).retryCount = paramd.dPU;
      if ((j == 0) || (i == 0)) {
        break label540;
      }
      localb.retMsg = ("uuid_null[" + localb.toString() + "]");
      bool = false;
    }
    label529:
    label534:
    label540:
    for (;;)
    {
      cmd0x346.RspBody localRspBody;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool + ", retCode=" + localb.retCode + ", retMsg=" + localb.retMsg + ", totalSpace=" + localb.totalSpace + ", usedSpace=" + localb.usedSpace + ", ip=" + localb.strIP + ", port=" + localb.ag);
        }
        a(((agib.d)paramc.fi).a(), 5004, bool, new Object[] { localb, localObject, localList });
        return;
        if (paramd.g.getResultCode() != 1000)
        {
          localb.retCode = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + paramd.g.getResultCode() + "]");
          bool = false;
          break;
        }
        localObject = paramd.g.getWupBuffer();
        localb.dI = ((byte[])localObject);
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_apply_upload_rsp_v2.has()) {
            break label503;
          }
          localb.retCode = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localb.retCode = -100003;
          bool = false;
        }
      }
      break;
      label503:
      localList = a(localb, null, (cmd0x346.ApplyUploadRspV2)localRspBody.msg_apply_upload_rsp_v2.get());
      bool = true;
      break;
      i = 0;
      break label99;
      j = 0;
      break label119;
    }
  }
  
  private void u(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^> [CS Replay] response FileHit");
    agib.b localb = new agib.b();
    boolean bool;
    int i;
    label96:
    int j;
    label116:
    Object localObject;
    if (a(paramd))
    {
      localb.retCode = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool = false;
      if ((localb.strIP == null) || (localb.strIP.length() <= 0)) {
        break label822;
      }
      i = 1;
      if ((localb.uuid != null) && (localb.uuid.length != 0)) {
        break label827;
      }
      j = 1;
      localObject = new achq.a();
      ((achq.a)localObject).errCode = localb.retCode;
      ((achq.a)localObject).retryCount = paramd.dPU;
      if ((j == 0) || (i == 0)) {
        break label833;
      }
      localb.retMsg = ("uuid_null[" + localb.toString() + "]");
      bool = false;
    }
    label822:
    label827:
    label833:
    for (;;)
    {
      cmd0x346.RspBody localRspBody;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool + ", retCode=" + localb.retCode + ", retMsg=" + localb.retMsg + ", totalSpace=" + localb.totalSpace + ", usedSpace=" + localb.usedSpace + ", ip=" + localb.strIP + ", port=" + localb.ag);
        }
        a(((agib.d)paramc.fi).a(), 5020, bool, new Object[] { localb, localObject, null });
        return;
        if (paramd.g.getResultCode() != 1000)
        {
          localb.retCode = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + paramd.g.getResultCode() + "]");
          bool = false;
          break;
        }
        localObject = paramd.g.getWupBuffer();
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_apply_upload_hit_rsp_v2.has()) {
            break label492;
          }
          localb.retCode = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localb.retCode = -100003;
          bool = false;
        }
      }
      break;
      label492:
      cmd0x346.ApplyUploadHitRspV2 localApplyUploadHitRspV2 = (cmd0x346.ApplyUploadHitRspV2)localRspBody.msg_apply_upload_hit_rsp_v2.get();
      if (localApplyUploadHitRspV2.int32_ret_code.has()) {
        localb.retCode = localApplyUploadHitRspV2.int32_ret_code.get();
      }
      if (localApplyUploadHitRspV2.str_ret_msg.has()) {
        localb.retMsg = localApplyUploadHitRspV2.str_ret_msg.get();
      }
      if (localApplyUploadHitRspV2.uint64_total_space.has()) {
        localb.totalSpace = localApplyUploadHitRspV2.uint64_total_space.get();
      }
      if (localApplyUploadHitRspV2.uint64_used_space.has()) {
        localb.usedSpace = localApplyUploadHitRspV2.uint64_used_space.get();
      }
      if (localApplyUploadHitRspV2.str_upload_ip.has()) {
        localb.strIP = localApplyUploadHitRspV2.str_upload_ip.get();
      }
      for (;;)
      {
        if (localApplyUploadHitRspV2.uint32_upload_port.has()) {
          localb.ag = ((short)localApplyUploadHitRspV2.uint32_upload_port.get());
        }
        if (localApplyUploadHitRspV2.bytes_uuid.has()) {
          localb.uuid = localApplyUploadHitRspV2.bytes_uuid.get().toByteArray();
        }
        if (localApplyUploadHitRspV2.bytes_upload_key.has()) {
          localb.key = localApplyUploadHitRspV2.bytes_upload_key.get().toByteArray();
        }
        if (localApplyUploadHitRspV2.str_upload_https_domain.has()) {
          localb.bHe = localApplyUploadHitRspV2.str_upload_https_domain.get();
        }
        if (localApplyUploadHitRspV2.uint32_upload_https_port.has()) {
          localb.ah = ((short)localApplyUploadHitRspV2.uint32_upload_https_port.get());
        }
        if (localApplyUploadHitRspV2.str_upload_dns.has()) {
          localb.bHg = localApplyUploadHitRspV2.str_upload_dns.get();
        }
        bool = true;
        break;
        if (localApplyUploadHitRspV2.str_upload_domain.has()) {
          localb.strIP = localApplyUploadHitRspV2.str_upload_domain.get();
        } else {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse has neither ip nor domain");
        }
      }
      i = 0;
      break label96;
      j = 0;
      break label116;
    }
  }
  
  private void v(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    int i = -100003;
    boolean bool2 = false;
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.i("FileTransferHandler<FileAssistant>", 2, "handleRecallResponse ");
    }
    boolean bool1;
    if (a(paramd))
    {
      i = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool1 = false;
      paramd = localObject;
    }
    for (;;)
    {
      if (i != 0)
      {
        bool1 = bool2;
        label89:
        paramc = (agmy.a)((agib.d)paramc.fi).getObject();
        if (QLog.isColorLevel()) {
          QLog.i("FileTransferHandler<FileAssistant>", 2, "handleRecallResponse [" + bool1 + "],retCode[" + i + "], retMsg[" + paramd + "]");
        }
        if (bool1)
        {
          paramc.onSuccess();
          return;
          if (paramd.g.getResultCode() != 1000)
          {
            i = -100002;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is failed[" + paramd.g.getResultCode() + "]");
            bool1 = false;
            paramd = localObject;
            continue;
          }
          paramd = paramd.g.getWupBuffer();
          cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
          try
          {
            localRspBody.mergeFrom(paramd);
            if (localRspBody.msg_recall_file_rsp.has()) {
              break label305;
            }
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse rspBody has not hasMsgApplyDownloadAbsRsp");
            bool1 = false;
            paramd = localObject;
          }
          catch (InvalidProtocolBufferMicroException paramd)
          {
            paramd.printStackTrace();
            bool1 = false;
            paramd = localObject;
          }
          continue;
          label305:
          paramd = (cmd0x346.RecallFileRsp)localRspBody.msg_recall_file_rsp.get();
          if (!paramd.int32_ret_code.has()) {
            break label376;
          }
        }
      }
    }
    label376:
    for (i = paramd.int32_ret_code.get();; i = 0)
    {
      if (paramd.str_ret_msg.has()) {}
      for (paramd = paramd.str_ret_msg.get();; paramd = null)
      {
        bool1 = true;
        break;
        paramc.onError(i, paramd);
        return;
        break label89;
      }
    }
  }
  
  private void w(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    boolean bool2 = false;
    String str = "";
    int i;
    boolean bool1;
    if (a(paramd))
    {
      i = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool1 = false;
      paramd = str;
    }
    label72:
    cmd0x345.RspBody localRspBody;
    for (;;)
    {
      if (i != 0)
      {
        bool1 = bool2;
        paramc = (agmy.a)((agib.d)paramc.fi).getObject();
        if (QLog.isColorLevel()) {
          QLog.i("FileTransferHandler<FileAssistant>", 2, "internalDeleteDiscFile [" + bool1 + "],retCode[" + i + "], retMsg[" + paramd + "]");
        }
        if (paramc == null)
        {
          QLog.e("FileTransferHandler<FileAssistant>", 1, "del disc file, but callback is null!!!,check here!!!");
          return;
          if (paramd.g.getResultCode() != 1000)
          {
            i = -100002;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is failed[" + paramd.g.getResultCode() + "]");
            bool1 = false;
            paramd = str;
            continue;
          }
          paramd = paramd.g.getWupBuffer();
          localRspBody = new cmd0x345.RspBody();
        }
      }
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramd);
        if (!localRspBody.uint32_return_code.has()) {
          break label385;
        }
        i = localRspBody.uint32_return_code.get();
        if (localRspBody.msg_subcmd_0xa_rsp_body.has()) {
          break label318;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: rspBody has not hasMsgApplyDownloadRsp");
        i = -100003;
        bool1 = false;
        paramd = str;
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
        i = -100003;
        bool1 = false;
        paramd = str;
      }
      break;
      label318:
      paramd = (cmd0x345.RspBody.SubCmd0xaRspBody)localRspBody.msg_subcmd_0xa_rsp_body.get();
      if (paramd.str_ret_msg.has()) {}
      for (paramd = paramd.str_ret_msg.get();; paramd = "")
      {
        bool1 = true;
        break;
        if (bool1)
        {
          paramc.onSuccess();
          return;
        }
        paramc.onError(i, paramd);
        return;
        break label72;
      }
      label385:
      i = 0;
    }
  }
  
  public long a(List<MessageRecord> paramList, String paramString1, String paramString2, String paramString3, long paramLong1, boolean paramBoolean, int paramInt1, String paramString4, long paramLong2, long paramLong3, String paramString5, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt3, int paramInt4, hummer_resv_21.FileImgInfo paramFileImgInfo)
  {
    paramString5 = anbi.d(paramInt3);
    paramString5.uniseq = paramLong4;
    paramString5.selfuin = this.app.getCurrentAccountUin();
    paramString5.frienduin = paramString1;
    paramString5.senderuin = paramString2;
    if ((paramString4 == null) || (paramString4.length() < 1)) {
      paramString4 = aoon.a(paramString3, paramLong1, 0, paramBoolean);
    }
    for (;;)
    {
      if (paramInt3 == -3008)
      {
        paramString5.msg = paramString3;
        paramString5.msgtype = paramInt3;
        paramString5.isread = paramBoolean;
        if (!paramString2.equals(this.app.getAccount())) {
          break label584;
        }
        paramInt2 = 1;
        label110:
        paramString5.issend = paramInt2;
        paramString5.istroop = paramInt1;
        paramString5.msgseq = paramLong2;
        paramString5.shmsgseq = anbk.d(paramLong2, paramInt1);
        paramString5.msgUid = paramLong5;
        paramString5.time = paramLong7;
        if (!paramString5.isSend()) {
          break label590;
        }
        ((acle)this.app.getBusinessHandler(13)).W(paramString5);
      }
      for (;;)
      {
        paramString5.vipBubbleDiyTextId = paramInt4;
        if (paramFileImgInfo != null)
        {
          paramString5.saveExtInfoToExtStr("file_pic_width", String.valueOf(paramFileImgInfo.uint32_file_width.get()));
          paramString5.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(paramFileImgInfo.uint32_file_height.get()));
          QLog.i("FileTransferHandler<FileAssistant>", 1, "Insert ThumbSize toMsg height[" + paramFileImgInfo.uint32_file_width.get() + "], width[" + paramFileImgInfo.uint32_file_height.get() + "]");
        }
        if (paramInt3 == -2005) {
          ((MessageForFile)paramString5).parse();
        }
        paramList.add(paramString5);
        ahav.j(this.app, paramString2, paramString1, paramInt1);
        if (this.jdField_a_of_type_Aocq == null) {
          this.jdField_a_of_type_Aocq = ((aocq)this.app.getManager(272));
        }
        if ((paramString5 instanceof MessageForFile)) {
          this.jdField_a_of_type_Aocq.Z((MessageForFile)paramString5);
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(paramString5.uniseq) + "], selfuin[" + ahav.kZ(paramString5.selfuin) + "], frienduin[" + ahav.kZ(paramString5.frienduin) + "], senderuin[" + ahav.kZ(paramString5.senderuin) + "], issend[" + String.valueOf(paramString5.issend) + "], istroop[" + String.valueOf(paramString5.istroop) + "], shmsgseq[" + String.valueOf(paramString5.shmsgseq) + "], msgUid[" + String.valueOf(paramString5.msgUid) + "], time[" + String.valueOf(paramString5.time) + "], vipBubbleID[" + String.valueOf(paramLong6) + "], bubbleDiyTextId[" + String.valueOf(paramInt4) + "]");
        return paramString5.uniseq;
        paramString3 = paramString4;
        break;
        label584:
        paramInt2 = 0;
        break label110;
        label590:
        if (paramLong6 != -1L) {
          paramString5.vipBubbleID = paramLong6;
        } else {
          paramString5.vipBubbleID = this.app.b().S(paramString1);
        }
      }
    }
  }
  
  public agnj a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed context=null");
      return null;
    }
    int i = paramArrayOfByte.length;
    agnj localagnj = new agnj();
    int j;
    if (i >= 16)
    {
      aqoj.c(paramArrayOfByte, 0, localagnj.ea, 16);
      if (i >= 28)
      {
        localagnj.sessionid = aqoj.getLongData(paramArrayOfByte, 24);
        if (i < 51) {
          break label116;
        }
        j = aqoj.b(paramArrayOfByte, 49);
        if (j >= 4) {
          break label127;
        }
        localagnj.cex = false;
        return localagnj;
      }
    }
    else
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - bufAppGuid");
      return null;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - dwSessionId");
    return null;
    label116:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - bufOther");
    return null;
    label127:
    byte[] arrayOfByte = new byte[j];
    label151:
    int k;
    int m;
    if (i >= j + 51)
    {
      aqoj.c(paramArrayOfByte, 51, arrayOfByte, j);
      i = 0;
      if (i < j)
      {
        k = arrayOfByte[i];
        m = i + 1;
        if (j < m + 2) {
          break label214;
        }
        i = aqoj.b(arrayOfByte, m);
        m += 2;
        if (k != 1) {
          break label226;
        }
      }
    }
    label214:
    label226:
    do
    {
      for (;;)
      {
        i = m + i;
        break label151;
        break;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - ismulitendpoint");
        return null;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - L");
        break;
        if ((k != 2) && (k != 3))
        {
          if (k == 4)
          {
            paramArrayOfByte = new byte[i];
            if (j >= m + i)
            {
              aqoj.c(arrayOfByte, m, paramArrayOfByte, i);
              paramArrayOfByte = a(paramArrayOfByte);
              if (paramArrayOfByte != null)
              {
                localagnj.name = paramArrayOfByte.name;
                localagnj.size = paramArrayOfByte.size;
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
          if (k != 12) {
            if (k == 15)
            {
              if (i < 1)
              {
                localagnj.cex = false;
              }
              else if (j >= m + i)
              {
                paramArrayOfByte = new byte[i];
                aqoj.c(arrayOfByte, m, paramArrayOfByte, i);
                if (paramArrayOfByte[0] == 1) {}
                for (bool = true;; bool = false)
                {
                  localagnj.cex = bool;
                  break;
                }
              }
            }
            else if (k == 17)
            {
              if (i >= 1) {
                break label415;
              }
              localagnj.cey = false;
            }
          }
        }
      }
    } while (j < m + i);
    label415:
    paramArrayOfByte = new byte[i];
    aqoj.c(arrayOfByte, m, paramArrayOfByte, i);
    if (paramArrayOfByte[0] == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localagnj.cey = bool;
      break;
    }
  }
  
  public MessageRecord a(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject = this.app.b().k(paramString1, paramInt);
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
  
  /* Error */
  public List<MessageRecord> a(MessageHandler paramMessageHandler, List<msg_comm.Msg> paramList, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 1058	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 1059	java/util/ArrayList:<init>	()V
    //   7: astore 16
    //   9: new 1058	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 1059	java/util/ArrayList:<init>	()V
    //   16: astore 17
    //   18: aload 17
    //   20: aload_2
    //   21: invokeinterface 2532 2 0
    //   26: pop
    //   27: iconst_0
    //   28: istore 7
    //   30: iload 7
    //   32: aload 17
    //   34: invokeinterface 736 1 0
    //   39: if_icmpge +784 -> 823
    //   42: aload 17
    //   44: iload 7
    //   46: invokeinterface 1065 2 0
    //   51: checkcast 2534	msf/msgcomm/msg_comm$Msg
    //   54: astore 18
    //   56: aload 18
    //   58: getfield 2538	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   61: invokevirtual 2541	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   64: checkcast 2540	msf/msgcomm/msg_comm$MsgHead
    //   67: astore_1
    //   68: aload 18
    //   70: getfield 2538	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   73: invokevirtual 2542	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   76: ifne +68 -> 144
    //   79: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +744 -> 826
    //   85: ldc 135
    //   87: iconst_2
    //   88: new 229	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 2544
    //   98: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: iload 7
    //   103: invokevirtual 1236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: ldc_w 2546
    //   109: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 609	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: iconst_1
    //   119: istore 6
    //   121: iload 6
    //   123: ifeq +12 -> 135
    //   126: aload_2
    //   127: aload 18
    //   129: invokeinterface 2549 2 0
    //   134: pop
    //   135: iload 7
    //   137: iconst_1
    //   138: iadd
    //   139: istore 7
    //   141: goto -111 -> 30
    //   144: aload_1
    //   145: getfield 2552	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   148: invokevirtual 677	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   151: i2s
    //   152: istore 9
    //   154: aload_1
    //   155: getfield 2555	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   158: invokevirtual 193	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   161: lstore 10
    //   163: aload_1
    //   164: getfield 2558	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   167: invokevirtual 677	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   170: i2l
    //   171: lstore 12
    //   173: aload_1
    //   174: getfield 2561	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   177: invokevirtual 193	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   180: lstore 14
    //   182: aload_1
    //   183: getfield 2564	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   186: invokevirtual 677	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   189: istore 6
    //   191: aload 18
    //   193: getfield 2538	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   196: invokevirtual 2541	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   199: checkcast 2540	msf/msgcomm/msg_comm$MsgHead
    //   202: getfield 2567	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   205: invokevirtual 677	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   208: istore 8
    //   210: iload 6
    //   212: invokestatic 2570	anbk:lu	(I)Z
    //   215: ifeq +21 -> 236
    //   218: aload_1
    //   219: getfield 2567	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   222: invokevirtual 676	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   225: ifeq +11 -> 236
    //   228: iload 8
    //   230: sipush 169
    //   233: if_icmpeq +23 -> 256
    //   236: iload 6
    //   238: sipush 529
    //   241: if_icmpne +9 -> 250
    //   244: iload 8
    //   246: iconst_4
    //   247: if_icmpeq +9 -> 256
    //   250: iconst_0
    //   251: istore 6
    //   253: goto -132 -> 121
    //   256: iload 6
    //   258: invokestatic 2570	anbk:lu	(I)Z
    //   261: ifeq +199 -> 460
    //   264: aload_1
    //   265: getfield 2567	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   268: invokevirtual 676	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   271: ifeq +189 -> 460
    //   274: iload 8
    //   276: sipush 169
    //   279: if_icmpne +181 -> 460
    //   282: aload 18
    //   284: getfield 2574	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   287: invokevirtual 2577	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   290: ifeq +23 -> 313
    //   293: aload 18
    //   295: getfield 2574	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   298: invokevirtual 2578	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   301: checkcast 2576	tencent/im/msg/im_msg_body$MsgBody
    //   304: getfield 2582	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   307: invokevirtual 2585	tencent/im/msg/im_msg_body$RichText:has	()Z
    //   310: ifne +74 -> 384
    //   313: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq +510 -> 826
    //   319: ldc 135
    //   321: iconst_2
    //   322: new 229	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 2587
    //   332: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 18
    //   337: getfield 2574	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   340: invokevirtual 2577	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   343: invokevirtual 607	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   346: ldc_w 2589
    //   349: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload 18
    //   354: getfield 2574	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   357: invokevirtual 2578	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   360: checkcast 2576	tencent/im/msg/im_msg_body$MsgBody
    //   363: getfield 2582	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   366: invokevirtual 2585	tencent/im/msg/im_msg_body$RichText:has	()Z
    //   369: invokevirtual 607	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   372: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 143	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: iconst_1
    //   379: istore 6
    //   381: goto -260 -> 121
    //   384: aload 18
    //   386: getfield 2574	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   389: invokevirtual 2578	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   392: checkcast 2576	tencent/im/msg/im_msg_body$MsgBody
    //   395: getfield 2582	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   398: invokevirtual 2590	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   401: checkcast 2584	tencent/im/msg/im_msg_body$RichText
    //   404: astore 19
    //   406: aload 19
    //   408: getfield 2594	tencent/im/msg/im_msg_body$RichText:not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   411: invokevirtual 2597	tencent/im/msg/im_msg_body$NotOnlineFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   414: checkcast 2596	tencent/im/msg/im_msg_body$NotOnlineFile
    //   417: astore_1
    //   418: aload 19
    //   420: getfield 2594	tencent/im/msg/im_msg_body$RichText:not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   423: invokevirtual 2598	tencent/im/msg/im_msg_body$NotOnlineFile:has	()Z
    //   426: ifne +24 -> 450
    //   429: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   432: ifeq +394 -> 826
    //   435: ldc 135
    //   437: iconst_2
    //   438: ldc_w 2600
    //   441: invokestatic 143	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: iconst_1
    //   445: istore 6
    //   447: goto -326 -> 121
    //   450: aload_1
    //   451: ifnonnull +154 -> 605
    //   454: iconst_1
    //   455: istore 6
    //   457: goto -336 -> 121
    //   460: iload 6
    //   462: sipush 529
    //   465: if_icmpne +361 -> 826
    //   468: iload 8
    //   470: iconst_4
    //   471: if_icmpne +355 -> 826
    //   474: aload 18
    //   476: getfield 2574	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   479: invokevirtual 2578	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   482: checkcast 2576	tencent/im/msg/im_msg_body$MsgBody
    //   485: getfield 2603	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   488: invokevirtual 167	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   491: invokevirtual 172	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   494: astore_1
    //   495: new 2605	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody
    //   498: dup
    //   499: invokespecial 2606	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody:<init>	()V
    //   502: astore 19
    //   504: aload 19
    //   506: aload_1
    //   507: invokevirtual 2607	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   510: checkcast 2605	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody
    //   513: astore_1
    //   514: aload_1
    //   515: getfield 2610	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody:msg_not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   518: invokevirtual 2598	tencent/im/msg/im_msg_body$NotOnlineFile:has	()Z
    //   521: ifne +70 -> 591
    //   524: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +299 -> 826
    //   530: ldc 135
    //   532: iconst_2
    //   533: ldc_w 2612
    //   536: invokestatic 143	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: iconst_1
    //   540: istore 6
    //   542: goto -421 -> 121
    //   545: astore_1
    //   546: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   549: ifeq +13 -> 562
    //   552: ldc 135
    //   554: iconst_2
    //   555: ldc_w 2614
    //   558: aload_1
    //   559: invokestatic 2617	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   562: iconst_1
    //   563: istore 6
    //   565: goto -444 -> 121
    //   568: astore_1
    //   569: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq +13 -> 585
    //   575: ldc 135
    //   577: iconst_2
    //   578: ldc_w 2619
    //   581: aload_1
    //   582: invokestatic 2617	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   585: iconst_1
    //   586: istore 6
    //   588: goto -467 -> 121
    //   591: aload_1
    //   592: getfield 2610	tencent/im/s2c/msgtype0x211/submsgtype0x4/SubMsgType0x4$MsgBody:msg_not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   595: invokevirtual 2597	tencent/im/msg/im_msg_body$NotOnlineFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   598: checkcast 2596	tencent/im/msg/im_msg_body$NotOnlineFile
    //   601: astore_1
    //   602: goto -152 -> 450
    //   605: aload_1
    //   606: getfield 2622	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   609: invokevirtual 163	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   612: ifne +24 -> 636
    //   615: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +208 -> 826
    //   621: ldc 135
    //   623: iconst_2
    //   624: ldc_w 2624
    //   627: invokestatic 143	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: iconst_1
    //   631: istore 6
    //   633: goto -512 -> 121
    //   636: aload_1
    //   637: getfield 2627	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   640: invokevirtual 677	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   643: istore 6
    //   645: aload_1
    //   646: getfield 2628	tencent/im/msg/im_msg_body$NotOnlineFile:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   649: invokevirtual 193	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   652: pop2
    //   653: aload_1
    //   654: getfield 2631	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_subcmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   657: invokevirtual 677	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   660: pop
    //   661: iload 5
    //   663: ifeq +15 -> 678
    //   666: iload 6
    //   668: iconst_1
    //   669: if_icmpne +9 -> 678
    //   672: iconst_1
    //   673: istore 6
    //   675: goto -554 -> 121
    //   678: aload_0
    //   679: iconst_0
    //   680: lload_3
    //   681: invokestatic 151	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   684: lload 10
    //   686: invokestatic 151	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   689: lload 12
    //   691: iload 9
    //   693: i2l
    //   694: lload 14
    //   696: invokevirtual 2633	agib:a	(ILjava/lang/String;Ljava/lang/String;JJJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   699: astore 19
    //   701: aload 19
    //   703: ifnull +34 -> 737
    //   706: invokestatic 361	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   709: ifeq +12 -> 721
    //   712: ldc 135
    //   714: iconst_2
    //   715: ldc_w 2519
    //   718: invokestatic 609	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: aload 16
    //   723: aload 19
    //   725: invokeinterface 1068 2 0
    //   730: pop
    //   731: iconst_1
    //   732: istore 6
    //   734: goto -613 -> 121
    //   737: iconst_0
    //   738: istore 6
    //   740: aload_1
    //   741: getfield 2636	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_reserved	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   744: invokevirtual 676	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   747: ifeq +28 -> 775
    //   750: aload_1
    //   751: getfield 2636	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_reserved	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   754: invokevirtual 677	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   757: istore 8
    //   759: iload 8
    //   761: istore 6
    //   763: iload 8
    //   765: i2l
    //   766: lload 10
    //   768: lcmp
    //   769: ifne +6 -> 775
    //   772: iconst_0
    //   773: istore 6
    //   775: aload_0
    //   776: lload_3
    //   777: invokestatic 151	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   780: aload_1
    //   781: getfield 2639	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   784: invokevirtual 167	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   787: invokevirtual 1836	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   790: iload 6
    //   792: i2l
    //   793: iload 9
    //   795: i2l
    //   796: lload 14
    //   798: aload 16
    //   800: lload 10
    //   802: invokestatic 151	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   805: invokespecial 1062	agib:a	(Ljava/lang/String;Ljava/lang/String;JJJLjava/util/List;Ljava/lang/String;)Z
    //   808: ifeq +9 -> 817
    //   811: iconst_1
    //   812: istore 6
    //   814: goto -693 -> 121
    //   817: iconst_0
    //   818: istore 6
    //   820: goto -699 -> 121
    //   823: aload 16
    //   825: areturn
    //   826: iconst_1
    //   827: istore 6
    //   829: goto -708 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	832	0	this	agib
    //   0	832	1	paramMessageHandler	MessageHandler
    //   0	832	2	paramList	List<msg_comm.Msg>
    //   0	832	3	paramLong	long
    //   0	832	5	paramBoolean	boolean
    //   119	709	6	i	int
    //   28	112	7	j	int
    //   208	556	8	k	int
    //   152	642	9	m	int
    //   161	640	10	l1	long
    //   171	519	12	l2	long
    //   180	617	14	l3	long
    //   7	817	16	localArrayList1	ArrayList
    //   16	27	17	localArrayList2	ArrayList
    //   54	421	18	localMsg	msg_comm.Msg
    //   404	320	19	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   474	495	545	java/lang/Exception
    //   504	514	568	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public cmd0x346.ApplyUploadHitReqV2 a(agzs paramagzs)
  {
    cmd0x346.ApplyUploadHitReqV2 localApplyUploadHitReqV2 = new cmd0x346.ApplyUploadHitReqV2();
    paramagzs = paramagzs.jdField_a_of_type_Agzp;
    localApplyUploadHitReqV2.uint64_sender_uin.set(paramagzs.uint64_sender_uin);
    localApplyUploadHitReqV2.uint64_recver_uin.set(paramagzs.uint64_recver_uin);
    localApplyUploadHitReqV2.uint64_file_size.set(paramagzs.uint64_file_size);
    localApplyUploadHitReqV2.str_file_name.set(paramagzs.str_file_name);
    localApplyUploadHitReqV2.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramagzs.bytes_10m_md5));
    localApplyUploadHitReqV2.bytes_3sha.set(ByteStringMicro.copyFrom(paramagzs.bytes_3sha));
    localApplyUploadHitReqV2.bytes_sha.set(ByteStringMicro.copyFrom(paramagzs.bytes_sha));
    localApplyUploadHitReqV2.str_local_filepath.set(paramagzs.str_local_filepath);
    localApplyUploadHitReqV2.uint32_danger_level.set(paramagzs.uint32_danger_level);
    localApplyUploadHitReqV2.uint64_total_space.set(paramagzs.uint64_total_space);
    return localApplyUploadHitReqV2;
  }
  
  public cmd0x346.ApplyUploadReqV2 a(agzs paramagzs)
  {
    cmd0x346.ApplyUploadReqV2 localApplyUploadReqV2 = new cmd0x346.ApplyUploadReqV2();
    paramagzs = paramagzs.jdField_a_of_type_Agzq;
    localApplyUploadReqV2.uint64_sender_uin.set(paramagzs.uint64_sender_uin);
    localApplyUploadReqV2.uint64_recver_uin.set(paramagzs.uint64_recver_uin);
    localApplyUploadReqV2.uint64_file_size.set(paramagzs.uint64_file_size);
    localApplyUploadReqV2.str_file_name.set(paramagzs.str_file_name);
    localApplyUploadReqV2.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramagzs.bytes_10m_md5));
    localApplyUploadReqV2.bytes_3sha.set(ByteStringMicro.copyFrom(paramagzs.bytes_3sha));
    localApplyUploadReqV2.str_local_filepath.set(paramagzs.str_local_filepath);
    localApplyUploadReqV2.uint32_danger_level.set(paramagzs.uint32_danger_level);
    localApplyUploadReqV2.uint64_total_space.set(paramagzs.uint64_total_space);
    return localApplyUploadReqV2;
  }
  
  public cmd0x346.ApplyUploadReqV3 a(agzs paramagzs)
  {
    cmd0x346.ApplyUploadReqV3 localApplyUploadReqV3 = new cmd0x346.ApplyUploadReqV3();
    paramagzs = paramagzs.jdField_a_of_type_Agzr;
    localApplyUploadReqV3.uint64_sender_uin.set(paramagzs.uint64_sender_uin);
    localApplyUploadReqV3.uint64_recver_uin.set(paramagzs.uint64_recver_uin);
    localApplyUploadReqV3.uint64_file_size.set(paramagzs.uint64_file_size);
    localApplyUploadReqV3.str_file_name.set(paramagzs.str_file_name);
    localApplyUploadReqV3.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramagzs.bytes_10m_md5));
    if (paramagzs.eh != null) {
      localApplyUploadReqV3.bytes_md5.set(ByteStringMicro.copyFrom(paramagzs.eh));
    }
    localApplyUploadReqV3.bytes_sha.set(ByteStringMicro.copyFrom(paramagzs.bytes_sha));
    if (paramagzs.bytes_3sha != null) {
      localApplyUploadReqV3.bytes_3sha.set(ByteStringMicro.copyFrom(paramagzs.bytes_3sha));
    }
    localApplyUploadReqV3.uint32_contenttype.set(0);
    localApplyUploadReqV3.str_local_filepath.set(paramagzs.str_local_filepath);
    localApplyUploadReqV3.uint32_danger_level.set(paramagzs.uint32_danger_level);
    localApplyUploadReqV3.uint64_total_space.set(paramagzs.uint64_total_space);
    return localApplyUploadReqV3;
  }
  
  public void a(int paramInt1, int paramInt2, agie paramagie)
  {
    Object localObject = new cmd0x346.RecvListQueryReq();
    ((cmd0x346.RecvListQueryReq)localObject).uint64_uin.set(this.app.getLongAccountUin());
    ((cmd0x346.RecvListQueryReq)localObject).uint32_begin_index.set(paramInt1);
    ((cmd0x346.RecvListQueryReq)localObject).uint32_req_count.set(paramInt2);
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.msg_recv_list_query_req.set((MessageMicro)localObject);
    localReqBody.uint32_cmd.set(100);
    localObject = localReqBody.uint32_seq;
    paramInt1 = cRe;
    cRe = paramInt1 + 1;
    ((PBUInt32Field)localObject).set(paramInt1);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    if (ald())
    {
      localReqBody.uint32_flag_support_mediaplatform.set(1);
      QLog.d("FileTransferHandler<FileAssistant>", 1, "queryRecvFileList: UseMediaPlatform enabled");
    }
    for (;;)
    {
      paramagie = new agib.d(paramagie);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECV_LIST-100", localReqBody.toByteArray(), paramagie, 10000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "queryRecvFileList: UseMediaPlatform not enabled");
    }
  }
  
  public void a(int paramInt1, int paramInt2, FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardIntrlnal : uDstId[" + String.valueOf(paramFileManagerEntity.peerUin) + "], uDstUin[" + String.valueOf(paramFileManagerEntity.selfUin) + " nDstSvcId[" + String.valueOf(paramInt1) + " uFileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + " strFileName[" + String.valueOf(paramFileManagerEntity.fileName) + " strUuid[" + String.valueOf(paramFileManagerEntity.Uuid) + "]");
    }
    if ((paramFileManagerEntity.Uuid == null) || (paramFileManagerEntity.Uuid.length() < 1) || (this.app.getAccount() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "uuid or selfUin is null!!!");
      }
      return;
    }
    Object localObject2 = new cmd0x346.ApplyCopyToReq();
    Object localObject1 = this.app.getAccount().replace("+", "");
    ((cmd0x346.ApplyCopyToReq)localObject2).uint64_dst_id.set(Long.parseLong((String)localObject1));
    if ((paramInt1 == 106) || (paramInt1 == 102) || (paramInt1 == 104)) {
      ((cmd0x346.ApplyCopyToReq)localObject2).uint64_dst_id.set(Long.parseLong(paramFileManagerEntity.peerUin));
    }
    ((cmd0x346.ApplyCopyToReq)localObject2).uint32_dst_svcid.set(paramInt1);
    ((cmd0x346.ApplyCopyToReq)localObject2).uint64_src_uin.set(Long.parseLong((String)localObject1));
    ((cmd0x346.ApplyCopyToReq)localObject2).uint64_file_size.set(paramFileManagerEntity.fileSize);
    ((cmd0x346.ApplyCopyToReq)localObject2).str_file_name.set(paramFileManagerEntity.fileName);
    ((cmd0x346.ApplyCopyToReq)localObject2).bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    localObject1 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject1).msg_apply_copy_to_req.set((MessageMicro)localObject2);
    ((cmd0x346.ReqBody)localObject1).uint32_cmd.set(60100);
    localObject2 = ((cmd0x346.ReqBody)localObject1).uint32_seq;
    paramInt1 = cRe;
    cRe = paramInt1 + 1;
    ((PBUInt32Field)localObject2).set(paramInt1);
    ((cmd0x346.ReqBody)localObject1).uint32_business_id.set(paramInt2);
    ((cmd0x346.ReqBody)localObject1).uint32_client_type.set(104);
    paramFileManagerEntity = new agib.d(false, paramFileManagerEntity.nSessionId);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", ((cmd0x346.ReqBody)localObject1).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
  }
  
  public void a(int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    a(paramInt, 3, paramFileManagerEntity);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt2, String paramString3, agnj paramagnj, long paramLong2, int paramInt3)
  {
    if (!a(paramagnj)) {
      return;
    }
    switch (paramInt1)
    {
    case 130: 
    case 132: 
    default: 
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramagnj.sessionid + "] handleOnLineFilePushMsg. error cmd:" + paramInt1);
      return;
    case 129: 
      QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramagnj.sessionid + "] handle cmd 0x81. request");
      this.app.a().a(paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramagnj, paramLong2, paramInt3);
      return;
    case 131: 
      QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramagnj.sessionid + "] handle cmd 0x83. accept");
      this.app.a().q(paramString1, paramagnj.sessionid, 1);
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramagnj.sessionid + "] handle cmd 0x85. cancel.type:" + paramagnj.aj + " reason:" + paramagnj.ak);
    if (2 == paramagnj.aj)
    {
      this.app.a().q(paramString1, paramagnj.sessionid, 2);
      return;
    }
    if (1 == paramagnj.aj)
    {
      if (57 == paramagnj.ak)
      {
        this.app.a().q(paramString1, paramagnj.sessionid, 5);
        return;
      }
      if (70 == paramagnj.ak)
      {
        this.app.a().al(paramString1, paramagnj.sessionid);
        return;
      }
      if (71 == paramagnj.ak)
      {
        this.app.a().q(paramString1, paramagnj.sessionid, 4);
        return;
      }
      if (5 == paramagnj.ak)
      {
        this.app.a().q(paramString1, paramagnj.sessionid, 2);
        return;
      }
      if (paramagnj.ak == 0)
      {
        this.app.a().q(paramString1, paramagnj.sessionid, 3);
        return;
      }
      if (58 == paramagnj.ak)
      {
        this.app.a().al(paramString1, paramagnj.sessionid);
        return;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramagnj.sessionid + "] canceltype:1.unkonw reason:" + paramagnj.ak);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramagnj.sessionid + "] unknow canceltype:" + paramagnj.aj);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean, agzs paramagzs, agie paramagie, FileManagerEntity paramFileManagerEntity)
  {
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramInt);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    Object localObject = localReqBody.uint32_seq;
    int i = cRe;
    cRe = i + 1;
    ((PBUInt32Field)localObject).set(i);
    QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + paramFileManagerEntity.nSessionId + "], send pb uMsgSubType[" + paramInt + "]");
    switch (paramInt)
    {
    default: 
      QLog.e("FileTransferHandler<FileAssistant>", 2, "=_= ^! SessionId[" + paramFileManagerEntity.nSessionId + "]send0x346Req, unknwon nCmdType:" + paramInt);
      return;
    case 1600: 
      localObject = a(paramagzs);
      localReqBody.msg_apply_upload_req_v2.set((MessageMicro)localObject);
      paramagie = new agib.d(paramagzs.jdField_a_of_type_Agzq.bytes_10m_md5, null, paramagzs.jdField_a_of_type_Agzq.bytes_3sha, paramagie);
      paramagzs = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600";
    }
    for (;;)
    {
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
        ((cmd0x346.ExtensionReq)localObject).uint64_type.set(paramFileManagerEntity.tmpSessionType);
        if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
          ((cmd0x346.ExtensionReq)localObject).bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
        }
        if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
          ((cmd0x346.ExtensionReq)localObject).str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
        }
        QLog.e("FileTransferHandler<FileAssistant>", 2, "=_= ^> SessionId[" + paramFileManagerEntity.nSessionId + "]send0x346Req, add TempInfo:" + paramFileManagerEntity.tmpSessionType);
        localReqBody.msg_extension_req.set((MessageMicro)localObject);
      }
      if (paramBoolean) {
        localReqBody.uint32_flag_support_mediaplatform.set(1);
      }
      a(paramagzs, localReqBody.toByteArray(), paramagie);
      return;
      localObject = a(paramagzs);
      localReqBody.msg_apply_upload_req_v3.set((MessageMicro)localObject);
      paramagie = new agib.d(paramagzs.jdField_a_of_type_Agzr.bytes_10m_md5, paramagzs.jdField_a_of_type_Agzr.bytes_sha, null, paramagie);
      paramagzs = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700";
      continue;
      localObject = a(paramagzs);
      localReqBody.msg_apply_upload_hit_req_v2.set((MessageMicro)localObject);
      paramagie = new agib.d(paramagzs.jdField_a_of_type_Agzp.bytes_10m_md5, paramagzs.jdField_a_of_type_Agzp.bytes_sha, null, paramagie);
      paramagzs = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800";
    }
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, String paramString2, agie paramagie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "getDiscFile : String[" + paramString2 + "], nDiscId[" + paramLong2 + "]");
    }
    paramString1 = new cmd0x345.ReqBody.SubCmd0x3ReqBody();
    paramString1.uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    paramString1.str_file_id.set(paramString2);
    paramString1.uint64_disscus_uin.set(paramLong2);
    paramString1.uint32_costom_id.set(0);
    paramString2 = new cmd0x345.ReqBody();
    paramString2.msg_subcmd_0x3_req_body.set(paramString1);
    paramString2.uint32_sub_cmd.set(3);
    paramString1 = new agib.d(false, paramLong1, paramagie, 3);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString2.toByteArray(), paramString1);
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
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
    paramString2 = new agib.d(false, paramLong1, null, 6);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4, long paramLong3, long paramLong4, agie paramagie)
  {
    cmd0x345.ReqBody.SubCmd0x2ReqBody localSubCmd0x2ReqBody = new cmd0x345.ReqBody.SubCmd0x2ReqBody();
    int i = (int)Long.parseLong(paramString1);
    localSubCmd0x2ReqBody.uint32_disscus_uin.set(i);
    i = (int)Long.parseLong(paramString2);
    localSubCmd0x2ReqBody.uint32_sender_uin.set(i);
    localSubCmd0x2ReqBody.str_file_name.set(paramString3);
    localSubCmd0x2ReqBody.uint64_file_size.set(paramLong2);
    localSubCmd0x2ReqBody.str_file_id.set(paramString4);
    paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
    localSubCmd0x2ReqBody.str_batch_id.set(paramString1);
    paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
    localSubCmd0x2ReqBody.str_batch_item_id.set(paramString1);
    localSubCmd0x2ReqBody.uint64_time.set(anaz.gQ());
    localSubCmd0x2ReqBody.uint32_busid.set(106);
    paramString1 = this.app.a().b(paramLong1);
    int j;
    if (paramString1 != null)
    {
      j = 0;
      paramString2 = new hummer_resv_21.ResvAttr();
      i = j;
      if (ahav.getFileType(paramString1.fileName) == 5)
      {
        i = j;
        if (!TextUtils.isEmpty(paramString1.strApkPackageName))
        {
          paramString3 = new hummer_resv_21.FileApkInfo();
          paramString3.str_package_name.set(paramString1.strApkPackageName);
          paramString3.str_version.set("");
          paramString2.file_apk_info.set(paramString3);
          i = 1;
        }
      }
      if (paramString1.nFileType != 0)
      {
        j = i;
        if (paramString1.nFileType != 2) {}
      }
      else
      {
        ahav.K(paramString1);
        if ((paramString1.imgHeight <= 0) || (paramString1.imgWidth <= 0)) {
          break label420;
        }
        paramString3 = new hummer_resv_21.FileImgInfo();
        paramString3.uint32_file_height.set(paramString1.imgHeight);
        paramString3.uint32_file_width.set(paramString1.imgWidth);
        paramString2.file_image_info.set(paramString3);
        j = 1;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "send Disc Feeds setThumbSize height[" + paramString1.imgHeight + "], width[" + paramString1.imgWidth + "]");
      }
    }
    for (;;)
    {
      if (j != 0) {
        localSubCmd0x2ReqBody.bytes_pb_bytes_reserve.set(ByteStringMicro.copyFrom(paramString2.toByteArray()));
      }
      if ((paramLong4 != 0L) || (!QLog.isDevelopLevel())) {
        break;
      }
      throw new NullPointerException();
      label420:
      j = i;
      if (!paramString1.hasNoThumb()) {
        if (paramString1.nFileType != 0)
        {
          j = i;
          if (paramString1.nFileType != 2) {}
        }
        else
        {
          new Handler(Looper.getMainLooper()).postDelayed(new FileTransferHandler.12(this, paramString1), 1000L);
          j = i;
        }
      }
    }
    i = anbk.ab(paramLong4);
    localSubCmd0x2ReqBody.uint32_random.set(i);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x2_req_body.set(localSubCmd0x2ReqBody);
    paramString1.uint32_sub_cmd.set(2);
    QLog.i("FileTransferHandler<FileAssistant>", 2, "=_= ^ [Disc Feed]send Disc Feed[" + paramLong1 + "]");
    paramString2 = new agib.d(false, paramLong1, paramagie, 2);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, agie paramagie)
  {
    cmd0x346.ApplyDownloadReq localApplyDownloadReq = new cmd0x346.ApplyDownloadReq();
    localApplyDownloadReq.uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localApplyDownloadReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    int i;
    if (paramBoolean)
    {
      i = 1;
      localApplyDownloadReq.uint32_owner_type.set(i);
      paramString1 = new cmd0x346.ReqBody();
      paramString1.msg_apply_download_req.set(localApplyDownloadReq);
      paramString1.uint32_cmd.set(1200);
      Object localObject = paramString1.uint32_seq;
      i = cRe;
      cRe = i + 1;
      ((PBUInt32Field)localObject).set(i);
      paramString1.uint32_business_id.set(3);
      paramString1.uint32_client_type.set(104);
      localObject = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject).uint32_download_url_type.set(1);
      paramString1.msg_extension_req.set((MessageMicro)localObject);
      if (!ald()) {
        break label248;
      }
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label236;
      }
      localApplyDownloadReq.str_fileidcrc.set(paramString2);
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getC2CThumbDownloadInfo: UseMediaPlatform endabled");
    }
    for (;;)
    {
      paramString2 = new agib.d(paramLong, paramagie);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", paramString1.toByteArray(), paramString2);
      return;
      i = 2;
      break;
      label236:
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getC2CThumbDownloadInfo: UseMediaPlatform endabled but FileIdCrc is null");
      continue;
      label248:
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getC2CThumbDownloadInfo: UseMediaPlatform not enabled");
    }
  }
  
  public final void a(agie paramagie, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramagie != null)
    {
      Message localMessage = handler.obtainMessage();
      localMessage.what = paramInt;
      localMessage.obj = new Object[] { paramagie, Boolean.valueOf(paramBoolean), paramObject };
      localMessage.sendToTarget();
      QLog.i("FileTransferHandler<FileAssistant>", 1, "notifyUI. sendToTarget[" + paramBoolean + "] .type=" + paramInt);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find observer .type=" + paramInt);
  }
  
  public void a(agzw paramagzw, agie paramagie, FileManagerEntity paramFileManagerEntity)
  {
    agzs localagzs = a(paramagzw);
    paramFileManagerEntity.strFileSha3 = agoy.t(paramagzw.el);
    a(1L, paramagzw.cYU, paramagzw.bUseMediaPlatform, localagzs, paramagie, paramFileManagerEntity);
  }
  
  public void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, im_msg_body.NotOnlineFile paramNotOnlineFile, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt, hummer_resv_21.FileImgInfo paramFileImgInfo)
  {
    a(paramMessageHandler, paramList, paramMsg, paramNotOnlineFile, paramString, paramBoolean1, paramBoolean2, paramLong, paramInt, paramFileImgInfo, null);
  }
  
  public void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, im_msg_body.NotOnlineFile paramNotOnlineFile, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt, hummer_resv_21.FileImgInfo paramFileImgInfo, hummer_resv_21.ResvAttr paramResvAttr)
  {
    anbm localanbm = null;
    if (paramMsg.msg_head.c2c_tmp_msg_head.has()) {
      localanbm = ancb.a(paramMsg, this.app);
    }
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    if (!paramNotOnlineFile.bytes_file_name.has()) {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not fileName");
      }
    }
    label557:
    do
    {
      String str2;
      int k;
      long l3;
      String str3;
      String str4;
      do
      {
        do
        {
          do
          {
            return;
            str2 = ahav.getFileName(paramNotOnlineFile.bytes_file_name.get().toStringUtf8());
            k = paramNotOnlineFile.uint32_file_type.get();
            l3 = paramNotOnlineFile.uint64_file_size.get();
            i = paramNotOnlineFile.uint32_subcmd.get();
            str3 = agoy.t(paramNotOnlineFile.bytes_file_md5.get().toByteArray());
            localObject1 = String.valueOf(l4);
            localObject2 = this.app.getCurrentAccountUin();
            if (paramNotOnlineFile.bytes_file_uuid.has())
            {
              str1 = paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "offline file come, msgTime[" + l2 + "] msgSeq[" + s + "] msgUid[" + l1 + "]  fileName[" + str2 + "] uuid[" + str1 + "] fileType[" + k + "] subCmd[" + i + "] strMd5[" + str3 + "]");
              }
            }
            if (k != 1) {
              break label557;
            }
            if ((!paramBoolean1) && (!((String)localObject1).equalsIgnoreCase((String)localObject2))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("FileTransferHandler<FileAssistant>", 2, "Recv a file receipt file name: " + str2 + "don't need to handle because isPullRoam[" + paramBoolean2 + "],senderuin[" + (String)localObject1 + "]");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "Recv a file receipt file name: " + str2 + "type[" + k + "]. insert tips into aio");
          }
          paramMessageHandler = aoon.a(aojs.a(this.app.getAccount(), str2, 0, null), l3, 0, false, null);
          l4 = anbi.d(-2005).uniseq;
          a(paramList, paramString, (String)localObject1, str2, l3, paramBoolean1, 0, paramMessageHandler, s, s, "", k, l4, l1, paramLong, l2, -3008, paramInt, paramFileImgInfo);
          return;
          if (paramNotOnlineFile.bytes_file_uuid.has()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not uuid");
        return;
        localObject1 = new String(paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8() + l2);
        if (QLog.isDevelopLevel()) {
          QLog.i("FileTransferHandler<FileAssistant>", 2, "offline file come:fileName[" + str2 + "]");
        }
        str4 = paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8();
        if ((!paramMessageHandler.a().kJ((String)localObject1)) || (paramBoolean2)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "isPullRoam[false] and local already recv.  fileName[" + str2 + "] uuid[" + str4 + "] fileType[" + k + "] subCmd[" + i + "]");
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("FileTransferHandler<FileAssistant>", 2, "offline file come:fileName[" + str2 + "] Filtered");
      return;
      int i = 0;
      if (paramNotOnlineFile.uint32_reserved.has())
      {
        int j = paramNotOnlineFile.uint32_reserved.get();
        i = j;
        if (j == l4) {
          i = 0;
        }
      }
      if (i != 0) {
        ThreadManager.executeOnSubThread(new FileTransferHandler.3(this, paramString, i, s, l1, l2));
      }
      if ((paramBoolean2) && (paramBoolean1))
      {
        localObject1 = a(0, paramString, String.valueOf(l4), l2, s, l1);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
          }
          paramMessageHandler = anbi.d(-2005);
          paramMessageHandler.msgtype = -2005;
          paramMessageHandler.msg = ((MessageRecord)localObject1).msg;
          ((MessageForFile)paramMessageHandler).parse();
          paramMessageHandler.uniseq = ((MessageRecord)localObject1).uniseq;
          paramList.add(paramMessageHandler);
          return;
        }
      }
      Object localObject1 = this.app.a().eV().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if ((((FileManagerEntity)localObject2).Uuid != null) && (((FileManagerEntity)localObject2).Uuid.replace("/offline", "").equalsIgnoreCase(str4.replace("/offline", ""))))
        {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "uuid is compare memory!");
          return;
        }
      }
      if (l3 == 0L) {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "<---decodeC2CMsgPkg_MsgType0x211:fileType[" + k + "], UUID[" + str4 + "], filename[" + str2 + "], fileSize[" + l3 + "]");
      }
      localObject1 = null;
      if (paramNotOnlineFile.str_fileidcrc_media.has())
      {
        localObject1 = paramNotOnlineFile.str_fileidcrc_media.get();
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleOffLineFileMsg UUID[" + str4 + "], FileIdCrc[" + (String)localObject1 + "], filename[" + str2 + "], fileSize[" + l3 + "]");
      }
      String str1 = null;
      Object localObject2 = str1;
      if (paramResvAttr != null)
      {
        localObject2 = str1;
        if (paramResvAttr.file_apk_info.has()) {
          localObject2 = (hummer_resv_21.FileApkInfo)paramResvAttr.file_apk_info.get();
        }
      }
      a(paramMessageHandler, paramList, paramString, String.valueOf(l4), l2, s, paramBoolean1, paramBoolean2, k, str4, (String)localObject1, str2, l3, i, paramLong, l1, str3, localanbm, paramInt, paramFileImgInfo, paramNotOnlineFile.bytes_pb_reserve.get().toByteArray(), paramNotOnlineFile.bytes_note.get().toStringUtf8(), (hummer_resv_21.FileApkInfo)localObject2);
    } while (((localanbm == null) || (localanbm.friendType != 1024)) && (!jou.z(BaseApplicationImpl.getContext(), String.valueOf(l4))));
    asih.a(this.app, paramList, paramNotOnlineFile, paramMsg, localanbm);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, agmy.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileTransferHandler<FileAssistant>", 2, "revertC2CFile ");
    }
    cmd0x346.RecallFileReq localRecallFileReq = new cmd0x346.RecallFileReq();
    localRecallFileReq.uint64_uin.set(this.app.getLongAccountUin());
    localRecallFileReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.msg_recall_file_req.set(localRecallFileReq);
    localReqBody.uint32_cmd.set(400);
    PBUInt32Field localPBUInt32Field = localReqBody.uint32_seq;
    int i = cRe;
    cRe = i + 1;
    localPBUInt32Field.set(i);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    if (ald())
    {
      localReqBody.uint32_flag_support_mediaplatform.set(1);
      if ((paramFileManagerEntity.fileIdCrc != null) && (paramFileManagerEntity.fileIdCrc.length() > 0))
      {
        localRecallFileReq.str_fileidcrc.set(paramFileManagerEntity.fileIdCrc);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "revertC2CFile: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramFileManagerEntity = new agib.d();
      agib.d.a(paramFileManagerEntity, parama);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400", localReqBody.toByteArray(), paramFileManagerEntity, 10000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "revertC2CFile: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "revertC2CFile: UseMediaPlatform not enabled");
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, String paramString3, agie paramagie)
  {
    a(paramFileManagerEntity, paramString1, paramString2, paramString3, false, null, paramagie);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, agie paramagie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "setUploadSuccState : selfUin[" + ahav.kZ(paramString1) + "], toUin[" + ahav.kZ(paramString2) + "], filePath[" + paramString3 + "]");
    }
    cmd0x346.UploadSuccReq localUploadSuccReq = new cmd0x346.UploadSuccReq();
    localUploadSuccReq.uint64_sender_uin.set(Long.parseLong(paramString1));
    paramString1 = paramString2.replace("+", "");
    localUploadSuccReq.uint64_recver_uin.set(Long.parseLong(paramString1));
    localUploadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    if (paramBoolean)
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString4 != null) && (paramString4.length() > 0))
      {
        localUploadSuccReq.str_fileidcrc.set(paramString4);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "setUploadSuccStateEx: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramString1.msg_upload_succ_req.set(localUploadSuccReq);
      paramString1.uint32_cmd.set(800);
      paramString2 = paramString1.uint32_seq;
      int i = cRe;
      cRe = i + 1;
      paramString2.set(i);
      paramString1.uint32_business_id.set(3);
      paramString1.uint32_client_type.set(104);
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        paramString2 = new cmd0x346.ExtensionReq();
        paramString2.uint64_id.set(3L);
        paramString2.uint64_type.set(paramFileManagerEntity.tmpSessionType);
        if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
          paramString2.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
        }
        if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
          paramString2.str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
        }
        paramString1.msg_extension_req.set(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "setUploadSuccState : addtempinfo SessionType[" + paramFileManagerEntity.tmpSessionType + "], sessionId[" + paramFileManagerEntity.nSessionId + "]");
        }
      }
      paramFileManagerEntity = new agib.d(paramagie);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", paramString1.toByteArray(), paramFileManagerEntity, 30000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "setUploadSuccStateEx: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "setUploadSuccStateEx: UseMediaPlatform not enabled");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, long paramLong)
  {
    boolean bool = true;
    long l2 = paramFromServiceMsg.getResultCode();
    long l1;
    if ((l2 == 1002L) || (l2 == 1013L))
    {
      l1 = -100001L;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleOffLineFileSendCCSuccess: resp is timeout[" + paramFromServiceMsg + "]");
      if (l1 != -100001L) {
        break label172;
      }
    }
    label172:
    for (int i = 1;; i = 0)
    {
      int j = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if ((i == 0) || (j >= 3)) {
        break label178;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", j + 1);
      return;
      l1 = l2;
      if (l2 == 1000L) {
        break;
      }
      l1 = -100002L;
      bool = false;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleOffLineFileSendCCSuccess: resp is failed[" + paramFromServiceMsg + "]");
      break;
    }
    label178:
    l2 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
    if ((l2 != 0L) && (l2 != 241L))
    {
      bool = false;
      l1 = l2;
    }
    for (;;)
    {
      if ((bool) && (paramLong > 0L))
      {
        ahav.l(this.app, paramLong);
        Object localObject = this.app.a().c(paramLong);
        if (localObject != null)
        {
          l2 = ahav.d(this.app, ((FileManagerEntity)localObject).fileName);
          if (((FileManagerEntity)localObject).fileSize > l2) {
            break label406;
          }
          localObject = this.app.a(((FileManagerEntity)localObject).peerType).a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).uniseq);
          ((aocq)this.app.getManager(272)).aE((MessageRecord)localObject);
        }
      }
      for (;;)
      {
        l2 = paramToServiceMsg.extraData.getLong("uniseq");
        notifyUI(paramToServiceMsg, 5014, bool, new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Integer.valueOf(paramFromServiceMsg.getAppSeq()), Long.valueOf(paramLong), Long.valueOf(l2) });
        wte.a().h(this.app, l2);
        return;
        label406:
        if (QLog.isColorLevel()) {
          QLog.e("AIOMessageSpreadManager", 1, "can't find File Msg sID:" + paramLong);
        }
      }
    }
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, String paramString2, long paramLong2)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FileTransferHandler.11(this, paramLong1, paramString1, paramInt, paramString2, paramLong2));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "] upload competed:");
    this.app.a().b(paramString1, paramLong1, paramInt, paramString2, paramLong2);
  }
  
  public void a(String paramString1, String paramString2, aojs.a parama, long paramLong1, short paramShort, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "--->>getOffLineFile--toUin: " + paramString2 + " filePath: " + parama.serverPath + " delUin: " + paramLong2);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("TransService.ReqOffFilePack");
    localToServiceMsg.extraData.putString("selfuin", this.app.getCurrentAccountUin());
    localToServiceMsg.extraData.putString("uin", paramString2);
    localToServiceMsg.extraData.putByteArray("filepath", parama.serverPath.getBytes());
    localToServiceMsg.extraData.putInt("offfile_type", 0);
    localToServiceMsg.extraData.putLong("msgTime", paramLong1);
    localToServiceMsg.extraData.putShort("msgSeq", paramShort);
    localToServiceMsg.extraData.putLong("delUin", paramLong2);
    localToServiceMsg.extraData.putByte("type", parama.type);
    localToServiceMsg.extraData.putInt("retryIndex", 0);
    localToServiceMsg.extraData.putString("friendUin", paramString1);
    localToServiceMsg.extraData.putBoolean("isRead", paramBoolean);
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, agie paramagie)
  {
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
    paramString2 = new agib.d(false, 0L, paramagie, 1);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, agmy.a parama)
  {
    cmd0x345.ReqBody.SubCmd0xaReqBody localSubCmd0xaReqBody = new cmd0x345.ReqBody.SubCmd0xaReqBody();
    try
    {
      localSubCmd0xaReqBody.uint64_disscus_uin.set(Long.parseLong(paramString1));
      localSubCmd0xaReqBody.uint64_uin.set(Long.parseLong(paramString2));
      localSubCmd0xaReqBody.str_file_id.set(paramString3);
      paramString1 = new cmd0x345.ReqBody();
      paramString1.msg_subcmd_0xa_req_body.set(localSubCmd0xaReqBody);
      paramString1.uint32_sub_cmd.set(10);
      paramString2 = new agib.d();
      agib.d.a(paramString2, 10);
      agib.d.a(paramString2, parama);
      a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      parama.onError(-1, paramString1.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, agie paramagie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "setDownloadSuccState : selfUin[" + ahav.kZ(paramString1) + "], filePath[" + paramString2 + "]");
    }
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(paramString1));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_download_succ_req.set(localDownloadSuccReq);
    paramString1.uint32_cmd.set(1000);
    paramString2 = paramString1.uint32_seq;
    int i = cRe;
    cRe = i + 1;
    paramString2.set(i);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (paramBoolean)
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString3 != null) && (paramString3.length() > 0))
      {
        localDownloadSuccReq.str_fileidcrc.set(paramString3);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "setDownloadSuccState: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramString2 = new agib.d(paramagie);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000", paramString1.toByteArray(), paramString2, 30000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "setDownloadSuccState: UseMediaPlatform enabled, but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "setDownloadSuccState: UseMediaPlatform not enabled");
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, agie paramagie)
  {
    cmd0x346.ApplyDownloadReq localApplyDownloadReq = new cmd0x346.ApplyDownloadReq();
    localApplyDownloadReq.uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localApplyDownloadReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    int i;
    if (paramBoolean1)
    {
      i = 1;
      localApplyDownloadReq.uint32_owner_type.set(i);
      if (paramBoolean2) {
        localApplyDownloadReq.uint32_need_https_url.set(1);
      }
      paramString1 = new cmd0x346.ReqBody();
      if (!ald()) {
        break label250;
      }
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label238;
      }
      localApplyDownloadReq.str_fileidcrc.set(paramString2);
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getDownloadInfo: UseMediaPlatform enabled");
    }
    for (;;)
    {
      paramString1.msg_apply_download_req.set(localApplyDownloadReq);
      paramString1.uint32_cmd.set(1200);
      paramString2 = paramString1.uint32_seq;
      i = cRe;
      cRe = i + 1;
      paramString2.set(i);
      paramString1.uint32_business_id.set(3);
      paramString1.uint32_client_type.set(104);
      paramString2 = new cmd0x346.ExtensionReq();
      paramString2.uint32_download_url_type.set(1);
      paramString1.msg_extension_req.set(paramString2);
      paramString2 = new agib.d(paramagie);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", paramString1.toByteArray(), paramString2);
      return;
      i = 2;
      break;
      label238:
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getDownloadInfo: UseMediaPlatform enabled, but FileIdCrc is null");
      continue;
      label250:
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getDownloadInfo: UseMediaPlatform not enabled");
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, agib.d paramd)
  {
    ProtoReqManager.c localc = new ProtoReqManager.c();
    localc.clW = paramString;
    localc.fW = paramArrayOfByte;
    localc.fi = paramd;
    a(localc);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, agib.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    ProtoReqManager.c localc = new ProtoReqManager.c();
    localc.clW = paramString;
    localc.fW = paramArrayOfByte;
    localc.fi = paramd;
    localc.daB = paramInt1;
    localc.tryCount = paramInt2;
    localc.dPR = paramInt3;
    a(localc);
  }
  
  public boolean a(agnj paramagnj)
  {
    if (paramagnj != null)
    {
      if ((dG.equals(paramagnj.ea)) || (!paramagnj.cex)) {
        QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramagnj.sessionid + "]  is not surpport mulitendpoint");
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
    synchronized (this.ky)
    {
      paramFMTransC2CMsgInfo.observerSeq = this.observerSeq;
      this.ky.put(Long.valueOf(this.observerSeq), paramFMTransC2CMsgInfo.fileTransferObserver);
      this.observerSeq += 1L;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "send0x211c2cMsg transC2CMsgInfo:" + paramFMTransC2CMsgInfo.toString());
      }
      return this.app.a().a().a(paramString, paramInt1, paramArrayOfByte, paramFMTransC2CMsgInfo);
    }
  }
  
  public boolean a(String paramString, FileManagerEntity paramFileManagerEntity, agie paramagie)
  {
    Object localObject1 = this.app.b().b(paramString, 0, paramFileManagerEntity.uniseq);
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
    if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
      ((im_msg_body.NotOnlineFile)localObject2).bytes_file_md5.set(ByteStringMicro.copyFrom(aqhs.hexStr2Bytes(paramFileManagerEntity.strFileMd5)));
    }
    ((im_msg_body.NotOnlineFile)localObject2).uint32_subcmd.set(1);
    if (paramFileManagerEntity.bUseMediaPlatform) {
      if ((paramFileManagerEntity.fileIdCrc != null) && (paramFileManagerEntity.fileIdCrc.length() > 0))
      {
        ((im_msg_body.NotOnlineFile)localObject2).str_fileidcrc_media.set(paramFileManagerEntity.fileIdCrc);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "sendC2COfflineFileMsg: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      ((SubMsgType0x4.MsgBody)localObject1).msg_not_online_file.set((MessageMicro)localObject2);
      if (!TextUtils.isEmpty(paramFileManagerEntity.yybApkPackageName))
      {
        localObject2 = new hummer_resv_21.ResvAttr();
        hummer_resv_21.FileApkInfo localFileApkInfo = new hummer_resv_21.FileApkInfo();
        if (!TextUtils.isEmpty(paramFileManagerEntity.yybApkPackageName)) {
          localFileApkInfo.str_package_name.set(paramFileManagerEntity.yybApkPackageName);
        }
        if (!TextUtils.isEmpty(paramFileManagerEntity.yybApkName)) {
          localFileApkInfo.str_app_name.set(paramFileManagerEntity.yybApkName);
        }
        if (!TextUtils.isEmpty(paramFileManagerEntity.yybApkIconUrl)) {
          localFileApkInfo.str_icon_url.set(paramFileManagerEntity.yybApkIconUrl);
        }
        ((hummer_resv_21.ResvAttr)localObject2).file_apk_info.set(localFileApkInfo);
        ((SubMsgType0x4.MsgBody)localObject1).resv_attr.set((MessageMicro)localObject2);
      }
      ThreadManager.executeOnSubThread(new FileTransferHandler.7(this, paramFileManagerEntity, new hummer_resv_21.FileImgInfo(), (SubMsgType0x4.MsgBody)localObject1, paramagie, new Handler(Looper.getMainLooper()), paramString));
      return true;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "sendC2COfflineFileMsg: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "sendC2COfflineFileMsg: UseMediaPlatform not enabled");
    }
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
    ((FMTransC2CMsgInfo)localObject).msgSeq = ahav.bA();
    ((FMTransC2CMsgInfo)localObject).msgUid = ahav.ge();
    return a(paramString1, 529, 4, paramString2, (FMTransC2CMsgInfo)localObject);
  }
  
  public byte[] a(agnj paramagnj)
  {
    if (paramagnj == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[1024];
    aqoj.b(arrayOfByte, 0, paramagnj.ea, 16);
    aqoj.DWord2Byte(arrayOfByte, 22, paramagnj.sessionid);
    aqoj.Word2Byte(arrayOfByte, 28, paramagnj.aj);
    aqoj.Word2Byte(arrayOfByte, 30, (short)1);
    arrayOfByte[32] = 1;
    aqoj.Word2Byte(arrayOfByte, 35, (short)11);
    arrayOfByte[37] = 15;
    aqoj.Word2Byte(arrayOfByte, 38, (short)1);
    arrayOfByte[40] = 1;
    arrayOfByte[41] = 16;
    aqoj.Word2Byte(arrayOfByte, 42, (short)4);
    aqoj.DWord2Byte(arrayOfByte, 44, this.app.getAppid());
    paramagnj = new byte[48];
    aqoj.b(paramagnj, 0, arrayOfByte, 48);
    return paramagnj;
  }
  
  public void aK(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
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
      float f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " during " + this.decimalFormat.format(f) + "sec.");
      }
    }
    if (paramToServiceMsg.getServiceCmd().equals("TransService.ReqOffFilePack"))
    {
      onReceive(paramToServiceMsg, paramFromServiceMsg, (anbd.a)c(paramToServiceMsg, paramFromServiceMsg));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResponse : cmd " + paramToServiceMsg.getServiceCmd().hashCode() + "unknow");
  }
  
  public long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, im_msg_body.GroupFile paramGroupFile, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "handleDiscFileCome,uinseq[" + String.valueOf(paramLong1) + "],discUin[" + String.valueOf(paramLong2) + "],sendUin[" + String.valueOf(paramLong3) + "],seq[" + String.valueOf(paramLong4) + "],msgTime[" + String.valueOf(paramLong6) + "],fileInfo[" + String.valueOf(paramGroupFile) + "],oriImgWidth[" + String.valueOf(paramInt1) + "],oriImgHeight[" + String.valueOf(paramInt2) + "]");
    }
    return a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramGroupFile, paramInt1, paramInt2);
  }
  
  public agnj b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed context=null");
      return null;
    }
    int i = paramArrayOfByte.length;
    agnj localagnj = new agnj();
    int j;
    int k;
    if (i >= 16)
    {
      aqoj.c(paramArrayOfByte, 0, localagnj.ea, 16);
      if (i < 26) {
        break label167;
      }
      localagnj.sessionid = aqoj.getLongData(paramArrayOfByte, 22);
      if (i < 30) {
        break label178;
      }
      localagnj.aj = aqoj.b(paramArrayOfByte, 28);
      if (i < 32) {
        break label189;
      }
      j = aqoj.b(paramArrayOfByte, 30);
      if (j >= 2)
      {
        if (i < 34) {
          break label200;
        }
        localagnj.ak = aqoj.b(paramArrayOfByte, 32);
      }
      k = j + 32 + 2;
      if (i < k + 2) {
        break label211;
      }
      j = aqoj.b(paramArrayOfByte, k);
      if (j >= 4) {
        break label222;
      }
      localagnj.cex = false;
    }
    for (;;)
    {
      return localagnj;
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - bufAppGUID");
      return null;
      label167:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - dwSessionId");
      return null;
      label178:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wCancelType");
      return null;
      label189:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wReasonLen");
      return null;
      label200:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - bufReason");
      return null;
      label211:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wContextDataLen");
      return null;
      label222:
      byte[] arrayOfByte = new byte[j];
      aqoj.c(paramArrayOfByte, k + 2, arrayOfByte, j);
      i = 0;
      label240:
      int m;
      if (i < j)
      {
        k = arrayOfByte[i];
        m = i + 1;
        if (j <= m + 2) {
          break label304;
        }
        i = aqoj.b(arrayOfByte, m);
        m += 2;
        if (k != 15) {
          break label363;
        }
        if (i == 1) {
          break label316;
        }
        localagnj.cex = false;
      }
      for (;;)
      {
        i = m + i;
        break label240;
        break;
        label304:
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode Cancel or accept tlv error - L");
        break;
        label316:
        if (j >= m + i)
        {
          paramArrayOfByte = new byte[i];
          aqoj.c(arrayOfByte, m, paramArrayOfByte, i);
          if (paramArrayOfByte[0] == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localagnj.cex = bool;
            break;
          }
          label363:
          if (k == 4)
          {
            paramArrayOfByte = new byte[i];
            if (j < m + i) {
              break label421;
            }
            aqoj.c(arrayOfByte, m, paramArrayOfByte, i);
            paramArrayOfByte = a(paramArrayOfByte);
            if (paramArrayOfByte == null) {
              break label433;
            }
            localagnj.name = paramArrayOfByte.name;
            localagnj.size = paramArrayOfByte.size;
          }
        }
      }
      label421:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - V");
    }
    label433:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode fileinfo error for request or accept");
    return null;
  }
  
  public void b(int paramInt1, int paramInt2, agie paramagie)
  {
    Object localObject = new cmd0x346.SendListQueryReq();
    ((cmd0x346.SendListQueryReq)localObject).uint64_uin.set(this.app.getLongAccountUin());
    ((cmd0x346.SendListQueryReq)localObject).uint32_begin_index.set(paramInt1);
    ((cmd0x346.SendListQueryReq)localObject).uint32_req_count.set(paramInt2);
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.msg_send_list_query_req.set((MessageMicro)localObject);
    localReqBody.uint32_cmd.set(200);
    localObject = localReqBody.uint32_seq;
    paramInt1 = cRe;
    cRe = paramInt1 + 1;
    ((PBUInt32Field)localObject).set(paramInt1);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    if (ald())
    {
      localReqBody.uint32_flag_support_mediaplatform.set(1);
      QLog.d("FileTransferHandler<FileAssistant>", 1, "querySendFileList: UseMediaPlatform enabled");
    }
    for (;;)
    {
      paramagie = new agib.d(paramagie);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_SEND_LIST-200", localReqBody.toByteArray(), paramagie, 10000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "querySendFileList: UseMediaPlatform not enabled");
    }
  }
  
  public void b(int paramInt1, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt2, String paramString3, agnj paramagnj, long paramLong2, int paramInt3)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FileTransferHandler.4(this, paramInt1, paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramagnj, paramLong2, paramInt3));
      return;
    }
    a(paramInt1, paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramagnj, paramLong2, paramInt3);
  }
  
  public void b(agzw paramagzw, agie paramagie, FileManagerEntity paramFileManagerEntity)
  {
    paramagzw = b(paramagzw);
    QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]SendOfflineFileHit");
    a(1L, 1800, false, paramagzw, paramagie, paramFileManagerEntity);
  }
  
  public void c(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    cmd0x345.ReqBody.SubCmd0x6ReqBody localSubCmd0x6ReqBody = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
    localSubCmd0x6ReqBody.uint32_dst_bus_id.set(paramInt);
    localSubCmd0x6ReqBody.uint64_file_size.set(paramFileManagerEntity.fileSize);
    localSubCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    if ((paramFileManagerEntity.strFileMd5 != null) && (paramFileManagerEntity.strFileMd5.length() > 0)) {
      localSubCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramFileManagerEntity.strFileMd5.getBytes()));
    }
    localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramFileManagerEntity.selfUin));
    Object localObject = paramFileManagerEntity.peerUin.replace("+", "");
    localSubCmd0x6ReqBody.uint64_dst_uin.set(Long.parseLong((String)localObject));
    localSubCmd0x6ReqBody.str_file_name.set(paramFileManagerEntity.fileName);
    localSubCmd0x6ReqBody.str_src_file_path.set(paramFileManagerEntity.Uuid);
    localSubCmd0x6ReqBody.str_src_parent_folder.set("/");
    localSubCmd0x6ReqBody.uint32_client_type.set(104);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
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
    localObject = new cmd0x345.ReqBody();
    ((cmd0x345.ReqBody)localObject).msg_subcmd_0x6_req_body.set(localSubCmd0x6ReqBody);
    ((cmd0x345.ReqBody)localObject).uint32_sub_cmd.set(7);
    paramFileManagerEntity = new agib.d(false, paramFileManagerEntity.nSessionId, null, 7);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", ((cmd0x345.ReqBody)localObject).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
  }
  
  public void c(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "RemoveOfflineFile : PeerUin[" + ahav.kZ(paramString1) + "], FileUUID[" + paramString2 + "], bSend[" + paramBoolean + "]");
    }
    if (paramBoolean) {
      i = 1;
    }
    paramString4 = new cmd0x346.DeleteFileReq();
    this.app.getCurrentAccountUin();
    try
    {
      long l1 = Long.parseLong(this.app.getCurrentAccountUin());
      long l2 = Long.parseLong(paramString1);
      paramString4.uint64_uin.set(l1);
      paramString4.uint64_peer_uin.set(l2);
      paramString4.uint32_delete_type.set(i);
      paramString4.bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
      paramString1 = new cmd0x346.ReqBody();
      paramString1.msg_delete_file_req.set(paramString4);
      paramString1.uint32_cmd.set(900);
      PBUInt32Field localPBUInt32Field = paramString1.uint32_seq;
      i = cRe;
      cRe = i + 1;
      localPBUInt32Field.set(i);
      paramString1.uint32_business_id.set(3);
      paramString1.uint32_client_type.set(104);
      if (ald())
      {
        paramString1.uint32_flag_support_mediaplatform.set(1);
        if ((paramString3 != null) && (paramString3.length() > 0))
        {
          paramString4.str_fileidcrc.set(paramString3);
          QLog.d("FileTransferHandler<FileAssistant>", 1, "RemoveOfflineFile: UseMediaPlatform enabled");
        }
      }
      for (;;)
      {
        paramString2 = new agib.d(paramString2);
        a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900", paramString1.toByteArray(), paramString2, 30000, 3, 1);
        return;
        QLog.d("FileTransferHandler<FileAssistant>", 1, "RemoveOfflineFile: UseMediaPlatform enabled but FileIdCrc is null");
        continue;
        QLog.d("FileTransferHandler<FileAssistant>", 1, "RemoveOfflineFile: UseMediaPlatform not enabled");
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void dgq()
  {
    face2face_file.msg localmsg = new face2face_file.msg();
    localmsg.version.set(1);
    localmsg.result.set(0);
    a("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ", localmsg.toByteArray(), null);
  }
  
  public void dgr()
  {
    Object localObject1;
    long l1;
    long l2;
    if (this.app.getCurrentAccountUin() != null)
    {
      localObject1 = this.app.getApplication().getSharedPreferences("wifiphoto_smart_reminder", 0);
      l1 = ((SharedPreferences)localObject1).getLong("wifiphoto_smart_reminder_last_time", 0L);
      l2 = anaz.gQ();
      if (l2 - l1 > 86400L)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putLong("wifiphoto_smart_reminder_last_time", l2);
        ((SharedPreferences.Editor)localObject1).commit();
        boolean bool = aqfo.isExistSDCard();
        l1 = aqfo.getSDCardAvailableSize();
        l2 = aqfo.getSystemAvailableSize();
        if ((!bool) || (l1 == 0L)) {
          break label716;
        }
        l1 = Math.min(l1, l2) * 1024L;
      }
    }
    for (;;)
    {
      l2 = ahap.at(this.app.getApplication());
      if ((l1 <= 1073741824L) && (l2 >= 50L)) {
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("freeSize", l1);
        ((JSONObject)localObject1).put("deviceType", 2);
        ((JSONObject)localObject1).put("subtype", "8");
        ((JSONObject)localObject1).put("photoCount", l2);
        Object localObject2 = new SubMsgType0x7.MsgBody.GenericSubCmd();
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint64_sessionid.set(1L);
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_size.set(1);
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_index.set(0);
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_type.set(5);
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).bytes_buf.set(ByteStringMicro.copyFrom(((JSONObject)localObject1).toString().getBytes()));
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).setHasFlag(true);
        localObject1 = new SubMsgType0x7.MsgBody();
        ((SubMsgType0x7.MsgBody)localObject1).uint32_sub_cmd.set(4);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_src_app_id.set(1001);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_src_inst_id.set(AppSetting.getAppId());
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_dst_app_id.set(1);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_dst_inst_id.set(1);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint64_dst_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint64_src_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.setHasFlag(true);
        ((SubMsgType0x7.MsgBody)localObject1).msg_subcmd_0x4_generic.set((MessageMicro)localObject2);
        ((SubMsgType0x7.MsgBody)localObject1).setHasFlag(true);
        localObject2 = this.app.getCurrentAccountUin();
        Object localObject3 = ((SubMsgType0x7.MsgBody)localObject1).toByteArray();
        localObject1 = createToServiceMsg("MessageSvc.PbSendMsg");
        ((ToServiceMsg)localObject1).extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
        ((ToServiceMsg)localObject1).extraData.putInt("ROUNTING_TYPE", 13);
        ((ToServiceMsg)localObject1).extraData.putBoolean("ISFROM_DATALINE", true);
        ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_CMD", 1002);
        ((ToServiceMsg)localObject1).addAttribute("cookie", Integer.valueOf(1));
        ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
        l1 = ahav.ge();
        l2 = ahav.bA();
        anbn localanbn = new anbn();
        localanbn.dEY = 7;
        localanbn.msg = ((byte[])localObject3);
        localObject2 = anbh.a(this.app, 13, (String)localObject2, localanbn, l2, anbk.ac(l1));
        localObject3 = new im_msg_head.InstInfo();
        ((im_msg_head.InstInfo)localObject3).uint32_apppid.set(1);
        ((im_msg_head.InstInfo)localObject3).uint32_instid.set(1);
        ((im_msg_head.InstInfo)localObject3).setHasFlag(true);
        ((msg_svc.PbSendMsgReq)localObject2).routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add((MessageMicro)localObject3);
        localObject3 = new im_msg_head.InstInfo();
        ((im_msg_head.InstInfo)localObject3).uint32_apppid.set(1001);
        ((im_msg_head.InstInfo)localObject3).uint32_instid.set(AppSetting.getAppId());
        ((im_msg_head.InstInfo)localObject3).setHasFlag(true);
        ((msg_svc.PbSendMsgReq)localObject2).routing_head.trans_0x211.inst_ctrl.msg_from_inst = ((im_msg_head.InstInfo)localObject3);
        ((msg_svc.PbSendMsgReq)localObject2).routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
        ((ToServiceMsg)localObject1).putWupBuffer(((msg_svc.PbSendMsgReq)localObject2).toByteArray());
        if (localObject1 != null)
        {
          ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
          this.app.sendToService((ToServiceMsg)localObject1);
        }
        return;
        label716:
        l1 = 1024L * l2;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void fE(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "PreviewOfflineFile : FileUUID[" + paramString1 + "]");
    }
    cmd0x346.ApplyDownloadAbsReq localApplyDownloadAbsReq = new cmd0x346.ApplyDownloadAbsReq();
    localApplyDownloadAbsReq.uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localApplyDownloadAbsReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_apply_download_abs_req.set(localApplyDownloadAbsReq);
    paramString1.uint32_cmd.set(1100);
    PBUInt32Field localPBUInt32Field = paramString1.uint32_seq;
    int i = cRe;
    cRe = i + 1;
    localPBUInt32Field.set(i);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (ald())
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        localApplyDownloadAbsReq.str_fileidcrc.set(paramString2);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "PreviewOfflineFile: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramString2 = new agib.d();
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100", paramString1.toByteArray(), paramString2, 30000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "PreviewOfflineFile: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "PreviewOfflineFile: UseMediaPlatform not enabled");
    }
  }
  
  public void fF(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "PreviewOfflineFile : FileUUID[" + paramString2 + "]");
    }
    cmd0x345.ReqBody.SubCmd0x7ReqBody localSubCmd0x7ReqBody = new cmd0x345.ReqBody.SubCmd0x7ReqBody();
    localSubCmd0x7ReqBody.uint64_disscus_uin.set(Long.parseLong(paramString1));
    localSubCmd0x7ReqBody.str_file_path.set(paramString2);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x7_req_body.set(localSubCmd0x7ReqBody);
    paramString1.uint32_sub_cmd.set(8);
    paramString2 = new agib.d(false, 0L, null, 8);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void i(String paramString, long paramLong, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FileTransferHandler.6(this, paramLong, paramBoolean, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  handle recv onlinefile resp. sucess =" + paramBoolean);
    this.app.a().k(paramString, paramLong, paramBoolean);
  }
  
  public void j(String paramString, long paramLong, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FileTransferHandler.8(this, paramLong, paramBoolean, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  handle query onlinefile upload progress resp. sucess =" + paramBoolean);
    this.app.a().l(paramString, paramLong, paramBoolean);
  }
  
  public void k(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      long l = paramInt1;
      new Handler(localLooper).post(new FileTransferHandler.9(this, l, paramInt2, paramString2, paramString1));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramInt1 + "] Handle upload failed notify. retCode =" + paramInt2 + "(1:cancel upload) reason=" + paramString2);
    if (1 == paramInt2)
    {
      this.app.a().ak(paramString1, paramInt1);
      return;
    }
    if (2 == paramInt2)
    {
      this.app.a().ak(paramString1, paramInt1);
      return;
    }
    if (3 == paramInt2)
    {
      this.app.a().am(paramString1, paramInt1);
      return;
    }
    this.app.a().ak(paramString1, paramInt1);
  }
  
  public void l(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      long l = paramInt1;
      new Handler(localLooper).post(new FileTransferHandler.10(this, l, paramInt3, paramInt2, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramInt1 + "] Handle upload progress notify. speed=" + paramInt3 + " progress =" + paramInt2);
    this.app.a().d(paramString, paramInt1, paramInt3, paramInt2);
  }
  
  public void m(FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardOfflineFile : PeerUin[" + ahav.kZ(paramFileManagerEntity.peerUin) + "], FileUUID[" + paramFileManagerEntity.Uuid + "]");
    }
    if ((paramFileManagerEntity == null) || (TextUtils.isEmpty(paramFileManagerEntity.Uuid)))
    {
      QLog.e("FileTransferHandler<FileAssistant>", 2, "entity info error:" + ahav.d(paramFileManagerEntity));
      return;
    }
    cmd0x346.ApplyForwardFileReq localApplyForwardFileReq = new cmd0x346.ApplyForwardFileReq();
    localApplyForwardFileReq.uint64_sender_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    Object localObject1 = paramFileManagerEntity.peerUin.replace("+", "");
    localApplyForwardFileReq.uint64_recver_uin.set(Long.parseLong((String)localObject1));
    localApplyForwardFileReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    localObject1 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject1).msg_apply_forward_file_req.set(localApplyForwardFileReq);
    ((cmd0x346.ReqBody)localObject1).uint32_cmd.set(700);
    Object localObject2 = ((cmd0x346.ReqBody)localObject1).uint32_seq;
    int i = cRe;
    cRe = i + 1;
    ((PBUInt32Field)localObject2).set(i);
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
    if (ald())
    {
      ((cmd0x346.ReqBody)localObject1).uint32_flag_support_mediaplatform.set(1);
      if ((paramFileManagerEntity.fileIdCrc != null) && (paramFileManagerEntity.fileIdCrc.length() > 0))
      {
        localApplyForwardFileReq.str_fileidcrc.set(paramFileManagerEntity.fileIdCrc);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "ForwardOfflineFile: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramFileManagerEntity = new agib.d(false, paramFileManagerEntity.nSessionId);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700", ((cmd0x346.ReqBody)localObject1).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "ForwardOfflineFile: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "ForwardOfflineFile: UseMediaPlatform not enabled");
    }
  }
  
  public void m(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "getOfflineVideoThumbInfo : FileUUID[" + paramString1 + "]");
    }
    cmd0x346.ApplyDownloadAbsReq localApplyDownloadAbsReq = new cmd0x346.ApplyDownloadAbsReq();
    localApplyDownloadAbsReq.uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localApplyDownloadAbsReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_apply_download_abs_req.set(localApplyDownloadAbsReq);
    paramString1.uint32_cmd.set(1100);
    PBUInt32Field localPBUInt32Field = paramString1.uint32_seq;
    int i = cRe;
    cRe = i + 1;
    localPBUInt32Field.set(i);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (ald())
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        localApplyDownloadAbsReq.str_fileidcrc.set(paramString2);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "getOfflineVideoThumbInfo: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramString2 = new agib.d(true, paramLong);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100", paramString1.toByteArray(), paramString2, 30000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getOfflineVideoThumbInfo: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getOfflineVideoThumbInfo: UseMediaPlatform not enabled");
    }
  }
  
  public void n(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "getDiscVideoThumbInfo : FileUUID[" + paramString2 + "]");
    }
    cmd0x345.ReqBody.SubCmd0x7ReqBody localSubCmd0x7ReqBody = new cmd0x345.ReqBody.SubCmd0x7ReqBody();
    localSubCmd0x7ReqBody.uint64_disscus_uin.set(Long.parseLong(paramString1));
    localSubCmd0x7ReqBody.str_file_path.set(paramString2);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x7_req_body.set(localSubCmd0x7ReqBody);
    paramString1.uint32_sub_cmd.set(8);
    paramString2 = new agib.d(true, paramLong, null, 8);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public final void notifyUI(ToServiceMsg arg1, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (???.extraData.containsKey(SEQ_KEY))
    {
      long l = ???.extraData.getLong(SEQ_KEY);
      synchronized (this.ky)
      {
        agie localagie = (agie)this.ky.remove(Long.valueOf(l));
        if (localagie != null)
        {
          ??? = handler.obtainMessage();
          ???.what = paramInt;
          ???.obj = new Object[] { localagie, Boolean.valueOf(paramBoolean), paramObject };
          ???.sendToTarget();
          QLog.i("FileTransferHandler<FileAssistant>", 1, "notifyUI. sendToTarget. seq=" + l + ".type=" + paramInt);
          return;
        }
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find observer. seq=" + l + ".type=" + paramInt);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find seq_key. type=" + paramInt);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      aA(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramObject = (anbd.a)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "onReceive, MessageConstants.CMD_TRANSSERVICE_REQOFFFILEPACK: " + paramObject.bx);
    }
    switch (paramObject.bx)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 1: 
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 2: 
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 3: 
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    e(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public boolean p(String paramString, long paramLong)
  {
    agnj localagnj = new agnj();
    localagnj.ea = ((byte[])dG.clone());
    localagnj.aj = 4;
    localagnj.sessionid = paramLong;
    byte[] arrayOfByte = this.app.a().a(localagnj);
    if (arrayOfByte == null)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + localagnj.sessionid + "]. recvOnLineFile failed:");
      return false;
    }
    return this.app.a().a().a(paramString, paramLong, 133, arrayOfByte);
  }
  
  public boolean q(String paramString, long paramLong)
  {
    Object localObject = new SubMsgType0x5.MsgBody();
    ((SubMsgType0x5.MsgBody)localObject).uint32_sessionid.set((int)paramLong);
    localObject = ((SubMsgType0x5.MsgBody)localObject).toByteArray();
    FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
    localFMTransC2CMsgInfo.sessionId = paramLong;
    localFMTransC2CMsgInfo.busiType = 1025;
    localFMTransC2CMsgInfo.msgSeq = ahav.bA();
    localFMTransC2CMsgInfo.msgUid = ahav.ge();
    localFMTransC2CMsgInfo.entity = this.app.a().b(paramLong);
    return a(paramString, 529, 5, (byte[])localObject, localFMTransC2CMsgInfo);
  }
  
  class a
  {
    List<String> AV = null;
    short ag = 0;
    short ah = 0;
    String bHd = null;
    String bHe = null;
    String bHf = null;
    ByteStringMicro c = null;
    long retCode = 0L;
    String retMsg = null;
    String strCookie = null;
    String strFileName = null;
    String strIP = null;
    String strMd5 = null;
    String strUrl = null;
    
    private a() {}
  }
  
  public static class b
  {
    public short ag;
    public short ah;
    public String bHe = "";
    public String bHg = "";
    public String bHh = "";
    public String bHi = "";
    public boolean bUseMediaPlatform;
    public int cXd = -1;
    public int cXe;
    public byte[] dI;
    public byte[] dJ;
    public boolean fileExist;
    public long fileSize;
    public byte[] key;
    public int packetSize;
    public int retCode;
    public String retMsg = "";
    public byte[] sha;
    public String strIP = "";
    public long totalSpace;
    public long usedSpace;
    public byte[] uuid;
  }
  
  static class c
  {
    public String name;
    public long size;
  }
  
  class d
  {
    private long Yu;
    private String bHj;
    private agie c;
    private int cXf;
    private int cXg;
    private boolean cds;
    private Object dH;
    private byte[] dK;
    private byte[] dL;
    private byte[] dM;
    
    d()
    {
      a(false, 0L, null, null, 0);
    }
    
    d(long paramLong, agie paramagie)
    {
      a(false, paramLong, null, paramagie, 0);
    }
    
    d(agie paramagie)
    {
      a(false, 0L, null, paramagie, 0);
    }
    
    d(String paramString)
    {
      a(false, 0L, paramString, null, 0);
    }
    
    d(boolean paramBoolean, long paramLong)
    {
      a(paramBoolean, paramLong, null, null, 0);
    }
    
    d(boolean paramBoolean, long paramLong, agie paramagie, int paramInt)
    {
      a(paramBoolean, paramLong, null, paramagie, paramInt);
    }
    
    d(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, agie paramagie)
    {
      a(false, 0L, null, paramagie, 0);
      this.dK = paramArrayOfByte1;
      this.dL = paramArrayOfByte2;
      this.dM = paramArrayOfByte3;
    }
    
    private void a(boolean paramBoolean, long paramLong, String paramString, agie paramagie, int paramInt)
    {
      this.cXf = 0;
      this.cds = paramBoolean;
      this.Yu = paramLong;
      this.cXg = paramInt;
      this.bHj = paramString;
      this.c = paramagie;
      this.dH = null;
    }
    
    int Ed()
    {
      return this.cXg;
    }
    
    int Ee()
    {
      return this.cXf;
    }
    
    agie a()
    {
      return this.c;
    }
    
    boolean ale()
    {
      return this.cds;
    }
    
    void dgs()
    {
      this.cXf += 1;
    }
    
    long fD()
    {
      return this.Yu;
    }
    
    Object getObject()
    {
      return this.dH;
    }
    
    String uY()
    {
      return this.bHj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agib
 * JD-Core Version:    0.7.0.1
 */