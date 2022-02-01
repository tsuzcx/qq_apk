import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetImgUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.GetImgUrlRsp;
import tencent.im.cs.cmd0x388.cmd0x388.IPv6Info;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;

public class aoqb
  extends aoqj
{
  private void a(aoql.a.c paramc, cmd0x388.GetImgUrlRsp paramGetImgUrlRsp, aoql.b.l paraml)
    throws UnknownHostException
  {
    int j = 0;
    Object localObject = null;
    if (paramc.fileType == 65537) {
      if (anof.ayA()) {
        localObject = paramGetImgUrlRsp.bytes_big_thumb_down_para.get().toStringUtf8();
      }
    }
    int i;
    for (;;)
    {
      paraml.urlPath = ((String)localObject);
      if ((!paramGetImgUrlRsp.rpt_uint32_down_ip.has()) || (paramGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) || (!paramGetImgUrlRsp.rpt_uint32_down_port.has()) || (paramGetImgUrlRsp.rpt_uint32_down_port.size() <= 0)) {
        break;
      }
      paramc = paramGetImgUrlRsp.rpt_uint32_down_ip.get();
      localObject = paramGetImgUrlRsp.rpt_uint32_down_port.get();
      i = 0;
      while (i < paramc.size())
      {
        aonh localaonh = new aonh();
        localaonh.mIp = aqoj.bS(((Integer)paramc.get(i)).intValue() & 0xFFFFFFFF);
        localaonh.port = ((Integer)((List)localObject).get(i)).intValue();
        paraml.xp.add(i, localaonh);
        i += 1;
      }
      localObject = paramGetImgUrlRsp.bytes_thumb_down_para.get().toStringUtf8();
      continue;
      if (paramc.fileType == 1) {
        localObject = paramGetImgUrlRsp.bytes_big_down_para.get().toStringUtf8();
      } else if (paramc.fileType == 131075) {
        localObject = paramGetImgUrlRsp.bytes_original_down_para.get().toStringUtf8();
      }
    }
    if ((paramGetImgUrlRsp.rpt_msg_down_ip6.has()) && (paramGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
    {
      paramc = paramGetImgUrlRsp.rpt_msg_down_ip6.get();
      i = j;
      while (i < paramc.size())
      {
        localObject = new aonh();
        ((aonh)localObject).mIp = Inet6Address.getByAddress(((cmd0x388.IPv6Info)paramc.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
        ((aonh)localObject).port = ((cmd0x388.IPv6Info)paramc.get(i)).uint32_port.get();
        ((aonh)localObject).isIpv6 = true;
        paraml.Bw.add(i, localObject);
        i += 1;
      }
    }
    if (paramGetImgUrlRsp.bytes_down_domain.has())
    {
      paramc = new aonh();
      paramc.mIp = paramGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
      paramc.port = 80;
      paraml.xp.add(paramc);
      paraml.domain = paramc.mIp;
    }
    if (paramGetImgUrlRsp.uint32_https_url_flag.has()) {
      paraml.protocolType = paramGetImgUrlRsp.uint32_https_url_flag.get();
    }
  }
  
  void a(int paramInt, aoql.a.k paramk, cmd0x388.ReqBody paramReqBody)
  {
    int i = 1;
    paramk = (aoql.a.c)paramk;
    cmd0x388.GetImgUrlReq localGetImgUrlReq = new cmd0x388.GetImgUrlReq();
    localGetImgUrlReq.setHasFlag(true);
    localGetImgUrlReq.uint64_file_id.set(paramInt);
    localGetImgUrlReq.uint64_dst_uin.set(Long.valueOf(paramk.selfUin).longValue());
    localGetImgUrlReq.uint64_group_code.set(Long.parseLong(paramk.peerUin));
    localGetImgUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramk.md5));
    localGetImgUrlReq.uint32_pic_up_timestamp.set(paramk.msgTime);
    if (paramk.groupFileID != 0L) {
      localGetImgUrlReq.uint64_fileid.set(paramk.groupFileID);
    }
    PBUInt32Field localPBUInt32Field;
    if (paramk.fileType == 65537) {
      if (anof.ayA())
      {
        localGetImgUrlReq.uint32_url_flag.set(16);
        localGetImgUrlReq.uint32_url_type.set(2);
        localGetImgUrlReq.uint32_req_platform_type.set(9);
        localGetImgUrlReq.uint32_req_term.set(5);
        localGetImgUrlReq.uint32_inner_ip.set(0);
        localPBUInt32Field = localGetImgUrlReq.uint32_bu_type;
        if (paramk.uinType != 1) {
          break label317;
        }
      }
    }
    label317:
    for (paramInt = i;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localGetImgUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(aonc.getVersionCode()));
      localGetImgUrlReq.uint32_req_transfer_type.set(paramk.protocolType);
      paramReqBody.rpt_msg_getimg_url_req.add(localGetImgUrlReq);
      return;
      localGetImgUrlReq.uint32_url_flag.set(1);
      localGetImgUrlReq.uint32_url_type.set(2);
      break;
      if (paramk.fileType == 1)
      {
        localGetImgUrlReq.uint32_url_flag.set(8);
        localGetImgUrlReq.uint32_url_type.set(3);
        break;
      }
      if (paramk.fileType != 131075) {
        break;
      }
      localGetImgUrlReq.uint32_url_flag.set(2);
      localGetImgUrlReq.uint32_url_type.set(4);
      break;
    }
  }
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      localc.clW = "ImgStore.GroupPicDown";
      localc.fW = b(parama.He);
      localc.fi = parama;
      localc.a = this;
      a(parama, localc);
    }
  }
  
  protected void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, aoql.a parama, aoql.b paramb, achq.a parama1)
  {
    try
    {
      paramd = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_getimg_url_rsp.get();
      if ((paramd == null) || (paramd.size() == 0)) {
        throw new Exception("resps null");
      }
    }
    catch (Exception paramd)
    {
      a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), parama1, paramb.Hf);
    }
    for (;;)
    {
      return;
      Iterator localIterator = paramd.iterator();
      while (localIterator.hasNext())
      {
        paramd = (cmd0x388.GetImgUrlRsp)localIterator.next();
        try
        {
          locall = (aoql.b.l)paramb.Hf.get((int)paramd.uint64_file_id.get());
          try
          {
            aoql.a.c localc = (aoql.a.c)parama.He.get(0);
            if (locall == null) {
              continue;
            }
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              locall.cOc = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramd.uint32_result.get();
            if (i != 0) {
              break label309;
            }
            a(localc, paramd, locall);
            a(0, 0, "", "", parama1, locall);
          }
          catch (Exception paramd) {}
        }
        catch (Exception paramd)
        {
          for (;;)
          {
            int i;
            aoql.b.l locall = null;
          }
        }
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), parama1, locall);
        continue;
        label309:
        if (aoqc.lR(i))
        {
          this.dOO += 1;
          if (this.dOO < 2)
          {
            parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(paramc);
            return;
          }
        }
        a(-1, -9527, aojn.bH(i), aojn.bH(i), parama1, locall);
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
      aoql.b.l locall = new aoql.b.l();
      localb.Hf.add(i, locall);
      i += 1;
    }
  }
  
  byte[] b(List<aoql.a.k> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (aoql.a.k)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (aomi.a().getNetType())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = aomi.a().getApnType();
      int j = i;
      if (paramList != null)
      {
        j = i;
        if (paramList.contains("wap")) {
          j = 5;
        }
      }
      localReqBody.uint32_net_type.set(j);
      return localReqBody.toByteArray();
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqb
 * JD-Core Version:    0.7.0.1
 */