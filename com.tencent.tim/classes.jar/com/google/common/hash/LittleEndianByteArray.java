package com.google.common.hash;

import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

final class LittleEndianByteArray
{
  private static final LittleEndianBytes byteArray;
  
  static
  {
    boolean bool;
    if (!LittleEndianByteArray.class.desiredAssertionStatus())
    {
      bool = true;
      $assertionsDisabled = bool;
      localJavaLittleEndianBytes2 = JavaLittleEndianBytes.INSTANCE;
    }
    for (;;)
    {
      try
      {
        String str = System.getProperty("os.arch");
        if (!"amd64".equals(str))
        {
          localObject = localJavaLittleEndianBytes2;
          if (!"aarch64".equals(str)) {}
        }
        else
        {
          if (!ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
            continue;
          }
          localObject = UnsafeByteArray.UNSAFE_LITTLE_ENDIAN;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        JavaLittleEndianBytes localJavaLittleEndianBytes1 = localJavaLittleEndianBytes2;
        continue;
      }
      byteArray = (LittleEndianBytes)localObject;
      return;
      bool = false;
      break;
      localObject = UnsafeByteArray.UNSAFE_BIG_ENDIAN;
    }
  }
  
  static int load32(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  static long load64(byte[] paramArrayOfByte, int paramInt)
  {
    assert (paramArrayOfByte.length >= paramInt + 8);
    return byteArray.getLongLittleEndian(paramArrayOfByte, paramInt);
  }
  
  static long load64Safely(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = 0L;
    int i = Math.min(paramInt2, 8);
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      l |= (paramArrayOfByte[(paramInt1 + paramInt2)] & 0xFF) << paramInt2 * 8;
      paramInt2 += 1;
    }
    return l;
  }
  
  static void store64(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    assert ((paramInt >= 0) && (paramInt + 8 <= paramArrayOfByte.length));
    byteArray.putLongLittleEndian(paramArrayOfByte, paramInt, paramLong);
  }
  
  static boolean usingUnsafe()
  {
    return byteArray instanceof UnsafeByteArray;
  }
  
  static abstract enum JavaLittleEndianBytes
    implements LittleEndianByteArray.LittleEndianBytes
  {
    INSTANCE;
    
    private JavaLittleEndianBytes() {}
  }
  
  static abstract interface LittleEndianBytes
  {
    public abstract long getLongLittleEndian(byte[] paramArrayOfByte, int paramInt);
    
    public abstract void putLongLittleEndian(byte[] paramArrayOfByte, int paramInt, long paramLong);
  }
  
  static abstract enum UnsafeByteArray
    implements LittleEndianByteArray.LittleEndianBytes
  {
    private static final int BYTE_ARRAY_BASE_OFFSET;
    private static final Unsafe theUnsafe;
    
    static
    {
      UNSAFE_BIG_ENDIAN = new LittleEndianByteArray.UnsafeByteArray.2("UNSAFE_BIG_ENDIAN", 1);
      $VALUES = new UnsafeByteArray[] { UNSAFE_LITTLE_ENDIAN, UNSAFE_BIG_ENDIAN };
      theUnsafe = getUnsafe();
      BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset([B.class);
      if (theUnsafe.arrayIndexScale([B.class) != 1) {
        throw new AssertionError();
      }
    }
    
    private UnsafeByteArray() {}
    
    private static Unsafe getUnsafe()
    {
      try
      {
        Unsafe localUnsafe1 = Unsafe.getUnsafe();
        return localUnsafe1;
      }
      catch (SecurityException localSecurityException)
      {
        try
        {
          Unsafe localUnsafe2 = (Unsafe)AccessController.doPrivileged(new LittleEndianByteArray.UnsafeByteArray.3());
          return localUnsafe2;
        }
        catch (PrivilegedActionException localPrivilegedActionException)
        {
          throw new RuntimeException("Could not initialize intrinsics", localPrivilegedActionException.getCause());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.LittleEndianByteArray
 * JD-Core Version:    0.7.0.1
 */