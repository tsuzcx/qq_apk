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
  
  public an i(int paramInt)
  {
    for (;;)
    {
      try
      {
        this.dp.readLock().lock();
        localan = (an)this.dq.get(Integer.valueOf(paramInt));
      }
      catch (Exception localException1)
      {
        an localan;
        continue;
        return localException1;
      }
      try
      {
        this.dp.readLock().unlock();
        return localan;
      }
      catch (Exception localException2) {}
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.ao
 * JD-Core Version:    0.7.0.1
 */