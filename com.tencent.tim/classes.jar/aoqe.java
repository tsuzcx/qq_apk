import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttRsp;

public class aoqe
  extends aopw
{
  void a(int paramInt, aoql.a.k paramk, cmd0x388.ReqBody paramReqBody)
  {
    paramk = (aoql.a.j)paramk;
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(paramk.selfUin).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(paramk.peerUin).longValue());
    localTryUpPttReq.uint64_file_id.set(paramInt);
    localTryUpPttReq.uint64_file_size.set(paramk.fileSize);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramk.md5));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramk.fileName));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (paramk.uinType == 1) {}
    for (paramInt = 3;; paramInt = 4)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(aonc.getVersionCode()));
      localTryUpPttReq.uint32_voice_length.set(paramk.voiceLength);
      localTryUpPttReq.uint32_codec.set(paramk.voiceType);
      localTryUpPttReq.uint32_voice_type.set(paramk.audioPanelType);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + paramk.audioPanelType + "] type[" + paramk.voiceType + "] length[" + paramk.voiceLength + "] size[" + paramk.fileSize + "]");
      }
      paramReqBody.rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      return;
    }
  }
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      localc.clW = "PttStore.GroupPttUp";
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
      continue;
      try
      {
        paramd = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_ptt_rsp.get();
        if ((paramd != null) && (paramd.size() != 0)) {
          break label266;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramd)
      {
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), locala1, localb.Hf);
      }
      continue;
      label266:
      Iterator localIterator = paramd.iterator();
      while (localIterator.hasNext())
      {
        paramd = (cmd0x388.TryUpPttRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (aoql.b.g)localb.Hf.get((int)paramd.uint64_file_id.get());
              try
              {
                ((aoql.b.g)localObject1).cOc = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                if (QLog.isColorLevel()) {
                  QLog.e("http_sideway", 2, "GroupPttUpHandler.onProtoResp:isSendByQuickHttp=" + ((aoql.b.g)localObject1).cOc);
                }
                i = paramd.uint32_result.get();
                if (i != 0) {
                  break label750;
                }
                ((aoql.b.g)localObject1).groupFileID = paramd.uint64_fileid.get();
                if (paramd.bytes_file_key.has()) {
                  ((aoql.b.g)localObject1).gf = paramd.bytes_file_key.get().toByteArray();
                }
                if ((!paramd.bool_file_exit.has()) || (!paramd.bool_file_exit.get())) {
                  break label528;
                }
                ((aoql.b.g)localObject1).isExist = true;
                a(0, 0, "", "", locala1, (aoql.b.m)localObject1);
              }
              catch (Exception paramd) {}
            }
          }
          catch (Exception paramd)
          {
            label528:
            List localList;
            Object localObject2;
            long l1;
            long l2;
            aonh localaonh;
            localObject1 = null;
            continue;
          }
          a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), locala1, (aoql.b.m)localObject1);
          break;
          localList = paramd.rpt_uint32_up_ip.get();
          localObject2 = paramd.rpt_uint32_up_port.get();
          if ((localList != null) && (localList.size() > 0))
          {
            i = 0;
            if (i < localList.size())
            {
              l1 = ((Integer)localList.get(i)).intValue();
              l2 = ((Integer)((List)localObject2).get(i)).intValue();
              localaonh = new aonh();
              localaonh.mIp = aqoj.bS(l1 & 0xFFFFFFFF);
              localaonh.port = ((int)l2);
              ((aoql.b.g)localObject1).ipList.add(i, localaonh);
              i += 1;
              continue;
            }
          }
          localObject2 = HexUtil.bytes2HexStr(paramd.bytes_up_ukey.get().toByteArray());
          if ((localObject2 == null) || (((String)localObject2).equals("")) || (localList == null) || (localList.size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((aoql.b.g)localObject1).mUkey = ((String)localObject2);
          ((aoql.b.g)localObject1).blockSize = ((int)paramd.uint64_block_size.get());
          ((aoql.b.g)localObject1).transferedSize = ((int)paramd.uint64_up_offset.get());
        }
        label750:
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
  }
  
  void b(aoql.a parama)
  {
    aoql.b localb = parama.jdField_a_of_type_Aoql$b;
    localb.Hf.clear();
    int i = 0;
    while (i < parama.He.size())
    {
      aoql.b.g localg = new aoql.b.g();
      localb.Hf.add(i, localg);
      i += 1;
    }
  }
  
  byte[] b(List<aoql.a.k> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(3);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (aoql.a.k)paramList.get(i), localReqBody);
      i += 1;
    }
    i = KW();
    localReqBody.uint32_net_type.set(i);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + i + "]");
    }
    return localReqBody.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqe
 * JD-Core Version:    0.7.0.1
 */