package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import com.tencent.ad.tangram.log.AdLog;

class e$1
  implements Runnable
{
  e$1(e parame, AdAppBtnData paramAdAppBtnData, int paramInt) {}
  
  public void run()
  {
    if ((this.val$cgdtAppBtnData != null) && (e.access$000(this.this$0) != null) && ((this.val$cgdtAppBtnData.cState == 8) || (this.val$cgdtAppBtnData.cState == 2)))
    {
      AdLog.i("AdCanvasAppBtnUIAdapter", "pauseDownloadUi " + this.val$cgdtAppBtnData.packageName);
      e.access$000(this.this$0).setDownloadingUI("继续");
      this.val$cgdtAppBtnData.cState = 2;
      e.access$000(this.this$0).setProgress(this.val$progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.e.1
 * JD-Core Version:    0.7.0.1
 */