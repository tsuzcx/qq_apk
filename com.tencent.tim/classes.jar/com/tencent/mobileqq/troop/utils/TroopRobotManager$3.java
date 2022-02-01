package com.tencent.mobileqq.troop.utils;

import aptw;
import aptw.b;
import java.lang.ref.WeakReference;

public class TroopRobotManager$3
  implements Runnable
{
  public TroopRobotManager$3(aptw paramaptw) {}
  
  public void run()
  {
    if (this.this$0.ij != null)
    {
      aptw.b localb = (aptw.b)this.this$0.ij.get();
      if (localb != null) {
        localb.V(this.this$0.crr, this.this$0.crp, this.this$0.cSn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager.3
 * JD-Core Version:    0.7.0.1
 */