package com.tencent.viola.core;

import com.tencent.viola.ui.action.IRenderTask;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

class ViolaRenderManager$3
  implements Runnable
{
  ViolaRenderManager$3(ViolaRenderManager paramViolaRenderManager, String paramString, List paramList) {}
  
  public void run()
  {
    if (ViolaRenderManager.access$000(this.this$0).get(this.val$instanceId) == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.val$tasks.iterator();
      while (localIterator.hasNext()) {
        ((IRenderTask)localIterator.next()).execute();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.core.ViolaRenderManager.3
 * JD-Core Version:    0.7.0.1
 */