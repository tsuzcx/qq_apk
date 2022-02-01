package com.tencent.qapmsdk.dns.utils;

import com.tencent.qapmsdk.dns.HttpDns.Callback;

class Utils$AsyncCallbackWrapper$1
  implements Runnable
{
  Utils$AsyncCallbackWrapper$1(Utils.AsyncCallbackWrapper paramAsyncCallbackWrapper, HttpDns.Callback paramCallback, boolean paramBoolean, Throwable paramThrowable) {}
  
  public void run()
  {
    this.val$callback.onHook(this.val$success, this.val$tr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.utils.Utils.AsyncCallbackWrapper.1
 * JD-Core Version:    0.7.0.1
 */