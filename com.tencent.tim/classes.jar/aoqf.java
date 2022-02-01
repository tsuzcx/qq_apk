import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.longconn.multimsg.MultiMsg.ExternMsg;
import tencent.im.longconn.multimsg.MultiMsg.Ipv4Info;
import tencent.im.longconn.multimsg.MultiMsg.Ipv6Info;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyDownReq;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyDownRsp;
import tencent.im.longconn.multimsg.MultiMsg.ReqBody;
import tencent.im.longconn.multimsg.MultiMsg.RspBody;

public class aoqf
  extends aopw
{
  int dRk;
  
  private void a(int paramInt, aoql.a.k paramk, MultiMsg.ReqBody paramReqBody)
  {
    paramk = (aoql.a.f)paramk;
    MultiMsg.MultiMsgApplyDownReq localMultiMsgApplyDownReq = new MultiMsg.MultiMsgApplyDownReq();
    localMultiMsgApplyDownReq.setHasFlag(true);
    localMultiMsgApplyDownReq.bytes_msg_resid.set(ByteStringMicro.copyFrom(paramk.gd));
    localMultiMsgApplyDownReq.uint32_msg_type.set(aoqg.ju(paramk.uinType));
    localMultiMsgApplyDownReq.uint64_src_uin.set(Long.valueOf(paramk.selfUin).longValue());
    try
    {
      localMultiMsgApplyDownReq.bytes_msg_key.set(ByteStringMicro.copyFrom(aojg.ar()));
      localMultiMsgApplyDownReq.bytes_msg_sig.set(ByteStringMicro.copyFrom(aojg.as()));
      List localList = aojg.w(false);
      if (QLog.isDevelopLevel()) {
        QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler addone bdh serverIP4.size  " + localList.size());
      }
      if (localList.size() > 0)
      {
        localObject1 = localList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label312;
          }
          localObject2 = (ExcitingTransferHostInfo)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            MultiMsg.Ipv4Info localIpv4Info = new MultiMsg.Ipv4Info();
            localIpv4Info.uint32_ip_v4_addr.set(ajgv.dB(((ExcitingTransferHostInfo)localObject2).mstrIp));
            if (QLog.isDevelopLevel()) {
              QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler ipv4:  " + ((ExcitingTransferHostInfo)localObject2).mstrIp);
            }
            localIpv4Info.uint32_ip_v4_port.set(((ExcitingTransferHostInfo)localObject2).mport);
            if (!((ExcitingTransferHostInfo)localObject2).mIsHttps) {
              break;
            }
            paramInt = 1;
            localIpv4Info.uint32_is_https_addr.set(paramInt);
            localMultiMsgApplyDownReq.rpt_ip_v4_info.add(localIpv4Info);
          }
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        QLog.e("MultiMsg_TAG", 1, localException, new Object[0]);
        continue;
        paramInt = 0;
      }
      label312:
      Object localObject1 = aojg.w(true);
      if (QLog.isDevelopLevel()) {
        QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler addone bdh serverIP6.size  " + localException.size());
      }
      if (((List)localObject1).size() > 0)
      {
        Iterator localIterator = ((List)localObject1).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = (ExcitingTransferHostInfo)localIterator.next();
            if (localObject1 == null) {
              continue;
            }
            localObject2 = new MultiMsg.Ipv6Info();
            try
            {
              ((MultiMsg.Ipv6Info)localObject2).bytes_ip_v6_addr.set(ByteStringMicro.copyFrom(Inet6Address.getByName(((ExcitingTransferHostInfo)localObject1).mstrIp).getAddress()));
              if (QLog.isDevelopLevel()) {
                QLog.i("MultiMsg_TAG_opt", 2, "Multimsg download handler ipv6:  " + ((ExcitingTransferHostInfo)localObject1).mstrIp);
              }
              ((MultiMsg.Ipv6Info)localObject2).uint32_ip_v6_port.set(((ExcitingTransferHostInfo)localObject1).mport);
              if (((ExcitingTransferHostInfo)localObject1).mIsHttps)
              {
                paramInt = 1;
                ((MultiMsg.Ipv6Info)localObject2).uint32_is_https_addr.set(paramInt);
                localMultiMsgApplyDownReq.rpt_ip_v6_info.add((MessageMicro)localObject2);
              }
            }
            catch (UnknownHostException localUnknownHostException)
            {
              for (;;)
              {
                localUnknownHostException.printStackTrace();
                continue;
                paramInt = 0;
              }
            }
          }
        }
      }
      paramReqBody.rpt_multimsg_applydown_req.add(localMultiMsgApplyDownReq);
      if ((paramk.dPD == 0) && (ajlg.cph)) {
        paramReqBody.uint32_bu_type.set(2);
      }
    }
  }
  
  private byte[] b(List<aoql.a.k> paramList)
  {
    int i = aomi.a().getNetType();
    this.dRk = i;
    switch (i)
    {
    default: 
      i = 255;
    }
    Object localObject;
    for (;;)
    {
      localObject = aomi.a().getApnType();
      int j = i;
      if (localObject != null)
      {
        j = i;
        if (((String)localObject).contains("wap")) {
          j = 5;
        }
      }
      localObject = new MultiMsg.ReqBody();
      ((MultiMsg.ReqBody)localObject).setHasFlag(true);
      ((MultiMsg.ReqBody)localObject).uint32_subcmd.set(2);
      ((MultiMsg.ReqBody)localObject).uint32_term_type.set(5);
      ((MultiMsg.ReqBody)localObject).uint32_platform_type.set(9);
      ((MultiMsg.ReqBody)localObject).uint32_net_type.set(j);
      ((MultiMsg.ReqBody)localObject).bytes_build_ver.set(ByteStringMicro.copyFromUtf8(aonc.getVersionCode()));
      ((MultiMsg.ReqBody)localObject).uint32_req_channel_type.set(2);
      i = 0;
      while (i < paramList.size())
      {
        a(i, (aoql.a.k)paramList.get(i), (MultiMsg.ReqBody)localObject);
        i += 1;
      }
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
    return ((MultiMsg.ReqBody)localObject).toByteArray();
  }
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      localc.clW = "MultiMsg.ApplyDown";
      localc.fW = b(parama.He);
      localc.fi = parama;
      localc.a = this;
      a(parama, localc);
    }
  }
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    localObject1 = paramd.g;
    byte[] arrayOfByte = paramd.g.getWupBuffer();
    aoql.a locala = (aoql.a)paramc.fi;
    aoql.b localb = locala.jdField_a_of_type_Aoql$b;
    achq.a locala1 = paramd.a;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject1).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.b((FromServiceMsg)localObject1), "", locala1, localb.Hf);
      }
    }
    List localList;
    for (;;)
    {
      aoqm.a(locala, localb);
      return;
      a(-1, 9044, MessageHandler.b((FromServiceMsg)localObject1), "", locala1, localb.Hf);
      continue;
      try
      {
        localList = ((MultiMsg.RspBody)new MultiMsg.RspBody().mergeFrom(arrayOfByte)).rpt_multimsg_applydown_rsp.get();
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramd)
      {
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), locala1, localb.Hf);
      }
    }
    int i = 0;
    label235:
    Object localObject2;
    if (i < localList.size()) {
      localObject2 = (MultiMsg.MultiMsgApplyDownRsp)localList.get(i);
    }
    try
    {
      localObject1 = (aoql.b.i)localb.Hf.get(i);
      try
      {
        j = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).uint32_result.get();
        if (j != 0) {
          break label899;
        }
        if (((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_thumb_down_para.has()) {
          break label372;
        }
        throw new Exception("bytes_thumb_down_para NOT exists");
      }
      catch (Exception paramd) {}
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        int j;
        localObject1 = null;
      }
    }
    a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), locala1, (aoql.b.m)localObject1);
    for (;;)
    {
      i += 1;
      break label235;
      break;
      label372:
      paramd = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_thumb_down_para.get();
      if (paramd == null) {}
      for (paramd = null; (paramd == null) || (paramd.equals("")); paramd = paramd.toStringUtf8()) {
        throw new Exception("urlParam == null || empty");
      }
      if (!((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_resid.has()) {
        throw new Exception("bytes_msg_resid NOT exists");
      }
      Object localObject3 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_resid.get().toByteArray();
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        throw new Exception("resid_bs == null || empty");
      }
      if (!((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_key.has()) {
        throw new Exception("bytes_msg_key NOT exists");
      }
      Object localObject4 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_key.get().toByteArray();
      if ((localObject4 == null) || (localObject4.length <= 0)) {
        throw new Exception("ukey_bs == null || empty");
      }
      j = 0;
      if (((MultiMsg.MultiMsgApplyDownRsp)localObject2).msg_extern_info.has()) {
        j = ((MultiMsg.ExternMsg)((MultiMsg.MultiMsgApplyDownRsp)localObject2).msg_extern_info.get()).uint32_channel_type.get();
      }
      ((aoql.b.i)localObject1).mChannelType = j;
      ((aoql.b.i)localObject1).cmH = paramd;
      ((aoql.b.i)localObject1).gh = ((byte[])localObject3);
      ((aoql.b.i)localObject1).gi = ((byte[])localObject4);
      paramd = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_ip.get();
      localObject3 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_port.get();
      if ((paramd == null) || (paramd.size() == 0)) {
        throw new Exception("check iplist");
      }
      if ((paramd != null) && (paramd.size() > 0))
      {
        j = 0;
        while (j < paramd.size())
        {
          long l1 = ((Integer)paramd.get(j)).intValue();
          long l2 = ((Integer)((List)localObject3).get(j)).intValue();
          localObject4 = new aonh();
          ((aonh)localObject4).mIp = aqoj.bS(l1 & 0xFFFFFFFF);
          ((aonh)localObject4).port = ((int)l2);
          ((aoql.b.i)localObject1).ipList.add(j, localObject4);
          j += 1;
        }
      }
      paramd = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_bytes_down_ip_v6.get();
      localObject2 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_v6_port.get();
      if ((paramd != null) && (paramd.size() > 0))
      {
        j = 0;
        while (j < paramd.size())
        {
          localObject3 = new aonh();
          ((aonh)localObject3).mIp = Inet6Address.getByAddress(((ByteStringMicro)paramd.get(j)).toByteArray()).getHostAddress();
          ((aonh)localObject3).port = ((int)((Integer)((List)localObject2).get(j)).intValue());
          ((aonh)localObject3).isIpv6 = true;
          ((aoql.b.i)localObject1).Bw.add(j, localObject3);
          j += 1;
        }
      }
      a(0, 0, "", "", locala1, (aoql.b.m)localObject1);
      continue;
      label899:
      if (j == 196) {
        anot.b(null, "CliOper", "", "", "0X8006627", "0X8006627", 0, 1, 0, "", "", "", "");
      }
      if (aoqc.lR(j))
      {
        this.dOO += 1;
        if (this.dOO < 2)
        {
          locala.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(paramc);
          return;
        }
      }
      a(-1, -9527, aojn.bH(j), "", locala1, (aoql.b.m)localObject1);
    }
  }
  
  void b(aoql.a parama)
  {
    aoql.b localb = parama.jdField_a_of_type_Aoql$b;
    localb.Hf.clear();
    int i = 0;
    while (i < parama.He.size())
    {
      aoql.b.i locali = new aoql.b.i();
      localb.Hf.add(i, locali);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqf
 * JD-Core Version:    0.7.0.1
 */