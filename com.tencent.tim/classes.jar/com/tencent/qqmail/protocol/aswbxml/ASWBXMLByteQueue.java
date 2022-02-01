package com.tencent.qqmail.protocol.aswbxml;

import java.io.ByteArrayOutputStream;

public class ASWBXMLByteQueue
{
  private byte[] bytes;
  private int index;
  
  public ASWBXMLByteQueue(byte[] paramArrayOfByte)
  {
    this.bytes = paramArrayOfByte;
  }
  
  private boolean checkContinuationBit(byte paramByte)
    throws Exception
  {
    return (0xFFFFFF80 & paramByte) != 0;
  }
  
  public byte Dequeue()
  {
    byte[] arrayOfByte = this.bytes;
    int i = this.index;
    this.index = (i + 1);
    return arrayOfByte[i];
  }
  
  public byte[] dequeueBinary(int paramInt)
    throws Exception
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = Dequeue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  public int dequeueMultibyteInt()
    throws Exception
  {
    int i = 0;
    byte b;
    int j;
    do
    {
      b = Dequeue();
      j = i << 7 | b & 0x7F;
      i = j;
    } while (checkContinuationBit(b));
    return j;
  }
  
  public String dequeueString()
    throws Exception
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i;
    do
    {
      i = Dequeue();
      if (i != 0) {
        localByteArrayOutputStream.write(i);
      }
    } while (i != 0);
    return new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
  }
  
  public String dequeueString(int paramInt)
    throws Exception
  {
    return new String(dequeueBinary(paramInt), "UTF-8");
  }
  
  public int getCount()
  {
    if (this.bytes != null) {
      return this.bytes.length - this.index;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.aswbxml.ASWBXMLByteQueue
 * JD-Core Version:    0.7.0.1
 */