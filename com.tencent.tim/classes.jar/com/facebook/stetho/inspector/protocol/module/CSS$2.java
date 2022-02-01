package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.elements.Document;

class CSS$2
  implements Runnable
{
  CSS$2(CSS paramCSS, CSS.GetMatchedStylesForNodeRequest paramGetMatchedStylesForNodeRequest, CSS.RuleMatch paramRuleMatch1, CSS.RuleMatch paramRuleMatch2) {}
  
  public void run()
  {
    Object localObject = CSS.access$200(this.this$0).getElementForNodeId(this.val$request.nodeId);
    if (localObject == null)
    {
      LogUtil.w("Failed to get style of an element that does not exist, nodeid=" + this.val$request.nodeId);
      return;
    }
    CSS.access$200(this.this$0).getElementStyles(localObject, new CSS.2.1(this));
    CSS.access$200(this.this$0).getElementAccessibilityStyles(localObject, new CSS.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.CSS.2
 * JD-Core Version:    0.7.0.1
 */