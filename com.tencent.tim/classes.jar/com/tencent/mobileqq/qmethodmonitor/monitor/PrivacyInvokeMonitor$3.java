package com.tencent.mobileqq.qmethodmonitor.monitor;

import allb;
import allb.b;
import anpl;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class PrivacyInvokeMonitor$3
  implements Runnable
{
  public PrivacyInvokeMonitor$3(allb.b paramb) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_invoke_type", this.a.bXb);
    localHashMap.put("key_stack_string", this.a.bXc);
    localHashMap.put("key_invoke_times", String.valueOf(this.a.mCount));
    localHashMap.put("key_system_api", this.a.bWX);
    localHashMap.put("key_process_name", allb.access$100());
    String str = "0";
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    anpl.c(str, "tim_privacy_monitor ", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qmethodmonitor.monitor.PrivacyInvokeMonitor.3
 * JD-Core Version:    0.7.0.1
 */