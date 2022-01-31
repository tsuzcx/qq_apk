package com.tencent.qbardemo;

import java.util.TimerTask;

class MainActivity$5
  extends TimerTask
{
  MainActivity$5(MainActivity paramMainActivity) {}
  
  public void run()
  {
    if (!MainActivity.access$000(this.this$0))
    {
      MainActivity.access$002(this.this$0, true);
      ProcessThread localProcessThread = new ProcessThread(this.this$0.uiHandler, this.this$0.previewData, this.this$0.outData, this.this$0.inData, MainActivity.access$600(this.this$0), MainActivity.access$700(this.this$0), this.this$0.path);
      localProcessThread.setPriority(10);
      localProcessThread.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qbardemo.MainActivity.5
 * JD-Core Version:    0.7.0.1
 */