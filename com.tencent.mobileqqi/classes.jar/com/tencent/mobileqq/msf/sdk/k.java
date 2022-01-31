package com.tencent.mobileqq.msf.sdk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class k
  extends AbstractQueue
  implements Serializable
{
  private static final long d = -387911632671998426L;
  transient d a;
  transient d b;
  final ReentrantLock c = new ReentrantLock();
  private transient int e;
  private final int f;
  private final Condition g = this.c.newCondition();
  private final Condition h = this.c.newCondition();
  
  public k()
  {
    this(2147483647);
  }
  
  public k(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    this.f = paramInt;
  }
  
  public k(Collection paramCollection)
  {
    this(2147483647);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    for (;;)
    {
      Object localObject;
      try
      {
        paramCollection = paramCollection.iterator();
        if (!paramCollection.hasNext()) {
          break;
        }
        localObject = paramCollection.next();
        if (localObject == null) {
          throw new NullPointerException();
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
      if (!c(new d(localObject))) {
        throw new IllegalStateException("Deque full");
      }
    }
    localReentrantLock.unlock();
  }
  
  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.e = 0;
    this.a = null;
    this.b = null;
    for (;;)
    {
      Object localObject = paramObjectInputStream.readObject();
      if (localObject == null) {
        return;
      }
      add(localObject);
    }
  }
  
  private void a(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      paramObjectOutputStream.defaultWriteObject();
      for (d locald = this.a; locald != null; locald = locald.c) {
        paramObjectOutputStream.writeObject(locald.a);
      }
      paramObjectOutputStream.writeObject(null);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  private boolean b(d paramd)
  {
    if (this.e >= this.f) {
      return false;
    }
    d locald = this.a;
    paramd.c = locald;
    this.a = paramd;
    if (this.b == null) {
      this.b = paramd;
    }
    for (;;)
    {
      this.e += 1;
      this.g.signal();
      return true;
      locald.b = paramd;
    }
  }
  
  private boolean c(d paramd)
  {
    if (this.e >= this.f) {
      return false;
    }
    d locald = this.b;
    paramd.b = locald;
    this.b = paramd;
    if (this.a == null) {
      this.a = paramd;
    }
    for (;;)
    {
      this.e += 1;
      this.g.signal();
      return true;
      locald.c = paramd;
    }
  }
  
  private Object o()
  {
    d locald1 = this.a;
    if (locald1 == null) {
      return null;
    }
    d locald2 = locald1.c;
    Object localObject = locald1.a;
    locald1.a = null;
    locald1.c = locald1;
    this.a = locald2;
    if (locald2 == null) {
      this.b = null;
    }
    for (;;)
    {
      this.e -= 1;
      this.h.signal();
      return localObject;
      locald2.b = null;
    }
  }
  
  private Object p()
  {
    d locald1 = this.b;
    if (locald1 == null) {
      return null;
    }
    d locald2 = locald1.b;
    Object localObject = locald1.a;
    locald1.a = null;
    locald1.b = locald1;
    this.b = locald2;
    if (locald2 == null) {
      this.a = null;
    }
    for (;;)
    {
      this.e -= 1;
      this.h.signal();
      return localObject;
      locald2.c = null;
    }
  }
  
  public int a(Collection paramCollection)
  {
    return a(paramCollection, 2147483647);
  }
  
  public int a(Collection paramCollection, int paramInt)
  {
    int i = 0;
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (paramCollection == this) {
      throw new IllegalArgumentException();
    }
    if (paramInt <= 0) {
      return 0;
    }
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int j = Math.min(paramInt, this.e);
      paramInt = i;
      while (paramInt < j)
      {
        paramCollection.add(this.a.a);
        o();
        paramInt += 1;
      }
      return j;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object a()
  {
    Object localObject = c();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public Object a(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.c;
    paramTimeUnit.lockInterruptibly();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = o();
        if (localObject1 != null) {
          break;
        }
        if (paramLong <= 0L) {
          return null;
        }
        paramLong = this.g.awaitNanos(paramLong);
      }
      return localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  void a(d paramd)
  {
    d locald1 = paramd.b;
    d locald2 = paramd.c;
    if (locald1 == null)
    {
      o();
      return;
    }
    if (locald2 == null)
    {
      p();
      return;
    }
    locald1.c = locald2;
    locald2.b = locald1;
    paramd.a = null;
    this.e -= 1;
    this.h.signal();
  }
  
  public void a(Object paramObject)
  {
    if (!c(paramObject)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  public boolean a(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    paramObject = new d(paramObject);
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.c;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        boolean bool = b(paramObject);
        if (bool) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = this.h.awaitNanos(paramLong);
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public boolean add(Object paramObject)
  {
    b(paramObject);
    return true;
  }
  
  public Object b()
  {
    Object localObject = d();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public Object b(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.c;
    paramTimeUnit.lockInterruptibly();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = p();
        if (localObject1 != null) {
          break;
        }
        if (paramLong <= 0L) {
          return null;
        }
        paramLong = this.g.awaitNanos(paramLong);
      }
      return localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public void b(Object paramObject)
  {
    if (!d(paramObject)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  public boolean b(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    paramObject = new d(paramObject);
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.c;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        boolean bool = c(paramObject);
        if (bool) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = this.h.awaitNanos(paramLong);
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public Object c()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = o();
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object c(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return a(paramLong, paramTimeUnit);
  }
  
  public boolean c(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    d locald = new d(paramObject);
    paramObject = this.c;
    paramObject.lock();
    try
    {
      boolean bool = b(locald);
      return bool;
    }
    finally
    {
      paramObject.unlock();
    }
  }
  
  public boolean c(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return b(paramObject, paramLong, paramTimeUnit);
  }
  
  public void clear()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      d locald;
      for (Object localObject1 = this.a; localObject1 != null; localObject1 = locald)
      {
        ((d)localObject1).a = null;
        locald = ((d)localObject1).c;
        ((d)localObject1).b = null;
        ((d)localObject1).c = null;
      }
      this.b = null;
      this.a = null;
      this.e = 0;
      this.h.signalAll();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (d locald = this.a; locald != null; locald = locald.c)
      {
        boolean bool = paramObject.equals(locald.a);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object d()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = p();
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean d(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    d locald = new d(paramObject);
    paramObject = this.c;
    paramObject.lock();
    try
    {
      boolean bool = c(locald);
      return bool;
    }
    finally
    {
      paramObject.unlock();
    }
  }
  
  public Object e()
    throws InterruptedException
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (;;)
      {
        Object localObject1 = o();
        if (localObject1 != null) {
          break;
        }
        this.g.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return localObject2;
  }
  
  public void e(Object paramObject)
    throws InterruptedException
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    d locald = new d(paramObject);
    paramObject = this.c;
    paramObject.lock();
    try
    {
      if (!b(locald)) {
        this.h.await();
      }
      return;
    }
    finally
    {
      paramObject.unlock();
    }
  }
  
  public Object element()
  {
    return g();
  }
  
  public Object f()
    throws InterruptedException
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (;;)
      {
        Object localObject1 = p();
        if (localObject1 != null) {
          break;
        }
        this.g.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return localObject2;
  }
  
  public void f(Object paramObject)
    throws InterruptedException
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    d locald = new d(paramObject);
    paramObject = this.c;
    paramObject.lock();
    try
    {
      if (!c(locald)) {
        this.h.await();
      }
      return;
    }
    finally
    {
      paramObject.unlock();
    }
  }
  
  public Object g()
  {
    Object localObject = i();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public boolean g(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (d locald = this.a; locald != null; locald = locald.c) {
        if (paramObject.equals(locald.a))
        {
          a(locald);
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object h()
  {
    Object localObject = j();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public boolean h(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (d locald = this.b; locald != null; locald = locald.b) {
        if (paramObject.equals(locald.a))
        {
          a(locald);
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  public Object i()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/mobileqq/msf/sdk/k:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 62	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 111	com/tencent/mobileqq/msf/sdk/k:a	Lcom/tencent/mobileqq/msf/sdk/k$d;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 84	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 111	com/tencent/mobileqq/msf/sdk/k:a	Lcom/tencent/mobileqq/msf/sdk/k$d;
    //   30: getfield 130	com/tencent/mobileqq/msf/sdk/k$d:a	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 84	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	k
    //   13	21	1	localObject1	Object
    //   37	6	1	localObject2	Object
    //   4	35	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
    //   26	34	37	finally
  }
  
  public void i(Object paramObject)
    throws InterruptedException
  {
    f(paramObject);
  }
  
  public Iterator iterator()
  {
    return new c(null);
  }
  
  /* Error */
  public Object j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/mobileqq/msf/sdk/k:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 62	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 113	com/tencent/mobileqq/msf/sdk/k:b	Lcom/tencent/mobileqq/msf/sdk/k$d;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 84	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 113	com/tencent/mobileqq/msf/sdk/k:b	Lcom/tencent/mobileqq/msf/sdk/k$d;
    //   30: getfield 130	com/tencent/mobileqq/msf/sdk/k$d:a	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 84	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	k
    //   13	21	1	localObject1	Object
    //   37	6	1	localObject2	Object
    //   4	35	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
    //   26	34	37	finally
  }
  
  public void j(Object paramObject)
  {
    a(paramObject);
  }
  
  public Object k()
    throws InterruptedException
  {
    return e();
  }
  
  public int l()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = this.f;
      int j = this.e;
      return i - j;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object m()
  {
    return a();
  }
  
  public Iterator n()
  {
    return new b(null);
  }
  
  public boolean offer(Object paramObject)
  {
    return d(paramObject);
  }
  
  public Object peek()
  {
    return i();
  }
  
  public Object poll()
  {
    return c();
  }
  
  public Object remove()
  {
    return a();
  }
  
  public boolean remove(Object paramObject)
  {
    return g(paramObject);
  }
  
  public int size()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = this.e;
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object[] toArray()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object[] arrayOfObject = new Object[this.e];
      int i = 0;
      d locald = this.a;
      while (locald != null)
      {
        arrayOfObject[i] = locald.a;
        locald = locald.c;
        i += 1;
      }
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    Object[] arrayOfObject = paramArrayOfObject;
    try
    {
      if (paramArrayOfObject.length < this.e) {
        arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), this.e);
      }
      int i = 0;
      paramArrayOfObject = this.a;
      while (paramArrayOfObject != null)
      {
        arrayOfObject[i] = paramArrayOfObject.a;
        paramArrayOfObject = paramArrayOfObject.c;
        i += 1;
      }
      if (arrayOfObject.length > i) {
        arrayOfObject[i] = null;
      }
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  public java.lang.String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/mobileqq/msf/sdk/k:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 62	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   11: aload_0
    //   12: getfield 111	com/tencent/mobileqq/msf/sdk/k:a	Lcom/tencent/mobileqq/msf/sdk/k$d;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +12 -> 29
    //   20: aload 4
    //   22: invokevirtual 84	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   25: ldc_w 266
    //   28: areturn
    //   29: new 268	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   36: astore 5
    //   38: aload 5
    //   40: bipush 91
    //   42: invokevirtual 273	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: getfield 130	com/tencent/mobileqq/msf/sdk/k$d:a	Ljava/lang/Object;
    //   50: astore_3
    //   51: aload_3
    //   52: astore_2
    //   53: aload_3
    //   54: aload_0
    //   55: if_acmpne +7 -> 62
    //   58: ldc_w 275
    //   61: astore_2
    //   62: aload 5
    //   64: aload_2
    //   65: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_1
    //   70: getfield 135	com/tencent/mobileqq/msf/sdk/k$d:c	Lcom/tencent/mobileqq/msf/sdk/k$d;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnonnull +21 -> 96
    //   78: aload 5
    //   80: bipush 93
    //   82: invokevirtual 273	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   85: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_1
    //   89: aload 4
    //   91: invokevirtual 84	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: aload_1
    //   95: areturn
    //   96: aload 5
    //   98: bipush 44
    //   100: invokevirtual 273	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   103: bipush 32
    //   105: invokevirtual 273	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: goto -63 -> 46
    //   112: astore_1
    //   113: aload 4
    //   115: invokevirtual 84	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	k
    //   15	80	1	localObject1	Object
    //   112	7	1	localObject2	Object
    //   52	13	2	localObject3	Object
    //   50	4	3	localObject4	Object
    //   4	110	4	localReentrantLock	ReentrantLock
    //   36	61	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	16	112	finally
    //   29	46	112	finally
    //   46	51	112	finally
    //   62	74	112	finally
    //   78	89	112	finally
    //   96	109	112	finally
  }
  
  private abstract class a
    implements Iterator
  {
    k.d a;
    Object b;
    private k.d d;
    
    /* Error */
    a()
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 19	com/tencent/mobileqq/msf/sdk/k$a:c	Lcom/tencent/mobileqq/msf/sdk/k;
      //   5: aload_0
      //   6: invokespecial 22	java/lang/Object:<init>	()V
      //   9: aload_1
      //   10: getfield 25	com/tencent/mobileqq/msf/sdk/k:c	Ljava/util/concurrent/locks/ReentrantLock;
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 30	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   18: aload_0
      //   19: aload_0
      //   20: invokevirtual 33	com/tencent/mobileqq/msf/sdk/k$a:a	()Lcom/tencent/mobileqq/msf/sdk/k$d;
      //   23: putfield 35	com/tencent/mobileqq/msf/sdk/k$a:a	Lcom/tencent/mobileqq/msf/sdk/k$d;
      //   26: aload_0
      //   27: getfield 35	com/tencent/mobileqq/msf/sdk/k$a:a	Lcom/tencent/mobileqq/msf/sdk/k$d;
      //   30: ifnonnull +15 -> 45
      //   33: aconst_null
      //   34: astore_1
      //   35: aload_0
      //   36: aload_1
      //   37: putfield 37	com/tencent/mobileqq/msf/sdk/k$a:b	Ljava/lang/Object;
      //   40: aload_2
      //   41: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   44: return
      //   45: aload_0
      //   46: getfield 35	com/tencent/mobileqq/msf/sdk/k$a:a	Lcom/tencent/mobileqq/msf/sdk/k$d;
      //   49: getfield 44	com/tencent/mobileqq/msf/sdk/k$d:a	Ljava/lang/Object;
      //   52: astore_1
      //   53: goto -18 -> 35
      //   56: astore_1
      //   57: aload_2
      //   58: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   61: aload_1
      //   62: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	a
      //   0	63	1	this$1	k
      //   13	45	2	localReentrantLock	ReentrantLock
      // Exception table:
      //   from	to	target	type
      //   18	33	56	finally
      //   35	40	56	finally
      //   45	53	56	finally
    }
    
    private k.d b(k.d paramd)
    {
      for (;;)
      {
        k.d locald1 = a(paramd);
        k.d locald2;
        if (locald1 == null) {
          locald2 = null;
        }
        do
        {
          return locald2;
          locald2 = locald1;
        } while (locald1.a != null);
        if (locald1 == paramd) {
          return a();
        }
        paramd = locald1;
      }
    }
    
    abstract k.d a();
    
    abstract k.d a(k.d paramd);
    
    /* Error */
    void b()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	com/tencent/mobileqq/msf/sdk/k$a:c	Lcom/tencent/mobileqq/msf/sdk/k;
      //   4: getfield 25	com/tencent/mobileqq/msf/sdk/k:c	Ljava/util/concurrent/locks/ReentrantLock;
      //   7: astore_2
      //   8: aload_2
      //   9: invokevirtual 30	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   12: aload_0
      //   13: aload_0
      //   14: aload_0
      //   15: getfield 35	com/tencent/mobileqq/msf/sdk/k$a:a	Lcom/tencent/mobileqq/msf/sdk/k$d;
      //   18: invokespecial 50	com/tencent/mobileqq/msf/sdk/k$a:b	(Lcom/tencent/mobileqq/msf/sdk/k$d;)Lcom/tencent/mobileqq/msf/sdk/k$d;
      //   21: putfield 35	com/tencent/mobileqq/msf/sdk/k$a:a	Lcom/tencent/mobileqq/msf/sdk/k$d;
      //   24: aload_0
      //   25: getfield 35	com/tencent/mobileqq/msf/sdk/k$a:a	Lcom/tencent/mobileqq/msf/sdk/k$d;
      //   28: ifnonnull +15 -> 43
      //   31: aconst_null
      //   32: astore_1
      //   33: aload_0
      //   34: aload_1
      //   35: putfield 37	com/tencent/mobileqq/msf/sdk/k$a:b	Ljava/lang/Object;
      //   38: aload_2
      //   39: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   42: return
      //   43: aload_0
      //   44: getfield 35	com/tencent/mobileqq/msf/sdk/k$a:a	Lcom/tencent/mobileqq/msf/sdk/k$d;
      //   47: getfield 44	com/tencent/mobileqq/msf/sdk/k$d:a	Ljava/lang/Object;
      //   50: astore_1
      //   51: goto -18 -> 33
      //   54: astore_1
      //   55: aload_2
      //   56: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   59: aload_1
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	a
      //   32	19	1	localObject1	Object
      //   54	6	1	localObject2	Object
      //   7	49	2	localReentrantLock	ReentrantLock
      // Exception table:
      //   from	to	target	type
      //   12	31	54	finally
      //   33	38	54	finally
      //   43	51	54	finally
    }
    
    public boolean hasNext()
    {
      return this.a != null;
    }
    
    public Object next()
    {
      if (this.a == null) {
        throw new NoSuchElementException();
      }
      this.d = this.a;
      Object localObject = this.b;
      b();
      return localObject;
    }
    
    public void remove()
    {
      k.d locald = this.d;
      if (locald == null) {
        throw new IllegalStateException();
      }
      this.d = null;
      ReentrantLock localReentrantLock = k.this.c;
      localReentrantLock.lock();
      try
      {
        if (locald.a != null) {
          k.this.a(locald);
        }
        return;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
  
  private class b
    extends k.a
  {
    private b()
    {
      super();
    }
    
    k.d a()
    {
      return k.this.b;
    }
    
    k.d a(k.d paramd)
    {
      return paramd.b;
    }
  }
  
  private class c
    extends k.a
  {
    private c()
    {
      super();
    }
    
    k.d a()
    {
      return k.this.a;
    }
    
    k.d a(k.d paramd)
    {
      return paramd.c;
    }
  }
  
  static final class d
  {
    Object a;
    d b;
    d c;
    
    d(Object paramObject)
    {
      this.a = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.k
 * JD-Core Version:    0.7.0.1
 */