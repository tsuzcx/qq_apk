package com.tencent.aekit.plugin.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AIInput
{
  public static final String KEY_FRAME = "frame";
  private Map<String, Object> aiInputs = new HashMap();
  private Map<Float, byte[]> frameBytes = new HashMap();
  private int inputTexture = -1;
  private Map<DataSize, byte[]> sizeFrameBytes = new HashMap();
  
  public final byte[] getBytes(float paramFloat)
  {
    return (byte[])this.frameBytes.get(Float.valueOf(paramFloat));
  }
  
  public Object getInput(String paramString)
  {
    return this.aiInputs.get(paramString);
  }
  
  public int getInputTexture()
  {
    return this.inputTexture;
  }
  
  public final byte[] getSizedBytes(DataSize paramDataSize)
  {
    Iterator localIterator = this.sizeFrameBytes.keySet().iterator();
    while (localIterator.hasNext())
    {
      DataSize localDataSize = (DataSize)localIterator.next();
      if ((localDataSize.width == paramDataSize.width) && (localDataSize.height == paramDataSize.height)) {
        return (byte[])this.sizeFrameBytes.get(localDataSize);
      }
    }
    return (byte[])this.sizeFrameBytes.get(paramDataSize);
  }
  
  public void setBytes(float paramFloat, byte[] paramArrayOfByte)
  {
    this.frameBytes.put(Float.valueOf(paramFloat), paramArrayOfByte);
  }
  
  public void setInput(String paramString, Object paramObject)
  {
    this.aiInputs.put(paramString, paramObject);
  }
  
  public void setInputTexture(int paramInt)
  {
    this.inputTexture = paramInt;
  }
  
  public void setSizedBytes(DataSize paramDataSize, byte[] paramArrayOfByte)
  {
    Iterator localIterator = this.sizeFrameBytes.keySet().iterator();
    while (localIterator.hasNext())
    {
      DataSize localDataSize = (DataSize)localIterator.next();
      if ((localDataSize.width == paramDataSize.width) && (localDataSize.height == paramDataSize.height))
      {
        this.sizeFrameBytes.put(localDataSize, paramArrayOfByte);
        return;
      }
    }
    this.sizeFrameBytes.put(paramDataSize, paramArrayOfByte);
  }
  
  public static class DataSize
  {
    public int height;
    public int width;
    
    public DataSize(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIInput
 * JD-Core Version:    0.7.0.1
 */