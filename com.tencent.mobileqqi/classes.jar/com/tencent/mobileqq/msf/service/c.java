package com.tencent.mobileqq.msf.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder.DeathRecipient;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class c
  implements IBinder.DeathRecipient
{
  c(b paramb) {}
  
  public void binderDied()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.AppProcessInfo", 2, "binderDied | current time " + System.currentTimeMillis() + ", last death " + b.k + ", unguard time " + this.a.j);
    }
    Object localObject;
    RdmReq localRdmReq;
    if ((this.a.j != 0L) && (l - b.k > 100L))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("aliveTime", String.valueOf(l - this.a.j));
      ((HashMap)localObject).put("activeDegree", String.valueOf(this.a.h));
      ((HashMap)localObject).put("memoryCost", String.valueOf(this.a.i));
      localRdmReq = new RdmReq();
      localRdmReq.eventName = "MSF.BinderDied";
      localRdmReq.elapse = 0L;
      localRdmReq.size = 0L;
      localRdmReq.isSucceed = true;
      localRdmReq.isRealTime = false;
      localRdmReq.params = ((Map)localObject);
    }
    try
    {
      localObject = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), localRdmReq);
      ((ToServiceMsg)localObject).setNeedCallback(false);
      MsfServiceSdk.get().sendMsg((ToServiceMsg)localObject);
      if (l - b.k > b.l)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessInfo", 2, "send broadcast to wake up mobileqq");
        }
        localObject = new Intent("com.tencent.mobileqqi.broadcast.qq");
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
        b.k = l;
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      } while (b.l >= 1800000L);
      b.l = ((float)b.l * 1.2F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.c
 * JD-Core Version:    0.7.0.1
 */