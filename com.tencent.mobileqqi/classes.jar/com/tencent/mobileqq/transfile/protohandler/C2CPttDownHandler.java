package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class C2CPttDownHandler
  extends BaseHandler
{
  int ak = 17;
  
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
      try
      {
        localObject1 = new cmd0x346.RspBody();
        ((cmd0x346.RspBody)localObject1).mergeFrom(arrayOfByte);
        Object localObject2 = (cmd0x346.ApplyDownloadRsp)((cmd0x346.RspBody)localObject1).msg_apply_download_rsp.get();
        localObject1 = (RichProto.RichProtoResp.C2CPttDownResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
        i = ((cmd0x346.ApplyDownloadRsp)localObject2).int32_ret_code.get();
        if (i != 0) {
          break label302;
        }
        localObject2 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadRsp)localObject2).msg_download_info.get();
        if ((localObject2 == null) || (!((cmd0x346.DownloadInfo)localObject2).str_download_url.has())) {
          break label292;
        }
        ((RichProto.RichProtoResp.C2CPttDownResp)localObject1).jdField_a_of_type_JavaLangString = ((cmd0x346.DownloadInfo)localObject2).str_download_url.get();
        a(0, 0, "", "", paramProtoResp, (RichProto.RichProtoResp.RespCommon)localObject1);
      }
      catch (Exception localException)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), localException.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), paramProtoResp, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label292:
      throw new Exception("no url");
      label302:
      a(-1, -9527, BaseTransProcessor.a(i), "", paramProtoResp, localException);
    }
  }
  
  void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    localRichProtoResp.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramRichProtoReq.jdField_a_of_type_JavaUtilList.size())
    {
      RichProto.RichProtoResp.C2CPttDownResp localC2CPttDownResp = new RichProto.RichProtoResp.C2CPttDownResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localC2CPttDownResp);
      i += 1;
    }
  }
  
  byte[] a(List paramList)
  {
    int i = 1;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    if (paramList.size() == 1)
    {
      paramList = (RichProto.RichProtoReq.C2CPttDownReq)paramList.get(0);
      Object localObject;
      if ("ftn".equals(paramList.b))
      {
        this.ak = 3;
        localObject = new cmd0x346.ApplyDownloadReq();
        ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(Long.parseLong(paramList.jdField_c_of_type_JavaLangString));
        ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFromUtf8(paramList.jdField_a_of_type_JavaLangString));
        PBUInt32Field localPBUInt32Field = ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type;
        if (!paramList.jdField_a_of_type_Boolean) {
          break label332;
        }
        label101:
        localPBUInt32Field.set(i);
        localReqBody.uint32_cmd.set(1200);
        localReqBody.uint32_seq.set(0);
        localReqBody.uint32_business_id.set(this.ak);
        localReqBody.uint32_client_type.set(104);
        localReqBody.msg_apply_download_req.set((MessageMicro)localObject);
        if (paramList.jdField_c_of_type_Int != 0)
        {
          localObject = new cmd0x346.ExtensionReq();
          ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
          switch (paramList.jdField_c_of_type_Int)
          {
          default: 
            i = 0;
          }
        }
      }
      for (;;)
      {
        ((cmd0x346.ExtensionReq)localObject).uint64_type.set(i);
        localReqBody.msg_extension_req.set((MessageMicro)localObject);
        return localReqBody.toByteArray();
        if (!"pttcenter".equals(paramList.b)) {
          break;
        }
        this.ak = 17;
        break;
        label332:
        i = 2;
        break label101;
        i = 0;
        continue;
        i = 102;
        continue;
        i = 104;
        continue;
        i = 104;
        continue;
        i = 105;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 101;
        continue;
        i = 103;
        continue;
        i = 100;
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  public void c(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200";
      if (this.ak == 3) {
        localProtoReq.jdField_a_of_type_JavaLangString = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200";
      }
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPttDownHandler
 * JD-Core Version:    0.7.0.1
 */