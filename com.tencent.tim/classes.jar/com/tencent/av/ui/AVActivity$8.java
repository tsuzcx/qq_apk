package com.tencent.av.ui;

import com.tencent.av.app.VideoAppInterface;
import igv;
import iiv;

class AVActivity$8
  implements Runnable
{
  AVActivity$8(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if ((this.this$0.mApp != null) && (this.this$0.mApp.ak("BEAUTY_SKIN") > 0))
    {
      iiv localiiv = igv.a().a();
      if (localiiv != null) {
        localiiv.Qi = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.8
 * JD-Core Version:    0.7.0.1
 */