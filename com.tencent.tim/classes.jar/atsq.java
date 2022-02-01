import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
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
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.app.FileTransferHandler.14;
import com.tencent.tim.filemanager.app.FileTransferHandler.7;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;
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
import tencent.im.cs.cmd0x346.cmd0x346.RecallFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccRsp;
import tencent.im.cs.face2face_file.face2face_file.msg;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;

public class atsq
{
  private static final String SEQ_KEY = agie.class.getName();
  private static int cRe;
  public static final byte[] dG = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 101 };
  private static Handler handler = new atsr(Looper.getMainLooper());
  private anbd jdField_a_of_type_Anbd = new anbd();
  private anbe jdField_a_of_type_Anbe = new anbe();
  aocq jdField_a_of_type_Aocq = null;
  public final QQAppInterface app;
  private DecimalFormat decimalFormat = new DecimalFormat("0.00");
  private Map<Long, agie> ky = new HashMap();
  private long observerSeq;
  
  public atsq(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private aude a(audi paramaudi)
  {
    aude localaude = new aude();
    long l = Long.parseLong(this.app.getCurrentAccountUin());
    if (paramaudi.cYU == 1700)
    {
      localaude.jdField_a_of_type_Audd = new audd();
      paramaudi.bJz = paramaudi.bJz.replace("+", "");
      localaude.jdField_a_of_type_Audd.uint64_sender_uin = l;
      localaude.jdField_a_of_type_Audd.uint64_recver_uin = Long.parseLong(paramaudi.bJz);
      localaude.jdField_a_of_type_Audd.uint64_file_size = paramaudi.fileSize;
      localaude.jdField_a_of_type_Audd.str_file_name = new String(paramaudi.ej);
      localaude.jdField_a_of_type_Audd.str_local_filepath = new String(paramaudi.ei);
      localaude.jdField_a_of_type_Audd.bytes_10m_md5 = paramaudi.md5;
      localaude.jdField_a_of_type_Audd.bytes_sha = paramaudi.sha1;
    }
    while (paramaudi.cYU != 1600) {
      return localaude;
    }
    localaude.jdField_a_of_type_Audc = new audc();
    paramaudi.bJz = paramaudi.bJz.replace("+", "");
    localaude.jdField_a_of_type_Audc.uint64_sender_uin = l;
    localaude.jdField_a_of_type_Audc.uint64_recver_uin = Long.parseLong(paramaudi.bJz);
    localaude.jdField_a_of_type_Audc.uint64_file_size = paramaudi.fileSize;
    localaude.jdField_a_of_type_Audc.str_file_name = new String(paramaudi.ej);
    localaude.jdField_a_of_type_Audc.str_local_filepath = new String(paramaudi.ei);
    localaude.jdField_a_of_type_Audc.bytes_10m_md5 = paramaudi.md5;
    localaude.jdField_a_of_type_Audc.bytes_3sha = paramaudi.el;
    return localaude;
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
  
  private void a(ProtoReqManager.c paramc)
  {
    paramc.a = new atsu(this);
    this.app.getProtoReqManager().b(paramc);
  }
  
  private aude b(audi paramaudi)
  {
    aude localaude = new aude();
    localaude.jdField_a_of_type_Audb = new audb();
    paramaudi.bJz = paramaudi.bJz.replace("+", "");
    long l = Long.parseLong(this.app.getCurrentAccountUin());
    localaude.jdField_a_of_type_Audb.uint64_sender_uin = l;
    localaude.jdField_a_of_type_Audb.uint64_recver_uin = Long.parseLong(paramaudi.bJz);
    localaude.jdField_a_of_type_Audb.uint64_file_size = paramaudi.fileSize;
    localaude.jdField_a_of_type_Audb.str_file_name = new String(paramaudi.ej);
    localaude.jdField_a_of_type_Audb.str_local_filepath = new String(paramaudi.ei);
    localaude.jdField_a_of_type_Audb.bytes_10m_md5 = paramaudi.md5;
    localaude.jdField_a_of_type_Audb.bytes_sha = paramaudi.sha1;
    localaude.jdField_a_of_type_Audb.bytes_3sha = paramaudi.el;
    return localaude;
  }
  
  private void c(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    agib.b localb = new agib.b();
    Object localObject1 = null;
    boolean bool1;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      localb.retCode = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool1 = false;
    }
    int i;
    label117:
    int j;
    label139:
    int k;
    label164:
    int m;
    for (;;)
    {
      if ((localb.retCode == 0) && ((localb.strIP == null) || (localb.strIP.length() == 0)))
      {
        i = 1;
        if ((localb.strIP == null) || (localb.strIP.length() <= 0)) {
          break label765;
        }
        j = 1;
        if ((localb.retCode != -91245) && (localb.retCode != -7010)) {
          break label771;
        }
        k = 1;
        if ((localb.uuid != null) && (localb.uuid.length != 0)) {
          break label777;
        }
        m = 1;
        label184:
        Object localObject2 = (atsq.a)paramc.fi;
        int n = ((atsq.a)localObject2).Ee();
        if (((m == 0) || (j == 0)) && (((k == 0) && (i == 0)) || (n >= 3))) {
          break label783;
        }
        ((atsq.a)localObject2).dgs();
        a(paramc.clW, paramc.fW, (atsq.a)localObject2);
        return;
        if (paramd.g.getResultCode() != 1000)
        {
          localb.retCode = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is failed[" + paramd.g.getResultCode() + "]");
          bool1 = false;
        }
        else
        {
          localObject2 = paramd.g.getWupBuffer();
          cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
          try
          {
            localRspBody.mergeFrom((byte[])localObject2);
            if (localRspBody.msg_apply_upload_rsp.has()) {
              break label393;
            }
            localb.retCode = -100003;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
            bool1 = false;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
            localb.retCode = -100003;
            bool1 = false;
          }
          continue;
          label393:
          localObject1 = (cmd0x346.ApplyUploadRsp)localRspBody.msg_apply_upload_rsp.get();
          if (((cmd0x346.ApplyUploadRsp)localObject1).int32_ret_code.has()) {
            localb.retCode = ((cmd0x346.ApplyUploadRsp)localObject1).int32_ret_code.get();
          }
          if (((cmd0x346.ApplyUploadRsp)localObject1).str_ret_msg.has()) {
            localb.retMsg = ((cmd0x346.ApplyUploadRsp)localObject1).str_ret_msg.get();
          }
          if (((cmd0x346.ApplyUploadRsp)localObject1).uint64_total_space.has()) {
            localb.totalSpace = ((cmd0x346.ApplyUploadRsp)localObject1).uint64_total_space.get();
          }
          if (((cmd0x346.ApplyUploadRsp)localObject1).uint64_used_space.has()) {
            localb.usedSpace = ((cmd0x346.ApplyUploadRsp)localObject1).uint64_used_space.get();
          }
          if (((cmd0x346.ApplyUploadRsp)localObject1).uint64_uploaded_size.has()) {
            localb.fileSize = ((cmd0x346.ApplyUploadRsp)localObject1).uint64_uploaded_size.get();
          }
          if (((cmd0x346.ApplyUploadRsp)localObject1).str_upload_ip.has())
          {
            localb.strIP = ((cmd0x346.ApplyUploadRsp)localObject1).str_upload_ip.get();
            label550:
            if (((cmd0x346.ApplyUploadRsp)localObject1).uint32_upload_port.has()) {
              localb.ag = ((short)((cmd0x346.ApplyUploadRsp)localObject1).uint32_upload_port.get());
            }
            if (((cmd0x346.ApplyUploadRsp)localObject1).bytes_uuid.has()) {
              localb.uuid = ((cmd0x346.ApplyUploadRsp)localObject1).bytes_uuid.get().toByteArray();
            }
            if (((cmd0x346.ApplyUploadRsp)localObject1).bytes_upload_key.has()) {
              localb.key = ((cmd0x346.ApplyUploadRsp)localObject1).bytes_upload_key.get().toByteArray();
            }
            if (((cmd0x346.ApplyUploadRsp)localObject1).bool_file_exist.has()) {
              localb.fileExist = ((cmd0x346.ApplyUploadRsp)localObject1).bool_file_exist.get();
            }
            if (((cmd0x346.ApplyUploadRsp)localObject1).uint32_upload_port.has()) {
              localb.packetSize = ((cmd0x346.ApplyUploadRsp)localObject1).uint32_pack_size.get();
            }
            if ((!((cmd0x346.ApplyUploadRsp)localObject1).rpt_str_uploadip_list.has()) || (((cmd0x346.ApplyUploadRsp)localObject1).rpt_str_uploadip_list.get().size() <= 0)) {
              break label1015;
            }
          }
        }
      }
    }
    label771:
    label777:
    label783:
    label1015:
    for (localObject1 = ((cmd0x346.ApplyUploadRsp)localObject1).rpt_str_uploadip_list.get();; localObject1 = null)
    {
      bool1 = true;
      break;
      if (((cmd0x346.ApplyUploadRsp)localObject1).str_upload_domain.has())
      {
        localb.strIP = ((cmd0x346.ApplyUploadRsp)localObject1).str_upload_domain.get();
        break label550;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
      break label550;
      i = 0;
      break label117;
      label765:
      j = 0;
      break label139;
      k = 0;
      break label164;
      m = 0;
      break label184;
      paramc = new achq.a();
      paramc.errCode = localb.retCode;
      paramc.retryCount = paramd.dPU;
      boolean bool2 = bool1;
      if (m != 0)
      {
        bool2 = bool1;
        if (j != 0)
        {
          localb.retMsg = ("uuid_null[" + localb.toString() + "]");
          bool2 = false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool2 + ", retCode=" + localb.retCode + ", retMsg=" + localb.retMsg + ", totalSpace=" + localb.totalSpace + ", usedSpace=" + localb.usedSpace + ", ip=" + localb.strIP + ", port=" + localb.ag);
      }
      a(localInvalidProtocolBufferMicroException.a(), 5004, bool2, new Object[] { localb, paramc, localObject1 });
      return;
    }
  }
  
  private void d(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    agib.b localb = new agib.b();
    boolean bool;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      localb.retCode = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool = false;
    }
    for (;;)
    {
      Object localObject = new achq.a();
      ((achq.a)localObject).errCode = localb.retCode;
      ((achq.a)localObject).retryCount = paramd.dPU;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleUploadSuccResponse: return " + bool + ", retCode=" + localb.retCode + ", retMsg=" + localb.retMsg);
      }
      a(((atsq.a)paramc.fi).a(), 5005, bool, new Object[] { localb, localObject });
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        localb.retCode = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: resp is failed[" + paramd.g.getResultCode() + "]");
        bool = false;
      }
      else
      {
        localObject = paramd.g.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_upload_succ_rsp.has()) {
            break label351;
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
        continue;
        label351:
        cmd0x346.UploadSuccRsp localUploadSuccRsp = (cmd0x346.UploadSuccRsp)localRspBody.msg_upload_succ_rsp.get();
        if (localUploadSuccRsp.int32_ret_code.has()) {
          localb.retCode = localUploadSuccRsp.int32_ret_code.get();
        }
        if (localUploadSuccRsp.str_ret_msg.has()) {
          localb.retMsg = localUploadSuccRsp.str_ret_msg.get();
        }
        bool = true;
      }
    }
  }
  
  private void e(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    long l1 = 0L;
    paramc = new face2face_file.msg();
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("QlinkResistTerrorist", 0);
    long l2;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
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
        break label368;
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
      label368:
      l2 = l1;
      if (l1 == -100003L) {
        l2 = 9045L;
      }
    }
  }
  
  private void f(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    long l = 0L;
    Object localObject12 = null;
    Object localObject16 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject15 = null;
    Object localObject7 = null;
    short s1 = 0;
    short s3 = 0;
    short s2 = 0;
    Object localObject4 = null;
    Object localObject14 = null;
    Object localObject10 = null;
    Object localObject5 = null;
    Object localObject13 = null;
    Object localObject11 = null;
    Object localObject8 = null;
    Object localObject6 = null;
    Object localObject9 = null;
    boolean bool;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is timeout[" + paramd.g.getResultCode() + "]");
      localObject1 = null;
      l = -100001L;
      bool = false;
      localObject5 = localObject11;
      localObject4 = localObject10;
      s1 = s2;
    }
    int i;
    label163:
    int j;
    label184:
    Object localObject17;
    Object localObject2;
    while ((l == 0L) && (localObject4 == null) && (localObject7 == null))
    {
      i = 1;
      if ((l != -91245L) && (l != -7010L)) {
        break label862;
      }
      j = 1;
      localObject10 = (atsq.a)paramc.fi;
      int k = ((atsq.a)localObject10).Ee();
      if (((j == 0) && (i == 0)) || (k >= 3)) {
        break label868;
      }
      ((atsq.a)localObject10).dgs();
      a(paramc.clW, paramc.fW, (atsq.a)localObject10);
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is failed[" + paramd.g.getResultCode() + "]");
        localObject1 = null;
        l = -100002L;
        bool = false;
        s1 = s2;
        localObject4 = localObject10;
        localObject5 = localObject11;
      }
      else
      {
        localObject17 = paramd.g.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject17);
          if (localRspBody.msg_apply_download_rsp.has()) {
            break label417;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: rspBody has not hasMsgApplyDownloadRsp");
          localObject1 = null;
          l = -100003L;
          bool = false;
          s1 = s2;
          localObject4 = localObject10;
          localObject5 = localObject11;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localObject2 = null;
          l = -100003L;
          bool = false;
          s1 = s2;
          localObject4 = localObject10;
          localObject5 = localObject11;
        }
        continue;
        label417:
        localObject17 = (cmd0x346.ApplyDownloadRsp)localRspBody.msg_apply_download_rsp.get();
        if (((cmd0x346.ApplyDownloadRsp)localObject17).int32_ret_code.has()) {
          l = ((cmd0x346.ApplyDownloadRsp)localObject17).int32_ret_code.get();
        }
        if (!((cmd0x346.ApplyDownloadRsp)localObject17).str_ret_msg.has()) {
          break label1138;
        }
      }
    }
    label563:
    label862:
    label868:
    label1138:
    for (localObject6 = ((cmd0x346.ApplyDownloadRsp)localObject17).str_ret_msg.get();; localObject6 = null)
    {
      localObject7 = localObject16;
      localObject9 = localObject15;
      s2 = s3;
      localObject10 = localObject14;
      localObject11 = localObject13;
      if (((cmd0x346.ApplyDownloadRsp)localObject17).msg_download_info.has())
      {
        localObject8 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadRsp)localObject17).msg_download_info.get();
        localObject3 = localObject12;
        if (((cmd0x346.DownloadInfo)localObject8).bytes_download_key.has()) {
          localObject3 = ((cmd0x346.DownloadInfo)localObject8).bytes_download_key.get();
        }
        if (((cmd0x346.DownloadInfo)localObject8).str_download_ip.has())
        {
          localObject2 = ((cmd0x346.DownloadInfo)localObject8).str_download_ip.get();
          if (((cmd0x346.DownloadInfo)localObject8).uint32_port.has()) {
            s1 = (short)((cmd0x346.DownloadInfo)localObject8).uint32_port.get();
          }
          if (((cmd0x346.DownloadInfo)localObject8).str_download_url.has()) {
            localObject4 = ((cmd0x346.DownloadInfo)localObject8).str_download_url.get();
          }
          if (((cmd0x346.DownloadInfo)localObject8).str_cookie.has()) {
            localObject5 = "FTN5K=" + ((cmd0x346.DownloadInfo)localObject8).str_cookie.get();
          }
          localObject7 = localObject3;
          localObject9 = localObject2;
          s2 = s1;
          localObject10 = localObject4;
          localObject11 = localObject5;
          if (!((cmd0x346.DownloadInfo)localObject8).rpt_str_downloadip_list.has()) {
            break label1113;
          }
          localObject7 = localObject3;
          localObject9 = localObject2;
          s2 = s1;
          localObject10 = localObject4;
          localObject11 = localObject5;
          if (((cmd0x346.DownloadInfo)localObject8).rpt_str_downloadip_list.get().size() <= 0) {
            break label1113;
          }
          localObject8 = ((cmd0x346.DownloadInfo)localObject8).rpt_str_downloadip_list.get();
          localObject7 = localObject2;
        }
      }
      for (;;)
      {
        if (((cmd0x346.ApplyDownloadRsp)localObject17).msg_file_info.has())
        {
          localObject2 = (cmd0x346.FileInfo)((cmd0x346.ApplyDownloadRsp)localObject17).msg_file_info.get();
          if (((cmd0x346.FileInfo)localObject2).str_file_name.has())
          {
            localObject9 = audx.getFileName(((cmd0x346.FileInfo)localObject2).str_file_name.get());
            if (((cmd0x346.FileInfo)localObject2).bytes_sha.has()) {
              localObject2 = ((cmd0x346.FileInfo)localObject2).bytes_sha.get();
            }
          }
        }
        for (;;)
        {
          localObject10 = localObject2;
          bool = true;
          localObject2 = localObject6;
          localObject6 = localObject8;
          localObject8 = localObject9;
          localObject9 = localObject10;
          break;
          if (((cmd0x346.DownloadInfo)localObject8).str_download_domain.has())
          {
            localObject2 = ((cmd0x346.DownloadInfo)localObject8).str_download_domain.get();
            break label563;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: has neither ip nor domain");
          break label563;
          i = 0;
          break label163;
          j = 0;
          break label184;
          if (QLog.isColorLevel())
          {
            localObject11 = new StringBuilder().append("handleDownloadResp: return ").append(bool).append(", retCode=").append(l).append(", retMsg=").append((String)localObject2).append(", key=");
            if (localObject3 == null) {
              break label1086;
            }
          }
          for (paramc = ((ByteStringMicro)localObject3).toStringUtf8();; paramc = "")
          {
            QLog.d("FileTransferHandler<FileAssistant>", 2, paramc + ", strIP=" + localObject7 + ", port=" + s1 + ", strUrl=" + (String)localObject4);
            a(((atsq.a)localObject10).a(), 5006, bool, new Object[] { Long.valueOf(l), localObject2, localObject5, localObject3, localObject7, Short.valueOf(s1), localObject4, localObject6, Integer.valueOf(paramd.g.getAppSeq()), localObject8, Long.valueOf(((atsq.a)localObject10).fD()), localObject9 });
            return;
          }
          localObject2 = null;
          continue;
          localObject9 = null;
          break label772;
          localObject2 = null;
          localObject9 = null;
        }
        localObject8 = null;
        localObject3 = localObject7;
        localObject7 = localObject9;
        s1 = s2;
        localObject4 = localObject10;
        localObject5 = localObject11;
      }
    }
  }
  
  private void g(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    agib.b localb = new agib.b();
    boolean bool;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
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
      a(((atsq.a)paramc.fi).a(), 5007, bool, new Object[] { localb, localObject });
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
            break label365;
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
        label365:
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
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject5 = null;
    int j;
    Object localObject3;
    Object localObject4;
    boolean bool;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
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
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handlePreviewResponse: return " + bool + ", retCode=" + i + ", retMsg=" + (String)localObject4 + ", Key=" + (String)localObject3 + ", IP=" + (String)localObject2 + ", Domain=" + (String)localObject1 + ", port=" + j);
      }
      if (i != -100001) {
        break label746;
      }
      i = 9043;
    }
    for (;;)
    {
      for (;;)
      {
        if (i != 0) {
          bool = false;
        }
        paramc = (atsq.a)paramc.fi;
        if (!paramc.ale()) {
          break label760;
        }
        this.app.a().b(bool, 191, new Object[] { Integer.valueOf(i), localObject4, localObject5, localObject3, localObject2, localObject1, Integer.valueOf(j), paramd, Long.valueOf(paramc.fD()) });
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
          break;
        }
        paramd = paramd.g.getWupBuffer();
        localObject3 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject3).mergeFrom(paramd);
          if (((cmd0x346.RspBody)localObject3).msg_apply_download_abs_rsp.has()) {
            break label493;
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
      break;
      label493:
      localObject3 = (cmd0x346.ApplyDownloadAbsRsp)((cmd0x346.RspBody)localObject3).msg_apply_download_abs_rsp.get();
      if (((cmd0x346.ApplyDownloadAbsRsp)localObject3).int32_ret_code.has()) {
        i = ((cmd0x346.ApplyDownloadAbsRsp)localObject3).int32_ret_code.get();
      }
      paramd = (ProtoReqManager.d)localObject2;
      if (((cmd0x346.ApplyDownloadAbsRsp)localObject3).str_ret_msg.has()) {
        paramd = ((cmd0x346.ApplyDownloadAbsRsp)localObject3).str_ret_msg.get();
      }
      if ((i == 0) && (!((cmd0x346.ApplyDownloadAbsRsp)localObject3).msg_download_info.has()))
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not MsgDownloadSuccRsp");
        i = -100003;
        j = 0;
        str = null;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = paramd;
        bool = false;
        paramd = str;
        break;
      }
      localObject5 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadAbsRsp)localObject3).msg_download_info.get();
      localObject4 = ((cmd0x346.DownloadInfo)localObject5).str_download_ip.get();
      localObject3 = ((cmd0x346.DownloadInfo)localObject5).str_download_domain.get();
      j = ((cmd0x346.DownloadInfo)localObject5).uint32_port.get();
      localObject2 = ((cmd0x346.DownloadInfo)localObject5).str_download_url.get();
      if (((cmd0x346.DownloadInfo)localObject5).str_cookie.has()) {
        localObject1 = "FTN5K=" + ((cmd0x346.DownloadInfo)localObject5).str_cookie.get();
      }
      String str = aqhs.bytes2HexStr(((cmd0x346.DownloadInfo)localObject5).bytes_download_key.get().toByteArray());
      bool = true;
      ProtoReqManager.d locald = paramd;
      localObject5 = localObject1;
      paramd = (ProtoReqManager.d)localObject2;
      localObject1 = localObject3;
      localObject2 = localObject4;
      localObject3 = str;
      localObject4 = locald;
      break;
      label746:
      if (i == -100003)
      {
        i = 9045;
        continue;
        label760:
        this.app.a().b(bool, 18, new Object[] { Integer.valueOf(i), localObject4, localObject5, localObject3, localObject2, localObject1, Integer.valueOf(j) });
        return;
      }
    }
  }
  
  private void i(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    int i = 0;
    audw.b localb = null;
    String str = null;
    long l1 = 0L;
    long l2 = 0L;
    boolean bool;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      l1 = 0L;
      l2 = 0L;
      str = null;
      paramd = null;
      i = -100001;
      bool = false;
    }
    for (;;)
    {
      if (i != 0) {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleForwardResponse: return " + bool + ", retCode=" + i + ", retMsg=" + paramd + ", totalSpace=" + l2 + ", usedSpace=" + l1);
      }
      long l3 = ((atsq.a)paramc.fi).fD();
      paramc = this.app.a().b(l3);
      audx.a(this.app, paramc);
      if (bool)
      {
        localb = new audw.b();
        localb.bJE = "send_file_suc";
        localb.cYX = 1;
        audw.a(this.app.getCurrentAccountUin(), localb);
      }
      this.app.a().a(bool, i, paramd, str, l3);
      this.app.a().b(bool, 19, new Object[] { Integer.valueOf(i), paramd, Long.valueOf(l2), Long.valueOf(l1), str, Long.valueOf(l3) });
      if ((paramc.nOpType == 26) || (paramc.nOpType == 27)) {}
      try
      {
        ((ahbm)paramc.mContext).a(bool, paramc.strTroopFileUuid, paramc.nSessionId, i, paramd, String.valueOf(paramc.peerUin), str);
        return;
      }
      catch (Exception paramc)
      {
        Object localObject;
        label547:
        paramc.printStackTrace();
        QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: Exception is " + paramc.toString());
      }
      if (paramd.g.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is failed[" + paramd.g.getResultCode() + "]");
        l1 = 0L;
        l2 = 0L;
        str = null;
        paramd = null;
        i = -100002;
        bool = false;
      }
      else
      {
        paramd = paramd.g.getWupBuffer();
        localObject = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject).mergeFrom(paramd);
          if (((cmd0x346.RspBody)localObject).msg_apply_forward_file_rsp.has()) {
            break label547;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse rspBody has not hasMsgApplyForwardFileRsp");
          l1 = 0L;
          l2 = 0L;
          str = null;
          paramd = null;
          i = -100003;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
          l1 = 0L;
          l2 = 0L;
          str = null;
          paramd = null;
          i = -100003;
          bool = false;
        }
        continue;
        localObject = (cmd0x346.ApplyForwardFileRsp)((cmd0x346.RspBody)localObject).msg_apply_forward_file_rsp.get();
        if (((cmd0x346.ApplyForwardFileRsp)localObject).int32_ret_code.has()) {
          i = ((cmd0x346.ApplyForwardFileRsp)localObject).int32_ret_code.get();
        }
        paramd = localb;
        if (((cmd0x346.ApplyForwardFileRsp)localObject).str_ret_msg.has()) {
          paramd = ((cmd0x346.ApplyForwardFileRsp)localObject).str_ret_msg.get();
        }
        if (((cmd0x346.ApplyForwardFileRsp)localObject).bytes_uuid.has()) {
          str = new String(((cmd0x346.ApplyForwardFileRsp)localObject).bytes_uuid.get().toByteArray());
        }
        if (((cmd0x346.ApplyForwardFileRsp)localObject).uint64_total_space.has()) {
          l1 = ((cmd0x346.ApplyForwardFileRsp)localObject).uint64_total_space.get();
        }
        if (((cmd0x346.ApplyForwardFileRsp)localObject).uint64_used_space.has()) {
          l2 = ((cmd0x346.ApplyForwardFileRsp)localObject).uint64_used_space.get();
        }
        l3 = l1;
        bool = true;
        l1 = l2;
        l2 = l3;
      }
    }
  }
  
  private void j(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    boolean bool = false;
    int i = 0;
    Object localObject1 = null;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      paramd = null;
      localObject1 = null;
      i = -100001;
    }
    label89:
    long l;
    Object localObject2;
    for (;;)
    {
      if (i != 0)
      {
        bool = false;
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleForwardFromOfflineResponse: return " + bool + ", retCode=" + i + ", retMsg=" + (String)localObject1);
        }
        l = ((atsq.a)paramc.fi).fD();
        paramc = this.app.a().b(l);
        if (paramc == null)
        {
          QLog.e("FileTransferHandler<FileAssistant>", 1, "forward offline file, but entity is null!!!");
          return;
          if (paramd.g.getResultCode() != 1000)
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: resp is failed[" + paramd.g.getResultCode() + "]");
            paramd = null;
            localObject1 = null;
            i = -100002;
            continue;
          }
          paramd = paramd.g.getWupBuffer();
          localObject2 = new cmd0x346.RspBody();
          try
          {
            ((cmd0x346.RspBody)localObject2).mergeFrom(paramd);
            if (((cmd0x346.RspBody)localObject2).msg_apply_copy_to_rsp.has()) {
              break label322;
            }
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse rspBody has not hasMsgApplyDownloadAbsRsp");
            paramd = null;
            localObject1 = null;
            i = -100003;
          }
          catch (InvalidProtocolBufferMicroException paramd)
          {
            paramd.printStackTrace();
            paramd = null;
            localObject1 = null;
            i = -100003;
          }
          continue;
          label322:
          localObject2 = (cmd0x346.ApplyCopyToRsp)((cmd0x346.RspBody)localObject2).msg_apply_copy_to_rsp.get();
          if (((cmd0x346.ApplyCopyToRsp)localObject2).int32_ret_code.has()) {
            i = ((cmd0x346.ApplyCopyToRsp)localObject2).int32_ret_code.get();
          }
          paramd = (ProtoReqManager.d)localObject1;
          if (((cmd0x346.ApplyCopyToRsp)localObject2).str_ret_msg.has()) {
            paramd = ((cmd0x346.ApplyCopyToRsp)localObject2).str_ret_msg.get();
          }
          if (!((cmd0x346.ApplyCopyToRsp)localObject2).str_file_key.has()) {
            break label1286;
          }
        }
      }
    }
    label1286:
    for (localObject1 = ((cmd0x346.ApplyCopyToRsp)localObject2).str_file_key.get();; localObject1 = null)
    {
      localObject2 = paramd;
      bool = true;
      paramd = (ProtoReqManager.d)localObject1;
      localObject1 = localObject2;
      break;
      if (bool)
      {
        localObject2 = new audw.b();
        ((audw.b)localObject2).bJE = "send_file_suc";
        ((audw.b)localObject2).cYX = 1;
        audw.a(this.app.getCurrentAccountUin(), (audw.b)localObject2);
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
      switch (paramc.nOpType)
      {
      default: 
        return;
      case 4: 
        if (((paramd == null) || (paramd.length() < 1)) && (QLog.isColorLevel())) {
          QLog.w("FileTransferHandler<FileAssistant>", 2, "forward offline to weiyun ,but weiyun fileid is null! retCode[" + String.valueOf(i) + "retMsg[" + String.valueOf(localObject1) + "]");
        }
        if (bool)
        {
          paramc.status = 1;
          paramc.setCloudType(2);
        }
      case 7: 
      case 28: 
        for (;;)
        {
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
          paramc.WeiYunFileId = paramd;
          this.app.a().u(paramc);
          this.app.a().b(bool, 34, new Object[] { Integer.valueOf(i), localObject1, paramd, Long.valueOf(l) });
          return;
          if (((paramd == null) || (paramd.length() < 1)) && (QLog.isColorLevel())) {
            QLog.w("FileTransferHandler<FileAssistant>", 2, "forward offline to weiyun ,but weiyun fileid is null! retCode[" + String.valueOf(i) + "retMsg[" + String.valueOf(localObject1) + "]");
          }
          if (bool) {}
          for (paramc.status = 1;; paramc.status = 0)
          {
            if (bool)
            {
              paramc.Uuid = paramd;
              paramc.cloudId = null;
              paramc.cloudIdHex = null;
              paramc.pDirKey = null;
              paramc.cloudFile = null;
              paramc.setCloudType(1);
              paramc.peerType = 3000;
              a(paramc.nSessionId, paramc.peerUin, this.app.getCurrentAccountUin(), paramc.fileName, paramc.fileSize, paramd, paramc.uniseq, paramc.msgUid, new atsv(this, paramc));
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
            this.app.a().b(bool, 19, new Object[] { Integer.valueOf(i), localObject1, Long.valueOf(0L), Long.valueOf(0L), paramd, Long.valueOf(l) });
            return;
          }
          paramc.status = 0;
        }
      case 26: 
      case 27: 
      case 32: 
        try
        {
          ((ahbm)paramc.mContext).a(bool, paramc.strTroopFileUuid, paramc.nSessionId, i, (String)localObject1, String.valueOf(paramc.peerUin), paramd);
          return;
        }
        catch (Exception paramc)
        {
          paramc.printStackTrace();
          QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: Exception is " + paramc.toString());
          return;
        }
      }
      try
      {
        ((ahbm)paramc.mContext).b(bool, paramc.datalineEntitySessionId, i, (String)localObject1, null, null, paramd);
        return;
      }
      catch (Exception paramc)
      {
        paramc.printStackTrace();
        QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: Exception is " + paramc.toString());
        return;
      }
      break label89;
    }
  }
  
  private void k(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    WeiYunFileInfo localWeiYunFileInfo = null;
    boolean bool;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      i = -100001;
      bool = false;
      paramd = localWeiYunFileInfo;
    }
    while (i != 0)
    {
      bool = false;
      label85:
      paramc = ((atsq.a)paramc.fi).uY();
      localWeiYunFileInfo = atwb.a(paramc);
      if ((QLog.isColorLevel()) && (localWeiYunFileInfo != null)) {
        QLog.i("FileTransferHandler<FileAssistant>", 2, "handleRemoveResponse, bSucess[" + String.valueOf(bool) + "],fileName[" + localWeiYunFileInfo.strFileName + "],uuid[" + paramc + "]");
      }
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
            break label369;
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
        label369:
        paramd = (cmd0x346.DeleteFileRsp)localRspBody.msg_delete_file_rsp.get();
        if (!paramd.int32_ret_code.has()) {
          break label431;
        }
      }
    }
    label431:
    for (int i = paramd.int32_ret_code.get();; i = 0)
    {
      if (paramd.str_ret_msg.has()) {}
      for (paramd = paramd.str_ret_msg.get();; paramd = null)
      {
        bool = true;
        break;
        break label85;
      }
    }
  }
  
  private void l(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    atsq.a locala = (atsq.a)paramc.fi;
    switch (locala.Ed())
    {
    case 9: 
    default: 
      QLog.e("FileTransferHandler<FileAssistant>", 1, "handleDiscGetFileInfo: subcmd[" + locala.Ed() + "] is not implemented");
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
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is timeout[" + paramd.g.getResultCode() + "]");
      str = null;
      i = -100001;
      bool = false;
    }
    label97:
    long l;
    for (paramd = "";; paramd = "")
    {
      if (i != 0) {
        bool = false;
      }
      if (str != null) {
        break label733;
      }
      bool = false;
      l = ((atsq.a)paramc.fi).fD();
      paramc = this.app.a().b(l);
      if (paramc != null) {
        break label370;
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
          break label742;
        }
        i = ((cmd0x345.RspBody)localObject).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject).msg_subcmd_0x5_rsp_body.has()) {
          break label307;
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
      label307:
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
        label370:
        if (bool)
        {
          paramc.Uuid = str;
          paramc.cloudId = null;
          paramc.cloudIdHex = null;
          paramc.pDirKey = null;
          paramc.cloudFile = null;
          paramc.setCloudType(1);
          this.app.a().b(bool, 19, new Object[] { Integer.valueOf(i), paramd, Long.valueOf(0L), Long.valueOf(0L), str, Long.valueOf(l) });
          a(l, paramc.peerUin, this.app.getCurrentAccountUin(), paramc.fileName, paramc.fileSize, str, paramc.uniseq, paramc.msgUid, new atss(this, paramc));
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
        label733:
        break label97;
      }
      label742:
      i = 0;
    }
  }
  
  private void n(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    String str3 = "";
    String str4 = "";
    String str2 = "";
    String str1 = "";
    String str5 = "";
    int j = 0;
    boolean bool;
    int i;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool = false;
      i = -100001;
      paramd = str5;
    }
    label105:
    cmd0x345.RspBody localRspBody;
    for (;;)
    {
      if (i != 0)
      {
        bool = false;
        paramc = (atsq.a)paramc.fi;
        if (paramc.ale())
        {
          long l = paramc.fD();
          this.app.a().b(bool, 192, new Object[] { Integer.valueOf(i), str3, paramd, str4, str2, str1, Integer.valueOf(j), null, Long.valueOf(l) });
          return;
          if (paramd.g.getResultCode() != 1000)
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: resp is failed[" + paramd.g.getResultCode() + "]");
            bool = false;
            i = -100002;
            paramd = str5;
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
          break label518;
        }
        i = localRspBody.uint32_return_code.get();
        if (localRspBody.msg_subcmd_0x7_rsp_body.has()) {
          break label362;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        bool = false;
        i = -100003;
        paramd = str5;
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
        bool = false;
        i = -100003;
        paramd = str5;
      }
      break;
      label362:
      paramd = (cmd0x345.RspBody.SubCmd0x7RspBody)localRspBody.msg_subcmd_0x7_rsp_body.get();
      str2 = paramd.str_server_ip.get();
      str1 = paramd.str_dns.get();
      j = paramd.uint32_server_port.get();
      str4 = paramd.str_url.get();
      str3 = paramd.str_ret_msg.get();
      paramd = "FTN5K=" + paramd.bytes_cookie.get().toStringUtf8();
      bool = true;
      break;
      this.app.a().b(bool, 21, new Object[] { Integer.valueOf(i), str3, paramd, str4, str2, str1, Integer.valueOf(j) });
      return;
      break label105;
      label518:
      i = 0;
    }
  }
  
  private void o(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    String str = "";
    int i;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: resp is timeout[" + paramd.g.getResultCode() + "]");
      str = null;
      paramd = "";
    }
    long l;
    for (boolean bool = false;; bool = false)
    {
      if (i != 0) {
        bool = false;
      }
      if (str == null) {
        bool = false;
      }
      l = ((atsq.a)paramc.fi).fD();
      paramc = this.app.a().b(l);
      if (paramc != null) {
        break label370;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
      return;
      if (paramd.g.getResultCode() == 1000) {
        break;
      }
      i = -100002;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: resp is failed[" + paramd.g.getResultCode() + "]");
      str = null;
      paramd = "";
    }
    paramd = paramd.g.getWupBuffer();
    Object localObject = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x345.RspBody)localObject).mergeFrom(paramd);
        if (!((cmd0x345.RspBody)localObject).uint32_return_code.has()) {
          break label1133;
        }
        i = ((cmd0x345.RspBody)localObject).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject).msg_subcmd_0x6_rsp_body.has()) {
          break label307;
        }
        i = -100003;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        str = null;
        paramd = "";
        bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
        i = -100003;
        str = null;
        paramd = "";
        bool = false;
      }
      break;
      label307:
      localObject = (cmd0x345.RspBody.SubCmd0x6RspBody)((cmd0x345.RspBody)localObject).msg_subcmd_0x6_rsp_body.get();
      paramd = str;
      if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_ret_msg.has()) {
        paramd = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_ret_msg.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_file_id.has()) {}
      for (str = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_file_id.get();; str = null)
      {
        bool = true;
        break;
        label370:
        paramc.status = 0;
        if (bool)
        {
          paramc.status = 1;
          switch (paramc.nOpType)
          {
          default: 
            if (QLog.isDevelopLevel()) {
              throw new NullPointerException("类型错误！");
            }
            break;
          case 21: 
            paramc.Uuid = str;
            paramc.cloudId = null;
            paramc.cloudIdHex = null;
            paramc.pDirKey = null;
            paramc.cloudFile = null;
            paramc.setCloudType(1);
            this.app.a().b(bool, 19, new Object[] { Integer.valueOf(i), paramd, Long.valueOf(0L), Long.valueOf(0L), str, Long.valueOf(l) });
            a(paramc.peerUin, paramc, new atst(this, paramc));
            this.app.a().a(paramc, 6, null);
          }
        }
        for (;;)
        {
          this.app.a().u(paramc);
          return;
          paramc.WeiYunFileId = str;
          paramc.setCloudType(2);
          this.app.a().b(bool, 34, new Object[] { Integer.valueOf(i), paramd, str, Long.valueOf(l) });
          continue;
          if ((paramc.mContext instanceof ahbm))
          {
            ((ahbm)paramc.mContext).a(bool, paramc.strTroopFileUuid, paramc.nSessionId, i, paramd, String.valueOf(paramc.peerUin), str);
            continue;
            switch (paramc.nOpType)
            {
            default: 
              if (QLog.isDevelopLevel()) {
                throw new NullPointerException("类型错误！");
              }
              break;
            case 21: 
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
              break;
            case 20: 
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
              this.app.a().b(bool, 34, new Object[] { Integer.valueOf(i), paramd, str, Long.valueOf(l) });
              break;
            case 27: 
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
              if ((paramc.mContext instanceof ahbm)) {
                ((ahbm)paramc.mContext).a(bool, paramc.strTroopFileUuid, paramc.nSessionId, i, paramd, String.valueOf(paramc.peerUin), str);
              }
              break;
            }
          }
        }
      }
      label1133:
      i = 0;
    }
  }
  
  private void p(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    String str1 = "";
    String str2 = "";
    Object localObject4 = "";
    long l1;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: resp is timeout[" + paramd.g.getResultCode() + "]");
      localObject3 = "";
      l1 = -100001L;
      localObject1 = "";
    }
    Object localObject5;
    long l2;
    label123:
    boolean bool;
    for (int i = 80;; i = 80)
    {
      if (l1 != 0L) {}
      localObject5 = (atsq.a)paramc.fi;
      if (l1 != -100001L) {
        break label707;
      }
      l2 = 9043L;
      if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
        break label791;
      }
      bool = true;
      label139:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("internalDownloadDiscFile: return ").append(bool).append(", retCode=").append(l2).append(", strHost=").append((String)localObject3).append(", strCheckSum=");
        if (localObject1 == null) {
          break label797;
        }
        paramc = (ProtoReqManager.c)localObject1;
        label201:
        QLog.d("FileTransferHandler<FileAssistant>", 2, paramc + ", strCookie=" + str1 + ", port=" + i);
      }
      a(((atsq.a)localObject5).a(), 5013, bool, new Object[] { Long.valueOf(l2), str2, localObject4, localObject3, Integer.valueOf(i), localObject1, str1, Integer.valueOf(paramd.g.getAppSeq()), Long.valueOf(((atsq.a)localObject5).fD()) });
      return;
      if (paramd.g.getResultCode() == 1000) {
        break;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: resp is failed[" + paramd.g.getResultCode() + "]");
      localObject3 = "";
      l1 = -100002L;
      localObject1 = "";
    }
    Object localObject1 = paramd.g.getWupBuffer();
    Object localObject3 = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x345.RspBody)localObject3).mergeFrom((byte[])localObject1);
        if (!((cmd0x345.RspBody)localObject3).uint32_return_code.has()) {
          break label844;
        }
        l1 = ((cmd0x345.RspBody)localObject3).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject3).msg_subcmd_0x3_rsp_body.has()) {
          break label510;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        localObject3 = "";
        l1 = -100003L;
        localObject1 = "";
        i = 80;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        localObject3 = "";
        l1 = -100003L;
        localObject2 = "";
        i = 80;
      }
      break;
      label510:
      localObject4 = (cmd0x345.RspBody.SubCmd0x3RspBody)((cmd0x345.RspBody)localObject3).msg_subcmd_0x3_rsp_body.get();
      if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).str_host.has()) {}
      for (Object localObject2 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).str_host.get();; localObject2 = "")
      {
        if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).uint32_port.has()) {}
        for (i = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).uint32_port.get();; i = 80)
        {
          if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).str_check_sum.has()) {}
          for (localObject3 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).str_check_sum.get();; localObject3 = "")
          {
            if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).str_cookie.has()) {}
            for (str1 = "FTN5K=" + ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).str_cookie.get();; str1 = "")
            {
              if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).int32_ret_code.has()) {
                l1 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).int32_ret_code.get();
              }
              if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).str_ret_msg.has()) {}
              for (str2 = ((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).str_ret_msg.get();; str2 = "")
              {
                if (((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).str_suggest_file_name.has()) {}
                for (localObject4 = audx.getFileName(((cmd0x345.RspBody.SubCmd0x3RspBody)localObject4).str_suggest_file_name.get());; localObject4 = "")
                {
                  localObject5 = localObject2;
                  localObject2 = localObject3;
                  localObject3 = localObject5;
                  break;
                  label707:
                  if (l1 == -100003L)
                  {
                    l2 = 9045L;
                    break label123;
                  }
                  if ((l1 == 0L) && (localObject3 == null)) {}
                  for (int j = 1;; j = 0)
                  {
                    int k = ((atsq.a)localObject5).Ee();
                    l2 = l1;
                    if (j == 0) {
                      break;
                    }
                    l2 = l1;
                    if (k >= 3) {
                      break;
                    }
                    ((atsq.a)localObject5).dgs();
                    a(paramc.clW, paramc.fW, (atsq.a)localObject5);
                    return;
                  }
                  label791:
                  bool = false;
                  break label139;
                  label797:
                  paramc = "";
                  break label201;
                }
              }
            }
          }
        }
      }
      label844:
      l1 = 0L;
    }
  }
  
  private void q(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    Object localObject2 = "";
    String str1 = "";
    int i = 0;
    String str2 = "";
    Object localObject3 = "";
    Object localObject1;
    boolean bool;
    long l;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is timeout[" + paramd.g.getResultCode() + "]");
      localObject1 = "";
      bool = false;
      paramd = "";
      l = -100001L;
    }
    label108:
    Object localObject4;
    for (;;)
    {
      if (l != 0L)
      {
        bool = false;
        localObject4 = (atsq.a)paramc.fi;
        if (l == -100001L)
        {
          l = 9043L;
          label131:
          a(((atsq.a)localObject4).a(), 5015, bool, new Object[] { Long.valueOf(l), localObject1, paramd, localObject2, str1, Integer.valueOf(i), str2, localObject3 });
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
          break label686;
        }
        l = ((cmd0x345.RspBody)localObject1).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject1).msg_subcmd_0x1_rsp_body.has()) {
          break label375;
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
      label375:
      localObject3 = (cmd0x345.RspBody.SubCmd0x1RspBody)((cmd0x345.RspBody)localObject1).msg_subcmd_0x1_rsp_body.get();
      if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).str_file_id.has()) {}
      for (paramd = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).str_file_id.get();; paramd = "")
      {
        if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).str_file_key.has()) {}
        for (localObject2 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).str_file_key.get();; localObject2 = "")
        {
          if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).str_check_sum.has()) {}
          for (localObject1 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).str_check_sum.get();; localObject1 = "")
          {
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).str_host.has()) {}
            for (str1 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).str_host.get();; str1 = "")
            {
              if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).uint32_port.has()) {}
              for (i = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).uint32_port.get();; i = 0)
              {
                if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).str_file_name.has()) {}
                for (str2 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).str_file_name.get();; str2 = "")
                {
                  if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).str_warn.has()) {}
                  for (localObject3 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject3).str_warn.get();; localObject3 = "")
                  {
                    localObject4 = localObject2;
                    ProtoReqManager.d locald = paramd;
                    bool = true;
                    localObject2 = localObject1;
                    paramd = (ProtoReqManager.d)localObject4;
                    localObject1 = locald;
                    break;
                    if (l == -100003L)
                    {
                      l = 9045L;
                      break label131;
                    }
                    if ((str1 == null) || (str1.length() == 0)) {}
                    for (int j = 1;; j = 0)
                    {
                      int k = ((atsq.a)localObject4).Ee();
                      if ((j == 0) || (k >= 3)) {
                        break;
                      }
                      ((atsq.a)localObject4).dgs();
                      a(paramc.clW, paramc.fW, (atsq.a)localObject4);
                      return;
                    }
                    break label131;
                    break label108;
                  }
                }
              }
            }
          }
        }
      }
      label686:
      l = 0L;
    }
  }
  
  private void r(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    paramc = (atsq.a)paramc.fi;
    long l2 = paramc.fD();
    long l1;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      l1 = -100001L;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is timeout[" + paramd.g.getResultCode() + "]");
    }
    for (boolean bool = false;; bool = false)
    {
      if (l1 != 0L) {
        bool = false;
      }
      if (l2 != 0L) {
        break label296;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "why there is 0?!");
      label112:
      a(paramc.a(), 5016, bool, new Object[] { Long.valueOf(l1) });
      return;
      if (paramd.g.getResultCode() == 1000) {
        break;
      }
      l1 = -100002L;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is failed[" + paramd.g.getResultCode() + "]");
    }
    paramd = paramd.g.getWupBuffer();
    cmd0x345.RspBody localRspBody = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramd);
        if (!localRspBody.uint32_return_code.has()) {
          break label410;
        }
        l1 = localRspBody.uint32_return_code.get();
        if (localRspBody.msg_subcmd_0x2_rsp_body.has()) {
          break label290;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: rspBody has not hasMsgApplyDownloadRsp");
        l1 = -100003L;
        bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
        l1 = -100003L;
        bool = false;
      }
      break;
      label290:
      bool = true;
      break;
      label296:
      paramd = this.app.a().b(l2);
      if (paramd == null) {
        break label112;
      }
      if (bool)
      {
        paramd.status = 1;
        this.app.a().a(paramd, 6, "");
      }
      for (;;)
      {
        this.app.a().u(paramd);
        break;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "nSessionId[" + l2 + "] sendDiscFeed faild,retCode[" + l1 + "]");
        paramd.status = 0;
        a(l1, paramd);
      }
      label410:
      l1 = 0L;
    }
  }
  
  private void s(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    agib.b localb = new agib.b();
    Object localObject1 = null;
    boolean bool;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      localb.retCode = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool = false;
    }
    int i;
    label115:
    int j;
    label135:
    label210:
    cmd0x346.RspBody localRspBody;
    for (;;)
    {
      localb.cXe = 2;
      if ((localb.strIP == null) || (localb.strIP.length() <= 0)) {
        break label882;
      }
      i = 1;
      if ((localb.uuid != null) && (localb.uuid.length != 0)) {
        break label887;
      }
      j = 1;
      Object localObject2 = new achq.a();
      ((achq.a)localObject2).errCode = localb.retCode;
      ((achq.a)localObject2).retryCount = paramd.dPU;
      if ((j == 0) || (i == 0)) {
        break label893;
      }
      localb.retMsg = ("uuid_null[" + localb.toString() + "]");
      bool = false;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool + ", retCode=" + localb.retCode + ", retMsg=" + localb.retMsg + ", totalSpace=" + localb.totalSpace + ", usedSpace=" + localb.usedSpace + ", ip=" + localb.strIP + ", port=" + localb.ag);
      }
      a(((atsq.a)paramc.fi).a(), 5004, bool, new Object[] { localb, localObject2, localObject1 });
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        localb.retCode = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is failed[" + paramd.g.getResultCode() + "]");
        bool = false;
      }
      else
      {
        localObject2 = paramd.g.getWupBuffer();
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject2);
          if (localRspBody.msg_apply_upload_rsp_v3.has()) {
            break;
          }
          localb.retCode = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localb.retCode = -100003;
          bool = false;
        }
      }
    }
    localObject1 = (cmd0x346.ApplyUploadRspV3)localRspBody.msg_apply_upload_rsp_v3.get();
    if (((cmd0x346.ApplyUploadRspV3)localObject1).int32_ret_code.has()) {
      localb.retCode = ((cmd0x346.ApplyUploadRspV3)localObject1).int32_ret_code.get();
    }
    if (((cmd0x346.ApplyUploadRspV3)localObject1).str_ret_msg.has()) {
      localb.retMsg = ((cmd0x346.ApplyUploadRspV3)localObject1).str_ret_msg.get();
    }
    if (((cmd0x346.ApplyUploadRspV3)localObject1).uint64_total_space.has()) {
      localb.totalSpace = ((cmd0x346.ApplyUploadRspV3)localObject1).uint64_total_space.get();
    }
    if (((cmd0x346.ApplyUploadRspV3)localObject1).uint64_used_space.has()) {
      localb.usedSpace = ((cmd0x346.ApplyUploadRspV3)localObject1).uint64_used_space.get();
    }
    if (((cmd0x346.ApplyUploadRspV3)localObject1).uint64_uploaded_size.has()) {
      localb.fileSize = ((cmd0x346.ApplyUploadRspV3)localObject1).uint64_uploaded_size.get();
    }
    if (((cmd0x346.ApplyUploadRspV3)localObject1).str_upload_ip.has())
    {
      localb.strIP = ((cmd0x346.ApplyUploadRspV3)localObject1).str_upload_ip.get();
      label672:
      if (((cmd0x346.ApplyUploadRspV3)localObject1).uint32_upload_port.has()) {
        localb.ag = ((short)((cmd0x346.ApplyUploadRspV3)localObject1).uint32_upload_port.get());
      }
      if (((cmd0x346.ApplyUploadRspV3)localObject1).bytes_uuid.has()) {
        localb.uuid = ((cmd0x346.ApplyUploadRspV3)localObject1).bytes_uuid.get().toByteArray();
      }
      if (((cmd0x346.ApplyUploadRspV3)localObject1).bytes_upload_key.has()) {
        localb.key = ((cmd0x346.ApplyUploadRspV3)localObject1).bytes_upload_key.get().toByteArray();
      }
      if (((cmd0x346.ApplyUploadRspV3)localObject1).bool_file_exist.has()) {
        localb.fileExist = ((cmd0x346.ApplyUploadRspV3)localObject1).bool_file_exist.get();
      }
      if (((cmd0x346.ApplyUploadRspV3)localObject1).uint32_upload_port.has()) {
        localb.packetSize = ((cmd0x346.ApplyUploadRspV3)localObject1).uint32_pack_size.get();
      }
      if ((!((cmd0x346.ApplyUploadRspV3)localObject1).rpt_str_uploadip_list.has()) || (((cmd0x346.ApplyUploadRspV3)localObject1).rpt_str_uploadip_list.get().size() <= 0)) {
        break label896;
      }
    }
    label896:
    for (localObject1 = ((cmd0x346.ApplyUploadRspV3)localObject1).rpt_str_uploadip_list.get();; localObject1 = null)
    {
      bool = true;
      break;
      if (((cmd0x346.ApplyUploadRspV3)localObject1).str_upload_domain.has())
      {
        localb.strIP = ((cmd0x346.ApplyUploadRspV3)localObject1).str_upload_domain.get();
        break label672;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
      break label672;
      label882:
      i = 0;
      break label115;
      label887:
      j = 0;
      break label135;
      label893:
      break label210;
    }
  }
  
  private void t(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    agib.b localb = new agib.b();
    Object localObject1 = null;
    boolean bool;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      localb.retCode = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool = false;
    }
    int i;
    label109:
    int j;
    for (;;)
    {
      if ((localb.strIP != null) && (localb.strIP.length() > 0))
      {
        i = 1;
        if ((localb.uuid != null) && (localb.uuid.length != 0)) {
          break label932;
        }
        j = 1;
        label129:
        Object localObject2 = new achq.a();
        ((achq.a)localObject2).errCode = localb.retCode;
        ((achq.a)localObject2).retryCount = paramd.dPU;
        if ((j == 0) || (i == 0)) {
          break label938;
        }
        localb.retMsg = ("uuid_null[" + localb.toString() + "]");
        bool = false;
        label204:
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool + ", retCode=" + localb.retCode + ", retMsg=" + localb.retMsg + ", totalSpace=" + localb.totalSpace + ", usedSpace=" + localb.usedSpace + ", ip=" + localb.strIP + ", port=" + localb.ag);
        }
        a(((atsq.a)paramc.fi).a(), 5004, bool, new Object[] { localb, localObject2, localObject1 });
        return;
        if (paramd.g.getResultCode() != 1000)
        {
          localb.retCode = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is failed[" + paramd.g.getResultCode() + "]");
          bool = false;
        }
        else
        {
          localObject2 = paramd.g.getWupBuffer();
          cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
          try
          {
            localRspBody.mergeFrom((byte[])localObject2);
            if (localRspBody.msg_apply_upload_rsp_v2.has()) {
              break label509;
            }
            localb.retCode = -100003;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
            bool = false;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
            localb.retCode = -100003;
            bool = false;
          }
          continue;
          label509:
          localObject1 = (cmd0x346.ApplyUploadRspV2)localRspBody.msg_apply_upload_rsp_v2.get();
          if (((cmd0x346.ApplyUploadRspV2)localObject1).int32_ret_code.has()) {
            localb.retCode = ((cmd0x346.ApplyUploadRspV2)localObject1).int32_ret_code.get();
          }
          if (((cmd0x346.ApplyUploadRspV2)localObject1).str_ret_msg.has()) {
            localb.retMsg = ((cmd0x346.ApplyUploadRspV2)localObject1).str_ret_msg.get();
          }
          if (((cmd0x346.ApplyUploadRspV2)localObject1).uint64_total_space.has()) {
            localb.totalSpace = ((cmd0x346.ApplyUploadRspV2)localObject1).uint64_total_space.get();
          }
          if (((cmd0x346.ApplyUploadRspV2)localObject1).uint64_used_space.has()) {
            localb.usedSpace = ((cmd0x346.ApplyUploadRspV2)localObject1).uint64_used_space.get();
          }
          if (((cmd0x346.ApplyUploadRspV2)localObject1).uint64_uploaded_size.has()) {
            localb.fileSize = ((cmd0x346.ApplyUploadRspV2)localObject1).uint64_uploaded_size.get();
          }
          if (((cmd0x346.ApplyUploadRspV2)localObject1).str_upload_ip.has())
          {
            localb.strIP = ((cmd0x346.ApplyUploadRspV2)localObject1).str_upload_ip.get();
            label666:
            if (((cmd0x346.ApplyUploadRspV2)localObject1).uint32_upload_port.has()) {
              localb.ag = ((short)((cmd0x346.ApplyUploadRspV2)localObject1).uint32_upload_port.get());
            }
            if (((cmd0x346.ApplyUploadRspV2)localObject1).bytes_uuid.has()) {
              localb.uuid = ((cmd0x346.ApplyUploadRspV2)localObject1).bytes_uuid.get().toByteArray();
            }
            if (((cmd0x346.ApplyUploadRspV2)localObject1).bytes_upload_key.has()) {
              localb.key = ((cmd0x346.ApplyUploadRspV2)localObject1).bytes_upload_key.get().toByteArray();
            }
            if (((cmd0x346.ApplyUploadRspV2)localObject1).bool_file_exist.has()) {
              localb.fileExist = ((cmd0x346.ApplyUploadRspV2)localObject1).bool_file_exist.get();
            }
            if (((cmd0x346.ApplyUploadRspV2)localObject1).uint32_upload_port.has()) {
              localb.packetSize = ((cmd0x346.ApplyUploadRspV2)localObject1).uint32_pack_size.get();
            }
            if (((cmd0x346.ApplyUploadRspV2)localObject1).uint32_httpsvr_api_ver.has()) {
              localb.cXe = ((cmd0x346.ApplyUploadRspV2)localObject1).uint32_httpsvr_api_ver.get();
            }
            if (((cmd0x346.ApplyUploadRspV2)localObject1).bytes_sha.has()) {
              localb.sha = ((cmd0x346.ApplyUploadRspV2)localObject1).bytes_sha.get().toByteArray();
            }
            if ((!((cmd0x346.ApplyUploadRspV2)localObject1).rpt_str_uploadip_list.has()) || (((cmd0x346.ApplyUploadRspV2)localObject1).rpt_str_uploadip_list.get().size() <= 0)) {
              break label941;
            }
          }
        }
      }
    }
    label932:
    label938:
    label941:
    for (localObject1 = ((cmd0x346.ApplyUploadRspV2)localObject1).rpt_str_uploadip_list.get();; localObject1 = null)
    {
      bool = true;
      break;
      if (((cmd0x346.ApplyUploadRspV2)localObject1).str_upload_domain.has())
      {
        localb.strIP = ((cmd0x346.ApplyUploadRspV2)localObject1).str_upload_domain.get();
        break label666;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
      break label666;
      i = 0;
      break label109;
      j = 0;
      break label129;
      break label204;
    }
  }
  
  private void u(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    agib.b localb = new agib.b();
    boolean bool;
    int i;
    label106:
    int j;
    label126:
    Object localObject;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      localb.retCode = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool = false;
      if ((localb.strIP == null) || (localb.strIP.length() <= 0)) {
        break label763;
      }
      i = 1;
      if ((localb.uuid != null) && (localb.uuid.length != 0)) {
        break label768;
      }
      j = 1;
      localObject = new achq.a();
      ((achq.a)localObject).errCode = localb.retCode;
      ((achq.a)localObject).retryCount = paramd.dPU;
      if ((j == 0) || (i == 0)) {
        break label774;
      }
      localb.retMsg = ("uuid_null[" + localb.toString() + "]");
      bool = false;
    }
    label768:
    label774:
    for (;;)
    {
      cmd0x346.RspBody localRspBody;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool + ", retCode=" + localb.retCode + ", retMsg=" + localb.retMsg + ", totalSpace=" + localb.totalSpace + ", usedSpace=" + localb.usedSpace + ", ip=" + localb.strIP + ", port=" + localb.ag);
        }
        a(((atsq.a)paramc.fi).a(), 5020, bool, new Object[] { localb, localObject, null });
        return;
        if (paramd.g.getResultCode() != 1000)
        {
          localb.retCode = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is failed[" + paramd.g.getResultCode() + "]");
          bool = false;
          break;
        }
        localObject = paramd.g.getWupBuffer();
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_apply_upload_hit_rsp_v2.has()) {
            break label505;
          }
          localb.retCode = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
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
      label505:
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
        bool = true;
        break;
        if (localApplyUploadHitRspV2.str_upload_domain.has()) {
          localb.strIP = localApplyUploadHitRspV2.str_upload_domain.get();
        } else {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
        }
      }
      label763:
      i = 0;
      break label106;
      j = 0;
      break label126;
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
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
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
        label109:
        paramc = (atwa.a)((atsq.a)paramc.fi).getObject();
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
              break label328;
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
          label328:
          paramd = (cmd0x346.RecallFileRsp)localRspBody.msg_recall_file_rsp.get();
          if (!paramd.int32_ret_code.has()) {
            break label399;
          }
        }
      }
    }
    label399:
    for (i = paramd.int32_ret_code.get();; i = 0)
    {
      if (paramd.str_ret_msg.has()) {}
      for (paramd = paramd.str_ret_msg.get();; paramd = null)
      {
        bool1 = true;
        break;
        paramc.onError(i, paramd);
        return;
        break label109;
      }
    }
  }
  
  private void w(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    boolean bool2 = false;
    String str = "";
    int i;
    boolean bool1;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is timeout[" + paramd.g.getResultCode() + "]");
      bool1 = false;
      paramd = str;
    }
    label90:
    cmd0x345.RspBody localRspBody;
    for (;;)
    {
      if (i != 0)
      {
        bool1 = bool2;
        paramc = (atwa.a)((atsq.a)paramc.fi).getObject();
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
          break label406;
        }
        i = localRspBody.uint32_return_code.get();
        if (localRspBody.msg_subcmd_0xa_rsp_body.has()) {
          break label340;
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
      label340:
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
        break label90;
      }
      label406:
      i = 0;
    }
  }
  
  public void Zc(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "PreviewOfflineFile : FileUUID[" + paramString + "]");
    }
    Object localObject = new cmd0x346.ApplyDownloadAbsReq();
    ((cmd0x346.ApplyDownloadAbsReq)localObject).uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    ((cmd0x346.ApplyDownloadAbsReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    paramString = new cmd0x346.ReqBody();
    paramString.msg_apply_download_abs_req.set((MessageMicro)localObject);
    paramString.uint32_cmd.set(1100);
    localObject = paramString.uint32_seq;
    int i = cRe;
    cRe = i + 1;
    ((PBUInt32Field)localObject).set(i);
    paramString.uint32_business_id.set(3);
    paramString.uint32_client_type.set(104);
    localObject = new atsq.a();
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100", paramString.toByteArray(), (atsq.a)localObject, 30000, 3, 1);
  }
  
  public cmd0x346.ApplyUploadHitReqV2 a(aude paramaude)
  {
    cmd0x346.ApplyUploadHitReqV2 localApplyUploadHitReqV2 = new cmd0x346.ApplyUploadHitReqV2();
    paramaude = paramaude.jdField_a_of_type_Audb;
    localApplyUploadHitReqV2.uint64_sender_uin.set(paramaude.uint64_sender_uin);
    localApplyUploadHitReqV2.uint64_recver_uin.set(paramaude.uint64_recver_uin);
    localApplyUploadHitReqV2.uint64_file_size.set(paramaude.uint64_file_size);
    localApplyUploadHitReqV2.str_file_name.set(paramaude.str_file_name);
    localApplyUploadHitReqV2.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramaude.bytes_10m_md5));
    localApplyUploadHitReqV2.bytes_3sha.set(ByteStringMicro.copyFrom(paramaude.bytes_3sha));
    localApplyUploadHitReqV2.bytes_sha.set(ByteStringMicro.copyFrom(paramaude.bytes_sha));
    localApplyUploadHitReqV2.str_local_filepath.set(paramaude.str_local_filepath);
    localApplyUploadHitReqV2.uint32_danger_level.set(paramaude.uint32_danger_level);
    localApplyUploadHitReqV2.uint64_total_space.set(paramaude.uint64_total_space);
    return localApplyUploadHitReqV2;
  }
  
  public cmd0x346.ApplyUploadReqV2 a(aude paramaude)
  {
    cmd0x346.ApplyUploadReqV2 localApplyUploadReqV2 = new cmd0x346.ApplyUploadReqV2();
    paramaude = paramaude.jdField_a_of_type_Audc;
    localApplyUploadReqV2.uint64_sender_uin.set(paramaude.uint64_sender_uin);
    localApplyUploadReqV2.uint64_recver_uin.set(paramaude.uint64_recver_uin);
    localApplyUploadReqV2.uint64_file_size.set(paramaude.uint64_file_size);
    localApplyUploadReqV2.str_file_name.set(paramaude.str_file_name);
    localApplyUploadReqV2.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramaude.bytes_10m_md5));
    localApplyUploadReqV2.bytes_3sha.set(ByteStringMicro.copyFrom(paramaude.bytes_3sha));
    localApplyUploadReqV2.str_local_filepath.set(paramaude.str_local_filepath);
    localApplyUploadReqV2.uint32_danger_level.set(paramaude.uint32_danger_level);
    localApplyUploadReqV2.uint64_total_space.set(paramaude.uint64_total_space);
    return localApplyUploadReqV2;
  }
  
  public cmd0x346.ApplyUploadReqV3 a(aude paramaude)
  {
    cmd0x346.ApplyUploadReqV3 localApplyUploadReqV3 = new cmd0x346.ApplyUploadReqV3();
    paramaude = paramaude.jdField_a_of_type_Audd;
    localApplyUploadReqV3.uint64_sender_uin.set(paramaude.uint64_sender_uin);
    localApplyUploadReqV3.uint64_recver_uin.set(paramaude.uint64_recver_uin);
    localApplyUploadReqV3.uint64_file_size.set(paramaude.uint64_file_size);
    localApplyUploadReqV3.str_file_name.set(paramaude.str_file_name);
    localApplyUploadReqV3.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramaude.bytes_10m_md5));
    localApplyUploadReqV3.bytes_sha.set(ByteStringMicro.copyFrom(paramaude.bytes_sha));
    localApplyUploadReqV3.str_local_filepath.set(paramaude.str_local_filepath);
    localApplyUploadReqV3.uint32_danger_level.set(paramaude.uint32_danger_level);
    localApplyUploadReqV3.uint64_total_space.set(paramaude.uint64_total_space);
    return localApplyUploadReqV3;
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
    paramFileManagerEntity = new atsq.a(false, paramFileManagerEntity.nSessionId);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", ((cmd0x346.ReqBody)localObject1).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt2, String paramString3, atwg paramatwg, long paramLong2, int paramInt3)
  {
    if (!a(paramatwg)) {
      return;
    }
    switch (paramInt1)
    {
    case 130: 
    case 132: 
    default: 
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatwg.sessionid + "] handleOnLineFilePushMsg. error cmd:" + paramInt1);
      return;
    case 129: 
      QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatwg.sessionid + "] handle cmd 0x81. request");
      this.app.a().a(paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramatwg, paramLong2, paramInt3);
      return;
    case 131: 
      QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatwg.sessionid + "] handle cmd 0x83. accept");
      this.app.a().q(paramString1, paramatwg.sessionid, 1);
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatwg.sessionid + "] handle cmd 0x85. cancel.type:" + paramatwg.aj + " reason:" + paramatwg.ak);
    if (2 == paramatwg.aj)
    {
      this.app.a().q(paramString1, paramatwg.sessionid, 2);
      return;
    }
    if (1 == paramatwg.aj)
    {
      if (57 == paramatwg.ak)
      {
        this.app.a().q(paramString1, paramatwg.sessionid, 5);
        return;
      }
      if (70 == paramatwg.ak)
      {
        this.app.a().al(paramString1, paramatwg.sessionid);
        return;
      }
      if (71 == paramatwg.ak)
      {
        this.app.a().q(paramString1, paramatwg.sessionid, 4);
        return;
      }
      if (5 == paramatwg.ak)
      {
        this.app.a().q(paramString1, paramatwg.sessionid, 2);
        return;
      }
      if (paramatwg.ak == 0)
      {
        this.app.a().q(paramString1, paramatwg.sessionid, 3);
        return;
      }
      if (58 == paramatwg.ak)
      {
        this.app.a().al(paramString1, paramatwg.sessionid);
        return;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatwg.sessionid + "] canceltype:1.unkonw reason:" + paramatwg.ak);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatwg.sessionid + "] unknow canceltype:" + paramatwg.aj);
  }
  
  public void a(long paramLong, int paramInt, aude paramaude, agie paramagie, FileManagerEntity paramFileManagerEntity)
  {
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramInt);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    Object localObject = localReqBody.uint32_seq;
    int i = cRe;
    cRe = i + 1;
    ((PBUInt32Field)localObject).set(i);
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "send0x346Req, unknwon nCmdType:" + paramInt);
      }
      return;
    case 1600: 
      localObject = a(paramaude);
      localReqBody.msg_apply_upload_req_v2.set((MessageMicro)localObject);
      paramagie = new atsq.a(paramaude.jdField_a_of_type_Audc.bytes_10m_md5, null, paramaude.jdField_a_of_type_Audc.bytes_3sha, paramagie);
      paramaude = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600";
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
        localReqBody.msg_extension_req.set((MessageMicro)localObject);
      }
      a(paramaude, localReqBody.toByteArray(), paramagie);
      return;
      localObject = a(paramaude);
      localReqBody.msg_apply_upload_req_v3.set((MessageMicro)localObject);
      paramagie = new atsq.a(paramaude.jdField_a_of_type_Audd.bytes_10m_md5, paramaude.jdField_a_of_type_Audd.bytes_sha, null, paramagie);
      paramaude = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700";
      continue;
      localObject = a(paramaude);
      localReqBody.msg_apply_upload_hit_req_v2.set((MessageMicro)localObject);
      paramagie = new atsq.a(paramaude.jdField_a_of_type_Audb.bytes_10m_md5, paramaude.jdField_a_of_type_Audb.bytes_sha, null, paramagie);
      paramaude = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800";
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
    paramString1 = new atsq.a(false, paramLong1, paramagie, 3);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString2.toByteArray(), paramString1);
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
    if ((paramString1 != null) && ((paramString1.nFileType == 0) || (paramString1.nFileType == 2)))
    {
      audx.K(paramString1);
      if ((paramString1.imgHeight <= 0) || (paramString1.imgWidth <= 0)) {
        break label330;
      }
      paramString2 = new hummer_resv_21.ResvAttr();
      paramString3 = new hummer_resv_21.FileImgInfo();
      paramString3.uint32_file_height.set(paramString1.imgHeight);
      paramString3.uint32_file_width.set(paramString1.imgWidth);
      paramString2.file_image_info.set(paramString3);
      localSubCmd0x2ReqBody.bytes_pb_bytes_reserve.set(ByteStringMicro.copyFrom(paramString2.toByteArray()));
      QLog.i("FileTransferHandler<FileAssistant>", 1, "send Disc Feeds setThumbSize height[" + paramString1.imgHeight + "], width[" + paramString1.imgWidth + "]");
    }
    while ((paramLong4 == 0L) && (QLog.isDevelopLevel()))
    {
      throw new NullPointerException();
      label330:
      if ((!paramString1.hasNoThumb()) && ((paramString1.nFileType == 0) || (paramString1.nFileType == 2))) {
        new Handler(Looper.getMainLooper()).postDelayed(new FileTransferHandler.14(this, paramString1), 1000L);
      }
    }
    i = anbk.ab(paramLong4);
    localSubCmd0x2ReqBody.uint32_random.set(i);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x2_req_body.set(localSubCmd0x2ReqBody);
    paramString1.uint32_sub_cmd.set(2);
    paramString2 = new atsq.a(false, paramLong1, paramagie, 2);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean, agie paramagie)
  {
    Object localObject = new cmd0x346.ApplyDownloadReq();
    ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type.set(i);
      paramString = new cmd0x346.ReqBody();
      paramString.msg_apply_download_req.set((MessageMicro)localObject);
      paramString.uint32_cmd.set(1200);
      localObject = paramString.uint32_seq;
      i = cRe;
      cRe = i + 1;
      ((PBUInt32Field)localObject).set(i);
      paramString.uint32_business_id.set(3);
      paramString.uint32_client_type.set(104);
      localObject = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject).uint32_download_url_type.set(1);
      paramString.msg_extension_req.set((MessageMicro)localObject);
      paramagie = new atsq.a(paramLong, paramagie);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", paramString.toByteArray(), paramagie);
      return;
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
      QLog.i("FileTransferHandler<FileAssistant>", 1, "notifyUI. sendToTarget .type=" + paramInt);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find observer .type=" + paramInt);
  }
  
  public void a(audi paramaudi, agie paramagie, FileManagerEntity paramFileManagerEntity)
  {
    aude localaude = a(paramaudi);
    a(1L, paramaudi.cYU, localaude, paramagie, paramFileManagerEntity);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, String paramString3, agie paramagie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "setUploadSuccState : selfUin[" + audx.kZ(paramString1) + "], toUin[" + audx.kZ(paramString2) + "], filePath[" + paramString3 + "]");
    }
    cmd0x346.UploadSuccReq localUploadSuccReq = new cmd0x346.UploadSuccReq();
    localUploadSuccReq.uint64_sender_uin.set(Long.parseLong(paramString1));
    paramString1 = paramString2.replace("+", "");
    localUploadSuccReq.uint64_recver_uin.set(Long.parseLong(paramString1));
    localUploadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
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
        QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardOfflineFile : addtempinfo SessionType[" + paramFileManagerEntity.tmpSessionType + "], sessionId[" + paramFileManagerEntity.nSessionId + "]");
      }
    }
    paramFileManagerEntity = new atsq.a(paramagie);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", paramString1.toByteArray(), paramFileManagerEntity, 30000, 3, 1);
  }
  
  public void a(String paramString1, String paramString2, agie paramagie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "setDownloadSuccState : selfUin[" + audx.kZ(paramString1) + "], filePath[" + paramString2 + "]");
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
    paramString2 = new atsq.a(paramagie);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000", paramString1.toByteArray(), paramString2, 30000, 3, 1);
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
    paramString2 = new atsq.a(false, 0L, paramagie, 1);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean, agie paramagie)
  {
    Object localObject = new cmd0x346.ApplyDownloadReq();
    ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type.set(i);
      paramString = new cmd0x346.ReqBody();
      paramString.msg_apply_download_req.set((MessageMicro)localObject);
      paramString.uint32_cmd.set(1200);
      localObject = paramString.uint32_seq;
      i = cRe;
      cRe = i + 1;
      ((PBUInt32Field)localObject).set(i);
      paramString.uint32_business_id.set(3);
      paramString.uint32_client_type.set(104);
      localObject = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject).uint32_download_url_type.set(1);
      paramString.msg_extension_req.set((MessageMicro)localObject);
      paramagie = new atsq.a(paramagie);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", paramString.toByteArray(), paramagie);
      return;
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, atsq.a parama)
  {
    ProtoReqManager.c localc = new ProtoReqManager.c();
    localc.clW = paramString;
    localc.fW = paramArrayOfByte;
    localc.fi = parama;
    a(localc);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, atsq.a parama, int paramInt1, int paramInt2, int paramInt3)
  {
    ProtoReqManager.c localc = new ProtoReqManager.c();
    localc.clW = paramString;
    localc.fW = paramArrayOfByte;
    localc.fi = parama;
    localc.daB = paramInt1;
    localc.tryCount = paramInt2;
    localc.dPR = paramInt3;
    a(localc);
  }
  
  public boolean a(atwg paramatwg)
  {
    if (paramatwg != null)
    {
      if ((dG.equals(paramatwg.ea)) || (!paramatwg.cex)) {
        QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatwg.sessionid + "]  is not surpport mulitendpoint");
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
    ((im_msg_body.NotOnlineFile)localObject2).uint32_subcmd.set(1);
    ((SubMsgType0x4.MsgBody)localObject1).msg_not_online_file.set((MessageMicro)localObject2);
    localObject2 = new hummer_resv_21.FileImgInfo();
    audx.K(paramFileManagerEntity);
    if ((paramFileManagerEntity.imgHeight > 0) && (paramFileManagerEntity.imgWidth > 0))
    {
      ((hummer_resv_21.FileImgInfo)localObject2).uint32_file_height.set(paramFileManagerEntity.imgHeight);
      ((hummer_resv_21.FileImgInfo)localObject2).uint32_file_width.set(paramFileManagerEntity.imgWidth);
      ((SubMsgType0x4.MsgBody)localObject1).file_image_info.set((MessageMicro)localObject2);
      QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "]Send CCMsg, setThumbSize height[" + paramFileManagerEntity.imgHeight + "], width[" + paramFileManagerEntity.imgWidth + "]");
    }
    for (;;)
    {
      localObject1 = ((SubMsgType0x4.MsgBody)localObject1).toByteArray();
      localObject2 = new FMTransC2CMsgInfo();
      ((FMTransC2CMsgInfo)localObject2).busiType = 1028;
      ((FMTransC2CMsgInfo)localObject2).uuid = paramFileManagerEntity.Uuid;
      ((FMTransC2CMsgInfo)localObject2).uniseq = paramFileManagerEntity.uniseq;
      ((FMTransC2CMsgInfo)localObject2).fileTransferObserver = paramagie;
      ((FMTransC2CMsgInfo)localObject2).msgSeq = paramFileManagerEntity.msgSeq;
      ((FMTransC2CMsgInfo)localObject2).msgUid = paramFileManagerEntity.msgUid;
      ((FMTransC2CMsgInfo)localObject2).sessionId = paramFileManagerEntity.nSessionId;
      ((FMTransC2CMsgInfo)localObject2).entity = paramFileManagerEntity;
      paramFileManagerEntity.bOnceSuccess = true;
      this.app.a().u(paramFileManagerEntity);
      return a(paramString, 529, 4, (byte[])localObject1, (FMTransC2CMsgInfo)localObject2);
      if ((!paramFileManagerEntity.hasNoThumb()) && ((paramFileManagerEntity.nFileType == 0) || (paramFileManagerEntity.nFileType == 2))) {
        new Handler(Looper.getMainLooper()).postDelayed(new FileTransferHandler.7(this, paramFileManagerEntity), 1000L);
      }
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
    ((FMTransC2CMsgInfo)localObject).msgSeq = audx.bA();
    ((FMTransC2CMsgInfo)localObject).msgUid = audx.ge();
    return a(paramString1, 529, 4, paramString2, (FMTransC2CMsgInfo)localObject);
  }
  
  public void b(int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    a(paramInt, 3, paramFileManagerEntity);
  }
  
  public void b(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
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
    paramString2 = new atsq.a(false, paramLong1, null, 6);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void b(audi paramaudi, agie paramagie, FileManagerEntity paramFileManagerEntity)
  {
    a(1L, 1800, b(paramaudi), paramagie, paramFileManagerEntity);
  }
  
  public void e(FileManagerEntity paramFileManagerEntity, int paramInt)
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
    paramFileManagerEntity = new atsq.a(false, paramFileManagerEntity.nSessionId, null, 7);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", ((cmd0x345.ReqBody)localObject).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
  }
  
  public void j(FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardOfflineFile : PeerUin[" + audx.kZ(paramFileManagerEntity.peerUin) + "], FileUUID[" + paramFileManagerEntity.Uuid + "]");
    }
    if ((paramFileManagerEntity == null) || (TextUtils.isEmpty(paramFileManagerEntity.Uuid)))
    {
      QLog.e("FileTransferHandler<FileAssistant>", 2, "entity info error:" + audx.d(paramFileManagerEntity));
      return;
    }
    Object localObject2 = new cmd0x346.ApplyForwardFileReq();
    ((cmd0x346.ApplyForwardFileReq)localObject2).uint64_sender_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    Object localObject1 = paramFileManagerEntity.peerUin.replace("+", "");
    ((cmd0x346.ApplyForwardFileReq)localObject2).uint64_recver_uin.set(Long.parseLong((String)localObject1));
    ((cmd0x346.ApplyForwardFileReq)localObject2).bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    localObject1 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject1).msg_apply_forward_file_req.set((MessageMicro)localObject2);
    ((cmd0x346.ReqBody)localObject1).uint32_cmd.set(700);
    localObject2 = ((cmd0x346.ReqBody)localObject1).uint32_seq;
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
    paramFileManagerEntity = new atsq.a(false, paramFileManagerEntity.nSessionId);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700", ((cmd0x346.ReqBody)localObject1).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
  }
  
  public void jf(String paramString1, String paramString2)
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
    paramString2 = new atsq.a(false, 0L, null, 8);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
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
    paramString2 = new atsq.a(true, paramLong, null, 8);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void o(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "RemoveOfflineFile : PeerUin[" + audx.kZ(paramString1) + "], FileUUID[" + paramString2 + "], bSend[" + paramBoolean + "]");
    }
    if (paramBoolean) {
      i = 1;
    }
    paramString3 = new cmd0x346.DeleteFileReq();
    paramString3.uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    paramString3.uint64_peer_uin.set(Long.parseLong(paramString1));
    paramString3.uint32_delete_type.set(i);
    paramString3.bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_delete_file_req.set(paramString3);
    paramString1.uint32_cmd.set(900);
    paramString3 = paramString1.uint32_seq;
    i = cRe;
    cRe = i + 1;
    paramString3.set(i);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    paramString2 = new atsq.a(paramString2);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  class a
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
    
    a()
    {
      a(false, 0L, null, null, 0);
    }
    
    a(long paramLong, agie paramagie)
    {
      a(false, paramLong, null, paramagie, 0);
    }
    
    a(agie paramagie)
    {
      a(false, 0L, null, paramagie, 0);
    }
    
    a(String paramString)
    {
      a(false, 0L, paramString, null, 0);
    }
    
    a(boolean paramBoolean, long paramLong)
    {
      a(paramBoolean, paramLong, null, null, 0);
    }
    
    a(boolean paramBoolean, long paramLong, agie paramagie, int paramInt)
    {
      a(paramBoolean, paramLong, null, paramagie, paramInt);
    }
    
    a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, agie paramagie)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atsq
 * JD-Core Version:    0.7.0.1
 */