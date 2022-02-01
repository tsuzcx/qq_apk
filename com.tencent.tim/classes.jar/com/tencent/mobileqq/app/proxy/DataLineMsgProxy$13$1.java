package com.tencent.mobileqq.app.proxy;

import acxt;
import acxt.a;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import java.util.Iterator;
import java.util.List;

class DataLineMsgProxy$13$1
  implements Runnable
{
  DataLineMsgProxy$13$1(DataLineMsgProxy.13 param13, List paramList) {}
  
  public void run()
  {
    int j = 0;
    int i = j;
    if (this.val$list != null)
    {
      i = j;
      if (acxt.a(this.a.this$0) != null)
      {
        Iterator localIterator = this.val$list.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
          if (!acxt.a(this.a.this$0).insertFrontToList(localDataLineMsgRecord)) {
            break label107;
          }
          i += 1;
        }
      }
    }
    label107:
    for (;;)
    {
      break;
      if (this.a.a != null) {
        this.a.a.D(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.13.1
 * JD-Core Version:    0.7.0.1
 */