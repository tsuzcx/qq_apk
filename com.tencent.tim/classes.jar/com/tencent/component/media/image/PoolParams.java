package com.tencent.component.media.image;

public abstract interface PoolParams
{
  public abstract BucketParams getBucketParams(int paramInt);
  
  public abstract int getBucketPoolSize();
  
  public static class BucketParams
  {
    public int arraysSize;
    public int bucketMinSize;
    
    public BucketParams(int paramInt1, int paramInt2)
    {
      this.bucketMinSize = paramInt1;
      this.arraysSize = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.PoolParams
 * JD-Core Version:    0.7.0.1
 */