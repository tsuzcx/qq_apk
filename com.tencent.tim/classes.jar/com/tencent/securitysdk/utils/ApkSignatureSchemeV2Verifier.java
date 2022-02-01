package com.tencent.securitysdk.utils;

import android.util.Pair;
import atah;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ApkSignatureSchemeV2Verifier
{
  public static Pair<ByteBuffer, Long> a(RandomAccessFile paramRandomAccessFile)
    throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException
  {
    paramRandomAccessFile = atah.b(paramRandomAccessFile);
    if (paramRandomAccessFile == null) {
      throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    }
    return paramRandomAccessFile;
  }
  
  public static Pair<ByteBuffer, Long> a(RandomAccessFile paramRandomAccessFile, long paramLong)
    throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException
  {
    if (paramLong < 32L) {
      throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + paramLong);
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(24);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong - localByteBuffer.capacity());
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    if ((localByteBuffer.getLong(8) != 2334950737559900225L) || (localByteBuffer.getLong(16) != 3617552046287187010L)) {
      throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
    }
    long l1 = localByteBuffer.getLong(0);
    if ((l1 < localByteBuffer.capacity()) || (l1 > 2147483639L)) {
      throw new SignatureNotFoundException("APK Signing Block size out of range: " + l1);
    }
    int i = (int)(8L + l1);
    paramLong -= i;
    if (paramLong < 0L) {
      throw new SignatureNotFoundException("APK Signing Block offset out of range: " + paramLong);
    }
    localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong);
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    long l2 = localByteBuffer.getLong(0);
    if (l2 != l1) {
      throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + l2 + " vs " + l1);
    }
    return Pair.create(localByteBuffer, Long.valueOf(paramLong));
  }
  
  private static ByteBuffer a(ByteBuffer paramByteBuffer)
    throws ApkSignatureSchemeV2Verifier.SignatureNotFoundException
  {
    b(paramByteBuffer);
    paramByteBuffer = b(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      i += 1;
      if (paramByteBuffer.remaining() < 8) {
        throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i);
      }
      long l = paramByteBuffer.getLong();
      if ((l < 4L) || (l > 2147483647L)) {
        throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + l);
      }
      int j = (int)l;
      int k = paramByteBuffer.position();
      if (j > paramByteBuffer.remaining()) {
        throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + j + ", available: " + paramByteBuffer.remaining());
      }
      if (paramByteBuffer.getInt() == 1896449818) {
        return c(paramByteBuffer, j - 4);
      }
      paramByteBuffer.position(k + j);
    }
    throw new SignatureNotFoundException("No APK Signature Scheme v2 block in APK Signing Block");
  }
  
  public static long b(ByteBuffer paramByteBuffer, long paramLong)
    throws ApkSignatureSchemeV2Verifier.SignatureNotFoundException
  {
    long l = atah.c(paramByteBuffer);
    if (l >= paramLong) {
      throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + l + ". ZIP End of Central Directory offset: " + paramLong);
    }
    if (atah.d(paramByteBuffer) + l != paramLong) {
      throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
    }
    return l;
  }
  
  public static ByteBuffer b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("start: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("end < start: " + paramInt2 + " < " + paramInt1);
    }
    int i = paramByteBuffer.capacity();
    if (paramInt2 > paramByteBuffer.capacity()) {
      throw new IllegalArgumentException("end > capacity: " + paramInt2 + " > " + i);
    }
    i = paramByteBuffer.limit();
    int j = paramByteBuffer.position();
    try
    {
      paramByteBuffer.position(0);
      paramByteBuffer.limit(paramInt2);
      paramByteBuffer.position(paramInt1);
      ByteBuffer localByteBuffer = paramByteBuffer.slice();
      localByteBuffer.order(paramByteBuffer.order());
      return localByteBuffer;
    }
    finally
    {
      paramByteBuffer.position(0);
      paramByteBuffer.limit(i);
      paramByteBuffer.position(j);
    }
  }
  
  public static void b(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
      throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }
  }
  
  public static ByteBuffer c(ByteBuffer paramByteBuffer, int paramInt)
    throws BufferUnderflowException
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("size: " + paramInt);
    }
    int i = paramByteBuffer.limit();
    int j = paramByteBuffer.position();
    paramInt = j + paramInt;
    if ((paramInt < j) || (paramInt > i)) {
      throw new BufferUnderflowException();
    }
    paramByteBuffer.limit(paramInt);
    try
    {
      ByteBuffer localByteBuffer = paramByteBuffer.slice();
      localByteBuffer.order(paramByteBuffer.order());
      paramByteBuffer.position(paramInt);
      return localByteBuffer;
    }
    finally
    {
      paramByteBuffer.limit(i);
    }
  }
  
  public static ByteBuffer d(ByteBuffer paramByteBuffer, int paramInt)
    throws ApkSignatureSchemeV2Verifier.SignatureNotFoundException
  {
    b(paramByteBuffer);
    paramByteBuffer = b(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      i += 1;
      if (paramByteBuffer.remaining() < 8) {
        throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i);
      }
      long l = paramByteBuffer.getLong();
      if ((l < 4L) || (l > 2147483647L)) {
        throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + l);
      }
      int j = (int)l;
      int k = paramByteBuffer.position();
      if (j > paramByteBuffer.remaining()) {
        throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + j + ", available: " + paramByteBuffer.remaining());
      }
      if (paramByteBuffer.getInt() == paramInt) {
        return c(paramByteBuffer, j - 4);
      }
      paramByteBuffer.position(k + j);
    }
    throw new SignatureNotFoundException("No Channel block in APK Signing Block");
  }
  
  public static boolean sT(String paramString)
    throws IOException
  {
    try
    {
      paramString = new RandomAccessFile(paramString, "r");
      Pair localPair = a(paramString);
      ByteBuffer localByteBuffer = (ByteBuffer)localPair.first;
      long l = ((Long)localPair.second).longValue();
      if (atah.b(paramString, l)) {
        throw new SignatureNotFoundException("ZIP64 APK not supported");
      }
      a((ByteBuffer)a(paramString, b(localByteBuffer, l)).first);
      return true;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    catch (SignatureNotFoundException paramString) {}
    return false;
  }
  
  public static class SignatureNotFoundException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
    
    public SignatureNotFoundException(String paramString)
    {
      super();
    }
    
    public SignatureNotFoundException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.securitysdk.utils.ApkSignatureSchemeV2Verifier
 * JD-Core Version:    0.7.0.1
 */