package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import java.util.HashSet;

class Document$5$1
  implements Accumulator<Object>
{
  Document$5$1(Document.5 param5) {}
  
  public void store(Object paramObject)
  {
    if (this.this$1.val$docUpdate.isElementChanged(paramObject)) {
      Document.5.access$800(this.this$1).add(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.Document.5.1
 * JD-Core Version:    0.7.0.1
 */