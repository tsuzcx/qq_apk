package com.tencent.mobileqq.filemanager.app;

import agir;
import agir.k;
import java.util.HashMap;

public class QFileMsgForwardManager$4
  implements Runnable
{
  public void run()
  {
    agir.k localk = null;
    if (agir.a(this.this$0).containsKey(Long.valueOf(this.rJ))) {
      localk = (agir.k)agir.a(this.this$0).get(Long.valueOf(this.rJ));
    }
    if (localk != null)
    {
      localk.stop();
      localk.update();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.4
 * JD-Core Version:    0.7.0.1
 */