package com.tencent.turingfd.sdk.base;

import java.util.LinkedList;

public class ak
{
  public int a;
  public LinkedList b = new LinkedList();
  
  public ak(int paramInt)
  {
    this.a = paramInt;
  }
  
  public Object a()
  {
    return this.b.getFirst();
  }
  
  public Object a(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public void a(Object paramObject)
  {
    if (this.b.size() >= this.a) {
      this.b.poll();
    }
    this.b.offer(paramObject);
  }
  
  public int b()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ak
 * JD-Core Version:    0.7.0.1
 */