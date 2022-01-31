package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pttcenterservice.PttShortVideo.PttShortVideoDownloadReq;
import pttcenterservice.PttShortVideo.PttShortVideoDownloadResp;
import pttcenterservice.PttShortVideo.PttShortVideoIpList;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class ShortVideoDownHandler
  extends BaseHandler
{
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    Object localObject1 = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    paramProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = paramProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    paramProtoResp = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    int i;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject1).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject1), "", paramProtoResp, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      RichProtoProc.a(paramProtoReq, localRichProtoResp);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject1), "", paramProtoResp, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      Object localObject3;
      try
      {
        localObject1 = new PttShortVideo.RspBody();
        ((PttShortVideo.RspBody)localObject1).mergeFrom(arrayOfByte);
        localObject3 = (PttShortVideo.PttShortVideoDownloadResp)((PttShortVideo.RspBody)localObject1).msg_PttShortVideoDownload_Resp.get();
        localObject1 = (RichProto.RichProtoResp.ShortVideoDownResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
        i = ((PttShortVideo.PttShortVideoDownloadResp)localObject3).int32_ret_code.get();
        if (i != 0) {
          break label494;
        }
        localObject2 = ((PttShortVideo.PttShortVideoDownloadResp)localObject3).bytes_downloadkey.get().toByteArray();
        if ((((PttShortVideo.PttShortVideoDownloadResp)localObject3).rpt_same_area_out_addr.size() > 0) && (((PttShortVideo.PttShortVideoDownloadResp)localObject3).rpt_diff_area_out_addr.size() > 0) && (localObject2 != null) && (localObject2.length != 0)) {
          break label290;
        }
        throw new Exception("check ip, port, ukey");
      }
      catch (Exception localException)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), localException.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), paramProtoResp, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label290:
      localException.jdField_a_of_type_JavaLangString = HexUtil.bytes2HexStr((byte[])localObject2);
      localException.jdField_a_of_type_ArrayOfByte = ((PttShortVideo.PttShortVideoDownloadResp)localObject3).bytes_file_md5.get().toByteArray();
      Object localObject2 = ((PttShortVideo.PttShortVideoDownloadResp)localObject3).rpt_same_area_out_addr.get();
      ((List)localObject2).addAll(((PttShortVideo.PttShortVideoDownloadResp)localObject3).rpt_diff_area_out_addr.get());
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject3 = (PttShortVideo.PttShortVideoIpList)((List)localObject2).get(i);
        ((PttShortVideo.PttShortVideoIpList)localObject3).uint32_ip.get();
        long l = ((PttShortVideo.PttShortVideoIpList)localObject3).uint32_ip.get() & 0xFFFFFFFF;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVidwoDownHandler", 2, "onProtoResp---------- ip = " + l);
        }
        int j = ((PttShortVideo.PttShortVideoIpList)localObject3).uint32_port.get();
        localObject3 = new ServerAddr();
        ((ServerAddr)localObject3).jdField_a_of_type_JavaLangString = PkgTools.a(l);
        ((ServerAddr)localObject3).jdField_b_of_type_Int = j;
        localException.jdField_a_of_type_JavaUtilArrayList.add(i, localObject3);
        i += 1;
      }
      a(0, 0, "", "", paramProtoResp, localException);
      continue;
      label494:
      if (i == -5100026) {
        a(-1, -5100026, BaseTransProcessor.a(i), "", paramProtoResp, localException);
      } else {
        a(-1, -9527, BaseTransProcessor.a(i), "", paramProtoResp, localException);
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
      RichProto.RichProtoResp.ShortVideoDownResp localShortVideoDownResp = new RichProto.RichProtoResp.ShortVideoDownResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localShortVideoDownResp);
      i += 1;
    }
  }
  
  byte[] a(List paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (RichProto.RichProtoReq.ShortVideoDownReq)paramList.get(0);
      PttShortVideo.PttShortVideoDownloadReq localPttShortVideoDownloadReq = new PttShortVideo.PttShortVideoDownloadReq();
      localPttShortVideoDownloadReq.uint64_touin.set(Long.parseLong(paramList.jdField_c_of_type_JavaLangString));
      localPttShortVideoDownloadReq.uint32_chat_type.set(paramList.jdField_a_of_type_Int);
      if (paramList.jdField_a_of_type_Int == 0) {
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.d));
      }
      for (;;)
      {
        localPttShortVideoDownloadReq.uint32_client_type.set(paramList.jdField_b_of_type_Int);
        localPttShortVideoDownloadReq.str_fileid.set(paramList.jdField_a_of_type_JavaLangString);
        localPttShortVideoDownloadReq.uint64_group_code.set(Long.parseLong(paramList.jdField_b_of_type_JavaLangString));
        localPttShortVideoDownloadReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramList.jdField_a_of_type_ArrayOfByte));
        localPttShortVideoDownloadReq.uint32_agent_type.set(paramList.jdField_e_of_type_Int);
        localReqBody.uint32_cmd.set(400);
        localReqBody.uint32_seq.set(paramList.jdField_c_of_type_Int);
        localReqBody.msg_PttShortVideoDownload_Req.set(localPttShortVideoDownloadReq);
        return localReqBody.toByteArray();
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.jdField_e_of_type_JavaLangString));
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  public void c(RichProto.RichProtoReq paramRichProtoReq)
  {
    ProtoReqManager.ProtoReq localProtoReq;
    RichProto.RichProtoReq.ReqCommon localReqCommon;
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      localProtoReq = new ProtoReqManager.ProtoReq();
      if (paramRichProtoReq.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label134;
      }
      localReqCommon = (RichProto.RichProtoReq.ReqCommon)paramRichProtoReq.jdField_a_of_type_JavaUtilList.get(0);
      if (localReqCommon.d != 0) {
        break label96;
      }
      localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
    }
    for (;;)
    {
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
      return;
      label96:
      if ((1 == localReqCommon.d) || (3000 == localReqCommon.d)) {
        localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.GroupShortVideoDownReq";
      } else {
        localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
      }
    }
    label134:
    throw new RuntimeException("only support one request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.ShortVideoDownHandler
 * JD-Core Version:    0.7.0.1
 */