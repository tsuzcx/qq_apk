package com.tencent.mobileqq.cuckoo;

public class MethodCopyOnWriteSet
{
  private volatile transient MethodCallback[] elements = new MethodCallback[0];
  
  /* Error */
  public boolean add(MethodCallback paramMethodCallback)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 21	com/tencent/mobileqq/cuckoo/MethodCopyOnWriteSet:indexOf	(Ljava/lang/Object;)I
    //   9: istore_2
    //   10: iload_2
    //   11: iflt +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_3
    //   17: ireturn
    //   18: aload_0
    //   19: getfield 14	com/tencent/mobileqq/cuckoo/MethodCopyOnWriteSet:elements	[Lcom/tencent/mobileqq/cuckoo/MethodCallback;
    //   22: arraylength
    //   23: iconst_1
    //   24: iadd
    //   25: anewarray 12	com/tencent/mobileqq/cuckoo/MethodCallback
    //   28: astore 4
    //   30: aload_0
    //   31: getfield 14	com/tencent/mobileqq/cuckoo/MethodCopyOnWriteSet:elements	[Lcom/tencent/mobileqq/cuckoo/MethodCallback;
    //   34: iconst_0
    //   35: aload 4
    //   37: iconst_0
    //   38: aload_0
    //   39: getfield 14	com/tencent/mobileqq/cuckoo/MethodCopyOnWriteSet:elements	[Lcom/tencent/mobileqq/cuckoo/MethodCallback;
    //   42: arraylength
    //   43: invokestatic 27	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   46: aload 4
    //   48: aload_0
    //   49: getfield 14	com/tencent/mobileqq/cuckoo/MethodCopyOnWriteSet:elements	[Lcom/tencent/mobileqq/cuckoo/MethodCallback;
    //   52: arraylength
    //   53: aload_1
    //   54: aastore
    //   55: aload_0
    //   56: aload 4
    //   58: putfield 14	com/tencent/mobileqq/cuckoo/MethodCopyOnWriteSet:elements	[Lcom/tencent/mobileqq/cuckoo/MethodCallback;
    //   61: iconst_1
    //   62: istore_3
    //   63: goto -49 -> 14
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	MethodCopyOnWriteSet
    //   0	71	1	paramMethodCallback	MethodCallback
    //   9	2	2	i	int
    //   1	62	3	bool	boolean
    //   28	29	4	arrayOfMethodCallback	MethodCallback[]
    // Exception table:
    //   from	to	target	type
    //   4	10	66	finally
    //   18	61	66	finally
  }
  
  public void clear()
  {
    try
    {
      this.elements = new MethodCallback[0];
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public MethodCallback[] getSnapshot()
  {
    return this.elements;
  }
  
  public int indexOf(Object paramObject)
  {
    int i = 0;
    while (i < this.elements.length)
    {
      if (paramObject.equals(this.elements[i])) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  /* Error */
  public boolean remove(MethodCallback paramMethodCallback)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 21	com/tencent/mobileqq/cuckoo/MethodCopyOnWriteSet:indexOf	(Ljava/lang/Object;)I
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_m1
    //   12: if_icmpne +7 -> 19
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 14	com/tencent/mobileqq/cuckoo/MethodCopyOnWriteSet:elements	[Lcom/tencent/mobileqq/cuckoo/MethodCallback;
    //   23: arraylength
    //   24: iconst_1
    //   25: isub
    //   26: anewarray 12	com/tencent/mobileqq/cuckoo/MethodCallback
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 14	com/tencent/mobileqq/cuckoo/MethodCopyOnWriteSet:elements	[Lcom/tencent/mobileqq/cuckoo/MethodCallback;
    //   34: iconst_0
    //   35: aload_1
    //   36: iconst_0
    //   37: iload_2
    //   38: invokestatic 27	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   41: aload_0
    //   42: getfield 14	com/tencent/mobileqq/cuckoo/MethodCopyOnWriteSet:elements	[Lcom/tencent/mobileqq/cuckoo/MethodCallback;
    //   45: iload_2
    //   46: iconst_1
    //   47: iadd
    //   48: aload_1
    //   49: iload_2
    //   50: aload_0
    //   51: getfield 14	com/tencent/mobileqq/cuckoo/MethodCopyOnWriteSet:elements	[Lcom/tencent/mobileqq/cuckoo/MethodCallback;
    //   54: arraylength
    //   55: iload_2
    //   56: isub
    //   57: iconst_1
    //   58: isub
    //   59: invokestatic 27	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   62: aload_0
    //   63: aload_1
    //   64: putfield 14	com/tencent/mobileqq/cuckoo/MethodCopyOnWriteSet:elements	[Lcom/tencent/mobileqq/cuckoo/MethodCallback;
    //   67: iconst_1
    //   68: istore_3
    //   69: goto -54 -> 15
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	MethodCopyOnWriteSet
    //   0	77	1	paramMethodCallback	MethodCallback
    //   9	48	2	i	int
    //   1	68	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	10	72	finally
    //   19	67	72	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.cuckoo.MethodCopyOnWriteSet
 * JD-Core Version:    0.7.0.1
 */