package com.tencent.mobileqq.troop.navigatebar;

import apmz;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class TroopAioMsgNavigateBar$1
  implements Runnable
{
  public TroopAioMsgNavigateBar$1(apmz paramapmz) {}
  
  public void run()
  {
    this.this$0.eaG();
    ThreadManager.getUIHandler().post(new TroopAioMsgNavigateBar.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar.1
 * JD-Core Version:    0.7.0.1
 */