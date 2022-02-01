package com.tencent.viola.core;

import com.tencent.viola.ui.action.RenderAction;
import java.util.WeakHashMap;

class ViolaRenderManager$4
  implements Runnable
{
  ViolaRenderManager$4(ViolaRenderManager paramViolaRenderManager, String paramString, RenderAction paramRenderAction) {}
  
  public void run()
  {
    if (ViolaRenderManager.access$000(this.this$0).get(this.val$instanceId) == null) {
      return;
    }
    this.val$action.executeRender(this.this$0.getRenderContext(this.val$instanceId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.core.ViolaRenderManager.4
 * JD-Core Version:    0.7.0.1
 */