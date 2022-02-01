package com.tencent.qapmsdk.impl.instrumentation.io;

public abstract interface QAPMStreamCompleteListener
{
  public abstract void streamComplete(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent);
  
  public abstract void streamError(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteListener
 * JD-Core Version:    0.7.0.1
 */