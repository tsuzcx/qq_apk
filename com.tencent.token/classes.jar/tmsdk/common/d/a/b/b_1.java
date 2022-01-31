package tmsdk.common.d.a.b;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import tmsdk.common.tcc.TccCryptor;

public class b
{
  @Deprecated
  public static JceStruct a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, JceStruct paramJceStruct)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0)) {}
    do
    {
      return null;
      paramContext = b(paramContext, paramArrayOfByte1, paramArrayOfByte2);
    } while (paramContext == null);
    return h.a(paramContext, paramJceStruct);
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, JceStruct paramJceStruct)
  {
    paramArrayOfByte = b(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return null;
    }
    return h.a(paramArrayOfByte, paramJceStruct);
  }
  
  @Deprecated
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {}
    do
    {
      return null;
      paramContext = a(paramJceStruct);
    } while (paramContext == null);
    return TccCryptor.encrypt(paramContext, paramArrayOfByte);
  }
  
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramContext = a(paramArrayOfByte2);
    if (paramContext == null) {
      return null;
    }
    return TccCryptor.encrypt(paramContext, paramArrayOfByte1);
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    byte[] arrayOfByte = a(h.a(paramJceStruct));
    paramJceStruct = arrayOfByte;
    if (arrayOfByte == null) {
      paramJceStruct = null;
    }
    return paramJceStruct;
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte);
      localDeflaterOutputStream.finish();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.close();
        localDeflaterOutputStream.close();
        return paramArrayOfByte;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return paramArrayOfByte;
      }
      try
      {
        localIOException1.close();
        localDeflaterOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramArrayOfByte.printStackTrace();
      try
      {
        localIOException1.close();
        localDeflaterOutputStream.close();
        return null;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
    }
    finally {}
  }
  
  public static byte[] b(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0)) {}
    for (;;)
    {
      return null;
      try
      {
        paramContext = TccCryptor.decrypt(paramArrayOfByte2, paramArrayOfByte1);
        if (paramContext != null) {
          return b(paramContext);
        }
      }
      catch (Exception paramContext) {}
    }
    return null;
  }
  
  private static byte[] b(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    localInflaterInputStream = new InflaterInputStream(paramArrayOfByte);
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      for (;;)
      {
        int i = localInflaterInputStream.read();
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(i);
      }
      try
      {
        byte[] arrayOfByte;
        paramArrayOfByte.close();
        localInflaterInputStream.close();
        localByteArrayOutputStream.close();
        throw localObject;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      localIOException.printStackTrace();
      try
      {
        paramArrayOfByte.close();
        localInflaterInputStream.close();
        localByteArrayOutputStream.close();
        return null;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      try
      {
        paramArrayOfByte.close();
        localInflaterInputStream.close();
        localByteArrayOutputStream.close();
        return arrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return arrayOfByte;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.b
 * JD-Core Version:    0.7.0.1
 */