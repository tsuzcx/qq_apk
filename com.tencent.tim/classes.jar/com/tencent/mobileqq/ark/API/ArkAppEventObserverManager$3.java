package com.tencent.mobileqq.ark.API;

import adno;
import adno.g;
import android.hardware.SensorEvent;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$3
  implements Runnable
{
  public ArkAppEventObserverManager$3(adno paramadno, long paramLong, SensorEvent paramSensorEvent) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onOrientationSensorChange curTime=" + this.Vi + ", event[0]=" + this.a.values[0] + ", event[1]=" + this.a.values[1] + ", event[2]=" + this.a.values[2]);
    }
    adno.a(this.this$0, 360.0F - this.a.values[0]);
    adno.b(this.this$0, -this.a.values[1]);
    adno.c(this.this$0, -this.a.values[2]);
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onOrientationSensorChange update alpha=" + adno.c(this.this$0) + ", update beta=" + adno.b(this.this$0) + ", update gamma=" + adno.a(this.this$0));
    }
    if (adno.a(this.this$0) != null) {
      adno.a(this.this$0).b(true, adno.c(this.this$0), adno.b(this.this$0), adno.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.3
 * JD-Core Version:    0.7.0.1
 */