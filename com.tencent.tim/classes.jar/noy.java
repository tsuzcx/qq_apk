import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptLinkedBlockingDeque;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager.1;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

public class noy
{
  private static noy a;
  public static final String tag = "zimage." + noy.class.getSimpleName();
  AtomicBoolean aA = new AtomicBoolean(false);
  public nor b;
  ConcurrentHashMap<noz, RunningJob> bx = new ConcurrentHashMap();
  ConcurrentHashMap<noz, RunningJob> by = new ConcurrentHashMap();
  private ConcurrentHashMap<noz, Boolean> bz = new ConcurrentHashMap();
  public ThreadPoolExecutor j;
  CopyOnWriteArrayList<noz> s = new CopyOnWriteArrayList();
  
  private noy()
  {
    int i;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      BaseApplicationImpl.sImageCache.evict(0);
      i = BaseApplicationImpl.sImageCacheSize * 2 / 3;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        npe.log(tag, "start memLimit:" + i);
      }
      this.b = new nor(i);
      ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
      localThreadPoolParams.poolThreadName = "image-manager";
      localThreadPoolParams.corePoolsize = 4;
      localThreadPoolParams.maxPooolSize = 8;
      localThreadPoolParams.priority = 3;
      if (lgj.Cd()) {
        localThreadPoolParams.queue = new RIJImageOptLinkedBlockingDeque(128);
      }
      this.j = ((ThreadPoolExecutor)ThreadManager.newFreeThreadPool(localThreadPoolParams));
      return;
      int k = (int)(MemoryManager.eS() / 10L);
      i = k;
      if (k <= 4194304) {
        i = 4194304;
      }
    }
  }
  
  public static noy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new noy();
      }
      return a;
    }
    finally {}
  }
  
  public nov a(noz paramnoz)
  {
    if (paramnoz == null) {
      return null;
    }
    return this.b.a(paramnoz);
  }
  
  /* Error */
  public void a(noz paramnoz, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	noy:bx	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 172	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 174	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +19 -> 34
    //   18: aload_2
    //   19: invokevirtual 177	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:cancel	()V
    //   22: aload_0
    //   23: getfield 151	noy:j	Ljava/util/concurrent/ThreadPoolExecutor;
    //   26: aload_2
    //   27: invokevirtual 180	java/util/concurrent/ThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 68	noy:by	Ljava/util/concurrent/ConcurrentHashMap;
    //   38: aload_1
    //   39: invokevirtual 172	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 174	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -16 -> 31
    //   50: aload_1
    //   51: invokevirtual 177	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:cancel	()V
    //   54: goto -23 -> 31
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	noy
    //   0	62	1	paramnoz	noz
    //   0	62	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	57	finally
    //   18	31	57	finally
    //   34	46	57	finally
    //   50	54	57	finally
  }
  
  public void a(noz paramnoz, nox paramnox)
  {
    if (paramnoz != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        if (paramnoz.url == null)
        {
          lgl.a(6, paramnoz);
          return;
        }
        localObject = this.b.a(paramnoz);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            npe.log(tag, "loadImage request:" + paramnoz + ", cache bitmap exist! callback:" + paramnox);
          }
          lgl.b(1, paramnoz);
          if (paramnox != null) {
            paramnox.a(paramnoz, ((nov)localObject).a());
          }
          ((nov)localObject).close();
          lgl.a(6, paramnoz);
          continue;
        }
        if (!paramnoz.isPreload) {
          break label140;
        }
      }
      finally {}
      if (this.bz.containsKey(paramnoz))
      {
        lgl.a(6, paramnoz);
      }
      else
      {
        label140:
        RunningJob localRunningJob = (RunningJob)this.bx.get(paramnoz);
        localObject = localRunningJob;
        if (localRunningJob == null)
        {
          localObject = localRunningJob;
          if (this.aA.get()) {
            localObject = (RunningJob)this.by.get(paramnoz);
          }
        }
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            npe.o(tag, "loadImage request:" + paramnoz + " already exist", true);
          }
          ((RunningJob)localObject).a(paramnox);
          paramnoz.failCode = 0;
          lgl.a(6, paramnoz);
        }
        else
        {
          localObject = new RunningJob(this, paramnoz);
          ((RunningJob)localObject).a(paramnox);
          if ((this.aA.get()) && (aoiz.getFile(paramnoz.url.toString()) == null))
          {
            this.by.put(paramnoz, localObject);
            if (QLog.isColorLevel()) {
              npe.o(tag, "loadImage request:" + paramnoz + " add to pending queue", true);
            }
          }
          else
          {
            this.bx.put(paramnoz, localObject);
            lgl.a(2, paramnoz);
            ThreadManager.post(new ImageManager.1(this, paramnoz, (RunningJob)localObject), 10, null, true);
          }
        }
      }
    }
  }
  
  public boolean a(URL paramURL)
  {
    return (paramURL != null) && (aoiz.getFile(paramURL.toString()) != null);
  }
  
  public void clean()
  {
    try
    {
      if (QLog.isColorLevel()) {
        npe.log(tag, "clean");
      }
      this.b.clean();
      Iterator localIterator = this.bx.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((RunningJob)((Map.Entry)localIterator.next()).getValue()).cancel();
      }
      this.bx.clear();
    }
    finally {}
  }
  
  public CopyOnWriteArrayList<noz> d()
  {
    return this.s;
  }
  
  public void g(noz paramnoz)
  {
    try
    {
      if (paramnoz.isPreload) {
        this.bz.put(paramnoz, Boolean.valueOf(true));
      }
      this.bx.remove(paramnoz);
      this.by.remove(paramnoz);
      return;
    }
    finally {}
  }
  
  public void h(noz paramnoz)
  {
    this.s.add(paramnoz);
  }
  
  public void i(noz paramnoz)
  {
    this.s.remove(paramnoz);
  }
  
  public void pauseDownload()
  {
    if (this.aA.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      npe.o(tag, "pause", true);
    }
    this.aA.set(true);
  }
  
  public void resume()
  {
    if (!this.aA.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      npe.o(tag, "resume", true);
    }
    this.aA.set(false);
    try
    {
      Iterator localIterator = this.by.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.bx.put(localEntry.getKey(), localEntry.getValue());
        this.j.execute((Runnable)localEntry.getValue());
      }
      this.by.clear();
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     noy
 * JD-Core Version:    0.7.0.1
 */