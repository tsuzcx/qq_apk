package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.inspector.elements.Document;

class DOM$5
  implements Runnable
{
  DOM$5(DOM paramDOM, DOM.SetAttributesAsTextRequest paramSetAttributesAsTextRequest) {}
  
  public void run()
  {
    Object localObject = DOM.access$300(this.this$0).getElementForNodeId(this.val$request.nodeId);
    if (localObject != null) {
      DOM.access$300(this.this$0).setAttributesAsText(localObject, this.val$request.text);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.DOM.5
 * JD-Core Version:    0.7.0.1
 */