package com.tencent.turingfd.sdk.base;

import java.util.LinkedList;

public class v<E>
{
  public int a;
  public LinkedList<E> b = new LinkedList();
  
  public v(int paramInt)
  {
    this.a = paramInt;
  }
  
  public E a()
  {
    return this.b.getFirst();
  }
  
  public E a(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public void a(E paramE)
  {
    if (this.b.size() >= this.a) {
      this.b.poll();
    }
    this.b.offer(paramE);
  }
  
  public int b()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.v
 * JD-Core Version:    0.7.0.1
 */