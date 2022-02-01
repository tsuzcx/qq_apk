package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import iiv;
import ivp;
import ivz;

public class SmallScreenVideoController$4
  implements Runnable
{
  public SmallScreenVideoController$4(ivz paramivz) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI instanceof ivp))
    {
      String str = this.this$0.mApp.getCurrentAccountUin();
      int i = this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().anm;
      this.this$0.mApp.l(new Object[] { Integer.valueOf(42), str, Integer.valueOf(i) });
    }
    this.this$0.arj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.4
 * JD-Core Version:    0.7.0.1
 */