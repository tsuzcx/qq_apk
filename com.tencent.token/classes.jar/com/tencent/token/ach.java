package com.tencent.token;

import java.util.LinkedList;

public final class ach<E>
{
  public int a;
  public LinkedList<E> b = new LinkedList();
  
  public ach(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final E a(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public final void a(E paramE)
  {
    if (this.b.size() >= this.a) {
      this.b.poll();
    }
    this.b.offer(paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ach
 * JD-Core Version:    0.7.0.1
 */