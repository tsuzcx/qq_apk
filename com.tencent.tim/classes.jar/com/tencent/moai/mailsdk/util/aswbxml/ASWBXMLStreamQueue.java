package com.tencent.moai.mailsdk.util.aswbxml;

import java.io.IOException;
import java.io.InputStream;

public class ASWBXMLStreamQueue
{
  private static final int BUFF_SIZE = 1024;
  private byte[] buffer = new byte[1024];
  private int count;
  private int index;
  private InputStream inputStream;
  
  public ASWBXMLStreamQueue(InputStream paramInputStream)
  {
    this.inputStream = paramInputStream;
    try
    {
      this.count = paramInputStream.available();
      return;
    }
    catch (IOException paramInputStream) {}
  }
  
  private boolean checkContinuationBit(byte paramByte)
    throws Exception
  {
    return (0xFFFFFF80 & paramByte) != 0;
  }
  
  public byte Dequeue()
  {
    this.index += 1;
    byte[] arrayOfByte = new byte[1];
    try
    {
      this.inputStream.read(arrayOfByte);
      label23:
      return arrayOfByte[0];
    }
    catch (IOException localIOException)
    {
      break label23;
    }
  }
  
  public void dequeue(int paramInt, ASWBXMLStreamQueueCallback paramASWBXMLStreamQueueCallback)
  {
    int i;
    if (paramInt > 1024) {
      i = 1024;
    }
    while (i > 0) {
      try
      {
        int j = this.inputStream.read(this.buffer, 0, i);
        if (j != -1)
        {
          paramInt -= j;
          this.index += j;
          if (paramInt > 1024) {}
          for (i = 1024;; i = paramInt)
          {
            paramASWBXMLStreamQueueCallback.onDequeue(this.buffer, j);
            break;
            i = paramInt;
            break;
          }
        }
        return;
      }
      catch (IOException paramASWBXMLStreamQueueCallback) {}
    }
  }
  
  public void dequeueBinary(int paramInt, ASWBXMLStreamQueueCallback paramASWBXMLStreamQueueCallback)
    throws Exception
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramASWBXMLStreamQueueCallback != null) {
        paramASWBXMLStreamQueueCallback.onDequeue(Dequeue());
      }
      i += 1;
    }
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
  
  public void dequeueStream(int paramInt, ASWBXMLStreamQueueCallback paramASWBXMLStreamQueueCallback)
    throws Exception
  {
    dequeue(paramInt, paramASWBXMLStreamQueueCallback);
  }
  
  public void dequeueStream(ASWBXMLStreamQueueCallback paramASWBXMLStreamQueueCallback)
    throws Exception
  {
    byte b;
    do
    {
      b = Dequeue();
      if ((b != 0) && (paramASWBXMLStreamQueueCallback != null)) {
        paramASWBXMLStreamQueueCallback.onDequeue(b);
      }
    } while (b != 0);
  }
  
  public int getCount()
  {
    return this.count - this.index;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public static abstract interface ASWBXMLStreamQueueCallback
  {
    public abstract void onDequeue(byte paramByte);
    
    public abstract void onDequeue(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.aswbxml.ASWBXMLStreamQueue
 * JD-Core Version:    0.7.0.1
 */