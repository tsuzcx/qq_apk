package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.common.ArrayListAccumulator;
import com.facebook.stetho.inspector.elements.Document;

class DOM$7
  implements Runnable
{
  DOM$7(DOM paramDOM, DOM.PerformSearchRequest paramPerformSearchRequest, ArrayListAccumulator paramArrayListAccumulator) {}
  
  public void run()
  {
    DOM.access$300(this.this$0).findMatchingElements(this.val$request.query, this.val$resultNodeIds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.protocol.module.DOM.7
 * JD-Core Version:    0.7.0.1
 */