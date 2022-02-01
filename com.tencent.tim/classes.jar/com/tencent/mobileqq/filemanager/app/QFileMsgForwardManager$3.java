package com.tencent.mobileqq.filemanager.app;

import agir;
import agir.k;
import java.util.HashMap;

public class QFileMsgForwardManager$3
  implements Runnable
{
  public QFileMsgForwardManager$3(agir paramagir, String paramString) {}
  
  public void run()
  {
    agir.k localk = null;
    if (agir.a(this.this$0).containsKey(this.bHl)) {
      localk = (agir.k)agir.a(this.this$0).get(this.bHl);
    }
    if (localk != null) {
      localk.update();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3
 * JD-Core Version:    0.7.0.1
 */