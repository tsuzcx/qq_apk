package com.tencent.mobileqq.ark.API;

import adno;
import adno.e;
import android.hardware.SensorEvent;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$2
  implements Runnable
{
  public ArkAppEventObserverManager$2(adno paramadno, SensorEvent paramSensorEvent, long paramLong) {}
  
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      adno.a(this.this$0)[i] = ((float)(0.1D * this.a.values[i] + 0.9D * adno.a(this.this$0)[i]));
      adno.b(this.this$0)[i] = (this.a.values[i] - adno.a(this.this$0)[i]);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onMotionSensorChange curTime=" + this.Vi + ", mMotionX=" + adno.b(this.this$0)[0] + ", mMotionY=" + adno.b(this.this$0)[1] + ", mMotionZ=" + adno.b(this.this$0)[2]);
    }
    if (adno.a(this.this$0) != null) {
      adno.a(this.this$0).a(true, adno.b(this.this$0)[0], adno.b(this.this$0)[1], adno.b(this.this$0)[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.2
 * JD-Core Version:    0.7.0.1
 */