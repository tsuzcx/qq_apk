package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneNewestFeedRequest;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZoneFeedsServlet
  extends MSFServlet
{
  private static final int a = 60000;
  public static final String a = "selfuin";
  public static final String b = "hostuin";
  public static final String c = "lasttime";
  private static final String d = QZoneFeedsServlet.class.getSimpleName();
  private static final String e = "SQQzoneSvc.";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = QZoneNewestFeedRequest.a(paramFromServiceMsg.getWupBuffer(), (QQAppInterface)getAppRuntime());
      if (paramIntent != null)
      {
        paramFromServiceMsg = new Bundle();
        paramFromServiceMsg.putSerializable("data", paramIntent);
        notifyObserver(null, 1001, true, paramFromServiceMsg, QZoneObserver.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "inform QZoneFeedsServlet isSuccess false");
      }
      notifyObserver(null, 1001, false, new Bundle(), QZoneObserver.class);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "inform QZoneFeedsServlet resultcode fail.");
    }
    notifyObserver(null, 1001, false, new Bundle(), QZoneObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {}
    long l;
    do
    {
      return;
      l = paramIntent.getLongExtra("selfuin", 0L);
      localObject = paramIntent.getLongArrayExtra("hostuin");
    } while (localObject == null);
    ArrayList localArrayList = new ArrayList(localObject.length);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Long.valueOf(localObject[i]));
      i += 1;
    }
    Object localObject = QZoneNewestFeedRequest.a(l, localArrayList, paramIntent.getLongExtra("lasttime", 0L), paramIntent.getStringExtra("refer"));
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + "getAIONewestFeed");
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneFeedsServlet
 * JD-Core Version:    0.7.0.1
 */