package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import com.facebook.stetho.inspector.elements.Descriptor.Host;
import javax.annotation.Nullable;

abstract interface AndroidDescriptorHost
  extends Descriptor.Host
{
  @Nullable
  public abstract View getHighlightingView(@Nullable Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.AndroidDescriptorHost
 * JD-Core Version:    0.7.0.1
 */