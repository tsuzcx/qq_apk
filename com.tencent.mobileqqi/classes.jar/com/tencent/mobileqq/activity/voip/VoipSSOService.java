package com.tencent.mobileqq.activity.voip;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class VoipSSOService
  extends BaseProtocolCoder
{
  private static final String jdField_a_of_type_JavaLangString = "QQiSvc.fs_account";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static final String b = "QQiSvc.balance_info";
  private static final String c = "QQiSvc.sendUinInfo";
  
  static
  {
    a = new String[] { "QQiSvc" };
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return true;
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipSSOService
 * JD-Core Version:    0.7.0.1
 */