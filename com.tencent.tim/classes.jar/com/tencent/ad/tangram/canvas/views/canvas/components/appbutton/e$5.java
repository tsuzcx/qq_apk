package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

class e$5
  implements Runnable
{
  e$5(e parame, AdAppBtnData paramAdAppBtnData) {}
  
  public void run()
  {
    if ((e.access$000(this.this$0) != null) && (this.val$cgdtAppBtnData != null))
    {
      e.access$000(this.this$0).resetUI();
      e.access$000(this.this$0).setText(e.access$100(this.this$0));
      e.access$000(this.this$0).setProgress(100);
      this.val$cgdtAppBtnData.cState = 0;
      this.val$cgdtAppBtnData.cProgerss = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.e.5
 * JD-Core Version:    0.7.0.1
 */