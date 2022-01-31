package com.tencent.mm.algorithm;

public class LRUMap$TimeVal
{
  public Object obj;
  public Long t;
  
  public LRUMap$TimeVal(LRUMap paramLRUMap, Object paramObject)
  {
    this.obj = paramObject;
    UpTime();
  }
  
  public void UpTime()
  {
    this.t = Long.valueOf(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.algorithm.LRUMap.TimeVal
 * JD-Core Version:    0.7.0.1
 */