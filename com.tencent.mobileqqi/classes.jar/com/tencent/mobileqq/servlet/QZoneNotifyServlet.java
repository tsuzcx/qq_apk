package com.tencent.mobileqq.servlet;

import NS_UNDEAL_COUNT.feed_host_info;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.QZoneManager.FeedType;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import gje;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QZoneNotifyServlet
  extends MSFServlet
{
  public static long a = 0L;
  public static final String a = "Qzone_Get_NewAndUnread_Count";
  private static long b = 600000L;
  public static final String b = "Qzone_Refresh_UI";
  public static final String c = "qzone_send_by_time";
  public static final String d = "scene";
  private static final String e = "Q.lebatab.QZoneNotifyServlet";
  private gje jdField_a_of_type_Gje;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private long c = 0L;
  
  static
  {
    jdField_a_of_type_Long = 0L;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilTimer == null) {
      this.jdField_a_of_type_JavaUtilTimer = ThreadManager.a();
    }
    if (this.jdField_a_of_type_Gje != null)
    {
      this.jdField_a_of_type_Gje.cancel();
      this.jdField_a_of_type_Gje = null;
    }
    this.jdField_a_of_type_Gje = new gje(this);
    long l = b;
    Object localObject = (QQAppInterface)getAppRuntime();
    if (localObject != null)
    {
      localObject = (QZoneManagerImp)((QQAppInterface)localObject).getManager(9);
      if (localObject != null) {
        l = ((QZoneManagerImp)localObject).a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_Gje, l);
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.QZoneNotifyServlet", 2, "scheduleQZoneCountTask.section interval=" + l);
      }
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    paramQQAppInterface = (FriendsManagerImp)paramQQAppInterface.getManager(8);
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList1.size())
      {
        String str = paramQQAppInterface.b(String.valueOf(((feed_host_info)paramArrayList1.get(i)).uUin));
        paramArrayList2.add(new Pair(Long.valueOf(((feed_host_info)paramArrayList1.get(i)).uUin), str));
        i += 1;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Gje != null)
    {
      this.jdField_a_of_type_Gje.cancel();
      this.jdField_a_of_type_Gje = null;
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent = (QQAppInterface)getAppRuntime();
    this.c = System.currentTimeMillis();
    Object localObject2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      localObject2 = paramFromServiceMsg.getWupBuffer();
      paramFromServiceMsg = new ArrayList();
      localObject1 = QZoneFeedCountPackeger.a((byte[])localObject2, (QQAppInterface)getAppRuntime(), paramFromServiceMsg);
      if (localObject1 != null)
      {
        localObject2 = (QZoneManagerImp)paramIntent.getManager(9);
        int i = ((QZoneManagerImp)localObject2).a(QZoneManager.FeedType.friendSpace);
        int j = ((QZoneManagerImp)localObject2).a(QZoneManager.FeedType.mySpacefeed);
        ArrayList localArrayList = new ArrayList();
        a(paramIntent, paramFromServiceMsg, localArrayList);
        ((QZoneManagerImp)localObject2).a((long[])localObject1, localArrayList);
        boolean bool = false;
        if (localObject1[0] != i) {
          bool = true;
        }
        i = 0;
        if (localObject1[1] != j)
        {
          i = 1;
          bool = true;
        }
        if (localObject1[2] > 0L)
        {
          b = localObject1[2] * 1000L;
          ((QZoneManagerImp)localObject2).a(b);
        }
        paramFromServiceMsg = new Bundle();
        paramFromServiceMsg.putBoolean("new", bool);
        paramFromServiceMsg.putInt("notify_type", i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.QZoneNotifyServlet", 2, "inform QZONE_GET_UNREAD isSuccess true.hasnew=" + bool);
        }
        notifyObserver(null, 1000, true, paramFromServiceMsg, QZoneObserver.class);
        if (paramIntent != null)
        {
          paramFromServiceMsg = new HashMap();
          StatisticCollector.a(paramIntent.a()).a(paramIntent.a(), "actQzoneUnread", true, this.c - jdField_a_of_type_Long, 0L, paramFromServiceMsg, "");
        }
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.QZoneNotifyServlet", 2, "inform QZONE_GET_UNREAD isSuccess false");
        }
        notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
      } while (paramIntent == null);
      paramFromServiceMsg = "|wufbuf: " + HexUtil.a((byte[])localObject2);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("param_FailCode", String.valueOf(9045));
      ((HashMap)localObject1).put("param_errorDesc", paramFromServiceMsg);
      StatisticCollector.a(paramIntent.a()).a(paramIntent.a(), "actQzoneUnread", false, this.c - jdField_a_of_type_Long, 0L, (HashMap)localObject1, "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.QZoneNotifyServlet", 2, "inform QZONE_GET_UNREAD resultcode fail.");
      }
      notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
    } while (paramIntent == null);
    paramFromServiceMsg = "|resultcode: " + paramFromServiceMsg.getResultCode() + "|reason: " + MessageHandler.a(paramFromServiceMsg);
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("param_FailCode", String.valueOf(9311));
    ((HashMap)localObject1).put("param_errorDesc", paramFromServiceMsg);
    StatisticCollector.a(paramIntent.a()).a(paramIntent.a(), "actQzoneUnread", false, this.c - jdField_a_of_type_Long, 0L, (HashMap)localObject1, "");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.QZoneNotifyServlet", 2, "onSend.begin.");
    }
    QQAppInterface localQQAppInterface;
    boolean bool;
    int i;
    int j;
    if (paramIntent.getAction().equals("Qzone_Get_NewAndUnread_Count"))
    {
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      bool = paramIntent.getBooleanExtra("bNotWorkInBackGround", false);
      i = paramIntent.getIntExtra("qzone_send_by_time", 0);
      j = paramIntent.getIntExtra("scene", 102);
      if (i != 1) {
        break label114;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.QZoneNotifyServlet", 2, "onSend.is send by time.timetype == 1");
      }
      if (System.currentTimeMillis() - jdField_a_of_type_Long >= b) {
        break label114;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.QZoneNotifyServlet", 2, "onSend.interval time is not enough.");
      }
    }
    for (;;)
    {
      return;
      label114:
      if ((i == 0) && (bool) && (localQQAppInterface.isBackground_Pause))
      {
        a();
        return;
      }
      paramIntent = (QZoneManagerImp)localQQAppInterface.getManager(9);
      if ((i == 0) && (paramIntent != null) && (!paramIntent.a()))
      {
        a();
        return;
      }
      int k = localQQAppInterface.a().getResources().getDisplayMetrics().widthPixels;
      int m = localQQAppInterface.a().getResources().getDisplayMetrics().heightPixels;
      paramIntent = QZoneFeedCountPackeger.a(Long.valueOf(localQQAppInterface.a()).longValue(), null, k, m, j);
      if (paramIntent == null)
      {
        paramIntent = new byte[4];
        notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
      }
      while (i == 0)
      {
        a();
        return;
        paramPacket.setTimeout(30000L);
        paramPacket.setSSOCommand("SQQzoneSvc.getUndealCount");
        paramPacket.putSendData(paramIntent);
        jdField_a_of_type_Long = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.QZoneNotifyServlet", 2, "onSend.send success.");
        }
      }
    }
  }
  
  public void service(Intent paramIntent)
  {
    if (paramIntent.getAction().equals("Qzone_Refresh_UI"))
    {
      int i = paramIntent.getIntExtra("notify_type", 0);
      paramIntent = new Bundle();
      paramIntent.putBoolean("new", true);
      paramIntent.putInt("notify_type", i);
      notifyObserver(null, 1000, true, paramIntent, QZoneObserver.class);
      return;
    }
    super.service(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet
 * JD-Core Version:    0.7.0.1
 */