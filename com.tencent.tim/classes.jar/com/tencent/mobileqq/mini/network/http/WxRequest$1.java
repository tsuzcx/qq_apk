package com.tencent.mobileqq.mini.network.http;

import java.util.concurrent.atomic.AtomicInteger;

final class WxRequest$1
  implements Runnable
{
  WxRequest$1(RequestTask paramRequestTask) {}
  
  public void run()
  {
    try
    {
      WxRequest.access$000().getAndIncrement();
      this.val$task.run();
      return;
    }
    finally
    {
      WxRequest.access$000().getAndDecrement();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.WxRequest.1
 * JD-Core Version:    0.7.0.1
 */