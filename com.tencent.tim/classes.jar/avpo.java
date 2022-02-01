public class avpo<T>
{
  private int DEFAULT_SIZE = 10;
  private int capacity;
  private Object[] elementData;
  private int exN;
  private int exO;
  
  public avpo()
  {
    this.capacity = this.DEFAULT_SIZE;
    this.elementData = new Object[this.capacity];
  }
  
  public avpo(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("size不能小于1,size=" + paramInt);
    }
    this.capacity = paramInt;
    this.elementData = new Object[this.capacity];
  }
  
  public void add(T paramT)
  {
    try
    {
      if ((this.exO == this.exN) && (this.elementData[this.exN] != null)) {
        throw new IndexOutOfBoundsException(acfp.m(2131707973));
      }
    }
    finally {}
    if (paramT == null) {
      throw new IllegalArgumentException("element不能为null,element=null");
    }
    Object[] arrayOfObject = this.elementData;
    int i = this.exO;
    this.exO = (i + 1);
    arrayOfObject[i] = paramT;
    if (this.exO == this.capacity) {}
    for (i = 0;; i = this.exO)
    {
      this.exO = i;
      return;
    }
  }
  
  /* Error */
  public boolean isEmpty()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	avpo:exO	I
    //   6: aload_0
    //   7: getfield 51	avpo:exN	I
    //   10: if_icmpne +23 -> 33
    //   13: aload_0
    //   14: getfield 22	avpo:elementData	[Ljava/lang/Object;
    //   17: aload_0
    //   18: getfield 49	avpo:exO	I
    //   21: aaload
    //   22: astore_2
    //   23: aload_2
    //   24: ifnonnull +9 -> 33
    //   27: iconst_1
    //   28: istore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_1
    //   35: goto -6 -> 29
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	avpo
    //   28	7	1	bool	boolean
    //   22	2	2	localObject1	Object
    //   38	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	38	finally
  }
  
  /* Error */
  public boolean isFull()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 72	avpo:size	()I
    //   6: istore_1
    //   7: aload_0
    //   8: getfield 20	avpo:capacity	I
    //   11: istore_2
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmpne +9 -> 23
    //   17: iconst_1
    //   18: istore_3
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_3
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_3
    //   25: goto -6 -> 19
    //   28: astore 4
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	avpo
    //   6	9	1	i	int
    //   11	4	2	j	int
    //   18	7	3	bool	boolean
    //   28	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	28	finally
  }
  
  public T remove()
  {
    try
    {
      if (isEmpty()) {
        throw new IndexOutOfBoundsException(acfp.m(2131707974));
      }
    }
    finally {}
    Object localObject2 = this.elementData[this.exN];
    Object[] arrayOfObject = this.elementData;
    int i = this.exN;
    this.exN = (i + 1);
    arrayOfObject[i] = null;
    if (this.exN == this.capacity) {}
    for (i = 0;; i = this.exN)
    {
      this.exN = i;
      return localObject2;
    }
  }
  
  /* Error */
  public int size()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 76	avpo:isEmpty	()Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +9 -> 19
    //   13: iconst_0
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 49	avpo:exO	I
    //   23: aload_0
    //   24: getfield 51	avpo:exN	I
    //   27: if_icmple +16 -> 43
    //   30: aload_0
    //   31: getfield 49	avpo:exO	I
    //   34: aload_0
    //   35: getfield 51	avpo:exN	I
    //   38: isub
    //   39: istore_1
    //   40: goto -25 -> 15
    //   43: aload_0
    //   44: getfield 20	avpo:capacity	I
    //   47: istore_1
    //   48: aload_0
    //   49: getfield 51	avpo:exN	I
    //   52: istore_2
    //   53: aload_0
    //   54: getfield 49	avpo:exO	I
    //   57: istore_3
    //   58: iload_1
    //   59: iload_2
    //   60: iload_3
    //   61: isub
    //   62: isub
    //   63: istore_1
    //   64: goto -49 -> 15
    //   67: astore 5
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 5
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	avpo
    //   14	50	1	i	int
    //   52	10	2	j	int
    //   57	5	3	k	int
    //   6	3	4	bool	boolean
    //   67	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	67	finally
    //   19	40	67	finally
    //   43	58	67	finally
  }
  
  public String toString()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if (isEmpty())
        {
          localObject1 = "[]";
          return localObject1;
        }
        int i;
        if (this.exN < this.exO)
        {
          localObject1 = new StringBuilder("[");
          i = this.exN;
          if (i < this.exO)
          {
            ((StringBuilder)localObject1).append(this.elementData[i].toString() + "->");
            i += 1;
          }
          else
          {
            i = ((StringBuilder)localObject1).length();
            localObject1 = "]";
          }
        }
        else
        {
          localObject1 = new StringBuilder("[");
          i = this.exN;
          if (i < this.capacity)
          {
            ((StringBuilder)localObject1).append(this.elementData[i].toString() + "->");
            i += 1;
            continue;
            if (i < this.exO)
            {
              ((StringBuilder)localObject1).append(this.elementData[i].toString() + "->");
              i += 1;
            }
            else
            {
              i = ((StringBuilder)localObject1).length();
              localObject1 = "]";
            }
          }
          else
          {
            i = 0;
          }
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avpo
 * JD-Core Version:    0.7.0.1
 */