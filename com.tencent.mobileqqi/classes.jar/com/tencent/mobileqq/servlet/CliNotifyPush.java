package com.tencent.mobileqq.servlet;

import QzoneCombine.PushInfo;
import QzoneCombine.SingleMsg;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.QZoneManager.FeedType;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sc.app.MsgNotifacation;
import com.tencent.sc.qzonepush.QQService.SvcMsgPush;
import cooperation.qzone.QZoneHelper.LocalConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class CliNotifyPush
  extends MSFServlet
{
  public static final String a = "MessageSvc.WNSQzone.Push";
  private static final String[] a = { "baseSdk.Msf.NotifyResp", "CliNotifySvc.SvcReqPush", "MessageSvc.WNSQzone" };
  private static final String b = "CliNotifyPush";
  private static final String c = "CliNotifySvc.SvcReqPush";
  private static final String d = "MessageSvc.WNSQzone";
  private static final String e = "QZONE_PUSH_ST";
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    long l2 = 0L;
    SharedPreferences localSharedPreferences = paramQQAppInterface.a().getSharedPreferences("QZONE_PUSH_ST", 0);
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      l1 = l2;
      if (paramQQAppInterface != null)
      {
        l1 = l2;
        if (paramQQAppInterface.length() > 0) {
          l1 = localSharedPreferences.getLong(paramQQAppInterface + "", 0L);
        }
      }
    }
    return l1;
  }
  
  public static SingleMsg a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    System.arraycopy(paramArrayOfByte, 4, paramArrayOfByte, 0, paramArrayOfByte.length - 4);
    PushInfo localPushInfo = new PushInfo();
    paramArrayOfByte = new JceInputStream(paramArrayOfByte);
    paramArrayOfByte.setServerEncoding("utf-8");
    localPushInfo.readFrom(paramArrayOfByte);
    long l = a(paramQQAppInterface);
    try
    {
      paramArrayOfByte = localPushInfo.vecMsg;
      paramArrayOfByte = (SingleMsg)paramArrayOfByte.get(paramArrayOfByte.size() - 1);
      paramArrayOfByte.printStackTrace();
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        if ((Integer.parseInt((String)paramArrayOfByte.data.get("pushtype")) == 1) && (paramArrayOfByte.addTime > l))
        {
          a(paramQQAppInterface, paramArrayOfByte.addTime);
          return paramArrayOfByte;
        }
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramQQAppInterface = paramArrayOfByte;
          paramArrayOfByte = localException;
        }
      }
      paramArrayOfByte = paramArrayOfByte;
      paramQQAppInterface = null;
    }
    return paramQQAppInterface;
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {}
    for (long l = Long.parseLong(paramQQAppInterface.getAccount());; l = 0L)
    {
      if ((paramLong != 0L) && (l != 0L))
      {
        NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), QZonePushAckServlet.class);
        localNewIntent.putExtra("timestamp", paramLong);
        localNewIntent.putExtra("hostuin", l);
        paramQQAppInterface.startServlet(localNewIntent);
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("QZONE_PUSH_ST", 0).edit();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        localEditor.putLong(paramQQAppInterface + "", paramLong);
      }
    }
    localEditor.commit();
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    Object localObject = a(localQQAppInterface, paramFromServiceMsg.getWupBuffer());
    paramFromServiceMsg = (String)((SingleMsg)localObject).data.get("conent");
    int i = Integer.parseInt((String)((SingleMsg)localObject).data.get("count"));
    long l = ((SingleMsg)localObject).opUin;
    if (a(localQQAppInterface)) {
      ((QZoneManagerImp)localQQAppInterface.getManager(9)).a(QZoneManager.FeedType.mySpacefeed, i, l, paramFromServiceMsg);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageSvc.WNSQzone.Push", 2, "receive push time:" + ((SingleMsg)localObject).addTime);
    }
    a(((SingleMsg)localObject).addTime, localQQAppInterface);
    boolean bool2;
    if ((localQQAppInterface.isBackground_Pause) && (a(localQQAppInterface)) && (paramFromServiceMsg != null))
    {
      bool2 = localQQAppInterface.e();
      if (!bool2) {
        paramFromServiceMsg = localQQAppInterface.a().getApplicationContext().getString(2131563282, new Object[] { Integer.valueOf(i) });
      }
      localObject = ((ActivityManager)localQQAppInterface.a().getSystemService("activity")).getRunningTasks(1);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label270;
      }
    }
    label270:
    for (boolean bool1 = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName().equals("cooperation.qzone.QzoneTranslucentPluginProxyActivity");; bool1 = false)
    {
      if (!bool1) {
        MsgNotifacation.a().a(localQQAppInterface, 1, paramFromServiceMsg, bool2);
      }
      return;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    return QZoneHelper.LocalConfig.a(paramQQAppInterface.a().getApplicationContext().getString(2131563461) + paramQQAppInterface.getAccount(), true);
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
      localSvcMsgPush = new SvcMsgPush();
      localSvcMsgPush.readFrom(new JceInputStream(paramIntent));
      ((MessageHandler)((QQAppInterface)getAppRuntime()).a(0)).a(null, paramFromServiceMsg, localSvcMsgPush);
    }
    while ((!paramFromServiceMsg.getServiceCmd().equals("MessageSvc.WNSQzone")) || (!paramFromServiceMsg.isSuccess()))
    {
      SvcMsgPush localSvcMsgPush;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get online qzone push");
    }
    a(paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.CliNotifyPush
 * JD-Core Version:    0.7.0.1
 */