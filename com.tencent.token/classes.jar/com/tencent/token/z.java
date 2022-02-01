package com.tencent.token;

import java.util.LinkedList;

public final class z
{
  private volatile long a = 0L;
  private volatile LinkedList b = new LinkedList();
  private Object c = new Object();
  
  public final long a()
  {
    return this.a;
  }
  
  public final void a(int paramInt, long paramLong1, byte[] paramArrayOfByte, long paramLong2)
  {
    synchronized (this.c)
    {
      LinkedList localLinkedList = this.b;
      int i = (int)paramLong2;
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
      localLinkedList.addLast(new a(paramInt, paramLong1, arrayOfByte, paramLong2));
      this.a += paramLong2;
      return;
    }
  }
  
  public final a b()
  {
    synchronized (this.c)
    {
      if (this.b.size() > 0)
      {
        a locala = (a)this.b.removeFirst();
        this.a -= locala.d;
        return locala;
      }
      return null;
    }
  }
  
  public final void c()
  {
    synchronized (this.c)
    {
      while (b() != null) {}
      return;
    }
  }
  
  public static final class a
  {
    public int a = -1;
    public long b;
    public byte[] c;
    public long d;
    
    public a(int paramInt, long paramLong1, byte[] paramArrayOfByte, long paramLong2)
    {
      this.a = paramInt;
      this.b = paramLong1;
      this.c = paramArrayOfByte;
      this.d = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.z
 * JD-Core Version:    0.7.0.1
 */