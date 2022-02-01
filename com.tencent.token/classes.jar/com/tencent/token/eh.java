package com.tencent.token;

public final class eh
{
  public static abstract interface a<T>
  {
    public abstract T a();
    
    public abstract boolean a(T paramT);
  }
  
  public static class b<T>
    implements eh.a<T>
  {
    private final Object[] a;
    private int b;
    
    public b(int paramInt)
    {
      if (paramInt > 0)
      {
        this.a = new Object[paramInt];
        return;
      }
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    
    public T a()
    {
      int i = this.b;
      if (i > 0)
      {
        int j = i - 1;
        Object[] arrayOfObject = this.a;
        Object localObject = arrayOfObject[j];
        arrayOfObject[j] = null;
        this.b = (i - 1);
        return localObject;
      }
      return null;
    }
    
    public boolean a(T paramT)
    {
      int i = 0;
      while (i < this.b)
      {
        if (this.a[i] == paramT)
        {
          i = 1;
          break label34;
        }
        i += 1;
      }
      i = 0;
      label34:
      if (i == 0)
      {
        i = this.b;
        Object[] arrayOfObject = this.a;
        if (i < arrayOfObject.length)
        {
          arrayOfObject[i] = paramT;
          this.b = (i + 1);
          return true;
        }
        return false;
      }
      throw new IllegalStateException("Already in the pool!");
    }
  }
  
  public static final class c<T>
    extends eh.b<T>
  {
    private final Object a = new Object();
    
    public c()
    {
      super();
    }
    
    public final T a()
    {
      synchronized (this.a)
      {
        Object localObject2 = super.a();
        return localObject2;
      }
    }
    
    public final boolean a(T paramT)
    {
      synchronized (this.a)
      {
        boolean bool = super.a(paramT);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.eh
 * JD-Core Version:    0.7.0.1
 */