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
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pttcenterservice.PttShortVideo.DataHole;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoRetweetReq;
import pttcenterservice.PttShortVideo.PttShortVideoRetweetResp;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class aoqp
  extends aopw
{
  public static boolean lR(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      if (parama.He.size() == 1)
      {
        localc.clW = "PttCenterSvr.ShortVideoRetweetReq";
        localc.fW = b(parama.He);
        localc.fi = parama;
        localc.a = this;
        a(parama, localc);
      }
    }
    else
    {
      return;
    }
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
        localObject = (PttShortVideo.PttShortVideoRetweetResp)((PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte)).rpt_msg_short_video_retweet_resp.get(0);
        if (localObject != null) {
          break label222;
        }
        throw new Exception("forwardResp null");
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
            label222:
            paramd = (aoql.b.o)localb.Hf.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoRetweetResp)localObject).int32_ret_code.get();
              if (i != 0) {
                break label488;
              }
              if (1 != ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_file_exist.get()) {
                break label378;
              }
              paramd.isExist = true;
              paramd.fileId = ((PttShortVideo.PttShortVideoRetweetResp)localObject).str_fileid.get();
              paramd.videoAttr = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_is_hot_file.get();
              paramd.videoKandianType = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_long_video_carry_watch_point_type.get();
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
          label378:
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
      label488:
      if (i == -5100026)
      {
        a(-1, -5100026, aojn.bH(i), "", locala1, paramd);
      }
      else
      {
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
  }
  
  void b(aoql.a parama)
  {
    aoql.b localb = parama.jdField_a_of_type_Aoql$b;
    localb.Hf.clear();
    int j = parama.He.size();
    int i = 0;
    while (i < j)
    {
      parama = new aoql.b.o();
      localb.Hf.add(i, parama);
      i += 1;
    }
  }
  
  byte[] b(List<aoql.a.k> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      aoql.a.m localm = (aoql.a.m)paramList.get(0);
      PttShortVideo.PttShortVideoRetweetReq localPttShortVideoRetweetReq = new PttShortVideo.PttShortVideoRetweetReq();
      localPttShortVideoRetweetReq.setHasFlag(true);
      localPttShortVideoRetweetReq.uint64_from_uin.set(Long.parseLong(localm.fromUin));
      localPttShortVideoRetweetReq.uint64_to_uin.set(Long.parseLong(localm.peerUin));
      localPttShortVideoRetweetReq.uint32_from_chat_type.set(localm.fromChatType);
      localPttShortVideoRetweetReq.uint32_to_chat_type.set(localm.toChatType);
      localPttShortVideoRetweetReq.uint32_from_busi_type.set(localm.dFm);
      localPttShortVideoRetweetReq.uint32_to_busi_type.set(localm.dFn);
      localPttShortVideoRetweetReq.uint32_client_type.set(localm.clientType);
      localPttShortVideoRetweetReq.uint32_agent_type.set(localm.dRn);
      Object localObject = localPttShortVideoRetweetReq.str_fileid;
      if (localm.uuid == null)
      {
        paramList = "";
        ((PBStringField)localObject).set(paramList);
        if (localm.troopUin == null) {
          break label438;
        }
      }
      for (;;)
      {
        try
        {
          localPttShortVideoRetweetReq.uint64_group_code.set(Long.parseLong(localm.troopUin));
          localPttShortVideoRetweetReq.uint32_flag_support_large_size.set(1);
          localObject = new PttShortVideo.PttShortVideoFileInfo();
          PBStringField localPBStringField = ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name;
          if (localm.fileName != null) {
            break label450;
          }
          paramList = "";
          localPBStringField.set(paramList);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(localm.md5));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(localm.fG));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_file_size.set(localm.fileSize);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_length.set(localm.dRo);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_width.set(localm.dRp);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_format.set(localm.format);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_time.set(localm.dFo);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_thumb_file_size.set(localm.JW);
          localPttShortVideoRetweetReq.msg_PttShortVideoFileInfo.set((MessageMicro)localObject);
          localReqBody.uint32_cmd.set(500);
          localReqBody.uint32_seq.set(localm.seq);
          localReqBody.rpt_msg_short_video_retweet_req.add(localPttShortVideoRetweetReq);
          return localReqBody.toByteArray();
          paramList = localm.uuid;
        }
        catch (NumberFormatException paramList)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.ShortVideoForwardHandler", 2, "NumberFormatException e = " + paramList);
          }
          localPttShortVideoRetweetReq.uint64_group_code.set(0L);
          continue;
        }
        label438:
        localPttShortVideoRetweetReq.uint64_group_code.set(0L);
        continue;
        label450:
        paramList = localm.fileName;
      }
    }
    throw new RuntimeException("only support one request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqp
 * JD-Core Version:    0.7.0.1
 */