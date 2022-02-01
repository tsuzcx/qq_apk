package dov.com.tencent.mobileqq.richmedia.capture.view;

import ayyf;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareActionSheet$2
  implements Runnable
{
  public void run()
  {
    if (this.this$0.c.getWidth() < this.this$0.bgd) {
      this.this$0.c.setMove(true);
    }
    while (this.this$0.d.getWidth() < ayyf.a(this.this$0))
    {
      this.this$0.d.setMove(true);
      return;
      this.this$0.c.setMove(false);
    }
    this.this$0.d.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet.2
 * JD-Core Version:    0.7.0.1
 */