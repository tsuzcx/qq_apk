package com.tencent.mobileqq.utils;

import aqms;
import aqms.a;
import java.util.ArrayList;
import java.util.Iterator;

class SyncLoadTask$1$1
  implements Runnable
{
  SyncLoadTask$1$1(SyncLoadTask.1 param1, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    Iterator localIterator = this.CN.iterator();
    while (localIterator.hasNext()) {
      ((aqms)localIterator.next()).setComplete(true);
    }
    localIterator = this.CO.iterator();
    for (boolean bool = true; localIterator.hasNext(); bool = false) {
      ((aqms)localIterator.next()).setComplete(false);
    }
    if (this.this$0.a != null) {
      this.this$0.a.j(bool, this.this$0.CM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SyncLoadTask.1.1
 * JD-Core Version:    0.7.0.1
 */