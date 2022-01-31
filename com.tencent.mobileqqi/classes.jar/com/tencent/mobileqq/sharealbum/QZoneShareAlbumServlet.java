package com.tencent.mobileqq.sharealbum;

import ShareAlbumHelperProtocol.GetMyAlbumListRsp;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.ShareAlbumInfoRequest;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZoneShareAlbumServlet
  extends MSFServlet
{
  private static final int a = 60000;
  public static final String a = "timestamp";
  public static final String b = "hostuin";
  private static final String c = "SQQzoneSvc.";
  private static final String d = QZoneShareAlbumServlet.class.getSimpleName();
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "ShareAlbum receive share album respons");
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = ShareAlbumInfoRequest.a(paramFromServiceMsg.getWupBuffer(), (QQAppInterface)getAppRuntime());
      if ((paramIntent != null) && (paramIntent.album_ids != null) && (paramIntent.album_ids.size() > 0))
      {
        QZoneShareAlbumAssistantManager.a().a(paramIntent.last_visit_time);
        if (QLog.isColorLevel()) {
          QLog.d(d, 2, "ShareAlbum goUpdate");
        }
        paramFromServiceMsg = (QQAppInterface)getAppRuntime();
        QZoneShareAlbumAssistantManager.a().a(paramIntent, paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d(d, 2, "ShareAlbum updateDone");
        }
      }
      for (;;)
      {
        QZoneShareAlbumAssistantManager.a().a(true);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(d, 2, "ShareAlbum response NULL");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "inform QZoneFeedsServlet resultcode fail.");
    }
    QZoneShareAlbumAssistantManager.a().a(false);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {}
    long l1;
    do
    {
      return;
      l1 = paramIntent.getLongExtra("timestamp", 0L);
      long l2 = paramIntent.getLongExtra("hostuin", 0L);
      paramIntent = paramIntent.getStringExtra("refer");
      long l3 = QZoneShareAlbumAssistantManager.a().a();
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "ShareAlbum currentTime:" + l3);
      }
      byte[] arrayOfByte = ShareAlbumInfoRequest.a(l2, l3, paramIntent);
      paramIntent = arrayOfByte;
      if (arrayOfByte == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + "getQQLoginMsgListData");
      paramPacket.putSendData(paramIntent);
    } while (!QLog.isColorLevel());
    QLog.d("MessageSvc.WNSQzone.Push", 2, "LastShareAlbumPullTime:" + l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.sharealbum.QZoneShareAlbumServlet
 * JD-Core Version:    0.7.0.1
 */