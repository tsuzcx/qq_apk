package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;

class Document$3
  implements Accumulator<Object>
{
  Document$3(Document paramDocument, ShadowDocument.Update paramUpdate) {}
  
  public void store(Object paramObject)
  {
    if (!Document.access$500(this.this$0).containsObject(paramObject)) {
      throw new IllegalStateException();
    }
    if (this.val$docUpdate.getElementInfo(paramObject).parentElement == null)
    {
      ElementInfo localElementInfo = Document.access$100(this.this$0).getElementInfo(paramObject);
      int i = Document.access$500(this.this$0).getIdForObject(localElementInfo.parentElement).intValue();
      int j = Document.access$500(this.this$0).getIdForObject(paramObject).intValue();
      Document.access$700(this.this$0).onChildNodeRemoved(i, j);
    }
    Document.access$500(this.this$0).removeObject(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.Document.3
 * JD-Core Version:    0.7.0.1
 */