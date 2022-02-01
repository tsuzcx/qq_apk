import common.qzone.component.cache.common.FastLruCache.1;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class avch<K, V>
{
  private ReferenceQueue<V> d = new ReferenceQueue();
  private final int mMaxSize;
  private final HashMap<K, V> qq;
  private final HashMap<K, avch.a<K, V>> qr = new HashMap();
  
  public avch(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.mMaxSize = paramInt;
    this.qq = new FastLruCache.1(this, 16, 0.75F, true, paramInt);
  }
  
  private void ezq()
  {
    for (avch.a locala = (avch.a)this.d.poll(); locala != null; locala = (avch.a)this.d.poll()) {
      this.qr.remove(locala.mKey);
    }
  }
  
  /* Error */
  public final V get(K paramK)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 67	avch:ezq	()V
    //   6: aload_0
    //   7: getfield 50	avch:qq	Ljava/util/HashMap;
    //   10: aload_1
    //   11: invokevirtual 69	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +9 -> 25
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aload_0
    //   26: getfield 28	avch:qr	Ljava/util/HashMap;
    //   29: aload_1
    //   30: invokevirtual 69	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 7	avch$a
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +8 -> 46
    //   41: aconst_null
    //   42: astore_1
    //   43: goto -22 -> 21
    //   46: aload_1
    //   47: invokevirtual 72	avch$a:get	()Ljava/lang/Object;
    //   50: astore_1
    //   51: goto -30 -> 21
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	avch
    //   0	59	1	paramK	K
    //   14	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	54	finally
    //   25	37	54	finally
    //   46	51	54	finally
  }
  
  /* Error */
  public final V put(K paramK, V paramV)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 67	avch:ezq	()V
    //   6: aload_0
    //   7: getfield 50	avch:qq	Ljava/util/HashMap;
    //   10: aload_1
    //   11: aload_2
    //   12: invokevirtual 78	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: aload_0
    //   17: getfield 28	avch:qr	Ljava/util/HashMap;
    //   20: aload_1
    //   21: new 7	avch$a
    //   24: dup
    //   25: aload_1
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 33	avch:d	Ljava/lang/ref/ReferenceQueue;
    //   31: invokespecial 81	avch$a:<init>	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V
    //   34: invokevirtual 78	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 7	avch$a
    //   40: astore_1
    //   41: aload_1
    //   42: ifnonnull +9 -> 51
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: aload_1
    //   52: invokevirtual 72	avch$a:get	()Ljava/lang/Object;
    //   55: astore_1
    //   56: goto -9 -> 47
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	avch
    //   0	64	1	paramK	K
    //   0	64	2	paramV	V
    // Exception table:
    //   from	to	target	type
    //   2	41	59	finally
    //   51	56	59	finally
  }
  
  static class a<K, V>
    extends WeakReference<V>
  {
    K mKey;
    
    public a(K paramK, V paramV, ReferenceQueue<V> paramReferenceQueue)
    {
      super(paramReferenceQueue);
      this.mKey = paramK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avch
 * JD-Core Version:    0.7.0.1
 */