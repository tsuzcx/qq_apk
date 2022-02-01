package com.tencent.qqmail.bottle.controller;

import java.util.Iterator;

class BottleThrowController$1
  implements Runnable
{
  BottleThrowController$1(BottleThrowController paramBottleThrowController, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (BottleThrowController.access$000(this.this$0).length() > 0)
    {
      Iterator localIterator = BottleThrowController.access$000(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BottleThrowController.BottleLocationWatcher)localIterator.next()).onSuccessInMainThread(this.val$geo, this.val$city);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController.1
 * JD-Core Version:    0.7.0.1
 */