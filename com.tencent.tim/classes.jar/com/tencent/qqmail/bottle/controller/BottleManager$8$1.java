package com.tencent.qqmail.bottle.controller;

class BottleManager$8$1
  implements Runnable
{
  BottleManager$8$1(BottleManager.8 param8) {}
  
  public void run()
  {
    if (this.this$1.val$callback != null) {
      this.this$1.val$callback.onSuccessInMainThread(this.this$1.val$bottleId, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.8.1
 * JD-Core Version:    0.7.0.1
 */