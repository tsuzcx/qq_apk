package com.tencent.mobileqq.app;

import mqq.os.MqqHandler;

class TroopManager$12
  implements Runnable
{
  TroopManager$12(TroopManager paramTroopManager, String paramString, TroopManager.g paramg) {}
  
  public void run()
  {
    String str = this.this$0.jr(this.Uf);
    ThreadManager.getUIHandler().post(new TroopManager.12.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.12
 * JD-Core Version:    0.7.0.1
 */