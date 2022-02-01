package com.tencent.qqmail.bottle.controller;

class BottleManager$6$1
  implements Runnable
{
  BottleManager$6$1(BottleManager.6 param6) {}
  
  public void run()
  {
    if (this.this$1.val$callback != null) {
      this.this$1.val$callback.onSuccessInMainThread(this.this$1.val$bottleId, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.6.1
 * JD-Core Version:    0.7.0.1
 */