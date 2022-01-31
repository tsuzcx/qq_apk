package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class C2CPttUpHandler
  extends BaseHandler
{
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x346.ReqBody paramReqBody) {}
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    Object localObject = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    int i;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    RichProto.RichProtoResp.C2CPttUpResp localC2CPttUpResp;
    for (;;)
    {
      RichProtoProc.a(localRichProtoReq, localRichProtoResp);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramProtoResp = new cmd0x346.RspBody();
        paramProtoResp.mergeFrom(arrayOfByte);
        localObject = (cmd0x346.ApplyUploadRsp)paramProtoResp.msg_apply_upload_rsp.get();
        localC2CPttUpResp = (RichProto.RichProtoResp.C2CPttUpResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
        i = ((cmd0x346.ApplyUploadRsp)localObject).int32_ret_code.get();
        if (i != 0) {
          break label419;
        }
        localC2CPttUpResp.jdField_a_of_type_JavaLangString = ((cmd0x346.ApplyUploadRsp)localObject).bytes_uuid.get().toStringUtf8();
        if ((!((cmd0x346.ApplyUploadRsp)localObject).bool_file_exist.has()) || (!((cmd0x346.ApplyUploadRsp)localObject).bool_file_exist.get())) {
          break;
        }
        localC2CPttUpResp.jdField_a_of_type_Boolean = true;
      }
      catch (Exception paramProtoResp)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    if (((cmd0x346.ApplyUploadRsp)localObject).uint32_pack_size.has()) {
      localC2CPttUpResp.jdField_a_of_type_Int = ((cmd0x346.ApplyUploadRsp)localObject).uint32_pack_size.get();
    }
    String str = HexUtil.bytes2HexStr(((cmd0x346.ApplyUploadRsp)localObject).bytes_upload_key.get().toByteArray());
    localC2CPttUpResp.b = str;
    paramProtoReq = ((cmd0x346.ApplyUploadRsp)localObject).str_upload_ip.get();
    paramProtoResp = paramProtoReq;
    if (paramProtoReq == null) {
      paramProtoResp = ((cmd0x346.ApplyUploadRsp)localObject).str_upload_domain.get();
    }
    for (;;)
    {
      label357:
      throw new Exception("ukey or ip missing");
      label419:
      do
      {
        paramProtoReq = new ServerAddr();
        paramProtoReq.jdField_a_of_type_JavaLangString = paramProtoResp;
        paramProtoReq.b = ((cmd0x346.ApplyUploadRsp)localObject).uint32_upload_port.get();
        localC2CPttUpResp.jdField_a_of_type_JavaUtilArrayList.add(paramProtoReq);
        a(0, 0, "", "", localStatictisInfo, localC2CPttUpResp);
        break;
        a(-1, -9527, BaseTransProcessor.a(i), "", localStatictisInfo, localC2CPttUpResp);
        break;
        if (str == null) {
          break label357;
        }
      } while (paramProtoResp != null);
    }
  }
  
  void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    localRichProtoResp.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramRichProtoReq.jdField_a_of_type_JavaUtilList.size())
    {
      RichProto.RichProtoResp.C2CPttUpResp localC2CPttUpResp = new RichProto.RichProtoResp.C2CPttUpResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localC2CPttUpResp);
      i += 1;
    }
  }
  
  byte[] a(List paramList)
  {
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(500);
    localReqBody.uint32_seq.set(0);
    localReqBody.uint32_business_id.set(17);
    localReqBody.uint32_client_type.set(104);
    RichProto.RichProtoReq.PttUpReq localPttUpReq;
    if (paramList.size() == 1)
    {
      localPttUpReq = (RichProto.RichProtoReq.PttUpReq)paramList.get(0);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localPttUpReq.jdField_c_of_type_JavaLangString));
      try
      {
        String str = localPttUpReq.d;
        paramList = str;
        if (str.startsWith("+")) {
          paramList = str.substring(1);
        }
        long l = Long.valueOf(paramList).longValue();
        localApplyUploadReq.uint64_recver_uin.set(l);
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          int i;
          paramList.printStackTrace();
          continue;
          if (localPttUpReq.jdField_a_of_type_Boolean)
          {
            i = 500;
            continue;
            paramList.str_dst_phonenum.set(localPttUpReq.d);
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
      }
      localApplyUploadReq.str_file_name.set(localPttUpReq.jdField_a_of_type_JavaLangString);
      localApplyUploadReq.uint64_file_size.set(localPttUpReq.b);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localPttUpReq.jdField_a_of_type_ArrayOfByte));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      paramList = new cmd0x346.ExtensionReq();
      paramList.uint64_id.set(3L);
      switch (localPttUpReq.jdField_c_of_type_Int)
      {
      default: 
        i = 0;
        paramList.uint64_type.set(i);
        localReqBody.msg_extension_req.set(paramList);
        return localReqBody.toByteArray();
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  public void c(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPttUpHandler
 * JD-Core Version:    0.7.0.1
 */