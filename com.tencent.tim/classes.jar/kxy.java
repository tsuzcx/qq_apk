import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class kxy
{
  private static final Map<String, kxy> ec = new HashMap();
  private boolean aiI;
  private List<Long> gU = new ArrayList();
  private long tf = -1L;
  private long tg = -1L;
  
  public static long E(String paramString)
  {
    return a(paramString, false).cp();
  }
  
  public static long F(String paramString)
  {
    return a(paramString, false).cq();
  }
  
  public static long a(String paramString, boolean paramBoolean)
  {
    return a(paramString, false).b(paramBoolean);
  }
  
  public static kxy a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (kxy)ec.get(paramString);
  }
  
  private static kxy a(String paramString, boolean paramBoolean)
  {
    kxy localkxy2 = a(paramString);
    kxy localkxy1 = localkxy2;
    if (localkxy2 == null)
    {
      localkxy2 = new kxy();
      localkxy1 = localkxy2;
      if (paramBoolean)
      {
        a(paramString, localkxy2);
        localkxy1 = localkxy2;
      }
    }
    return localkxy1;
  }
  
  public static void a(String paramString, kxy paramkxy)
  {
    if ((paramString == null) || (paramkxy == null)) {
      return;
    }
    ec.put(paramString, paramkxy);
  }
  
  public static void mI(String paramString)
  {
    ec.remove(paramString);
  }
  
  public static void mJ(String paramString)
  {
    a(paramString, true).wakeUp();
  }
  
  public static void mK(String paramString)
  {
    a(paramString, false).aIc();
  }
  
  public boolean Bf()
  {
    return this.aiI;
  }
  
  /* Error */
  public void aIc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 90	kxy:aiI	Z
    //   6: ifeq +37 -> 43
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 90	kxy:aiI	Z
    //   14: invokestatic 95	android/os/SystemClock:elapsedRealtime	()J
    //   17: aload_0
    //   18: getfield 37	kxy:tg	J
    //   21: lsub
    //   22: lstore_1
    //   23: lload_1
    //   24: lconst_0
    //   25: lcmp
    //   26: iflt +20 -> 46
    //   29: aload_0
    //   30: getfield 35	kxy:gU	Ljava/util/List;
    //   33: lload_1
    //   34: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   37: invokeinterface 107 2 0
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: ldc 109
    //   48: ldc 109
    //   50: new 111	java/lang/IllegalArgumentException
    //   53: dup
    //   54: invokespecial 112	java/lang/IllegalArgumentException:<init>	()V
    //   57: invokestatic 117	wja:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/RuntimeException;)V
    //   60: goto -17 -> 43
    //   63: astore_3
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_3
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	kxy
    //   22	12	1	l	long
    //   63	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	63	finally
    //   29	43	63	finally
    //   46	60	63	finally
  }
  
  public long b(boolean paramBoolean)
  {
    if (paramBoolean) {
      aIc();
    }
    Object localObject = this.gU.iterator();
    for (long l1 = 0L; ((Iterator)localObject).hasNext(); l1 = ((Long)((Iterator)localObject).next()).longValue() + l1) {}
    long l2 = l1;
    if (this.aiI)
    {
      l2 = l1;
      if (!paramBoolean) {
        l2 = l1 + (SystemClock.elapsedRealtime() - this.tg);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startMillis : " + this.tf + "  during : " + l2 + "  :  ");
      Iterator localIterator = this.gU.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        ((StringBuilder)localObject).append(localLong + "  : ");
      }
      QLog.d("TimeSliceHelper", 1, ((StringBuilder)localObject).toString());
    }
    return l2;
  }
  
  public long cp()
  {
    return this.tf;
  }
  
  public long cq()
  {
    return b(true);
  }
  
  public void reset()
  {
    this.tf = -1L;
    this.gU.clear();
    this.aiI = false;
    this.tg = -1L;
  }
  
  public void wakeUp()
  {
    if (this.tf < 0L) {
      this.tf = NetConnInfoCenter.getServerTimeMillis();
    }
    if (!this.aiI)
    {
      this.aiI = true;
      this.tg = SystemClock.elapsedRealtime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kxy
 * JD-Core Version:    0.7.0.1
 */