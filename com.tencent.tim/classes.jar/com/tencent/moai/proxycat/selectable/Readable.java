package com.tencent.moai.proxycat.selectable;

import java.nio.channels.SelectionKey;

public abstract interface Readable
{
  public abstract void onReadable(SelectionKey paramSelectionKey);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.selectable.Readable
 * JD-Core Version:    0.7.0.1
 */