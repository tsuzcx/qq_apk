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

public class w
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
  
  public w()
  {
    this(2147483647);
  }
  
  public w(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    this.f = paramInt;
  }
  
  public w(Collection paramCollection)
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
  
  /* Error */
  public Object a(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    // Byte code:
    //   0: aload_3
    //   1: lload_1
    //   2: invokevirtual 168	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 43	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: astore 5
    //   12: aload 5
    //   14: invokevirtual 171	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   17: aload_0
    //   18: invokespecial 154	com/tencent/mobileqq/msf/sdk/w:o	()Ljava/lang/Object;
    //   21: astore_3
    //   22: aload_3
    //   23: astore 4
    //   25: aload_3
    //   26: ifnonnull +12 -> 38
    //   29: lload_1
    //   30: lconst_0
    //   31: lcmp
    //   32: ifgt +14 -> 46
    //   35: aconst_null
    //   36: astore 4
    //   38: aload 5
    //   40: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   43: aload 4
    //   45: areturn
    //   46: aload_0
    //   47: getfield 49	com/tencent/mobileqq/msf/sdk/w:g	Ljava/util/concurrent/locks/Condition;
    //   50: lload_1
    //   51: invokeinterface 174 3 0
    //   56: lstore_1
    //   57: goto -40 -> 17
    //   60: astore_3
    //   61: aload 5
    //   63: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   66: aload_3
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	w
    //   0	68	1	paramLong	long
    //   0	68	3	paramTimeUnit	TimeUnit
    //   23	21	4	localTimeUnit	TimeUnit
    //   10	52	5	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   17	22	60	finally
    //   46	57	60	finally
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
  
  /* Error */
  public boolean a(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 78	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 79	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: new 17	com/tencent/mobileqq/msf/sdk/w$d
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 85	com/tencent/mobileqq/msf/sdk/w$d:<init>	(Ljava/lang/Object;)V
    //   20: astore_1
    //   21: aload 4
    //   23: lload_2
    //   24: invokevirtual 168	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   27: lstore_2
    //   28: aload_0
    //   29: getfield 43	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   32: astore 4
    //   34: aload 4
    //   36: invokevirtual 171	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 182	com/tencent/mobileqq/msf/sdk/w:b	(Lcom/tencent/mobileqq/msf/sdk/w$d;)Z
    //   44: istore 5
    //   46: iload 5
    //   48: ifne +34 -> 82
    //   51: lload_2
    //   52: lconst_0
    //   53: lcmp
    //   54: ifgt +14 -> 68
    //   57: iconst_0
    //   58: istore 5
    //   60: aload 4
    //   62: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   65: iload 5
    //   67: ireturn
    //   68: aload_0
    //   69: getfield 51	com/tencent/mobileqq/msf/sdk/w:h	Ljava/util/concurrent/locks/Condition;
    //   72: lload_2
    //   73: invokeinterface 174 3 0
    //   78: lstore_2
    //   79: goto -40 -> 39
    //   82: iconst_1
    //   83: istore 5
    //   85: goto -25 -> 60
    //   88: astore_1
    //   89: aload 4
    //   91: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	w
    //   0	96	1	paramObject	Object
    //   0	96	2	paramLong	long
    //   0	96	4	paramTimeUnit	TimeUnit
    //   44	40	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   39	46	88	finally
    //   68	79	88	finally
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
  
  /* Error */
  public Object b(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    // Byte code:
    //   0: aload_3
    //   1: lload_1
    //   2: invokevirtual 168	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 43	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: astore 5
    //   12: aload 5
    //   14: invokevirtual 171	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   17: aload_0
    //   18: invokespecial 177	com/tencent/mobileqq/msf/sdk/w:p	()Ljava/lang/Object;
    //   21: astore_3
    //   22: aload_3
    //   23: astore 4
    //   25: aload_3
    //   26: ifnonnull +12 -> 38
    //   29: lload_1
    //   30: lconst_0
    //   31: lcmp
    //   32: ifgt +14 -> 46
    //   35: aconst_null
    //   36: astore 4
    //   38: aload 5
    //   40: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   43: aload 4
    //   45: areturn
    //   46: aload_0
    //   47: getfield 49	com/tencent/mobileqq/msf/sdk/w:g	Ljava/util/concurrent/locks/Condition;
    //   50: lload_1
    //   51: invokeinterface 174 3 0
    //   56: lstore_1
    //   57: goto -40 -> 17
    //   60: astore_3
    //   61: aload 5
    //   63: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   66: aload_3
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	w
    //   0	68	1	paramLong	long
    //   0	68	3	paramTimeUnit	TimeUnit
    //   23	21	4	localTimeUnit	TimeUnit
    //   10	52	5	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   17	22	60	finally
    //   46	57	60	finally
  }
  
  public void b(Object paramObject)
  {
    if (!d(paramObject)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  /* Error */
  public boolean b(Object paramObject, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 78	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 79	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: new 17	com/tencent/mobileqq/msf/sdk/w$d
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 85	com/tencent/mobileqq/msf/sdk/w$d:<init>	(Ljava/lang/Object;)V
    //   20: astore_1
    //   21: aload 4
    //   23: lload_2
    //   24: invokevirtual 168	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   27: lstore_2
    //   28: aload_0
    //   29: getfield 43	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   32: astore 4
    //   34: aload 4
    //   36: invokevirtual 171	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 88	com/tencent/mobileqq/msf/sdk/w:c	(Lcom/tencent/mobileqq/msf/sdk/w$d;)Z
    //   44: istore 5
    //   46: iload 5
    //   48: ifne +34 -> 82
    //   51: lload_2
    //   52: lconst_0
    //   53: lcmp
    //   54: ifgt +14 -> 68
    //   57: iconst_0
    //   58: istore 5
    //   60: aload 4
    //   62: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   65: iload 5
    //   67: ireturn
    //   68: aload_0
    //   69: getfield 51	com/tencent/mobileqq/msf/sdk/w:h	Ljava/util/concurrent/locks/Condition;
    //   72: lload_2
    //   73: invokeinterface 174 3 0
    //   78: lstore_2
    //   79: goto -40 -> 39
    //   82: iconst_1
    //   83: istore 5
    //   85: goto -25 -> 60
    //   88: astore_1
    //   89: aload 4
    //   91: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	w
    //   0	96	1	paramObject	Object
    //   0	96	2	paramLong	long
    //   0	96	4	paramTimeUnit	TimeUnit
    //   44	40	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   39	46	88	finally
    //   68	79	88	finally
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
  
  /* Error */
  public boolean contains(Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 43	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   12: astore 5
    //   14: aload 5
    //   16: invokevirtual 60	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   19: aload_0
    //   20: getfield 109	com/tencent/mobileqq/msf/sdk/w:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   23: astore 4
    //   25: iload_3
    //   26: istore_2
    //   27: aload 4
    //   29: ifnull +19 -> 48
    //   32: aload_1
    //   33: aload 4
    //   35: getfield 128	com/tencent/mobileqq/msf/sdk/w$d:a	Ljava/lang/Object;
    //   38: invokevirtual 202	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   41: istore_2
    //   42: iload_2
    //   43: ifeq +12 -> 55
    //   46: iconst_1
    //   47: istore_2
    //   48: aload 5
    //   50: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   53: iload_2
    //   54: ireturn
    //   55: aload 4
    //   57: getfield 133	com/tencent/mobileqq/msf/sdk/w$d:c	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   60: astore 4
    //   62: goto -37 -> 25
    //   65: astore_1
    //   66: aload 5
    //   68: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	w
    //   0	73	1	paramObject	Object
    //   26	28	2	bool1	boolean
    //   1	25	3	bool2	boolean
    //   23	38	4	locald	d
    //   12	55	5	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   19	25	65	finally
    //   32	42	65	finally
    //   55	62	65	finally
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
  
  /* Error */
  public boolean g(Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 43	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   12: astore 5
    //   14: aload 5
    //   16: invokevirtual 60	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   19: aload_0
    //   20: getfield 109	com/tencent/mobileqq/msf/sdk/w:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   23: astore 4
    //   25: iload_3
    //   26: istore_2
    //   27: aload 4
    //   29: ifnull +23 -> 52
    //   32: aload_1
    //   33: aload 4
    //   35: getfield 128	com/tencent/mobileqq/msf/sdk/w$d:a	Ljava/lang/Object;
    //   38: invokevirtual 202	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +18 -> 59
    //   44: aload_0
    //   45: aload 4
    //   47: invokevirtual 213	com/tencent/mobileqq/msf/sdk/w:a	(Lcom/tencent/mobileqq/msf/sdk/w$d;)V
    //   50: iconst_1
    //   51: istore_2
    //   52: aload 5
    //   54: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   57: iload_2
    //   58: ireturn
    //   59: aload 4
    //   61: getfield 133	com/tencent/mobileqq/msf/sdk/w$d:c	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   64: astore 4
    //   66: goto -41 -> 25
    //   69: astore_1
    //   70: aload 5
    //   72: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	w
    //   0	77	1	paramObject	Object
    //   26	32	2	bool1	boolean
    //   1	25	3	bool2	boolean
    //   23	42	4	locald	d
    //   12	59	5	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   19	25	69	finally
    //   32	50	69	finally
    //   59	66	69	finally
  }
  
  public Object h()
  {
    Object localObject = j();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  /* Error */
  public boolean h(Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 43	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   12: astore 5
    //   14: aload 5
    //   16: invokevirtual 60	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   19: aload_0
    //   20: getfield 111	com/tencent/mobileqq/msf/sdk/w:b	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   23: astore 4
    //   25: iload_3
    //   26: istore_2
    //   27: aload 4
    //   29: ifnull +23 -> 52
    //   32: aload_1
    //   33: aload 4
    //   35: getfield 128	com/tencent/mobileqq/msf/sdk/w$d:a	Ljava/lang/Object;
    //   38: invokevirtual 202	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +18 -> 59
    //   44: aload_0
    //   45: aload 4
    //   47: invokevirtual 213	com/tencent/mobileqq/msf/sdk/w:a	(Lcom/tencent/mobileqq/msf/sdk/w$d;)V
    //   50: iconst_1
    //   51: istore_2
    //   52: aload 5
    //   54: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   57: iload_2
    //   58: ireturn
    //   59: aload 4
    //   61: getfield 139	com/tencent/mobileqq/msf/sdk/w$d:b	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   64: astore 4
    //   66: goto -41 -> 25
    //   69: astore_1
    //   70: aload 5
    //   72: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	w
    //   0	77	1	paramObject	Object
    //   26	32	2	bool1	boolean
    //   1	25	3	bool2	boolean
    //   23	42	4	locald	d
    //   12	59	5	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   19	25	69	finally
    //   32	50	69	finally
    //   59	66	69	finally
  }
  
  /* Error */
  public Object i()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 60	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 109	com/tencent/mobileqq/msf/sdk/w:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 109	com/tencent/mobileqq/msf/sdk/w:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   30: getfield 128	com/tencent/mobileqq/msf/sdk/w$d:a	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	w
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
    //   1: getfield 43	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 60	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 111	com/tencent/mobileqq/msf/sdk/w:b	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 111	com/tencent/mobileqq/msf/sdk/w:b	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   30: getfield 128	com/tencent/mobileqq/msf/sdk/w$d:a	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	w
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
    Object[] arrayOfObject;
    try
    {
      arrayOfObject = new Object[this.e];
      int i = 0;
      d locald = this.a;
      while (locald != null)
      {
        arrayOfObject[i] = locald.a;
        locald = locald.c;
        i += 1;
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return arrayOfObject;
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
    //   1: getfield 43	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 60	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   11: aload_0
    //   12: getfield 109	com/tencent/mobileqq/msf/sdk/w:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +14 -> 31
    //   20: ldc_w 264
    //   23: astore_1
    //   24: aload 4
    //   26: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   29: aload_1
    //   30: areturn
    //   31: new 266	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   38: astore 5
    //   40: aload 5
    //   42: bipush 91
    //   44: invokevirtual 271	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: getfield 128	com/tencent/mobileqq/msf/sdk/w$d:a	Ljava/lang/Object;
    //   52: astore_3
    //   53: aload_3
    //   54: astore_2
    //   55: aload_3
    //   56: aload_0
    //   57: if_acmpne +7 -> 64
    //   60: ldc_w 273
    //   63: astore_2
    //   64: aload 5
    //   66: aload_2
    //   67: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_1
    //   72: getfield 133	com/tencent/mobileqq/msf/sdk/w$d:c	Lcom/tencent/mobileqq/msf/sdk/w$d;
    //   75: astore_1
    //   76: aload_1
    //   77: ifnonnull +17 -> 94
    //   80: aload 5
    //   82: bipush 93
    //   84: invokevirtual 271	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   87: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore_1
    //   91: goto -67 -> 24
    //   94: aload 5
    //   96: bipush 44
    //   98: invokevirtual 271	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   101: bipush 32
    //   103: invokevirtual 271	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: goto -59 -> 48
    //   110: astore_1
    //   111: aload 4
    //   113: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	w
    //   15	76	1	localObject1	Object
    //   110	7	1	localObject2	Object
    //   54	13	2	localObject3	Object
    //   52	4	3	localObject4	Object
    //   4	108	4	localReentrantLock	ReentrantLock
    //   38	57	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	16	110	finally
    //   31	48	110	finally
    //   48	53	110	finally
    //   64	76	110	finally
    //   80	91	110	finally
    //   94	107	110	finally
  }
  
  abstract class a
    implements Iterator
  {
    w.d a;
    Object b;
    private w.d d;
    
    /* Error */
    a()
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 19	com/tencent/mobileqq/msf/sdk/w$a:c	Lcom/tencent/mobileqq/msf/sdk/w;
      //   5: aload_0
      //   6: invokespecial 22	java/lang/Object:<init>	()V
      //   9: aload_1
      //   10: getfield 25	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 30	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   18: aload_0
      //   19: aload_0
      //   20: invokevirtual 33	com/tencent/mobileqq/msf/sdk/w$a:a	()Lcom/tencent/mobileqq/msf/sdk/w$d;
      //   23: putfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
      //   26: aload_0
      //   27: getfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
      //   30: ifnonnull +15 -> 45
      //   33: aconst_null
      //   34: astore_1
      //   35: aload_0
      //   36: aload_1
      //   37: putfield 37	com/tencent/mobileqq/msf/sdk/w$a:b	Ljava/lang/Object;
      //   40: aload_2
      //   41: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   44: return
      //   45: aload_0
      //   46: getfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
      //   49: getfield 44	com/tencent/mobileqq/msf/sdk/w$d:a	Ljava/lang/Object;
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
      //   0	63	1	this$1	w
      //   13	45	2	localReentrantLock	ReentrantLock
      // Exception table:
      //   from	to	target	type
      //   18	33	56	finally
      //   35	40	56	finally
      //   45	53	56	finally
    }
    
    private w.d b(w.d paramd)
    {
      for (;;)
      {
        w.d locald1 = a(paramd);
        w.d locald2;
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
    
    abstract w.d a();
    
    abstract w.d a(w.d paramd);
    
    /* Error */
    void b()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	com/tencent/mobileqq/msf/sdk/w$a:c	Lcom/tencent/mobileqq/msf/sdk/w;
      //   4: getfield 25	com/tencent/mobileqq/msf/sdk/w:c	Ljava/util/concurrent/locks/ReentrantLock;
      //   7: astore_2
      //   8: aload_2
      //   9: invokevirtual 30	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   12: aload_0
      //   13: aload_0
      //   14: aload_0
      //   15: getfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
      //   18: invokespecial 50	com/tencent/mobileqq/msf/sdk/w$a:b	(Lcom/tencent/mobileqq/msf/sdk/w$d;)Lcom/tencent/mobileqq/msf/sdk/w$d;
      //   21: putfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
      //   24: aload_0
      //   25: getfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
      //   28: ifnonnull +15 -> 43
      //   31: aconst_null
      //   32: astore_1
      //   33: aload_0
      //   34: aload_1
      //   35: putfield 37	com/tencent/mobileqq/msf/sdk/w$a:b	Ljava/lang/Object;
      //   38: aload_2
      //   39: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   42: return
      //   43: aload_0
      //   44: getfield 35	com/tencent/mobileqq/msf/sdk/w$a:a	Lcom/tencent/mobileqq/msf/sdk/w$d;
      //   47: getfield 44	com/tencent/mobileqq/msf/sdk/w$d:a	Ljava/lang/Object;
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
      w.d locald = this.d;
      if (locald == null) {
        throw new IllegalStateException();
      }
      this.d = null;
      ReentrantLock localReentrantLock = w.this.c;
      localReentrantLock.lock();
      try
      {
        if (locald.a != null) {
          w.this.a(locald);
        }
        return;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
  
  class b
    extends w.a
  {
    private b()
    {
      super();
    }
    
    w.d a()
    {
      return w.this.b;
    }
    
    w.d a(w.d paramd)
    {
      return paramd.b;
    }
  }
  
  class c
    extends w.a
  {
    private c()
    {
      super();
    }
    
    w.d a()
    {
      return w.this.a;
    }
    
    w.d a(w.d paramd)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.w
 * JD-Core Version:    0.7.0.1
 */