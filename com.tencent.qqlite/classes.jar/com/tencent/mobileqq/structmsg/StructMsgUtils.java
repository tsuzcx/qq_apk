package com.tencent.mobileqq.structmsg;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class StructMsgUtils
{
  public static int a(String paramString)
  {
    int i = 0;
    if (paramString != null) {
      paramString.trim();
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static long a(String paramString)
  {
    long l = 0L;
    if (paramString != null) {
      paramString.trim();
    }
    try
    {
      l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Inflater localInflater = new Inflater();
    localInflater.reset();
    localInflater.setInput(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte1 = new byte[1024];
      while (!localInflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte1, 0, localInflater.inflate(arrayOfByte1));
      }
      try
      {
        byte[] arrayOfByte2;
        localIOException3.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, localIOException1.getMessage());
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, localException.getMessage());
      }
      for (;;)
      {
        try
        {
          localByteArrayOutputStream.close();
          arrayOfByte2 = paramArrayOfByte;
        }
        catch (IOException localIOException3)
        {
          arrayOfByte2 = paramArrayOfByte;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("StructMsg", 2, localIOException3.getMessage());
          arrayOfByte2 = paramArrayOfByte;
          continue;
        }
        localInflater.end();
        return arrayOfByte2;
        arrayOfByte2 = localByteArrayOutputStream.toByteArray();
        paramArrayOfByte = arrayOfByte2;
        try
        {
          localByteArrayOutputStream.close();
          arrayOfByte2 = paramArrayOfByte;
        }
        catch (IOException localIOException2)
        {
          arrayOfByte2 = paramArrayOfByte;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, localIOException2.getMessage());
          arrayOfByte2 = paramArrayOfByte;
        }
      }
    }
    finally {}
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length;
    Object localObject;
    if (paramInt == -1)
    {
      paramInt = paramArrayOfByte[0];
      localObject = new byte[i - 1];
      if (paramInt == 1)
      {
        System.arraycopy(paramArrayOfByte, 1, localObject, 0, i - 1);
        paramArrayOfByte = a((byte[])localObject);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new String(paramArrayOfByte, 0, paramArrayOfByte.length);
        QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff xmlStr:" + (String)localObject);
      }
      return paramArrayOfByte;
      System.arraycopy(paramArrayOfByte, 1, localObject, 0, i - 1);
      paramArrayOfByte = (byte[])localObject;
      continue;
      localObject = new byte[i];
      if (paramInt == 1)
      {
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, i);
        paramArrayOfByte = a((byte[])localObject);
      }
      else
      {
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, i);
        paramArrayOfByte = (byte[])localObject;
      }
    }
  }
  
  public static final byte[] b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte1 = new byte[0];
    Deflater localDeflater = new Deflater();
    localDeflater.reset();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte3 = new byte[1024];
      while (!localDeflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte3, 0, localDeflater.deflate(arrayOfByte3));
      }
      try
      {
        byte[] arrayOfByte2;
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, localIOException1.getMessage());
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, localException.getMessage());
      }
      for (;;)
      {
        try
        {
          localByteArrayOutputStream.close();
          arrayOfByte2 = paramArrayOfByte;
        }
        catch (IOException localIOException3)
        {
          arrayOfByte2 = paramArrayOfByte;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("StructMsg", 2, localIOException3.getMessage());
          arrayOfByte2 = paramArrayOfByte;
          continue;
        }
        localDeflater.end();
        return arrayOfByte2;
        arrayOfByte3 = localByteArrayOutputStream.toByteArray();
        paramArrayOfByte = arrayOfByte3;
        try
        {
          localByteArrayOutputStream.close();
          arrayOfByte2 = paramArrayOfByte;
        }
        catch (IOException localIOException2)
        {
          arrayOfByte2 = paramArrayOfByte;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, localIOException2.getMessage());
          arrayOfByte2 = paramArrayOfByte;
        }
      }
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = paramArrayOfByte;
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramArrayOfByte.getMessage());
        }
        try
        {
          localByteArrayOutputStream.close();
        }
        catch (IOException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramArrayOfByte.getMessage());
          }
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgUtils
 * JD-Core Version:    0.7.0.1
 */