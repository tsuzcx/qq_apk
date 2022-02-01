package com.tencent.ttpic.filament;

import java.nio.ByteBuffer;

public class ByteBufferUtil
{
  public static void put(ByteBuffer paramByteBuffer, VertexForPoint paramVertexForPoint)
  {
    paramByteBuffer.putFloat(paramVertexForPoint.x);
    paramByteBuffer.putFloat(paramVertexForPoint.y);
    paramByteBuffer.putInt(paramVertexForPoint.color);
  }
  
  public static void put(ByteBuffer paramByteBuffer, VertexForTriangle paramVertexForTriangle)
  {
    paramByteBuffer.putFloat(paramVertexForTriangle.x);
    paramByteBuffer.putFloat(paramVertexForTriangle.y);
    paramByteBuffer.putFloat(paramVertexForTriangle.z);
    paramByteBuffer.putInt(paramVertexForTriangle.color);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.ByteBufferUtil
 * JD-Core Version:    0.7.0.1
 */