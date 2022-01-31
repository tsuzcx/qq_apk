package com.tencent.mobileqq.transfile;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ProtoServlet
  extends MSFServlet
{
  public static final String a = "key_cmd";
  public static final String b = "key_body";
  public static final String c = "key_timeout";
  public static final String d = "key_fastresend";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    ((QQAppInterface)getAppRuntime()).a().a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent != null)
    {
      paramPacket.setSSOCommand(paramIntent.getStringExtra("key_cmd"));
      paramPacket.putSendData(paramIntent.getByteArrayExtra("key_body"));
      paramPacket.setTimeout(paramIntent.getLongExtra("key_timeout", 30000L));
      paramPacket.addAttribute("fastresend", Boolean.valueOf(paramIntent.getBooleanExtra("key_fastresend", false)));
      paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(paramIntent.getBooleanExtra("remind_slown_network", true)));
    }
  }
  
  protected void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    super.sendToMSF(paramIntent, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoServlet
 * JD-Core Version:    0.7.0.1
 */