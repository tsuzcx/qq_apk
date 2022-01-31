package com.tencent.mobileqq.service.push;

import MessageSvcPack.RequestBatchPushFStatus;
import MessageSvcPack.RequestPushStatus;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.PushBroadcastReceiver;
import com.tencent.mobileqq.compatible.ActionListener;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PushService
  extends BaseProtocolCoder
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "Push" };
  private ActionListener jdField_a_of_type_ComTencentMobileqqCompatibleActionListener;
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg.getWupBuffer() == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PushNotify")) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(ActionListener paramActionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqCompatibleActionListener = paramActionListener;
  }
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if (paramToServiceMsg.equals("MessageSvc.RequestPushStatus"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatusPush", 2, "decodeRespMsg MessageSvc.RequestPushStatus uin:" + paramFromServiceMsg.getUin() + " at " + System.currentTimeMillis());
      }
      paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
      if (paramToServiceMsg != null) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          paramFromServiceMsg = new UniPacket();
          paramFromServiceMsg.decode(paramToServiceMsg);
          paramToServiceMsg = (RequestPushStatus)paramFromServiceMsg.getByClass("req_PushStatus", new RequestPushStatus());
          paramFromServiceMsg = BaseApplication.getContext().getSharedPreferences("share", 0);
          if (paramToServiceMsg.cStatus == 1)
          {
            paramFromServiceMsg.edit().putBoolean("is_pc_online" + paramToServiceMsg.lUin, true).commit();
            return;
          }
          paramFromServiceMsg.edit().putBoolean("is_pc_online" + paramToServiceMsg.lUin, false).commit();
          return;
          if (!"CliNotifySvc.register".equals(paramToServiceMsg)) {
            break;
          }
        } while ((!paramFromServiceMsg.isSuccess()) || (paramFromServiceMsg.extraData.getLong("pushId") != 128L));
        return;
        if ("baseSdk.Msf.NotifyResp".equals(paramToServiceMsg))
        {
          paramToServiceMsg = new Intent("tencent.notify.album");
          paramToServiceMsg.putExtra("resp", paramFromServiceMsg);
          BaseApplication.getContext().sendBroadcast(paramToServiceMsg, "com.tencent.msg.permission.pushnotify");
          return;
        }
        if (!paramToServiceMsg.equals("MessageSvc.RequestBatchPushFStatus")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("StatusPush", 2, "decodeRespMsg MessageSvc.RequestBatchPushFStatus uin:" + paramFromServiceMsg.getUin() + " counter: " + 0 + " at " + System.currentTimeMillis());
        }
        paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
      } while (paramToServiceMsg == null);
      Object localObject = new UniPacket();
      ((UniPacket)localObject).decode(paramToServiceMsg);
      paramToServiceMsg = (RequestBatchPushFStatus)((UniPacket)localObject).getByClass("req_RequestBatchPushFStatus", new RequestBatchPushFStatus());
      localObject = new Intent("tencent.notify.friend.status");
      ((Intent)localObject).putExtra("reqBatchFStatus", paramToServiceMsg.vBatchFStatusReq);
      ((Intent)localObject).putExtra("selfuin", paramFromServiceMsg.getUin());
      ((Intent)localObject).setClass(BaseApplicationImpl.a, PushBroadcastReceiver.class);
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
      return;
      paramToServiceMsg = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    } while (this.jdField_a_of_type_ComTencentMobileqqCompatibleActionListener == null);
    this.jdField_a_of_type_ComTencentMobileqqCompatibleActionListener.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return false;
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.push.PushService
 * JD-Core Version:    0.7.0.1
 */