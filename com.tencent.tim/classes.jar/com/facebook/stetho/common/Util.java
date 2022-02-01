package com.facebook.stetho.common;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Util
{
  public static void awaitUninterruptibly(CountDownLatch paramCountDownLatch)
  {
    for (;;)
    {
      try
      {
        paramCountDownLatch.await();
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public static void close(Closeable paramCloseable, boolean paramBoolean)
    throws IOException
  {
    if ((paramCloseable == null) || (paramBoolean)) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        LogUtil.e(paramCloseable, "Hiding IOException because another is pending");
        return;
      }
    }
    paramCloseable.close();
  }
  
  public static void copy(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    for (;;)
    {
      int i = paramInputStream.read(paramArrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
  }
  
  public static <T> T getUninterruptibly(Future<T> paramFuture)
    throws ExecutionException
  {
    for (;;)
    {
      try
      {
        Object localObject = paramFuture.get();
        return localObject;
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public static <T> T getUninterruptibly(Future<T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException, ExecutionException
  {
    paramLong = paramTimeUnit.toMillis(paramLong);
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        paramTimeUnit = paramFuture.get(paramLong, TimeUnit.MILLISECONDS);
        return paramTimeUnit;
      }
      catch (InterruptedException paramTimeUnit)
      {
        paramLong -= System.currentTimeMillis() - l;
      }
    }
  }
  
  public static void joinUninterruptibly(Thread paramThread)
  {
    for (;;)
    {
      try
      {
        paramThread.join();
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public static String readAsUTF8(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream, new byte[1024]);
    return localByteArrayOutputStream.toString("UTF-8");
  }
  
  public static void sleepUninterruptibly(long paramLong)
  {
    long l2 = System.currentTimeMillis();
    long l1;
    do
    {
      try
      {
        Thread.sleep(paramLong);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        l1 = paramLong - (System.currentTimeMillis() - l2);
        paramLong = l1;
      }
    } while (l1 > 0L);
  }
  
  public static void throwIf(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void throwIfNot(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void throwIfNot(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.format(paramString, paramVarArgs));
    }
  }
  
  public static void throwIfNotNull(Object paramObject)
  {
    if (paramObject != null) {
      throw new IllegalStateException();
    }
  }
  
  public static <T> T throwIfNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static <T1, T2> void throwIfNull(T1 paramT1, T2 paramT2)
  {
    throwIfNull(paramT1);
    throwIfNull(paramT2);
  }
  
  public static <T1, T2, T3> void throwIfNull(T1 paramT1, T2 paramT2, T3 paramT3)
  {
    throwIfNull(paramT1);
    throwIfNull(paramT2);
    throwIfNull(paramT3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.Util
 * JD-Core Version:    0.7.0.1
 */