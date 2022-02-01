package com.tencent.TMG.utils;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class NioUtils
{
  public static final String TAG = "NioUtils";
  
  public static ByteBuffer createDirectByteBuffer(int paramInt)
  {
    QLog.d("NioUtils", 0, "createDirectByteBuffer len = " + paramInt);
    return ByteBuffer.allocateDirect(paramInt);
  }
  
  public static boolean destroyDirectByteBuffer(ByteBuffer paramByteBuffer)
  {
    QLog.d("NioUtils", 0, "destroyDirectByteBuffer start");
    if (!paramByteBuffer.isDirect()) {
      return false;
    }
    try
    {
      paramByteBuffer.getClass().getMethod("free", new Class[0]).invoke(paramByteBuffer, new Object[0]);
      QLog.d("NioUtils", 0, "destroyDirectByteBuffer end");
      return true;
    }
    catch (Exception paramByteBuffer)
    {
      QLog.e("NioUtils", 0, "destroyDirectByteBuffer", paramByteBuffer);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.utils.NioUtils
 * JD-Core Version:    0.7.0.1
 */