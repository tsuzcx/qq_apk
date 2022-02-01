package com.tencent.component.media.image;

public abstract interface BytePoolParams
{
  public abstract ByteArrayParams getByteArrayParams(int paramInt);
  
  public abstract int getBytePoolSize();
  
  public static class ByteArrayParams
  {
    public int arraysSize;
    public int byteMinSize;
    
    public ByteArrayParams(int paramInt1, int paramInt2)
    {
      this.byteMinSize = paramInt1;
      this.arraysSize = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.BytePoolParams
 * JD-Core Version:    0.7.0.1
 */