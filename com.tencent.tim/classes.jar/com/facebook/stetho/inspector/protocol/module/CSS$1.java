package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.elements.Document;

class CSS$1
  implements Runnable
{
  CSS$1(CSS paramCSS, CSS.GetComputedStyleForNodeRequest paramGetComputedStyleForNodeRequest, CSS.GetComputedStyleForNodeResult paramGetComputedStyleForNodeResult) {}
  
  public void run()
  {
    Object localObject = CSS.access$200(this.this$0).getElementForNodeId(this.val$request.nodeId);
    if (localObject == null)
    {
      LogUtil.e("Tried to get the style of an element that does not exist, using nodeid=" + this.val$request.nodeId);
      return;
    }
    CSS.access$200(this.this$0).getElementStyles(localObject, new CSS.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.CSS.1
 * JD-Core Version:    0.7.0.1
 */