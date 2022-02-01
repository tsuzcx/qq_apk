package com.tencent.av.ui;

import anot;
import com.tencent.av.VideoController;
import iiv;
import iwu;

class DoubleVideoCtrlUI$3
  implements Runnable
{
  DoubleVideoCtrlUI$3(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (!this.this$0.a.b().isConnected()))
    {
      iwu.b(this.this$0.mApp, 1049);
      anot.a(null, "CliOper", "", "", "0X8009D02", "0X8009D02", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.3
 * JD-Core Version:    0.7.0.1
 */