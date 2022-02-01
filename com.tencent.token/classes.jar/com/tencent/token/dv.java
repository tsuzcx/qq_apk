package com.tencent.token;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class dv<E>
  implements Collection<E>, Set<E>
{
  private static final int[] b = new int[0];
  private static final Object[] c = new Object[0];
  private static Object[] d;
  private static int e;
  private static Object[] f;
  private static int g;
  public Object[] a = c;
  private int[] h = b;
  private int i = 0;
  private eb<E, E> j;
  
  public dv()
  {
    this((byte)0);
  }
  
  private dv(byte paramByte) {}
  
  private int a()
  {
    int m = this.i;
    if (m == 0) {
      return -1;
    }
    int n = dw.a(this.h, m, 0);
    if (n < 0) {
      return n;
    }
    if (this.a[n] == null) {
      return n;
    }
    int k = n + 1;
    while ((k < m) && (this.h[k] == 0))
    {
      if (this.a[k] == null) {
        return k;
      }
      k += 1;
    }
    m = n - 1;
    while ((m >= 0) && (this.h[m] == 0))
    {
      if (this.a[m] == null) {
        return m;
      }
      m -= 1;
    }
    return k ^ 0xFFFFFFFF;
  }
  
  private int a(Object paramObject, int paramInt)
  {
    int m = this.i;
    if (m == 0) {
      return -1;
    }
    int n = dw.a(this.h, m, paramInt);
    if (n < 0) {
      return n;
    }
    if (paramObject.equals(this.a[n])) {
      return n;
    }
    int k = n + 1;
    while ((k < m) && (this.h[k] == paramInt))
    {
      if (paramObject.equals(this.a[k])) {
        return k;
      }
      k += 1;
    }
    m = n - 1;
    while ((m >= 0) && (this.h[m] == paramInt))
    {
      if (paramObject.equals(this.a[m])) {
        return m;
      }
      m -= 1;
    }
    return k ^ 0xFFFFFFFF;
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (g < 10)
        {
          paramArrayOfObject[0] = f;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label114;
          f = paramArrayOfObject;
          g += 1;
        }
        return;
      }
      finally {}
    } else if (paramArrayOfInt.length != 4) {}
    for (;;)
    {
      try
      {
        if (e < 10)
        {
          paramArrayOfObject[0] = d;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          d = paramArrayOfObject;
          e += 1;
        }
        return;
      }
      finally {}
      return;
      label114:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label130:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        if (f != null)
        {
          Object[] arrayOfObject1 = f;
          this.a = arrayOfObject1;
          f = (Object[])arrayOfObject1[0];
          this.h = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          g -= 1;
          return;
        }
      }
      finally {}
    } else if (paramInt == 4) {
      try
      {
        if (d != null)
        {
          Object[] arrayOfObject2 = d;
          this.a = arrayOfObject2;
          d = (Object[])arrayOfObject2[0];
          this.h = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          e -= 1;
          return;
        }
      }
      finally {}
    }
    this.h = new int[paramInt];
    this.a = new Object[paramInt];
  }
  
  public final int a(Object paramObject)
  {
    if (paramObject == null) {
      return a();
    }
    return a(paramObject, paramObject.hashCode());
  }
  
  public final E a(int paramInt)
  {
    Object localObject = this.a;
    E ? = localObject[paramInt];
    int m = this.i;
    if (m <= 1)
    {
      a(this.h, (Object[])localObject, m);
      this.h = b;
      this.a = c;
      this.i = 0;
      return ?;
    }
    localObject = this.h;
    int n = localObject.length;
    int k = 8;
    if ((n > 8) && (m < localObject.length / 3))
    {
      if (m > 8) {
        k = m + (m >> 1);
      }
      localObject = this.h;
      Object[] arrayOfObject = this.a;
      b(k);
      this.i -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(localObject, 0, this.h, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.a, 0, paramInt);
      }
      k = this.i;
      if (paramInt < k)
      {
        m = paramInt + 1;
        System.arraycopy(localObject, m, this.h, paramInt, k - paramInt);
        System.arraycopy(arrayOfObject, m, this.a, paramInt, this.i - paramInt);
        return ?;
      }
    }
    else
    {
      this.i -= 1;
      k = this.i;
      if (paramInt < k)
      {
        localObject = this.h;
        m = paramInt + 1;
        System.arraycopy(localObject, m, localObject, paramInt, k - paramInt);
        localObject = this.a;
        System.arraycopy(localObject, m, localObject, paramInt, this.i - paramInt);
      }
      this.a[this.i] = null;
    }
    return ?;
  }
  
  public final boolean add(E paramE)
  {
    int m;
    if (paramE == null)
    {
      k = a();
      m = 0;
    }
    else
    {
      m = paramE.hashCode();
      k = a(paramE, m);
    }
    if (k >= 0) {
      return false;
    }
    int n = k ^ 0xFFFFFFFF;
    int i1 = this.i;
    Object localObject;
    if (i1 >= this.h.length)
    {
      k = 4;
      if (i1 >= 8) {
        k = (i1 >> 1) + i1;
      } else if (i1 >= 4) {
        k = 8;
      }
      localObject = this.h;
      Object[] arrayOfObject = this.a;
      b(k);
      int[] arrayOfInt = this.h;
      if (arrayOfInt.length > 0)
      {
        System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
        System.arraycopy(arrayOfObject, 0, this.a, 0, arrayOfObject.length);
      }
      a((int[])localObject, arrayOfObject, this.i);
    }
    int k = this.i;
    if (n < k)
    {
      localObject = this.h;
      i1 = n + 1;
      System.arraycopy(localObject, n, localObject, i1, k - n);
      localObject = this.a;
      System.arraycopy(localObject, n, localObject, i1, this.i - n);
    }
    this.h[n] = m;
    this.a[n] = paramE;
    this.i += 1;
    return true;
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    int k = this.i + paramCollection.size();
    int[] arrayOfInt = this.h;
    int m = arrayOfInt.length;
    boolean bool = false;
    if (m < k)
    {
      Object[] arrayOfObject = this.a;
      b(k);
      k = this.i;
      if (k > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.h, 0, k);
        System.arraycopy(arrayOfObject, 0, this.a, 0, this.i);
      }
      a(arrayOfInt, arrayOfObject, this.i);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    return bool;
  }
  
  public final void clear()
  {
    int k = this.i;
    if (k != 0)
    {
      a(this.h, this.a, k);
      this.h = b;
      this.a = c;
      this.i = 0;
    }
  }
  
  public final boolean contains(Object paramObject)
  {
    return a(paramObject) >= 0;
  }
  
  public final boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    int k;
    if ((paramObject instanceof Set))
    {
      paramObject = (Set)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
      k = 0;
    }
    try
    {
      while (k < this.i)
      {
        boolean bool = paramObject.contains(this.a[k]);
        if (!bool) {
          return false;
        }
        k += 1;
      }
      return true;
    }
    catch (NullPointerException paramObject)
    {
      return false;
    }
    catch (ClassCastException paramObject) {}
    return false;
    return false;
  }
  
  public final int hashCode()
  {
    int[] arrayOfInt = this.h;
    int n = this.i;
    int k = 0;
    int m = 0;
    while (k < n)
    {
      m += arrayOfInt[k];
      k += 1;
    }
    return m;
  }
  
  public final boolean isEmpty()
  {
    return this.i <= 0;
  }
  
  public final Iterator<E> iterator()
  {
    if (this.j == null) {
      this.j = new eb()
      {
        protected final int a()
        {
          return dv.a(dv.this);
        }
        
        protected final int a(Object paramAnonymousObject)
        {
          return dv.this.a(paramAnonymousObject);
        }
        
        protected final Object a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return dv.b(dv.this)[paramAnonymousInt1];
        }
        
        protected final E a(int paramAnonymousInt, E paramAnonymousE)
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final void a(int paramAnonymousInt)
        {
          dv.this.a(paramAnonymousInt);
        }
        
        protected final void a(E paramAnonymousE1, E paramAnonymousE2)
        {
          dv.this.add(paramAnonymousE1);
        }
        
        protected final int b(Object paramAnonymousObject)
        {
          return dv.this.a(paramAnonymousObject);
        }
        
        protected final Map<E, E> b()
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final void c()
        {
          dv.this.clear();
        }
      };
    }
    return this.j.d().iterator();
  }
  
  public final boolean remove(Object paramObject)
  {
    int k = a(paramObject);
    if (k >= 0)
    {
      a(k);
      return true;
    }
    return false;
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    while (paramCollection.hasNext()) {
      bool |= remove(paramCollection.next());
    }
    return bool;
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    int k = this.i - 1;
    boolean bool = false;
    while (k >= 0)
    {
      if (!paramCollection.contains(this.a[k]))
      {
        a(k);
        bool = true;
      }
      k -= 1;
    }
    return bool;
  }
  
  public final int size()
  {
    return this.i;
  }
  
  public final Object[] toArray()
  {
    int k = this.i;
    Object[] arrayOfObject = new Object[k];
    System.arraycopy(this.a, 0, arrayOfObject, 0, k);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < this.i) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.i);
    }
    System.arraycopy(this.a, 0, localObject, 0, this.i);
    int k = localObject.length;
    int m = this.i;
    if (k > m) {
      localObject[m] = null;
    }
    return localObject;
  }
  
  public final String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.i * 14);
    localStringBuilder.append('{');
    int k = 0;
    while (k < this.i)
    {
      if (k > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = this.a[k];
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Set)");
      }
      k += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dv
 * JD-Core Version:    0.7.0.1
 */