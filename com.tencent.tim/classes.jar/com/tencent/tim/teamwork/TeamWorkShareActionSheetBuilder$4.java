package com.tencent.tim.teamwork;

import auln;
import com.tencent.biz.widgets.ElasticHorScrView;

public class TeamWorkShareActionSheetBuilder$4
  implements Runnable
{
  public TeamWorkShareActionSheetBuilder$4(auln paramauln) {}
  
  public void run()
  {
    if (this.this$0.c.getWidth() < auln.a(this.this$0)) {
      this.this$0.c.setMove(true);
    }
    while (this.this$0.d.getWidth() < auln.b(this.this$0))
    {
      this.this$0.d.setMove(true);
      return;
      this.this$0.c.setMove(false);
    }
    this.this$0.d.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkShareActionSheetBuilder.4
 * JD-Core Version:    0.7.0.1
 */