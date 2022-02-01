package com.facebook.stetho.inspector.elements.android;

import android.view.Window;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.Descriptor;

class AndroidDocumentProvider$2
  implements Accumulator<Object>
{
  AndroidDocumentProvider$2(AndroidDocumentProvider paramAndroidDocumentProvider, Accumulator paramAccumulator) {}
  
  public void store(Object paramObject)
  {
    if ((paramObject instanceof Window)) {
      this.val$accumulator.store((Window)paramObject);
    }
    Descriptor localDescriptor;
    do
    {
      return;
      localDescriptor = this.this$0.getDescriptor(paramObject);
    } while (localDescriptor == null);
    localDescriptor.getChildren(paramObject, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.AndroidDocumentProvider.2
 * JD-Core Version:    0.7.0.1
 */