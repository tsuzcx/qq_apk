package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class BottleManager$6$2$1
  implements Runnable
{
  BottleManager$6$2$1(BottleManager.6.2 param2, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    if (this.this$2.this$1.val$callback != null) {
      this.this$2.this$1.val$callback.onErrorInMainThread(this.val$error);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.6.2.1
 * JD-Core Version:    0.7.0.1
 */