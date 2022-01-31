package wf7;

import android.os.Handler;
import com.tencent.qqpimsecure.wificore.api.connect.d;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ao
{
  private final String TAG = "WifiServiceCenter";
  private final ReentrantReadWriteLock dp = new ReentrantReadWriteLock();
  private final HashMap<Integer, an> dq = new HashMap();
  
  private ao()
  {
    this.dp.writeLock().lock();
    this.dq.put(Integer.valueOf(1), db.bz());
    this.dq.put(Integer.valueOf(2), cw.bo());
    this.dq.put(Integer.valueOf(3), cq.aV());
    this.dq.put(Integer.valueOf(4), am.a(d.class));
    this.dp.writeLock().unlock();
    bz.av().ax().post(new ao.1(this));
  }
  
  public static ao c()
  {
    return ao.a.ds;
  }
  
  private void onCreate()
  {
    this.dp.readLock().lock();
    Iterator localIterator = this.dq.values().iterator();
    while (localIterator.hasNext()) {
      ((an)localIterator.next()).onCreate();
    }
    this.dp.readLock().unlock();
  }
  
  public void d()
  {
    this.dp.readLock().lock();
    Iterator localIterator = this.dq.values().iterator();
    while (localIterator.hasNext()) {
      ((an)localIterator.next()).a();
    }
    this.dp.readLock().unlock();
  }
  
  public void e()
  {
    this.dp.readLock().lock();
    Iterator localIterator = this.dq.values().iterator();
    while (localIterator.hasNext()) {
      ((an)localIterator.next()).b();
    }
    this.dp.readLock().unlock();
  }
  
  /* Error */
  public an i(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	wf7/ao:dp	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 116	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   7: invokevirtual 119	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   10: aload_0
    //   11: getfield 29	wf7/ao:dq	Ljava/util/HashMap;
    //   14: iload_1
    //   15: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: invokevirtual 158	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 141	wf7/an
    //   24: astore_2
    //   25: aload_0
    //   26: getfield 24	wf7/ao:dp	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   29: invokevirtual 116	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   32: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   35: aload_2
    //   36: ifnonnull +3 -> 39
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: aconst_null
    //   43: astore_2
    //   44: goto -9 -> 35
    //   47: astore_3
    //   48: goto -13 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	ao
    //   0	51	1	paramInt	int
    //   24	16	2	localan	an
    //   41	1	2	localException1	java.lang.Exception
    //   43	1	2	localObject	Object
    //   47	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	25	41	java/lang/Exception
    //   25	35	47	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.ao
 * JD-Core Version:    0.7.0.1
 */