package com.tencent.moai.proxycat.selectable;

import java.nio.channels.SelectionKey;

public abstract interface Writable
{
  public abstract void onWritable(SelectionKey paramSelectionKey);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.selectable.Writable
 * JD-Core Version:    0.7.0.1
 */