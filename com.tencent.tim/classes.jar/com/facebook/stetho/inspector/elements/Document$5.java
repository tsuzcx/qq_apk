package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Document$5
  implements Accumulator<Object>
{
  private Accumulator<Object> insertedElements = new Document.5.1(this);
  private final HashSet<Object> listenerInsertedElements = new HashSet();
  
  Document$5(Document paramDocument, ShadowDocument.Update paramUpdate) {}
  
  public void store(Object paramObject)
  {
    if (!Document.access$500(this.this$0).containsObject(paramObject)) {}
    while (this.listenerInsertedElements.contains(paramObject)) {
      return;
    }
    Object localObject1 = Document.access$100(this.this$0).getElementInfo(paramObject);
    Object localObject2 = this.val$docUpdate.getElementInfo(paramObject);
    Document.ChildEventingList localChildEventingList;
    int i;
    label92:
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((ElementInfo)localObject1).children;
      localObject2 = ((ElementInfo)localObject2).children;
      localChildEventingList = Document.access$900(this.this$0, paramObject, this.val$docUpdate);
      i = 0;
      int j = ((List)localObject1).size();
      if (i >= j) {
        break label173;
      }
      localObject3 = ((List)localObject1).get(i);
      if (Document.access$500(this.this$0).containsObject(localObject3))
      {
        ElementInfo localElementInfo = this.val$docUpdate.getElementInfo(localObject3);
        if ((localElementInfo == null) || (localElementInfo.parentElement == paramObject)) {
          break label162;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label92;
      localObject1 = Collections.emptyList();
      break;
      label162:
      localChildEventingList.add(localObject3);
    }
    label173:
    Document.access$1000(localChildEventingList, (List)localObject2, this.insertedElements);
    Document.access$1100(this.this$0, localChildEventingList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.Document.5
 * JD-Core Version:    0.7.0.1
 */