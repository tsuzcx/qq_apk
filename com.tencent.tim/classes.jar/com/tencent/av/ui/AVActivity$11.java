package com.tencent.av.ui;

import com.tencent.av.VideoController;
import iiv;
import iwu;

class AVActivity$11
  implements Runnable
{
  AVActivity$11(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    iiv localiiv;
    do
    {
      return;
      localiiv = this.this$0.a.b();
    } while ((localiiv == null) || ((!localiiv.ti()) && ((!localiiv.tn()) || (!localiiv.Qw))));
    iwu.a(VideoController.a().mApp, 8, 0L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.11
 * JD-Core Version:    0.7.0.1
 */