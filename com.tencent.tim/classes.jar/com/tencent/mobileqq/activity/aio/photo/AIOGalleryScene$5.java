package com.tencent.mobileqq.activity.aio.photo;

import mqq.os.MqqHandler;
import xsk;
import xto;
import xuf;
import ztk;

public class AIOGalleryScene$5
  implements Runnable
{
  public void run()
  {
    this.this$0.gm(false);
    this.this$0.zA(false);
    if ((this.this$0.jdField_b_of_type_Xto.c() != null) && ((this.this$0.jdField_b_of_type_Xto.c().e instanceof AIOShortVideoData))) {
      xsk.a(this.this$0, true);
    }
    if (this.this$0.c.VL())
    {
      this.this$0.updateUI();
      this.this$0.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.this$0.eu);
      this.this$0.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.this$0.eu, 100L);
      this.this$0.jdField_b_of_type_MqqOsMqqHandler.post(this.this$0.et);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.5
 * JD-Core Version:    0.7.0.1
 */