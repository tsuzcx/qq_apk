import android.text.TextUtils;
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

public class aoqc
  extends aoqk
{
  int dRk;
  
  public static boolean lR(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202);
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
    localTryUpImgReq.uint32_app_pic_type.set(paramk.busiType);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (paramk.uinType == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(aonc.getVersionCode()));
      localTryUpImgReq.uint32_srv_upload.set(paramk.dRm);
      if (paramk.cMs) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      if (!TextUtils.isEmpty(paramk.cmB)) {
        localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(paramk.cmB));
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
      localc.clW = "ImgStore.GroupPicUp";
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
          locale = (aoql.b.e)paramb.Hf.get((int)paramd.uint64_file_id.get());
          if (locale == null) {
            continue;
          }
          try
          {
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              locale.cOc = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = paramd.uint32_result.get();
            if (i != 0) {
              break label802;
            }
            locale.groupFileID = paramd.uint64_fileid.get();
            long l1;
            long l2;
            if ((paramd.bool_file_exit.has()) && (paramd.bool_file_exit.get()))
            {
              locale.isExist = true;
              localList = paramd.rpt_uint32_up_ip.get();
              paramd = paramd.rpt_uint32_up_port.get();
              if ((localList == null) || (localList.size() <= 0)) {
                break label783;
              }
              i = 0;
              while (i < localList.size())
              {
                l1 = ((Integer)localList.get(i)).intValue();
                l2 = ((Integer)paramd.get(i)).intValue();
                localObject = new aonh();
                ((aonh)localObject).mIp = aqoj.bS(l1 & 0xFFFFFFFF);
                ((aonh)localObject).port = ((int)l2);
                locale.xp.add(i, localObject);
                i += 1;
              }
            }
            List localList = paramd.rpt_uint32_up_ip.get();
            localObject = paramd.rpt_uint32_up_port.get();
            if ((localList != null) && (localList.size() > 0))
            {
              i = 0;
              while (i < localList.size())
              {
                l1 = ((Integer)localList.get(i)).intValue();
                l2 = ((Integer)((List)localObject).get(i)).intValue();
                aonh localaonh = new aonh();
                localaonh.mIp = aqoj.bS(l1 & 0xFFFFFFFF);
                localaonh.port = ((int)l2);
                locale.xp.add(i, localaonh);
                i += 1;
              }
            }
            localObject = HexUtil.bytes2HexStr(paramd.bytes_up_ukey.get().toByteArray());
            if ((localObject != null) && (!((String)localObject).equals("")) && (localList != null) && (localList.size() != 0)) {
              break label643;
            }
            throw new Exception("check ukey,iplist");
          }
          catch (Exception paramd) {}
        }
        catch (Exception paramd)
        {
          for (;;)
          {
            int i;
            Object localObject;
            aoql.b.e locale = null;
            continue;
            boolean bool = false;
          }
        }
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), parama1, locale);
        continue;
        label643:
        locale.mUkey = ((String)localObject);
        locale.blockSize = ((int)paramd.uint64_block_size.get());
        locale.transferedSize = ((int)paramd.uint64_up_offset.get());
        if (aomi.a().getNetType() == this.dRk) {
          break label870;
        }
        bool = true;
        locale.cOa = bool;
        locale.startOffset = paramd.uint64_up_offset.get();
        if (QLog.isColorLevel()) {
          QLog.d("BDH_LOG", 2, " Channel:" + paramd.bool_new_big_chan.get());
        }
        if ((paramd.bool_new_big_chan.has()) && (paramd.bool_new_big_chan.get() == true)) {
          locale.cOb = true;
        }
        label783:
        a(0, 0, "", "", parama1, locale);
        continue;
        label802:
        if (lR(i))
        {
          this.dOO += 1;
          if (this.dOO < 2)
          {
            parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(paramc);
            return;
          }
        }
        a(-1, -9527, aojn.bH(i), "", parama1, locale);
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
      aoql.b.e locale = new aoql.b.e();
      localb.Hf.add(i, locale);
      i += 1;
    }
  }
  
  byte[] b(List<aoql.a.k> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqc
 * JD-Core Version:    0.7.0.1
 */