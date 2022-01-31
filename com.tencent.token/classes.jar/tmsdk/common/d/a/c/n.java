package tmsdk.common.d.a.c;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

public class n
{
  private TreeMap a = null;
  
  public n(Comparator paramComparator)
  {
    this.a = new TreeMap(paramComparator);
  }
  
  private LinkedList d()
  {
    return new LinkedList();
  }
  
  public void a(Object paramObject)
  {
    try
    {
      LinkedList localLinkedList2 = (LinkedList)this.a.get(paramObject);
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = d();
        this.a.put(paramObject, localLinkedList1);
      }
      localLinkedList1.addLast(paramObject);
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.a.isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public Object c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 49	tmsdk/common/d/a/c/n:a	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_2
    //   16: areturn
    //   17: aload_0
    //   18: getfield 13	tmsdk/common/d/a/c/n:a	Ljava/util/TreeMap;
    //   21: invokevirtual 52	java/util/TreeMap:firstKey	()Ljava/lang/Object;
    //   24: astore_3
    //   25: aload_0
    //   26: getfield 13	tmsdk/common/d/a/c/n:a	Ljava/util/TreeMap;
    //   29: aload_3
    //   30: invokevirtual 28	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 22	java/util/LinkedList
    //   36: astore 4
    //   38: aload 4
    //   40: invokevirtual 55	java/util/LinkedList:poll	()Ljava/lang/Object;
    //   43: astore_2
    //   44: aload 4
    //   46: invokevirtual 59	java/util/LinkedList:size	()I
    //   49: ifgt +12 -> 61
    //   52: aload_0
    //   53: getfield 13	tmsdk/common/d/a/c/n:a	Ljava/util/TreeMap;
    //   56: aload_3
    //   57: invokevirtual 62	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: pop
    //   61: goto -48 -> 13
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	n
    //   6	2	1	bool	boolean
    //   12	32	2	localObject1	Object
    //   64	4	2	localObject2	Object
    //   24	33	3	localObject3	Object
    //   36	9	4	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   2	7	64	finally
    //   17	61	64	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.n
 * JD-Core Version:    0.7.0.1
 */