package wf7;

import java.util.LinkedHashSet;

public class fl<T>
{
  private int pZ = -1;
  private LinkedHashSet<T> qb = new LinkedHashSet();
  
  public fl(int paramInt)
  {
    this.pZ = paramInt;
  }
  
  public boolean b(T paramT)
  {
    try
    {
      boolean bool = this.qb.contains(paramT);
      return bool;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  /* Error */
  public T poll()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	wf7/fl:qb	Ljava/util/LinkedHashSet;
    //   6: ifnull +44 -> 50
    //   9: aload_0
    //   10: getfield 22	wf7/fl:qb	Ljava/util/LinkedHashSet;
    //   13: invokevirtual 36	java/util/LinkedHashSet:iterator	()Ljava/util/Iterator;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +32 -> 50
    //   21: aload_1
    //   22: invokeinterface 42 1 0
    //   27: ifeq +23 -> 50
    //   30: aload_1
    //   31: invokeinterface 45 1 0
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 22	wf7/fl:qb	Ljava/util/LinkedHashSet;
    //   41: aload_1
    //   42: invokevirtual 48	java/util/LinkedHashSet:remove	(Ljava/lang/Object;)Z
    //   45: pop
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: areturn
    //   50: aconst_null
    //   51: astore_1
    //   52: goto -6 -> 46
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	fl
    //   16	36	1	localObject1	Object
    //   55	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	55	finally
    //   21	46	55	finally
  }
  
  public void push(T paramT)
  {
    try
    {
      if (this.qb.size() >= this.pZ) {
        poll();
      }
      this.qb.add(paramT);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fl
 * JD-Core Version:    0.7.0.1
 */