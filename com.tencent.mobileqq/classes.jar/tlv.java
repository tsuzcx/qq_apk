import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptLinkedBlockingDeque;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager.1;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

public class tlv
{
  public static final String a;
  private static tlv jdField_a_of_type_Tlv;
  ConcurrentHashMap<tlw, RunningJob> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  CopyOnWriteArrayList<tlw> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public ThreadPoolExecutor a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public tlo a;
  ConcurrentHashMap<tlw, RunningJob> b = new ConcurrentHashMap();
  private ConcurrentHashMap<tlw, Boolean> c = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + tlv.class.getSimpleName();
  }
  
  private tlv()
  {
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      try
      {
        BaseApplicationImpl.sImageCache.evict(0);
        i = BaseApplicationImpl.sImageCacheSize * 2 / 3;
        if (QLog.isColorLevel()) {
          tmd.a(jdField_a_of_type_JavaLangString, "start memLimit:" + i);
        }
        this.jdField_a_of_type_Tlo = new tlo(i);
        ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
        localThreadPoolParams.poolThreadName = "image-manager";
        localThreadPoolParams.corePoolsize = 4;
        localThreadPoolParams.maxPooolSize = 8;
        localThreadPoolParams.priority = 3;
        if (qdk.a.b()) {
          localThreadPoolParams.queue = new RIJImageOptLinkedBlockingDeque(128);
        }
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = ((ThreadPoolExecutor)ThreadManager.newFreeThreadPool(localThreadPoolParams));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[ImageManager] e = " + localException);
        continue;
      }
      int j = (int)(MemoryManager.getAvailClassSize() / 10L);
      int i = j;
      if (j <= 4194304) {
        i = 4194304;
      }
    }
  }
  
  public static tlv a()
  {
    if (jdField_a_of_type_Tlv == null) {}
    try
    {
      if (jdField_a_of_type_Tlv == null) {
        jdField_a_of_type_Tlv = new tlv();
      }
      return jdField_a_of_type_Tlv;
    }
    finally {}
  }
  
  public CopyOnWriteArrayList<tlw> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public tls a(tlw paramtlw)
  {
    if (paramtlw == null) {
      return null;
    }
    return this.jdField_a_of_type_Tlo.a(paramtlw);
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        tmd.a(jdField_a_of_type_JavaLangString, "clean");
      }
      this.jdField_a_of_type_Tlo.a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((RunningJob)((Map.Entry)localIterator.next()).getValue()).a();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    finally {}
  }
  
  public void a(tlw paramtlw)
  {
    try
    {
      if (paramtlw.b) {
        this.c.put(paramtlw, Boolean.valueOf(true));
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramtlw);
      this.b.remove(paramtlw);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(tlw paramtlw, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	tlv:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 230	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 206	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +19 -> 34
    //   18: aload_2
    //   19: invokevirtual 207	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   22: aload_0
    //   23: getfield 148	tlv:jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   26: aload_2
    //   27: invokevirtual 234	java/util/concurrent/ThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 64	tlv:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   38: aload_1
    //   39: invokevirtual 230	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 206	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -16 -> 31
    //   50: aload_1
    //   51: invokevirtual 207	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()V
    //   54: goto -23 -> 31
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	tlv
    //   0	62	1	paramtlw	tlw
    //   0	62	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	57	finally
    //   18	31	57	finally
    //   34	46	57	finally
    //   50	54	57	finally
  }
  
  public void a(tlw paramtlw, tlu paramtlu)
  {
    if (paramtlw != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        if (paramtlw.a == null)
        {
          qdm.a(6, paramtlw);
          return;
        }
        localObject = this.jdField_a_of_type_Tlo.a(paramtlw);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            tmd.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramtlw + ", cache bitmap exist! callback:" + paramtlu);
          }
          qdm.b(1, paramtlw);
          if (paramtlu != null) {
            paramtlu.a(paramtlw, ((tls)localObject).a());
          }
          ((tls)localObject).a();
          qdm.a(6, paramtlw);
          continue;
        }
        if (!paramtlw.b) {
          break label140;
        }
      }
      finally {}
      if (this.c.containsKey(paramtlw))
      {
        qdm.a(6, paramtlw);
      }
      else
      {
        label140:
        RunningJob localRunningJob = (RunningJob)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramtlw);
        localObject = localRunningJob;
        if (localRunningJob == null)
        {
          localObject = localRunningJob;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            localObject = (RunningJob)this.b.get(paramtlw);
          }
        }
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            tmd.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramtlw + " already exist", true);
          }
          ((RunningJob)localObject).a(paramtlu);
          paramtlw.e = 0;
          qdm.a(6, paramtlw);
        }
        else
        {
          localObject = new RunningJob(this, paramtlw);
          ((RunningJob)localObject).a(paramtlu);
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (AbsDownloader.getFile(paramtlw.a.toString()) == null))
          {
            this.b.put(paramtlw, localObject);
            if (QLog.isColorLevel()) {
              tmd.a(jdField_a_of_type_JavaLangString, "loadImage request:" + paramtlw + " add to pending queue", true);
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramtlw, localObject);
            qdm.a(2, paramtlw);
            ThreadManager.post(new ImageManager.1(this, paramtlw, (RunningJob)localObject), 10, null, true);
          }
        }
      }
    }
  }
  
  public boolean a(URL paramURL)
  {
    return (paramURL != null) && (AbsDownloader.getFile(paramURL.toString()) != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      tmd.a(jdField_a_of_type_JavaLangString, "pause", true);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void b(tlw paramtlw)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramtlw);
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      tmd.a(jdField_a_of_type_JavaLangString, "resume", true);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    try
    {
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localEntry.getKey(), localEntry.getValue());
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute((Runnable)localEntry.getValue());
      }
      this.b.clear();
    }
    finally {}
  }
  
  public void c(tlw paramtlw)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramtlw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tlv
 * JD-Core Version:    0.7.0.1
 */