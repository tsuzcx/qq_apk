package com.tencent.mobileqq.service.message;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class MessageService
  extends BaseProtocolCoder
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "MessageSvc", "TransService", "StreamSvr", "ADMsgSvc", "VideoSvc", "VideoCCSvc", "OnlinePush", "KQQGroupPic", "AccostSvc", "SecretFileSvc", "MultiVideo" };
  private MessageFactoryReceiver jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactoryReceiver = new MessageFactoryReceiver();
  private MessageFactorySender jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactorySender = new MessageFactorySender();
  
  public MessageService(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactorySender.a(paramQQAppInterface);
  }
  
  public int a()
  {
    return 1;
  }
  
  public FromServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    return new FromServiceMsg(paramToServiceMsg.getAppId(), paramToServiceMsg.getRequestSsoSeq(), paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactoryReceiver.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public String a()
  {
    return "MessageService";
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactoryReceiver.a(paramToServiceMsg, 1002, "");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactoryReceiver.a(paramToServiceMsg, paramInt, paramString);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactorySender.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactorySender = null;
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageFactoryReceiver = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageService
 * JD-Core Version:    0.7.0.1
 */