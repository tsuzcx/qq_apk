import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.RspBody;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgRsp;

public class aopy
  extends aoqk
{
  int dRk;
  
  public static boolean lR(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  void a(int paramInt, aoql.a.k paramk, cmd0x352.ReqBody paramReqBody)
  {
    aoql.a.i locali = (aoql.a.i)paramk;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(locali.selfUin).longValue());
    try
    {
      String str = locali.peerUin;
      paramk = str;
      if (str.startsWith("+")) {
        paramk = str.substring(1);
      }
      long l = Long.valueOf(paramk).longValue();
      localTryUpImgReq.uint64_dst_uin.set(l);
    }
    catch (Exception paramk)
    {
      for (;;)
      {
        paramk.printStackTrace();
      }
    }
    localTryUpImgReq.uint64_file_size.set(locali.fileSize);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(locali.md5));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(locali.fileName));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(locali.cNW);
    localTryUpImgReq.uint32_platform_type.set(9);
    a(localTryUpImgReq);
    localTryUpImgReq.bool_pic_original.set(locali.cMs);
    localTryUpImgReq.uint32_pic_width.set(locali.width);
    localTryUpImgReq.uint32_pic_height.set(locali.height);
    localTryUpImgReq.uint32_pic_type.set(locali.picType);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(aonc.getVersionCode()));
    localTryUpImgReq.bool_reject_tryfast.set(false);
    localTryUpImgReq.uint32_srv_upload.set(locali.dRm);
    if (!TextUtils.isEmpty(locali.cmB)) {
      localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(locali.cmB));
    }
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      f(localc);
      localc.fW = b(parama.He);
      localc.fi = parama;
      localc.a = this;
      a(parama, localc);
    }
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, aoql.a parama, aoql.b paramb, achq.a parama1, ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    try
    {
      paramd = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_tryup_img_rsp.get();
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
        paramd = (cmd0x352.TryUpImgRsp)localIterator.next();
        try
        {
          localb = (aoql.b.b)paramb.Hf.get((int)paramd.uint64_file_id.get());
          if (localb == null) {
            continue;
          }
          try
          {
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              localb.cOc = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramd.uint32_result.get();
            if (i != 0) {
              break label298;
            }
            a(paramd, localb);
            a(0, 0, "", "", parama1, localb);
          }
          catch (Exception paramd) {}
        }
        catch (Exception paramd)
        {
          for (;;)
          {
            int i;
            aoql.b.b localb = null;
          }
        }
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), parama1, localb);
        continue;
        label298:
        if (lR(i))
        {
          this.dOO += 1;
          if (this.dOO < 2)
          {
            parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(paramc);
            return;
          }
        }
        a(-1, -9527, aojn.bH(i), "", parama1, localb);
      }
    }
  }
  
  protected void a(cmd0x352.TryUpImgReq paramTryUpImgReq)
  {
    paramTryUpImgReq.uint32_bu_type.set(1);
  }
  
  void a(cmd0x352.TryUpImgRsp paramTryUpImgRsp, aoql.b.b paramb)
  {
    boolean bool = true;
    if (paramTryUpImgRsp.bytes_up_resid.has()) {
      paramb.mResid = paramTryUpImgRsp.bytes_up_resid.get().toStringUtf8();
    }
    if (paramTryUpImgRsp.bytes_up_uuid.has()) {
      paramb.mUuid = paramTryUpImgRsp.bytes_up_uuid.get().toStringUtf8();
    }
    paramb.startOffset = paramTryUpImgRsp.uint64_up_offset.get();
    if (QLog.isColorLevel()) {
      QLog.d("BDH_LOG", 2, " TryUpLoad : Offset:" + paramb.startOffset + " Value:" + paramTryUpImgRsp.uint64_up_offset.get());
    }
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      paramb.isExist = true;
      if (paramTryUpImgRsp.bytes_original_down_para.has()) {
        paramb.cmD = paramTryUpImgRsp.bytes_original_down_para.get().toStringUtf8();
      }
      return;
    }
    paramb.mUkey = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
    paramb.blockSize = ((int)paramTryUpImgRsp.uint64_block_size.get());
    if (aomi.a().getNetType() != this.dRk) {}
    for (;;)
    {
      paramb.cOa = bool;
      break;
      bool = false;
    }
  }
  
  void b(aoql.a parama)
  {
    aoql.b localb = parama.jdField_a_of_type_Aoql$b;
    localb.Hf.clear();
    int i = 0;
    while (i < parama.He.size())
    {
      aoql.b.b localb1 = new aoql.b.b();
      localb.Hf.add(i, localb1);
      i += 1;
    }
  }
  
  byte[] b(List<aoql.a.k> paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (aoql.a.k)paramList.get(i), localReqBody);
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
  
  protected void f(ProtoReqManager.c paramc)
  {
    paramc.clW = "LongConn.OffPicUp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopy
 * JD-Core Version:    0.7.0.1
 */