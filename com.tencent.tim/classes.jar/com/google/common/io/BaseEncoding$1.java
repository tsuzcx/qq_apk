package com.google.common.io;

import java.io.IOException;
import java.io.OutputStream;

class BaseEncoding$1
  extends ByteSink
{
  BaseEncoding$1(BaseEncoding paramBaseEncoding, CharSink paramCharSink) {}
  
  public OutputStream openStream()
    throws IOException
  {
    return this.this$0.encodingStream(this.val$encodedSink.openStream());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.BaseEncoding.1
 * JD-Core Version:    0.7.0.1
 */