package com.tencent.token;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class ef<K, V>
{
  static Object[] b;
  static int c;
  static Object[] d;
  static int e;
  int[] f = dw.a;
  Object[] g = dw.c;
  int h = 0;
  
  private int a()
  {
    int j = this.h;
    if (j == 0) {
      return -1;
    }
    int k = a(this.f, j, 0);
    if (k < 0) {
      return k;
    }
    if (this.g[(k << 1)] == null) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.f[i] == 0))
    {
      if (this.g[(i << 1)] == null) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.f[j] == 0))
    {
      if (this.g[(j << 1)] == null) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  private int a(Object paramObject, int paramInt)
  {
    int j = this.h;
    if (j == 0) {
      return -1;
    }
    int k = a(this.f, j, paramInt);
    if (k < 0) {
      return k;
    }
    if (paramObject.equals(this.g[(k << 1)])) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.f[i] == paramInt))
    {
      if (paramObject.equals(this.g[(i << 1)])) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.f[j] == paramInt))
    {
      if (paramObject.equals(this.g[(j << 1)])) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = dw.a(paramArrayOfInt, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      label9:
      break label9;
    }
    throw new ConcurrentModificationException();
  }
  
  static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (e < 10)
        {
          paramArrayOfObject[0] = d;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label118;
          d = paramArrayOfObject;
          e += 1;
        }
        return;
      }
      finally {}
    } else if (paramArrayOfInt.length != 4) {}
    for (;;)
    {
      try
      {
        if (c < 10)
        {
          paramArrayOfObject[0] = b;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          b = paramArrayOfObject;
          c += 1;
        }
        return;
      }
      finally {}
      return;
      label118:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label134:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  public final int a(Object paramObject)
  {
    if (paramObject == null) {
      return a();
    }
    return a(paramObject, paramObject.hashCode());
  }
  
  final void a(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        if (d != null)
        {
          Object[] arrayOfObject1 = d;
          this.g = arrayOfObject1;
          d = (Object[])arrayOfObject1[0];
          this.f = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          e -= 1;
          return;
        }
      }
      finally {}
    } else if (paramInt == 4) {
      try
      {
        if (b != null)
        {
          Object[] arrayOfObject2 = b;
          this.g = arrayOfObject2;
          b = (Object[])arrayOfObject2[0];
          this.f = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          c -= 1;
          return;
        }
      }
      finally {}
    }
    this.f = new int[paramInt];
    this.g = new Object[paramInt << 1];
  }
  
  final int b(Object paramObject)
  {
    int j = this.h * 2;
    Object[] arrayOfObject = this.g;
    if (paramObject == null)
    {
      i = 1;
      while (i < j)
      {
        if (arrayOfObject[i] == null) {
          return i >> 1;
        }
        i += 2;
      }
    }
    int i = 1;
    while (i < j)
    {
      if (paramObject.equals(arrayOfObject[i])) {
        return i >> 1;
      }
      i += 2;
    }
    return -1;
  }
  
  public final K b(int paramInt)
  {
    return this.g[(paramInt << 1)];
  }
  
  public final V c(int paramInt)
  {
    return this.g[((paramInt << 1) + 1)];
  }
  
  public void clear()
  {
    int i = this.h;
    if (i > 0)
    {
      int[] arrayOfInt = this.f;
      Object[] arrayOfObject = this.g;
      this.f = dw.a;
      this.g = dw.c;
      this.h = 0;
      a(arrayOfInt, arrayOfObject, i);
    }
    if (this.h <= 0) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return a(paramObject) >= 0;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return b(paramObject) >= 0;
  }
  
  public final V d(int paramInt)
  {
    Object localObject = this.g;
    int m = paramInt << 1;
    V ? = localObject[(m + 1)];
    int k = this.h;
    int i;
    if (k <= 1)
    {
      a(this.f, (Object[])localObject, k);
      this.f = dw.a;
      this.g = dw.c;
      i = 0;
    }
    else
    {
      int j = k - 1;
      localObject = this.f;
      int n = localObject.length;
      i = 8;
      if ((n > 8) && (k < localObject.length / 3))
      {
        if (k > 8) {
          i = k + (k >> 1);
        }
        localObject = this.f;
        Object[] arrayOfObject = this.g;
        a(i);
        if (k == this.h)
        {
          if (paramInt > 0)
          {
            System.arraycopy(localObject, 0, this.f, 0, paramInt);
            System.arraycopy(arrayOfObject, 0, this.g, 0, m);
          }
          i = j;
          if (paramInt < j)
          {
            i = paramInt + 1;
            int[] arrayOfInt = this.f;
            n = j - paramInt;
            System.arraycopy(localObject, i, arrayOfInt, paramInt, n);
            System.arraycopy(arrayOfObject, i << 1, this.g, m, n << 1);
            i = j;
          }
        }
        else
        {
          throw new ConcurrentModificationException();
        }
      }
      else
      {
        if (paramInt < j)
        {
          localObject = this.f;
          i = paramInt + 1;
          n = j - paramInt;
          System.arraycopy(localObject, i, localObject, paramInt, n);
          localObject = this.g;
          System.arraycopy(localObject, i << 1, localObject, m, n << 1);
        }
        localObject = this.g;
        paramInt = j << 1;
        localObject[paramInt] = null;
        localObject[(paramInt + 1)] = null;
        i = j;
      }
    }
    if (k == this.h)
    {
      this.h = i;
      return ?;
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    int i;
    if ((paramObject instanceof ef))
    {
      paramObject = (ef)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < this.h)
      {
        localObject1 = b(i);
        localObject2 = c(i);
        localObject3 = paramObject.get(localObject1);
        if (localObject2 == null)
        {
          if (localObject3 != null) {
            break label229;
          }
          if (!paramObject.containsKey(localObject1)) {
            return false;
          }
        }
        else
        {
          bool = localObject2.equals(localObject3);
          if (!bool) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (NullPointerException paramObject)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      boolean bool;
      return false;
    }
    catch (ClassCastException paramObject)
    {
      return false;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < this.h)
      {
        localObject1 = b(i);
        localObject2 = c(i);
        localObject3 = paramObject.get(localObject1);
        if (localObject2 == null)
        {
          if (localObject3 != null) {
            break label231;
          }
          if (!paramObject.containsKey(localObject1)) {
            return false;
          }
        }
        else
        {
          bool = localObject2.equals(localObject3);
          if (!bool) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (NullPointerException paramObject)
    {
      return false;
    }
    catch (ClassCastException paramObject)
    {
      return false;
    }
    return false;
    label229:
    return false;
    label231:
    return false;
  }
  
  public V get(Object paramObject)
  {
    int i = a(paramObject);
    if (i >= 0) {
      return this.g[((i << 1) + 1)];
    }
    return null;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.f;
    Object[] arrayOfObject = this.g;
    int n = this.h;
    int j = 0;
    int k = 0;
    int i = 1;
    while (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      int m;
      if (localObject == null) {
        m = 0;
      } else {
        m = localObject.hashCode();
      }
      k += (m ^ i1);
      j += 1;
      i += 2;
    }
    return k;
  }
  
  public boolean isEmpty()
  {
    return this.h <= 0;
  }
  
  public V put(K paramK, V paramV)
  {
    int k = this.h;
    int j;
    if (paramK == null)
    {
      i = a();
      j = 0;
    }
    else
    {
      j = paramK.hashCode();
      i = a(paramK, j);
    }
    Object localObject;
    if (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.g;
      localObject = paramK[i];
      paramK[i] = paramV;
      return localObject;
    }
    int m = i ^ 0xFFFFFFFF;
    if (k >= this.f.length)
    {
      i = 4;
      if (k >= 8) {
        i = (k >> 1) + k;
      } else if (k >= 4) {
        i = 8;
      }
      localObject = this.f;
      Object[] arrayOfObject = this.g;
      a(i);
      if (k == this.h)
      {
        int[] arrayOfInt = this.f;
        if (arrayOfInt.length > 0)
        {
          System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
          System.arraycopy(arrayOfObject, 0, this.g, 0, arrayOfObject.length);
        }
        a((int[])localObject, arrayOfObject, k);
      }
      else
      {
        throw new ConcurrentModificationException();
      }
    }
    if (m < k)
    {
      localObject = this.f;
      i = m + 1;
      System.arraycopy(localObject, m, localObject, i, k - m);
      localObject = this.g;
      System.arraycopy(localObject, m << 1, localObject, i << 1, this.h - m << 1);
    }
    int i = this.h;
    if (k == i)
    {
      localObject = this.f;
      if (m < localObject.length)
      {
        localObject[m] = j;
        localObject = this.g;
        j = m << 1;
        localObject[j] = paramK;
        localObject[(j + 1)] = paramV;
        this.h = (i + 1);
        return null;
      }
    }
    throw new ConcurrentModificationException();
  }
  
  public V remove(Object paramObject)
  {
    int i = a(paramObject);
    if (i >= 0) {
      return d(i);
    }
    return null;
  }
  
  public int size()
  {
    return this.h;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.h * 28);
    localStringBuilder.append('{');
    int i = 0;
    while (i < this.h)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = b(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      localStringBuilder.append('=');
      localObject = c(i);
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
 * Qualified Name:     com.tencent.token.ef
 * JD-Core Version:    0.7.0.1
 */