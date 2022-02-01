package com.tencent.mobileqq.utils;

import aqmh;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareWithPictureActionSheetBuilder$2
  implements Runnable
{
  public ShareWithPictureActionSheetBuilder$2(aqmh paramaqmh) {}
  
  public void run()
  {
    if (this.this$0.c.getWidth() < this.this$0.bgd) {
      this.this$0.c.setMove(true);
    }
    while (this.this$0.d.getWidth() < this.this$0.bgc)
    {
      this.this$0.d.setMove(true);
      return;
      this.this$0.c.setMove(false);
    }
    this.this$0.d.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder.2
 * JD-Core Version:    0.7.0.1
 */