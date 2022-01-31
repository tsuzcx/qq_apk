package com.tencent.mobileqq.service.discussion;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class DiscussionService
  extends BaseProtocolCoder
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "QQServiceDiscussSvc" };
  private DiscussionReceiver jdField_a_of_type_ComTencentMobileqqServiceDiscussionDiscussionReceiver = new DiscussionReceiver();
  private DiscussionSender jdField_a_of_type_ComTencentMobileqqServiceDiscussionDiscussionSender = new DiscussionSender();
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceDiscussionDiscussionReceiver.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceDiscussionDiscussionSender.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.discussion.DiscussionService
 * JD-Core Version:    0.7.0.1
 */