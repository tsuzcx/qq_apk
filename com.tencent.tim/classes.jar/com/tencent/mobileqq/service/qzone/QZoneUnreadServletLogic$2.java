package com.tencent.mobileqq.service.qzone;

import NS_MOBILE_COMM_CONF.MobileCommConf;
import NS_UNDEAL_COUNT.mobile_count_rsp_new;
import ands;
import awnu;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public final class QZoneUnreadServletLogic$2
  implements Runnable
{
  public QZoneUnreadServletLogic$2(mobile_count_rsp_new parammobile_count_rsp_new) {}
  
  public void run()
  {
    try
    {
      MobileCommConf localMobileCommConf = (MobileCommConf)ands.a(MobileCommConf.class, (byte[])this.a.mapTransData.get("ZengzhiCommConf"));
      awnu.a().a(localMobileCommConf);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "error handleQzoneNewMobileInfo " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic.2
 * JD-Core Version:    0.7.0.1
 */