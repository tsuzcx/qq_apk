package gameloginsdk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class o
{
  HashMap a = new HashMap(1000);
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.a.values().iterator();
      while (localIterator.hasNext()) {
        if (((l)localIterator.next()).a()) {
          localIterator.remove();
        }
      }
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    try
    {
      a();
      this.a.put(Long.valueOf(paramLong1), new l(paramLong1, paramLong2));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 48	gameloginsdk/o:a	()V
    //   6: aload_0
    //   7: getfield 17	gameloginsdk/o:a	Ljava/util/HashMap;
    //   10: lload_1
    //   11: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   14: invokevirtual 64	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnonnull +9 -> 30
    //   24: iconst_0
    //   25: istore_3
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: iconst_1
    //   31: istore_3
    //   32: goto -6 -> 26
    //   35: astore 4
    //   37: aload_0
    //   38: monitorexit
    //   39: aload 4
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	o
    //   0	42	1	paramLong	long
    //   25	7	3	bool	boolean
    //   17	3	4	localObject1	Object
    //   35	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	35	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.o
 * JD-Core Version:    0.7.0.1
 */