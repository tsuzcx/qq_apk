package com.tencent.commonsdk.cache;

public class LruCacheInfo
  extends CacheInfo
{
  public int evictionCount;
  
  public LruCacheInfo(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LruCacheInfo{");
    localStringBuilder.append("tagId=").append(this.tagId);
    localStringBuilder.append(", capacity=").append(this.capacity);
    localStringBuilder.append(", size=").append(this.size);
    localStringBuilder.append(", getCount=").append(this.getCount);
    localStringBuilder.append(", putCount=").append(this.putCount);
    localStringBuilder.append(", removeCount=").append(this.removeCount);
    localStringBuilder.append(", hitCount=").append(this.hitCount);
    localStringBuilder.append(", missCount=").append(this.missCount);
    localStringBuilder.append(", lifeTime=").append(this.lifeTime);
    localStringBuilder.append(", gapTime=").append(this.gapTime);
    localStringBuilder.append(", evictionCount=").append(this.evictionCount);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.commonsdk.cache.LruCacheInfo
 * JD-Core Version:    0.7.0.1
 */