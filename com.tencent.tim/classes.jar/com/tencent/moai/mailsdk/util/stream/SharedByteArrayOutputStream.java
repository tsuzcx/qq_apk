package com.tencent.moai.mailsdk.util.stream;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class SharedByteArrayOutputStream
  extends ByteArrayOutputStream
{
  public SharedByteArrayOutputStream(int paramInt)
  {
    super(paramInt);
  }
  
  public InputStream toStream()
  {
    return new SharedByteArrayInputStream(this.buf, 0, this.count);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.SharedByteArrayOutputStream
 * JD-Core Version:    0.7.0.1
 */