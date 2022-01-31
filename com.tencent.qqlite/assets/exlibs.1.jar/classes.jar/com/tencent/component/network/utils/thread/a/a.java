package com.tencent.component.network.utils.thread.a;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class a<E>
  extends AbstractCollection<E>
  implements b<E>, Serializable, Cloneable
{
  private transient Object[] a = new Object[16];
  private transient int b;
  private transient int c;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      return;
    }
  }
  
  private E a()
  {
    int i = this.b;
    Object localObject = this.a[i];
    if (localObject == null) {
      return null;
    }
    this.a[i] = null;
    this.b = (i + 1 & this.a.length - 1);
    return localObject;
  }
  
  private void a(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException("e == null");
    }
    this.a[this.c] = paramE;
    int i = this.c + 1 & this.a.length - 1;
    this.c = i;
    if (i == this.b)
    {
      if ((!d) && (this.b != this.c)) {
        throw new AssertionError();
      }
      i = this.b;
      int j = this.a.length;
      int k = j - i;
      int m = j << 1;
      if (m < 0) {
        throw new IllegalStateException("Sorry, deque too big");
      }
      paramE = new Object[m];
      System.arraycopy(this.a, i, paramE, 0, k);
      System.arraycopy(this.a, 0, paramE, k, i);
      this.a = paramE;
      this.b = 0;
      this.c = j;
    }
  }
  
  private boolean a(int paramInt)
  {
    if ((!d) && (this.a[this.c] != null)) {
      throw new AssertionError();
    }
    if (!d) {
      if (this.b == this.c)
      {
        if (this.a[this.b] == null) {}
      }
      else {
        while ((this.a[this.b] == null) || (this.a[(this.c - 1 & this.a.length - 1)] == null)) {
          throw new AssertionError();
        }
      }
    }
    if ((!d) && (this.a[(this.b - 1 & this.a.length - 1)] != null)) {
      throw new AssertionError();
    }
    Object[] arrayOfObject = this.a;
    int i = arrayOfObject.length - 1;
    int j = this.b;
    int k = this.c;
    int m = paramInt - j & i;
    int n = k - paramInt & i;
    if (m >= (k - j & i)) {
      throw new ConcurrentModificationException();
    }
    if (m < n)
    {
      if (j <= paramInt) {
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, m);
      }
      for (;;)
      {
        arrayOfObject[j] = null;
        this.b = (j + 1 & i);
        return false;
        System.arraycopy(arrayOfObject, 0, arrayOfObject, 1, paramInt);
        arrayOfObject[0] = arrayOfObject[i];
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, i - j);
      }
    }
    if (paramInt < k) {
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, n);
    }
    for (this.c = (k - 1);; this.c = (k - 1 & i))
    {
      return true;
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i - paramInt);
      arrayOfObject[i] = arrayOfObject[0];
      System.arraycopy(arrayOfObject, 1, arrayOfObject, 0, k);
    }
  }
  
  private <T> T[] a(T[] paramArrayOfT)
  {
    if (this.b < this.c) {
      System.arraycopy(this.a, this.b, paramArrayOfT, 0, size());
    }
    while (this.b <= this.c) {
      return paramArrayOfT;
    }
    int i = this.a.length - this.b;
    System.arraycopy(this.a, this.b, paramArrayOfT, 0, i);
    System.arraycopy(this.a, 0, paramArrayOfT, i, this.c);
    return paramArrayOfT;
  }
  
  private a<E> b()
  {
    try
    {
      a locala = (a)super.clone();
      locala.a = Arrays.copyOf(this.a, this.a.length);
      return locala;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  public boolean add(E paramE)
  {
    a(paramE);
    return true;
  }
  
  public void clear()
  {
    int i = this.b;
    int k = this.c;
    if (i != k)
    {
      this.c = 0;
      this.b = 0;
      int m = this.a.length;
      int j;
      do
      {
        this.a[i] = null;
        j = i + 1 & m - 1;
        i = j;
      } while (j != k);
    }
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int j = this.a.length;
    for (int i = this.b;; i = i + 1 & j - 1)
    {
      Object localObject = this.a[i];
      if (localObject == null) {
        return false;
      }
      if (paramObject.equals(localObject)) {
        return true;
      }
    }
  }
  
  public E element()
  {
    Object localObject = this.a[this.b];
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public boolean isEmpty()
  {
    return this.b == this.c;
  }
  
  public Iterator<E> iterator()
  {
    return new a((byte)0);
  }
  
  public boolean offer(E paramE)
  {
    a(paramE);
    return true;
  }
  
  public E peek()
  {
    return this.a[this.b];
  }
  
  public E poll()
  {
    return a();
  }
  
  public E remove()
  {
    Object localObject = a();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public boolean remove(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int j = this.a.length;
    for (int i = this.b;; i = i + 1 & j - 1)
    {
      Object localObject = this.a[i];
      if (localObject == null) {
        return false;
      }
      if (paramObject.equals(localObject))
      {
        a(i);
        return true;
      }
    }
  }
  
  public int size()
  {
    return this.c - this.b & this.a.length - 1;
  }
  
  public Object[] toArray()
  {
    return a(new Object[size()]);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    int i = size();
    if (paramArrayOfT.length < i) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
    }
    for (;;)
    {
      a(paramArrayOfT);
      if (paramArrayOfT.length > i) {
        paramArrayOfT[i] = null;
      }
      return paramArrayOfT;
    }
  }
  
  final class a
    implements Iterator<E>
  {
    private int a = a.a(a.this);
    private int b = a.b(a.this);
    private int c = -1;
    
    private a() {}
    
    public final boolean hasNext()
    {
      return this.a != this.b;
    }
    
    public final E next()
    {
      if (this.a == this.b) {
        throw new NoSuchElementException();
      }
      Object localObject = a.c(a.this)[this.a];
      if ((a.b(a.this) != this.b) || (localObject == null)) {
        throw new ConcurrentModificationException();
      }
      this.c = this.a;
      this.a = (this.a + 1 & a.c(a.this).length - 1);
      return localObject;
    }
    
    public final void remove()
    {
      if (this.c < 0) {
        throw new IllegalStateException();
      }
      if (a.a(a.this, this.c))
      {
        this.a = (this.a - 1 & a.c(a.this).length - 1);
        this.b = a.b(a.this);
      }
      this.c = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.a.a
 * JD-Core Version:    0.7.0.1
 */