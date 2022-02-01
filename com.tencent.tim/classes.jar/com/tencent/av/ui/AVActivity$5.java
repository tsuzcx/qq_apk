package com.tencent.av.ui;

import com.tencent.mobileqq.vipav.VipFullScreenVideoView;

class AVActivity$5
  implements Runnable
{
  AVActivity$5(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if (this.this$0.a.isPlaying()) {
        this.this$0.a.stopPlayback();
      }
      if ((this.this$0.mControlUI != null) && ((this.this$0.mControlUI instanceof DoubleVideoCtrlUI))) {
        ((DoubleVideoCtrlUI)this.this$0.mControlUI).jA(false);
      }
      this.this$0.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.5
 * JD-Core Version:    0.7.0.1
 */