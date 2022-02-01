package com.tencent.biz.pubaccount.ecshopassit;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kdm;
import kec;
import mqq.app.MobileQQ;

public class EcShopAssistantManager$1
  implements Runnable
{
  public EcShopAssistantManager$1(kdm paramkdm) {}
  
  public void run()
  {
    this.this$0.G(this.this$0.mApp);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("action_get_PA_head");
    ((IntentFilter)localObject).addAction("action_shop_set_read");
    ((IntentFilter)localObject).addAction("action_folder_set_read");
    ((IntentFilter)localObject).addAction("action_folder_destroy");
    ((IntentFilter)localObject).addAction("action_folder_msg_change");
    ((IntentFilter)localObject).addAction("action_set_folder_tab_red");
    ((IntentFilter)localObject).addAction("action_follow_status");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(this.this$0.ag, (IntentFilter)localObject);
      ((kec)this.this$0.mApp.getBusinessHandler(88)).aBJ();
      localObject = this.this$0.mApp.getApplication().getSharedPreferences("ecshop_sp" + kdm.a(this.this$0), 0);
      this.this$0.aen = ((SharedPreferences)localObject).getBoolean("folder_tab_show", false);
      this.this$0.aeo = ((SharedPreferences)localObject).getBoolean("preload_web", false);
      kdm.Yr = String.valueOf(((SharedPreferences)localObject).getLong("ad_puin", 0L));
      this.this$0.rM = ((SharedPreferences)localObject).getLong("stayTime", 5000L);
      this.this$0.aIb = ((SharedPreferences)localObject).getInt("dayLimit", 3);
      this.this$0.aBM();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("EcShopAssistantManager", 1, "Register receiver error:" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.1
 * JD-Core Version:    0.7.0.1
 */