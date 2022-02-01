package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ThreadBound;

public abstract interface DocumentProviderFactory
  extends ThreadBound
{
  public abstract DocumentProvider create();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.DocumentProviderFactory
 * JD-Core Version:    0.7.0.1
 */