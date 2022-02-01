package com.facebook.stetho.inspector.elements.android;

import android.app.Dialog;
import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor.Host;
import javax.annotation.Nullable;

final class DialogDescriptor
  extends AbstractChainedDescriptor<Dialog>
  implements HighlightableDescriptor
{
  @Nullable
  public View getViewForHighlighting(Object paramObject)
  {
    Descriptor.Host localHost = getHost();
    if ((localHost instanceof AndroidDescriptorHost))
    {
      paramObject = (Dialog)paramObject;
      return ((AndroidDescriptorHost)localHost).getHighlightingView(paramObject.getWindow());
    }
    return null;
  }
  
  protected void onGetChildren(Dialog paramDialog, Accumulator<Object> paramAccumulator)
  {
    paramDialog = paramDialog.getWindow();
    if (paramDialog != null) {
      paramAccumulator.store(paramDialog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.DialogDescriptor
 * JD-Core Version:    0.7.0.1
 */