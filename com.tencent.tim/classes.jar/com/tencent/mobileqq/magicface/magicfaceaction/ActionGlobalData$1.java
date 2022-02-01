package com.tencent.mobileqq.magicface.magicfaceaction;

import aixt;
import aixt.a;
import java.util.TimerTask;

public class ActionGlobalData$1
  extends TimerTask
{
  public ActionGlobalData$1(aixt paramaixt) {}
  
  public void run()
  {
    aixt localaixt = this.this$0;
    localaixt.count += 1;
    localaixt = this.this$0;
    localaixt.xb -= 0.1F;
    if (this.this$0.a != null) {
      this.this$0.a.cHe();
    }
    if (this.this$0.count * 100 == this.this$0.dgi * 1000)
    {
      this.this$0.xb = 0.0F;
      if (this.this$0.a != null) {
        this.this$0.a.dvp();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
 * JD-Core Version:    0.7.0.1
 */