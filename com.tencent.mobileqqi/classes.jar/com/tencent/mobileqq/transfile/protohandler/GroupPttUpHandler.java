package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttRsp;

public class GroupPttUpHandler
  extends BaseHandler
{
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.PttUpReq)paramReqCommon;
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(paramReqCommon.jdField_c_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(paramReqCommon.d).longValue());
    localTryUpPttReq.uint64_file_id.set(paramInt);
    localTryUpPttReq.uint64_file_size.set(paramReqCommon.b);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.jdField_a_of_type_ArrayOfByte));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramReqCommon.jdField_a_of_type_JavaLangString));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (paramReqCommon.jdField_c_of_type_Int == 1) {}
    for (paramInt = 3;; paramInt = 4)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.a()));
      localTryUpPttReq.uint32_voice_length.set(paramReqCommon.jdField_a_of_type_Int);
      paramReqBody.rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      return;
    }
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    localObject1 = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    int i;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject1).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject1), "", localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      RichProtoProc.a(localRichProtoReq, localRichProtoResp);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject1), "", localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramProtoResp = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_ptt_rsp.get();
        if ((paramProtoResp != null) && (paramProtoResp.size() != 0)) {
          break label225;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramProtoResp)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label225:
      Iterator localIterator = paramProtoResp.iterator();
      while (localIterator.hasNext())
      {
        paramProtoResp = (cmd0x388.TryUpPttRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (RichProto.RichProtoResp.GroupPttUpResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get((int)paramProtoResp.uint64_file_id.get());
              try
              {
                i = paramProtoResp.uint32_result.get();
                if (i != 0) {
                  break label619;
                }
                ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).jdField_a_of_type_Long = paramProtoResp.uint64_fileid.get();
                if ((!paramProtoResp.bool_file_exit.has()) || (!paramProtoResp.bool_file_exit.get())) {
                  break label398;
                }
                ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).jdField_a_of_type_Boolean = true;
                a(0, 0, "", "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
              }
              catch (Exception paramProtoResp) {}
            }
          }
          catch (Exception paramProtoResp)
          {
            label398:
            List localList;
            Object localObject2;
            long l1;
            long l2;
            ServerAddr localServerAddr;
            localObject1 = null;
            continue;
          }
          a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
          break;
          localList = paramProtoResp.rpt_uint32_up_ip.get();
          localObject2 = paramProtoResp.rpt_uint32_up_port.get();
          if ((localList != null) && (localList.size() > 0))
          {
            i = 0;
            if (i < localList.size())
            {
              l1 = ((Integer)localList.get(i)).intValue();
              l2 = ((Integer)((List)localObject2).get(i)).intValue();
              localServerAddr = new ServerAddr();
              localServerAddr.jdField_a_of_type_JavaLangString = PkgTools.a(l1 & 0xFFFFFFFF);
              localServerAddr.b = ((int)l2);
              ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localServerAddr);
              i += 1;
              continue;
            }
          }
          localObject2 = HexUtil.bytes2HexStr(paramProtoResp.bytes_up_ukey.get().toByteArray());
          if ((localObject2 == null) || (((String)localObject2).equals("")) || (localList == null) || (localList.size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).jdField_a_of_type_Int = ((int)paramProtoResp.uint64_block_size.get());
          ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).b = ((int)paramProtoResp.uint64_up_offset.get());
        }
        label619:
        if (GroupPicUpHandler.a(i))
        {
          this.aj += 1;
          if (this.aj < 2)
          {
            localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramProtoReq);
            return;
          }
        }
        a(-1, -9527, BaseTransProcessor.a(i), "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
      }
    }
  }
  
  void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    localRichProtoResp.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramRichProtoReq.jdField_a_of_type_JavaUtilList.size())
    {
      RichProto.RichProtoResp.GroupPttUpResp localGroupPttUpResp = new RichProto.RichProtoResp.GroupPttUpResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localGroupPttUpResp);
      i += 1;
    }
  }
  
  byte[] a(List paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(3);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), localReqBody);
      i += 1;
    }
    return localReqBody.toByteArray();
  }
  
  public void c(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicUp#pttGu";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GroupPttUpHandler
 * JD-Core Version:    0.7.0.1
 */