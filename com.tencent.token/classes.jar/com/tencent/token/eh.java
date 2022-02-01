package com.tencent.token;

public final class eh<E>
  implements Cloneable
{
  private static final Object e = new Object();
  public boolean a = false;
  public int[] b;
  public Object[] c;
  public int d;
  
  public eh()
  {
    this(10);
  }
  
  public eh(int paramInt)
  {
    if (paramInt == 0)
    {
      this.b = dx.a;
      this.c = dx.c;
    }
    else
    {
      paramInt = dx.a(paramInt);
      this.b = new int[paramInt];
      this.c = new Object[paramInt];
    }
    this.d = 0;
  }
  
  private eh<E> c()
  {
    for (;;)
    {
      try
      {
        localeh = (eh)super.clone();
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1)
      {
        eh localeh;
        continue;
        return localCloneNotSupportedException1;
      }
      try
      {
        localeh.b = ((int[])this.b.clone());
        localeh.c = ((Object[])this.c.clone());
        return localeh;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
    }
    return null;
  }
  
  public final E a(int paramInt)
  {
    paramInt = dx.a(this.b, this.d, paramInt);
    if (paramInt >= 0)
    {
      Object[] arrayOfObject = this.c;
      if (arrayOfObject[paramInt] != e) {
        return arrayOfObject[paramInt];
      }
    }
    return null;
  }
  
  public final void a()
  {
    int m = this.d;
    int[] arrayOfInt = this.b;
    Object[] arrayOfObject = this.c;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != e)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.a = false;
    this.d = j;
  }
  
  public final void a(int paramInt, E paramE)
  {
    int i = dx.a(this.b, this.d, paramInt);
    if (i >= 0)
    {
      this.c[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    Object localObject1;
    if (j < this.d)
    {
      localObject1 = this.c;
      if (localObject1[j] == e)
      {
        this.b[j] = paramInt;
        localObject1[j] = paramE;
        return;
      }
    }
    i = j;
    if (this.a)
    {
      i = j;
      if (this.d >= this.b.length)
      {
        a();
        i = dx.a(this.b, this.d, paramInt) ^ 0xFFFFFFFF;
      }
    }
    j = this.d;
    if (j >= this.b.length)
    {
      j = dx.a(j + 1);
      localObject1 = new int[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject2 = this.b;
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      localObject2 = this.c;
      System.arraycopy(localObject2, 0, arrayOfObject, 0, localObject2.length);
      this.b = ((int[])localObject1);
      this.c = arrayOfObject;
    }
    j = this.d;
    if (j - i != 0)
    {
      localObject1 = this.b;
      int k = i + 1;
      System.arraycopy(localObject1, i, localObject1, k, j - i);
      localObject1 = this.c;
      System.arraycopy(localObject1, i, localObject1, k, this.d - i);
    }
    this.b[i] = paramInt;
    this.c[i] = paramE;
    this.d += 1;
  }
  
  public final int b()
  {
    if (this.a) {
      a();
    }
    return this.d;
  }
  
  public final void b(int paramInt)
  {
    paramInt = dx.a(this.b, this.d, paramInt);
    if (paramInt >= 0)
    {
      Object[] arrayOfObject = this.c;
      Object localObject1 = arrayOfObject[paramInt];
      Object localObject2 = e;
      if (localObject1 != localObject2)
      {
        arrayOfObject[paramInt] = localObject2;
        this.a = true;
      }
    }
  }
  
  public final void b(int paramInt, E paramE)
  {
    int i = this.d;
    if ((i != 0) && (paramInt <= this.b[(i - 1)]))
    {
      a(paramInt, paramE);
      return;
    }
    if ((this.a) && (this.d >= this.b.length)) {
      a();
    }
    i = this.d;
    if (i >= this.b.length)
    {
      int j = dx.a(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject = this.b;
      System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
      localObject = this.c;
      System.arraycopy(localObject, 0, arrayOfObject, 0, localObject.length);
      this.b = arrayOfInt;
      this.c = arrayOfObject;
    }
    this.b[i] = paramInt;
    this.c[i] = paramE;
    this.d = (i + 1);
  }
  
  public final int c(int paramInt)
  {
    if (this.a) {
      a();
    }
    return this.b[paramInt];
  }
  
  public final E d(int paramInt)
  {
    if (this.a) {
      a();
    }
    return this.c[paramInt];
  }
  
  public final String toString()
  {
    if (b() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.d * 28);
    localStringBuilder.append('{');
    int i = 0;
    while (i < this.d)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(c(i));
      localStringBuilder.append('=');
      Object localObject = d(i);
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
 * Qualified Name:     com.tencent.token.eh
 * JD-Core Version:    0.7.0.1
 */