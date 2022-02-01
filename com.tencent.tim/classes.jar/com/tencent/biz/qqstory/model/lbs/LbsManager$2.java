package com.tencent.biz.qqstory.model.lbs;

import pub;
import ram;

public class LbsManager$2
  implements Runnable
{
  public LbsManager$2(pub parampub, int paramInt) {}
  
  public void run()
  {
    ram.w("LbsManager", "onLocation Timeout  %d ms", new Object[] { Integer.valueOf(this.val$delay) });
    this.this$0.b(false, this.this$0.b);
    pub.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.2
 * JD-Core Version:    0.7.0.1
 */