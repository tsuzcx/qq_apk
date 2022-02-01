package com.tencent.token;

public final class ed<E>
  implements Cloneable
{
  public static final Object a = new Object();
  public boolean b = false;
  public long[] c;
  public Object[] d;
  public int e;
  
  public ed()
  {
    this((byte)0);
  }
  
  private ed(byte paramByte)
  {
    paramByte = ea.b(10);
    this.c = new long[paramByte];
    this.d = new Object[paramByte];
    this.e = 0;
  }
  
  private long a(int paramInt)
  {
    if (this.b) {
      b();
    }
    return this.c[paramInt];
  }
  
  private ed<E> a()
  {
    for (;;)
    {
      try
      {
        localed = (ed)super.clone();
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1)
      {
        ed localed;
        continue;
        return localCloneNotSupportedException1;
      }
      try
      {
        localed.c = ((long[])this.c.clone());
        localed.d = ((Object[])this.d.clone());
        return localed;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
    }
    return null;
  }
  
  private E b(int paramInt)
  {
    if (this.b) {
      b();
    }
    return this.d[paramInt];
  }
  
  private void b()
  {
    int m = this.e;
    long[] arrayOfLong = this.c;
    Object[] arrayOfObject = this.d;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != a)
      {
        if (i != j)
        {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.b = false;
    this.e = j;
  }
  
  public final void a(long paramLong, E paramE)
  {
    int i = ea.a(this.c, this.e, paramLong);
    if (i >= 0)
    {
      this.d[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    Object localObject1;
    if (j < this.e)
    {
      localObject1 = this.d;
      if (localObject1[j] == a)
      {
        this.c[j] = paramLong;
        localObject1[j] = paramE;
        return;
      }
    }
    i = j;
    if (this.b)
    {
      i = j;
      if (this.e >= this.c.length)
      {
        b();
        i = ea.a(this.c, this.e, paramLong) ^ 0xFFFFFFFF;
      }
    }
    j = this.e;
    if (j >= this.c.length)
    {
      j = ea.b(j + 1);
      localObject1 = new long[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject2 = this.c;
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      localObject2 = this.d;
      System.arraycopy(localObject2, 0, arrayOfObject, 0, localObject2.length);
      this.c = ((long[])localObject1);
      this.d = arrayOfObject;
    }
    j = this.e;
    if (j - i != 0)
    {
      localObject1 = this.c;
      int k = i + 1;
      System.arraycopy(localObject1, i, localObject1, k, j - i);
      localObject1 = this.d;
      System.arraycopy(localObject1, i, localObject1, k, this.e - i);
    }
    this.c[i] = paramLong;
    this.d[i] = paramE;
    this.e += 1;
  }
  
  public final String toString()
  {
    if (this.b) {
      b();
    }
    int i = this.e;
    if (i <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(i * 28);
    localStringBuilder.append('{');
    i = 0;
    while (i < this.e)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(a(i));
      localStringBuilder.append('=');
      Object localObject = b(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ed
 * JD-Core Version:    0.7.0.1
 */