package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.inspector.elements.Document;

class DOM$4
  implements UncheckedCallable<Object>
{
  DOM$4(DOM paramDOM, DOM.ResolveNodeRequest paramResolveNodeRequest) {}
  
  public Object call()
  {
    return DOM.access$300(this.this$0).getElementForNodeId(this.val$request.nodeId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.DOM.4
 * JD-Core Version:    0.7.0.1
 */