import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
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
import java.util.ArrayList;
import java.util.List;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyUpReq;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyUpRsp;
import tencent.im.longconn.multimsg.MultiMsg.ReqBody;
import tencent.im.longconn.multimsg.MultiMsg.RspBody;

public class aoqg
  extends aopw
{
  int dRk;
  
  private void a(int paramInt, aoql.a.k paramk, MultiMsg.ReqBody paramReqBody)
  {
    paramk = (aoql.a.g)paramk;
    MultiMsg.MultiMsgApplyUpReq localMultiMsgApplyUpReq = new MultiMsg.MultiMsgApplyUpReq();
    localMultiMsgApplyUpReq.setHasFlag(true);
    localMultiMsgApplyUpReq.uint64_dst_uin.set(Long.valueOf(paramk.peerUin).longValue());
    localMultiMsgApplyUpReq.uint64_msg_size.set(paramk.size);
    localMultiMsgApplyUpReq.bytes_msg_md5.set(ByteStringMicro.copyFrom(paramk.md5));
    localMultiMsgApplyUpReq.uint32_msg_type.set(ju(paramk.uinType));
    localMultiMsgApplyUpReq.uint32_apply_id.set(0);
    paramReqBody.rpt_multimsg_applyup_req.add(localMultiMsgApplyUpReq);
    if (paramk.dPD == 1) {
      paramReqBody.uint32_bu_type.set(1);
    }
    if ((paramk.dPD == 0) && (ajlg.cph)) {
      paramReqBody.uint32_bu_type.set(2);
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
      ((MultiMsg.ReqBody)localObject).uint32_subcmd.set(1);
      ((MultiMsg.ReqBody)localObject).uint32_term_type.set(5);
      ((MultiMsg.ReqBody)localObject).uint32_platform_type.set(9);
      ((MultiMsg.ReqBody)localObject).uint32_net_type.set(j);
      ((MultiMsg.ReqBody)localObject).bytes_build_ver.set(ByteStringMicro.copyFromUtf8(aonc.getVersionCode()));
      ((MultiMsg.ReqBody)localObject).uint32_bu_type.set(0);
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
  
  public static int ju(int paramInt)
  {
    int i = 3;
    switch (paramInt)
    {
    default: 
      i = 1;
    case 1: 
    case 3000: 
      return i;
    case 1040: 
      return 15;
    }
    return 255;
  }
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      localc.clW = "MultiMsg.ApplyUp";
      localc.fW = b(parama.He);
      localc.fi = parama;
      localc.a = this;
      a(parama, localc);
    }
  }
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    localObject1 = paramd.g;
    byte[] arrayOfByte1 = paramd.g.getWupBuffer();
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
        localList = ((MultiMsg.RspBody)new MultiMsg.RspBody().mergeFrom(arrayOfByte1)).rpt_multimsg_applyup_rsp.get();
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramd)
      {
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte1), locala1, localb.Hf);
      }
    }
    int i = 0;
    label233:
    if (i < localList.size()) {
      paramd = (MultiMsg.MultiMsgApplyUpRsp)localList.get(i);
    }
    try
    {
      localObject1 = (aoql.b.j)localb.Hf.get(i);
      try
      {
        j = paramd.uint32_result.get();
        if (j != 0) {
          break label781;
        }
        if (paramd.bytes_msg_resid.has()) {
          break label367;
        }
        throw new Exception("bytes_msg_resid NOT exists");
      }
      catch (Exception paramd) {}
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        localObject1 = null;
        continue;
        int j = 0;
      }
    }
    a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte1), locala1, (aoql.b.m)localObject1);
    for (;;)
    {
      i += 1;
      break label233;
      break;
      label367:
      Object localObject2 = paramd.bytes_msg_resid.get().toByteArray();
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        throw new Exception("resid_bs == null || empty");
      }
      if (!paramd.bytes_msg_ukey.has()) {
        throw new Exception("bytes_msg_ukey NOT exists");
      }
      Object localObject3 = paramd.bytes_msg_ukey.get().toByteArray();
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        throw new Exception("ukey_bs == null || empty");
      }
      if (!paramd.bytes_msg_key.has()) {
        throw new Exception("bytes_msg_key NOT exists");
      }
      Object localObject4 = paramd.bytes_msg_key.get().toByteArray();
      if ((localObject4 == null) || (localObject4.length <= 0)) {
        throw new Exception("msgkey_bs == null || empty");
      }
      if (!paramd.bytes_msg_sig.has()) {
        throw new Exception("bytes_msg_sig NOT exists");
      }
      byte[] arrayOfByte2 = paramd.bytes_msg_sig.get().toByteArray();
      if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
        throw new Exception("msgsig_bs == null || empty");
      }
      ((aoql.b.j)localObject1).gh = ((byte[])localObject2);
      ((aoql.b.j)localObject1).gj = ((byte[])localObject3);
      ((aoql.b.j)localObject1).gk = ((byte[])localObject4);
      ((aoql.b.j)localObject1).gl = arrayOfByte2;
      localObject2 = paramd.rpt_uint32_up_ip.get();
      localObject3 = paramd.rpt_uint32_up_port.get();
      if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
        break label847;
      }
      throw new Exception("check iplist");
      while (j < ((List)localObject2).size())
      {
        long l1 = ((Integer)((List)localObject2).get(j)).intValue();
        long l2 = ((Integer)((List)localObject3).get(j)).intValue();
        localObject4 = new aonh();
        ((aonh)localObject4).mIp = aqoj.bS(l1 & 0xFFFFFFFF);
        ((aonh)localObject4).port = ((int)l2);
        ((aoql.b.j)localObject1).ipList.add(j, localObject4);
        j += 1;
      }
      ((aoql.b.j)localObject1).blockSize = ((int)paramd.uint64_block_size.get());
      ((aoql.b.j)localObject1).transferedSize = ((int)paramd.uint64_up_offset.get());
      a(0, 0, "", "", locala1, (aoql.b.m)localObject1);
      continue;
      label781:
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
      aoql.b.j localj = new aoql.b.j();
      localb.Hf.add(i, localj);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqg
 * JD-Core Version:    0.7.0.1
 */