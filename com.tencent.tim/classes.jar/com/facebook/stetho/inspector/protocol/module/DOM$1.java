package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.inspector.elements.Document;

class DOM$1
  implements UncheckedCallable<DOM.Node>
{
  DOM$1(DOM paramDOM) {}
  
  public DOM.Node call()
  {
    Object localObject = DOM.access$300(this.this$0).getRootElement();
    return DOM.access$400(this.this$0, localObject, DOM.access$300(this.this$0).getDocumentView(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.DOM.1
 * JD-Core Version:    0.7.0.1
 */