import com.qq.taf.jce.HexUtil;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgRsp;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpInfo4Busi;

public class aopv
  extends aopw
{
  int dRk;
  
  private void a(aoql.b.a parama, cmd0x388.TryUpImgRsp paramTryUpImgRsp)
    throws Exception
  {
    boolean bool = false;
    if (paramTryUpImgRsp.msg_info4busi.has())
    {
      localObject1 = (cmd0x388.TryUpInfo4Busi)paramTryUpImgRsp.msg_info4busi.get();
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_down_domain.has()) {
        parama.clu = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_down_domain.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_big_down_url.has()) {
        parama.clx = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_big_down_url.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_original_down_url.has()) {
        parama.clv = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_original_down_url.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_thumb_down_url.has()) {
        parama.clw = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_thumb_down_url.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_file_resid.has()) {
        parama.resid = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_file_resid.get().toStringUtf8();
      }
    }
    parama.groupFileID = paramTryUpImgRsp.uint64_fileid.get();
    Object localObject1 = paramTryUpImgRsp.rpt_uint32_up_ip.get();
    Object localObject2 = paramTryUpImgRsp.rpt_uint32_up_port.get();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        long l1 = ((Integer)((List)localObject1).get(i)).intValue();
        long l2 = ((Integer)((List)localObject2).get(i)).intValue();
        aonh localaonh = new aonh();
        localaonh.mIp = aqoj.bS(l1 & 0xFFFFFFFF);
        localaonh.port = ((int)l2);
        parama.xp.add(i, localaonh);
        i += 1;
      }
    }
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get())) {
      parama.isExist = true;
    }
    do
    {
      return;
      localObject2 = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (localObject1 == null) || (((List)localObject1).size() == 0)) {
        throw new Exception("check ukey,iplist");
      }
      parama.mUkey = ((String)localObject2);
      parama.blockSize = ((int)paramTryUpImgRsp.uint64_block_size.get());
      parama.transferedSize = ((int)paramTryUpImgRsp.uint64_up_offset.get());
      if (aomi.a().getNetType() != this.dRk) {
        bool = true;
      }
      parama.cOa = bool;
      parama.startOffset = paramTryUpImgRsp.uint64_up_offset.get();
      if (QLog.isColorLevel()) {
        QLog.d("BDH_LOG", 2, " Channel:" + paramTryUpImgRsp.bool_new_big_chan.get());
      }
    } while ((!paramTryUpImgRsp.bool_new_big_chan.has()) || (paramTryUpImgRsp.bool_new_big_chan.get() != true));
    parama.cOb = true;
  }
  
  public static boolean lR(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202) && (paramInt != 120509) && (paramInt != 400010) && (paramInt != 400011);
  }
  
  void a(int paramInt, aoql.a.k paramk, cmd0x388.ReqBody paramReqBody)
  {
    paramk = (aoql.a.i)paramk;
    cmd0x388.TryUpImgReq localTryUpImgReq = new cmd0x388.TryUpImgReq();
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(paramk.selfUin).longValue());
    localTryUpImgReq.uint64_group_code.set(Long.valueOf(paramk.peerUin).longValue());
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.uint64_file_size.set(paramk.fileSize);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramk.md5));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramk.fileName));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_pic_width.set(paramk.width);
    localTryUpImgReq.uint32_pic_height.set(paramk.height);
    localTryUpImgReq.uint32_pic_type.set(paramk.picType);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (paramk.uinType == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(aonc.getVersionCode()));
      if (paramk.cMs) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
      return;
    }
  }
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      localc.clW = "ImgStore.BDHCommonUp";
      localc.fW = a(parama);
      localc.fi = parama;
      localc.a = this;
      a(parama, localc);
    }
  }
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.e("BDHCommonUpHandler", 1, "onProtoResp: " + paramd.g.getResultCode());
    }
    super.a(paramd, paramc);
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, aoql.a parama, aoql.b paramb, achq.a parama1, ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    try
    {
      paramd = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_tryup_img_rsp.get();
      if ((paramd == null) || (paramd.size() == 0)) {
        throw new Exception("resps null");
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      a(-1, -9527, aojn.x("P", -9529L), paramFromServiceMsg.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), parama1, paramb.Hf);
    }
    for (;;)
    {
      return;
      Iterator localIterator = paramd.iterator();
      while (localIterator.hasNext())
      {
        paramd = (cmd0x388.TryUpImgRsp)localIterator.next();
        try
        {
          locala = (aoql.b.a)paramb.Hf.get((int)paramd.uint64_file_id.get());
          if (locala == null) {
            continue;
          }
          try
          {
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              locala.cOc = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramd.uint32_result.get();
            if (i != 0) {
              break label296;
            }
            a(locala, paramd);
            a(0, 0, "", "", parama1, locala);
          }
          catch (Exception paramd) {}
        }
        catch (Exception paramd)
        {
          for (;;)
          {
            int i;
            aoql.b.a locala = null;
          }
        }
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), parama1, locala);
        continue;
        label296:
        if (lR(i))
        {
          this.dOO += 1;
          if (this.dOO < 2)
          {
            parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(paramc);
            return;
          }
        }
        a(-1, -9527, aojn.bH(i), "", parama1, locala);
      }
    }
  }
  
  byte[] a(aoql.a parama)
  {
    if (parama == null) {
      return null;
    }
    List localList = parama.He;
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    localReqBody.uint32_command_id.set(parama.commandId);
    if (parama.gc != null) {
      localReqBody.bytes_extension.set(ByteStringMicro.copyFrom(parama.gc));
    }
    int i = 0;
    while (i < localList.size())
    {
      a(i, (aoql.a.k)localList.get(i), localReqBody);
      i += 1;
    }
    i = aomi.a().getNetType();
    this.dRk = i;
    switch (i)
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      parama = aomi.a().getApnType();
      int j = i;
      if (parama != null)
      {
        j = i;
        if (parama.contains("wap")) {
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
  
  void b(aoql.a parama)
  {
    aoql.b localb = parama.jdField_a_of_type_Aoql$b;
    localb.Hf.clear();
    int i = 0;
    while (i < parama.He.size())
    {
      aoql.b.a locala = new aoql.b.a();
      localb.Hf.add(i, locala);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopv
 * JD-Core Version:    0.7.0.1
 */