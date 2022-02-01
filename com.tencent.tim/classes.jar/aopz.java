import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
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
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346.AddrList;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class aopz
  extends aopw
{
  int busiType = 17;
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      localc.fW = b(parama.He);
      localc.fi = parama;
      localc.clW = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200";
      if (this.busiType == 3) {
        localc.clW = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200";
      }
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
      Object localObject3;
      aonh localaonh;
      try
      {
        paramc = new cmd0x346.RspBody();
        paramc.mergeFrom((byte[])localObject1);
        localObject3 = (cmd0x346.ApplyDownloadRsp)paramc.msg_apply_download_rsp.get();
        paramd = (aoql.b.c)localb.Hf.get(0);
        if (paramd != null) {
          paramd.cOc = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownHandler.onProtoResp:isSendByQuickHttp=" + paramd.cOc);
        }
        i = ((cmd0x346.ApplyDownloadRsp)localObject3).int32_ret_code.get();
        paramc = (cmd0x346.ExtensionRsp)paramc.msg_extension_rsp.get();
        if (i != 0) {
          break label639;
        }
        localObject2 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadRsp)localObject3).msg_download_info.get();
        if ((localObject2 != null) && (((cmd0x346.DownloadInfo)localObject2).str_download_url.has()))
        {
          paramd.downloadUrl = ((cmd0x346.DownloadInfo)localObject2).str_download_url.get();
          localObject2 = ((cmd0x346.DownloadInfo)localObject2).rpt_str_downloadip_list.get();
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break label479;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            localaonh = new aonh();
            localaonh.mIp = ((String)localObject3);
            paramd.xp.add(localaonh);
          }
        }
      }
      catch (Exception paramd)
      {
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), locala1, localb.Hf);
      }
      throw new Exception("no url");
      label479:
      if ((paramc != null) && (paramc.server_addr_ipv6_list.has()))
      {
        paramc = (cmd0x346.AddrList)paramc.server_addr_ipv6_list.get();
        if (paramc != null)
        {
          localObject2 = paramc.rpt_str_ip.get();
          i = paramc.uint32_port.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              localaonh = new aonh();
              localaonh.mIp = ((String)localObject3);
              localaonh.port = i;
              localaonh.isIpv6 = true;
              paramd.Bw.add(localaonh);
            }
          }
          paramd.cmE = paramc.rpt_str_domain.get();
        }
      }
      a(0, 0, "", "", locala1, paramd);
      continue;
      label639:
      if ((paramc != null) && (paramc.uint32_allow_retry.get() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onReceive :c2c ptt server not allow retry");
        }
        paramd.cOd = false;
      }
      a(-1, -9527, aojn.bH(i), "", locala1, paramd);
    }
  }
  
  void b(aoql.a parama)
  {
    aoql.b localb = parama.jdField_a_of_type_Aoql$b;
    localb.Hf.clear();
    int i = 0;
    while (i < parama.He.size())
    {
      aoql.b.c localc = new aoql.b.c();
      localb.Hf.add(i, localc);
      i += 1;
    }
  }
  
  byte[] b(List<aoql.a.k> paramList)
  {
    int i = 1;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    if (paramList.size() == 1)
    {
      paramList = (aoql.a.b)paramList.get(0);
      Object localObject;
      if ("ftn".equals(paramList.storageSource))
      {
        this.busiType = 3;
        localObject = new cmd0x346.ApplyDownloadReq();
        ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(Long.parseLong(paramList.selfUin));
        ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFromUtf8(paramList.uuid));
        PBUInt32Field localPBUInt32Field = ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type;
        if (!paramList.cNX) {
          break label428;
        }
        label102:
        localPBUInt32Field.set(i);
        localReqBody.uint32_cmd.set(1200);
        localReqBody.uint32_seq.set(0);
        localReqBody.uint32_business_id.set(this.busiType);
        localReqBody.uint32_client_type.set(104);
        localReqBody.msg_apply_download_req.set((MessageMicro)localObject);
        if (paramList.uinType == 0) {
          break label501;
        }
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
        switch (paramList.uinType)
        {
        default: 
          i = 0;
          label310:
          ((cmd0x346.ExtensionReq)localObject).uint64_type.set(i);
          ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(paramList.voiceType);
          ((cmd0x346.ExtensionReq)localObject).uint32_file_type.set(paramList.busiType);
          ((cmd0x346.ExtensionReq)localObject).uint32_is_auto.set(paramList.dRl);
          localReqBody.msg_extension_req.set((MessageMicro)localObject);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.C2CPttDownHandler", 2, "constructReqBody C2CPttDownReq = " + paramList.toString());
        }
        return localReqBody.toByteArray();
        if (!"pttcenter".equals(paramList.storageSource)) {
          break;
        }
        this.busiType = 17;
        break;
        label428:
        i = 2;
        break label102;
        i = 0;
        break label310;
        i = 102;
        break label310;
        i = 104;
        break label310;
        i = 104;
        break label310;
        i = 105;
        break label310;
        i = 0;
        break label310;
        i = 0;
        break label310;
        i = 0;
        break label310;
        i = 101;
        break label310;
        i = 103;
        break label310;
        i = 100;
        break label310;
        i = 114;
        break label310;
        label501:
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(paramList.voiceType);
        ((cmd0x346.ExtensionReq)localObject).uint32_is_auto.set(paramList.dRl);
        localReqBody.msg_extension_req.set((MessageMicro)localObject);
      }
    }
    throw new RuntimeException("only support one request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopz
 * JD-Core Version:    0.7.0.1
 */