import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;
import pttcenterservice.PttShortVideo.DataHole;
import pttcenterservice.PttShortVideo.ExtensionReq;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class aoqq
  extends aopw
{
  public static boolean lR(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
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
      localc.clW = "PttCenterSvr.ShortVideoUpReq";
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
        localc.clW = "PttCenterSvr.GroupShortVideoUpReq";
      } else {
        localc.clW = "PttCenterSvr.ShortVideoUpReq";
      }
    }
    label131:
    throw new RuntimeException("only support one request");
  }
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    Object localObject = paramd.g;
    byte[] arrayOfByte = paramd.g.getWupBuffer();
    aoql.a locala = (aoql.a)paramc.fi;
    aoql.b localb = locala.jdField_a_of_type_Aoql$b;
    achq.a locala1 = paramd.a;
    int i;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.b((FromServiceMsg)localObject), "", locala1, localb.Hf);
      }
    }
    for (;;)
    {
      aoqm.a(locala, localb);
      return;
      a(-1, 9044, MessageHandler.b((FromServiceMsg)localObject), "", locala1, localb.Hf);
      continue;
      try
      {
        localObject = (PttShortVideo.PttShortVideoUploadResp)((PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte)).msg_PttShortVideoUpload_Resp.get();
        if (localObject != null) {
          break label221;
        }
        throw new Exception("svUpResp null");
      }
      catch (Exception paramd)
      {
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), locala1, localb.Hf);
      }
      continue;
      for (;;)
      {
        try
        {
          for (;;)
          {
            label221:
            paramd = (aoql.b.p)localb.Hf.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoUploadResp)localObject).int32_ret_code.get();
              if (i != 0) {
                break label487;
              }
              if (1 != ((PttShortVideo.PttShortVideoUploadResp)localObject).uint32_file_exist.get()) {
                break label377;
              }
              paramd.isExist = true;
              paramd.fileId = ((PttShortVideo.PttShortVideoUploadResp)localObject).str_fileid.get();
              paramd.videoAttr = ((PttShortVideo.PttShortVideoUploadResp)localObject).uint32_is_hot_file.get();
              paramd.videoKandianType = ((PttShortVideo.PttShortVideoUploadResp)localObject).uint32_long_video_carry_watch_point_type.get();
              a(0, 0, "", "", locala1, paramd);
            }
            catch (Exception localException)
            {
              paramc = paramd;
              paramd = localException;
            }
          }
        }
        catch (Exception paramd)
        {
          label377:
          paramc = null;
          continue;
        }
        a(-1, -9527, aojn.x("P", -9529L), paramd.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), locala1, paramc);
        break;
        paramc = localException.bytes_ukey.get().toByteArray();
        if (((localException.rpt_same_area_out_addr.size() <= 0) && (localException.rpt_diff_area_out_addr.size() <= 0)) || (paramc == null) || (paramc.length == 0)) {
          throw new Exception("check ip, port, ukey");
        }
        paramd.fileId = localException.str_fileid.get();
        paramc = localException.rpt_data_hole.get();
        if ((paramc != null) && (paramc.size() > 0)) {
          paramd.startOffset = ((PttShortVideo.DataHole)paramc.get(0)).uint64_begin.get();
        }
      }
      label487:
      if (lR(i))
      {
        this.dOO += 1;
        if (this.dOO < 2)
        {
          locala.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(paramc);
          return;
        }
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
      aoql.b.p localp = new aoql.b.p();
      localb.Hf.add(i, localp);
      i += 1;
    }
  }
  
  byte[] b(List<aoql.a.k> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (aoql.a.n)paramList.get(0);
      PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
      localPttShortVideoUploadReq.setHasFlag(true);
      localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(paramList.selfUin));
      localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(paramList.peerUin));
      localPttShortVideoUploadReq.uint32_chat_type.set(paramList.chatType);
      localPttShortVideoUploadReq.uint32_client_type.set(paramList.clientType);
      if (paramList.troopUin != null) {
        localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(paramList.troopUin));
      }
      for (;;)
      {
        localPttShortVideoUploadReq.uint32_agent_type.set(paramList.dRn);
        localPttShortVideoUploadReq.uint32_business_type.set(paramList.busiType);
        localPttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
        Object localObject = new PttShortVideo.PttShortVideoFileInfo();
        ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name.set(paramList.fileName);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(paramList.md5));
        ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(paramList.fG));
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_file_size.set(paramList.fileSize);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_length.set(paramList.dRo);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_width.set(paramList.dRp);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_format.set(paramList.format);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_time.set(paramList.dFo);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_thumb_file_size.set(paramList.JW);
        localPttShortVideoUploadReq.msg_PttShortVideoFileInfo.set((MessageMicro)localObject);
        localObject = new PttShortVideo.ExtensionReq();
        ((PttShortVideo.ExtensionReq)localObject).uint32_sub_busi_type.set(paramList.subBusiType);
        ((PttShortVideo.ExtensionReq)localObject).uint32_user_cnt.set(paramList.dRq);
        localReqBody.uint32_cmd.set(300);
        localReqBody.uint32_seq.set(paramList.seq);
        localReqBody.msg_PttShortVideoUpload_Req.set(localPttShortVideoUploadReq);
        localReqBody.rpt_msg_extension_req.add((MessageMicro)localObject);
        return localReqBody.toByteArray();
        localPttShortVideoUploadReq.uint64_group_code.set(0L);
      }
    }
    throw new RuntimeException("only support one request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqq
 * JD-Core Version:    0.7.0.1
 */