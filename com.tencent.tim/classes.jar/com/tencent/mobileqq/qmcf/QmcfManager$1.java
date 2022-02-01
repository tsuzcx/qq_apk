package com.tencent.mobileqq.qmcf;

import com.tencent.sveffects.SLog;
import java.util.ArrayList;

class QmcfManager$1
  implements Runnable
{
  QmcfManager$1(QmcfManager paramQmcfManager) {}
  
  public void run()
  {
    String str;
    synchronized (QmcfManager.access$000(this.this$0))
    {
      if (QmcfManager.access$000(this.this$0).size() > 0)
      {
        str = (String)QmcfManager.access$000(this.this$0).get(QmcfManager.access$000(this.this$0).size() - 1);
        QmcfManager.access$000(this.this$0).clear();
      }
    }
    try
    {
      if (this.this$0.hasQmcfEntrance(QmcfManager.access$100(this.this$0), true))
      {
        QmcfManager.access$202(this.this$0, str);
        this.this$0.getQmcfModelItem();
      }
      for (;;)
      {
        return;
        if (SLog.isEnable()) {
          SLog.d("QMCF_MGR", "ignore the old switch!");
        }
        return;
        localObject = finally;
        throw localObject;
        QmcfManager.access$102(this.this$0, 0);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        SLog.i("QMCF_MGR", "switchModel excep!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.QmcfManager.1
 * JD-Core Version:    0.7.0.1
 */