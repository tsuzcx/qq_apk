package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class BubbleEntity
  extends Entity
{
  public int bubble_id = 0;
  public long expire = 0L;
  public String hash = "";
  public int opType = 0;
  public int power = 0;
  public String resUrl = null;
  public int version = 1;
  
  public BubbleEntity() {}
  
  public BubbleEntity(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
  {
    this.bubble_id = paramInt1;
    this.opType = paramInt2;
    this.resUrl = paramString;
    this.power = paramInt3;
    this.expire = paramLong;
  }
  
  public BubbleEntity(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong, int paramInt4)
  {
    this.bubble_id = paramInt1;
    this.opType = paramInt2;
    this.resUrl = paramString;
    this.power = paramInt3;
    this.expire = paramLong;
    this.version = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.BubbleEntity
 * JD-Core Version:    0.7.0.1
 */