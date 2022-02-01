package com.tencent.component.network.utils.http.pool;

public class PoolStats
{
  private final int available;
  private final int leased;
  private final int max;
  private final int pending;
  
  public PoolStats(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.leased = paramInt1;
    this.pending = paramInt2;
    this.available = paramInt3;
    this.max = paramInt4;
  }
  
  public int getAvailable()
  {
    return this.available;
  }
  
  public int getLeased()
  {
    return this.leased;
  }
  
  public int getMax()
  {
    return this.max;
  }
  
  public int getPending()
  {
    return this.pending;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[leased: ");
    localStringBuilder.append(this.leased);
    localStringBuilder.append("; pending: ");
    localStringBuilder.append(this.pending);
    localStringBuilder.append("; available: ");
    localStringBuilder.append(this.available);
    localStringBuilder.append("; max: ");
    localStringBuilder.append(this.max);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.PoolStats
 * JD-Core Version:    0.7.0.1
 */