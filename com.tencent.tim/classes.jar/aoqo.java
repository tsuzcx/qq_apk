import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pttcenterservice.PttShortVideo.ExtensionReq;
import pttcenterservice.PttShortVideo.PttShortVideoAddr;
import pttcenterservice.PttShortVideo.PttShortVideoDownloadReq;
import pttcenterservice.PttShortVideo.PttShortVideoDownloadResp;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class aoqo
  extends aopw
{
  public void a(aoql.a parama)
  {
    ProtoReqManager.c localc;
    aoql.a.k localk;
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      localc = new ProtoReqManager.c();
      if (parama.He.size() != 1) {
        break label131;
      }
      localk = (aoql.a.k)parama.He.get(0);
      if (localk.uinType != 0) {
        break label95;
      }
      localc.clW = "PttCenterSvr.ShortVideoDownReq";
    }
    for (;;)
    {
      localc.fW = b(parama.He);
      localc.fi = parama;
      localc.a = this;
      a(parama, localc);
      return;
      label95:
      if ((1 == localk.uinType) || (3000 == localk.uinType)) {
        localc.clW = "PttCenterSvr.GroupShortVideoDownReq";
      } else {
        localc.clW = "PttCenterSvr.ShortVideoDownReq";
      }
    }
    label131:
    throw new RuntimeException("only support one request");
  }
  
  public void a(aoql.b.n paramn, PttShortVideo.PttShortVideoDownloadResp paramPttShortVideoDownloadResp)
  {
    PttShortVideo.PttShortVideoAddr localPttShortVideoAddr = (PttShortVideo.PttShortVideoAddr)paramPttShortVideoDownloadResp.msg_download_addr.get();
    if (localPttShortVideoAddr != null)
    {
      paramn.dRr = localPttShortVideoAddr.uint32_host_type.get();
      if (paramn.dRr == 0)
      {
        Object localObject2 = localPttShortVideoAddr.rpt_str_host.get();
        int i;
        aonh localaonh;
        if (localObject2 != null)
        {
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localaonh = new aonh();
            localObject1 = (String)((List)localObject2).get(i);
            paramPttShortVideoDownloadResp = (PttShortVideo.PttShortVideoDownloadResp)localObject1;
            if (((String)localObject1).startsWith("http://")) {
              paramPttShortVideoDownloadResp = ((String)localObject1).substring("http://".length());
            }
            localObject1 = paramPttShortVideoDownloadResp;
            if (paramPttShortVideoDownloadResp.endsWith("/")) {
              localObject1 = paramPttShortVideoDownloadResp.substring(0, paramPttShortVideoDownloadResp.length() - 1);
            }
            paramPttShortVideoDownloadResp = ((String)localObject1).split(":");
            localaonh.mIp = paramPttShortVideoDownloadResp[0];
            if (paramPttShortVideoDownloadResp.length == 2) {
              localaonh.port = Integer.valueOf(paramPttShortVideoDownloadResp[1]).intValue();
            }
            paramn.xp.add(i, localaonh);
            i += 1;
          }
        }
        localObject2 = localPttShortVideoAddr.rpt_str_host_ipv6.get();
        if (localObject2 != null)
        {
          i = 0;
          if (i < ((List)localObject2).size())
          {
            localaonh = new aonh();
            localObject1 = (String)((List)localObject2).get(i);
            paramPttShortVideoDownloadResp = (PttShortVideo.PttShortVideoDownloadResp)localObject1;
            if (((String)localObject1).startsWith("http://")) {
              paramPttShortVideoDownloadResp = ((String)localObject1).substring("http://".length());
            }
            localObject1 = paramPttShortVideoDownloadResp;
            if (paramPttShortVideoDownloadResp.endsWith("/")) {
              localObject1 = paramPttShortVideoDownloadResp.substring(0, paramPttShortVideoDownloadResp.length() - 1);
            }
            if (((String)localObject1).lastIndexOf(':') > ((String)localObject1).lastIndexOf(']'))
            {
              localaonh.mIp = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf(']') + 1);
              localaonh.port = Integer.valueOf(((String)localObject1).substring(((String)localObject1).lastIndexOf(':') + 1)).intValue();
            }
            for (;;)
            {
              localaonh.isIpv6 = true;
              paramn.Bw.add(i, localaonh);
              i += 1;
              break;
              localaonh.mIp = ((String)localObject1);
            }
          }
        }
        Object localObject1 = "";
        paramPttShortVideoDownloadResp = (PttShortVideo.PttShortVideoDownloadResp)localObject1;
        if (localPttShortVideoAddr.rpt_str_domain.has())
        {
          paramPttShortVideoDownloadResp = (PttShortVideo.PttShortVideoDownloadResp)localObject1;
          if (localPttShortVideoAddr.rpt_str_domain.size() > 0) {
            paramPttShortVideoDownloadResp = (String)localPttShortVideoAddr.rpt_str_domain.get(0);
          }
        }
        localObject2 = paramPttShortVideoDownloadResp;
        if (paramPttShortVideoDownloadResp != null)
        {
          localObject2 = paramPttShortVideoDownloadResp;
          if (paramPttShortVideoDownloadResp.length() > 0)
          {
            localObject1 = paramPttShortVideoDownloadResp;
            if (paramPttShortVideoDownloadResp.startsWith("http://")) {
              localObject1 = paramPttShortVideoDownloadResp.substring("http://".length());
            }
            localObject2 = localObject1;
            if (((String)localObject1).endsWith("/")) {
              localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
            }
          }
        }
        paramn.mDomain = ((String)localObject2);
      }
      paramn.mUrl = localPttShortVideoAddr.str_url_args.get();
    }
  }
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    FromServiceMsg localFromServiceMsg = paramd.g;
    byte[] arrayOfByte = paramd.g.getWupBuffer();
    paramc = (aoql.a)paramc.fi;
    aoql.b localb = paramc.jdField_a_of_type_Aoql$b;
    paramd = paramd.a;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      int i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.b(localFromServiceMsg), "", paramd, localb.Hf);
      }
    }
    for (;;)
    {
      aoqm.a(paramc, localb);
      return;
      a(-1, 9044, MessageHandler.b(localFromServiceMsg), "", paramd, localb.Hf);
      continue;
      a(arrayOfByte, localb, paramd);
    }
  }
  
  public void a(byte[] paramArrayOfByte, aoql.b paramb, achq.a parama)
  {
    for (;;)
    {
      aoql.b.n localn;
      int i;
      try
      {
        PttShortVideo.RspBody localRspBody = new PttShortVideo.RspBody();
        localRspBody.mergeFrom(paramArrayOfByte);
        PttShortVideo.PttShortVideoDownloadResp localPttShortVideoDownloadResp = (PttShortVideo.PttShortVideoDownloadResp)localRspBody.msg_PttShortVideoDownload_Resp.get();
        localn = (aoql.b.n)paramb.Hf.get(0);
        i = localPttShortVideoDownloadResp.int32_ret_code.get();
        if (i == 0)
        {
          localn.mUkey = HexUtil.bytes2HexStr(localPttShortVideoDownloadResp.bytes_downloadkey.get().toByteArray());
          localn.md5 = localPttShortVideoDownloadResp.bytes_file_md5.get().toByteArray();
          if (localPttShortVideoDownloadResp.bytes_encrypt_key.has()) {
            localn.gm = localPttShortVideoDownloadResp.bytes_encrypt_key.get().toByteArray();
          }
          a(localn, localPttShortVideoDownloadResp);
          a(0, 0, "", "", parama, localn);
          return;
        }
        if (i == -5100026)
        {
          a(-1, -5100026, aojn.bH(i), "", parama, localn);
          if (localRspBody.uint32_allow_retry.get() != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp : shortVideo server not allow retry");
          }
          localn.cOd = false;
          return;
        }
      }
      catch (Exception localException)
      {
        a(-1, -9527, aojn.x("P", -9529L), localException.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), parama, paramb.Hf);
        return;
      }
      if (i == -5100528)
      {
        long l = i;
        a(-1, -5100528, aojn.bH(l), "", parama, localn);
      }
      else
      {
        a(-1, -9527, aojn.bH(i), "", parama, localn);
      }
    }
  }
  
  void b(aoql.a parama)
  {
    aoql.b localb = parama.jdField_a_of_type_Aoql$b;
    localb.Hf.clear();
    int i = 0;
    while (i < parama.He.size())
    {
      aoql.b.n localn = new aoql.b.n();
      localb.Hf.add(i, localn);
      i += 1;
    }
  }
  
  byte[] b(List<aoql.a.k> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (aoql.a.l)paramList.get(0);
      PttShortVideo.PttShortVideoDownloadReq localPttShortVideoDownloadReq = new PttShortVideo.PttShortVideoDownloadReq();
      localPttShortVideoDownloadReq.uint64_touin.set(Long.parseLong(paramList.selfUin));
      localPttShortVideoDownloadReq.uint32_chat_type.set(paramList.chatType);
      if (paramList.chatType == 0)
      {
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.peerUin));
        localPttShortVideoDownloadReq.uint32_client_type.set(paramList.clientType);
        localPttShortVideoDownloadReq.str_fileid.set(paramList.fileId);
        if (paramList.troopUin == null) {
          break label386;
        }
        localPttShortVideoDownloadReq.uint64_group_code.set(Long.parseLong(paramList.troopUin));
      }
      for (;;)
      {
        localPttShortVideoDownloadReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramList.md5));
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "download md5 = " + paramList.md5);
        }
        localPttShortVideoDownloadReq.uint32_agent_type.set(paramList.dRn);
        localPttShortVideoDownloadReq.uint32_business_type.set(paramList.busiType);
        localPttShortVideoDownloadReq.uint32_flag_support_large_size.set(1);
        localPttShortVideoDownloadReq.uint32_file_type.set(paramList.fileType);
        localPttShortVideoDownloadReq.uint32_down_type.set(paramList.dRl);
        localPttShortVideoDownloadReq.uint32_scene_type.set(paramList.IH);
        localPttShortVideoDownloadReq.uint32_need_inner_addr.set(0);
        localPttShortVideoDownloadReq.uint32_req_transfer_type.set(0);
        localPttShortVideoDownloadReq.uint32_req_host_type.set(11);
        PttShortVideo.ExtensionReq localExtensionReq = new PttShortVideo.ExtensionReq();
        localExtensionReq.uint32_sub_busi_type.set(paramList.subBusiType);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "constructReqBody ShortVideoDownReq = " + paramList.toString());
        }
        localReqBody.uint32_cmd.set(400);
        localReqBody.uint32_seq.set(paramList.seq);
        localReqBody.msg_PttShortVideoDownload_Req.set(localPttShortVideoDownloadReq);
        localReqBody.rpt_msg_extension_req.add(localExtensionReq);
        return localReqBody.toByteArray();
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.cmC));
        break;
        label386:
        localPttShortVideoDownloadReq.uint64_group_code.set(0L);
      }
    }
    throw new RuntimeException("only support one request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqo
 * JD-Core Version:    0.7.0.1
 */