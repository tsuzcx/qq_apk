package com.tencent.mobileqq.app;

import acms;
import android.os.Bundle;
import apys;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.ReqBody;

public class TroopHandler$6
  implements Runnable
{
  public TroopHandler$6(acms paramacms, String paramString) {}
  
  public void run()
  {
    Object localObject = (apys)this.this$0.app.getManager(234);
    if ((((apys)localObject).eY(this.Uf) != 3) && (NetConnInfoCenter.getServerTime() < ((apys)localObject).aV(this.Uf)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "getAllOnlineMemberList, too frequency");
      }
      localObject = ((apys)localObject).bc(this.Uf);
      this.this$0.notifyUI(101, true, new Object[] { this.Uf, localObject });
      return;
    }
    for (;;)
    {
      try
      {
        if (((apys)localObject).eY(this.Uf) == 3)
        {
          i = 4;
          localObject = new oidb_0xa2a.ReqBody();
          ((oidb_0xa2a.ReqBody)localObject).group_id.set(Long.valueOf(this.Uf).longValue());
          ((oidb_0xa2a.ReqBody)localObject).is_private.set(TroopInfo.isQidianPrivateTroop(this.this$0.app, this.Uf));
          localObject = this.this$0.makeOIDBPkg("OidbSvc.0xa2a_1", 2602, i, ((oidb_0xa2a.ReqBody)localObject).toByteArray());
          ((ToServiceMsg)localObject).extraData.putString("troopUin", this.Uf);
          this.this$0.sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.i("TroopHandler", 1, "getAllOnlineMemberList, e=" + localException.toString());
        return;
      }
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.6
 * JD-Core Version:    0.7.0.1
 */