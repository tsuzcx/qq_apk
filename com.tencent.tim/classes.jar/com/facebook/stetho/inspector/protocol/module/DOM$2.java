package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.elements.Document;

class DOM$2
  implements Runnable
{
  DOM$2(DOM paramDOM, DOM.HighlightNodeRequest paramHighlightNodeRequest, DOM.RGBAColor paramRGBAColor) {}
  
  public void run()
  {
    Object localObject = DOM.access$300(this.this$0).getElementForNodeId(this.val$request.nodeId.intValue());
    if (localObject != null) {
      DOM.access$300(this.this$0).highlightElement(localObject, this.val$contentColor.getColor());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.DOM.2
 * JD-Core Version:    0.7.0.1
 */