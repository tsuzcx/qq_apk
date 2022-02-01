package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;

class Document$4
  implements Accumulator<Object>
{
  Document$4(Document paramDocument, ShadowDocument.Update paramUpdate) {}
  
  public void store(Object paramObject)
  {
    if (!Document.access$500(this.this$0).containsObject(paramObject)) {}
    ElementInfo localElementInfo;
    do
    {
      return;
      localElementInfo = Document.access$100(this.this$0).getElementInfo(paramObject);
    } while ((localElementInfo == null) || (this.val$docUpdate.getElementInfo(paramObject).parentElement == localElementInfo.parentElement));
    int i = Document.access$500(this.this$0).getIdForObject(localElementInfo.parentElement).intValue();
    int j = Document.access$500(this.this$0).getIdForObject(paramObject).intValue();
    Document.access$700(this.this$0).onChildNodeRemoved(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.Document.4
 * JD-Core Version:    0.7.0.1
 */