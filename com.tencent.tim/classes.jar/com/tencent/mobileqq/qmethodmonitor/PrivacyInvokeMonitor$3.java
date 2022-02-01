package com.tencent.mobileqq.qmethodmonitor;

import alku;
import alku.b;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class PrivacyInvokeMonitor$3
  implements Runnable
{
  public PrivacyInvokeMonitor$3(alku.b paramb) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_stack_string", this.a.bWY);
    localHashMap.put("key_invoke_times", String.valueOf(this.a.mCount));
    localHashMap.put("key_system_api", this.a.bWX);
    localHashMap.put("key_process_name", alku.access$100());
    String str = "0";
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(str, "privacy_monitor_beacon_report", false, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qmethodmonitor.PrivacyInvokeMonitor.3
 * JD-Core Version:    0.7.0.1
 */