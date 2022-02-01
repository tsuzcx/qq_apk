package com.tencent.mobileqq.teamworkforgroup;

import aoeh;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareUtils$2
  implements Runnable
{
  public ShareUtils$2(aoeh paramaoeh, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (aoeh.a(this.this$0).getWidth() < this.aTX) {
      aoeh.a(this.this$0).setMove(true);
    }
    while (aoeh.b(this.this$0).getWidth() < this.aTY)
    {
      aoeh.b(this.this$0).setMove(true);
      return;
      aoeh.a(this.this$0).setMove(false);
    }
    aoeh.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */