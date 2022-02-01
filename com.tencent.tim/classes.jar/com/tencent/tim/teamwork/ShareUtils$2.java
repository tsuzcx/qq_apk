package com.tencent.tim.teamwork;

import aujz;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareUtils$2
  implements Runnable
{
  public ShareUtils$2(aujz paramaujz, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (aujz.a(this.this$0).getWidth() < this.aTX) {
      aujz.a(this.this$0).setMove(true);
    }
    while (aujz.b(this.this$0).getWidth() < this.aTY)
    {
      aujz.b(this.this$0).setMove(true);
      return;
      aujz.a(this.this$0).setMove(false);
    }
    aujz.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */