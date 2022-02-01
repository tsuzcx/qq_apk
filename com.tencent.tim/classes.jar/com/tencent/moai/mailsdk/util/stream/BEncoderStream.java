package com.tencent.moai.mailsdk.util.stream;

import java.io.OutputStream;

public class BEncoderStream
  extends BASE64EncoderStream
{
  public BEncoderStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream, 2147483647);
  }
  
  public static int encodedLength(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte.length + 2) / 3 * 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.BEncoderStream
 * JD-Core Version:    0.7.0.1
 */