package com.qq.wx.voice.vad;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TRSilkDecoder
{
  private static int a = 24000;
  private static int b = 16000;
  private static TRSilk c = null;
  
  public TRSilkDecoder()
  {
    c = new TRSilk();
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = null;
    Object localObject = arrayOfByte;
    int i;
    if (paramArrayOfByte != null)
    {
      localObject = arrayOfByte;
      if (paramInt > 0)
      {
        localObject = new ByteArrayOutputStream();
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= paramInt) {}
      try
      {
        ((ByteArrayOutputStream)localObject).flush();
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        return localObject;
        arrayOfByte = c.silkDecode(paramArrayOfByte, i, Math.min(64, paramInt - i));
        if (arrayOfByte != null) {}
        try
        {
          ((ByteArrayOutputStream)localObject).write(arrayOfByte);
          i += 64;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
  }
  
  public static byte[] processSilkToPCM(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      arrayOfByte = null;
    }
    do
    {
      do
      {
        return arrayOfByte;
        arrayOfByte = paramArrayOfByte;
      } while (paramArrayOfByte.length <= 0);
      arrayOfByte = paramArrayOfByte;
    } while (c == null);
    byte[] arrayOfByte = paramArrayOfByte;
    try
    {
      c.silkDecodeInit(a, b);
      arrayOfByte = paramArrayOfByte;
      paramArrayOfByte = a(paramArrayOfByte, paramArrayOfByte.length);
      arrayOfByte = paramArrayOfByte;
      c.silkDecodeRelease();
      return paramArrayOfByte;
    }
    catch (TRSilkException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.wx.voice.vad.TRSilkDecoder
 * JD-Core Version:    0.7.0.1
 */