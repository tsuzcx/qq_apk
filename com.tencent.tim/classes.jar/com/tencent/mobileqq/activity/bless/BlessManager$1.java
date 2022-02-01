package com.tencent.mobileqq.activity.bless;

import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import ylm;

public class BlessManager$1
  implements Runnable
{
  public BlessManager$1(ylm paramylm) {}
  
  public void run()
  {
    ylm.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "mCheckMultiConfigRunnable");
    }
    Set localSet = ylm.a(this.this$0);
    if ((localSet != null) && (localSet.size() > 0)) {
      this.this$0.h(localSet);
    }
    ylm.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.1
 * JD-Core Version:    0.7.0.1
 */