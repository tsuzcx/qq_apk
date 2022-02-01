package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import javax.annotation.Nullable;

abstract interface HighlightableDescriptor
{
  @Nullable
  public abstract View getViewForHighlighting(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.HighlightableDescriptor
 * JD-Core Version:    0.7.0.1
 */