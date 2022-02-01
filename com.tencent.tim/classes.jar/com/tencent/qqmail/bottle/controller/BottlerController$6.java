package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.bottle.model.Bottler;
import java.util.Iterator;

class BottlerController$6
  implements Runnable
{
  BottlerController$6(BottlerController paramBottlerController, Bottler paramBottler) {}
  
  public void run()
  {
    if (BottlerController.access$800(this.this$0).length() > 0)
    {
      Iterator localIterator = BottlerController.access$800(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BottlerController.MyInformationUpdatedWatcher)localIterator.next()).onMyInformationUpdatedInMainThread(this.val$bottler);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottlerController.6
 * JD-Core Version:    0.7.0.1
 */