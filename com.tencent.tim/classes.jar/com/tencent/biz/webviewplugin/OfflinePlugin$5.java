package com.tencent.biz.webviewplugin;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import stw;

public class OfflinePlugin$5
  implements Runnable
{
  public OfflinePlugin$5(stw paramstw) {}
  
  public void run()
  {
    if ((this.this$0.A == null) || (this.this$0.A.size() == 0)) {
      return;
    }
    Iterator localIterator = this.this$0.A.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.this$0.checkOfflineUpNotCallback(str);
    }
    this.this$0.A.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.5
 * JD-Core Version:    0.7.0.1
 */