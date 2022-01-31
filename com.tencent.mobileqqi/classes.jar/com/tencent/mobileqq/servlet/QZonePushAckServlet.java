package com.tencent.mobileqq.servlet;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneMsfPushAckRequest;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZonePushAckServlet
  extends MSFServlet
{
  private static final int a = 60000;
  public static final String a = "timestamp";
  public static final String b = "hostuin";
  private static final String c = "SQQzoneSvc.";
  private static final String d = QZonePushAckServlet.class.getSimpleName();
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg) {}
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    long l = paramIntent.getLongExtra("timestamp", 0L);
    byte[] arrayOfByte = QZoneMsfPushAckRequest.a(paramIntent.getLongExtra("hostuin", 0L), l, paramIntent.getStringExtra("refer"));
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + "wns.pushrsp");
    paramPacket.putSendData(paramIntent);
    QLog.d("MessageSvc.WNSQzone.Push", 2, "发送push ack 时间:" + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZonePushAckServlet
 * JD-Core Version:    0.7.0.1
 */