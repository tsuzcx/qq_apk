package com.tencent.qqmini.sdk.monitor.service;

import com.tencent.qqmini.sdk.monitor.common.ProcessStats;

class TaskMonitorManager$1
  implements Runnable
{
  TaskMonitorManager$1(TaskMonitorManager paramTaskMonitorManager) {}
  
  public void run()
  {
    this.this$0.mAppLastUsage = this.this$0.mAppCurUsage;
    this.this$0.mAppCurUsage = ProcessStats.collectCpuUsage("-1");
    long l2 = this.this$0.mAppCurUsage;
    long l3 = this.this$0.mAppLastUsage;
    if (this.this$0.isCalcDeviceUsageOk)
    {
      this.this$0.mDeviceLastUsage = this.this$0.mDeviceCurUsage;
      this.this$0.mDeviceCurUsage = ProcessStats.collectCpuUsage("-2");
    }
    for (long l1 = this.this$0.mDeviceCurUsage - this.this$0.mDeviceLastUsage;; l1 = 0L)
    {
      TaskMonitorManager localTaskMonitorManager = this.this$0;
      if ((this.this$0.mDeviceCurUsage > 0L) && (l1 > 0L)) {}
      for (boolean bool = true;; bool = false)
      {
        localTaskMonitorManager.isCalcDeviceUsageOk = bool;
        if (!this.this$0.isCalcDeviceUsageOk) {
          break;
        }
        this.this$0.sTotalCpuUsage = ((int)(100L * (l2 - l3) / l1));
        return;
      }
      this.this$0.sTotalCpuUsage = 0;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager.1
 * JD-Core Version:    0.7.0.1
 */