package com.tencent.viola.core;

import com.tencent.viola.ui.action.IRenderTask;
import java.util.WeakHashMap;

class ViolaRenderManager$2
  implements Runnable
{
  ViolaRenderManager$2(ViolaRenderManager paramViolaRenderManager, String paramString, IRenderTask paramIRenderTask) {}
  
  public void run()
  {
    if (ViolaRenderManager.access$000(this.this$0).get(this.val$instanceId) == null) {}
    while (this.val$task == null) {
      return;
    }
    this.val$task.execute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.core.ViolaRenderManager.2
 * JD-Core Version:    0.7.0.1
 */