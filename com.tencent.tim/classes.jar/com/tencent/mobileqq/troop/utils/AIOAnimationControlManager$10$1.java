package com.tencent.mobileqq.troop.utils;

import apqk;
import apql;
import apwy;

public class AIOAnimationControlManager$10$1
  implements Runnable
{
  public AIOAnimationControlManager$10$1(apql paramapql) {}
  
  public void run()
  {
    try
    {
      if (this.a.this$0.b != null) {
        this.a.this$0.b.ecB();
      }
      label26:
      this.a.this$0.playState = 1;
      this.a.this$0.Sa(this.a.aTe);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label26;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.10.1
 * JD-Core Version:    0.7.0.1
 */