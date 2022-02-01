import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class amxd
{
  public static amxd a = new amxd();
  public long akm;
  public Map<Long, WeakReference<Object>> dataMap = new ConcurrentHashMap();
  
  public static amxd a()
  {
    return a;
  }
  
  public long b(Object paramObject)
  {
    long l;
    if (paramObject == null) {
      l = -9223372036854775808L;
    }
    for (;;)
    {
      return l;
      try
      {
        l = this.akm;
        this.akm = (1L + l);
        this.dataMap.put(Long.valueOf(l), new WeakReference(paramObject));
      }
      finally {}
    }
  }
  
  /* Error */
  public Object getObject(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	amxd:dataMap	Ljava/util/Map;
    //   6: lload_1
    //   7: invokestatic 38	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokeinterface 55 2 0
    //   15: checkcast 40	java/lang/ref/WeakReference
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +12 -> 32
    //   23: aload_3
    //   24: invokevirtual 58	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: areturn
    //   32: aconst_null
    //   33: astore_3
    //   34: goto -6 -> 28
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	amxd
    //   0	42	1	paramLong	long
    //   18	16	3	localObject1	Object
    //   37	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	37	finally
    //   23	28	37	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amxd
 * JD-Core Version:    0.7.0.1
 */