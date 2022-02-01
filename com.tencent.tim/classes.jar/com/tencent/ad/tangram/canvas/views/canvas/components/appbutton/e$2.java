package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import com.tencent.ad.tangram.log.AdLog;

class e$2
  implements Runnable
{
  e$2(e parame, AdAppBtnData paramAdAppBtnData, int paramInt) {}
  
  public void run()
  {
    if ((this.val$cgdtAppBtnData != null) && (this.val$cgdtAppBtnData.cState == 8) && ((this.this$0.addToDownloadCallbacks) || (this.this$0.data.canShowProgress)) && (e.access$000(this.this$0) != null) && (this.val$progress >= 0))
    {
      AdLog.i("AdCanvasAppBtnUIAdapter", "updateBtnProgressUI " + this.val$progress);
      e.access$000(this.this$0).setDownloadingUI("下载中, " + this.val$progress + "%");
      e.access$000(this.this$0).setProgress(this.val$progress);
      this.val$cgdtAppBtnData.cProgerss = this.val$progress;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.e.2
 * JD-Core Version:    0.7.0.1
 */