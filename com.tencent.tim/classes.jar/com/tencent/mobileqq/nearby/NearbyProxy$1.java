package com.tencent.mobileqq.nearby;

import ajqp;
import akkx;
import altq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class NearbyProxy$1
  implements Runnable
{
  public NearbyProxy$1(ajqp paramajqp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProxy", 2, "receive msg_notify_new_msg in Main,updateNearbyNumAppinfo start..");
    }
    ((altq)this.this$0.app.getManager(36)).czp = true;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = akkx.a(this.this$0.app, true);
    this.this$0.l(4102, new Object[] { localAppInfo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.1
 * JD-Core Version:    0.7.0.1
 */