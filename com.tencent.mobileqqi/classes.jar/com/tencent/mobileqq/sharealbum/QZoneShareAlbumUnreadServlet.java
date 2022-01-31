package com.tencent.mobileqq.sharealbum;

import NS_SHARE_ALBUM.sa_update_timestamp_rsp;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZoneShareAlbumUnreadServlet
  extends MSFServlet
{
  private static final int a = 60000;
  public static final String a = "hostuin";
  private static final String b = "SQQzoneSvc.";
  private static final String c = QZoneShareAlbumUnreadServlet.class.getSimpleName();
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(c, 2, "ShareAlbum receive share album respons");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = QZoneShareAlbumUnreadRequest.a(paramFromServiceMsg.getWupBuffer(), (QQAppInterface)getAppRuntime());
      if (paramIntent != null) {
        if (paramIntent.ret != 0)
        {
          paramFromServiceMsg = c;
          if ("ShareAlbum errr:" + paramIntent.errmsg == null)
          {
            paramIntent = "null";
            QLog.e(paramFromServiceMsg, 2, paramIntent);
          }
        }
        else
        {
          QLog.d(c, 2, "ShareAlbum updateSuc");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        paramIntent = paramIntent.errmsg;
      }
      QLog.e(c, 2, "ShareAlbum updateFail");
      return;
    }
    QLog.d(c, 2, "ShareAlbum updateFail resultcode fail.");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    byte[] arrayOfByte = QZoneShareAlbumUnreadRequest.a(paramIntent.getLongExtra("hostuin", 0L), paramIntent.getStringExtra("refer"));
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + "saUpdateTimeStamp");
    paramPacket.putSendData(paramIntent);
    QLog.d(c, 2, "ShareAlbum send update unread");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.sharealbum.QZoneShareAlbumUnreadServlet
 * JD-Core Version:    0.7.0.1
 */