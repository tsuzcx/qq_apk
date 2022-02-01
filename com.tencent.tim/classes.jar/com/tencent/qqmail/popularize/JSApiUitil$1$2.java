package com.tencent.qqmail.popularize;

class JSApiUitil$1$2
  implements Runnable
{
  JSApiUitil$1$2(JSApiUitil.1 param1) {}
  
  public void run()
  {
    this.this$0.val$callback.onError(JSApiUitil.handleJsCallBack(false, "send mail error", this.this$0.val$callbackId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.JSApiUitil.1.2
 * JD-Core Version:    0.7.0.1
 */