package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import iiv;
import ivz;
import iwb;
import java.util.Timer;
import java.util.TimerTask;

public class SmallScreenVideoController$1
  extends TimerTask
{
  public SmallScreenVideoController$1(ivz paramivz) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) || (this.this$0.jdField_a_of_type_Iwb == null)) {}
    long l1;
    long l2;
    do
    {
      do
      {
        iiv localiiv;
        do
        {
          return;
          localiiv = this.this$0.jdField_a_of_type_ComTencentAvVideoController.b();
        } while (localiiv == null);
        if (localiiv.ann > 0) {
          break;
        }
      } while (this.this$0.m == null);
      this.this$0.m.cancel();
      this.this$0.m = null;
      return;
      l1 = this.this$0.jdField_a_of_type_Iwb.z(this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().peerUin);
      l2 = System.currentTimeMillis();
    } while ((l1 == 0L) || (l2 - l1 <= this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().ann * 1000));
    this.this$0.mApp.runOnUiThread(new SmallScreenVideoController.1.1(this, l2, l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.1
 * JD-Core Version:    0.7.0.1
 */