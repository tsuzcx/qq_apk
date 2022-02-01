package com.tencent.av.ui;

import com.tencent.av.VideoController;
import iiv;
import ixc;

public class AVActivity$10$1
  implements Runnable
{
  public AVActivity$10$1(ixc paramixc) {}
  
  public void run()
  {
    if ((this.a.this$0.a != null) && (this.a.this$0.a.b().state != 4) && (this.a.this$0.mSessionType == 1) && (!this.a.this$0.Ta))
    {
      this.a.this$0.jm(false);
      this.a.this$0.jq(false);
      if ((this.a.this$0.mControlUI != null) && ((this.a.this$0.mControlUI instanceof DoubleVideoCtrlUI)))
      {
        ((DoubleVideoCtrlUI)this.a.this$0.mControlUI).setBackgroundTransparent();
        ((DoubleVideoCtrlUI)this.a.this$0.mControlUI).jA(true);
        this.a.this$0.mControlUI.O(-1028L, 65535);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.10.1
 * JD-Core Version:    0.7.0.1
 */