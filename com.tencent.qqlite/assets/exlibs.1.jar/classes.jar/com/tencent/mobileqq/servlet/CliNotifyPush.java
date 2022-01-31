package com.tencent.mobileqq.servlet;

import android.content.Intent;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sc.qzonepush.QQService.SvcMsgPush;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class CliNotifyPush
  extends MSFServlet
{
  private static final String jdField_a_of_type_JavaLangString = "CliNotifyPush";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static final String b = "CliNotifySvc.SvcReqPush";
  
  static
  {
    a = new String[] { "baseSdk.Msf.NotifyResp", "CliNotifySvc.SvcReqPush" };
  }
  
  public String[] getPreferSSOCommands()
  {
    return a;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify begin");
    }
    if ((paramFromServiceMsg.getServiceCmd().equals("CliNotifySvc.SvcReqPush")) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify");
      }
      paramIntent = (byte[])paramFromServiceMsg.attributes.get("pushMsgs");
      SvcMsgPush localSvcMsgPush = new SvcMsgPush();
      localSvcMsgPush.readFrom(new JceInputStream(paramIntent));
      ((MessageHandler)((QQAppInterface)getAppRuntime()).a(0)).a(null, paramFromServiceMsg, localSvcMsgPush);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.CliNotifyPush
 * JD-Core Version:    0.7.0.1
 */