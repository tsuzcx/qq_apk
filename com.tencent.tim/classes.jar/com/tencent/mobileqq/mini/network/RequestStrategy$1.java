package com.tencent.mobileqq.mini.network;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class RequestStrategy$1
  implements Runnable
{
  RequestStrategy$1(RequestStrategy paramRequestStrategy) {}
  
  public void run()
  {
    boolean bool = true;
    RequestStrategy localRequestStrategy = this.this$0;
    if (NetConnInfoCenter.getActiveNetIpFamily(true) == 2) {}
    for (;;)
    {
      RequestStrategy.access$002(localRequestStrategy, bool);
      QLog.d("MiniAppInterface", 2, "updateIPv6Status ipv6: " + RequestStrategy.access$000(this.this$0));
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.RequestStrategy.1
 * JD-Core Version:    0.7.0.1
 */