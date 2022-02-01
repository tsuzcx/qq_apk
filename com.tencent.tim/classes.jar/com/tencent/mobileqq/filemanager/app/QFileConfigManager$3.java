package com.tencent.mobileqq.filemanager.app;

import agiq;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class QFileConfigManager$3
  implements Runnable
{
  public QFileConfigManager$3(agiq paramagiq, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.aO == null) {}
    do
    {
      return;
      QLog.i("QFileConfigManager", 1, "setFileIPv6Config[" + this.aO.toString() + "]");
      if (this.aO.containsKey("ipv6_all_switch")) {
        agiq.e(this.this$0, this.aO.getBoolean("ipv6_all_switch", false));
      }
      if (this.aO.containsKey("ipv6_c2c_switch")) {
        agiq.f(this.this$0, this.aO.getBoolean("ipv6_c2c_switch", false));
      }
      if (this.aO.containsKey("ipv6_group_switch")) {
        agiq.g(this.this$0, this.aO.getBoolean("ipv6_group_switch", false));
      }
      if (this.aO.containsKey("ipv6_disc_switch")) {
        agiq.h(this.this$0, this.aO.getBoolean("ipv6_disc_switch", false));
      }
      if (this.aO.containsKey("ipv6_dataline_switch")) {
        agiq.i(this.this$0, this.aO.getBoolean("ipv6_dataline_switch", false));
      }
    } while (!this.aO.containsKey("ipv6_strategy"));
    agiq.a(this.this$0, this.aO.getInt("ipv6_strategy", 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.3
 * JD-Core Version:    0.7.0.1
 */