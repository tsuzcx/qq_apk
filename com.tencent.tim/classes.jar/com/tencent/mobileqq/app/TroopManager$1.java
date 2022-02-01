package com.tencent.mobileqq.app;

import acms;
import acms.h;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.RspBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo;

class TroopManager$1
  implements Runnable
{
  TroopManager$1(TroopManager paramTroopManager) {}
  
  public void run()
  {
    Object localObject = this.this$0.jr.values();
    long l = NetConnInfoCenter.getServerTime();
    if (this.this$0.app == null)
    {
      QLog.e(".troop.survey", 1, "Error: check survey list expire, app is null!");
      return;
    }
    acms localacms = (acms)this.this$0.app.getBusinessHandler(20);
    if (localacms == null)
    {
      QLog.e(".troop.survey", 1, "Error: check survey list expire, troop handler is null!");
      return;
    }
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      oidb_cmd0xb36.RspBody localRspBody = (oidb_cmd0xb36.RspBody)((Iterator)localObject).next();
      if ((localRspBody.toast.expired.has()) && (localRspBody.toast.expired.get() < l))
      {
        String str = String.valueOf(localRspBody.group_id.get());
        if (QLog.isColorLevel()) {
          QLog.d(".troop.survey", 2, new Object[] { "group id ", str, "request survey toast, expiredTime: ", Integer.valueOf(localRspBody.toast.expired.get()) });
        }
        acms.h.a(localacms, str, 0);
      }
    }
    this.this$0.cMP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.1
 * JD-Core Version:    0.7.0.1
 */