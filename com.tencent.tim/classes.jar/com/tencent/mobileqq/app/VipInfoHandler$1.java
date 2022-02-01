package com.tencent.mobileqq.app;

import MQQ.PayRuleCfg;
import acny;
import java.util.HashMap;

public final class VipInfoHandler$1
  implements Runnable
{
  public VipInfoHandler$1(String paramString, PayRuleCfg paramPayRuleCfg) {}
  
  public void run()
  {
    synchronized ()
    {
      if (acny.access$000().get(this.val$uin) != this.b) {
        return;
      }
      acny.b(this.val$uin, "payRule.cfg", this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.VipInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */