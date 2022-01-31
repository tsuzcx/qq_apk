package com.tencent.mobileqq.servlet;

import KQQ.PluginInfo;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.service.gamecenter.GameCenterPackeger;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class GameCenterServlet
  extends MSFServlet
{
  public static final String a = "gc_get_newandunreadmsg";
  public static final String b = "gc_refresh_ui";
  private static final String c = "Q.lebatab.GameCenterServlet";
  private long a = 0L;
  private long b = 0L;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.GameCenterServlet", 2, "recieve flag from server.");
    }
    paramIntent = (QQAppInterface)getAppRuntime();
    this.b = System.currentTimeMillis();
    Object localObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      localObject = GameCenterPackeger.a(paramFromServiceMsg.getWupBuffer());
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramFromServiceMsg = (GameCenterManagerImp)paramIntent.getManager(11);
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg.a((List)localObject);
          paramFromServiceMsg = new Bundle();
          paramFromServiceMsg.putBoolean("new", ((PluginInfo)((List)localObject).get(0)).Flag);
          paramFromServiceMsg.putInt("gc_notify_type", 2);
          notifyObserver(null, 10000, true, paramFromServiceMsg, GameCenterObserver.class);
          if (paramIntent != null)
          {
            paramFromServiceMsg = new HashMap();
            StatisticCollector.a(paramIntent.a()).a(paramIntent.a(), "actPluginUnread", true, this.b - this.a, 0L, paramFromServiceMsg, "");
          }
        }
      }
      else if (paramIntent != null)
      {
        paramFromServiceMsg = "|wufbuf: " + HexUtil.a(paramFromServiceMsg.getWupBuffer());
        localObject = new HashMap();
        ((HashMap)localObject).put("param_FailCode", String.valueOf(9045));
        ((HashMap)localObject).put("param_errorDesc", paramFromServiceMsg);
        StatisticCollector.a(paramIntent.a()).a(paramIntent.a(), "actPluginUnread", false, this.b - this.a, 0L, (HashMap)localObject, "");
      }
    }
    for (;;)
    {
      paramIntent = new Bundle();
      paramIntent.putInt("gc_notify_type", 2);
      notifyObserver(null, 10000, false, paramIntent, GameCenterObserver.class);
      return;
      if (paramIntent != null)
      {
        paramFromServiceMsg = "|resultcode: " + paramFromServiceMsg.getResultCode() + "|reason: " + MessageHandler.a(paramFromServiceMsg);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_FailCode", String.valueOf(9311));
        ((HashMap)localObject).put("param_errorDesc", paramFromServiceMsg);
        StatisticCollector.a(paramIntent.a()).a(paramIntent.a(), "actPluginUnread", false, this.b - this.a, 0L, (HashMap)localObject, "");
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getAction();
    paramIntent = (ArrayList)paramIntent.getSerializableExtra("gc_pluginid_list");
    if ((str != null) && (str.equals("gc_get_newandunreadmsg"))) {
      GameCenterPackeger.a(paramPacket, paramIntent);
    }
    this.a = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.GameCenterServlet", 2, "send get flag request.");
    }
  }
  
  public void service(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((str != null) && ("gc_refresh_ui".equals(str)))
    {
      int i = paramIntent.getIntExtra("gc_notify_type", 0);
      paramIntent = new Bundle();
      paramIntent.putBoolean("new", true);
      paramIntent.putInt("gc_notify_type", i);
      notifyObserver(null, 10000, true, paramIntent, GameCenterObserver.class);
      return;
    }
    super.service(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.GameCenterServlet
 * JD-Core Version:    0.7.0.1
 */