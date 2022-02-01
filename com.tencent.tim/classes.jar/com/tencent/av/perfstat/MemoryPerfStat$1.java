package com.tencent.av.perfstat;

import auru;
import com.tencent.common.app.BaseApplicationImpl;
import ird;

public class MemoryPerfStat$1
  implements Runnable
{
  public MemoryPerfStat$1(ird paramird) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    ird.a(this.this$0, localBaseApplicationImpl);
    ird.a(this.this$0);
    if (ird.a(this.this$0) == 1) {
      ird.a(this.this$0).sendEmptyMessageDelayed(1, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.perfstat.MemoryPerfStat.1
 * JD-Core Version:    0.7.0.1
 */