import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Laoql.a.k;>;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class aoqa
  extends aopw
{
  private static int dPm;
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      localc.clW = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500";
      localc.fW = b(parama.He);
      localc.fi = parama;
      localc.a = this;
      a(parama, localc);
    }
  }
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    Object localObject2 = paramd.g;
    Object localObject1 = paramd.g.getWupBuffer();
    aoql.a locala = (aoql.a)paramc.fi;
    aoql.b localb = locala.jdField_a_of_type_Aoql$b;
    achq.a locala1 = paramd.a;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.b((FromServiceMsg)localObject2);
        paramc = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        paramd = paramc;
        if (paramc == null) {
          paramd = "";
        }
        a(-1, 9311, (String)localObject1, paramd, locala1, localb.Hf);
      }
    }
    cmd0x346.ApplyUploadRsp localApplyUploadRsp;
    aoql.b.d locald;
    for (;;)
    {
      aoqm.a(locala, localb);
      return;
      localObject1 = MessageHandler.b((FromServiceMsg)localObject2);
      paramc = ((FromServiceMsg)localObject2).getBusinessFailMsg();
      paramd = paramc;
      if (paramc == null) {
        paramd = "";
      }
      a(-1, 9044, (String)localObject1, paramd, locala1, localb.Hf);
      continue;
      try
      {
        paramd = new cmd0x346.RspBody();
        paramd.mergeFrom((byte[])localObject1);
        localApplyUploadRsp = (cmd0x346.ApplyUploadRsp)paramd.msg_apply_upload_rsp.get();
        locald = (aoql.b.d)localb.Hf.get(0);
        if ((locald != null) && (localObject2 != null) && (((FromServiceMsg)localObject2).getAttributes().containsKey("_attr_send_by_quickHttp"))) {
          locald.cOc = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttUpHandler.onProtoResp:isSendByQuickHttp=" + locald.cOc);
        }
        i = localApplyUploadRsp.int32_ret_code.get();
        if (i != 0) {
          break label578;
        }
        locald.uuid = localApplyUploadRsp.bytes_uuid.get().toStringUtf8();
        if ((!localApplyUploadRsp.bool_file_exist.has()) || (!localApplyUploadRsp.bool_file_exist.get())) {
          break;
        }
        locald.isExist = true;
      }
      catch (Exception paramd)
      {
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), locala1, localb.Hf);
      }
    }
    if (localApplyUploadRsp.uint32_pack_size.has()) {
      locald.blockSize = localApplyUploadRsp.uint32_pack_size.get();
    }
    localObject2 = HexUtil.bytes2HexStr(localApplyUploadRsp.bytes_upload_key.get().toByteArray());
    locald.mUkey = ((String)localObject2);
    paramc = localApplyUploadRsp.str_upload_ip.get();
    paramd = paramc;
    if (paramc == null) {
      paramd = localApplyUploadRsp.str_upload_domain.get();
    }
    for (;;)
    {
      label473:
      throw new Exception("ukey or ip missing");
      label578:
      do
      {
        paramd = localApplyUploadRsp.rpt_str_uploadip_list.get();
        if ((paramd != null) && (paramd.size() > 0))
        {
          paramd = paramd.iterator();
          while (paramd.hasNext())
          {
            paramc = (String)paramd.next();
            localObject2 = new aonh();
            ((aonh)localObject2).mIp = paramc;
            locald.ipList.add(localObject2);
          }
        }
        a(0, 0, "", "", locala1, locald);
        break;
        a(-1, -9527, aojn.bH(i), "", locala1, locald);
        break;
        if (localObject2 == null) {
          break label473;
        }
      } while (paramd != null);
    }
  }
  
  void b(aoql.a parama)
  {
    aoql.b localb = parama.jdField_a_of_type_Aoql$b;
    localb.Hf.clear();
    int i = 0;
    while (i < parama.He.size())
    {
      aoql.b.d locald = new aoql.b.d();
      localb.Hf.add(i, locald);
      i += 1;
    }
  }
  
  byte[] b(List<aoql.a.k> paramList)
  {
    int j = 0;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(500);
    Object localObject = localReqBody.uint32_seq;
    int i = dPm;
    dPm = i + 1;
    ((PBUInt32Field)localObject).set(i);
    localReqBody.uint32_business_id.set(17);
    localReqBody.uint32_client_type.set(104);
    aoql.a.j localj;
    if (paramList.size() == 1)
    {
      localj = (aoql.a.j)paramList.get(0);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localj.selfUin));
      try
      {
        localObject = localj.peerUin;
        paramList = (List<aoql.a.k>)localObject;
        if (((String)localObject).startsWith("+")) {
          paramList = ((String)localObject).substring(1);
        }
        long l = Long.valueOf(paramList).longValue();
        localApplyUploadReq.uint64_recver_uin.set(l);
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          paramList.printStackTrace();
          continue;
          i = j;
          if (localj.cNZ)
          {
            i = 500;
            continue;
            paramList.str_dst_phonenum.set(localj.peerUin);
            i = 102;
            continue;
            i = 104;
            continue;
            i = 104;
            continue;
            i = 105;
            continue;
            i = 101;
            continue;
            i = 103;
            continue;
            i = 114;
            continue;
            if (localj.uinType == 9999) {
              paramList.uint32_file_type.set(102);
            }
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localj.fileName);
      localApplyUploadReq.uint64_file_size.set(localj.fileSize);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localj.md5));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      paramList = new cmd0x346.ExtensionReq();
      paramList.uint64_id.set(3L);
      paramList.uint32_ptt_format.set(localj.voiceType);
      paramList.uint32_ptt_time.set(localj.voiceLength);
      i = KW();
      paramList.uint32_net_type.set(i);
      paramList.uint32_voice_type.set(localj.audioPanelType);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localj.audioPanelType + "] type[" + localj.voiceType + "] length[" + localj.voiceLength + "] size[" + localj.fileSize + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + i + "]");
        }
      }
      i = j;
      switch (localj.uinType)
      {
      default: 
        i = j;
      case 1005: 
      case 1023: 
      case 1024: 
        paramList.uint64_type.set(i);
        if (localj.uinType == 1008)
        {
          paramList.uint32_file_type.set(3);
          localReqBody.msg_extension_req.set(paramList);
          return localReqBody.toByteArray();
        }
        break;
      }
    }
    throw new RuntimeException("only support one request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqa
 * JD-Core Version:    0.7.0.1
 */