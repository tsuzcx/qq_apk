import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.b;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x5ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x5RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccRsp;

public class agik
  implements ProtoReqManager.b
{
  private static int cRe;
  private final String TAG = "ProtocolManager";
  private QQAppInterface app;
  
  public agik(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void A(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    boolean bool = false;
    Object localObject = null;
    int i = -1;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      i = -100001;
      paramd = localObject;
    }
    for (;;)
    {
      ((agij.c)((agik.b)paramc.fi).a()).a(bool, i, paramd);
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + paramd.g.getResultCode() + "]");
        i = -100002;
        paramd = localObject;
      }
      else
      {
        paramd = paramd.g.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(paramd);
          if (localRspBody.msg_apply_upload_rsp_v3.has()) {
            break label221;
          }
          QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          i = -100003;
          paramd = localObject;
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
          i = -100003;
          paramd = localObject;
        }
        continue;
        label221:
        paramd = (cmd0x346.ApplyUploadRspV3)localRspBody.msg_apply_upload_rsp_v3.get();
        bool = true;
      }
    }
  }
  
  private void B(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    boolean bool = false;
    int i = -1;
    String str = "";
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      paramd = str;
    }
    cmd0x346.RspBody localRspBody;
    for (;;)
    {
      if (paramc.fi != null) {
        ((agij.a)((agik.b)paramc.fi).a()).l(bool, i, paramd);
      }
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: resp is failed[" + paramd.g.getResultCode() + "]");
        paramd = str;
      }
      else
      {
        paramd = paramd.g.getWupBuffer();
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(paramd);
          if (localRspBody.msg_upload_succ_rsp.has()) {
            break;
          }
          QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          i = -100003;
          paramd = str;
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
          i = -100003;
          paramd = str;
        }
      }
    }
    paramd = (cmd0x346.UploadSuccRsp)localRspBody.msg_upload_succ_rsp.get();
    if (paramd.int32_ret_code.has()) {
      i = paramd.int32_ret_code.get();
    }
    if (paramd.str_ret_msg.has()) {}
    for (paramd = paramd.str_ret_msg.get();; paramd = "")
    {
      bool = true;
      break;
    }
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, agik.b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    ProtoReqManager.c localc = new ProtoReqManager.c();
    localc.clW = paramString;
    localc.fW = paramArrayOfByte;
    localc.fi = paramb;
    localc.daB = paramInt1;
    localc.tryCount = paramInt2;
    localc.dPR = paramInt3;
    localc.a = this;
    this.app.getProtoReqManager().b(localc);
  }
  
  private void x(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    long l2 = 0L;
    int i = -100003;
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool2 = true;
    long l1;
    Object localObject1;
    boolean bool1;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: resp is timeout[" + paramd.g.getResultCode() + "]");
      l1 = 0L;
      localObject1 = null;
      paramd = null;
      bool1 = false;
    }
    for (;;)
    {
      if (i != 0) {
        bool1 = false;
      }
      ((agij.b)((agik.b)paramc.fi).a()).a(bool1, i, paramd, (String)localObject1, (String)localObject2, l1, l2);
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: resp is failed[" + paramd.g.getResultCode() + "]");
        l1 = 0L;
        localObject1 = null;
        paramd = null;
        bool1 = false;
      }
      else
      {
        paramd = paramd.g.getWupBuffer();
        localObject1 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject1).mergeFrom(paramd);
          if (((cmd0x346.RspBody)localObject1).msg_apply_forward_file_rsp.has()) {
            break;
          }
          QLog.i("ProtocolManager", 1, "onForwardOfflineResponse rspBody has not hasMsgApplyForwardFileRsp");
          l1 = 0L;
          localObject1 = null;
          paramd = null;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
          l1 = 0L;
          localObject1 = null;
          paramd = null;
          bool1 = false;
        }
      }
    }
    label295:
    label321:
    cmd0x346.ApplyForwardFileRsp localApplyForwardFileRsp;
    if (((cmd0x346.RspBody)localObject1).uint32_flag_use_media_platform.has()) {
      if (((cmd0x346.RspBody)localObject1).uint32_flag_use_media_platform.get() == 1)
      {
        bool1 = true;
        QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: bUseMediaPlatform " + bool1);
        localApplyForwardFileRsp = (cmd0x346.ApplyForwardFileRsp)((cmd0x346.RspBody)localObject1).msg_apply_forward_file_rsp.get();
        if (!localApplyForwardFileRsp.int32_ret_code.has()) {
          break label526;
        }
      }
    }
    label526:
    for (i = localApplyForwardFileRsp.int32_ret_code.get();; i = 0)
    {
      if (localApplyForwardFileRsp.str_ret_msg.has()) {}
      for (paramd = localApplyForwardFileRsp.str_ret_msg.get();; paramd = null)
      {
        if (localApplyForwardFileRsp.bytes_uuid.has()) {}
        for (localObject1 = new String(localApplyForwardFileRsp.bytes_uuid.get().toByteArray());; localObject1 = null)
        {
          localObject2 = localObject3;
          if (bool1)
          {
            localObject2 = localObject3;
            if (localApplyForwardFileRsp.str_fileidcrc.has()) {
              localObject2 = localApplyForwardFileRsp.str_fileidcrc.get();
            }
          }
          if (localApplyForwardFileRsp.uint64_total_space.has()) {}
          for (l1 = localApplyForwardFileRsp.uint64_total_space.get();; l1 = 0L)
          {
            if (localApplyForwardFileRsp.uint64_used_space.has()) {
              l2 = localApplyForwardFileRsp.uint64_used_space.get();
            }
            bool1 = bool2;
            break;
            bool1 = false;
            break label295;
            QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
            bool1 = false;
            break label321;
          }
        }
      }
    }
  }
  
  private void y(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    int i = -100003;
    boolean bool;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("ProtocolManager", 1, "onForwardOfflineToOther: resp is timeout[" + paramd.g.getResultCode() + "]");
      localObject = null;
      paramd = null;
      bool = false;
    }
    for (;;)
    {
      if (i != 0) {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProtocolManager", 2, "onForwardOfflineToOther: return " + bool + ", retCode=" + i + ", retMsg=" + paramd);
      }
      ((agij.b)((agik.b)paramc.fi).a()).a(bool, i, paramd, (String)localObject, null, 0L, 0L);
      return;
      if (paramd.g.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("ProtocolManager", 1, "onForwardOfflineToOther: resp is failed[" + paramd.g.getResultCode() + "]");
        localObject = null;
        paramd = null;
        bool = false;
      }
      else
      {
        paramd = paramd.g.getWupBuffer();
        localObject = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject).mergeFrom(paramd);
          if (((cmd0x346.RspBody)localObject).msg_apply_copy_to_rsp.has()) {
            break;
          }
          QLog.i("ProtocolManager", 1, "onForwardOfflineToOther rspBody has not hasMsgApplyDownloadAbsRsp");
          localObject = null;
          paramd = null;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException paramd)
        {
          paramd.printStackTrace();
          localObject = null;
          paramd = null;
          bool = false;
        }
      }
    }
    Object localObject = (cmd0x346.ApplyCopyToRsp)((cmd0x346.RspBody)localObject).msg_apply_copy_to_rsp.get();
    if (((cmd0x346.ApplyCopyToRsp)localObject).int32_ret_code.has()) {}
    for (i = ((cmd0x346.ApplyCopyToRsp)localObject).int32_ret_code.get();; i = 0)
    {
      if (((cmd0x346.ApplyCopyToRsp)localObject).str_ret_msg.has()) {}
      for (paramd = ((cmd0x346.ApplyCopyToRsp)localObject).str_ret_msg.get();; paramd = null)
      {
        if (((cmd0x346.ApplyCopyToRsp)localObject).str_file_key.has()) {}
        for (localObject = ((cmd0x346.ApplyCopyToRsp)localObject).str_file_key.get();; localObject = null)
        {
          bool = true;
          break;
        }
      }
    }
  }
  
  private void z(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    Object localObject1 = "";
    boolean bool;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      QLog.i("ProtocolManager", 1, "internalForwardDiscFile: resp is timeout[" + paramd.g.getResultCode() + "]");
      paramd = null;
      bool = false;
    }
    for (int i = -100001;; i = -100002)
    {
      ((agij.b)((agik.b)paramc.fi).a()).a(bool, i, (String)localObject1, paramd, null, 0L, 0L);
      return;
      if (paramd.g.getResultCode() == 1000) {
        break;
      }
      QLog.i("ProtocolManager", 1, "internalForwardDiscFile: resp is failed[" + paramd.g.getResultCode() + "]");
      paramd = null;
      bool = false;
    }
    Object localObject2 = paramd.g.getWupBuffer();
    paramd = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        paramd.mergeFrom((byte[])localObject2);
        if (!paramd.uint32_return_code.has()) {
          break label436;
        }
        i = paramd.uint32_return_code.get();
        if ((paramd.msg_subcmd_0x6_rsp_body.has()) || (paramd.msg_subcmd_0x5_rsp_body.has())) {
          break label260;
        }
        QLog.i("ProtocolManager", 1, "internalForwardDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        bool = false;
        i = -100003;
        paramd = null;
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
        bool = false;
        i = -100003;
        paramd = null;
      }
      break;
      label260:
      if (paramd.msg_subcmd_0x6_rsp_body.has())
      {
        localObject1 = (cmd0x345.RspBody.SubCmd0x6RspBody)paramd.msg_subcmd_0x6_rsp_body.get();
        if (!((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_ret_msg.has()) {
          break label430;
        }
      }
      label430:
      for (paramd = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_ret_msg.get();; paramd = "")
      {
        if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_file_id.has()) {
          localObject1 = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_file_id.get();
        }
        for (;;)
        {
          localObject2 = localObject1;
          bool = true;
          localObject1 = paramd;
          paramd = (ProtoReqManager.d)localObject2;
          break;
          localObject2 = localObject1;
          if (paramd.msg_subcmd_0x5_rsp_body.has())
          {
            cmd0x345.RspBody.SubCmd0x5RspBody localSubCmd0x5RspBody = (cmd0x345.RspBody.SubCmd0x5RspBody)paramd.msg_subcmd_0x5_rsp_body.get();
            paramd = (ProtoReqManager.d)localObject1;
            if (localSubCmd0x5RspBody.str_ret_msg.has()) {
              paramd = localSubCmd0x5RspBody.str_ret_msg.get();
            }
            localObject2 = paramd;
            if (localSubCmd0x5RspBody.str_file_id.has())
            {
              localObject1 = localSubCmd0x5RspBody.str_file_id.get();
              continue;
            }
          }
          localObject1 = null;
          paramd = (ProtoReqManager.d)localObject2;
          continue;
          localObject1 = null;
        }
      }
      label436:
      i = 0;
    }
  }
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700".equals(paramc.clW)) {
      x(paramc, paramd);
    }
    for (;;)
    {
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800".equals(paramc.clW)) {
        B(paramc, paramd);
      }
      return;
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(paramc.clW))
      {
        y(paramc, paramd);
      }
      else if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(paramc.clW))
      {
        agik.b localb = (agik.b)paramc.fi;
        int i = localb.Ef();
        if (i == 6) {
          z(paramc, paramd);
        } else if (i == 7) {
          z(paramc, paramd);
        } else {
          QLog.w("ProtocolManager", 1, "unspourt:" + localb.Ef());
        }
      }
      else if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700".equals(paramc.clW))
      {
        A(paramc, paramd);
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, agik.a parama, int paramInt3, int paramInt4, agij.b paramb)
  {
    cmd0x345.ReqBody.SubCmd0x6ReqBody localSubCmd0x6ReqBody = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
    localSubCmd0x6ReqBody.uint32_dst_bus_id.set(paramInt2);
    localSubCmd0x6ReqBody.uint64_file_size.set(parama.fileSize);
    localSubCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(parama.uuid.getBytes()));
    if (!TextUtils.isEmpty(parama.md5)) {
      localSubCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(parama.md5.getBytes()));
    }
    localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramString2));
    paramString2 = paramString1.replace("+", "");
    localSubCmd0x6ReqBody.uint64_dst_uin.set(Long.parseLong(paramString2));
    localSubCmd0x6ReqBody.str_file_name.set(parama.fileName);
    localSubCmd0x6ReqBody.str_src_file_path.set(parama.uuid);
    localSubCmd0x6ReqBody.str_src_parent_folder.set("/");
    localSubCmd0x6ReqBody.uint32_client_type.set(104);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localSubCmd0x6ReqBody.uint64_app_id.set(3L);
      localSubCmd0x6ReqBody.uint64_talk_type.set(paramInt1);
      paramString1 = ahav.a(this.app, paramString1, paramInt1);
      if (paramString1 != null) {
        localSubCmd0x6ReqBody.bytes_sig.set(ByteStringMicro.copyFrom(paramString1));
      }
      if (QLog.isColorLevel()) {
        QLog.i("ProtocolManager", 2, "forwardDiscToOther : add tempinfo SessionType[" + paramInt1 + "]");
      }
    }
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x6_req_body.set(localSubCmd0x6ReqBody);
    paramString1.uint32_sub_cmd.set(7);
    paramString2 = new agik.b(paramb);
    paramString2.NT(7);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, paramInt3, paramInt4, 1);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, agij.b paramb)
  {
    cmd0x346.ApplyForwardFileReq localApplyForwardFileReq = new cmd0x346.ApplyForwardFileReq();
    localApplyForwardFileReq.uint64_sender_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    Object localObject = paramString1.replace("+", "");
    localApplyForwardFileReq.uint64_recver_uin.set(Long.parseLong((String)localObject));
    localApplyForwardFileReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_apply_forward_file_req.set(localApplyForwardFileReq);
    paramString1.uint32_cmd.set(700);
    paramString2 = paramString1.uint32_seq;
    int i = cRe;
    cRe = i + 1;
    paramString2.set(i);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (paramInt1 != 0)
    {
      paramString2 = new cmd0x346.ExtensionReq();
      paramString2.uint64_id.set(3L);
      paramString2.uint64_type.set(paramInt1);
      localObject = ahav.a(this.app, (String)localObject, paramInt1);
      if (localObject != null) {
        paramString2.bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      paramString1.msg_extension_req.set(paramString2);
      if (QLog.isColorLevel()) {
        QLog.i("ProtocolManager", 2, "forwardOfflineFileToBuddy : add tempinfo SessionType[" + paramInt1 + "]");
      }
    }
    if (((agiq)this.app.getManager(317)).ald())
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString3 != null) && (paramString3.length() > 0))
      {
        localApplyForwardFileReq.str_fileidcrc.set(paramString3);
        QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramString2 = new agik.b(paramb);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700", paramString1.toByteArray(), paramString2, paramInt2, paramInt3, 1);
      return;
      QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform not enabled");
    }
  }
  
  public void a(String paramString1, String paramString2, agik.a parama, int paramInt1, int paramInt2, int paramInt3, agij.b paramb)
  {
    cmd0x346.ApplyCopyToReq localApplyCopyToReq = new cmd0x346.ApplyCopyToReq();
    String str = this.app.getAccount().replace("+", "");
    localApplyCopyToReq.uint64_dst_id.set(Long.parseLong(str));
    if ((paramInt1 == 106) || (paramInt1 == 102) || (paramInt1 == 104))
    {
      paramString2 = paramString2.replace("+", "");
      localApplyCopyToReq.uint64_dst_id.set(Long.parseLong(paramString2));
    }
    localApplyCopyToReq.uint32_dst_svcid.set(paramInt1);
    localApplyCopyToReq.uint64_src_uin.set(Long.parseLong(str));
    localApplyCopyToReq.uint64_file_size.set(parama.fileSize);
    localApplyCopyToReq.str_file_name.set(parama.fileName);
    localApplyCopyToReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_apply_copy_to_req.set(localApplyCopyToReq);
    paramString1.uint32_cmd.set(60100);
    paramString2 = paramString1.uint32_seq;
    paramInt1 = cRe;
    cRe = paramInt1 + 1;
    paramString2.set(paramInt1);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    paramString2 = new agik.b(paramb);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", paramString1.toByteArray(), paramString2, paramInt2, paramInt3, 1);
  }
  
  public void a(String paramString1, String paramString2, agik.a parama, agij.b paramb)
  {
    cmd0x345.ReqBody.SubCmd0x5ReqBody localSubCmd0x5ReqBody = new cmd0x345.ReqBody.SubCmd0x5ReqBody();
    localSubCmd0x5ReqBody.uint32_src_bus_id.set(106);
    localSubCmd0x5ReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom("/".getBytes()));
    localSubCmd0x5ReqBody.bytes_src_file_path.set(ByteStringMicro.copyFrom(parama.uuid.getBytes()));
    localSubCmd0x5ReqBody.uint32_dst_uin.set(Integer.parseInt(paramString1));
    localSubCmd0x5ReqBody.uint64_file_size.set(parama.fileSize);
    localSubCmd0x5ReqBody.uint32_from_uin.set(Integer.parseInt(paramString2));
    localSubCmd0x5ReqBody.str_file_name.set(parama.fileName);
    if ((parama.md5 != null) && (parama.md5.length() > 0)) {
      localSubCmd0x5ReqBody.bytes_md5.set(ByteStringMicro.copyFrom(parama.md5.getBytes()));
    }
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x5_req_body.set(localSubCmd0x5ReqBody);
    paramString1.uint32_sub_cmd.set(6);
    paramString2 = new agik.b(paramb);
    paramString2.NT(6);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, agij.c paramc)
  {
    long l = Long.parseLong(this.app.getCurrentAccountUin());
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(1700);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    Object localObject = localReqBody.uint32_seq;
    int i = cRe;
    cRe = i + 1;
    ((PBUInt32Field)localObject).set(i);
    localObject = new cmd0x346.ApplyUploadReqV3();
    ((cmd0x346.ApplyUploadReqV3)localObject).uint64_sender_uin.set(l);
    ((cmd0x346.ApplyUploadReqV3)localObject).uint64_recver_uin.set(Long.parseLong(paramString1));
    ((cmd0x346.ApplyUploadReqV3)localObject).uint64_file_size.set(paramLong);
    ((cmd0x346.ApplyUploadReqV3)localObject).str_file_name.set(new String(paramString3));
    ((cmd0x346.ApplyUploadReqV3)localObject).bytes_10m_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    ((cmd0x346.ApplyUploadReqV3)localObject).bytes_sha.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
    ((cmd0x346.ApplyUploadReqV3)localObject).str_local_filepath.set(paramString2);
    ((cmd0x346.ApplyUploadReqV3)localObject).uint32_danger_level.set(0);
    ((cmd0x346.ApplyUploadReqV3)localObject).uint64_total_space.set(0L);
    localReqBody.msg_apply_upload_req_v3.set((MessageMicro)localObject);
    localReqBody.setHasFlag(true);
    paramString1 = new agik.b(paramc);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", localReqBody.toByteArray(), paramString1, paramInt1, paramInt2, 1);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, agij.a parama)
  {
    cmd0x346.UploadSuccReq localUploadSuccReq = new cmd0x346.UploadSuccReq();
    localUploadSuccReq.uint64_sender_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    paramString = paramString.replace("+", "");
    localUploadSuccReq.uint64_recver_uin.set(Long.parseLong(paramString));
    localUploadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = new cmd0x346.ReqBody();
    paramArrayOfByte.msg_upload_succ_req.set(localUploadSuccReq);
    paramArrayOfByte.uint32_cmd.set(800);
    paramString = paramArrayOfByte.uint32_seq;
    int i = cRe;
    cRe = i + 1;
    paramString.set(i);
    paramArrayOfByte.uint32_business_id.set(3);
    paramArrayOfByte.uint32_client_type.set(104);
    paramString = null;
    if (parama != null) {
      paramString = new agik.b(parama);
    }
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", paramArrayOfByte.toByteArray(), paramString, paramInt1, paramInt2, 1);
  }
  
  public static class a
  {
    String fileName;
    long fileSize;
    String md5;
    String uuid;
  }
  
  class b
  {
    private agij a;
    private int cXh;
    
    public b(agij paramagij)
    {
      this.a = paramagij;
    }
    
    public int Ef()
    {
      return this.cXh;
    }
    
    public void NT(int paramInt)
    {
      this.cXh = paramInt;
    }
    
    public agij a()
    {
      return this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agik
 * JD-Core Version:    0.7.0.1
 */