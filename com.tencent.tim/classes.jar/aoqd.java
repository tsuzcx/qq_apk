import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlRsp;
import tencent.im.cs.cmd0x388.cmd0x388.IPv6Info;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;

public class aoqd
  extends aopw
{
  void a(int paramInt, aoql.a.k paramk, cmd0x388.ReqBody paramReqBody)
  {
    paramk = (aoql.a.d)paramk;
    cmd0x388.GetPttUrlReq localGetPttUrlReq = new cmd0x388.GetPttUrlReq();
    localGetPttUrlReq.setHasFlag(true);
    localGetPttUrlReq.uint64_file_id.set(paramInt);
    localGetPttUrlReq.uint64_dst_uin.set(Long.valueOf(paramk.selfUin).longValue());
    localGetPttUrlReq.uint64_group_code.set(Long.parseLong(paramk.peerUin));
    localGetPttUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramk.md5));
    if (paramk.groupFileID != 0L) {
      localGetPttUrlReq.uint64_fileid.set(paramk.groupFileID);
    }
    localGetPttUrlReq.uint32_req_platform_type.set(9);
    localGetPttUrlReq.uint32_req_term.set(5);
    localGetPttUrlReq.uint32_inner_ip.set(0);
    Object localObject = localGetPttUrlReq.uint32_bu_type;
    if (paramk.uinType == 1) {
      paramInt = 3;
    }
    for (;;)
    {
      ((PBUInt32Field)localObject).set(paramInt);
      localGetPttUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(aonc.getVersionCode()));
      localGetPttUrlReq.uint32_codec.set(paramk.voiceType);
      if (paramk.cmz != null) {}
      try
      {
        localObject = paramk.cmz.getBytes("utf-8");
        localGetPttUrlReq.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
        label207:
        localGetPttUrlReq.uint32_is_auto.set(paramk.dRl);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.GroupPttDownHandler", 2, "constructReqBody GroupPttDownReq = " + paramk.toString());
        }
        paramReqBody.rpt_msg_getptt_url_req.add(localGetPttUrlReq);
        return;
        paramInt = 4;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label207;
      }
    }
  }
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      localc.clW = "PttStore.GroupPttDown";
      localc.fW = b(parama.He);
      localc.fi = parama;
      localc.a = this;
      a(parama, localc);
    }
  }
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    FromServiceMsg localFromServiceMsg = paramd.g;
    byte[] arrayOfByte = paramd.g.getWupBuffer();
    aoql.a locala = (aoql.a)paramc.fi;
    aoql.b localb = locala.jdField_a_of_type_Aoql$b;
    achq.a locala1 = paramd.a;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.b(localFromServiceMsg);
        paramc = localFromServiceMsg.getBusinessFailMsg();
        paramd = paramc;
        if (paramc == null) {
          paramd = "";
        }
        a(-1, 9311, (String)localObject1, paramd, locala1, localb.Hf);
      }
      for (;;)
      {
        aoqm.a(locala, localb);
        return;
        localObject1 = MessageHandler.b(localFromServiceMsg);
        paramc = localFromServiceMsg.getBusinessFailMsg();
        paramd = paramc;
        if (paramc == null) {
          paramd = "";
        }
        a(-1, 9044, (String)localObject1, paramd, locala1, localb.Hf);
      }
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getptt_url_rsp.get().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        paramd = (cmd0x388.GetPttUrlRsp)localIterator.next();
      }
      catch (Exception paramd)
      {
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), locala1, localb.Hf);
      }
      try
      {
        localObject1 = (aoql.b.f)localb.Hf.get((int)paramd.uint64_file_id.get());
        if ((localObject1 != null) && (localFromServiceMsg != null)) {}
        try
        {
          ((aoql.b.f)localObject1).cOc = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.e("http_sideway", 2, "GroupPttDownHandler.onProtoResp:isSendByQuickHttp=" + ((aoql.b.f)localObject1).cOc);
          }
          i = paramd.uint32_result.get();
          if (i != 0) {
            break label714;
          }
          ((aoql.b.f)localObject1).urlPath = paramd.bytes_down_para.get().toStringUtf8();
          List localList = paramd.rpt_uint32_down_ip.get();
          Object localObject2 = paramd.rpt_uint32_down_port.get();
          i = 0;
          if (i < localList.size())
          {
            aonh localaonh = new aonh();
            localaonh.mIp = aqoj.bS(((Integer)localList.get(i)).intValue() & 0xFFFFFFFF);
            localaonh.port = ((Integer)((List)localObject2).get(i)).intValue();
            ((aoql.b.f)localObject1).xp.add(i, localaonh);
            i += 1;
            continue;
          }
          if ((paramd.rpt_msg_down_ip6.has()) && (paramd.rpt_msg_down_ip6.size() > 0))
          {
            localList = paramd.rpt_msg_down_ip6.get();
            i = 0;
            if (i < localList.size())
            {
              localObject2 = new aonh();
              ((aonh)localObject2).mIp = Inet6Address.getByAddress(((cmd0x388.IPv6Info)localList.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((aonh)localObject2).port = ((cmd0x388.IPv6Info)localList.get(i)).uint32_port.get();
              ((aonh)localObject2).isIpv6 = true;
              ((aoql.b.f)localObject1).Bw.add(i, localObject2);
              i += 1;
              continue;
            }
          }
          if (paramd.rpt_str_domain.has()) {
            ((aoql.b.f)localObject1).cmE = paramd.rpt_str_domain.get();
          }
          a(0, 0, "", "", locala1, (aoql.b.m)localObject1);
        }
        catch (Exception paramd) {}
      }
      catch (Exception paramd)
      {
        localObject1 = null;
        continue;
      }
      a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), locala1, (aoql.b.m)localObject1);
      continue;
      break;
      label714:
      if (paramd.uint32_allow_retry.get() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp :group ptt server not allow retry");
        }
        ((aoql.b.f)localObject1).cOd = false;
      }
      if (aoqc.lR(i))
      {
        this.dOO += 1;
        if (this.dOO < 2)
        {
          locala.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(paramc);
          return;
        }
      }
      a(-1, -9527, aojn.bH(i), "", locala1, (aoql.b.m)localObject1);
    }
  }
  
  void b(aoql.a parama)
  {
    aoql.b localb = parama.jdField_a_of_type_Aoql$b;
    localb.Hf.clear();
    int i = 0;
    while (i < parama.He.size())
    {
      aoql.b.f localf = new aoql.b.f();
      localb.Hf.add(i, localf);
      i += 1;
    }
  }
  
  byte[] b(List<aoql.a.k> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(4);
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
 * Qualified Name:     aoqd
 * JD-Core Version:    0.7.0.1
 */