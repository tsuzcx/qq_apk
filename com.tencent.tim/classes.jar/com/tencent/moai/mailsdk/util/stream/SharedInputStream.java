package com.tencent.moai.mailsdk.util.stream;

import java.io.InputStream;

public abstract interface SharedInputStream
{
  public abstract long getPosition();
  
  public abstract InputStream newStream(long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.SharedInputStream
 * JD-Core Version:    0.7.0.1
 */