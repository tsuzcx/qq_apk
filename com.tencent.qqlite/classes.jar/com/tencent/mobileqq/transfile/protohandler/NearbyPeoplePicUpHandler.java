package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x6ff.subcmd0x501.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody;

public class NearbyPeoplePicUpHandler
  extends BaseHandler
{
  public static final int ap = 5;
  public static final String d = "HttpConn.0x6ff_501";
  
  private byte[] a(List paramList)
  {
    subcmd0x501.ReqBody localReqBody = new subcmd0x501.ReqBody();
    subcmd0x501.SubCmd0x501ReqBody localSubCmd0x501ReqBody = new subcmd0x501.SubCmd0x501ReqBody();
    if ((paramList != null) && (paramList.size() == 1))
    {
      paramList = (RichProto.RichProtoReq.NearbyPeoplePicUpReq)paramList.get(0);
      localSubCmd0x501ReqBody.uint64_uin.set(Long.parseLong(paramList.jdField_a_of_type_JavaLangString));
      localSubCmd0x501ReqBody.uint32_idc_id.set(0);
      localSubCmd0x501ReqBody.uint32_appid.set(16);
      localSubCmd0x501ReqBody.uint32_login_sig_type.set(1);
      localSubCmd0x501ReqBody.uint32_request_flag.set(3);
      paramList = new ArrayList();
      paramList.add(Integer.valueOf(5));
      localSubCmd0x501ReqBody.rpt_uint32_service_types.set(paramList);
      localReqBody.msg_subcmd_0x501_req_body.set(localSubCmd0x501ReqBody);
      return localReqBody.toByteArray();
    }
    throw new RuntimeException("only support one request");
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    Object localObject = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    paramProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = paramProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      int i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      for (;;)
      {
        RichProtoProc.a(paramProtoReq, localRichProtoResp);
        return;
        a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      try
      {
        paramProtoResp = ((subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)new subcmd0x501.RspBody().mergeFrom(arrayOfByte)).msg_subcmd_0x501_rsp_body.get()).bytes_httpconn_sig_session.get();
        if ((paramProtoResp == null) || (paramProtoResp.toByteArray().length <= 0)) {
          break label264;
        }
        paramProtoResp = paramProtoResp.toByteArray();
        localObject = (RichProto.RichProtoResp.NearbyPeoplePicUpResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
        ((RichProto.RichProtoResp.NearbyPeoplePicUpResp)localObject).jdField_a_of_type_ArrayOfByte = paramProtoResp;
        a(0, 0, "", "", localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject);
      }
      catch (Exception paramProtoResp)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      break;
      label264:
      paramProtoResp = null;
    }
  }
  
  void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    localRichProtoResp.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramRichProtoReq.jdField_a_of_type_JavaUtilList.size())
    {
      RichProto.RichProtoResp.NearbyPeoplePicUpResp localNearbyPeoplePicUpResp = new RichProto.RichProtoResp.NearbyPeoplePicUpResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localNearbyPeoplePicUpResp);
      i += 1;
    }
  }
  
  public void c(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "HttpConn.0x6ff_501";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.NearbyPeoplePicUpHandler
 * JD-Core Version:    0.7.0.1
 */